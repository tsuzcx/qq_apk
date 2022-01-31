import UserGrowth.downloadConfig;
import UserGrowth.stGlobalConfig;
import UserGrowth.stLinkConfig;
import android.text.TextUtils;
import com.google.gson.Gson;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class tee
{
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static tee a()
  {
    return teg.a();
  }
  
  private void b(stGlobalConfig paramstGlobalConfig)
  {
    if (paramstGlobalConfig == null) {
      return;
    }
    tlo.d("WSGlobalConfigLog", "globalConfig info:stGlobalConfig: {\nis_call_weishi=" + paramstGlobalConfig.is_call_weishi + ", link_strategy_type=" + paramstGlobalConfig.link_strategy_type + ", open_4g_autodownload=" + paramstGlobalConfig.open_4g_autodownload + ", cache_size=" + paramstGlobalConfig.cache_size + ", is_direct_open=" + paramstGlobalConfig.is_direct_open + ", encrypted_deviceid=" + paramstGlobalConfig.encrypted_deviceid + "\nlinkConfig=" + paramstGlobalConfig.linkConfig + "\ndownload=" + paramstGlobalConfig.download + "\nmapExt=" + paramstGlobalConfig.mapExt + "\n}");
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig == null);
  }
  
  private boolean h()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.download == null);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public stGlobalConfig a()
  {
    return this.jdField_a_of_type_UserGrowthStGlobalConfig;
  }
  
  public String a()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.packageName;
    }
    return "";
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
    tlo.d("WSGlobalConfigLog", "initGlobalConfig globalConfig:" + paramstGlobalConfig);
    b(paramstGlobalConfig);
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new Gson().toJson(paramMap));
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig != null) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.mapExt != null) && (TextUtils.equals((CharSequence)this.jdField_a_of_type_UserGrowthStGlobalConfig.mapExt.get("share_style"), String.valueOf(1)));
  }
  
  public int b()
  {
    if (!g()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig.callCount;
    }
    return 10000;
  }
  
  public String b()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.downloadUrl;
    }
    return "";
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.open_4g_autodownload != 0);
  }
  
  public int c()
  {
    if (!g()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig.downloadCount;
    }
    return 10000;
  }
  
  public String c()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.preloadDownloadUrl;
    }
    return "";
  }
  
  public boolean c()
  {
    if (!g()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig.isOpenVideoPage;
    }
    return true;
  }
  
  public int d()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.vendorId;
    }
    return 0;
  }
  
  public String d()
  {
    if (!h())
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl))
      {
        this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl = (tfa.a() + "&versioncode=" + e());
        tlo.c("WeishiDownloadUtil", "服务器下发QQDownloadUrl失败，使用默认的:" + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      }
      tlo.d("WeishiDownloadUtil", "服务器下发QQDownloadUrl: " + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl;
    }
    return tfa.a();
  }
  
  public boolean d()
  {
    return (!h()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.preload);
  }
  
  public int e()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.versionCode;
    }
    return 0;
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_UserGrowthStGlobalConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStGlobalConfig.encrypted_deviceid)))
    {
      LocalMultiProcConfig.putString("weishi_usergrowth", "encryptedDeviceId", this.jdField_a_of_type_UserGrowthStGlobalConfig.encrypted_deviceid);
      str = this.jdField_a_of_type_UserGrowthStGlobalConfig.encrypted_deviceid;
      tlo.a("WSGlobalConfigLog", "LocalMultiProcConfig save encrypted_deviceid:" + str);
      return str;
    }
    String str = LocalMultiProcConfig.getString("weishi_usergrowth", "encryptedDeviceId", "");
    tlo.a("WSGlobalConfigLog", "LocalMultiProcConfig load encrypted_deviceid:" + str);
    return str;
  }
  
  public boolean e()
  {
    return (!h()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.appStoreSwitch);
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.cache_size;
    }
    return 14;
  }
  
  public boolean f()
  {
    return (!h()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.enableRock);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tee
 * JD-Core Version:    0.7.0.1
 */