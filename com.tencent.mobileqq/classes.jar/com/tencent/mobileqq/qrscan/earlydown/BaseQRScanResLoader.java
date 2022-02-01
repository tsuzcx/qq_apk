package com.tencent.mobileqq.qrscan.earlydown;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qrscan.utils.Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public abstract class BaseQRScanResLoader
{
  protected static String a(int paramInt)
  {
    if (paramInt == 0) {
      return MiniScanDecodeSoLoader.a();
    }
    if (paramInt == 1) {
      return MiniScanDetectSoLoader.a();
    }
    if (paramInt == 2) {
      return MiniScanDetectModelLoader.a();
    }
    if (paramInt == 3) {
      return QBarModelLoader.a();
    }
    return "";
  }
  
  public static String a(int paramInt, String paramString)
  {
    paramString = b(paramInt, paramString);
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qrscan_native_res_");
    localStringBuilder.append(paramString);
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFileMd5BySP ,resName = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",md5 = ");
      localStringBuilder.append((String)localObject);
      QLog.i("MiniRecog.BaseQRScanResLoader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  protected static void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      MiniScanDecodeSoLoader.a(paramBoolean);
      return;
    }
    if (paramInt == 1)
    {
      MiniScanDetectSoLoader.a(paramBoolean);
      return;
    }
    if (paramInt == 2)
    {
      MiniScanDetectModelLoader.a(paramBoolean);
      return;
    }
    if (paramInt == 3) {
      QBarModelLoader.a(paramBoolean);
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 45	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 89
    //   17: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 73
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: astore 4
    //   40: new 94	com/tencent/commonsdk/zip/QZipFile
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 97	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 101	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 6
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore 7
    //   62: aload 6
    //   64: invokeinterface 106 1 0
    //   69: ifeq +336 -> 405
    //   72: aload 6
    //   74: invokeinterface 110 1 0
    //   79: checkcast 112	java/util/zip/ZipEntry
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 115	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull -29 -> 62
    //   94: aload 5
    //   96: ldc 117
    //   98: invokevirtual 123	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +6 -> 107
    //   104: goto -42 -> 62
    //   107: new 45	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   114: astore 8
    //   116: aload 8
    //   118: aload_1
    //   119: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 8
    //   125: getstatic 129	java/io/File:separator	Ljava/lang/String;
    //   128: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 8
    //   134: aload 5
    //   136: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 8
    //   142: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: aload_0
    //   148: invokevirtual 132	java/util/zip/ZipEntry:isDirectory	()Z
    //   151: ifeq +28 -> 179
    //   154: new 125	java/io/File
    //   157: dup
    //   158: aload 5
    //   160: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 136	java/io/File:exists	()Z
    //   168: ifne -106 -> 62
    //   171: aload_0
    //   172: invokevirtual 139	java/io/File:mkdir	()Z
    //   175: pop
    //   176: goto -114 -> 62
    //   179: aload 5
    //   181: getstatic 129	java/io/File:separator	Ljava/lang/String;
    //   184: invokevirtual 143	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload 5
    //   190: iconst_0
    //   191: iload_2
    //   192: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   195: astore 8
    //   197: aload 5
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 149	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: ldc 151
    //   207: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   210: ifeq +6 -> 216
    //   213: goto -151 -> 62
    //   216: new 125	java/io/File
    //   219: dup
    //   220: aload 8
    //   222: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: astore 8
    //   227: aload 8
    //   229: invokevirtual 136	java/io/File:exists	()Z
    //   232: ifne +9 -> 241
    //   235: aload 8
    //   237: invokevirtual 158	java/io/File:mkdirs	()Z
    //   240: pop
    //   241: new 45	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   248: astore 8
    //   250: aload 8
    //   252: aload 5
    //   254: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 8
    //   260: ldc 160
    //   262: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: new 125	java/io/File
    //   269: dup
    //   270: aload 8
    //   272: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   278: astore 8
    //   280: new 125	java/io/File
    //   283: dup
    //   284: aload 5
    //   286: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 9
    //   291: aload 8
    //   293: invokevirtual 136	java/io/File:exists	()Z
    //   296: ifeq +9 -> 305
    //   299: aload 8
    //   301: invokevirtual 163	java/io/File:delete	()Z
    //   304: pop
    //   305: new 165	java/io/FileOutputStream
    //   308: dup
    //   309: aload 8
    //   311: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   314: astore 5
    //   316: aload_3
    //   317: aload_0
    //   318: invokevirtual 172	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   321: astore_0
    //   322: aload_0
    //   323: aload 7
    //   325: iconst_0
    //   326: aload 7
    //   328: arraylength
    //   329: invokevirtual 178	java/io/InputStream:read	([BII)I
    //   332: istore_2
    //   333: iload_2
    //   334: iconst_m1
    //   335: if_icmpeq +15 -> 350
    //   338: aload 5
    //   340: aload 7
    //   342: iconst_0
    //   343: iload_2
    //   344: invokevirtual 182	java/io/FileOutputStream:write	([BII)V
    //   347: goto -25 -> 322
    //   350: aload 5
    //   352: invokevirtual 185	java/io/FileOutputStream:flush	()V
    //   355: aload 5
    //   357: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   360: aload_0
    //   361: invokevirtual 189	java/io/InputStream:close	()V
    //   364: aload 8
    //   366: aload 9
    //   368: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   371: ifne -309 -> 62
    //   374: aload 8
    //   376: aload 9
    //   378: invokestatic 198	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   381: pop
    //   382: goto -320 -> 62
    //   385: astore 4
    //   387: aload_0
    //   388: astore_1
    //   389: aload 4
    //   391: astore_0
    //   392: goto +6 -> 398
    //   395: astore_0
    //   396: aconst_null
    //   397: astore_1
    //   398: aload 5
    //   400: astore 4
    //   402: goto +25 -> 427
    //   405: aload_3
    //   406: invokevirtual 199	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   409: return
    //   410: astore_0
    //   411: aload_0
    //   412: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   415: return
    //   416: astore_0
    //   417: aconst_null
    //   418: astore_1
    //   419: goto +8 -> 427
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_3
    //   425: aload_3
    //   426: astore_1
    //   427: aload 4
    //   429: ifnull +18 -> 447
    //   432: aload 4
    //   434: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   437: goto +10 -> 447
    //   440: astore 4
    //   442: aload 4
    //   444: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   447: aload_1
    //   448: ifnull +15 -> 463
    //   451: aload_1
    //   452: invokevirtual 189	java/io/InputStream:close	()V
    //   455: goto +8 -> 463
    //   458: astore_1
    //   459: aload_1
    //   460: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   463: aload_3
    //   464: ifnull +15 -> 479
    //   467: aload_3
    //   468: invokevirtual 199	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   471: goto +8 -> 479
    //   474: astore_1
    //   475: aload_1
    //   476: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   479: goto +5 -> 484
    //   482: aload_0
    //   483: athrow
    //   484: goto -2 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramString1	String
    //   0	487	1	paramString2	String
    //   187	157	2	i	int
    //   13	455	3	localObject1	Object
    //   38	1	4	localObject2	Object
    //   385	5	4	localObject3	Object
    //   400	33	4	localObject4	Object
    //   440	3	4	localIOException	IOException
    //   87	312	5	localObject5	Object
    //   53	20	6	localEnumeration	java.util.Enumeration
    //   60	281	7	arrayOfByte	byte[]
    //   114	261	8	localObject6	Object
    //   289	88	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   322	333	385	finally
    //   338	347	385	finally
    //   350	364	385	finally
    //   316	322	395	finally
    //   405	409	410	java/io/IOException
    //   49	62	416	finally
    //   62	89	416	finally
    //   94	104	416	finally
    //   107	176	416	finally
    //   179	213	416	finally
    //   216	241	416	finally
    //   241	305	416	finally
    //   305	316	416	finally
    //   364	382	416	finally
    //   40	49	422	finally
    //   432	437	440	java/io/IOException
    //   451	455	458	java/io/IOException
    //   467	471	474	java/io/IOException
  }
  
  public static boolean a(int paramInt, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramInt == 0) {
      return MiniScanDecodeSoLoader.a(paramString, paramHashMap);
    }
    if (paramInt == 1) {
      return MiniScanDetectSoLoader.a(paramString, paramHashMap);
    }
    if (paramInt == 2) {
      return MiniScanDetectModelLoader.a(paramString, paramHashMap);
    }
    if (paramInt == 3) {
      return QBarModelLoader.a(paramString, paramHashMap);
    }
    return false;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(paramInt));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("minicode");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(b(paramInt, paramString));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(paramInt));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(b(paramInt, paramString));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = new File((String)localObject1);
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (!paramBoolean)
    {
      bool1 = bool3;
      if (((File)localObject2).exists())
      {
        localObject2 = b(paramInt);
        bool1 = bool3;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        String str = a(paramInt, paramString);
        localObject1 = Util.a((String)localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSoFileExist: soName= ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" ,spmd5 = ");
          localStringBuilder.append(str);
          localStringBuilder.append(",fileMD5 = ");
          localStringBuilder.append((String)localObject1);
          QLog.d("MiniRecog.BaseQRScanResLoader", 2, localStringBuilder.toString());
        }
        if ((str == null) || (str.equalsIgnoreCase((String)localObject1))) {
          break label416;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isSoFileExist: soName= ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" check md5 false!");
          QLog.d("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject1).toString());
          bool1 = bool2;
        }
      }
      finally {}
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isSoFileExist: soName= ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" ,result = ");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(",isUncompressZip = ");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject1).toString());
      }
      return bool1;
      label416:
      bool1 = true;
    }
  }
  
  public static byte b(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(paramInt));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("minicode");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(b(paramInt, paramString));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(paramInt));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(b(paramInt, paramString));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start loadMiniNativeSo: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new File((String)localObject1);
    byte b1 = 0;
    byte b2 = 0;
    if ((!paramBoolean) && (((File)localObject2).exists()))
    {
      try
      {
        SoLoadUtilNew.loadSoByName(MobileQQ.getContext(), "c++_shared");
        System.load((String)localObject1);
        if (!QLog.isColorLevel()) {
          return b1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("load ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" success!");
        QLog.i("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject2).toString());
        return 0;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("load from mini dir failed, libName = ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(localUnsatisfiedLinkError.getMessage());
        QLog.d("MiniRecog.BaseQRScanResLoader", 1, ((StringBuilder)localObject2).toString());
        return -2;
      }
    }
    else
    {
      b1 = b2;
      if (paramBoolean)
      {
        b1 = b2;
        if (!((File)localObject2).exists()) {
          b1 = -3;
        }
      }
      b2 = b1;
      if (paramBoolean)
      {
        b2 = b1;
        if (((File)localObject2).exists()) {
          b2 = -4;
        }
      }
      b1 = b2;
      if (!paramBoolean)
      {
        b1 = b2;
        if (!((File)localObject2).exists()) {
          b1 = -5;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no mini so in mini dir,libName = ");
      localStringBuilder.append(paramString);
      QLog.d("MiniRecog.BaseQRScanResLoader", 1, localStringBuilder.toString());
    }
    return b1;
  }
  
  public static Object b(int paramInt)
  {
    if (paramInt == 0) {
      return MiniScanDecodeSoLoader.c();
    }
    if (paramInt == 1) {
      return MiniScanDetectSoLoader.c();
    }
    if (paramInt == 2) {
      return MiniScanDetectModelLoader.b();
    }
    if (paramInt == 3) {
      return QBarModelLoader.b();
    }
    return null;
  }
  
  public static String b(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return MiniScanDecodeSoLoader.a(paramString);
    }
    if (paramInt == 1) {
      return MiniScanDetectSoLoader.a(paramString);
    }
    if (paramInt == 2) {
      return MiniScanDetectModelLoader.a(paramString);
    }
    if (paramInt == 3) {
      return QBarModelLoader.a(paramString);
    }
    return "";
  }
  
  public static String c(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return MiniScanDecodeSoLoader.b(paramString);
    }
    if (paramInt == 1) {
      return MiniScanDetectSoLoader.b(paramString);
    }
    if (paramInt == 2) {
      return MiniScanDetectModelLoader.b(paramString);
    }
    if (paramInt == 3) {
      return QBarModelLoader.b(paramString);
    }
    return "";
  }
  
  public static byte d(int paramInt, String paramString)
  {
    a(paramInt, true);
    byte b2 = 2;
    for (;;)
    {
      try
      {
        a(paramString, a(paramInt));
        Object localObject3 = new HashMap();
        SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4).edit();
        if (paramInt == 0)
        {
          paramString = new StringBuilder();
          paramString.append(a(paramInt));
          paramString.append(File.separator);
          paramString.append("minicode");
          paramString.append("/config.xml");
          paramString = paramString.toString();
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append(a(paramInt));
          paramString.append("/config.xml");
          paramString = paramString.toString();
        }
        Object localObject1 = new File(paramString);
        if (((File)localObject1).exists())
        {
          paramString = null;
          try
          {
            localObject1 = FileUtils.readFileToString((File)localObject1);
            paramString = (String)localObject1;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
          if ((paramString != null) && (a(paramInt, paramString, (HashMap)localObject3))) {
            synchronized (b(paramInt))
            {
              localObject3 = ((HashMap)localObject3).entrySet().iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label709;
              }
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
              String str = c(paramInt, (String)localEntry.getKey());
              if (paramInt == 0)
              {
                paramString = new StringBuilder();
                paramString.append(a(paramInt));
                paramString.append(File.separator);
                paramString.append("minicode");
                paramString.append(File.separator);
                paramString.append(str);
                paramString = paramString.toString();
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append(a(paramInt));
                paramString.append(File.separator);
                paramString.append(str);
                paramString = paramString.toString();
              }
              File localFile = new File(paramString);
              if (localFile.exists())
              {
                paramString = Util.a(paramString);
                if (!((String)localEntry.getValue()).equalsIgnoreCase(paramString))
                {
                  localFile.delete();
                  b1 = b2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("MiniRecog.BaseQRScanResLoader", 2, String.format("doOnDownloadSuccess md5 failed file=[%s] file.md5=[%s] cfg.md5=[%s]", new Object[] { str, paramString, localEntry.getValue() }));
                    b1 = b2;
                  }
                }
                else
                {
                  paramString = new StringBuilder();
                  paramString.append("qrscan_native_res_");
                  paramString.append(str);
                  localEditor.putString(paramString.toString(), (String)localEntry.getValue());
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  paramString = new StringBuilder();
                  paramString.append("doOnDownloadSuccess save sp key =  qrscan_native_res_");
                  paramString.append(str);
                  paramString.append(",value = ");
                  paramString.append((String)localEntry.getValue());
                  QLog.d("MiniRecog.BaseQRScanResLoader", 2, paramString.toString());
                }
              }
              else
              {
                if (!QLog.isColorLevel()) {
                  break label704;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("doOnDownloadSuccess file not exists = ");
                ((StringBuilder)localObject3).append(paramString);
                QLog.d("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject3).toString());
                break label704;
              }
              localEditor.commit();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.BaseQRScanResLoader", 2, "config data is not correct");
          }
          b1 = 4;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.BaseQRScanResLoader", 2, "config file is not exist");
          }
          b1 = 0;
        }
        a(paramInt, false);
        return b1;
      }
      catch (IOException paramString)
      {
        a(paramInt, false);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("uncompressZip false: ");
          ((StringBuilder)???).append(paramString.getMessage());
          QLog.d("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)???).toString());
        }
        FileUtils.delete(a(paramInt), false);
        return -1;
      }
      label704:
      byte b1 = 3;
      continue;
      label709:
      b1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.BaseQRScanResLoader
 * JD-Core Version:    0.7.0.1
 */