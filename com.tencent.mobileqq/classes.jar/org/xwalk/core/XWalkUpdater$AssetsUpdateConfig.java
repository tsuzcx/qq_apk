package org.xwalk.core;

public class XWalkUpdater$AssetsUpdateConfig
  extends XWalkUpdater.EmbededUpdateConfig
{
  public XWalkUpdater$AssetsUpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt, paramString1, paramString2);
  }
  
  /* Error */
  public boolean copyPackageToLocal(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 21	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   3: invokevirtual 27	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 6
    //   13: aload 4
    //   15: aload_1
    //   16: invokevirtual 33	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore 5
    //   21: new 35	java/io/FileOutputStream
    //   24: dup
    //   25: aload_0
    //   26: invokevirtual 39	org/xwalk/core/XWalkUpdater$AssetsUpdateConfig:getDownloadPath	()Ljava/lang/String;
    //   29: invokespecial 42	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: ldc 43
    //   35: newarray byte
    //   37: astore_1
    //   38: aload 5
    //   40: aload_1
    //   41: invokevirtual 49	java/io/InputStream:read	([B)I
    //   44: istore_3
    //   45: iload_3
    //   46: iconst_m1
    //   47: if_icmpeq +13 -> 60
    //   50: aload_2
    //   51: aload_1
    //   52: iconst_0
    //   53: iload_3
    //   54: invokevirtual 55	java/io/OutputStream:write	([BII)V
    //   57: goto -19 -> 38
    //   60: aload_2
    //   61: invokevirtual 59	java/io/OutputStream:flush	()V
    //   64: aload 5
    //   66: ifnull +8 -> 74
    //   69: aload 5
    //   71: invokevirtual 62	java/io/InputStream:close	()V
    //   74: aload_2
    //   75: invokevirtual 63	java/io/OutputStream:close	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore_1
    //   81: aload_2
    //   82: astore 4
    //   84: goto +12 -> 96
    //   87: astore 4
    //   89: goto +20 -> 109
    //   92: astore_1
    //   93: aconst_null
    //   94: astore 4
    //   96: aload 5
    //   98: astore_2
    //   99: aload_1
    //   100: astore 5
    //   102: goto +99 -> 201
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_2
    //   109: aload 5
    //   111: astore_1
    //   112: goto +18 -> 130
    //   115: astore 5
    //   117: aconst_null
    //   118: astore 4
    //   120: goto +81 -> 201
    //   123: astore 4
    //   125: aconst_null
    //   126: astore_2
    //   127: aload 6
    //   129: astore_1
    //   130: aload 4
    //   132: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   135: new 68	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   142: astore 5
    //   144: aload 5
    //   146: ldc 72
    //   148: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: aload 4
    //   156: invokevirtual 79	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 81
    //   165: aload 5
    //   167: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 88	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_1
    //   174: ifnull +10 -> 184
    //   177: aload_1
    //   178: invokevirtual 62	java/io/InputStream:close	()V
    //   181: goto +3 -> 184
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 63	java/io/OutputStream:close	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore 5
    //   196: aload_2
    //   197: astore 4
    //   199: aload_1
    //   200: astore_2
    //   201: aload_2
    //   202: ifnull +10 -> 212
    //   205: aload_2
    //   206: invokevirtual 62	java/io/InputStream:close	()V
    //   209: goto +3 -> 212
    //   212: aload 4
    //   214: ifnull +8 -> 222
    //   217: aload 4
    //   219: invokevirtual 63	java/io/OutputStream:close	()V
    //   222: goto +6 -> 228
    //   225: aload 5
    //   227: athrow
    //   228: goto -3 -> 225
    //   231: astore_1
    //   232: goto -158 -> 74
    //   235: astore_1
    //   236: goto -158 -> 78
    //   239: astore_1
    //   240: goto -56 -> 184
    //   243: astore_1
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_1
    //   247: goto -35 -> 212
    //   250: astore_1
    //   251: goto -29 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	AssetsUpdateConfig
    //   0	254	1	paramString1	String
    //   0	254	2	paramString2	String
    //   44	10	3	i	int
    //   6	77	4	localObject1	java.lang.Object
    //   87	1	4	localException1	java.lang.Exception
    //   94	1	4	localObject2	java.lang.Object
    //   105	1	4	localException2	java.lang.Exception
    //   118	1	4	localObject3	java.lang.Object
    //   123	32	4	localException3	java.lang.Exception
    //   197	21	4	str	String
    //   19	91	5	localObject4	java.lang.Object
    //   115	1	5	localObject5	java.lang.Object
    //   142	24	5	localStringBuilder	java.lang.StringBuilder
    //   194	32	5	localObject6	java.lang.Object
    //   11	117	6	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   33	38	80	finally
    //   38	45	80	finally
    //   50	57	80	finally
    //   60	64	80	finally
    //   33	38	87	java/lang/Exception
    //   38	45	87	java/lang/Exception
    //   50	57	87	java/lang/Exception
    //   60	64	87	java/lang/Exception
    //   21	33	92	finally
    //   21	33	105	java/lang/Exception
    //   13	21	115	finally
    //   13	21	123	java/lang/Exception
    //   130	173	194	finally
    //   69	74	231	java/lang/Exception
    //   74	78	235	java/io/IOException
    //   177	181	239	java/lang/Exception
    //   188	192	243	java/io/IOException
    //   205	209	246	java/lang/Exception
    //   217	222	250	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.AssetsUpdateConfig
 * JD-Core Version:    0.7.0.1
 */