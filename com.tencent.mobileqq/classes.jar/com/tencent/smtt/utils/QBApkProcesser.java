package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QBApkProcesser
{
  private static final String Config_Name_QBApkPath = "FileDownloadPath";
  private static final String Config_Verify_Info = "FileDownloadVerifyInfo";
  private static final String DEMOIniPath = "/data/data/com.tencent.tbs/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static final String DOWNLOAD_URL = "downloadurl";
  private static final int MSG_DOWNLOAD_QB = 2;
  private static final int MSG_INSTALL_QB = 1;
  private static final int MSG_OPEN_URL = 0;
  private static final String PAGE_URL = "url";
  private static final int QBAPK_DOWNLOAD = 1;
  private static final int QBAPK_INSTALLED = 2;
  private static final int QBAPK_UNDOWNLOAD = 0;
  private static final String QB_APK_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  private static final String QB_CLASS_NAME = "com.tencent.mtt.MainActivity";
  private static final String QB_PACKAGE_NAME = "com.tencent.mtt";
  private static final String QQIniPath = "/data/data/com.tencent.mobileqq/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static final String QZONEIniPath = "/data/data/com.qzone/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static final String SCHEME_TBSQB_DOWNLOADE = "tbsqbdownload://";
  private static final String TAG = "QBApkUtils";
  private static final String WXIniPath = "/data/data/com.tencent.mm/app_tbs/share/QQBrowserDownloadInfo.ini";
  private static QBApkProcesser mInstance = null;
  private Handler mHandler = null;
  
  private int checkQBApkStatus(Context paramContext)
  {
    if (getInstalledPKGInfo("com.tencent.mtt", paramContext, 128) != null) {
      return 2;
    }
    if (!TextUtils.isEmpty(getQBApkPath(paramContext))) {
      return 1;
    }
    return 0;
  }
  
  private void downloadQB(Context paramContext, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = new Object[] { paramContext, paramString };
    this.mHandler.sendMessage(localMessage);
  }
  
  private void downloadQBInThread(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() > 0))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.addFlags(268435456);
      paramContext.startActivity(paramString);
    }
  }
  
  public static QBApkProcesser getInstance()
  {
    if (mInstance == null) {
      mInstance = new QBApkProcesser();
    }
    return mInstance;
  }
  
  private String getQBApkPath(Context paramContext)
  {
    Object localObject = parseQBApkIni(paramContext);
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      paramContext = (String)((Map)localObject).get("FileDownloadPath");
      localObject = (String)((Map)localObject).get("FileDownloadVerifyInfo");
      if (TextUtils.isEmpty(paramContext)) {
        paramContext = "";
      }
      File localFile;
      do
      {
        return paramContext;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return "";
        }
        localFile = new File(paramContext);
        if (!localFile.exists()) {
          return "";
        }
      } while (TextUtils.equals(Md5Utils.getMD5(localFile.lastModified() + ""), (CharSequence)localObject));
    }
    return "";
  }
  
  private void installQB(Context paramContext)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext };
    this.mHandler.sendMessage(localMessage);
  }
  
  private void installQBInThread(Context paramContext)
  {
    try
    {
      Object localObject = getQBApkPath(paramContext);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType(Uri.fromFile((File)localObject), "application/vnd.android.package-archive");
        paramContext.startActivity(localIntent);
        QBInstallerRecorder.getInstance(paramContext).recordQBInstaller(paramContext.getApplicationInfo().processName);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void openUrlByQB(Context paramContext, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = new Object[] { paramContext, paramString };
    this.mHandler.sendMessage(localMessage);
  }
  
  public static void openUrlByQBInThread(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() > 0)) {
      MttLoader.loadUrl(paramContext, paramString, null, null);
    }
  }
  
  private Map<String, String> parseIni(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      for (;;)
      {
        try
        {
          localHashMap = new HashMap();
        }
        catch (Throwable paramString)
        {
          String[] arrayOfString;
          int j;
          int i;
          Object localObject;
          HashMap localHashMap = null;
          continue;
          i += 1;
          continue;
        }
        try
        {
          arrayOfString = paramString.split("\n");
          j = arrayOfString.length;
          i = 0;
          paramString = localHashMap;
          if (i >= j) {
            break;
          }
          paramString = arrayOfString[i];
          if ((paramString == null) || (paramString.length() <= 0)) {
            continue;
          }
          localObject = paramString.trim().split("=", 2);
          if ((localObject == null) || (localObject.length < 2)) {
            continue;
          }
          paramString = localObject[0];
          localObject = localObject[1];
          if ((paramString == null) || (paramString.length() <= 0)) {
            continue;
          }
          localHashMap.put(paramString, localObject);
        }
        catch (Throwable paramString) {}
      }
    }
    paramString.printStackTrace();
    return localHashMap;
  }
  
  /* Error */
  private Map<String, String> parseQBApkIni(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc 172
    //   8: astore_3
    //   9: aload 6
    //   11: astore_1
    //   12: new 174	java/io/File
    //   15: dup
    //   16: ldc 54
    //   18: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +17 -> 42
    //   28: aload 4
    //   30: astore_2
    //   31: aload 6
    //   33: astore_1
    //   34: aload 4
    //   36: invokevirtual 181	java/io/File:exists	()Z
    //   39: ifne +16 -> 55
    //   42: aload 6
    //   44: astore_1
    //   45: new 174	java/io/File
    //   48: dup
    //   49: ldc 42
    //   51: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +16 -> 72
    //   59: aload_2
    //   60: astore 4
    //   62: aload 6
    //   64: astore_1
    //   65: aload_2
    //   66: invokevirtual 181	java/io/File:exists	()Z
    //   69: ifne +17 -> 86
    //   72: aload 6
    //   74: astore_1
    //   75: new 174	java/io/File
    //   78: dup
    //   79: ldc 45
    //   81: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 4
    //   86: aload 4
    //   88: ifnull +165 -> 253
    //   91: aload 6
    //   93: astore_1
    //   94: aload 4
    //   96: invokevirtual 181	java/io/File:exists	()Z
    //   99: ifeq +154 -> 253
    //   102: aload 6
    //   104: astore_1
    //   105: new 280	java/io/FileInputStream
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 283	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore_2
    //   115: aload_2
    //   116: invokestatic 289	com/tencent/smtt/utils/FileUtil:toByteArray	(Ljava/io/InputStream;)[B
    //   119: astore 5
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: astore 4
    //   126: aload 5
    //   128: ifnull +19 -> 147
    //   131: new 126	java/lang/String
    //   134: dup
    //   135: aload 5
    //   137: ldc_w 291
    //   140: invokespecial 294	java/lang/String:<init>	([BLjava/lang/String;)V
    //   143: astore_1
    //   144: aload_2
    //   145: astore 4
    //   147: aload_1
    //   148: astore 5
    //   150: aload 4
    //   152: ifnull +11 -> 163
    //   155: aload 4
    //   157: invokevirtual 297	java/io/FileInputStream:close	()V
    //   160: aload_1
    //   161: astore 5
    //   163: aload_0
    //   164: aload 5
    //   166: invokespecial 299	com/tencent/smtt/utils/QBApkProcesser:parseIni	(Ljava/lang/String;)Ljava/util/Map;
    //   169: areturn
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   175: aload_1
    //   176: astore 5
    //   178: goto -15 -> 163
    //   181: astore 4
    //   183: aload 5
    //   185: astore_2
    //   186: aload_2
    //   187: astore_1
    //   188: aload 4
    //   190: invokevirtual 243	java/lang/Throwable:printStackTrace	()V
    //   193: aload_3
    //   194: astore 5
    //   196: aload_2
    //   197: ifnull -34 -> 163
    //   200: aload_2
    //   201: invokevirtual 297	java/io/FileInputStream:close	()V
    //   204: aload_3
    //   205: astore 5
    //   207: goto -44 -> 163
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   215: aload_3
    //   216: astore 5
    //   218: goto -55 -> 163
    //   221: astore_3
    //   222: aload_1
    //   223: astore_2
    //   224: aload_3
    //   225: astore_1
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 297	java/io/FileInputStream:close	()V
    //   234: aload_1
    //   235: athrow
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   241: goto -7 -> 234
    //   244: astore_1
    //   245: goto -19 -> 226
    //   248: astore 4
    //   250: goto -64 -> 186
    //   253: aconst_null
    //   254: astore 4
    //   256: aload_3
    //   257: astore_1
    //   258: goto -111 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	QBApkProcesser
    //   0	261	1	paramContext	Context
    //   30	115	2	localObject1	Object
    //   170	2	2	localIOException1	java.io.IOException
    //   185	46	2	localObject2	Object
    //   236	2	2	localIOException2	java.io.IOException
    //   8	208	3	str	String
    //   221	36	3	localObject3	Object
    //   21	135	4	localObject4	Object
    //   181	8	4	localThrowable1	Throwable
    //   248	1	4	localThrowable2	Throwable
    //   254	1	4	localObject5	Object
    //   4	213	5	localObject6	Object
    //   1	102	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   155	160	170	java/io/IOException
    //   12	23	181	java/lang/Throwable
    //   34	42	181	java/lang/Throwable
    //   45	55	181	java/lang/Throwable
    //   65	72	181	java/lang/Throwable
    //   75	86	181	java/lang/Throwable
    //   94	102	181	java/lang/Throwable
    //   105	115	181	java/lang/Throwable
    //   200	204	210	java/io/IOException
    //   12	23	221	finally
    //   34	42	221	finally
    //   45	55	221	finally
    //   65	72	221	finally
    //   75	86	221	finally
    //   94	102	221	finally
    //   105	115	221	finally
    //   188	193	221	finally
    //   230	234	236	java/io/IOException
    //   115	121	244	finally
    //   131	144	244	finally
    //   115	121	248	java/lang/Throwable
    //   131	144	248	java/lang/Throwable
  }
  
  public PackageInfo getInstalledPKGInfo(String paramString, Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, paramInt);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public boolean hiJackUrl(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    boolean bool = true;
    if (paramString != null) {}
    Object localObject1;
    String str;
    label178:
    label205:
    label217:
    do
    {
      for (;;)
      {
        try
        {
          if (!paramString.startsWith("tbsqbdownload://")) {
            break label178;
          }
          String[] arrayOfString1 = paramString.substring("tbsqbdownload://".length()).split(",");
          if (arrayOfString1.length <= 1) {
            break;
          }
          paramString = arrayOfString1[0].split("=");
          if ((paramString.length <= 1) || (!"url".equalsIgnoreCase(paramString[0]))) {
            break label205;
          }
          paramString = arrayOfString1[0].substring("url".length() + 1);
          String[] arrayOfString2 = arrayOfString1[1].split("=");
          localObject1 = localObject2;
          str = paramString;
          if (arrayOfString2.length <= 1) {
            break label217;
          }
          localObject1 = localObject2;
          str = paramString;
          if (!"downloadurl".equalsIgnoreCase(arrayOfString2[0])) {
            break label217;
          }
          localObject1 = arrayOfString1[1].substring("downloadurl".length() + 1);
          str = paramString;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
        int i = checkQBApkStatus(paramContext);
        if (i == 2)
        {
          openUrlByQB(paramContext, str);
          return true;
          return false;
        }
        if (i == 1)
        {
          installQB(paramContext);
          return true;
        }
        if (i != 0) {
          break label230;
        }
        downloadQB(paramContext, (String)localObject1);
        return true;
        paramString = null;
      }
      str = null;
      localObject1 = localObject2;
    } while ((str != null) && (localObject1 != null));
    bool = false;
    label230:
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.QBApkProcesser
 * JD-Core Version:    0.7.0.1
 */