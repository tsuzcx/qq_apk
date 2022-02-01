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
  public static byte a(int paramInt, String arg1)
  {
    a(paramInt, true);
    byte b2 = 2;
    for (;;)
    {
      try
      {
        a(???, a(paramInt));
        Object localObject4 = new HashMap();
        SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4).edit();
        ??? = new StringBuilder();
        ???.append(a(paramInt));
        ???.append("/config.xml");
        Object localObject1 = new File(???.toString());
        if (((File)localObject1).exists())
        {
          ??? = null;
          try
          {
            localObject1 = FileUtils.readFileToString((File)localObject1);
            ??? = (String)localObject1;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
          if ((??? != null) && (a(paramInt, ???, (HashMap)localObject4))) {
            synchronized (a(paramInt))
            {
              Object localObject2 = ((HashMap)localObject4).entrySet().iterator();
              if (!((Iterator)localObject2).hasNext()) {
                break label608;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              String str = c(paramInt, (String)((Map.Entry)localObject4).getKey());
              Object localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(a(paramInt));
              ((StringBuilder)localObject5).append(File.separator);
              ((StringBuilder)localObject5).append(str);
              localObject5 = ((StringBuilder)localObject5).toString();
              File localFile = new File((String)localObject5);
              if (localFile.exists())
              {
                localObject5 = Util.a((String)localObject5);
                if (!((String)((Map.Entry)localObject4).getValue()).equalsIgnoreCase((String)localObject5))
                {
                  localFile.delete();
                  b1 = b2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("MiniRecog.BaseQRScanResLoader", 2, String.format("doOnDownloadSuccess md5 failed file=[%s] file.md5=[%s] cfg.md5=[%s]", new Object[] { str, localObject5, ((Map.Entry)localObject4).getValue() }));
                    b1 = b2;
                  }
                }
                else
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("qrscan_native_res_");
                  ((StringBuilder)localObject5).append(str);
                  localEditor.putString(((StringBuilder)localObject5).toString(), (String)((Map.Entry)localObject4).getValue());
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("doOnDownloadSuccess save sp key =  qrscan_native_res_");
                  ((StringBuilder)localObject5).append(str);
                  ((StringBuilder)localObject5).append(",value = ");
                  ((StringBuilder)localObject5).append((String)((Map.Entry)localObject4).getValue());
                  QLog.d("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject5).toString());
                }
              }
              else
              {
                if (!QLog.isColorLevel()) {
                  break label603;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("doOnDownloadSuccess file not exists = ");
                ((StringBuilder)localObject2).append((String)localObject5);
                QLog.d("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject2).toString());
                break label603;
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
      catch (IOException ???)
      {
        a(paramInt, false);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uncompressZip false: ");
          localStringBuilder.append(???.getMessage());
          QLog.d("MiniRecog.BaseQRScanResLoader", 2, localStringBuilder.toString());
        }
        FileUtils.delete(a(paramInt), false);
        return -1;
      }
      label603:
      byte b1 = 3;
      continue;
      label608:
      b1 = 0;
    }
  }
  
  public static byte a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a(paramInt));
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(b(paramInt, paramString));
    localObject1 = ((StringBuilder)localObject1).toString();
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
  
  public static Object a(int paramInt)
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
    return null;
  }
  
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
    //   0: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 45	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 250
    //   17: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 136
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: astore 4
    //   40: new 252	com/tencent/commonsdk/zip/QZipFile
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 253	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 257	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 6
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore 7
    //   62: aload 6
    //   64: invokeinterface 262 1 0
    //   69: ifeq +339 -> 408
    //   72: aload 6
    //   74: invokeinterface 265 1 0
    //   79: checkcast 267	java/util/zip/ZipEntry
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 270	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull -29 -> 62
    //   94: aload 5
    //   96: ldc_w 272
    //   99: invokevirtual 276	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +6 -> 108
    //   105: goto -43 -> 62
    //   108: new 45	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   115: astore 8
    //   117: aload 8
    //   119: aload_1
    //   120: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 8
    //   126: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   129: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 8
    //   135: aload 5
    //   137: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 8
    //   143: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 5
    //   148: aload_0
    //   149: invokevirtual 279	java/util/zip/ZipEntry:isDirectory	()Z
    //   152: ifeq +28 -> 180
    //   155: new 54	java/io/File
    //   158: dup
    //   159: aload 5
    //   161: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 65	java/io/File:exists	()Z
    //   169: ifne -107 -> 62
    //   172: aload_0
    //   173: invokevirtual 282	java/io/File:mkdir	()Z
    //   176: pop
    //   177: goto -115 -> 62
    //   180: aload 5
    //   182: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   185: invokevirtual 286	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   188: istore_2
    //   189: aload 5
    //   191: iconst_0
    //   192: iload_2
    //   193: invokevirtual 290	java/lang/String:substring	(II)Ljava/lang/String;
    //   196: astore 8
    //   198: aload 5
    //   200: iload_2
    //   201: iconst_1
    //   202: iadd
    //   203: invokevirtual 292	java/lang/String:substring	(I)Ljava/lang/String;
    //   206: ldc_w 294
    //   209: invokevirtual 297	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   212: ifeq +6 -> 218
    //   215: goto -153 -> 62
    //   218: new 54	java/io/File
    //   221: dup
    //   222: aload 8
    //   224: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   227: astore 8
    //   229: aload 8
    //   231: invokevirtual 65	java/io/File:exists	()Z
    //   234: ifne +9 -> 243
    //   237: aload 8
    //   239: invokevirtual 282	java/io/File:mkdir	()Z
    //   242: pop
    //   243: new 45	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   250: astore 8
    //   252: aload 8
    //   254: aload 5
    //   256: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 8
    //   262: ldc_w 299
    //   265: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: new 54	java/io/File
    //   272: dup
    //   273: aload 8
    //   275: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   281: astore 8
    //   283: new 54	java/io/File
    //   286: dup
    //   287: aload 5
    //   289: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   292: astore 9
    //   294: aload 8
    //   296: invokevirtual 65	java/io/File:exists	()Z
    //   299: ifeq +9 -> 308
    //   302: aload 8
    //   304: invokevirtual 129	java/io/File:delete	()Z
    //   307: pop
    //   308: new 301	java/io/FileOutputStream
    //   311: dup
    //   312: aload 8
    //   314: invokespecial 304	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   317: astore 5
    //   319: aload_3
    //   320: aload_0
    //   321: invokevirtual 308	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   324: astore_0
    //   325: aload_0
    //   326: aload 7
    //   328: iconst_0
    //   329: aload 7
    //   331: arraylength
    //   332: invokevirtual 314	java/io/InputStream:read	([BII)I
    //   335: istore_2
    //   336: iload_2
    //   337: iconst_m1
    //   338: if_icmpeq +15 -> 353
    //   341: aload 5
    //   343: aload 7
    //   345: iconst_0
    //   346: iload_2
    //   347: invokevirtual 318	java/io/FileOutputStream:write	([BII)V
    //   350: goto -25 -> 325
    //   353: aload 5
    //   355: invokevirtual 321	java/io/FileOutputStream:flush	()V
    //   358: aload 5
    //   360: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   363: aload_0
    //   364: invokevirtual 325	java/io/InputStream:close	()V
    //   367: aload 8
    //   369: aload 9
    //   371: invokestatic 329	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   374: ifne -312 -> 62
    //   377: aload 8
    //   379: aload 9
    //   381: invokestatic 332	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   384: pop
    //   385: goto -323 -> 62
    //   388: astore 4
    //   390: aload_0
    //   391: astore_1
    //   392: aload 4
    //   394: astore_0
    //   395: goto +6 -> 401
    //   398: astore_0
    //   399: aconst_null
    //   400: astore_1
    //   401: aload 5
    //   403: astore 4
    //   405: goto +25 -> 430
    //   408: aload_3
    //   409: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   412: return
    //   413: astore_0
    //   414: aload_0
    //   415: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   418: return
    //   419: astore_0
    //   420: aconst_null
    //   421: astore_1
    //   422: goto +8 -> 430
    //   425: astore_0
    //   426: aconst_null
    //   427: astore_3
    //   428: aload_3
    //   429: astore_1
    //   430: aload 4
    //   432: ifnull +18 -> 450
    //   435: aload 4
    //   437: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   440: goto +10 -> 450
    //   443: astore 4
    //   445: aload 4
    //   447: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   450: aload_1
    //   451: ifnull +15 -> 466
    //   454: aload_1
    //   455: invokevirtual 325	java/io/InputStream:close	()V
    //   458: goto +8 -> 466
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   466: aload_3
    //   467: ifnull +15 -> 482
    //   470: aload_3
    //   471: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   474: goto +8 -> 482
    //   477: astore_1
    //   478: aload_1
    //   479: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   482: goto +5 -> 487
    //   485: aload_0
    //   486: athrow
    //   487: goto -2 -> 485
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramString1	String
    //   0	490	1	paramString2	String
    //   188	159	2	i	int
    //   13	458	3	localObject1	Object
    //   38	1	4	localObject2	Object
    //   388	5	4	localObject3	Object
    //   403	33	4	localObject4	Object
    //   443	3	4	localIOException	IOException
    //   87	315	5	localObject5	Object
    //   53	20	6	localEnumeration	java.util.Enumeration
    //   60	284	7	arrayOfByte	byte[]
    //   115	263	8	localObject6	Object
    //   292	88	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   325	336	388	finally
    //   341	350	388	finally
    //   353	367	388	finally
    //   319	325	398	finally
    //   408	412	413	java/io/IOException
    //   49	62	419	finally
    //   62	89	419	finally
    //   94	105	419	finally
    //   108	177	419	finally
    //   180	215	419	finally
    //   218	243	419	finally
    //   243	308	419	finally
    //   308	319	419	finally
    //   367	385	419	finally
    //   40	49	425	finally
    //   435	440	443	java/io/IOException
    //   454	458	461	java/io/IOException
    //   470	474	477	java/io/IOException
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a(paramInt));
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(b(paramInt, paramString));
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new File(str);
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (!paramBoolean)
    {
      bool1 = bool3;
      if (((File)localObject1).exists())
      {
        localObject1 = a(paramInt);
        bool1 = bool3;
        if (localObject1 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = a(paramInt, paramString);
        str = Util.a(str);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSoFileExist: soName= ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" ,spmd5 = ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(",fileMD5 = ");
          localStringBuilder.append(str);
          QLog.d("MiniRecog.BaseQRScanResLoader", 2, localStringBuilder.toString());
        }
        if ((localObject2 == null) || (((String)localObject2).equalsIgnoreCase(str))) {
          break label354;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("isSoFileExist: soName= ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" check md5 false!");
          QLog.d("MiniRecog.BaseQRScanResLoader", 2, ((StringBuilder)localObject2).toString());
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
      label354:
      bool1 = true;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.BaseQRScanResLoader
 * JD-Core Version:    0.7.0.1
 */