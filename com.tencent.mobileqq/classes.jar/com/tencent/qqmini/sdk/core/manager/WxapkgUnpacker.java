package com.tencent.qqmini.sdk.core.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class WxapkgUnpacker
{
  private static final String TAG = "WxapkgUnpacker";
  
  /* Error */
  public static File createFileFromInputStream(Context paramContext, InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 19	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   10: astore 5
    //   12: aload 5
    //   14: aload_0
    //   15: invokevirtual 26	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 32	java/io/File:getPath	()Ljava/lang/String;
    //   21: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 5
    //   27: ldc 38
    //   29: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 5
    //   35: aload_2
    //   36: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: new 28	java/io/File
    //   43: dup
    //   44: aload 5
    //   46: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: new 46	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_0
    //   62: sipush 1024
    //   65: newarray byte
    //   67: astore 4
    //   69: aload_1
    //   70: aload 4
    //   72: invokevirtual 55	java/io/InputStream:read	([B)I
    //   75: istore_3
    //   76: iload_3
    //   77: ifle +14 -> 91
    //   80: aload_0
    //   81: aload 4
    //   83: iconst_0
    //   84: iload_3
    //   85: invokevirtual 61	java/io/OutputStream:write	([BII)V
    //   88: goto -19 -> 69
    //   91: aload_1
    //   92: invokevirtual 64	java/io/InputStream:close	()V
    //   95: aload_0
    //   96: invokevirtual 65	java/io/OutputStream:close	()V
    //   99: aload_2
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   106: aload_2
    //   107: areturn
    //   108: astore_2
    //   109: aload_0
    //   110: astore_1
    //   111: aload_2
    //   112: astore_0
    //   113: goto +10 -> 123
    //   116: goto +27 -> 143
    //   119: astore_0
    //   120: aload 4
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +15 -> 139
    //   127: aload_1
    //   128: invokevirtual 65	java/io/OutputStream:close	()V
    //   131: goto +8 -> 139
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   139: aload_0
    //   140: athrow
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +14 -> 158
    //   147: aload_0
    //   148: invokevirtual 65	java/io/OutputStream:close	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: goto -20 -> 141
    //   164: astore_1
    //   165: goto -49 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   0	168	1	paramInputStream	InputStream
    //   0	168	2	paramString	String
    //   75	10	3	i	int
    //   1	120	4	arrayOfByte	byte[]
    //   10	35	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   95	99	101	java/io/IOException
    //   62	69	108	finally
    //   69	76	108	finally
    //   80	88	108	finally
    //   91	95	108	finally
    //   3	62	119	finally
    //   127	131	134	java/io/IOException
    //   147	151	153	java/io/IOException
    //   3	62	160	java/io/IOException
    //   62	69	164	java/io/IOException
    //   69	76	164	java/io/IOException
    //   80	88	164	java/io/IOException
    //   91	95	164	java/io/IOException
  }
  
  public static File getWxapkgFileInAssets(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getAssets();
    InputStream localInputStream;
    try
    {
      localObject = ((AssetManager)localObject).open(paramString);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localInputStream = null;
    }
    if (localInputStream != null) {
      return createFileFromInputStream(paramContext, localInputStream, paramString);
    }
    return null;
  }
  
  /* Error */
  private static boolean unPacker(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +498 -> 502
    //   7: aload_1
    //   8: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +49 -> 69
    //   23: new 19	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   30: astore 7
    //   32: aload 7
    //   34: new 28	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 7
    //   51: ldc 100
    //   53: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 7
    //   59: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_2
    //   64: astore 7
    //   66: goto +16 -> 82
    //   69: new 28	java/io/File
    //   72: dup
    //   73: aload_2
    //   74: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: astore 7
    //   82: new 102	java/io/RandomAccessFile
    //   85: dup
    //   86: aload_0
    //   87: ldc 104
    //   89: invokespecial 107	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 111	java/io/RandomAccessFile:readByte	()B
    //   97: bipush 190
    //   99: if_icmpne +363 -> 462
    //   102: aload_2
    //   103: ldc2_w 112
    //   106: invokevirtual 117	java/io/RandomAccessFile:seek	(J)V
    //   109: aload_2
    //   110: invokevirtual 121	java/io/RandomAccessFile:readInt	()I
    //   113: istore 5
    //   115: new 123	java/util/ArrayList
    //   118: dup
    //   119: iload 5
    //   121: invokespecial 126	java/util/ArrayList:<init>	(I)V
    //   124: astore 9
    //   126: iconst_0
    //   127: istore 4
    //   129: iload 4
    //   131: iload 5
    //   133: if_icmpge +240 -> 373
    //   136: aload_2
    //   137: invokevirtual 121	java/io/RandomAccessFile:readInt	()I
    //   140: istore 6
    //   142: iload 6
    //   144: newarray byte
    //   146: astore_0
    //   147: aload_2
    //   148: aload_0
    //   149: iconst_0
    //   150: iload 6
    //   152: invokevirtual 129	java/io/RandomAccessFile:read	([BII)I
    //   155: pop
    //   156: new 28	java/io/File
    //   159: dup
    //   160: new 131	java/lang/String
    //   163: dup
    //   164: aload_0
    //   165: iconst_0
    //   166: iload 6
    //   168: invokespecial 133	java/lang/String:<init>	([BII)V
    //   171: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   177: astore 8
    //   179: aload 8
    //   181: astore_0
    //   182: aload 7
    //   184: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +155 -> 342
    //   190: aload 8
    //   192: aload 7
    //   194: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   197: ifne +111 -> 308
    //   200: iload_3
    //   201: ifeq +101 -> 302
    //   204: aload 7
    //   206: aload 8
    //   208: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   211: ifne +61 -> 272
    //   214: aload 7
    //   216: aload 8
    //   218: invokevirtual 140	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   221: ifeq +6 -> 227
    //   224: goto +48 -> 272
    //   227: new 19	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   234: astore_0
    //   235: aload_0
    //   236: aload 7
    //   238: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_0
    //   243: ldc 100
    //   245: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_0
    //   250: getstatic 143	java/io/File:separator	Ljava/lang/String;
    //   253: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_0
    //   258: aload 8
    //   260: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_0
    //   265: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore_0
    //   269: goto +73 -> 342
    //   272: new 19	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   279: astore_0
    //   280: aload_0
    //   281: aload 7
    //   283: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_0
    //   288: ldc 100
    //   290: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_0
    //   295: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: astore_0
    //   299: goto +43 -> 342
    //   302: aload_2
    //   303: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   306: iconst_0
    //   307: ireturn
    //   308: new 19	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   315: astore_0
    //   316: aload_0
    //   317: aload 7
    //   319: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_0
    //   324: ldc 100
    //   326: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 8
    //   332: aload 7
    //   334: aload_0
    //   335: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokevirtual 148	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   341: astore_0
    //   342: aload 9
    //   344: new 150	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile
    //   347: dup
    //   348: aload_0
    //   349: aload_2
    //   350: invokevirtual 121	java/io/RandomAccessFile:readInt	()I
    //   353: aload_2
    //   354: invokevirtual 121	java/io/RandomAccessFile:readInt	()I
    //   357: invokespecial 153	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:<init>	(Ljava/lang/String;II)V
    //   360: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   363: pop
    //   364: iload 4
    //   366: iconst_1
    //   367: iadd
    //   368: istore 4
    //   370: goto -241 -> 129
    //   373: aload 9
    //   375: invokevirtual 161	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   378: astore_0
    //   379: aload_0
    //   380: invokeinterface 167 1 0
    //   385: ifeq +71 -> 456
    //   388: aload_0
    //   389: invokeinterface 171 1 0
    //   394: checkcast 150	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile
    //   397: astore 7
    //   399: new 28	java/io/File
    //   402: dup
    //   403: aload_1
    //   404: aload 7
    //   406: getfield 174	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:name	Ljava/lang/String;
    //   409: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: astore 8
    //   414: aload_2
    //   415: aload 7
    //   417: getfield 179	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:start	I
    //   420: i2l
    //   421: invokevirtual 117	java/io/RandomAccessFile:seek	(J)V
    //   424: aload 7
    //   426: getfield 182	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:length	I
    //   429: newarray byte
    //   431: astore 9
    //   433: aload_2
    //   434: aload 9
    //   436: iconst_0
    //   437: aload 7
    //   439: getfield 182	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:length	I
    //   442: invokevirtual 129	java/io/RandomAccessFile:read	([BII)I
    //   445: pop
    //   446: aload 8
    //   448: aload 9
    //   450: invokestatic 185	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker:write	(Ljava/io/File;[B)V
    //   453: goto -74 -> 379
    //   456: aload_2
    //   457: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   460: iconst_1
    //   461: ireturn
    //   462: new 187	java/lang/RuntimeException
    //   465: dup
    //   466: ldc 189
    //   468: invokespecial 190	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   471: athrow
    //   472: astore_0
    //   473: goto +9 -> 482
    //   476: goto +18 -> 494
    //   479: astore_0
    //   480: aconst_null
    //   481: astore_2
    //   482: aload_2
    //   483: ifnull +7 -> 490
    //   486: aload_2
    //   487: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   490: aload_0
    //   491: athrow
    //   492: aconst_null
    //   493: astore_2
    //   494: aload_2
    //   495: ifnull +7 -> 502
    //   498: aload_2
    //   499: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   502: iconst_0
    //   503: ireturn
    //   504: astore_0
    //   505: goto -13 -> 492
    //   508: astore_0
    //   509: goto -33 -> 476
    //   512: astore_0
    //   513: iconst_0
    //   514: ireturn
    //   515: astore_0
    //   516: goto -56 -> 460
    //   519: astore_1
    //   520: goto -30 -> 490
    //   523: astore_0
    //   524: iconst_0
    //   525: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	paramString1	String
    //   0	526	1	paramString2	String
    //   0	526	2	paramString3	String
    //   0	526	3	paramBoolean	boolean
    //   127	242	4	i	int
    //   113	21	5	j	int
    //   140	27	6	k	int
    //   30	408	7	localObject1	Object
    //   177	270	8	localObject2	Object
    //   124	325	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   93	126	472	finally
    //   136	179	472	finally
    //   182	200	472	finally
    //   204	224	472	finally
    //   227	269	472	finally
    //   272	299	472	finally
    //   308	342	472	finally
    //   342	364	472	finally
    //   373	379	472	finally
    //   379	453	472	finally
    //   462	472	472	finally
    //   82	93	479	finally
    //   82	93	504	java/lang/Exception
    //   93	126	508	java/lang/Exception
    //   136	179	508	java/lang/Exception
    //   182	200	508	java/lang/Exception
    //   204	224	508	java/lang/Exception
    //   227	269	508	java/lang/Exception
    //   272	299	508	java/lang/Exception
    //   308	342	508	java/lang/Exception
    //   342	364	508	java/lang/Exception
    //   373	379	508	java/lang/Exception
    //   379	453	508	java/lang/Exception
    //   462	472	508	java/lang/Exception
    //   302	306	512	java/lang/Exception
    //   456	460	515	java/lang/Exception
    //   486	490	519	java/lang/Exception
    //   498	502	523	java/lang/Exception
  }
  
  private static boolean unpackAtomically(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!new File(paramString1).exists())
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically fail !zipFile.exists() ");
      return false;
    }
    String str = new File(paramString2, paramString3).getAbsolutePath();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("Tmp");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.delete((String)localObject, false);
    if (!unPacker(paramString1, paramString2, paramString3, paramBoolean))
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically unPacker fail");
      return false;
    }
    paramString2 = new File((String)localObject);
    if (!paramString2.exists())
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically !uniqueFolderTmpFile.exists()");
      return false;
    }
    paramString3 = new File(str);
    FileUtils.delete(str, false);
    if (!FileUtils.renameFile(paramString2, paramString3))
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically !FileUtils.renameFile(uniqueFolderTmpFile, uniqueFolderFile)");
      return false;
    }
    if (!paramString3.exists())
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically !uniqueFolderFile.exists()");
      return false;
    }
    FileUtils.delete(paramString1, true);
    return true;
  }
  
  public static boolean unpackSync(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = unpackSync(paramString1, paramString2, "");
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static boolean unpackSync(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = unpackSync(paramString1, paramString2, paramString3, false);
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static boolean unpackSync(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        boolean bool = new File(paramString2, paramString3).exists();
        if (bool) {
          return true;
        }
        paramBoolean = unpackAtomically(paramString1, paramString2, paramString3, paramBoolean);
        return paramBoolean;
      }
      QMLog.e("WxapkgUnpacker", "wxapkgPath is null ");
      return false;
    }
    finally {}
  }
  
  private static void write(File paramFile, byte[] paramArrayOfByte)
  {
    if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs()))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Create folder fail:");
      paramArrayOfByte.append(paramFile.getParentFile().getAbsolutePath());
      throw new RuntimeException(paramArrayOfByte.toString());
    }
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramFile.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker
 * JD-Core Version:    0.7.0.1
 */