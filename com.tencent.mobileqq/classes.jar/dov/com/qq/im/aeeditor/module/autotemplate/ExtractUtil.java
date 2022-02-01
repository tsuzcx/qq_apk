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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/ExtractUtil;", "", "()V", "TAG", "", "VERBOSE", "", "doExtract", "Landroid/graphics/Bitmap;", "extractor", "Landroid/media/MediaExtractor;", "trackIndex", "", "decoder", "Landroid/media/MediaCodec;", "outputSurface", "Ldov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface;", "seekTimeUs", "", "getFrameAtTime", "videoPath", "timeUs", "maxSize", "getFrameAtTimeInner", "selectTrack", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExtractUtil
{
  public static final ExtractUtil a;
  private static final boolean a;
  
  static
  {
    jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateExtractUtil = new ExtractUtil();
    jdField_a_of_type_Boolean = BuildConfig.jdField_a_of_type_Boolean;
  }
  
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
        if (jdField_a_of_type_Boolean) {
          Log.d("ExtractUtil", "Extractor selected track " + i + " (" + str + "): " + localMediaFormat);
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
    Bitmap localBitmap = (Bitmap)null;
    ByteBuffer[] arrayOfByteBuffer = paramMediaCodec.getInputBuffers();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i = 0;
    int k = 0;
    int j = 0;
    int m;
    Object localObject;
    int n;
    if (k == 0)
    {
      if (jdField_a_of_type_Boolean) {
        Log.d("ExtractUtil", "loop");
      }
      if (j == 0)
      {
        m = paramMediaCodec.dequeueInputBuffer(10000);
        if (m >= 0)
        {
          localObject = arrayOfByteBuffer[m];
          paramMediaExtractor.seekTo(paramLong, 2);
          n = paramMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
          if (n < 0)
          {
            paramMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
            if (!jdField_a_of_type_Boolean) {
              break label649;
            }
            Log.d("ExtractUtil", "sent input EOS");
            m = 1;
            j = i;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      label132:
      if (k == 0)
      {
        m = paramMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000);
        if (m == -1)
        {
          if (!jdField_a_of_type_Boolean) {
            break label646;
          }
          Log.d("ExtractUtil", "no output from decoder available");
        }
      }
      label640:
      label646:
      for (;;)
      {
        m = j;
        j = i;
        i = m;
        break;
        if (paramMediaExtractor.getSampleTrackIndex() != paramInt) {
          Log.w("ExtractUtil", "WEIRD: got sample from track " + paramMediaExtractor.getSampleTrackIndex() + ", expected " + paramInt);
        }
        paramMediaCodec.queueInputBuffer(m, 0, n, paramMediaExtractor.getSampleTime(), 0);
        if (jdField_a_of_type_Boolean) {
          Log.d("ExtractUtil", "submitted frame " + i + " to dec, size=" + n);
        }
        paramMediaExtractor.advance();
        m = i + 1;
        i = j;
        j = m;
        break label132;
        if (jdField_a_of_type_Boolean) {
          Log.d("ExtractUtil", "input buffer not available");
        }
        m = i;
        i = j;
        j = m;
        break label132;
        if (m == -3)
        {
          if (jdField_a_of_type_Boolean) {
            Log.d("ExtractUtil", "decoder output buffers changed");
          }
        }
        else if (m == -2)
        {
          localObject = paramMediaCodec.getOutputFormat();
          if (jdField_a_of_type_Boolean) {
            Log.d("ExtractUtil", "decoder output format changed: " + localObject);
          }
        }
        else if (m < 0)
        {
          Log.e("ExtractUtil", "unexpected result from decoder.dequeueOutputBuffer: " + m);
        }
        else
        {
          if (jdField_a_of_type_Boolean) {
            Log.d("ExtractUtil", "surface decoder given buffer " + m + " (size=" + localBufferInfo.size + ")");
          }
          if ((localBufferInfo.flags & 0x4) != 0)
          {
            if (jdField_a_of_type_Boolean) {
              Log.d("ExtractUtil", "output EOS");
            }
            k = 1;
          }
          for (;;)
          {
            if (localBufferInfo.size != 0) {}
            for (boolean bool = true;; bool = false)
            {
              paramMediaCodec.releaseOutputBuffer(m, bool);
              if (!bool) {
                break label640;
              }
              if (jdField_a_of_type_Boolean) {
                Log.d("ExtractUtil", "awaiting decode of frame " + 0);
              }
              paramCodecOutputSurface.c();
              paramCodecOutputSurface.a(false);
              localBitmap = paramCodecOutputSurface.a(true);
              if (jdField_a_of_type_Boolean) {
                Log.d("ExtractUtil", "result bitmap: " + localBitmap);
              }
              k = 1;
              break;
            }
            return localBitmap;
            break;
          }
        }
      }
      label649:
      m = 1;
      j = i;
      i = m;
    }
  }
  
  /* Error */
  @RequiresApi(17)
  private final Bitmap b(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 119	android/media/MediaCodec
    //   4: astore 12
    //   6: aconst_null
    //   7: checkcast 212	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface
    //   10: astore 13
    //   12: aconst_null
    //   13: checkcast 57	android/media/MediaExtractor
    //   16: astore 15
    //   18: new 230	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 236	java/io/File:canRead	()Z
    //   31: ifne +80 -> 111
    //   34: new 238	java/io/FileNotFoundException
    //   37: dup
    //   38: new 85	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   45: ldc 240
    //   47: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 241	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   60: checkcast 243	java/lang/Throwable
    //   63: athrow
    //   64: astore_1
    //   65: aload 15
    //   67: astore 14
    //   69: aload 13
    //   71: ifnull +8 -> 79
    //   74: aload 13
    //   76: invokevirtual 245	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:a	()V
    //   79: aload 12
    //   81: ifnull +8 -> 89
    //   84: aload 12
    //   86: invokevirtual 248	android/media/MediaCodec:stop	()V
    //   89: aload 12
    //   91: ifnull +8 -> 99
    //   94: aload 12
    //   96: invokevirtual 251	android/media/MediaCodec:release	()V
    //   99: aload 14
    //   101: ifnull +8 -> 109
    //   104: aload 14
    //   106: invokevirtual 252	android/media/MediaExtractor:release	()V
    //   109: aload_1
    //   110: athrow
    //   111: new 57	android/media/MediaExtractor
    //   114: dup
    //   115: invokespecial 253	android/media/MediaExtractor:<init>	()V
    //   118: astore 14
    //   120: aload 14
    //   122: aload_1
    //   123: invokevirtual 254	java/io/File:toString	()Ljava/lang/String;
    //   126: invokevirtual 257	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   129: aload_0
    //   130: aload 14
    //   132: invokespecial 259	dov/com/qq/im/aeeditor/module/autotemplate/ExtractUtil:a	(Landroid/media/MediaExtractor;)I
    //   135: istore 11
    //   137: iload 11
    //   139: ifge +34 -> 173
    //   142: new 261	java/lang/RuntimeException
    //   145: dup
    //   146: new 85	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 263
    //   156: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 264	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   169: checkcast 243	java/lang/Throwable
    //   172: athrow
    //   173: aload 14
    //   175: iload 11
    //   177: invokevirtual 267	android/media/MediaExtractor:selectTrack	(I)V
    //   180: aload 14
    //   182: iload 11
    //   184: invokevirtual 65	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   187: astore 15
    //   189: aload 15
    //   191: ldc_w 269
    //   194: invokevirtual 273	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   197: ifeq +242 -> 439
    //   200: aload 15
    //   202: ldc_w 269
    //   205: invokevirtual 277	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   208: istore 9
    //   210: aload 15
    //   212: ldc_w 279
    //   215: invokevirtual 277	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   218: istore 8
    //   220: aload 15
    //   222: ldc_w 281
    //   225: invokevirtual 277	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   228: istore 10
    //   230: iload 9
    //   232: bipush 90
    //   234: if_icmpeq +215 -> 449
    //   237: iload 10
    //   239: istore 6
    //   241: iload 8
    //   243: istore 7
    //   245: iload 9
    //   247: sipush 270
    //   250: if_icmpne +6 -> 256
    //   253: goto +196 -> 449
    //   256: iload 4
    //   258: ifle +174 -> 432
    //   261: iload 7
    //   263: i2f
    //   264: iload 6
    //   266: i2f
    //   267: fdiv
    //   268: fstore 5
    //   270: iload 6
    //   272: iload 7
    //   274: if_icmple +113 -> 387
    //   277: iload 6
    //   279: iload 4
    //   281: if_icmple +151 -> 432
    //   284: iload 4
    //   286: i2f
    //   287: fload 5
    //   289: fmul
    //   290: f2i
    //   291: istore 7
    //   293: iload 4
    //   295: istore 6
    //   297: iload 7
    //   299: istore 4
    //   301: new 212	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface
    //   304: dup
    //   305: iload 4
    //   307: iload 6
    //   309: invokespecial 284	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:<init>	(II)V
    //   312: astore_1
    //   313: aload 15
    //   315: ldc 67
    //   317: invokevirtual 73	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   320: invokestatic 288	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   323: astore 13
    //   325: aload 13
    //   327: aload 15
    //   329: aload_1
    //   330: invokevirtual 291	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:a	()Landroid/view/Surface;
    //   333: aconst_null
    //   334: iconst_0
    //   335: invokevirtual 295	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   338: aload 13
    //   340: invokevirtual 298	android/media/MediaCodec:start	()V
    //   343: aload 13
    //   345: ldc_w 299
    //   348: invokestatic 305	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   351: aload_0
    //   352: aload 14
    //   354: iload 11
    //   356: aload 13
    //   358: aload_1
    //   359: lload_2
    //   360: invokespecial 307	dov/com/qq/im/aeeditor/module/autotemplate/ExtractUtil:a	(Landroid/media/MediaExtractor;ILandroid/media/MediaCodec;Ldov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface;J)Landroid/graphics/Bitmap;
    //   363: astore 12
    //   365: aload_1
    //   366: invokevirtual 245	dov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface:a	()V
    //   369: aload 13
    //   371: invokevirtual 248	android/media/MediaCodec:stop	()V
    //   374: aload 13
    //   376: invokevirtual 251	android/media/MediaCodec:release	()V
    //   379: aload 14
    //   381: invokevirtual 252	android/media/MediaExtractor:release	()V
    //   384: aload 12
    //   386: areturn
    //   387: iload 7
    //   389: iload 4
    //   391: if_icmple +41 -> 432
    //   394: iload 4
    //   396: i2f
    //   397: fload 5
    //   399: fdiv
    //   400: f2i
    //   401: istore 6
    //   403: goto -102 -> 301
    //   406: astore 15
    //   408: aload_1
    //   409: astore 13
    //   411: aload 15
    //   413: astore_1
    //   414: goto -345 -> 69
    //   417: astore 15
    //   419: aload 13
    //   421: astore 12
    //   423: aload_1
    //   424: astore 13
    //   426: aload 15
    //   428: astore_1
    //   429: goto -360 -> 69
    //   432: iload 7
    //   434: istore 4
    //   436: goto -135 -> 301
    //   439: iconst_0
    //   440: istore 9
    //   442: goto -232 -> 210
    //   445: astore_1
    //   446: goto -377 -> 69
    //   449: iload 10
    //   451: istore 7
    //   453: iload 8
    //   455: istore 6
    //   457: goto -201 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	ExtractUtil
    //   0	460	1	paramString	String
    //   0	460	2	paramLong	long
    //   0	460	4	paramInt	int
    //   268	130	5	f	float
    //   239	217	6	i	int
    //   243	209	7	j	int
    //   218	236	8	k	int
    //   208	233	9	m	int
    //   228	222	10	n	int
    //   135	220	11	i1	int
    //   4	418	12	localObject1	Object
    //   10	415	13	localObject2	Object
    //   67	313	14	localObject3	Object
    //   16	312	15	localObject4	Object
    //   406	6	15	localObject5	Object
    //   417	10	15	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   18	64	64	finally
    //   111	120	64	finally
    //   313	325	406	finally
    //   325	365	417	finally
    //   120	137	445	finally
    //   142	173	445	finally
    //   173	210	445	finally
    //   210	230	445	finally
    //   261	270	445	finally
    //   301	313	445	finally
  }
  
  @RequiresApi(17)
  @Nullable
  public final Bitmap a(@NotNull String paramString, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoPath");
    return (Bitmap)Executors.newSingleThreadExecutor().submit((Callable)new ExtractUtil.getFrameAtTime.result.1(paramString, paramLong, paramInt)).get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.ExtractUtil
 * JD-Core Version:    0.7.0.1
 */