package com.tencent.mobileqq.mini.utils;

import android.content.res.AssetManager;
import android.text.TextUtils;
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
    //   4: ifne +519 -> 523
    //   7: aload_1
    //   8: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +50 -> 70
    //   23: new 25	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   30: astore 7
    //   32: aload 7
    //   34: new 28	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 35	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 7
    //   51: ldc 41
    //   53: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 7
    //   59: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 7
    //   64: aload_2
    //   65: astore 8
    //   67: goto +19 -> 86
    //   70: new 28	java/io/File
    //   73: dup
    //   74: aload_2
    //   75: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 35	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   81: astore 8
    //   83: aload_1
    //   84: astore 7
    //   86: aconst_null
    //   87: astore 9
    //   89: aconst_null
    //   90: astore_1
    //   91: new 46	java/io/RandomAccessFile
    //   94: dup
    //   95: aload_0
    //   96: ldc 48
    //   98: invokespecial 51	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 55	java/io/RandomAccessFile:readByte	()B
    //   106: bipush 190
    //   108: if_icmpne +352 -> 460
    //   111: aload_2
    //   112: ldc2_w 56
    //   115: invokevirtual 61	java/io/RandomAccessFile:seek	(J)V
    //   118: aload_2
    //   119: invokevirtual 65	java/io/RandomAccessFile:readInt	()I
    //   122: istore 5
    //   124: new 67	java/util/ArrayList
    //   127: dup
    //   128: iload 5
    //   130: invokespecial 70	java/util/ArrayList:<init>	(I)V
    //   133: astore 9
    //   135: iconst_0
    //   136: istore 4
    //   138: iload 4
    //   140: iload 5
    //   142: if_icmpge +233 -> 375
    //   145: aload_2
    //   146: invokevirtual 65	java/io/RandomAccessFile:readInt	()I
    //   149: istore 6
    //   151: iload 6
    //   153: newarray byte
    //   155: astore_0
    //   156: aload_2
    //   157: aload_0
    //   158: iconst_0
    //   159: iload 6
    //   161: invokevirtual 74	java/io/RandomAccessFile:read	([BII)I
    //   164: pop
    //   165: new 28	java/io/File
    //   168: dup
    //   169: new 76	java/lang/String
    //   172: dup
    //   173: aload_0
    //   174: iconst_0
    //   175: iload 6
    //   177: invokespecial 79	java/lang/String:<init>	([BII)V
    //   180: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: invokevirtual 35	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   186: astore_1
    //   187: aload_1
    //   188: astore_0
    //   189: aload 8
    //   191: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +150 -> 344
    //   197: aload_1
    //   198: aload 8
    //   200: invokevirtual 83	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   203: ifne +108 -> 311
    //   206: iload_3
    //   207: ifeq +98 -> 305
    //   210: aload 8
    //   212: aload_1
    //   213: invokevirtual 83	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   216: ifne +59 -> 275
    //   219: aload 8
    //   221: aload_1
    //   222: invokevirtual 86	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   225: ifeq +6 -> 231
    //   228: goto +47 -> 275
    //   231: new 25	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   238: astore_0
    //   239: aload_0
    //   240: aload 8
    //   242: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_0
    //   247: ldc 41
    //   249: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_0
    //   254: getstatic 89	java/io/File:separator	Ljava/lang/String;
    //   257: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_0
    //   262: aload_1
    //   263: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_0
    //   268: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: astore_0
    //   272: goto +72 -> 344
    //   275: new 25	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   282: astore_0
    //   283: aload_0
    //   284: aload 8
    //   286: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_0
    //   291: ldc 41
    //   293: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_0
    //   298: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: astore_0
    //   302: goto +42 -> 344
    //   305: aload_2
    //   306: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   309: iconst_0
    //   310: ireturn
    //   311: new 25	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   318: astore_0
    //   319: aload_0
    //   320: aload 8
    //   322: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_0
    //   327: ldc 41
    //   329: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_1
    //   334: aload 8
    //   336: aload_0
    //   337: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokevirtual 96	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   343: astore_0
    //   344: aload 9
    //   346: new 98	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile
    //   349: dup
    //   350: aload_0
    //   351: aload_2
    //   352: invokevirtual 65	java/io/RandomAccessFile:readInt	()I
    //   355: aload_2
    //   356: invokevirtual 65	java/io/RandomAccessFile:readInt	()I
    //   359: invokespecial 101	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:<init>	(Ljava/lang/String;II)V
    //   362: invokevirtual 105	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   365: pop
    //   366: iload 4
    //   368: iconst_1
    //   369: iadd
    //   370: istore 4
    //   372: goto -234 -> 138
    //   375: aload 9
    //   377: invokevirtual 109	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   380: astore_0
    //   381: aload_0
    //   382: invokeinterface 115 1 0
    //   387: ifeq +67 -> 454
    //   390: aload_0
    //   391: invokeinterface 119 1 0
    //   396: checkcast 98	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile
    //   399: astore_1
    //   400: new 28	java/io/File
    //   403: dup
    //   404: aload 7
    //   406: aload_1
    //   407: getfield 122	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:name	Ljava/lang/String;
    //   410: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: astore 8
    //   415: aload_2
    //   416: aload_1
    //   417: getfield 127	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:start	I
    //   420: i2l
    //   421: invokevirtual 61	java/io/RandomAccessFile:seek	(J)V
    //   424: aload_1
    //   425: getfield 130	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:length	I
    //   428: newarray byte
    //   430: astore 9
    //   432: aload_2
    //   433: aload 9
    //   435: iconst_0
    //   436: aload_1
    //   437: getfield 130	com/tencent/mobileqq/mini/utils/WxapkgUnpacker$WxapkgFile:length	I
    //   440: invokevirtual 74	java/io/RandomAccessFile:read	([BII)I
    //   443: pop
    //   444: aload 8
    //   446: aload 9
    //   448: invokestatic 134	com/tencent/mobileqq/mini/utils/WxapkgUnpacker:write	(Ljava/io/File;[B)V
    //   451: goto -70 -> 381
    //   454: aload_2
    //   455: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   458: iconst_1
    //   459: ireturn
    //   460: new 136	java/lang/RuntimeException
    //   463: dup
    //   464: ldc 138
    //   466: invokespecial 139	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   469: athrow
    //   470: astore_0
    //   471: goto +42 -> 513
    //   474: astore_1
    //   475: aload_2
    //   476: astore_0
    //   477: aload_1
    //   478: astore_2
    //   479: goto +13 -> 492
    //   482: astore_0
    //   483: aload_1
    //   484: astore_2
    //   485: goto +28 -> 513
    //   488: astore_2
    //   489: aload 9
    //   491: astore_0
    //   492: aload_0
    //   493: astore_1
    //   494: ldc 8
    //   496: iconst_1
    //   497: ldc 141
    //   499: aload_2
    //   500: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   503: aload_0
    //   504: ifnull +7 -> 511
    //   507: aload_0
    //   508: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   511: iconst_0
    //   512: ireturn
    //   513: aload_2
    //   514: ifnull +7 -> 521
    //   517: aload_2
    //   518: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   521: aload_0
    //   522: athrow
    //   523: iconst_0
    //   524: ireturn
    //   525: astore_0
    //   526: iconst_0
    //   527: ireturn
    //   528: astore_0
    //   529: iconst_1
    //   530: ireturn
    //   531: astore_0
    //   532: iconst_0
    //   533: ireturn
    //   534: astore_1
    //   535: goto -14 -> 521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	paramString1	String
    //   0	538	1	paramString2	String
    //   0	538	2	paramString3	String
    //   0	538	3	paramBoolean	boolean
    //   136	235	4	i	int
    //   122	21	5	j	int
    //   149	27	6	k	int
    //   30	375	7	localObject1	Object
    //   65	380	8	localObject2	Object
    //   87	403	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   102	135	470	finally
    //   145	187	470	finally
    //   189	206	470	finally
    //   210	228	470	finally
    //   231	272	470	finally
    //   275	302	470	finally
    //   311	344	470	finally
    //   344	366	470	finally
    //   375	381	470	finally
    //   381	451	470	finally
    //   460	470	470	finally
    //   102	135	474	java/lang/Exception
    //   145	187	474	java/lang/Exception
    //   189	206	474	java/lang/Exception
    //   210	228	474	java/lang/Exception
    //   231	272	474	java/lang/Exception
    //   275	302	474	java/lang/Exception
    //   311	344	474	java/lang/Exception
    //   344	366	474	java/lang/Exception
    //   375	381	474	java/lang/Exception
    //   381	451	474	java/lang/Exception
    //   460	470	474	java/lang/Exception
    //   91	102	482	finally
    //   494	503	482	finally
    //   91	102	488	java/lang/Exception
    //   305	309	525	java/lang/Exception
    //   454	458	528	java/lang/Exception
    //   507	511	531	java/lang/Exception
    //   517	521	534	java/lang/Exception
  }
  
  /* Error */
  public static File createFileFromInputStream(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 25	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 157	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: invokevirtual 161	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 164	java/io/File:getPath	()Ljava/lang/String;
    //   21: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_3
    //   26: ldc 166
    //   28: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: aload_1
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: new 28	java/io/File
    //   41: dup
    //   42: aload_3
    //   43: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 5
    //   51: new 168	java/io/FileOutputStream
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_1
    //   63: sipush 1024
    //   66: newarray byte
    //   68: astore 4
    //   70: aload_3
    //   71: astore_1
    //   72: aload_0
    //   73: aload 4
    //   75: invokevirtual 176	java/io/InputStream:read	([B)I
    //   78: istore_2
    //   79: iload_2
    //   80: ifle +16 -> 96
    //   83: aload_3
    //   84: astore_1
    //   85: aload_3
    //   86: aload 4
    //   88: iconst_0
    //   89: iload_2
    //   90: invokevirtual 180	java/io/OutputStream:write	([BII)V
    //   93: goto -23 -> 70
    //   96: aload_3
    //   97: astore_1
    //   98: aload_0
    //   99: invokevirtual 181	java/io/InputStream:close	()V
    //   102: aload_3
    //   103: invokevirtual 182	java/io/OutputStream:close	()V
    //   106: aload 5
    //   108: areturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   114: aload 5
    //   116: areturn
    //   117: astore 4
    //   119: aload_3
    //   120: astore_0
    //   121: goto +14 -> 135
    //   124: astore_0
    //   125: aload 4
    //   127: astore_1
    //   128: goto +65 -> 193
    //   131: astore 4
    //   133: aconst_null
    //   134: astore_0
    //   135: aload_0
    //   136: astore_1
    //   137: new 25	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   144: astore_3
    //   145: aload_0
    //   146: astore_1
    //   147: aload_3
    //   148: ldc 187
    //   150: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_0
    //   155: astore_1
    //   156: aload_3
    //   157: aload 4
    //   159: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_0
    //   164: astore_1
    //   165: ldc 8
    //   167: iconst_1
    //   168: aload_3
    //   169: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_0
    //   176: ifnull +14 -> 190
    //   179: aload_0
    //   180: invokevirtual 182	java/io/OutputStream:close	()V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_0
    //   193: aload_1
    //   194: ifnull +15 -> 209
    //   197: aload_1
    //   198: invokevirtual 182	java/io/OutputStream:close	()V
    //   201: goto +8 -> 209
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   209: goto +5 -> 214
    //   212: aload_0
    //   213: athrow
    //   214: goto -2 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramInputStream	InputStream
    //   0	217	1	paramString	String
    //   78	12	2	i	int
    //   10	159	3	localObject	Object
    //   1	86	4	arrayOfByte	byte[]
    //   117	9	4	localIOException1	java.io.IOException
    //   131	27	4	localIOException2	java.io.IOException
    //   49	66	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   102	106	109	java/io/IOException
    //   63	70	117	java/io/IOException
    //   72	79	117	java/io/IOException
    //   85	93	117	java/io/IOException
    //   98	102	117	java/io/IOException
    //   3	61	124	finally
    //   3	61	131	java/io/IOException
    //   179	183	185	java/io/IOException
    //   63	70	192	finally
    //   72	79	192	finally
    //   85	93	192	finally
    //   98	102	192	finally
    //   137	145	192	finally
    //   147	154	192	finally
    //   156	163	192	finally
    //   165	175	192	finally
    //   197	201	204	java/io/IOException
  }
  
  public static File getWxapkgFileInAssets(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext().getAssets();
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
      return createFileFromInputStream(localInputStream, paramString);
    }
    return null;
  }
  
  private static boolean unpackAtomically(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QLog.e("WxapkgUnpacker", 1, new Object[] { "unpackAtomically wxapkgPath:", paramString1, " outDirPath:", paramString2, " uniqueFolderSubPath:", paramString3, " isMiniGame:", Boolean.valueOf(paramBoolean) });
    if (!new File(paramString1).exists())
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically fail !zipFile.exists() ");
      return false;
    }
    String str = new File(paramString2, paramString3).getAbsolutePath();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("Tmp");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.delete((String)localObject, false);
    if (!Unpacker(paramString1, paramString2, paramString3, paramBoolean))
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically Unpacker fail");
      return false;
    }
    paramString2 = new File((String)localObject);
    if (!paramString2.exists())
    {
      QLog.e("WxapkgUnpacker", 1, "unpackAtomically !uniqueFolderTmpFile.exists()");
      return false;
    }
    paramString3 = new File(str);
    FileUtils.delete(str, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.WxapkgUnpacker
 * JD-Core Version:    0.7.0.1
 */