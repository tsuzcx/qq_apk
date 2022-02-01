package com.tencent.xaction.api.util;

public class AssetsUtils
{
  /* Error */
  public static boolean a(android.content.res.AssetManager paramAssetManager, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 22	java/io/File:getParentFile	()Ljava/io/File;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +27 -> 44
    //   20: aload 4
    //   22: invokevirtual 26	java/io/File:exists	()Z
    //   25: ifne +9 -> 34
    //   28: aload 4
    //   30: invokevirtual 29	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: aload 4
    //   36: invokevirtual 32	java/io/File:isDirectory	()Z
    //   39: ifne +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual 38	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   49: astore_0
    //   50: new 40	java/io/FileOutputStream
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 43	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore 5
    //   60: aload_0
    //   61: astore_1
    //   62: aload 5
    //   64: astore_2
    //   65: sipush 1024
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: astore_1
    //   74: aload 5
    //   76: astore_2
    //   77: aload_0
    //   78: aload 4
    //   80: invokevirtual 49	java/io/InputStream:read	([B)I
    //   83: istore_3
    //   84: iload_3
    //   85: iconst_m1
    //   86: if_icmpeq +32 -> 118
    //   89: aload_0
    //   90: astore_1
    //   91: aload 5
    //   93: astore_2
    //   94: aload 5
    //   96: aload 4
    //   98: iconst_0
    //   99: iload_3
    //   100: invokevirtual 53	java/io/FileOutputStream:write	([BII)V
    //   103: aload_0
    //   104: astore_1
    //   105: aload 5
    //   107: astore_2
    //   108: aload_0
    //   109: aload 4
    //   111: invokevirtual 49	java/io/InputStream:read	([B)I
    //   114: istore_3
    //   115: goto -31 -> 84
    //   118: aload_0
    //   119: astore_1
    //   120: aload 5
    //   122: astore_2
    //   123: aload 5
    //   125: invokevirtual 56	java/io/FileOutputStream:flush	()V
    //   128: aload_0
    //   129: ifnull +15 -> 144
    //   132: aload_0
    //   133: invokevirtual 59	java/io/InputStream:close	()V
    //   136: goto +8 -> 144
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   144: aload 5
    //   146: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   149: iconst_1
    //   150: ireturn
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: aload_0
    //   160: astore 4
    //   162: aload 5
    //   164: astore_0
    //   165: aload_1
    //   166: astore 5
    //   168: goto +38 -> 206
    //   171: astore 4
    //   173: aconst_null
    //   174: astore_2
    //   175: goto +80 -> 255
    //   178: astore 5
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_0
    //   183: astore 4
    //   185: aload_1
    //   186: astore_0
    //   187: goto +19 -> 206
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_2
    //   194: aload_2
    //   195: astore_0
    //   196: goto +59 -> 255
    //   199: astore 5
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_0
    //   204: astore 4
    //   206: aload 4
    //   208: astore_1
    //   209: aload_0
    //   210: astore_2
    //   211: aload 5
    //   213: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   216: aload 4
    //   218: ifnull +16 -> 234
    //   221: aload 4
    //   223: invokevirtual 59	java/io/InputStream:close	()V
    //   226: goto +8 -> 234
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   234: aload_0
    //   235: ifnull +14 -> 249
    //   238: aload_0
    //   239: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   249: iconst_0
    //   250: ireturn
    //   251: astore 4
    //   253: aload_1
    //   254: astore_0
    //   255: aload_0
    //   256: ifnull +15 -> 271
    //   259: aload_0
    //   260: invokevirtual 59	java/io/InputStream:close	()V
    //   263: goto +8 -> 271
    //   266: astore_0
    //   267: aload_0
    //   268: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   271: aload_2
    //   272: ifnull +15 -> 287
    //   275: aload_2
    //   276: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   279: goto +8 -> 287
    //   282: astore_0
    //   283: aload_0
    //   284: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   287: goto +6 -> 293
    //   290: aload 4
    //   292: athrow
    //   293: goto -3 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramAssetManager	android.content.res.AssetManager
    //   0	296	1	paramString1	java.lang.String
    //   0	296	2	paramString2	java.lang.String
    //   83	32	3	i	int
    //   13	148	4	localObject1	Object
    //   171	1	4	localObject2	Object
    //   183	1	4	localAssetManager1	android.content.res.AssetManager
    //   190	1	4	localObject3	Object
    //   204	18	4	localAssetManager2	android.content.res.AssetManager
    //   251	40	4	localObject4	Object
    //   58	109	5	localObject5	Object
    //   178	1	5	localException1	java.lang.Exception
    //   199	13	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   132	136	139	java/lang/Exception
    //   144	149	151	java/lang/Exception
    //   65	72	158	java/lang/Exception
    //   77	84	158	java/lang/Exception
    //   94	103	158	java/lang/Exception
    //   108	115	158	java/lang/Exception
    //   123	128	158	java/lang/Exception
    //   50	60	171	finally
    //   50	60	178	java/lang/Exception
    //   44	50	190	finally
    //   44	50	199	java/lang/Exception
    //   221	226	229	java/lang/Exception
    //   238	242	244	java/lang/Exception
    //   65	72	251	finally
    //   77	84	251	finally
    //   94	103	251	finally
    //   108	115	251	finally
    //   123	128	251	finally
    //   211	216	251	finally
    //   259	263	266	java/lang/Exception
    //   275	279	282	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.AssetsUtils
 * JD-Core Version:    0.7.0.1
 */