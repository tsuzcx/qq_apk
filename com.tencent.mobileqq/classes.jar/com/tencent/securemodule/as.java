package com.tencent.securemodule;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.securemodule.impl.AppInfo;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class as
{
  /* Error */
  public static AppInfo a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 18	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: bipush 64
    //   9: invokevirtual 24	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   12: astore_2
    //   13: new 26	com/tencent/securemodule/impl/AppInfo
    //   16: dup
    //   17: invokespecial 30	com/tencent/securemodule/impl/AppInfo:<init>	()V
    //   20: astore_0
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 34	com/tencent/securemodule/impl/AppInfo:setPkgName	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: aload_2
    //   28: getfield 40	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   31: invokevirtual 43	com/tencent/securemodule/impl/AppInfo:setVersionName	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: aload_2
    //   36: getfield 47	android/content/pm/PackageInfo:versionCode	I
    //   39: invokevirtual 51	com/tencent/securemodule/impl/AppInfo:setVersionCode	(I)V
    //   42: aload_2
    //   43: getfield 55	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   46: iconst_0
    //   47: aaload
    //   48: invokestatic 58	com/tencent/securemodule/as:a	(Landroid/content/pm/Signature;)Ljava/security/cert/Certificate;
    //   51: checkcast 60	java/security/cert/X509Certificate
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +17 -> 73
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 64	java/security/cert/X509Certificate:getEncoded	()[B
    //   64: invokestatic 70	com/tencent/securemodule/az:b	([B)[B
    //   67: invokestatic 73	com/tencent/securemodule/az:a	([B)Ljava/lang/String;
    //   70: invokevirtual 76	com/tencent/securemodule/impl/AppInfo:setCertMd5	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_1
    //   79: invokevirtual 79	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   82: aload_0
    //   83: areturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_1
    //   88: invokevirtual 80	java/security/cert/CertificateEncodingException:printStackTrace	()V
    //   91: aload_0
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_1
    //   97: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   100: aload_0
    //   101: areturn
    //   102: astore_1
    //   103: goto -7 -> 96
    //   106: astore_1
    //   107: goto -20 -> 87
    //   110: astore_1
    //   111: goto -33 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramContext	Context
    //   0	114	1	paramString	String
    //   12	31	2	localPackageInfo	android.content.pm.PackageInfo
    // Exception table:
    //   from	to	target	type
    //   5	21	75	android/content/pm/PackageManager$NameNotFoundException
    //   5	21	84	java/security/cert/CertificateEncodingException
    //   5	21	93	java/lang/Exception
    //   21	55	102	java/lang/Exception
    //   59	73	102	java/lang/Exception
    //   21	55	106	java/security/cert/CertificateEncodingException
    //   59	73	106	java/security/cert/CertificateEncodingException
    //   21	55	110	android/content/pm/PackageManager$NameNotFoundException
    //   59	73	110	android/content/pm/PackageManager$NameNotFoundException
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 87	java/util/zip/ZipFile
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 89	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: new 91	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 96	java/io/File:exists	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifne +46 -> 71
    //   28: iconst_0
    //   29: ifeq +11 -> 40
    //   32: new 98	java/lang/NullPointerException
    //   35: dup
    //   36: invokespecial 99	java/lang/NullPointerException:<init>	()V
    //   39: athrow
    //   40: aload 7
    //   42: astore_0
    //   43: aload_3
    //   44: ifnull +10 -> 54
    //   47: aload_3
    //   48: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   51: aload 7
    //   53: astore_0
    //   54: aload_0
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   61: goto -21 -> 40
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_3
    //   72: ldc 105
    //   74: invokevirtual 109	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +171 -> 250
    //   82: new 111	java/io/BufferedReader
    //   85: dup
    //   86: new 113	java/io/InputStreamReader
    //   89: dup
    //   90: aload_3
    //   91: aload_0
    //   92: invokevirtual 117	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   95: invokespecial 120	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   98: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   101: astore_0
    //   102: aload_3
    //   103: astore 5
    //   105: aload_0
    //   106: astore 4
    //   108: aload_0
    //   109: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   112: astore 6
    //   114: aload_0
    //   115: astore 4
    //   117: aload 6
    //   119: ifnull +134 -> 253
    //   122: aload_3
    //   123: astore 5
    //   125: aload_0
    //   126: astore 4
    //   128: aload 6
    //   130: ldc 129
    //   132: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   135: ifeq -33 -> 102
    //   138: aload_3
    //   139: astore 5
    //   141: aload_0
    //   142: astore 4
    //   144: aload_0
    //   145: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   148: astore 6
    //   150: aload 6
    //   152: ifnull -50 -> 102
    //   155: aload_3
    //   156: astore 5
    //   158: aload_0
    //   159: astore 4
    //   161: aload 6
    //   163: ldc 137
    //   165: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   168: ifeq -66 -> 102
    //   171: aload_3
    //   172: astore 5
    //   174: aload_0
    //   175: astore 4
    //   177: aload 6
    //   179: ldc 139
    //   181: invokevirtual 143	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   184: istore_1
    //   185: iload_1
    //   186: ifle -84 -> 102
    //   189: aload_3
    //   190: astore 5
    //   192: aload_0
    //   193: astore 4
    //   195: aload 6
    //   197: iload_1
    //   198: iconst_1
    //   199: iadd
    //   200: invokevirtual 147	java/lang/String:substring	(I)Ljava/lang/String;
    //   203: invokevirtual 150	java/lang/String:trim	()Ljava/lang/String;
    //   206: astore 6
    //   208: aload 6
    //   210: astore 4
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 151	java/io/BufferedReader:close	()V
    //   220: aload 4
    //   222: astore_0
    //   223: aload_3
    //   224: ifnull -170 -> 54
    //   227: aload_3
    //   228: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   231: aload 4
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   239: aload 4
    //   241: areturn
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   247: goto -27 -> 220
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 151	java/io/BufferedReader:close	()V
    //   263: aload 7
    //   265: astore_0
    //   266: aload_3
    //   267: ifnull -213 -> 54
    //   270: aload_3
    //   271: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   274: aconst_null
    //   275: areturn
    //   276: astore_0
    //   277: aload_0
    //   278: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   281: aconst_null
    //   282: areturn
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   288: goto -25 -> 263
    //   291: astore 6
    //   293: aconst_null
    //   294: astore_3
    //   295: aconst_null
    //   296: astore_0
    //   297: aload_3
    //   298: astore 5
    //   300: aload_0
    //   301: astore 4
    //   303: aload 6
    //   305: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   308: aload_0
    //   309: ifnull +7 -> 316
    //   312: aload_0
    //   313: invokevirtual 151	java/io/BufferedReader:close	()V
    //   316: aload 7
    //   318: astore_0
    //   319: aload_3
    //   320: ifnull -266 -> 54
    //   323: aload_3
    //   324: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   327: aconst_null
    //   328: areturn
    //   329: astore_0
    //   330: aload_0
    //   331: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   334: aconst_null
    //   335: areturn
    //   336: astore_0
    //   337: aload_0
    //   338: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   341: goto -25 -> 316
    //   344: astore_0
    //   345: aconst_null
    //   346: astore_3
    //   347: aconst_null
    //   348: astore 4
    //   350: aload 4
    //   352: ifnull +8 -> 360
    //   355: aload 4
    //   357: invokevirtual 151	java/io/BufferedReader:close	()V
    //   360: aload_3
    //   361: ifnull +7 -> 368
    //   364: aload_3
    //   365: invokevirtual 102	java/util/zip/ZipFile:close	()V
    //   368: aload_0
    //   369: athrow
    //   370: astore 4
    //   372: aload 4
    //   374: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   377: goto -17 -> 360
    //   380: astore_3
    //   381: aload_3
    //   382: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   385: goto -17 -> 368
    //   388: astore_0
    //   389: aconst_null
    //   390: astore 4
    //   392: goto -42 -> 350
    //   395: astore_0
    //   396: aload 5
    //   398: astore_3
    //   399: goto -49 -> 350
    //   402: astore 6
    //   404: aconst_null
    //   405: astore_0
    //   406: goto -109 -> 297
    //   409: astore 6
    //   411: goto -114 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	paramString	String
    //   184	16	1	i	int
    //   23	2	2	bool	boolean
    //   11	354	3	localZipFile1	java.util.zip.ZipFile
    //   380	2	3	localIOException1	IOException
    //   398	1	3	localObject1	Object
    //   106	250	4	localObject2	Object
    //   370	3	4	localIOException2	IOException
    //   390	1	4	localObject3	Object
    //   103	294	5	localZipFile2	java.util.zip.ZipFile
    //   112	97	6	str	String
    //   291	13	6	localIOException3	IOException
    //   402	1	6	localIOException4	IOException
    //   409	1	6	localIOException5	IOException
    //   1	316	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   32	40	56	java/io/IOException
    //   47	51	64	java/io/IOException
    //   227	231	234	java/io/IOException
    //   216	220	242	java/io/IOException
    //   270	274	276	java/io/IOException
    //   258	263	283	java/io/IOException
    //   3	12	291	java/io/IOException
    //   323	327	329	java/io/IOException
    //   312	316	336	java/io/IOException
    //   3	12	344	finally
    //   355	360	370	java/io/IOException
    //   364	368	380	java/io/IOException
    //   12	24	388	finally
    //   71	78	388	finally
    //   82	102	388	finally
    //   108	114	395	finally
    //   128	138	395	finally
    //   144	150	395	finally
    //   161	171	395	finally
    //   177	185	395	finally
    //   195	208	395	finally
    //   303	308	395	finally
    //   12	24	402	java/io/IOException
    //   71	78	402	java/io/IOException
    //   82	102	402	java/io/IOException
    //   108	114	409	java/io/IOException
    //   128	138	409	java/io/IOException
    //   144	150	409	java/io/IOException
    //   161	171	409	java/io/IOException
    //   177	185	409	java/io/IOException
    //   195	208	409	java/io/IOException
  }
  
  private static Certificate a(Signature paramSignature)
  {
    paramSignature = new ByteArrayInputStream(paramSignature.toByteArray());
    try
    {
      X509Certificate localX509Certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramSignature);
      if (paramSignature != null) {}
      try
      {
        paramSignature.close();
        return localX509Certificate;
      }
      catch (IOException paramSignature)
      {
        paramSignature.printStackTrace();
        return localX509Certificate;
      }
      return null;
    }
    catch (CertificateException localCertificateException)
    {
      localCertificateException.printStackTrace();
      if (paramSignature != null) {
        try
        {
          paramSignature.close();
          return null;
        }
        catch (IOException paramSignature)
        {
          paramSignature.printStackTrace();
          return null;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (paramSignature != null) {
        try
        {
          paramSignature.close();
          return null;
        }
        catch (IOException paramSignature)
        {
          paramSignature.printStackTrace();
          return null;
        }
      }
    }
    finally
    {
      if (paramSignature != null) {}
      try
      {
        paramSignature.close();
        throw localObject;
      }
      catch (IOException paramSignature)
      {
        for (;;)
        {
          paramSignature.printStackTrace();
        }
      }
    }
  }
  
  public static List<AppInfo> a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = localPackageManager.getInstalledApplications(0).iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
      label61:
      AppInfo localAppInfo;
      if ((localApplicationInfo.flags & 0x1) != 0)
      {
        i = 1;
        if ((i != 0) && (!paramBoolean)) {
          break label188;
        }
        localAppInfo = a(paramContext, localApplicationInfo.packageName);
        if (localAppInfo == null) {
          continue;
        }
        localAppInfo.setSoftName(az.a(localPackageManager.getApplicationLabel(localApplicationInfo).toString()));
        if (i == 0) {
          break label190;
        }
      }
      label188:
      label190:
      for (int i = 1;; i = 0)
      {
        localAppInfo.setAppType(i);
        localAppInfo.setFileSize(new File(localApplicationInfo.sourceDir).length());
        localAppInfo.setApkPath(localApplicationInfo.sourceDir);
        localArrayList.add(localAppInfo);
        ax.b("CloudScan", "add app " + localApplicationInfo.packageName);
        break;
        i = 0;
        break label61;
        break;
      }
    }
    return localArrayList;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 8192);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = paramContext.flags;
        bool1 = bool2;
        if ((i & 0x1) != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String b(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = new StringBuffer();
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      i = 0;
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo != null)
        {
          paramContext.append(localRunningAppProcessInfo.processName);
          paramContext.append(";");
          int j = i + 1;
          i = j;
          if (j <= 100) {}
        }
      }
      else
      {
        if (paramContext.length() > 0) {
          paramContext.deleteCharAt(paramContext.length() - 1);
        }
        return paramContext.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.as
 * JD-Core Version:    0.7.0.1
 */