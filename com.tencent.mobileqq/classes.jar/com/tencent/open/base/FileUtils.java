package com.tencent.open.base;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import java.io.File;

public class FileUtils
{
  public static String a(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    String str;
    if (i >= 0) {
      str = paramString.substring(i);
    } else {
      str = ".png";
    }
    int j = 5381;
    i = 0;
    int k = paramString.length();
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    paramString = new StringBuilder();
    paramString.append(String.valueOf(j & 0x7FFFFFFF));
    paramString.append(str);
    return paramString.toString();
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 59	com/tencent/open/appcommon/Common:d	()Z
    //   3: ifne +11 -> 14
    //   6: ldc 61
    //   8: ldc 63
    //   10: invokestatic 69	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 75	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   18: invokevirtual 81	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   21: aload_1
    //   22: invokevirtual 87	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   25: astore 8
    //   27: new 89	java/io/File
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 9
    //   37: aload 9
    //   39: invokevirtual 95	java/io/File:exists	()Z
    //   42: ifne +9 -> 51
    //   45: aload 9
    //   47: invokevirtual 98	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: iconst_0
    //   52: istore_3
    //   53: iload_3
    //   54: aload 8
    //   56: arraylength
    //   57: if_icmpge +485 -> 542
    //   60: aconst_null
    //   61: astore 6
    //   63: aconst_null
    //   64: astore 5
    //   66: aload 8
    //   68: iload_3
    //   69: aaload
    //   70: astore 7
    //   72: aload 7
    //   74: ldc 13
    //   76: invokevirtual 102	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   79: ifne +162 -> 241
    //   82: aload_1
    //   83: invokevirtual 29	java/lang/String:length	()I
    //   86: ifne +59 -> 145
    //   89: new 35	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   96: astore 10
    //   98: aload 10
    //   100: aload_2
    //   101: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 10
    //   107: getstatic 106	java/io/File:separator	Ljava/lang/String;
    //   110: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 10
    //   116: aload 7
    //   118: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: getstatic 106	java/io/File:separator	Ljava/lang/String;
    //   127: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: aload 7
    //   134: aload 10
    //   136: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 108	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   142: goto +276 -> 418
    //   145: new 35	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   152: astore 10
    //   154: aload 10
    //   156: aload_1
    //   157: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 10
    //   163: getstatic 106	java/io/File:separator	Ljava/lang/String;
    //   166: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: aload 7
    //   174: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 10
    //   180: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore 10
    //   185: new 35	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   192: astore 11
    //   194: aload 11
    //   196: aload_2
    //   197: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 11
    //   203: getstatic 106	java/io/File:separator	Ljava/lang/String;
    //   206: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 11
    //   212: aload 7
    //   214: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 11
    //   220: getstatic 106	java/io/File:separator	Ljava/lang/String;
    //   223: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_0
    //   228: aload 10
    //   230: aload 11
    //   232: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 108	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto +180 -> 418
    //   241: new 89	java/io/File
    //   244: dup
    //   245: aload 9
    //   247: aload 7
    //   249: invokespecial 111	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   252: astore 10
    //   254: aload 10
    //   256: invokevirtual 95	java/io/File:exists	()Z
    //   259: ifeq +9 -> 268
    //   262: aload 10
    //   264: invokevirtual 114	java/io/File:delete	()Z
    //   267: pop
    //   268: aload_1
    //   269: invokevirtual 29	java/lang/String:length	()I
    //   272: ifeq +60 -> 332
    //   275: aload_0
    //   276: invokevirtual 115	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   279: astore 11
    //   281: new 35	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   288: astore 12
    //   290: aload 12
    //   292: aload_1
    //   293: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 12
    //   299: ldc 117
    //   301: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 12
    //   307: aload 7
    //   309: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 11
    //   315: aload 12
    //   317: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokevirtual 121	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   323: astore 7
    //   325: aload 7
    //   327: astore 5
    //   329: goto +18 -> 347
    //   332: aload_0
    //   333: invokevirtual 115	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   336: aload 7
    //   338: invokevirtual 121	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   341: astore 7
    //   343: aload 7
    //   345: astore 5
    //   347: new 123	java/io/FileOutputStream
    //   350: dup
    //   351: aload 10
    //   353: invokespecial 126	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   356: astore 6
    //   358: sipush 8192
    //   361: newarray byte
    //   363: astore 7
    //   365: aload 5
    //   367: aload 7
    //   369: invokevirtual 132	java/io/InputStream:read	([B)I
    //   372: istore 4
    //   374: iload 4
    //   376: ifle +16 -> 392
    //   379: aload 6
    //   381: aload 7
    //   383: iconst_0
    //   384: iload 4
    //   386: invokevirtual 138	java/io/OutputStream:write	([BII)V
    //   389: goto -24 -> 365
    //   392: aload 5
    //   394: ifnull +11 -> 405
    //   397: aload 5
    //   399: invokevirtual 141	java/io/InputStream:close	()V
    //   402: goto +3 -> 405
    //   405: aload 6
    //   407: invokevirtual 142	java/io/OutputStream:close	()V
    //   410: goto +8 -> 418
    //   413: aload 5
    //   415: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   418: iload_3
    //   419: iconst_1
    //   420: iadd
    //   421: istore_3
    //   422: goto -369 -> 53
    //   425: astore_0
    //   426: aload 6
    //   428: astore_2
    //   429: goto +13 -> 442
    //   432: astore_1
    //   433: aload 6
    //   435: astore_2
    //   436: goto +18 -> 454
    //   439: astore_0
    //   440: aconst_null
    //   441: astore_2
    //   442: aload 5
    //   444: astore_1
    //   445: aload_0
    //   446: astore 5
    //   448: goto +65 -> 513
    //   451: astore_1
    //   452: aconst_null
    //   453: astore_2
    //   454: aload 5
    //   456: astore_0
    //   457: goto +19 -> 476
    //   460: astore 5
    //   462: aconst_null
    //   463: astore_2
    //   464: aload 6
    //   466: astore_1
    //   467: goto +46 -> 513
    //   470: astore_1
    //   471: aconst_null
    //   472: astore_2
    //   473: aload 5
    //   475: astore_0
    //   476: ldc 147
    //   478: ldc 149
    //   480: aload_1
    //   481: invokestatic 153	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   484: aload_0
    //   485: ifnull +10 -> 495
    //   488: aload_0
    //   489: invokevirtual 141	java/io/InputStream:close	()V
    //   492: goto +3 -> 495
    //   495: aload_2
    //   496: ifnull +46 -> 542
    //   499: aload_2
    //   500: invokevirtual 142	java/io/OutputStream:close	()V
    //   503: return
    //   504: aload_0
    //   505: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   508: return
    //   509: astore 5
    //   511: aload_0
    //   512: astore_1
    //   513: aload_1
    //   514: ifnull +10 -> 524
    //   517: aload_1
    //   518: invokevirtual 141	java/io/InputStream:close	()V
    //   521: goto +3 -> 524
    //   524: aload_2
    //   525: ifnull +14 -> 539
    //   528: aload_2
    //   529: invokevirtual 142	java/io/OutputStream:close	()V
    //   532: goto +7 -> 539
    //   535: aload_0
    //   536: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   539: aload 5
    //   541: athrow
    //   542: return
    //   543: astore_0
    //   544: ldc 147
    //   546: ldc 155
    //   548: aload_0
    //   549: invokestatic 153	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   552: return
    //   553: astore 5
    //   555: goto -142 -> 413
    //   558: astore_0
    //   559: goto -55 -> 504
    //   562: astore_0
    //   563: goto -28 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	paramContext	Context
    //   0	566	1	paramString1	String
    //   0	566	2	paramString2	String
    //   52	370	3	i	int
    //   372	13	4	j	int
    //   64	391	5	localObject1	Object
    //   460	14	5	localObject2	Object
    //   509	31	5	localObject3	Object
    //   553	1	5	localIOException	java.io.IOException
    //   61	404	6	localFileOutputStream	java.io.FileOutputStream
    //   70	312	7	localObject4	Object
    //   25	42	8	arrayOfString	String[]
    //   35	211	9	localFile	File
    //   96	256	10	localObject5	Object
    //   192	122	11	localObject6	Object
    //   288	28	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   358	365	425	finally
    //   365	374	425	finally
    //   379	389	425	finally
    //   358	365	432	java/lang/Exception
    //   365	374	432	java/lang/Exception
    //   379	389	432	java/lang/Exception
    //   347	358	439	finally
    //   347	358	451	java/lang/Exception
    //   72	142	460	finally
    //   145	238	460	finally
    //   241	268	460	finally
    //   268	325	460	finally
    //   332	343	460	finally
    //   72	142	470	java/lang/Exception
    //   145	238	470	java/lang/Exception
    //   241	268	470	java/lang/Exception
    //   268	325	470	java/lang/Exception
    //   332	343	470	java/lang/Exception
    //   476	484	509	finally
    //   14	27	543	java/io/IOException
    //   397	402	553	java/io/IOException
    //   405	410	553	java/io/IOException
    //   488	492	558	java/io/IOException
    //   499	503	558	java/io/IOException
    //   517	521	562	java/io/IOException
    //   528	532	562	java/io/IOException
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = CommonDataAdapter.a().b();
    if (localObject != null)
    {
      a((Context)localObject, paramString1, paramString2);
      try
      {
        ZipUtils.a(paramString2, Common.l());
      }
      catch (Exception paramString1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("zipAssets error : ");
        ((StringBuilder)localObject).append(paramString1.toString());
        LogUtility.e("FileUtils", ((StringBuilder)localObject).toString());
      }
      if (new File(Common.l()).exists())
      {
        paramString1 = MD5Utils.encodeFileHexStr(Common.l());
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new File(paramString2);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(Common.c());
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(paramString1);
          localObject = new File(((StringBuilder)localObject).toString());
          if (paramString2.exists())
          {
            if (((File)localObject).exists())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(Common.j());
              localStringBuilder.append(SystemClock.currentThreadTimeMillis());
              if (((File)localObject).renameTo(new File(localStringBuilder.toString())))
              {
                LogUtility.b("FileUtils", "<zipAssets> md5Dir exists, rename md5Dir to systemOldFile successful");
                if (paramString2.renameTo((File)localObject))
                {
                  Common.f(paramString1);
                  LogUtility.b("FileUtils", "<zipAssets> md5Dir exists, rename tmpDir to md5Dir successful");
                  return;
                }
                LogUtility.c("FileUtils", "<zipAssets> md5Dir exists, rename tmpDir to md5Dir failed");
                return;
              }
              LogUtility.b("FileUtils", "<zipAssets> md5Dir exists, rename md5Dir to systemOldFile failed");
              return;
            }
            if (paramString2.renameTo((File)localObject))
            {
              LogUtility.b("FileUtils", "<zipAssets> md5Dir not exists, rename tmpDir to md5Dir successful");
              Common.f(paramString1);
            }
          }
        }
      }
    }
    else
    {
      LogUtility.e("FileUtils", "plugin context is null !!!");
    }
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          if (!a(arrayOfFile[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.FileUtils
 * JD-Core Version:    0.7.0.1
 */