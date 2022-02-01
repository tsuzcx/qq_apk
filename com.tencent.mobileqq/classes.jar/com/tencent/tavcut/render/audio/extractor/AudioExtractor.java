package com.tencent.tavcut.render.audio.extractor;

import android.media.AudioRecord;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import com.tencent.tavcut.render.log.TavLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/extractor/AudioExtractor;", "Lcom/tencent/tavcut/render/audio/extractor/IAudioExtractor;", "()V", "audioExtractorListener", "Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;", "audioTotalDuration", "", "channelCount", "", "isRunning", "", "mediaExtractor", "Landroid/media/MediaExtractor;", "mediaMuxer", "Landroid/media/MediaMuxer;", "outputAudioPath", "", "sampleRate", "trackIndex", "cancelExtractAudio", "", "computeBufferSize", "createBufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sampleSize", "extractAudioFromVideo", "inputVideoPath", "listener", "initMediaExtractor", "notifyExtractorError", "errCode", "errMsg", "release", "startExtractAudio", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class AudioExtractor
  implements IAudioExtractor
{
  public static final AudioExtractor.Companion a = new AudioExtractor.Companion(null);
  private MediaExtractor b;
  private MediaMuxer c;
  private String d = "";
  private int e;
  private int f;
  private boolean g;
  private int h = -1;
  private long i;
  private OnAudioExtractorListener j;
  
  private final MediaCodec.BufferInfo a(int paramInt)
  {
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    localBufferInfo.offset = 0;
    localBufferInfo.size = paramInt;
    MediaExtractor localMediaExtractor = this.b;
    if (localMediaExtractor == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
    }
    localBufferInfo.flags = localMediaExtractor.getSampleFlags();
    localMediaExtractor = this.b;
    if (localMediaExtractor == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
    }
    localBufferInfo.presentationTimeUs = localMediaExtractor.getSampleTime();
    return localBufferInfo;
  }
  
  /* Error */
  private final void a()
  {
    // Byte code:
    //   0: ldc 77
    //   2: astore 4
    //   4: aload_0
    //   5: getfield 122	com/tencent/tavcut/render/audio/extractor/AudioExtractor:j	Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +10 -> 22
    //   15: aload 5
    //   17: invokeinterface 126 1 0
    //   22: iconst_0
    //   23: istore_2
    //   24: aload_0
    //   25: invokespecial 128	com/tencent/tavcut/render/audio/extractor/AudioExtractor:b	()I
    //   28: invokestatic 134	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   31: astore 5
    //   33: aload_0
    //   34: getfield 136	com/tencent/tavcut/render/audio/extractor/AudioExtractor:c	Landroid/media/MediaMuxer;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnonnull +8 -> 49
    //   44: ldc 137
    //   46: invokestatic 100	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   49: aload 6
    //   51: invokevirtual 142	android/media/MediaMuxer:start	()V
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 144	com/tencent/tavcut/render/audio/extractor/AudioExtractor:g	Z
    //   59: aload_0
    //   60: getfield 144	com/tencent/tavcut/render/audio/extractor/AudioExtractor:g	Z
    //   63: ifeq +170 -> 233
    //   66: aload_0
    //   67: getfield 93	com/tencent/tavcut/render/audio/extractor/AudioExtractor:b	Landroid/media/MediaExtractor;
    //   70: astore 6
    //   72: aload 6
    //   74: ifnonnull +8 -> 82
    //   77: ldc 94
    //   79: invokestatic 100	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   82: aload 6
    //   84: aload 5
    //   86: iconst_0
    //   87: invokevirtual 148	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   90: istore_3
    //   91: ldc 149
    //   93: fstore_1
    //   94: iload_3
    //   95: ifgt +36 -> 131
    //   98: aload_0
    //   99: getfield 93	com/tencent/tavcut/render/audio/extractor/AudioExtractor:b	Landroid/media/MediaExtractor;
    //   102: astore 6
    //   104: aload 6
    //   106: ifnonnull +8 -> 114
    //   109: ldc 94
    //   111: invokestatic 100	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   114: aload 6
    //   116: aload_0
    //   117: getfield 81	com/tencent/tavcut/render/audio/extractor/AudioExtractor:h	I
    //   120: invokevirtual 153	android/media/MediaExtractor:unselectTrack	(I)V
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 144	com/tencent/tavcut/render/audio/extractor/AudioExtractor:g	Z
    //   128: goto +82 -> 210
    //   131: aload_0
    //   132: iload_3
    //   133: invokespecial 155	com/tencent/tavcut/render/audio/extractor/AudioExtractor:a	(I)Landroid/media/MediaCodec$BufferInfo;
    //   136: astore 6
    //   138: aload_0
    //   139: getfield 136	com/tencent/tavcut/render/audio/extractor/AudioExtractor:c	Landroid/media/MediaMuxer;
    //   142: astore 7
    //   144: aload 7
    //   146: ifnonnull +8 -> 154
    //   149: ldc 137
    //   151: invokestatic 100	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   154: aload 7
    //   156: aload_0
    //   157: getfield 81	com/tencent/tavcut/render/audio/extractor/AudioExtractor:h	I
    //   160: aload 5
    //   162: aload 6
    //   164: invokevirtual 159	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   167: aload_0
    //   168: getfield 93	com/tencent/tavcut/render/audio/extractor/AudioExtractor:b	Landroid/media/MediaExtractor;
    //   171: astore 7
    //   173: aload 7
    //   175: ifnonnull +8 -> 183
    //   178: ldc 94
    //   180: invokestatic 100	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   183: aload 7
    //   185: invokevirtual 163	android/media/MediaExtractor:advance	()Z
    //   188: pop
    //   189: ldc 149
    //   191: aload 6
    //   193: getfield 116	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   196: l2f
    //   197: aload_0
    //   198: getfield 165	com/tencent/tavcut/render/audio/extractor/AudioExtractor:i	J
    //   201: l2f
    //   202: fdiv
    //   203: ldc 149
    //   205: fmul
    //   206: invokestatic 171	kotlin/ranges/RangesKt:coerceAtMost	(FF)F
    //   209: fstore_1
    //   210: aload_0
    //   211: getfield 122	com/tencent/tavcut/render/audio/extractor/AudioExtractor:j	Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;
    //   214: astore 6
    //   216: aload 6
    //   218: ifnull -159 -> 59
    //   221: aload 6
    //   223: fload_1
    //   224: f2i
    //   225: invokeinterface 173 2 0
    //   230: goto -171 -> 59
    //   233: aload_0
    //   234: invokespecial 175	com/tencent/tavcut/render/audio/extractor/AudioExtractor:c	()V
    //   237: iconst_1
    //   238: istore_2
    //   239: goto +89 -> 328
    //   242: astore 4
    //   244: goto +111 -> 355
    //   247: astore 5
    //   249: ldc 177
    //   251: ldc 179
    //   253: aload 5
    //   255: checkcast 181	java/lang/Throwable
    //   258: invokestatic 186	com/tencent/tavcut/render/log/TavLogger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: aload 5
    //   263: invokevirtual 190	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   266: astore 5
    //   268: aload 5
    //   270: ifnull +7 -> 277
    //   273: aload 5
    //   275: astore 4
    //   277: aload_0
    //   278: iconst_2
    //   279: aload 4
    //   281: invokespecial 193	com/tencent/tavcut/render/audio/extractor/AudioExtractor:a	(ILjava/lang/String;)V
    //   284: goto +40 -> 324
    //   287: astore 5
    //   289: ldc 177
    //   291: ldc 179
    //   293: aload 5
    //   295: checkcast 181	java/lang/Throwable
    //   298: invokestatic 186	com/tencent/tavcut/render/log/TavLogger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload 5
    //   303: invokevirtual 194	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   306: astore 5
    //   308: aload 5
    //   310: ifnull +7 -> 317
    //   313: aload 5
    //   315: astore 4
    //   317: aload_0
    //   318: iconst_2
    //   319: aload 4
    //   321: invokespecial 193	com/tencent/tavcut/render/audio/extractor/AudioExtractor:a	(ILjava/lang/String;)V
    //   324: aload_0
    //   325: invokespecial 175	com/tencent/tavcut/render/audio/extractor/AudioExtractor:c	()V
    //   328: iload_2
    //   329: ifeq +25 -> 354
    //   332: aload_0
    //   333: getfield 122	com/tencent/tavcut/render/audio/extractor/AudioExtractor:j	Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;
    //   336: astore 4
    //   338: aload 4
    //   340: ifnull +14 -> 354
    //   343: aload 4
    //   345: aload_0
    //   346: getfield 79	com/tencent/tavcut/render/audio/extractor/AudioExtractor:d	Ljava/lang/String;
    //   349: invokeinterface 196 2 0
    //   354: return
    //   355: aload_0
    //   356: invokespecial 175	com/tencent/tavcut/render/audio/extractor/AudioExtractor:c	()V
    //   359: goto +6 -> 365
    //   362: aload 4
    //   364: athrow
    //   365: goto -3 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	AudioExtractor
    //   93	131	1	f1	float
    //   23	306	2	k	int
    //   90	43	3	m	int
    //   2	1	4	str1	String
    //   242	1	4	localObject1	Object
    //   275	88	4	localObject2	Object
    //   8	153	5	localObject3	Object
    //   247	15	5	localIllegalStateException	IllegalStateException
    //   266	8	5	str2	String
    //   287	15	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   306	8	5	str3	String
    //   37	185	6	localObject4	Object
    //   142	42	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   24	39	242	finally
    //   44	49	242	finally
    //   49	59	242	finally
    //   59	72	242	finally
    //   77	82	242	finally
    //   82	91	242	finally
    //   98	104	242	finally
    //   109	114	242	finally
    //   114	128	242	finally
    //   131	144	242	finally
    //   149	154	242	finally
    //   154	173	242	finally
    //   178	183	242	finally
    //   183	210	242	finally
    //   210	216	242	finally
    //   221	230	242	finally
    //   249	268	242	finally
    //   277	284	242	finally
    //   289	308	242	finally
    //   317	324	242	finally
    //   24	39	247	java/lang/IllegalStateException
    //   44	49	247	java/lang/IllegalStateException
    //   49	59	247	java/lang/IllegalStateException
    //   59	72	247	java/lang/IllegalStateException
    //   77	82	247	java/lang/IllegalStateException
    //   82	91	247	java/lang/IllegalStateException
    //   98	104	247	java/lang/IllegalStateException
    //   109	114	247	java/lang/IllegalStateException
    //   114	128	247	java/lang/IllegalStateException
    //   131	144	247	java/lang/IllegalStateException
    //   149	154	247	java/lang/IllegalStateException
    //   154	173	247	java/lang/IllegalStateException
    //   178	183	247	java/lang/IllegalStateException
    //   183	210	247	java/lang/IllegalStateException
    //   210	216	247	java/lang/IllegalStateException
    //   221	230	247	java/lang/IllegalStateException
    //   24	39	287	java/lang/IllegalArgumentException
    //   44	49	287	java/lang/IllegalArgumentException
    //   49	59	287	java/lang/IllegalArgumentException
    //   59	72	287	java/lang/IllegalArgumentException
    //   77	82	287	java/lang/IllegalArgumentException
    //   82	91	287	java/lang/IllegalArgumentException
    //   98	104	287	java/lang/IllegalArgumentException
    //   109	114	287	java/lang/IllegalArgumentException
    //   114	128	287	java/lang/IllegalArgumentException
    //   131	144	287	java/lang/IllegalArgumentException
    //   149	154	287	java/lang/IllegalArgumentException
    //   154	173	287	java/lang/IllegalArgumentException
    //   178	183	287	java/lang/IllegalArgumentException
    //   183	210	287	java/lang/IllegalArgumentException
    //   210	216	287	java/lang/IllegalArgumentException
    //   221	230	287	java/lang/IllegalArgumentException
  }
  
  private final void a(int paramInt, String paramString)
  {
    this.g = false;
    OnAudioExtractorListener localOnAudioExtractorListener = this.j;
    if (localOnAudioExtractorListener != null) {
      localOnAudioExtractorListener.a(paramInt, paramString);
    }
  }
  
  private final int b()
  {
    if (this.f == 2) {
      k = 12;
    } else {
      k = 16;
    }
    int k = AudioRecord.getMinBufferSize(this.e, k, 2);
    double d1 = this.e * 2;
    Double.isNaN(d1);
    double d2 = 16;
    Double.isNaN(d2);
    double d3 = 8;
    Double.isNaN(d3);
    int m = (int)(d1 * 0.02D * d2 / d3);
    if (k < m) {
      return m;
    }
    return 8192;
  }
  
  private final void c()
  {
    try
    {
      MediaMuxer localMediaMuxer = this.c;
      if (localMediaMuxer == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mediaMuxer");
      }
      localMediaMuxer.stop();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      TavLogger.a("AudioExtractor", "MediaMuxer stop failed", (Throwable)localIllegalStateException);
      localObject = localIllegalStateException.getMessage();
      if (localObject == null) {
        localObject = "";
      }
      a(4, (String)localObject);
    }
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaMuxer");
    }
    ((MediaMuxer)localObject).release();
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mediaExtractor");
    }
    ((MediaExtractor)localObject).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.extractor.AudioExtractor
 * JD-Core Version:    0.7.0.1
 */