package com.tencent.tavcut.render.audio.wave;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.utils.TimeUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor;", "Lcom/tencent/tavcut/render/audio/wave/IAudioWaveDataProcessor;", "()V", "audioDecoder", "Landroid/media/MediaCodec;", "audioPath", "", "channelCount", "", "dataCaptureListener", "Lcom/tencent/tavcut/render/audio/wave/IWaveDataCaptureListener;", "encodingPcmBit", "gapDurationUs", "", "lastNotifyTime", "mediaExtractor", "Landroid/media/MediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "sampleRate", "startTime", "trackIndex", "waveDataCalculator", "Lcom/tencent/tavcut/render/audio/wave/AudioWaveDataCalculator;", "decodeAudio", "", "decodeForWaveData", "path", "perSecondSampleCnt", "listener", "handleInputBufferIndex", "", "inputBufIndex", "handleOutputBufferIndex", "outputBufferIndex", "audioBufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "notifyDecodeError", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "notifyWaveData", "data", "", "", "prepare", "processWaveData", "pcmByteBuffer", "Ljava/nio/ByteBuffer;", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MediaCodecAudioWaveDataProcessor
  implements IAudioWaveDataProcessor
{
  public static final MediaCodecAudioWaveDataProcessor.Companion a = new MediaCodecAudioWaveDataProcessor.Companion(null);
  private MediaExtractor b;
  private MediaCodec c;
  private MediaFormat d;
  private String e = "";
  private int f;
  private int g;
  private int h = -1;
  private IWaveDataCaptureListener i;
  private long j;
  private long k;
  private int l = 2;
  private long m;
  private AudioWaveDataCalculator n;
  
  private final void a(Exception paramException)
  {
    IWaveDataCaptureListener localIWaveDataCaptureListener = this.i;
    if (localIWaveDataCaptureListener != null)
    {
      paramException = paramException.getMessage();
      if (paramException == null) {
        paramException = "";
      }
      localIWaveDataCaptureListener.a(3, paramException);
    }
  }
  
  private final void a(ByteBuffer paramByteBuffer)
  {
    AudioWaveDataCalculator localAudioWaveDataCalculator = this.n;
    if (localAudioWaveDataCalculator == null) {
      Intrinsics.throwUninitializedPropertyAccessException("waveDataCalculator");
    }
    a(localAudioWaveDataCalculator.a(paramByteBuffer));
  }
  
  private final void a(List<Float> paramList)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.k >= TimeUtils.a.a(this.m))
    {
      IWaveDataCaptureListener localIWaveDataCaptureListener = this.i;
      if (localIWaveDataCaptureListener != null) {
        localIWaveDataCaptureListener.a(paramList);
      }
      this.k = l1;
    }
  }
  
  private final boolean a()
  {
    for (;;)
    {
      try
      {
        this.b = new MediaExtractor();
        Object localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        ((MediaExtractor)localObject1).setDataSource(this.e);
        localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        int i3 = ((MediaExtractor)localObject1).getTrackCount();
        int i1 = 0;
        if (i1 < i3)
        {
          localObject1 = this.b;
          if (localObject1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
          }
          localObject1 = ((MediaExtractor)localObject1).getTrackFormat(i1);
          Object localObject2 = ((MediaFormat)localObject1).getString("mime");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "mime");
          if (((CharSequence)localObject2).length() > 0)
          {
            i2 = 1;
            if (i2 != 0)
            {
              i2 = 2;
              if (StringsKt.startsWith$default((String)localObject2, "audio/", false, 2, null))
              {
                this.h = i1;
                localObject2 = this.b;
                if (localObject2 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
                }
                ((MediaExtractor)localObject2).selectTrack(i1);
                this.f = ((MediaFormat)localObject1).getInteger("sample-rate");
                this.g = ((MediaFormat)localObject1).getInteger("channel-count");
                if (((MediaFormat)localObject1).containsKey("pcm-encoding"))
                {
                  i1 = i2;
                  if (Build.VERSION.SDK_INT >= 24) {
                    i1 = ((MediaFormat)localObject1).getInteger("pcm-encoding");
                  }
                  this.l = i1;
                }
                Intrinsics.checkExpressionValueIsNotNull(localObject1, "format");
                this.d = ((MediaFormat)localObject1);
                return true;
              }
            }
            i1 += 1;
          }
        }
        else
        {
          return false;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        TavLogger.a("MediaCodecAudioWaveDataProcessor", "Fail to init MediaExtractor", (Throwable)localIllegalArgumentException);
        return false;
      }
      catch (IOException localIOException)
      {
        TavLogger.a("MediaCodecAudioWaveDataProcessor", "Fail to init MediaExtractor", (Throwable)localIOException);
        return false;
      }
      int i2 = 0;
    }
  }
  
  private final boolean a(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
      }
      localObject = ((MediaCodec)localObject).getInputBuffer(paramInt);
      if (localObject != null)
      {
        MediaExtractor localMediaExtractor = this.b;
        if (localMediaExtractor == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        int i1 = localMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
        if (i1 <= 0)
        {
          localObject = this.c;
          if (localObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
          }
          ((MediaCodec)localObject).queueInputBuffer(paramInt, 0, 0, 0L, 4);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decode saw inputEOS EOS; audio path = ");
          ((StringBuilder)localObject).append(this.e);
          TavLogger.b("MediaCodecAudioWaveDataProcessor", ((StringBuilder)localObject).toString());
          return true;
        }
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
        }
        localMediaExtractor = this.b;
        if (localMediaExtractor == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        ((MediaCodec)localObject).queueInputBuffer(paramInt, 0, i1, localMediaExtractor.getSampleTime(), 0);
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
        }
        ((MediaExtractor)localObject).advance();
      }
    }
    return false;
  }
  
  private final boolean a(int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    Object localObject;
    if (paramInt >= 0)
    {
      if ((paramBufferInfo.flags & 0x2) != 0)
      {
        paramBufferInfo = this.c;
        if (paramBufferInfo == null) {
          Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
        }
        paramBufferInfo.releaseOutputBuffer(paramInt, false);
        return false;
      }
      if (paramBufferInfo.size != 0)
      {
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
        }
        localObject = ((MediaCodec)localObject).getOutputBuffer(paramInt);
        if (localObject != null)
        {
          ((ByteBuffer)localObject).position(paramBufferInfo.offset);
          ((ByteBuffer)localObject).limit(paramBufferInfo.offset + paramBufferInfo.size);
          a((ByteBuffer)localObject);
          ((ByteBuffer)localObject).clear();
        }
      }
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
      }
      ((MediaCodec)localObject).releaseOutputBuffer(paramInt, false);
      if ((paramBufferInfo.flags & 0x4) != 0)
      {
        TavLogger.b("MediaCodecAudioWaveDataProcessor", "saw output EOS.");
        return true;
      }
    }
    else
    {
      if (paramInt == -3)
      {
        TavLogger.b("MediaCodecAudioWaveDataProcessor", "output buffers have changed.");
        return false;
      }
      if (paramInt == -2)
      {
        paramBufferInfo = new StringBuilder();
        paramBufferInfo.append("output format has changed to ");
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("audioDecoder");
        }
        paramBufferInfo.append(((MediaCodec)localObject).getOutputFormat());
        TavLogger.b("MediaCodecAudioWaveDataProcessor", paramBufferInfo.toString());
        return false;
      }
      if (paramInt == -1) {
        TavLogger.b("MediaCodecAudioWaveDataProcessor", "INFO_TRY_AGAIN_LATER");
      }
    }
    return false;
  }
  
  /* Error */
  private final void b()
  {
    // Byte code:
    //   0: new 261	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc_w 337
    //   14: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_0
    //   19: getfield 230	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:d	Landroid/media/MediaFormat;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnonnull +9 -> 35
    //   29: ldc_w 338
    //   32: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   35: aload 4
    //   37: aload 5
    //   39: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc 232
    //   45: aload 4
    //   47: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 340	com/tencent/tavcut/render/log/TavLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 230	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:d	Landroid/media/MediaFormat;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnonnull +9 -> 70
    //   64: ldc_w 338
    //   67: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   70: aload 4
    //   72: ldc 176
    //   74: invokevirtual 182	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 344	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   80: astore 4
    //   82: aload 4
    //   84: ldc_w 346
    //   87: invokestatic 186	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload_0
    //   91: aload 4
    //   93: putfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   96: aload_0
    //   97: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   100: astore 4
    //   102: aload 4
    //   104: ifnonnull +8 -> 112
    //   107: ldc 245
    //   109: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   112: aload_0
    //   113: getfield 230	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:d	Landroid/media/MediaFormat;
    //   116: astore 5
    //   118: aload 5
    //   120: ifnonnull +9 -> 129
    //   123: ldc_w 338
    //   126: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   129: iconst_0
    //   130: istore_2
    //   131: aload 4
    //   133: aload 5
    //   135: aconst_null
    //   136: aconst_null
    //   137: iconst_0
    //   138: invokevirtual 350	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   141: aload_0
    //   142: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   145: astore 4
    //   147: aload 4
    //   149: ifnonnull +8 -> 157
    //   152: ldc 245
    //   154: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   157: aload 4
    //   159: invokevirtual 353	android/media/MediaCodec:start	()V
    //   162: new 283	android/media/MediaCodec$BufferInfo
    //   165: dup
    //   166: invokespecial 354	android/media/MediaCodec$BufferInfo:<init>	()V
    //   169: astore 4
    //   171: iconst_0
    //   172: istore_1
    //   173: iload_2
    //   174: ifne +78 -> 252
    //   177: iload_1
    //   178: istore_2
    //   179: iload_1
    //   180: ifne +32 -> 212
    //   183: aload_0
    //   184: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   187: astore 5
    //   189: aload 5
    //   191: ifnonnull +8 -> 199
    //   194: ldc 245
    //   196: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   199: aload_0
    //   200: aload 5
    //   202: ldc2_w 355
    //   205: invokevirtual 360	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   208: invokespecial 362	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:a	(I)Z
    //   211: istore_2
    //   212: aload_0
    //   213: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   216: astore 5
    //   218: aload 5
    //   220: ifnonnull +8 -> 228
    //   223: ldc 245
    //   225: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   228: aload_0
    //   229: aload 5
    //   231: aload 4
    //   233: ldc2_w 363
    //   236: invokevirtual 368	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   239: aload 4
    //   241: invokespecial 370	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:a	(ILandroid/media/MediaCodec$BufferInfo;)Z
    //   244: istore_3
    //   245: iload_2
    //   246: istore_1
    //   247: iload_3
    //   248: istore_2
    //   249: goto -76 -> 173
    //   252: aload_0
    //   253: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   256: astore 4
    //   258: aload 4
    //   260: ifnonnull +8 -> 268
    //   263: ldc 245
    //   265: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   268: aload 4
    //   270: invokevirtual 373	android/media/MediaCodec:stop	()V
    //   273: aload_0
    //   274: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   277: astore 4
    //   279: aload 4
    //   281: ifnonnull +8 -> 289
    //   284: ldc 245
    //   286: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   289: aload 4
    //   291: invokevirtual 376	android/media/MediaCodec:release	()V
    //   294: aload_0
    //   295: getfield 162	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:b	Landroid/media/MediaExtractor;
    //   298: astore 5
    //   300: aload 5
    //   302: astore 4
    //   304: aload 5
    //   306: ifnonnull +199 -> 505
    //   309: aload 5
    //   311: astore 4
    //   313: goto +187 -> 500
    //   316: astore 4
    //   318: goto +324 -> 642
    //   321: astore 4
    //   323: goto +8 -> 331
    //   326: astore 4
    //   328: goto +89 -> 417
    //   331: ldc 232
    //   333: ldc_w 378
    //   336: aload 4
    //   338: checkcast 236	java/lang/Throwable
    //   341: invokestatic 241	com/tencent/tavcut/render/log/TavLogger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   344: aload_0
    //   345: aload 4
    //   347: checkcast 106	java/lang/Exception
    //   350: invokespecial 380	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:a	(Ljava/lang/Exception;)V
    //   353: aload_0
    //   354: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   357: astore 4
    //   359: aload 4
    //   361: ifnonnull +8 -> 369
    //   364: ldc 245
    //   366: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   369: aload 4
    //   371: invokevirtual 373	android/media/MediaCodec:stop	()V
    //   374: aload_0
    //   375: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   378: astore 4
    //   380: aload 4
    //   382: ifnonnull +8 -> 390
    //   385: ldc 245
    //   387: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   390: aload 4
    //   392: invokevirtual 376	android/media/MediaCodec:release	()V
    //   395: aload_0
    //   396: getfield 162	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:b	Landroid/media/MediaExtractor;
    //   399: astore 5
    //   401: aload 5
    //   403: astore 4
    //   405: aload 5
    //   407: ifnonnull +98 -> 505
    //   410: aload 5
    //   412: astore 4
    //   414: goto +86 -> 500
    //   417: ldc 232
    //   419: ldc_w 378
    //   422: aload 4
    //   424: checkcast 236	java/lang/Throwable
    //   427: invokestatic 241	com/tencent/tavcut/render/log/TavLogger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   430: aload_0
    //   431: aload 4
    //   433: checkcast 106	java/lang/Exception
    //   436: invokespecial 380	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:a	(Ljava/lang/Exception;)V
    //   439: aload_0
    //   440: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   443: astore 4
    //   445: aload 4
    //   447: ifnonnull +8 -> 455
    //   450: ldc 245
    //   452: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   455: aload 4
    //   457: invokevirtual 373	android/media/MediaCodec:stop	()V
    //   460: aload_0
    //   461: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   464: astore 4
    //   466: aload 4
    //   468: ifnonnull +8 -> 476
    //   471: ldc 245
    //   473: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   476: aload 4
    //   478: invokevirtual 376	android/media/MediaCodec:release	()V
    //   481: aload_0
    //   482: getfield 162	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:b	Landroid/media/MediaExtractor;
    //   485: astore 5
    //   487: aload 5
    //   489: astore 4
    //   491: aload 5
    //   493: ifnonnull +12 -> 505
    //   496: aload 5
    //   498: astore 4
    //   500: ldc 163
    //   502: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   505: aload 4
    //   507: invokevirtual 381	android/media/MediaExtractor:release	()V
    //   510: new 261	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   517: astore 4
    //   519: aload 4
    //   521: ldc_w 383
    //   524: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 4
    //   530: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   533: aload_0
    //   534: getfield 385	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:j	J
    //   537: lsub
    //   538: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 4
    //   544: ldc_w 390
    //   547: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 4
    //   553: ldc_w 392
    //   556: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload_0
    //   561: getfield 101	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:n	Lcom/tencent/tavcut/render/audio/wave/AudioWaveDataCalculator;
    //   564: astore 5
    //   566: aload 5
    //   568: ifnonnull +8 -> 576
    //   571: ldc 117
    //   573: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   576: aload 4
    //   578: aload 5
    //   580: invokevirtual 395	com/tencent/tavcut/render/audio/wave/AudioWaveDataCalculator:a	()Ljava/util/List;
    //   583: invokeinterface 399 1 0
    //   588: invokevirtual 402	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: ldc 232
    //   594: aload 4
    //   596: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 274	com/tencent/tavcut/render/log/TavLogger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload_0
    //   603: getfield 104	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:i	Lcom/tencent/tavcut/render/audio/wave/IWaveDataCaptureListener;
    //   606: astore 4
    //   608: aload 4
    //   610: ifnull +31 -> 641
    //   613: aload_0
    //   614: getfield 101	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:n	Lcom/tencent/tavcut/render/audio/wave/AudioWaveDataCalculator;
    //   617: astore 5
    //   619: aload 5
    //   621: ifnonnull +8 -> 629
    //   624: ldc 117
    //   626: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   629: aload 4
    //   631: aload 5
    //   633: invokevirtual 395	com/tencent/tavcut/render/audio/wave/AudioWaveDataCalculator:a	()Ljava/util/List;
    //   636: invokeinterface 404 2 0
    //   641: return
    //   642: aload_0
    //   643: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   646: astore 5
    //   648: aload 5
    //   650: ifnonnull +8 -> 658
    //   653: ldc 245
    //   655: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   658: aload 5
    //   660: invokevirtual 373	android/media/MediaCodec:stop	()V
    //   663: aload_0
    //   664: getfield 244	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:c	Landroid/media/MediaCodec;
    //   667: astore 5
    //   669: aload 5
    //   671: ifnonnull +8 -> 679
    //   674: ldc 245
    //   676: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   679: aload 5
    //   681: invokevirtual 376	android/media/MediaCodec:release	()V
    //   684: aload_0
    //   685: getfield 162	com/tencent/tavcut/render/audio/wave/MediaCodecAudioWaveDataProcessor:b	Landroid/media/MediaExtractor;
    //   688: astore 5
    //   690: aload 5
    //   692: ifnonnull +8 -> 700
    //   695: ldc 163
    //   697: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   700: aload 5
    //   702: invokevirtual 381	android/media/MediaExtractor:release	()V
    //   705: goto +6 -> 711
    //   708: aload 4
    //   710: athrow
    //   711: goto -3 -> 708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	this	MediaCodecAudioWaveDataProcessor
    //   172	75	1	bool1	boolean
    //   130	119	2	bool2	boolean
    //   244	4	3	bool3	boolean
    //   7	305	4	localObject1	Object
    //   316	1	4	localObject2	Object
    //   321	1	4	localIllegalStateException	java.lang.IllegalStateException
    //   326	20	4	localIllegalArgumentException	IllegalArgumentException
    //   357	352	4	localObject3	Object
    //   22	679	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	316	finally
    //   29	35	316	finally
    //   35	59	316	finally
    //   64	70	316	finally
    //   70	102	316	finally
    //   107	112	316	finally
    //   112	118	316	finally
    //   123	129	316	finally
    //   131	147	316	finally
    //   152	157	316	finally
    //   157	171	316	finally
    //   183	189	316	finally
    //   194	199	316	finally
    //   199	212	316	finally
    //   212	218	316	finally
    //   223	228	316	finally
    //   228	245	316	finally
    //   331	353	316	finally
    //   417	439	316	finally
    //   0	24	321	java/lang/IllegalStateException
    //   29	35	321	java/lang/IllegalStateException
    //   35	59	321	java/lang/IllegalStateException
    //   64	70	321	java/lang/IllegalStateException
    //   70	102	321	java/lang/IllegalStateException
    //   107	112	321	java/lang/IllegalStateException
    //   112	118	321	java/lang/IllegalStateException
    //   123	129	321	java/lang/IllegalStateException
    //   131	147	321	java/lang/IllegalStateException
    //   152	157	321	java/lang/IllegalStateException
    //   157	171	321	java/lang/IllegalStateException
    //   183	189	321	java/lang/IllegalStateException
    //   194	199	321	java/lang/IllegalStateException
    //   199	212	321	java/lang/IllegalStateException
    //   212	218	321	java/lang/IllegalStateException
    //   223	228	321	java/lang/IllegalStateException
    //   228	245	321	java/lang/IllegalStateException
    //   0	24	326	java/lang/IllegalArgumentException
    //   29	35	326	java/lang/IllegalArgumentException
    //   35	59	326	java/lang/IllegalArgumentException
    //   64	70	326	java/lang/IllegalArgumentException
    //   70	102	326	java/lang/IllegalArgumentException
    //   107	112	326	java/lang/IllegalArgumentException
    //   112	118	326	java/lang/IllegalArgumentException
    //   123	129	326	java/lang/IllegalArgumentException
    //   131	147	326	java/lang/IllegalArgumentException
    //   152	157	326	java/lang/IllegalArgumentException
    //   157	171	326	java/lang/IllegalArgumentException
    //   183	189	326	java/lang/IllegalArgumentException
    //   194	199	326	java/lang/IllegalArgumentException
    //   199	212	326	java/lang/IllegalArgumentException
    //   212	218	326	java/lang/IllegalArgumentException
    //   223	228	326	java/lang/IllegalArgumentException
    //   228	245	326	java/lang/IllegalArgumentException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.wave.MediaCodecAudioWaveDataProcessor
 * JD-Core Version:    0.7.0.1
 */