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
  private Handler A;
  private Set<String> B;
  private int C = e;
  private boolean D;
  String a;
  String[] b = null;
  int c = 0;
  private boolean d = false;
  private Context h;
  private String i;
  private String j;
  private String k;
  private File l;
  private long m;
  private int n = 30000;
  private int o = 20000;
  private boolean p;
  private int q;
  private int r;
  private boolean s;
  private boolean t;
  private HttpURLConnection u;
  private String v;
  private TbsLogReport.TbsLogInfo w;
  private String x;
  private int y;
  private boolean z;
  
  public l(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    this.w = TbsLogReport.getInstance(this.h).tbsLogInfo();
    this.B = new HashSet();
    paramContext = new StringBuilder();
    paramContext.append("tbs_downloading_");
    paramContext.append(this.h.getPackageName());
    this.v = paramContext.toString();
    p.a();
    this.l = p.s(this.h);
    if (this.l != null)
    {
      g();
      this.x = null;
      this.y = -1;
      return;
    }
    throw new NullPointerException("TbsCorePrivateDir is null!");
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.w.setDownConsumeTime(l1 - paramLong1);
    this.w.setDownloadSize(paramLong2);
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
    if ((paramBoolean) || (this.q > this.C))
    {
      this.w.setErrorCode(paramInt);
      this.w.setFailDetail(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.q += 1;
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
    HttpURLConnection localHttpURLConnection = this.u;
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
    this.u = ((HttpURLConnection)paramString.openConnection());
    this.u.setRequestProperty("User-Agent", TbsDownloader.b(this.h));
    this.u.setRequestProperty("Accept-Encoding", "identity");
    this.u.setRequestMethod("GET");
    this.u.setInstanceFollowRedirects(false);
    this.u.setConnectTimeout(this.o);
    this.u.setReadTimeout(this.n);
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
        Object localObject1 = p.s(paramContext);
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
    ((StringBuilder)localObject1).append(paramBoolean1);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    Object localObject2 = this.l;
    if (!paramBoolean1) {
      localObject1 = "x5.tbs";
    } else {
      localObject1 = "x5.tbs.temp";
    }
    localObject2 = new File((File)localObject2, (String)localObject1);
    if (!((File)localObject2).exists()) {
      return false;
    }
    Object localObject3 = TbsDownloadConfig.getInstance(this.h).mPreferences;
    localObject1 = null;
    Object localObject4 = ((SharedPreferences)localObject3).getString("tbs_apk_md5", null);
    localObject3 = a.a((File)localObject2);
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
        if (((File)localObject2).exists())
        {
          l2 = l1;
          if (l3 > 0L)
          {
            l1 = ((File)localObject2).length();
            l2 = l1;
            if (l3 != l1) {
              l2 = l1;
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
          ((StringBuilder)localObject1).append(paramBoolean1);
          ((StringBuilder)localObject1).append(" filelength failed");
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
          localObject1 = this.w;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("fileLength:");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(",contentLength:");
          ((StringBuilder)localObject2).append(l3);
          ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(((StringBuilder)localObject2).toString());
          return false;
        }
      }
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
          i2 = a.a(this.h, (File)localObject2);
          int i3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
          i1 = i2;
          if (i3 != i2)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
            ((StringBuilder)localObject1).append(paramBoolean1);
            ((StringBuilder)localObject1).append(" versionCode failed");
            TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
            if (paramBoolean1)
            {
              localObject1 = this.w;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("fileVersion:");
              ((StringBuilder)localObject2).append(i2);
              ((StringBuilder)localObject2).append(",configVersion:");
              ((StringBuilder)localObject2).append(i3);
              ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(((StringBuilder)localObject2).toString());
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
        localObject3 = b.a(this.h, false, (File)localObject2);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject3))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
          ((StringBuilder)localObject1).append(paramBoolean1);
          ((StringBuilder)localObject1).append(" signature failed");
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
          if (paramBoolean1)
          {
            localObject2 = this.w;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("signature:");
            if (localObject3 == null) {
              localObject1 = "null";
            } else {
              localObject1 = Integer.valueOf(((String)localObject3).length());
            }
            ((StringBuilder)localObject4).append(localObject1);
            ((TbsLogReport.TbsLogInfo)localObject2).setCheckErrorDetail(((StringBuilder)localObject4).toString());
          }
          return false;
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if (paramBoolean1)
      {
        try
        {
          paramBoolean1 = ((File)localObject2).renameTo(new File(this.l, "x5.tbs"));
        }
        catch (Exception localException)
        {
          paramBoolean1 = false;
        }
        paramBoolean2 = paramBoolean1;
        if (!paramBoolean1)
        {
          a(109, a(localException), true);
          return false;
        }
      }
      else
      {
        paramBoolean2 = false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsApkDownloader.verifyTbsApk] rename(");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(") successful!");
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsApkDownloader.verifyTbsApk] isTempFile=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" md5 failed");
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (paramBoolean1) {
      this.w.setCheckErrorDetail("fileMd5 not match");
    }
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    com.tencent.smtt.utils.p.a(this.h);
    Object localObject1 = TbsDownloadConfig.getInstance(this.h);
    Object localObject2 = ((TbsDownloadConfig)localObject1).mSyncMap;
    Boolean localBoolean = Boolean.valueOf(false);
    ((Map)localObject2).put("request_full_package", localBoolean);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", localBoolean);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject1).commit();
    localObject2 = QbSdk.m;
    if (paramBoolean) {
      i1 = 100;
    } else {
      i1 = 120;
    }
    ((TbsListener)localObject2).onDownloadFinish(i1);
    int i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_responsecode", 0);
    paramBoolean = TbsDownloader.a(this.h);
    if (i1 == 5)
    {
      localObject2 = a(i1, paramBoolean);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return;
      }
    }
    for (;;)
    {
      p.a().b(this.h, (Bundle)localObject1);
      return;
      if ((i1 != 3) && (i1 <= 10000))
      {
        i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
        p.a().a(this.h, new File(this.l, "x5.tbs").getAbsolutePath(), i1);
        a(new File(this.l, "x5.tbs"), this.h);
        return;
      }
      localObject2 = a(this.h);
      if (localObject2 == null) {
        break;
      }
      localObject1 = a(i1, (File)localObject2, paramBoolean);
    }
    c();
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
    ((TbsDownloadConfig)localObject1).commit();
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
    this.q = 0;
    this.r = 0;
    this.m = -1L;
    this.k = null;
    this.p = false;
    this.s = false;
    this.t = false;
    this.z = false;
  }
  
  private void h()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    HttpURLConnection localHttpURLConnection = this.u;
    Object localObject2;
    if (localHttpURLConnection != null)
    {
      if (!this.s) {
        this.w.setResolveIp(a(localHttpURLConnection.getURL()));
      }
      try
      {
        this.u.disconnect();
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[closeHttpRequest] mHttpRequest.disconnect() Throwable:");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
      }
      this.u = null;
    }
    int i1 = this.w.a;
    if ((!this.s) && (this.z))
    {
      this.w.setEventTime(System.currentTimeMillis());
      localObject2 = Apn.getApnInfo(this.h);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int i2 = Apn.getApnType(this.h);
      this.w.setApn((String)localObject1);
      this.w.setNetworkType(i2);
      if ((i2 != this.y) || (!((String)localObject1).equals(this.x))) {
        this.w.setNetworkChange(0);
      }
      if (((this.w.a == 0) || (this.w.a == 107)) && (this.w.getDownFinalFlag() == 0))
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
      ((TbsLogReport)localObject1).eventReport((TbsLogReport.EventType)localObject2, this.w);
      this.w.resetArgs();
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
    //   0: invokestatic 691	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 6
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: aconst_null
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 8
    //   17: new 110	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   24: astore 7
    //   26: aload 7
    //   28: ldc_w 693
    //   31: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: ldc_w 695
    //   40: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 6
    //   46: aload 7
    //   48: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 699	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   54: invokevirtual 705	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   57: astore 6
    //   59: new 707	java/io/InputStreamReader
    //   62: dup
    //   63: aload 6
    //   65: invokespecial 710	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: astore 7
    //   70: new 712	java/io/BufferedReader
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 715	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore 10
    //   81: iconst_0
    //   82: istore_1
    //   83: aload 10
    //   85: invokevirtual 718	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   88: astore 8
    //   90: iload 4
    //   92: istore_3
    //   93: aload 8
    //   95: ifnull +49 -> 144
    //   98: aload 8
    //   100: ldc_w 720
    //   103: invokevirtual 326	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   106: ifne +36 -> 142
    //   109: aload 8
    //   111: ldc_w 722
    //   114: invokevirtual 326	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   147: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
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
    //   270: invokevirtual 725	java/lang/Throwable:printStackTrace	()V
    //   273: aload_0
    //   274: aload 8
    //   276: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   279: iload 5
    //   281: istore_3
    //   282: aload_0
    //   283: aload 7
    //   285: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   288: aload_0
    //   289: aload 6
    //   291: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
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
    //   325: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   328: aload_0
    //   329: aload 10
    //   331: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   334: aload_0
    //   335: aload 8
    //   337: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
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
    int i1 = this.q;
    if ((i1 != 1) && (i1 != 2))
    {
      if ((i1 != 3) && (i1 != 4)) {
        return 200000L;
      }
      return 100000L;
    }
    return this.q * 20000L;
  }
  
  /* Error */
  private boolean o()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4: invokestatic 642	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
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
    //   28: new 110	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: ldc_w 733
    //   42: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 6
    //   48: iload_2
    //   49: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 203
    //   55: aload 6
    //   57: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aconst_null
    //   64: astore 8
    //   66: aconst_null
    //   67: astore 6
    //   69: iload_2
    //   70: ifeq +271 -> 341
    //   73: aload_0
    //   74: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   77: invokestatic 736	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   80: astore 9
    //   82: new 110	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   89: astore 7
    //   91: aload 7
    //   93: ldc_w 738
    //   96: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 7
    //   102: aload 9
    //   104: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 203
    //   110: aload 7
    //   112: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: new 244	java/net/URL
    //   121: dup
    //   122: ldc_w 740
    //   125: invokespecial 384	java/net/URL:<init>	(Ljava/lang/String;)V
    //   128: invokevirtual 398	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   131: checkcast 388	java/net/HttpURLConnection
    //   134: astore 7
    //   136: aload 7
    //   138: iconst_0
    //   139: invokevirtual 419	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   142: aload 7
    //   144: sipush 10000
    //   147: invokevirtual 422	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   150: aload 7
    //   152: sipush 10000
    //   155: invokevirtual 425	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   158: aload 7
    //   160: iconst_0
    //   161: invokevirtual 743	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   164: aload 7
    //   166: invokevirtual 744	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   169: pop
    //   170: aload 7
    //   172: invokevirtual 747	java/net/HttpURLConnection:getResponseCode	()I
    //   175: istore_1
    //   176: new 110	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   183: astore 6
    //   185: aload 6
    //   187: ldc_w 749
    //   190: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: iload_1
    //   197: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 203
    //   203: aload 6
    //   205: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   237: invokevirtual 391	java/net/HttpURLConnection:disconnect	()V
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
    //   295: invokevirtual 725	java/lang/Throwable:printStackTrace	()V
    //   298: aload 9
    //   300: astore 6
    //   302: iload 4
    //   304: istore_3
    //   305: aload 7
    //   307: ifnull +40 -> 347
    //   310: iload 5
    //   312: istore_3
    //   313: aload 7
    //   315: invokevirtual 391	java/net/HttpURLConnection:disconnect	()V
    //   318: aload 9
    //   320: astore 6
    //   322: iload 4
    //   324: istore_3
    //   325: goto +22 -> 347
    //   328: aload 7
    //   330: ifnull +8 -> 338
    //   333: aload 7
    //   335: invokevirtual 391	java/net/HttpURLConnection:disconnect	()V
    //   338: aload 6
    //   340: athrow
    //   341: aconst_null
    //   342: astore 6
    //   344: iload 4
    //   346: istore_3
    //   347: iload_3
    //   348: ifne +68 -> 416
    //   351: aload 6
    //   353: invokestatic 754	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +60 -> 416
    //   359: aload_0
    //   360: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   363: aload 6
    //   365: invokeinterface 758 2 0
    //   370: ifne +46 -> 416
    //   373: aload_0
    //   374: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   377: aload 6
    //   379: invokeinterface 761 2 0
    //   384: pop
    //   385: aload_0
    //   386: invokespecial 763	com/tencent/smtt/sdk/l:p	()V
    //   389: aload_0
    //   390: getfield 765	com/tencent/smtt/sdk/l:A	Landroid/os/Handler;
    //   393: sipush 150
    //   396: aload 6
    //   398: invokevirtual 771	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   401: astore 7
    //   403: aload_0
    //   404: getfield 765	com/tencent/smtt/sdk/l:A	Landroid/os/Handler;
    //   407: aload 7
    //   409: ldc2_w 772
    //   412: invokevirtual 777	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   415: pop
    //   416: iload_3
    //   417: ifeq +29 -> 446
    //   420: aload_0
    //   421: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   424: aload 6
    //   426: invokeinterface 758 2 0
    //   431: ifeq +15 -> 446
    //   434: aload_0
    //   435: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   438: aload 6
    //   440: invokeinterface 780 2 0
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
    if (this.A == null) {
      this.A = new l.1(this, n.a().getLooper());
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
      localObject1 = p.a().p(this.h);
      i1 = p.a().h(this.h);
    }
    else
    {
      localObject1 = p.a().q(this.h);
      i1 = p.a().i(this.h);
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
    if (p.a().t(this.h)) {
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
    try
    {
      File localFile1 = new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
      boolean bool = localFile1.exists();
      if (bool)
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      else
      {
        File localFile2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          FileUtil.b(localFile2, localFile1);
        }
      }
      if (a.a(this.h, localFile1, 0L, TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        bool = p.a().e(this.h);
        return bool;
      }
    }
    catch (Exception localException)
    {
      label143:
      break label143;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT == 23) {
      return false;
    }
    int i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
    int i2 = p.a().i(this.h);
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
              ((TbsLogReport)localObject2).eventReport((TbsLogReport.EventType)localObject3, this.w);
              this.w.resetArgs();
            }
            return true;
          }
        }
        else
        {
          j();
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
    this.s = true;
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
    //   0: ldc_w 881
    //   3: astore 35
    //   5: invokestatic 131	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   8: aload_0
    //   9: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   12: invokevirtual 883	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;)Z
    //   15: ifeq +25 -> 40
    //   18: iload_1
    //   19: ifne +21 -> 40
    //   22: iconst_0
    //   23: putstatic 677	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   26: aload_0
    //   27: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   30: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   33: sipush -322
    //   36: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   39: return
    //   40: aload_0
    //   41: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   44: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   47: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   50: ldc_w 373
    //   53: iconst_0
    //   54: invokeinterface 311 3 0
    //   59: istore 7
    //   61: iload 7
    //   63: iconst_1
    //   64: if_icmpeq +24 -> 88
    //   67: iload 7
    //   69: iconst_2
    //   70: if_icmpeq +18 -> 88
    //   73: iload 7
    //   75: iconst_4
    //   76: if_icmpne +6 -> 82
    //   79: goto +9 -> 88
    //   82: iconst_0
    //   83: istore 9
    //   85: goto +6 -> 91
    //   88: iconst_1
    //   89: istore 9
    //   91: iload_2
    //   92: ifne +18 -> 110
    //   95: aload_0
    //   96: iload_1
    //   97: iload 9
    //   99: invokevirtual 885	com/tencent/smtt/sdk/l:a	(ZZ)Z
    //   102: ifeq +8 -> 110
    //   105: iconst_0
    //   106: putstatic 677	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   109: return
    //   110: aload_0
    //   111: iload_1
    //   112: putfield 887	com/tencent/smtt/sdk/l:D	Z
    //   115: aload_0
    //   116: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   119: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   122: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   125: astore 31
    //   127: aconst_null
    //   128: astore 30
    //   130: aload_0
    //   131: aload 31
    //   133: ldc_w 889
    //   136: aconst_null
    //   137: invokeinterface 457 3 0
    //   142: putfield 891	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   145: aload_0
    //   146: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   149: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   152: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   155: ldc_w 893
    //   158: aconst_null
    //   159: invokeinterface 457 3 0
    //   164: astore 31
    //   166: new 110	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   173: astore 32
    //   175: aload 32
    //   177: ldc_w 895
    //   180: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 32
    //   186: aload 31
    //   188: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: ldc 203
    //   194: aload 32
    //   196: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: iconst_1
    //   200: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   203: aload_0
    //   204: aconst_null
    //   205: putfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 83	com/tencent/smtt/sdk/l:c	I
    //   213: iload_1
    //   214: ifne +37 -> 251
    //   217: aload 31
    //   219: ifnull +32 -> 251
    //   222: ldc_w 259
    //   225: aload 31
    //   227: invokevirtual 901	java/lang/String:trim	()Ljava/lang/String;
    //   230: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifne +18 -> 251
    //   236: aload_0
    //   237: aload 31
    //   239: invokevirtual 901	java/lang/String:trim	()Ljava/lang/String;
    //   242: ldc_w 903
    //   245: invokevirtual 907	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   248: putfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   251: new 110	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   258: astore 32
    //   260: aload 32
    //   262: ldc_w 909
    //   265: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 32
    //   271: aload_0
    //   272: getfield 891	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   275: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 32
    //   281: ldc_w 911
    //   284: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 32
    //   290: aload 31
    //   292: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 32
    //   298: ldc_w 913
    //   301: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 32
    //   307: aload_0
    //   308: getfield 607	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   311: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 32
    //   317: ldc_w 915
    //   320: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 32
    //   326: aload_0
    //   327: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   330: invokevirtual 451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 32
    //   336: ldc_w 917
    //   339: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 32
    //   345: aload_0
    //   346: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   349: invokevirtual 520	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: ldc 203
    //   355: aload 32
    //   357: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_0
    //   364: getfield 891	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   367: ifnonnull +34 -> 401
    //   370: aload_0
    //   371: getfield 607	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   374: ifnonnull +27 -> 401
    //   377: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   380: bipush 110
    //   382: invokeinterface 573 2 0
    //   387: aload_0
    //   388: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   391: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   394: sipush -302
    //   397: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   400: return
    //   401: aload_0
    //   402: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   405: ifnull +34 -> 439
    //   408: aload_0
    //   409: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   412: ifne +27 -> 439
    //   415: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   418: bipush 110
    //   420: invokeinterface 573 2 0
    //   425: aload_0
    //   426: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   429: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   432: sipush -303
    //   435: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   438: return
    //   439: iload_1
    //   440: ifne +54 -> 494
    //   443: aload_0
    //   444: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   447: aload_0
    //   448: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   451: invokestatic 736	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   454: invokeinterface 758 2 0
    //   459: ifeq +35 -> 494
    //   462: ldc 203
    //   464: ldc_w 919
    //   467: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   473: bipush 110
    //   475: invokeinterface 573 2 0
    //   480: aload_0
    //   481: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   484: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   487: sipush -304
    //   490: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   493: return
    //   494: aload_0
    //   495: invokespecial 138	com/tencent/smtt/sdk/l:g	()V
    //   498: ldc 203
    //   500: ldc_w 921
    //   503: iconst_1
    //   504: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   507: aload_0
    //   508: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   511: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   514: invokevirtual 924	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   517: lstore 14
    //   519: aload_0
    //   520: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   523: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   526: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   529: astore 31
    //   531: lconst_0
    //   532: lstore 16
    //   534: ldc_w 926
    //   537: astore 33
    //   539: aload 31
    //   541: ldc_w 926
    //   544: lconst_0
    //   545: invokeinterface 474 4 0
    //   550: lstore 12
    //   552: iload_1
    //   553: ifeq +11 -> 564
    //   556: getstatic 928	com/tencent/smtt/sdk/l:f	I
    //   559: istore 7
    //   561: goto +8 -> 569
    //   564: getstatic 77	com/tencent/smtt/sdk/l:e	I
    //   567: istore 7
    //   569: aload_0
    //   570: iload 7
    //   572: putfield 79	com/tencent/smtt/sdk/l:C	I
    //   575: iconst_0
    //   576: istore 10
    //   578: iload 9
    //   580: istore_2
    //   581: aload_0
    //   582: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   585: aload_0
    //   586: getfield 79	com/tencent/smtt/sdk/l:C	I
    //   589: if_icmple +6 -> 595
    //   592: goto +2425 -> 3017
    //   595: aload_0
    //   596: getfield 601	com/tencent/smtt/sdk/l:r	I
    //   599: bipush 8
    //   601: if_icmple +28 -> 629
    //   604: aload_0
    //   605: bipush 123
    //   607: aload 30
    //   609: iconst_1
    //   610: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   613: aload_0
    //   614: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   617: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   620: sipush -306
    //   623: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   626: goto -34 -> 592
    //   629: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   632: lstore 26
    //   634: iload_1
    //   635: ifne +393 -> 1028
    //   638: aload_0
    //   639: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   642: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   645: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   648: aload 35
    //   650: lload 16
    //   652: invokeinterface 474 4 0
    //   657: lstore 18
    //   659: lload 26
    //   661: lload 18
    //   663: lsub
    //   664: ldc2_w 929
    //   667: lcmp
    //   668: ifle +102 -> 770
    //   671: lload 12
    //   673: lstore 18
    //   675: lload 12
    //   677: lstore 20
    //   679: ldc 203
    //   681: ldc_w 932
    //   684: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: lload 12
    //   689: lstore 18
    //   691: lload 12
    //   693: lstore 20
    //   695: aload_0
    //   696: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   699: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   702: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   705: aload 35
    //   707: lload 26
    //   709: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   712: invokeinterface 556 3 0
    //   717: pop
    //   718: lload 12
    //   720: lstore 18
    //   722: lload 12
    //   724: lstore 20
    //   726: aload_0
    //   727: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   730: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   733: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   736: aload 33
    //   738: lload 16
    //   740: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   743: invokeinterface 556 3 0
    //   748: pop
    //   749: lload 12
    //   751: lstore 18
    //   753: lload 12
    //   755: lstore 20
    //   757: aload_0
    //   758: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   761: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   764: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   767: goto +130 -> 897
    //   770: new 110	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   777: astore 31
    //   779: aload 31
    //   781: ldc_w 939
    //   784: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload 31
    //   790: lload 12
    //   792: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: ldc 203
    //   798: aload 31
    //   800: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: lload 12
    //   808: lstore 16
    //   810: lload 12
    //   812: lload 14
    //   814: lcmp
    //   815: iflt +82 -> 897
    //   818: ldc 203
    //   820: ldc_w 941
    //   823: iconst_1
    //   824: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   827: aload_0
    //   828: bipush 112
    //   830: aload 30
    //   832: iconst_1
    //   833: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   836: aload_0
    //   837: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   840: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   843: sipush -307
    //   846: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   849: iload_1
    //   850: ifne -258 -> 592
    //   853: aload_0
    //   854: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   857: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   860: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   863: astore 30
    //   865: lload 12
    //   867: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   870: astore 31
    //   872: aload 30
    //   874: aload 33
    //   876: aload 31
    //   878: invokeinterface 556 3 0
    //   883: pop
    //   884: aload_0
    //   885: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   888: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   891: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   894: goto -302 -> 592
    //   897: lload 16
    //   899: lstore 12
    //   901: lload 16
    //   903: lstore 18
    //   905: lload 16
    //   907: lstore 20
    //   909: aload_0
    //   910: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   913: invokestatic 943	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   916: ifne +112 -> 1028
    //   919: lload 16
    //   921: lstore 18
    //   923: lload 16
    //   925: lstore 20
    //   927: ldc 203
    //   929: ldc_w 945
    //   932: iconst_1
    //   933: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   936: lload 16
    //   938: lstore 18
    //   940: lload 16
    //   942: lstore 20
    //   944: aload_0
    //   945: bipush 105
    //   947: aload 30
    //   949: iconst_1
    //   950: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   953: lload 16
    //   955: lstore 18
    //   957: lload 16
    //   959: lstore 20
    //   961: aload_0
    //   962: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   965: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   968: sipush -308
    //   971: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   974: iload_1
    //   975: ifne -383 -> 592
    //   978: aload_0
    //   979: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   982: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   985: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   988: astore 30
    //   990: lload 16
    //   992: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   995: astore 31
    //   997: goto -125 -> 872
    //   1000: astore 30
    //   1002: goto +4908 -> 5910
    //   1005: astore 30
    //   1007: iload 10
    //   1009: istore 9
    //   1011: goto +4262 -> 5273
    //   1014: astore 30
    //   1016: goto +4894 -> 5910
    //   1019: astore 30
    //   1021: iload 10
    //   1023: istore 9
    //   1025: goto +4248 -> 5273
    //   1028: aload_0
    //   1029: iconst_1
    //   1030: putfield 615	com/tencent/smtt/sdk/l:z	Z
    //   1033: aload_0
    //   1034: getfield 607	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   1037: astore 30
    //   1039: aload 30
    //   1041: ifnull +38 -> 1079
    //   1044: lload 12
    //   1046: lstore 18
    //   1048: lload 12
    //   1050: lstore 20
    //   1052: aload_0
    //   1053: getfield 607	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   1056: astore 30
    //   1058: goto +27 -> 1085
    //   1061: astore 30
    //   1063: lload 18
    //   1065: lstore 12
    //   1067: goto -51 -> 1016
    //   1070: astore 30
    //   1072: lload 20
    //   1074: lstore 12
    //   1076: goto -55 -> 1021
    //   1079: aload_0
    //   1080: getfield 891	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   1083: astore 30
    //   1085: new 110	java/lang/StringBuilder
    //   1088: dup
    //   1089: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1092: astore 31
    //   1094: aload 31
    //   1096: ldc_w 947
    //   1099: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: pop
    //   1103: aload 31
    //   1105: aload 30
    //   1107: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 31
    //   1113: ldc_w 949
    //   1116: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload 31
    //   1122: aload_0
    //   1123: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   1126: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: ldc 203
    //   1132: aload 31
    //   1134: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1137: iconst_1
    //   1138: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1141: aload 30
    //   1143: aload_0
    //   1144: getfield 951	com/tencent/smtt/sdk/l:j	Ljava/lang/String;
    //   1147: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1150: istore 9
    //   1152: iload 9
    //   1154: ifne +20 -> 1174
    //   1157: lload 12
    //   1159: lstore 18
    //   1161: lload 12
    //   1163: lstore 20
    //   1165: aload_0
    //   1166: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1169: aload 30
    //   1171: invokevirtual 954	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1174: aload_0
    //   1175: aload 30
    //   1177: putfield 951	com/tencent/smtt/sdk/l:j	Ljava/lang/String;
    //   1180: aload_0
    //   1181: aload 30
    //   1183: invokespecial 956	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;)V
    //   1186: aload_0
    //   1187: getfield 609	com/tencent/smtt/sdk/l:p	Z
    //   1190: istore 9
    //   1192: iload 9
    //   1194: ifne +397 -> 1591
    //   1197: lload 12
    //   1199: lstore 18
    //   1201: aload_0
    //   1202: invokespecial 958	com/tencent/smtt/sdk/l:l	()J
    //   1205: lstore 16
    //   1207: lload 12
    //   1209: lstore 18
    //   1211: new 110	java/lang/StringBuilder
    //   1214: dup
    //   1215: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1218: astore 30
    //   1220: lload 12
    //   1222: lstore 18
    //   1224: aload 30
    //   1226: ldc_w 960
    //   1229: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: lload 12
    //   1235: lstore 18
    //   1237: aload 30
    //   1239: lload 16
    //   1241: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1244: pop
    //   1245: lload 12
    //   1247: lstore 18
    //   1249: ldc 203
    //   1251: aload 30
    //   1253: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1259: lload 12
    //   1261: lstore 18
    //   1263: aload_0
    //   1264: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   1267: lconst_0
    //   1268: lcmp
    //   1269: ifgt +137 -> 1406
    //   1272: lload 12
    //   1274: lstore 18
    //   1276: new 110	java/lang/StringBuilder
    //   1279: dup
    //   1280: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1283: astore 30
    //   1285: lload 12
    //   1287: lstore 18
    //   1289: aload 30
    //   1291: ldc_w 962
    //   1294: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: pop
    //   1298: lload 12
    //   1300: lstore 18
    //   1302: aload 30
    //   1304: lload 16
    //   1306: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1309: pop
    //   1310: lload 12
    //   1312: lstore 18
    //   1314: ldc 203
    //   1316: aload 30
    //   1318: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: iconst_1
    //   1322: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1325: lload 12
    //   1327: lstore 18
    //   1329: aload_0
    //   1330: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   1333: astore 30
    //   1335: lload 12
    //   1337: lstore 18
    //   1339: new 110	java/lang/StringBuilder
    //   1342: dup
    //   1343: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1346: astore 31
    //   1348: lload 12
    //   1350: lstore 18
    //   1352: aload 31
    //   1354: ldc_w 964
    //   1357: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: lload 12
    //   1363: lstore 18
    //   1365: aload 31
    //   1367: lload 16
    //   1369: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1372: pop
    //   1373: lload 12
    //   1375: lstore 18
    //   1377: aload 31
    //   1379: ldc_w 966
    //   1382: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: lload 12
    //   1388: lstore 18
    //   1390: aload 30
    //   1392: ldc_w 968
    //   1395: aload 31
    //   1397: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1400: invokevirtual 406	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1403: goto +191 -> 1594
    //   1406: lload 12
    //   1408: lstore 18
    //   1410: new 110	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1417: astore 30
    //   1419: lload 12
    //   1421: lstore 18
    //   1423: aload 30
    //   1425: ldc_w 970
    //   1428: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: pop
    //   1432: lload 12
    //   1434: lstore 18
    //   1436: aload 30
    //   1438: lload 16
    //   1440: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1443: pop
    //   1444: lload 12
    //   1446: lstore 18
    //   1448: aload 30
    //   1450: ldc_w 972
    //   1453: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: lload 12
    //   1459: lstore 18
    //   1461: aload 30
    //   1463: aload_0
    //   1464: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   1467: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1470: pop
    //   1471: lload 12
    //   1473: lstore 18
    //   1475: ldc 203
    //   1477: aload 30
    //   1479: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: iconst_1
    //   1483: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1486: lload 12
    //   1488: lstore 18
    //   1490: aload_0
    //   1491: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   1494: astore 30
    //   1496: lload 12
    //   1498: lstore 18
    //   1500: new 110	java/lang/StringBuilder
    //   1503: dup
    //   1504: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1507: astore 31
    //   1509: lload 12
    //   1511: lstore 18
    //   1513: aload 31
    //   1515: ldc_w 964
    //   1518: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: pop
    //   1522: lload 12
    //   1524: lstore 18
    //   1526: aload 31
    //   1528: lload 16
    //   1530: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: lload 12
    //   1536: lstore 18
    //   1538: aload 31
    //   1540: ldc_w 966
    //   1543: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: pop
    //   1547: lload 12
    //   1549: lstore 18
    //   1551: aload 31
    //   1553: aload_0
    //   1554: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   1557: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: lload 12
    //   1563: lstore 18
    //   1565: aload 30
    //   1567: ldc_w 968
    //   1570: aload 31
    //   1572: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: invokevirtual 406	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1578: goto +16 -> 1594
    //   1581: astore 30
    //   1583: goto -562 -> 1021
    //   1586: astore 30
    //   1588: goto -567 -> 1021
    //   1591: lconst_0
    //   1592: lstore 16
    //   1594: iload 10
    //   1596: istore 9
    //   1598: aload_0
    //   1599: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1602: astore 30
    //   1604: lload 16
    //   1606: lconst_0
    //   1607: lcmp
    //   1608: ifne +4348 -> 5956
    //   1611: iconst_0
    //   1612: istore 7
    //   1614: goto +3 -> 1617
    //   1617: aload 30
    //   1619: iload 7
    //   1621: invokevirtual 975	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1624: aload_0
    //   1625: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1628: invokestatic 642	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1631: istore 7
    //   1633: aload_0
    //   1634: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1637: invokestatic 638	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1640: astore 30
    //   1642: aload_0
    //   1643: getfield 140	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   1646: astore 31
    //   1648: aload 31
    //   1650: ifnonnull +38 -> 1688
    //   1653: lload 12
    //   1655: lstore 18
    //   1657: aload_0
    //   1658: getfield 142	com/tencent/smtt/sdk/l:y	I
    //   1661: iconst_m1
    //   1662: if_icmpne +26 -> 1688
    //   1665: lload 12
    //   1667: lstore 18
    //   1669: aload_0
    //   1670: aload 30
    //   1672: putfield 140	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   1675: lload 12
    //   1677: lstore 18
    //   1679: aload_0
    //   1680: iload 7
    //   1682: putfield 142	com/tencent/smtt/sdk/l:y	I
    //   1685: goto +56 -> 1741
    //   1688: aload_0
    //   1689: getfield 142	com/tencent/smtt/sdk/l:y	I
    //   1692: istore 8
    //   1694: iload 7
    //   1696: iload 8
    //   1698: if_icmpne +23 -> 1721
    //   1701: lload 12
    //   1703: lstore 18
    //   1705: aload 30
    //   1707: aload_0
    //   1708: getfield 140	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   1711: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1714: istore 11
    //   1716: iload 11
    //   1718: ifne +23 -> 1741
    //   1721: aload_0
    //   1722: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1725: iconst_0
    //   1726: invokevirtual 651	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   1729: aload_0
    //   1730: aload 30
    //   1732: putfield 140	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   1735: aload_0
    //   1736: iload 7
    //   1738: putfield 142	com/tencent/smtt/sdk/l:y	I
    //   1741: aload_0
    //   1742: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   1745: istore 7
    //   1747: iload 7
    //   1749: iconst_1
    //   1750: if_icmplt +21 -> 1771
    //   1753: lload 12
    //   1755: lstore 18
    //   1757: aload_0
    //   1758: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   1761: ldc_w 977
    //   1764: aload_0
    //   1765: getfield 891	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   1768: invokevirtual 980	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1771: aload_0
    //   1772: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   1775: invokevirtual 747	java/net/HttpURLConnection:getResponseCode	()I
    //   1778: istore 7
    //   1780: new 110	java/lang/StringBuilder
    //   1783: dup
    //   1784: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1787: astore 30
    //   1789: aload 30
    //   1791: ldc_w 982
    //   1794: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: pop
    //   1798: aload 30
    //   1800: iload 7
    //   1802: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1805: pop
    //   1806: ldc 203
    //   1808: aload 30
    //   1810: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1813: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1816: aload_0
    //   1817: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1820: iload 7
    //   1822: invokevirtual 985	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1825: iload_1
    //   1826: ifne +101 -> 1927
    //   1829: lload 12
    //   1831: lstore 18
    //   1833: aload_0
    //   1834: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1837: invokestatic 216	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1840: ifne +87 -> 1927
    //   1843: lload 12
    //   1845: lstore 18
    //   1847: aload_0
    //   1848: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1851: invokestatic 642	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1854: iconst_3
    //   1855: if_icmpne +17 -> 1872
    //   1858: lload 12
    //   1860: lstore 18
    //   1862: aload_0
    //   1863: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1866: invokestatic 642	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1869: ifne +58 -> 1927
    //   1872: lload 12
    //   1874: lstore 18
    //   1876: invokestatic 988	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1879: ifne +48 -> 1927
    //   1882: lload 12
    //   1884: lstore 18
    //   1886: aload_0
    //   1887: invokevirtual 989	com/tencent/smtt/sdk/l:b	()V
    //   1890: lload 12
    //   1892: lstore 18
    //   1894: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1897: ifnull +17 -> 1914
    //   1900: lload 12
    //   1902: lstore 18
    //   1904: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1907: bipush 111
    //   1909: invokeinterface 573 2 0
    //   1914: lload 12
    //   1916: lstore 18
    //   1918: ldc 203
    //   1920: ldc_w 991
    //   1923: iconst_0
    //   1924: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1927: aload_0
    //   1928: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   1931: istore 11
    //   1933: iload 11
    //   1935: ifeq +60 -> 1995
    //   1938: lload 12
    //   1940: lstore 18
    //   1942: aload_0
    //   1943: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1946: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1949: sipush -309
    //   1952: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1955: iload_1
    //   1956: ifne +1061 -> 3017
    //   1959: aload_0
    //   1960: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1963: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1966: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1969: aload 33
    //   1971: lload 12
    //   1973: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1976: invokeinterface 556 3 0
    //   1981: pop
    //   1982: aload_0
    //   1983: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1986: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1989: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1992: goto +1025 -> 3017
    //   1995: iload 7
    //   1997: sipush 200
    //   2000: if_icmpeq +623 -> 2623
    //   2003: iload 7
    //   2005: sipush 206
    //   2008: if_icmpne +6 -> 2014
    //   2011: goto +612 -> 2623
    //   2014: iload 7
    //   2016: sipush 300
    //   2019: if_icmplt +129 -> 2148
    //   2022: iload 7
    //   2024: sipush 307
    //   2027: if_icmpgt +121 -> 2148
    //   2030: lload 12
    //   2032: lstore 18
    //   2034: aload_0
    //   2035: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   2038: ldc_w 993
    //   2041: invokevirtual 997	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2044: astore 30
    //   2046: lload 12
    //   2048: lstore 18
    //   2050: aload 30
    //   2052: invokestatic 754	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2055: ifne +57 -> 2112
    //   2058: lload 12
    //   2060: lstore 18
    //   2062: aload_0
    //   2063: aload 30
    //   2065: putfield 607	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   2068: lload 12
    //   2070: lstore 18
    //   2072: aload_0
    //   2073: aload_0
    //   2074: getfield 601	com/tencent/smtt/sdk/l:r	I
    //   2077: iconst_1
    //   2078: iadd
    //   2079: putfield 601	com/tencent/smtt/sdk/l:r	I
    //   2082: iload_1
    //   2083: ifne +3912 -> 5995
    //   2086: aload_0
    //   2087: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2090: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2093: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2096: aload 33
    //   2098: lload 12
    //   2100: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2103: invokeinterface 556 3 0
    //   2108: pop
    //   2109: goto +259 -> 2368
    //   2112: lload 12
    //   2114: lstore 18
    //   2116: aload_0
    //   2117: bipush 124
    //   2119: aconst_null
    //   2120: iconst_1
    //   2121: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2124: lload 12
    //   2126: lstore 18
    //   2128: aload_0
    //   2129: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2132: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2135: sipush -312
    //   2138: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2141: iload_1
    //   2142: ifne +875 -> 3017
    //   2145: goto -186 -> 1959
    //   2148: lload 12
    //   2150: lstore 18
    //   2152: aload_0
    //   2153: bipush 102
    //   2155: iload 7
    //   2157: invokestatic 1000	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2160: iconst_0
    //   2161: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2164: iload 7
    //   2166: sipush 416
    //   2169: if_icmpne +3793 -> 5962
    //   2172: lload 12
    //   2174: lstore 18
    //   2176: aload_0
    //   2177: iconst_1
    //   2178: iload_2
    //   2179: invokespecial 871	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   2182: istore 9
    //   2184: iload 9
    //   2186: ifeq +74 -> 2260
    //   2189: lload 12
    //   2191: lstore 18
    //   2193: aload_0
    //   2194: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2197: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2200: sipush -214
    //   2203: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2206: iload_1
    //   2207: ifne +36 -> 2243
    //   2210: aload_0
    //   2211: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2214: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2217: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2220: aload 33
    //   2222: lload 12
    //   2224: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2227: invokeinterface 556 3 0
    //   2232: pop
    //   2233: aload_0
    //   2234: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2237: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2240: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2243: iconst_1
    //   2244: istore 10
    //   2246: iload_2
    //   2247: istore 11
    //   2249: goto +3252 -> 5501
    //   2252: astore 30
    //   2254: iconst_1
    //   2255: istore 9
    //   2257: goto +3016 -> 5273
    //   2260: lload 12
    //   2262: lstore 18
    //   2264: aload_0
    //   2265: iconst_0
    //   2266: invokespecial 873	com/tencent/smtt/sdk/l:e	(Z)Z
    //   2269: pop
    //   2270: lload 12
    //   2272: lstore 18
    //   2274: aload_0
    //   2275: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2278: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2281: sipush -313
    //   2284: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2287: iload_1
    //   2288: ifne +729 -> 3017
    //   2291: goto -332 -> 1959
    //   2294: lload 12
    //   2296: lstore 18
    //   2298: aload_0
    //   2299: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   2302: ldc2_w 602
    //   2305: lcmp
    //   2306: ifne +27 -> 2333
    //   2309: lload 12
    //   2311: lstore 18
    //   2313: aload_0
    //   2314: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2317: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2320: sipush -314
    //   2323: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2326: iload_1
    //   2327: ifne +690 -> 3017
    //   2330: goto -371 -> 1959
    //   2333: iload 7
    //   2335: sipush 202
    //   2338: if_icmpne +43 -> 2381
    //   2341: iload_1
    //   2342: ifne +3653 -> 5995
    //   2345: aload_0
    //   2346: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2349: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2352: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2355: aload 33
    //   2357: lload 12
    //   2359: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2362: invokeinterface 556 3 0
    //   2367: pop
    //   2368: aload_0
    //   2369: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2372: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2375: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2378: goto +3617 -> 5995
    //   2381: lload 12
    //   2383: lstore 18
    //   2385: aload_0
    //   2386: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   2389: aload_0
    //   2390: getfield 79	com/tencent/smtt/sdk/l:C	I
    //   2393: if_icmpge +67 -> 2460
    //   2396: iload 7
    //   2398: sipush 503
    //   2401: if_icmpne +59 -> 2460
    //   2404: lload 12
    //   2406: lstore 18
    //   2408: aload_0
    //   2409: aload_0
    //   2410: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   2413: ldc_w 1002
    //   2416: invokevirtual 997	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2419: invokestatic 1006	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2422: invokespecial 1008	com/tencent/smtt/sdk/l:a	(J)V
    //   2425: lload 12
    //   2427: lstore 18
    //   2429: aload_0
    //   2430: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   2433: ifeq +3548 -> 5981
    //   2436: lload 12
    //   2438: lstore 18
    //   2440: aload_0
    //   2441: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2444: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2447: sipush -309
    //   2450: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2453: iload_1
    //   2454: ifne +563 -> 3017
    //   2457: goto -498 -> 1959
    //   2460: lload 12
    //   2462: lstore 18
    //   2464: aload_0
    //   2465: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   2468: aload_0
    //   2469: getfield 79	com/tencent/smtt/sdk/l:C	I
    //   2472: if_icmpge +79 -> 2551
    //   2475: iload 7
    //   2477: sipush 408
    //   2480: if_icmpeq +27 -> 2507
    //   2483: iload 7
    //   2485: sipush 504
    //   2488: if_icmpeq +19 -> 2507
    //   2491: iload 7
    //   2493: sipush 502
    //   2496: if_icmpeq +11 -> 2507
    //   2499: iload 7
    //   2501: sipush 408
    //   2504: if_icmpne +47 -> 2551
    //   2507: lload 12
    //   2509: lstore 18
    //   2511: aload_0
    //   2512: lconst_0
    //   2513: invokespecial 1008	com/tencent/smtt/sdk/l:a	(J)V
    //   2516: lload 12
    //   2518: lstore 18
    //   2520: aload_0
    //   2521: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   2524: ifeq +3464 -> 5988
    //   2527: lload 12
    //   2529: lstore 18
    //   2531: aload_0
    //   2532: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2535: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2538: sipush -309
    //   2541: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2544: iload_1
    //   2545: ifne +472 -> 3017
    //   2548: goto -589 -> 1959
    //   2551: lload 12
    //   2553: lstore 18
    //   2555: aload_0
    //   2556: invokespecial 958	com/tencent/smtt/sdk/l:l	()J
    //   2559: lconst_0
    //   2560: lcmp
    //   2561: ifgt +38 -> 2599
    //   2564: lload 12
    //   2566: lstore 18
    //   2568: aload_0
    //   2569: getfield 609	com/tencent/smtt/sdk/l:p	Z
    //   2572: ifne +27 -> 2599
    //   2575: iload 7
    //   2577: sipush 410
    //   2580: if_icmpeq +19 -> 2599
    //   2583: lload 12
    //   2585: lstore 18
    //   2587: aload_0
    //   2588: iconst_1
    //   2589: putfield 609	com/tencent/smtt/sdk/l:p	Z
    //   2592: iload_1
    //   2593: ifne +3402 -> 5995
    //   2596: goto -251 -> 2345
    //   2599: lload 12
    //   2601: lstore 18
    //   2603: aload_0
    //   2604: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2607: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2610: sipush -315
    //   2613: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2616: iload_1
    //   2617: ifne +400 -> 3017
    //   2620: goto -661 -> 1959
    //   2623: aload_0
    //   2624: aload_0
    //   2625: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   2628: invokevirtual 1011	java/net/HttpURLConnection:getContentLength	()I
    //   2631: i2l
    //   2632: lload 16
    //   2634: ladd
    //   2635: putfield 605	com/tencent/smtt/sdk/l:m	J
    //   2638: new 110	java/lang/StringBuilder
    //   2641: dup
    //   2642: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2645: astore 30
    //   2647: aload 30
    //   2649: ldc_w 1013
    //   2652: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2655: pop
    //   2656: aload 30
    //   2658: aload_0
    //   2659: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   2662: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2665: pop
    //   2666: ldc 203
    //   2668: aload 30
    //   2670: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2673: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2676: aload_0
    //   2677: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2680: aload_0
    //   2681: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   2684: invokevirtual 1016	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2687: aload_0
    //   2688: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2691: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2694: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2697: ldc_w 470
    //   2700: lconst_0
    //   2701: invokeinterface 474 4 0
    //   2706: lstore 20
    //   2708: lload 20
    //   2710: lconst_0
    //   2711: lcmp
    //   2712: ifeq +311 -> 3023
    //   2715: lload 12
    //   2717: lstore 18
    //   2719: aload_0
    //   2720: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   2723: lload 20
    //   2725: lcmp
    //   2726: ifeq +297 -> 3023
    //   2729: lload 12
    //   2731: lstore 18
    //   2733: new 110	java/lang/StringBuilder
    //   2736: dup
    //   2737: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2740: astore 30
    //   2742: lload 12
    //   2744: lstore 18
    //   2746: aload 30
    //   2748: ldc_w 1018
    //   2751: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2754: pop
    //   2755: lload 12
    //   2757: lstore 18
    //   2759: aload 30
    //   2761: lload 20
    //   2763: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2766: pop
    //   2767: lload 12
    //   2769: lstore 18
    //   2771: aload 30
    //   2773: ldc_w 1020
    //   2776: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: pop
    //   2780: lload 12
    //   2782: lstore 18
    //   2784: aload 30
    //   2786: aload_0
    //   2787: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   2790: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2793: pop
    //   2794: lload 12
    //   2796: lstore 18
    //   2798: ldc 203
    //   2800: aload 30
    //   2802: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2805: iconst_1
    //   2806: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2809: iload_1
    //   2810: ifne +169 -> 2979
    //   2813: lload 12
    //   2815: lstore 18
    //   2817: aload_0
    //   2818: invokespecial 428	com/tencent/smtt/sdk/l:o	()Z
    //   2821: ifne +27 -> 2848
    //   2824: lload 12
    //   2826: lstore 18
    //   2828: invokestatic 988	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2831: ifeq +148 -> 2979
    //   2834: lload 12
    //   2836: lstore 18
    //   2838: aload_0
    //   2839: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2842: invokestatic 657	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2845: ifeq +134 -> 2979
    //   2848: lload 12
    //   2850: lstore 18
    //   2852: aload_0
    //   2853: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   2856: ifnull +22 -> 2878
    //   2859: lload 12
    //   2861: lstore 18
    //   2863: aload_0
    //   2864: iconst_0
    //   2865: invokevirtual 1022	com/tencent/smtt/sdk/l:b	(Z)Z
    //   2868: ifeq +10 -> 2878
    //   2871: iload_1
    //   2872: ifne +3123 -> 5995
    //   2875: goto -530 -> 2345
    //   2878: lload 12
    //   2880: lstore 18
    //   2882: new 110	java/lang/StringBuilder
    //   2885: dup
    //   2886: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2889: astore 30
    //   2891: lload 12
    //   2893: lstore 18
    //   2895: aload 30
    //   2897: ldc_w 1024
    //   2900: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2903: pop
    //   2904: lload 12
    //   2906: lstore 18
    //   2908: aload 30
    //   2910: lload 20
    //   2912: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2915: pop
    //   2916: lload 12
    //   2918: lstore 18
    //   2920: aload 30
    //   2922: ldc_w 1020
    //   2925: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: pop
    //   2929: lload 12
    //   2931: lstore 18
    //   2933: aload 30
    //   2935: aload_0
    //   2936: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   2939: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2942: pop
    //   2943: lload 12
    //   2945: lstore 18
    //   2947: aload_0
    //   2948: bipush 113
    //   2950: aload 30
    //   2952: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2955: iconst_1
    //   2956: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2959: lload 12
    //   2961: lstore 18
    //   2963: aload_0
    //   2964: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2967: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2970: sipush -310
    //   2973: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2976: goto +34 -> 3010
    //   2979: lload 12
    //   2981: lstore 18
    //   2983: aload_0
    //   2984: bipush 101
    //   2986: ldc_w 1026
    //   2989: iconst_1
    //   2990: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2993: lload 12
    //   2995: lstore 18
    //   2997: aload_0
    //   2998: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3001: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3004: sipush -304
    //   3007: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3010: iload_1
    //   3011: ifne +6 -> 3017
    //   3014: goto -1055 -> 1959
    //   3017: iload_2
    //   3018: istore 11
    //   3020: goto +2481 -> 5501
    //   3023: ldc 203
    //   3025: ldc_w 1028
    //   3028: invokestatic 381	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3031: aload_0
    //   3032: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   3035: invokevirtual 744	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3038: astore 34
    //   3040: aload 34
    //   3042: astore 31
    //   3044: aload 31
    //   3046: ifnull +1230 -> 4276
    //   3049: aload_0
    //   3050: getfield 386	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   3053: invokevirtual 1031	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3056: astore 30
    //   3058: aload 30
    //   3060: ifnull +28 -> 3088
    //   3063: aload 30
    //   3065: ldc_w 1033
    //   3068: invokevirtual 326	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3071: ifeq +17 -> 3088
    //   3074: new 1035	java/util/zip/GZIPInputStream
    //   3077: dup
    //   3078: aload 31
    //   3080: invokespecial 1036	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3083: astore 30
    //   3085: goto +45 -> 3130
    //   3088: aload 30
    //   3090: ifnull +36 -> 3126
    //   3093: aload 30
    //   3095: ldc_w 1038
    //   3098: invokevirtual 326	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3101: ifeq +25 -> 3126
    //   3104: new 1040	java/util/zip/InflaterInputStream
    //   3107: dup
    //   3108: aload 31
    //   3110: new 1042	java/util/zip/Inflater
    //   3113: dup
    //   3114: iconst_1
    //   3115: invokespecial 1044	java/util/zip/Inflater:<init>	(Z)V
    //   3118: invokespecial 1047	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3121: astore 30
    //   3123: goto +7 -> 3130
    //   3126: aload 31
    //   3128: astore 30
    //   3130: sipush 8192
    //   3133: newarray byte
    //   3135: astore 36
    //   3137: aload_0
    //   3138: getfield 136	com/tencent/smtt/sdk/l:l	Ljava/io/File;
    //   3141: astore 32
    //   3143: new 1049	java/io/FileOutputStream
    //   3146: dup
    //   3147: new 177	java/io/File
    //   3150: dup
    //   3151: aload 32
    //   3153: ldc_w 445
    //   3156: invokespecial 225	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3159: iconst_1
    //   3160: invokespecial 1052	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3163: astore 32
    //   3165: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   3168: lstore 22
    //   3170: iload 9
    //   3172: istore 10
    //   3174: lload 16
    //   3176: lstore 20
    //   3178: lload 16
    //   3180: lstore 24
    //   3182: iload_2
    //   3183: istore 9
    //   3185: aload_0
    //   3186: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   3189: istore_2
    //   3190: iload_2
    //   3191: ifeq +54 -> 3245
    //   3194: ldc 203
    //   3196: ldc_w 1054
    //   3199: iconst_1
    //   3200: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3203: aload_0
    //   3204: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3207: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3210: sipush -309
    //   3213: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3216: iload 10
    //   3218: istore_2
    //   3219: iconst_0
    //   3220: istore 7
    //   3222: goto +738 -> 3960
    //   3225: astore 31
    //   3227: iload 10
    //   3229: istore_2
    //   3230: aload 32
    //   3232: astore 36
    //   3234: aload 30
    //   3236: astore 32
    //   3238: aload 36
    //   3240: astore 30
    //   3242: goto +2813 -> 6055
    //   3245: iload 10
    //   3247: istore_2
    //   3248: aload 30
    //   3250: aload 36
    //   3252: iconst_0
    //   3253: sipush 8192
    //   3256: invokevirtual 1060	java/io/InputStream:read	([BII)I
    //   3259: istore 7
    //   3261: iload 7
    //   3263: ifgt +140 -> 3403
    //   3266: aload_0
    //   3267: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   3270: ifnull +44 -> 3314
    //   3273: aload_0
    //   3274: iconst_1
    //   3275: iload 9
    //   3277: invokespecial 871	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   3280: ifne +34 -> 3314
    //   3283: iload_1
    //   3284: ifne +17 -> 3301
    //   3287: aload_0
    //   3288: iconst_0
    //   3289: invokevirtual 1022	com/tencent/smtt/sdk/l:b	(Z)Z
    //   3292: ifeq +9 -> 3301
    //   3295: iconst_1
    //   3296: istore 7
    //   3298: goto -76 -> 3222
    //   3301: aload_0
    //   3302: iconst_1
    //   3303: putfield 613	com/tencent/smtt/sdk/l:t	Z
    //   3306: iconst_0
    //   3307: istore 7
    //   3309: iconst_0
    //   3310: istore_2
    //   3311: goto +649 -> 3960
    //   3314: aload_0
    //   3315: iconst_1
    //   3316: putfield 613	com/tencent/smtt/sdk/l:t	Z
    //   3319: aload_0
    //   3320: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   3323: astore 36
    //   3325: aload 36
    //   3327: ifnull +8 -> 3335
    //   3330: iconst_1
    //   3331: istore_2
    //   3332: goto +3 -> 3335
    //   3335: aload_0
    //   3336: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3339: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3342: sipush -311
    //   3345: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3348: goto -129 -> 3219
    //   3351: astore 34
    //   3353: goto +10 -> 3363
    //   3356: astore 31
    //   3358: goto +18 -> 3376
    //   3361: astore 34
    //   3363: aload 31
    //   3365: astore 36
    //   3367: aload 32
    //   3369: astore 31
    //   3371: goto +1761 -> 5132
    //   3374: astore 31
    //   3376: aload 32
    //   3378: astore 36
    //   3380: aload 34
    //   3382: astore 32
    //   3384: aload 31
    //   3386: astore 34
    //   3388: aload 32
    //   3390: astore 31
    //   3392: aload 30
    //   3394: astore 32
    //   3396: aload 36
    //   3398: astore 30
    //   3400: goto +1125 -> 4525
    //   3403: aload 32
    //   3405: aload 36
    //   3407: iconst_0
    //   3408: iload 7
    //   3410: invokevirtual 1064	java/io/FileOutputStream:write	([BII)V
    //   3413: aload 32
    //   3415: invokevirtual 1067	java/io/FileOutputStream:flush	()V
    //   3418: iload_1
    //   3419: ifne +254 -> 3673
    //   3422: iload 9
    //   3424: istore 11
    //   3426: lload 12
    //   3428: iload 7
    //   3430: i2l
    //   3431: ladd
    //   3432: lstore 16
    //   3434: lload 16
    //   3436: lload 14
    //   3438: lcmp
    //   3439: iflt +105 -> 3544
    //   3442: ldc 203
    //   3444: ldc_w 941
    //   3447: iconst_1
    //   3448: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3451: new 110	java/lang/StringBuilder
    //   3454: dup
    //   3455: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   3458: astore 36
    //   3460: aload 36
    //   3462: ldc_w 1069
    //   3465: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3468: pop
    //   3469: aload 36
    //   3471: lload 16
    //   3473: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3476: pop
    //   3477: aload 36
    //   3479: ldc_w 1071
    //   3482: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3485: pop
    //   3486: aload 36
    //   3488: lload 14
    //   3490: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3493: pop
    //   3494: aload_0
    //   3495: bipush 112
    //   3497: aload 36
    //   3499: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3502: iconst_1
    //   3503: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3506: aload_0
    //   3507: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3510: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3513: sipush -307
    //   3516: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3519: goto +129 -> 3648
    //   3522: astore 34
    //   3524: lload 16
    //   3526: lstore 12
    //   3528: iload 11
    //   3530: istore 10
    //   3532: goto +665 -> 4197
    //   3535: astore 31
    //   3537: lload 16
    //   3539: lstore 12
    //   3541: goto -314 -> 3227
    //   3544: lload 16
    //   3546: lstore 18
    //   3548: lload 18
    //   3550: lstore 12
    //   3552: aload_0
    //   3553: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3556: invokestatic 943	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   3559: ifne +114 -> 3673
    //   3562: ldc 203
    //   3564: ldc_w 1073
    //   3567: iconst_1
    //   3568: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3571: new 110	java/lang/StringBuilder
    //   3574: dup
    //   3575: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   3578: astore 36
    //   3580: aload 36
    //   3582: ldc_w 1075
    //   3585: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: pop
    //   3589: aload 36
    //   3591: invokestatic 1077	com/tencent/smtt/utils/p:a	()J
    //   3594: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3597: pop
    //   3598: aload 36
    //   3600: ldc_w 1079
    //   3603: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3606: pop
    //   3607: aload 36
    //   3609: aload_0
    //   3610: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3613: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3616: invokevirtual 1082	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   3619: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3622: pop
    //   3623: aload_0
    //   3624: bipush 105
    //   3626: aload 36
    //   3628: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3631: iconst_1
    //   3632: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3635: aload_0
    //   3636: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3639: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3642: sipush -308
    //   3645: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3648: lload 16
    //   3650: lstore 12
    //   3652: goto -433 -> 3219
    //   3655: astore 34
    //   3657: lload 18
    //   3659: lstore 12
    //   3661: goto -298 -> 3363
    //   3664: astore 31
    //   3666: lload 18
    //   3668: lstore 12
    //   3670: goto -294 -> 3376
    //   3673: iload 9
    //   3675: istore 10
    //   3677: iload 7
    //   3679: i2l
    //   3680: lstore 16
    //   3682: aload_0
    //   3683: lload 26
    //   3685: lload 16
    //   3687: invokespecial 1084	com/tencent/smtt/sdk/l:a	(JJ)J
    //   3690: lstore 26
    //   3692: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   3695: lstore 28
    //   3697: lload 24
    //   3699: lload 16
    //   3701: ladd
    //   3702: lstore 18
    //   3704: lload 28
    //   3706: lload 22
    //   3708: lsub
    //   3709: ldc2_w 1085
    //   3712: lcmp
    //   3713: ifle +418 -> 4131
    //   3716: new 110	java/lang/StringBuilder
    //   3719: dup
    //   3720: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   3723: astore 37
    //   3725: aload 37
    //   3727: ldc_w 1088
    //   3730: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3733: pop
    //   3734: aload 37
    //   3736: lload 18
    //   3738: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3741: pop
    //   3742: aload 37
    //   3744: ldc_w 972
    //   3747: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3750: pop
    //   3751: aload 37
    //   3753: aload_0
    //   3754: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   3757: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3760: pop
    //   3761: ldc 203
    //   3763: aload 37
    //   3765: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3768: iconst_1
    //   3769: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3772: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   3775: astore 37
    //   3777: aload 37
    //   3779: ifnull +63 -> 3842
    //   3782: lload 18
    //   3784: l2d
    //   3785: dstore_3
    //   3786: aload_0
    //   3787: getfield 605	com/tencent/smtt/sdk/l:m	J
    //   3790: lstore 16
    //   3792: lload 16
    //   3794: l2d
    //   3795: dstore 5
    //   3797: dload_3
    //   3798: invokestatic 1094	java/lang/Double:isNaN	(D)Z
    //   3801: pop
    //   3802: dload 5
    //   3804: invokestatic 1094	java/lang/Double:isNaN	(D)Z
    //   3807: pop
    //   3808: dload_3
    //   3809: dload 5
    //   3811: ddiv
    //   3812: ldc2_w 1095
    //   3815: dmul
    //   3816: d2i
    //   3817: istore 7
    //   3819: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   3822: iload 7
    //   3824: invokeinterface 1099 2 0
    //   3829: goto +13 -> 3842
    //   3832: astore 34
    //   3834: goto -471 -> 3363
    //   3837: astore 31
    //   3839: goto -463 -> 3376
    //   3842: lload 14
    //   3844: lstore 16
    //   3846: iload_1
    //   3847: ifne +277 -> 4124
    //   3850: lload 18
    //   3852: lload 20
    //   3854: lsub
    //   3855: ldc2_w 1100
    //   3858: lcmp
    //   3859: ifle +265 -> 4124
    //   3862: aload_0
    //   3863: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3866: invokestatic 216	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   3869: ifne +222 -> 4091
    //   3872: aload_0
    //   3873: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3876: invokestatic 642	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   3879: istore 7
    //   3881: iload 7
    //   3883: iconst_3
    //   3884: if_icmpne +17 -> 3901
    //   3887: aload_0
    //   3888: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3891: invokestatic 642	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   3894: istore 7
    //   3896: iload 7
    //   3898: ifne +193 -> 4091
    //   3901: invokestatic 988	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   3904: ifne +187 -> 4091
    //   3907: aload_0
    //   3908: invokevirtual 989	com/tencent/smtt/sdk/l:b	()V
    //   3911: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   3914: astore 36
    //   3916: aload 36
    //   3918: ifnull +13 -> 3931
    //   3921: getstatic 568	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   3924: bipush 111
    //   3926: invokeinterface 573 2 0
    //   3931: ldc 203
    //   3933: ldc_w 1103
    //   3936: iconst_0
    //   3937: invokestatic 898	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3940: aload_0
    //   3941: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3944: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3947: astore 34
    //   3949: aload 34
    //   3951: sipush -304
    //   3954: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3957: iconst_0
    //   3958: istore 7
    //   3960: iload 7
    //   3962: ifeq +100 -> 4062
    //   3965: iload_2
    //   3966: istore 11
    //   3968: lload 12
    //   3970: lstore 20
    //   3972: iload 9
    //   3974: istore 10
    //   3976: lload 14
    //   3978: lstore 18
    //   3980: lload 12
    //   3982: lstore 16
    //   3984: aload_0
    //   3985: aload 32
    //   3987: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   3990: iload_2
    //   3991: istore 11
    //   3993: lload 12
    //   3995: lstore 20
    //   3997: iload 9
    //   3999: istore 10
    //   4001: lload 14
    //   4003: lstore 18
    //   4005: lload 12
    //   4007: lstore 16
    //   4009: aload_0
    //   4010: aload 30
    //   4012: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4015: iload_2
    //   4016: istore 11
    //   4018: lload 12
    //   4020: lstore 20
    //   4022: iload 9
    //   4024: istore 10
    //   4026: lload 14
    //   4028: lstore 18
    //   4030: lload 12
    //   4032: lstore 16
    //   4034: aload_0
    //   4035: aload 31
    //   4037: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4040: iload_2
    //   4041: istore 10
    //   4043: lload 12
    //   4045: lstore 16
    //   4047: iload 9
    //   4049: istore 11
    //   4051: lload 14
    //   4053: lstore 18
    //   4055: iload_1
    //   4056: ifne +1028 -> 5084
    //   4059: goto +977 -> 5036
    //   4062: goto +230 -> 4292
    //   4065: astore 34
    //   4067: iload 10
    //   4069: istore 9
    //   4071: lload 16
    //   4073: lstore 14
    //   4075: goto +1951 -> 6026
    //   4078: astore 34
    //   4080: iload 10
    //   4082: istore 9
    //   4084: lload 16
    //   4086: lstore 14
    //   4088: goto +128 -> 4216
    //   4091: lload 18
    //   4093: lstore 20
    //   4095: goto +29 -> 4124
    //   4098: astore 34
    //   4100: iload 10
    //   4102: istore 9
    //   4104: lload 16
    //   4106: lstore 14
    //   4108: goto +93 -> 4201
    //   4111: astore 34
    //   4113: iload 10
    //   4115: istore 9
    //   4117: lload 16
    //   4119: lstore 14
    //   4121: goto +95 -> 4216
    //   4124: lload 28
    //   4126: lstore 22
    //   4128: goto +3 -> 4131
    //   4131: iload 10
    //   4133: istore 9
    //   4135: iload_2
    //   4136: istore 10
    //   4138: lload 18
    //   4140: lstore 24
    //   4142: goto -957 -> 3185
    //   4145: astore 34
    //   4147: goto +50 -> 4197
    //   4150: astore 34
    //   4152: goto +60 -> 4212
    //   4155: astore 34
    //   4157: goto +10 -> 4167
    //   4160: astore 34
    //   4162: goto +17 -> 4179
    //   4165: astore 34
    //   4167: iload 10
    //   4169: istore_2
    //   4170: iload 9
    //   4172: istore 10
    //   4174: goto +23 -> 4197
    //   4177: astore 34
    //   4179: iload 10
    //   4181: istore_2
    //   4182: iload 9
    //   4184: istore 10
    //   4186: goto +26 -> 4212
    //   4189: astore 34
    //   4191: iload_2
    //   4192: istore 10
    //   4194: iload 9
    //   4196: istore_2
    //   4197: iload 10
    //   4199: istore 9
    //   4201: goto +1825 -> 6026
    //   4204: astore 34
    //   4206: iload_2
    //   4207: istore 10
    //   4209: iload 9
    //   4211: istore_2
    //   4212: iload 10
    //   4214: istore 9
    //   4216: aload 32
    //   4218: astore 36
    //   4220: aload 30
    //   4222: astore 32
    //   4224: aload 36
    //   4226: astore 30
    //   4228: goto +297 -> 4525
    //   4231: astore 32
    //   4233: goto +10 -> 4243
    //   4236: astore 32
    //   4238: goto +14 -> 4252
    //   4241: astore 32
    //   4243: aload 32
    //   4245: astore 34
    //   4247: goto +233 -> 4480
    //   4250: astore 32
    //   4252: aload 32
    //   4254: astore 34
    //   4256: aload 30
    //   4258: astore 32
    //   4260: goto +252 -> 4512
    //   4263: astore 34
    //   4265: aconst_null
    //   4266: astore 30
    //   4268: goto +212 -> 4480
    //   4271: astore 34
    //   4273: goto +236 -> 4509
    //   4276: iload 9
    //   4278: istore 10
    //   4280: aconst_null
    //   4281: astore 30
    //   4283: aconst_null
    //   4284: astore 32
    //   4286: iload_2
    //   4287: istore 9
    //   4289: iload 10
    //   4291: istore_2
    //   4292: lload 12
    //   4294: lstore 20
    //   4296: iload_2
    //   4297: istore 11
    //   4299: iload 9
    //   4301: istore 10
    //   4303: lload 14
    //   4305: lstore 18
    //   4307: lload 12
    //   4309: lstore 16
    //   4311: aload_0
    //   4312: aload 32
    //   4314: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4317: lload 12
    //   4319: lstore 20
    //   4321: iload_2
    //   4322: istore 11
    //   4324: iload 9
    //   4326: istore 10
    //   4328: lload 14
    //   4330: lstore 18
    //   4332: lload 12
    //   4334: lstore 16
    //   4336: aload_0
    //   4337: aload 30
    //   4339: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4342: lload 12
    //   4344: lstore 20
    //   4346: iload_2
    //   4347: istore 11
    //   4349: iload 9
    //   4351: istore 10
    //   4353: lload 14
    //   4355: lstore 18
    //   4357: lload 12
    //   4359: lstore 16
    //   4361: aload_0
    //   4362: aload 31
    //   4364: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4367: lload 12
    //   4369: lstore 20
    //   4371: iload_2
    //   4372: istore 11
    //   4374: iload 9
    //   4376: istore 10
    //   4378: lload 14
    //   4380: lstore 18
    //   4382: lload 12
    //   4384: lstore 16
    //   4386: aload_0
    //   4387: getfield 613	com/tencent/smtt/sdk/l:t	Z
    //   4390: ifne +35 -> 4425
    //   4393: lload 12
    //   4395: lstore 20
    //   4397: iload_2
    //   4398: istore 11
    //   4400: iload 9
    //   4402: istore 10
    //   4404: lload 14
    //   4406: lstore 18
    //   4408: lload 12
    //   4410: lstore 16
    //   4412: aload_0
    //   4413: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4416: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4419: sipush -319
    //   4422: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4425: iload_1
    //   4426: ifne +36 -> 4462
    //   4429: aload_0
    //   4430: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4433: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4436: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4439: aload 33
    //   4441: lload 12
    //   4443: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4446: invokeinterface 556 3 0
    //   4451: pop
    //   4452: aload_0
    //   4453: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4456: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4459: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4462: iload_2
    //   4463: istore 10
    //   4465: iload 9
    //   4467: istore 11
    //   4469: goto +1032 -> 5501
    //   4472: astore 34
    //   4474: aconst_null
    //   4475: astore 30
    //   4477: aconst_null
    //   4478: astore 31
    //   4480: iload_2
    //   4481: istore 10
    //   4483: iload 9
    //   4485: istore_2
    //   4486: aconst_null
    //   4487: astore 32
    //   4489: aload 31
    //   4491: astore 36
    //   4493: aload 32
    //   4495: astore 31
    //   4497: iload 10
    //   4499: istore 9
    //   4501: goto +631 -> 5132
    //   4504: astore 34
    //   4506: aconst_null
    //   4507: astore 31
    //   4509: aconst_null
    //   4510: astore 32
    //   4512: iload_2
    //   4513: istore 10
    //   4515: iload 9
    //   4517: istore_2
    //   4518: aconst_null
    //   4519: astore 30
    //   4521: iload 10
    //   4523: istore 9
    //   4525: aload 34
    //   4527: invokevirtual 1104	java/io/IOException:printStackTrace	()V
    //   4530: aload 34
    //   4532: instanceof 1106
    //   4535: ifne +382 -> 4917
    //   4538: aload 34
    //   4540: instanceof 1108
    //   4543: ifeq +6 -> 4549
    //   4546: goto +371 -> 4917
    //   4549: iload_1
    //   4550: ifne +219 -> 4769
    //   4553: aload_0
    //   4554: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4557: invokestatic 943	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   4560: ifne +209 -> 4769
    //   4563: new 110	java/lang/StringBuilder
    //   4566: dup
    //   4567: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   4570: astore 34
    //   4572: aload 34
    //   4574: ldc_w 1075
    //   4577: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4580: pop
    //   4581: aload 34
    //   4583: invokestatic 1077	com/tencent/smtt/utils/p:a	()J
    //   4586: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4589: pop
    //   4590: aload 34
    //   4592: ldc_w 1079
    //   4595: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4598: pop
    //   4599: aload 34
    //   4601: aload_0
    //   4602: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4605: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4608: invokevirtual 1082	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4611: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4614: pop
    //   4615: aload_0
    //   4616: bipush 105
    //   4618: aload 34
    //   4620: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4623: iconst_1
    //   4624: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4627: aload_0
    //   4628: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4631: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4634: sipush -308
    //   4637: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4640: iload_2
    //   4641: istore 11
    //   4643: lload 12
    //   4645: lstore 20
    //   4647: iload 9
    //   4649: istore 10
    //   4651: lload 14
    //   4653: lstore 18
    //   4655: lload 12
    //   4657: lstore 16
    //   4659: aload_0
    //   4660: aload 30
    //   4662: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4665: iload_2
    //   4666: istore 11
    //   4668: lload 12
    //   4670: lstore 20
    //   4672: iload 9
    //   4674: istore 10
    //   4676: lload 14
    //   4678: lstore 18
    //   4680: lload 12
    //   4682: lstore 16
    //   4684: aload_0
    //   4685: aload 32
    //   4687: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4690: iload_2
    //   4691: istore 11
    //   4693: lload 12
    //   4695: lstore 20
    //   4697: iload 9
    //   4699: istore 10
    //   4701: lload 14
    //   4703: lstore 18
    //   4705: lload 12
    //   4707: lstore 16
    //   4709: aload_0
    //   4710: aload 31
    //   4712: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4715: iload_2
    //   4716: istore 10
    //   4718: iload 9
    //   4720: istore 11
    //   4722: iload_1
    //   4723: ifne +778 -> 5501
    //   4726: iload_2
    //   4727: istore 10
    //   4729: aload_0
    //   4730: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4733: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4736: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4739: aload 33
    //   4741: lload 12
    //   4743: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4746: invokeinterface 556 3 0
    //   4751: pop
    //   4752: aload_0
    //   4753: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4756: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4759: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4762: iload 9
    //   4764: istore 11
    //   4766: goto +735 -> 5501
    //   4769: aload_0
    //   4770: lconst_0
    //   4771: invokespecial 1008	com/tencent/smtt/sdk/l:a	(J)V
    //   4774: aload_0
    //   4775: invokespecial 1110	com/tencent/smtt/sdk/l:k	()Z
    //   4778: ifne +27 -> 4805
    //   4781: bipush 106
    //   4783: istore 7
    //   4785: aload_0
    //   4786: aload 34
    //   4788: invokespecial 527	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4791: astore 34
    //   4793: aload_0
    //   4794: iload 7
    //   4796: aload 34
    //   4798: iconst_0
    //   4799: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4802: goto +18 -> 4820
    //   4805: bipush 104
    //   4807: istore 7
    //   4809: aload_0
    //   4810: aload 34
    //   4812: invokespecial 527	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4815: astore 34
    //   4817: goto -24 -> 4793
    //   4820: iload_2
    //   4821: istore 11
    //   4823: lload 12
    //   4825: lstore 20
    //   4827: iload 9
    //   4829: istore 10
    //   4831: lload 14
    //   4833: lstore 18
    //   4835: lload 12
    //   4837: lstore 16
    //   4839: aload_0
    //   4840: aload 30
    //   4842: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4845: iload_2
    //   4846: istore 11
    //   4848: lload 12
    //   4850: lstore 20
    //   4852: iload 9
    //   4854: istore 10
    //   4856: lload 14
    //   4858: lstore 18
    //   4860: lload 12
    //   4862: lstore 16
    //   4864: aload_0
    //   4865: aload 32
    //   4867: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4870: iload_2
    //   4871: istore 11
    //   4873: lload 12
    //   4875: lstore 20
    //   4877: iload 9
    //   4879: istore 10
    //   4881: lload 14
    //   4883: lstore 18
    //   4885: lload 12
    //   4887: lstore 16
    //   4889: aload_0
    //   4890: aload 31
    //   4892: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4895: iload_2
    //   4896: istore 10
    //   4898: lload 12
    //   4900: lstore 16
    //   4902: iload 9
    //   4904: istore 11
    //   4906: lload 14
    //   4908: lstore 18
    //   4910: iload_1
    //   4911: ifne +173 -> 5084
    //   4914: goto +122 -> 5036
    //   4917: aload_0
    //   4918: ldc_w 1111
    //   4921: putfield 73	com/tencent/smtt/sdk/l:n	I
    //   4924: aload_0
    //   4925: lconst_0
    //   4926: invokespecial 1008	com/tencent/smtt/sdk/l:a	(J)V
    //   4929: aload_0
    //   4930: bipush 103
    //   4932: aload_0
    //   4933: aload 34
    //   4935: invokespecial 527	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4938: iconst_0
    //   4939: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4942: iload_2
    //   4943: istore 11
    //   4945: lload 12
    //   4947: lstore 20
    //   4949: iload 9
    //   4951: istore 10
    //   4953: lload 14
    //   4955: lstore 18
    //   4957: lload 12
    //   4959: lstore 16
    //   4961: aload_0
    //   4962: aload 30
    //   4964: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4967: iload_2
    //   4968: istore 11
    //   4970: lload 12
    //   4972: lstore 20
    //   4974: iload 9
    //   4976: istore 10
    //   4978: lload 14
    //   4980: lstore 18
    //   4982: lload 12
    //   4984: lstore 16
    //   4986: aload_0
    //   4987: aload 32
    //   4989: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4992: iload_2
    //   4993: istore 11
    //   4995: lload 12
    //   4997: lstore 20
    //   4999: iload 9
    //   5001: istore 10
    //   5003: lload 14
    //   5005: lstore 18
    //   5007: lload 12
    //   5009: lstore 16
    //   5011: aload_0
    //   5012: aload 31
    //   5014: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5017: iload_2
    //   5018: istore 10
    //   5020: lload 12
    //   5022: lstore 16
    //   5024: iload 9
    //   5026: istore 11
    //   5028: lload 14
    //   5030: lstore 18
    //   5032: iload_1
    //   5033: ifne +51 -> 5084
    //   5036: aload_0
    //   5037: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5040: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5043: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5046: aload 33
    //   5048: lload 12
    //   5050: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5053: invokeinterface 556 3 0
    //   5058: pop
    //   5059: aload_0
    //   5060: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5063: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5066: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5069: lload 14
    //   5071: lstore 18
    //   5073: iload 9
    //   5075: istore 11
    //   5077: lload 12
    //   5079: lstore 16
    //   5081: iload_2
    //   5082: istore 10
    //   5084: iload 11
    //   5086: istore_2
    //   5087: lload 18
    //   5089: lstore 14
    //   5091: lload 16
    //   5093: lstore 12
    //   5095: goto +904 -> 5999
    //   5098: astore 30
    //   5100: iload 11
    //   5102: istore 9
    //   5104: lload 20
    //   5106: lstore 12
    //   5108: iload 10
    //   5110: istore_2
    //   5111: lload 18
    //   5113: lstore 14
    //   5115: goto +158 -> 5273
    //   5118: astore 34
    //   5120: aload 31
    //   5122: astore 36
    //   5124: aload 30
    //   5126: astore 31
    //   5128: aload 32
    //   5130: astore 30
    //   5132: lload 12
    //   5134: lstore 20
    //   5136: iload_2
    //   5137: istore 11
    //   5139: iload 9
    //   5141: istore 10
    //   5143: lload 14
    //   5145: lstore 18
    //   5147: lload 12
    //   5149: lstore 16
    //   5151: aload_0
    //   5152: aload 31
    //   5154: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5157: lload 12
    //   5159: lstore 20
    //   5161: iload_2
    //   5162: istore 11
    //   5164: iload 9
    //   5166: istore 10
    //   5168: lload 14
    //   5170: lstore 18
    //   5172: lload 12
    //   5174: lstore 16
    //   5176: aload_0
    //   5177: aload 30
    //   5179: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5182: lload 12
    //   5184: lstore 20
    //   5186: iload_2
    //   5187: istore 11
    //   5189: iload 9
    //   5191: istore 10
    //   5193: lload 14
    //   5195: lstore 18
    //   5197: lload 12
    //   5199: lstore 16
    //   5201: aload_0
    //   5202: aload 36
    //   5204: invokespecial 724	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   5207: lload 12
    //   5209: lstore 20
    //   5211: iload_2
    //   5212: istore 11
    //   5214: iload 9
    //   5216: istore 10
    //   5218: lload 14
    //   5220: lstore 18
    //   5222: lload 12
    //   5224: lstore 16
    //   5226: aload 34
    //   5228: athrow
    //   5229: astore 30
    //   5231: lload 20
    //   5233: lstore 12
    //   5235: iload 10
    //   5237: istore_2
    //   5238: lload 18
    //   5240: lstore 14
    //   5242: goto +9 -> 5251
    //   5245: astore 30
    //   5247: iload 9
    //   5249: istore 11
    //   5251: iload 11
    //   5253: istore 9
    //   5255: aload 30
    //   5257: astore 31
    //   5259: goto +18 -> 5277
    //   5262: astore 30
    //   5264: goto +646 -> 5910
    //   5267: astore 30
    //   5269: iload 10
    //   5271: istore 9
    //   5273: aload 30
    //   5275: astore 31
    //   5277: aload 33
    //   5279: astore 30
    //   5281: lload 12
    //   5283: lstore 16
    //   5285: aload 31
    //   5287: instanceof 1113
    //   5290: ifeq +127 -> 5417
    //   5293: iload_1
    //   5294: ifne +123 -> 5417
    //   5297: lload 12
    //   5299: lstore 16
    //   5301: aload_0
    //   5302: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   5305: ifnull +112 -> 5417
    //   5308: lload 12
    //   5310: lstore 16
    //   5312: aload_0
    //   5313: iconst_0
    //   5314: invokevirtual 1022	com/tencent/smtt/sdk/l:b	(Z)Z
    //   5317: ifeq +100 -> 5417
    //   5320: lload 12
    //   5322: lstore 16
    //   5324: new 110	java/lang/StringBuilder
    //   5327: dup
    //   5328: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   5331: astore 32
    //   5333: lload 12
    //   5335: lstore 16
    //   5337: aload 32
    //   5339: ldc_w 1115
    //   5342: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5345: pop
    //   5346: lload 12
    //   5348: lstore 16
    //   5350: aload 32
    //   5352: aload_0
    //   5353: getfield 607	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   5356: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5359: pop
    //   5360: lload 12
    //   5362: lstore 16
    //   5364: aload 32
    //   5366: ldc_w 1117
    //   5369: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5372: pop
    //   5373: lload 12
    //   5375: lstore 16
    //   5377: aload 32
    //   5379: aload 31
    //   5381: invokevirtual 394	java/lang/Throwable:toString	()Ljava/lang/String;
    //   5384: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5387: pop
    //   5388: lload 12
    //   5390: lstore 16
    //   5392: ldc 203
    //   5394: aload 32
    //   5396: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5399: invokestatic 208	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5402: lload 12
    //   5404: lstore 16
    //   5406: aload_0
    //   5407: bipush 125
    //   5409: aconst_null
    //   5410: iconst_1
    //   5411: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5414: goto +412 -> 5826
    //   5417: lload 12
    //   5419: lstore 16
    //   5421: aload 31
    //   5423: invokevirtual 725	java/lang/Throwable:printStackTrace	()V
    //   5426: lload 12
    //   5428: lstore 16
    //   5430: aload_0
    //   5431: lconst_0
    //   5432: invokespecial 1008	com/tencent/smtt/sdk/l:a	(J)V
    //   5435: lload 12
    //   5437: lstore 16
    //   5439: aload_0
    //   5440: bipush 107
    //   5442: aload_0
    //   5443: aload 31
    //   5445: invokespecial 527	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5448: iconst_0
    //   5449: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5452: lload 12
    //   5454: lstore 16
    //   5456: aload_0
    //   5457: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   5460: ifeq +366 -> 5826
    //   5463: lload 12
    //   5465: lstore 16
    //   5467: aload_0
    //   5468: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5471: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5474: sipush -309
    //   5477: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5480: iload 9
    //   5482: istore 10
    //   5484: iload_2
    //   5485: istore 11
    //   5487: iload_1
    //   5488: ifne +13 -> 5501
    //   5491: iload 9
    //   5493: istore 10
    //   5495: iload_2
    //   5496: istore 9
    //   5498: goto -769 -> 4729
    //   5501: aload_0
    //   5502: getfield 611	com/tencent/smtt/sdk/l:s	Z
    //   5505: ifne +316 -> 5821
    //   5508: iload 10
    //   5510: istore_1
    //   5511: aload_0
    //   5512: getfield 613	com/tencent/smtt/sdk/l:t	Z
    //   5515: ifeq +162 -> 5677
    //   5518: aload_0
    //   5519: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   5522: ifnonnull +20 -> 5542
    //   5525: iload 10
    //   5527: ifne +15 -> 5542
    //   5530: aload_0
    //   5531: iconst_1
    //   5532: iload 11
    //   5534: invokespecial 871	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   5537: istore 10
    //   5539: goto +3 -> 5542
    //   5542: aload_0
    //   5543: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   5546: astore 30
    //   5548: iload 10
    //   5550: ifeq +9 -> 5559
    //   5553: iconst_1
    //   5554: istore 7
    //   5556: goto +6 -> 5562
    //   5559: iconst_0
    //   5560: istore 7
    //   5562: aload 30
    //   5564: iload 7
    //   5566: invokevirtual 1120	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   5569: iload 11
    //   5571: ifne +26 -> 5597
    //   5574: aload_0
    //   5575: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   5578: astore 30
    //   5580: iload 10
    //   5582: ifeq +9 -> 5591
    //   5585: iconst_1
    //   5586: istore 7
    //   5588: goto +18 -> 5606
    //   5591: iconst_2
    //   5592: istore 7
    //   5594: goto +12 -> 5606
    //   5597: aload_0
    //   5598: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   5601: astore 30
    //   5603: iconst_0
    //   5604: istore 7
    //   5606: aload 30
    //   5608: iload 7
    //   5610: invokevirtual 1123	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   5613: iload 10
    //   5615: ifeq +37 -> 5652
    //   5618: aload_0
    //   5619: iconst_1
    //   5620: invokespecial 865	com/tencent/smtt/sdk/l:d	(Z)V
    //   5623: aload_0
    //   5624: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5627: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5630: sipush -317
    //   5633: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5636: aload_0
    //   5637: bipush 100
    //   5639: ldc_w 1125
    //   5642: iconst_1
    //   5643: invokespecial 529	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5646: iload 10
    //   5648: istore_1
    //   5649: goto +28 -> 5677
    //   5652: aload_0
    //   5653: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5656: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5659: sipush -318
    //   5662: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5665: aload_0
    //   5666: iconst_0
    //   5667: invokespecial 873	com/tencent/smtt/sdk/l:e	(Z)Z
    //   5670: pop
    //   5671: iload 10
    //   5673: istore_1
    //   5674: goto +3 -> 5677
    //   5677: iconst_0
    //   5678: istore 7
    //   5680: aload_0
    //   5681: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5684: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5687: astore 30
    //   5689: iload_1
    //   5690: ifeq +43 -> 5733
    //   5693: aload 30
    //   5695: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   5698: ldc_w 1127
    //   5701: iconst_0
    //   5702: invokeinterface 311 3 0
    //   5707: istore 8
    //   5709: aload 30
    //   5711: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5714: ldc_w 1127
    //   5717: iload 8
    //   5719: iconst_1
    //   5720: iadd
    //   5721: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5724: invokeinterface 556 3 0
    //   5729: pop
    //   5730: goto +66 -> 5796
    //   5733: aload 30
    //   5735: getfield 303	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   5738: ldc_w 1129
    //   5741: iconst_0
    //   5742: invokeinterface 311 3 0
    //   5747: istore 8
    //   5749: aload 30
    //   5751: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5754: astore 31
    //   5756: iload 8
    //   5758: iconst_1
    //   5759: iadd
    //   5760: istore 8
    //   5762: aload 31
    //   5764: ldc_w 1129
    //   5767: iload 8
    //   5769: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5772: invokeinterface 556 3 0
    //   5777: pop
    //   5778: iload 8
    //   5780: aload 30
    //   5782: invokevirtual 1132	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   5785: if_icmpne +11 -> 5796
    //   5788: aload_0
    //   5789: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   5792: iconst_2
    //   5793: invokevirtual 975	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   5796: aload 30
    //   5798: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5801: aload_0
    //   5802: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   5805: astore 30
    //   5807: iload_1
    //   5808: ifeq +6 -> 5814
    //   5811: iconst_1
    //   5812: istore 7
    //   5814: aload 30
    //   5816: iload 7
    //   5818: invokevirtual 1135	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   5821: aload_0
    //   5822: invokespecial 1137	com/tencent/smtt/sdk/l:h	()V
    //   5825: return
    //   5826: lload 12
    //   5828: lstore 16
    //   5830: aload_0
    //   5831: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5834: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5837: sipush -316
    //   5840: invokevirtual 863	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5843: iload_1
    //   5844: ifne +36 -> 5880
    //   5847: aload_0
    //   5848: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5851: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5854: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5857: aload 30
    //   5859: lload 12
    //   5861: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5864: invokeinterface 556 3 0
    //   5869: pop
    //   5870: aload_0
    //   5871: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5874: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5877: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5880: aconst_null
    //   5881: astore 31
    //   5883: lconst_0
    //   5884: lstore 16
    //   5886: aload 30
    //   5888: astore 33
    //   5890: aload 31
    //   5892: astore 30
    //   5894: iload 9
    //   5896: istore 10
    //   5898: goto -5317 -> 581
    //   5901: astore 30
    //   5903: lload 16
    //   5905: lstore 12
    //   5907: goto -643 -> 5264
    //   5910: iload_1
    //   5911: ifne +36 -> 5947
    //   5914: aload_0
    //   5915: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5918: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5921: getfield 543	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5924: aload 33
    //   5926: lload 12
    //   5928: invokestatic 937	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5931: invokeinterface 556 3 0
    //   5936: pop
    //   5937: aload_0
    //   5938: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5941: invokestatic 299	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5944: invokevirtual 563	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5947: goto +6 -> 5953
    //   5950: aload 30
    //   5952: athrow
    //   5953: goto -3 -> 5950
    //   5956: iconst_1
    //   5957: istore 7
    //   5959: goto -4342 -> 1617
    //   5962: iload 7
    //   5964: sipush 403
    //   5967: if_icmpeq -3673 -> 2294
    //   5970: iload 7
    //   5972: sipush 406
    //   5975: if_icmpne -3642 -> 2333
    //   5978: goto -3684 -> 2294
    //   5981: iload_1
    //   5982: ifne +13 -> 5995
    //   5985: goto -3640 -> 2345
    //   5988: iload_1
    //   5989: ifne +6 -> 5995
    //   5992: goto -3647 -> 2345
    //   5995: iload 9
    //   5997: istore 10
    //   5999: aconst_null
    //   6000: astore 30
    //   6002: lconst_0
    //   6003: lstore 16
    //   6005: goto -5424 -> 581
    //   6008: astore 34
    //   6010: iload 9
    //   6012: istore 10
    //   6014: aconst_null
    //   6015: astore 30
    //   6017: aconst_null
    //   6018: astore 32
    //   6020: iload_2
    //   6021: istore 9
    //   6023: iload 10
    //   6025: istore_2
    //   6026: aload 31
    //   6028: astore 36
    //   6030: aload 32
    //   6032: astore 31
    //   6034: goto -902 -> 5132
    //   6037: astore 31
    //   6039: iload 9
    //   6041: istore 10
    //   6043: aconst_null
    //   6044: astore 32
    //   6046: aconst_null
    //   6047: astore 30
    //   6049: iload_2
    //   6050: istore 9
    //   6052: iload 10
    //   6054: istore_2
    //   6055: aload 34
    //   6057: astore 36
    //   6059: aload 31
    //   6061: astore 34
    //   6063: aload 36
    //   6065: astore 31
    //   6067: goto -1542 -> 4525
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6070	0	this	l
    //   0	6070	1	paramBoolean1	boolean
    //   0	6070	2	paramBoolean2	boolean
    //   3785	24	3	d1	double
    //   3795	15	5	d2	double
    //   59	5917	7	i1	int
    //   1692	4094	8	i2	int
    //   83	5968	9	bool1	boolean
    //   576	5477	10	bool2	boolean
    //   1714	3856	11	bool3	boolean
    //   550	5377	12	l1	long
    //   517	4724	14	l2	long
    //   532	5472	16	l3	long
    //   657	4582	18	l4	long
    //   677	4555	20	l5	long
    //   3168	959	22	l6	long
    //   3180	961	24	l7	long
    //   632	3059	26	l8	long
    //   3695	430	28	l9	long
    //   128	861	30	localObject1	Object
    //   1000	1	30	localObject2	Object
    //   1005	1	30	localThrowable1	Throwable
    //   1014	1	30	localObject3	Object
    //   1019	1	30	localThrowable2	Throwable
    //   1037	20	30	str1	String
    //   1061	1	30	localObject4	Object
    //   1070	1	30	localThrowable3	Throwable
    //   1083	483	30	localObject5	Object
    //   1581	1	30	localThrowable4	Throwable
    //   1586	1	30	localThrowable5	Throwable
    //   1602	462	30	localObject6	Object
    //   2252	1	30	localThrowable6	Throwable
    //   2645	2318	30	localObject7	Object
    //   5098	27	30	localThrowable7	Throwable
    //   5130	48	30	localObject8	Object
    //   5229	1	30	localThrowable8	Throwable
    //   5245	11	30	localThrowable9	Throwable
    //   5262	1	30	localObject9	Object
    //   5267	7	30	localThrowable10	Throwable
    //   5279	614	30	localObject10	Object
    //   5901	50	30	localObject11	Object
    //   6000	48	30	localObject12	Object
    //   125	3002	31	localObject13	Object
    //   3225	1	31	localIOException1	IOException
    //   3356	8	31	localIOException2	IOException
    //   3369	1	31	localObject14	Object
    //   3374	11	31	localIOException3	IOException
    //   3390	1	31	localObject15	Object
    //   3535	1	31	localIOException4	IOException
    //   3664	1	31	localIOException5	IOException
    //   3837	526	31	localIOException6	IOException
    //   4478	1555	31	localObject16	Object
    //   6037	23	31	localIOException7	IOException
    //   6065	1	31	localObject17	Object
    //   173	4050	32	localObject18	Object
    //   4231	1	32	localObject19	Object
    //   4236	1	32	localIOException8	IOException
    //   4241	3	32	localObject20	Object
    //   4250	3	32	localIOException9	IOException
    //   4258	1787	32	localObject21	Object
    //   537	5388	33	localObject22	Object
    //   3038	3	34	localInputStream	java.io.InputStream
    //   3351	1	34	localObject23	Object
    //   3361	20	34	localObject24	Object
    //   3386	1	34	localIOException10	IOException
    //   3522	1	34	localObject25	Object
    //   3655	1	34	localObject26	Object
    //   3832	1	34	localObject27	Object
    //   3947	3	34	localTbsDownloadConfig	TbsDownloadConfig
    //   4065	1	34	localObject28	Object
    //   4078	1	34	localIOException11	IOException
    //   4098	1	34	localObject29	Object
    //   4111	1	34	localIOException12	IOException
    //   4145	1	34	localObject30	Object
    //   4150	1	34	localIOException13	IOException
    //   4155	1	34	localObject31	Object
    //   4160	1	34	localIOException14	IOException
    //   4165	1	34	localObject32	Object
    //   4177	1	34	localIOException15	IOException
    //   4189	1	34	localObject33	Object
    //   4204	1	34	localIOException16	IOException
    //   4245	10	34	localObject34	Object
    //   4263	1	34	localObject35	Object
    //   4271	1	34	localIOException17	IOException
    //   4472	1	34	localObject36	Object
    //   4504	35	34	localIOException18	IOException
    //   4570	364	34	localObject37	Object
    //   5118	109	34	localObject38	Object
    //   6008	48	34	localObject39	Object
    //   6061	1	34	localIOException19	IOException
    //   3	703	35	str2	String
    //   3135	2929	36	localObject40	Object
    //   3723	55	37	localObject41	Object
    // Exception table:
    //   from	to	target	type
    //   788	806	1000	finally
    //   818	849	1000	finally
    //   788	806	1005	java/lang/Throwable
    //   818	849	1005	java/lang/Throwable
    //   638	659	1014	finally
    //   770	788	1014	finally
    //   638	659	1019	java/lang/Throwable
    //   770	788	1019	java/lang/Throwable
    //   679	687	1061	finally
    //   695	718	1061	finally
    //   726	749	1061	finally
    //   757	767	1061	finally
    //   909	919	1061	finally
    //   927	936	1061	finally
    //   944	953	1061	finally
    //   961	974	1061	finally
    //   1052	1058	1061	finally
    //   1165	1174	1061	finally
    //   1201	1207	1061	finally
    //   1211	1220	1061	finally
    //   1224	1233	1061	finally
    //   1237	1245	1061	finally
    //   1249	1259	1061	finally
    //   1263	1272	1061	finally
    //   1276	1285	1061	finally
    //   1289	1298	1061	finally
    //   1302	1310	1061	finally
    //   1314	1325	1061	finally
    //   1329	1335	1061	finally
    //   1339	1348	1061	finally
    //   1352	1361	1061	finally
    //   1365	1373	1061	finally
    //   1377	1386	1061	finally
    //   1390	1403	1061	finally
    //   1410	1419	1061	finally
    //   1423	1432	1061	finally
    //   1436	1444	1061	finally
    //   1448	1457	1061	finally
    //   1461	1471	1061	finally
    //   1475	1486	1061	finally
    //   1490	1496	1061	finally
    //   1500	1509	1061	finally
    //   1513	1522	1061	finally
    //   1526	1534	1061	finally
    //   1538	1547	1061	finally
    //   1551	1561	1061	finally
    //   1565	1578	1061	finally
    //   1657	1665	1061	finally
    //   1669	1675	1061	finally
    //   1679	1685	1061	finally
    //   1705	1716	1061	finally
    //   1757	1771	1061	finally
    //   1833	1843	1061	finally
    //   1847	1858	1061	finally
    //   1862	1872	1061	finally
    //   1876	1882	1061	finally
    //   1886	1890	1061	finally
    //   1894	1900	1061	finally
    //   1904	1914	1061	finally
    //   1918	1927	1061	finally
    //   1942	1955	1061	finally
    //   2034	2046	1061	finally
    //   2050	2058	1061	finally
    //   2062	2068	1061	finally
    //   2072	2082	1061	finally
    //   2116	2124	1061	finally
    //   2128	2141	1061	finally
    //   2152	2164	1061	finally
    //   2176	2184	1061	finally
    //   2193	2206	1061	finally
    //   2264	2270	1061	finally
    //   2274	2287	1061	finally
    //   2298	2309	1061	finally
    //   2313	2326	1061	finally
    //   2385	2396	1061	finally
    //   2408	2425	1061	finally
    //   2429	2436	1061	finally
    //   2440	2453	1061	finally
    //   2464	2475	1061	finally
    //   2511	2516	1061	finally
    //   2520	2527	1061	finally
    //   2531	2544	1061	finally
    //   2555	2564	1061	finally
    //   2568	2575	1061	finally
    //   2587	2592	1061	finally
    //   2603	2616	1061	finally
    //   2719	2729	1061	finally
    //   2733	2742	1061	finally
    //   2746	2755	1061	finally
    //   2759	2767	1061	finally
    //   2771	2780	1061	finally
    //   2784	2794	1061	finally
    //   2798	2809	1061	finally
    //   2817	2824	1061	finally
    //   2828	2834	1061	finally
    //   2838	2848	1061	finally
    //   2852	2859	1061	finally
    //   2863	2871	1061	finally
    //   2882	2891	1061	finally
    //   2895	2904	1061	finally
    //   2908	2916	1061	finally
    //   2920	2929	1061	finally
    //   2933	2943	1061	finally
    //   2947	2959	1061	finally
    //   2963	2976	1061	finally
    //   2983	2993	1061	finally
    //   2997	3010	1061	finally
    //   679	687	1070	java/lang/Throwable
    //   695	718	1070	java/lang/Throwable
    //   726	749	1070	java/lang/Throwable
    //   757	767	1070	java/lang/Throwable
    //   909	919	1070	java/lang/Throwable
    //   927	936	1070	java/lang/Throwable
    //   944	953	1070	java/lang/Throwable
    //   961	974	1070	java/lang/Throwable
    //   1052	1058	1070	java/lang/Throwable
    //   1165	1174	1070	java/lang/Throwable
    //   1263	1272	1581	java/lang/Throwable
    //   1276	1285	1581	java/lang/Throwable
    //   1289	1298	1581	java/lang/Throwable
    //   1302	1310	1581	java/lang/Throwable
    //   1314	1325	1581	java/lang/Throwable
    //   1329	1335	1581	java/lang/Throwable
    //   1339	1348	1581	java/lang/Throwable
    //   1352	1361	1581	java/lang/Throwable
    //   1365	1373	1581	java/lang/Throwable
    //   1377	1386	1581	java/lang/Throwable
    //   1390	1403	1581	java/lang/Throwable
    //   1410	1419	1581	java/lang/Throwable
    //   1423	1432	1581	java/lang/Throwable
    //   1436	1444	1581	java/lang/Throwable
    //   1448	1457	1581	java/lang/Throwable
    //   1461	1471	1581	java/lang/Throwable
    //   1475	1486	1581	java/lang/Throwable
    //   1490	1496	1581	java/lang/Throwable
    //   1500	1509	1581	java/lang/Throwable
    //   1513	1522	1581	java/lang/Throwable
    //   1526	1534	1581	java/lang/Throwable
    //   1538	1547	1581	java/lang/Throwable
    //   1551	1561	1581	java/lang/Throwable
    //   1565	1578	1581	java/lang/Throwable
    //   1657	1665	1581	java/lang/Throwable
    //   1669	1675	1581	java/lang/Throwable
    //   1679	1685	1581	java/lang/Throwable
    //   1705	1716	1581	java/lang/Throwable
    //   1757	1771	1581	java/lang/Throwable
    //   1833	1843	1581	java/lang/Throwable
    //   1847	1858	1581	java/lang/Throwable
    //   1862	1872	1581	java/lang/Throwable
    //   1876	1882	1581	java/lang/Throwable
    //   1886	1890	1581	java/lang/Throwable
    //   1894	1900	1581	java/lang/Throwable
    //   1904	1914	1581	java/lang/Throwable
    //   1918	1927	1581	java/lang/Throwable
    //   1942	1955	1581	java/lang/Throwable
    //   2034	2046	1581	java/lang/Throwable
    //   2050	2058	1581	java/lang/Throwable
    //   2062	2068	1581	java/lang/Throwable
    //   2072	2082	1581	java/lang/Throwable
    //   2116	2124	1581	java/lang/Throwable
    //   2128	2141	1581	java/lang/Throwable
    //   2152	2164	1581	java/lang/Throwable
    //   2176	2184	1581	java/lang/Throwable
    //   2264	2270	1581	java/lang/Throwable
    //   2274	2287	1581	java/lang/Throwable
    //   2298	2309	1581	java/lang/Throwable
    //   2313	2326	1581	java/lang/Throwable
    //   2385	2396	1581	java/lang/Throwable
    //   2408	2425	1581	java/lang/Throwable
    //   2429	2436	1581	java/lang/Throwable
    //   2440	2453	1581	java/lang/Throwable
    //   2464	2475	1581	java/lang/Throwable
    //   2511	2516	1581	java/lang/Throwable
    //   2520	2527	1581	java/lang/Throwable
    //   2531	2544	1581	java/lang/Throwable
    //   2555	2564	1581	java/lang/Throwable
    //   2568	2575	1581	java/lang/Throwable
    //   2587	2592	1581	java/lang/Throwable
    //   2603	2616	1581	java/lang/Throwable
    //   2719	2729	1581	java/lang/Throwable
    //   2733	2742	1581	java/lang/Throwable
    //   2746	2755	1581	java/lang/Throwable
    //   2759	2767	1581	java/lang/Throwable
    //   2771	2780	1581	java/lang/Throwable
    //   2784	2794	1581	java/lang/Throwable
    //   2798	2809	1581	java/lang/Throwable
    //   2817	2824	1581	java/lang/Throwable
    //   2828	2834	1581	java/lang/Throwable
    //   2838	2848	1581	java/lang/Throwable
    //   2852	2859	1581	java/lang/Throwable
    //   2863	2871	1581	java/lang/Throwable
    //   2882	2891	1581	java/lang/Throwable
    //   2895	2904	1581	java/lang/Throwable
    //   2908	2916	1581	java/lang/Throwable
    //   2920	2929	1581	java/lang/Throwable
    //   2933	2943	1581	java/lang/Throwable
    //   2947	2959	1581	java/lang/Throwable
    //   2963	2976	1581	java/lang/Throwable
    //   2983	2993	1581	java/lang/Throwable
    //   2997	3010	1581	java/lang/Throwable
    //   1201	1207	1586	java/lang/Throwable
    //   1211	1220	1586	java/lang/Throwable
    //   1224	1233	1586	java/lang/Throwable
    //   1237	1245	1586	java/lang/Throwable
    //   1249	1259	1586	java/lang/Throwable
    //   2193	2206	2252	java/lang/Throwable
    //   3194	3216	3225	java/io/IOException
    //   3335	3348	3351	finally
    //   3335	3348	3356	java/io/IOException
    //   3266	3283	3361	finally
    //   3287	3295	3361	finally
    //   3301	3306	3361	finally
    //   3314	3325	3361	finally
    //   3266	3283	3374	java/io/IOException
    //   3287	3295	3374	java/io/IOException
    //   3301	3306	3374	java/io/IOException
    //   3314	3325	3374	java/io/IOException
    //   3442	3519	3522	finally
    //   3442	3519	3535	java/io/IOException
    //   3552	3648	3655	finally
    //   3552	3648	3664	java/io/IOException
    //   3786	3792	3832	finally
    //   3819	3829	3832	finally
    //   3887	3896	3832	finally
    //   3921	3931	3832	finally
    //   3786	3792	3837	java/io/IOException
    //   3819	3829	3837	java/io/IOException
    //   3887	3896	3837	java/io/IOException
    //   3921	3931	3837	java/io/IOException
    //   3949	3957	4065	finally
    //   3949	3957	4078	java/io/IOException
    //   3862	3881	4098	finally
    //   3901	3916	4098	finally
    //   3931	3949	4098	finally
    //   3862	3881	4111	java/io/IOException
    //   3901	3916	4111	java/io/IOException
    //   3931	3949	4111	java/io/IOException
    //   3682	3697	4145	finally
    //   3716	3777	4145	finally
    //   3682	3697	4150	java/io/IOException
    //   3716	3777	4150	java/io/IOException
    //   3248	3261	4155	finally
    //   3403	3418	4155	finally
    //   3248	3261	4160	java/io/IOException
    //   3403	3418	4160	java/io/IOException
    //   3185	3190	4165	finally
    //   3194	3216	4165	finally
    //   3185	3190	4177	java/io/IOException
    //   3165	3170	4189	finally
    //   3165	3170	4204	java/io/IOException
    //   3143	3165	4231	finally
    //   3143	3165	4236	java/io/IOException
    //   3130	3143	4241	finally
    //   3130	3143	4250	java/io/IOException
    //   3049	3058	4263	finally
    //   3049	3058	4271	java/io/IOException
    //   3031	3040	4472	finally
    //   3031	3040	4504	java/io/IOException
    //   3984	3990	5098	java/lang/Throwable
    //   4009	4015	5098	java/lang/Throwable
    //   4034	4040	5098	java/lang/Throwable
    //   4659	4665	5098	java/lang/Throwable
    //   4684	4690	5098	java/lang/Throwable
    //   4709	4715	5098	java/lang/Throwable
    //   4839	4845	5098	java/lang/Throwable
    //   4864	4870	5098	java/lang/Throwable
    //   4889	4895	5098	java/lang/Throwable
    //   4961	4967	5098	java/lang/Throwable
    //   4986	4992	5098	java/lang/Throwable
    //   5011	5017	5098	java/lang/Throwable
    //   4525	4546	5118	finally
    //   4553	4640	5118	finally
    //   4769	4781	5118	finally
    //   4785	4793	5118	finally
    //   4793	4802	5118	finally
    //   4809	4817	5118	finally
    //   4917	4942	5118	finally
    //   4311	4317	5229	java/lang/Throwable
    //   4336	4342	5229	java/lang/Throwable
    //   4361	4367	5229	java/lang/Throwable
    //   4386	4393	5229	java/lang/Throwable
    //   4412	4425	5229	java/lang/Throwable
    //   5151	5157	5229	java/lang/Throwable
    //   5176	5182	5229	java/lang/Throwable
    //   5201	5207	5229	java/lang/Throwable
    //   5226	5229	5229	java/lang/Throwable
    //   1598	1604	5245	java/lang/Throwable
    //   1617	1648	5245	java/lang/Throwable
    //   1688	1694	5245	java/lang/Throwable
    //   1721	1741	5245	java/lang/Throwable
    //   1741	1747	5245	java/lang/Throwable
    //   1771	1825	5245	java/lang/Throwable
    //   1927	1933	5245	java/lang/Throwable
    //   2623	2708	5245	java/lang/Throwable
    //   3023	3031	5245	java/lang/Throwable
    //   1028	1039	5262	finally
    //   1079	1085	5262	finally
    //   1085	1152	5262	finally
    //   1174	1192	5262	finally
    //   1598	1604	5262	finally
    //   1617	1648	5262	finally
    //   1688	1694	5262	finally
    //   1721	1741	5262	finally
    //   1741	1747	5262	finally
    //   1771	1825	5262	finally
    //   1927	1933	5262	finally
    //   2623	2708	5262	finally
    //   3023	3031	5262	finally
    //   1028	1039	5267	java/lang/Throwable
    //   1079	1085	5267	java/lang/Throwable
    //   1085	1152	5267	java/lang/Throwable
    //   1174	1192	5267	java/lang/Throwable
    //   3984	3990	5901	finally
    //   4009	4015	5901	finally
    //   4034	4040	5901	finally
    //   4311	4317	5901	finally
    //   4336	4342	5901	finally
    //   4361	4367	5901	finally
    //   4386	4393	5901	finally
    //   4412	4425	5901	finally
    //   4659	4665	5901	finally
    //   4684	4690	5901	finally
    //   4709	4715	5901	finally
    //   4839	4845	5901	finally
    //   4864	4870	5901	finally
    //   4889	4895	5901	finally
    //   4961	4967	5901	finally
    //   4986	4992	5901	finally
    //   5011	5017	5901	finally
    //   5151	5157	5901	finally
    //   5176	5182	5901	finally
    //   5201	5207	5901	finally
    //   5226	5229	5901	finally
    //   5285	5293	5901	finally
    //   5301	5308	5901	finally
    //   5312	5320	5901	finally
    //   5324	5333	5901	finally
    //   5337	5346	5901	finally
    //   5350	5360	5901	finally
    //   5364	5373	5901	finally
    //   5377	5388	5901	finally
    //   5392	5402	5901	finally
    //   5406	5414	5901	finally
    //   5421	5426	5901	finally
    //   5430	5435	5901	finally
    //   5439	5452	5901	finally
    //   5456	5463	5901	finally
    //   5467	5480	5901	finally
    //   5830	5843	5901	finally
    //   3063	3085	6008	finally
    //   3093	3123	6008	finally
    //   3063	3085	6037	java/io/IOException
    //   3093	3123	6037	java/io/IOException
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
        this.q = 0;
        this.r = 0;
        this.m = -1L;
        this.p = false;
        this.s = false;
        this.t = false;
        this.z = false;
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
    localStringBuilder.append(this.D);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    return this.D;
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
      this.z = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */