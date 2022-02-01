package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EncoderWriter
{
  public static final int OUTPUT_AUDIO_AAC_PROFILE = 2;
  public static final int OUTPUT_AUDIO_BIT_RATE = 128000;
  public static final int OUTPUT_AUDIO_CHANNEL_COUNT = 1;
  public static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
  public static final int OUTPUT_AUDIO_SAMPLE_RATE_HZ = 44100;
  public static final int OUTPUT_VIDEO_BIT_RATE = 8000000;
  public static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
  public static final int OUTPUT_VIDEO_FRAME_RATE = 30;
  public static final int OUTPUT_VIDEO_IFRAME_INTERVAL = 1;
  public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
  private static final String TAG = "EncoderWriter";
  private static final long WAIT_TRANSIENT_MS = 20L;
  public static final long WRITER_FINISH = -1L;
  private Surface _inputSurface = null;
  private volatile MediaCodec.BufferInfo audioBufferInfo = new MediaCodec.BufferInfo();
  private volatile MediaFormat audioEncodeFormat = null;
  private MediaCodec audioEncoder;
  private Lock audioEncoderLock = new ReentrantLock();
  private boolean audioEncoderStarted = false;
  private long audioPresentationTimeUs;
  private boolean enOfAudioInputStream = false;
  private boolean enOfVideoInputStream = false;
  private ExportConfig encodeOption;
  private boolean hasAudioTrack = false;
  private boolean hasVideoTrack = false;
  private ReadWriteLock lock = new ReentrantReadWriteLock();
  private MediaMuxer muxer;
  private volatile boolean muxerStarted = false;
  private int outHeight;
  private int outWidth;
  private volatile int outputAudioTrack = -1;
  private volatile int outputVideoTrack = -1;
  private boolean released = false;
  private volatile MediaCodec.BufferInfo videoBufferInfo = new MediaCodec.BufferInfo();
  private volatile MediaFormat videoEncodeFormat = null;
  private MediaCodec videoEncoder;
  private Lock videoEncoderLock = new ReentrantLock();
  private boolean videoEncoderStarted = false;
  private long videoPresentationTimeUs;
  
  @RequiresApi(api=18)
  public EncoderWriter(String paramString)
  {
    this.muxer = new MediaMuxer(paramString, 0);
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      return i;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "dequeueInputBuffer e = ", localException);
      if ((21 <= Build.VERSION.SDK_INT) && ((localException instanceof MediaCodec.CodecException)))
      {
        loggerCodecException((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          return dequeueInputBuffer(paramMediaCodec);
        }
      }
      throw localException;
    }
    catch (Error localError)
    {
      label11:
      break label11;
    }
  }
  
  private int dequeueOutputBuffer(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      return i;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "dequeueOutputBuffer e = ", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        loggerCodecException((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          return dequeueOutputBuffer(paramMediaCodec, paramBufferInfo);
        }
      }
      throw localException;
    }
  }
  
  @RequiresApi(api=18)
  private void drainEncoder(boolean paramBoolean)
  {
    int j = 0;
    int i;
    if (paramBoolean)
    {
      i = j;
      if (this.hasVideoTrack)
      {
        if (this._inputSurface != null) {
          break label314;
        }
        i = 1;
      }
    }
    for (boolean bool1 = this.hasAudioTrack;; bool1 = false)
    {
      boolean bool2;
      label40:
      boolean bool3;
      label50:
      long l;
      boolean bool4;
      if (!this.hasVideoTrack)
      {
        bool2 = true;
        if (this.hasAudioTrack) {
          break label329;
        }
        bool3 = true;
        l = System.currentTimeMillis();
        bool4 = bool3;
        boolean bool5 = bool2;
        bool3 = bool1;
        bool2 = bool4;
        bool1 = bool5;
        label75:
        if (((bool1) || (!this.hasVideoTrack)) && ((bool2) || (!this.hasAudioTrack))) {
          break label354;
        }
        if (i == 0) {
          break label368;
        }
        signalEndOfVideoStream();
        i = 0;
      }
      label144:
      label233:
      label368:
      for (;;)
      {
        if (!bool1)
        {
          bool1 = writeVideoFrame(paramBoolean);
          if (System.currentTimeMillis() - l > 2000L)
          {
            bool4 = true;
            if (!paramBoolean)
            {
              bool1 = true;
              this.hasVideoTrack = bool1;
              Logger.e("EncoderWriter", "drainEncoder: 视频写入处理时间超时，提前结束写入");
              bool1 = bool4;
            }
          }
        }
        for (;;)
        {
          bool4 = bool3;
          if (bool3)
          {
            signalEndOfAudioStream();
            bool4 = false;
          }
          bool3 = bool2;
          if (!bool2)
          {
            bool2 = writeAudioFrame(paramBoolean);
            if (System.currentTimeMillis() - l <= 2000L) {
              break label233;
            }
            bool3 = true;
            if (paramBoolean) {
              break label341;
            }
          }
          for (bool2 = true;; bool2 = false)
          {
            for (;;)
            {
              this.hasAudioTrack = bool2;
              Logger.e("EncoderWriter", "drainEncoder: 音频写入处理时间超时，提前结束写入");
              bool2 = bool3;
              if (!unStarted()) {
                break label355;
              }
              try
              {
                if (unStarted())
                {
                  if (this.hasVideoTrack) {
                    this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
                  }
                  if (this.hasAudioTrack) {
                    this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
                  }
                  this.muxer.start();
                  this.muxerStarted = true;
                }
                bool3 = bool4;
                break;
              }
              finally {}
            }
            signalEndOfVideoStream();
            i = j;
            break;
            bool2 = false;
            break label40;
            bool3 = false;
            break label50;
            bool1 = false;
            break label144;
          }
          return;
          bool3 = bool4;
          break label75;
        }
      }
      label314:
      label329:
      label341:
      label354:
      label355:
      i = 0;
    }
  }
  
  private void fixAudioFormat(MediaFormat paramMediaFormat)
  {
    fixStringKey(paramMediaFormat, "mime", "audio/mp4a-latm");
    fixIntegerKey(paramMediaFormat, "sample-rate", 44100);
    fixIntegerKey(paramMediaFormat, "channel-count", 1);
    fixIntegerKey(paramMediaFormat, "bitrate", 128000);
    fixIntegerKey(paramMediaFormat, "aac-profile", 2);
    Logger.d("EncoderWriter", "fixAudioFormat() called with: format = [" + paramMediaFormat + "]");
  }
  
  private void fixIntegerKey(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if ((!paramMediaFormat.containsKey(paramString)) || (paramMediaFormat.getInteger(paramString) <= 0))
    {
      Logger.w("EncoderWriter", "fixIntegerKey: 缺少关键配置：" + paramString + ", 使用默认值：" + paramInt);
      paramMediaFormat.setInteger(paramString, paramInt);
    }
  }
  
  private void fixStringKey(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    if ((!paramMediaFormat.containsKey(paramString1)) || (TextUtils.isEmpty(paramMediaFormat.getString(paramString1))))
    {
      Logger.w("EncoderWriter", "fixStringKey: 缺少关键配置：" + paramString1 + ", 使用默认值：" + paramString2);
      paramMediaFormat.setString(paramString1, paramString2);
    }
  }
  
  private void fixVideoFormat(MediaFormat paramMediaFormat)
  {
    paramMediaFormat.setInteger("color-format", 2130708361);
    fixStringKey(paramMediaFormat, "mime", "video/avc");
    fixIntegerKey(paramMediaFormat, "bitrate", 8000000);
    fixIntegerKey(paramMediaFormat, "frame-rate", 30);
    fixIntegerKey(paramMediaFormat, "i-frame-interval", 1);
    Logger.d("EncoderWriter", "fixVideoFormat() called with: format = [" + paramMediaFormat + "]");
  }
  
  private ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodec, paramInt);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "getInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        loggerCodecException((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          return getInputBuffer(paramMediaCodec, paramInt);
        }
      }
      throw localException;
    }
    catch (Error localError)
    {
      label9:
      break label9;
    }
  }
  
  private ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "getOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        loggerCodecException((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          return getOutputBuffer(paramMediaCodec, paramInt);
        }
      }
      throw localException;
    }
    catch (Error localError)
    {
      label9:
      break label9;
    }
  }
  
  private void loggerCodecException(MediaCodec.CodecException paramCodecException)
  {
    if (23 <= Build.VERSION.SDK_INT) {
      Logger.e("EncoderWriter", "CodecException - isTransient = " + paramCodecException.isTransient() + " , isRecoverable = " + paramCodecException.isRecoverable() + " , errorCode = " + paramCodecException.getErrorCode());
    }
  }
  
  private void prepareAudioEncoder(ExportConfig paramExportConfig)
  {
    Logger.d("EncoderWriter", "AssetWriter prepareAudioEncoder " + this);
    paramExportConfig = paramExportConfig.getAudioFormat();
    fixAudioFormat(paramExportConfig);
    paramExportConfig.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0 }));
    try
    {
      Logger.i("EncoderWriter", "prepareAudioEncoder: format = " + paramExportConfig);
      this.audioEncoder = MediaCodecManager.createEncoderByType("audio/mp4a-latm");
      this.audioEncoder.configure(paramExportConfig, null, null, 1);
      return;
    }
    catch (Exception localException)
    {
      MediaCodecManager.releaseCodec(this.audioEncoder);
      throw new ExportRuntimeException(new ExportErrorStatus(-104, localException, paramExportConfig.toString()));
    }
  }
  
  private void prepareVideoEncoder(ExportConfig paramExportConfig)
  {
    CGSize localCGSize = CodecHelper.correctSupportSize(paramExportConfig.getOutputSize(), "video/avc");
    this.outHeight = ((int)localCGSize.height);
    this.outWidth = ((int)localCGSize.width);
    paramExportConfig = paramExportConfig.getVideoFormat();
    fixVideoFormat(paramExportConfig);
    try
    {
      Logger.i("EncoderWriter", "prepareVideoEncoder: format = " + paramExportConfig);
      this.videoEncoder = MediaCodecManager.createEncoderByType("video/avc");
      this.videoEncoder.configure(paramExportConfig, null, null, 1);
      return;
    }
    catch (Exception localException1)
    {
      Logger.e("EncoderWriter", "prepareVideoEncoder: 失败，准备重试。format = " + paramExportConfig, localException1);
      paramExportConfig.setInteger("profile", 0);
      paramExportConfig.setInteger("level", 0);
      try
      {
        this.videoEncoder = MediaCodecManager.createEncoderByType("video/avc");
        this.videoEncoder.configure(paramExportConfig, null, null, 1);
        return;
      }
      catch (Exception localException2)
      {
        Logger.e("EncoderWriter", "prepareVideoEncoder: retry 失败 format = " + paramExportConfig, localException2);
        MediaCodecManager.releaseCodec(this.videoEncoder);
        throw new ExportRuntimeException(new ExportErrorStatus(-103, localException2, paramExportConfig.toString()));
      }
    }
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        loggerCodecException((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          queueInputBuffer(paramMediaCodec, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        }
      }
      throw localException;
    }
    catch (Error localError)
    {
      label15:
      break label15;
    }
  }
  
  /* Error */
  @RequiresApi(api=18)
  private void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 125	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   5: ldc 30
    //   7: new 247	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 451
    //   17: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   34: invokeinterface 457 1 0
    //   39: invokeinterface 461 1 0
    //   44: ldc 30
    //   46: new 247	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 463
    //   56: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +22 -> 97
    //   78: aload_0
    //   79: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   82: invokevirtual 466	android/media/MediaCodec:stop	()V
    //   85: aload_0
    //   86: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   89: invokestatic 388	com/tencent/tav/decoder/MediaCodecManager:releaseCodec	(Landroid/media/MediaCodec;)V
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   97: aload_0
    //   98: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +22 -> 125
    //   106: aload_0
    //   107: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   110: invokevirtual 466	android/media/MediaCodec:stop	()V
    //   113: aload_0
    //   114: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   117: invokestatic 388	com/tencent/tav/decoder/MediaCodecManager:releaseCodec	(Landroid/media/MediaCodec;)V
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   125: aload_0
    //   126: getfield 132	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   129: ifnull +34 -> 163
    //   132: aload_0
    //   133: getfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   136: ifeq +15 -> 151
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   144: aload_0
    //   145: getfield 132	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   148: invokevirtual 467	android/media/MediaMuxer:stop	()V
    //   151: aload_0
    //   152: getfield 132	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   155: invokevirtual 469	android/media/MediaMuxer:release	()V
    //   158: aload_0
    //   159: aconst_null
    //   160: putfield 132	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   163: aload_0
    //   164: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   167: invokeinterface 457 1 0
    //   172: invokeinterface 472 1 0
    //   177: return
    //   178: astore_1
    //   179: ldc 30
    //   181: ldc_w 474
    //   184: aload_1
    //   185: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -103 -> 85
    //   191: astore_1
    //   192: aload_0
    //   193: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   196: invokeinterface 457 1 0
    //   201: invokeinterface 472 1 0
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: ldc 30
    //   211: ldc_w 476
    //   214: aload_1
    //   215: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: goto -126 -> 92
    //   221: astore_1
    //   222: ldc 30
    //   224: ldc_w 478
    //   227: aload_1
    //   228: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: goto -118 -> 113
    //   234: astore_1
    //   235: ldc 30
    //   237: ldc_w 480
    //   240: aload_1
    //   241: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   244: goto -124 -> 120
    //   247: astore_1
    //   248: ldc 30
    //   250: ldc_w 482
    //   253: aload_1
    //   254: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -106 -> 151
    //   260: astore_1
    //   261: ldc 30
    //   263: ldc_w 484
    //   266: aload_1
    //   267: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -112 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	EncoderWriter
    //   73	30	1	localMediaCodec	MediaCodec
    //   178	7	1	localException1	Exception
    //   191	16	1	localObject	Object
    //   208	7	1	localException2	Exception
    //   221	7	1	localException3	Exception
    //   234	7	1	localException4	Exception
    //   247	7	1	localException5	Exception
    //   260	7	1	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   78	85	178	java/lang/Exception
    //   30	74	191	finally
    //   78	85	191	finally
    //   85	92	191	finally
    //   92	97	191	finally
    //   97	102	191	finally
    //   106	113	191	finally
    //   113	120	191	finally
    //   120	125	191	finally
    //   125	144	191	finally
    //   144	151	191	finally
    //   151	158	191	finally
    //   158	163	191	finally
    //   179	188	191	finally
    //   209	218	191	finally
    //   222	231	191	finally
    //   235	244	191	finally
    //   248	257	191	finally
    //   261	270	191	finally
    //   85	92	208	java/lang/Exception
    //   106	113	221	java/lang/Exception
    //   113	120	234	java/lang/Exception
    //   144	151	247	java/lang/Exception
    //   151	158	260	java/lang/Exception
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "releaseOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        loggerCodecException((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          releaseOutputBuffer(paramMediaCodec, paramInt, paramBoolean);
        }
      }
      throw localException;
    }
    catch (Error localError)
    {
      label9:
      break label9;
    }
  }
  
  private void signalEndOfAudioStream()
  {
    try
    {
      if (this.enOfAudioInputStream) {
        return;
      }
      Logger.d("EncoderWriter", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.audioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
        this.enOfAudioInputStream = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfAudioStream failed", localThrowable);
      localThrowable.printStackTrace();
    }
  }
  
  @RequiresApi(api=18)
  private void signalEndOfVideoStream()
  {
    Logger.d("EncoderWriter", "signalEndOfVideoStream: ");
    if ((this._inputSurface == null) || (this.enOfVideoInputStream)) {
      return;
    }
    try
    {
      this.videoEncoder.signalEndOfInputStream();
      this.enOfVideoInputStream = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfVideoStream failed", localThrowable);
    }
  }
  
  private boolean unStarted()
  {
    return (!this.muxerStarted) && ((!this.hasVideoTrack) || (this.videoEncodeFormat != null)) && ((!this.hasAudioTrack) || (this.audioEncodeFormat != null));
  }
  
  private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo paramBufferInfo)
  {
    return paramBufferInfo.size > 0;
  }
  
  private void waitTime(long paramLong)
  {
    try
    {
      wait(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  /* Error */
  @RequiresApi(api=18)
  private boolean writeAudioFrame(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 461 1 0
    //   11: aload_0
    //   12: getfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   15: ifne +10 -> 25
    //   18: aload_0
    //   19: getfield 113	com/tencent/tav/decoder/EncoderWriter:audioEncodeFormat	Landroid/media/MediaFormat;
    //   22: ifnonnull +328 -> 350
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   30: aload_0
    //   31: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   34: invokespecial 185	com/tencent/tav/decoder/EncoderWriter:dequeueOutputBuffer	(Landroid/media/MediaCodec;Landroid/media/MediaCodec$BufferInfo;)I
    //   37: istore_2
    //   38: iload_2
    //   39: iconst_m1
    //   40: if_icmpne +18 -> 58
    //   43: iload_1
    //   44: ifne +310 -> 354
    //   47: aload_0
    //   48: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   51: invokeinterface 472 1 0
    //   56: iload_3
    //   57: ireturn
    //   58: iload_2
    //   59: bipush 254
    //   61: if_icmpne +19 -> 80
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   69: invokevirtual 522	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   72: putfield 113	com/tencent/tav/decoder/EncoderWriter:audioEncodeFormat	Landroid/media/MediaFormat;
    //   75: iconst_0
    //   76: istore_3
    //   77: goto -30 -> 47
    //   80: iload_2
    //   81: iflt +273 -> 354
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   89: iload_2
    //   90: invokespecial 326	com/tencent/tav/decoder/EncoderWriter:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   93: astore 4
    //   95: aload_0
    //   96: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   99: getfield 525	android/media/MediaCodec$BufferInfo:flags	I
    //   102: iconst_2
    //   103: iand
    //   104: ifeq +11 -> 115
    //   107: aload_0
    //   108: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   111: iconst_0
    //   112: putfield 513	android/media/MediaCodec$BufferInfo:size	I
    //   115: getstatic 160	android/os/Build$VERSION:SDK_INT	I
    //   118: bipush 19
    //   120: if_icmplt +37 -> 157
    //   123: aload 4
    //   125: aload_0
    //   126: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   129: getfield 528	android/media/MediaCodec$BufferInfo:offset	I
    //   132: invokevirtual 532	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   135: pop
    //   136: aload 4
    //   138: aload_0
    //   139: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   142: getfield 528	android/media/MediaCodec$BufferInfo:offset	I
    //   145: aload_0
    //   146: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   149: getfield 513	android/media/MediaCodec$BufferInfo:size	I
    //   152: iadd
    //   153: invokevirtual 535	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   156: pop
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   162: invokespecial 537	com/tencent/tav/decoder/EncoderWriter:validAndCorrectBufferInfo	(Landroid/media/MediaCodec$BufferInfo;)Z
    //   165: ifeq +111 -> 276
    //   168: aload_0
    //   169: getfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   172: istore_1
    //   173: iload_1
    //   174: ifeq +102 -> 276
    //   177: new 104	android/media/MediaCodec$BufferInfo
    //   180: dup
    //   181: invokespecial 105	android/media/MediaCodec$BufferInfo:<init>	()V
    //   184: astore 5
    //   186: aload 5
    //   188: aload_0
    //   189: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   192: getfield 528	android/media/MediaCodec$BufferInfo:offset	I
    //   195: aload_0
    //   196: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   199: getfield 513	android/media/MediaCodec$BufferInfo:size	I
    //   202: aload_0
    //   203: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   206: getfield 540	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   209: aload_0
    //   210: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   213: getfield 525	android/media/MediaCodec$BufferInfo:flags	I
    //   216: invokevirtual 544	android/media/MediaCodec$BufferInfo:set	(IIJI)V
    //   219: aload_0
    //   220: getfield 132	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   223: aload_0
    //   224: getfield 117	com/tencent/tav/decoder/EncoderWriter:outputAudioTrack	I
    //   227: aload 4
    //   229: aload 5
    //   231: invokevirtual 548	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   234: ldc 30
    //   236: new 247	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 550
    //   246: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   253: getfield 540	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   256: invokevirtual 553	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   259: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 556	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_0
    //   266: aload_0
    //   267: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   270: getfield 540	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   273: putfield 558	com/tencent/tav/decoder/EncoderWriter:audioPresentationTimeUs	J
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   281: iload_2
    //   282: iconst_0
    //   283: invokespecial 492	com/tencent/tav/decoder/EncoderWriter:releaseOutputBuffer	(Landroid/media/MediaCodec;IZ)V
    //   286: aload_0
    //   287: getfield 109	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   290: getfield 525	android/media/MediaCodec$BufferInfo:flags	I
    //   293: iconst_4
    //   294: iand
    //   295: ifeq +59 -> 354
    //   298: ldc 30
    //   300: ldc_w 560
    //   303: invokestatic 372	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_0
    //   307: ldc2_w 36
    //   310: putfield 558	com/tencent/tav/decoder/EncoderWriter:audioPresentationTimeUs	J
    //   313: aload_0
    //   314: iconst_0
    //   315: putfield 84	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   318: goto -271 -> 47
    //   321: astore 4
    //   323: aload_0
    //   324: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   327: invokeinterface 472 1 0
    //   332: aload 4
    //   334: athrow
    //   335: astore 4
    //   337: ldc 30
    //   339: ldc_w 562
    //   342: aload 4
    //   344: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   347: goto -71 -> 276
    //   350: iload_1
    //   351: ifeq -304 -> 47
    //   354: iconst_0
    //   355: istore_3
    //   356: goto -309 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	EncoderWriter
    //   0	359	1	paramBoolean	boolean
    //   37	245	2	i	int
    //   1	355	3	bool	boolean
    //   93	135	4	localByteBuffer	ByteBuffer
    //   321	12	4	localObject	Object
    //   335	8	4	localException	Exception
    //   184	46	5	localBufferInfo	MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   2	25	321	finally
    //   25	38	321	finally
    //   64	75	321	finally
    //   84	115	321	finally
    //   115	157	321	finally
    //   157	173	321	finally
    //   177	276	321	finally
    //   276	318	321	finally
    //   337	347	321	finally
    //   177	276	335	java/lang/Exception
  }
  
  /* Error */
  @RequiresApi(api=18)
  private boolean writeVideoFrame(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   7: invokeinterface 461 1 0
    //   12: aload_0
    //   13: getfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: getfield 111	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   23: ifnonnull +329 -> 352
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   31: aload_0
    //   32: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   35: invokespecial 185	com/tencent/tav/decoder/EncoderWriter:dequeueOutputBuffer	(Landroid/media/MediaCodec;Landroid/media/MediaCodec$BufferInfo;)I
    //   38: istore_2
    //   39: iload_2
    //   40: iconst_m1
    //   41: if_icmpne +19 -> 60
    //   44: iload_1
    //   45: ifne +311 -> 356
    //   48: aload_0
    //   49: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 472 1 0
    //   57: iload 4
    //   59: ireturn
    //   60: iload_2
    //   61: bipush 254
    //   63: if_icmpne +20 -> 83
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   71: invokevirtual 522	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   74: putfield 111	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   77: iconst_0
    //   78: istore 4
    //   80: goto -32 -> 48
    //   83: iload_2
    //   84: iflt +272 -> 356
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   92: iload_2
    //   93: invokespecial 326	com/tencent/tav/decoder/EncoderWriter:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   96: astore 5
    //   98: aload_0
    //   99: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   102: getfield 525	android/media/MediaCodec$BufferInfo:flags	I
    //   105: iconst_2
    //   106: iand
    //   107: ifeq +11 -> 118
    //   110: aload_0
    //   111: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   114: iconst_0
    //   115: putfield 513	android/media/MediaCodec$BufferInfo:size	I
    //   118: aload_0
    //   119: getfield 119	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   122: ifeq +84 -> 206
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   130: invokespecial 537	com/tencent/tav/decoder/EncoderWriter:validAndCorrectBufferInfo	(Landroid/media/MediaCodec$BufferInfo;)Z
    //   133: istore_1
    //   134: iload_1
    //   135: ifeq +71 -> 206
    //   138: new 104	android/media/MediaCodec$BufferInfo
    //   141: dup
    //   142: invokespecial 105	android/media/MediaCodec$BufferInfo:<init>	()V
    //   145: astore 6
    //   147: aload 6
    //   149: aload_0
    //   150: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   153: getfield 528	android/media/MediaCodec$BufferInfo:offset	I
    //   156: aload_0
    //   157: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   160: getfield 513	android/media/MediaCodec$BufferInfo:size	I
    //   163: aload_0
    //   164: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   167: getfield 540	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   170: aload_0
    //   171: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   174: getfield 525	android/media/MediaCodec$BufferInfo:flags	I
    //   177: invokevirtual 544	android/media/MediaCodec$BufferInfo:set	(IIJI)V
    //   180: aload_0
    //   181: getfield 132	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   184: aload_0
    //   185: getfield 115	com/tencent/tav/decoder/EncoderWriter:outputVideoTrack	I
    //   188: aload 5
    //   190: aload 6
    //   192: invokevirtual 548	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   195: aload_0
    //   196: aload_0
    //   197: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   200: getfield 540	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   203: putfield 564	com/tencent/tav/decoder/EncoderWriter:videoPresentationTimeUs	J
    //   206: aload_0
    //   207: aload_0
    //   208: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   211: iload_2
    //   212: iconst_0
    //   213: invokespecial 492	com/tencent/tav/decoder/EncoderWriter:releaseOutputBuffer	(Landroid/media/MediaCodec;IZ)V
    //   216: aload_0
    //   217: getfield 107	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   220: getfield 525	android/media/MediaCodec$BufferInfo:flags	I
    //   223: iconst_4
    //   224: iand
    //   225: ifeq +131 -> 356
    //   228: ldc 30
    //   230: ldc_w 566
    //   233: invokestatic 372	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: ldc2_w 36
    //   240: putfield 564	com/tencent/tav/decoder/EncoderWriter:videoPresentationTimeUs	J
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 82	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   248: goto -200 -> 48
    //   251: astore 5
    //   253: bipush 135
    //   255: istore_3
    //   256: iload_3
    //   257: istore_2
    //   258: getstatic 160	android/os/Build$VERSION:SDK_INT	I
    //   261: bipush 23
    //   263: if_icmplt +49 -> 312
    //   266: iload_3
    //   267: istore_2
    //   268: aload 5
    //   270: instanceof 162
    //   273: ifeq +39 -> 312
    //   276: new 247	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 568
    //   286: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: bipush 135
    //   291: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: aload 5
    //   296: checkcast 162	android/media/MediaCodec$CodecException
    //   299: invokevirtual 342	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   302: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 573	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   311: istore_2
    //   312: new 390	com/tencent/tav/core/ExportRuntimeException
    //   315: dup
    //   316: iload_2
    //   317: aload 5
    //   319: invokespecial 576	com/tencent/tav/core/ExportRuntimeException:<init>	(ILjava/lang/Throwable;)V
    //   322: athrow
    //   323: astore 5
    //   325: aload_0
    //   326: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   329: invokeinterface 472 1 0
    //   334: aload 5
    //   336: athrow
    //   337: astore 5
    //   339: ldc 30
    //   341: ldc_w 578
    //   344: aload 5
    //   346: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: goto -143 -> 206
    //   352: iload_1
    //   353: ifeq -305 -> 48
    //   356: iconst_0
    //   357: istore 4
    //   359: goto -311 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	EncoderWriter
    //   0	362	1	paramBoolean	boolean
    //   38	279	2	i	int
    //   255	12	3	j	int
    //   1	357	4	bool	boolean
    //   96	93	5	localByteBuffer	ByteBuffer
    //   251	67	5	localThrowable	Throwable
    //   323	12	5	localObject	Object
    //   337	8	5	localException	Exception
    //   145	46	6	localBufferInfo	MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   3	26	251	java/lang/Throwable
    //   26	39	251	java/lang/Throwable
    //   66	77	251	java/lang/Throwable
    //   87	118	251	java/lang/Throwable
    //   118	134	251	java/lang/Throwable
    //   138	206	251	java/lang/Throwable
    //   206	248	251	java/lang/Throwable
    //   339	349	251	java/lang/Throwable
    //   3	26	323	finally
    //   26	39	323	finally
    //   66	77	323	finally
    //   87	118	323	finally
    //   118	134	323	finally
    //   138	206	323	finally
    //   206	248	323	finally
    //   258	266	323	finally
    //   268	312	323	finally
    //   312	323	323	finally
    //   339	349	323	finally
    //   138	206	337	java/lang/Exception
  }
  
  public boolean audioTrackWritable()
  {
    boolean bool2 = true;
    if ((this.hasAudioTrack) && ((this.muxerStarted) || (this.audioEncodeFormat == null))) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.hasAudioTrack)
        {
          bool1 = bool2;
          if (!this.muxerStarted)
          {
            if (this.audioEncodeFormat == null) {
              bool1 = bool2;
            }
          }
          else {
            return bool1;
          }
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  @RequiresApi(api=18)
  public Surface createInputSurface()
  {
    try
    {
      if ((this._inputSurface == null) && (this.hasVideoTrack)) {
        this._inputSurface = this.videoEncoder.createInputSurface();
      }
      Surface localSurface = this._inputSurface;
      return localSurface;
    }
    finally {}
  }
  
  @RequiresApi(api=18)
  public void endWriteAudioSample()
  {
    Logger.d("EncoderWriter", "endWriteAudioSample:" + this);
    try
    {
      this.lock.readLock().lock();
      if (!this.released)
      {
        boolean bool = this.enOfAudioInputStream;
        if (!bool) {}
      }
      else
      {
        return;
      }
      Logger.d("EncoderWriter", "endWriteAudioSample: ");
      try
      {
        int i = dequeueInputBuffer(this.audioEncoder);
        if (i >= 0)
        {
          queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
          this.enOfAudioInputStream = true;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Logger.e("EncoderWriter", "endWriteAudioSample failed", localThrowable);
        }
      }
      drainEncoder(false);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
  
  /* Error */
  @RequiresApi(api=18)
  public void endWriteVideoSample()
  {
    // Byte code:
    //   0: ldc 30
    //   2: ldc_w 598
    //   5: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   12: invokeinterface 589 1 0
    //   17: invokeinterface 461 1 0
    //   22: aload_0
    //   23: getfield 125	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +18 -> 46
    //   31: aload_0
    //   32: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   35: invokeinterface 589 1 0
    //   40: invokeinterface 472 1 0
    //   45: return
    //   46: aload_0
    //   47: getfield 102	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 86	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   57: istore_1
    //   58: iload_1
    //   59: ifeq +18 -> 77
    //   62: aload_0
    //   63: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   66: invokeinterface 589 1 0
    //   71: invokeinterface 472 1 0
    //   76: return
    //   77: aload_0
    //   78: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   81: invokevirtual 506	android/media/MediaCodec:signalEndOfInputStream	()V
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield 86	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   89: aload_0
    //   90: iconst_0
    //   91: invokespecial 593	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(Z)V
    //   94: aload_0
    //   95: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   98: invokeinterface 589 1 0
    //   103: invokeinterface 472 1 0
    //   108: return
    //   109: astore_2
    //   110: ldc 30
    //   112: ldc_w 600
    //   115: aload_2
    //   116: invokestatic 155	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_2
    //   120: invokevirtual 501	java/lang/Throwable:printStackTrace	()V
    //   123: goto -34 -> 89
    //   126: astore_2
    //   127: aload_0
    //   128: getfield 100	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   131: invokeinterface 589 1 0
    //   136: invokeinterface 472 1 0
    //   141: aload_2
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	EncoderWriter
    //   26	33	1	bool	boolean
    //   109	11	2	localThrowable	Throwable
    //   126	16	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	89	109	java/lang/Throwable
    //   8	27	126	finally
    //   46	58	126	finally
    //   77	89	126	finally
    //   89	94	126	finally
    //   110	123	126	finally
  }
  
  public long getAudioPresentationTimeUs()
  {
    return this.audioPresentationTimeUs;
  }
  
  public int getOutHeight()
  {
    return this.outHeight;
  }
  
  public int getOutWidth()
  {
    return this.outWidth;
  }
  
  public long getVideoPresentationTimeUs()
  {
    return this.videoPresentationTimeUs;
  }
  
  public void setEncodeOption(@NonNull ExportConfig paramExportConfig)
  {
    if ((paramExportConfig.getOutputWidth() <= 0) || (paramExportConfig.getOutputHeight() <= 0)) {
      throw new IllegalArgumentException("width and height must > 0");
    }
    this.encodeOption = paramExportConfig.clone();
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 461 1 0
    //   11: ldc 30
    //   13: new 247	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 628
    //   23: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 624	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   41: invokespecial 630	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 84	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   49: aload_0
    //   50: getfield 380	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   53: invokevirtual 631	android/media/MediaCodec:start	()V
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 123	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   61: aload_0
    //   62: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 472 1 0
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 95	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   78: invokeinterface 472 1 0
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	EncoderWriter
    //   73	11	1	localObject1	Object
    //   85	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	61	73	finally
    //   61	70	85	finally
    //   74	85	85	finally
  }
  
  /* Error */
  @RequiresApi(api=18)
  public void startVideoEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 461 1 0
    //   11: ldc 30
    //   13: new 247	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 634
    //   23: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 266	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 624	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   41: invokespecial 636	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 82	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   49: aload_0
    //   50: invokevirtual 637	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   53: pop
    //   54: aload_0
    //   55: getfield 432	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   58: invokevirtual 631	android/media/MediaCodec:start	()V
    //   61: aload_0
    //   62: iconst_1
    //   63: putfield 121	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   66: aload_0
    //   67: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   70: invokeinterface 472 1 0
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 93	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 472 1 0
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	EncoderWriter
    //   78	11	1	localObject1	Object
    //   90	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	66	78	finally
    //   66	75	90	finally
    //   79	90	90	finally
  }
  
  @RequiresApi(api=18)
  public void stop()
  {
    Logger.d("EncoderWriter", "AssetWriter stop " + this);
    if (this.released) {}
    while ((!this.videoEncoderStarted) && (!this.audioEncoderStarted)) {
      return;
    }
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    drainEncoder(true);
    release();
  }
  
  public boolean videoTrackWritable()
  {
    boolean bool2 = true;
    if ((this.hasVideoTrack) && ((this.muxerStarted) || (this.videoEncodeFormat == null))) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.hasVideoTrack)
        {
          bool1 = bool2;
          if (!this.muxerStarted)
          {
            if (this.videoEncodeFormat == null) {
              bool1 = bool2;
            }
          }
          else {
            return bool1;
          }
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  @RequiresApi(api=18)
  public void writeAudioSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    label353:
    for (;;)
    {
      int j;
      try
      {
        this.lock.readLock().lock();
        StringBuilder localStringBuilder = new StringBuilder().append("writeAudioSample: ").append(paramLong).append("  ");
        Object localObject;
        boolean bool;
        if (paramByteBuffer != null)
        {
          localObject = Integer.valueOf(paramByteBuffer.limit());
          Logger.v("EncoderWriter", localObject);
          if (paramByteBuffer != null)
          {
            bool = this.released;
            if (!bool) {
              continue;
            }
          }
        }
        else
        {
          localObject = "null";
          continue;
        }
        int i = paramByteBuffer.position();
        j = paramByteBuffer.limit();
        long l1 = 0L;
        if (i < j)
        {
          bool = this.released;
          if (!bool) {
            try
            {
              this.audioEncoderLock.lock();
              int m = dequeueInputBuffer(this.audioEncoder);
              if (m < 0) {
                break label353;
              }
              localObject = getInputBuffer(this.audioEncoder, m);
              int k = Math.min(j - i, ((ByteBuffer)localObject).capacity());
              paramByteBuffer.limit(i + k);
              paramByteBuffer.position(i);
              ((ByteBuffer)localObject).put(paramByteBuffer);
              queueInputBuffer(this.audioEncoder, m, 0, k, paramLong + l1, 0);
              i += k;
              long l2 = DecoderUtils.getAudioDuration(k, this.encodeOption.getAudioChannelCount(), this.encodeOption.getAudioSampleRateHz());
              l1 = l2 + l1;
              this.audioEncoderLock.unlock();
              drainEncoder(false);
              continue;
            }
            finally
            {
              this.audioEncoderLock.unlock();
            }
          }
        }
        paramByteBuffer.position(0);
      }
      catch (Throwable paramByteBuffer)
      {
        throw new ExportRuntimeException(-122, paramByteBuffer);
      }
      finally
      {
        this.lock.readLock().unlock();
      }
      paramByteBuffer.limit(j);
      this.lock.readLock().unlock();
      return;
    }
  }
  
  @RequiresApi(api=18)
  public void writeVideoSample()
  {
    try
    {
      this.lock.readLock().lock();
      Surface localSurface = this._inputSurface;
      if (localSurface == null) {
        return;
      }
      drainEncoder(false);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
  
  @RequiresApi(api=18)
  public void writeVideoSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    if (this._inputSurface != null) {
      return;
    }
    int i = 1;
    while (i != 0) {
      try
      {
        this.videoEncoderLock.lock();
        int j = dequeueInputBuffer(this.videoEncoder);
        if (j >= 0)
        {
          ByteBuffer localByteBuffer = getInputBuffer(this.videoEncoder, j);
          i = paramByteBuffer.limit();
          int k = paramByteBuffer.position();
          localByteBuffer.put(paramByteBuffer);
          queueInputBuffer(this.videoEncoder, j, 0, i - k, paramLong, 0);
          i = 0;
        }
        this.videoEncoderLock.unlock();
        drainEncoder(false);
      }
      finally
      {
        this.videoEncoderLock.unlock();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */