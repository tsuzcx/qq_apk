package com.tencent.thumbplayer.core.common;

import java.util.HashMap;

public class TPUnitendCodecUtils
{
  private static int DolbyVisionProfileDvavPen;
  private static int DolbyVisionProfileDvavPer;
  private static int DolbyVisionProfileDvavSe = 9;
  private static int DolbyVisionProfileDvheDen;
  private static int DolbyVisionProfileDvheDer;
  private static int DolbyVisionProfileDvheDtb;
  private static int DolbyVisionProfileDvheDth;
  private static int DolbyVisionProfileDvheDtr;
  private static int DolbyVisionProfileDvheSt;
  private static int DolbyVisionProfileDvheStn;
  private static HashMap<String, String> mSecureDecoderNameMaps = null;
  
  static
  {
    DolbyVisionProfileDvavPer = 0;
    DolbyVisionProfileDvavPen = 1;
    DolbyVisionProfileDvheDer = 2;
    DolbyVisionProfileDvheDen = 3;
    DolbyVisionProfileDvheDtr = 4;
    DolbyVisionProfileDvheStn = 5;
    DolbyVisionProfileDvheDth = 6;
    DolbyVisionProfileDvheDtb = 7;
    DolbyVisionProfileDvheSt = 8;
  }
  
  public static int convertOmxProfileToDolbyVision(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      TPNativeLog.printLog(2, "TPUnitendCodecUtils", "convertOmxProfileToDolbyVision omxProfile:" + paramInt + " dolbyVisionProfile:" + i);
      return i;
      i = DolbyVisionProfileDvavPer;
      continue;
      i = DolbyVisionProfileDvavPen;
      continue;
      i = DolbyVisionProfileDvheDer;
      continue;
      i = DolbyVisionProfileDvheDen;
      continue;
      i = DolbyVisionProfileDvheDtr;
      continue;
      i = DolbyVisionProfileDvheStn;
      continue;
      i = DolbyVisionProfileDvheDth;
      continue;
      i = DolbyVisionProfileDvheDtb;
      continue;
      i = DolbyVisionProfileDvheSt;
      continue;
      i = DolbyVisionProfileDvavSe;
    }
  }
  
  /* Error */
  public static String getDolbyVisionDecoderName(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 80
    //   5: aload_0
    //   6: invokestatic 86	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   9: istore 7
    //   11: iload 7
    //   13: ifne +12 -> 25
    //   16: aconst_null
    //   17: astore 8
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload 8
    //   24: areturn
    //   25: getstatic 91	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 21
    //   30: if_icmpge +9 -> 39
    //   33: aconst_null
    //   34: astore 8
    //   36: goto -17 -> 19
    //   39: new 93	android/media/MediaCodecList
    //   42: dup
    //   43: iconst_1
    //   44: invokespecial 96	android/media/MediaCodecList:<init>	(I)V
    //   47: astore 8
    //   49: aload 8
    //   51: ifnonnull +9 -> 60
    //   54: aconst_null
    //   55: astore 8
    //   57: goto -38 -> 19
    //   60: aload 8
    //   62: invokevirtual 100	android/media/MediaCodecList:getCodecInfos	()[Landroid/media/MediaCodecInfo;
    //   65: astore 12
    //   67: aload 12
    //   69: ifnonnull +9 -> 78
    //   72: aconst_null
    //   73: astore 8
    //   75: goto -56 -> 19
    //   78: aload 12
    //   80: arraylength
    //   81: istore 5
    //   83: iconst_0
    //   84: istore_2
    //   85: aconst_null
    //   86: astore 9
    //   88: aload 9
    //   90: astore 8
    //   92: iload_2
    //   93: iload 5
    //   95: if_icmpge -76 -> 19
    //   98: aload 12
    //   100: iload_2
    //   101: aaload
    //   102: astore 13
    //   104: iconst_2
    //   105: ldc 50
    //   107: new 52	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   114: ldc 102
    //   116: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 13
    //   121: invokevirtual 107	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   124: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 74	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   133: aload 13
    //   135: invokevirtual 111	android/media/MediaCodecInfo:isEncoder	()Z
    //   138: istore 7
    //   140: iload 7
    //   142: ifeq +18 -> 160
    //   145: aload 9
    //   147: astore 11
    //   149: iload_2
    //   150: iconst_1
    //   151: iadd
    //   152: istore_2
    //   153: aload 11
    //   155: astore 9
    //   157: goto -69 -> 88
    //   160: aload 13
    //   162: aload_0
    //   163: invokevirtual 115	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   166: astore 10
    //   168: aload 9
    //   170: astore 11
    //   172: aload 10
    //   174: ifnull -25 -> 149
    //   177: aload 10
    //   179: getfield 121	android/media/MediaCodecInfo$CodecCapabilities:profileLevels	[Landroid/media/MediaCodecInfo$CodecProfileLevel;
    //   182: astore 11
    //   184: iconst_0
    //   185: istore 4
    //   187: aload 9
    //   189: astore 8
    //   191: iload 4
    //   193: aload 11
    //   195: arraylength
    //   196: if_icmpge +110 -> 306
    //   199: aload 11
    //   201: iload 4
    //   203: aaload
    //   204: getfield 126	android/media/MediaCodecInfo$CodecProfileLevel:profile	I
    //   207: invokestatic 128	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:convertOmxProfileToDolbyVision	(I)I
    //   210: istore 6
    //   212: iload 6
    //   214: iload_1
    //   215: if_icmpne +153 -> 368
    //   218: iconst_2
    //   219: ldc 50
    //   221: new 52	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   228: ldc 130
    //   230: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 4
    //   235: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: ldc 132
    //   240: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload 6
    //   245: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc 134
    //   250: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload_1
    //   254: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: ldc 136
    //   259: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload_3
    //   263: invokevirtual 139	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   266: ldc 141
    //   268: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 13
    //   273: invokevirtual 107	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   276: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 74	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   285: iload_3
    //   286: ifeq +72 -> 358
    //   289: aload 10
    //   291: ldc 143
    //   293: invokevirtual 147	android/media/MediaCodecInfo$CodecCapabilities:isFeatureSupported	(Ljava/lang/String;)Z
    //   296: ifeq +72 -> 368
    //   299: aload 13
    //   301: invokevirtual 107	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   304: astore 8
    //   306: aload 8
    //   308: astore 11
    //   310: aload 8
    //   312: ifnull -163 -> 149
    //   315: iconst_2
    //   316: ldc 50
    //   318: new 52	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   325: ldc 102
    //   327: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 8
    //   332: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 74	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   341: goto -322 -> 19
    //   344: astore_0
    //   345: ldc 2
    //   347: monitorexit
    //   348: aload_0
    //   349: athrow
    //   350: astore 8
    //   352: aconst_null
    //   353: astore 10
    //   355: goto -187 -> 168
    //   358: aload 13
    //   360: invokevirtual 107	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   363: astore 8
    //   365: goto -59 -> 306
    //   368: iload 4
    //   370: iconst_1
    //   371: iadd
    //   372: istore 4
    //   374: goto -187 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString	String
    //   0	377	1	paramInt1	int
    //   0	377	2	paramInt2	int
    //   0	377	3	paramBoolean	boolean
    //   185	188	4	i	int
    //   81	15	5	j	int
    //   210	34	6	k	int
    //   9	132	7	bool	boolean
    //   17	314	8	localObject1	Object
    //   350	1	8	localException	java.lang.Exception
    //   363	1	8	str	String
    //   86	102	9	localObject2	Object
    //   166	188	10	localCodecCapabilities	android.media.MediaCodecInfo.CodecCapabilities
    //   147	162	11	localObject3	Object
    //   65	34	12	arrayOfMediaCodecInfo	android.media.MediaCodecInfo[]
    //   102	257	13	localMediaCodecInfo	android.media.MediaCodecInfo
    // Exception table:
    //   from	to	target	type
    //   3	11	344	finally
    //   25	33	344	finally
    //   39	49	344	finally
    //   60	67	344	finally
    //   78	83	344	finally
    //   104	140	344	finally
    //   160	168	344	finally
    //   177	184	344	finally
    //   191	212	344	finally
    //   218	285	344	finally
    //   289	306	344	finally
    //   315	341	344	finally
    //   358	365	344	finally
    //   160	168	350	java/lang/Exception
  }
  
  /* Error */
  public static String getSecureDecoderName(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 2
    //   8: monitorenter
    //   9: ldc 151
    //   11: aload_0
    //   12: invokestatic 86	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   15: ifne +33 -> 48
    //   18: ldc 153
    //   20: aload_0
    //   21: invokestatic 86	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   24: ifne +24 -> 48
    //   27: ldc 80
    //   29: aload_0
    //   30: invokestatic 86	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   33: istore_3
    //   34: iload_3
    //   35: ifne +13 -> 48
    //   38: aload 6
    //   40: astore 4
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload 4
    //   47: areturn
    //   48: getstatic 22	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   51: ifnonnull +13 -> 64
    //   54: new 155	java/util/HashMap
    //   57: dup
    //   58: invokespecial 156	java/util/HashMap:<init>	()V
    //   61: putstatic 22	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   64: getstatic 22	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   67: aload_0
    //   68: invokevirtual 160	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   71: ifeq +18 -> 89
    //   74: getstatic 22	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   77: aload_0
    //   78: invokevirtual 164	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 166	java/lang/String
    //   84: astore 4
    //   86: goto -44 -> 42
    //   89: new 93	android/media/MediaCodecList
    //   92: dup
    //   93: iconst_1
    //   94: invokespecial 96	android/media/MediaCodecList:<init>	(I)V
    //   97: astore 7
    //   99: aload 6
    //   101: astore 4
    //   103: aload 7
    //   105: ifnull -63 -> 42
    //   108: aload 7
    //   110: invokevirtual 100	android/media/MediaCodecList:getCodecInfos	()[Landroid/media/MediaCodecInfo;
    //   113: astore 7
    //   115: aload 6
    //   117: astore 4
    //   119: aload 7
    //   121: ifnull -79 -> 42
    //   124: aload 7
    //   126: arraylength
    //   127: istore_2
    //   128: iconst_0
    //   129: istore_1
    //   130: aload 5
    //   132: astore 4
    //   134: iload_1
    //   135: iload_2
    //   136: if_icmpge +56 -> 192
    //   139: aload 7
    //   141: iload_1
    //   142: aaload
    //   143: astore 6
    //   145: aload 6
    //   147: invokevirtual 111	android/media/MediaCodecInfo:isEncoder	()Z
    //   150: istore_3
    //   151: iload_3
    //   152: ifeq +10 -> 162
    //   155: iload_1
    //   156: iconst_1
    //   157: iadd
    //   158: istore_1
    //   159: goto -29 -> 130
    //   162: aload 6
    //   164: aload_0
    //   165: invokevirtual 115	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   168: astore 4
    //   170: aload 4
    //   172: ifnull -17 -> 155
    //   175: aload 4
    //   177: ldc 143
    //   179: invokevirtual 147	android/media/MediaCodecInfo$CodecCapabilities:isFeatureSupported	(Ljava/lang/String;)Z
    //   182: ifeq -27 -> 155
    //   185: aload 6
    //   187: invokevirtual 107	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   190: astore 4
    //   192: getstatic 22	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   195: aload_0
    //   196: aload 4
    //   198: invokevirtual 170	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: goto -160 -> 42
    //   205: astore_0
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload_0
    //   210: athrow
    //   211: astore 4
    //   213: aconst_null
    //   214: astore 4
    //   216: goto -46 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramString	String
    //   129	30	1	i	int
    //   127	10	2	j	int
    //   33	119	3	bool	boolean
    //   40	157	4	localObject1	Object
    //   211	1	4	localException	java.lang.Exception
    //   214	1	4	localObject2	Object
    //   1	130	5	localObject3	Object
    //   4	182	6	localObject4	Object
    //   97	43	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   9	34	205	finally
    //   48	64	205	finally
    //   64	86	205	finally
    //   89	99	205	finally
    //   108	115	205	finally
    //   124	128	205	finally
    //   145	151	205	finally
    //   162	170	205	finally
    //   175	192	205	finally
    //   192	202	205	finally
    //   162	170	211	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPUnitendCodecUtils
 * JD-Core Version:    0.7.0.1
 */