package com.tencent.tavcut.util;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import com.tencent.tavcut.bean.Size;

public class VideoUtil
{
  private static final String TAG = VideoUtil.class.getSimpleName();
  
  /* Error */
  @android.support.annotation.RequiresApi(api=16)
  public static int getIFrameInterval(String paramString, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: sipush 1000
    //   5: istore 4
    //   7: iload 4
    //   9: istore 5
    //   11: aload_0
    //   12: invokestatic 33	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +264 -> 279
    //   18: new 35	android/media/MediaExtractor
    //   21: dup
    //   22: invokespecial 36	android/media/MediaExtractor:<init>	()V
    //   25: astore 13
    //   27: aload 13
    //   29: astore 12
    //   31: aload 13
    //   33: aload_0
    //   34: invokevirtual 40	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   37: aload 13
    //   39: astore 12
    //   41: iload_3
    //   42: aload 13
    //   44: invokevirtual 44	android/media/MediaExtractor:getTrackCount	()I
    //   47: if_icmpge +36 -> 83
    //   50: aload 13
    //   52: astore 12
    //   54: aload 13
    //   56: iload_3
    //   57: invokevirtual 48	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   60: ldc 50
    //   62: invokevirtual 56	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: ldc 58
    //   67: invokevirtual 64	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +212 -> 282
    //   73: aload 13
    //   75: astore 12
    //   77: aload 13
    //   79: iload_3
    //   80: invokevirtual 68	android/media/MediaExtractor:selectTrack	(I)V
    //   83: aload 13
    //   85: astore 12
    //   87: aload 13
    //   89: lload_1
    //   90: ldc2_w 69
    //   93: ldiv
    //   94: ldc2_w 71
    //   97: lmul
    //   98: iconst_0
    //   99: invokevirtual 76	android/media/MediaExtractor:seekTo	(JI)V
    //   102: aload 13
    //   104: astore 12
    //   106: aload 13
    //   108: invokevirtual 80	android/media/MediaExtractor:getSampleTime	()J
    //   111: lstore 10
    //   113: aload 13
    //   115: astore 12
    //   117: aload 13
    //   119: invokevirtual 83	android/media/MediaExtractor:getSampleFlags	()I
    //   122: istore_3
    //   123: lconst_0
    //   124: lstore 6
    //   126: aload 13
    //   128: astore 12
    //   130: aload 13
    //   132: invokevirtual 87	android/media/MediaExtractor:advance	()Z
    //   135: ifeq +46 -> 181
    //   138: aload 13
    //   140: astore 12
    //   142: aload 13
    //   144: invokevirtual 80	android/media/MediaExtractor:getSampleTime	()J
    //   147: lstore 6
    //   149: aload 13
    //   151: astore 12
    //   153: aload 13
    //   155: invokevirtual 83	android/media/MediaExtractor:getSampleFlags	()I
    //   158: istore 5
    //   160: lload 6
    //   162: lload 10
    //   164: lsub
    //   165: lstore 8
    //   167: lload 8
    //   169: lstore 6
    //   171: iload 5
    //   173: iconst_1
    //   174: if_icmpne -48 -> 126
    //   177: lload 8
    //   179: lstore 6
    //   181: aload 13
    //   183: astore 12
    //   185: getstatic 16	com/tencent/tavcut/util/VideoUtil:TAG	Ljava/lang/String;
    //   188: new 89	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   195: ldc 92
    //   197: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload 10
    //   202: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: ldc 101
    //   207: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload_3
    //   211: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: ldc 106
    //   216: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: lload_1
    //   220: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: ldc 108
    //   225: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: lload 6
    //   230: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 117	com/tencent/tavcut/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: iload 4
    //   241: istore_3
    //   242: lload 6
    //   244: lconst_0
    //   245: lcmp
    //   246: ifle +17 -> 263
    //   249: aload 13
    //   251: astore 12
    //   253: lload 6
    //   255: ldc2_w 71
    //   258: ldiv
    //   259: lstore_1
    //   260: lload_1
    //   261: l2i
    //   262: istore_3
    //   263: iload_3
    //   264: istore 5
    //   266: aload 13
    //   268: ifnull +11 -> 279
    //   271: aload 13
    //   273: invokevirtual 120	android/media/MediaExtractor:release	()V
    //   276: iload_3
    //   277: istore 5
    //   279: iload 5
    //   281: ireturn
    //   282: iload_3
    //   283: iconst_1
    //   284: iadd
    //   285: istore_3
    //   286: goto -249 -> 37
    //   289: astore 14
    //   291: aconst_null
    //   292: astore_0
    //   293: aload_0
    //   294: astore 12
    //   296: getstatic 16	com/tencent/tavcut/util/VideoUtil:TAG	Ljava/lang/String;
    //   299: ldc 122
    //   301: aload 14
    //   303: invokestatic 126	com/tencent/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: iload 4
    //   308: istore 5
    //   310: aload_0
    //   311: ifnull -32 -> 279
    //   314: aload_0
    //   315: invokevirtual 120	android/media/MediaExtractor:release	()V
    //   318: sipush 1000
    //   321: ireturn
    //   322: astore_0
    //   323: aconst_null
    //   324: astore 12
    //   326: aload 12
    //   328: ifnull +8 -> 336
    //   331: aload 12
    //   333: invokevirtual 120	android/media/MediaExtractor:release	()V
    //   336: aload_0
    //   337: athrow
    //   338: astore_0
    //   339: goto -13 -> 326
    //   342: astore 14
    //   344: aload 13
    //   346: astore_0
    //   347: goto -54 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramString	String
    //   0	350	1	paramLong	long
    //   1	285	3	i	int
    //   5	302	4	j	int
    //   9	300	5	k	int
    //   124	130	6	l1	long
    //   165	13	8	l2	long
    //   111	90	10	l3	long
    //   29	303	12	localObject	Object
    //   25	320	13	localMediaExtractor	android.media.MediaExtractor
    //   289	13	14	localException1	java.lang.Exception
    //   342	1	14	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	27	289	java/lang/Exception
    //   18	27	322	finally
    //   31	37	338	finally
    //   41	50	338	finally
    //   54	73	338	finally
    //   77	83	338	finally
    //   87	102	338	finally
    //   106	113	338	finally
    //   117	123	338	finally
    //   130	138	338	finally
    //   142	149	338	finally
    //   153	160	338	finally
    //   185	239	338	finally
    //   253	260	338	finally
    //   296	306	338	finally
    //   31	37	342	java/lang/Exception
    //   41	50	342	java/lang/Exception
    //   54	73	342	java/lang/Exception
    //   77	83	342	java/lang/Exception
    //   87	102	342	java/lang/Exception
    //   106	113	342	java/lang/Exception
    //   117	123	342	java/lang/Exception
    //   130	138	342	java/lang/Exception
    //   142	149	342	java/lang/Exception
    //   153	160	342	java/lang/Exception
    //   185	239	342	java/lang/Exception
    //   253	260	342	java/lang/Exception
  }
  
  public static Size getVideoSize(String paramString)
  {
    return getVideoSize(paramString, true);
  }
  
  public static Size getVideoSize(String paramString, boolean paramBoolean)
  {
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setDataSource(paramString);
    paramString = ExtractorUtils.getVideoSize(localAssetExtractor);
    Size localSize = new Size((int)paramString.width, (int)paramString.height);
    if (paramBoolean)
    {
      int i = localAssetExtractor.getPreferRotation();
      if ((i == 1) || (i == 3))
      {
        localSize.setWidth((int)paramString.height);
        localSize.setHeight((int)paramString.width);
      }
    }
    localAssetExtractor.release();
    return localSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.util.VideoUtil
 * JD-Core Version:    0.7.0.1
 */