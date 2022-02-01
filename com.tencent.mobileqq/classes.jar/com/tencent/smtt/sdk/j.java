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
import com.tencent.smtt.utils.o;
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

class j
{
  private static int d = 5;
  private static int e = 1;
  private static final String[] f = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private Set<String> A;
  private int B = d;
  private boolean C;
  String a;
  String[] b = null;
  int c = 0;
  private Context g;
  private String h;
  private String i;
  private String j;
  private File k;
  private long l;
  private int m = 30000;
  private int n = 20000;
  private boolean o;
  private int p;
  private int q;
  private boolean r;
  private boolean s;
  private HttpURLConnection t;
  private String u;
  private TbsLogReport.TbsLogInfo v;
  private String w;
  private int x;
  private boolean y;
  private Handler z;
  
  public j(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    this.v = TbsLogReport.getInstance(this.g).tbsLogInfo();
    this.A = new HashSet();
    this.u = ("tbs_downloading_" + this.g.getPackageName());
    n.a();
    this.k = n.s(this.g);
    if (this.k == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    e();
    this.w = null;
    this.x = -1;
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.v.setDownConsumeTime(l1 - paramLong1);
    this.v.setDownloadSize(paramLong2);
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
    if ((paramBoolean) || (this.p > this.B))
    {
      this.v.setErrorCode(paramInt);
      this.v.setFailDetail(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.p += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = l();
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
    if (this.t != null) {}
    try
    {
      this.t.disconnect();
      this.t = ((HttpURLConnection)paramString.openConnection());
      this.t.setRequestProperty("User-Agent", TbsDownloader.b(this.g));
      this.t.setRequestProperty("Accept-Encoding", "identity");
      this.t.setRequestMethod("GET");
      this.t.setInstanceFollowRedirects(false);
      this.t.setConnectTimeout(this.n);
      this.t.setReadTimeout(this.m);
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
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    return a.a(this.g, paramFile, 0L, i1);
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
      File localFile1 = new File(this.k, "x5.tbs");
      File localFile2 = a(this.g);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.g)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          FileUtil.b((File)localObject, localFile1);
          if (a.a(this.g, localFile1, 0L, paramInt)) {
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
        n.a();
        Object localObject1 = n.s(paramContext);
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
  
  private void c(boolean paramBoolean)
  {
    o.a(this.g);
    Object localObject1 = TbsDownloadConfig.getInstance(this.g);
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
      paramBoolean = TbsDownloader.a(this.g);
      if (i1 != 5) {
        break label149;
      }
      localObject1 = a(i1, paramBoolean);
      if (localObject1 != null) {
        break;
      }
      return;
    }
    n.a().b(this.g, (Bundle)localObject1);
    return;
    label149:
    if ((i1 == 3) || (i1 > 10000))
    {
      localObject2 = a(this.g);
      if (localObject2 != null)
      {
        localObject1 = a(i1, (File)localObject2, paramBoolean);
        n.a().b(this.g, (Bundle)localObject1);
        return;
      }
      c();
      ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
      ((TbsDownloadConfig)localObject1).commit();
      return;
    }
    i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
    n.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
    a(new File(this.k, "x5.tbs"), this.g);
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    Object localObject2 = this.k;
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
      localObject2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getString("tbs_apk_md5", null);
      localObject3 = a.a((File)localObject1);
      if ((localObject2 != null) && (((String)localObject2).equals(localObject3))) {
        break label164;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
    } while (!paramBoolean1);
    this.v.setCheckErrorDetail("fileMd5 not match");
    return false;
    label164:
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = l2;
    long l3;
    if (paramBoolean1)
    {
      l3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
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
      this.v.setCheckErrorDetail("fileLength:" + l1 + ",contentLength:" + l3);
      return false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l1 + ") successful!");
      int i2 = -1;
      int i1 = i2;
      if (paramBoolean2)
      {
        i1 = i2;
        if (!paramBoolean1)
        {
          i2 = a.a(this.g, (File)localObject1);
          int i3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
          i1 = i2;
          if (i3 != i2)
          {
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
            if (!paramBoolean1) {
              break;
            }
            this.v.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i3);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i1 + ") successful!");
      if ((paramBoolean2) && (!paramBoolean1))
      {
        String str = b.a(this.g, false, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
          if (!paramBoolean1) {
            break;
          }
          localObject2 = this.v;
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
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.k, "x5.tbs"));
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
  
  private boolean d(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.k, "x5.tbs");; localFile = new File(this.k, "x5.tbs.temp"))
    {
      if ((localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      return true;
    }
  }
  
  private void e()
  {
    this.p = 0;
    this.q = 0;
    this.l = -1L;
    this.j = null;
    this.o = false;
    this.r = false;
    this.s = false;
    this.y = false;
  }
  
  private void f()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.t != null) {
      if (!this.r) {
        this.v.setResolveIp(a(this.t.getURL()));
      }
    }
    try
    {
      this.t.disconnect();
      this.t = null;
      int i1 = this.v.a;
      if ((!this.r) && (this.y))
      {
        this.v.setEventTime(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.g);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int i2 = Apn.getApnType(this.g);
        this.v.setApn(str1);
        this.v.setNetworkType(i2);
        if ((i2 != this.x) || (!str1.equals(this.w))) {
          this.v.setNetworkChange(0);
        }
        if (((this.v.a == 0) || (this.v.a == 107)) && (this.v.getDownFinalFlag() == 0))
        {
          if (!Apn.isNetworkAvailable(this.g)) {
            a(101, null, true);
          }
        }
        else
        {
          if (!TbsDownloader.a(this.g)) {
            break label305;
          }
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
          this.v.resetArgs();
          if (i1 != 100) {
            QbSdk.m.onDownloadFinish(i1);
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
        continue;
        if (!k())
        {
          a(101, null, true);
          continue;
          label305:
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
        }
      }
      TbsDownloader.a = false;
    }
  }
  
  private File g()
  {
    String str = FileUtil.a(this.g, 4);
    if (TbsDownloader.getOverSea(this.g)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
    {
      localObject = new File(str, (String)localObject);
      if (!TbsDownloader.a(this.g)) {
        break;
      }
      return new File(FileUtil.a(this.g, 4), TbsDownloader.getBackupFileName(true));
    }
    return localObject;
  }
  
  private void h()
  {
    try
    {
      Object localObject = g();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        FileUtil.b((File)localObject);
        localObject = ((File)localObject).getParentFile().listFiles();
        Pattern localPattern = Pattern.compile(a.a(TbsDownloader.a(this.g)) + "(.*)");
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
  
  private boolean i()
  {
    boolean bool2 = false;
    File localFile = new File(this.k, "x5.tbs.temp");
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
  
  private long j()
  {
    long l2 = 0L;
    File localFile = new File(this.k, "x5.tbs.temp");
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
  private boolean k()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: invokestatic 683	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: astore 5
    //   14: aload 5
    //   16: new 107	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 685
    //   26: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 687
    //   32: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 691	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 697	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore 5
    //   46: new 699	java/io/InputStreamReader
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 702	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 7
    //   57: new 704	java/io/BufferedReader
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 707	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore 6
    //   68: iconst_0
    //   69: istore_1
    //   70: aload 6
    //   72: invokevirtual 710	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: iload 4
    //   79: istore_3
    //   80: aload 8
    //   82: ifnull +29 -> 111
    //   85: aload 8
    //   87: ldc_w 712
    //   90: invokevirtual 318	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifne +16 -> 109
    //   96: aload 8
    //   98: ldc_w 714
    //   101: invokevirtual 318	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +25 -> 131
    //   109: iconst_1
    //   110: istore_3
    //   111: aload_0
    //   112: aload 5
    //   114: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   117: aload_0
    //   118: aload 7
    //   120: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   123: aload_0
    //   124: aload 6
    //   126: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
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
    //   162: invokevirtual 717	java/lang/Throwable:printStackTrace	()V
    //   165: aload_0
    //   166: aload 6
    //   168: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: aload 8
    //   174: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   177: aload_0
    //   178: aload 5
    //   180: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 6
    //   187: aconst_null
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_0
    //   194: aload 5
    //   196: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 7
    //   202: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 8
    //   208: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
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
    //   0	334	0	this	j
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
  
  private long l()
  {
    switch (this.p)
    {
    default: 
      return 20000L * 10L;
    case 1: 
    case 2: 
      return 20000L * this.p;
    }
    return 20000L * 5L;
  }
  
  /* Error */
  private boolean m()
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
    //   13: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   16: invokestatic 632	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   19: iconst_3
    //   20: if_icmpne +276 -> 296
    //   23: iconst_1
    //   24: istore_3
    //   25: ldc 195
    //   27: new 107	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 725
    //   37: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_3
    //   41: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iload 5
    //   52: istore_2
    //   53: iload_3
    //   54: ifeq +141 -> 195
    //   57: aload_0
    //   58: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   61: invokestatic 728	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   64: astore 6
    //   66: ldc 195
    //   68: new 107	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 730
    //   78: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 6
    //   83: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 241	java/net/URL
    //   95: dup
    //   96: ldc_w 732
    //   99: invokespecial 376	java/net/URL:<init>	(Ljava/lang/String;)V
    //   102: invokevirtual 387	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   105: checkcast 380	java/net/HttpURLConnection
    //   108: astore 7
    //   110: aload 7
    //   112: iconst_0
    //   113: invokevirtual 408	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   116: aload 7
    //   118: sipush 10000
    //   121: invokevirtual 411	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   124: aload 7
    //   126: sipush 10000
    //   129: invokevirtual 414	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   132: aload 7
    //   134: iconst_0
    //   135: invokevirtual 735	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   138: aload 7
    //   140: invokevirtual 736	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   143: pop
    //   144: aload 7
    //   146: invokevirtual 739	java/net/HttpURLConnection:getResponseCode	()I
    //   149: istore_1
    //   150: ldc 195
    //   152: new 107	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 741
    //   162: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload_1
    //   166: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iload_1
    //   176: sipush 204
    //   179: if_icmpne +122 -> 301
    //   182: iload 4
    //   184: istore_2
    //   185: aload 7
    //   187: ifnull +203 -> 390
    //   190: aload 7
    //   192: invokevirtual 383	java/net/HttpURLConnection:disconnect	()V
    //   195: iload_2
    //   196: ifne +68 -> 264
    //   199: aload 6
    //   201: invokestatic 746	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +60 -> 264
    //   207: aload_0
    //   208: getfield 105	com/tencent/smtt/sdk/j:A	Ljava/util/Set;
    //   211: aload 6
    //   213: invokeinterface 750 2 0
    //   218: ifne +46 -> 264
    //   221: aload_0
    //   222: getfield 105	com/tencent/smtt/sdk/j:A	Ljava/util/Set;
    //   225: aload 6
    //   227: invokeinterface 753 2 0
    //   232: pop
    //   233: aload_0
    //   234: invokespecial 755	com/tencent/smtt/sdk/j:n	()V
    //   237: aload_0
    //   238: getfield 757	com/tencent/smtt/sdk/j:z	Landroid/os/Handler;
    //   241: sipush 150
    //   244: aload 6
    //   246: invokevirtual 763	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   249: astore 7
    //   251: aload_0
    //   252: getfield 757	com/tencent/smtt/sdk/j:z	Landroid/os/Handler;
    //   255: aload 7
    //   257: ldc2_w 764
    //   260: invokevirtual 769	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   263: pop
    //   264: iload_2
    //   265: ifeq +29 -> 294
    //   268: aload_0
    //   269: getfield 105	com/tencent/smtt/sdk/j:A	Ljava/util/Set;
    //   272: aload 6
    //   274: invokeinterface 750 2 0
    //   279: ifeq +15 -> 294
    //   282: aload_0
    //   283: getfield 105	com/tencent/smtt/sdk/j:A	Ljava/util/Set;
    //   286: aload 6
    //   288: invokeinterface 772 2 0
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
    //   318: invokevirtual 717	java/lang/Throwable:printStackTrace	()V
    //   321: aload 7
    //   323: ifnull +61 -> 384
    //   326: aload 7
    //   328: invokevirtual 383	java/net/HttpURLConnection:disconnect	()V
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
    //   358: invokevirtual 383	java/net/HttpURLConnection:disconnect	()V
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
    //   0	393	0	this	j
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
  
  private void n()
  {
    if (this.z == null) {
      this.z = new j.1(this, l.a().getLooper());
    }
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      paramFile = new File(paramFile, TbsDownloader.getBackupFileName(true));
      i1 = a.a(this.g, paramFile);
      localObject = new File(this.k, "x5.tbs");
      if (!((File)localObject).exists()) {
        break label189;
      }
    }
    label189:
    for (Object localObject = ((File)localObject).getAbsolutePath();; localObject = null)
    {
      int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", paramFile.getAbsolutePath());
      localBundle.putString("new_apk_location", (String)localObject);
      localBundle.putString("diff_file_location", (String)localObject);
      return localBundle;
      if (TbsDownloader.getOverSea(this.g)) {}
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
      localObject1 = n.a().p(this.g);
      i1 = n.a().h(this.g);
      localObject2 = new File(this.k, "x5.tbs");
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
      localObject1 = n.a().q(this.g);
      i1 = n.a().i(this.g);
      break;
    }
    label97:
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    if (paramBoolean) {}
    for (File localFile = n.a().f(this.g, 6);; localFile = n.a().f(this.g, 5))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", ((File)localObject1).getAbsolutePath());
      localBundle.putString("new_apk_location", localFile.getAbsolutePath());
      localBundle.putString("diff_file_location", (String)localObject2);
      localObject1 = FileUtil.a(this.g, 7);
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
    if (n.a().t(this.g)) {
      n.a().b();
    }
    try
    {
      File localFile = new File(this.k, "x5.tbs");
      int i1 = a.a(this.g, localFile);
      if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
        FileUtil.b(localFile);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean a()
  {
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    try
    {
      File localFile1 = new File(FileUtil.a(this.g, 4), TbsDownloader.getBackupFileName(true));
      if ((localFile1 != null) && (localFile1.exists())) {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      while (a.a(this.g, localFile1, 0L, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        return n.a().e(this.g);
        File localFile2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          FileUtil.b(localFile2, localFile1);
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!m()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g)))) {}
    while ((this.b == null) || (this.c < 0) || (this.c >= this.b.length)) {
      return false;
    }
    String[] arrayOfString = this.b;
    int i1 = this.c;
    this.c = (i1 + 1);
    this.j = arrayOfString[i1];
    this.p = 0;
    this.q = 0;
    this.l = -1L;
    this.o = false;
    this.r = false;
    this.s = false;
    this.y = false;
    return true;
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
      int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
      int i2 = n.a().i(this.g);
      File localFile;
      Object localObject;
      if (i1 == 0)
      {
        i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
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
        String str = FileUtil.a(this.g, 4);
        if (!TbsDownloader.getOverSea(this.g)) {
          break label337;
        }
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
      }
      for (;;)
      {
        try
        {
          if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            break label353;
          }
          FileUtil.b(localFile, (File)localObject);
          i2 = 1;
          localObject = g();
          if ((localObject == null) || (!((File)localObject).exists()) || (!a((File)localObject))) {
            break label379;
          }
          if (!b(i1)) {
            break label428;
          }
          TbsDownloadConfig.getInstance(this.g).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
          c(false);
          if (i2 != 0)
          {
            a(100, "use local backup apk in startDownload" + this.a, true);
            if (!TbsDownloader.a(this.g)) {
              break label359;
            }
            TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
            this.v.resetArgs();
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
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
      }
      h();
      if ((localFile != null) && (localFile.exists()) && (!a.a(this.g, localFile, 0L, i1)) && (localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      if (c(false, paramBoolean2))
      {
        TbsDownloadConfig.getInstance(this.g).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
        c(false);
        return true;
      }
    } while ((d(true)) || (d(true)));
    label130:
    label428:
    TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
    return false;
  }
  
  public int b(boolean paramBoolean)
  {
    File localFile = a(this.g);
    if (paramBoolean) {
      if (localFile != null) {}
    }
    while (localFile == null)
    {
      return 0;
      return a.a(this.g, new File(localFile, TbsDownloader.getBackupFileName(true)));
    }
    Context localContext = this.g;
    if (TbsDownloader.getOverSea(this.g)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false)) {
      return a.a(localContext, new File(localFile, str));
    }
  }
  
  public void b()
  {
    this.r = true;
    TbsLogReport.TbsLogInfo localTbsLogInfo;
    if (TbsShareManager.isThirdPartyApp(this.g))
    {
      localTbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.g)) {
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
      }
    }
    else
    {
      return;
    }
    TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 128	com/tencent/smtt/sdk/n:a	()Lcom/tencent/smtt/sdk/n;
    //   3: aload_0
    //   4: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   7: invokevirtual 880	com/tencent/smtt/sdk/n:c	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 669	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   25: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush -322
    //   31: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   39: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 365
    //   48: iconst_0
    //   49: invokeinterface 303 3 0
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
    //   81: invokevirtual 882	com/tencent/smtt/sdk/j:a	(ZZ)Z
    //   84: ifeq +14 -> 98
    //   87: iconst_0
    //   88: putstatic 669	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   91: return
    //   92: iconst_0
    //   93: istore 8
    //   95: goto -22 -> 73
    //   98: aload_0
    //   99: iload_1
    //   100: putfield 884	com/tencent/smtt/sdk/j:C	Z
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   108: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   114: ldc_w 886
    //   117: aconst_null
    //   118: invokeinterface 513 3 0
    //   123: putfield 888	com/tencent/smtt/sdk/j:h	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   130: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   136: ldc_w 890
    //   139: aconst_null
    //   140: invokeinterface 513 3 0
    //   145: astore 27
    //   147: ldc 195
    //   149: new 107	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 892
    //   159: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 27
    //   164: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: iconst_1
    //   171: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 78	com/tencent/smtt/sdk/j:b	[Ljava/lang/String;
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 80	com/tencent/smtt/sdk/j:c	I
    //   184: iload_1
    //   185: ifne +36 -> 221
    //   188: aload 27
    //   190: ifnull +31 -> 221
    //   193: ldc 255
    //   195: aload 27
    //   197: invokevirtual 898	java/lang/String:trim	()Ljava/lang/String;
    //   200: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   203: ifne +18 -> 221
    //   206: aload_0
    //   207: aload 27
    //   209: invokevirtual 898	java/lang/String:trim	()Ljava/lang/String;
    //   212: ldc_w 900
    //   215: invokevirtual 904	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   218: putfield 78	com/tencent/smtt/sdk/j:b	[Ljava/lang/String;
    //   221: ldc 195
    //   223: new 107	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 906
    //   233: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 888	com/tencent/smtt/sdk/j:h	Ljava/lang/String;
    //   240: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 908
    //   246: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 27
    //   251: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc_w 910
    //   257: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_0
    //   261: getfield 599	com/tencent/smtt/sdk/j:j	Ljava/lang/String;
    //   264: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 912
    //   270: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_0
    //   274: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   277: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: ldc_w 914
    //   283: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_0
    //   287: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   290: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_0
    //   300: getfield 888	com/tencent/smtt/sdk/j:h	Ljava/lang/String;
    //   303: ifnonnull +34 -> 337
    //   306: aload_0
    //   307: getfield 599	com/tencent/smtt/sdk/j:j	Ljava/lang/String;
    //   310: ifnonnull +27 -> 337
    //   313: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   316: bipush 110
    //   318: invokeinterface 481 2 0
    //   323: aload_0
    //   324: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   327: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   330: sipush -302
    //   333: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   336: return
    //   337: aload_0
    //   338: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   341: ifnull +34 -> 375
    //   344: aload_0
    //   345: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   348: ifne +27 -> 375
    //   351: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   354: bipush 110
    //   356: invokeinterface 481 2 0
    //   361: aload_0
    //   362: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   365: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   368: sipush -303
    //   371: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   374: return
    //   375: iload_1
    //   376: ifne +54 -> 430
    //   379: aload_0
    //   380: getfield 105	com/tencent/smtt/sdk/j:A	Ljava/util/Set;
    //   383: aload_0
    //   384: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   387: invokestatic 728	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   390: invokeinterface 750 2 0
    //   395: ifeq +35 -> 430
    //   398: ldc 195
    //   400: ldc_w 916
    //   403: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   409: bipush 110
    //   411: invokeinterface 481 2 0
    //   416: aload_0
    //   417: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   420: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   423: sipush -304
    //   426: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   429: return
    //   430: aload_0
    //   431: invokespecial 142	com/tencent/smtt/sdk/j:e	()V
    //   434: ldc 195
    //   436: ldc_w 918
    //   439: iconst_1
    //   440: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   443: aload_0
    //   444: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   447: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   450: invokevirtual 921	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   453: lstore 25
    //   455: iconst_0
    //   456: istore_2
    //   457: aload_0
    //   458: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   461: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   464: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   467: ldc_w 923
    //   470: lconst_0
    //   471: invokeinterface 537 4 0
    //   476: lstore 11
    //   478: iload_1
    //   479: ifeq +216 -> 695
    //   482: aload_0
    //   483: getstatic 51	com/tencent/smtt/sdk/j:e	I
    //   486: putfield 76	com/tencent/smtt/sdk/j:B	I
    //   489: aload_0
    //   490: getfield 259	com/tencent/smtt/sdk/j:p	I
    //   493: aload_0
    //   494: getfield 76	com/tencent/smtt/sdk/j:B	I
    //   497: if_icmple +208 -> 705
    //   500: iload_2
    //   501: istore 5
    //   503: aload_0
    //   504: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   507: ifne +183 -> 690
    //   510: iload 5
    //   512: istore_1
    //   513: aload_0
    //   514: getfield 605	com/tencent/smtt/sdk/j:s	Z
    //   517: ifeq +102 -> 619
    //   520: iload 5
    //   522: istore_1
    //   523: aload_0
    //   524: getfield 78	com/tencent/smtt/sdk/j:b	[Ljava/lang/String;
    //   527: ifnonnull +19 -> 546
    //   530: iload 5
    //   532: istore_1
    //   533: iload 5
    //   535: ifne +11 -> 546
    //   538: aload_0
    //   539: iconst_1
    //   540: iload 8
    //   542: invokespecial 863	com/tencent/smtt/sdk/j:c	(ZZ)Z
    //   545: istore_1
    //   546: aload_0
    //   547: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   550: astore 27
    //   552: iload_1
    //   553: ifeq +5683 -> 6236
    //   556: iconst_1
    //   557: istore_3
    //   558: aload 27
    //   560: iload_3
    //   561: invokevirtual 926	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   564: iload 8
    //   566: ifne +5680 -> 6246
    //   569: aload_0
    //   570: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   573: astore 27
    //   575: iload_1
    //   576: ifeq +5665 -> 6241
    //   579: iconst_1
    //   580: istore_3
    //   581: aload 27
    //   583: iload_3
    //   584: invokevirtual 929	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   587: iload_1
    //   588: ifeq +5669 -> 6257
    //   591: aload_0
    //   592: iconst_1
    //   593: invokespecial 855	com/tencent/smtt/sdk/j:c	(Z)V
    //   596: aload_0
    //   597: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   600: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   603: sipush -317
    //   606: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   609: aload_0
    //   610: bipush 100
    //   612: ldc_w 931
    //   615: iconst_1
    //   616: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   619: aload_0
    //   620: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   623: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   626: astore 27
    //   628: iload_1
    //   629: ifeq +5650 -> 6279
    //   632: aload 27
    //   634: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   637: ldc_w 933
    //   640: iconst_0
    //   641: invokeinterface 303 3 0
    //   646: istore_3
    //   647: aload 27
    //   649: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   652: ldc_w 933
    //   655: iload_3
    //   656: iconst_1
    //   657: iadd
    //   658: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   661: invokeinterface 459 3 0
    //   666: pop
    //   667: aload 27
    //   669: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   672: aload_0
    //   673: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   676: astore 27
    //   678: iload_1
    //   679: ifeq +5661 -> 6340
    //   682: iconst_1
    //   683: istore_3
    //   684: aload 27
    //   686: iload_3
    //   687: invokevirtual 936	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   690: aload_0
    //   691: invokespecial 938	com/tencent/smtt/sdk/j:f	()V
    //   694: return
    //   695: aload_0
    //   696: getstatic 49	com/tencent/smtt/sdk/j:d	I
    //   699: putfield 76	com/tencent/smtt/sdk/j:B	I
    //   702: goto -213 -> 489
    //   705: aload_0
    //   706: getfield 593	com/tencent/smtt/sdk/j:q	I
    //   709: bipush 8
    //   711: if_icmple +30 -> 741
    //   714: aload_0
    //   715: bipush 123
    //   717: aconst_null
    //   718: iconst_1
    //   719: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   722: aload_0
    //   723: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   726: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   729: sipush -306
    //   732: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   735: iload_2
    //   736: istore 5
    //   738: goto -235 -> 503
    //   741: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   744: lstore 23
    //   746: lload 11
    //   748: lstore 9
    //   750: iload_1
    //   751: ifne +441 -> 1192
    //   754: lload 11
    //   756: lstore 15
    //   758: iload_2
    //   759: istore 5
    //   761: lload 11
    //   763: lstore 13
    //   765: lload 23
    //   767: aload_0
    //   768: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   771: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   774: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   777: ldc_w 940
    //   780: lconst_0
    //   781: invokeinterface 537 4 0
    //   786: lsub
    //   787: ldc2_w 941
    //   790: lcmp
    //   791: ifle +246 -> 1037
    //   794: lload 11
    //   796: lstore 15
    //   798: iload_2
    //   799: istore 5
    //   801: lload 11
    //   803: lstore 13
    //   805: ldc 195
    //   807: ldc_w 944
    //   810: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: lload 11
    //   815: lstore 15
    //   817: iload_2
    //   818: istore 5
    //   820: lload 11
    //   822: lstore 13
    //   824: aload_0
    //   825: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   828: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   831: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   834: ldc_w 940
    //   837: lload 23
    //   839: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   842: invokeinterface 459 3 0
    //   847: pop
    //   848: lload 11
    //   850: lstore 15
    //   852: iload_2
    //   853: istore 5
    //   855: lload 11
    //   857: lstore 13
    //   859: aload_0
    //   860: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   863: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   866: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   869: ldc_w 923
    //   872: lconst_0
    //   873: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   876: invokeinterface 459 3 0
    //   881: pop
    //   882: lload 11
    //   884: lstore 15
    //   886: iload_2
    //   887: istore 5
    //   889: lload 11
    //   891: lstore 13
    //   893: aload_0
    //   894: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   897: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   900: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   903: lconst_0
    //   904: lstore 9
    //   906: iload_2
    //   907: istore 5
    //   909: lload 9
    //   911: lstore 11
    //   913: lload 9
    //   915: lstore 13
    //   917: aload_0
    //   918: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   921: invokestatic 951	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   924: ifne +268 -> 1192
    //   927: iload_2
    //   928: istore 5
    //   930: lload 9
    //   932: lstore 11
    //   934: lload 9
    //   936: lstore 13
    //   938: ldc 195
    //   940: ldc_w 953
    //   943: iconst_1
    //   944: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   947: iload_2
    //   948: istore 5
    //   950: lload 9
    //   952: lstore 11
    //   954: lload 9
    //   956: lstore 13
    //   958: aload_0
    //   959: bipush 105
    //   961: aconst_null
    //   962: iconst_1
    //   963: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   966: iload_2
    //   967: istore 5
    //   969: lload 9
    //   971: lstore 11
    //   973: lload 9
    //   975: lstore 13
    //   977: aload_0
    //   978: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   981: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   984: sipush -308
    //   987: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   990: iload_2
    //   991: istore 5
    //   993: iload_1
    //   994: ifne -491 -> 503
    //   997: aload_0
    //   998: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1001: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1004: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1007: ldc_w 923
    //   1010: lload 9
    //   1012: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1015: invokeinterface 459 3 0
    //   1020: pop
    //   1021: aload_0
    //   1022: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1025: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1028: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1031: iload_2
    //   1032: istore 5
    //   1034: goto -531 -> 503
    //   1037: lload 11
    //   1039: lstore 15
    //   1041: iload_2
    //   1042: istore 5
    //   1044: lload 11
    //   1046: lstore 13
    //   1048: ldc 195
    //   1050: new 107	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 955
    //   1060: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: lload 11
    //   1065: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1074: lload 11
    //   1076: lload 25
    //   1078: lcmp
    //   1079: iflt +5471 -> 6550
    //   1082: lload 11
    //   1084: lstore 15
    //   1086: iload_2
    //   1087: istore 5
    //   1089: lload 11
    //   1091: lstore 13
    //   1093: ldc 195
    //   1095: ldc_w 957
    //   1098: iconst_1
    //   1099: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1102: lload 11
    //   1104: lstore 15
    //   1106: iload_2
    //   1107: istore 5
    //   1109: lload 11
    //   1111: lstore 13
    //   1113: aload_0
    //   1114: bipush 112
    //   1116: aconst_null
    //   1117: iconst_1
    //   1118: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   1121: lload 11
    //   1123: lstore 15
    //   1125: iload_2
    //   1126: istore 5
    //   1128: lload 11
    //   1130: lstore 13
    //   1132: aload_0
    //   1133: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1136: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1139: sipush -307
    //   1142: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1145: iload_2
    //   1146: istore 5
    //   1148: iload_1
    //   1149: ifne -646 -> 503
    //   1152: aload_0
    //   1153: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1156: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1159: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1162: ldc_w 923
    //   1165: lload 11
    //   1167: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1170: invokeinterface 459 3 0
    //   1175: pop
    //   1176: aload_0
    //   1177: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1180: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1183: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1186: iload_2
    //   1187: istore 5
    //   1189: goto -686 -> 503
    //   1192: lload 9
    //   1194: lstore 15
    //   1196: iload_2
    //   1197: istore 5
    //   1199: lload 9
    //   1201: lstore 13
    //   1203: aload_0
    //   1204: iconst_1
    //   1205: putfield 607	com/tencent/smtt/sdk/j:y	Z
    //   1208: lload 9
    //   1210: lstore 15
    //   1212: iload_2
    //   1213: istore 5
    //   1215: lload 9
    //   1217: lstore 13
    //   1219: aload_0
    //   1220: getfield 599	com/tencent/smtt/sdk/j:j	Ljava/lang/String;
    //   1223: ifnull +846 -> 2069
    //   1226: lload 9
    //   1228: lstore 15
    //   1230: iload_2
    //   1231: istore 5
    //   1233: lload 9
    //   1235: lstore 13
    //   1237: aload_0
    //   1238: getfield 599	com/tencent/smtt/sdk/j:j	Ljava/lang/String;
    //   1241: astore 27
    //   1243: lload 9
    //   1245: lstore 15
    //   1247: iload_2
    //   1248: istore 5
    //   1250: lload 9
    //   1252: lstore 13
    //   1254: ldc 195
    //   1256: new 107	java/lang/StringBuilder
    //   1259: dup
    //   1260: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1263: ldc_w 959
    //   1266: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: aload 27
    //   1271: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: ldc_w 961
    //   1277: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: aload_0
    //   1281: getfield 259	com/tencent/smtt/sdk/j:p	I
    //   1284: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1287: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1290: iconst_1
    //   1291: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1294: lload 9
    //   1296: lstore 15
    //   1298: iload_2
    //   1299: istore 5
    //   1301: lload 9
    //   1303: lstore 13
    //   1305: aload 27
    //   1307: aload_0
    //   1308: getfield 963	com/tencent/smtt/sdk/j:i	Ljava/lang/String;
    //   1311: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1314: ifne +23 -> 1337
    //   1317: lload 9
    //   1319: lstore 15
    //   1321: iload_2
    //   1322: istore 5
    //   1324: lload 9
    //   1326: lstore 13
    //   1328: aload_0
    //   1329: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1332: aload 27
    //   1334: invokevirtual 966	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1337: lload 9
    //   1339: lstore 15
    //   1341: iload_2
    //   1342: istore 5
    //   1344: lload 9
    //   1346: lstore 13
    //   1348: aload_0
    //   1349: aload 27
    //   1351: putfield 963	com/tencent/smtt/sdk/j:i	Ljava/lang/String;
    //   1354: lload 9
    //   1356: lstore 15
    //   1358: iload_2
    //   1359: istore 5
    //   1361: lload 9
    //   1363: lstore 13
    //   1365: aload_0
    //   1366: aload 27
    //   1368: invokespecial 968	com/tencent/smtt/sdk/j:a	(Ljava/lang/String;)V
    //   1371: lconst_0
    //   1372: lstore 11
    //   1374: lload 9
    //   1376: lstore 15
    //   1378: iload_2
    //   1379: istore 5
    //   1381: lload 9
    //   1383: lstore 13
    //   1385: aload_0
    //   1386: getfield 601	com/tencent/smtt/sdk/j:o	Z
    //   1389: ifne +163 -> 1552
    //   1392: lload 9
    //   1394: lstore 15
    //   1396: iload_2
    //   1397: istore 5
    //   1399: lload 9
    //   1401: lstore 13
    //   1403: aload_0
    //   1404: invokespecial 970	com/tencent/smtt/sdk/j:j	()J
    //   1407: lstore 11
    //   1409: lload 9
    //   1411: lstore 15
    //   1413: iload_2
    //   1414: istore 5
    //   1416: lload 9
    //   1418: lstore 13
    //   1420: ldc 195
    //   1422: new 107	java/lang/StringBuilder
    //   1425: dup
    //   1426: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1429: ldc_w 972
    //   1432: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: lload 11
    //   1437: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1440: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1446: lload 9
    //   1448: lstore 15
    //   1450: iload_2
    //   1451: istore 5
    //   1453: lload 9
    //   1455: lstore 13
    //   1457: aload_0
    //   1458: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   1461: lconst_0
    //   1462: lcmp
    //   1463: ifgt +626 -> 2089
    //   1466: lload 9
    //   1468: lstore 15
    //   1470: iload_2
    //   1471: istore 5
    //   1473: lload 9
    //   1475: lstore 13
    //   1477: ldc 195
    //   1479: new 107	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1486: ldc_w 974
    //   1489: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: lload 11
    //   1494: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1497: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1500: iconst_1
    //   1501: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1504: lload 9
    //   1506: lstore 15
    //   1508: iload_2
    //   1509: istore 5
    //   1511: lload 9
    //   1513: lstore 13
    //   1515: aload_0
    //   1516: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   1519: ldc_w 976
    //   1522: new 107	java/lang/StringBuilder
    //   1525: dup
    //   1526: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1529: ldc_w 978
    //   1532: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: lload 11
    //   1537: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1540: ldc_w 980
    //   1543: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: invokevirtual 395	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1552: lload 9
    //   1554: lstore 15
    //   1556: iload_2
    //   1557: istore 5
    //   1559: lload 9
    //   1561: lstore 13
    //   1563: aload_0
    //   1564: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1567: astore 27
    //   1569: lload 11
    //   1571: lconst_0
    //   1572: lcmp
    //   1573: ifne +800 -> 2373
    //   1576: iconst_0
    //   1577: istore_3
    //   1578: lload 9
    //   1580: lstore 15
    //   1582: iload_2
    //   1583: istore 5
    //   1585: lload 9
    //   1587: lstore 13
    //   1589: aload 27
    //   1591: iload_3
    //   1592: invokevirtual 983	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1595: lload 9
    //   1597: lstore 15
    //   1599: iload_2
    //   1600: istore 5
    //   1602: lload 9
    //   1604: lstore 13
    //   1606: aload_0
    //   1607: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1610: invokestatic 632	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1613: istore_3
    //   1614: lload 9
    //   1616: lstore 15
    //   1618: iload_2
    //   1619: istore 5
    //   1621: lload 9
    //   1623: lstore 13
    //   1625: aload_0
    //   1626: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1629: invokestatic 628	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1632: astore 27
    //   1634: lload 9
    //   1636: lstore 15
    //   1638: iload_2
    //   1639: istore 5
    //   1641: lload 9
    //   1643: lstore 13
    //   1645: aload_0
    //   1646: getfield 144	com/tencent/smtt/sdk/j:w	Ljava/lang/String;
    //   1649: ifnonnull +729 -> 2378
    //   1652: lload 9
    //   1654: lstore 15
    //   1656: iload_2
    //   1657: istore 5
    //   1659: lload 9
    //   1661: lstore 13
    //   1663: aload_0
    //   1664: getfield 146	com/tencent/smtt/sdk/j:x	I
    //   1667: iconst_m1
    //   1668: if_icmpne +710 -> 2378
    //   1671: lload 9
    //   1673: lstore 15
    //   1675: iload_2
    //   1676: istore 5
    //   1678: lload 9
    //   1680: lstore 13
    //   1682: aload_0
    //   1683: aload 27
    //   1685: putfield 144	com/tencent/smtt/sdk/j:w	Ljava/lang/String;
    //   1688: lload 9
    //   1690: lstore 15
    //   1692: iload_2
    //   1693: istore 5
    //   1695: lload 9
    //   1697: lstore 13
    //   1699: aload_0
    //   1700: iload_3
    //   1701: putfield 146	com/tencent/smtt/sdk/j:x	I
    //   1704: lload 9
    //   1706: lstore 15
    //   1708: iload_2
    //   1709: istore 5
    //   1711: lload 9
    //   1713: lstore 13
    //   1715: aload_0
    //   1716: getfield 259	com/tencent/smtt/sdk/j:p	I
    //   1719: iconst_1
    //   1720: if_icmplt +28 -> 1748
    //   1723: lload 9
    //   1725: lstore 15
    //   1727: iload_2
    //   1728: istore 5
    //   1730: lload 9
    //   1732: lstore 13
    //   1734: aload_0
    //   1735: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   1738: ldc_w 985
    //   1741: aload_0
    //   1742: getfield 888	com/tencent/smtt/sdk/j:h	Ljava/lang/String;
    //   1745: invokevirtual 988	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1748: lload 9
    //   1750: lstore 15
    //   1752: iload_2
    //   1753: istore 5
    //   1755: lload 9
    //   1757: lstore 13
    //   1759: aload_0
    //   1760: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   1763: invokevirtual 739	java/net/HttpURLConnection:getResponseCode	()I
    //   1766: istore_3
    //   1767: lload 9
    //   1769: lstore 15
    //   1771: iload_2
    //   1772: istore 5
    //   1774: lload 9
    //   1776: lstore 13
    //   1778: ldc 195
    //   1780: new 107	java/lang/StringBuilder
    //   1783: dup
    //   1784: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1787: ldc_w 990
    //   1790: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: iload_3
    //   1794: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1797: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1803: lload 9
    //   1805: lstore 15
    //   1807: iload_2
    //   1808: istore 5
    //   1810: lload 9
    //   1812: lstore 13
    //   1814: aload_0
    //   1815: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1818: iload_3
    //   1819: invokevirtual 993	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1822: iload_1
    //   1823: ifne +157 -> 1980
    //   1826: lload 9
    //   1828: lstore 15
    //   1830: iload_2
    //   1831: istore 5
    //   1833: lload 9
    //   1835: lstore 13
    //   1837: aload_0
    //   1838: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1841: invokestatic 213	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1844: ifne +136 -> 1980
    //   1847: lload 9
    //   1849: lstore 15
    //   1851: iload_2
    //   1852: istore 5
    //   1854: lload 9
    //   1856: lstore 13
    //   1858: aload_0
    //   1859: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1862: invokestatic 632	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1865: iconst_3
    //   1866: if_icmpne +24 -> 1890
    //   1869: lload 9
    //   1871: lstore 15
    //   1873: iload_2
    //   1874: istore 5
    //   1876: lload 9
    //   1878: lstore 13
    //   1880: aload_0
    //   1881: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   1884: invokestatic 632	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1887: ifne +93 -> 1980
    //   1890: lload 9
    //   1892: lstore 15
    //   1894: iload_2
    //   1895: istore 5
    //   1897: lload 9
    //   1899: lstore 13
    //   1901: invokestatic 840	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1904: ifne +76 -> 1980
    //   1907: lload 9
    //   1909: lstore 15
    //   1911: iload_2
    //   1912: istore 5
    //   1914: lload 9
    //   1916: lstore 13
    //   1918: aload_0
    //   1919: invokevirtual 994	com/tencent/smtt/sdk/j:b	()V
    //   1922: lload 9
    //   1924: lstore 15
    //   1926: iload_2
    //   1927: istore 5
    //   1929: lload 9
    //   1931: lstore 13
    //   1933: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1936: ifnull +24 -> 1960
    //   1939: lload 9
    //   1941: lstore 15
    //   1943: iload_2
    //   1944: istore 5
    //   1946: lload 9
    //   1948: lstore 13
    //   1950: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1953: bipush 111
    //   1955: invokeinterface 481 2 0
    //   1960: lload 9
    //   1962: lstore 15
    //   1964: iload_2
    //   1965: istore 5
    //   1967: lload 9
    //   1969: lstore 13
    //   1971: ldc 195
    //   1973: ldc_w 996
    //   1976: iconst_0
    //   1977: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1980: lload 9
    //   1982: lstore 15
    //   1984: iload_2
    //   1985: istore 5
    //   1987: lload 9
    //   1989: lstore 13
    //   1991: aload_0
    //   1992: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   1995: ifeq +523 -> 2518
    //   1998: lload 9
    //   2000: lstore 15
    //   2002: iload_2
    //   2003: istore 5
    //   2005: lload 9
    //   2007: lstore 13
    //   2009: aload_0
    //   2010: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2013: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2016: sipush -309
    //   2019: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2022: iload_2
    //   2023: istore 5
    //   2025: iload_1
    //   2026: ifne -1523 -> 503
    //   2029: aload_0
    //   2030: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2033: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2036: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2039: ldc_w 923
    //   2042: lload 9
    //   2044: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2047: invokeinterface 459 3 0
    //   2052: pop
    //   2053: aload_0
    //   2054: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2057: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2060: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2063: iload_2
    //   2064: istore 5
    //   2066: goto -1563 -> 503
    //   2069: lload 9
    //   2071: lstore 15
    //   2073: iload_2
    //   2074: istore 5
    //   2076: lload 9
    //   2078: lstore 13
    //   2080: aload_0
    //   2081: getfield 888	com/tencent/smtt/sdk/j:h	Ljava/lang/String;
    //   2084: astore 27
    //   2086: goto -843 -> 1243
    //   2089: lload 9
    //   2091: lstore 15
    //   2093: iload_2
    //   2094: istore 5
    //   2096: lload 9
    //   2098: lstore 13
    //   2100: ldc 195
    //   2102: new 107	java/lang/StringBuilder
    //   2105: dup
    //   2106: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2109: ldc_w 998
    //   2112: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: lload 11
    //   2117: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2120: ldc_w 1000
    //   2123: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: aload_0
    //   2127: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   2130: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2133: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2136: iconst_1
    //   2137: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2140: lload 9
    //   2142: lstore 15
    //   2144: iload_2
    //   2145: istore 5
    //   2147: lload 9
    //   2149: lstore 13
    //   2151: aload_0
    //   2152: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   2155: ldc_w 976
    //   2158: new 107	java/lang/StringBuilder
    //   2161: dup
    //   2162: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2165: ldc_w 978
    //   2168: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: lload 11
    //   2173: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2176: ldc_w 980
    //   2179: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: aload_0
    //   2183: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   2186: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2189: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2192: invokevirtual 395	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2195: goto -643 -> 1552
    //   2198: astore 27
    //   2200: iload 5
    //   2202: istore 6
    //   2204: lload 15
    //   2206: lstore 13
    //   2208: aload 27
    //   2210: instanceof 1002
    //   2213: ifeq +3911 -> 6124
    //   2216: iload_1
    //   2217: ifne +3907 -> 6124
    //   2220: lload 15
    //   2222: lstore 13
    //   2224: aload_0
    //   2225: getfield 78	com/tencent/smtt/sdk/j:b	[Ljava/lang/String;
    //   2228: ifnull +3896 -> 6124
    //   2231: lload 15
    //   2233: lstore 13
    //   2235: aload_0
    //   2236: iconst_0
    //   2237: invokevirtual 1004	com/tencent/smtt/sdk/j:a	(Z)Z
    //   2240: ifeq +3884 -> 6124
    //   2243: lload 15
    //   2245: lstore 13
    //   2247: ldc 195
    //   2249: new 107	java/lang/StringBuilder
    //   2252: dup
    //   2253: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2256: ldc_w 1006
    //   2259: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2262: aload_0
    //   2263: getfield 599	com/tencent/smtt/sdk/j:j	Ljava/lang/String;
    //   2266: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2269: ldc_w 1008
    //   2272: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: aload 27
    //   2277: invokevirtual 417	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2280: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2286: invokestatic 205	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2289: lload 15
    //   2291: lstore 13
    //   2293: aload_0
    //   2294: bipush 125
    //   2296: aconst_null
    //   2297: iconst_1
    //   2298: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   2301: lload 15
    //   2303: lstore 13
    //   2305: aload_0
    //   2306: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2309: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2312: sipush -316
    //   2315: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2318: lload 15
    //   2320: lstore 11
    //   2322: iload 6
    //   2324: istore_2
    //   2325: iload_1
    //   2326: ifne -1837 -> 489
    //   2329: aload_0
    //   2330: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2333: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2336: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2339: ldc_w 923
    //   2342: lload 15
    //   2344: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2347: invokeinterface 459 3 0
    //   2352: pop
    //   2353: aload_0
    //   2354: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2357: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2360: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2363: lload 15
    //   2365: lstore 11
    //   2367: iload 6
    //   2369: istore_2
    //   2370: goto -1881 -> 489
    //   2373: iconst_1
    //   2374: istore_3
    //   2375: goto -797 -> 1578
    //   2378: lload 9
    //   2380: lstore 15
    //   2382: iload_2
    //   2383: istore 5
    //   2385: lload 9
    //   2387: lstore 13
    //   2389: iload_3
    //   2390: aload_0
    //   2391: getfield 146	com/tencent/smtt/sdk/j:x	I
    //   2394: if_icmpne +26 -> 2420
    //   2397: lload 9
    //   2399: lstore 15
    //   2401: iload_2
    //   2402: istore 5
    //   2404: lload 9
    //   2406: lstore 13
    //   2408: aload 27
    //   2410: aload_0
    //   2411: getfield 144	com/tencent/smtt/sdk/j:w	Ljava/lang/String;
    //   2414: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2417: ifne -713 -> 1704
    //   2420: lload 9
    //   2422: lstore 15
    //   2424: iload_2
    //   2425: istore 5
    //   2427: lload 9
    //   2429: lstore 13
    //   2431: aload_0
    //   2432: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2435: iconst_0
    //   2436: invokevirtual 641	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2439: lload 9
    //   2441: lstore 15
    //   2443: iload_2
    //   2444: istore 5
    //   2446: lload 9
    //   2448: lstore 13
    //   2450: aload_0
    //   2451: aload 27
    //   2453: putfield 144	com/tencent/smtt/sdk/j:w	Ljava/lang/String;
    //   2456: lload 9
    //   2458: lstore 15
    //   2460: iload_2
    //   2461: istore 5
    //   2463: lload 9
    //   2465: lstore 13
    //   2467: aload_0
    //   2468: iload_3
    //   2469: putfield 146	com/tencent/smtt/sdk/j:x	I
    //   2472: goto -768 -> 1704
    //   2475: astore 27
    //   2477: iload_1
    //   2478: ifne +37 -> 2515
    //   2481: aload_0
    //   2482: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2485: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2488: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2491: ldc_w 923
    //   2494: lload 13
    //   2496: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2499: invokeinterface 459 3 0
    //   2504: pop
    //   2505: aload_0
    //   2506: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2509: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2512: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2515: aload 27
    //   2517: athrow
    //   2518: iload_3
    //   2519: sipush 200
    //   2522: if_icmpeq +10 -> 2532
    //   2525: iload_3
    //   2526: sipush 206
    //   2529: if_icmpne +2408 -> 4937
    //   2532: lload 9
    //   2534: lstore 15
    //   2536: iload_2
    //   2537: istore 5
    //   2539: lload 9
    //   2541: lstore 13
    //   2543: aload_0
    //   2544: aload_0
    //   2545: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   2548: invokevirtual 1011	java/net/HttpURLConnection:getContentLength	()I
    //   2551: i2l
    //   2552: lload 11
    //   2554: ladd
    //   2555: putfield 597	com/tencent/smtt/sdk/j:l	J
    //   2558: lload 9
    //   2560: lstore 15
    //   2562: iload_2
    //   2563: istore 5
    //   2565: lload 9
    //   2567: lstore 13
    //   2569: ldc 195
    //   2571: new 107	java/lang/StringBuilder
    //   2574: dup
    //   2575: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2578: ldc_w 1013
    //   2581: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2584: aload_0
    //   2585: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   2588: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2591: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2594: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2597: lload 9
    //   2599: lstore 15
    //   2601: iload_2
    //   2602: istore 5
    //   2604: lload 9
    //   2606: lstore 13
    //   2608: aload_0
    //   2609: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2612: aload_0
    //   2613: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   2616: invokevirtual 1016	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2619: lload 9
    //   2621: lstore 15
    //   2623: iload_2
    //   2624: istore 5
    //   2626: lload 9
    //   2628: lstore 13
    //   2630: aload_0
    //   2631: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2634: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2637: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2640: ldc_w 533
    //   2643: lconst_0
    //   2644: invokeinterface 537 4 0
    //   2649: lstore 17
    //   2651: lload 17
    //   2653: lconst_0
    //   2654: lcmp
    //   2655: ifeq +396 -> 3051
    //   2658: lload 9
    //   2660: lstore 15
    //   2662: iload_2
    //   2663: istore 5
    //   2665: lload 9
    //   2667: lstore 13
    //   2669: aload_0
    //   2670: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   2673: lload 17
    //   2675: lcmp
    //   2676: ifeq +375 -> 3051
    //   2679: lload 9
    //   2681: lstore 15
    //   2683: iload_2
    //   2684: istore 5
    //   2686: lload 9
    //   2688: lstore 13
    //   2690: ldc 195
    //   2692: new 107	java/lang/StringBuilder
    //   2695: dup
    //   2696: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2699: ldc_w 1018
    //   2702: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2705: lload 17
    //   2707: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2710: ldc_w 1020
    //   2713: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2716: aload_0
    //   2717: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   2720: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2723: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2726: iconst_1
    //   2727: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2730: iload_1
    //   2731: ifne +272 -> 3003
    //   2734: lload 9
    //   2736: lstore 15
    //   2738: iload_2
    //   2739: istore 5
    //   2741: lload 9
    //   2743: lstore 13
    //   2745: aload_0
    //   2746: invokespecial 420	com/tencent/smtt/sdk/j:m	()Z
    //   2749: ifne +41 -> 2790
    //   2752: lload 9
    //   2754: lstore 15
    //   2756: iload_2
    //   2757: istore 5
    //   2759: lload 9
    //   2761: lstore 13
    //   2763: invokestatic 840	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2766: ifeq +237 -> 3003
    //   2769: lload 9
    //   2771: lstore 15
    //   2773: iload_2
    //   2774: istore 5
    //   2776: lload 9
    //   2778: lstore 13
    //   2780: aload_0
    //   2781: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2784: invokestatic 647	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2787: ifeq +216 -> 3003
    //   2790: lload 9
    //   2792: lstore 15
    //   2794: iload_2
    //   2795: istore 5
    //   2797: lload 9
    //   2799: lstore 13
    //   2801: aload_0
    //   2802: getfield 78	com/tencent/smtt/sdk/j:b	[Ljava/lang/String;
    //   2805: ifnull +75 -> 2880
    //   2808: lload 9
    //   2810: lstore 15
    //   2812: iload_2
    //   2813: istore 5
    //   2815: lload 9
    //   2817: lstore 13
    //   2819: aload_0
    //   2820: iconst_0
    //   2821: invokevirtual 1004	com/tencent/smtt/sdk/j:a	(Z)Z
    //   2824: istore 6
    //   2826: iload 6
    //   2828: ifeq +52 -> 2880
    //   2831: lload 9
    //   2833: lstore 11
    //   2835: iload_1
    //   2836: ifne -2347 -> 489
    //   2839: aload_0
    //   2840: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2843: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2846: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2849: ldc_w 923
    //   2852: lload 9
    //   2854: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2857: invokeinterface 459 3 0
    //   2862: pop
    //   2863: aload_0
    //   2864: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2867: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2870: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2873: lload 9
    //   2875: lstore 11
    //   2877: goto -2388 -> 489
    //   2880: lload 9
    //   2882: lstore 15
    //   2884: iload_2
    //   2885: istore 5
    //   2887: lload 9
    //   2889: lstore 13
    //   2891: aload_0
    //   2892: bipush 113
    //   2894: new 107	java/lang/StringBuilder
    //   2897: dup
    //   2898: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2901: ldc_w 1022
    //   2904: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: lload 17
    //   2909: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2912: ldc_w 1020
    //   2915: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2918: aload_0
    //   2919: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   2922: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2925: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2928: iconst_1
    //   2929: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   2932: lload 9
    //   2934: lstore 15
    //   2936: iload_2
    //   2937: istore 5
    //   2939: lload 9
    //   2941: lstore 13
    //   2943: aload_0
    //   2944: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2947: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2950: sipush -310
    //   2953: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2956: iload_2
    //   2957: istore 5
    //   2959: iload_1
    //   2960: ifne -2457 -> 503
    //   2963: aload_0
    //   2964: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2967: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2970: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2973: ldc_w 923
    //   2976: lload 9
    //   2978: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2981: invokeinterface 459 3 0
    //   2986: pop
    //   2987: aload_0
    //   2988: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   2991: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2994: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2997: iload_2
    //   2998: istore 5
    //   3000: goto -2497 -> 503
    //   3003: lload 9
    //   3005: lstore 15
    //   3007: iload_2
    //   3008: istore 5
    //   3010: lload 9
    //   3012: lstore 13
    //   3014: aload_0
    //   3015: bipush 101
    //   3017: ldc_w 1024
    //   3020: iconst_1
    //   3021: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   3024: lload 9
    //   3026: lstore 15
    //   3028: iload_2
    //   3029: istore 5
    //   3031: lload 9
    //   3033: lstore 13
    //   3035: aload_0
    //   3036: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3039: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3042: sipush -304
    //   3045: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3048: goto -92 -> 2956
    //   3051: aconst_null
    //   3052: astore 31
    //   3054: aconst_null
    //   3055: astore 27
    //   3057: aconst_null
    //   3058: astore 29
    //   3060: lload 9
    //   3062: lstore 15
    //   3064: iload_2
    //   3065: istore 5
    //   3067: lload 9
    //   3069: lstore 13
    //   3071: ldc 195
    //   3073: ldc_w 1026
    //   3076: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3079: aload_0
    //   3080: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   3083: invokevirtual 736	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3086: astore 28
    //   3088: aload 28
    //   3090: ifnull +3451 -> 6541
    //   3093: aload_0
    //   3094: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   3097: invokevirtual 1029	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3100: astore 27
    //   3102: aload 27
    //   3104: ifnull +258 -> 3362
    //   3107: aload 27
    //   3109: ldc_w 1031
    //   3112: invokevirtual 318	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3115: ifeq +247 -> 3362
    //   3118: new 1033	java/util/zip/GZIPInputStream
    //   3121: dup
    //   3122: aload 28
    //   3124: invokespecial 1034	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3127: astore 27
    //   3129: sipush 8192
    //   3132: newarray byte
    //   3134: astore 29
    //   3136: new 1036	java/io/FileOutputStream
    //   3139: dup
    //   3140: new 174	java/io/File
    //   3143: dup
    //   3144: aload_0
    //   3145: getfield 133	com/tencent/smtt/sdk/j:k	Ljava/io/File;
    //   3148: ldc_w 437
    //   3151: invokespecial 218	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3154: iconst_1
    //   3155: invokespecial 1039	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3158: astore 30
    //   3160: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   3163: lstore 15
    //   3165: iconst_0
    //   3166: istore_3
    //   3167: lload 11
    //   3169: lstore 21
    //   3171: lload 11
    //   3173: lstore 13
    //   3175: iload_2
    //   3176: istore 6
    //   3178: lload 9
    //   3180: lstore 17
    //   3182: iload_2
    //   3183: istore 7
    //   3185: lload 9
    //   3187: lstore 19
    //   3189: aload_0
    //   3190: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   3193: ifeq +386 -> 3579
    //   3196: iload_2
    //   3197: istore 6
    //   3199: lload 9
    //   3201: lstore 17
    //   3203: iload_2
    //   3204: istore 7
    //   3206: lload 9
    //   3208: lstore 19
    //   3210: ldc 195
    //   3212: ldc_w 1041
    //   3215: iconst_1
    //   3216: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3219: iload_2
    //   3220: istore 6
    //   3222: lload 9
    //   3224: lstore 17
    //   3226: iload_2
    //   3227: istore 7
    //   3229: lload 9
    //   3231: lstore 19
    //   3233: aload_0
    //   3234: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3237: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3240: sipush -309
    //   3243: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3246: iload_2
    //   3247: istore 6
    //   3249: iload_3
    //   3250: ifeq +1121 -> 4371
    //   3253: lload 9
    //   3255: lstore 15
    //   3257: iload 6
    //   3259: istore 5
    //   3261: lload 9
    //   3263: lstore 13
    //   3265: aload_0
    //   3266: aload 30
    //   3268: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   3271: lload 9
    //   3273: lstore 15
    //   3275: iload 6
    //   3277: istore 5
    //   3279: lload 9
    //   3281: lstore 13
    //   3283: aload_0
    //   3284: aload 27
    //   3286: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   3289: lload 9
    //   3291: lstore 15
    //   3293: iload 6
    //   3295: istore 5
    //   3297: lload 9
    //   3299: lstore 13
    //   3301: aload_0
    //   3302: aload 28
    //   3304: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   3307: lload 9
    //   3309: lstore 11
    //   3311: iload 6
    //   3313: istore_2
    //   3314: iload_1
    //   3315: ifne -2826 -> 489
    //   3318: aload_0
    //   3319: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3322: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3325: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3328: ldc_w 923
    //   3331: lload 9
    //   3333: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3336: invokeinterface 459 3 0
    //   3341: pop
    //   3342: aload_0
    //   3343: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3346: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3349: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3352: lload 9
    //   3354: lstore 11
    //   3356: iload 6
    //   3358: istore_2
    //   3359: goto -2870 -> 489
    //   3362: aload 27
    //   3364: ifnull +208 -> 3572
    //   3367: aload 27
    //   3369: ldc_w 1043
    //   3372: invokevirtual 318	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3375: ifeq +197 -> 3572
    //   3378: new 1045	java/util/zip/InflaterInputStream
    //   3381: dup
    //   3382: aload 28
    //   3384: new 1047	java/util/zip/Inflater
    //   3387: dup
    //   3388: iconst_1
    //   3389: invokespecial 1049	java/util/zip/Inflater:<init>	(Z)V
    //   3392: invokespecial 1052	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3395: astore 27
    //   3397: goto -268 -> 3129
    //   3400: astore 32
    //   3402: aload 28
    //   3404: astore 27
    //   3406: aload 31
    //   3408: astore 30
    //   3410: aload 32
    //   3412: astore 28
    //   3414: iload_2
    //   3415: istore 6
    //   3417: aload 28
    //   3419: invokevirtual 1053	java/io/IOException:printStackTrace	()V
    //   3422: aload 28
    //   3424: instanceof 1055
    //   3427: ifne +11 -> 3438
    //   3430: aload 28
    //   3432: instanceof 1057
    //   3435: ifeq +1079 -> 4514
    //   3438: aload_0
    //   3439: ldc_w 1058
    //   3442: putfield 72	com/tencent/smtt/sdk/j:m	I
    //   3445: aload_0
    //   3446: lconst_0
    //   3447: invokespecial 1060	com/tencent/smtt/sdk/j:a	(J)V
    //   3450: aload_0
    //   3451: bipush 103
    //   3453: aload_0
    //   3454: aload 28
    //   3456: invokespecial 581	com/tencent/smtt/sdk/j:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3459: iconst_0
    //   3460: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   3463: lload 9
    //   3465: lstore 15
    //   3467: iload 6
    //   3469: istore 5
    //   3471: lload 9
    //   3473: lstore 13
    //   3475: aload_0
    //   3476: aload 30
    //   3478: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   3481: lload 9
    //   3483: lstore 15
    //   3485: iload 6
    //   3487: istore 5
    //   3489: lload 9
    //   3491: lstore 13
    //   3493: aload_0
    //   3494: aload 29
    //   3496: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   3499: lload 9
    //   3501: lstore 15
    //   3503: iload 6
    //   3505: istore 5
    //   3507: lload 9
    //   3509: lstore 13
    //   3511: aload_0
    //   3512: aload 27
    //   3514: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   3517: lload 9
    //   3519: lstore 11
    //   3521: iload 6
    //   3523: istore_2
    //   3524: iload_1
    //   3525: ifne -3036 -> 489
    //   3528: aload_0
    //   3529: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3532: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3535: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3538: ldc_w 923
    //   3541: lload 9
    //   3543: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3546: invokeinterface 459 3 0
    //   3551: pop
    //   3552: aload_0
    //   3553: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3556: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3559: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3562: lload 9
    //   3564: lstore 11
    //   3566: iload 6
    //   3568: istore_2
    //   3569: goto -3080 -> 489
    //   3572: aload 28
    //   3574: astore 27
    //   3576: goto -447 -> 3129
    //   3579: iload_2
    //   3580: istore 6
    //   3582: lload 9
    //   3584: lstore 17
    //   3586: iload_2
    //   3587: istore 7
    //   3589: lload 9
    //   3591: lstore 19
    //   3593: aload 27
    //   3595: aload 29
    //   3597: iconst_0
    //   3598: sipush 8192
    //   3601: invokevirtual 1066	java/io/InputStream:read	([BII)I
    //   3604: istore 4
    //   3606: iload 4
    //   3608: ifgt +189 -> 3797
    //   3611: iload_2
    //   3612: istore 6
    //   3614: lload 9
    //   3616: lstore 17
    //   3618: iload_2
    //   3619: istore 7
    //   3621: lload 9
    //   3623: lstore 19
    //   3625: aload_0
    //   3626: getfield 78	com/tencent/smtt/sdk/j:b	[Ljava/lang/String;
    //   3629: ifnull +86 -> 3715
    //   3632: iload_2
    //   3633: istore 6
    //   3635: lload 9
    //   3637: lstore 17
    //   3639: iload_2
    //   3640: istore 7
    //   3642: lload 9
    //   3644: lstore 19
    //   3646: aload_0
    //   3647: iconst_1
    //   3648: iload 8
    //   3650: invokespecial 863	com/tencent/smtt/sdk/j:c	(ZZ)Z
    //   3653: ifne +62 -> 3715
    //   3656: iload_1
    //   3657: ifne +33 -> 3690
    //   3660: iload_2
    //   3661: istore 6
    //   3663: lload 9
    //   3665: lstore 17
    //   3667: iload_2
    //   3668: istore 7
    //   3670: lload 9
    //   3672: lstore 19
    //   3674: aload_0
    //   3675: iconst_0
    //   3676: invokevirtual 1004	com/tencent/smtt/sdk/j:a	(Z)Z
    //   3679: ifeq +11 -> 3690
    //   3682: iconst_1
    //   3683: istore_3
    //   3684: iload_2
    //   3685: istore 6
    //   3687: goto -438 -> 3249
    //   3690: iload_2
    //   3691: istore 6
    //   3693: lload 9
    //   3695: lstore 17
    //   3697: iload_2
    //   3698: istore 7
    //   3700: lload 9
    //   3702: lstore 19
    //   3704: aload_0
    //   3705: iconst_1
    //   3706: putfield 605	com/tencent/smtt/sdk/j:s	Z
    //   3709: iconst_0
    //   3710: istore 6
    //   3712: goto -463 -> 3249
    //   3715: iload_2
    //   3716: istore 6
    //   3718: lload 9
    //   3720: lstore 17
    //   3722: iload_2
    //   3723: istore 7
    //   3725: lload 9
    //   3727: lstore 19
    //   3729: aload_0
    //   3730: iconst_1
    //   3731: putfield 605	com/tencent/smtt/sdk/j:s	Z
    //   3734: iload_2
    //   3735: istore 5
    //   3737: iload_2
    //   3738: istore 6
    //   3740: lload 9
    //   3742: lstore 17
    //   3744: iload_2
    //   3745: istore 7
    //   3747: lload 9
    //   3749: lstore 19
    //   3751: aload_0
    //   3752: getfield 78	com/tencent/smtt/sdk/j:b	[Ljava/lang/String;
    //   3755: ifnull +6 -> 3761
    //   3758: iconst_1
    //   3759: istore 5
    //   3761: iload 5
    //   3763: istore 6
    //   3765: lload 9
    //   3767: lstore 17
    //   3769: iload 5
    //   3771: istore 7
    //   3773: lload 9
    //   3775: lstore 19
    //   3777: aload_0
    //   3778: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3781: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3784: sipush -311
    //   3787: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3790: iload 5
    //   3792: istore 6
    //   3794: goto -545 -> 3249
    //   3797: iload_2
    //   3798: istore 6
    //   3800: lload 9
    //   3802: lstore 17
    //   3804: iload_2
    //   3805: istore 7
    //   3807: lload 9
    //   3809: lstore 19
    //   3811: aload 30
    //   3813: aload 29
    //   3815: iconst_0
    //   3816: iload 4
    //   3818: invokevirtual 1070	java/io/FileOutputStream:write	([BII)V
    //   3821: iload_2
    //   3822: istore 6
    //   3824: lload 9
    //   3826: lstore 17
    //   3828: iload_2
    //   3829: istore 7
    //   3831: lload 9
    //   3833: lstore 19
    //   3835: aload 30
    //   3837: invokevirtual 1073	java/io/FileOutputStream:flush	()V
    //   3840: lload 9
    //   3842: lstore 11
    //   3844: iload_1
    //   3845: ifne +274 -> 4119
    //   3848: lload 9
    //   3850: iload 4
    //   3852: i2l
    //   3853: ladd
    //   3854: lstore 9
    //   3856: lload 9
    //   3858: lload 25
    //   3860: lcmp
    //   3861: iflt +112 -> 3973
    //   3864: iload_2
    //   3865: istore 6
    //   3867: lload 9
    //   3869: lstore 17
    //   3871: iload_2
    //   3872: istore 7
    //   3874: lload 9
    //   3876: lstore 19
    //   3878: ldc 195
    //   3880: ldc_w 957
    //   3883: iconst_1
    //   3884: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3887: iload_2
    //   3888: istore 6
    //   3890: lload 9
    //   3892: lstore 17
    //   3894: iload_2
    //   3895: istore 7
    //   3897: lload 9
    //   3899: lstore 19
    //   3901: aload_0
    //   3902: bipush 112
    //   3904: new 107	java/lang/StringBuilder
    //   3907: dup
    //   3908: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   3911: ldc_w 1075
    //   3914: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3917: lload 9
    //   3919: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3922: ldc_w 1077
    //   3925: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3928: lload 25
    //   3930: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3933: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3936: iconst_1
    //   3937: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   3940: iload_2
    //   3941: istore 6
    //   3943: lload 9
    //   3945: lstore 17
    //   3947: iload_2
    //   3948: istore 7
    //   3950: lload 9
    //   3952: lstore 19
    //   3954: aload_0
    //   3955: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3958: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3961: sipush -307
    //   3964: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3967: iload_2
    //   3968: istore 6
    //   3970: goto -721 -> 3249
    //   3973: lload 9
    //   3975: lstore 11
    //   3977: iload_2
    //   3978: istore 6
    //   3980: lload 9
    //   3982: lstore 17
    //   3984: iload_2
    //   3985: istore 7
    //   3987: lload 9
    //   3989: lstore 19
    //   3991: aload_0
    //   3992: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   3995: invokestatic 951	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   3998: ifne +121 -> 4119
    //   4001: iload_2
    //   4002: istore 6
    //   4004: lload 9
    //   4006: lstore 17
    //   4008: iload_2
    //   4009: istore 7
    //   4011: lload 9
    //   4013: lstore 19
    //   4015: ldc 195
    //   4017: ldc_w 1079
    //   4020: iconst_1
    //   4021: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4024: iload_2
    //   4025: istore 6
    //   4027: lload 9
    //   4029: lstore 17
    //   4031: iload_2
    //   4032: istore 7
    //   4034: lload 9
    //   4036: lstore 19
    //   4038: aload_0
    //   4039: bipush 105
    //   4041: new 107	java/lang/StringBuilder
    //   4044: dup
    //   4045: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   4048: ldc_w 1081
    //   4051: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4054: invokestatic 1083	com/tencent/smtt/utils/o:a	()J
    //   4057: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4060: ldc_w 1085
    //   4063: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4066: aload_0
    //   4067: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4070: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4073: invokevirtual 1088	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4076: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4079: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4082: iconst_1
    //   4083: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   4086: iload_2
    //   4087: istore 6
    //   4089: lload 9
    //   4091: lstore 17
    //   4093: iload_2
    //   4094: istore 7
    //   4096: lload 9
    //   4098: lstore 19
    //   4100: aload_0
    //   4101: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4104: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4107: sipush -308
    //   4110: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4113: iload_2
    //   4114: istore 6
    //   4116: goto -867 -> 3249
    //   4119: iload 4
    //   4121: i2l
    //   4122: lstore 9
    //   4124: aload_0
    //   4125: lload 23
    //   4127: lload 9
    //   4129: invokespecial 1090	com/tencent/smtt/sdk/j:a	(JJ)J
    //   4132: lstore 23
    //   4134: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   4137: lstore 19
    //   4139: iload 4
    //   4141: i2l
    //   4142: lload 21
    //   4144: ladd
    //   4145: lstore 17
    //   4147: lload 19
    //   4149: lload 15
    //   4151: lsub
    //   4152: ldc2_w 1091
    //   4155: lcmp
    //   4156: ifle +2374 -> 6530
    //   4159: ldc 195
    //   4161: new 107	java/lang/StringBuilder
    //   4164: dup
    //   4165: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   4168: ldc_w 1094
    //   4171: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4174: lload 17
    //   4176: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4179: ldc_w 1000
    //   4182: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4185: aload_0
    //   4186: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   4189: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4192: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4195: iconst_1
    //   4196: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4199: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4202: ifnull +29 -> 4231
    //   4205: lload 17
    //   4207: l2d
    //   4208: aload_0
    //   4209: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   4212: l2d
    //   4213: ddiv
    //   4214: ldc2_w 1095
    //   4217: dmul
    //   4218: d2i
    //   4219: istore 4
    //   4221: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4224: iload 4
    //   4226: invokeinterface 1099 2 0
    //   4231: lload 13
    //   4233: lstore 9
    //   4235: iload_1
    //   4236: ifne +112 -> 4348
    //   4239: lload 13
    //   4241: lstore 9
    //   4243: lload 17
    //   4245: lload 13
    //   4247: lsub
    //   4248: ldc2_w 1100
    //   4251: lcmp
    //   4252: ifle +96 -> 4348
    //   4255: aload_0
    //   4256: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4259: invokestatic 213	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4262: ifne +82 -> 4344
    //   4265: aload_0
    //   4266: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4269: invokestatic 632	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4272: iconst_3
    //   4273: if_icmpne +13 -> 4286
    //   4276: aload_0
    //   4277: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4280: invokestatic 632	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4283: ifne +61 -> 4344
    //   4286: invokestatic 840	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4289: ifne +55 -> 4344
    //   4292: aload_0
    //   4293: invokevirtual 994	com/tencent/smtt/sdk/j:b	()V
    //   4296: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4299: ifnull +13 -> 4312
    //   4302: getstatic 476	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4305: bipush 111
    //   4307: invokeinterface 481 2 0
    //   4312: ldc 195
    //   4314: ldc_w 1103
    //   4317: iconst_0
    //   4318: invokestatic 895	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4321: aload_0
    //   4322: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4325: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4328: sipush -304
    //   4331: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4334: lload 11
    //   4336: lstore 9
    //   4338: iload_2
    //   4339: istore 6
    //   4341: goto -1092 -> 3249
    //   4344: lload 17
    //   4346: lstore 9
    //   4348: lload 19
    //   4350: lstore 13
    //   4352: lload 13
    //   4354: lstore 15
    //   4356: lload 9
    //   4358: lstore 13
    //   4360: lload 11
    //   4362: lstore 9
    //   4364: lload 17
    //   4366: lstore 21
    //   4368: goto -1193 -> 3175
    //   4371: iload 6
    //   4373: istore_2
    //   4374: iload_2
    //   4375: istore 5
    //   4377: lload 9
    //   4379: lstore 11
    //   4381: lload 9
    //   4383: lstore 13
    //   4385: aload_0
    //   4386: aload 30
    //   4388: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4391: iload_2
    //   4392: istore 5
    //   4394: lload 9
    //   4396: lstore 11
    //   4398: lload 9
    //   4400: lstore 13
    //   4402: aload_0
    //   4403: aload 27
    //   4405: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4408: iload_2
    //   4409: istore 5
    //   4411: lload 9
    //   4413: lstore 11
    //   4415: lload 9
    //   4417: lstore 13
    //   4419: aload_0
    //   4420: aload 28
    //   4422: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4425: iload_2
    //   4426: istore 5
    //   4428: lload 9
    //   4430: lstore 11
    //   4432: lload 9
    //   4434: lstore 13
    //   4436: aload_0
    //   4437: getfield 605	com/tencent/smtt/sdk/j:s	Z
    //   4440: ifne +27 -> 4467
    //   4443: iload_2
    //   4444: istore 5
    //   4446: lload 9
    //   4448: lstore 11
    //   4450: lload 9
    //   4452: lstore 13
    //   4454: aload_0
    //   4455: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4458: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4461: sipush -319
    //   4464: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4467: iload_2
    //   4468: istore 5
    //   4470: iload_1
    //   4471: ifne -3968 -> 503
    //   4474: aload_0
    //   4475: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4478: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4481: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4484: ldc_w 923
    //   4487: lload 9
    //   4489: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4492: invokeinterface 459 3 0
    //   4497: pop
    //   4498: aload_0
    //   4499: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4502: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4505: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4508: iload_2
    //   4509: istore 5
    //   4511: goto -4008 -> 503
    //   4514: iload_1
    //   4515: ifne +177 -> 4692
    //   4518: aload_0
    //   4519: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4522: invokestatic 951	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   4525: ifne +167 -> 4692
    //   4528: aload_0
    //   4529: bipush 105
    //   4531: new 107	java/lang/StringBuilder
    //   4534: dup
    //   4535: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   4538: ldc_w 1081
    //   4541: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4544: invokestatic 1083	com/tencent/smtt/utils/o:a	()J
    //   4547: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4550: ldc_w 1085
    //   4553: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4556: aload_0
    //   4557: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4560: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4563: invokevirtual 1088	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4566: invokevirtual 546	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4569: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4572: iconst_1
    //   4573: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   4576: aload_0
    //   4577: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4580: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4583: sipush -308
    //   4586: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4589: lload 9
    //   4591: lstore 15
    //   4593: iload 6
    //   4595: istore 5
    //   4597: lload 9
    //   4599: lstore 13
    //   4601: aload_0
    //   4602: aload 30
    //   4604: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4607: lload 9
    //   4609: lstore 15
    //   4611: iload 6
    //   4613: istore 5
    //   4615: lload 9
    //   4617: lstore 13
    //   4619: aload_0
    //   4620: aload 29
    //   4622: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4625: lload 9
    //   4627: lstore 15
    //   4629: iload 6
    //   4631: istore 5
    //   4633: lload 9
    //   4635: lstore 13
    //   4637: aload_0
    //   4638: aload 27
    //   4640: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4643: iload 6
    //   4645: istore 5
    //   4647: iload_1
    //   4648: ifne -4145 -> 503
    //   4651: aload_0
    //   4652: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4655: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4658: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4661: ldc_w 923
    //   4664: lload 9
    //   4666: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4669: invokeinterface 459 3 0
    //   4674: pop
    //   4675: aload_0
    //   4676: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4679: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4682: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4685: iload 6
    //   4687: istore 5
    //   4689: goto -4186 -> 503
    //   4692: aload_0
    //   4693: lconst_0
    //   4694: invokespecial 1060	com/tencent/smtt/sdk/j:a	(J)V
    //   4697: aload_0
    //   4698: invokespecial 1105	com/tencent/smtt/sdk/j:i	()Z
    //   4701: ifne +125 -> 4826
    //   4704: aload_0
    //   4705: bipush 106
    //   4707: aload_0
    //   4708: aload 28
    //   4710: invokespecial 581	com/tencent/smtt/sdk/j:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4713: iconst_0
    //   4714: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   4717: lload 9
    //   4719: lstore 15
    //   4721: iload 6
    //   4723: istore 5
    //   4725: lload 9
    //   4727: lstore 13
    //   4729: aload_0
    //   4730: aload 30
    //   4732: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4735: lload 9
    //   4737: lstore 15
    //   4739: iload 6
    //   4741: istore 5
    //   4743: lload 9
    //   4745: lstore 13
    //   4747: aload_0
    //   4748: aload 29
    //   4750: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4753: lload 9
    //   4755: lstore 15
    //   4757: iload 6
    //   4759: istore 5
    //   4761: lload 9
    //   4763: lstore 13
    //   4765: aload_0
    //   4766: aload 27
    //   4768: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4771: lload 9
    //   4773: lstore 11
    //   4775: iload 6
    //   4777: istore_2
    //   4778: iload_1
    //   4779: ifne -4290 -> 489
    //   4782: aload_0
    //   4783: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4786: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4789: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4792: ldc_w 923
    //   4795: lload 9
    //   4797: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4800: invokeinterface 459 3 0
    //   4805: pop
    //   4806: aload_0
    //   4807: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   4810: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4813: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4816: lload 9
    //   4818: lstore 11
    //   4820: iload 6
    //   4822: istore_2
    //   4823: goto -4334 -> 489
    //   4826: aload_0
    //   4827: bipush 104
    //   4829: aload_0
    //   4830: aload 28
    //   4832: invokespecial 581	com/tencent/smtt/sdk/j:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4835: iconst_0
    //   4836: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   4839: goto -122 -> 4717
    //   4842: astore 31
    //   4844: aload 27
    //   4846: astore 28
    //   4848: aload 29
    //   4850: astore 27
    //   4852: iload 6
    //   4854: istore_2
    //   4855: aload 31
    //   4857: astore 29
    //   4859: iload_2
    //   4860: istore 5
    //   4862: lload 9
    //   4864: lstore 11
    //   4866: lload 9
    //   4868: lstore 13
    //   4870: aload_0
    //   4871: aload 30
    //   4873: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4876: iload_2
    //   4877: istore 5
    //   4879: lload 9
    //   4881: lstore 11
    //   4883: lload 9
    //   4885: lstore 13
    //   4887: aload_0
    //   4888: aload 27
    //   4890: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4893: iload_2
    //   4894: istore 5
    //   4896: lload 9
    //   4898: lstore 11
    //   4900: lload 9
    //   4902: lstore 13
    //   4904: aload_0
    //   4905: aload 28
    //   4907: invokespecial 716	com/tencent/smtt/sdk/j:a	(Ljava/io/Closeable;)V
    //   4910: iload_2
    //   4911: istore 5
    //   4913: lload 9
    //   4915: lstore 11
    //   4917: lload 9
    //   4919: lstore 13
    //   4921: aload 29
    //   4923: athrow
    //   4924: astore 27
    //   4926: lload 11
    //   4928: lstore 15
    //   4930: iload 5
    //   4932: istore 6
    //   4934: goto -2730 -> 2204
    //   4937: iload_3
    //   4938: sipush 300
    //   4941: if_icmplt +229 -> 5170
    //   4944: iload_3
    //   4945: sipush 307
    //   4948: if_icmpgt +222 -> 5170
    //   4951: lload 9
    //   4953: lstore 15
    //   4955: iload_2
    //   4956: istore 5
    //   4958: lload 9
    //   4960: lstore 13
    //   4962: aload_0
    //   4963: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   4966: ldc_w 1107
    //   4969: invokevirtual 1111	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   4972: astore 27
    //   4974: lload 9
    //   4976: lstore 15
    //   4978: iload_2
    //   4979: istore 5
    //   4981: lload 9
    //   4983: lstore 13
    //   4985: aload 27
    //   4987: invokestatic 746	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4990: ifne +90 -> 5080
    //   4993: lload 9
    //   4995: lstore 15
    //   4997: iload_2
    //   4998: istore 5
    //   5000: lload 9
    //   5002: lstore 13
    //   5004: aload_0
    //   5005: aload 27
    //   5007: putfield 599	com/tencent/smtt/sdk/j:j	Ljava/lang/String;
    //   5010: lload 9
    //   5012: lstore 15
    //   5014: iload_2
    //   5015: istore 5
    //   5017: lload 9
    //   5019: lstore 13
    //   5021: aload_0
    //   5022: aload_0
    //   5023: getfield 593	com/tencent/smtt/sdk/j:q	I
    //   5026: iconst_1
    //   5027: iadd
    //   5028: putfield 593	com/tencent/smtt/sdk/j:q	I
    //   5031: lload 9
    //   5033: lstore 11
    //   5035: iload_1
    //   5036: ifne -4547 -> 489
    //   5039: aload_0
    //   5040: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5043: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5046: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5049: ldc_w 923
    //   5052: lload 9
    //   5054: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5057: invokeinterface 459 3 0
    //   5062: pop
    //   5063: aload_0
    //   5064: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5067: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5070: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5073: lload 9
    //   5075: lstore 11
    //   5077: goto -4588 -> 489
    //   5080: lload 9
    //   5082: lstore 15
    //   5084: iload_2
    //   5085: istore 5
    //   5087: lload 9
    //   5089: lstore 13
    //   5091: aload_0
    //   5092: bipush 124
    //   5094: aconst_null
    //   5095: iconst_1
    //   5096: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   5099: lload 9
    //   5101: lstore 15
    //   5103: iload_2
    //   5104: istore 5
    //   5106: lload 9
    //   5108: lstore 13
    //   5110: aload_0
    //   5111: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5114: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5117: sipush -312
    //   5120: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5123: iload_2
    //   5124: istore 5
    //   5126: iload_1
    //   5127: ifne -4624 -> 503
    //   5130: aload_0
    //   5131: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5134: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5137: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5140: ldc_w 923
    //   5143: lload 9
    //   5145: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5148: invokeinterface 459 3 0
    //   5153: pop
    //   5154: aload_0
    //   5155: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5158: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5161: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5164: iload_2
    //   5165: istore 5
    //   5167: goto -4664 -> 503
    //   5170: lload 9
    //   5172: lstore 15
    //   5174: iload_2
    //   5175: istore 5
    //   5177: lload 9
    //   5179: lstore 13
    //   5181: aload_0
    //   5182: bipush 102
    //   5184: iload_3
    //   5185: invokestatic 1114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5188: iconst_0
    //   5189: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   5192: iload_3
    //   5193: sipush 416
    //   5196: if_icmpne +185 -> 5381
    //   5199: lload 9
    //   5201: lstore 15
    //   5203: iload_2
    //   5204: istore 5
    //   5206: lload 9
    //   5208: lstore 13
    //   5210: aload_0
    //   5211: iconst_1
    //   5212: iload 8
    //   5214: invokespecial 863	com/tencent/smtt/sdk/j:c	(ZZ)Z
    //   5217: ifeq +76 -> 5293
    //   5220: iconst_1
    //   5221: istore 5
    //   5223: iconst_1
    //   5224: istore_2
    //   5225: lload 9
    //   5227: lstore 15
    //   5229: lload 9
    //   5231: lstore 13
    //   5233: aload_0
    //   5234: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5237: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5240: sipush -214
    //   5243: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5246: iload_2
    //   5247: istore 5
    //   5249: iload_1
    //   5250: ifne -4747 -> 503
    //   5253: aload_0
    //   5254: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5257: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5260: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5263: ldc_w 923
    //   5266: lload 9
    //   5268: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5271: invokeinterface 459 3 0
    //   5276: pop
    //   5277: aload_0
    //   5278: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5281: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5284: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5287: iload_2
    //   5288: istore 5
    //   5290: goto -4787 -> 503
    //   5293: lload 9
    //   5295: lstore 15
    //   5297: iload_2
    //   5298: istore 5
    //   5300: lload 9
    //   5302: lstore 13
    //   5304: aload_0
    //   5305: iconst_0
    //   5306: invokespecial 865	com/tencent/smtt/sdk/j:d	(Z)Z
    //   5309: pop
    //   5310: lload 9
    //   5312: lstore 15
    //   5314: iload_2
    //   5315: istore 5
    //   5317: lload 9
    //   5319: lstore 13
    //   5321: aload_0
    //   5322: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5325: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5328: sipush -313
    //   5331: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5334: iload_2
    //   5335: istore 5
    //   5337: iload_1
    //   5338: ifne -4835 -> 503
    //   5341: aload_0
    //   5342: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5345: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5348: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5351: ldc_w 923
    //   5354: lload 9
    //   5356: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5359: invokeinterface 459 3 0
    //   5364: pop
    //   5365: aload_0
    //   5366: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5369: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5372: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5375: iload_2
    //   5376: istore 5
    //   5378: goto -4875 -> 503
    //   5381: iload_3
    //   5382: sipush 403
    //   5385: if_icmpeq +10 -> 5395
    //   5388: iload_3
    //   5389: sipush 406
    //   5392: if_icmpne +96 -> 5488
    //   5395: lload 9
    //   5397: lstore 15
    //   5399: iload_2
    //   5400: istore 5
    //   5402: lload 9
    //   5404: lstore 13
    //   5406: aload_0
    //   5407: getfield 597	com/tencent/smtt/sdk/j:l	J
    //   5410: ldc2_w 594
    //   5413: lcmp
    //   5414: ifne +74 -> 5488
    //   5417: lload 9
    //   5419: lstore 15
    //   5421: iload_2
    //   5422: istore 5
    //   5424: lload 9
    //   5426: lstore 13
    //   5428: aload_0
    //   5429: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5432: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5435: sipush -314
    //   5438: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5441: iload_2
    //   5442: istore 5
    //   5444: iload_1
    //   5445: ifne -4942 -> 503
    //   5448: aload_0
    //   5449: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5452: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5455: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5458: ldc_w 923
    //   5461: lload 9
    //   5463: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5466: invokeinterface 459 3 0
    //   5471: pop
    //   5472: aload_0
    //   5473: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5476: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5479: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5482: iload_2
    //   5483: istore 5
    //   5485: goto -4982 -> 503
    //   5488: iload_3
    //   5489: sipush 202
    //   5492: if_icmpne +52 -> 5544
    //   5495: lload 9
    //   5497: lstore 11
    //   5499: iload_1
    //   5500: ifne -5011 -> 489
    //   5503: aload_0
    //   5504: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5507: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5510: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5513: ldc_w 923
    //   5516: lload 9
    //   5518: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5521: invokeinterface 459 3 0
    //   5526: pop
    //   5527: aload_0
    //   5528: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5531: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5534: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5537: lload 9
    //   5539: lstore 11
    //   5541: goto -5052 -> 489
    //   5544: lload 9
    //   5546: lstore 15
    //   5548: iload_2
    //   5549: istore 5
    //   5551: lload 9
    //   5553: lstore 13
    //   5555: aload_0
    //   5556: getfield 259	com/tencent/smtt/sdk/j:p	I
    //   5559: aload_0
    //   5560: getfield 76	com/tencent/smtt/sdk/j:B	I
    //   5563: if_icmpge +176 -> 5739
    //   5566: iload_3
    //   5567: sipush 503
    //   5570: if_icmpne +169 -> 5739
    //   5573: lload 9
    //   5575: lstore 15
    //   5577: iload_2
    //   5578: istore 5
    //   5580: lload 9
    //   5582: lstore 13
    //   5584: aload_0
    //   5585: aload_0
    //   5586: getfield 378	com/tencent/smtt/sdk/j:t	Ljava/net/HttpURLConnection;
    //   5589: ldc_w 1116
    //   5592: invokevirtual 1111	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5595: invokestatic 1120	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5598: invokespecial 1060	com/tencent/smtt/sdk/j:a	(J)V
    //   5601: lload 9
    //   5603: lstore 15
    //   5605: iload_2
    //   5606: istore 5
    //   5608: lload 9
    //   5610: lstore 13
    //   5612: aload_0
    //   5613: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   5616: ifeq +74 -> 5690
    //   5619: lload 9
    //   5621: lstore 15
    //   5623: iload_2
    //   5624: istore 5
    //   5626: lload 9
    //   5628: lstore 13
    //   5630: aload_0
    //   5631: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5634: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5637: sipush -309
    //   5640: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5643: iload_2
    //   5644: istore 5
    //   5646: iload_1
    //   5647: ifne -5144 -> 503
    //   5650: aload_0
    //   5651: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5654: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5657: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5660: ldc_w 923
    //   5663: lload 9
    //   5665: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5668: invokeinterface 459 3 0
    //   5673: pop
    //   5674: aload_0
    //   5675: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5678: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5681: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5684: iload_2
    //   5685: istore 5
    //   5687: goto -5184 -> 503
    //   5690: lload 9
    //   5692: lstore 11
    //   5694: iload_1
    //   5695: ifne -5206 -> 489
    //   5698: aload_0
    //   5699: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5702: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5705: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5708: ldc_w 923
    //   5711: lload 9
    //   5713: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5716: invokeinterface 459 3 0
    //   5721: pop
    //   5722: aload_0
    //   5723: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5726: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5729: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5732: lload 9
    //   5734: lstore 11
    //   5736: goto -5247 -> 489
    //   5739: lload 9
    //   5741: lstore 15
    //   5743: iload_2
    //   5744: istore 5
    //   5746: lload 9
    //   5748: lstore 13
    //   5750: aload_0
    //   5751: getfield 259	com/tencent/smtt/sdk/j:p	I
    //   5754: aload_0
    //   5755: getfield 76	com/tencent/smtt/sdk/j:B	I
    //   5758: if_icmpge +185 -> 5943
    //   5761: iload_3
    //   5762: sipush 408
    //   5765: if_icmpeq +24 -> 5789
    //   5768: iload_3
    //   5769: sipush 504
    //   5772: if_icmpeq +17 -> 5789
    //   5775: iload_3
    //   5776: sipush 502
    //   5779: if_icmpeq +10 -> 5789
    //   5782: iload_3
    //   5783: sipush 408
    //   5786: if_icmpne +157 -> 5943
    //   5789: lload 9
    //   5791: lstore 15
    //   5793: iload_2
    //   5794: istore 5
    //   5796: lload 9
    //   5798: lstore 13
    //   5800: aload_0
    //   5801: lconst_0
    //   5802: invokespecial 1060	com/tencent/smtt/sdk/j:a	(J)V
    //   5805: lload 9
    //   5807: lstore 15
    //   5809: iload_2
    //   5810: istore 5
    //   5812: lload 9
    //   5814: lstore 13
    //   5816: aload_0
    //   5817: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   5820: ifeq +74 -> 5894
    //   5823: lload 9
    //   5825: lstore 15
    //   5827: iload_2
    //   5828: istore 5
    //   5830: lload 9
    //   5832: lstore 13
    //   5834: aload_0
    //   5835: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5838: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5841: sipush -309
    //   5844: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5847: iload_2
    //   5848: istore 5
    //   5850: iload_1
    //   5851: ifne -5348 -> 503
    //   5854: aload_0
    //   5855: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5858: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5861: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5864: ldc_w 923
    //   5867: lload 9
    //   5869: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5872: invokeinterface 459 3 0
    //   5877: pop
    //   5878: aload_0
    //   5879: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5882: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5885: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5888: iload_2
    //   5889: istore 5
    //   5891: goto -5388 -> 503
    //   5894: lload 9
    //   5896: lstore 11
    //   5898: iload_1
    //   5899: ifne -5410 -> 489
    //   5902: aload_0
    //   5903: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5906: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5909: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5912: ldc_w 923
    //   5915: lload 9
    //   5917: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5920: invokeinterface 459 3 0
    //   5925: pop
    //   5926: aload_0
    //   5927: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   5930: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5933: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5936: lload 9
    //   5938: lstore 11
    //   5940: goto -5451 -> 489
    //   5943: lload 9
    //   5945: lstore 15
    //   5947: iload_2
    //   5948: istore 5
    //   5950: lload 9
    //   5952: lstore 13
    //   5954: aload_0
    //   5955: invokespecial 970	com/tencent/smtt/sdk/j:j	()J
    //   5958: lconst_0
    //   5959: lcmp
    //   5960: ifgt +93 -> 6053
    //   5963: lload 9
    //   5965: lstore 15
    //   5967: iload_2
    //   5968: istore 5
    //   5970: lload 9
    //   5972: lstore 13
    //   5974: aload_0
    //   5975: getfield 601	com/tencent/smtt/sdk/j:o	Z
    //   5978: ifne +75 -> 6053
    //   5981: iload_3
    //   5982: sipush 410
    //   5985: if_icmpeq +68 -> 6053
    //   5988: lload 9
    //   5990: lstore 15
    //   5992: iload_2
    //   5993: istore 5
    //   5995: lload 9
    //   5997: lstore 13
    //   5999: aload_0
    //   6000: iconst_1
    //   6001: putfield 601	com/tencent/smtt/sdk/j:o	Z
    //   6004: lload 9
    //   6006: lstore 11
    //   6008: iload_1
    //   6009: ifne -5520 -> 489
    //   6012: aload_0
    //   6013: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6016: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6019: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6022: ldc_w 923
    //   6025: lload 9
    //   6027: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6030: invokeinterface 459 3 0
    //   6035: pop
    //   6036: aload_0
    //   6037: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6040: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6043: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6046: lload 9
    //   6048: lstore 11
    //   6050: goto -5561 -> 489
    //   6053: lload 9
    //   6055: lstore 15
    //   6057: iload_2
    //   6058: istore 5
    //   6060: lload 9
    //   6062: lstore 13
    //   6064: aload_0
    //   6065: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6068: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6071: sipush -315
    //   6074: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6077: iload_2
    //   6078: istore 5
    //   6080: iload_1
    //   6081: ifne -5578 -> 503
    //   6084: aload_0
    //   6085: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6088: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6091: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6094: ldc_w 923
    //   6097: lload 9
    //   6099: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6102: invokeinterface 459 3 0
    //   6107: pop
    //   6108: aload_0
    //   6109: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6112: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6115: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6118: iload_2
    //   6119: istore 5
    //   6121: goto -5618 -> 503
    //   6124: lload 15
    //   6126: lstore 13
    //   6128: aload 27
    //   6130: invokevirtual 717	java/lang/Throwable:printStackTrace	()V
    //   6133: lload 15
    //   6135: lstore 13
    //   6137: aload_0
    //   6138: lconst_0
    //   6139: invokespecial 1060	com/tencent/smtt/sdk/j:a	(J)V
    //   6142: lload 15
    //   6144: lstore 13
    //   6146: aload_0
    //   6147: bipush 107
    //   6149: aload_0
    //   6150: aload 27
    //   6152: invokespecial 581	com/tencent/smtt/sdk/j:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6155: iconst_0
    //   6156: invokespecial 583	com/tencent/smtt/sdk/j:a	(ILjava/lang/String;Z)V
    //   6159: lload 15
    //   6161: lstore 13
    //   6163: aload_0
    //   6164: getfield 603	com/tencent/smtt/sdk/j:r	Z
    //   6167: ifeq -3866 -> 2301
    //   6170: lload 15
    //   6172: lstore 13
    //   6174: aload_0
    //   6175: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6178: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6181: sipush -309
    //   6184: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6187: iload 6
    //   6189: istore 5
    //   6191: iload_1
    //   6192: ifne -5689 -> 503
    //   6195: aload_0
    //   6196: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6199: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6202: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6205: ldc_w 923
    //   6208: lload 15
    //   6210: invokestatic 949	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6213: invokeinterface 459 3 0
    //   6218: pop
    //   6219: aload_0
    //   6220: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6223: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6226: invokevirtual 471	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6229: iload 6
    //   6231: istore 5
    //   6233: goto -5730 -> 503
    //   6236: iconst_0
    //   6237: istore_3
    //   6238: goto -5680 -> 558
    //   6241: iconst_2
    //   6242: istore_3
    //   6243: goto -5662 -> 581
    //   6246: aload_0
    //   6247: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6250: iconst_0
    //   6251: invokevirtual 929	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6254: goto -5667 -> 587
    //   6257: aload_0
    //   6258: getfield 88	com/tencent/smtt/sdk/j:g	Landroid/content/Context;
    //   6261: invokestatic 291	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6264: sipush -318
    //   6267: invokevirtual 853	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6270: aload_0
    //   6271: iconst_0
    //   6272: invokespecial 865	com/tencent/smtt/sdk/j:d	(Z)Z
    //   6275: pop
    //   6276: goto -5657 -> 619
    //   6279: aload 27
    //   6281: getfield 295	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6284: ldc_w 1122
    //   6287: iconst_0
    //   6288: invokeinterface 303 3 0
    //   6293: istore_3
    //   6294: aload 27
    //   6296: getfield 445	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6299: astore 28
    //   6301: iload_3
    //   6302: iconst_1
    //   6303: iadd
    //   6304: istore_3
    //   6305: aload 28
    //   6307: ldc_w 1122
    //   6310: iload_3
    //   6311: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6314: invokeinterface 459 3 0
    //   6319: pop
    //   6320: iload_3
    //   6321: aload 27
    //   6323: invokevirtual 1125	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6326: if_icmpne -5659 -> 667
    //   6329: aload_0
    //   6330: getfield 100	com/tencent/smtt/sdk/j:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6333: iconst_2
    //   6334: invokevirtual 983	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6337: goto -5670 -> 667
    //   6340: iconst_0
    //   6341: istore_3
    //   6342: goto -5658 -> 684
    //   6345: astore 27
    //   6347: goto -3870 -> 2477
    //   6350: astore 29
    //   6352: aconst_null
    //   6353: astore 27
    //   6355: aconst_null
    //   6356: astore 28
    //   6358: aconst_null
    //   6359: astore 30
    //   6361: goto -1502 -> 4859
    //   6364: astore 29
    //   6366: aconst_null
    //   6367: astore 27
    //   6369: aconst_null
    //   6370: astore 30
    //   6372: goto -1513 -> 4859
    //   6375: astore 29
    //   6377: aconst_null
    //   6378: astore 30
    //   6380: goto -1521 -> 4859
    //   6383: astore 29
    //   6385: goto -1526 -> 4859
    //   6388: astore 29
    //   6390: iload 6
    //   6392: istore_2
    //   6393: lload 17
    //   6395: lstore 9
    //   6397: goto -1538 -> 4859
    //   6400: astore 29
    //   6402: lload 11
    //   6404: lstore 9
    //   6406: goto -1547 -> 4859
    //   6409: astore 28
    //   6411: iload_2
    //   6412: istore 6
    //   6414: aload 31
    //   6416: astore 30
    //   6418: goto -3001 -> 3417
    //   6421: astore 29
    //   6423: aload 28
    //   6425: astore 30
    //   6427: iload_2
    //   6428: istore 6
    //   6430: aload 29
    //   6432: astore 28
    //   6434: aload 27
    //   6436: astore 29
    //   6438: aload 30
    //   6440: astore 27
    //   6442: aload 31
    //   6444: astore 30
    //   6446: goto -3029 -> 3417
    //   6449: astore 29
    //   6451: aload 28
    //   6453: astore 31
    //   6455: iload_2
    //   6456: istore 6
    //   6458: aload 29
    //   6460: astore 28
    //   6462: aload 27
    //   6464: astore 29
    //   6466: aload 31
    //   6468: astore 27
    //   6470: goto -3053 -> 3417
    //   6473: astore 29
    //   6475: lload 19
    //   6477: lstore 9
    //   6479: aload 28
    //   6481: astore 31
    //   6483: iload 7
    //   6485: istore 6
    //   6487: aload 29
    //   6489: astore 28
    //   6491: aload 27
    //   6493: astore 29
    //   6495: aload 31
    //   6497: astore 27
    //   6499: goto -3082 -> 3417
    //   6502: astore 29
    //   6504: aload 28
    //   6506: astore 31
    //   6508: lload 11
    //   6510: lstore 9
    //   6512: iload_2
    //   6513: istore 6
    //   6515: aload 29
    //   6517: astore 28
    //   6519: aload 27
    //   6521: astore 29
    //   6523: aload 31
    //   6525: astore 27
    //   6527: goto -3110 -> 3417
    //   6530: lload 13
    //   6532: lstore 9
    //   6534: lload 15
    //   6536: lstore 13
    //   6538: goto -2186 -> 4352
    //   6541: aconst_null
    //   6542: astore 27
    //   6544: aconst_null
    //   6545: astore 30
    //   6547: goto -2173 -> 4374
    //   6550: lload 11
    //   6552: lstore 9
    //   6554: goto -5648 -> 906
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6557	0	this	j
    //   0	6557	1	paramBoolean1	boolean
    //   0	6557	2	paramBoolean2	boolean
    //   54	6288	3	i1	int
    //   3604	621	4	i2	int
    //   501	5731	5	bool1	boolean
    //   2202	4312	6	bool2	boolean
    //   3183	3301	7	bool3	boolean
    //   71	5142	8	bool4	boolean
    //   748	5805	9	l1	long
    //   476	6075	11	l2	long
    //   763	5774	13	l3	long
    //   756	5779	15	l4	long
    //   2649	3745	17	l5	long
    //   3187	3289	19	l6	long
    //   3169	1198	21	l7	long
    //   744	3389	23	l8	long
    //   453	3476	25	l9	long
    //   145	1940	27	localObject1	Object
    //   2198	254	27	localThrowable1	Throwable
    //   2475	41	27	localObject2	Object
    //   3055	1834	27	localObject3	Object
    //   4924	1	27	localThrowable2	Throwable
    //   4972	1350	27	str	String
    //   6345	1	27	localObject4	Object
    //   6353	190	27	localObject5	Object
    //   3086	3271	28	localObject6	Object
    //   6409	15	28	localIOException1	IOException
    //   6432	86	28	localIOException2	IOException
    //   3058	1864	29	localObject7	Object
    //   6350	1	29	localObject8	Object
    //   6364	1	29	localObject9	Object
    //   6375	1	29	localObject10	Object
    //   6383	1	29	localObject11	Object
    //   6388	1	29	localObject12	Object
    //   6400	1	29	localObject13	Object
    //   6421	10	29	localIOException3	IOException
    //   6436	1	29	localObject14	Object
    //   6449	10	29	localIOException4	IOException
    //   6464	1	29	localObject15	Object
    //   6473	15	29	localIOException5	IOException
    //   6493	1	29	localObject16	Object
    //   6502	14	29	localIOException6	IOException
    //   6521	1	29	localObject17	Object
    //   3158	3388	30	localObject18	Object
    //   3052	355	31	localObject19	Object
    //   4842	1601	31	localObject20	Object
    //   6453	71	31	localObject21	Object
    //   3400	11	32	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   765	794	2198	java/lang/Throwable
    //   805	813	2198	java/lang/Throwable
    //   824	848	2198	java/lang/Throwable
    //   859	882	2198	java/lang/Throwable
    //   893	903	2198	java/lang/Throwable
    //   1048	1074	2198	java/lang/Throwable
    //   1093	1102	2198	java/lang/Throwable
    //   1113	1121	2198	java/lang/Throwable
    //   1132	1145	2198	java/lang/Throwable
    //   1203	1208	2198	java/lang/Throwable
    //   1219	1226	2198	java/lang/Throwable
    //   1237	1243	2198	java/lang/Throwable
    //   1254	1294	2198	java/lang/Throwable
    //   1305	1317	2198	java/lang/Throwable
    //   1328	1337	2198	java/lang/Throwable
    //   1348	1354	2198	java/lang/Throwable
    //   1365	1371	2198	java/lang/Throwable
    //   1385	1392	2198	java/lang/Throwable
    //   1403	1409	2198	java/lang/Throwable
    //   1420	1446	2198	java/lang/Throwable
    //   1457	1466	2198	java/lang/Throwable
    //   1477	1504	2198	java/lang/Throwable
    //   1515	1552	2198	java/lang/Throwable
    //   1563	1569	2198	java/lang/Throwable
    //   1589	1595	2198	java/lang/Throwable
    //   1606	1614	2198	java/lang/Throwable
    //   1625	1634	2198	java/lang/Throwable
    //   1645	1652	2198	java/lang/Throwable
    //   1663	1671	2198	java/lang/Throwable
    //   1682	1688	2198	java/lang/Throwable
    //   1699	1704	2198	java/lang/Throwable
    //   1715	1723	2198	java/lang/Throwable
    //   1734	1748	2198	java/lang/Throwable
    //   1759	1767	2198	java/lang/Throwable
    //   1778	1803	2198	java/lang/Throwable
    //   1814	1822	2198	java/lang/Throwable
    //   1837	1847	2198	java/lang/Throwable
    //   1858	1869	2198	java/lang/Throwable
    //   1880	1890	2198	java/lang/Throwable
    //   1901	1907	2198	java/lang/Throwable
    //   1918	1922	2198	java/lang/Throwable
    //   1933	1939	2198	java/lang/Throwable
    //   1950	1960	2198	java/lang/Throwable
    //   1971	1980	2198	java/lang/Throwable
    //   1991	1998	2198	java/lang/Throwable
    //   2009	2022	2198	java/lang/Throwable
    //   2080	2086	2198	java/lang/Throwable
    //   2100	2140	2198	java/lang/Throwable
    //   2151	2195	2198	java/lang/Throwable
    //   2389	2397	2198	java/lang/Throwable
    //   2408	2420	2198	java/lang/Throwable
    //   2431	2439	2198	java/lang/Throwable
    //   2450	2456	2198	java/lang/Throwable
    //   2467	2472	2198	java/lang/Throwable
    //   2543	2558	2198	java/lang/Throwable
    //   2569	2597	2198	java/lang/Throwable
    //   2608	2619	2198	java/lang/Throwable
    //   2630	2651	2198	java/lang/Throwable
    //   2669	2679	2198	java/lang/Throwable
    //   2690	2730	2198	java/lang/Throwable
    //   2745	2752	2198	java/lang/Throwable
    //   2763	2769	2198	java/lang/Throwable
    //   2780	2790	2198	java/lang/Throwable
    //   2801	2808	2198	java/lang/Throwable
    //   2819	2826	2198	java/lang/Throwable
    //   2891	2932	2198	java/lang/Throwable
    //   2943	2956	2198	java/lang/Throwable
    //   3014	3024	2198	java/lang/Throwable
    //   3035	3048	2198	java/lang/Throwable
    //   3071	3079	2198	java/lang/Throwable
    //   3265	3271	2198	java/lang/Throwable
    //   3283	3289	2198	java/lang/Throwable
    //   3301	3307	2198	java/lang/Throwable
    //   3475	3481	2198	java/lang/Throwable
    //   3493	3499	2198	java/lang/Throwable
    //   3511	3517	2198	java/lang/Throwable
    //   4601	4607	2198	java/lang/Throwable
    //   4619	4625	2198	java/lang/Throwable
    //   4637	4643	2198	java/lang/Throwable
    //   4729	4735	2198	java/lang/Throwable
    //   4747	4753	2198	java/lang/Throwable
    //   4765	4771	2198	java/lang/Throwable
    //   4962	4974	2198	java/lang/Throwable
    //   4985	4993	2198	java/lang/Throwable
    //   5004	5010	2198	java/lang/Throwable
    //   5021	5031	2198	java/lang/Throwable
    //   5091	5099	2198	java/lang/Throwable
    //   5110	5123	2198	java/lang/Throwable
    //   5181	5192	2198	java/lang/Throwable
    //   5210	5220	2198	java/lang/Throwable
    //   5233	5246	2198	java/lang/Throwable
    //   5304	5310	2198	java/lang/Throwable
    //   5321	5334	2198	java/lang/Throwable
    //   5406	5417	2198	java/lang/Throwable
    //   5428	5441	2198	java/lang/Throwable
    //   5555	5566	2198	java/lang/Throwable
    //   5584	5601	2198	java/lang/Throwable
    //   5612	5619	2198	java/lang/Throwable
    //   5630	5643	2198	java/lang/Throwable
    //   5750	5761	2198	java/lang/Throwable
    //   5800	5805	2198	java/lang/Throwable
    //   5816	5823	2198	java/lang/Throwable
    //   5834	5847	2198	java/lang/Throwable
    //   5954	5963	2198	java/lang/Throwable
    //   5974	5981	2198	java/lang/Throwable
    //   5999	6004	2198	java/lang/Throwable
    //   6064	6077	2198	java/lang/Throwable
    //   765	794	2475	finally
    //   805	813	2475	finally
    //   824	848	2475	finally
    //   859	882	2475	finally
    //   893	903	2475	finally
    //   1048	1074	2475	finally
    //   1093	1102	2475	finally
    //   1113	1121	2475	finally
    //   1132	1145	2475	finally
    //   1203	1208	2475	finally
    //   1219	1226	2475	finally
    //   1237	1243	2475	finally
    //   1254	1294	2475	finally
    //   1305	1317	2475	finally
    //   1328	1337	2475	finally
    //   1348	1354	2475	finally
    //   1365	1371	2475	finally
    //   1385	1392	2475	finally
    //   1403	1409	2475	finally
    //   1420	1446	2475	finally
    //   1457	1466	2475	finally
    //   1477	1504	2475	finally
    //   1515	1552	2475	finally
    //   1563	1569	2475	finally
    //   1589	1595	2475	finally
    //   1606	1614	2475	finally
    //   1625	1634	2475	finally
    //   1645	1652	2475	finally
    //   1663	1671	2475	finally
    //   1682	1688	2475	finally
    //   1699	1704	2475	finally
    //   1715	1723	2475	finally
    //   1734	1748	2475	finally
    //   1759	1767	2475	finally
    //   1778	1803	2475	finally
    //   1814	1822	2475	finally
    //   1837	1847	2475	finally
    //   1858	1869	2475	finally
    //   1880	1890	2475	finally
    //   1901	1907	2475	finally
    //   1918	1922	2475	finally
    //   1933	1939	2475	finally
    //   1950	1960	2475	finally
    //   1971	1980	2475	finally
    //   1991	1998	2475	finally
    //   2009	2022	2475	finally
    //   2080	2086	2475	finally
    //   2100	2140	2475	finally
    //   2151	2195	2475	finally
    //   2208	2216	2475	finally
    //   2224	2231	2475	finally
    //   2235	2243	2475	finally
    //   2247	2289	2475	finally
    //   2293	2301	2475	finally
    //   2305	2318	2475	finally
    //   2389	2397	2475	finally
    //   2408	2420	2475	finally
    //   2431	2439	2475	finally
    //   2450	2456	2475	finally
    //   2467	2472	2475	finally
    //   2543	2558	2475	finally
    //   2569	2597	2475	finally
    //   2608	2619	2475	finally
    //   2630	2651	2475	finally
    //   2669	2679	2475	finally
    //   2690	2730	2475	finally
    //   2745	2752	2475	finally
    //   2763	2769	2475	finally
    //   2780	2790	2475	finally
    //   2801	2808	2475	finally
    //   2819	2826	2475	finally
    //   2891	2932	2475	finally
    //   2943	2956	2475	finally
    //   3014	3024	2475	finally
    //   3035	3048	2475	finally
    //   3071	3079	2475	finally
    //   3265	3271	2475	finally
    //   3283	3289	2475	finally
    //   3301	3307	2475	finally
    //   3475	3481	2475	finally
    //   3493	3499	2475	finally
    //   3511	3517	2475	finally
    //   4601	4607	2475	finally
    //   4619	4625	2475	finally
    //   4637	4643	2475	finally
    //   4729	4735	2475	finally
    //   4747	4753	2475	finally
    //   4765	4771	2475	finally
    //   4962	4974	2475	finally
    //   4985	4993	2475	finally
    //   5004	5010	2475	finally
    //   5021	5031	2475	finally
    //   5091	5099	2475	finally
    //   5110	5123	2475	finally
    //   5181	5192	2475	finally
    //   5210	5220	2475	finally
    //   5233	5246	2475	finally
    //   5304	5310	2475	finally
    //   5321	5334	2475	finally
    //   5406	5417	2475	finally
    //   5428	5441	2475	finally
    //   5555	5566	2475	finally
    //   5584	5601	2475	finally
    //   5612	5619	2475	finally
    //   5630	5643	2475	finally
    //   5750	5761	2475	finally
    //   5800	5805	2475	finally
    //   5816	5823	2475	finally
    //   5834	5847	2475	finally
    //   5954	5963	2475	finally
    //   5974	5981	2475	finally
    //   5999	6004	2475	finally
    //   6064	6077	2475	finally
    //   6128	6133	2475	finally
    //   6137	6142	2475	finally
    //   6146	6159	2475	finally
    //   6163	6170	2475	finally
    //   6174	6187	2475	finally
    //   3093	3102	3400	java/io/IOException
    //   3107	3129	3400	java/io/IOException
    //   3367	3397	3400	java/io/IOException
    //   3417	3438	4842	finally
    //   3438	3463	4842	finally
    //   4518	4589	4842	finally
    //   4692	4717	4842	finally
    //   4826	4839	4842	finally
    //   917	927	4924	java/lang/Throwable
    //   938	947	4924	java/lang/Throwable
    //   958	966	4924	java/lang/Throwable
    //   977	990	4924	java/lang/Throwable
    //   4385	4391	4924	java/lang/Throwable
    //   4402	4408	4924	java/lang/Throwable
    //   4419	4425	4924	java/lang/Throwable
    //   4436	4443	4924	java/lang/Throwable
    //   4454	4467	4924	java/lang/Throwable
    //   4870	4876	4924	java/lang/Throwable
    //   4887	4893	4924	java/lang/Throwable
    //   4904	4910	4924	java/lang/Throwable
    //   4921	4924	4924	java/lang/Throwable
    //   917	927	6345	finally
    //   938	947	6345	finally
    //   958	966	6345	finally
    //   977	990	6345	finally
    //   4385	4391	6345	finally
    //   4402	4408	6345	finally
    //   4419	4425	6345	finally
    //   4436	4443	6345	finally
    //   4454	4467	6345	finally
    //   4870	4876	6345	finally
    //   4887	4893	6345	finally
    //   4904	4910	6345	finally
    //   4921	4924	6345	finally
    //   3079	3088	6350	finally
    //   3093	3102	6364	finally
    //   3107	3129	6364	finally
    //   3367	3397	6364	finally
    //   3129	3160	6375	finally
    //   3160	3165	6383	finally
    //   3189	3196	6388	finally
    //   3210	3219	6388	finally
    //   3233	3246	6388	finally
    //   3593	3606	6388	finally
    //   3625	3632	6388	finally
    //   3646	3656	6388	finally
    //   3674	3682	6388	finally
    //   3704	3709	6388	finally
    //   3729	3734	6388	finally
    //   3751	3758	6388	finally
    //   3777	3790	6388	finally
    //   3811	3821	6388	finally
    //   3835	3840	6388	finally
    //   3878	3887	6388	finally
    //   3901	3940	6388	finally
    //   3954	3967	6388	finally
    //   3991	4001	6388	finally
    //   4015	4024	6388	finally
    //   4038	4086	6388	finally
    //   4100	4113	6388	finally
    //   4124	4139	6400	finally
    //   4159	4231	6400	finally
    //   4255	4286	6400	finally
    //   4286	4312	6400	finally
    //   4312	4334	6400	finally
    //   3079	3088	6409	java/io/IOException
    //   3129	3160	6421	java/io/IOException
    //   3160	3165	6449	java/io/IOException
    //   3189	3196	6473	java/io/IOException
    //   3210	3219	6473	java/io/IOException
    //   3233	3246	6473	java/io/IOException
    //   3593	3606	6473	java/io/IOException
    //   3625	3632	6473	java/io/IOException
    //   3646	3656	6473	java/io/IOException
    //   3674	3682	6473	java/io/IOException
    //   3704	3709	6473	java/io/IOException
    //   3729	3734	6473	java/io/IOException
    //   3751	3758	6473	java/io/IOException
    //   3777	3790	6473	java/io/IOException
    //   3811	3821	6473	java/io/IOException
    //   3835	3840	6473	java/io/IOException
    //   3878	3887	6473	java/io/IOException
    //   3901	3940	6473	java/io/IOException
    //   3954	3967	6473	java/io/IOException
    //   3991	4001	6473	java/io/IOException
    //   4015	4024	6473	java/io/IOException
    //   4038	4086	6473	java/io/IOException
    //   4100	4113	6473	java/io/IOException
    //   4124	4139	6502	java/io/IOException
    //   4159	4231	6502	java/io/IOException
    //   4255	4286	6502	java/io/IOException
    //   4286	4312	6502	java/io/IOException
    //   4312	4334	6502	java/io/IOException
  }
  
  public void c()
  {
    b();
    d(false);
    d(true);
  }
  
  public boolean d()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
    return this.C;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.j
 * JD-Core Version:    0.7.0.1
 */