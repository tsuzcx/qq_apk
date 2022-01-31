import UserGrowth.downloadConfig;
import UserGrowth.stGlobalConfig;
import UserGrowth.stLinkConfig;
import android.text.TextUtils;
import cooperation.qzone.LocalMultiProcConfig;

public class skb
{
  private stGlobalConfig a;
  
  public static skb a()
  {
    return skd.a();
  }
  
  private boolean f()
  {
    return (this.a == null) || (this.a.linkConfig == null);
  }
  
  private boolean g()
  {
    return (this.a == null) || (this.a.download == null);
  }
  
  public int a()
  {
    if (this.a != null) {
      return this.a.link_strategy_type;
    }
    return 1;
  }
  
  public stGlobalConfig a()
  {
    return this.a;
  }
  
  public String a()
  {
    if (!g()) {
      return this.a.download.packageName;
    }
    return "";
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    this.a = paramstGlobalConfig;
    sne.d("WSGlobalConfigLog", "initGlobalConfig globalConfig:" + paramstGlobalConfig);
  }
  
  public boolean a()
  {
    return (this.a == null) || (this.a.open_4g_autodownload != 0);
  }
  
  public int b()
  {
    if (!f()) {
      return this.a.linkConfig.callCount;
    }
    return 10000;
  }
  
  public String b()
  {
    if (!g()) {
      return this.a.download.downloadUrl;
    }
    return "";
  }
  
  public boolean b()
  {
    if (!f()) {
      return this.a.linkConfig.isOpenVideoPage;
    }
    return true;
  }
  
  public int c()
  {
    if (!f()) {
      return this.a.linkConfig.downloadCount;
    }
    return 10000;
  }
  
  public String c()
  {
    if (!g()) {
      return this.a.download.preloadDownloadUrl;
    }
    return "";
  }
  
  public boolean c()
  {
    return (!g()) && (this.a.download.preload);
  }
  
  public int d()
  {
    if (!g()) {
      return this.a.download.vendorId;
    }
    return 0;
  }
  
  public String d()
  {
    if (!g())
    {
      if (TextUtils.isEmpty(this.a.download.qqDownloadUrl))
      {
        this.a.download.qqDownloadUrl = (skq.a() + "&versioncode=" + e());
        sne.c("WeishiDownloadUtil", "服务器下发QQDownloadUrl失败，使用默认的:" + this.a.download.qqDownloadUrl);
      }
      sne.d("WeishiDownloadUtil", "服务器下发QQDownloadUrl: " + this.a.download.qqDownloadUrl);
      return this.a.download.qqDownloadUrl;
    }
    return skq.a();
  }
  
  public boolean d()
  {
    return (!g()) && (this.a.download.appStoreSwitch);
  }
  
  public int e()
  {
    if (!g()) {
      return this.a.download.versionCode;
    }
    return 0;
  }
  
  public String e()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.encrypted_deviceid)))
    {
      LocalMultiProcConfig.putString("weishi_usergrowth", "encryptedDeviceId", this.a.encrypted_deviceid);
      str = this.a.encrypted_deviceid;
      sne.a("WSGlobalConfigLog", "LocalMultiProcConfig save encrypted_deviceid:" + str);
      return str;
    }
    String str = LocalMultiProcConfig.getString("weishi_usergrowth", "encryptedDeviceId", "");
    sne.a("WSGlobalConfigLog", "LocalMultiProcConfig load encrypted_deviceid:" + str);
    return str;
  }
  
  public boolean e()
  {
    return (!g()) && (this.a.download.enableRock);
  }
  
  public int f()
  {
    if (this.a != null) {
      return this.a.cache_size;
    }
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skb
 * JD-Core Version:    0.7.0.1
 */