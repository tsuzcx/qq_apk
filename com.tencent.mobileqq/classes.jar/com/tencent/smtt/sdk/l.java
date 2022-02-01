package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.q;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class l
{
  private static int e = 5;
  private static int f = 1;
  private static final String[] g = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private boolean A;
  private Handler B;
  private Set<String> C;
  private int D = e;
  private boolean E;
  String a;
  String[] b = null;
  int c = 0;
  private boolean d = false;
  private Context h;
  private String i;
  private String j;
  private String k;
  private File l;
  private File m;
  private long n;
  private int o = 30000;
  private int p = 20000;
  private boolean q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private HttpURLConnection v;
  private String w;
  private TbsLogReport.TbsLogInfo x;
  private String y;
  private int z;
  
  public l(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    this.x = TbsLogReport.getInstance(this.h).tbsLogInfo();
    this.C = new HashSet();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbs_downloading_");
    ((StringBuilder)localObject).append(this.h.getPackageName());
    this.w = ((StringBuilder)localObject).toString();
    p.a();
    this.l = p.t(this.h);
    if (this.l != null) {}
    try
    {
      localObject = TbsShareManager.getPackageContext(paramContext, "com.tencent.mm", false);
      if (localObject == null) {
        this.m = new File(FileUtil.a(paramContext, "com.tencent.mm", 4, true));
      } else {
        this.m = new File(FileUtil.a((Context)localObject, 4));
      }
    }
    catch (Throwable paramContext)
    {
      label180:
      break label180;
    }
    g();
    this.y = null;
    this.z = -1;
    return;
    throw new NullPointerException("TbsCorePrivateDir is null!");
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.x.setDownConsumeTime(l1 - paramLong1);
    this.x.setDownloadSize(paramLong2);
    return l1;
  }
  
  @TargetApi(8)
  static File a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(FileUtil.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TbsApkDownloader.backupApkPath] Exception is ");
        localStringBuilder.append(paramContext.getMessage());
        TbsLog.e("TbsDownload", localStringBuilder.toString());
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    File localFile = new File(FileUtil.a(paramContext, paramInt));
    if (localFile.exists())
    {
      if (!localFile.isDirectory()) {
        return null;
      }
      if (TbsDownloader.getOverSea(paramContext)) {
        paramContext = "x5.oversea.tbs.org";
      } else {
        paramContext = TbsDownloader.getBackupFileName(false);
      }
      if (new File(localFile, paramContext).exists()) {
        return localFile;
      }
    }
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.r > this.D))
    {
      this.x.setErrorCode(paramInt);
      this.x.setFailDetail(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.r += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = n();
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    if (paramFile != null) {}
    try
    {
      if (paramFile.exists()) {
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          return;
        }
      }
    }
    finally
    {
      File localFile;
      Object localObject1;
      boolean bool1;
      boolean bool2;
      Object localObject2;
      int i2;
      label213:
      Object localObject3;
      label519:
      for (;;)
      {
        label361:
        throw paramFile;
      }
    }
    try
    {
      localFile = a(paramContext);
      if (localFile == null) {
        break label519;
      }
      if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1)
      {
        localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
      }
      else
      {
        if (TbsDownloader.getOverSea(paramContext)) {
          localObject1 = "x5.oversea.tbs.org";
        } else {
          localObject1 = TbsDownloader.getBackupFileName(false);
        }
        localObject1 = new File(localFile, (String)localObject1);
      }
      ((File)localObject1).delete();
      FileUtil.b(paramFile, (File)localObject1);
      bool1 = ((File)localObject1).getName().contains("tbs.org");
      bool2 = ((File)localObject1).getName().contains("x5.tbs.decouple");
      if ((!bool2) && (!bool1)) {
        break label361;
      }
      localObject1 = localFile.listFiles();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a.a(bool2));
      ((StringBuilder)localObject2).append("(.*)");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString());
      i2 = localObject1.length;
      i1 = 0;
    }
    catch (Exception paramFile)
    {
      break label519;
      i1 += 1;
      break label213;
    }
    if (i1 < i2)
    {
      localObject3 = localObject1[i1];
      if ((((Pattern)localObject2).matcher(localObject3.getName()).find()) && (localObject3.isFile()) && (localObject3.exists())) {
        localObject3.delete();
      }
    }
    else
    {
      i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a.a(bool2));
      ((StringBuilder)localObject1).append(".");
      ((StringBuilder)localObject1).append(i1);
      localObject1 = new File(localFile, ((StringBuilder)localObject1).toString());
      if (((File)localObject1).exists())
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
        return;
      }
      ((File)localObject1).createNewFile();
      if ((TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) != 1) && (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0) == a.a(paramContext, paramFile)))
      {
        i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
        if ((i1 == 5) || (i1 == 3))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("response code=");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append("return backup decouple apk");
          TbsLog.i("TbsApkDownloader", ((StringBuilder)localObject1).toString());
        }
        localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
        if (a.a(paramContext, paramFile) != a.a(paramContext, (File)localObject1))
        {
          ((File)localObject1).delete();
          FileUtil.b(paramFile, (File)localObject1);
        }
      }
      return;
      return;
    }
  }
  
  private void a(String paramString)
  {
    paramString = new URL(paramString);
    HttpURLConnection localHttpURLConnection = this.v;
    if (localHttpURLConnection != null) {
      try
      {
        localHttpURLConnection.disconnect();
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initHttpRequest] mHttpRequest.disconnect() Throwable:");
        localStringBuilder.append(localThrowable.toString());
        TbsLog.e("TbsDownload", localStringBuilder.toString());
      }
    }
    this.v = ((HttpURLConnection)paramString.openConnection());
    this.v.setRequestProperty("User-Agent", TbsDownloader.b(this.h));
    this.v.setRequestProperty("Accept-Encoding", "identity");
    this.v.setRequestMethod("GET");
    this.v.setInstanceFollowRedirects(false);
    this.v.setConnectTimeout(this.p);
    this.v.setReadTimeout(this.o);
  }
  
  private boolean a(File paramFile)
  {
    int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
    }
    return a.a(this.h, paramFile, 0L, i1);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, File paramFile)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
    ((StringBuilder)localObject1).append(paramBoolean1);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    if (paramFile != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk]  verifyFile is ");
      ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.l;
    if (!paramBoolean1) {
      localObject1 = "x5.tbs";
    } else {
      localObject1 = "x5.tbs.temp";
    }
    localObject1 = new File((File)localObject2, (String)localObject1);
    if (paramFile != null) {
      localObject1 = paramFile;
    }
    if (!((File)localObject1).exists()) {
      return false;
    }
    Object localObject3 = TbsDownloadConfig.getInstance(this.h).mPreferences;
    localObject2 = null;
    Object localObject4 = ((SharedPreferences)localObject3).getString("tbs_apk_md5", null);
    localObject3 = a.a((File)localObject1);
    if ((localObject4 != null) && (((String)localObject4).equals(localObject3)))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("[TbsApkDownloader.verifyTbsApk] md5(");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(") successful!");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject4).toString());
      long l1 = 0L;
      long l2 = l1;
      if (paramBoolean1)
      {
        long l3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
        l2 = l1;
        if (localObject1 != null)
        {
          l2 = l1;
          if (((File)localObject1).exists())
          {
            l2 = l1;
            if (l3 <= 0L) {
              break label413;
            }
            l1 = ((File)localObject1).length();
            l2 = l1;
            if (l3 == l1) {
              break label413;
            }
            l2 = l1;
          }
        }
        paramFile = new StringBuilder();
        paramFile.append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
        paramFile.append(paramBoolean1);
        paramFile.append(" filelength failed");
        TbsLog.i("TbsDownload", paramFile.toString());
        paramFile = this.x;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fileLength:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(",contentLength:");
        ((StringBuilder)localObject1).append(l3);
        paramFile.setCheckErrorDetail(((StringBuilder)localObject1).toString());
        return false;
      }
      label413:
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[TbsApkDownloader.verifyTbsApk] length(");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(") successful!");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject3).toString());
      int i2 = -1;
      int i1 = i2;
      if (paramBoolean2)
      {
        i1 = i2;
        if (!paramBoolean1)
        {
          i2 = a.a(this.h, (File)localObject1);
          int i3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
          i1 = i2;
          if (i3 != i2)
          {
            paramFile = new StringBuilder();
            paramFile.append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
            paramFile.append(paramBoolean1);
            paramFile.append(" versionCode failed");
            TbsLog.i("TbsDownload", paramFile.toString());
            if (paramBoolean1)
            {
              paramFile = this.x;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("fileVersion:");
              ((StringBuilder)localObject1).append(i2);
              ((StringBuilder)localObject1).append(",configVersion:");
              ((StringBuilder)localObject1).append(i3);
              paramFile.setCheckErrorDetail(((StringBuilder)localObject1).toString());
            }
            return false;
          }
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(") successful!");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject3).toString());
      if ((paramBoolean2) && (!paramBoolean1))
      {
        localObject3 = b.a(this.h, false, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject3))
        {
          paramFile = new StringBuilder();
          paramFile.append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
          paramFile.append(paramBoolean1);
          paramFile.append(" signature failed");
          TbsLog.i("TbsDownload", paramFile.toString());
          if (paramBoolean1)
          {
            localObject1 = this.x;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("signature:");
            if (localObject3 == null) {
              paramFile = "null";
            } else {
              paramFile = Integer.valueOf(((String)localObject3).length());
            }
            ((StringBuilder)localObject2).append(paramFile);
            ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(((StringBuilder)localObject2).toString());
          }
          return false;
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if ((paramBoolean1) && (paramFile == null))
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.l, "x5.tbs"));
          paramFile = (File)localObject2;
        }
        catch (Exception paramFile)
        {
          paramBoolean1 = false;
        }
        paramBoolean2 = paramBoolean1;
        if (!paramBoolean1)
        {
          a(109, a(paramFile), true);
          return false;
        }
      }
      else
      {
        paramBoolean2 = false;
      }
      paramFile = new StringBuilder();
      paramFile.append("[TbsApkDownloader.verifyTbsApk] rename(");
      paramFile.append(paramBoolean2);
      paramFile.append(") successful!");
      TbsLog.i("TbsDownload", paramFile.toString());
      return true;
    }
    paramFile = new StringBuilder();
    paramFile.append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
    paramFile.append(paramBoolean1);
    paramFile.append(" md5 failed");
    TbsLog.i("TbsDownload", paramFile.toString());
    if (paramBoolean1) {
      this.x.setCheckErrorDetail("fileMd5 not match");
    }
    return false;
  }
  
  @TargetApi(8)
  static File b(Context paramContext)
  {
    Object localObject1 = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = a(paramContext, 4);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramContext, 2);
        }
        if (localObject2 == null)
        {
          paramContext = a(paramContext, 1);
          return paramContext;
        }
        localObject1 = localObject2;
      }
      return localObject1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[TbsApkDownloader.backupApkPath] Exception is ");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      TbsLog.e("TbsDownload", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  private boolean b(int paramInt)
  {
    try
    {
      localObject2 = new File(this.l, "x5.tbs");
      File localFile = a(this.h);
      if (localFile != null)
      {
        if (TbsDownloader.getOverSea(this.h)) {
          localObject1 = "x5.oversea.tbs.org";
        } else {
          localObject1 = TbsDownloader.getBackupFileName(false);
        }
        Object localObject1 = new File(localFile, (String)localObject1);
        ((File)localObject2).delete();
        FileUtil.b((File)localObject1, (File)localObject2);
        if (!a.a(this.h, (File)localObject2, 0L, paramInt))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          return false;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
    }
    return false;
  }
  
  public static void c(Context paramContext)
  {
    for (;;)
    {
      int i1;
      try
      {
        p.a();
        Object localObject1 = p.t(paramContext);
        new File((File)localObject1, "x5.tbs").delete();
        new File((File)localObject1, "x5.tbs.temp").delete();
        paramContext = a(paramContext);
        if (paramContext != null)
        {
          int i2 = 0;
          new File(paramContext, TbsDownloader.getBackupFileName(false)).delete();
          new File(paramContext, "x5.oversea.tbs.org").delete();
          paramContext = paramContext.listFiles();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(a.a(true));
          ((StringBuilder)localObject1).append("(.*)");
          localObject1 = Pattern.compile(((StringBuilder)localObject1).toString());
          int i3 = paramContext.length;
          i1 = 0;
          Object localObject2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label283;
            }
            localObject2.delete();
            break label283;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(a.a(false));
          ((StringBuilder)localObject1).append("(.*)");
          localObject1 = Pattern.compile(((StringBuilder)localObject1).toString());
          i3 = paramContext.length;
          i1 = i2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((((Pattern)localObject1).matcher(localObject2.getName()).find()) && (localObject2.isFile()) && (localObject2.exists())) {
              localObject2.delete();
            }
            i1 += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramContext)
      {
        return;
      }
      label283:
      i1 += 1;
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, null);
  }
  
  private void d(boolean paramBoolean)
  {
    q.a(this.h);
    Object localObject1 = TbsDownloadConfig.getInstance(this.h);
    Object localObject2 = ((TbsDownloadConfig)localObject1).mSyncMap;
    Object localObject4 = Boolean.valueOf(false);
    ((Map)localObject2).put("request_full_package", localObject4);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", localObject4);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject1).commit();
    localObject2 = QbSdk.m;
    int i1;
    if (paramBoolean) {
      i1 = 100;
    } else {
      i1 = 120;
    }
    ((TbsListener)localObject2).onDownloadFinish(i1);
    int i2 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_responsecode", 0);
    paramBoolean = TbsDownloader.a(this.h);
    for (;;)
    {
      try
      {
        int i3 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadSuccess #1  cpuTypeForOtherStableCore is ");
        ((StringBuilder)localObject2).append(i3);
        ((StringBuilder)localObject2).append(" isDownloadDecoupleCore is ");
        ((StringBuilder)localObject2).append(paramBoolean);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
        if ((paramBoolean) && (q.b(this.h)))
        {
          localObject2 = this.m.listFiles();
          localObject4 = Pattern.compile(a.a(false, i3));
          int i4 = localObject2.length;
          i1 = 0;
          if (i1 < i4)
          {
            Object localObject5 = localObject2[i1];
            if ((!((Pattern)localObject4).matcher(localObject5.getName()).find()) || (!localObject5.isFile()) || (!localObject5.exists())) {
              break label820;
            }
            localObject5.delete();
            break label820;
          }
          localObject2 = this.m;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(a.a(false, i3));
          ((StringBuilder)localObject4).append(".");
          ((StringBuilder)localObject4).append(((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0));
          localObject2 = new File((File)localObject2, ((StringBuilder)localObject4).toString());
          if (!((File)localObject2).exists()) {
            ((File)localObject2).createNewFile();
          }
          try
          {
            localObject2 = this.m;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(TbsDownloader.getBackupFileName(false));
            ((StringBuilder)localObject4).append(".");
            ((StringBuilder)localObject4).append("tmp");
            boolean bool = new File((File)localObject2, ((StringBuilder)localObject4).toString()).renameTo(new File(this.m, TbsDownloader.getBackupFileName(false, i3)));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("downloadSuccess renameResult is ");
            ((StringBuilder)localObject2).append(bool);
            TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
          }
          catch (Throwable localThrowable1)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("downloadSuccess stack is ");
            ((StringBuilder)localObject4).append(Log.getStackTraceString(localThrowable1));
            TbsLog.i("TbsDownload", ((StringBuilder)localObject4).toString());
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadSuccess getTbsStableCoreVersion is ");
          localStringBuilder.append(TbsShareManager.getTbsStableCoreVersion(this.h, i3));
          TbsLog.i("TbsDownload", localStringBuilder.toString());
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("downloadSuccess stack is ");
        ((StringBuilder)localObject4).append(Log.getStackTraceString(localThrowable2));
        TbsLog.i("TbsDownload", ((StringBuilder)localObject4).toString());
      }
      Object localObject3;
      if (i2 == 5)
      {
        localObject3 = a(i2, paramBoolean);
        localObject1 = localObject3;
        if (localObject3 == null) {
          return;
        }
      }
      for (;;)
      {
        p.a().b(this.h, (Bundle)localObject1);
        return;
        if ((i2 != 3) && (i2 <= 10000))
        {
          i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
          p.a().a(this.h, new File(this.l, "x5.tbs").getAbsolutePath(), i1);
          if (!q.b(this.h))
          {
            a(new File(this.l, "x5.tbs"), this.h);
            return;
          }
          Log.d("TbsDownload", "downloadSuccess not backup ");
          return;
        }
        localObject3 = a(this.h);
        if (localObject3 == null) {
          break;
        }
        localObject1 = a(i2, (File)localObject3, paramBoolean);
      }
      c();
      ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
      ((TbsDownloadConfig)localObject1).commit();
      return;
      label820:
      i1 += 1;
    }
  }
  
  private boolean e(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[TbsApkDownloader.deleteFile] isApk=");
    ((StringBuilder)localObject).append(paramBoolean);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = new File(this.l, "x5.tbs");
    } else {
      localObject = new File(this.l, "x5.tbs.temp");
    }
    if (((File)localObject).exists()) {
      FileUtil.b((File)localObject);
    }
    return true;
  }
  
  private void g()
  {
    this.r = 0;
    this.s = 0;
    this.n = -1L;
    this.k = null;
    this.q = false;
    this.t = false;
    this.u = false;
    this.A = false;
  }
  
  private void h()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    HttpURLConnection localHttpURLConnection = this.v;
    Object localObject2;
    if (localHttpURLConnection != null)
    {
      if (!this.t) {
        this.x.setResolveIp(a(localHttpURLConnection.getURL()));
      }
      try
      {
        this.v.disconnect();
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[closeHttpRequest] mHttpRequest.disconnect() Throwable:");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
      }
      this.v = null;
    }
    int i1 = this.x.a;
    if ((!this.t) && (this.A))
    {
      this.x.setEventTime(System.currentTimeMillis());
      localObject2 = Apn.getApnInfo(this.h);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int i2 = Apn.getApnType(this.h);
      this.x.setApn((String)localObject1);
      this.x.setNetworkType(i2);
      if ((i2 != this.z) || (!((String)localObject1).equals(this.y))) {
        this.x.setNetworkChange(0);
      }
      if (((this.x.a == 0) || (this.x.a == 107)) && (this.x.getDownFinalFlag() == 0))
      {
        if (!Apn.isNetworkAvailable(this.h)) {}
        while (!m())
        {
          a(101, null, true);
          break;
        }
      }
      if (TbsDownloader.a(this.h))
      {
        localObject1 = TbsLogReport.getInstance(this.h);
        localObject2 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
      }
      else
      {
        localObject1 = TbsLogReport.getInstance(this.h);
        localObject2 = TbsLogReport.EventType.TYPE_DOWNLOAD;
      }
      ((TbsLogReport)localObject1).eventReport((TbsLogReport.EventType)localObject2, this.x);
      this.x.resetArgs();
      if (i1 != 100) {
        QbSdk.m.onDownloadFinish(i1);
      }
    }
    else if (!this.d)
    {
      TbsDownloader.a = false;
    }
  }
  
  private File i()
  {
    String str = FileUtil.a(this.h, 4);
    if (TbsDownloader.getOverSea(this.h)) {
      localObject = "x5.oversea.tbs.org";
    } else {
      localObject = TbsDownloader.getBackupFileName(false);
    }
    Object localObject = new File(str, (String)localObject);
    if (TbsDownloader.a(this.h)) {
      localObject = new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
    }
    return localObject;
  }
  
  private void j()
  {
    try
    {
      Object localObject1 = i();
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        FileUtil.b((File)localObject1);
        localObject1 = ((File)localObject1).getParentFile().listFiles();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a.a(TbsDownloader.a(this.h)));
        ((StringBuilder)localObject2).append("(.*)");
        localObject2 = Pattern.compile(((StringBuilder)localObject2).toString());
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          File localFile = localObject1[i1];
          if ((((Pattern)localObject2).matcher(localFile.getName()).find()) && (localFile.isFile()) && (localFile.exists())) {
            FileUtil.b(localFile);
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean k()
  {
    return new File(this.l, "x5.tbs.temp").exists();
  }
  
  private long l()
  {
    File localFile = new File(this.l, "x5.tbs.temp");
    if (localFile.exists()) {
      return localFile.length();
    }
    return 0L;
  }
  
  /* Error */
  private boolean m()
  {
    // Byte code:
    //   0: invokestatic 738	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 6
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: aconst_null
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 8
    //   17: new 113	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   24: astore 7
    //   26: aload 7
    //   28: ldc_w 740
    //   31: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: ldc_w 742
    //   40: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 6
    //   46: aload 7
    //   48: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 746	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   54: invokevirtual 752	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   57: astore 6
    //   59: new 754	java/io/InputStreamReader
    //   62: dup
    //   63: aload 6
    //   65: invokespecial 757	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: astore 7
    //   70: new 759	java/io/BufferedReader
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 762	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore 10
    //   81: iconst_0
    //   82: istore_1
    //   83: aload 10
    //   85: invokevirtual 765	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   88: astore 8
    //   90: iload 4
    //   92: istore_3
    //   93: aload 8
    //   95: ifnull +49 -> 144
    //   98: aload 8
    //   100: ldc_w 767
    //   103: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   106: ifne +36 -> 142
    //   109: aload 8
    //   111: ldc_w 769
    //   114: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   117: istore_3
    //   118: iload_3
    //   119: ifeq +6 -> 125
    //   122: goto +20 -> 142
    //   125: iload_1
    //   126: iconst_1
    //   127: iadd
    //   128: istore_2
    //   129: iload_2
    //   130: istore_1
    //   131: iload_2
    //   132: iconst_5
    //   133: if_icmplt -50 -> 83
    //   136: iload 4
    //   138: istore_3
    //   139: goto +5 -> 144
    //   142: iconst_1
    //   143: istore_3
    //   144: aload_0
    //   145: aload 6
    //   147: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   150: aload 10
    //   152: astore 6
    //   154: goto +128 -> 282
    //   157: astore 8
    //   159: aload 6
    //   161: astore 9
    //   163: aload 8
    //   165: astore 6
    //   167: aload 10
    //   169: astore 8
    //   171: goto +139 -> 310
    //   174: astore 9
    //   176: aload 6
    //   178: astore 8
    //   180: aload 10
    //   182: astore 6
    //   184: goto +84 -> 268
    //   187: astore 10
    //   189: aconst_null
    //   190: astore 8
    //   192: aload 6
    //   194: astore 9
    //   196: aload 10
    //   198: astore 6
    //   200: goto +110 -> 310
    //   203: astore 9
    //   205: aconst_null
    //   206: astore 10
    //   208: aload 6
    //   210: astore 8
    //   212: aload 10
    //   214: astore 6
    //   216: goto +52 -> 268
    //   219: astore 7
    //   221: aconst_null
    //   222: astore 8
    //   224: goto +98 -> 322
    //   227: astore 9
    //   229: aconst_null
    //   230: astore 10
    //   232: aload 10
    //   234: astore 7
    //   236: aload 6
    //   238: astore 8
    //   240: aload 10
    //   242: astore 6
    //   244: goto +24 -> 268
    //   247: astore 7
    //   249: aconst_null
    //   250: astore 6
    //   252: aload 6
    //   254: astore 8
    //   256: goto +66 -> 322
    //   259: astore 9
    //   261: aconst_null
    //   262: astore 7
    //   264: aload 7
    //   266: astore 6
    //   268: aload 9
    //   270: invokevirtual 772	java/lang/Throwable:printStackTrace	()V
    //   273: aload_0
    //   274: aload 8
    //   276: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   279: iload 5
    //   281: istore_3
    //   282: aload_0
    //   283: aload 7
    //   285: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   288: aload_0
    //   289: aload 6
    //   291: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   294: iload_3
    //   295: ireturn
    //   296: astore 10
    //   298: aload 8
    //   300: astore 9
    //   302: aload 6
    //   304: astore 8
    //   306: aload 10
    //   308: astore 6
    //   310: aload 7
    //   312: astore 10
    //   314: aload 6
    //   316: astore 7
    //   318: aload 9
    //   320: astore 6
    //   322: aload_0
    //   323: aload 6
    //   325: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   328: aload_0
    //   329: aload 10
    //   331: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   334: aload_0
    //   335: aload 8
    //   337: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   340: goto +6 -> 346
    //   343: aload 7
    //   345: athrow
    //   346: goto -3 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	l
    //   82	49	1	i1	int
    //   128	6	2	i2	int
    //   92	203	3	bool1	boolean
    //   9	128	4	bool2	boolean
    //   6	274	5	bool3	boolean
    //   3	321	6	localObject1	Object
    //   24	51	7	localObject2	Object
    //   219	1	7	localObject3	Object
    //   234	1	7	localObject4	Object
    //   247	1	7	localObject5	Object
    //   262	82	7	localObject6	Object
    //   15	95	8	str	String
    //   157	7	8	localObject7	Object
    //   169	167	8	localObject8	Object
    //   161	1	9	localObject9	Object
    //   174	1	9	localThrowable1	Throwable
    //   194	1	9	localObject10	Object
    //   203	1	9	localThrowable2	Throwable
    //   227	1	9	localThrowable3	Throwable
    //   259	10	9	localThrowable4	Throwable
    //   300	19	9	localObject11	Object
    //   12	169	10	localBufferedReader	java.io.BufferedReader
    //   187	10	10	localObject12	Object
    //   206	35	10	localObject13	Object
    //   296	11	10	localObject14	Object
    //   312	18	10	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   83	90	157	finally
    //   98	118	157	finally
    //   83	90	174	java/lang/Throwable
    //   98	118	174	java/lang/Throwable
    //   70	81	187	finally
    //   70	81	203	java/lang/Throwable
    //   59	70	219	finally
    //   59	70	227	java/lang/Throwable
    //   17	59	247	finally
    //   17	59	259	java/lang/Throwable
    //   268	273	296	finally
  }
  
  private long n()
  {
    int i1 = this.r;
    if ((i1 != 1) && (i1 != 2))
    {
      if ((i1 != 3) && (i1 != 4)) {
        return 200000L;
      }
      return 100000L;
    }
    return this.r * 20000L;
  }
  
  /* Error */
  private boolean o()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4: invokestatic 689	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   7: istore_1
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore 5
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_1
    //   17: iconst_3
    //   18: if_icmpne +8 -> 26
    //   21: iconst_1
    //   22: istore_2
    //   23: goto +5 -> 28
    //   26: iconst_0
    //   27: istore_2
    //   28: new 113	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: ldc_w 780
    //   42: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 6
    //   48: iload_2
    //   49: invokevirtual 452	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 219
    //   55: aload 6
    //   57: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aconst_null
    //   64: astore 8
    //   66: aconst_null
    //   67: astore 6
    //   69: iload_2
    //   70: ifeq +271 -> 341
    //   73: aload_0
    //   74: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   77: invokestatic 783	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   80: astore 9
    //   82: new 113	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   89: astore 7
    //   91: aload 7
    //   93: ldc_w 785
    //   96: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 7
    //   102: aload 9
    //   104: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 219
    //   110: aload 7
    //   112: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: new 260	java/net/URL
    //   121: dup
    //   122: ldc_w 787
    //   125: invokespecial 396	java/net/URL:<init>	(Ljava/lang/String;)V
    //   128: invokevirtual 410	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   131: checkcast 400	java/net/HttpURLConnection
    //   134: astore 7
    //   136: aload 7
    //   138: iconst_0
    //   139: invokevirtual 431	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   142: aload 7
    //   144: sipush 10000
    //   147: invokevirtual 434	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   150: aload 7
    //   152: sipush 10000
    //   155: invokevirtual 437	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   158: aload 7
    //   160: iconst_0
    //   161: invokevirtual 790	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   164: aload 7
    //   166: invokevirtual 791	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   169: pop
    //   170: aload 7
    //   172: invokevirtual 794	java/net/HttpURLConnection:getResponseCode	()I
    //   175: istore_1
    //   176: new 113	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   183: astore 6
    //   185: aload 6
    //   187: ldc_w 796
    //   190: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: iload_1
    //   197: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 219
    //   203: aload 6
    //   205: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: iload_3
    //   212: istore_2
    //   213: iload_1
    //   214: sipush 204
    //   217: if_icmpne +5 -> 222
    //   220: iconst_1
    //   221: istore_2
    //   222: aload 9
    //   224: astore 6
    //   226: iload_2
    //   227: istore_3
    //   228: aload 7
    //   230: ifnull +117 -> 347
    //   233: iload_2
    //   234: istore_3
    //   235: aload 7
    //   237: invokevirtual 403	java/net/HttpURLConnection:disconnect	()V
    //   240: aload 9
    //   242: astore 6
    //   244: iload_2
    //   245: istore_3
    //   246: goto +101 -> 347
    //   249: aload 9
    //   251: astore 6
    //   253: goto +94 -> 347
    //   256: astore 6
    //   258: goto +70 -> 328
    //   261: astore 8
    //   263: goto +26 -> 289
    //   266: astore 8
    //   268: aload 6
    //   270: astore 7
    //   272: aload 8
    //   274: astore 6
    //   276: goto +52 -> 328
    //   279: astore 6
    //   281: aload 8
    //   283: astore 7
    //   285: aload 6
    //   287: astore 8
    //   289: aload 7
    //   291: astore 6
    //   293: aload 8
    //   295: invokevirtual 772	java/lang/Throwable:printStackTrace	()V
    //   298: aload 9
    //   300: astore 6
    //   302: iload 4
    //   304: istore_3
    //   305: aload 7
    //   307: ifnull +40 -> 347
    //   310: iload 5
    //   312: istore_3
    //   313: aload 7
    //   315: invokevirtual 403	java/net/HttpURLConnection:disconnect	()V
    //   318: aload 9
    //   320: astore 6
    //   322: iload 4
    //   324: istore_3
    //   325: goto +22 -> 347
    //   328: aload 7
    //   330: ifnull +8 -> 338
    //   333: aload 7
    //   335: invokevirtual 403	java/net/HttpURLConnection:disconnect	()V
    //   338: aload 6
    //   340: athrow
    //   341: aconst_null
    //   342: astore 6
    //   344: iload 4
    //   346: istore_3
    //   347: iload_3
    //   348: ifne +68 -> 416
    //   351: aload 6
    //   353: invokestatic 801	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +60 -> 416
    //   359: aload_0
    //   360: getfield 111	com/tencent/smtt/sdk/l:C	Ljava/util/Set;
    //   363: aload 6
    //   365: invokeinterface 805 2 0
    //   370: ifne +46 -> 416
    //   373: aload_0
    //   374: getfield 111	com/tencent/smtt/sdk/l:C	Ljava/util/Set;
    //   377: aload 6
    //   379: invokeinterface 808 2 0
    //   384: pop
    //   385: aload_0
    //   386: invokespecial 810	com/tencent/smtt/sdk/l:p	()V
    //   389: aload_0
    //   390: getfield 812	com/tencent/smtt/sdk/l:B	Landroid/os/Handler;
    //   393: sipush 150
    //   396: aload 6
    //   398: invokevirtual 818	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   401: astore 7
    //   403: aload_0
    //   404: getfield 812	com/tencent/smtt/sdk/l:B	Landroid/os/Handler;
    //   407: aload 7
    //   409: ldc2_w 819
    //   412: invokevirtual 824	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   415: pop
    //   416: iload_3
    //   417: ifeq +29 -> 446
    //   420: aload_0
    //   421: getfield 111	com/tencent/smtt/sdk/l:C	Ljava/util/Set;
    //   424: aload 6
    //   426: invokeinterface 805 2 0
    //   431: ifeq +15 -> 446
    //   434: aload_0
    //   435: getfield 111	com/tencent/smtt/sdk/l:C	Ljava/util/Set;
    //   438: aload 6
    //   440: invokeinterface 827 2 0
    //   445: pop
    //   446: iload_3
    //   447: ireturn
    //   448: astore 6
    //   450: goto -201 -> 249
    //   453: astore 7
    //   455: goto -117 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	l
    //   7	211	1	i1	int
    //   22	223	2	bool1	boolean
    //   15	432	3	bool2	boolean
    //   9	336	4	bool3	boolean
    //   12	299	5	bool4	boolean
    //   35	217	6	localObject1	Object
    //   256	13	6	localObject2	Object
    //   274	1	6	localObject3	Object
    //   279	7	6	localThrowable1	Throwable
    //   291	148	6	localObject4	Object
    //   448	1	6	localException1	Exception
    //   89	319	7	localObject5	Object
    //   453	1	7	localException2	Exception
    //   64	1	8	localObject6	Object
    //   261	1	8	localThrowable2	Throwable
    //   266	16	8	localObject7	Object
    //   287	7	8	localThrowable3	Throwable
    //   80	239	9	str	String
    // Exception table:
    //   from	to	target	type
    //   136	211	256	finally
    //   136	211	261	java/lang/Throwable
    //   118	136	266	finally
    //   293	298	266	finally
    //   118	136	279	java/lang/Throwable
    //   235	240	448	java/lang/Exception
    //   313	318	448	java/lang/Exception
    //   333	338	453	java/lang/Exception
  }
  
  private void p()
  {
    if (this.B == null) {
      this.B = new l.1(this, n.a().getLooper());
    }
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFile = new File(paramFile, TbsDownloader.getBackupFileName(true));
    }
    else
    {
      if (TbsDownloader.getOverSea(this.h)) {
        localObject = "x5.oversea.tbs.org";
      } else {
        localObject = TbsDownloader.getBackupFileName(false);
      }
      paramFile = new File(paramFile, (String)localObject);
    }
    int i1 = a.a(this.h, paramFile);
    Object localObject = new File(this.l, "x5.tbs");
    if (((File)localObject).exists()) {
      localObject = ((File)localObject).getAbsolutePath();
    } else {
      localObject = null;
    }
    int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
    Bundle localBundle = new Bundle();
    localBundle.putInt("operation", paramInt);
    localBundle.putInt("old_core_ver", i1);
    localBundle.putInt("new_core_ver", i2);
    localBundle.putString("old_apk_location", paramFile.getAbsolutePath());
    localBundle.putString("new_apk_location", (String)localObject);
    localBundle.putString("diff_file_location", (String)localObject);
    return localBundle;
  }
  
  public Bundle a(int paramInt, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      localObject1 = p.a().q(this.h);
      i1 = p.a().i(this.h);
    }
    else
    {
      localObject1 = p.a().r(this.h);
      i1 = p.a().j(this.h);
    }
    Object localObject2 = new File(this.l, "x5.tbs");
    if (((File)localObject2).exists()) {
      localObject2 = ((File)localObject2).getAbsolutePath();
    } else {
      localObject2 = null;
    }
    if (localObject2 == null) {
      return null;
    }
    int i3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
    int i2;
    if (paramBoolean)
    {
      localObject4 = p.a();
      localObject3 = this.h;
      i2 = 6;
    }
    else
    {
      localObject4 = p.a();
      localObject3 = this.h;
      i2 = 5;
    }
    Object localObject4 = ((p)localObject4).f((Context)localObject3, i2);
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("operation", paramInt);
    ((Bundle)localObject3).putInt("old_core_ver", i1);
    ((Bundle)localObject3).putInt("new_core_ver", i3);
    ((Bundle)localObject3).putString("old_apk_location", ((File)localObject1).getAbsolutePath());
    ((Bundle)localObject3).putString("new_apk_location", ((File)localObject4).getAbsolutePath());
    ((Bundle)localObject3).putString("diff_file_location", (String)localObject2);
    Object localObject1 = FileUtil.a(this.h, 7);
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i3);
    ((StringBuilder)localObject2).append(".tbs");
    ((Bundle)localObject3).putString("backup_apk", new File((String)localObject1, ((StringBuilder)localObject2).toString()).getAbsolutePath());
    return localObject3;
  }
  
  public void a(int paramInt)
  {
    if (p.a().u(this.h)) {
      p.a().b();
    }
    try
    {
      File localFile = new File(this.l, "x5.tbs");
      int i1 = a.a(this.h, localFile);
      if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
        FileUtil.b(localFile);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean, false);
  }
  
  public boolean a()
  {
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    for (;;)
    {
      int i2;
      try
      {
        File localFile;
        if (q.b(this.h)) {
          localFile = new File(FileUtil.a(this.h, "com.tencent.mm", 4, true), TbsDownloader.getBackupFileName(false));
        } else {
          localFile = new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("verifyAndInstallDecoupleCoreFromBackup backupFile is ");
        ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
        TbsLog.i("TbsApkDownloader", ((StringBuilder)localObject1).toString());
        boolean bool = localFile.exists();
        if (bool)
        {
          localObject1 = "verifyAndInstallDecoupleCoreFromBackup #2";
          TbsLog.i("TbsApkDownloader", (String)localObject1);
        }
        else
        {
          localObject1 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
          Object localObject3;
          if (localObject1 != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("verifyAndInstallDecoupleCoreFromBackup getExistBackupCoreForDecouple is ");
            ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
            TbsLog.i("TbsApkDownloader", ((StringBuilder)localObject3).toString());
          }
          if ((localObject1 != null) && (((File)localObject1).exists())) {
            FileUtil.b((File)localObject1, localFile);
          }
          try
          {
            localObject1 = ((File)localObject1).getName();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("verifyAndInstallDecoupleCoreFromBackup fileNameSource is ");
            ((StringBuilder)localObject3).append((String)localObject1);
            TbsLog.i("TbsApkDownloader", ((StringBuilder)localObject3).toString());
            int i1 = 32;
            if (((String)localObject1).contains("64")) {
              i1 = 64;
            }
            if (q.b(this.h))
            {
              localObject1 = this.m.listFiles();
              localObject3 = Pattern.compile(a.a(false, i1));
              int i3 = localObject1.length;
              i2 = 0;
              if (i2 < i3)
              {
                Object localObject4 = localObject1[i2];
                if ((!((Pattern)localObject3).matcher(localObject4.getName()).find()) || (!localObject4.isFile()) || (!localObject4.exists())) {
                  break label760;
                }
                localObject4.delete();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("verifyAndInstallDecoupleCoreFromBackup delete file ");
                localStringBuilder.append(localObject4.getAbsolutePath());
                TbsLog.i("TbsApkDownloader", localStringBuilder.toString());
                break label760;
              }
              localObject1 = this.m;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(a.a(false, i1));
              ((StringBuilder)localObject3).append(".");
              ((StringBuilder)localObject3).append(TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
              localObject1 = new File((File)localObject1, ((StringBuilder)localObject3).toString());
              if (((File)localObject1).exists())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("verifyAndInstallDecoupleCoreFromBackup  file already exist ");
                ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
                localObject1 = ((StringBuilder)localObject3).toString();
                TbsLog.i("TbsApkDownloader", (String)localObject1);
              }
              else
              {
                ((File)localObject1).createNewFile();
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("verifyAndInstallDecoupleCoreFromBackup create file ");
                ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
                localObject1 = ((StringBuilder)localObject3).toString();
                continue;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("stack is ");
            ((StringBuilder)localObject3).append(Log.getStackTraceString(localThrowable));
            localObject2 = ((StringBuilder)localObject3).toString();
          }
        }
        if (a.a(this.h, localFile, 0L, TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1)))
        {
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
          if (q.b(this.h))
          {
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup isStableCoreForHostEnable and return true");
            return true;
          }
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup goto installDecoupleCoreFromBackup");
          bool = p.a().f(this.h);
          return bool;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("stack is ");
        ((StringBuilder)localObject2).append(Log.getStackTraceString(localException));
        TbsLog.i("TbsApkDownloader", ((StringBuilder)localObject2).toString());
      }
      return false;
      label760:
      i2 += 1;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT == 23) {
      return false;
    }
    int i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
    int i2 = p.a().j(this.h);
    Object localObject1;
    if (i1 == 0)
    {
      i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      localObject1 = "by default key";
    }
    else
    {
      localObject1 = "by new key";
    }
    this.a = ((String)localObject1);
    if (i1 != 0)
    {
      if (i1 == i2) {
        return false;
      }
      if (paramBoolean2)
      {
        Object localObject3 = TbsDownloader.a(i1);
        if ((localObject3 != null) && (((File)localObject3).exists()))
        {
          String str = FileUtil.a(this.h, 4);
          if (TbsDownloader.getOverSea(this.h)) {
            localObject1 = "x5.oversea.tbs.org";
          } else {
            localObject1 = TbsDownloader.getBackupFileName(false);
          }
          localObject1 = new File(str, (String)localObject1);
          try
          {
            if (TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version_type", 0) != 1)
            {
              FileUtil.b((File)localObject3, (File)localObject1);
              i2 = 1;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        else
        {
          i2 = 0;
        }
        Object localObject2 = i();
        if ((localObject2 != null) && (((File)localObject2).exists()) && (a((File)localObject2)))
        {
          if (b(i1))
          {
            TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
            TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
            d(false);
            if (i2 != 0)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("use local backup apk in startDownload");
              ((StringBuilder)localObject2).append(this.a);
              a(100, ((StringBuilder)localObject2).toString(), true);
              if (TbsDownloader.a(this.h))
              {
                localObject2 = TbsLogReport.getInstance(this.h);
                localObject3 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
              }
              else
              {
                localObject2 = TbsLogReport.getInstance(this.h);
                localObject3 = TbsLogReport.EventType.TYPE_DOWNLOAD;
              }
              ((TbsLogReport)localObject2).eventReport((TbsLogReport.EventType)localObject3, this.x);
              this.x.resetArgs();
            }
            return true;
          }
        }
        else
        {
          if (!q.b(this.h)) {
            j();
          }
          if ((localObject3 != null) && (((File)localObject3).exists()) && (!a.a(this.h, (File)localObject3, 0L, i1)) && (localObject3 != null) && (((File)localObject3).exists())) {
            FileUtil.b((File)localObject3);
          }
        }
      }
      if (c(false, paramBoolean2))
      {
        TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
        TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
        d(false);
        return true;
      }
      if ((!e(true)) && (!e(true)))
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
        TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-301);
      }
    }
    return false;
  }
  
  public void b()
  {
    this.t = true;
    if (TbsShareManager.isThirdPartyApp(this.h))
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo = TbsLogReport.getInstance(this.h).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      TbsLogReport localTbsLogReport;
      TbsLogReport.EventType localEventType;
      if (TbsDownloader.a(this.h))
      {
        localTbsLogReport = TbsLogReport.getInstance(this.h);
        localEventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
      }
      else
      {
        localTbsLogReport = TbsLogReport.getInstance(this.h);
        localEventType = TbsLogReport.EventType.TYPE_DOWNLOAD;
      }
      localTbsLogReport.eventReport(localEventType, localTbsLogInfo);
    }
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 134	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   3: aload_0
    //   4: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   7: invokevirtual 948	com/tencent/smtt/sdk/p:d	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 724	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   25: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush -322
    //   31: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   39: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 387
    //   48: iconst_0
    //   49: invokeinterface 325 3 0
    //   54: istore 7
    //   56: iload 7
    //   58: iconst_1
    //   59: if_icmpeq +24 -> 83
    //   62: iload 7
    //   64: iconst_2
    //   65: if_icmpeq +18 -> 83
    //   68: iload 7
    //   70: iconst_4
    //   71: if_icmpne +6 -> 77
    //   74: goto +9 -> 83
    //   77: iconst_0
    //   78: istore 12
    //   80: goto +6 -> 86
    //   83: iconst_1
    //   84: istore 12
    //   86: iload_2
    //   87: ifne +18 -> 105
    //   90: aload_0
    //   91: iload_1
    //   92: iload 12
    //   94: invokevirtual 950	com/tencent/smtt/sdk/l:a	(ZZ)Z
    //   97: ifeq +8 -> 105
    //   100: iconst_0
    //   101: putstatic 724	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   104: return
    //   105: aload_0
    //   106: iload_1
    //   107: putfield 952	com/tencent/smtt/sdk/l:E	Z
    //   110: aload_0
    //   111: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   114: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   117: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   120: astore 33
    //   122: aconst_null
    //   123: astore 34
    //   125: aload_0
    //   126: aload 33
    //   128: ldc_w 954
    //   131: aconst_null
    //   132: invokeinterface 467 3 0
    //   137: putfield 956	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   140: aload_0
    //   141: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   144: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   147: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   150: ldc_w 958
    //   153: aconst_null
    //   154: invokeinterface 467 3 0
    //   159: astore 35
    //   161: new 113	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   168: astore 33
    //   170: aload 33
    //   172: ldc_w 960
    //   175: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 33
    //   181: aload 35
    //   183: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 33
    //   189: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore 36
    //   194: ldc 219
    //   196: astore 33
    //   198: ldc 219
    //   200: aload 36
    //   202: iconst_1
    //   203: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 84	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   211: aload_0
    //   212: iconst_0
    //   213: putfield 86	com/tencent/smtt/sdk/l:c	I
    //   216: iload_1
    //   217: ifne +37 -> 254
    //   220: aload 35
    //   222: ifnull +32 -> 254
    //   225: ldc_w 275
    //   228: aload 35
    //   230: invokevirtual 966	java/lang/String:trim	()Ljava/lang/String;
    //   233: invokevirtual 474	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   236: ifne +18 -> 254
    //   239: aload_0
    //   240: aload 35
    //   242: invokevirtual 966	java/lang/String:trim	()Ljava/lang/String;
    //   245: ldc_w 968
    //   248: invokevirtual 972	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   251: putfield 84	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   254: new 113	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   261: astore 36
    //   263: aload 36
    //   265: ldc_w 974
    //   268: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 36
    //   274: aload_0
    //   275: getfield 956	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   278: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 36
    //   284: ldc_w 976
    //   287: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 36
    //   293: aload 35
    //   295: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 36
    //   301: ldc_w 978
    //   304: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 36
    //   310: aload_0
    //   311: getfield 654	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   314: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 36
    //   320: ldc_w 980
    //   323: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 36
    //   329: aload_0
    //   330: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   333: invokevirtual 452	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 36
    //   339: ldc_w 982
    //   342: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 36
    //   348: aload_0
    //   349: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   352: invokevirtual 530	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: ldc 219
    //   358: aload 36
    //   360: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: getfield 956	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   370: ifnonnull +34 -> 404
    //   373: aload_0
    //   374: getfield 654	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   377: ifnonnull +27 -> 404
    //   380: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   383: bipush 110
    //   385: invokeinterface 593 2 0
    //   390: aload_0
    //   391: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   394: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   397: sipush -302
    //   400: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   403: return
    //   404: aload_0
    //   405: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   408: ifnull +34 -> 442
    //   411: aload_0
    //   412: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   415: ifne +27 -> 442
    //   418: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   421: bipush 110
    //   423: invokeinterface 593 2 0
    //   428: aload_0
    //   429: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   432: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   435: sipush -303
    //   438: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   441: return
    //   442: iload_1
    //   443: ifne +54 -> 497
    //   446: aload_0
    //   447: getfield 111	com/tencent/smtt/sdk/l:C	Ljava/util/Set;
    //   450: aload_0
    //   451: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   454: invokestatic 783	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   457: invokeinterface 805 2 0
    //   462: ifeq +35 -> 497
    //   465: ldc 219
    //   467: ldc_w 984
    //   470: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   476: bipush 110
    //   478: invokeinterface 593 2 0
    //   483: aload_0
    //   484: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   487: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   490: sipush -304
    //   493: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   496: return
    //   497: aload_0
    //   498: invokespecial 164	com/tencent/smtt/sdk/l:g	()V
    //   501: ldc 219
    //   503: ldc_w 986
    //   506: iconst_1
    //   507: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   510: aload_0
    //   511: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   514: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   517: invokevirtual 989	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   520: lstore 17
    //   522: aload_0
    //   523: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   526: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   529: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   532: astore 35
    //   534: lconst_0
    //   535: lstore 19
    //   537: aload 35
    //   539: ldc_w 991
    //   542: lconst_0
    //   543: invokeinterface 484 4 0
    //   548: lstore 13
    //   550: iload_1
    //   551: ifeq +11 -> 562
    //   554: getstatic 993	com/tencent/smtt/sdk/l:f	I
    //   557: istore 7
    //   559: goto +8 -> 567
    //   562: getstatic 80	com/tencent/smtt/sdk/l:e	I
    //   565: istore 7
    //   567: aload_0
    //   568: iload 7
    //   570: putfield 82	com/tencent/smtt/sdk/l:D	I
    //   573: iconst_0
    //   574: istore 9
    //   576: aload_0
    //   577: getfield 278	com/tencent/smtt/sdk/l:r	I
    //   580: aload_0
    //   581: getfield 82	com/tencent/smtt/sdk/l:D	I
    //   584: if_icmple +6 -> 590
    //   587: goto +2581 -> 3168
    //   590: aload_0
    //   591: getfield 648	com/tencent/smtt/sdk/l:s	I
    //   594: bipush 8
    //   596: if_icmple +28 -> 624
    //   599: aload_0
    //   600: bipush 123
    //   602: aload 34
    //   604: iconst_1
    //   605: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   608: aload_0
    //   609: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   612: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   615: sipush -306
    //   618: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   621: goto +2547 -> 3168
    //   624: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   627: lstore 31
    //   629: lload 13
    //   631: lstore 15
    //   633: iload_1
    //   634: ifne +413 -> 1047
    //   637: lload 13
    //   639: lstore 21
    //   641: lload 13
    //   643: lstore 23
    //   645: lload 31
    //   647: aload_0
    //   648: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   651: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   654: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   657: ldc_w 995
    //   660: lload 19
    //   662: invokeinterface 484 4 0
    //   667: lsub
    //   668: ldc2_w 996
    //   671: lcmp
    //   672: ifle +104 -> 776
    //   675: lload 13
    //   677: lstore 21
    //   679: lload 13
    //   681: lstore 23
    //   683: aload 33
    //   685: ldc_w 999
    //   688: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: lload 13
    //   693: lstore 21
    //   695: lload 13
    //   697: lstore 23
    //   699: aload_0
    //   700: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   703: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   706: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   709: ldc_w 995
    //   712: lload 31
    //   714: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   717: invokeinterface 576 3 0
    //   722: pop
    //   723: lload 13
    //   725: lstore 21
    //   727: lload 13
    //   729: lstore 23
    //   731: aload_0
    //   732: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   735: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   738: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   741: ldc_w 991
    //   744: lload 19
    //   746: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   749: invokeinterface 576 3 0
    //   754: pop
    //   755: lload 13
    //   757: lstore 21
    //   759: lload 13
    //   761: lstore 23
    //   763: aload_0
    //   764: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   767: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   770: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   773: goto +178 -> 951
    //   776: lload 13
    //   778: lstore 21
    //   780: lload 13
    //   782: lstore 23
    //   784: new 113	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   791: astore 34
    //   793: lload 13
    //   795: lstore 21
    //   797: lload 13
    //   799: lstore 23
    //   801: aload 34
    //   803: ldc_w 1006
    //   806: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: lload 13
    //   812: lstore 21
    //   814: lload 13
    //   816: lstore 23
    //   818: aload 34
    //   820: lload 13
    //   822: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: lload 13
    //   828: lstore 21
    //   830: lload 13
    //   832: lstore 23
    //   834: aload 33
    //   836: aload 34
    //   838: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   844: lload 13
    //   846: lstore 19
    //   848: lload 13
    //   850: lload 17
    //   852: lcmp
    //   853: iflt +98 -> 951
    //   856: lload 13
    //   858: lstore 21
    //   860: lload 13
    //   862: lstore 23
    //   864: aload 33
    //   866: ldc_w 1008
    //   869: iconst_1
    //   870: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   873: lload 13
    //   875: lstore 21
    //   877: lload 13
    //   879: lstore 23
    //   881: aload_0
    //   882: bipush 112
    //   884: aconst_null
    //   885: iconst_1
    //   886: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   889: lload 13
    //   891: lstore 21
    //   893: lload 13
    //   895: lstore 23
    //   897: aload_0
    //   898: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   901: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   904: sipush -307
    //   907: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   910: iload_1
    //   911: ifne +2257 -> 3168
    //   914: aload_0
    //   915: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   918: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   921: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   924: ldc_w 991
    //   927: lload 13
    //   929: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   932: invokeinterface 576 3 0
    //   937: pop
    //   938: aload_0
    //   939: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   942: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   945: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   948: goto +2220 -> 3168
    //   951: lload 19
    //   953: lstore 21
    //   955: lload 19
    //   957: lstore 15
    //   959: lload 19
    //   961: lstore 23
    //   963: aload_0
    //   964: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   967: invokestatic 1009	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   970: ifne +77 -> 1047
    //   973: lload 19
    //   975: lstore 21
    //   977: lload 19
    //   979: lstore 23
    //   981: aload 33
    //   983: ldc_w 1011
    //   986: iconst_1
    //   987: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   990: lload 19
    //   992: lstore 21
    //   994: lload 19
    //   996: lstore 23
    //   998: aload_0
    //   999: bipush 105
    //   1001: aconst_null
    //   1002: iconst_1
    //   1003: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   1006: lload 19
    //   1008: lstore 21
    //   1010: lload 19
    //   1012: lstore 23
    //   1014: aload_0
    //   1015: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1018: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1021: sipush -308
    //   1024: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1027: iload_1
    //   1028: ifne +2140 -> 3168
    //   1031: lload 19
    //   1033: lstore 13
    //   1035: goto -121 -> 914
    //   1038: astore 33
    //   1040: lload 21
    //   1042: lstore 15
    //   1044: goto +4624 -> 5668
    //   1047: lload 15
    //   1049: lstore 23
    //   1051: aload_0
    //   1052: iconst_1
    //   1053: putfield 662	com/tencent/smtt/sdk/l:A	Z
    //   1056: lload 15
    //   1058: lstore 23
    //   1060: aload_0
    //   1061: getfield 654	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   1064: astore 34
    //   1066: aload 34
    //   1068: ifnull +20 -> 1088
    //   1071: lload 15
    //   1073: lstore 21
    //   1075: lload 15
    //   1077: lstore 23
    //   1079: aload_0
    //   1080: getfield 654	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   1083: astore 34
    //   1085: goto +13 -> 1098
    //   1088: lload 15
    //   1090: lstore 23
    //   1092: aload_0
    //   1093: getfield 956	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   1096: astore 34
    //   1098: lload 15
    //   1100: lstore 23
    //   1102: new 113	java/lang/StringBuilder
    //   1105: dup
    //   1106: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1109: astore 35
    //   1111: lload 15
    //   1113: lstore 23
    //   1115: aload 35
    //   1117: ldc_w 1013
    //   1120: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: pop
    //   1124: lload 15
    //   1126: lstore 23
    //   1128: aload 35
    //   1130: aload 34
    //   1132: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: lload 15
    //   1138: lstore 23
    //   1140: aload 35
    //   1142: ldc_w 1015
    //   1145: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: pop
    //   1149: lload 15
    //   1151: lstore 23
    //   1153: aload 35
    //   1155: aload_0
    //   1156: getfield 278	com/tencent/smtt/sdk/l:r	I
    //   1159: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: pop
    //   1163: lload 15
    //   1165: lstore 23
    //   1167: aload 33
    //   1169: aload 35
    //   1171: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1174: iconst_1
    //   1175: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1178: lload 15
    //   1180: lstore 23
    //   1182: aload 34
    //   1184: aload_0
    //   1185: getfield 1017	com/tencent/smtt/sdk/l:j	Ljava/lang/String;
    //   1188: invokevirtual 474	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1191: istore 10
    //   1193: iload 10
    //   1195: ifne +20 -> 1215
    //   1198: lload 15
    //   1200: lstore 21
    //   1202: lload 15
    //   1204: lstore 23
    //   1206: aload_0
    //   1207: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1210: aload 34
    //   1212: invokevirtual 1020	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1215: lload 15
    //   1217: lstore 23
    //   1219: aload_0
    //   1220: aload 34
    //   1222: putfield 1017	com/tencent/smtt/sdk/l:j	Ljava/lang/String;
    //   1225: lload 15
    //   1227: lstore 23
    //   1229: aload_0
    //   1230: aload 34
    //   1232: invokespecial 1022	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;)V
    //   1235: lload 15
    //   1237: lstore 23
    //   1239: aload_0
    //   1240: getfield 656	com/tencent/smtt/sdk/l:q	Z
    //   1243: istore 10
    //   1245: ldc_w 1024
    //   1248: astore 39
    //   1250: iload 10
    //   1252: ifne +515 -> 1767
    //   1255: lload 15
    //   1257: lstore 21
    //   1259: lload 15
    //   1261: lstore 23
    //   1263: aload_0
    //   1264: invokespecial 1026	com/tencent/smtt/sdk/l:l	()J
    //   1267: lstore 19
    //   1269: lload 15
    //   1271: lstore 21
    //   1273: lload 15
    //   1275: lstore 23
    //   1277: new 113	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1284: astore 34
    //   1286: lload 15
    //   1288: lstore 21
    //   1290: lload 15
    //   1292: lstore 23
    //   1294: aload 34
    //   1296: ldc_w 1028
    //   1299: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: lload 15
    //   1305: lstore 21
    //   1307: lload 15
    //   1309: lstore 23
    //   1311: aload 34
    //   1313: lload 19
    //   1315: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: lload 15
    //   1321: lstore 21
    //   1323: lload 15
    //   1325: lstore 23
    //   1327: aload 33
    //   1329: aload 34
    //   1331: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1337: lload 15
    //   1339: lstore 21
    //   1341: lload 15
    //   1343: lstore 23
    //   1345: aload_0
    //   1346: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   1349: lconst_0
    //   1350: lcmp
    //   1351: ifgt +161 -> 1512
    //   1354: lload 15
    //   1356: lstore 21
    //   1358: lload 15
    //   1360: lstore 23
    //   1362: new 113	java/lang/StringBuilder
    //   1365: dup
    //   1366: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1369: astore 34
    //   1371: lload 15
    //   1373: lstore 21
    //   1375: lload 15
    //   1377: lstore 23
    //   1379: aload 34
    //   1381: ldc_w 1030
    //   1384: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: lload 15
    //   1390: lstore 21
    //   1392: lload 15
    //   1394: lstore 23
    //   1396: aload 34
    //   1398: lload 19
    //   1400: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: lload 15
    //   1406: lstore 21
    //   1408: lload 15
    //   1410: lstore 23
    //   1412: aload 33
    //   1414: aload 34
    //   1416: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: iconst_1
    //   1420: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1423: lload 15
    //   1425: lstore 21
    //   1427: lload 15
    //   1429: lstore 23
    //   1431: aload_0
    //   1432: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   1435: astore 34
    //   1437: lload 15
    //   1439: lstore 21
    //   1441: lload 15
    //   1443: lstore 23
    //   1445: new 113	java/lang/StringBuilder
    //   1448: dup
    //   1449: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1452: astore 35
    //   1454: lload 15
    //   1456: lstore 21
    //   1458: aload 35
    //   1460: ldc_w 1032
    //   1463: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: lload 15
    //   1469: lstore 21
    //   1471: aload 35
    //   1473: lload 19
    //   1475: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1478: pop
    //   1479: lload 15
    //   1481: lstore 21
    //   1483: aload 35
    //   1485: ldc_w 1034
    //   1488: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: pop
    //   1492: lload 15
    //   1494: lstore 21
    //   1496: aload 34
    //   1498: ldc_w 1036
    //   1501: aload 35
    //   1503: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: invokevirtual 418	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: goto +261 -> 1770
    //   1512: lload 15
    //   1514: lstore 21
    //   1516: new 113	java/lang/StringBuilder
    //   1519: dup
    //   1520: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1523: astore 34
    //   1525: lload 15
    //   1527: lstore 21
    //   1529: aload 34
    //   1531: ldc_w 1038
    //   1534: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: pop
    //   1538: lload 15
    //   1540: lstore 21
    //   1542: aload 34
    //   1544: lload 19
    //   1546: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1549: pop
    //   1550: lload 15
    //   1552: lstore 21
    //   1554: aload 34
    //   1556: ldc_w 1024
    //   1559: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: lload 15
    //   1565: lstore 21
    //   1567: aload 34
    //   1569: aload_0
    //   1570: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   1573: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1576: pop
    //   1577: lload 15
    //   1579: lstore 21
    //   1581: aload 33
    //   1583: aload 34
    //   1585: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: iconst_1
    //   1589: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1592: lload 15
    //   1594: lstore 21
    //   1596: new 113	java/lang/StringBuilder
    //   1599: dup
    //   1600: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1603: astore 34
    //   1605: lload 15
    //   1607: lstore 21
    //   1609: aload 34
    //   1611: ldc_w 1038
    //   1614: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: lload 15
    //   1620: lstore 21
    //   1622: aload 34
    //   1624: lload 19
    //   1626: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1629: pop
    //   1630: lload 15
    //   1632: lstore 21
    //   1634: aload 34
    //   1636: ldc_w 1024
    //   1639: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: pop
    //   1643: lload 15
    //   1645: lstore 21
    //   1647: aload 34
    //   1649: aload_0
    //   1650: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   1653: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1656: pop
    //   1657: lload 15
    //   1659: lstore 21
    //   1661: aload 33
    //   1663: aload 34
    //   1665: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1668: invokestatic 635	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1671: pop
    //   1672: lload 15
    //   1674: lstore 21
    //   1676: aload_0
    //   1677: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   1680: astore 34
    //   1682: lload 15
    //   1684: lstore 21
    //   1686: new 113	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1693: astore 35
    //   1695: lload 15
    //   1697: lstore 21
    //   1699: aload 35
    //   1701: ldc_w 1032
    //   1704: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: pop
    //   1708: lload 15
    //   1710: lstore 21
    //   1712: aload 35
    //   1714: lload 19
    //   1716: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1719: pop
    //   1720: lload 15
    //   1722: lstore 21
    //   1724: aload 35
    //   1726: ldc_w 1034
    //   1729: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: pop
    //   1733: lload 15
    //   1735: lstore 21
    //   1737: aload 35
    //   1739: aload_0
    //   1740: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   1743: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1746: pop
    //   1747: lload 15
    //   1749: lstore 21
    //   1751: aload 34
    //   1753: ldc_w 1036
    //   1756: aload 35
    //   1758: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1761: invokevirtual 418	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1764: goto +6 -> 1770
    //   1767: lconst_0
    //   1768: lstore 19
    //   1770: lload 17
    //   1772: lstore 13
    //   1774: aload_0
    //   1775: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1778: astore 34
    //   1780: lload 19
    //   1782: lconst_0
    //   1783: lcmp
    //   1784: ifne +4715 -> 6499
    //   1787: iconst_0
    //   1788: istore 7
    //   1790: goto +3 -> 1793
    //   1793: aload 34
    //   1795: iload 7
    //   1797: invokevirtual 1041	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1800: aload_0
    //   1801: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1804: invokestatic 689	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1807: istore 7
    //   1809: aload_0
    //   1810: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1813: invokestatic 685	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1816: astore 34
    //   1818: aload_0
    //   1819: getfield 166	com/tencent/smtt/sdk/l:y	Ljava/lang/String;
    //   1822: astore 35
    //   1824: aload 35
    //   1826: ifnonnull +38 -> 1864
    //   1829: lload 15
    //   1831: lstore 21
    //   1833: aload_0
    //   1834: getfield 168	com/tencent/smtt/sdk/l:z	I
    //   1837: iconst_m1
    //   1838: if_icmpne +26 -> 1864
    //   1841: lload 15
    //   1843: lstore 21
    //   1845: aload_0
    //   1846: aload 34
    //   1848: putfield 166	com/tencent/smtt/sdk/l:y	Ljava/lang/String;
    //   1851: lload 15
    //   1853: lstore 21
    //   1855: aload_0
    //   1856: iload 7
    //   1858: putfield 168	com/tencent/smtt/sdk/l:z	I
    //   1861: goto +39 -> 1900
    //   1864: aload_0
    //   1865: getfield 168	com/tencent/smtt/sdk/l:z	I
    //   1868: istore 8
    //   1870: iload 7
    //   1872: iload 8
    //   1874: if_icmpne +29 -> 1903
    //   1877: lload 15
    //   1879: lstore 21
    //   1881: aload 34
    //   1883: aload_0
    //   1884: getfield 166	com/tencent/smtt/sdk/l:y	Ljava/lang/String;
    //   1887: invokevirtual 474	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1890: istore 10
    //   1892: iload 10
    //   1894: ifne +6 -> 1900
    //   1897: goto +6 -> 1903
    //   1900: goto +23 -> 1923
    //   1903: aload_0
    //   1904: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1907: iconst_0
    //   1908: invokevirtual 698	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   1911: aload_0
    //   1912: aload 34
    //   1914: putfield 166	com/tencent/smtt/sdk/l:y	Ljava/lang/String;
    //   1917: aload_0
    //   1918: iload 7
    //   1920: putfield 168	com/tencent/smtt/sdk/l:z	I
    //   1923: aload_0
    //   1924: getfield 278	com/tencent/smtt/sdk/l:r	I
    //   1927: istore 7
    //   1929: iload 7
    //   1931: iconst_1
    //   1932: if_icmplt +21 -> 1953
    //   1935: lload 15
    //   1937: lstore 21
    //   1939: aload_0
    //   1940: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   1943: ldc_w 1043
    //   1946: aload_0
    //   1947: getfield 956	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   1950: invokevirtual 1046	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1953: aload_0
    //   1954: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   1957: invokevirtual 794	java/net/HttpURLConnection:getResponseCode	()I
    //   1960: istore 7
    //   1962: new 113	java/lang/StringBuilder
    //   1965: dup
    //   1966: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1969: astore 34
    //   1971: aload 34
    //   1973: ldc_w 1048
    //   1976: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: pop
    //   1980: aload 34
    //   1982: iload 7
    //   1984: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1987: pop
    //   1988: aload 33
    //   1990: aload 34
    //   1992: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1995: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1998: aload_0
    //   1999: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2002: iload 7
    //   2004: invokevirtual 1051	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   2007: iload_1
    //   2008: ifne +101 -> 2109
    //   2011: lload 15
    //   2013: lstore 21
    //   2015: aload_0
    //   2016: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2019: invokestatic 232	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   2022: ifne +87 -> 2109
    //   2025: lload 15
    //   2027: lstore 21
    //   2029: aload_0
    //   2030: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2033: invokestatic 689	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2036: iconst_3
    //   2037: if_icmpne +17 -> 2054
    //   2040: lload 15
    //   2042: lstore 21
    //   2044: aload_0
    //   2045: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2048: invokestatic 689	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2051: ifne +58 -> 2109
    //   2054: lload 15
    //   2056: lstore 21
    //   2058: invokestatic 1054	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2061: ifne +48 -> 2109
    //   2064: lload 15
    //   2066: lstore 21
    //   2068: aload_0
    //   2069: invokevirtual 1055	com/tencent/smtt/sdk/l:b	()V
    //   2072: lload 15
    //   2074: lstore 21
    //   2076: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2079: ifnull +17 -> 2096
    //   2082: lload 15
    //   2084: lstore 21
    //   2086: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2089: bipush 111
    //   2091: invokeinterface 593 2 0
    //   2096: lload 15
    //   2098: lstore 21
    //   2100: aload 33
    //   2102: ldc_w 1057
    //   2105: iconst_0
    //   2106: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2109: aload_0
    //   2110: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   2113: istore 10
    //   2115: iload 10
    //   2117: ifeq +4388 -> 6505
    //   2120: lload 15
    //   2122: lstore 21
    //   2124: aload_0
    //   2125: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2128: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2131: sipush -309
    //   2134: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2137: iload_1
    //   2138: ifne +1030 -> 3168
    //   2141: lload 15
    //   2143: lstore 13
    //   2145: goto -1231 -> 914
    //   2148: iload 7
    //   2150: sipush 300
    //   2153: if_icmplt +110 -> 2263
    //   2156: iload 7
    //   2158: sipush 307
    //   2161: if_icmpgt +102 -> 2263
    //   2164: lload 15
    //   2166: lstore 21
    //   2168: aload_0
    //   2169: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   2172: ldc_w 1059
    //   2175: invokevirtual 1063	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2178: astore 34
    //   2180: lload 15
    //   2182: lstore 21
    //   2184: aload 34
    //   2186: invokestatic 801	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2189: ifne +34 -> 2223
    //   2192: lload 15
    //   2194: lstore 21
    //   2196: aload_0
    //   2197: aload 34
    //   2199: putfield 654	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   2202: lload 15
    //   2204: lstore 21
    //   2206: aload_0
    //   2207: aload_0
    //   2208: getfield 648	com/tencent/smtt/sdk/l:s	I
    //   2211: iconst_1
    //   2212: iadd
    //   2213: putfield 648	com/tencent/smtt/sdk/l:s	I
    //   2216: iload_1
    //   2217: ifne +4340 -> 6557
    //   2220: goto +259 -> 2479
    //   2223: lload 15
    //   2225: lstore 21
    //   2227: aload_0
    //   2228: bipush 124
    //   2230: aconst_null
    //   2231: iconst_1
    //   2232: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2235: lload 15
    //   2237: lstore 21
    //   2239: aload_0
    //   2240: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2243: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2246: sipush -312
    //   2249: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2252: iload_1
    //   2253: ifne +915 -> 3168
    //   2256: lload 15
    //   2258: lstore 13
    //   2260: goto -1346 -> 914
    //   2263: lload 15
    //   2265: lstore 21
    //   2267: aload_0
    //   2268: bipush 102
    //   2270: iload 7
    //   2272: invokestatic 1066	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2275: iconst_0
    //   2276: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2279: iload 7
    //   2281: sipush 416
    //   2284: if_icmpne +4240 -> 6524
    //   2287: lload 15
    //   2289: lstore 21
    //   2291: aload_0
    //   2292: iconst_1
    //   2293: iload 12
    //   2295: invokespecial 938	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   2298: istore 10
    //   2300: iload 10
    //   2302: ifeq +84 -> 2386
    //   2305: lload 15
    //   2307: lstore 21
    //   2309: aload_0
    //   2310: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2313: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2316: sipush -214
    //   2319: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2322: iload_1
    //   2323: ifne +37 -> 2360
    //   2326: aload_0
    //   2327: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2330: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2333: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2336: ldc_w 991
    //   2339: lload 15
    //   2341: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2344: invokeinterface 576 3 0
    //   2349: pop
    //   2350: aload_0
    //   2351: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2354: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2357: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2360: iconst_1
    //   2361: istore 9
    //   2363: aload 33
    //   2365: astore 34
    //   2367: goto +3536 -> 5903
    //   2370: astore 34
    //   2372: iconst_1
    //   2373: istore 11
    //   2375: lload 13
    //   2377: lstore 21
    //   2379: lload 15
    //   2381: lstore 13
    //   2383: goto +3302 -> 5685
    //   2386: lload 15
    //   2388: lstore 21
    //   2390: aload_0
    //   2391: iconst_0
    //   2392: invokespecial 940	com/tencent/smtt/sdk/l:e	(Z)Z
    //   2395: pop
    //   2396: lload 15
    //   2398: lstore 21
    //   2400: aload_0
    //   2401: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2404: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2407: sipush -313
    //   2410: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2413: iload_1
    //   2414: ifne +754 -> 3168
    //   2417: lload 15
    //   2419: lstore 13
    //   2421: goto -1507 -> 914
    //   2424: lload 15
    //   2426: lstore 21
    //   2428: aload_0
    //   2429: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   2432: ldc2_w 649
    //   2435: lcmp
    //   2436: ifne +31 -> 2467
    //   2439: lload 15
    //   2441: lstore 21
    //   2443: aload_0
    //   2444: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2447: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2450: sipush -314
    //   2453: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2456: iload_1
    //   2457: ifne +711 -> 3168
    //   2460: lload 15
    //   2462: lstore 13
    //   2464: goto -1550 -> 914
    //   2467: iload 7
    //   2469: sipush 202
    //   2472: if_icmpne +44 -> 2516
    //   2475: iload_1
    //   2476: ifne +4081 -> 6557
    //   2479: aload_0
    //   2480: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2483: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2486: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2489: ldc_w 991
    //   2492: lload 15
    //   2494: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2497: invokeinterface 576 3 0
    //   2502: pop
    //   2503: aload_0
    //   2504: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2507: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2510: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2513: goto +4044 -> 6557
    //   2516: lload 15
    //   2518: lstore 21
    //   2520: aload_0
    //   2521: getfield 278	com/tencent/smtt/sdk/l:r	I
    //   2524: aload_0
    //   2525: getfield 82	com/tencent/smtt/sdk/l:D	I
    //   2528: if_icmpge +71 -> 2599
    //   2531: iload 7
    //   2533: sipush 503
    //   2536: if_icmpne +63 -> 2599
    //   2539: lload 15
    //   2541: lstore 21
    //   2543: aload_0
    //   2544: aload_0
    //   2545: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   2548: ldc_w 1068
    //   2551: invokevirtual 1063	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2554: invokestatic 1072	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2557: invokespecial 1074	com/tencent/smtt/sdk/l:a	(J)V
    //   2560: lload 15
    //   2562: lstore 21
    //   2564: aload_0
    //   2565: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   2568: ifeq +3975 -> 6543
    //   2571: lload 15
    //   2573: lstore 21
    //   2575: aload_0
    //   2576: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2579: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2582: sipush -309
    //   2585: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2588: iload_1
    //   2589: ifne +579 -> 3168
    //   2592: lload 15
    //   2594: lstore 13
    //   2596: goto -1682 -> 914
    //   2599: lload 15
    //   2601: lstore 21
    //   2603: aload_0
    //   2604: getfield 278	com/tencent/smtt/sdk/l:r	I
    //   2607: aload_0
    //   2608: getfield 82	com/tencent/smtt/sdk/l:D	I
    //   2611: if_icmpge +83 -> 2694
    //   2614: iload 7
    //   2616: sipush 408
    //   2619: if_icmpeq +27 -> 2646
    //   2622: iload 7
    //   2624: sipush 504
    //   2627: if_icmpeq +19 -> 2646
    //   2630: iload 7
    //   2632: sipush 502
    //   2635: if_icmpeq +11 -> 2646
    //   2638: iload 7
    //   2640: sipush 408
    //   2643: if_icmpne +51 -> 2694
    //   2646: lload 15
    //   2648: lstore 21
    //   2650: aload_0
    //   2651: lconst_0
    //   2652: invokespecial 1074	com/tencent/smtt/sdk/l:a	(J)V
    //   2655: lload 15
    //   2657: lstore 21
    //   2659: aload_0
    //   2660: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   2663: ifeq +3887 -> 6550
    //   2666: lload 15
    //   2668: lstore 21
    //   2670: aload_0
    //   2671: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2674: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2677: sipush -309
    //   2680: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2683: iload_1
    //   2684: ifne +484 -> 3168
    //   2687: lload 15
    //   2689: lstore 13
    //   2691: goto -1777 -> 914
    //   2694: lload 15
    //   2696: lstore 21
    //   2698: aload_0
    //   2699: invokespecial 1026	com/tencent/smtt/sdk/l:l	()J
    //   2702: lconst_0
    //   2703: lcmp
    //   2704: ifgt +38 -> 2742
    //   2707: lload 15
    //   2709: lstore 21
    //   2711: aload_0
    //   2712: getfield 656	com/tencent/smtt/sdk/l:q	Z
    //   2715: ifne +27 -> 2742
    //   2718: iload 7
    //   2720: sipush 410
    //   2723: if_icmpeq +19 -> 2742
    //   2726: lload 15
    //   2728: lstore 21
    //   2730: aload_0
    //   2731: iconst_1
    //   2732: putfield 656	com/tencent/smtt/sdk/l:q	Z
    //   2735: iload_1
    //   2736: ifne +3821 -> 6557
    //   2739: goto -260 -> 2479
    //   2742: lload 15
    //   2744: lstore 21
    //   2746: aload_0
    //   2747: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2750: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2753: sipush -315
    //   2756: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2759: iload_1
    //   2760: ifne +408 -> 3168
    //   2763: lload 15
    //   2765: lstore 13
    //   2767: goto -1853 -> 914
    //   2770: aload_0
    //   2771: aload_0
    //   2772: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   2775: invokevirtual 1077	java/net/HttpURLConnection:getContentLength	()I
    //   2778: i2l
    //   2779: lload 19
    //   2781: ladd
    //   2782: putfield 652	com/tencent/smtt/sdk/l:n	J
    //   2785: new 113	java/lang/StringBuilder
    //   2788: dup
    //   2789: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   2792: astore 34
    //   2794: aload 34
    //   2796: ldc_w 1079
    //   2799: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2802: pop
    //   2803: aload 34
    //   2805: aload_0
    //   2806: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   2809: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2812: pop
    //   2813: aload 33
    //   2815: aload 34
    //   2817: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2820: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2823: aload_0
    //   2824: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2827: aload_0
    //   2828: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   2831: invokevirtual 1082	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2834: aload_0
    //   2835: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2838: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2841: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2844: ldc_w 480
    //   2847: lconst_0
    //   2848: invokeinterface 484 4 0
    //   2853: lstore 23
    //   2855: lload 23
    //   2857: lconst_0
    //   2858: lcmp
    //   2859: ifeq +316 -> 3175
    //   2862: lload 15
    //   2864: lstore 21
    //   2866: aload_0
    //   2867: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   2870: lload 23
    //   2872: lcmp
    //   2873: ifeq +302 -> 3175
    //   2876: lload 15
    //   2878: lstore 21
    //   2880: new 113	java/lang/StringBuilder
    //   2883: dup
    //   2884: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   2887: astore 34
    //   2889: lload 15
    //   2891: lstore 21
    //   2893: aload 34
    //   2895: ldc_w 1084
    //   2898: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2901: pop
    //   2902: lload 15
    //   2904: lstore 21
    //   2906: aload 34
    //   2908: lload 23
    //   2910: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2913: pop
    //   2914: lload 15
    //   2916: lstore 21
    //   2918: aload 34
    //   2920: ldc_w 1086
    //   2923: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2926: pop
    //   2927: lload 15
    //   2929: lstore 21
    //   2931: aload 34
    //   2933: aload_0
    //   2934: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   2937: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2940: pop
    //   2941: lload 15
    //   2943: lstore 21
    //   2945: aload 33
    //   2947: aload 34
    //   2949: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2952: iconst_1
    //   2953: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2956: iload_1
    //   2957: ifne +169 -> 3126
    //   2960: lload 15
    //   2962: lstore 21
    //   2964: aload_0
    //   2965: invokespecial 440	com/tencent/smtt/sdk/l:o	()Z
    //   2968: ifne +27 -> 2995
    //   2971: lload 15
    //   2973: lstore 21
    //   2975: invokestatic 1054	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2978: ifeq +148 -> 3126
    //   2981: lload 15
    //   2983: lstore 21
    //   2985: aload_0
    //   2986: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2989: invokestatic 704	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2992: ifeq +134 -> 3126
    //   2995: lload 15
    //   2997: lstore 21
    //   2999: aload_0
    //   3000: getfield 84	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   3003: ifnull +22 -> 3025
    //   3006: lload 15
    //   3008: lstore 21
    //   3010: aload_0
    //   3011: iconst_0
    //   3012: invokevirtual 1088	com/tencent/smtt/sdk/l:b	(Z)Z
    //   3015: ifeq +10 -> 3025
    //   3018: iload_1
    //   3019: ifne +3538 -> 6557
    //   3022: goto -543 -> 2479
    //   3025: lload 15
    //   3027: lstore 21
    //   3029: new 113	java/lang/StringBuilder
    //   3032: dup
    //   3033: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   3036: astore 34
    //   3038: lload 15
    //   3040: lstore 21
    //   3042: aload 34
    //   3044: ldc_w 1090
    //   3047: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3050: pop
    //   3051: lload 15
    //   3053: lstore 21
    //   3055: aload 34
    //   3057: lload 23
    //   3059: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3062: pop
    //   3063: lload 15
    //   3065: lstore 21
    //   3067: aload 34
    //   3069: ldc_w 1086
    //   3072: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3075: pop
    //   3076: lload 15
    //   3078: lstore 21
    //   3080: aload 34
    //   3082: aload_0
    //   3083: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   3086: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3089: pop
    //   3090: lload 15
    //   3092: lstore 21
    //   3094: aload_0
    //   3095: bipush 113
    //   3097: aload 34
    //   3099: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3102: iconst_1
    //   3103: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3106: lload 15
    //   3108: lstore 21
    //   3110: aload_0
    //   3111: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3114: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3117: sipush -310
    //   3120: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3123: goto +34 -> 3157
    //   3126: lload 15
    //   3128: lstore 21
    //   3130: aload_0
    //   3131: bipush 101
    //   3133: ldc_w 1092
    //   3136: iconst_1
    //   3137: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3140: lload 15
    //   3142: lstore 21
    //   3144: aload_0
    //   3145: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3148: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3151: sipush -304
    //   3154: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3157: iload_1
    //   3158: ifne +10 -> 3168
    //   3161: lload 15
    //   3163: lstore 13
    //   3165: goto -2251 -> 914
    //   3168: aload 33
    //   3170: astore 34
    //   3172: goto +2731 -> 5903
    //   3175: aload 33
    //   3177: ldc_w 1094
    //   3180: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3183: aload_0
    //   3184: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   3187: invokevirtual 791	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3190: astore 35
    //   3192: aload 35
    //   3194: ifnull +3612 -> 6806
    //   3197: aload_0
    //   3198: getfield 398	com/tencent/smtt/sdk/l:v	Ljava/net/HttpURLConnection;
    //   3201: invokevirtual 1097	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3204: astore 34
    //   3206: aload 34
    //   3208: ifnull +28 -> 3236
    //   3211: aload 34
    //   3213: ldc_w 1099
    //   3216: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3219: ifeq +17 -> 3236
    //   3222: new 1101	java/util/zip/GZIPInputStream
    //   3225: dup
    //   3226: aload 35
    //   3228: invokespecial 1102	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3231: astore 34
    //   3233: goto +45 -> 3278
    //   3236: aload 34
    //   3238: ifnull +36 -> 3274
    //   3241: aload 34
    //   3243: ldc_w 1104
    //   3246: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3249: ifeq +25 -> 3274
    //   3252: new 1106	java/util/zip/InflaterInputStream
    //   3255: dup
    //   3256: aload 35
    //   3258: new 1108	java/util/zip/Inflater
    //   3261: dup
    //   3262: iconst_1
    //   3263: invokespecial 1110	java/util/zip/Inflater:<init>	(Z)V
    //   3266: invokespecial 1113	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3269: astore 34
    //   3271: goto +7 -> 3278
    //   3274: aload 35
    //   3276: astore 34
    //   3278: sipush 8192
    //   3281: newarray byte
    //   3283: astore 40
    //   3285: iload_2
    //   3286: ifeq +121 -> 3407
    //   3289: aload_0
    //   3290: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3293: invokestatic 602	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   3296: ifeq +111 -> 3407
    //   3299: aload_0
    //   3300: getfield 159	com/tencent/smtt/sdk/l:m	Ljava/io/File;
    //   3303: astore 36
    //   3305: new 113	java/lang/StringBuilder
    //   3308: dup
    //   3309: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   3312: astore 37
    //   3314: aload 37
    //   3316: iconst_0
    //   3317: invokestatic 238	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   3320: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3323: pop
    //   3324: aload 37
    //   3326: ldc_w 372
    //   3329: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3332: pop
    //   3333: aload 37
    //   3335: ldc_w 607
    //   3338: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: pop
    //   3342: new 149	java/io/File
    //   3345: dup
    //   3346: aload 36
    //   3348: aload 37
    //   3350: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3353: invokespecial 241	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3356: astore 37
    //   3358: aload 37
    //   3360: astore 36
    //   3362: aload 37
    //   3364: invokevirtual 203	java/io/File:exists	()Z
    //   3367: ifeq +56 -> 3423
    //   3370: aload 37
    //   3372: invokevirtual 328	java/io/File:delete	()Z
    //   3375: pop
    //   3376: aload 37
    //   3378: astore 36
    //   3380: goto +43 -> 3423
    //   3383: astore 36
    //   3385: goto +10 -> 3395
    //   3388: astore 36
    //   3390: goto +10 -> 3400
    //   3393: astore 36
    //   3395: goto +3347 -> 6742
    //   3398: astore 36
    //   3400: aload 36
    //   3402: astore 37
    //   3404: goto +3370 -> 6774
    //   3407: new 149	java/io/File
    //   3410: dup
    //   3411: aload_0
    //   3412: getfield 139	com/tencent/smtt/sdk/l:l	Ljava/io/File;
    //   3415: ldc_w 461
    //   3418: invokespecial 241	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3421: astore 36
    //   3423: lload 19
    //   3425: lstore 21
    //   3427: lload 15
    //   3429: lstore 17
    //   3431: new 113	java/lang/StringBuilder
    //   3434: dup
    //   3435: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   3438: astore 37
    //   3440: aload 37
    //   3442: ldc_w 1115
    //   3445: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3448: pop
    //   3449: aload 37
    //   3451: aload 36
    //   3453: invokevirtual 457	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3456: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3459: pop
    //   3460: aload 33
    //   3462: aload 37
    //   3464: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3467: iconst_1
    //   3468: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3471: new 1117	java/io/FileOutputStream
    //   3474: dup
    //   3475: aload 36
    //   3477: iconst_1
    //   3478: invokespecial 1120	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3481: astore 36
    //   3483: aload 33
    //   3485: astore 37
    //   3487: lload 17
    //   3489: lstore 23
    //   3491: aload 33
    //   3493: astore 38
    //   3495: lload 17
    //   3497: lstore 25
    //   3499: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   3502: lstore 27
    //   3504: lload 21
    //   3506: lstore 19
    //   3508: lload 21
    //   3510: lstore 29
    //   3512: lload 17
    //   3514: lstore 15
    //   3516: aload 33
    //   3518: astore 37
    //   3520: lload 15
    //   3522: lstore 23
    //   3524: aload 33
    //   3526: astore 38
    //   3528: lload 15
    //   3530: lstore 25
    //   3532: aload_0
    //   3533: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   3536: istore 10
    //   3538: iload 10
    //   3540: ifeq +93 -> 3633
    //   3543: iload 9
    //   3545: istore 10
    //   3547: iload 9
    //   3549: istore 11
    //   3551: aload 33
    //   3553: ldc_w 1122
    //   3556: iconst_1
    //   3557: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3560: iload 9
    //   3562: istore 10
    //   3564: iload 9
    //   3566: istore 11
    //   3568: aload_0
    //   3569: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3572: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3575: sipush -309
    //   3578: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3581: iconst_0
    //   3582: istore 7
    //   3584: goto +971 -> 4555
    //   3587: astore 39
    //   3589: aload 36
    //   3591: astore 38
    //   3593: aload 33
    //   3595: astore 37
    //   3597: aload 39
    //   3599: astore 36
    //   3601: aload 38
    //   3603: astore 33
    //   3605: aload 35
    //   3607: astore 38
    //   3609: aload 34
    //   3611: astore 35
    //   3613: aload 37
    //   3615: astore 34
    //   3617: iload 10
    //   3619: istore 9
    //   3621: goto +1894 -> 5515
    //   3624: astore 37
    //   3626: iload 11
    //   3628: istore 9
    //   3630: goto +2975 -> 6605
    //   3633: aload 33
    //   3635: astore 37
    //   3637: lload 15
    //   3639: lstore 23
    //   3641: aload 33
    //   3643: astore 38
    //   3645: lload 15
    //   3647: lstore 25
    //   3649: aload 34
    //   3651: aload 40
    //   3653: iconst_0
    //   3654: sipush 8192
    //   3657: invokevirtual 1128	java/io/InputStream:read	([BII)I
    //   3660: istore 7
    //   3662: iload 7
    //   3664: ifgt +136 -> 3800
    //   3667: iload 9
    //   3669: istore 10
    //   3671: iload 9
    //   3673: istore 11
    //   3675: aload_0
    //   3676: getfield 84	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   3679: ifnull +66 -> 3745
    //   3682: iload 9
    //   3684: istore 10
    //   3686: iload 9
    //   3688: istore 11
    //   3690: aload_0
    //   3691: iconst_1
    //   3692: iload 12
    //   3694: invokespecial 938	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   3697: ifne +48 -> 3745
    //   3700: iload_1
    //   3701: ifne +25 -> 3726
    //   3704: iload 9
    //   3706: istore 10
    //   3708: iload 9
    //   3710: istore 11
    //   3712: aload_0
    //   3713: iconst_0
    //   3714: invokevirtual 1088	com/tencent/smtt/sdk/l:b	(Z)Z
    //   3717: ifeq +9 -> 3726
    //   3720: iconst_1
    //   3721: istore 7
    //   3723: goto +832 -> 4555
    //   3726: iload 9
    //   3728: istore 10
    //   3730: iload 9
    //   3732: istore 11
    //   3734: aload_0
    //   3735: iconst_1
    //   3736: putfield 660	com/tencent/smtt/sdk/l:u	Z
    //   3739: iconst_0
    //   3740: istore 9
    //   3742: goto -161 -> 3581
    //   3745: iload 9
    //   3747: istore 10
    //   3749: iload 9
    //   3751: istore 11
    //   3753: aload_0
    //   3754: iconst_1
    //   3755: putfield 660	com/tencent/smtt/sdk/l:u	Z
    //   3758: iload 9
    //   3760: istore 10
    //   3762: iload 9
    //   3764: istore 11
    //   3766: aload_0
    //   3767: getfield 84	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   3770: ifnull +6 -> 3776
    //   3773: iconst_1
    //   3774: istore 9
    //   3776: iload 9
    //   3778: istore 10
    //   3780: iload 9
    //   3782: istore 11
    //   3784: aload_0
    //   3785: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3788: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3791: sipush -311
    //   3794: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3797: goto -216 -> 3581
    //   3800: aload 33
    //   3802: astore 37
    //   3804: lload 15
    //   3806: lstore 23
    //   3808: aload 33
    //   3810: astore 38
    //   3812: lload 15
    //   3814: lstore 25
    //   3816: aload 36
    //   3818: aload 40
    //   3820: iconst_0
    //   3821: iload 7
    //   3823: invokevirtual 1132	java/io/FileOutputStream:write	([BII)V
    //   3826: aload 33
    //   3828: astore 37
    //   3830: lload 15
    //   3832: lstore 23
    //   3834: aload 33
    //   3836: astore 38
    //   3838: lload 15
    //   3840: lstore 25
    //   3842: aload 36
    //   3844: invokevirtual 1135	java/io/FileOutputStream:flush	()V
    //   3847: iload_1
    //   3848: ifne +335 -> 4183
    //   3851: aload 33
    //   3853: astore 37
    //   3855: lload 15
    //   3857: iload 7
    //   3859: i2l
    //   3860: ladd
    //   3861: lstore 15
    //   3863: lload 15
    //   3865: lload 13
    //   3867: lcmp
    //   3868: iflt +123 -> 3991
    //   3871: aload 37
    //   3873: ldc_w 1008
    //   3876: iconst_1
    //   3877: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3880: new 113	java/lang/StringBuilder
    //   3883: dup
    //   3884: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   3887: astore 38
    //   3889: aload 38
    //   3891: ldc_w 1137
    //   3894: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3897: pop
    //   3898: aload 38
    //   3900: lload 15
    //   3902: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3905: pop
    //   3906: aload 38
    //   3908: ldc_w 1139
    //   3911: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3914: pop
    //   3915: aload 38
    //   3917: lload 13
    //   3919: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3922: pop
    //   3923: aload_0
    //   3924: bipush 112
    //   3926: aload 38
    //   3928: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3931: iconst_1
    //   3932: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3935: aload_0
    //   3936: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3939: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3942: sipush -307
    //   3945: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3948: goto -367 -> 3581
    //   3951: astore 33
    //   3953: goto +2725 -> 6678
    //   3956: astore 33
    //   3958: goto +2757 -> 6715
    //   3961: astore 38
    //   3963: aload 36
    //   3965: astore 33
    //   3967: aload 38
    //   3969: astore 36
    //   3971: aload 35
    //   3973: astore 38
    //   3975: aload 34
    //   3977: astore 35
    //   3979: aload 37
    //   3981: astore 34
    //   3983: goto +1532 -> 5515
    //   3986: astore 37
    //   3988: goto -358 -> 3630
    //   3991: lload 15
    //   3993: lstore 17
    //   3995: lload 17
    //   3997: lstore 23
    //   3999: lload 17
    //   4001: lstore 15
    //   4003: lload 17
    //   4005: lstore 21
    //   4007: aload_0
    //   4008: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4011: invokestatic 1009	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   4014: ifne +169 -> 4183
    //   4017: lload 17
    //   4019: lstore 23
    //   4021: lload 17
    //   4023: lstore 21
    //   4025: aload 37
    //   4027: ldc_w 1141
    //   4030: iconst_1
    //   4031: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4034: lload 17
    //   4036: lstore 23
    //   4038: lload 17
    //   4040: lstore 21
    //   4042: new 113	java/lang/StringBuilder
    //   4045: dup
    //   4046: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   4049: astore 37
    //   4051: lload 17
    //   4053: lstore 23
    //   4055: lload 17
    //   4057: lstore 21
    //   4059: aload 37
    //   4061: ldc_w 1143
    //   4064: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4067: pop
    //   4068: lload 17
    //   4070: lstore 23
    //   4072: lload 17
    //   4074: lstore 21
    //   4076: aload 37
    //   4078: invokestatic 1145	com/tencent/smtt/utils/q:a	()J
    //   4081: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4084: pop
    //   4085: lload 17
    //   4087: lstore 23
    //   4089: lload 17
    //   4091: lstore 21
    //   4093: aload 37
    //   4095: ldc_w 1147
    //   4098: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: pop
    //   4102: lload 17
    //   4104: lstore 23
    //   4106: lload 17
    //   4108: lstore 21
    //   4110: aload 37
    //   4112: aload_0
    //   4113: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4116: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4119: invokevirtual 1150	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4122: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4125: pop
    //   4126: lload 17
    //   4128: lstore 23
    //   4130: lload 17
    //   4132: lstore 21
    //   4134: aload_0
    //   4135: bipush 105
    //   4137: aload 37
    //   4139: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4142: iconst_1
    //   4143: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4146: lload 17
    //   4148: lstore 23
    //   4150: lload 17
    //   4152: lstore 21
    //   4154: aload_0
    //   4155: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4158: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4161: sipush -308
    //   4164: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4167: lload 17
    //   4169: lstore 15
    //   4171: goto -590 -> 3581
    //   4174: astore 37
    //   4176: lload 23
    //   4178: lstore 15
    //   4180: goto -550 -> 3630
    //   4183: aload 33
    //   4185: astore 37
    //   4187: iload 7
    //   4189: i2l
    //   4190: lstore 17
    //   4192: lload 15
    //   4194: lstore 21
    //   4196: aload_0
    //   4197: lload 31
    //   4199: lload 17
    //   4201: invokespecial 1152	com/tencent/smtt/sdk/l:a	(JJ)J
    //   4204: lstore 31
    //   4206: lload 15
    //   4208: lstore 21
    //   4210: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   4213: lstore 25
    //   4215: lload 29
    //   4217: lload 17
    //   4219: ladd
    //   4220: lstore 17
    //   4222: lload 25
    //   4224: lload 27
    //   4226: lsub
    //   4227: ldc2_w 1153
    //   4230: lcmp
    //   4231: ifle +2412 -> 6643
    //   4234: lload 15
    //   4236: lstore 21
    //   4238: new 113	java/lang/StringBuilder
    //   4241: dup
    //   4242: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   4245: astore 38
    //   4247: lload 15
    //   4249: lstore 21
    //   4251: aload 38
    //   4253: ldc_w 1156
    //   4256: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4259: pop
    //   4260: lload 15
    //   4262: lstore 21
    //   4264: aload 38
    //   4266: lload 17
    //   4268: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4271: pop
    //   4272: lload 15
    //   4274: lstore 21
    //   4276: aload 38
    //   4278: aload 39
    //   4280: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4283: pop
    //   4284: lload 15
    //   4286: lstore 21
    //   4288: aload 38
    //   4290: aload_0
    //   4291: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   4294: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4297: pop
    //   4298: lload 15
    //   4300: lstore 21
    //   4302: aload 37
    //   4304: aload 38
    //   4306: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4309: iconst_1
    //   4310: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4313: lload 15
    //   4315: lstore 21
    //   4317: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4320: astore 38
    //   4322: aload 38
    //   4324: ifnull +69 -> 4393
    //   4327: lload 17
    //   4329: l2d
    //   4330: dstore_3
    //   4331: lload 15
    //   4333: lstore 23
    //   4335: lload 15
    //   4337: lstore 21
    //   4339: aload_0
    //   4340: getfield 652	com/tencent/smtt/sdk/l:n	J
    //   4343: lstore 27
    //   4345: lload 27
    //   4347: l2d
    //   4348: dstore 5
    //   4350: dload_3
    //   4351: invokestatic 1162	java/lang/Double:isNaN	(D)Z
    //   4354: pop
    //   4355: dload 5
    //   4357: invokestatic 1162	java/lang/Double:isNaN	(D)Z
    //   4360: pop
    //   4361: dload_3
    //   4362: dload 5
    //   4364: ddiv
    //   4365: ldc2_w 1163
    //   4368: dmul
    //   4369: d2i
    //   4370: istore 7
    //   4372: lload 15
    //   4374: lstore 23
    //   4376: lload 15
    //   4378: lstore 21
    //   4380: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4383: iload 7
    //   4385: invokeinterface 1167 2 0
    //   4390: goto +3 -> 4393
    //   4393: iload_1
    //   4394: ifne +2242 -> 6636
    //   4397: lload 17
    //   4399: lload 19
    //   4401: lsub
    //   4402: ldc2_w 1168
    //   4405: lcmp
    //   4406: ifle +2230 -> 6636
    //   4409: lload 15
    //   4411: lstore 21
    //   4413: aload_0
    //   4414: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4417: invokestatic 232	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4420: ifne +2209 -> 6629
    //   4423: lload 15
    //   4425: lstore 21
    //   4427: aload_0
    //   4428: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4431: invokestatic 689	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4434: istore 7
    //   4436: iload 7
    //   4438: iconst_3
    //   4439: if_icmpne +25 -> 4464
    //   4442: lload 15
    //   4444: lstore 23
    //   4446: lload 15
    //   4448: lstore 21
    //   4450: aload_0
    //   4451: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4454: invokestatic 689	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4457: istore 7
    //   4459: iload 7
    //   4461: ifne +2168 -> 6629
    //   4464: lload 15
    //   4466: lstore 21
    //   4468: invokestatic 1054	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4471: ifne +2158 -> 6629
    //   4474: lload 15
    //   4476: lstore 21
    //   4478: aload_0
    //   4479: invokevirtual 1055	com/tencent/smtt/sdk/l:b	()V
    //   4482: lload 15
    //   4484: lstore 21
    //   4486: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4489: astore 38
    //   4491: aload 38
    //   4493: ifnull +21 -> 4514
    //   4496: lload 15
    //   4498: lstore 23
    //   4500: lload 15
    //   4502: lstore 21
    //   4504: getstatic 588	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4507: bipush 111
    //   4509: invokeinterface 593 2 0
    //   4514: lload 15
    //   4516: lstore 21
    //   4518: aload 37
    //   4520: ldc_w 1171
    //   4523: iconst_0
    //   4524: invokestatic 963	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4527: lload 15
    //   4529: lstore 21
    //   4531: aload_0
    //   4532: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4535: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4538: astore 38
    //   4540: lload 15
    //   4542: lstore 21
    //   4544: aload 38
    //   4546: sipush -304
    //   4549: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4552: goto -971 -> 3581
    //   4555: aload 36
    //   4557: astore 39
    //   4559: aload 34
    //   4561: astore 40
    //   4563: aload 33
    //   4565: astore 38
    //   4567: iload 9
    //   4569: istore 10
    //   4571: lload 13
    //   4573: lstore 25
    //   4575: lload 15
    //   4577: lstore 23
    //   4579: iload 7
    //   4581: ifeq +104 -> 4685
    //   4584: aload 33
    //   4586: astore 37
    //   4588: iload 9
    //   4590: istore 11
    //   4592: lload 13
    //   4594: lstore 21
    //   4596: lload 15
    //   4598: lstore 19
    //   4600: lload 15
    //   4602: lstore 17
    //   4604: aload_0
    //   4605: aload 36
    //   4607: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4610: aload 33
    //   4612: astore 37
    //   4614: iload 9
    //   4616: istore 11
    //   4618: lload 13
    //   4620: lstore 21
    //   4622: lload 15
    //   4624: lstore 19
    //   4626: lload 15
    //   4628: lstore 17
    //   4630: aload_0
    //   4631: aload 34
    //   4633: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4636: aload 33
    //   4638: astore 37
    //   4640: iload 9
    //   4642: istore 11
    //   4644: lload 13
    //   4646: lstore 21
    //   4648: lload 15
    //   4650: lstore 19
    //   4652: lload 15
    //   4654: lstore 17
    //   4656: aload_0
    //   4657: aload 35
    //   4659: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4662: aload 33
    //   4664: astore 34
    //   4666: iload 9
    //   4668: istore 11
    //   4670: lload 13
    //   4672: lstore 19
    //   4674: lload 15
    //   4676: lstore 17
    //   4678: iload_1
    //   4679: ifne +799 -> 5478
    //   4682: goto +746 -> 5428
    //   4685: aload 38
    //   4687: astore 37
    //   4689: iload 10
    //   4691: istore 11
    //   4693: lload 25
    //   4695: lstore 21
    //   4697: lload 23
    //   4699: lstore 19
    //   4701: lload 23
    //   4703: lstore 17
    //   4705: aload_0
    //   4706: aload 39
    //   4708: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4711: aload 38
    //   4713: astore 37
    //   4715: iload 10
    //   4717: istore 11
    //   4719: lload 25
    //   4721: lstore 21
    //   4723: lload 23
    //   4725: lstore 19
    //   4727: lload 23
    //   4729: lstore 17
    //   4731: aload_0
    //   4732: aload 40
    //   4734: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4737: aload 38
    //   4739: astore 37
    //   4741: iload 10
    //   4743: istore 11
    //   4745: lload 25
    //   4747: lstore 21
    //   4749: lload 23
    //   4751: lstore 19
    //   4753: lload 23
    //   4755: lstore 17
    //   4757: aload_0
    //   4758: aload 35
    //   4760: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4763: aload 38
    //   4765: astore 37
    //   4767: iload 10
    //   4769: istore 11
    //   4771: lload 25
    //   4773: lstore 21
    //   4775: lload 23
    //   4777: lstore 19
    //   4779: lload 23
    //   4781: lstore 17
    //   4783: aload_0
    //   4784: getfield 660	com/tencent/smtt/sdk/l:u	Z
    //   4787: ifne +36 -> 4823
    //   4790: aload 38
    //   4792: astore 37
    //   4794: iload 10
    //   4796: istore 11
    //   4798: lload 25
    //   4800: lstore 21
    //   4802: lload 23
    //   4804: lstore 19
    //   4806: lload 23
    //   4808: lstore 17
    //   4810: aload_0
    //   4811: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4814: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4817: sipush -319
    //   4820: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4823: aload 38
    //   4825: astore 34
    //   4827: iload 10
    //   4829: istore 9
    //   4831: iload_1
    //   4832: ifne +1071 -> 5903
    //   4835: lload 23
    //   4837: lstore 13
    //   4839: iload 10
    //   4841: istore 9
    //   4843: aload 38
    //   4845: astore 33
    //   4847: aload_0
    //   4848: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4851: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4854: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4857: ldc_w 991
    //   4860: lload 13
    //   4862: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4865: invokeinterface 576 3 0
    //   4870: pop
    //   4871: aload_0
    //   4872: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4875: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4878: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4881: aload 33
    //   4883: astore 34
    //   4885: goto +1018 -> 5903
    //   4888: astore 34
    //   4890: aconst_null
    //   4891: astore 35
    //   4893: aload 33
    //   4895: astore 37
    //   4897: aconst_null
    //   4898: astore 36
    //   4900: aconst_null
    //   4901: astore 39
    //   4903: aload 34
    //   4905: astore 33
    //   4907: aload 37
    //   4909: astore 34
    //   4911: goto +624 -> 5535
    //   4914: astore 37
    //   4916: aconst_null
    //   4917: astore 38
    //   4919: aconst_null
    //   4920: astore 36
    //   4922: aconst_null
    //   4923: astore 35
    //   4925: iload 9
    //   4927: istore 10
    //   4929: aload 37
    //   4931: invokevirtual 1172	java/io/IOException:printStackTrace	()V
    //   4934: aload 37
    //   4936: instanceof 1174
    //   4939: ifne +362 -> 5301
    //   4942: aload 37
    //   4944: instanceof 1176
    //   4947: ifeq +6 -> 4953
    //   4950: goto +351 -> 5301
    //   4953: iload_1
    //   4954: ifne +191 -> 5145
    //   4957: aload_0
    //   4958: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4961: invokestatic 1009	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   4964: ifne +181 -> 5145
    //   4967: new 113	java/lang/StringBuilder
    //   4970: dup
    //   4971: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   4974: astore 34
    //   4976: aload 34
    //   4978: ldc_w 1143
    //   4981: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4984: pop
    //   4985: aload 34
    //   4987: invokestatic 1145	com/tencent/smtt/utils/q:a	()J
    //   4990: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4993: pop
    //   4994: aload 34
    //   4996: ldc_w 1147
    //   4999: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5002: pop
    //   5003: aload 34
    //   5005: aload_0
    //   5006: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5009: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5012: invokevirtual 1150	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   5015: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5018: pop
    //   5019: aload_0
    //   5020: bipush 105
    //   5022: aload 34
    //   5024: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5027: iconst_1
    //   5028: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5031: aload_0
    //   5032: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5035: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5038: sipush -308
    //   5041: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5044: aload 33
    //   5046: astore 37
    //   5048: iload 10
    //   5050: istore 11
    //   5052: lload 13
    //   5054: lstore 21
    //   5056: lload 15
    //   5058: lstore 19
    //   5060: lload 15
    //   5062: lstore 17
    //   5064: aload_0
    //   5065: aload 36
    //   5067: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5070: aload 33
    //   5072: astore 37
    //   5074: iload 10
    //   5076: istore 11
    //   5078: lload 13
    //   5080: lstore 21
    //   5082: lload 15
    //   5084: lstore 19
    //   5086: lload 15
    //   5088: lstore 17
    //   5090: aload_0
    //   5091: aload 35
    //   5093: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5096: aload 33
    //   5098: astore 37
    //   5100: iload 10
    //   5102: istore 11
    //   5104: lload 13
    //   5106: lstore 21
    //   5108: lload 15
    //   5110: lstore 19
    //   5112: lload 15
    //   5114: lstore 17
    //   5116: aload_0
    //   5117: aload 38
    //   5119: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5122: aload 33
    //   5124: astore 34
    //   5126: iload 10
    //   5128: istore 9
    //   5130: iload_1
    //   5131: ifne +772 -> 5903
    //   5134: iload 10
    //   5136: istore 9
    //   5138: lload 15
    //   5140: lstore 13
    //   5142: goto -295 -> 4847
    //   5145: aload_0
    //   5146: lconst_0
    //   5147: invokespecial 1074	com/tencent/smtt/sdk/l:a	(J)V
    //   5150: aload_0
    //   5151: invokespecial 1178	com/tencent/smtt/sdk/l:k	()Z
    //   5154: ifne +27 -> 5181
    //   5157: bipush 106
    //   5159: istore 7
    //   5161: aload_0
    //   5162: aload 37
    //   5164: invokespecial 537	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5167: astore 34
    //   5169: aload_0
    //   5170: iload 7
    //   5172: aload 34
    //   5174: iconst_0
    //   5175: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5178: goto +18 -> 5196
    //   5181: bipush 104
    //   5183: istore 7
    //   5185: aload_0
    //   5186: aload 37
    //   5188: invokespecial 537	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5191: astore 34
    //   5193: goto -24 -> 5169
    //   5196: aload 33
    //   5198: astore 37
    //   5200: iload 10
    //   5202: istore 11
    //   5204: lload 13
    //   5206: lstore 21
    //   5208: lload 15
    //   5210: lstore 19
    //   5212: lload 15
    //   5214: lstore 17
    //   5216: aload_0
    //   5217: aload 36
    //   5219: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5222: aload 33
    //   5224: astore 37
    //   5226: iload 10
    //   5228: istore 11
    //   5230: lload 13
    //   5232: lstore 21
    //   5234: lload 15
    //   5236: lstore 19
    //   5238: lload 15
    //   5240: lstore 17
    //   5242: aload_0
    //   5243: aload 35
    //   5245: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5248: aload 33
    //   5250: astore 37
    //   5252: iload 10
    //   5254: istore 11
    //   5256: lload 13
    //   5258: lstore 21
    //   5260: lload 15
    //   5262: lstore 19
    //   5264: lload 15
    //   5266: lstore 17
    //   5268: aload_0
    //   5269: aload 38
    //   5271: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5274: aload 33
    //   5276: astore 34
    //   5278: iload 10
    //   5280: istore 11
    //   5282: lload 13
    //   5284: lstore 19
    //   5286: lload 15
    //   5288: lstore 17
    //   5290: iload_1
    //   5291: ifne +187 -> 5478
    //   5294: iload 10
    //   5296: istore 9
    //   5298: goto +130 -> 5428
    //   5301: aload_0
    //   5302: ldc_w 1179
    //   5305: putfield 76	com/tencent/smtt/sdk/l:o	I
    //   5308: aload_0
    //   5309: lconst_0
    //   5310: invokespecial 1074	com/tencent/smtt/sdk/l:a	(J)V
    //   5313: aload_0
    //   5314: bipush 103
    //   5316: aload_0
    //   5317: aload 37
    //   5319: invokespecial 537	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5322: iconst_0
    //   5323: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5326: aload 33
    //   5328: astore 37
    //   5330: iload 10
    //   5332: istore 11
    //   5334: lload 13
    //   5336: lstore 21
    //   5338: lload 15
    //   5340: lstore 19
    //   5342: lload 15
    //   5344: lstore 17
    //   5346: aload_0
    //   5347: aload 36
    //   5349: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5352: aload 33
    //   5354: astore 37
    //   5356: iload 10
    //   5358: istore 11
    //   5360: lload 13
    //   5362: lstore 21
    //   5364: lload 15
    //   5366: lstore 19
    //   5368: lload 15
    //   5370: lstore 17
    //   5372: aload_0
    //   5373: aload 35
    //   5375: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5378: aload 33
    //   5380: astore 37
    //   5382: iload 10
    //   5384: istore 11
    //   5386: lload 13
    //   5388: lstore 21
    //   5390: lload 15
    //   5392: lstore 19
    //   5394: lload 15
    //   5396: lstore 17
    //   5398: aload_0
    //   5399: aload 38
    //   5401: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5404: aload 33
    //   5406: astore 34
    //   5408: iload 10
    //   5410: istore 11
    //   5412: lload 13
    //   5414: lstore 19
    //   5416: lload 15
    //   5418: lstore 17
    //   5420: iload_1
    //   5421: ifne +57 -> 5478
    //   5424: iload 10
    //   5426: istore 9
    //   5428: aload_0
    //   5429: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5432: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5435: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5438: ldc_w 991
    //   5441: lload 15
    //   5443: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5446: invokeinterface 576 3 0
    //   5451: pop
    //   5452: aload_0
    //   5453: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5456: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5459: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5462: lload 15
    //   5464: lstore 17
    //   5466: lload 13
    //   5468: lstore 19
    //   5470: iload 9
    //   5472: istore 11
    //   5474: aload 33
    //   5476: astore 34
    //   5478: aload 34
    //   5480: astore 33
    //   5482: lload 17
    //   5484: lstore 13
    //   5486: lload 19
    //   5488: lstore 17
    //   5490: iload 11
    //   5492: istore 9
    //   5494: goto +1071 -> 6565
    //   5497: astore 37
    //   5499: iload 10
    //   5501: istore 9
    //   5503: aload 33
    //   5505: astore 34
    //   5507: aload 36
    //   5509: astore 33
    //   5511: aload 37
    //   5513: astore 36
    //   5515: aload 36
    //   5517: astore 37
    //   5519: aload 35
    //   5521: astore 39
    //   5523: aload 38
    //   5525: astore 35
    //   5527: aload 33
    //   5529: astore 36
    //   5531: aload 37
    //   5533: astore 33
    //   5535: aload 34
    //   5537: astore 37
    //   5539: iload 9
    //   5541: istore 11
    //   5543: lload 13
    //   5545: lstore 21
    //   5547: lload 15
    //   5549: lstore 19
    //   5551: lload 15
    //   5553: lstore 17
    //   5555: aload_0
    //   5556: aload 36
    //   5558: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5561: aload 34
    //   5563: astore 37
    //   5565: iload 9
    //   5567: istore 11
    //   5569: lload 13
    //   5571: lstore 21
    //   5573: lload 15
    //   5575: lstore 19
    //   5577: lload 15
    //   5579: lstore 17
    //   5581: aload_0
    //   5582: aload 39
    //   5584: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5587: aload 34
    //   5589: astore 37
    //   5591: iload 9
    //   5593: istore 11
    //   5595: lload 13
    //   5597: lstore 21
    //   5599: lload 15
    //   5601: lstore 19
    //   5603: lload 15
    //   5605: lstore 17
    //   5607: aload_0
    //   5608: aload 35
    //   5610: invokespecial 771	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5613: aload 34
    //   5615: astore 37
    //   5617: iload 9
    //   5619: istore 11
    //   5621: lload 13
    //   5623: lstore 21
    //   5625: lload 15
    //   5627: lstore 19
    //   5629: lload 15
    //   5631: lstore 17
    //   5633: aload 33
    //   5635: athrow
    //   5636: astore 34
    //   5638: aload 37
    //   5640: astore 33
    //   5642: lload 19
    //   5644: lstore 13
    //   5646: goto +39 -> 5685
    //   5649: astore 34
    //   5651: lload 15
    //   5653: lstore 13
    //   5655: iload 9
    //   5657: istore 11
    //   5659: lload 17
    //   5661: lstore 21
    //   5663: goto +22 -> 5685
    //   5666: astore 33
    //   5668: goto +784 -> 6452
    //   5671: astore 34
    //   5673: lload 23
    //   5675: lstore 13
    //   5677: lload 17
    //   5679: lstore 21
    //   5681: iload 9
    //   5683: istore 11
    //   5685: lload 13
    //   5687: lstore 17
    //   5689: aload 34
    //   5691: instanceof 1181
    //   5694: ifeq +127 -> 5821
    //   5697: iload_1
    //   5698: ifne +123 -> 5821
    //   5701: lload 13
    //   5703: lstore 17
    //   5705: aload_0
    //   5706: getfield 84	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   5709: ifnull +112 -> 5821
    //   5712: lload 13
    //   5714: lstore 17
    //   5716: aload_0
    //   5717: iconst_0
    //   5718: invokevirtual 1088	com/tencent/smtt/sdk/l:b	(Z)Z
    //   5721: ifeq +100 -> 5821
    //   5724: lload 13
    //   5726: lstore 17
    //   5728: new 113	java/lang/StringBuilder
    //   5731: dup
    //   5732: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   5735: astore 35
    //   5737: lload 13
    //   5739: lstore 17
    //   5741: aload 35
    //   5743: ldc_w 1183
    //   5746: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5749: pop
    //   5750: lload 13
    //   5752: lstore 17
    //   5754: aload 35
    //   5756: aload_0
    //   5757: getfield 654	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   5760: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5763: pop
    //   5764: lload 13
    //   5766: lstore 17
    //   5768: aload 35
    //   5770: ldc_w 1185
    //   5773: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5776: pop
    //   5777: lload 13
    //   5779: lstore 17
    //   5781: aload 35
    //   5783: aload 34
    //   5785: invokevirtual 406	java/lang/Throwable:toString	()Ljava/lang/String;
    //   5788: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5791: pop
    //   5792: lload 13
    //   5794: lstore 17
    //   5796: aload 33
    //   5798: aload 35
    //   5800: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5803: invokestatic 224	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5806: lload 13
    //   5808: lstore 17
    //   5810: aload_0
    //   5811: bipush 125
    //   5813: aconst_null
    //   5814: iconst_1
    //   5815: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5818: goto +556 -> 6374
    //   5821: lload 13
    //   5823: lstore 17
    //   5825: aload 34
    //   5827: invokevirtual 772	java/lang/Throwable:printStackTrace	()V
    //   5830: lload 13
    //   5832: lstore 17
    //   5834: aload_0
    //   5835: lconst_0
    //   5836: invokespecial 1074	com/tencent/smtt/sdk/l:a	(J)V
    //   5839: lload 13
    //   5841: lstore 17
    //   5843: aload_0
    //   5844: bipush 107
    //   5846: aload_0
    //   5847: aload 34
    //   5849: invokespecial 537	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5852: iconst_0
    //   5853: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5856: lload 13
    //   5858: lstore 17
    //   5860: aload_0
    //   5861: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   5864: ifeq +510 -> 6374
    //   5867: lload 13
    //   5869: lstore 17
    //   5871: aload_0
    //   5872: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5875: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5878: sipush -309
    //   5881: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5884: aload 33
    //   5886: astore 34
    //   5888: iload 11
    //   5890: istore 9
    //   5892: iload_1
    //   5893: ifne +10 -> 5903
    //   5896: iload 11
    //   5898: istore 9
    //   5900: goto -1053 -> 4847
    //   5903: aload_0
    //   5904: getfield 658	com/tencent/smtt/sdk/l:t	Z
    //   5907: ifne +462 -> 6369
    //   5910: aload_0
    //   5911: getfield 660	com/tencent/smtt/sdk/l:u	Z
    //   5914: ifeq +305 -> 6219
    //   5917: iload 9
    //   5919: istore_1
    //   5920: aload_0
    //   5921: getfield 84	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   5924: ifnonnull +101 -> 6025
    //   5927: iload 9
    //   5929: istore_1
    //   5930: iload 9
    //   5932: ifne +93 -> 6025
    //   5935: iload_2
    //   5936: ifeq +81 -> 6017
    //   5939: aload_0
    //   5940: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5943: invokestatic 602	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   5946: ifeq +71 -> 6017
    //   5949: aload_0
    //   5950: getfield 159	com/tencent/smtt/sdk/l:m	Ljava/io/File;
    //   5953: astore 33
    //   5955: new 113	java/lang/StringBuilder
    //   5958: dup
    //   5959: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   5962: astore 35
    //   5964: aload 35
    //   5966: iconst_0
    //   5967: invokestatic 238	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   5970: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5973: pop
    //   5974: aload 35
    //   5976: ldc_w 372
    //   5979: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5982: pop
    //   5983: aload 35
    //   5985: ldc_w 607
    //   5988: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5991: pop
    //   5992: aload_0
    //   5993: iconst_1
    //   5994: iload 12
    //   5996: new 149	java/io/File
    //   5999: dup
    //   6000: aload 33
    //   6002: aload 35
    //   6004: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6007: invokespecial 241	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   6010: invokespecial 555	com/tencent/smtt/sdk/l:a	(ZZLjava/io/File;)Z
    //   6013: istore_1
    //   6014: goto +11 -> 6025
    //   6017: aload_0
    //   6018: iconst_1
    //   6019: iload 12
    //   6021: invokespecial 938	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   6024: istore_1
    //   6025: aload_0
    //   6026: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6029: astore 33
    //   6031: iload_1
    //   6032: ifeq +9 -> 6041
    //   6035: iconst_1
    //   6036: istore 7
    //   6038: goto +6 -> 6044
    //   6041: iconst_0
    //   6042: istore 7
    //   6044: aload 33
    //   6046: iload 7
    //   6048: invokevirtual 1188	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   6051: new 113	java/lang/StringBuilder
    //   6054: dup
    //   6055: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   6058: astore 33
    //   6060: aload 33
    //   6062: ldc_w 1190
    //   6065: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6068: pop
    //   6069: aload 33
    //   6071: iload_1
    //   6072: invokevirtual 452	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6075: pop
    //   6076: aload 33
    //   6078: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6081: invokestatic 1191	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   6084: iload 12
    //   6086: ifne +25 -> 6111
    //   6089: aload_0
    //   6090: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6093: astore 33
    //   6095: iload_1
    //   6096: ifeq +9 -> 6105
    //   6099: iconst_1
    //   6100: istore 7
    //   6102: goto +18 -> 6120
    //   6105: iconst_2
    //   6106: istore 7
    //   6108: goto +12 -> 6120
    //   6111: aload_0
    //   6112: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6115: astore 33
    //   6117: iconst_0
    //   6118: istore 7
    //   6120: aload 33
    //   6122: iload 7
    //   6124: invokevirtual 1194	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6127: new 113	java/lang/StringBuilder
    //   6130: dup
    //   6131: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   6134: astore 33
    //   6136: aload 33
    //   6138: ldc_w 1196
    //   6141: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6144: pop
    //   6145: aload 33
    //   6147: iload_1
    //   6148: invokevirtual 452	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6151: pop
    //   6152: aload 34
    //   6154: aload 33
    //   6156: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6159: invokestatic 395	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6162: iload_1
    //   6163: ifeq +34 -> 6197
    //   6166: aload_0
    //   6167: iconst_1
    //   6168: invokespecial 932	com/tencent/smtt/sdk/l:d	(Z)V
    //   6171: aload_0
    //   6172: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6175: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6178: sipush -317
    //   6181: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6184: aload_0
    //   6185: bipush 100
    //   6187: ldc_w 1198
    //   6190: iconst_1
    //   6191: invokespecial 539	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   6194: goto +22 -> 6216
    //   6197: aload_0
    //   6198: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6201: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6204: sipush -318
    //   6207: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6210: aload_0
    //   6211: iconst_0
    //   6212: invokespecial 940	com/tencent/smtt/sdk/l:e	(Z)Z
    //   6215: pop
    //   6216: goto +6 -> 6222
    //   6219: iload 9
    //   6221: istore_1
    //   6222: aload_0
    //   6223: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6226: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6229: astore 33
    //   6231: iload_1
    //   6232: ifeq +43 -> 6275
    //   6235: aload 33
    //   6237: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6240: ldc_w 1200
    //   6243: iconst_0
    //   6244: invokeinterface 325 3 0
    //   6249: istore 7
    //   6251: aload 33
    //   6253: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6256: ldc_w 1200
    //   6259: iload 7
    //   6261: iconst_1
    //   6262: iadd
    //   6263: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6266: invokeinterface 576 3 0
    //   6271: pop
    //   6272: goto +66 -> 6338
    //   6275: aload 33
    //   6277: getfield 317	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6280: ldc_w 1202
    //   6283: iconst_0
    //   6284: invokeinterface 325 3 0
    //   6289: istore 7
    //   6291: aload 33
    //   6293: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6296: astore 34
    //   6298: iload 7
    //   6300: iconst_1
    //   6301: iadd
    //   6302: istore 7
    //   6304: aload 34
    //   6306: ldc_w 1202
    //   6309: iload 7
    //   6311: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6314: invokeinterface 576 3 0
    //   6319: pop
    //   6320: iload 7
    //   6322: aload 33
    //   6324: invokevirtual 1205	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6327: if_icmpne +11 -> 6338
    //   6330: aload_0
    //   6331: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6334: iconst_2
    //   6335: invokevirtual 1041	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6338: iconst_1
    //   6339: istore 7
    //   6341: aload 33
    //   6343: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6346: aload_0
    //   6347: getfield 106	com/tencent/smtt/sdk/l:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6350: astore 33
    //   6352: iload_1
    //   6353: ifeq +6 -> 6359
    //   6356: goto +6 -> 6362
    //   6359: iconst_0
    //   6360: istore 7
    //   6362: aload 33
    //   6364: iload 7
    //   6366: invokevirtual 1208	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   6369: aload_0
    //   6370: invokespecial 1210	com/tencent/smtt/sdk/l:h	()V
    //   6373: return
    //   6374: lload 13
    //   6376: lstore 17
    //   6378: aload_0
    //   6379: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6382: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6385: sipush -316
    //   6388: invokevirtual 930	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6391: iload_1
    //   6392: ifne +37 -> 6429
    //   6395: aload_0
    //   6396: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6399: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6402: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6405: ldc_w 991
    //   6408: lload 13
    //   6410: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6413: invokeinterface 576 3 0
    //   6418: pop
    //   6419: aload_0
    //   6420: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6423: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6426: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6429: aconst_null
    //   6430: astore 34
    //   6432: lload 21
    //   6434: lstore 17
    //   6436: lconst_0
    //   6437: lstore 19
    //   6439: iload 11
    //   6441: istore 9
    //   6443: goto -5867 -> 576
    //   6446: astore 33
    //   6448: lload 17
    //   6450: lstore 15
    //   6452: iload_1
    //   6453: ifne +37 -> 6490
    //   6456: aload_0
    //   6457: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6460: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6463: getfield 563	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6466: ldc_w 991
    //   6469: lload 15
    //   6471: invokestatic 1004	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6474: invokeinterface 576 3 0
    //   6479: pop
    //   6480: aload_0
    //   6481: getfield 94	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6484: invokestatic 313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6487: invokevirtual 583	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6490: goto +6 -> 6496
    //   6493: aload 33
    //   6495: athrow
    //   6496: goto -3 -> 6493
    //   6499: iconst_1
    //   6500: istore 7
    //   6502: goto -4709 -> 1793
    //   6505: iload 7
    //   6507: sipush 200
    //   6510: if_icmpeq -3740 -> 2770
    //   6513: iload 7
    //   6515: sipush 206
    //   6518: if_icmpne -4370 -> 2148
    //   6521: goto -3751 -> 2770
    //   6524: iload 7
    //   6526: sipush 403
    //   6529: if_icmpeq -4105 -> 2424
    //   6532: iload 7
    //   6534: sipush 406
    //   6537: if_icmpne -4070 -> 2467
    //   6540: goto -4116 -> 2424
    //   6543: iload_1
    //   6544: ifne +13 -> 6557
    //   6547: goto -4068 -> 2479
    //   6550: iload_1
    //   6551: ifne +6 -> 6557
    //   6554: goto -4075 -> 2479
    //   6557: lload 13
    //   6559: lstore 17
    //   6561: lload 15
    //   6563: lstore 13
    //   6565: aconst_null
    //   6566: astore 34
    //   6568: lconst_0
    //   6569: lstore 19
    //   6571: goto -5995 -> 576
    //   6574: astore 36
    //   6576: aload 33
    //   6578: astore 34
    //   6580: aconst_null
    //   6581: astore 33
    //   6583: aconst_null
    //   6584: astore 37
    //   6586: aload 35
    //   6588: astore 38
    //   6590: aload 37
    //   6592: astore 35
    //   6594: goto -1079 -> 5515
    //   6597: astore 37
    //   6599: aconst_null
    //   6600: astore 36
    //   6602: aconst_null
    //   6603: astore 34
    //   6605: aload 35
    //   6607: astore 38
    //   6609: aload 34
    //   6611: astore 35
    //   6613: iload 9
    //   6615: istore 10
    //   6617: goto -1688 -> 4929
    //   6620: astore 33
    //   6622: aload 37
    //   6624: astore 38
    //   6626: goto +93 -> 6719
    //   6629: lload 17
    //   6631: lstore 19
    //   6633: goto +3 -> 6636
    //   6636: lload 25
    //   6638: lstore 27
    //   6640: goto +3 -> 6643
    //   6643: aload 37
    //   6645: astore 33
    //   6647: lload 17
    //   6649: lstore 29
    //   6651: goto -3135 -> 3516
    //   6654: aload 33
    //   6656: astore 37
    //   6658: astore 33
    //   6660: lload 21
    //   6662: lstore 15
    //   6664: goto +14 -> 6678
    //   6667: astore 33
    //   6669: goto +46 -> 6715
    //   6672: astore 33
    //   6674: lload 23
    //   6676: lstore 15
    //   6678: aload 36
    //   6680: astore 38
    //   6682: aload 33
    //   6684: astore 36
    //   6686: aload 38
    //   6688: astore 33
    //   6690: aload 35
    //   6692: astore 38
    //   6694: aload 34
    //   6696: astore 35
    //   6698: aload 37
    //   6700: astore 34
    //   6702: goto -1187 -> 5515
    //   6705: astore 33
    //   6707: aload 38
    //   6709: astore 37
    //   6711: lload 25
    //   6713: lstore 15
    //   6715: aload 37
    //   6717: astore 38
    //   6719: aload 33
    //   6721: astore 37
    //   6723: aload 38
    //   6725: astore 33
    //   6727: goto -122 -> 6605
    //   6730: astore 36
    //   6732: goto +10 -> 6742
    //   6735: astore 36
    //   6737: goto +33 -> 6770
    //   6740: astore 36
    //   6742: aload 33
    //   6744: astore 37
    //   6746: aconst_null
    //   6747: astore 38
    //   6749: aload 36
    //   6751: astore 33
    //   6753: aload 38
    //   6755: astore 36
    //   6757: aload 34
    //   6759: astore 39
    //   6761: aload 37
    //   6763: astore 34
    //   6765: goto -1230 -> 5535
    //   6768: astore 36
    //   6770: aload 36
    //   6772: astore 37
    //   6774: aconst_null
    //   6775: astore 36
    //   6777: aload 35
    //   6779: astore 38
    //   6781: aload 34
    //   6783: astore 35
    //   6785: iload 9
    //   6787: istore 10
    //   6789: goto -1860 -> 4929
    //   6792: astore 34
    //   6794: goto -1901 -> 4893
    //   6797: astore 37
    //   6799: aload 35
    //   6801: astore 38
    //   6803: goto -1884 -> 4919
    //   6806: aconst_null
    //   6807: astore 39
    //   6809: aconst_null
    //   6810: astore 40
    //   6812: aload 33
    //   6814: astore 38
    //   6816: iload 9
    //   6818: istore 10
    //   6820: lload 13
    //   6822: lstore 25
    //   6824: lload 15
    //   6826: lstore 23
    //   6828: goto -2143 -> 4685
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6831	0	this	l
    //   0	6831	1	paramBoolean1	boolean
    //   0	6831	2	paramBoolean2	boolean
    //   4330	32	3	d1	double
    //   4348	15	5	d2	double
    //   54	6484	7	i1	int
    //   1868	7	8	i2	int
    //   574	6243	9	bool1	boolean
    //   1191	5628	10	bool2	boolean
    //   2373	4067	11	bool3	boolean
    //   78	6007	12	bool4	boolean
    //   548	6273	13	l1	long
    //   631	6194	15	l2	long
    //   520	6128	17	l3	long
    //   535	6097	19	l4	long
    //   639	6022	21	l5	long
    //   643	6184	23	l6	long
    //   3497	3326	25	l7	long
    //   3502	3137	27	l8	long
    //   3510	3140	29	l9	long
    //   627	3578	31	l10	long
    //   120	862	33	localObject1	Object
    //   1038	2556	33	str1	String
    //   3603	249	33	localObject2	Object
    //   3951	1	33	localObject3	Object
    //   3956	1	33	localIOException1	IOException
    //   3965	1676	33	localObject4	Object
    //   5666	219	33	str2	String
    //   5953	410	33	localObject5	Object
    //   6446	131	33	localObject6	Object
    //   6581	1	33	localObject7	Object
    //   6620	1	33	localIOException2	IOException
    //   6645	10	33	localObject8	Object
    //   6658	1	33	localObject9	Object
    //   6667	1	33	localIOException3	IOException
    //   6672	11	33	localObject10	Object
    //   6688	1	33	localObject11	Object
    //   6705	15	33	localIOException4	IOException
    //   6725	88	33	localObject12	Object
    //   123	2243	34	localObject13	Object
    //   2370	1	34	localThrowable1	Throwable
    //   2792	2092	34	localObject14	Object
    //   4888	16	34	localObject15	Object
    //   4909	705	34	localObject16	Object
    //   5636	1	34	localThrowable2	Throwable
    //   5649	1	34	localThrowable3	Throwable
    //   5671	177	34	localThrowable4	Throwable
    //   5886	896	34	localObject17	Object
    //   6792	1	34	localObject18	Object
    //   159	6641	35	localObject19	Object
    //   192	3187	36	localObject20	Object
    //   3383	1	36	localObject21	Object
    //   3388	1	36	localIOException5	IOException
    //   3393	1	36	localObject22	Object
    //   3398	3	36	localIOException6	IOException
    //   3421	2136	36	localObject23	Object
    //   6574	1	36	localObject24	Object
    //   6600	85	36	localObject25	Object
    //   6730	1	36	localObject26	Object
    //   6735	1	36	localIOException7	IOException
    //   6740	10	36	localObject27	Object
    //   6755	1	36	localObject28	Object
    //   6768	3	36	localIOException8	IOException
    //   6775	1	36	localObject29	Object
    //   3312	302	37	localObject30	Object
    //   3624	1	37	localIOException9	IOException
    //   3635	345	37	localObject31	Object
    //   3986	40	37	localIOException10	IOException
    //   4049	89	37	localStringBuilder	StringBuilder
    //   4174	1	37	localIOException11	IOException
    //   4185	723	37	localObject32	Object
    //   4914	29	37	localIOException12	IOException
    //   5046	335	37	localObject33	Object
    //   5497	15	37	localObject34	Object
    //   5517	1074	37	localObject35	Object
    //   6597	47	37	localIOException13	IOException
    //   6656	117	37	localObject36	Object
    //   6797	1	37	localIOException14	IOException
    //   3493	434	38	localObject37	Object
    //   3961	7	38	localObject38	Object
    //   3973	2842	38	localObject39	Object
    //   1248	1	39	str3	String
    //   3587	692	39	str4	String
    //   4557	2251	39	localObject40	Object
    //   3283	3528	40	localObject41	Object
    // Exception table:
    //   from	to	target	type
    //   645	675	1038	finally
    //   683	691	1038	finally
    //   699	723	1038	finally
    //   731	755	1038	finally
    //   763	773	1038	finally
    //   784	793	1038	finally
    //   801	810	1038	finally
    //   818	826	1038	finally
    //   834	844	1038	finally
    //   864	873	1038	finally
    //   881	889	1038	finally
    //   897	910	1038	finally
    //   963	973	1038	finally
    //   981	990	1038	finally
    //   998	1006	1038	finally
    //   1014	1027	1038	finally
    //   1079	1085	1038	finally
    //   1206	1215	1038	finally
    //   1263	1269	1038	finally
    //   1277	1286	1038	finally
    //   1294	1303	1038	finally
    //   1311	1319	1038	finally
    //   1327	1337	1038	finally
    //   1345	1354	1038	finally
    //   1362	1371	1038	finally
    //   1379	1388	1038	finally
    //   1396	1404	1038	finally
    //   1412	1423	1038	finally
    //   1431	1437	1038	finally
    //   1445	1454	1038	finally
    //   1458	1467	1038	finally
    //   1471	1479	1038	finally
    //   1483	1492	1038	finally
    //   1496	1509	1038	finally
    //   1516	1525	1038	finally
    //   1529	1538	1038	finally
    //   1542	1550	1038	finally
    //   1554	1563	1038	finally
    //   1567	1577	1038	finally
    //   1581	1592	1038	finally
    //   1596	1605	1038	finally
    //   1609	1618	1038	finally
    //   1622	1630	1038	finally
    //   1634	1643	1038	finally
    //   1647	1657	1038	finally
    //   1661	1672	1038	finally
    //   1676	1682	1038	finally
    //   1686	1695	1038	finally
    //   1699	1708	1038	finally
    //   1712	1720	1038	finally
    //   1724	1733	1038	finally
    //   1737	1747	1038	finally
    //   1751	1764	1038	finally
    //   1833	1841	1038	finally
    //   1845	1851	1038	finally
    //   1855	1861	1038	finally
    //   1881	1892	1038	finally
    //   1939	1953	1038	finally
    //   2015	2025	1038	finally
    //   2029	2040	1038	finally
    //   2044	2054	1038	finally
    //   2058	2064	1038	finally
    //   2068	2072	1038	finally
    //   2076	2082	1038	finally
    //   2086	2096	1038	finally
    //   2100	2109	1038	finally
    //   2124	2137	1038	finally
    //   2168	2180	1038	finally
    //   2184	2192	1038	finally
    //   2196	2202	1038	finally
    //   2206	2216	1038	finally
    //   2227	2235	1038	finally
    //   2239	2252	1038	finally
    //   2267	2279	1038	finally
    //   2291	2300	1038	finally
    //   2309	2322	1038	finally
    //   2390	2396	1038	finally
    //   2400	2413	1038	finally
    //   2428	2439	1038	finally
    //   2443	2456	1038	finally
    //   2520	2531	1038	finally
    //   2543	2560	1038	finally
    //   2564	2571	1038	finally
    //   2575	2588	1038	finally
    //   2603	2614	1038	finally
    //   2650	2655	1038	finally
    //   2659	2666	1038	finally
    //   2670	2683	1038	finally
    //   2698	2707	1038	finally
    //   2711	2718	1038	finally
    //   2730	2735	1038	finally
    //   2746	2759	1038	finally
    //   2866	2876	1038	finally
    //   2880	2889	1038	finally
    //   2893	2902	1038	finally
    //   2906	2914	1038	finally
    //   2918	2927	1038	finally
    //   2931	2941	1038	finally
    //   2945	2956	1038	finally
    //   2964	2971	1038	finally
    //   2975	2981	1038	finally
    //   2985	2995	1038	finally
    //   2999	3006	1038	finally
    //   3010	3018	1038	finally
    //   3029	3038	1038	finally
    //   3042	3051	1038	finally
    //   3055	3063	1038	finally
    //   3067	3076	1038	finally
    //   3080	3090	1038	finally
    //   3094	3106	1038	finally
    //   3110	3123	1038	finally
    //   3130	3140	1038	finally
    //   3144	3157	1038	finally
    //   2309	2322	2370	java/lang/Throwable
    //   3305	3358	3383	finally
    //   3362	3376	3383	finally
    //   3305	3358	3388	java/io/IOException
    //   3362	3376	3388	java/io/IOException
    //   3289	3305	3393	finally
    //   3289	3305	3398	java/io/IOException
    //   3551	3560	3587	finally
    //   3568	3581	3587	finally
    //   3675	3682	3587	finally
    //   3690	3700	3587	finally
    //   3712	3720	3587	finally
    //   3734	3739	3587	finally
    //   3753	3758	3587	finally
    //   3766	3773	3587	finally
    //   3784	3797	3587	finally
    //   3551	3560	3624	java/io/IOException
    //   3568	3581	3624	java/io/IOException
    //   3675	3682	3624	java/io/IOException
    //   3690	3700	3624	java/io/IOException
    //   3712	3720	3624	java/io/IOException
    //   3734	3739	3624	java/io/IOException
    //   3753	3758	3624	java/io/IOException
    //   3766	3773	3624	java/io/IOException
    //   3784	3797	3624	java/io/IOException
    //   3915	3948	3951	finally
    //   3915	3948	3956	java/io/IOException
    //   3871	3915	3961	finally
    //   3871	3915	3986	java/io/IOException
    //   4007	4017	4174	java/io/IOException
    //   4025	4034	4174	java/io/IOException
    //   4042	4051	4174	java/io/IOException
    //   4059	4068	4174	java/io/IOException
    //   4076	4085	4174	java/io/IOException
    //   4093	4102	4174	java/io/IOException
    //   4110	4126	4174	java/io/IOException
    //   4134	4146	4174	java/io/IOException
    //   4154	4167	4174	java/io/IOException
    //   4339	4345	4174	java/io/IOException
    //   4380	4390	4174	java/io/IOException
    //   4450	4459	4174	java/io/IOException
    //   4504	4514	4174	java/io/IOException
    //   3183	3192	4888	finally
    //   3183	3192	4914	java/io/IOException
    //   4929	4950	5497	finally
    //   4957	5044	5497	finally
    //   5145	5157	5497	finally
    //   5161	5169	5497	finally
    //   5169	5178	5497	finally
    //   5185	5193	5497	finally
    //   5301	5326	5497	finally
    //   4604	4610	5636	java/lang/Throwable
    //   4630	4636	5636	java/lang/Throwable
    //   4656	4662	5636	java/lang/Throwable
    //   4705	4711	5636	java/lang/Throwable
    //   4731	4737	5636	java/lang/Throwable
    //   4757	4763	5636	java/lang/Throwable
    //   4783	4790	5636	java/lang/Throwable
    //   4810	4823	5636	java/lang/Throwable
    //   5064	5070	5636	java/lang/Throwable
    //   5090	5096	5636	java/lang/Throwable
    //   5116	5122	5636	java/lang/Throwable
    //   5216	5222	5636	java/lang/Throwable
    //   5242	5248	5636	java/lang/Throwable
    //   5268	5274	5636	java/lang/Throwable
    //   5346	5352	5636	java/lang/Throwable
    //   5372	5378	5636	java/lang/Throwable
    //   5398	5404	5636	java/lang/Throwable
    //   5555	5561	5636	java/lang/Throwable
    //   5581	5587	5636	java/lang/Throwable
    //   5607	5613	5636	java/lang/Throwable
    //   5633	5636	5636	java/lang/Throwable
    //   1458	1467	5649	java/lang/Throwable
    //   1471	1479	5649	java/lang/Throwable
    //   1483	1492	5649	java/lang/Throwable
    //   1496	1509	5649	java/lang/Throwable
    //   1516	1525	5649	java/lang/Throwable
    //   1529	1538	5649	java/lang/Throwable
    //   1542	1550	5649	java/lang/Throwable
    //   1554	1563	5649	java/lang/Throwable
    //   1567	1577	5649	java/lang/Throwable
    //   1581	1592	5649	java/lang/Throwable
    //   1596	1605	5649	java/lang/Throwable
    //   1609	1618	5649	java/lang/Throwable
    //   1622	1630	5649	java/lang/Throwable
    //   1634	1643	5649	java/lang/Throwable
    //   1647	1657	5649	java/lang/Throwable
    //   1661	1672	5649	java/lang/Throwable
    //   1676	1682	5649	java/lang/Throwable
    //   1686	1695	5649	java/lang/Throwable
    //   1699	1708	5649	java/lang/Throwable
    //   1712	1720	5649	java/lang/Throwable
    //   1724	1733	5649	java/lang/Throwable
    //   1737	1747	5649	java/lang/Throwable
    //   1751	1764	5649	java/lang/Throwable
    //   1774	1780	5649	java/lang/Throwable
    //   1793	1824	5649	java/lang/Throwable
    //   1833	1841	5649	java/lang/Throwable
    //   1845	1851	5649	java/lang/Throwable
    //   1855	1861	5649	java/lang/Throwable
    //   1864	1870	5649	java/lang/Throwable
    //   1881	1892	5649	java/lang/Throwable
    //   1903	1923	5649	java/lang/Throwable
    //   1923	1929	5649	java/lang/Throwable
    //   1939	1953	5649	java/lang/Throwable
    //   1953	2007	5649	java/lang/Throwable
    //   2015	2025	5649	java/lang/Throwable
    //   2029	2040	5649	java/lang/Throwable
    //   2044	2054	5649	java/lang/Throwable
    //   2058	2064	5649	java/lang/Throwable
    //   2068	2072	5649	java/lang/Throwable
    //   2076	2082	5649	java/lang/Throwable
    //   2086	2096	5649	java/lang/Throwable
    //   2100	2109	5649	java/lang/Throwable
    //   2109	2115	5649	java/lang/Throwable
    //   2124	2137	5649	java/lang/Throwable
    //   2168	2180	5649	java/lang/Throwable
    //   2184	2192	5649	java/lang/Throwable
    //   2196	2202	5649	java/lang/Throwable
    //   2206	2216	5649	java/lang/Throwable
    //   2227	2235	5649	java/lang/Throwable
    //   2239	2252	5649	java/lang/Throwable
    //   2267	2279	5649	java/lang/Throwable
    //   2291	2300	5649	java/lang/Throwable
    //   2390	2396	5649	java/lang/Throwable
    //   2400	2413	5649	java/lang/Throwable
    //   2428	2439	5649	java/lang/Throwable
    //   2443	2456	5649	java/lang/Throwable
    //   2520	2531	5649	java/lang/Throwable
    //   2543	2560	5649	java/lang/Throwable
    //   2564	2571	5649	java/lang/Throwable
    //   2575	2588	5649	java/lang/Throwable
    //   2603	2614	5649	java/lang/Throwable
    //   2650	2655	5649	java/lang/Throwable
    //   2659	2666	5649	java/lang/Throwable
    //   2670	2683	5649	java/lang/Throwable
    //   2698	2707	5649	java/lang/Throwable
    //   2711	2718	5649	java/lang/Throwable
    //   2730	2735	5649	java/lang/Throwable
    //   2746	2759	5649	java/lang/Throwable
    //   2770	2855	5649	java/lang/Throwable
    //   2866	2876	5649	java/lang/Throwable
    //   2880	2889	5649	java/lang/Throwable
    //   2893	2902	5649	java/lang/Throwable
    //   2906	2914	5649	java/lang/Throwable
    //   2918	2927	5649	java/lang/Throwable
    //   2931	2941	5649	java/lang/Throwable
    //   2945	2956	5649	java/lang/Throwable
    //   2964	2971	5649	java/lang/Throwable
    //   2975	2981	5649	java/lang/Throwable
    //   2985	2995	5649	java/lang/Throwable
    //   2999	3006	5649	java/lang/Throwable
    //   3010	3018	5649	java/lang/Throwable
    //   3029	3038	5649	java/lang/Throwable
    //   3042	3051	5649	java/lang/Throwable
    //   3055	3063	5649	java/lang/Throwable
    //   3067	3076	5649	java/lang/Throwable
    //   3080	3090	5649	java/lang/Throwable
    //   3094	3106	5649	java/lang/Throwable
    //   3110	3123	5649	java/lang/Throwable
    //   3130	3140	5649	java/lang/Throwable
    //   3144	3157	5649	java/lang/Throwable
    //   3175	3183	5649	java/lang/Throwable
    //   1051	1056	5666	finally
    //   1060	1066	5666	finally
    //   1092	1098	5666	finally
    //   1102	1111	5666	finally
    //   1115	1124	5666	finally
    //   1128	1136	5666	finally
    //   1140	1149	5666	finally
    //   1153	1163	5666	finally
    //   1167	1178	5666	finally
    //   1182	1193	5666	finally
    //   1219	1225	5666	finally
    //   1229	1235	5666	finally
    //   1239	1245	5666	finally
    //   1774	1780	5666	finally
    //   1793	1824	5666	finally
    //   1864	1870	5666	finally
    //   1903	1923	5666	finally
    //   1923	1929	5666	finally
    //   1953	2007	5666	finally
    //   2109	2115	5666	finally
    //   2770	2855	5666	finally
    //   3175	3183	5666	finally
    //   645	675	5671	java/lang/Throwable
    //   683	691	5671	java/lang/Throwable
    //   699	723	5671	java/lang/Throwable
    //   731	755	5671	java/lang/Throwable
    //   763	773	5671	java/lang/Throwable
    //   784	793	5671	java/lang/Throwable
    //   801	810	5671	java/lang/Throwable
    //   818	826	5671	java/lang/Throwable
    //   834	844	5671	java/lang/Throwable
    //   864	873	5671	java/lang/Throwable
    //   881	889	5671	java/lang/Throwable
    //   897	910	5671	java/lang/Throwable
    //   963	973	5671	java/lang/Throwable
    //   981	990	5671	java/lang/Throwable
    //   998	1006	5671	java/lang/Throwable
    //   1014	1027	5671	java/lang/Throwable
    //   1051	1056	5671	java/lang/Throwable
    //   1060	1066	5671	java/lang/Throwable
    //   1079	1085	5671	java/lang/Throwable
    //   1092	1098	5671	java/lang/Throwable
    //   1102	1111	5671	java/lang/Throwable
    //   1115	1124	5671	java/lang/Throwable
    //   1128	1136	5671	java/lang/Throwable
    //   1140	1149	5671	java/lang/Throwable
    //   1153	1163	5671	java/lang/Throwable
    //   1167	1178	5671	java/lang/Throwable
    //   1182	1193	5671	java/lang/Throwable
    //   1206	1215	5671	java/lang/Throwable
    //   1219	1225	5671	java/lang/Throwable
    //   1229	1235	5671	java/lang/Throwable
    //   1239	1245	5671	java/lang/Throwable
    //   1263	1269	5671	java/lang/Throwable
    //   1277	1286	5671	java/lang/Throwable
    //   1294	1303	5671	java/lang/Throwable
    //   1311	1319	5671	java/lang/Throwable
    //   1327	1337	5671	java/lang/Throwable
    //   1345	1354	5671	java/lang/Throwable
    //   1362	1371	5671	java/lang/Throwable
    //   1379	1388	5671	java/lang/Throwable
    //   1396	1404	5671	java/lang/Throwable
    //   1412	1423	5671	java/lang/Throwable
    //   1431	1437	5671	java/lang/Throwable
    //   1445	1454	5671	java/lang/Throwable
    //   4604	4610	6446	finally
    //   4630	4636	6446	finally
    //   4656	4662	6446	finally
    //   4705	4711	6446	finally
    //   4731	4737	6446	finally
    //   4757	4763	6446	finally
    //   4783	4790	6446	finally
    //   4810	4823	6446	finally
    //   5064	5070	6446	finally
    //   5090	5096	6446	finally
    //   5116	5122	6446	finally
    //   5216	5222	6446	finally
    //   5242	5248	6446	finally
    //   5268	5274	6446	finally
    //   5346	5352	6446	finally
    //   5372	5378	6446	finally
    //   5398	5404	6446	finally
    //   5555	5561	6446	finally
    //   5581	5587	6446	finally
    //   5607	5613	6446	finally
    //   5633	5636	6446	finally
    //   5689	5697	6446	finally
    //   5705	5712	6446	finally
    //   5716	5724	6446	finally
    //   5728	5737	6446	finally
    //   5741	5750	6446	finally
    //   5754	5764	6446	finally
    //   5768	5777	6446	finally
    //   5781	5792	6446	finally
    //   5796	5806	6446	finally
    //   5810	5818	6446	finally
    //   5825	5830	6446	finally
    //   5834	5839	6446	finally
    //   5843	5856	6446	finally
    //   5860	5867	6446	finally
    //   5871	5884	6446	finally
    //   6378	6391	6446	finally
    //   3211	3233	6574	finally
    //   3241	3271	6574	finally
    //   3211	3233	6597	java/io/IOException
    //   3241	3271	6597	java/io/IOException
    //   4544	4552	6620	java/io/IOException
    //   4007	4017	6654	finally
    //   4025	4034	6654	finally
    //   4042	4051	6654	finally
    //   4059	4068	6654	finally
    //   4076	4085	6654	finally
    //   4093	4102	6654	finally
    //   4110	4126	6654	finally
    //   4134	4146	6654	finally
    //   4154	4167	6654	finally
    //   4196	4206	6654	finally
    //   4210	4215	6654	finally
    //   4238	4247	6654	finally
    //   4251	4260	6654	finally
    //   4264	4272	6654	finally
    //   4276	4284	6654	finally
    //   4288	4298	6654	finally
    //   4302	4313	6654	finally
    //   4317	4322	6654	finally
    //   4339	4345	6654	finally
    //   4380	4390	6654	finally
    //   4413	4423	6654	finally
    //   4427	4436	6654	finally
    //   4450	4459	6654	finally
    //   4468	4474	6654	finally
    //   4478	4482	6654	finally
    //   4486	4491	6654	finally
    //   4504	4514	6654	finally
    //   4518	4527	6654	finally
    //   4531	4540	6654	finally
    //   4544	4552	6654	finally
    //   4196	4206	6667	java/io/IOException
    //   4210	4215	6667	java/io/IOException
    //   4238	4247	6667	java/io/IOException
    //   4251	4260	6667	java/io/IOException
    //   4264	4272	6667	java/io/IOException
    //   4276	4284	6667	java/io/IOException
    //   4288	4298	6667	java/io/IOException
    //   4302	4313	6667	java/io/IOException
    //   4317	4322	6667	java/io/IOException
    //   4413	4423	6667	java/io/IOException
    //   4427	4436	6667	java/io/IOException
    //   4468	4474	6667	java/io/IOException
    //   4478	4482	6667	java/io/IOException
    //   4486	4491	6667	java/io/IOException
    //   4518	4527	6667	java/io/IOException
    //   4531	4540	6667	java/io/IOException
    //   3499	3504	6672	finally
    //   3532	3538	6672	finally
    //   3649	3662	6672	finally
    //   3816	3826	6672	finally
    //   3842	3847	6672	finally
    //   3499	3504	6705	java/io/IOException
    //   3532	3538	6705	java/io/IOException
    //   3649	3662	6705	java/io/IOException
    //   3816	3826	6705	java/io/IOException
    //   3842	3847	6705	java/io/IOException
    //   3407	3423	6730	finally
    //   3431	3483	6730	finally
    //   3407	3423	6735	java/io/IOException
    //   3431	3483	6735	java/io/IOException
    //   3278	3285	6740	finally
    //   3278	3285	6768	java/io/IOException
    //   3197	3206	6792	finally
    //   3197	3206	6797	java/io/IOException
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!o()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.h)))) {
      return false;
    }
    String[] arrayOfString = this.b;
    if (arrayOfString != null)
    {
      int i1 = this.c;
      if ((i1 >= 0) && (i1 < arrayOfString.length))
      {
        this.c = (i1 + 1);
        this.k = arrayOfString[i1];
        this.r = 0;
        this.s = 0;
        this.n = -1L;
        this.q = false;
        this.t = false;
        this.u = false;
        this.A = false;
        return true;
      }
    }
    return false;
  }
  
  public int c(boolean paramBoolean)
  {
    File localFile = a(this.h);
    if (paramBoolean)
    {
      if (localFile == null) {
        return 0;
      }
      return a.a(this.h, new File(localFile, TbsDownloader.getBackupFileName(true)));
    }
    if (localFile == null) {
      return 0;
    }
    Context localContext = this.h;
    String str;
    if (TbsDownloader.getOverSea(localContext)) {
      str = "x5.oversea.tbs.org";
    } else {
      str = TbsDownloader.getBackupFileName(false);
    }
    return a.a(localContext, new File(localFile, str));
  }
  
  public void c()
  {
    b();
    e(false);
    e(true);
  }
  
  public boolean d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=");
    localStringBuilder.append(this.E);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    return this.E;
  }
  
  void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseDownload,isPause=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("isDownloading=");
    localStringBuilder.append(TbsDownloader.isDownloading());
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if ((!this.d) && (TbsDownloader.isDownloading()))
    {
      b();
      this.d = true;
      this.A = false;
    }
  }
  
  void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeDownload,isPause=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("isDownloading=");
    localStringBuilder.append(TbsDownloader.isDownloading());
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if ((this.d) && (TbsDownloader.isDownloading()))
    {
      this.d = false;
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */