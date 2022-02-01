package com.tencent.qqmini.sdk.core.manager;

import android.content.Context;
import android.content.res.AssetManager;
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
    //   3: new 19	java/io/File
    //   6: dup
    //   7: new 21	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   14: aload_0
    //   15: invokevirtual 28	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 32	java/io/File:getPath	()Ljava/lang/String;
    //   21: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 38
    //   26: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 46	java/io/FileOutputStream
    //   43: dup
    //   44: aload_2
    //   45: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_0
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 4
    //   56: aload_1
    //   57: aload 4
    //   59: invokevirtual 55	java/io/InputStream:read	([B)I
    //   62: istore_3
    //   63: iload_3
    //   64: ifle +27 -> 91
    //   67: aload_0
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 61	java/io/OutputStream:write	([BII)V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 64	java/io/OutputStream:close	()V
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: areturn
    //   91: aload_1
    //   92: invokevirtual 65	java/io/InputStream:close	()V
    //   95: aload_2
    //   96: astore_1
    //   97: aload_0
    //   98: ifnull -9 -> 89
    //   101: aload_0
    //   102: invokevirtual 64	java/io/OutputStream:close	()V
    //   105: aload_2
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   112: aload_2
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   119: goto -32 -> 87
    //   122: astore_0
    //   123: aload 4
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 64	java/io/OutputStream:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: astore_2
    //   145: aload_0
    //   146: astore_1
    //   147: aload_2
    //   148: astore_0
    //   149: goto -23 -> 126
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -76 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	Context
    //   0	158	1	paramInputStream	InputStream
    //   0	158	2	paramString	String
    //   62	10	3	i	int
    //   1	123	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   49	56	78	java/io/IOException
    //   56	63	78	java/io/IOException
    //   67	75	78	java/io/IOException
    //   91	95	78	java/io/IOException
    //   101	105	107	java/io/IOException
    //   83	87	114	java/io/IOException
    //   3	49	122	finally
    //   130	134	136	java/io/IOException
    //   49	56	144	finally
    //   56	63	144	finally
    //   67	75	144	finally
    //   91	95	144	finally
    //   3	49	152	java/io/IOException
  }
  
  public static File getWxapkgFileInAssets(Context paramContext, String paramString)
  {
    File localFile = null;
    Object localObject1 = paramContext.getAssets();
    try
    {
      localObject1 = ((AssetManager)localObject1).open(paramString);
      if (localObject1 != null) {
        localFile = createFileFromInputStream(paramContext, (InputStream)localObject1, paramString);
      }
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  /* Error */
  private static boolean unPacker(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +80 -> 100
    //   23: new 21	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   30: new 19	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 100
    //   46: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_2
    //   54: astore 7
    //   56: aconst_null
    //   57: astore 8
    //   59: new 102	java/io/RandomAccessFile
    //   62: dup
    //   63: aload_0
    //   64: ldc 104
    //   66: invokespecial 107	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 111	java/io/RandomAccessFile:readByte	()B
    //   74: bipush 190
    //   76: if_icmpeq +40 -> 116
    //   79: new 113	java/lang/RuntimeException
    //   82: dup
    //   83: ldc 115
    //   85: invokespecial 116	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_0
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: new 19	java/io/File
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: astore 7
    //   113: goto -57 -> 56
    //   116: aload_2
    //   117: ldc2_w 118
    //   120: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   123: aload_2
    //   124: invokevirtual 127	java/io/RandomAccessFile:readInt	()I
    //   127: istore 5
    //   129: new 129	java/util/ArrayList
    //   132: dup
    //   133: iload 5
    //   135: invokespecial 132	java/util/ArrayList:<init>	(I)V
    //   138: astore 9
    //   140: iconst_0
    //   141: istore 4
    //   143: iload 4
    //   145: iload 5
    //   147: if_icmpge +219 -> 366
    //   150: aload_2
    //   151: invokevirtual 127	java/io/RandomAccessFile:readInt	()I
    //   154: istore 6
    //   156: iload 6
    //   158: newarray byte
    //   160: astore_0
    //   161: aload_2
    //   162: aload_0
    //   163: iconst_0
    //   164: iload 6
    //   166: invokevirtual 135	java/io/RandomAccessFile:read	([BII)I
    //   169: pop
    //   170: new 19	java/io/File
    //   173: dup
    //   174: new 137	java/lang/String
    //   177: dup
    //   178: aload_0
    //   179: iconst_0
    //   180: iload 6
    //   182: invokespecial 139	java/lang/String:<init>	([BII)V
    //   185: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: astore 8
    //   193: aload 8
    //   195: astore_0
    //   196: aload 7
    //   198: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +58 -> 259
    //   204: aload 8
    //   206: aload 7
    //   208: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   211: ifne +124 -> 335
    //   214: iload_3
    //   215: ifeq +110 -> 325
    //   218: aload 7
    //   220: aload 8
    //   222: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   225: ifne +13 -> 238
    //   228: aload 7
    //   230: aload 8
    //   232: invokevirtual 146	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   235: ifeq +55 -> 290
    //   238: new 21	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   245: aload 7
    //   247: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 100
    //   252: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_0
    //   259: aload 9
    //   261: new 148	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile
    //   264: dup
    //   265: aload_0
    //   266: aload_2
    //   267: invokevirtual 127	java/io/RandomAccessFile:readInt	()I
    //   270: aload_2
    //   271: invokevirtual 127	java/io/RandomAccessFile:readInt	()I
    //   274: invokespecial 151	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:<init>	(Ljava/lang/String;II)V
    //   277: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   280: pop
    //   281: iload 4
    //   283: iconst_1
    //   284: iadd
    //   285: istore 4
    //   287: goto -144 -> 143
    //   290: new 21	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   297: aload 7
    //   299: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 100
    //   304: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: getstatic 158	java/io/File:separator	Ljava/lang/String;
    //   310: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 8
    //   315: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: astore_0
    //   322: goto -63 -> 259
    //   325: aload_2
    //   326: ifnull +7 -> 333
    //   329: aload_2
    //   330: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   333: iconst_0
    //   334: ireturn
    //   335: aload 8
    //   337: aload 7
    //   339: new 21	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   346: aload 7
    //   348: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc 100
    //   353: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokevirtual 162	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   362: astore_0
    //   363: goto -104 -> 259
    //   366: aload 9
    //   368: invokevirtual 166	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   371: astore_0
    //   372: aload_0
    //   373: invokeinterface 172 1 0
    //   378: ifeq +82 -> 460
    //   381: aload_0
    //   382: invokeinterface 176 1 0
    //   387: checkcast 148	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile
    //   390: astore 7
    //   392: new 19	java/io/File
    //   395: dup
    //   396: aload_1
    //   397: aload 7
    //   399: getfield 179	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:name	Ljava/lang/String;
    //   402: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: astore 8
    //   407: aload_2
    //   408: aload 7
    //   410: getfield 184	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:start	I
    //   413: i2l
    //   414: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   417: aload 7
    //   419: getfield 187	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:length	I
    //   422: newarray byte
    //   424: astore 9
    //   426: aload_2
    //   427: aload 9
    //   429: iconst_0
    //   430: aload 7
    //   432: getfield 187	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:length	I
    //   435: invokevirtual 135	java/io/RandomAccessFile:read	([BII)I
    //   438: pop
    //   439: aload 8
    //   441: aload 9
    //   443: invokestatic 190	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker:write	(Ljava/io/File;[B)V
    //   446: goto -74 -> 372
    //   449: astore_0
    //   450: aload_2
    //   451: ifnull +7 -> 458
    //   454: aload_2
    //   455: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   458: aload_0
    //   459: athrow
    //   460: aload_2
    //   461: ifnull +7 -> 468
    //   464: aload_2
    //   465: invokevirtual 117	java/io/RandomAccessFile:close	()V
    //   468: iconst_1
    //   469: ireturn
    //   470: astore_0
    //   471: goto -138 -> 333
    //   474: astore_0
    //   475: goto -7 -> 468
    //   478: astore_0
    //   479: goto -381 -> 98
    //   482: astore_1
    //   483: goto -25 -> 458
    //   486: astore_0
    //   487: aconst_null
    //   488: astore_2
    //   489: goto -39 -> 450
    //   492: astore_0
    //   493: aload 8
    //   495: astore_2
    //   496: goto -406 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	paramString1	String
    //   0	499	1	paramString2	String
    //   0	499	2	paramString3	String
    //   0	499	3	paramBoolean	boolean
    //   141	145	4	i	int
    //   127	21	5	j	int
    //   154	27	6	k	int
    //   54	377	7	localObject1	Object
    //   57	437	8	localObject2	Object
    //   138	304	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   70	89	89	java/lang/Exception
    //   116	140	89	java/lang/Exception
    //   150	193	89	java/lang/Exception
    //   196	214	89	java/lang/Exception
    //   218	238	89	java/lang/Exception
    //   238	259	89	java/lang/Exception
    //   259	281	89	java/lang/Exception
    //   290	322	89	java/lang/Exception
    //   335	363	89	java/lang/Exception
    //   366	372	89	java/lang/Exception
    //   372	446	89	java/lang/Exception
    //   70	89	449	finally
    //   116	140	449	finally
    //   150	193	449	finally
    //   196	214	449	finally
    //   218	238	449	finally
    //   238	259	449	finally
    //   259	281	449	finally
    //   290	322	449	finally
    //   335	363	449	finally
    //   366	372	449	finally
    //   372	446	449	finally
    //   329	333	470	java/lang/Exception
    //   464	468	474	java/lang/Exception
    //   94	98	478	java/lang/Exception
    //   454	458	482	java/lang/Exception
    //   59	70	486	finally
    //   59	70	492	java/lang/Exception
  }
  
  private static boolean unpackAtomically(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!new File(paramString1).exists())
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically fail !zipFile.exists() ");
      return false;
    }
    String str1 = new File(paramString2, paramString3).getAbsolutePath();
    String str2 = str1 + "Tmp";
    FileUtils.delete(str2, false);
    if (!unPacker(paramString1, paramString2, paramString3, paramBoolean))
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically unPacker fail");
      return false;
    }
    paramString2 = new File(str2);
    if (!paramString2.exists())
    {
      QMLog.e("WxapkgUnpacker", "unpackAtomically !uniqueFolderTmpFile.exists()");
      return false;
    }
    paramString3 = new File(str1);
    FileUtils.delete(str1, false);
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
  
  /* Error */
  public static boolean unpackSync(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +10 -> 17
    //   10: aload_1
    //   11: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +17 -> 31
    //   17: ldc 8
    //   19: ldc 232
    //   21: invokestatic 201	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: iconst_0
    //   25: istore_3
    //   26: ldc 2
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: new 19	java/io/File
    //   34: dup
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: invokevirtual 194	java/io/File:exists	()Z
    //   43: ifeq +8 -> 51
    //   46: iconst_1
    //   47: istore_3
    //   48: goto -22 -> 26
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: iload_3
    //   55: invokestatic 234	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker:unpackAtomically	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   58: istore_3
    //   59: goto -33 -> 26
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramString1	String
    //   0	68	1	paramString2	String
    //   0	68	2	paramString3	String
    //   0	68	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	62	finally
    //   17	24	62	finally
    //   31	46	62	finally
    //   51	59	62	finally
  }
  
  private static void write(File paramFile, byte[] paramArrayOfByte)
  {
    if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs())) {
      throw new RuntimeException("Create folder fail:" + paramFile.getParentFile().getAbsolutePath());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker
 * JD-Core Version:    0.7.0.1
 */