package cooperation.ilive.plugin;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThreeDes;
import common.config.service.QzoneConfig;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.util.ElapseStat;
import cooperation.qzone.LocalMultiProcConfig;

public class IlivePluginManager
{
  public static final long ILIVE_PLUGIN_TOKEN_AUTH_EXPIRATION_DATE = 2073600L;
  public static final String KEY_ILIVE_PLUGIN_TOKEN = "key_ilive_plugin_token";
  public static final String KEY_LIVE_PLUGIN_TOKEN_VALID_TIME = "key_ilive_plugin_token_valid_time";
  private static final String TAG = "IliveAuthPluginManager";
  private static IlivePluginManager sInstance;
  public static boolean sIsFastStart = false;
  private IlivePluginCallback mPluginCallback;
  private String mTempToken;
  
  private long getAuthExpirationDate()
  {
    long l = QzoneConfig.getInstance().getConfig("qqLive", "pluginTokenAuthTime", 2073600L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAuthExpirationDate time = ");
    localStringBuilder.append(l);
    QLog.i("IliveAuthPluginManager", 1, localStringBuilder.toString());
    return l;
  }
  
  public static IlivePluginManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new IlivePluginManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private boolean isPluginIliveTokenExpireOut()
  {
    long l1 = getPluginTokenValidTime(0L);
    long l2 = System.currentTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPluginIliveTokenExpireOut , consume s = ");
    l1 = l2 - l1;
    localStringBuilder.append(l1);
    QLog.i("IliveAuthPluginManager", 1, localStringBuilder.toString());
    if (l1 > getAuthExpirationDate())
    {
      QLog.e("IliveAuthPluginManager", 1, "isPluginIliveTokenExpireOut = true , reAuth");
      return true;
    }
    return false;
  }
  
  public String getLiveToken()
  {
    QLog.e("IliveAuthPluginManager", 1, "getLiveToken");
    if (isPluginIliveTokenExpireOut()) {
      return "";
    }
    if (TextUtils.isEmpty(this.mTempToken)) {
      this.mTempToken = ThreeDes.b(LocalMultiProcConfig.getString4Uin("key_ilive_plugin_token", "", IliveAuthManager.getLongUin()), IliveAuthManager.getStringUin());
    }
    return this.mTempToken;
  }
  
  public IlivePluginCallback getPluginCallback()
  {
    return this.mPluginCallback;
  }
  
  public long getPluginTokenValidTime(long paramLong)
  {
    return LocalMultiProcConfig.getLong4Uin("key_ilive_plugin_token_valid_time", paramLong, IliveAuthManager.getLongUin());
  }
  
  public void onDestory()
  {
    this.mPluginCallback = null;
  }
  
  public void refreshToken(int paramInt)
  {
    ElapseStat.a("refreshToken");
    if (isPluginIliveTokenExpireOut())
    {
      LiveAuth.getStAuth(paramInt);
      return;
    }
    sIsFastStart = true;
  }
  
  public void savePluginToken(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("savePluginToken openId = ");
      localStringBuilder.append(paramString);
      QLog.i("IliveAuthPluginManager", 2, localStringBuilder.toString());
    }
    this.mTempToken = paramString;
    LocalMultiProcConfig.putString4Uin("key_ilive_plugin_token", ThreeDes.a(paramString, IliveAuthManager.getStringUin()), IliveAuthManager.getLongUin());
  }
  
  public void savePluginTokenValidTime(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("savePluginTokenValidTime expireTime = ");
      localStringBuilder.append(paramLong / 1000L);
      QLog.i("IliveAuthPluginManager", 2, localStringBuilder.toString());
    }
    LocalMultiProcConfig.putLong4Uin("key_ilive_plugin_token_valid_time", paramLong / 1000L, IliveAuthManager.getLongUin());
  }
  
  public void setIlivePluginCallback(IlivePluginCallback paramIlivePluginCallback)
  {
    this.mPluginCallback = paramIlivePluginCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.plugin.IlivePluginManager
 * JD-Core Version:    0.7.0.1
 */