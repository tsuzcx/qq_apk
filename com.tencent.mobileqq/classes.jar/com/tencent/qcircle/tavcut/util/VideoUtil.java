package com.tencent.qcircle.tavcut.util;

import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;

public class VideoUtil
{
  private static final String TAG = "VideoUtil";
  
  /* Error */
  @android.support.annotation.RequiresApi(api=16)
  public static int getIFrameInterval(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 27	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 12
    //   6: sipush 1000
    //   9: istore 4
    //   11: iload 12
    //   13: ifne +314 -> 327
    //   16: aconst_null
    //   17: astore 15
    //   19: aconst_null
    //   20: astore 13
    //   22: new 29	android/media/MediaExtractor
    //   25: dup
    //   26: invokespecial 30	android/media/MediaExtractor:<init>	()V
    //   29: astore 14
    //   31: aload 14
    //   33: aload_0
    //   34: invokevirtual 34	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   37: iconst_0
    //   38: istore_3
    //   39: iload_3
    //   40: aload 14
    //   42: invokevirtual 38	android/media/MediaExtractor:getTrackCount	()I
    //   45: if_icmpge +31 -> 76
    //   48: aload 14
    //   50: iload_3
    //   51: invokevirtual 42	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   54: ldc 44
    //   56: invokevirtual 50	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: ldc 52
    //   61: invokevirtual 58	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq +267 -> 331
    //   67: aload 14
    //   69: iload_3
    //   70: invokevirtual 62	android/media/MediaExtractor:selectTrack	(I)V
    //   73: goto +3 -> 76
    //   76: aload 14
    //   78: lload_1
    //   79: ldc2_w 63
    //   82: ldiv
    //   83: ldc2_w 65
    //   86: lmul
    //   87: iconst_0
    //   88: invokevirtual 70	android/media/MediaExtractor:seekTo	(JI)V
    //   91: aload 14
    //   93: invokevirtual 74	android/media/MediaExtractor:getSampleTime	()J
    //   96: lstore 10
    //   98: aload 14
    //   100: invokevirtual 77	android/media/MediaExtractor:getSampleFlags	()I
    //   103: istore_3
    //   104: lconst_0
    //   105: lstore 6
    //   107: aload 14
    //   109: invokevirtual 81	android/media/MediaExtractor:advance	()Z
    //   112: ifeq +38 -> 150
    //   115: aload 14
    //   117: invokevirtual 74	android/media/MediaExtractor:getSampleTime	()J
    //   120: lstore 6
    //   122: aload 14
    //   124: invokevirtual 77	android/media/MediaExtractor:getSampleFlags	()I
    //   127: istore 5
    //   129: lload 6
    //   131: lload 10
    //   133: lsub
    //   134: lstore 8
    //   136: lload 8
    //   138: lstore 6
    //   140: iload 5
    //   142: iconst_1
    //   143: if_icmpne -36 -> 107
    //   146: lload 8
    //   148: lstore 6
    //   150: getstatic 83	com/tencent/qcircle/tavcut/util/VideoUtil:TAG	Ljava/lang/String;
    //   153: astore_0
    //   154: new 85	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   161: astore 13
    //   163: aload 13
    //   165: ldc 88
    //   167: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 13
    //   173: lload 10
    //   175: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 13
    //   181: ldc 97
    //   183: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 13
    //   189: iload_3
    //   190: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 13
    //   196: ldc 102
    //   198: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 13
    //   204: lload_1
    //   205: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 13
    //   211: ldc 104
    //   213: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 13
    //   219: lload 6
    //   221: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_0
    //   226: aload 13
    //   228: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 114	com/tencent/qcircle/tavcut/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: iload 4
    //   236: istore_3
    //   237: lload 6
    //   239: lconst_0
    //   240: lcmp
    //   241: ifle +13 -> 254
    //   244: lload 6
    //   246: ldc2_w 65
    //   249: ldiv
    //   250: lstore_1
    //   251: lload_1
    //   252: l2i
    //   253: istore_3
    //   254: aload 14
    //   256: invokevirtual 117	android/media/MediaExtractor:release	()V
    //   259: iload_3
    //   260: ireturn
    //   261: astore_0
    //   262: goto +53 -> 315
    //   265: astore 13
    //   267: aload 14
    //   269: astore_0
    //   270: aload 13
    //   272: astore 14
    //   274: goto +16 -> 290
    //   277: astore_0
    //   278: aload 13
    //   280: astore 14
    //   282: goto +33 -> 315
    //   285: astore 14
    //   287: aload 15
    //   289: astore_0
    //   290: aload_0
    //   291: astore 13
    //   293: getstatic 83	com/tencent/qcircle/tavcut/util/VideoUtil:TAG	Ljava/lang/String;
    //   296: ldc 119
    //   298: aload 14
    //   300: invokestatic 123	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: aload_0
    //   304: ifnull +23 -> 327
    //   307: aload_0
    //   308: invokevirtual 117	android/media/MediaExtractor:release	()V
    //   311: sipush 1000
    //   314: ireturn
    //   315: aload 14
    //   317: ifnull +8 -> 325
    //   320: aload 14
    //   322: invokevirtual 117	android/media/MediaExtractor:release	()V
    //   325: aload_0
    //   326: athrow
    //   327: sipush 1000
    //   330: ireturn
    //   331: iload_3
    //   332: iconst_1
    //   333: iadd
    //   334: istore_3
    //   335: goto -296 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramString	String
    //   0	338	1	paramLong	long
    //   38	297	3	i	int
    //   9	226	4	j	int
    //   127	17	5	k	int
    //   105	140	6	l1	long
    //   134	13	8	l2	long
    //   96	78	10	l3	long
    //   4	8	12	bool	boolean
    //   20	207	13	localStringBuilder	java.lang.StringBuilder
    //   265	14	13	localException1	java.lang.Exception
    //   291	1	13	str	String
    //   29	252	14	localObject1	Object
    //   285	36	14	localException2	java.lang.Exception
    //   17	271	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	261	finally
    //   39	73	261	finally
    //   76	104	261	finally
    //   107	129	261	finally
    //   150	234	261	finally
    //   244	251	261	finally
    //   31	37	265	java/lang/Exception
    //   39	73	265	java/lang/Exception
    //   76	104	265	java/lang/Exception
    //   107	129	265	java/lang/Exception
    //   150	234	265	java/lang/Exception
    //   244	251	265	java/lang/Exception
    //   22	31	277	finally
    //   293	303	277	finally
    //   22	31	285	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.util.VideoUtil
 * JD-Core Version:    0.7.0.1
 */