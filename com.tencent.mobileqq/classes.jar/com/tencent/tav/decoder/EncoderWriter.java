package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Surface;
import com.tencent.tav.Utils;
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
  private static final String TAG = "AssetWriter";
  private static final long WAIT_TRANSIENT_MS = 20L;
  public static final long WRITER_FINISH = -1L;
  private Surface _inputSurface = null;
  private volatile MediaCodec.BufferInfo audioBufferInfo = new MediaCodec.BufferInfo();
  private volatile MediaFormat audioEncodeFormat = null;
  private MediaCodec audioEncoder;
  private Lock audioEncoderLock = new ReentrantLock();
  private boolean audioEncoderStarted = false;
  private long audioPresentationTimeUs;
  private int baselineLevel = 0;
  private boolean enOfAudioInputStream = false;
  private boolean enOfVideoInputStream = false;
  private boolean hasAudioTrack = false;
  private boolean hasVideoTrack = false;
  private ReadWriteLock lock = new ReentrantReadWriteLock();
  private MediaMuxer muxer;
  private volatile boolean muxerStarted = false;
  private int outHeight;
  private int outWidth;
  private volatile int outputAudioTrack = -1;
  private EncoderWriter.OutputConfig outputConfig = new EncoderWriter.OutputConfig();
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
  
  private void configureQualityEncoder(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    selectProfileAndLevel(paramMediaFormat);
    try
    {
      paramMediaCodec.configure(paramMediaFormat, null, null, 1);
      return;
    }
    catch (Exception paramMediaCodec)
    {
      Logger.e("AssetWriter", "configureQualityEncoder: ", paramMediaCodec);
      if (this.baselineLevel == -1) {
        break label71;
      }
    }
    paramMediaFormat.setInteger("profile", 1);
    paramMediaFormat.setInteger("level", this.baselineLevel);
    for (;;)
    {
      try
      {
        MediaCodec.createEncoderByType("video/avc").configure(paramMediaFormat, null, null, 1);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        Logger.e("AssetWriter", "configureQualityEncoder: ", paramMediaCodec);
        return;
      }
      label71:
      paramMediaFormat.setInteger("profile", 0);
      paramMediaFormat.setInteger("level", 0);
    }
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
      Logger.e("AssetWriter", "dequeueInputBuffer e = ", localException);
      if ((21 <= Build.VERSION.SDK_INT) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
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
      Logger.e("AssetWriter", "dequeueOutputBuffer e = ", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
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
          break label316;
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
          break label331;
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
          break label356;
        }
        if (i == 0) {
          break label370;
        }
        signalEndOfVideoStream();
        i = 0;
      }
      label144:
      label235:
      label370:
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
              Logger.e("AssetWriter", "drainEncoder: 视频写入处理时间超时，提前结束写入");
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
              break label235;
            }
            bool3 = true;
            if (paramBoolean) {
              break label343;
            }
          }
          for (bool2 = true;; bool2 = false)
          {
            for (;;)
            {
              this.hasAudioTrack = bool2;
              Logger.e("AssetWriter", "drainEncoder: 音频写入处理时间超时，提前结束写入");
              bool2 = bool3;
              if (!unStarted()) {
                break label357;
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
      label316:
      label331:
      label343:
      label356:
      label357:
      i = 0;
    }
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
      Logger.e("AssetWriter", "getInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
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
      Logger.e("AssetWriter", "getOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
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
  
  private void prepareAudioEncoder(EncoderWriter.OutputConfig paramOutputConfig)
  {
    Logger.d("AssetWriter", "AssetWriter prepareAudioEncoder " + this);
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(paramOutputConfig.AUDIO_MIME_TYPE, paramOutputConfig.AUDIO_SAMPLE_RATE_HZ, paramOutputConfig.AUDIO_CHANNEL_COUNT);
    localMediaFormat.setInteger("bitrate", paramOutputConfig.AUDIO_BIT_RATE);
    localMediaFormat.setInteger("aac-profile", paramOutputConfig.AUDIO_AAC_PROFILE);
    localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0 }));
    this.audioEncoder = MediaCodec.createEncoderByType(paramOutputConfig.AUDIO_MIME_TYPE);
    this.audioEncoder.configure(localMediaFormat, null, null, 1);
  }
  
  private void prepareVideoEncoder(EncoderWriter.OutputConfig paramOutputConfig)
  {
    Logger.d("AssetWriter", "AssetWriter prepareVideoEncoder " + this + "  " + paramOutputConfig.VIDEO_TARGET_WIDTH + " x " + paramOutputConfig.VIDEO_TARGET_HEIGHT);
    int i;
    int j;
    if (paramOutputConfig.VIDEO_BIT_RATE <= 0)
    {
      i = 8000000;
      if (paramOutputConfig.VIDEO_FRAME_RATE > 0) {
        break label229;
      }
      j = 30;
      label71:
      if (paramOutputConfig.VIDEO_IFRAME_INTERVAL > 0) {
        break label237;
      }
    }
    Object localObject;
    label229:
    label237:
    for (int k = 1;; k = paramOutputConfig.VIDEO_IFRAME_INTERVAL)
    {
      localObject = CodecHelper.correctSupportSize(new CGSize(paramOutputConfig.VIDEO_TARGET_WIDTH, paramOutputConfig.VIDEO_TARGET_HEIGHT), "video/avc");
      this.outHeight = ((int)((CGSize)localObject).height);
      this.outWidth = ((int)((CGSize)localObject).width);
      localObject = MediaFormat.createVideoFormat("video/avc", (int)((CGSize)localObject).width, (int)((CGSize)localObject).height);
      ((MediaFormat)localObject).setInteger("color-format", 2130708361);
      ((MediaFormat)localObject).setInteger("bitrate", i);
      ((MediaFormat)localObject).setInteger("frame-rate", j);
      ((MediaFormat)localObject).setInteger("i-frame-interval", k);
      this.videoEncoder = MediaCodec.createEncoderByType("video/avc");
      if ((!paramOutputConfig.HIGH_PROFILE) || ("OPPO_OPPO_R9s".equals(Utils.getPhoneName()))) {
        break label246;
      }
      configureQualityEncoder(this.videoEncoder, (MediaFormat)localObject);
      return;
      i = paramOutputConfig.VIDEO_BIT_RATE;
      break;
      j = paramOutputConfig.VIDEO_FRAME_RATE;
      break label71;
    }
    label246:
    this.videoEncoder.configure((MediaFormat)localObject, null, null, 1);
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
      Logger.e("AssetWriter", "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
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
    //   2: putfield 133	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   5: ldc 30
    //   7: new 197	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 429
    //   17: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 434	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: aload_0
    //   32: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   35: invokeinterface 440 1 0
    //   40: invokeinterface 444 1 0
    //   45: ldc 30
    //   47: new 197	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 446
    //   57: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 307	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +22 -> 98
    //   79: aload_0
    //   80: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   83: invokevirtual 449	android/media/MediaCodec:stop	()V
    //   86: aload_0
    //   87: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   90: invokevirtual 451	android/media/MediaCodec:release	()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   98: aload_0
    //   99: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +22 -> 126
    //   107: aload_0
    //   108: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   111: invokevirtual 449	android/media/MediaCodec:stop	()V
    //   114: aload_0
    //   115: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   118: invokevirtual 451	android/media/MediaCodec:release	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   126: aload_0
    //   127: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   130: ifnull +34 -> 164
    //   133: aload_0
    //   134: getfield 127	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   137: ifeq +15 -> 152
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 127	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   145: aload_0
    //   146: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   149: invokevirtual 452	android/media/MediaMuxer:stop	()V
    //   152: aload_0
    //   153: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   156: invokevirtual 453	android/media/MediaMuxer:release	()V
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   164: aload_0
    //   165: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   168: invokeinterface 440 1 0
    //   173: invokeinterface 456 1 0
    //   178: return
    //   179: astore_1
    //   180: ldc 30
    //   182: aload_1
    //   183: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: goto -100 -> 86
    //   189: astore_1
    //   190: aload_0
    //   191: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   194: invokeinterface 440 1 0
    //   199: invokeinterface 456 1 0
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: ldc 30
    //   209: aload_1
    //   210: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: goto -120 -> 93
    //   216: astore_1
    //   217: ldc 30
    //   219: aload_1
    //   220: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: goto -109 -> 114
    //   226: astore_1
    //   227: ldc 30
    //   229: aload_1
    //   230: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -112 -> 121
    //   236: astore_1
    //   237: ldc 30
    //   239: aload_1
    //   240: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   243: goto -91 -> 152
    //   246: astore_1
    //   247: ldc 30
    //   249: aload_1
    //   250: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: goto -94 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	EncoderWriter
    //   74	30	1	localMediaCodec	MediaCodec
    //   179	4	1	localException1	Exception
    //   189	16	1	localObject	Object
    //   206	4	1	localException2	Exception
    //   216	4	1	localException3	Exception
    //   226	4	1	localException4	Exception
    //   236	4	1	localException5	Exception
    //   246	4	1	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   79	86	179	java/lang/Exception
    //   31	75	189	finally
    //   79	86	189	finally
    //   86	93	189	finally
    //   93	98	189	finally
    //   98	103	189	finally
    //   107	114	189	finally
    //   114	121	189	finally
    //   121	126	189	finally
    //   126	145	189	finally
    //   145	152	189	finally
    //   152	159	189	finally
    //   159	164	189	finally
    //   180	186	189	finally
    //   207	213	189	finally
    //   217	223	189	finally
    //   227	233	189	finally
    //   237	243	189	finally
    //   247	253	189	finally
    //   86	93	206	java/lang/Exception
    //   107	114	216	java/lang/Exception
    //   114	121	226	java/lang/Exception
    //   145	152	236	java/lang/Exception
    //   152	159	246	java/lang/Exception
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
      Logger.e("AssetWriter", "releaseOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
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
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
    }
    return null;
  }
  
  private void selectProfileAndLevel(MediaFormat paramMediaFormat)
  {
    Object localObject = selectCodec("video/avc");
    if (localObject != null)
    {
      localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType("video/avc");
      int n;
      int k;
      if (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels != null)
      {
        int j = -1;
        int i = -1;
        int m = 0;
        n = j;
        k = i;
        if (m < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          k = j;
          n = i;
          if (localObject.profileLevels[m].profile <= 8)
          {
            if (localObject.profileLevels[m].profile <= i) {
              break label161;
            }
            n = localObject.profileLevels[m].profile;
            k = localObject.profileLevels[m].level;
          }
          for (;;)
          {
            if (localObject.profileLevels[m].profile == 1) {
              this.baselineLevel = localObject.profileLevels[m].level;
            }
            m += 1;
            j = k;
            i = n;
            break;
            label161:
            k = j;
            n = i;
            if (localObject.profileLevels[m].profile == i)
            {
              k = j;
              n = i;
              if (localObject.profileLevels[m].level > j)
              {
                k = localObject.profileLevels[m].level;
                n = i;
              }
            }
          }
        }
      }
      else
      {
        n = -1;
        k = -1;
      }
      if (k == 8)
      {
        paramMediaFormat.setInteger("profile", k);
        paramMediaFormat.setInteger("level", n);
        Logger.d("AssetWriter", String.format("selectProfileAndLevel: 0x%x, 0x%x", new Object[] { Integer.valueOf(k), Integer.valueOf(n) }));
      }
    }
  }
  
  private void signalEndOfAudioStream()
  {
    try
    {
      if (this.enOfAudioInputStream) {
        return;
      }
      Logger.e("AssetWriter", "signalEndOfAudioStream: ");
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
      Logger.e("AssetWriter", "signalEndOfAudioStream failed", localThrowable);
      localThrowable.printStackTrace();
    }
  }
  
  @RequiresApi(api=18)
  private void signalEndOfVideoStream()
  {
    Logger.e("AssetWriter", "signalEndOfVideoStream: ");
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
      Logger.e("AssetWriter", "signalEndOfVideoStream failed", localThrowable);
      localThrowable.printStackTrace();
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
    //   3: getfield 96	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 444 1 0
    //   11: aload_0
    //   12: getfield 127	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   15: ifne +10 -> 25
    //   18: aload_0
    //   19: getfield 121	com/tencent/tav/decoder/EncoderWriter:audioEncodeFormat	Landroid/media/MediaFormat;
    //   22: ifnonnull +325 -> 347
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   30: aload_0
    //   31: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   34: invokespecial 247	com/tencent/tav/decoder/EncoderWriter:dequeueOutputBuffer	(Landroid/media/MediaCodec;Landroid/media/MediaCodec$BufferInfo;)I
    //   37: istore_2
    //   38: iload_2
    //   39: iconst_m1
    //   40: if_icmpne +18 -> 58
    //   43: iload_1
    //   44: ifne +307 -> 351
    //   47: aload_0
    //   48: getfield 96	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   51: invokeinterface 456 1 0
    //   56: iload_3
    //   57: ireturn
    //   58: iload_2
    //   59: bipush 254
    //   61: if_icmpne +19 -> 80
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   69: invokevirtual 552	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   72: putfield 121	com/tencent/tav/decoder/EncoderWriter:audioEncodeFormat	Landroid/media/MediaFormat;
    //   75: iconst_0
    //   76: istore_3
    //   77: goto -30 -> 47
    //   80: iload_2
    //   81: iflt +270 -> 351
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   89: iload_2
    //   90: invokespecial 297	com/tencent/tav/decoder/EncoderWriter:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   93: astore 4
    //   95: aload_0
    //   96: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   99: getfield 555	android/media/MediaCodec$BufferInfo:flags	I
    //   102: iconst_2
    //   103: iand
    //   104: ifeq +11 -> 115
    //   107: aload_0
    //   108: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   111: iconst_0
    //   112: putfield 542	android/media/MediaCodec$BufferInfo:size	I
    //   115: getstatic 193	android/os/Build$VERSION:SDK_INT	I
    //   118: bipush 19
    //   120: if_icmplt +37 -> 157
    //   123: aload 4
    //   125: aload_0
    //   126: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   129: getfield 558	android/media/MediaCodec$BufferInfo:offset	I
    //   132: invokevirtual 562	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   135: pop
    //   136: aload 4
    //   138: aload_0
    //   139: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   142: getfield 558	android/media/MediaCodec$BufferInfo:offset	I
    //   145: aload_0
    //   146: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   149: getfield 542	android/media/MediaCodec$BufferInfo:size	I
    //   152: iadd
    //   153: invokevirtual 565	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   156: pop
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   162: invokespecial 567	com/tencent/tav/decoder/EncoderWriter:validAndCorrectBufferInfo	(Landroid/media/MediaCodec$BufferInfo;)Z
    //   165: ifeq +111 -> 276
    //   168: aload_0
    //   169: getfield 127	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   172: istore_1
    //   173: iload_1
    //   174: ifeq +102 -> 276
    //   177: new 112	android/media/MediaCodec$BufferInfo
    //   180: dup
    //   181: invokespecial 113	android/media/MediaCodec$BufferInfo:<init>	()V
    //   184: astore 5
    //   186: aload 5
    //   188: aload_0
    //   189: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   192: getfield 558	android/media/MediaCodec$BufferInfo:offset	I
    //   195: aload_0
    //   196: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   199: getfield 542	android/media/MediaCodec$BufferInfo:size	I
    //   202: aload_0
    //   203: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   206: getfield 570	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   209: aload_0
    //   210: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   213: getfield 555	android/media/MediaCodec$BufferInfo:flags	I
    //   216: invokevirtual 574	android/media/MediaCodec$BufferInfo:set	(IIJI)V
    //   219: aload_0
    //   220: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   223: aload_0
    //   224: getfield 125	com/tencent/tav/decoder/EncoderWriter:outputAudioTrack	I
    //   227: aload 4
    //   229: aload 5
    //   231: invokevirtual 578	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   234: ldc 30
    //   236: new 197	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 580
    //   246: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   253: getfield 570	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   256: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   259: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 307	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_0
    //   266: aload_0
    //   267: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   270: getfield 570	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   273: putfield 585	com/tencent/tav/decoder/EncoderWriter:audioPresentationTimeUs	J
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   281: iload_2
    //   282: iconst_0
    //   283: invokespecial 467	com/tencent/tav/decoder/EncoderWriter:releaseOutputBuffer	(Landroid/media/MediaCodec;IZ)V
    //   286: aload_0
    //   287: getfield 117	com/tencent/tav/decoder/EncoderWriter:audioBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   290: getfield 555	android/media/MediaCodec$BufferInfo:flags	I
    //   293: iconst_4
    //   294: iand
    //   295: ifeq +56 -> 351
    //   298: ldc 30
    //   300: ldc_w 587
    //   303: invokestatic 232	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_0
    //   307: ldc2_w 36
    //   310: putfield 585	com/tencent/tav/decoder/EncoderWriter:audioPresentationTimeUs	J
    //   313: aload_0
    //   314: iconst_0
    //   315: putfield 85	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   318: goto -271 -> 47
    //   321: astore 4
    //   323: aload_0
    //   324: getfield 96	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   327: invokeinterface 456 1 0
    //   332: aload 4
    //   334: athrow
    //   335: astore 4
    //   337: ldc 30
    //   339: aload 4
    //   341: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   344: goto -68 -> 276
    //   347: iload_1
    //   348: ifeq -301 -> 47
    //   351: iconst_0
    //   352: istore_3
    //   353: goto -306 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	EncoderWriter
    //   0	356	1	paramBoolean	boolean
    //   37	245	2	i	int
    //   1	352	3	bool	boolean
    //   93	135	4	localByteBuffer	ByteBuffer
    //   321	12	4	localObject	Object
    //   335	5	4	localException	Exception
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
    //   337	344	321	finally
    //   177	276	335	java/lang/Exception
  }
  
  /* Error */
  @RequiresApi(api=18)
  private boolean writeVideoFrame(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 94	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 444 1 0
    //   11: aload_0
    //   12: getfield 127	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   15: ifne +10 -> 25
    //   18: aload_0
    //   19: getfield 119	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   22: ifnonnull +252 -> 274
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   30: aload_0
    //   31: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   34: invokespecial 247	com/tencent/tav/decoder/EncoderWriter:dequeueOutputBuffer	(Landroid/media/MediaCodec;Landroid/media/MediaCodec$BufferInfo;)I
    //   37: istore_2
    //   38: iload_2
    //   39: iconst_m1
    //   40: if_icmpne +18 -> 58
    //   43: iload_1
    //   44: ifne +234 -> 278
    //   47: aload_0
    //   48: getfield 94	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   51: invokeinterface 456 1 0
    //   56: iload_3
    //   57: ireturn
    //   58: iload_2
    //   59: bipush 254
    //   61: if_icmpne +19 -> 80
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   69: invokevirtual 552	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   72: putfield 119	com/tencent/tav/decoder/EncoderWriter:videoEncodeFormat	Landroid/media/MediaFormat;
    //   75: iconst_0
    //   76: istore_3
    //   77: goto -30 -> 47
    //   80: iload_2
    //   81: iflt +197 -> 278
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   89: iload_2
    //   90: invokespecial 297	com/tencent/tav/decoder/EncoderWriter:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   93: astore 4
    //   95: aload_0
    //   96: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   99: getfield 555	android/media/MediaCodec$BufferInfo:flags	I
    //   102: iconst_2
    //   103: iand
    //   104: ifeq +11 -> 115
    //   107: aload_0
    //   108: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   111: iconst_0
    //   112: putfield 542	android/media/MediaCodec$BufferInfo:size	I
    //   115: aload_0
    //   116: getfield 127	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   119: ifeq +84 -> 203
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   127: invokespecial 567	com/tencent/tav/decoder/EncoderWriter:validAndCorrectBufferInfo	(Landroid/media/MediaCodec$BufferInfo;)Z
    //   130: istore_1
    //   131: iload_1
    //   132: ifeq +71 -> 203
    //   135: new 112	android/media/MediaCodec$BufferInfo
    //   138: dup
    //   139: invokespecial 113	android/media/MediaCodec$BufferInfo:<init>	()V
    //   142: astore 5
    //   144: aload 5
    //   146: aload_0
    //   147: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   150: getfield 558	android/media/MediaCodec$BufferInfo:offset	I
    //   153: aload_0
    //   154: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   157: getfield 542	android/media/MediaCodec$BufferInfo:size	I
    //   160: aload_0
    //   161: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   164: getfield 570	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   167: aload_0
    //   168: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   171: getfield 555	android/media/MediaCodec$BufferInfo:flags	I
    //   174: invokevirtual 574	android/media/MediaCodec$BufferInfo:set	(IIJI)V
    //   177: aload_0
    //   178: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   181: aload_0
    //   182: getfield 123	com/tencent/tav/decoder/EncoderWriter:outputVideoTrack	I
    //   185: aload 4
    //   187: aload 5
    //   189: invokevirtual 578	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   192: aload_0
    //   193: aload_0
    //   194: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   197: getfield 570	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   200: putfield 589	com/tencent/tav/decoder/EncoderWriter:videoPresentationTimeUs	J
    //   203: aload_0
    //   204: aload_0
    //   205: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   208: iload_2
    //   209: iconst_0
    //   210: invokespecial 467	com/tencent/tav/decoder/EncoderWriter:releaseOutputBuffer	(Landroid/media/MediaCodec;IZ)V
    //   213: aload_0
    //   214: getfield 115	com/tencent/tav/decoder/EncoderWriter:videoBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   217: getfield 555	android/media/MediaCodec$BufferInfo:flags	I
    //   220: iconst_4
    //   221: iand
    //   222: ifeq +56 -> 278
    //   225: ldc 30
    //   227: ldc_w 591
    //   230: invokestatic 232	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: ldc2_w 36
    //   237: putfield 589	com/tencent/tav/decoder/EncoderWriter:videoPresentationTimeUs	J
    //   240: aload_0
    //   241: iconst_0
    //   242: putfield 83	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   245: goto -198 -> 47
    //   248: astore 4
    //   250: aload_0
    //   251: getfield 94	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   254: invokeinterface 456 1 0
    //   259: aload 4
    //   261: athrow
    //   262: astore 4
    //   264: ldc 30
    //   266: aload 4
    //   268: invokestatic 459	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -68 -> 203
    //   274: iload_1
    //   275: ifeq -228 -> 47
    //   278: iconst_0
    //   279: istore_3
    //   280: goto -233 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	EncoderWriter
    //   0	283	1	paramBoolean	boolean
    //   37	172	2	i	int
    //   1	279	3	bool	boolean
    //   93	93	4	localByteBuffer	ByteBuffer
    //   248	12	4	localObject	Object
    //   262	5	4	localException	Exception
    //   142	46	5	localBufferInfo	MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   2	25	248	finally
    //   25	38	248	finally
    //   64	75	248	finally
    //   84	115	248	finally
    //   115	131	248	finally
    //   135	203	248	finally
    //   203	245	248	finally
    //   264	271	248	finally
    //   135	203	262	java/lang/Exception
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
    Logger.e("AssetWriter", "endWriteAudioSample:" + this);
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
      Logger.e("AssetWriter", "endWriteAudioSample: ");
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
          Logger.e("AssetWriter", "endWriteAudioSample failed", localThrowable);
          localThrowable.printStackTrace();
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
    //   2: ldc_w 611
    //   5: invokestatic 232	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   12: invokeinterface 602 1 0
    //   17: invokeinterface 444 1 0
    //   22: aload_0
    //   23: getfield 133	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +18 -> 46
    //   31: aload_0
    //   32: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   35: invokeinterface 602 1 0
    //   40: invokeinterface 456 1 0
    //   45: return
    //   46: aload_0
    //   47: getfield 108	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 87	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   57: istore_1
    //   58: iload_1
    //   59: ifeq +18 -> 77
    //   62: aload_0
    //   63: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   66: invokeinterface 602 1 0
    //   71: invokeinterface 456 1 0
    //   76: return
    //   77: aload_0
    //   78: getfield 400	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   81: invokevirtual 535	android/media/MediaCodec:signalEndOfInputStream	()V
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield 87	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   89: aload_0
    //   90: iconst_0
    //   91: invokespecial 606	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(Z)V
    //   94: aload_0
    //   95: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   98: invokeinterface 602 1 0
    //   103: invokeinterface 456 1 0
    //   108: return
    //   109: astore_2
    //   110: ldc 30
    //   112: ldc_w 613
    //   115: aload_2
    //   116: invokestatic 164	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_2
    //   120: invokevirtual 530	java/lang/Throwable:printStackTrace	()V
    //   123: goto -34 -> 89
    //   126: astore_2
    //   127: aload_0
    //   128: getfield 106	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   131: invokeinterface 602 1 0
    //   136: invokeinterface 456 1 0
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
  
  public void outputAudioEncoderConfig(@NonNull EncoderWriter.OutputConfig paramOutputConfig)
  {
    try
    {
      this.outputConfig.AUDIO_SAMPLE_RATE_HZ = paramOutputConfig.AUDIO_SAMPLE_RATE_HZ;
      this.outputConfig.AUDIO_MIME_TYPE = paramOutputConfig.AUDIO_MIME_TYPE;
      this.outputConfig.AUDIO_CHANNEL_COUNT = paramOutputConfig.AUDIO_CHANNEL_COUNT;
      this.outputConfig.AUDIO_BIT_RATE = paramOutputConfig.AUDIO_BIT_RATE;
      this.outputConfig.AUDIO_AAC_PROFILE = paramOutputConfig.AUDIO_AAC_PROFILE;
      return;
    }
    finally
    {
      paramOutputConfig = finally;
      throw paramOutputConfig;
    }
  }
  
  public void outputVideoEncoderConfig(@NonNull EncoderWriter.OutputConfig paramOutputConfig)
  {
    try
    {
      this.outputConfig.VIDEO_TARGET_WIDTH = paramOutputConfig.VIDEO_TARGET_WIDTH;
      this.outputConfig.VIDEO_TARGET_HEIGHT = paramOutputConfig.VIDEO_TARGET_HEIGHT;
      this.outputConfig.VIDEO_IFRAME_INTERVAL = paramOutputConfig.VIDEO_IFRAME_INTERVAL;
      this.outputConfig.VIDEO_BIT_RATE = paramOutputConfig.VIDEO_BIT_RATE;
      this.outputConfig.VIDEO_FRAME_RATE = paramOutputConfig.VIDEO_FRAME_RATE;
      this.outputConfig.HIGH_PROFILE = paramOutputConfig.HIGH_PROFILE;
      return;
    }
    finally
    {
      paramOutputConfig = finally;
      throw paramOutputConfig;
    }
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 96	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 444 1 0
    //   11: ldc 30
    //   13: new 197	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 624
    //   23: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 307	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 101	com/tencent/tav/decoder/EncoderWriter:outputConfig	Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;
    //   41: invokespecial 626	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;)V
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 85	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   49: aload_0
    //   50: getfield 345	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   53: invokevirtual 627	android/media/MediaCodec:start	()V
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 131	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   61: aload_0
    //   62: getfield 96	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 456 1 0
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 96	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   78: invokeinterface 456 1 0
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
  
  @RequiresApi(api=18)
  public void startVideoEncoder()
  {
    try
    {
      this.videoEncoderLock.lock();
      Logger.d("AssetWriter", "AssetWriter startVideoEncoder " + this);
      if ((this.outputConfig.VIDEO_TARGET_WIDTH > 0) && (this.outputConfig.VIDEO_TARGET_HEIGHT > 0))
      {
        prepareVideoEncoder(this.outputConfig);
        this.hasVideoTrack = true;
        createInputSurface();
        this.videoEncoder.start();
        this.videoEncoderStarted = true;
      }
    }
    finally
    {
      this.videoEncoderLock.unlock();
    }
    try
    {
      this.videoEncoderLock.unlock();
      return;
    }
    finally {}
    throw new IllegalArgumentException("width and height must > 0");
  }
  
  @RequiresApi(api=18)
  public void stop()
  {
    Logger.e("AssetWriter", "AssetWriter stop " + this);
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
    label342:
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
          Log.e("AssetWriter", localObject);
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
                break label342;
              }
              localObject = getInputBuffer(this.audioEncoder, m);
              int k = Math.min(j - i, ((ByteBuffer)localObject).capacity());
              paramByteBuffer.limit(i + k);
              paramByteBuffer.position(i);
              ((ByteBuffer)localObject).put(paramByteBuffer);
              queueInputBuffer(this.audioEncoder, m, 0, k, paramLong + l1, 0);
              i += k;
              long l2 = DecoderUtils.getAudioDuration(k, this.outputConfig.AUDIO_CHANNEL_COUNT, this.outputConfig.AUDIO_SAMPLE_RATE_HZ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */