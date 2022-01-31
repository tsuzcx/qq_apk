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
    if (i >= 0) {}
    int j;
    for (String str = paramString.substring(i);; str = ".png")
    {
      j = 5381;
      i = 0;
      int k = paramString.length();
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
    }
    return String.valueOf(j & 0x7FFFFFFF) + str;
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 4
    //   9: invokestatic 58	com/tencent/open/appcommon/Common:a	()Z
    //   12: ifne +11 -> 23
    //   15: ldc 60
    //   17: ldc 62
    //   19: invokestatic 68	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: return
    //   23: aload_0
    //   24: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: invokevirtual 80	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   30: aload_1
    //   31: invokevirtual 86	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore 10
    //   36: new 88	java/io/File
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 9
    //   46: iload 4
    //   48: istore_3
    //   49: aload 9
    //   51: invokevirtual 94	java/io/File:exists	()Z
    //   54: ifne +14 -> 68
    //   57: iload 4
    //   59: istore_3
    //   60: aload 9
    //   62: invokevirtual 97	java/io/File:mkdirs	()Z
    //   65: ifne +3 -> 68
    //   68: iload_3
    //   69: aload 10
    //   71: arraylength
    //   72: if_icmpge -50 -> 22
    //   75: aload 10
    //   77: iload_3
    //   78: aaload
    //   79: astore 5
    //   81: aload 5
    //   83: ldc 13
    //   85: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifne +198 -> 286
    //   91: aload_1
    //   92: invokevirtual 27	java/lang/String:length	()I
    //   95: ifne +81 -> 176
    //   98: aload_0
    //   99: aload 5
    //   101: new 35	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   108: aload_2
    //   109: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 105	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 5
    //   120: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 105	java/io/File:separator	Ljava/lang/String;
    //   126: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 107	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   135: iconst_0
    //   136: ifeq +11 -> 147
    //   139: new 109	java/lang/NullPointerException
    //   142: dup
    //   143: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   146: athrow
    //   147: iconst_0
    //   148: ifeq +11 -> 159
    //   151: new 109	java/lang/NullPointerException
    //   154: dup
    //   155: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   158: athrow
    //   159: iload_3
    //   160: iconst_1
    //   161: iadd
    //   162: istore_3
    //   163: goto -95 -> 68
    //   166: astore_0
    //   167: ldc 112
    //   169: ldc 114
    //   171: aload_0
    //   172: invokestatic 118	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: return
    //   176: aload_0
    //   177: new 35	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   184: aload_1
    //   185: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 105	java/io/File:separator	Ljava/lang/String;
    //   191: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: new 35	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   209: aload_2
    //   210: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: getstatic 105	java/io/File:separator	Ljava/lang/String;
    //   216: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 5
    //   221: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 105	java/io/File:separator	Ljava/lang/String;
    //   227: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 107	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   236: goto -101 -> 135
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_0
    //   242: aload 8
    //   244: astore_1
    //   245: ldc 112
    //   247: ldc 120
    //   249: aload_2
    //   250: invokestatic 118	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_1
    //   254: ifnull +7 -> 261
    //   257: aload_1
    //   258: invokevirtual 125	java/io/InputStream:close	()V
    //   261: aload_0
    //   262: ifnull -240 -> 22
    //   265: aload_0
    //   266: invokevirtual 128	java/io/OutputStream:close	()V
    //   269: return
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   275: return
    //   276: astore 5
    //   278: aload 5
    //   280: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   283: goto -124 -> 159
    //   286: new 88	java/io/File
    //   289: dup
    //   290: aload 9
    //   292: aload 5
    //   294: invokespecial 134	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   297: astore 6
    //   299: aload 6
    //   301: invokevirtual 94	java/io/File:exists	()Z
    //   304: ifeq +9 -> 313
    //   307: aload 6
    //   309: invokevirtual 137	java/io/File:delete	()Z
    //   312: pop
    //   313: aload_1
    //   314: invokevirtual 27	java/lang/String:length	()I
    //   317: ifeq +91 -> 408
    //   320: aload_0
    //   321: invokevirtual 138	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   324: new 35	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   331: aload_1
    //   332: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc 140
    //   337: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload 5
    //   342: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 144	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   351: astore 5
    //   353: new 146	java/io/FileOutputStream
    //   356: dup
    //   357: aload 6
    //   359: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   362: astore 6
    //   364: sipush 8192
    //   367: newarray byte
    //   369: astore 11
    //   371: aload 5
    //   373: aload 11
    //   375: invokevirtual 153	java/io/InputStream:read	([B)I
    //   378: istore 4
    //   380: iload 4
    //   382: ifle +40 -> 422
    //   385: aload 6
    //   387: aload 11
    //   389: iconst_0
    //   390: iload 4
    //   392: invokevirtual 157	java/io/OutputStream:write	([BII)V
    //   395: goto -24 -> 371
    //   398: astore_2
    //   399: aload 5
    //   401: astore_1
    //   402: aload 6
    //   404: astore_0
    //   405: goto -160 -> 245
    //   408: aload_0
    //   409: invokevirtual 138	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   412: aload 5
    //   414: invokevirtual 144	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   417: astore 5
    //   419: goto -66 -> 353
    //   422: aload 5
    //   424: ifnull +8 -> 432
    //   427: aload 5
    //   429: invokevirtual 125	java/io/InputStream:close	()V
    //   432: aload 6
    //   434: ifnull -275 -> 159
    //   437: aload 6
    //   439: invokevirtual 128	java/io/OutputStream:close	()V
    //   442: goto -283 -> 159
    //   445: astore 5
    //   447: aload 5
    //   449: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   452: goto -293 -> 159
    //   455: astore_0
    //   456: aconst_null
    //   457: astore 5
    //   459: aload 7
    //   461: astore_1
    //   462: aload 5
    //   464: ifnull +8 -> 472
    //   467: aload 5
    //   469: invokevirtual 125	java/io/InputStream:close	()V
    //   472: aload_1
    //   473: ifnull +7 -> 480
    //   476: aload_1
    //   477: invokevirtual 128	java/io/OutputStream:close	()V
    //   480: aload_0
    //   481: athrow
    //   482: astore_1
    //   483: aload_1
    //   484: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   487: goto -7 -> 480
    //   490: astore_0
    //   491: aload 7
    //   493: astore_1
    //   494: goto -32 -> 462
    //   497: astore_0
    //   498: aload 6
    //   500: astore_1
    //   501: goto -39 -> 462
    //   504: astore_2
    //   505: aload_1
    //   506: astore 5
    //   508: aload_0
    //   509: astore_1
    //   510: aload_2
    //   511: astore_0
    //   512: goto -50 -> 462
    //   515: astore_2
    //   516: aconst_null
    //   517: astore_0
    //   518: aload 5
    //   520: astore_1
    //   521: goto -276 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	paramContext	Context
    //   0	524	1	paramString1	String
    //   0	524	2	paramString2	String
    //   48	115	3	i	int
    //   7	384	4	j	int
    //   79	141	5	str1	String
    //   276	65	5	localIOException1	java.io.IOException
    //   351	77	5	localInputStream	java.io.InputStream
    //   445	3	5	localIOException2	java.io.IOException
    //   457	62	5	str2	String
    //   297	202	6	localObject1	Object
    //   1	491	7	localObject2	Object
    //   4	239	8	localObject3	Object
    //   44	247	9	localFile	File
    //   34	42	10	arrayOfString	String[]
    //   369	19	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	36	166	java/io/IOException
    //   81	135	239	java/lang/Exception
    //   176	236	239	java/lang/Exception
    //   286	313	239	java/lang/Exception
    //   313	353	239	java/lang/Exception
    //   408	419	239	java/lang/Exception
    //   257	261	270	java/io/IOException
    //   265	269	270	java/io/IOException
    //   139	147	276	java/io/IOException
    //   151	159	276	java/io/IOException
    //   364	371	398	java/lang/Exception
    //   371	380	398	java/lang/Exception
    //   385	395	398	java/lang/Exception
    //   427	432	445	java/io/IOException
    //   437	442	445	java/io/IOException
    //   81	135	455	finally
    //   176	236	455	finally
    //   286	313	455	finally
    //   313	353	455	finally
    //   408	419	455	finally
    //   467	472	482	java/io/IOException
    //   476	480	482	java/io/IOException
    //   353	364	490	finally
    //   364	371	497	finally
    //   371	380	497	finally
    //   385	395	497	finally
    //   245	253	504	finally
    //   353	364	515	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = CommonDataAdapter.a().a();
    if (localObject != null)
    {
      a((Context)localObject, paramString1, paramString2);
      label205:
      label213:
      do
      {
        try
        {
          ZipUtils.a(paramString2, Common.j());
          if (new File(Common.j()).exists())
          {
            paramString1 = MD5Utils.a(Common.j());
            if (!TextUtils.isEmpty(paramString1))
            {
              paramString2 = new File(paramString2);
              localObject = new File(Common.c() + File.separator + paramString1);
              if (paramString2.exists())
              {
                if (!((File)localObject).exists()) {
                  continue;
                }
                if (!((File)localObject).renameTo(new File(Common.i() + SystemClock.currentThreadTimeMillis()))) {
                  break label213;
                }
                LogUtility.b("FileUtils", "<zipAssets> md5Dir exists, rename md5Dir to systemOldFile successful");
                if (!paramString2.renameTo((File)localObject)) {
                  break label205;
                }
                Common.d(paramString1);
                LogUtility.b("FileUtils", "<zipAssets> md5Dir exists, rename tmpDir to md5Dir successful");
              }
            }
          }
          return;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            LogUtility.e("FileUtils", "zipAssets error : " + paramString1.toString());
          }
          LogUtility.c("FileUtils", "<zipAssets> md5Dir exists, rename tmpDir to md5Dir failed");
          return;
        }
        LogUtility.b("FileUtils", "<zipAssets> md5Dir exists, rename md5Dir to systemOldFile failed");
        return;
      } while (!paramString2.renameTo((File)localObject));
      LogUtility.b("FileUtils", "<zipAssets> md5Dir not exists, rename tmpDir to md5Dir successful");
      Common.d(paramString1);
      return;
    }
    LogUtility.e("FileUtils", "plugin context is null !!!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.FileUtils
 * JD-Core Version:    0.7.0.1
 */