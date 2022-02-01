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
    //   15: ifne +33 -> 48
    //   18: ldc 29
    //   20: aload_0
    //   21: invokestatic 27	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   24: ifne +24 -> 48
    //   27: ldc 31
    //   29: aload_0
    //   30: invokestatic 27	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   33: istore_3
    //   34: iload_3
    //   35: ifne +13 -> 48
    //   38: aload 6
    //   40: astore 4
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload 4
    //   47: areturn
    //   48: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   51: ifnonnull +13 -> 64
    //   54: new 33	java/util/HashMap
    //   57: dup
    //   58: invokespecial 34	java/util/HashMap:<init>	()V
    //   61: putstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   64: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   67: aload_0
    //   68: invokevirtual 38	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   71: ifeq +18 -> 89
    //   74: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   77: aload_0
    //   78: invokevirtual 42	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 44	java/lang/String
    //   84: astore 4
    //   86: goto -44 -> 42
    //   89: new 46	android/media/MediaCodecList
    //   92: dup
    //   93: iconst_1
    //   94: invokespecial 49	android/media/MediaCodecList:<init>	(I)V
    //   97: astore 7
    //   99: aload 6
    //   101: astore 4
    //   103: aload 7
    //   105: ifnull -63 -> 42
    //   108: aload 7
    //   110: invokevirtual 53	android/media/MediaCodecList:getCodecInfos	()[Landroid/media/MediaCodecInfo;
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
    //   147: invokevirtual 59	android/media/MediaCodecInfo:isEncoder	()Z
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
    //   165: invokevirtual 63	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   168: astore 4
    //   170: aload 4
    //   172: ifnull -17 -> 155
    //   175: aload 4
    //   177: ldc 65
    //   179: invokevirtual 71	android/media/MediaCodecInfo$CodecCapabilities:isFeatureSupported	(Ljava/lang/String;)Z
    //   182: ifeq -27 -> 155
    //   185: aload 6
    //   187: invokevirtual 75	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   190: astore 4
    //   192: getstatic 11	com/tencent/thumbplayer/core/common/TPUnitendCodecUtils:mSecureDecoderNameMaps	Ljava/util/HashMap;
    //   195: aload_0
    //   196: aload 4
    //   198: invokevirtual 79	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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