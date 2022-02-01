package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class AudioDecoder
  implements IDecoder
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final int MAX_WAIT_TIME = 1000;
  private static final long WAIT_TRANSIENT_MS = 2L;
  private static final ArrayList<String> nameList = new ArrayList();
  private final String TAG = "AudioDecoder@" + Integer.toHexString(hashCode());
  private AudioInfo _audioInfo = new AudioInfo();
  private ByteBuffer _outputBuffer = null;
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private CMTime currentDecoderTime = CMTime.CMTimeZero;
  private CMTime currentStartTime = CMTime.CMTimeInvalid;
  private MediaCodec decoder;
  private CMTime duration = CMTime.CMTimeZero;
  private AssetExtractor extractor = new AssetExtractor();
  private boolean extractorDone = false;
  private boolean isReleased = false;
  private int lastOutputBufferIndex = -1;
  private long mLastVideoQueueTime = 0L;
  private long mTimeOffset = 0L;
  private MediaFormat mediaFormat;
  private CMTime pFrameTime = new CMTime(20L, 600);
  private ArrayList<AudioDecoder.PendingFrame> pendingFrames = new ArrayList();
  private boolean started = false;
  private CMTimeRange timeRange;
  public int trackIndex = -1;
  
  public AudioDecoder(String paramString)
  {
    this.extractor.setDataSource(paramString);
    while (this.extractor.getSampleTrackIndex() != -1) {
      this.extractor.unselectTrack(this.extractor.getSampleTrackIndex());
    }
    this.trackIndex = DecoderUtils.getFirstTrackIndex(this.extractor, "audio/");
    if (this.trackIndex == -1)
    {
      this._outputBuffer = null;
      return;
    }
    this.extractor.selectTrack(this.trackIndex);
    this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
    this.duration = new CMTime((float)this.extractor.getAudioDuration() * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L));
    if (this.mediaFormat.containsKey("frame-rate")) {
      this.pFrameTime = new CMTime(600 / this.mediaFormat.getInteger("frame-rate"), 600);
    }
    this.decoder = MediaCodec.createDecoderByType(this.mediaFormat.getString("mime"));
    nameList.add(this.decoder.toString());
    if (decoderConfigure(this.mediaFormat))
    {
      start();
      this._audioInfo.sampleRate = this.mediaFormat.getInteger("sample-rate");
      this._audioInfo.channelCount = this.mediaFormat.getInteger("channel-count");
      return;
    }
    throw new IllegalStateException("decoderConfigure failed!");
  }
  
  private void clearDecoder()
  {
    Logger.d(this.TAG, "clearDecoder " + getSourcePath());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.decoder.flush();
      this.pendingFrames.clear();
      this.currentDecoderTime = CMTime.CMTimeInvalid;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean decoderConfigure(MediaFormat paramMediaFormat)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (Build.VERSION.SDK_INT < 21)
        {
          this.decoder.configure(paramMediaFormat, null, null, 0);
          bool = true;
          return bool;
        }
        int i = 0;
        i += 1;
        try
        {
          Logger.d(this.TAG, "createdDecoder---time---" + i);
          if (i > 10)
          {
            bool = false;
            continue;
          }
          this.decoder.configure(paramMediaFormat, null, null, 0);
          bool = true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (!(localException instanceof MediaCodec.CodecException)) {
            continue;
          }
        }
        if ((!((MediaCodec.CodecException)localException).isTransient()) && (!((MediaCodec.CodecException)localException).isRecoverable()))
        {
          this.decoder.release();
          throw localException;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private int dequeueInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: ldc2_w 305
    //   9: invokevirtual 309	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   22: ldc_w 310
    //   25: aload_2
    //   26: invokestatic 314	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   29: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 21
    //   34: if_icmplt +108 -> 142
    //   37: aload_2
    //   38: instanceof 291
    //   41: ifeq +101 -> 142
    //   44: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 23
    //   49: if_icmplt +68 -> 117
    //   52: aload_0
    //   53: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   56: new 63	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 316
    //   66: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: checkcast 291	android/media/MediaCodec$CodecException
    //   73: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   76: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   79: ldc_w 321
    //   82: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: checkcast 291	android/media/MediaCodec$CodecException
    //   89: invokevirtual 298	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   92: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: ldc_w 323
    //   98: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_2
    //   102: checkcast 291	android/media/MediaCodec$CodecException
    //   105: invokevirtual 326	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   108: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_2
    //   118: checkcast 291	android/media/MediaCodec$CodecException
    //   121: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   124: ifeq +18 -> 142
    //   127: aload_0
    //   128: ldc2_w 14
    //   131: invokespecial 332	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   134: aload_0
    //   135: invokespecial 334	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   138: istore_1
    //   139: goto -126 -> 13
    //   142: aload_2
    //   143: athrow
    //   144: astore_2
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: goto -132 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	AudioDecoder
    //   12	127	1	i	int
    //   17	126	2	localException	Exception
    //   144	4	2	localObject	Object
    //   149	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	13	17	java/lang/Exception
    //   2	13	144	finally
    //   18	117	144	finally
    //   117	139	144	finally
    //   142	144	144	finally
    //   2	13	149	java/lang/Error
  }
  
  private int dequeueOutputBuffer()
  {
    try
    {
      i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "dequeueOutputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(2L);
        int i = dequeueOutputBuffer();
      }
      throw localException;
    }
    finally {}
  }
  
  private CMTime doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    int i = 0;
    boolean bool = false;
    label159:
    label957:
    label960:
    for (;;)
    {
      long l2;
      int j;
      try
      {
        if (Logger.LOG_VERBOSE) {
          Logger.d(this.TAG, "doReadSample - " + this.extractor.getSourcePath());
        }
        paramCMTime = SAMPLE_TIME_FAILED;
        l1 = SAMPLE_TIME_FAILED.value;
        if ((!this.started) || (this.trackIndex == -1))
        {
          paramCMTime = this.TAG;
          localObject = new StringBuilder().append("doReadSample:[failed] !started || trackIndex == -1 ");
          if (!this.started)
          {
            paramBoolean = true;
            localObject = ((StringBuilder)localObject).append(paramBoolean).append(" - ");
            paramBoolean = bool;
            if (this.trackIndex == -1) {
              paramBoolean = true;
            }
            Logger.d(paramCMTime, paramBoolean);
            paramCMTime = SAMPLE_TIME_UNSTART;
            return paramCMTime;
          }
          paramBoolean = false;
          continue;
        }
        releaseOutputBuffer();
        if (this.pendingFrames.size() <= 0)
        {
          paramBoolean = this.extractorDone;
          localObject = paramCMTime;
          l2 = l1;
          if (paramBoolean) {
            break label664;
          }
        }
        try
        {
          if (!this.extractorDone) {
            readFromExtractor();
          }
          j = dequeueOutputBuffer();
          if (j != -2) {
            continue;
          }
          localObject = this.decoder.getOutputFormat();
          if (((MediaFormat)localObject).containsKey("pcm-encoding"))
          {
            this._audioInfo.pcmEncoding = ((MediaFormat)localObject).getInteger("pcm-encoding");
            if (!((MediaFormat)localObject).containsKey("sample-rate")) {
              break label960;
            }
            this._audioInfo.sampleRate = ((MediaFormat)localObject).getInteger("sample-rate");
            break label960;
          }
          this._audioInfo.pcmEncoding = 2;
          continue;
          paramCMTime = SAMPLE_TIME_ERROR;
        }
        catch (Exception paramCMTime)
        {
          paramCMTime.printStackTrace();
          if ((Build.VERSION.SDK_INT >= 21) && ((paramCMTime instanceof MediaCodec.CodecException)))
          {
            if (!((MediaCodec.CodecException)paramCMTime).isRecoverable()) {
              break label924;
            }
            releaseOutputBuffer();
            reset();
            this.lastOutputBufferIndex = -1;
            this.pendingFrames.clear();
            l1 = this.currentStartTime.getTimeUs();
            l2 = this.timeRange.getStartUs();
            this.extractor.seekTo(l1 - l2, 0);
            this.extractorDone = false;
          }
        }
        label368:
        continue;
        if ((j < 0) || (this.pendingFrames.size() <= 0)) {
          break label847;
        }
        if (this.bufferInfo.flags == 4)
        {
          if (this.bufferInfo.size > 0)
          {
            this.pendingFrames.remove(0);
            this.lastOutputBufferIndex = j;
            paramCMTime = getOnputBuffer(j);
            if (paramCMTime != null)
            {
              paramCMTime.position(this.bufferInfo.offset);
              paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
              this._outputBuffer = paramCMTime;
            }
          }
          else
          {
            Logger.e(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
            paramCMTime = SAMPLE_TIME_FINISH;
            continue;
          }
          releaseOutputBuffer(j, false);
          this._outputBuffer = null;
          continue;
        }
        paramCMTime = (AudioDecoder.PendingFrame)this.pendingFrames.remove(0);
      }
      finally {}
      long l1 = this.bufferInfo.presentationTimeUs - paramCMTime.timeOffset;
      Object localObject = new CMTime(l1, 1000000);
      if ((this.pendingFrames.size() == 0) && (this.extractorDone) && (paramCMTime.seekStartTime.getTimeUs() + 1000L >= this.duration.getTimeUs())) {
        localObject = this.duration;
      }
      for (;;)
      {
        if (this.bufferInfo.size > 0)
        {
          this.lastOutputBufferIndex = j;
          paramCMTime = getOnputBuffer(j);
          if (paramCMTime != null)
          {
            paramCMTime.position(this.bufferInfo.offset);
            paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
            this._outputBuffer = paramCMTime;
            l2 = l1;
            if (Logger.LOG_VERBOSE) {
              Logger.i(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + l2 + "  " + localObject, new Object[0]);
            }
            paramCMTime = (CMTime)localObject;
            if (!this.extractorDone) {
              break;
            }
            paramCMTime = (CMTime)localObject;
            if (l2 >= 0L) {
              break;
            }
            paramCMTime = SAMPLE_TIME_FINISH;
            break;
            if (paramCMTime.seekStartTime.getTimeUs() <= l1) {
              break label957;
            }
            releaseOutputBuffer(j, false);
            paramCMTime = SAMPLE_TIME_FAILED;
            break label159;
          }
          releaseOutputBuffer(j, false);
          Logger.e(this.TAG, "doReadSample:[error] " + this.bufferInfo.size + " byteBuffer==null");
          paramCMTime = SAMPLE_TIME_ERROR;
          break;
        }
        releaseOutputBuffer(j, false);
        paramCMTime = SAMPLE_TIME_FAILED;
        break label960;
        label847:
        if (j >= 0)
        {
          if (this.bufferInfo.flags == 4)
          {
            Logger.e(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM 2");
            paramCMTime = SAMPLE_TIME_FINISH;
            break;
          }
          releaseOutputBuffer(j, false);
          paramCMTime = SAMPLE_TIME_FAILED;
        }
        for (;;)
        {
          i += 1;
          if (i > 1000)
          {
            localObject = SAMPLE_TIME_TIMEOUT;
            Logger.e(this.TAG, "doReadSample: [timeout] ");
            l2 = l1;
            break label664;
            if (((MediaCodec.CodecException)paramCMTime).isTransient()) {
              break label368;
            }
            Logger.e(this.TAG, "doReadSample:[error] retry failed");
            paramCMTime = SAMPLE_TIME_ERROR;
            break;
          }
          break label960;
        }
      }
    }
  }
  
  /* Error */
  private ByteBuffer getInputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 471	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   20: ldc_w 472
    //   23: aload_2
    //   24: invokestatic 314	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   27: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   30: bipush 21
    //   32: if_icmplt +109 -> 141
    //   35: aload_2
    //   36: instanceof 291
    //   39: ifeq +102 -> 141
    //   42: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   45: bipush 23
    //   47: if_icmplt +68 -> 115
    //   50: aload_0
    //   51: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   54: new 63	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 316
    //   64: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: checkcast 291	android/media/MediaCodec$CodecException
    //   71: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   74: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   77: ldc_w 321
    //   80: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_2
    //   84: checkcast 291	android/media/MediaCodec$CodecException
    //   87: invokevirtual 298	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   90: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: ldc_w 323
    //   96: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: checkcast 291	android/media/MediaCodec$CodecException
    //   103: invokevirtual 326	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   106: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_2
    //   116: checkcast 291	android/media/MediaCodec$CodecException
    //   119: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   122: ifeq +19 -> 141
    //   125: aload_0
    //   126: ldc2_w 14
    //   129: invokespecial 332	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   132: aload_0
    //   133: iload_1
    //   134: invokespecial 474	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   137: astore_2
    //   138: goto -127 -> 11
    //   141: aload_2
    //   142: athrow
    //   143: astore_2
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    //   148: astore_2
    //   149: goto -133 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	AudioDecoder
    //   0	152	1	paramInt	int
    //   10	4	2	localByteBuffer1	ByteBuffer
    //   15	101	2	localException	Exception
    //   137	5	2	localByteBuffer2	ByteBuffer
    //   143	4	2	localObject	Object
    //   148	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	11	15	java/lang/Exception
    //   2	11	143	finally
    //   16	115	143	finally
    //   115	138	143	finally
    //   141	143	143	finally
    //   2	11	148	java/lang/Error
  }
  
  /* Error */
  private ByteBuffer getOnputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 477	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   20: ldc_w 478
    //   23: aload_2
    //   24: invokestatic 314	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   27: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   30: bipush 21
    //   32: if_icmplt +109 -> 141
    //   35: aload_2
    //   36: instanceof 291
    //   39: ifeq +102 -> 141
    //   42: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   45: bipush 23
    //   47: if_icmplt +68 -> 115
    //   50: aload_0
    //   51: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   54: new 63	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 316
    //   64: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: checkcast 291	android/media/MediaCodec$CodecException
    //   71: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   74: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   77: ldc_w 321
    //   80: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_2
    //   84: checkcast 291	android/media/MediaCodec$CodecException
    //   87: invokevirtual 298	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   90: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: ldc_w 323
    //   96: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: checkcast 291	android/media/MediaCodec$CodecException
    //   103: invokevirtual 326	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   106: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_2
    //   116: checkcast 291	android/media/MediaCodec$CodecException
    //   119: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   122: ifeq +19 -> 141
    //   125: aload_0
    //   126: ldc2_w 14
    //   129: invokespecial 332	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   132: aload_0
    //   133: iload_1
    //   134: invokespecial 406	com/tencent/tav/decoder/AudioDecoder:getOnputBuffer	(I)Ljava/nio/ByteBuffer;
    //   137: astore_2
    //   138: goto -127 -> 11
    //   141: aload_2
    //   142: athrow
    //   143: astore_2
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    //   148: astore_2
    //   149: goto -133 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	AudioDecoder
    //   0	152	1	paramInt	int
    //   10	4	2	localByteBuffer1	ByteBuffer
    //   15	101	2	localException	Exception
    //   137	5	2	localByteBuffer2	ByteBuffer
    //   143	4	2	localObject	Object
    //   148	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	11	15	java/lang/Exception
    //   2	11	143	finally
    //   16	115	143	finally
    //   115	138	143	finally
    //   141	143	143	finally
    //   2	11	148	java/lang/Error
  }
  
  /* Error */
  private void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: iload_3
    //   9: lload 4
    //   11: iload 6
    //   13: invokevirtual 482	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore 7
    //   21: aload_0
    //   22: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   25: ldc_w 483
    //   28: aload 7
    //   30: invokestatic 314	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   33: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   36: bipush 21
    //   38: if_icmplt +116 -> 154
    //   41: aload 7
    //   43: instanceof 291
    //   46: ifeq +108 -> 154
    //   49: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 23
    //   54: if_icmplt +71 -> 125
    //   57: aload_0
    //   58: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   61: new 63	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 316
    //   71: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 7
    //   76: checkcast 291	android/media/MediaCodec$CodecException
    //   79: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   82: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc_w 321
    //   88: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 7
    //   93: checkcast 291	android/media/MediaCodec$CodecException
    //   96: invokevirtual 298	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   99: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: ldc_w 323
    //   105: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 7
    //   110: checkcast 291	android/media/MediaCodec$CodecException
    //   113: invokevirtual 326	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   116: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload 7
    //   127: checkcast 291	android/media/MediaCodec$CodecException
    //   130: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   133: ifeq +21 -> 154
    //   136: aload_0
    //   137: ldc2_w 14
    //   140: invokespecial 332	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   143: aload_0
    //   144: iload_1
    //   145: iload_2
    //   146: iload_3
    //   147: lload 4
    //   149: iload 6
    //   151: invokespecial 484	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   154: aload 7
    //   156: athrow
    //   157: astore 7
    //   159: aload_0
    //   160: monitorexit
    //   161: aload 7
    //   163: athrow
    //   164: astore 7
    //   166: goto -145 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	AudioDecoder
    //   0	169	1	paramInt1	int
    //   0	169	2	paramInt2	int
    //   0	169	3	paramInt3	int
    //   0	169	4	paramLong	long
    //   0	169	6	paramInt4	int
    //   19	136	7	localException	Exception
    //   157	5	7	localObject	Object
    //   164	1	7	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	16	19	java/lang/Exception
    //   2	16	157	finally
    //   21	125	157	finally
    //   125	154	157	finally
    //   154	157	157	finally
    //   2	16	164	java/lang/Error
  }
  
  /* Error */
  private void readFromExtractor()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 140	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   6: invokevirtual 487	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   9: lstore_3
    //   10: lload_3
    //   11: aload_0
    //   12: getfield 382	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   15: invokevirtual 490	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   18: lcmp
    //   19: ifge +22 -> 41
    //   22: aload_0
    //   23: getfield 140	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   26: invokevirtual 146	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   29: iconst_m1
    //   30: if_icmpeq +11 -> 41
    //   33: lload_3
    //   34: ldc2_w 491
    //   37: lcmp
    //   38: ifne +29 -> 67
    //   41: aload_0
    //   42: invokespecial 334	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   45: istore_1
    //   46: iload_1
    //   47: iflt +17 -> 64
    //   50: aload_0
    //   51: iload_1
    //   52: iconst_0
    //   53: iconst_0
    //   54: lconst_0
    //   55: iconst_4
    //   56: invokespecial 484	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 131	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: invokespecial 334	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   71: istore_1
    //   72: iload_1
    //   73: iflt -9 -> 64
    //   76: aload_0
    //   77: iload_1
    //   78: invokespecial 474	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   81: astore 5
    //   83: aload_0
    //   84: getfield 140	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   87: aload 5
    //   89: iconst_0
    //   90: invokevirtual 496	com/tencent/tav/extractor/AssetExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   93: istore_2
    //   94: iload_2
    //   95: iflt +121 -> 216
    //   98: aload_0
    //   99: lload_3
    //   100: aload_0
    //   101: getfield 382	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   104: invokevirtual 387	com/tencent/tav/coremedia/CMTimeRange:getStartUs	()J
    //   107: lsub
    //   108: aload_0
    //   109: getfield 133	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   112: ladd
    //   113: putfield 135	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   116: aload_0
    //   117: iload_1
    //   118: iconst_0
    //   119: iload_2
    //   120: aload_0
    //   121: getfield 135	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   124: iconst_0
    //   125: invokespecial 484	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   128: new 428	com/tencent/tav/decoder/AudioDecoder$PendingFrame
    //   131: dup
    //   132: invokespecial 497	com/tencent/tav/decoder/AudioDecoder$PendingFrame:<init>	()V
    //   135: astore 5
    //   137: aload 5
    //   139: aload_0
    //   140: getfield 133	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   143: putfield 434	com/tencent/tav/decoder/AudioDecoder$PendingFrame:timeOffset	J
    //   146: aload 5
    //   148: new 88	com/tencent/tav/coremedia/CMTime
    //   151: dup
    //   152: lload_3
    //   153: l2f
    //   154: fconst_1
    //   155: fmul
    //   156: getstatic 177	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   159: lconst_1
    //   160: invokevirtual 181	java/util/concurrent/TimeUnit:toMicros	(J)J
    //   163: l2f
    //   164: fdiv
    //   165: invokespecial 184	com/tencent/tav/coremedia/CMTime:<init>	(F)V
    //   168: putfield 500	com/tencent/tav/decoder/AudioDecoder$PendingFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   171: aload 5
    //   173: aload_0
    //   174: getfield 124	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   177: aload_0
    //   178: getfield 382	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   181: invokevirtual 504	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   184: invokevirtual 508	com/tencent/tav/coremedia/CMTime:sub	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   187: putfield 438	com/tencent/tav/decoder/AudioDecoder$PendingFrame:seekStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   190: aload_0
    //   191: getfield 97	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   194: invokevirtual 266	java/util/ArrayList:size	()I
    //   197: ifne +9 -> 206
    //   200: aload 5
    //   202: iconst_1
    //   203: putfield 511	com/tencent/tav/decoder/AudioDecoder$PendingFrame:isFirst	Z
    //   206: aload_0
    //   207: getfield 97	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   210: aload 5
    //   212: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   215: pop
    //   216: aload_0
    //   217: getfield 140	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   220: invokevirtual 514	com/tencent/tav/extractor/AssetExtractor:advance	()Z
    //   223: pop
    //   224: goto -160 -> 64
    //   227: astore 5
    //   229: aload_0
    //   230: monitorexit
    //   231: aload 5
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	AudioDecoder
    //   45	73	1	i	int
    //   93	27	2	j	int
    //   9	144	3	l	long
    //   81	130	5	localObject1	Object
    //   227	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	227	finally
    //   41	46	227	finally
    //   50	64	227	finally
    //   67	72	227	finally
    //   76	94	227	finally
    //   98	206	227	finally
    //   206	216	227	finally
    //   216	224	227	finally
  }
  
  /* Error */
  private void releaseOutputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_m1
    //   9: if_icmpeq +17 -> 26
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 119	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   17: iconst_0
    //   18: invokespecial 426	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   21: aload_0
    //   22: iconst_m1
    //   23: putfield 119	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 117	com/tencent/tav/decoder/AudioDecoder:_outputBuffer	Ljava/nio/ByteBuffer;
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   39: goto -18 -> 21
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	AudioDecoder
    //   6	4	1	i	int
    //   34	2	2	localException	Exception
    //   42	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	21	34	java/lang/Exception
    //   2	7	42	finally
    //   12	21	42	finally
    //   21	26	42	finally
    //   26	31	42	finally
    //   35	39	42	finally
  }
  
  /* Error */
  private void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: invokevirtual 515	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   19: ldc_w 516
    //   22: aload_3
    //   23: invokestatic 314	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   26: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 21
    //   31: if_icmplt +106 -> 137
    //   34: aload_3
    //   35: instanceof 291
    //   38: ifeq +99 -> 137
    //   41: getstatic 280	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 23
    //   46: if_icmplt +68 -> 114
    //   49: aload_0
    //   50: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   53: new 63	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 316
    //   63: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: checkcast 291	android/media/MediaCodec$CodecException
    //   70: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   73: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   76: ldc_w 321
    //   79: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: checkcast 291	android/media/MediaCodec$CodecException
    //   86: invokevirtual 298	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   89: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: ldc_w 323
    //   95: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: checkcast 291	android/media/MediaCodec$CodecException
    //   102: invokevirtual 326	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   105: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_3
    //   115: checkcast 291	android/media/MediaCodec$CodecException
    //   118: invokevirtual 295	android/media/MediaCodec$CodecException:isTransient	()Z
    //   121: ifeq +16 -> 137
    //   124: aload_0
    //   125: ldc2_w 14
    //   128: invokespecial 332	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   131: aload_0
    //   132: iload_1
    //   133: iload_2
    //   134: invokespecial 426	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   137: aload_3
    //   138: athrow
    //   139: astore_3
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_3
    //   143: athrow
    //   144: astore_3
    //   145: goto -130 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	AudioDecoder
    //   0	148	1	paramInt	int
    //   0	148	2	paramBoolean	boolean
    //   14	124	3	localException	Exception
    //   139	4	3	localObject	Object
    //   144	1	3	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	11	14	java/lang/Exception
    //   2	11	139	finally
    //   15	114	139	finally
    //   114	137	139	finally
    //   137	139	139	finally
    //   2	11	144	java/lang/Error
  }
  
  private void reset()
  {
    try
    {
      boolean bool = this.isReleased;
      if (bool) {}
      for (;;)
      {
        return;
        Logger.d(this.TAG, "reset - ");
        try
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label68;
          }
          this.decoder.reset();
          decoderConfigure(this.mediaFormat);
          start();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        continue;
        try
        {
          this.decoder.stop();
          this.decoder.release();
          nameList.remove(this.decoder.toString());
          this.decoder = MediaCodec.createDecoderByType(this.mediaFormat.getString("mime"));
          nameList.add(this.decoder.toString());
          decoderConfigure(this.mediaFormat);
          start();
        }
        catch (Exception localException2)
        {
          break label75;
        }
      }
    }
    finally {}
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      return;
    }
    finally {}
  }
  
  private void start()
  {
    for (;;)
    {
      try
      {
        this.decoder.start();
        return;
      }
      catch (Exception localException)
      {
        Logger.e(this.TAG, "start", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(2L);
          start();
          continue;
        }
      }
      finally {}
      if (!((MediaCodec.CodecException)localObject).isRecoverable()) {
        break;
      }
      reset();
    }
    release();
    throw localObject;
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
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  protected void finalize()
  {
    super.finalize();
    release(false);
  }
  
  public AudioInfo getAudioInfo()
  {
    return this._audioInfo;
  }
  
  public String getSourcePath()
  {
    if (this.extractor == null) {
      return null;
    }
    return this.extractor.getSourcePath();
  }
  
  /* Error */
  public boolean hasTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_m1
    //   9: if_icmpeq +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	AudioDecoder
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public boolean isStarted()
  {
    return this.started;
  }
  
  public CMTime nextFrameTime()
  {
    if (this.pendingFrames.size() > 0) {}
    for (CMTime localCMTime = ((AudioDecoder.PendingFrame)this.pendingFrames.get(0)).frameTime;; localCMTime = CMTime.CMTimeInvalid)
    {
      Iterator localIterator = this.pendingFrames.iterator();
      while (localIterator.hasNext()) {
        localCMTime = CMTime.min(((AudioDecoder.PendingFrame)localIterator.next()).frameTime, localCMTime);
      }
    }
    return localCMTime;
  }
  
  public ByteBuffer outputBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = this._outputBuffer;
      return localByteBuffer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime readSample()
  {
    try
    {
      CMTime localCMTime = readSample(CMTime.CMTimeInvalid);
      return localCMTime;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime readSample(CMTime paramCMTime)
  {
    try
    {
      if (Logger.LOG_VERBOSE) {
        Logger.d(this.TAG, "readSample: " + paramCMTime + "  -  " + this.extractor.getSampleTime());
      }
      this.currentDecoderTime = doReadSample(paramCMTime, false);
      CMTime localCMTime = this.currentDecoderTime;
      if ((this.currentDecoderTime == SAMPLE_TIME_FINISH) || (this.currentDecoderTime == SAMPLE_TIME_TIMEOUT) || (!this.currentDecoderTime.smallThan(this.duration))) {
        clearDecoder();
      }
      if (Logger.LOG_VERBOSE) {
        Logger.i(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentDecoderTime, new Object[0]);
      }
      return localCMTime;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      release(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void release(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   18: new 63	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 588
    //   28: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 140	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 591	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 140	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 95	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 101	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   67: aload_0
    //   68: getfield 210	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   71: ifnull +14 -> 85
    //   74: new 593	com/tencent/tav/decoder/AudioDecoder$1
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 595	com/tencent/tav/decoder/AudioDecoder$1:<init>	(Lcom/tencent/tav/decoder/AudioDecoder;)V
    //   82: invokevirtual 596	com/tencent/tav/decoder/AudioDecoder$1:start	()V
    //   85: aload_0
    //   86: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   89: new 63	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 598
    //   99: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_1
    //   103: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: goto -101 -> 11
    //   115: astore_3
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_3
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	AudioDecoder
    //   0	120	1	paramBoolean	boolean
    //   6	2	2	bool	boolean
    //   115	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	115	finally
    //   14	41	115	finally
    //   45	57	115	finally
    //   57	85	115	finally
    //   85	112	115	finally
  }
  
  /* Error */
  public void seekTo(CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 346	com/tencent/tav/decoder/logger/Logger:LOG_VERBOSE	Z
    //   5: ifeq +66 -> 71
    //   8: aload_0
    //   9: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   12: new 63	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 601
    //   22: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: ldc_w 603
    //   32: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: ldc_w 447
    //   42: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 124	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   49: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc_w 447
    //   55: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 103	com/tencent/tav/decoder/AudioDecoder:currentDecoderTime	Lcom/tencent/tav/coremedia/CMTime;
    //   62: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 263	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 95	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   75: ifeq +11 -> 86
    //   78: aload_0
    //   79: getfield 99	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   82: iconst_m1
    //   83: if_icmpne +55 -> 138
    //   86: aload_0
    //   87: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   90: new 63	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 605
    //   100: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 95	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   107: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: ldc_w 607
    //   113: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 99	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   120: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc_w 609
    //   126: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 328	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: aload_1
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 380	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   144: lconst_0
    //   145: lcmp
    //   146: ifge +7 -> 153
    //   149: getstatic 91	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   152: astore_2
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 382	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   158: invokevirtual 504	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   161: aload_2
    //   162: invokevirtual 611	com/tencent/tav/coremedia/CMTime:add	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   165: putfield 124	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 131	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 124	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   178: invokevirtual 380	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   181: invokespecial 613	com/tencent/tav/decoder/AudioDecoder:seekExtractorTo	(J)V
    //   184: getstatic 346	com/tencent/tav/decoder/logger/Logger:LOG_VERBOSE	Z
    //   187: ifeq -52 -> 135
    //   190: aload_0
    //   191: getfield 86	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   194: new 63	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 615
    //   204: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_0
    //   208: getfield 124	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   211: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: ldc_w 447
    //   217: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 140	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   224: invokevirtual 487	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   227: invokevirtual 445	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 263	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: goto -101 -> 135
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	AudioDecoder
    //   0	244	1	paramCMTime	CMTime
    //   139	23	2	localCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	71	239	finally
    //   71	86	239	finally
    //   86	135	239	finally
    //   140	153	239	finally
    //   153	236	239	finally
  }
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    try
    {
      start(paramCMTimeRange, CMTime.CMTimeZero);
      return;
    }
    finally
    {
      paramCMTimeRange = finally;
      throw paramCMTimeRange;
    }
  }
  
  public void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    for (;;)
    {
      try
      {
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]");
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          return;
        }
        clearDecoder();
        if (paramCMTimeRange == null)
        {
          this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
          this.extractorDone = false;
          this.started = true;
          if (paramCMTime.getTimeUs() >= 0L) {
            seekTo(paramCMTime);
          }
        }
        else
        {
          this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */