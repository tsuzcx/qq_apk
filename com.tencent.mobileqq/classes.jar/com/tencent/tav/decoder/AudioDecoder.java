package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class AudioDecoder
  implements IAudioDecoder
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final int MAX_WAIT_TIME = 1000;
  private static final long WAIT_TRANSIENT_MS = 2L;
  private static final ArrayList<String> nameList = new ArrayList();
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private CMSampleState currentSampleState;
  private CMTime currentStartTime;
  private AudioInfo decodeAudioInfo;
  private ByteBuffer decodeBuffer;
  private MediaCodec decoder;
  private CMTime duration;
  private AssetExtractor extractor;
  private boolean extractorDone;
  private boolean isReleased;
  private int lastOutputBufferIndex;
  private long mLastVideoQueueTime;
  private long mTimeOffset;
  private MediaFormat mediaFormat;
  @Nullable
  private AudioInfo outputAudioInfo;
  private ByteBuffer outputBuffer;
  private CMTime pFrameTime;
  private ArrayList<AudioDecoder.PendingFrame> pendingFrames;
  private boolean started;
  private CMTimeRange timeRange;
  public int trackIndex;
  
  public AudioDecoder(IVideoDecoder.Params paramParams)
  {
    this(paramParams.filePath);
  }
  
  public AudioDecoder(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioDecoder@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.duration = CMTime.CMTimeZero;
    this.started = false;
    this.pendingFrames = new ArrayList();
    this.trackIndex = -1;
    this.isReleased = false;
    this.currentSampleState = new CMSampleState(CMTime.CMTimeZero);
    this.decodeAudioInfo = new AudioInfo();
    this.outputAudioInfo = null;
    this.decodeBuffer = null;
    this.outputBuffer = null;
    this.pFrameTime = new CMTime(20L, 600);
    this.lastOutputBufferIndex = -1;
    this.currentStartTime = CMTime.CMTimeInvalid;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.extractorDone = false;
    this.mTimeOffset = 0L;
    this.mLastVideoQueueTime = 0L;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      this.extractor = new AssetExtractor();
      this.extractor.setDataSource(paramString);
      while (this.extractor.getSampleTrackIndex() != -1)
      {
        paramString = this.extractor;
        paramString.unselectTrack(paramString.getSampleTrackIndex());
      }
      this.trackIndex = ExtractorUtils.getFirstTrackIndex(this.extractor, "audio/");
      int i = this.trackIndex;
      if (i == -1)
      {
        this.decodeBuffer = null;
        return;
      }
      this.extractor.selectTrack(i);
      this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
      this.duration = new CMTime((float)this.extractor.getAudioDuration() * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L));
      if (this.mediaFormat.containsKey("frame-rate")) {
        this.pFrameTime = new CMTime(600 / this.mediaFormat.getInteger("frame-rate"), 600);
      }
      this.decoder = MediaCodecManager.createDecoderByType(this.mediaFormat.getString("mime"));
      nameList.add(this.decoder.toString());
      if (decoderConfigure(this.mediaFormat))
      {
        start();
        this.decodeAudioInfo.sampleRate = this.mediaFormat.getInteger("sample-rate");
        this.decodeAudioInfo.channelCount = this.mediaFormat.getInteger("channel-count");
        paramString = new AudioInfo();
        paramString.channelCount = 1;
        paramString.sampleRate = 44100;
        paramString.pcmEncoding = 2;
        return;
      }
      throw new IllegalStateException("decoderConfigure failed!");
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("文件不存在：path = ");
    localStringBuilder.append(paramString);
    paramString = new RuntimeException(localStringBuilder.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void clearDecoder()
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearDecoder ");
    localStringBuilder.append(getSourcePath());
    Logger.v(str, localStringBuilder.toString());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone))
    {
      try
      {
        this.decoder.flush();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.pendingFrames.clear();
    }
    this.currentSampleState = new CMSampleState();
  }
  
  private boolean decoderConfigure(MediaFormat paramMediaFormat)
  {
    try
    {
      Object localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decoderConfigure() called with: inputFormat = [");
      localStringBuilder.append(paramMediaFormat);
      localStringBuilder.append("]");
      Logger.i((String)localObject, localStringBuilder.toString());
      if (Build.VERSION.SDK_INT < 21)
      {
        this.decoder.configure(paramMediaFormat, null, null, 0);
        paramMediaFormat = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decoderConfigure() called with: outputFormat = [");
        ((StringBuilder)localObject).append(this.decoder.getOutputFormat());
        ((StringBuilder)localObject).append("]");
        Logger.i(paramMediaFormat, ((StringBuilder)localObject).toString());
        return true;
      }
      int i = 0;
      for (;;)
      {
        int j = i + 1;
        try
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("createdDecoder---time---");
          localStringBuilder.append(j);
          Logger.d((String)localObject, localStringBuilder.toString());
          if (j > 10) {
            return false;
          }
          this.decoder.configure(paramMediaFormat, null, null, 0);
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("decoderConfigure() called with: outputFormat = [");
          localStringBuilder.append(this.decoder.getOutputFormat());
          localStringBuilder.append("]");
          Logger.i((String)localObject, localStringBuilder.toString());
          return true;
        }
        catch (Exception localException)
        {
          Logger.e(this.TAG, "decoderConfigure: ", localException);
          if ((localException instanceof MediaCodec.CodecException))
          {
            i = j;
            if (((MediaCodec.CodecException)localException).isTransient()) {
              continue;
            }
            if (((MediaCodec.CodecException)localException).isRecoverable())
            {
              i = j;
              continue;
            }
          }
          MediaCodecManager.releaseCodec(this.decoder);
          throw localException;
        }
      }
      throw paramMediaFormat;
    }
    finally {}
    for (;;) {}
  }
  
  /* Error */
  private int dequeueInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: ldc2_w 377
    //   9: invokevirtual 381	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: astore_2
    //   18: goto +159 -> 177
    //   21: astore_2
    //   22: goto +4 -> 26
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   30: ldc_w 382
    //   33: aload_2
    //   34: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   37: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   40: bipush 21
    //   42: if_icmplt +133 -> 175
    //   45: aload_2
    //   46: instanceof 363
    //   49: ifeq +126 -> 175
    //   52: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 23
    //   57: if_icmplt +92 -> 149
    //   60: aload_0
    //   61: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   64: astore_3
    //   65: new 75	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   72: astore 4
    //   74: aload 4
    //   76: ldc_w 384
    //   79: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: aload_2
    //   86: checkcast 363	android/media/MediaCodec$CodecException
    //   89: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   92: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 4
    //   98: ldc_w 389
    //   101: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: aload_2
    //   108: checkcast 363	android/media/MediaCodec$CodecException
    //   111: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   114: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 4
    //   120: ldc_w 391
    //   123: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: aload_2
    //   130: checkcast 363	android/media/MediaCodec$CodecException
    //   133: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   136: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: aload 4
    //   143: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 396	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_2
    //   150: checkcast 363	android/media/MediaCodec$CodecException
    //   153: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   156: ifeq +19 -> 175
    //   159: aload_0
    //   160: ldc2_w 14
    //   163: invokespecial 400	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   166: aload_0
    //   167: invokespecial 402	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   170: istore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: iload_1
    //   174: ireturn
    //   175: aload_2
    //   176: athrow
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	AudioDecoder
    //   12	162	1	i	int
    //   17	1	2	localObject	Object
    //   21	1	2	localError	java.lang.Error
    //   25	155	2	localException	Exception
    //   64	77	3	str	String
    //   72	70	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	13	17	finally
    //   26	149	17	finally
    //   149	171	17	finally
    //   175	177	17	finally
    //   2	13	21	java/lang/Error
    //   2	13	25	java/lang/Exception
  }
  
  /* Error */
  private int dequeueOutputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: aload_0
    //   7: getfield 150	com/tencent/tav/decoder/AudioDecoder:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   10: ldc2_w 377
    //   13: invokevirtual 406	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: astore_2
    //   22: goto +155 -> 177
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   30: ldc_w 407
    //   33: aload_2
    //   34: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   37: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   40: bipush 21
    //   42: if_icmplt +133 -> 175
    //   45: aload_2
    //   46: instanceof 363
    //   49: ifeq +126 -> 175
    //   52: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 23
    //   57: if_icmplt +92 -> 149
    //   60: aload_0
    //   61: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   64: astore_3
    //   65: new 75	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   72: astore 4
    //   74: aload 4
    //   76: ldc_w 384
    //   79: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: aload_2
    //   86: checkcast 363	android/media/MediaCodec$CodecException
    //   89: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   92: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 4
    //   98: ldc_w 389
    //   101: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: aload_2
    //   108: checkcast 363	android/media/MediaCodec$CodecException
    //   111: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   114: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 4
    //   120: ldc_w 391
    //   123: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: aload_2
    //   130: checkcast 363	android/media/MediaCodec$CodecException
    //   133: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   136: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: aload 4
    //   143: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 396	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_2
    //   150: checkcast 363	android/media/MediaCodec$CodecException
    //   153: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   156: ifeq +19 -> 175
    //   159: aload_0
    //   160: ldc2_w 14
    //   163: invokespecial 400	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   166: aload_0
    //   167: invokespecial 409	com/tencent/tav/decoder/AudioDecoder:dequeueOutputBuffer	()I
    //   170: istore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: iload_1
    //   174: ireturn
    //   175: aload_2
    //   176: athrow
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	AudioDecoder
    //   16	158	1	i	int
    //   21	1	2	localObject	Object
    //   25	155	2	localException	Exception
    //   64	77	3	str	String
    //   72	70	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	17	21	finally
    //   26	149	21	finally
    //   149	171	21	finally
    //   175	177	21	finally
    //   2	17	25	java/lang/Exception
  }
  
  private CMSampleState doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        paramCMTime = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReadSample - ");
        ((StringBuilder)localObject).append(this.extractor.getSourcePath());
        Logger.v(paramCMTime, ((StringBuilder)localObject).toString());
        paramCMTime = CMSampleState.fromError(-2L);
        if ((!this.started) || (this.trackIndex == -1)) {
          continue;
        }
        releaseOutputBuffer();
        l1 = -2L;
        i = 0;
        if (this.pendingFrames.size() <= 0)
        {
          paramBoolean = this.extractorDone;
          localObject = paramCMTime;
          l2 = l1;
          if (paramBoolean) {
            continue;
          }
        }
      }
      finally
      {
        Object localObject;
        long l1;
        int i;
        long l2;
        int j;
        boolean bool;
        continue;
        throw paramCMTime;
        continue;
        continue;
        paramBoolean = false;
        continue;
        paramBoolean = false;
        continue;
      }
      try
      {
        if (!this.extractorDone) {
          readFromExtractor();
        }
        j = dequeueOutputBuffer();
        if (j == -2)
        {
          localObject = this.decoder.getOutputFormat();
          if (((MediaFormat)localObject).containsKey("pcm-encoding"))
          {
            this.decodeAudioInfo.pcmEncoding = ((MediaFormat)localObject).getInteger("pcm-encoding");
          }
          else
          {
            Logger.w(this.TAG, "doReadSample: decodedAudioFormat.containsKey(\"pcm-encoding\") is false");
            this.decodeAudioInfo.pcmEncoding = 2;
          }
          if (((MediaFormat)localObject).containsKey("sample-rate")) {
            this.decodeAudioInfo.sampleRate = ((MediaFormat)localObject).getInteger("sample-rate");
          }
          if (((MediaFormat)localObject).containsKey("channel-count")) {
            this.decodeAudioInfo.channelCount = ((MediaFormat)localObject).getInteger("channel-count");
          }
        }
        else
        {
          if ((j >= 0) && (this.pendingFrames.size() > 0))
          {
            if (this.bufferInfo.flags == 4)
            {
              if (this.bufferInfo.size > 0)
              {
                this.pendingFrames.remove(0);
                this.lastOutputBufferIndex = j;
                paramCMTime = getOutputBuffer(j);
                if (paramCMTime != null)
                {
                  paramCMTime.position(this.bufferInfo.offset);
                  paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
                  this.decodeBuffer = paramCMTime;
                }
                else
                {
                  releaseOutputBuffer(j, false);
                  this.decodeBuffer = null;
                }
              }
              Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
              paramCMTime = CMSampleState.fromError(-1L);
              return paramCMTime;
            }
            paramCMTime = (AudioDecoder.PendingFrame)this.pendingFrames.remove(0);
            l1 = this.bufferInfo.presentationTimeUs - paramCMTime.timeOffset;
            localObject = new CMSampleState(new CMTime(l1, 1000000));
            if ((this.pendingFrames.size() == 0) && (this.extractorDone) && (paramCMTime.seekStartTime.getTimeUs() + 1000L >= this.duration.getTimeUs()))
            {
              localObject = new CMSampleState(this.duration);
            }
            else
            {
              if (paramCMTime.seekStartTime.getTimeUs() <= l1) {
                continue;
              }
              releaseOutputBuffer(j, false);
              paramCMTime = CMSampleState.fromError(-2L);
              continue;
            }
            if (this.bufferInfo.size > 0)
            {
              this.lastOutputBufferIndex = j;
              paramCMTime = getOutputBuffer(j);
              if (paramCMTime != null)
              {
                paramCMTime.position(this.bufferInfo.offset);
                paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
                this.decodeBuffer = paramCMTime;
                l2 = l1;
              }
              else
              {
                releaseOutputBuffer(j, false);
                paramCMTime = this.TAG;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("doReadSample:[error] ");
                ((StringBuilder)localObject).append(this.bufferInfo.size);
                ((StringBuilder)localObject).append(" byteBuffer==null");
                Logger.e(paramCMTime, ((StringBuilder)localObject).toString());
                paramCMTime = CMSampleState.fromError(-3L);
                return paramCMTime;
              }
            }
            else
            {
              releaseOutputBuffer(j, false);
              paramCMTime = CMSampleState.fromError(-2L);
            }
          }
          else
          {
            if (j >= 0)
            {
              if (this.bufferInfo.flags == 4)
              {
                Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM 2");
                paramCMTime = CMSampleState.fromError(-1L);
                return paramCMTime;
              }
              releaseOutputBuffer(j, false);
              paramCMTime = CMSampleState.fromError(-2L);
            }
            j = i + 1;
            i = j;
            if (j <= 1000) {
              continue;
            }
            localObject = CMSampleState.fromError(-4L);
            Logger.e(this.TAG, "doReadSample: [timeout] ");
            l2 = l1;
          }
          paramCMTime = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doReadSample:[success] ");
          localStringBuilder.append(this.extractorDone);
          localStringBuilder.append(" ");
          localStringBuilder.append(l2);
          localStringBuilder.append("  ");
          localStringBuilder.append(localObject);
          Logger.v(paramCMTime, localStringBuilder.toString());
          paramCMTime = (CMTime)localObject;
          if (this.extractorDone)
          {
            paramCMTime = (CMTime)localObject;
            if (l2 < 0L) {
              paramCMTime = CMSampleState.fromError(-1L);
            }
          }
          return paramCMTime;
        }
      }
      catch (Exception paramCMTime)
      {
        Logger.e(this.TAG, "doReadSample: error", paramCMTime);
        if ((Build.VERSION.SDK_INT >= 21) && ((paramCMTime instanceof MediaCodec.CodecException)) && (retryOnReadSampleError((MediaCodec.CodecException)paramCMTime)))
        {
          paramCMTime = CMSampleState.fromError(-3L, "catch exception, retry", paramCMTime);
          return paramCMTime;
        }
        paramCMTime = CMSampleState.fromError(-3L, "catch exception", paramCMTime);
        return paramCMTime;
      }
    }
    paramCMTime = this.TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doReadSample:[failed] !started || trackIndex == -1 ");
    paramBoolean = this.started;
    bool = true;
    if (!paramBoolean)
    {
      paramBoolean = true;
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" - ");
      if (this.trackIndex != -1) {
        break label1051;
      }
      paramBoolean = bool;
      ((StringBuilder)localObject).append(paramBoolean);
      Logger.e(paramCMTime, ((StringBuilder)localObject).toString());
      paramCMTime = CMSampleState.fromError(-100L);
      return paramCMTime;
    }
  }
  
  /* Error */
  private ByteBuffer getInputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 523	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: goto +160 -> 176
    //   19: astore_2
    //   20: goto +4 -> 24
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 524
    //   31: aload_2
    //   32: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   35: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   38: bipush 21
    //   40: if_icmplt +134 -> 174
    //   43: aload_2
    //   44: instanceof 363
    //   47: ifeq +127 -> 174
    //   50: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   53: bipush 23
    //   55: if_icmplt +92 -> 147
    //   58: aload_0
    //   59: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   62: astore_3
    //   63: new 75	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   70: astore 4
    //   72: aload 4
    //   74: ldc_w 384
    //   77: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 4
    //   83: aload_2
    //   84: checkcast 363	android/media/MediaCodec$CodecException
    //   87: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   90: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: ldc_w 389
    //   99: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 4
    //   105: aload_2
    //   106: checkcast 363	android/media/MediaCodec$CodecException
    //   109: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   112: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 391
    //   121: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 4
    //   127: aload_2
    //   128: checkcast 363	android/media/MediaCodec$CodecException
    //   131: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   134: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_3
    //   139: aload 4
    //   141: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 396	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_2
    //   148: checkcast 363	android/media/MediaCodec$CodecException
    //   151: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   154: ifeq +20 -> 174
    //   157: aload_0
    //   158: ldc2_w 14
    //   161: invokespecial 400	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   164: aload_0
    //   165: iload_1
    //   166: invokespecial 526	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   169: astore_2
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_2
    //   173: areturn
    //   174: aload_2
    //   175: athrow
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	AudioDecoder
    //   0	180	1	paramInt	int
    //   10	4	2	localByteBuffer1	ByteBuffer
    //   15	1	2	localObject	Object
    //   19	1	2	localError	java.lang.Error
    //   23	125	2	localException	Exception
    //   169	10	2	localByteBuffer2	ByteBuffer
    //   62	77	3	str	String
    //   70	70	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
    //   24	147	15	finally
    //   147	170	15	finally
    //   174	176	15	finally
    //   2	11	19	java/lang/Error
    //   2	11	23	java/lang/Exception
  }
  
  /* Error */
  private ByteBuffer getOutputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 528	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: goto +160 -> 176
    //   19: astore_2
    //   20: goto +4 -> 24
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 529
    //   31: aload_2
    //   32: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   35: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   38: bipush 21
    //   40: if_icmplt +134 -> 174
    //   43: aload_2
    //   44: instanceof 363
    //   47: ifeq +127 -> 174
    //   50: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   53: bipush 23
    //   55: if_icmplt +92 -> 147
    //   58: aload_0
    //   59: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   62: astore_3
    //   63: new 75	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   70: astore 4
    //   72: aload 4
    //   74: ldc_w 384
    //   77: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 4
    //   83: aload_2
    //   84: checkcast 363	android/media/MediaCodec$CodecException
    //   87: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   90: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: ldc_w 389
    //   99: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 4
    //   105: aload_2
    //   106: checkcast 363	android/media/MediaCodec$CodecException
    //   109: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   112: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 391
    //   121: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 4
    //   127: aload_2
    //   128: checkcast 363	android/media/MediaCodec$CodecException
    //   131: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   134: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_3
    //   139: aload 4
    //   141: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 396	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_2
    //   148: checkcast 363	android/media/MediaCodec$CodecException
    //   151: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   154: ifeq +20 -> 174
    //   157: aload_0
    //   158: ldc2_w 14
    //   161: invokespecial 400	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   164: aload_0
    //   165: iload_1
    //   166: invokespecial 443	com/tencent/tav/decoder/AudioDecoder:getOutputBuffer	(I)Ljava/nio/ByteBuffer;
    //   169: astore_2
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_2
    //   173: areturn
    //   174: aload_2
    //   175: athrow
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	AudioDecoder
    //   0	180	1	paramInt	int
    //   10	4	2	localByteBuffer1	ByteBuffer
    //   15	1	2	localObject	Object
    //   19	1	2	localError	java.lang.Error
    //   23	125	2	localException	Exception
    //   169	10	2	localByteBuffer2	ByteBuffer
    //   62	77	3	str	String
    //   70	70	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
    //   24	147	15	finally
    //   147	170	15	finally
    //   174	176	15	finally
    //   2	11	19	java/lang/Error
    //   2	11	23	java/lang/Exception
  }
  
  /* Error */
  private void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: iload_3
    //   9: lload 4
    //   11: iload 6
    //   13: invokevirtual 533	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore 7
    //   21: goto +172 -> 193
    //   24: astore 7
    //   26: goto +5 -> 31
    //   29: astore 7
    //   31: aload_0
    //   32: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   35: ldc_w 534
    //   38: aload 7
    //   40: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 21
    //   48: if_icmplt +142 -> 190
    //   51: aload 7
    //   53: instanceof 363
    //   56: ifeq +134 -> 190
    //   59: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 23
    //   64: if_icmplt +97 -> 161
    //   67: aload_0
    //   68: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   71: astore 8
    //   73: new 75	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   80: astore 9
    //   82: aload 9
    //   84: ldc_w 384
    //   87: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 9
    //   93: aload 7
    //   95: checkcast 363	android/media/MediaCodec$CodecException
    //   98: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   101: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 9
    //   107: ldc_w 389
    //   110: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 9
    //   116: aload 7
    //   118: checkcast 363	android/media/MediaCodec$CodecException
    //   121: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   124: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 9
    //   130: ldc_w 391
    //   133: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 9
    //   139: aload 7
    //   141: checkcast 363	android/media/MediaCodec$CodecException
    //   144: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   147: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 8
    //   153: aload 9
    //   155: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 396	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 7
    //   163: checkcast 363	android/media/MediaCodec$CodecException
    //   166: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   169: ifeq +21 -> 190
    //   172: aload_0
    //   173: ldc2_w 14
    //   176: invokespecial 400	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   179: aload_0
    //   180: iload_1
    //   181: iload_2
    //   182: iload_3
    //   183: lload 4
    //   185: iload 6
    //   187: invokespecial 535	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   190: aload 7
    //   192: athrow
    //   193: aload_0
    //   194: monitorexit
    //   195: aload 7
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	AudioDecoder
    //   0	198	1	paramInt1	int
    //   0	198	2	paramInt2	int
    //   0	198	3	paramInt3	int
    //   0	198	4	paramLong	long
    //   0	198	6	paramInt4	int
    //   19	1	7	localObject	Object
    //   24	1	7	localError	java.lang.Error
    //   29	167	7	localException	Exception
    //   71	81	8	str	String
    //   80	74	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
    //   31	161	19	finally
    //   161	190	19	finally
    //   190	193	19	finally
    //   2	16	24	java/lang/Error
    //   2	16	29	java/lang/Exception
  }
  
  private void readFromExtractor()
  {
    try
    {
      long l = this.extractor.getSampleTime();
      int i;
      if ((l < this.timeRange.getEndUs()) && (this.extractor.getSampleTrackIndex() != -1) && (l != -1L))
      {
        i = dequeueInputBuffer();
        if (i >= 0)
        {
          Object localObject1 = getInputBuffer(i);
          int j = this.extractor.readSampleData((ByteBuffer)localObject1, 0);
          if (j >= 0)
          {
            this.mLastVideoQueueTime = (l - this.timeRange.getStartUs() + this.mTimeOffset);
            queueInputBuffer(i, 0, j, this.mLastVideoQueueTime, 0);
            localObject1 = new AudioDecoder.PendingFrame();
            ((AudioDecoder.PendingFrame)localObject1).timeOffset = this.mTimeOffset;
            ((AudioDecoder.PendingFrame)localObject1).frameTime = new CMTime((float)l * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L));
            ((AudioDecoder.PendingFrame)localObject1).seekStartTime = this.currentStartTime.sub(this.timeRange.getStart());
            if (this.pendingFrames.size() == 0) {
              ((AudioDecoder.PendingFrame)localObject1).isFirst = true;
            }
            this.pendingFrames.add(localObject1);
          }
          this.extractor.advance();
        }
      }
      else
      {
        i = dequeueInputBuffer();
        if (i >= 0)
        {
          queueInputBuffer(i, 0, 0, 0L, 4);
          this.extractorDone = true;
        }
      }
      return;
    }
    finally {}
  }
  
  private void releaseOutputBuffer()
  {
    try
    {
      int i = this.lastOutputBufferIndex;
      if (i != -1)
      {
        try
        {
          releaseOutputBuffer(this.lastOutputBufferIndex, false);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.lastOutputBufferIndex = -1;
      }
      this.decodeBuffer = null;
      return;
    }
    finally {}
  }
  
  /* Error */
  private void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: invokevirtual 571	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_3
    //   15: goto +158 -> 173
    //   18: astore_3
    //   19: goto +4 -> 23
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   27: ldc_w 572
    //   30: aload_3
    //   31: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   34: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 21
    //   39: if_icmplt +132 -> 171
    //   42: aload_3
    //   43: instanceof 363
    //   46: ifeq +125 -> 171
    //   49: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 23
    //   54: if_icmplt +94 -> 148
    //   57: aload_0
    //   58: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   61: astore 4
    //   63: new 75	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   70: astore 5
    //   72: aload 5
    //   74: ldc_w 384
    //   77: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 5
    //   83: aload_3
    //   84: checkcast 363	android/media/MediaCodec$CodecException
    //   87: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   90: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 5
    //   96: ldc_w 389
    //   99: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 5
    //   105: aload_3
    //   106: checkcast 363	android/media/MediaCodec$CodecException
    //   109: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   112: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: ldc_w 391
    //   121: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 5
    //   127: aload_3
    //   128: checkcast 363	android/media/MediaCodec$CodecException
    //   131: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   134: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: aload 5
    //   142: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 396	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_3
    //   149: checkcast 363	android/media/MediaCodec$CodecException
    //   152: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   155: ifeq +16 -> 171
    //   158: aload_0
    //   159: ldc2_w 14
    //   162: invokespecial 400	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   165: aload_0
    //   166: iload_1
    //   167: iload_2
    //   168: invokespecial 458	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   171: aload_3
    //   172: athrow
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_3
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	AudioDecoder
    //   0	177	1	paramInt	int
    //   0	177	2	paramBoolean	boolean
    //   14	1	3	localObject	Object
    //   18	1	3	localError	java.lang.Error
    //   22	154	3	localException	Exception
    //   61	78	4	str	String
    //   70	71	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
    //   23	148	14	finally
    //   148	171	14	finally
    //   171	173	14	finally
    //   2	11	18	java/lang/Error
    //   2	11	22	java/lang/Exception
  }
  
  /* Error */
  private void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 113	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   18: ldc_w 575
    //   21: invokestatic 355	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 21
    //   29: if_icmplt +26 -> 55
    //   32: aload_0
    //   33: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   36: invokevirtual 577	android/media/MediaCodec:reset	()V
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 201	com/tencent/tav/decoder/AudioDecoder:mediaFormat	Landroid/media/MediaFormat;
    //   44: invokespecial 253	com/tencent/tav/decoder/AudioDecoder:decoderConfigure	(Landroid/media/MediaFormat;)Z
    //   47: pop
    //   48: aload_0
    //   49: invokespecial 256	com/tencent/tav/decoder/AudioDecoder:start	()V
    //   52: goto +89 -> 141
    //   55: aload_0
    //   56: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   59: invokevirtual 580	android/media/MediaCodec:stop	()V
    //   62: aload_0
    //   63: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   66: invokestatic 373	com/tencent/tav/decoder/MediaCodecManager:releaseCodec	(Landroid/media/MediaCodec;)V
    //   69: getstatic 62	com/tencent/tav/decoder/AudioDecoder:nameList	Ljava/util/ArrayList;
    //   72: aload_0
    //   73: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   76: invokevirtual 245	java/lang/Object:toString	()Ljava/lang/String;
    //   79: invokevirtual 582	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 201	com/tencent/tav/decoder/AudioDecoder:mediaFormat	Landroid/media/MediaFormat;
    //   88: ldc 232
    //   90: invokevirtual 236	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokestatic 242	com/tencent/tav/decoder/MediaCodecManager:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   96: putfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   99: getstatic 62	com/tencent/tav/decoder/AudioDecoder:nameList	Ljava/util/ArrayList;
    //   102: aload_0
    //   103: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   106: invokevirtual 245	java/lang/Object:toString	()Ljava/lang/String;
    //   109: invokevirtual 249	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   112: pop
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 201	com/tencent/tav/decoder/AudioDecoder:mediaFormat	Landroid/media/MediaFormat;
    //   118: invokespecial 253	com/tencent/tav/decoder/AudioDecoder:decoderConfigure	(Landroid/media/MediaFormat;)Z
    //   121: pop
    //   122: aload_0
    //   123: invokespecial 256	com/tencent/tav/decoder/AudioDecoder:start	()V
    //   126: goto +15 -> 141
    //   129: astore_2
    //   130: aload_0
    //   131: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   134: ldc_w 584
    //   137: aload_2
    //   138: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: astore_2
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: goto -88 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	AudioDecoder
    //   6	2	1	bool	boolean
    //   129	9	2	localException1	Exception
    //   144	4	2	localObject	Object
    //   149	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	52	129	java/lang/Exception
    //   62	126	129	java/lang/Exception
    //   2	7	144	finally
    //   14	24	144	finally
    //   24	52	144	finally
    //   55	62	144	finally
    //   62	126	144	finally
    //   130	141	144	finally
    //   55	62	149	java/lang/Exception
  }
  
  @RequiresApi(api=21)
  private boolean retryOnReadSampleError(MediaCodec.CodecException paramCodecException)
  {
    if (paramCodecException.isRecoverable())
    {
      releaseOutputBuffer();
      reset();
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      long l1 = this.currentStartTime.getTimeUs();
      long l2 = this.timeRange.getStartUs();
      this.extractor.seekTo(l1 - l2, 0);
      this.extractorDone = false;
      return false;
    }
    if (paramCodecException.isTransient()) {
      return false;
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    return true;
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
  
  /* Error */
  private void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 244	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   6: invokevirtual 600	android/media/MediaCodec:start	()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: goto +166 -> 179
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   21: ldc_w 601
    //   24: aload_1
    //   25: invokestatic 361	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   28: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   31: bipush 21
    //   33: if_icmplt +140 -> 173
    //   36: aload_1
    //   37: instanceof 363
    //   40: ifeq +133 -> 173
    //   43: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 23
    //   48: if_icmplt +84 -> 132
    //   51: aload_0
    //   52: getfield 98	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   55: astore_2
    //   56: new 75	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   63: astore_3
    //   64: aload_3
    //   65: ldc_w 384
    //   68: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: aload_1
    //   74: checkcast 363	android/media/MediaCodec$CodecException
    //   77: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   80: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: ldc_w 389
    //   88: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: aload_1
    //   94: checkcast 363	android/media/MediaCodec$CodecException
    //   97: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   100: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: ldc_w 391
    //   108: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: aload_1
    //   114: checkcast 363	android/media/MediaCodec$CodecException
    //   117: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   120: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_2
    //   125: aload_3
    //   126: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 396	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_1
    //   133: checkcast 363	android/media/MediaCodec$CodecException
    //   136: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   139: ifeq +17 -> 156
    //   142: aload_0
    //   143: ldc2_w 14
    //   146: invokespecial 400	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   149: aload_0
    //   150: invokespecial 256	com/tencent/tav/decoder/AudioDecoder:start	()V
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: aload_1
    //   157: checkcast 363	android/media/MediaCodec$CodecException
    //   160: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   163: ifeq +10 -> 173
    //   166: aload_0
    //   167: invokespecial 588	com/tencent/tav/decoder/AudioDecoder:reset	()V
    //   170: aload_0
    //   171: monitorexit
    //   172: return
    //   173: aload_0
    //   174: invokevirtual 604	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   177: aload_1
    //   178: athrow
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	AudioDecoder
    //   12	1	1	localObject	Object
    //   16	166	1	localException	Exception
    //   55	70	2	str	String
    //   63	63	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
    //   17	132	12	finally
    //   132	153	12	finally
    //   156	170	12	finally
    //   173	179	12	finally
    //   2	9	16	java/lang/Exception
  }
  
  /* Error */
  private void waitTime(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: invokevirtual 609	java/lang/Object:wait	(J)V
    //   7: goto +12 -> 19
    //   10: astore_3
    //   11: goto +11 -> 22
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 610	java/lang/InterruptedException:printStackTrace	()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_3
    //   25: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	AudioDecoder
    //   0	26	1	paramLong	long
    //   10	1	3	localObject	Object
    //   14	11	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
    //   15	19	10	finally
    //   2	7	14	java/lang/InterruptedException
  }
  
  protected void finalize()
  {
    super.finalize();
    release(false);
  }
  
  public AudioInfo getAudioInfo()
  {
    AudioInfo localAudioInfo = this.outputAudioInfo;
    if (localAudioInfo != null) {
      return localAudioInfo;
    }
    return this.decodeAudioInfo;
  }
  
  public String getSourcePath()
  {
    AssetExtractor localAssetExtractor = this.extractor;
    if (localAssetExtractor == null) {
      return null;
    }
    return localAssetExtractor.getSourcePath();
  }
  
  public boolean hasTrack()
  {
    try
    {
      int i = this.trackIndex;
      boolean bool;
      if (i != -1) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isStarted()
  {
    return this.started;
  }
  
  public CMTime nextFrameTime()
  {
    CMTime localCMTime;
    if (this.pendingFrames.size() > 0) {
      localCMTime = ((AudioDecoder.PendingFrame)this.pendingFrames.get(0)).frameTime;
    } else {
      localCMTime = CMTime.CMTimeInvalid;
    }
    Iterator localIterator = this.pendingFrames.iterator();
    while (localIterator.hasNext()) {
      localCMTime = CMTime.min(((AudioDecoder.PendingFrame)localIterator.next()).frameTime, localCMTime);
    }
    return localCMTime;
  }
  
  public ByteBuffer outputBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = this.decodeBuffer;
      if (localByteBuffer == null) {
        return null;
      }
      if (this.outputBuffer == null)
      {
        localByteBuffer = this.decodeBuffer;
        return localByteBuffer;
      }
      localByteBuffer = this.outputBuffer;
      return localByteBuffer;
    }
    finally {}
  }
  
  public CMSampleState readSample(CMTime paramCMTime)
  {
    try
    {
      Object localObject1 = this.TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("readSample: ");
      ((StringBuilder)localObject2).append(paramCMTime);
      ((StringBuilder)localObject2).append("  -  ");
      ((StringBuilder)localObject2).append(this.extractor.getSampleTime());
      Logger.v((String)localObject1, ((StringBuilder)localObject2).toString());
      this.currentSampleState = doReadSample(paramCMTime, false);
      localObject1 = this.currentSampleState;
      if ((this.currentSampleState.stateMatchingTo(new long[] { -1L, -4L })) || (!this.currentSampleState.getTime().smallThan(this.duration))) {
        clearDecoder();
      }
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readSample: finish ");
      localStringBuilder.append(paramCMTime);
      localStringBuilder.append("  -  ");
      localStringBuilder.append(this.currentSampleState);
      Logger.v((String)localObject2, localStringBuilder.toString());
      return localObject1;
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
  
  public void release(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.isReleased;
      if (bool) {
        return;
      }
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release:start ");
      localStringBuilder.append(paramBoolean);
      Logger.d(str, localStringBuilder.toString());
      if (paramBoolean)
      {
        this.extractor.dispose();
        this.extractor = null;
      }
      this.started = false;
      this.isReleased = true;
      if (this.decoder != null) {
        ThreadPool.execute(new AudioDecoder.1(this));
      }
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("release:end ");
      localStringBuilder.append(paramBoolean);
      Logger.d(str, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public void seekTo(CMTime paramCMTime)
  {
    try
    {
      Object localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekTo: ");
      localStringBuilder.append(paramCMTime);
      localStringBuilder.append("  - ");
      localStringBuilder.append(this);
      localStringBuilder.append("  ");
      localStringBuilder.append(this.currentStartTime);
      localStringBuilder.append("  ");
      localStringBuilder.append(this.currentSampleState);
      Logger.v((String)localObject, localStringBuilder.toString());
      if ((this.started) && (this.trackIndex != -1))
      {
        localObject = paramCMTime;
        if (paramCMTime.getTimeUs() < 0L) {
          localObject = CMTime.CMTimeZero;
        }
        this.currentStartTime = this.timeRange.getStart().add((CMTime)localObject);
        this.extractorDone = false;
        seekExtractorTo(this.currentStartTime.getTimeUs());
        paramCMTime = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("seekTo: finish - ");
        ((StringBuilder)localObject).append(this.currentStartTime);
        ((StringBuilder)localObject).append("  ");
        ((StringBuilder)localObject).append(this.extractor.getSampleTime());
        Logger.v(paramCMTime, ((StringBuilder)localObject).toString());
        return;
      }
      paramCMTime = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("seekTo:failed [started ");
      ((StringBuilder)localObject).append(this.started);
      ((StringBuilder)localObject).append("] [trackIndex ");
      ((StringBuilder)localObject).append(this.trackIndex);
      ((StringBuilder)localObject).append("]");
      Logger.e(paramCMTime, ((StringBuilder)localObject).toString());
      return;
    }
    finally {}
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
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start:");
      localStringBuilder.append(getSourcePath());
      localStringBuilder.append(" [timeRange ");
      localStringBuilder.append(paramCMTimeRange);
      localStringBuilder.append("] [start ");
      localStringBuilder.append(paramCMTime);
      localStringBuilder.append("]");
      Logger.d(str, localStringBuilder.toString());
      if (this.trackIndex == -1)
      {
        Logger.e(this.TAG, "start: trackIndex == -1");
        return;
      }
      clearDecoder();
      if (paramCMTimeRange == null) {
        this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
      } else {
        this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
      }
      this.extractorDone = false;
      this.started = true;
      if (paramCMTime.getTimeUs() >= 0L) {
        seekTo(paramCMTime);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */