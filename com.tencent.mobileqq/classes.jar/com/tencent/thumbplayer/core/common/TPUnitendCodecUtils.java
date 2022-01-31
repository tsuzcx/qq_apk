package com.tencent.thumbplayer.core.common;

import java.util.HashMap;

public class TPUnitendCodecUtils
{
  private static HashMap<String, String> mSecureDecoderNameMaps = null;
  
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
    //   9: ldc 21
    //   11: aload_0
    //   12: invokestatic 27	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   15: ifne +24 -> 39
    //   18: ldc 29
    //   20: aload_0
    //   21: invokestatic 27	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifne +13 -> 39
    //   29: aload 6
    //   31: astore 4
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload 4
    //   38: areturn
    //   39: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   42: ifnonnull +13 -> 55
    //   45: new 31	java/util/HashMap
    //   48: dup
    //   49: invokespecial 32	java/util/HashMap:<init>	()V
    //   52: putstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   55: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   58: aload_0
    //   59: invokevirtual 36	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   62: ifeq +18 -> 80
    //   65: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   68: aload_0
    //   69: invokevirtual 40	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 42	java/lang/String
    //   75: astore 4
    //   77: goto -44 -> 33
    //   80: new 44	android/media/MediaCodecList
    //   83: dup
    //   84: iconst_1
    //   85: invokespecial 47	android/media/MediaCodecList:<init>	(I)V
    //   88: astore 7
    //   90: aload 6
    //   92: astore 4
    //   94: aload 7
    //   96: ifnull -63 -> 33
    //   99: aload 7
    //   101: invokevirtual 51	android/media/MediaCodecList:getCodecInfos	()[Landroid/media/MediaCodecInfo;
    //   104: astore 7
    //   106: aload 6
    //   108: astore 4
    //   110: aload 7
    //   112: ifnull -79 -> 33
    //   115: aload 7
    //   117: arraylength
    //   118: istore_2
    //   119: iconst_0
    //   120: istore_1
    //   121: aload 5
    //   123: astore 4
    //   125: iload_1
    //   126: iload_2
    //   127: if_icmpge +56 -> 183
    //   130: aload 7
    //   132: iload_1
    //   133: aaload
    //   134: astore 6
    //   136: aload 6
    //   138: invokevirtual 57	android/media/MediaCodecInfo:isEncoder	()Z
    //   141: istore_3
    //   142: iload_3
    //   143: ifeq +10 -> 153
    //   146: iload_1
    //   147: iconst_1
    //   148: iadd
    //   149: istore_1
    //   150: goto -29 -> 121
    //   153: aload 6
    //   155: aload_0
    //   156: invokevirtual 61	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull -17 -> 146
    //   166: aload 4
    //   168: ldc 63
    //   170: invokevirtual 69	android/media/MediaCodecInfo$CodecCapabilities:isFeatureSupported	(Ljava/lang/String;)Z
    //   173: ifeq -27 -> 146
    //   176: aload 6
    //   178: invokevirtual 73	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   181: astore 4
    //   183: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   186: aload_0
    //   187: aload 4
    //   189: invokevirtual 77	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   192: pop
    //   193: goto -160 -> 33
    //   196: astore_0
    //   197: ldc 2
    //   199: monitorexit
    //   200: aload_0
    //   201: athrow
    //   202: astore 4
    //   204: aconst_null
    //   205: astore 4
    //   207: goto -46 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString	String
    //   120	30	1	i	int
    //   118	10	2	j	int
    //   24	119	3	bool	boolean
    //   31	157	4	localObject1	Object
    //   202	1	4	localException	java.lang.Exception
    //   205	1	4	localObject2	Object
    //   1	121	5	localObject3	Object
    //   4	173	6	localObject4	Object
    //   88	43	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   9	25	196	finally
    //   39	55	196	finally
    //   55	77	196	finally
    //   80	90	196	finally
    //   99	106	196	finally
    //   115	119	196	finally
    //   136	142	196	finally
    //   153	161	196	finally
    //   166	183	196	finally
    //   183	193	196	finally
    //   153	161	202	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPUnitendCodecUtils
 * JD-Core Version:    0.7.0.1
 */