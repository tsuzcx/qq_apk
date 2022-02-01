package com.tencent.securemodule;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.securemodule.impl.AppInfo;
import java.io.File;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class as
{
  public static AppInfo a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      Object localObject = paramContext.getPackageInfo(paramString, 64);
      paramContext = new AppInfo();
      try
      {
        paramContext.setPkgName(paramString);
        paramContext.setVersionName(((PackageInfo)localObject).versionName);
        paramContext.setVersionCode(((PackageInfo)localObject).versionCode);
        localObject = (X509Certificate)a(localObject.signatures[0]);
        paramString = paramContext;
        if (localObject == null) {
          return paramString;
        }
        paramContext.setCertMd5(az.a(az.b(((X509Certificate)localObject).getEncoded())));
        return paramContext;
      }
      catch (Exception paramString) {}catch (CertificateEncodingException paramString) {}catch (PackageManager.NameNotFoundException paramString) {}
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (CertificateEncodingException paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramContext = null;
    }
    paramString = paramContext;
    return paramString;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
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
    //   25: ifne +16 -> 41
    //   28: aload_3
    //   29: invokevirtual 99	java/util/zip/ZipFile:close	()V
    //   32: aconst_null
    //   33: areturn
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   39: aconst_null
    //   40: areturn
    //   41: aload_3
    //   42: ldc 102
    //   44: invokevirtual 106	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +161 -> 210
    //   52: new 108	java/io/BufferedReader
    //   55: dup
    //   56: new 110	java/io/InputStreamReader
    //   59: dup
    //   60: aload_3
    //   61: aload_0
    //   62: invokevirtual 114	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   65: invokespecial 117	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 120	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore_0
    //   72: aload_3
    //   73: astore 4
    //   75: aload_0
    //   76: astore 5
    //   78: aload_0
    //   79: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore 6
    //   84: aload_0
    //   85: astore 4
    //   87: aload 6
    //   89: ifnull +124 -> 213
    //   92: aload_3
    //   93: astore 4
    //   95: aload_0
    //   96: astore 5
    //   98: aload 6
    //   100: ldc 126
    //   102: invokevirtual 132	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   105: ifeq -33 -> 72
    //   108: aload_3
    //   109: astore 4
    //   111: aload_0
    //   112: astore 5
    //   114: aload_0
    //   115: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   118: astore 6
    //   120: aload 6
    //   122: ifnull -50 -> 72
    //   125: aload_3
    //   126: astore 4
    //   128: aload_0
    //   129: astore 5
    //   131: aload 6
    //   133: ldc 134
    //   135: invokevirtual 132	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   138: ifeq -66 -> 72
    //   141: aload_3
    //   142: astore 4
    //   144: aload_0
    //   145: astore 5
    //   147: aload 6
    //   149: ldc 136
    //   151: invokevirtual 140	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   154: istore_1
    //   155: iload_1
    //   156: ifle -84 -> 72
    //   159: aload_3
    //   160: astore 4
    //   162: aload_0
    //   163: astore 5
    //   165: aload 6
    //   167: iload_1
    //   168: iconst_1
    //   169: iadd
    //   170: invokevirtual 144	java/lang/String:substring	(I)Ljava/lang/String;
    //   173: invokevirtual 147	java/lang/String:trim	()Ljava/lang/String;
    //   176: astore 6
    //   178: aload_0
    //   179: invokevirtual 148	java/io/BufferedReader:close	()V
    //   182: goto +8 -> 190
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   190: aload_3
    //   191: invokevirtual 99	java/util/zip/ZipFile:close	()V
    //   194: aload 6
    //   196: areturn
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   202: aload 6
    //   204: areturn
    //   205: astore 6
    //   207: goto +53 -> 260
    //   210: aconst_null
    //   211: astore 4
    //   213: aload 4
    //   215: ifnull +16 -> 231
    //   218: aload 4
    //   220: invokevirtual 148	java/io/BufferedReader:close	()V
    //   223: goto +8 -> 231
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   231: aload_3
    //   232: invokevirtual 99	java/util/zip/ZipFile:close	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_0
    //   238: goto +74 -> 312
    //   241: astore 6
    //   243: aconst_null
    //   244: astore_0
    //   245: goto +15 -> 260
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_3
    //   251: goto +61 -> 312
    //   254: astore 6
    //   256: aconst_null
    //   257: astore_3
    //   258: aload_3
    //   259: astore_0
    //   260: aload_3
    //   261: astore 4
    //   263: aload_0
    //   264: astore 5
    //   266: aload 6
    //   268: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   271: aload_0
    //   272: ifnull +15 -> 287
    //   275: aload_0
    //   276: invokevirtual 148	java/io/BufferedReader:close	()V
    //   279: goto +8 -> 287
    //   282: astore_0
    //   283: aload_0
    //   284: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   287: aload_3
    //   288: ifnull +14 -> 302
    //   291: aload_3
    //   292: invokevirtual 99	java/util/zip/ZipFile:close	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   302: aconst_null
    //   303: areturn
    //   304: astore_0
    //   305: aload 4
    //   307: astore_3
    //   308: aload 5
    //   310: astore 4
    //   312: aload 4
    //   314: ifnull +18 -> 332
    //   317: aload 4
    //   319: invokevirtual 148	java/io/BufferedReader:close	()V
    //   322: goto +10 -> 332
    //   325: astore 4
    //   327: aload 4
    //   329: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   332: aload_3
    //   333: ifnull +15 -> 348
    //   336: aload_3
    //   337: invokevirtual 99	java/util/zip/ZipFile:close	()V
    //   340: goto +8 -> 348
    //   343: astore_3
    //   344: aload_3
    //   345: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   348: goto +5 -> 353
    //   351: aload_0
    //   352: athrow
    //   353: goto -2 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramString	String
    //   154	16	1	i	int
    //   23	2	2	bool	boolean
    //   11	326	3	localObject1	Object
    //   343	2	3	localIOException1	java.io.IOException
    //   1	317	4	localObject2	Object
    //   325	3	4	localIOException2	java.io.IOException
    //   76	233	5	str1	String
    //   82	121	6	str2	String
    //   205	1	6	localIOException3	java.io.IOException
    //   241	1	6	localIOException4	java.io.IOException
    //   254	13	6	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   28	32	34	java/io/IOException
    //   178	182	185	java/io/IOException
    //   190	194	197	java/io/IOException
    //   78	84	205	java/io/IOException
    //   98	108	205	java/io/IOException
    //   114	120	205	java/io/IOException
    //   131	141	205	java/io/IOException
    //   147	155	205	java/io/IOException
    //   165	178	205	java/io/IOException
    //   218	223	226	java/io/IOException
    //   12	24	237	finally
    //   41	48	237	finally
    //   52	72	237	finally
    //   12	24	241	java/io/IOException
    //   41	48	241	java/io/IOException
    //   52	72	241	java/io/IOException
    //   3	12	248	finally
    //   3	12	254	java/io/IOException
    //   275	279	282	java/io/IOException
    //   231	235	297	java/io/IOException
    //   291	295	297	java/io/IOException
    //   78	84	304	finally
    //   98	108	304	finally
    //   114	120	304	finally
    //   131	141	304	finally
    //   147	155	304	finally
    //   165	178	304	finally
    //   266	271	304	finally
    //   317	322	325	java/io/IOException
    //   336	340	343	java/io/IOException
  }
  
  /* Error */
  private static java.security.cert.Certificate a(android.content.pm.Signature paramSignature)
  {
    // Byte code:
    //   0: new 152	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 157	android/content/pm/Signature:toByteArray	()[B
    //   8: invokespecial 160	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_0
    //   12: ldc 162
    //   14: invokestatic 168	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   17: aload_0
    //   18: invokevirtual 172	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   21: checkcast 60	java/security/cert/X509Certificate
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: goto +34 -> 73
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   47: aload_0
    //   48: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   51: goto +20 -> 71
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 174	java/security/cert/CertificateException:printStackTrace	()V
    //   59: aload_0
    //   60: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   63: goto +8 -> 71
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   71: aconst_null
    //   72: areturn
    //   73: aload_0
    //   74: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   77: goto +8 -> 85
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramSignature	android.content.pm.Signature
    //   24	13	1	localX509Certificate	X509Certificate
    //   38	1	1	localObject	Object
    //   42	2	1	localException	Exception
    //   54	32	1	localCertificateException	java.security.cert.CertificateException
    // Exception table:
    //   from	to	target	type
    //   25	29	31	java/io/IOException
    //   12	25	38	finally
    //   43	47	38	finally
    //   55	59	38	finally
    //   12	25	42	java/lang/Exception
    //   12	25	54	java/security/cert/CertificateException
    //   47	51	66	java/io/IOException
    //   59	63	66	java/io/IOException
    //   73	77	80	java/io/IOException
  }
  
  public static List<AppInfo> a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = paramContext.getPackageManager();
    Iterator localIterator = localPackageManager.getInstalledApplications(0).iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
      int j = localApplicationInfo.flags;
      int i = 1;
      if ((j & 0x1) == 0) {
        i = 0;
      }
      if ((i == 0) || (paramBoolean))
      {
        Object localObject = a(paramContext, localApplicationInfo.packageName);
        if (localObject != null)
        {
          ((AppInfo)localObject).setSoftName(az.a(localPackageManager.getApplicationLabel(localApplicationInfo).toString()));
          ((AppInfo)localObject).setAppType(i);
          ((AppInfo)localObject).setFileSize(new File(localApplicationInfo.sourceDir).length());
          ((AppInfo)localObject).setApkPath(localApplicationInfo.sourceDir);
          localArrayList.add(localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("add app ");
          ((StringBuilder)localObject).append(localApplicationInfo.packageName);
          ax.b("CloudScan", ((StringBuilder)localObject).toString());
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 8192);
      if (paramContext != null)
      {
        int i = paramContext.flags;
        if ((i & 0x1) != 0) {
          return true;
        }
      }
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
    if (localObject != null)
    {
      int i = 0;
      localObject = ((List)localObject).iterator();
      int j;
      do
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        } while (localRunningAppProcessInfo == null);
        paramContext.append(localRunningAppProcessInfo.processName);
        paramContext.append(";");
        j = i + 1;
        i = j;
      } while (j <= 100);
      if (paramContext.length() > 0) {
        paramContext.deleteCharAt(paramContext.length() - 1);
      }
    }
    return paramContext.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.as
 * JD-Core Version:    0.7.0.1
 */