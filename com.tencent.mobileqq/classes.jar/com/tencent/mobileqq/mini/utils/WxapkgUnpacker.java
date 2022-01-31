package com.tencent.mobileqq.mini.utils;

import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class WxapkgUnpacker
{
  private static final String TAG = "WxapkgUnpacker";
  
  /* Error */
  private static boolean Unpacker(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +88 -> 108
    //   23: new 25	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   30: new 28	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 35	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 41
    //   46: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_2
    //   54: astore 7
    //   56: new 46	java/io/RandomAccessFile
    //   59: dup
    //   60: aload_0
    //   61: ldc 48
    //   63: invokespecial 51	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 55	java/io/RandomAccessFile:readByte	()B
    //   71: bipush 190
    //   73: if_icmpeq +51 -> 124
    //   76: new 57	java/lang/RuntimeException
    //   79: dup
    //   80: ldc 59
    //   82: invokespecial 60	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   85: athrow
    //   86: astore_1
    //   87: aload_2
    //   88: astore_0
    //   89: ldc 8
    //   91: iconst_1
    //   92: ldc 62
    //   94: aload_1
    //   95: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 71	java/io/RandomAccessFile:close	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: new 28	java/io/File
    //   111: dup
    //   112: aload_2
    //   113: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 35	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   119: astore 7
    //   121: goto -65 -> 56
    //   124: aload_2
    //   125: ldc2_w 72
    //   128: invokevirtual 77	java/io/RandomAccessFile:seek	(J)V
    //   131: aload_2
    //   132: invokevirtual 81	java/io/RandomAccessFile:readInt	()I
    //   135: istore 5
    //   137: new 83	java/util/ArrayList
    //   140: dup
    //   141: iload 5
    //   143: invokespecial 86	java/util/ArrayList:<init>	(I)V
    //   146: astore 9
    //   148: iconst_0
    //   149: istore 4
    //   151: iload 4
    //   153: iload 5
    //   155: if_icmpge +219 -> 374
    //   158: aload_2
    //   159: invokevirtual 81	java/io/RandomAccessFile:readInt	()I
    //   162: istore 6
    //   164: iload 6
    //   166: newarray byte
    //   168: astore_0
    //   169: aload_2
    //   170: aload_0
    //   171: iconst_0
    //   172: iload 6
    //   174: invokevirtual 90	java/io/RandomAccessFile:read	([BII)I
    //   177: pop
    //   178: new 28	java/io/File
    //   181: dup
    //   182: new 92	java/lang/String
    //   185: dup
    //   186: aload_0
    //   187: iconst_0
    //   188: iload 6
    //   190: invokespecial 95	java/lang/String:<init>	([BII)V
    //   193: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: invokevirtual 35	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   199: astore 8
    //   201: aload 8
    //   203: astore_0
    //   204: aload 7
    //   206: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +58 -> 267
    //   212: aload 8
    //   214: aload 7
    //   216: invokevirtual 99	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   219: ifne +124 -> 343
    //   222: iload_3
    //   223: ifeq +110 -> 333
    //   226: aload 7
    //   228: aload 8
    //   230: invokevirtual 99	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   233: ifne +13 -> 246
    //   236: aload 7
    //   238: aload 8
    //   240: invokevirtual 102	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   243: ifeq +55 -> 298
    //   246: new 25	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   253: aload 7
    //   255: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc 41
    //   260: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: astore_0
    //   267: aload 9
    //   269: new 104	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile
    //   272: dup
    //   273: aload_0
    //   274: aload_2
    //   275: invokevirtual 81	java/io/RandomAccessFile:readInt	()I
    //   278: aload_2
    //   279: invokevirtual 81	java/io/RandomAccessFile:readInt	()I
    //   282: invokespecial 107	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:<init>	(Ljava/lang/String;II)V
    //   285: invokevirtual 111	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   288: pop
    //   289: iload 4
    //   291: iconst_1
    //   292: iadd
    //   293: istore 4
    //   295: goto -144 -> 151
    //   298: new 25	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   305: aload 7
    //   307: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 41
    //   312: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   318: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 8
    //   323: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: astore_0
    //   330: goto -63 -> 267
    //   333: aload_2
    //   334: ifnull +7 -> 341
    //   337: aload_2
    //   338: invokevirtual 71	java/io/RandomAccessFile:close	()V
    //   341: iconst_0
    //   342: ireturn
    //   343: aload 8
    //   345: aload 7
    //   347: new 25	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   354: aload 7
    //   356: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc 41
    //   361: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 118	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   370: astore_0
    //   371: goto -104 -> 267
    //   374: aload 9
    //   376: invokevirtual 122	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   379: astore_0
    //   380: aload_0
    //   381: invokeinterface 128 1 0
    //   386: ifeq +84 -> 470
    //   389: aload_0
    //   390: invokeinterface 132 1 0
    //   395: checkcast 104	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile
    //   398: astore 7
    //   400: new 28	java/io/File
    //   403: dup
    //   404: aload_1
    //   405: aload 7
    //   407: getfield 135	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:name	Ljava/lang/String;
    //   410: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: astore 8
    //   415: aload_2
    //   416: aload 7
    //   418: getfield 140	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:start	I
    //   421: i2l
    //   422: invokevirtual 77	java/io/RandomAccessFile:seek	(J)V
    //   425: aload 7
    //   427: getfield 143	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:length	I
    //   430: newarray byte
    //   432: astore 9
    //   434: aload_2
    //   435: aload 9
    //   437: iconst_0
    //   438: aload 7
    //   440: getfield 143	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:length	I
    //   443: invokevirtual 90	java/io/RandomAccessFile:read	([BII)I
    //   446: pop
    //   447: aload 8
    //   449: aload 9
    //   451: invokestatic 147	com/tencent/mobileqq/mini/utils/WxapkgUnpacker:write	(Ljava/io/File;[B)V
    //   454: goto -74 -> 380
    //   457: astore_0
    //   458: aload_2
    //   459: astore_1
    //   460: aload_1
    //   461: ifnull +7 -> 468
    //   464: aload_1
    //   465: invokevirtual 71	java/io/RandomAccessFile:close	()V
    //   468: aload_0
    //   469: athrow
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 71	java/io/RandomAccessFile:close	()V
    //   478: iconst_1
    //   479: ireturn
    //   480: astore_0
    //   481: goto -140 -> 341
    //   484: astore_0
    //   485: goto -7 -> 478
    //   488: astore_0
    //   489: goto -383 -> 106
    //   492: astore_1
    //   493: goto -25 -> 468
    //   496: astore_0
    //   497: aconst_null
    //   498: astore_1
    //   499: goto -39 -> 460
    //   502: astore_2
    //   503: aload_0
    //   504: astore_1
    //   505: aload_2
    //   506: astore_0
    //   507: goto -47 -> 460
    //   510: astore_1
    //   511: aconst_null
    //   512: astore_0
    //   513: goto -424 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	paramString1	String
    //   0	516	1	paramString2	String
    //   0	516	2	paramString3	String
    //   0	516	3	paramBoolean	boolean
    //   149	145	4	i	int
    //   135	21	5	j	int
    //   162	27	6	k	int
    //   54	385	7	localObject1	Object
    //   199	249	8	localObject2	Object
    //   146	304	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   67	86	86	java/lang/Exception
    //   124	148	86	java/lang/Exception
    //   158	201	86	java/lang/Exception
    //   204	222	86	java/lang/Exception
    //   226	246	86	java/lang/Exception
    //   246	267	86	java/lang/Exception
    //   267	289	86	java/lang/Exception
    //   298	330	86	java/lang/Exception
    //   343	371	86	java/lang/Exception
    //   374	380	86	java/lang/Exception
    //   380	454	86	java/lang/Exception
    //   67	86	457	finally
    //   124	148	457	finally
    //   158	201	457	finally
    //   204	222	457	finally
    //   226	246	457	finally
    //   246	267	457	finally
    //   267	289	457	finally
    //   298	330	457	finally
    //   343	371	457	finally
    //   374	380	457	finally
    //   380	454	457	finally
    //   337	341	480	java/lang/Exception
    //   474	478	484	java/lang/Exception
    //   102	106	488	java/lang/Exception
    //   464	468	492	java/lang/Exception
    //   56	67	496	finally
    //   89	98	502	finally
    //   56	67	510	java/lang/Exception
  }
  
  /* Error */
  public static File createFileFromInputStream(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 28	java/io/File
    //   6: dup
    //   7: new 25	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 157	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: invokevirtual 161	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   20: invokevirtual 164	java/io/File:getPath	()Ljava/lang/String;
    //   23: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 166
    //   28: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: new 168	java/io/FileOutputStream
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore_3
    //   53: aload_3
    //   54: astore_1
    //   55: sipush 1024
    //   58: newarray byte
    //   60: astore 5
    //   62: aload_3
    //   63: astore_1
    //   64: aload_0
    //   65: aload 5
    //   67: invokevirtual 176	java/io/InputStream:read	([B)I
    //   70: istore_2
    //   71: iload_2
    //   72: ifle +60 -> 132
    //   75: aload_3
    //   76: astore_1
    //   77: aload_3
    //   78: aload 5
    //   80: iconst_0
    //   81: iload_2
    //   82: invokevirtual 180	java/io/OutputStream:write	([BII)V
    //   85: goto -23 -> 62
    //   88: astore_1
    //   89: aload_3
    //   90: astore_0
    //   91: aload_1
    //   92: astore_3
    //   93: aload_0
    //   94: astore_1
    //   95: ldc 8
    //   97: iconst_1
    //   98: new 25	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   105: ldc 182
    //   107: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 189	java/io/OutputStream:close	()V
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: areturn
    //   132: aload_3
    //   133: astore_1
    //   134: aload_0
    //   135: invokevirtual 190	java/io/InputStream:close	()V
    //   138: aload 4
    //   140: astore_0
    //   141: aload_3
    //   142: ifnull -12 -> 130
    //   145: aload_3
    //   146: invokevirtual 189	java/io/OutputStream:close	()V
    //   149: aload 4
    //   151: areturn
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   157: aload 4
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   165: goto -37 -> 128
    //   168: astore_0
    //   169: aload 5
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +7 -> 180
    //   176: aload_1
    //   177: invokevirtual 189	java/io/OutputStream:close	()V
    //   180: aload_0
    //   181: athrow
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   187: goto -7 -> 180
    //   190: astore_0
    //   191: goto -19 -> 172
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_0
    //   197: goto -104 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramInputStream	InputStream
    //   0	200	1	paramString	String
    //   70	12	2	i	int
    //   52	94	3	localObject	Object
    //   194	1	3	localIOException	java.io.IOException
    //   41	117	4	localFile	File
    //   1	169	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   55	62	88	java/io/IOException
    //   64	71	88	java/io/IOException
    //   77	85	88	java/io/IOException
    //   134	138	88	java/io/IOException
    //   145	149	152	java/io/IOException
    //   124	128	160	java/io/IOException
    //   3	53	168	finally
    //   176	180	182	java/io/IOException
    //   55	62	190	finally
    //   64	71	190	finally
    //   77	85	190	finally
    //   95	120	190	finally
    //   134	138	190	finally
    //   3	53	194	java/io/IOException
  }
  
  public static File getWxapkgFileInAssets(String paramString)
  {
    File localFile = null;
    Object localObject1 = BaseApplicationImpl.getContext().getAssets();
    try
    {
      localObject1 = ((AssetManager)localObject1).open(paramString);
      if (localObject1 != null) {
        localFile = createFileFromInputStream((InputStream)localObject1, paramString);
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
  
  private static boolean unpackAtomically(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QLog.e("WxapkgUnpacker", 1, new Object[] { "unpackAtomically wxapkgPath:", paramString1, " outDirPath:", paramString2, " uniqueFolderSubPath:", paramString3, " isMiniGame:", Boolean.valueOf(paramBoolean) });
    if (!new File(paramString1).exists())
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically fail !zipFile.exists() ");
      return false;
    }
    String str1 = new File(paramString2, paramString3).getAbsolutePath();
    String str2 = str1 + "Tmp";
    FileUtils.delete(str2, false);
    if (!Unpacker(paramString1, paramString2, paramString3, paramBoolean))
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically Unpacker fail");
      return false;
    }
    paramString2 = new File(str2);
    if (!paramString2.exists())
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically !uniqueFolderTmpFile.exists()");
      return false;
    }
    paramString3 = new File(str1);
    FileUtils.delete(str1, false);
    if (!FileUtils.renameFile(paramString2, paramString3))
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically !FileUtils.renameFile(uniqueFolderTmpFile, uniqueFolderFile)");
      return false;
    }
    if (!paramString3.exists())
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically !uniqueFolderFile.exists()");
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
    //   4: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +14 -> 21
    //   10: aload_1
    //   11: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore 4
    //   16: iload 4
    //   18: ifeq +10 -> 28
    //   21: iconst_0
    //   22: istore_3
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: new 28	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: aload_2
    //   34: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: invokevirtual 237	java/io/File:exists	()Z
    //   40: ifeq +8 -> 48
    //   43: iconst_1
    //   44: istore_3
    //   45: goto -22 -> 23
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: iload_3
    //   52: invokestatic 270	com/tencent/mobileqq/mini/utils/WxapkgUnpacker:unpackAtomically	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   55: istore_3
    //   56: goto -33 -> 23
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramString1	String
    //   0	65	1	paramString2	String
    //   0	65	2	paramString3	String
    //   0	65	3	paramBoolean	boolean
    //   14	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	16	59	finally
    //   28	43	59	finally
    //   48	56	59	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.WxapkgUnpacker
 * JD-Core Version:    0.7.0.1
 */