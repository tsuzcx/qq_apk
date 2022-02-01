package dov.com.qq.im.aeeditor.module.autotemplate;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.litelivesdk.afwraper.config.BuildConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/ExtractUtil;", "", "()V", "TAG", "", "VERBOSE", "", "doExtract", "Landroid/graphics/Bitmap;", "extractor", "Landroid/media/MediaExtractor;", "trackIndex", "", "decoder", "Landroid/media/MediaCodec;", "outputSurface", "Ldov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface;", "seekTimeUs", "", "getFrameAtTime", "videoPath", "timeUs", "maxSize", "getFrameAtTimeInner", "selectTrack", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ExtractUtil
{
  public static final ExtractUtil a = new ExtractUtil();
  private static final boolean b = BuildConfig.a;
  
  @RequiresApi(16)
  private final int a(MediaExtractor paramMediaExtractor)
  {
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    while (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      if ((str != null) && (StringsKt.startsWith$default(str, "video/", false, 2, null)))
      {
        if (b)
        {
          paramMediaExtractor = new StringBuilder();
          paramMediaExtractor.append("Extractor selected track ");
          paramMediaExtractor.append(i);
          paramMediaExtractor.append(" (");
          paramMediaExtractor.append(str);
          paramMediaExtractor.append("): ");
          paramMediaExtractor.append(localMediaFormat);
          Log.d("ExtractUtil", paramMediaExtractor.toString());
        }
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @RequiresApi(17)
  private final Bitmap a(MediaExtractor paramMediaExtractor, int paramInt, MediaCodec paramMediaCodec, CodecOutputSurface paramCodecOutputSurface, long paramLong)
  {
    Object localObject2 = paramMediaCodec;
    Object localObject1 = (Bitmap)null;
    ByteBuffer[] arrayOfByteBuffer = paramMediaCodec.getInputBuffers();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int j = 0;
    int i = 0;
    int m = 0;
    while (i == 0)
    {
      if (b) {
        Log.d("ExtractUtil", "loop");
      }
      int k;
      StringBuilder localStringBuilder;
      if (m == 0)
      {
        k = ((MediaCodec)localObject2).dequeueInputBuffer(10000);
        if (k >= 0)
        {
          localObject2 = arrayOfByteBuffer[k];
          paramMediaExtractor.seekTo(paramLong, 2);
          int n = paramMediaExtractor.readSampleData((ByteBuffer)localObject2, 0);
          if (n < 0)
          {
            paramMediaCodec.queueInputBuffer(k, 0, 0, 0L, 4);
            if (b) {
              Log.d("ExtractUtil", "sent input EOS");
            }
            m = 1;
          }
          else
          {
            localObject2 = "ExtractUtil";
            if (paramMediaExtractor.getSampleTrackIndex() != paramInt)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("WEIRD: got sample from track ");
              localStringBuilder.append(paramMediaExtractor.getSampleTrackIndex());
              localStringBuilder.append(", expected ");
              localStringBuilder.append(paramInt);
              Log.w((String)localObject2, localStringBuilder.toString());
            }
            paramMediaCodec.queueInputBuffer(k, 0, n, paramMediaExtractor.getSampleTime(), 0);
            if (b)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("submitted frame ");
              localStringBuilder.append(j);
              localStringBuilder.append(" to dec, size=");
              localStringBuilder.append(n);
              Log.d((String)localObject2, localStringBuilder.toString());
            }
            j += 1;
            paramMediaExtractor.advance();
          }
        }
        else if (b)
        {
          Log.d("ExtractUtil", "input buffer not available");
        }
      }
      if (i == 0)
      {
        long l = 10000;
        localObject2 = paramMediaCodec;
        k = ((MediaCodec)localObject2).dequeueOutputBuffer(localBufferInfo, l);
        if (k == -1)
        {
          k = i;
          if (b)
          {
            Log.d("ExtractUtil", "no output from decoder available");
            k = i;
          }
        }
        else if (k == -3)
        {
          k = i;
          if (b)
          {
            Log.d("ExtractUtil", "decoder output buffers changed");
            k = i;
          }
        }
        else if (k == -2)
        {
          localObject2 = paramMediaCodec.getOutputFormat();
          k = i;
          if (b)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("decoder output format changed: ");
            localStringBuilder.append(localObject2);
            Log.d("ExtractUtil", localStringBuilder.toString());
            k = i;
          }
        }
        else if (k < 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("unexpected result from decoder.dequeueOutputBuffer: ");
          ((StringBuilder)localObject2).append(k);
          Log.e("ExtractUtil", ((StringBuilder)localObject2).toString());
          k = i;
        }
        else
        {
          if (b)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("surface decoder given buffer ");
            localStringBuilder.append(k);
            localStringBuilder.append(" (size=");
            localStringBuilder.append(localBufferInfo.size);
            localStringBuilder.append(")");
            Log.d("ExtractUtil", localStringBuilder.toString());
          }
          if ((localBufferInfo.flags & 0x4) != 0)
          {
            if (b) {
              Log.d("ExtractUtil", "output EOS");
            }
            i = 1;
          }
          boolean bool;
          if (localBufferInfo.size != 0) {
            bool = true;
          } else {
            bool = false;
          }
          ((MediaCodec)localObject2).releaseOutputBuffer(k, bool);
          k = i;
          if (bool)
          {
            if (b)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("awaiting decode of frame ");
              ((StringBuilder)localObject1).append(0);
              Log.d("ExtractUtil", ((StringBuilder)localObject1).toString());
            }
            paramCodecOutputSurface.d();
            paramCodecOutputSurface.a(false);
            localObject1 = paramCodecOutputSurface.b(true);
            if (b)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("result bitmap: ");
              ((StringBuilder)localObject2).append(localObject1);
              Log.d("ExtractUtil", ((StringBuilder)localObject2).toString());
            }
            i = 1;
            break label757;
          }
        }
      }
      for (;;)
      {
        i = k;
        break;
        k = i;
      }
      label757:
      localObject2 = paramMediaCodec;
    }
    return localObject1;
  }
  
  /* Error */
  @RequiresApi(17)
  private final Bitmap b(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 121	android/media/MediaCodec
    //   4: astore 12
    //   6: aconst_null
    //   7: checkcast 214	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface
    //   10: astore 13
    //   12: aconst_null
    //   13: checkcast 59	android/media/MediaExtractor
    //   16: astore 15
    //   18: new 230	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 236	java/io/File:canRead	()Z
    //   31: ifeq +336 -> 367
    //   34: new 59	android/media/MediaExtractor
    //   37: dup
    //   38: invokespecial 237	android/media/MediaExtractor:<init>	()V
    //   41: astore 14
    //   43: aload 14
    //   45: aload_1
    //   46: invokevirtual 238	java/io/File:toString	()Ljava/lang/String;
    //   49: invokevirtual 241	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: aload 14
    //   55: invokespecial 243	dov/com/qq/im/aeeditor/module/autotemplate/ExtractUtil:a	(Landroid/media/MediaExtractor;)I
    //   58: istore 11
    //   60: iload 11
    //   62: iflt +256 -> 318
    //   65: aload 14
    //   67: iload 11
    //   69: invokevirtual 246	android/media/MediaExtractor:selectTrack	(I)V
    //   72: aload 14
    //   74: iload 11
    //   76: invokevirtual 67	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   79: astore 16
    //   81: aload 16
    //   83: ldc 248
    //   85: invokevirtual 252	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   88: ifeq +371 -> 459
    //   91: aload 16
    //   93: ldc 248
    //   95: invokevirtual 256	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   98: istore 9
    //   100: goto +3 -> 103
    //   103: aload 16
    //   105: ldc_w 258
    //   108: invokevirtual 256	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   111: istore 10
    //   113: aload 16
    //   115: ldc_w 260
    //   118: invokevirtual 256	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   121: istore 8
    //   123: iload 9
    //   125: bipush 90
    //   127: if_icmpeq +338 -> 465
    //   130: iload 10
    //   132: istore 6
    //   134: iload 8
    //   136: istore 7
    //   138: iload 9
    //   140: sipush 270
    //   143: if_icmpne +6 -> 149
    //   146: goto +319 -> 465
    //   149: iload 4
    //   151: ifle +325 -> 476
    //   154: iload 6
    //   156: i2f
    //   157: iload 7
    //   159: i2f
    //   160: fdiv
    //   161: fstore 5
    //   163: iload 7
    //   165: iload 6
    //   167: if_icmple +30 -> 197
    //   170: iload 7
    //   172: iload 4
    //   174: if_icmple +302 -> 476
    //   177: iload 4
    //   179: i2f
    //   180: fload 5
    //   182: fmul
    //   183: f2i
    //   184: istore 7
    //   186: iload 4
    //   188: istore 6
    //   190: iload 7
    //   192: istore 4
    //   194: goto +22 -> 216
    //   197: iload 6
    //   199: iload 4
    //   201: if_icmple +275 -> 476
    //   204: iload 4
    //   206: i2f
    //   207: fload 5
    //   209: fdiv
    //   210: f2i
    //   211: istore 6
    //   213: goto +3 -> 216
    //   216: new 214	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface
    //   219: dup
    //   220: iload 4
    //   222: iload 6
    //   224: invokespecial 263	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:<init>	(II)V
    //   227: astore 15
    //   229: aload 16
    //   231: ldc 69
    //   233: invokevirtual 75	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokestatic 267	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   239: astore_1
    //   240: aload_1
    //   241: aload 16
    //   243: aload 15
    //   245: invokevirtual 270	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:a	()Landroid/view/Surface;
    //   248: aconst_null
    //   249: iconst_0
    //   250: invokevirtual 274	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   253: aload_1
    //   254: invokevirtual 277	android/media/MediaCodec:start	()V
    //   257: aload_1
    //   258: ldc_w 278
    //   261: invokestatic 284	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   264: aload_0
    //   265: aload 14
    //   267: iload 11
    //   269: aload_1
    //   270: aload 15
    //   272: lload_2
    //   273: invokespecial 286	dov/com/qq/im/aeeditor/module/autotemplate/ExtractUtil:a	(Landroid/media/MediaExtractor;ILandroid/media/MediaCodec;Ldov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface;J)Landroid/graphics/Bitmap;
    //   276: astore 12
    //   278: aload 15
    //   280: invokevirtual 288	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:b	()V
    //   283: aload_1
    //   284: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   287: aload_1
    //   288: invokevirtual 294	android/media/MediaCodec:release	()V
    //   291: aload 14
    //   293: invokevirtual 295	android/media/MediaExtractor:release	()V
    //   296: aload 12
    //   298: areturn
    //   299: astore 13
    //   301: aload_1
    //   302: astore 12
    //   304: aload 13
    //   306: astore_1
    //   307: goto +4 -> 311
    //   310: astore_1
    //   311: aload 15
    //   313: astore 13
    //   315: goto +102 -> 417
    //   318: new 85	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   325: astore 15
    //   327: aload 15
    //   329: ldc_w 297
    //   332: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 15
    //   338: aload_1
    //   339: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: new 299	java/lang/RuntimeException
    //   346: dup
    //   347: aload 15
    //   349: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokespecial 300	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   355: checkcast 302	java/lang/Throwable
    //   358: athrow
    //   359: astore_1
    //   360: goto +57 -> 417
    //   363: astore_1
    //   364: goto +53 -> 417
    //   367: new 85	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   374: astore 14
    //   376: aload 14
    //   378: ldc_w 304
    //   381: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 14
    //   387: aload_1
    //   388: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: new 306	java/io/FileNotFoundException
    //   395: dup
    //   396: aload 14
    //   398: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokespecial 307	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   404: checkcast 302	java/lang/Throwable
    //   407: athrow
    //   408: astore_1
    //   409: goto +4 -> 413
    //   412: astore_1
    //   413: aload 15
    //   415: astore 14
    //   417: aload 13
    //   419: ifnull +8 -> 427
    //   422: aload 13
    //   424: invokevirtual 288	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:b	()V
    //   427: aload 12
    //   429: ifnull +8 -> 437
    //   432: aload 12
    //   434: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   437: aload 12
    //   439: ifnull +8 -> 447
    //   442: aload 12
    //   444: invokevirtual 294	android/media/MediaCodec:release	()V
    //   447: aload 14
    //   449: ifnull +8 -> 457
    //   452: aload 14
    //   454: invokevirtual 295	android/media/MediaExtractor:release	()V
    //   457: aload_1
    //   458: athrow
    //   459: iconst_0
    //   460: istore 9
    //   462: goto -359 -> 103
    //   465: iload 10
    //   467: istore 7
    //   469: iload 8
    //   471: istore 6
    //   473: goto -324 -> 149
    //   476: iload 6
    //   478: istore 4
    //   480: iload 7
    //   482: istore 6
    //   484: goto -268 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	ExtractUtil
    //   0	487	1	paramString	String
    //   0	487	2	paramLong	long
    //   0	487	4	paramInt	int
    //   161	47	5	f	float
    //   132	351	6	i	int
    //   136	345	7	j	int
    //   121	349	8	k	int
    //   98	363	9	m	int
    //   111	355	10	n	int
    //   58	210	11	i1	int
    //   4	439	12	localObject1	Object
    //   10	1	13	localCodecOutputSurface	CodecOutputSurface
    //   299	6	13	localObject2	Object
    //   313	110	13	localObject3	Object
    //   41	412	14	localObject4	Object
    //   16	398	15	localObject5	Object
    //   79	163	16	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   240	278	299	finally
    //   229	240	310	finally
    //   52	60	359	finally
    //   65	100	359	finally
    //   103	123	359	finally
    //   154	163	359	finally
    //   204	213	359	finally
    //   216	229	359	finally
    //   318	359	359	finally
    //   43	52	363	finally
    //   367	408	408	finally
    //   18	43	412	finally
  }
  
  @RequiresApi(17)
  @Nullable
  public final Bitmap a(@NotNull String paramString, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoPath");
    return (Bitmap)Executors.newSingleThreadExecutor().submit((Callable)new ExtractUtil.getFrameAtTime.result.1(paramString, paramLong, paramInt)).get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.ExtractUtil
 * JD-Core Version:    0.7.0.1
 */