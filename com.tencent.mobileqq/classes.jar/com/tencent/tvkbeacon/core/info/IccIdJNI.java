package com.tencent.tvkbeacon.core.info;

public class IccIdJNI
{
  private static volatile String a;
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	com/tencent/tvkbeacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +45 -> 55
    //   13: ldc 15
    //   15: invokestatic 21	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   18: invokestatic 24	com/tencent/tvkbeacon/core/info/IccIdJNI:collectIccid	()Ljava/lang/String;
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 29	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   28: ifeq +97 -> 125
    //   31: ldc 31
    //   33: astore 4
    //   35: aload 4
    //   37: putstatic 13	com/tencent/tvkbeacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   40: ldc 33
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: getstatic 13	com/tencent/tvkbeacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   51: aastore
    //   52: invokestatic 39	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: getstatic 13	com/tencent/tvkbeacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   58: astore 4
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload 4
    //   65: areturn
    //   66: astore 4
    //   68: ldc 15
    //   70: invokestatic 21	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   73: invokestatic 24	com/tencent/tvkbeacon/core/info/IccIdJNI:collectIccid	()Ljava/lang/String;
    //   76: astore 4
    //   78: goto -55 -> 23
    //   81: astore 4
    //   83: ldc 31
    //   85: astore 4
    //   87: ldc 41
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 44	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: goto -73 -> 23
    //   99: astore 4
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload 4
    //   106: athrow
    //   107: astore 4
    //   109: ldc 31
    //   111: astore 4
    //   113: ldc 41
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 44	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: goto -99 -> 23
    //   125: new 46	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 50	java/util/ArrayList:<init>	()V
    //   132: astore 5
    //   134: new 52	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   141: astore 7
    //   143: new 52	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   150: astore 6
    //   152: aload 4
    //   154: invokevirtual 59	java/lang/String:toCharArray	()[C
    //   157: astore 4
    //   159: aload 4
    //   161: arraylength
    //   162: istore_3
    //   163: iconst_0
    //   164: istore_2
    //   165: iconst_0
    //   166: istore_1
    //   167: iload_2
    //   168: iload_3
    //   169: if_icmpge +161 -> 330
    //   172: aload 4
    //   174: iload_2
    //   175: caload
    //   176: istore_0
    //   177: iload_0
    //   178: bipush 93
    //   180: if_icmpne +45 -> 225
    //   183: aload 5
    //   185: aload 7
    //   187: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokeinterface 68 2 0
    //   195: ifne +16 -> 211
    //   198: aload 5
    //   200: aload 7
    //   202: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokeinterface 71 2 0
    //   210: pop
    //   211: aload 7
    //   213: iconst_0
    //   214: aload 7
    //   216: invokevirtual 75	java/lang/StringBuilder:length	()I
    //   219: invokevirtual 79	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: iconst_0
    //   224: istore_1
    //   225: iload_1
    //   226: ifeq +89 -> 315
    //   229: aload 7
    //   231: iload_0
    //   232: invokevirtual 83	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: goto +79 -> 315
    //   239: iload_1
    //   240: aload 5
    //   242: invokeinterface 86 1 0
    //   247: if_icmpge +58 -> 305
    //   250: aload 5
    //   252: iload_1
    //   253: invokeinterface 90 2 0
    //   258: checkcast 55	java/lang/String
    //   261: astore 4
    //   263: aload 4
    //   265: invokevirtual 91	java/lang/String:length	()I
    //   268: bipush 20
    //   270: if_icmpne +65 -> 335
    //   273: aload 6
    //   275: aload 4
    //   277: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: iload_1
    //   282: iconst_1
    //   283: iadd
    //   284: aload 5
    //   286: invokeinterface 86 1 0
    //   291: if_icmpeq +44 -> 335
    //   294: aload 6
    //   296: ldc 96
    //   298: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: goto +33 -> 335
    //   305: aload 6
    //   307: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: astore 4
    //   312: goto -277 -> 35
    //   315: iload_0
    //   316: bipush 91
    //   318: if_icmpne +5 -> 323
    //   321: iconst_1
    //   322: istore_1
    //   323: iload_2
    //   324: iconst_1
    //   325: iadd
    //   326: istore_2
    //   327: goto -160 -> 167
    //   330: iconst_0
    //   331: istore_1
    //   332: goto -93 -> 239
    //   335: iload_1
    //   336: iconst_1
    //   337: iadd
    //   338: istore_1
    //   339: goto -100 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   176	143	0	c	char
    //   166	173	1	i	int
    //   164	163	2	j	int
    //   162	8	3	k	int
    //   6	58	4	str1	String
    //   66	1	4	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   76	1	4	str2	String
    //   81	1	4	localThrowable1	java.lang.Throwable
    //   85	1	4	str3	String
    //   99	6	4	localObject1	Object
    //   107	1	4	localThrowable2	java.lang.Throwable
    //   111	200	4	localObject2	Object
    //   132	153	5	localArrayList	java.util.ArrayList
    //   150	156	6	localStringBuilder1	java.lang.StringBuilder
    //   141	89	7	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	23	66	java/lang/UnsatisfiedLinkError
    //   68	78	81	java/lang/Throwable
    //   3	8	99	finally
    //   13	23	99	finally
    //   23	31	99	finally
    //   35	55	99	finally
    //   55	60	99	finally
    //   68	78	99	finally
    //   87	96	99	finally
    //   113	122	99	finally
    //   125	163	99	finally
    //   183	211	99	finally
    //   211	223	99	finally
    //   229	236	99	finally
    //   239	302	99	finally
    //   305	312	99	finally
    //   13	23	107	java/lang/Throwable
  }
  
  public static native String collectIccid();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.info.IccIdJNI
 * JD-Core Version:    0.7.0.1
 */