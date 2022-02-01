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
    this.v = ("tbs_downloading_" + this.h.getPackageName());
    p.a();
    this.l = p.s(this.h);
    if (this.l == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    g();
    this.x = null;
    this.y = -1;
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
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    File localFile = new File(FileUtil.a(paramContext, paramInt));
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org";; paramContext = TbsDownloader.getBackupFileName(false))
    {
      paramContext = new File(localFile, paramContext);
      if ((paramContext == null) || (!paramContext.exists())) {
        break;
      }
      return localFile;
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
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
      return "";
    }
    catch (Error paramURL)
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
    int i1 = 0;
    if (paramFile != null) {}
    for (;;)
    {
      File localFile;
      boolean bool2;
      try
      {
        if (!paramFile.exists()) {
          return;
        }
        try
        {
          localFile = a(paramContext);
          if (localFile != null)
          {
            if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1)
            {
              localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
              ((File)localObject1).delete();
              FileUtil.b(paramFile, (File)localObject1);
              boolean bool1 = ((File)localObject1).getName().contains("tbs.org");
              bool2 = ((File)localObject1).getName().contains("x5.tbs.decouple");
              if ((!bool2) && (!bool1)) {
                break label346;
              }
              localObject1 = localFile.listFiles();
              Pattern localPattern = Pattern.compile(a.a(bool2) + "(.*)");
              int i2 = localObject1.length;
              if (i1 >= i2) {
                break label258;
              }
              Object localObject2 = localObject1[i1];
              if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
                break label494;
              }
              localObject2.delete();
              break label494;
            }
            if (TbsDownloader.getOverSea(paramContext))
            {
              localObject1 = "x5.oversea.tbs.org";
              localObject1 = new File(localFile, (String)localObject1);
              continue;
            }
          }
          else
          {
            paramFile = finally;
          }
        }
        catch (Exception paramFile)
        {
          return;
        }
        localObject1 = TbsDownloader.getBackupFileName(false);
      }
      finally {}
      continue;
      label258:
      i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
      Object localObject1 = new File(localFile, a.a(bool2) + "." + i1);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
        return;
      }
      ((File)localObject1).createNewFile();
      label346:
      if ((TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) != 1) && (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0) == a.a(paramContext, paramFile)))
      {
        i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
        if ((i1 == 5) || (i1 == 3)) {
          TbsLog.i("TbsApkDownloader", "response code=" + i1 + "return backup decouple apk");
        }
        localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
        if (a.a(paramContext, paramFile) != a.a(paramContext, (File)localObject1))
        {
          ((File)localObject1).delete();
          FileUtil.b(paramFile, (File)localObject1);
          continue;
          label494:
          i1 += 1;
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    paramString = new URL(paramString);
    if (this.u != null) {}
    try
    {
      this.u.disconnect();
      this.u = ((HttpURLConnection)paramString.openConnection());
      this.u.setRequestProperty("User-Agent", TbsDownloader.b(this.h));
      this.u.setRequestProperty("Accept-Encoding", "identity");
      this.u.setRequestMethod("GET");
      this.u.setInstanceFollowRedirects(false);
      this.u.setConnectTimeout(this.o);
      this.u.setReadTimeout(this.n);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
      }
    }
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
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = a(paramContext, 4);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramContext, 2);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 1);
        }
        return localObject1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
      return null;
    }
    return null;
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    try
    {
      File localFile1 = new File(this.l, "x5.tbs");
      File localFile2 = a(this.h);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.h)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          FileUtil.b((File)localObject, localFile1);
          if (a.a(this.h, localFile1, 0L, paramInt)) {
            break;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          return false;
        }
        bool = true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      return false;
    }
    return bool;
  }
  
  public static void c(Context paramContext)
  {
    int i2 = 0;
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
          new File(paramContext, TbsDownloader.getBackupFileName(false)).delete();
          new File(paramContext, "x5.oversea.tbs.org").delete();
          paramContext = paramContext.listFiles();
          localObject1 = Pattern.compile(a.a(true) + "(.*)");
          int i3 = paramContext.length;
          i1 = 0;
          Object localObject2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label262;
            }
            localObject2.delete();
            break label262;
          }
          localObject1 = Pattern.compile(a.a(false) + "(.*)");
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
      catch (Exception paramContext) {}
      label262:
      i1 += 1;
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    Object localObject2 = this.l;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject1).exists()) {
        break label74;
      }
    }
    label74:
    Object localObject3;
    do
    {
      return false;
      localObject1 = "x5.tbs.temp";
      break;
      localObject2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getString("tbs_apk_md5", null);
      localObject3 = a.a((File)localObject1);
      if ((localObject2 != null) && (((String)localObject2).equals(localObject3))) {
        break label164;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
    } while (!paramBoolean1);
    this.w.setCheckErrorDetail("fileMd5 not match");
    return false;
    label164:
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = l2;
    long l3;
    if (paramBoolean1)
    {
      l3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
      if ((localObject1 == null) || (!((File)localObject1).exists())) {
        break label759;
      }
      l1 = l2;
      if (l3 > 0L)
      {
        l1 = ((File)localObject1).length();
        if (l3 == l1) {}
      }
    }
    for (;;)
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
      this.w.setCheckErrorDetail("fileLength:" + l1 + ",contentLength:" + l3);
      return false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l1 + ") successful!");
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
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
            if (!paramBoolean1) {
              break;
            }
            this.w.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i3);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i1 + ") successful!");
      if ((paramBoolean2) && (!paramBoolean1))
      {
        String str = b.a(this.h, false, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
          if (!paramBoolean1) {
            break;
          }
          localObject2 = this.w;
          localObject3 = new StringBuilder().append("signature:");
          if (str == null) {}
          for (localObject1 = "null";; localObject1 = Integer.valueOf(str.length()))
          {
            ((TbsLogReport.TbsLogInfo)localObject2).setCheckErrorDetail(localObject1);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if (paramBoolean1)
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.l, "x5.tbs"));
          localObject1 = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramBoolean1 = false;
          }
        }
        paramBoolean2 = paramBoolean1;
        if (paramBoolean1) {
          break label726;
        }
        a(109, a((Throwable)localObject1), true);
        return false;
      }
      paramBoolean2 = false;
      label726:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      return true;
      label759:
      l1 = 0L;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    com.tencent.smtt.utils.p.a(this.h);
    Object localObject1 = TbsDownloadConfig.getInstance(this.h);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("request_full_package", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject1).commit();
    Object localObject2 = QbSdk.m;
    if (paramBoolean) {}
    for (int i1 = 100;; i1 = 120)
    {
      ((TbsListener)localObject2).onDownloadFinish(i1);
      i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_responsecode", 0);
      paramBoolean = TbsDownloader.a(this.h);
      if (i1 != 5) {
        break label149;
      }
      localObject1 = a(i1, paramBoolean);
      if (localObject1 != null) {
        break;
      }
      return;
    }
    p.a().b(this.h, (Bundle)localObject1);
    return;
    label149:
    if ((i1 == 3) || (i1 > 10000))
    {
      localObject2 = a(this.h);
      if (localObject2 != null)
      {
        localObject1 = a(i1, (File)localObject2, paramBoolean);
        p.a().b(this.h, (Bundle)localObject1);
        return;
      }
      c();
      ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
      ((TbsDownloadConfig)localObject1).commit();
      return;
    }
    i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
    p.a().a(this.h, new File(this.l, "x5.tbs").getAbsolutePath(), i1);
    a(new File(this.l, "x5.tbs"), this.h);
  }
  
  private boolean e(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.l, "x5.tbs");; localFile = new File(this.l, "x5.tbs.temp"))
    {
      if ((localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      return true;
    }
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
    if (this.u != null) {
      if (!this.s) {
        this.w.setResolveIp(a(this.u.getURL()));
      }
    }
    try
    {
      this.u.disconnect();
      this.u = null;
      int i1 = this.w.a;
      if ((!this.s) && (this.z))
      {
        this.w.setEventTime(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.h);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int i2 = Apn.getApnType(this.h);
        this.w.setApn(str1);
        this.w.setNetworkType(i2);
        if ((i2 != this.y) || (!str1.equals(this.x))) {
          this.w.setNetworkChange(0);
        }
        if (((this.w.a == 0) || (this.w.a == 107)) && (this.w.getDownFinalFlag() == 0))
        {
          if (!Apn.isNetworkAvailable(this.h)) {
            a(101, null, true);
          }
        }
        else
        {
          if (!TbsDownloader.a(this.h)) {
            break label306;
          }
          TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.w);
          this.w.resetArgs();
          if (i1 != 100) {
            QbSdk.m.onDownloadFinish(i1);
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label306:
      do
      {
        for (;;)
        {
          TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
          continue;
          if (!m())
          {
            a(101, null, true);
            continue;
            TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.w);
          }
        }
      } while (this.d);
      TbsDownloader.a = false;
    }
  }
  
  private File i()
  {
    String str = FileUtil.a(this.h, 4);
    if (TbsDownloader.getOverSea(this.h)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
    {
      localObject = new File(str, (String)localObject);
      if (!TbsDownloader.a(this.h)) {
        break;
      }
      return new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
    }
    return localObject;
  }
  
  private void j()
  {
    try
    {
      Object localObject = i();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        FileUtil.b((File)localObject);
        localObject = ((File)localObject).getParentFile().listFiles();
        Pattern localPattern = Pattern.compile(a.a(TbsDownloader.a(this.h)) + "(.*)");
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          File localFile = localObject[i1];
          if ((localPattern.matcher(localFile.getName()).find()) && (localFile.isFile()) && (localFile.exists())) {
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
    boolean bool2 = false;
    File localFile = new File(this.l, "x5.tbs.temp");
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long l()
  {
    long l2 = 0L;
    File localFile = new File(this.l, "x5.tbs.temp");
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
    }
    return l1;
  }
  
  /* Error */
  private boolean m()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: invokestatic 686	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: astore 5
    //   14: aload 5
    //   16: new 110	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 688
    //   26: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 690
    //   32: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 694	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 700	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore 5
    //   46: new 702	java/io/InputStreamReader
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 705	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 7
    //   57: new 707	java/io/BufferedReader
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 710	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore 6
    //   68: iconst_0
    //   69: istore_1
    //   70: aload 6
    //   72: invokevirtual 713	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: iload 4
    //   79: istore_3
    //   80: aload 8
    //   82: ifnull +29 -> 111
    //   85: aload 8
    //   87: ldc_w 715
    //   90: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifne +16 -> 109
    //   96: aload 8
    //   98: ldc_w 717
    //   101: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +25 -> 131
    //   109: iconst_1
    //   110: istore_3
    //   111: aload_0
    //   112: aload 5
    //   114: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   117: aload_0
    //   118: aload 7
    //   120: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   123: aload_0
    //   124: aload 6
    //   126: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   129: iload_3
    //   130: ireturn
    //   131: iload_1
    //   132: iconst_1
    //   133: iadd
    //   134: istore_2
    //   135: iload_2
    //   136: istore_1
    //   137: iload_2
    //   138: iconst_5
    //   139: if_icmplt -69 -> 70
    //   142: iload 4
    //   144: istore_3
    //   145: goto -34 -> 111
    //   148: astore 7
    //   150: aconst_null
    //   151: astore 5
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 9
    //   158: astore 8
    //   160: aload 7
    //   162: invokevirtual 720	java/lang/Throwable:printStackTrace	()V
    //   165: aload_0
    //   166: aload 6
    //   168: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: aload 8
    //   174: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   177: aload_0
    //   178: aload 5
    //   180: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 6
    //   187: aconst_null
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_0
    //   194: aload 5
    //   196: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 7
    //   202: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 8
    //   208: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   211: aload 6
    //   213: athrow
    //   214: astore 6
    //   216: aconst_null
    //   217: astore 7
    //   219: goto -26 -> 193
    //   222: astore 6
    //   224: goto -31 -> 193
    //   227: astore 9
    //   229: aload 6
    //   231: astore 8
    //   233: aload 9
    //   235: astore 6
    //   237: goto -44 -> 193
    //   240: astore 10
    //   242: aload 6
    //   244: astore 9
    //   246: aload 8
    //   248: astore 7
    //   250: aload 10
    //   252: astore 6
    //   254: aload 5
    //   256: astore 8
    //   258: aload 9
    //   260: astore 5
    //   262: goto -69 -> 193
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 8
    //   270: aload 5
    //   272: astore 6
    //   274: aload 8
    //   276: astore 5
    //   278: aload 9
    //   280: astore 8
    //   282: goto -122 -> 160
    //   285: astore 10
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 7
    //   292: astore 8
    //   294: aload 5
    //   296: astore 6
    //   298: aload 10
    //   300: astore 7
    //   302: aload 9
    //   304: astore 5
    //   306: goto -146 -> 160
    //   309: astore 10
    //   311: aload 7
    //   313: astore 8
    //   315: aload 5
    //   317: astore 9
    //   319: aload 10
    //   321: astore 7
    //   323: aload 6
    //   325: astore 5
    //   327: aload 9
    //   329: astore 6
    //   331: goto -171 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	l
    //   69	68	1	i1	int
    //   134	6	2	i2	int
    //   79	66	3	bool1	boolean
    //   1	142	4	bool2	boolean
    //   12	314	5	localObject1	Object
    //   66	101	6	localBufferedReader	java.io.BufferedReader
    //   185	27	6	localObject2	Object
    //   214	1	6	localObject3	Object
    //   222	8	6	localObject4	Object
    //   235	95	6	localObject5	Object
    //   55	64	7	localInputStreamReader	java.io.InputStreamReader
    //   148	13	7	localThrowable1	Throwable
    //   188	61	7	localObject6	Object
    //   265	26	7	localThrowable2	Throwable
    //   300	22	7	localObject7	Object
    //   4	310	8	localObject8	Object
    //   7	150	9	localObject9	Object
    //   227	7	9	localObject10	Object
    //   244	84	9	localObject11	Object
    //   240	11	10	localObject12	Object
    //   285	14	10	localThrowable3	Throwable
    //   309	11	10	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	46	148	java/lang/Throwable
    //   14	46	185	finally
    //   46	57	214	finally
    //   57	68	222	finally
    //   70	77	227	finally
    //   85	105	227	finally
    //   160	165	240	finally
    //   46	57	265	java/lang/Throwable
    //   57	68	285	java/lang/Throwable
    //   70	77	309	java/lang/Throwable
    //   85	105	309	java/lang/Throwable
  }
  
  private long n()
  {
    switch (this.q)
    {
    default: 
      return 20000L * 10L;
    case 1: 
    case 2: 
      return 20000L * this.q;
    }
    return 20000L * 5L;
  }
  
  /* Error */
  private boolean o()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   16: invokestatic 635	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   19: iconst_3
    //   20: if_icmpne +276 -> 296
    //   23: iconst_1
    //   24: istore_3
    //   25: ldc 198
    //   27: new 110	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 728
    //   37: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_3
    //   41: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iload 5
    //   52: istore_2
    //   53: iload_3
    //   54: ifeq +141 -> 195
    //   57: aload_0
    //   58: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   61: invokestatic 731	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   64: astore 6
    //   66: ldc 198
    //   68: new 110	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 733
    //   78: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 6
    //   83: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 244	java/net/URL
    //   95: dup
    //   96: ldc_w 735
    //   99: invokespecial 379	java/net/URL:<init>	(Ljava/lang/String;)V
    //   102: invokevirtual 390	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   105: checkcast 383	java/net/HttpURLConnection
    //   108: astore 7
    //   110: aload 7
    //   112: iconst_0
    //   113: invokevirtual 411	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   116: aload 7
    //   118: sipush 10000
    //   121: invokevirtual 414	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   124: aload 7
    //   126: sipush 10000
    //   129: invokevirtual 417	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   132: aload 7
    //   134: iconst_0
    //   135: invokevirtual 738	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   138: aload 7
    //   140: invokevirtual 739	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   143: pop
    //   144: aload 7
    //   146: invokevirtual 742	java/net/HttpURLConnection:getResponseCode	()I
    //   149: istore_1
    //   150: ldc 198
    //   152: new 110	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 744
    //   162: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload_1
    //   166: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iload_1
    //   176: sipush 204
    //   179: if_icmpne +122 -> 301
    //   182: iload 4
    //   184: istore_2
    //   185: aload 7
    //   187: ifnull +203 -> 390
    //   190: aload 7
    //   192: invokevirtual 386	java/net/HttpURLConnection:disconnect	()V
    //   195: iload_2
    //   196: ifne +68 -> 264
    //   199: aload 6
    //   201: invokestatic 749	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +60 -> 264
    //   207: aload_0
    //   208: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   211: aload 6
    //   213: invokeinterface 753 2 0
    //   218: ifne +46 -> 264
    //   221: aload_0
    //   222: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   225: aload 6
    //   227: invokeinterface 756 2 0
    //   232: pop
    //   233: aload_0
    //   234: invokespecial 758	com/tencent/smtt/sdk/l:p	()V
    //   237: aload_0
    //   238: getfield 760	com/tencent/smtt/sdk/l:A	Landroid/os/Handler;
    //   241: sipush 150
    //   244: aload 6
    //   246: invokevirtual 766	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   249: astore 7
    //   251: aload_0
    //   252: getfield 760	com/tencent/smtt/sdk/l:A	Landroid/os/Handler;
    //   255: aload 7
    //   257: ldc2_w 767
    //   260: invokevirtual 772	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   263: pop
    //   264: iload_2
    //   265: ifeq +29 -> 294
    //   268: aload_0
    //   269: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   272: aload 6
    //   274: invokeinterface 753 2 0
    //   279: ifeq +15 -> 294
    //   282: aload_0
    //   283: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   286: aload 6
    //   288: invokeinterface 775 2 0
    //   293: pop
    //   294: iload_2
    //   295: ireturn
    //   296: iconst_0
    //   297: istore_3
    //   298: goto -273 -> 25
    //   301: iconst_0
    //   302: istore_2
    //   303: goto -118 -> 185
    //   306: astore 7
    //   308: goto -113 -> 195
    //   311: astore 8
    //   313: aconst_null
    //   314: astore 7
    //   316: aload 8
    //   318: invokevirtual 720	java/lang/Throwable:printStackTrace	()V
    //   321: aload 7
    //   323: ifnull +61 -> 384
    //   326: aload 7
    //   328: invokevirtual 386	java/net/HttpURLConnection:disconnect	()V
    //   331: iload 5
    //   333: istore_2
    //   334: goto -139 -> 195
    //   337: astore 7
    //   339: iload 5
    //   341: istore_2
    //   342: goto -147 -> 195
    //   345: astore 6
    //   347: aload 8
    //   349: astore 7
    //   351: aload 7
    //   353: ifnull +8 -> 361
    //   356: aload 7
    //   358: invokevirtual 386	java/net/HttpURLConnection:disconnect	()V
    //   361: aload 6
    //   363: athrow
    //   364: astore 7
    //   366: goto -5 -> 361
    //   369: astore 6
    //   371: goto -20 -> 351
    //   374: astore 6
    //   376: goto -25 -> 351
    //   379: astore 8
    //   381: goto -65 -> 316
    //   384: iload 5
    //   386: istore_2
    //   387: goto -192 -> 195
    //   390: goto -195 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	l
    //   149	31	1	i1	int
    //   52	335	2	bool1	boolean
    //   24	274	3	bool2	boolean
    //   7	176	4	bool3	boolean
    //   10	375	5	bool4	boolean
    //   4	283	6	str	String
    //   345	17	6	localObject1	Object
    //   369	1	6	localObject2	Object
    //   374	1	6	localObject3	Object
    //   108	148	7	localObject4	Object
    //   306	1	7	localException1	Exception
    //   314	13	7	localObject5	Object
    //   337	1	7	localException2	Exception
    //   349	8	7	localThrowable1	Throwable
    //   364	1	7	localException3	Exception
    //   1	1	8	localObject6	Object
    //   311	37	8	localThrowable2	Throwable
    //   379	1	8	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   190	195	306	java/lang/Exception
    //   92	110	311	java/lang/Throwable
    //   326	331	337	java/lang/Exception
    //   92	110	345	finally
    //   356	361	364	java/lang/Exception
    //   110	175	369	finally
    //   316	321	374	finally
    //   110	175	379	java/lang/Throwable
  }
  
  private void p()
  {
    if (this.A == null) {
      this.A = new l.1(this, n.a().getLooper());
    }
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      paramFile = new File(paramFile, TbsDownloader.getBackupFileName(true));
      i1 = a.a(this.h, paramFile);
      localObject = new File(this.l, "x5.tbs");
      if (!((File)localObject).exists()) {
        break label189;
      }
    }
    label189:
    for (Object localObject = ((File)localObject).getAbsolutePath();; localObject = null)
    {
      int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", paramFile.getAbsolutePath());
      localBundle.putString("new_apk_location", (String)localObject);
      localBundle.putString("diff_file_location", (String)localObject);
      return localBundle;
      if (TbsDownloader.getOverSea(this.h)) {}
      for (localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
      {
        paramFile = new File(paramFile, (String)localObject);
        break;
      }
    }
  }
  
  public Bundle a(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    int i1;
    if (paramBoolean)
    {
      localObject1 = p.a().p(this.h);
      i1 = p.a().h(this.h);
      localObject2 = new File(this.l, "x5.tbs");
      if (!((File)localObject2).exists()) {
        break label91;
      }
    }
    label91:
    for (Object localObject2 = ((File)localObject2).getAbsolutePath();; localObject2 = null)
    {
      if (localObject2 != null) {
        break label97;
      }
      return null;
      localObject1 = p.a().q(this.h);
      i1 = p.a().i(this.h);
      break;
    }
    label97:
    int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
    if (paramBoolean) {}
    for (File localFile = p.a().f(this.h, 6);; localFile = p.a().f(this.h, 5))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", ((File)localObject1).getAbsolutePath());
      localBundle.putString("new_apk_location", localFile.getAbsolutePath());
      localBundle.putString("diff_file_location", (String)localObject2);
      localObject1 = FileUtil.a(this.h, 7);
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localBundle.putString("backup_apk", new File((String)localObject1, i2 + ".tbs").getAbsolutePath());
      return localBundle;
    }
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
      if ((localFile1 != null) && (localFile1.exists())) {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      while (a.a(this.h, localFile1, 0L, TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        return p.a().e(this.h);
        File localFile2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          FileUtil.b(localFile2, localFile1);
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT == 23) {}
    label73:
    label335:
    label337:
    label353:
    label359:
    label379:
    do
    {
      return false;
      int i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
      int i2 = p.a().i(this.h);
      File localFile;
      Object localObject;
      if (i1 == 0)
      {
        i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
        this.a = "by default key";
        if ((i1 == 0) || (i1 == i2)) {
          break label335;
        }
        if (!paramBoolean2) {
          break label428;
        }
        localFile = TbsDownloader.a(i1);
        if ((localFile == null) || (!localFile.exists())) {
          break label353;
        }
        String str = FileUtil.a(this.h, 4);
        if (!TbsDownloader.getOverSea(this.h)) {
          break label337;
        }
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
      }
      for (;;)
      {
        try
        {
          if (TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            break label353;
          }
          FileUtil.b(localFile, (File)localObject);
          i2 = 1;
          localObject = i();
          if ((localObject == null) || (!((File)localObject).exists()) || (!a((File)localObject))) {
            break label379;
          }
          if (!b(i1)) {
            break label428;
          }
          TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
          d(false);
          if (i2 != 0)
          {
            a(100, "use local backup apk in startDownload" + this.a, true);
            if (!TbsDownloader.a(this.h)) {
              break label359;
            }
            TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.w);
            this.w.resetArgs();
          }
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.a = "by new key";
        break label73;
        break;
        localObject = TbsDownloader.getBackupFileName(false);
        break label130;
        i2 = 0;
        continue;
        TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.w);
      }
      j();
      if ((localFile != null) && (localFile.exists()) && (!a.a(this.h, localFile, 0L, i1)) && (localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      if (c(false, paramBoolean2))
      {
        TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
        TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
        d(false);
        return true;
      }
    } while ((e(true)) || (e(true)));
    label130:
    label428:
    TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
    TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-301);
    return false;
  }
  
  public void b()
  {
    this.s = true;
    TbsLogReport.TbsLogInfo localTbsLogInfo;
    if (TbsShareManager.isThirdPartyApp(this.h))
    {
      localTbsLogInfo = TbsLogReport.getInstance(this.h).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.h)) {
        TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
      }
    }
    else
    {
      return;
    }
    TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 131	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   3: aload_0
    //   4: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   7: invokevirtual 881	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 672	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   25: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush -322
    //   31: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   39: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 368
    //   48: iconst_0
    //   49: invokeinterface 306 3 0
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_1
    //   57: if_icmpeq +13 -> 70
    //   60: iload_3
    //   61: iconst_2
    //   62: if_icmpeq +8 -> 70
    //   65: iload_3
    //   66: iconst_4
    //   67: if_icmpne +25 -> 92
    //   70: iconst_1
    //   71: istore 8
    //   73: iload_2
    //   74: ifne +24 -> 98
    //   77: aload_0
    //   78: iload_1
    //   79: iload 8
    //   81: invokevirtual 883	com/tencent/smtt/sdk/l:a	(ZZ)Z
    //   84: ifeq +14 -> 98
    //   87: iconst_0
    //   88: putstatic 672	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   91: return
    //   92: iconst_0
    //   93: istore 8
    //   95: goto -22 -> 73
    //   98: aload_0
    //   99: iload_1
    //   100: putfield 885	com/tencent/smtt/sdk/l:D	Z
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   108: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   114: ldc_w 887
    //   117: aconst_null
    //   118: invokeinterface 452 3 0
    //   123: putfield 889	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   130: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   136: ldc_w 891
    //   139: aconst_null
    //   140: invokeinterface 452 3 0
    //   145: astore 27
    //   147: ldc 198
    //   149: new 110	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 893
    //   159: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 27
    //   164: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: iconst_1
    //   171: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 83	com/tencent/smtt/sdk/l:c	I
    //   184: iload_1
    //   185: ifne +37 -> 222
    //   188: aload 27
    //   190: ifnull +32 -> 222
    //   193: ldc_w 258
    //   196: aload 27
    //   198: invokevirtual 899	java/lang/String:trim	()Ljava/lang/String;
    //   201: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifne +18 -> 222
    //   207: aload_0
    //   208: aload 27
    //   210: invokevirtual 899	java/lang/String:trim	()Ljava/lang/String;
    //   213: ldc_w 901
    //   216: invokevirtual 905	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   219: putfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   222: ldc 198
    //   224: new 110	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 907
    //   234: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 889	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   241: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 909
    //   247: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 27
    //   252: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 911
    //   258: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: getfield 602	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   265: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 913
    //   271: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   278: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   281: ldc_w 915
    //   284: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   291: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload_0
    //   301: getfield 889	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   304: ifnonnull +34 -> 338
    //   307: aload_0
    //   308: getfield 602	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   311: ifnonnull +27 -> 338
    //   314: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   317: bipush 110
    //   319: invokeinterface 568 2 0
    //   324: aload_0
    //   325: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   328: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   331: sipush -302
    //   334: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   337: return
    //   338: aload_0
    //   339: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   342: ifnull +34 -> 376
    //   345: aload_0
    //   346: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   349: ifne +27 -> 376
    //   352: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   355: bipush 110
    //   357: invokeinterface 568 2 0
    //   362: aload_0
    //   363: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   366: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   369: sipush -303
    //   372: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   375: return
    //   376: iload_1
    //   377: ifne +54 -> 431
    //   380: aload_0
    //   381: getfield 108	com/tencent/smtt/sdk/l:B	Ljava/util/Set;
    //   384: aload_0
    //   385: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   388: invokestatic 731	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   391: invokeinterface 753 2 0
    //   396: ifeq +35 -> 431
    //   399: ldc 198
    //   401: ldc_w 917
    //   404: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   410: bipush 110
    //   412: invokeinterface 568 2 0
    //   417: aload_0
    //   418: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   421: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   424: sipush -304
    //   427: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   430: return
    //   431: aload_0
    //   432: invokespecial 145	com/tencent/smtt/sdk/l:g	()V
    //   435: ldc 198
    //   437: ldc_w 919
    //   440: iconst_1
    //   441: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   444: aload_0
    //   445: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   448: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   451: invokevirtual 922	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   454: lstore 25
    //   456: iconst_0
    //   457: istore_2
    //   458: aload_0
    //   459: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   462: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   465: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   468: ldc_w 924
    //   471: lconst_0
    //   472: invokeinterface 476 4 0
    //   477: lstore 11
    //   479: iload_1
    //   480: ifeq +216 -> 696
    //   483: aload_0
    //   484: getstatic 52	com/tencent/smtt/sdk/l:f	I
    //   487: putfield 79	com/tencent/smtt/sdk/l:C	I
    //   490: aload_0
    //   491: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   494: aload_0
    //   495: getfield 79	com/tencent/smtt/sdk/l:C	I
    //   498: if_icmple +208 -> 706
    //   501: iload_2
    //   502: istore 5
    //   504: aload_0
    //   505: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   508: ifne +183 -> 691
    //   511: iload 5
    //   513: istore_1
    //   514: aload_0
    //   515: getfield 608	com/tencent/smtt/sdk/l:t	Z
    //   518: ifeq +102 -> 620
    //   521: iload 5
    //   523: istore_1
    //   524: aload_0
    //   525: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   528: ifnonnull +19 -> 547
    //   531: iload 5
    //   533: istore_1
    //   534: iload 5
    //   536: ifne +11 -> 547
    //   539: aload_0
    //   540: iconst_1
    //   541: iload 8
    //   543: invokespecial 866	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   546: istore_1
    //   547: aload_0
    //   548: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   551: astore 27
    //   553: iload_1
    //   554: ifeq +5683 -> 6237
    //   557: iconst_1
    //   558: istore_3
    //   559: aload 27
    //   561: iload_3
    //   562: invokevirtual 927	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   565: iload 8
    //   567: ifne +5680 -> 6247
    //   570: aload_0
    //   571: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   574: astore 27
    //   576: iload_1
    //   577: ifeq +5665 -> 6242
    //   580: iconst_1
    //   581: istore_3
    //   582: aload 27
    //   584: iload_3
    //   585: invokevirtual 930	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   588: iload_1
    //   589: ifeq +5669 -> 6258
    //   592: aload_0
    //   593: iconst_1
    //   594: invokespecial 858	com/tencent/smtt/sdk/l:d	(Z)V
    //   597: aload_0
    //   598: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   601: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   604: sipush -317
    //   607: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   610: aload_0
    //   611: bipush 100
    //   613: ldc_w 932
    //   616: iconst_1
    //   617: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   620: aload_0
    //   621: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   624: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   627: astore 27
    //   629: iload_1
    //   630: ifeq +5650 -> 6280
    //   633: aload 27
    //   635: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   638: ldc_w 934
    //   641: iconst_0
    //   642: invokeinterface 306 3 0
    //   647: istore_3
    //   648: aload 27
    //   650: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   653: ldc_w 934
    //   656: iload_3
    //   657: iconst_1
    //   658: iadd
    //   659: invokestatic 519	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   662: invokeinterface 551 3 0
    //   667: pop
    //   668: aload 27
    //   670: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   673: aload_0
    //   674: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   677: astore 27
    //   679: iload_1
    //   680: ifeq +5661 -> 6341
    //   683: iconst_1
    //   684: istore_3
    //   685: aload 27
    //   687: iload_3
    //   688: invokevirtual 937	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   691: aload_0
    //   692: invokespecial 939	com/tencent/smtt/sdk/l:h	()V
    //   695: return
    //   696: aload_0
    //   697: getstatic 50	com/tencent/smtt/sdk/l:e	I
    //   700: putfield 79	com/tencent/smtt/sdk/l:C	I
    //   703: goto -213 -> 490
    //   706: aload_0
    //   707: getfield 596	com/tencent/smtt/sdk/l:r	I
    //   710: bipush 8
    //   712: if_icmple +30 -> 742
    //   715: aload_0
    //   716: bipush 123
    //   718: aconst_null
    //   719: iconst_1
    //   720: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   723: aload_0
    //   724: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   727: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   730: sipush -306
    //   733: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   736: iload_2
    //   737: istore 5
    //   739: goto -235 -> 504
    //   742: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   745: lstore 23
    //   747: lload 11
    //   749: lstore 9
    //   751: iload_1
    //   752: ifne +441 -> 1193
    //   755: lload 11
    //   757: lstore 15
    //   759: iload_2
    //   760: istore 5
    //   762: lload 11
    //   764: lstore 13
    //   766: lload 23
    //   768: aload_0
    //   769: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   772: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   775: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   778: ldc_w 941
    //   781: lconst_0
    //   782: invokeinterface 476 4 0
    //   787: lsub
    //   788: ldc2_w 942
    //   791: lcmp
    //   792: ifle +246 -> 1038
    //   795: lload 11
    //   797: lstore 15
    //   799: iload_2
    //   800: istore 5
    //   802: lload 11
    //   804: lstore 13
    //   806: ldc 198
    //   808: ldc_w 945
    //   811: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: lload 11
    //   816: lstore 15
    //   818: iload_2
    //   819: istore 5
    //   821: lload 11
    //   823: lstore 13
    //   825: aload_0
    //   826: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   829: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   832: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   835: ldc_w 941
    //   838: lload 23
    //   840: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   843: invokeinterface 551 3 0
    //   848: pop
    //   849: lload 11
    //   851: lstore 15
    //   853: iload_2
    //   854: istore 5
    //   856: lload 11
    //   858: lstore 13
    //   860: aload_0
    //   861: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   864: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   867: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   870: ldc_w 924
    //   873: lconst_0
    //   874: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   877: invokeinterface 551 3 0
    //   882: pop
    //   883: lload 11
    //   885: lstore 15
    //   887: iload_2
    //   888: istore 5
    //   890: lload 11
    //   892: lstore 13
    //   894: aload_0
    //   895: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   898: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   901: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   904: lconst_0
    //   905: lstore 9
    //   907: iload_2
    //   908: istore 5
    //   910: lload 9
    //   912: lstore 11
    //   914: lload 9
    //   916: lstore 13
    //   918: aload_0
    //   919: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   922: invokestatic 952	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   925: ifne +268 -> 1193
    //   928: iload_2
    //   929: istore 5
    //   931: lload 9
    //   933: lstore 11
    //   935: lload 9
    //   937: lstore 13
    //   939: ldc 198
    //   941: ldc_w 954
    //   944: iconst_1
    //   945: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   948: iload_2
    //   949: istore 5
    //   951: lload 9
    //   953: lstore 11
    //   955: lload 9
    //   957: lstore 13
    //   959: aload_0
    //   960: bipush 105
    //   962: aconst_null
    //   963: iconst_1
    //   964: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   967: iload_2
    //   968: istore 5
    //   970: lload 9
    //   972: lstore 11
    //   974: lload 9
    //   976: lstore 13
    //   978: aload_0
    //   979: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   982: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   985: sipush -308
    //   988: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   991: iload_2
    //   992: istore 5
    //   994: iload_1
    //   995: ifne -491 -> 504
    //   998: aload_0
    //   999: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1002: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1005: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1008: ldc_w 924
    //   1011: lload 9
    //   1013: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1016: invokeinterface 551 3 0
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1026: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1029: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1032: iload_2
    //   1033: istore 5
    //   1035: goto -531 -> 504
    //   1038: lload 11
    //   1040: lstore 15
    //   1042: iload_2
    //   1043: istore 5
    //   1045: lload 11
    //   1047: lstore 13
    //   1049: ldc 198
    //   1051: new 110	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 956
    //   1061: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: lload 11
    //   1066: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1069: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1075: lload 11
    //   1077: lload 25
    //   1079: lcmp
    //   1080: iflt +5471 -> 6551
    //   1083: lload 11
    //   1085: lstore 15
    //   1087: iload_2
    //   1088: istore 5
    //   1090: lload 11
    //   1092: lstore 13
    //   1094: ldc 198
    //   1096: ldc_w 958
    //   1099: iconst_1
    //   1100: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1103: lload 11
    //   1105: lstore 15
    //   1107: iload_2
    //   1108: istore 5
    //   1110: lload 11
    //   1112: lstore 13
    //   1114: aload_0
    //   1115: bipush 112
    //   1117: aconst_null
    //   1118: iconst_1
    //   1119: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   1122: lload 11
    //   1124: lstore 15
    //   1126: iload_2
    //   1127: istore 5
    //   1129: lload 11
    //   1131: lstore 13
    //   1133: aload_0
    //   1134: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1137: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1140: sipush -307
    //   1143: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1146: iload_2
    //   1147: istore 5
    //   1149: iload_1
    //   1150: ifne -646 -> 504
    //   1153: aload_0
    //   1154: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1157: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1160: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1163: ldc_w 924
    //   1166: lload 11
    //   1168: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1171: invokeinterface 551 3 0
    //   1176: pop
    //   1177: aload_0
    //   1178: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1181: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1184: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1187: iload_2
    //   1188: istore 5
    //   1190: goto -686 -> 504
    //   1193: lload 9
    //   1195: lstore 15
    //   1197: iload_2
    //   1198: istore 5
    //   1200: lload 9
    //   1202: lstore 13
    //   1204: aload_0
    //   1205: iconst_1
    //   1206: putfield 610	com/tencent/smtt/sdk/l:z	Z
    //   1209: lload 9
    //   1211: lstore 15
    //   1213: iload_2
    //   1214: istore 5
    //   1216: lload 9
    //   1218: lstore 13
    //   1220: aload_0
    //   1221: getfield 602	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   1224: ifnull +846 -> 2070
    //   1227: lload 9
    //   1229: lstore 15
    //   1231: iload_2
    //   1232: istore 5
    //   1234: lload 9
    //   1236: lstore 13
    //   1238: aload_0
    //   1239: getfield 602	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   1242: astore 27
    //   1244: lload 9
    //   1246: lstore 15
    //   1248: iload_2
    //   1249: istore 5
    //   1251: lload 9
    //   1253: lstore 13
    //   1255: ldc 198
    //   1257: new 110	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 960
    //   1267: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: aload 27
    //   1272: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: ldc_w 962
    //   1278: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: aload_0
    //   1282: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   1285: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1288: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1291: iconst_1
    //   1292: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1295: lload 9
    //   1297: lstore 15
    //   1299: iload_2
    //   1300: istore 5
    //   1302: lload 9
    //   1304: lstore 13
    //   1306: aload 27
    //   1308: aload_0
    //   1309: getfield 964	com/tencent/smtt/sdk/l:j	Ljava/lang/String;
    //   1312: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1315: ifne +23 -> 1338
    //   1318: lload 9
    //   1320: lstore 15
    //   1322: iload_2
    //   1323: istore 5
    //   1325: lload 9
    //   1327: lstore 13
    //   1329: aload_0
    //   1330: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1333: aload 27
    //   1335: invokevirtual 967	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1338: lload 9
    //   1340: lstore 15
    //   1342: iload_2
    //   1343: istore 5
    //   1345: lload 9
    //   1347: lstore 13
    //   1349: aload_0
    //   1350: aload 27
    //   1352: putfield 964	com/tencent/smtt/sdk/l:j	Ljava/lang/String;
    //   1355: lload 9
    //   1357: lstore 15
    //   1359: iload_2
    //   1360: istore 5
    //   1362: lload 9
    //   1364: lstore 13
    //   1366: aload_0
    //   1367: aload 27
    //   1369: invokespecial 969	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;)V
    //   1372: lconst_0
    //   1373: lstore 11
    //   1375: lload 9
    //   1377: lstore 15
    //   1379: iload_2
    //   1380: istore 5
    //   1382: lload 9
    //   1384: lstore 13
    //   1386: aload_0
    //   1387: getfield 604	com/tencent/smtt/sdk/l:p	Z
    //   1390: ifne +163 -> 1553
    //   1393: lload 9
    //   1395: lstore 15
    //   1397: iload_2
    //   1398: istore 5
    //   1400: lload 9
    //   1402: lstore 13
    //   1404: aload_0
    //   1405: invokespecial 971	com/tencent/smtt/sdk/l:l	()J
    //   1408: lstore 11
    //   1410: lload 9
    //   1412: lstore 15
    //   1414: iload_2
    //   1415: istore 5
    //   1417: lload 9
    //   1419: lstore 13
    //   1421: ldc 198
    //   1423: new 110	java/lang/StringBuilder
    //   1426: dup
    //   1427: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1430: ldc_w 973
    //   1433: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: lload 11
    //   1438: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1441: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1447: lload 9
    //   1449: lstore 15
    //   1451: iload_2
    //   1452: istore 5
    //   1454: lload 9
    //   1456: lstore 13
    //   1458: aload_0
    //   1459: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   1462: lconst_0
    //   1463: lcmp
    //   1464: ifgt +626 -> 2090
    //   1467: lload 9
    //   1469: lstore 15
    //   1471: iload_2
    //   1472: istore 5
    //   1474: lload 9
    //   1476: lstore 13
    //   1478: ldc 198
    //   1480: new 110	java/lang/StringBuilder
    //   1483: dup
    //   1484: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1487: ldc_w 975
    //   1490: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: lload 11
    //   1495: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1498: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: iconst_1
    //   1502: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1505: lload 9
    //   1507: lstore 15
    //   1509: iload_2
    //   1510: istore 5
    //   1512: lload 9
    //   1514: lstore 13
    //   1516: aload_0
    //   1517: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   1520: ldc_w 977
    //   1523: new 110	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1530: ldc_w 979
    //   1533: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: lload 11
    //   1538: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1541: ldc_w 981
    //   1544: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1550: invokevirtual 398	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1553: lload 9
    //   1555: lstore 15
    //   1557: iload_2
    //   1558: istore 5
    //   1560: lload 9
    //   1562: lstore 13
    //   1564: aload_0
    //   1565: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1568: astore 27
    //   1570: lload 11
    //   1572: lconst_0
    //   1573: lcmp
    //   1574: ifne +800 -> 2374
    //   1577: iconst_0
    //   1578: istore_3
    //   1579: lload 9
    //   1581: lstore 15
    //   1583: iload_2
    //   1584: istore 5
    //   1586: lload 9
    //   1588: lstore 13
    //   1590: aload 27
    //   1592: iload_3
    //   1593: invokevirtual 984	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1596: lload 9
    //   1598: lstore 15
    //   1600: iload_2
    //   1601: istore 5
    //   1603: lload 9
    //   1605: lstore 13
    //   1607: aload_0
    //   1608: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1611: invokestatic 635	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1614: istore_3
    //   1615: lload 9
    //   1617: lstore 15
    //   1619: iload_2
    //   1620: istore 5
    //   1622: lload 9
    //   1624: lstore 13
    //   1626: aload_0
    //   1627: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1630: invokestatic 631	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1633: astore 27
    //   1635: lload 9
    //   1637: lstore 15
    //   1639: iload_2
    //   1640: istore 5
    //   1642: lload 9
    //   1644: lstore 13
    //   1646: aload_0
    //   1647: getfield 147	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   1650: ifnonnull +729 -> 2379
    //   1653: lload 9
    //   1655: lstore 15
    //   1657: iload_2
    //   1658: istore 5
    //   1660: lload 9
    //   1662: lstore 13
    //   1664: aload_0
    //   1665: getfield 149	com/tencent/smtt/sdk/l:y	I
    //   1668: iconst_m1
    //   1669: if_icmpne +710 -> 2379
    //   1672: lload 9
    //   1674: lstore 15
    //   1676: iload_2
    //   1677: istore 5
    //   1679: lload 9
    //   1681: lstore 13
    //   1683: aload_0
    //   1684: aload 27
    //   1686: putfield 147	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   1689: lload 9
    //   1691: lstore 15
    //   1693: iload_2
    //   1694: istore 5
    //   1696: lload 9
    //   1698: lstore 13
    //   1700: aload_0
    //   1701: iload_3
    //   1702: putfield 149	com/tencent/smtt/sdk/l:y	I
    //   1705: lload 9
    //   1707: lstore 15
    //   1709: iload_2
    //   1710: istore 5
    //   1712: lload 9
    //   1714: lstore 13
    //   1716: aload_0
    //   1717: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   1720: iconst_1
    //   1721: if_icmplt +28 -> 1749
    //   1724: lload 9
    //   1726: lstore 15
    //   1728: iload_2
    //   1729: istore 5
    //   1731: lload 9
    //   1733: lstore 13
    //   1735: aload_0
    //   1736: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   1739: ldc_w 986
    //   1742: aload_0
    //   1743: getfield 889	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   1746: invokevirtual 989	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1749: lload 9
    //   1751: lstore 15
    //   1753: iload_2
    //   1754: istore 5
    //   1756: lload 9
    //   1758: lstore 13
    //   1760: aload_0
    //   1761: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   1764: invokevirtual 742	java/net/HttpURLConnection:getResponseCode	()I
    //   1767: istore_3
    //   1768: lload 9
    //   1770: lstore 15
    //   1772: iload_2
    //   1773: istore 5
    //   1775: lload 9
    //   1777: lstore 13
    //   1779: ldc 198
    //   1781: new 110	java/lang/StringBuilder
    //   1784: dup
    //   1785: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1788: ldc_w 991
    //   1791: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: iload_3
    //   1795: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1804: lload 9
    //   1806: lstore 15
    //   1808: iload_2
    //   1809: istore 5
    //   1811: lload 9
    //   1813: lstore 13
    //   1815: aload_0
    //   1816: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1819: iload_3
    //   1820: invokevirtual 994	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1823: iload_1
    //   1824: ifne +157 -> 1981
    //   1827: lload 9
    //   1829: lstore 15
    //   1831: iload_2
    //   1832: istore 5
    //   1834: lload 9
    //   1836: lstore 13
    //   1838: aload_0
    //   1839: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1842: invokestatic 216	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1845: ifne +136 -> 1981
    //   1848: lload 9
    //   1850: lstore 15
    //   1852: iload_2
    //   1853: istore 5
    //   1855: lload 9
    //   1857: lstore 13
    //   1859: aload_0
    //   1860: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1863: invokestatic 635	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1866: iconst_3
    //   1867: if_icmpne +24 -> 1891
    //   1870: lload 9
    //   1872: lstore 15
    //   1874: iload_2
    //   1875: istore 5
    //   1877: lload 9
    //   1879: lstore 13
    //   1881: aload_0
    //   1882: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   1885: invokestatic 635	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1888: ifne +93 -> 1981
    //   1891: lload 9
    //   1893: lstore 15
    //   1895: iload_2
    //   1896: istore 5
    //   1898: lload 9
    //   1900: lstore 13
    //   1902: invokestatic 997	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1905: ifne +76 -> 1981
    //   1908: lload 9
    //   1910: lstore 15
    //   1912: iload_2
    //   1913: istore 5
    //   1915: lload 9
    //   1917: lstore 13
    //   1919: aload_0
    //   1920: invokevirtual 998	com/tencent/smtt/sdk/l:b	()V
    //   1923: lload 9
    //   1925: lstore 15
    //   1927: iload_2
    //   1928: istore 5
    //   1930: lload 9
    //   1932: lstore 13
    //   1934: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1937: ifnull +24 -> 1961
    //   1940: lload 9
    //   1942: lstore 15
    //   1944: iload_2
    //   1945: istore 5
    //   1947: lload 9
    //   1949: lstore 13
    //   1951: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1954: bipush 111
    //   1956: invokeinterface 568 2 0
    //   1961: lload 9
    //   1963: lstore 15
    //   1965: iload_2
    //   1966: istore 5
    //   1968: lload 9
    //   1970: lstore 13
    //   1972: ldc 198
    //   1974: ldc_w 1000
    //   1977: iconst_0
    //   1978: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1981: lload 9
    //   1983: lstore 15
    //   1985: iload_2
    //   1986: istore 5
    //   1988: lload 9
    //   1990: lstore 13
    //   1992: aload_0
    //   1993: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   1996: ifeq +523 -> 2519
    //   1999: lload 9
    //   2001: lstore 15
    //   2003: iload_2
    //   2004: istore 5
    //   2006: lload 9
    //   2008: lstore 13
    //   2010: aload_0
    //   2011: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2014: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2017: sipush -309
    //   2020: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2023: iload_2
    //   2024: istore 5
    //   2026: iload_1
    //   2027: ifne -1523 -> 504
    //   2030: aload_0
    //   2031: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2034: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2037: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2040: ldc_w 924
    //   2043: lload 9
    //   2045: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2048: invokeinterface 551 3 0
    //   2053: pop
    //   2054: aload_0
    //   2055: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2058: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2061: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2064: iload_2
    //   2065: istore 5
    //   2067: goto -1563 -> 504
    //   2070: lload 9
    //   2072: lstore 15
    //   2074: iload_2
    //   2075: istore 5
    //   2077: lload 9
    //   2079: lstore 13
    //   2081: aload_0
    //   2082: getfield 889	com/tencent/smtt/sdk/l:i	Ljava/lang/String;
    //   2085: astore 27
    //   2087: goto -843 -> 1244
    //   2090: lload 9
    //   2092: lstore 15
    //   2094: iload_2
    //   2095: istore 5
    //   2097: lload 9
    //   2099: lstore 13
    //   2101: ldc 198
    //   2103: new 110	java/lang/StringBuilder
    //   2106: dup
    //   2107: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2110: ldc_w 1002
    //   2113: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: lload 11
    //   2118: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2121: ldc_w 1004
    //   2124: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: aload_0
    //   2128: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   2131: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2134: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2137: iconst_1
    //   2138: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2141: lload 9
    //   2143: lstore 15
    //   2145: iload_2
    //   2146: istore 5
    //   2148: lload 9
    //   2150: lstore 13
    //   2152: aload_0
    //   2153: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   2156: ldc_w 977
    //   2159: new 110	java/lang/StringBuilder
    //   2162: dup
    //   2163: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2166: ldc_w 979
    //   2169: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: lload 11
    //   2174: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2177: ldc_w 981
    //   2180: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: aload_0
    //   2184: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   2187: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2190: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2193: invokevirtual 398	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2196: goto -643 -> 1553
    //   2199: astore 27
    //   2201: iload 5
    //   2203: istore 6
    //   2205: lload 15
    //   2207: lstore 13
    //   2209: aload 27
    //   2211: instanceof 1006
    //   2214: ifeq +3911 -> 6125
    //   2217: iload_1
    //   2218: ifne +3907 -> 6125
    //   2221: lload 15
    //   2223: lstore 13
    //   2225: aload_0
    //   2226: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   2229: ifnull +3896 -> 6125
    //   2232: lload 15
    //   2234: lstore 13
    //   2236: aload_0
    //   2237: iconst_0
    //   2238: invokevirtual 1008	com/tencent/smtt/sdk/l:b	(Z)Z
    //   2241: ifeq +3884 -> 6125
    //   2244: lload 15
    //   2246: lstore 13
    //   2248: ldc 198
    //   2250: new 110	java/lang/StringBuilder
    //   2253: dup
    //   2254: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2257: ldc_w 1010
    //   2260: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2263: aload_0
    //   2264: getfield 602	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   2267: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: ldc_w 1012
    //   2273: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2276: aload 27
    //   2278: invokevirtual 420	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2281: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2284: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2287: invokestatic 208	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2290: lload 15
    //   2292: lstore 13
    //   2294: aload_0
    //   2295: bipush 125
    //   2297: aconst_null
    //   2298: iconst_1
    //   2299: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2302: lload 15
    //   2304: lstore 13
    //   2306: aload_0
    //   2307: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2310: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2313: sipush -316
    //   2316: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2319: lload 15
    //   2321: lstore 11
    //   2323: iload 6
    //   2325: istore_2
    //   2326: iload_1
    //   2327: ifne -1837 -> 490
    //   2330: aload_0
    //   2331: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2334: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2337: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2340: ldc_w 924
    //   2343: lload 15
    //   2345: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2348: invokeinterface 551 3 0
    //   2353: pop
    //   2354: aload_0
    //   2355: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2358: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2361: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2364: lload 15
    //   2366: lstore 11
    //   2368: iload 6
    //   2370: istore_2
    //   2371: goto -1881 -> 490
    //   2374: iconst_1
    //   2375: istore_3
    //   2376: goto -797 -> 1579
    //   2379: lload 9
    //   2381: lstore 15
    //   2383: iload_2
    //   2384: istore 5
    //   2386: lload 9
    //   2388: lstore 13
    //   2390: iload_3
    //   2391: aload_0
    //   2392: getfield 149	com/tencent/smtt/sdk/l:y	I
    //   2395: if_icmpne +26 -> 2421
    //   2398: lload 9
    //   2400: lstore 15
    //   2402: iload_2
    //   2403: istore 5
    //   2405: lload 9
    //   2407: lstore 13
    //   2409: aload 27
    //   2411: aload_0
    //   2412: getfield 147	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   2415: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2418: ifne -713 -> 1705
    //   2421: lload 9
    //   2423: lstore 15
    //   2425: iload_2
    //   2426: istore 5
    //   2428: lload 9
    //   2430: lstore 13
    //   2432: aload_0
    //   2433: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2436: iconst_0
    //   2437: invokevirtual 644	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2440: lload 9
    //   2442: lstore 15
    //   2444: iload_2
    //   2445: istore 5
    //   2447: lload 9
    //   2449: lstore 13
    //   2451: aload_0
    //   2452: aload 27
    //   2454: putfield 147	com/tencent/smtt/sdk/l:x	Ljava/lang/String;
    //   2457: lload 9
    //   2459: lstore 15
    //   2461: iload_2
    //   2462: istore 5
    //   2464: lload 9
    //   2466: lstore 13
    //   2468: aload_0
    //   2469: iload_3
    //   2470: putfield 149	com/tencent/smtt/sdk/l:y	I
    //   2473: goto -768 -> 1705
    //   2476: astore 27
    //   2478: iload_1
    //   2479: ifne +37 -> 2516
    //   2482: aload_0
    //   2483: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2486: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2489: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2492: ldc_w 924
    //   2495: lload 13
    //   2497: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2500: invokeinterface 551 3 0
    //   2505: pop
    //   2506: aload_0
    //   2507: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2510: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2513: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2516: aload 27
    //   2518: athrow
    //   2519: iload_3
    //   2520: sipush 200
    //   2523: if_icmpeq +10 -> 2533
    //   2526: iload_3
    //   2527: sipush 206
    //   2530: if_icmpne +2408 -> 4938
    //   2533: lload 9
    //   2535: lstore 15
    //   2537: iload_2
    //   2538: istore 5
    //   2540: lload 9
    //   2542: lstore 13
    //   2544: aload_0
    //   2545: aload_0
    //   2546: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   2549: invokevirtual 1015	java/net/HttpURLConnection:getContentLength	()I
    //   2552: i2l
    //   2553: lload 11
    //   2555: ladd
    //   2556: putfield 600	com/tencent/smtt/sdk/l:m	J
    //   2559: lload 9
    //   2561: lstore 15
    //   2563: iload_2
    //   2564: istore 5
    //   2566: lload 9
    //   2568: lstore 13
    //   2570: ldc 198
    //   2572: new 110	java/lang/StringBuilder
    //   2575: dup
    //   2576: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2579: ldc_w 1017
    //   2582: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: aload_0
    //   2586: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   2589: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2592: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2595: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2598: lload 9
    //   2600: lstore 15
    //   2602: iload_2
    //   2603: istore 5
    //   2605: lload 9
    //   2607: lstore 13
    //   2609: aload_0
    //   2610: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2613: aload_0
    //   2614: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   2617: invokevirtual 1020	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2620: lload 9
    //   2622: lstore 15
    //   2624: iload_2
    //   2625: istore 5
    //   2627: lload 9
    //   2629: lstore 13
    //   2631: aload_0
    //   2632: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2635: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2638: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2641: ldc_w 472
    //   2644: lconst_0
    //   2645: invokeinterface 476 4 0
    //   2650: lstore 17
    //   2652: lload 17
    //   2654: lconst_0
    //   2655: lcmp
    //   2656: ifeq +396 -> 3052
    //   2659: lload 9
    //   2661: lstore 15
    //   2663: iload_2
    //   2664: istore 5
    //   2666: lload 9
    //   2668: lstore 13
    //   2670: aload_0
    //   2671: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   2674: lload 17
    //   2676: lcmp
    //   2677: ifeq +375 -> 3052
    //   2680: lload 9
    //   2682: lstore 15
    //   2684: iload_2
    //   2685: istore 5
    //   2687: lload 9
    //   2689: lstore 13
    //   2691: ldc 198
    //   2693: new 110	java/lang/StringBuilder
    //   2696: dup
    //   2697: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2700: ldc_w 1022
    //   2703: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2706: lload 17
    //   2708: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2711: ldc_w 1024
    //   2714: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: aload_0
    //   2718: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   2721: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2724: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2727: iconst_1
    //   2728: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2731: iload_1
    //   2732: ifne +272 -> 3004
    //   2735: lload 9
    //   2737: lstore 15
    //   2739: iload_2
    //   2740: istore 5
    //   2742: lload 9
    //   2744: lstore 13
    //   2746: aload_0
    //   2747: invokespecial 423	com/tencent/smtt/sdk/l:o	()Z
    //   2750: ifne +41 -> 2791
    //   2753: lload 9
    //   2755: lstore 15
    //   2757: iload_2
    //   2758: istore 5
    //   2760: lload 9
    //   2762: lstore 13
    //   2764: invokestatic 997	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2767: ifeq +237 -> 3004
    //   2770: lload 9
    //   2772: lstore 15
    //   2774: iload_2
    //   2775: istore 5
    //   2777: lload 9
    //   2779: lstore 13
    //   2781: aload_0
    //   2782: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2785: invokestatic 650	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2788: ifeq +216 -> 3004
    //   2791: lload 9
    //   2793: lstore 15
    //   2795: iload_2
    //   2796: istore 5
    //   2798: lload 9
    //   2800: lstore 13
    //   2802: aload_0
    //   2803: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   2806: ifnull +75 -> 2881
    //   2809: lload 9
    //   2811: lstore 15
    //   2813: iload_2
    //   2814: istore 5
    //   2816: lload 9
    //   2818: lstore 13
    //   2820: aload_0
    //   2821: iconst_0
    //   2822: invokevirtual 1008	com/tencent/smtt/sdk/l:b	(Z)Z
    //   2825: istore 6
    //   2827: iload 6
    //   2829: ifeq +52 -> 2881
    //   2832: lload 9
    //   2834: lstore 11
    //   2836: iload_1
    //   2837: ifne -2347 -> 490
    //   2840: aload_0
    //   2841: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2844: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2847: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2850: ldc_w 924
    //   2853: lload 9
    //   2855: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2858: invokeinterface 551 3 0
    //   2863: pop
    //   2864: aload_0
    //   2865: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2868: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2871: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2874: lload 9
    //   2876: lstore 11
    //   2878: goto -2388 -> 490
    //   2881: lload 9
    //   2883: lstore 15
    //   2885: iload_2
    //   2886: istore 5
    //   2888: lload 9
    //   2890: lstore 13
    //   2892: aload_0
    //   2893: bipush 113
    //   2895: new 110	java/lang/StringBuilder
    //   2898: dup
    //   2899: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   2902: ldc_w 1026
    //   2905: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2908: lload 17
    //   2910: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2913: ldc_w 1024
    //   2916: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2919: aload_0
    //   2920: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   2923: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2926: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2929: iconst_1
    //   2930: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   2933: lload 9
    //   2935: lstore 15
    //   2937: iload_2
    //   2938: istore 5
    //   2940: lload 9
    //   2942: lstore 13
    //   2944: aload_0
    //   2945: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2948: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2951: sipush -310
    //   2954: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2957: iload_2
    //   2958: istore 5
    //   2960: iload_1
    //   2961: ifne -2457 -> 504
    //   2964: aload_0
    //   2965: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2968: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2971: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2974: ldc_w 924
    //   2977: lload 9
    //   2979: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2982: invokeinterface 551 3 0
    //   2987: pop
    //   2988: aload_0
    //   2989: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   2992: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2995: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2998: iload_2
    //   2999: istore 5
    //   3001: goto -2497 -> 504
    //   3004: lload 9
    //   3006: lstore 15
    //   3008: iload_2
    //   3009: istore 5
    //   3011: lload 9
    //   3013: lstore 13
    //   3015: aload_0
    //   3016: bipush 101
    //   3018: ldc_w 1028
    //   3021: iconst_1
    //   3022: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3025: lload 9
    //   3027: lstore 15
    //   3029: iload_2
    //   3030: istore 5
    //   3032: lload 9
    //   3034: lstore 13
    //   3036: aload_0
    //   3037: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3040: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3043: sipush -304
    //   3046: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3049: goto -92 -> 2957
    //   3052: aconst_null
    //   3053: astore 31
    //   3055: aconst_null
    //   3056: astore 27
    //   3058: aconst_null
    //   3059: astore 29
    //   3061: lload 9
    //   3063: lstore 15
    //   3065: iload_2
    //   3066: istore 5
    //   3068: lload 9
    //   3070: lstore 13
    //   3072: ldc 198
    //   3074: ldc_w 1030
    //   3077: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3080: aload_0
    //   3081: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   3084: invokevirtual 739	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3087: astore 28
    //   3089: aload 28
    //   3091: ifnull +3451 -> 6542
    //   3094: aload_0
    //   3095: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   3098: invokevirtual 1033	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3101: astore 27
    //   3103: aload 27
    //   3105: ifnull +258 -> 3363
    //   3108: aload 27
    //   3110: ldc_w 1035
    //   3113: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3116: ifeq +247 -> 3363
    //   3119: new 1037	java/util/zip/GZIPInputStream
    //   3122: dup
    //   3123: aload 28
    //   3125: invokespecial 1038	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3128: astore 27
    //   3130: sipush 8192
    //   3133: newarray byte
    //   3135: astore 29
    //   3137: new 1040	java/io/FileOutputStream
    //   3140: dup
    //   3141: new 177	java/io/File
    //   3144: dup
    //   3145: aload_0
    //   3146: getfield 136	com/tencent/smtt/sdk/l:l	Ljava/io/File;
    //   3149: ldc_w 440
    //   3152: invokespecial 221	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3155: iconst_1
    //   3156: invokespecial 1043	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3159: astore 30
    //   3161: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   3164: lstore 15
    //   3166: iconst_0
    //   3167: istore_3
    //   3168: lload 11
    //   3170: lstore 21
    //   3172: lload 11
    //   3174: lstore 13
    //   3176: iload_2
    //   3177: istore 6
    //   3179: lload 9
    //   3181: lstore 17
    //   3183: iload_2
    //   3184: istore 7
    //   3186: lload 9
    //   3188: lstore 19
    //   3190: aload_0
    //   3191: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   3194: ifeq +386 -> 3580
    //   3197: iload_2
    //   3198: istore 6
    //   3200: lload 9
    //   3202: lstore 17
    //   3204: iload_2
    //   3205: istore 7
    //   3207: lload 9
    //   3209: lstore 19
    //   3211: ldc 198
    //   3213: ldc_w 1045
    //   3216: iconst_1
    //   3217: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3220: iload_2
    //   3221: istore 6
    //   3223: lload 9
    //   3225: lstore 17
    //   3227: iload_2
    //   3228: istore 7
    //   3230: lload 9
    //   3232: lstore 19
    //   3234: aload_0
    //   3235: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3238: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3241: sipush -309
    //   3244: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3247: iload_2
    //   3248: istore 6
    //   3250: iload_3
    //   3251: ifeq +1121 -> 4372
    //   3254: lload 9
    //   3256: lstore 15
    //   3258: iload 6
    //   3260: istore 5
    //   3262: lload 9
    //   3264: lstore 13
    //   3266: aload_0
    //   3267: aload 30
    //   3269: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   3272: lload 9
    //   3274: lstore 15
    //   3276: iload 6
    //   3278: istore 5
    //   3280: lload 9
    //   3282: lstore 13
    //   3284: aload_0
    //   3285: aload 27
    //   3287: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   3290: lload 9
    //   3292: lstore 15
    //   3294: iload 6
    //   3296: istore 5
    //   3298: lload 9
    //   3300: lstore 13
    //   3302: aload_0
    //   3303: aload 28
    //   3305: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   3308: lload 9
    //   3310: lstore 11
    //   3312: iload 6
    //   3314: istore_2
    //   3315: iload_1
    //   3316: ifne -2826 -> 490
    //   3319: aload_0
    //   3320: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3323: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3326: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3329: ldc_w 924
    //   3332: lload 9
    //   3334: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3337: invokeinterface 551 3 0
    //   3342: pop
    //   3343: aload_0
    //   3344: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3347: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3350: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3353: lload 9
    //   3355: lstore 11
    //   3357: iload 6
    //   3359: istore_2
    //   3360: goto -2870 -> 490
    //   3363: aload 27
    //   3365: ifnull +208 -> 3573
    //   3368: aload 27
    //   3370: ldc_w 1047
    //   3373: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3376: ifeq +197 -> 3573
    //   3379: new 1049	java/util/zip/InflaterInputStream
    //   3382: dup
    //   3383: aload 28
    //   3385: new 1051	java/util/zip/Inflater
    //   3388: dup
    //   3389: iconst_1
    //   3390: invokespecial 1053	java/util/zip/Inflater:<init>	(Z)V
    //   3393: invokespecial 1056	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3396: astore 27
    //   3398: goto -268 -> 3130
    //   3401: astore 32
    //   3403: aload 28
    //   3405: astore 27
    //   3407: aload 31
    //   3409: astore 30
    //   3411: aload 32
    //   3413: astore 28
    //   3415: iload_2
    //   3416: istore 6
    //   3418: aload 28
    //   3420: invokevirtual 1057	java/io/IOException:printStackTrace	()V
    //   3423: aload 28
    //   3425: instanceof 1059
    //   3428: ifne +11 -> 3439
    //   3431: aload 28
    //   3433: instanceof 1061
    //   3436: ifeq +1079 -> 4515
    //   3439: aload_0
    //   3440: ldc_w 1062
    //   3443: putfield 75	com/tencent/smtt/sdk/l:n	I
    //   3446: aload_0
    //   3447: lconst_0
    //   3448: invokespecial 1064	com/tencent/smtt/sdk/l:a	(J)V
    //   3451: aload_0
    //   3452: bipush 103
    //   3454: aload_0
    //   3455: aload 28
    //   3457: invokespecial 526	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3460: iconst_0
    //   3461: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3464: lload 9
    //   3466: lstore 15
    //   3468: iload 6
    //   3470: istore 5
    //   3472: lload 9
    //   3474: lstore 13
    //   3476: aload_0
    //   3477: aload 30
    //   3479: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   3482: lload 9
    //   3484: lstore 15
    //   3486: iload 6
    //   3488: istore 5
    //   3490: lload 9
    //   3492: lstore 13
    //   3494: aload_0
    //   3495: aload 29
    //   3497: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   3500: lload 9
    //   3502: lstore 15
    //   3504: iload 6
    //   3506: istore 5
    //   3508: lload 9
    //   3510: lstore 13
    //   3512: aload_0
    //   3513: aload 27
    //   3515: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   3518: lload 9
    //   3520: lstore 11
    //   3522: iload 6
    //   3524: istore_2
    //   3525: iload_1
    //   3526: ifne -3036 -> 490
    //   3529: aload_0
    //   3530: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3533: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3536: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3539: ldc_w 924
    //   3542: lload 9
    //   3544: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3547: invokeinterface 551 3 0
    //   3552: pop
    //   3553: aload_0
    //   3554: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3557: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3560: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3563: lload 9
    //   3565: lstore 11
    //   3567: iload 6
    //   3569: istore_2
    //   3570: goto -3080 -> 490
    //   3573: aload 28
    //   3575: astore 27
    //   3577: goto -447 -> 3130
    //   3580: iload_2
    //   3581: istore 6
    //   3583: lload 9
    //   3585: lstore 17
    //   3587: iload_2
    //   3588: istore 7
    //   3590: lload 9
    //   3592: lstore 19
    //   3594: aload 27
    //   3596: aload 29
    //   3598: iconst_0
    //   3599: sipush 8192
    //   3602: invokevirtual 1070	java/io/InputStream:read	([BII)I
    //   3605: istore 4
    //   3607: iload 4
    //   3609: ifgt +189 -> 3798
    //   3612: iload_2
    //   3613: istore 6
    //   3615: lload 9
    //   3617: lstore 17
    //   3619: iload_2
    //   3620: istore 7
    //   3622: lload 9
    //   3624: lstore 19
    //   3626: aload_0
    //   3627: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   3630: ifnull +86 -> 3716
    //   3633: iload_2
    //   3634: istore 6
    //   3636: lload 9
    //   3638: lstore 17
    //   3640: iload_2
    //   3641: istore 7
    //   3643: lload 9
    //   3645: lstore 19
    //   3647: aload_0
    //   3648: iconst_1
    //   3649: iload 8
    //   3651: invokespecial 866	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   3654: ifne +62 -> 3716
    //   3657: iload_1
    //   3658: ifne +33 -> 3691
    //   3661: iload_2
    //   3662: istore 6
    //   3664: lload 9
    //   3666: lstore 17
    //   3668: iload_2
    //   3669: istore 7
    //   3671: lload 9
    //   3673: lstore 19
    //   3675: aload_0
    //   3676: iconst_0
    //   3677: invokevirtual 1008	com/tencent/smtt/sdk/l:b	(Z)Z
    //   3680: ifeq +11 -> 3691
    //   3683: iconst_1
    //   3684: istore_3
    //   3685: iload_2
    //   3686: istore 6
    //   3688: goto -438 -> 3250
    //   3691: iload_2
    //   3692: istore 6
    //   3694: lload 9
    //   3696: lstore 17
    //   3698: iload_2
    //   3699: istore 7
    //   3701: lload 9
    //   3703: lstore 19
    //   3705: aload_0
    //   3706: iconst_1
    //   3707: putfield 608	com/tencent/smtt/sdk/l:t	Z
    //   3710: iconst_0
    //   3711: istore 6
    //   3713: goto -463 -> 3250
    //   3716: iload_2
    //   3717: istore 6
    //   3719: lload 9
    //   3721: lstore 17
    //   3723: iload_2
    //   3724: istore 7
    //   3726: lload 9
    //   3728: lstore 19
    //   3730: aload_0
    //   3731: iconst_1
    //   3732: putfield 608	com/tencent/smtt/sdk/l:t	Z
    //   3735: iload_2
    //   3736: istore 5
    //   3738: iload_2
    //   3739: istore 6
    //   3741: lload 9
    //   3743: lstore 17
    //   3745: iload_2
    //   3746: istore 7
    //   3748: lload 9
    //   3750: lstore 19
    //   3752: aload_0
    //   3753: getfield 81	com/tencent/smtt/sdk/l:b	[Ljava/lang/String;
    //   3756: ifnull +6 -> 3762
    //   3759: iconst_1
    //   3760: istore 5
    //   3762: iload 5
    //   3764: istore 6
    //   3766: lload 9
    //   3768: lstore 17
    //   3770: iload 5
    //   3772: istore 7
    //   3774: lload 9
    //   3776: lstore 19
    //   3778: aload_0
    //   3779: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3782: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3785: sipush -311
    //   3788: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3791: iload 5
    //   3793: istore 6
    //   3795: goto -545 -> 3250
    //   3798: iload_2
    //   3799: istore 6
    //   3801: lload 9
    //   3803: lstore 17
    //   3805: iload_2
    //   3806: istore 7
    //   3808: lload 9
    //   3810: lstore 19
    //   3812: aload 30
    //   3814: aload 29
    //   3816: iconst_0
    //   3817: iload 4
    //   3819: invokevirtual 1074	java/io/FileOutputStream:write	([BII)V
    //   3822: iload_2
    //   3823: istore 6
    //   3825: lload 9
    //   3827: lstore 17
    //   3829: iload_2
    //   3830: istore 7
    //   3832: lload 9
    //   3834: lstore 19
    //   3836: aload 30
    //   3838: invokevirtual 1077	java/io/FileOutputStream:flush	()V
    //   3841: lload 9
    //   3843: lstore 11
    //   3845: iload_1
    //   3846: ifne +274 -> 4120
    //   3849: lload 9
    //   3851: iload 4
    //   3853: i2l
    //   3854: ladd
    //   3855: lstore 9
    //   3857: lload 9
    //   3859: lload 25
    //   3861: lcmp
    //   3862: iflt +112 -> 3974
    //   3865: iload_2
    //   3866: istore 6
    //   3868: lload 9
    //   3870: lstore 17
    //   3872: iload_2
    //   3873: istore 7
    //   3875: lload 9
    //   3877: lstore 19
    //   3879: ldc 198
    //   3881: ldc_w 958
    //   3884: iconst_1
    //   3885: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3888: iload_2
    //   3889: istore 6
    //   3891: lload 9
    //   3893: lstore 17
    //   3895: iload_2
    //   3896: istore 7
    //   3898: lload 9
    //   3900: lstore 19
    //   3902: aload_0
    //   3903: bipush 112
    //   3905: new 110	java/lang/StringBuilder
    //   3908: dup
    //   3909: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   3912: ldc_w 1079
    //   3915: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3918: lload 9
    //   3920: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3923: ldc_w 1081
    //   3926: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3929: lload 25
    //   3931: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3934: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3937: iconst_1
    //   3938: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   3941: iload_2
    //   3942: istore 6
    //   3944: lload 9
    //   3946: lstore 17
    //   3948: iload_2
    //   3949: istore 7
    //   3951: lload 9
    //   3953: lstore 19
    //   3955: aload_0
    //   3956: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3959: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3962: sipush -307
    //   3965: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3968: iload_2
    //   3969: istore 6
    //   3971: goto -721 -> 3250
    //   3974: lload 9
    //   3976: lstore 11
    //   3978: iload_2
    //   3979: istore 6
    //   3981: lload 9
    //   3983: lstore 17
    //   3985: iload_2
    //   3986: istore 7
    //   3988: lload 9
    //   3990: lstore 19
    //   3992: aload_0
    //   3993: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   3996: invokestatic 952	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   3999: ifne +121 -> 4120
    //   4002: iload_2
    //   4003: istore 6
    //   4005: lload 9
    //   4007: lstore 17
    //   4009: iload_2
    //   4010: istore 7
    //   4012: lload 9
    //   4014: lstore 19
    //   4016: ldc 198
    //   4018: ldc_w 1083
    //   4021: iconst_1
    //   4022: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4025: iload_2
    //   4026: istore 6
    //   4028: lload 9
    //   4030: lstore 17
    //   4032: iload_2
    //   4033: istore 7
    //   4035: lload 9
    //   4037: lstore 19
    //   4039: aload_0
    //   4040: bipush 105
    //   4042: new 110	java/lang/StringBuilder
    //   4045: dup
    //   4046: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   4049: ldc_w 1085
    //   4052: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4055: invokestatic 1087	com/tencent/smtt/utils/p:a	()J
    //   4058: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4061: ldc_w 1089
    //   4064: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4067: aload_0
    //   4068: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4071: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4074: invokevirtual 1092	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4077: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4080: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4083: iconst_1
    //   4084: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4087: iload_2
    //   4088: istore 6
    //   4090: lload 9
    //   4092: lstore 17
    //   4094: iload_2
    //   4095: istore 7
    //   4097: lload 9
    //   4099: lstore 19
    //   4101: aload_0
    //   4102: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4105: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4108: sipush -308
    //   4111: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4114: iload_2
    //   4115: istore 6
    //   4117: goto -867 -> 3250
    //   4120: iload 4
    //   4122: i2l
    //   4123: lstore 9
    //   4125: aload_0
    //   4126: lload 23
    //   4128: lload 9
    //   4130: invokespecial 1094	com/tencent/smtt/sdk/l:a	(JJ)J
    //   4133: lstore 23
    //   4135: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   4138: lstore 19
    //   4140: iload 4
    //   4142: i2l
    //   4143: lload 21
    //   4145: ladd
    //   4146: lstore 17
    //   4148: lload 19
    //   4150: lload 15
    //   4152: lsub
    //   4153: ldc2_w 1095
    //   4156: lcmp
    //   4157: ifle +2374 -> 6531
    //   4160: ldc 198
    //   4162: new 110	java/lang/StringBuilder
    //   4165: dup
    //   4166: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   4169: ldc_w 1098
    //   4172: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4175: lload 17
    //   4177: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4180: ldc_w 1004
    //   4183: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4186: aload_0
    //   4187: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   4190: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4193: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4196: iconst_1
    //   4197: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4200: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4203: ifnull +29 -> 4232
    //   4206: lload 17
    //   4208: l2d
    //   4209: aload_0
    //   4210: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   4213: l2d
    //   4214: ddiv
    //   4215: ldc2_w 1099
    //   4218: dmul
    //   4219: d2i
    //   4220: istore 4
    //   4222: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4225: iload 4
    //   4227: invokeinterface 1103 2 0
    //   4232: lload 13
    //   4234: lstore 9
    //   4236: iload_1
    //   4237: ifne +112 -> 4349
    //   4240: lload 13
    //   4242: lstore 9
    //   4244: lload 17
    //   4246: lload 13
    //   4248: lsub
    //   4249: ldc2_w 1104
    //   4252: lcmp
    //   4253: ifle +96 -> 4349
    //   4256: aload_0
    //   4257: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4260: invokestatic 216	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4263: ifne +82 -> 4345
    //   4266: aload_0
    //   4267: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4270: invokestatic 635	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4273: iconst_3
    //   4274: if_icmpne +13 -> 4287
    //   4277: aload_0
    //   4278: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4281: invokestatic 635	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4284: ifne +61 -> 4345
    //   4287: invokestatic 997	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4290: ifne +55 -> 4345
    //   4293: aload_0
    //   4294: invokevirtual 998	com/tencent/smtt/sdk/l:b	()V
    //   4297: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4300: ifnull +13 -> 4313
    //   4303: getstatic 563	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4306: bipush 111
    //   4308: invokeinterface 568 2 0
    //   4313: ldc 198
    //   4315: ldc_w 1107
    //   4318: iconst_0
    //   4319: invokestatic 896	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4322: aload_0
    //   4323: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4326: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4329: sipush -304
    //   4332: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4335: lload 11
    //   4337: lstore 9
    //   4339: iload_2
    //   4340: istore 6
    //   4342: goto -1092 -> 3250
    //   4345: lload 17
    //   4347: lstore 9
    //   4349: lload 19
    //   4351: lstore 13
    //   4353: lload 13
    //   4355: lstore 15
    //   4357: lload 9
    //   4359: lstore 13
    //   4361: lload 11
    //   4363: lstore 9
    //   4365: lload 17
    //   4367: lstore 21
    //   4369: goto -1193 -> 3176
    //   4372: iload 6
    //   4374: istore_2
    //   4375: iload_2
    //   4376: istore 5
    //   4378: lload 9
    //   4380: lstore 11
    //   4382: lload 9
    //   4384: lstore 13
    //   4386: aload_0
    //   4387: aload 30
    //   4389: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4392: iload_2
    //   4393: istore 5
    //   4395: lload 9
    //   4397: lstore 11
    //   4399: lload 9
    //   4401: lstore 13
    //   4403: aload_0
    //   4404: aload 27
    //   4406: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4409: iload_2
    //   4410: istore 5
    //   4412: lload 9
    //   4414: lstore 11
    //   4416: lload 9
    //   4418: lstore 13
    //   4420: aload_0
    //   4421: aload 28
    //   4423: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4426: iload_2
    //   4427: istore 5
    //   4429: lload 9
    //   4431: lstore 11
    //   4433: lload 9
    //   4435: lstore 13
    //   4437: aload_0
    //   4438: getfield 608	com/tencent/smtt/sdk/l:t	Z
    //   4441: ifne +27 -> 4468
    //   4444: iload_2
    //   4445: istore 5
    //   4447: lload 9
    //   4449: lstore 11
    //   4451: lload 9
    //   4453: lstore 13
    //   4455: aload_0
    //   4456: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4459: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4462: sipush -319
    //   4465: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4468: iload_2
    //   4469: istore 5
    //   4471: iload_1
    //   4472: ifne -3968 -> 504
    //   4475: aload_0
    //   4476: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4479: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4482: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4485: ldc_w 924
    //   4488: lload 9
    //   4490: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4493: invokeinterface 551 3 0
    //   4498: pop
    //   4499: aload_0
    //   4500: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4503: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4506: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4509: iload_2
    //   4510: istore 5
    //   4512: goto -4008 -> 504
    //   4515: iload_1
    //   4516: ifne +177 -> 4693
    //   4519: aload_0
    //   4520: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4523: invokestatic 952	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   4526: ifne +167 -> 4693
    //   4529: aload_0
    //   4530: bipush 105
    //   4532: new 110	java/lang/StringBuilder
    //   4535: dup
    //   4536: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   4539: ldc_w 1085
    //   4542: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4545: invokestatic 1087	com/tencent/smtt/utils/p:a	()J
    //   4548: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4551: ldc_w 1089
    //   4554: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4557: aload_0
    //   4558: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4561: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4564: invokevirtual 1092	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4567: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4570: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4573: iconst_1
    //   4574: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4577: aload_0
    //   4578: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4581: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4584: sipush -308
    //   4587: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4590: lload 9
    //   4592: lstore 15
    //   4594: iload 6
    //   4596: istore 5
    //   4598: lload 9
    //   4600: lstore 13
    //   4602: aload_0
    //   4603: aload 30
    //   4605: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4608: lload 9
    //   4610: lstore 15
    //   4612: iload 6
    //   4614: istore 5
    //   4616: lload 9
    //   4618: lstore 13
    //   4620: aload_0
    //   4621: aload 29
    //   4623: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4626: lload 9
    //   4628: lstore 15
    //   4630: iload 6
    //   4632: istore 5
    //   4634: lload 9
    //   4636: lstore 13
    //   4638: aload_0
    //   4639: aload 27
    //   4641: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4644: iload 6
    //   4646: istore 5
    //   4648: iload_1
    //   4649: ifne -4145 -> 504
    //   4652: aload_0
    //   4653: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4656: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4659: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4662: ldc_w 924
    //   4665: lload 9
    //   4667: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4670: invokeinterface 551 3 0
    //   4675: pop
    //   4676: aload_0
    //   4677: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4680: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4683: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4686: iload 6
    //   4688: istore 5
    //   4690: goto -4186 -> 504
    //   4693: aload_0
    //   4694: lconst_0
    //   4695: invokespecial 1064	com/tencent/smtt/sdk/l:a	(J)V
    //   4698: aload_0
    //   4699: invokespecial 1109	com/tencent/smtt/sdk/l:k	()Z
    //   4702: ifne +125 -> 4827
    //   4705: aload_0
    //   4706: bipush 106
    //   4708: aload_0
    //   4709: aload 28
    //   4711: invokespecial 526	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4714: iconst_0
    //   4715: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4718: lload 9
    //   4720: lstore 15
    //   4722: iload 6
    //   4724: istore 5
    //   4726: lload 9
    //   4728: lstore 13
    //   4730: aload_0
    //   4731: aload 30
    //   4733: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4736: lload 9
    //   4738: lstore 15
    //   4740: iload 6
    //   4742: istore 5
    //   4744: lload 9
    //   4746: lstore 13
    //   4748: aload_0
    //   4749: aload 29
    //   4751: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4754: lload 9
    //   4756: lstore 15
    //   4758: iload 6
    //   4760: istore 5
    //   4762: lload 9
    //   4764: lstore 13
    //   4766: aload_0
    //   4767: aload 27
    //   4769: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4772: lload 9
    //   4774: lstore 11
    //   4776: iload 6
    //   4778: istore_2
    //   4779: iload_1
    //   4780: ifne -4290 -> 490
    //   4783: aload_0
    //   4784: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4787: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4790: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4793: ldc_w 924
    //   4796: lload 9
    //   4798: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4801: invokeinterface 551 3 0
    //   4806: pop
    //   4807: aload_0
    //   4808: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   4811: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4814: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4817: lload 9
    //   4819: lstore 11
    //   4821: iload 6
    //   4823: istore_2
    //   4824: goto -4334 -> 490
    //   4827: aload_0
    //   4828: bipush 104
    //   4830: aload_0
    //   4831: aload 28
    //   4833: invokespecial 526	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4836: iconst_0
    //   4837: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   4840: goto -122 -> 4718
    //   4843: astore 31
    //   4845: aload 27
    //   4847: astore 28
    //   4849: aload 29
    //   4851: astore 27
    //   4853: iload 6
    //   4855: istore_2
    //   4856: aload 31
    //   4858: astore 29
    //   4860: iload_2
    //   4861: istore 5
    //   4863: lload 9
    //   4865: lstore 11
    //   4867: lload 9
    //   4869: lstore 13
    //   4871: aload_0
    //   4872: aload 30
    //   4874: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4877: iload_2
    //   4878: istore 5
    //   4880: lload 9
    //   4882: lstore 11
    //   4884: lload 9
    //   4886: lstore 13
    //   4888: aload_0
    //   4889: aload 27
    //   4891: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4894: iload_2
    //   4895: istore 5
    //   4897: lload 9
    //   4899: lstore 11
    //   4901: lload 9
    //   4903: lstore 13
    //   4905: aload_0
    //   4906: aload 28
    //   4908: invokespecial 719	com/tencent/smtt/sdk/l:a	(Ljava/io/Closeable;)V
    //   4911: iload_2
    //   4912: istore 5
    //   4914: lload 9
    //   4916: lstore 11
    //   4918: lload 9
    //   4920: lstore 13
    //   4922: aload 29
    //   4924: athrow
    //   4925: astore 27
    //   4927: lload 11
    //   4929: lstore 15
    //   4931: iload 5
    //   4933: istore 6
    //   4935: goto -2730 -> 2205
    //   4938: iload_3
    //   4939: sipush 300
    //   4942: if_icmplt +229 -> 5171
    //   4945: iload_3
    //   4946: sipush 307
    //   4949: if_icmpgt +222 -> 5171
    //   4952: lload 9
    //   4954: lstore 15
    //   4956: iload_2
    //   4957: istore 5
    //   4959: lload 9
    //   4961: lstore 13
    //   4963: aload_0
    //   4964: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   4967: ldc_w 1111
    //   4970: invokevirtual 1115	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   4973: astore 27
    //   4975: lload 9
    //   4977: lstore 15
    //   4979: iload_2
    //   4980: istore 5
    //   4982: lload 9
    //   4984: lstore 13
    //   4986: aload 27
    //   4988: invokestatic 749	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4991: ifne +90 -> 5081
    //   4994: lload 9
    //   4996: lstore 15
    //   4998: iload_2
    //   4999: istore 5
    //   5001: lload 9
    //   5003: lstore 13
    //   5005: aload_0
    //   5006: aload 27
    //   5008: putfield 602	com/tencent/smtt/sdk/l:k	Ljava/lang/String;
    //   5011: lload 9
    //   5013: lstore 15
    //   5015: iload_2
    //   5016: istore 5
    //   5018: lload 9
    //   5020: lstore 13
    //   5022: aload_0
    //   5023: aload_0
    //   5024: getfield 596	com/tencent/smtt/sdk/l:r	I
    //   5027: iconst_1
    //   5028: iadd
    //   5029: putfield 596	com/tencent/smtt/sdk/l:r	I
    //   5032: lload 9
    //   5034: lstore 11
    //   5036: iload_1
    //   5037: ifne -4547 -> 490
    //   5040: aload_0
    //   5041: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5044: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5047: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5050: ldc_w 924
    //   5053: lload 9
    //   5055: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5058: invokeinterface 551 3 0
    //   5063: pop
    //   5064: aload_0
    //   5065: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5068: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5071: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5074: lload 9
    //   5076: lstore 11
    //   5078: goto -4588 -> 490
    //   5081: lload 9
    //   5083: lstore 15
    //   5085: iload_2
    //   5086: istore 5
    //   5088: lload 9
    //   5090: lstore 13
    //   5092: aload_0
    //   5093: bipush 124
    //   5095: aconst_null
    //   5096: iconst_1
    //   5097: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5100: lload 9
    //   5102: lstore 15
    //   5104: iload_2
    //   5105: istore 5
    //   5107: lload 9
    //   5109: lstore 13
    //   5111: aload_0
    //   5112: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5115: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5118: sipush -312
    //   5121: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5124: iload_2
    //   5125: istore 5
    //   5127: iload_1
    //   5128: ifne -4624 -> 504
    //   5131: aload_0
    //   5132: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5135: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5138: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5141: ldc_w 924
    //   5144: lload 9
    //   5146: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5149: invokeinterface 551 3 0
    //   5154: pop
    //   5155: aload_0
    //   5156: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5159: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5162: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5165: iload_2
    //   5166: istore 5
    //   5168: goto -4664 -> 504
    //   5171: lload 9
    //   5173: lstore 15
    //   5175: iload_2
    //   5176: istore 5
    //   5178: lload 9
    //   5180: lstore 13
    //   5182: aload_0
    //   5183: bipush 102
    //   5185: iload_3
    //   5186: invokestatic 1118	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5189: iconst_0
    //   5190: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   5193: iload_3
    //   5194: sipush 416
    //   5197: if_icmpne +185 -> 5382
    //   5200: lload 9
    //   5202: lstore 15
    //   5204: iload_2
    //   5205: istore 5
    //   5207: lload 9
    //   5209: lstore 13
    //   5211: aload_0
    //   5212: iconst_1
    //   5213: iload 8
    //   5215: invokespecial 866	com/tencent/smtt/sdk/l:c	(ZZ)Z
    //   5218: ifeq +76 -> 5294
    //   5221: iconst_1
    //   5222: istore 5
    //   5224: iconst_1
    //   5225: istore_2
    //   5226: lload 9
    //   5228: lstore 15
    //   5230: lload 9
    //   5232: lstore 13
    //   5234: aload_0
    //   5235: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5238: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5241: sipush -214
    //   5244: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5247: iload_2
    //   5248: istore 5
    //   5250: iload_1
    //   5251: ifne -4747 -> 504
    //   5254: aload_0
    //   5255: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5258: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5261: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5264: ldc_w 924
    //   5267: lload 9
    //   5269: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5272: invokeinterface 551 3 0
    //   5277: pop
    //   5278: aload_0
    //   5279: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5282: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5285: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5288: iload_2
    //   5289: istore 5
    //   5291: goto -4787 -> 504
    //   5294: lload 9
    //   5296: lstore 15
    //   5298: iload_2
    //   5299: istore 5
    //   5301: lload 9
    //   5303: lstore 13
    //   5305: aload_0
    //   5306: iconst_0
    //   5307: invokespecial 868	com/tencent/smtt/sdk/l:e	(Z)Z
    //   5310: pop
    //   5311: lload 9
    //   5313: lstore 15
    //   5315: iload_2
    //   5316: istore 5
    //   5318: lload 9
    //   5320: lstore 13
    //   5322: aload_0
    //   5323: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5326: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5329: sipush -313
    //   5332: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5335: iload_2
    //   5336: istore 5
    //   5338: iload_1
    //   5339: ifne -4835 -> 504
    //   5342: aload_0
    //   5343: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5346: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5349: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5352: ldc_w 924
    //   5355: lload 9
    //   5357: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5360: invokeinterface 551 3 0
    //   5365: pop
    //   5366: aload_0
    //   5367: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5370: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5373: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5376: iload_2
    //   5377: istore 5
    //   5379: goto -4875 -> 504
    //   5382: iload_3
    //   5383: sipush 403
    //   5386: if_icmpeq +10 -> 5396
    //   5389: iload_3
    //   5390: sipush 406
    //   5393: if_icmpne +96 -> 5489
    //   5396: lload 9
    //   5398: lstore 15
    //   5400: iload_2
    //   5401: istore 5
    //   5403: lload 9
    //   5405: lstore 13
    //   5407: aload_0
    //   5408: getfield 600	com/tencent/smtt/sdk/l:m	J
    //   5411: ldc2_w 597
    //   5414: lcmp
    //   5415: ifne +74 -> 5489
    //   5418: lload 9
    //   5420: lstore 15
    //   5422: iload_2
    //   5423: istore 5
    //   5425: lload 9
    //   5427: lstore 13
    //   5429: aload_0
    //   5430: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5433: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5436: sipush -314
    //   5439: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5442: iload_2
    //   5443: istore 5
    //   5445: iload_1
    //   5446: ifne -4942 -> 504
    //   5449: aload_0
    //   5450: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5453: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5456: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5459: ldc_w 924
    //   5462: lload 9
    //   5464: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5467: invokeinterface 551 3 0
    //   5472: pop
    //   5473: aload_0
    //   5474: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5477: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5480: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5483: iload_2
    //   5484: istore 5
    //   5486: goto -4982 -> 504
    //   5489: iload_3
    //   5490: sipush 202
    //   5493: if_icmpne +52 -> 5545
    //   5496: lload 9
    //   5498: lstore 11
    //   5500: iload_1
    //   5501: ifne -5011 -> 490
    //   5504: aload_0
    //   5505: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5508: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5511: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5514: ldc_w 924
    //   5517: lload 9
    //   5519: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5522: invokeinterface 551 3 0
    //   5527: pop
    //   5528: aload_0
    //   5529: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5532: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5535: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5538: lload 9
    //   5540: lstore 11
    //   5542: goto -5052 -> 490
    //   5545: lload 9
    //   5547: lstore 15
    //   5549: iload_2
    //   5550: istore 5
    //   5552: lload 9
    //   5554: lstore 13
    //   5556: aload_0
    //   5557: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   5560: aload_0
    //   5561: getfield 79	com/tencent/smtt/sdk/l:C	I
    //   5564: if_icmpge +176 -> 5740
    //   5567: iload_3
    //   5568: sipush 503
    //   5571: if_icmpne +169 -> 5740
    //   5574: lload 9
    //   5576: lstore 15
    //   5578: iload_2
    //   5579: istore 5
    //   5581: lload 9
    //   5583: lstore 13
    //   5585: aload_0
    //   5586: aload_0
    //   5587: getfield 381	com/tencent/smtt/sdk/l:u	Ljava/net/HttpURLConnection;
    //   5590: ldc_w 1120
    //   5593: invokevirtual 1115	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5596: invokestatic 1124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5599: invokespecial 1064	com/tencent/smtt/sdk/l:a	(J)V
    //   5602: lload 9
    //   5604: lstore 15
    //   5606: iload_2
    //   5607: istore 5
    //   5609: lload 9
    //   5611: lstore 13
    //   5613: aload_0
    //   5614: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   5617: ifeq +74 -> 5691
    //   5620: lload 9
    //   5622: lstore 15
    //   5624: iload_2
    //   5625: istore 5
    //   5627: lload 9
    //   5629: lstore 13
    //   5631: aload_0
    //   5632: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5635: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5638: sipush -309
    //   5641: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5644: iload_2
    //   5645: istore 5
    //   5647: iload_1
    //   5648: ifne -5144 -> 504
    //   5651: aload_0
    //   5652: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5655: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5658: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5661: ldc_w 924
    //   5664: lload 9
    //   5666: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5669: invokeinterface 551 3 0
    //   5674: pop
    //   5675: aload_0
    //   5676: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5679: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5682: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5685: iload_2
    //   5686: istore 5
    //   5688: goto -5184 -> 504
    //   5691: lload 9
    //   5693: lstore 11
    //   5695: iload_1
    //   5696: ifne -5206 -> 490
    //   5699: aload_0
    //   5700: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5703: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5706: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5709: ldc_w 924
    //   5712: lload 9
    //   5714: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5717: invokeinterface 551 3 0
    //   5722: pop
    //   5723: aload_0
    //   5724: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5727: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5730: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5733: lload 9
    //   5735: lstore 11
    //   5737: goto -5247 -> 490
    //   5740: lload 9
    //   5742: lstore 15
    //   5744: iload_2
    //   5745: istore 5
    //   5747: lload 9
    //   5749: lstore 13
    //   5751: aload_0
    //   5752: getfield 262	com/tencent/smtt/sdk/l:q	I
    //   5755: aload_0
    //   5756: getfield 79	com/tencent/smtt/sdk/l:C	I
    //   5759: if_icmpge +185 -> 5944
    //   5762: iload_3
    //   5763: sipush 408
    //   5766: if_icmpeq +24 -> 5790
    //   5769: iload_3
    //   5770: sipush 504
    //   5773: if_icmpeq +17 -> 5790
    //   5776: iload_3
    //   5777: sipush 502
    //   5780: if_icmpeq +10 -> 5790
    //   5783: iload_3
    //   5784: sipush 408
    //   5787: if_icmpne +157 -> 5944
    //   5790: lload 9
    //   5792: lstore 15
    //   5794: iload_2
    //   5795: istore 5
    //   5797: lload 9
    //   5799: lstore 13
    //   5801: aload_0
    //   5802: lconst_0
    //   5803: invokespecial 1064	com/tencent/smtt/sdk/l:a	(J)V
    //   5806: lload 9
    //   5808: lstore 15
    //   5810: iload_2
    //   5811: istore 5
    //   5813: lload 9
    //   5815: lstore 13
    //   5817: aload_0
    //   5818: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   5821: ifeq +74 -> 5895
    //   5824: lload 9
    //   5826: lstore 15
    //   5828: iload_2
    //   5829: istore 5
    //   5831: lload 9
    //   5833: lstore 13
    //   5835: aload_0
    //   5836: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5839: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5842: sipush -309
    //   5845: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5848: iload_2
    //   5849: istore 5
    //   5851: iload_1
    //   5852: ifne -5348 -> 504
    //   5855: aload_0
    //   5856: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5859: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5862: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5865: ldc_w 924
    //   5868: lload 9
    //   5870: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5873: invokeinterface 551 3 0
    //   5878: pop
    //   5879: aload_0
    //   5880: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5883: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5886: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5889: iload_2
    //   5890: istore 5
    //   5892: goto -5388 -> 504
    //   5895: lload 9
    //   5897: lstore 11
    //   5899: iload_1
    //   5900: ifne -5410 -> 490
    //   5903: aload_0
    //   5904: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5907: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5910: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5913: ldc_w 924
    //   5916: lload 9
    //   5918: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5921: invokeinterface 551 3 0
    //   5926: pop
    //   5927: aload_0
    //   5928: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   5931: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5934: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5937: lload 9
    //   5939: lstore 11
    //   5941: goto -5451 -> 490
    //   5944: lload 9
    //   5946: lstore 15
    //   5948: iload_2
    //   5949: istore 5
    //   5951: lload 9
    //   5953: lstore 13
    //   5955: aload_0
    //   5956: invokespecial 971	com/tencent/smtt/sdk/l:l	()J
    //   5959: lconst_0
    //   5960: lcmp
    //   5961: ifgt +93 -> 6054
    //   5964: lload 9
    //   5966: lstore 15
    //   5968: iload_2
    //   5969: istore 5
    //   5971: lload 9
    //   5973: lstore 13
    //   5975: aload_0
    //   5976: getfield 604	com/tencent/smtt/sdk/l:p	Z
    //   5979: ifne +75 -> 6054
    //   5982: iload_3
    //   5983: sipush 410
    //   5986: if_icmpeq +68 -> 6054
    //   5989: lload 9
    //   5991: lstore 15
    //   5993: iload_2
    //   5994: istore 5
    //   5996: lload 9
    //   5998: lstore 13
    //   6000: aload_0
    //   6001: iconst_1
    //   6002: putfield 604	com/tencent/smtt/sdk/l:p	Z
    //   6005: lload 9
    //   6007: lstore 11
    //   6009: iload_1
    //   6010: ifne -5520 -> 490
    //   6013: aload_0
    //   6014: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6017: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6020: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6023: ldc_w 924
    //   6026: lload 9
    //   6028: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6031: invokeinterface 551 3 0
    //   6036: pop
    //   6037: aload_0
    //   6038: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6041: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6044: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6047: lload 9
    //   6049: lstore 11
    //   6051: goto -5561 -> 490
    //   6054: lload 9
    //   6056: lstore 15
    //   6058: iload_2
    //   6059: istore 5
    //   6061: lload 9
    //   6063: lstore 13
    //   6065: aload_0
    //   6066: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6069: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6072: sipush -315
    //   6075: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6078: iload_2
    //   6079: istore 5
    //   6081: iload_1
    //   6082: ifne -5578 -> 504
    //   6085: aload_0
    //   6086: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6089: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6092: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6095: ldc_w 924
    //   6098: lload 9
    //   6100: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6103: invokeinterface 551 3 0
    //   6108: pop
    //   6109: aload_0
    //   6110: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6113: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6116: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6119: iload_2
    //   6120: istore 5
    //   6122: goto -5618 -> 504
    //   6125: lload 15
    //   6127: lstore 13
    //   6129: aload 27
    //   6131: invokevirtual 720	java/lang/Throwable:printStackTrace	()V
    //   6134: lload 15
    //   6136: lstore 13
    //   6138: aload_0
    //   6139: lconst_0
    //   6140: invokespecial 1064	com/tencent/smtt/sdk/l:a	(J)V
    //   6143: lload 15
    //   6145: lstore 13
    //   6147: aload_0
    //   6148: bipush 107
    //   6150: aload_0
    //   6151: aload 27
    //   6153: invokespecial 526	com/tencent/smtt/sdk/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6156: iconst_0
    //   6157: invokespecial 528	com/tencent/smtt/sdk/l:a	(ILjava/lang/String;Z)V
    //   6160: lload 15
    //   6162: lstore 13
    //   6164: aload_0
    //   6165: getfield 606	com/tencent/smtt/sdk/l:s	Z
    //   6168: ifeq -3866 -> 2302
    //   6171: lload 15
    //   6173: lstore 13
    //   6175: aload_0
    //   6176: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6179: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6182: sipush -309
    //   6185: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6188: iload 6
    //   6190: istore 5
    //   6192: iload_1
    //   6193: ifne -5689 -> 504
    //   6196: aload_0
    //   6197: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6200: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6203: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6206: ldc_w 924
    //   6209: lload 15
    //   6211: invokestatic 950	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6214: invokeinterface 551 3 0
    //   6219: pop
    //   6220: aload_0
    //   6221: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6224: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6227: invokevirtual 558	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6230: iload 6
    //   6232: istore 5
    //   6234: goto -5730 -> 504
    //   6237: iconst_0
    //   6238: istore_3
    //   6239: goto -5680 -> 559
    //   6242: iconst_2
    //   6243: istore_3
    //   6244: goto -5662 -> 582
    //   6247: aload_0
    //   6248: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6251: iconst_0
    //   6252: invokevirtual 930	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6255: goto -5667 -> 588
    //   6258: aload_0
    //   6259: getfield 91	com/tencent/smtt/sdk/l:h	Landroid/content/Context;
    //   6262: invokestatic 294	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6265: sipush -318
    //   6268: invokevirtual 856	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6271: aload_0
    //   6272: iconst_0
    //   6273: invokespecial 868	com/tencent/smtt/sdk/l:e	(Z)Z
    //   6276: pop
    //   6277: goto -5657 -> 620
    //   6280: aload 27
    //   6282: getfield 298	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6285: ldc_w 1126
    //   6288: iconst_0
    //   6289: invokeinterface 306 3 0
    //   6294: istore_3
    //   6295: aload 27
    //   6297: getfield 538	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6300: astore 28
    //   6302: iload_3
    //   6303: iconst_1
    //   6304: iadd
    //   6305: istore_3
    //   6306: aload 28
    //   6308: ldc_w 1126
    //   6311: iload_3
    //   6312: invokestatic 519	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6315: invokeinterface 551 3 0
    //   6320: pop
    //   6321: iload_3
    //   6322: aload 27
    //   6324: invokevirtual 1129	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6327: if_icmpne -5659 -> 668
    //   6330: aload_0
    //   6331: getfield 103	com/tencent/smtt/sdk/l:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6334: iconst_2
    //   6335: invokevirtual 984	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6338: goto -5670 -> 668
    //   6341: iconst_0
    //   6342: istore_3
    //   6343: goto -5658 -> 685
    //   6346: astore 27
    //   6348: goto -3870 -> 2478
    //   6351: astore 29
    //   6353: aconst_null
    //   6354: astore 27
    //   6356: aconst_null
    //   6357: astore 28
    //   6359: aconst_null
    //   6360: astore 30
    //   6362: goto -1502 -> 4860
    //   6365: astore 29
    //   6367: aconst_null
    //   6368: astore 27
    //   6370: aconst_null
    //   6371: astore 30
    //   6373: goto -1513 -> 4860
    //   6376: astore 29
    //   6378: aconst_null
    //   6379: astore 30
    //   6381: goto -1521 -> 4860
    //   6384: astore 29
    //   6386: goto -1526 -> 4860
    //   6389: astore 29
    //   6391: iload 6
    //   6393: istore_2
    //   6394: lload 17
    //   6396: lstore 9
    //   6398: goto -1538 -> 4860
    //   6401: astore 29
    //   6403: lload 11
    //   6405: lstore 9
    //   6407: goto -1547 -> 4860
    //   6410: astore 28
    //   6412: iload_2
    //   6413: istore 6
    //   6415: aload 31
    //   6417: astore 30
    //   6419: goto -3001 -> 3418
    //   6422: astore 29
    //   6424: aload 28
    //   6426: astore 30
    //   6428: iload_2
    //   6429: istore 6
    //   6431: aload 29
    //   6433: astore 28
    //   6435: aload 27
    //   6437: astore 29
    //   6439: aload 30
    //   6441: astore 27
    //   6443: aload 31
    //   6445: astore 30
    //   6447: goto -3029 -> 3418
    //   6450: astore 29
    //   6452: aload 28
    //   6454: astore 31
    //   6456: iload_2
    //   6457: istore 6
    //   6459: aload 29
    //   6461: astore 28
    //   6463: aload 27
    //   6465: astore 29
    //   6467: aload 31
    //   6469: astore 27
    //   6471: goto -3053 -> 3418
    //   6474: astore 29
    //   6476: lload 19
    //   6478: lstore 9
    //   6480: aload 28
    //   6482: astore 31
    //   6484: iload 7
    //   6486: istore 6
    //   6488: aload 29
    //   6490: astore 28
    //   6492: aload 27
    //   6494: astore 29
    //   6496: aload 31
    //   6498: astore 27
    //   6500: goto -3082 -> 3418
    //   6503: astore 29
    //   6505: aload 28
    //   6507: astore 31
    //   6509: lload 11
    //   6511: lstore 9
    //   6513: iload_2
    //   6514: istore 6
    //   6516: aload 29
    //   6518: astore 28
    //   6520: aload 27
    //   6522: astore 29
    //   6524: aload 31
    //   6526: astore 27
    //   6528: goto -3110 -> 3418
    //   6531: lload 13
    //   6533: lstore 9
    //   6535: lload 15
    //   6537: lstore 13
    //   6539: goto -2186 -> 4353
    //   6542: aconst_null
    //   6543: astore 27
    //   6545: aconst_null
    //   6546: astore 30
    //   6548: goto -2173 -> 4375
    //   6551: lload 11
    //   6553: lstore 9
    //   6555: goto -5648 -> 907
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6558	0	this	l
    //   0	6558	1	paramBoolean1	boolean
    //   0	6558	2	paramBoolean2	boolean
    //   54	6289	3	i1	int
    //   3605	621	4	i2	int
    //   502	5731	5	bool1	boolean
    //   2203	4312	6	bool2	boolean
    //   3184	3301	7	bool3	boolean
    //   71	5143	8	bool4	boolean
    //   749	5805	9	l1	long
    //   477	6075	11	l2	long
    //   764	5774	13	l3	long
    //   757	5779	15	l4	long
    //   2650	3745	17	l5	long
    //   3188	3289	19	l6	long
    //   3170	1198	21	l7	long
    //   745	3389	23	l8	long
    //   454	3476	25	l9	long
    //   145	1941	27	localObject1	Object
    //   2199	254	27	localThrowable1	Throwable
    //   2476	41	27	localObject2	Object
    //   3056	1834	27	localObject3	Object
    //   4925	1	27	localThrowable2	Throwable
    //   4973	1350	27	str	String
    //   6346	1	27	localObject4	Object
    //   6354	190	27	localObject5	Object
    //   3087	3271	28	localObject6	Object
    //   6410	15	28	localIOException1	IOException
    //   6433	86	28	localIOException2	IOException
    //   3059	1864	29	localObject7	Object
    //   6351	1	29	localObject8	Object
    //   6365	1	29	localObject9	Object
    //   6376	1	29	localObject10	Object
    //   6384	1	29	localObject11	Object
    //   6389	1	29	localObject12	Object
    //   6401	1	29	localObject13	Object
    //   6422	10	29	localIOException3	IOException
    //   6437	1	29	localObject14	Object
    //   6450	10	29	localIOException4	IOException
    //   6465	1	29	localObject15	Object
    //   6474	15	29	localIOException5	IOException
    //   6494	1	29	localObject16	Object
    //   6503	14	29	localIOException6	IOException
    //   6522	1	29	localObject17	Object
    //   3159	3388	30	localObject18	Object
    //   3053	355	31	localObject19	Object
    //   4843	1601	31	localObject20	Object
    //   6454	71	31	localObject21	Object
    //   3401	11	32	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   766	795	2199	java/lang/Throwable
    //   806	814	2199	java/lang/Throwable
    //   825	849	2199	java/lang/Throwable
    //   860	883	2199	java/lang/Throwable
    //   894	904	2199	java/lang/Throwable
    //   1049	1075	2199	java/lang/Throwable
    //   1094	1103	2199	java/lang/Throwable
    //   1114	1122	2199	java/lang/Throwable
    //   1133	1146	2199	java/lang/Throwable
    //   1204	1209	2199	java/lang/Throwable
    //   1220	1227	2199	java/lang/Throwable
    //   1238	1244	2199	java/lang/Throwable
    //   1255	1295	2199	java/lang/Throwable
    //   1306	1318	2199	java/lang/Throwable
    //   1329	1338	2199	java/lang/Throwable
    //   1349	1355	2199	java/lang/Throwable
    //   1366	1372	2199	java/lang/Throwable
    //   1386	1393	2199	java/lang/Throwable
    //   1404	1410	2199	java/lang/Throwable
    //   1421	1447	2199	java/lang/Throwable
    //   1458	1467	2199	java/lang/Throwable
    //   1478	1505	2199	java/lang/Throwable
    //   1516	1553	2199	java/lang/Throwable
    //   1564	1570	2199	java/lang/Throwable
    //   1590	1596	2199	java/lang/Throwable
    //   1607	1615	2199	java/lang/Throwable
    //   1626	1635	2199	java/lang/Throwable
    //   1646	1653	2199	java/lang/Throwable
    //   1664	1672	2199	java/lang/Throwable
    //   1683	1689	2199	java/lang/Throwable
    //   1700	1705	2199	java/lang/Throwable
    //   1716	1724	2199	java/lang/Throwable
    //   1735	1749	2199	java/lang/Throwable
    //   1760	1768	2199	java/lang/Throwable
    //   1779	1804	2199	java/lang/Throwable
    //   1815	1823	2199	java/lang/Throwable
    //   1838	1848	2199	java/lang/Throwable
    //   1859	1870	2199	java/lang/Throwable
    //   1881	1891	2199	java/lang/Throwable
    //   1902	1908	2199	java/lang/Throwable
    //   1919	1923	2199	java/lang/Throwable
    //   1934	1940	2199	java/lang/Throwable
    //   1951	1961	2199	java/lang/Throwable
    //   1972	1981	2199	java/lang/Throwable
    //   1992	1999	2199	java/lang/Throwable
    //   2010	2023	2199	java/lang/Throwable
    //   2081	2087	2199	java/lang/Throwable
    //   2101	2141	2199	java/lang/Throwable
    //   2152	2196	2199	java/lang/Throwable
    //   2390	2398	2199	java/lang/Throwable
    //   2409	2421	2199	java/lang/Throwable
    //   2432	2440	2199	java/lang/Throwable
    //   2451	2457	2199	java/lang/Throwable
    //   2468	2473	2199	java/lang/Throwable
    //   2544	2559	2199	java/lang/Throwable
    //   2570	2598	2199	java/lang/Throwable
    //   2609	2620	2199	java/lang/Throwable
    //   2631	2652	2199	java/lang/Throwable
    //   2670	2680	2199	java/lang/Throwable
    //   2691	2731	2199	java/lang/Throwable
    //   2746	2753	2199	java/lang/Throwable
    //   2764	2770	2199	java/lang/Throwable
    //   2781	2791	2199	java/lang/Throwable
    //   2802	2809	2199	java/lang/Throwable
    //   2820	2827	2199	java/lang/Throwable
    //   2892	2933	2199	java/lang/Throwable
    //   2944	2957	2199	java/lang/Throwable
    //   3015	3025	2199	java/lang/Throwable
    //   3036	3049	2199	java/lang/Throwable
    //   3072	3080	2199	java/lang/Throwable
    //   3266	3272	2199	java/lang/Throwable
    //   3284	3290	2199	java/lang/Throwable
    //   3302	3308	2199	java/lang/Throwable
    //   3476	3482	2199	java/lang/Throwable
    //   3494	3500	2199	java/lang/Throwable
    //   3512	3518	2199	java/lang/Throwable
    //   4602	4608	2199	java/lang/Throwable
    //   4620	4626	2199	java/lang/Throwable
    //   4638	4644	2199	java/lang/Throwable
    //   4730	4736	2199	java/lang/Throwable
    //   4748	4754	2199	java/lang/Throwable
    //   4766	4772	2199	java/lang/Throwable
    //   4963	4975	2199	java/lang/Throwable
    //   4986	4994	2199	java/lang/Throwable
    //   5005	5011	2199	java/lang/Throwable
    //   5022	5032	2199	java/lang/Throwable
    //   5092	5100	2199	java/lang/Throwable
    //   5111	5124	2199	java/lang/Throwable
    //   5182	5193	2199	java/lang/Throwable
    //   5211	5221	2199	java/lang/Throwable
    //   5234	5247	2199	java/lang/Throwable
    //   5305	5311	2199	java/lang/Throwable
    //   5322	5335	2199	java/lang/Throwable
    //   5407	5418	2199	java/lang/Throwable
    //   5429	5442	2199	java/lang/Throwable
    //   5556	5567	2199	java/lang/Throwable
    //   5585	5602	2199	java/lang/Throwable
    //   5613	5620	2199	java/lang/Throwable
    //   5631	5644	2199	java/lang/Throwable
    //   5751	5762	2199	java/lang/Throwable
    //   5801	5806	2199	java/lang/Throwable
    //   5817	5824	2199	java/lang/Throwable
    //   5835	5848	2199	java/lang/Throwable
    //   5955	5964	2199	java/lang/Throwable
    //   5975	5982	2199	java/lang/Throwable
    //   6000	6005	2199	java/lang/Throwable
    //   6065	6078	2199	java/lang/Throwable
    //   766	795	2476	finally
    //   806	814	2476	finally
    //   825	849	2476	finally
    //   860	883	2476	finally
    //   894	904	2476	finally
    //   1049	1075	2476	finally
    //   1094	1103	2476	finally
    //   1114	1122	2476	finally
    //   1133	1146	2476	finally
    //   1204	1209	2476	finally
    //   1220	1227	2476	finally
    //   1238	1244	2476	finally
    //   1255	1295	2476	finally
    //   1306	1318	2476	finally
    //   1329	1338	2476	finally
    //   1349	1355	2476	finally
    //   1366	1372	2476	finally
    //   1386	1393	2476	finally
    //   1404	1410	2476	finally
    //   1421	1447	2476	finally
    //   1458	1467	2476	finally
    //   1478	1505	2476	finally
    //   1516	1553	2476	finally
    //   1564	1570	2476	finally
    //   1590	1596	2476	finally
    //   1607	1615	2476	finally
    //   1626	1635	2476	finally
    //   1646	1653	2476	finally
    //   1664	1672	2476	finally
    //   1683	1689	2476	finally
    //   1700	1705	2476	finally
    //   1716	1724	2476	finally
    //   1735	1749	2476	finally
    //   1760	1768	2476	finally
    //   1779	1804	2476	finally
    //   1815	1823	2476	finally
    //   1838	1848	2476	finally
    //   1859	1870	2476	finally
    //   1881	1891	2476	finally
    //   1902	1908	2476	finally
    //   1919	1923	2476	finally
    //   1934	1940	2476	finally
    //   1951	1961	2476	finally
    //   1972	1981	2476	finally
    //   1992	1999	2476	finally
    //   2010	2023	2476	finally
    //   2081	2087	2476	finally
    //   2101	2141	2476	finally
    //   2152	2196	2476	finally
    //   2209	2217	2476	finally
    //   2225	2232	2476	finally
    //   2236	2244	2476	finally
    //   2248	2290	2476	finally
    //   2294	2302	2476	finally
    //   2306	2319	2476	finally
    //   2390	2398	2476	finally
    //   2409	2421	2476	finally
    //   2432	2440	2476	finally
    //   2451	2457	2476	finally
    //   2468	2473	2476	finally
    //   2544	2559	2476	finally
    //   2570	2598	2476	finally
    //   2609	2620	2476	finally
    //   2631	2652	2476	finally
    //   2670	2680	2476	finally
    //   2691	2731	2476	finally
    //   2746	2753	2476	finally
    //   2764	2770	2476	finally
    //   2781	2791	2476	finally
    //   2802	2809	2476	finally
    //   2820	2827	2476	finally
    //   2892	2933	2476	finally
    //   2944	2957	2476	finally
    //   3015	3025	2476	finally
    //   3036	3049	2476	finally
    //   3072	3080	2476	finally
    //   3266	3272	2476	finally
    //   3284	3290	2476	finally
    //   3302	3308	2476	finally
    //   3476	3482	2476	finally
    //   3494	3500	2476	finally
    //   3512	3518	2476	finally
    //   4602	4608	2476	finally
    //   4620	4626	2476	finally
    //   4638	4644	2476	finally
    //   4730	4736	2476	finally
    //   4748	4754	2476	finally
    //   4766	4772	2476	finally
    //   4963	4975	2476	finally
    //   4986	4994	2476	finally
    //   5005	5011	2476	finally
    //   5022	5032	2476	finally
    //   5092	5100	2476	finally
    //   5111	5124	2476	finally
    //   5182	5193	2476	finally
    //   5211	5221	2476	finally
    //   5234	5247	2476	finally
    //   5305	5311	2476	finally
    //   5322	5335	2476	finally
    //   5407	5418	2476	finally
    //   5429	5442	2476	finally
    //   5556	5567	2476	finally
    //   5585	5602	2476	finally
    //   5613	5620	2476	finally
    //   5631	5644	2476	finally
    //   5751	5762	2476	finally
    //   5801	5806	2476	finally
    //   5817	5824	2476	finally
    //   5835	5848	2476	finally
    //   5955	5964	2476	finally
    //   5975	5982	2476	finally
    //   6000	6005	2476	finally
    //   6065	6078	2476	finally
    //   6129	6134	2476	finally
    //   6138	6143	2476	finally
    //   6147	6160	2476	finally
    //   6164	6171	2476	finally
    //   6175	6188	2476	finally
    //   3094	3103	3401	java/io/IOException
    //   3108	3130	3401	java/io/IOException
    //   3368	3398	3401	java/io/IOException
    //   3418	3439	4843	finally
    //   3439	3464	4843	finally
    //   4519	4590	4843	finally
    //   4693	4718	4843	finally
    //   4827	4840	4843	finally
    //   918	928	4925	java/lang/Throwable
    //   939	948	4925	java/lang/Throwable
    //   959	967	4925	java/lang/Throwable
    //   978	991	4925	java/lang/Throwable
    //   4386	4392	4925	java/lang/Throwable
    //   4403	4409	4925	java/lang/Throwable
    //   4420	4426	4925	java/lang/Throwable
    //   4437	4444	4925	java/lang/Throwable
    //   4455	4468	4925	java/lang/Throwable
    //   4871	4877	4925	java/lang/Throwable
    //   4888	4894	4925	java/lang/Throwable
    //   4905	4911	4925	java/lang/Throwable
    //   4922	4925	4925	java/lang/Throwable
    //   918	928	6346	finally
    //   939	948	6346	finally
    //   959	967	6346	finally
    //   978	991	6346	finally
    //   4386	4392	6346	finally
    //   4403	4409	6346	finally
    //   4420	4426	6346	finally
    //   4437	4444	6346	finally
    //   4455	4468	6346	finally
    //   4871	4877	6346	finally
    //   4888	4894	6346	finally
    //   4905	4911	6346	finally
    //   4922	4925	6346	finally
    //   3080	3089	6351	finally
    //   3094	3103	6365	finally
    //   3108	3130	6365	finally
    //   3368	3398	6365	finally
    //   3130	3161	6376	finally
    //   3161	3166	6384	finally
    //   3190	3197	6389	finally
    //   3211	3220	6389	finally
    //   3234	3247	6389	finally
    //   3594	3607	6389	finally
    //   3626	3633	6389	finally
    //   3647	3657	6389	finally
    //   3675	3683	6389	finally
    //   3705	3710	6389	finally
    //   3730	3735	6389	finally
    //   3752	3759	6389	finally
    //   3778	3791	6389	finally
    //   3812	3822	6389	finally
    //   3836	3841	6389	finally
    //   3879	3888	6389	finally
    //   3902	3941	6389	finally
    //   3955	3968	6389	finally
    //   3992	4002	6389	finally
    //   4016	4025	6389	finally
    //   4039	4087	6389	finally
    //   4101	4114	6389	finally
    //   4125	4140	6401	finally
    //   4160	4232	6401	finally
    //   4256	4287	6401	finally
    //   4287	4313	6401	finally
    //   4313	4335	6401	finally
    //   3080	3089	6410	java/io/IOException
    //   3130	3161	6422	java/io/IOException
    //   3161	3166	6450	java/io/IOException
    //   3190	3197	6474	java/io/IOException
    //   3211	3220	6474	java/io/IOException
    //   3234	3247	6474	java/io/IOException
    //   3594	3607	6474	java/io/IOException
    //   3626	3633	6474	java/io/IOException
    //   3647	3657	6474	java/io/IOException
    //   3675	3683	6474	java/io/IOException
    //   3705	3710	6474	java/io/IOException
    //   3730	3735	6474	java/io/IOException
    //   3752	3759	6474	java/io/IOException
    //   3778	3791	6474	java/io/IOException
    //   3812	3822	6474	java/io/IOException
    //   3836	3841	6474	java/io/IOException
    //   3879	3888	6474	java/io/IOException
    //   3902	3941	6474	java/io/IOException
    //   3955	3968	6474	java/io/IOException
    //   3992	4002	6474	java/io/IOException
    //   4016	4025	6474	java/io/IOException
    //   4039	4087	6474	java/io/IOException
    //   4101	4114	6474	java/io/IOException
    //   4125	4140	6503	java/io/IOException
    //   4160	4232	6503	java/io/IOException
    //   4256	4287	6503	java/io/IOException
    //   4287	4313	6503	java/io/IOException
    //   4313	4335	6503	java/io/IOException
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!o()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.h)))) {}
    while ((this.b == null) || (this.c < 0) || (this.c >= this.b.length)) {
      return false;
    }
    String[] arrayOfString = this.b;
    int i1 = this.c;
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
  
  public int c(boolean paramBoolean)
  {
    File localFile = a(this.h);
    if (paramBoolean) {
      if (localFile != null) {}
    }
    while (localFile == null)
    {
      return 0;
      return a.a(this.h, new File(localFile, TbsDownloader.getBackupFileName(true)));
    }
    Context localContext = this.h;
    if (TbsDownloader.getOverSea(this.h)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false)) {
      return a.a(localContext, new File(localFile, str));
    }
  }
  
  public void c()
  {
    b();
    e(false);
    e(true);
  }
  
  public boolean d()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.D);
    return this.D;
  }
  
  void e()
  {
    TbsLog.i("TbsDownload", "pauseDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
    if ((!this.d) && (TbsDownloader.isDownloading()))
    {
      b();
      this.d = true;
      this.z = false;
    }
  }
  
  void f()
  {
    TbsLog.i("TbsDownload", "resumeDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
    if ((this.d) && (TbsDownloader.isDownloading()))
    {
      this.d = false;
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */