package com.tencent.mobileqq.weather.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqcommon.api.ILocalManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.weather.WeatherServlet;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.mobileqq.weather.api.listener.WeatherUpdateListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;

public class WeatherRuntimeServiceImpl
  implements IWeatherRuntimeService, BusinessObserver
{
  private static final String KEY_WEATHER_RES_VERSION = "key_weather_res_version";
  public static final String MINI_APP_WEATHER_URL = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2066&_sig=191577ab932c397857a3cb26aa1938bfa257d305ad390c43ae02ca77df0753e7";
  public static final String TAG = "weatherManager";
  private static final String WEATHER_RESOURCES_SP = "weather_resources";
  public static String WEATHER_RESOURCE_PATH;
  private boolean hasUpdate = false;
  private AppInterface mApp;
  private SharedPreferences mGlobalSp;
  private WeatherUpdateListener mWeatherUpdateListener;
  
  private long getLastSuccessTime()
  {
    return MobileQQ.getContext().getSharedPreferences("public_account_weather", 0).getLong("drawer_last_success_time", 0L);
  }
  
  public static String getWeatherResource(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(WEATHER_RESOURCE_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("WeatherResource");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append("_bg.jpg");
    return localStringBuilder.toString();
  }
  
  public static boolean isWeatherResourceExist(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isWeatherResourceExist jpgfilepath: ");
      localStringBuilder.append(getWeatherResource(paramString));
      QLog.d("qq_weather", 2, localStringBuilder.toString());
    }
    return FileUtils.fileExistsAndNotEmpty(getWeatherResource(paramString));
  }
  
  public long getConfigVersion()
  {
    long l = this.mGlobalSp.getLong("key_weather_res_version", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigVersion version=");
      localStringBuilder.append(l);
      QLog.d("weatherManager", 2, localStringBuilder.toString());
    }
    return l;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    BaseApplication localBaseApplication = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localBaseApplication.getFilesDir().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("WeatherResource");
    WEATHER_RESOURCE_PATH = localStringBuilder.toString();
    this.mGlobalSp = localBaseApplication.getApplicationContext().getSharedPreferences("weather_resources", 0);
    paramAppRuntime.registObserver(this);
  }
  
  public void onDestroy()
  {
    this.mApp.unRegistObserver(this);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WeatherManager onReceive type:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("weatherManager", 2, new Object[] { ((StringBuilder)localObject1).toString(), ",bundle:", paramBundle });
    }
    if ((paramInt != 6666) && (paramInt != 8888)) {
      return;
    }
    if (paramBoolean)
    {
      localObject1 = paramBundle.getString("KEY_TEMPER");
      String str1 = paramBundle.getString("area_info");
      int i = paramBundle.getInt("adcode");
      String str2 = paramBundle.getString("o_wea_code");
      String str3 = paramBundle.getString("wea_desc");
      int j = paramBundle.getInt("show_flag");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onReceive show_flag:");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(",temp:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",area_name");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append("adcode");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",o_wea_code");
        ((StringBuilder)localObject2).append(str2);
        QLog.d("WeatherSetting", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = MobileQQ.getContext().getSharedPreferences("public_account_weather", 0).edit();
      if (j == 1)
      {
        if ((localObject1 != null) && (!((String)localObject1).equals("")) && (!TextUtils.isEmpty(str1)))
        {
          Long localLong = Long.valueOf(System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject2).putLong("pa_send_time", localLong.longValue());
          ((SharedPreferences.Editor)localObject2).putString("cur_temp", (String)localObject1);
          ((SharedPreferences.Editor)localObject2).putString("cur_code", str2);
          ((SharedPreferences.Editor)localObject2).putString("cur_city", str1);
          ((SharedPreferences.Editor)localObject2).putInt("cur_adcode", i);
          ((SharedPreferences.Editor)localObject2).putBoolean("show_flag", true);
          ((SharedPreferences.Editor)localObject2).putLong("drawer_last_success_time", localLong.longValue());
          ((SharedPreferences.Editor)localObject2).putString("drawer_cur_city", str1);
          ((SharedPreferences.Editor)localObject2).putString("drawer_cur_temp", (String)localObject1);
          ((SharedPreferences.Editor)localObject2).putInt("drawer_cur_adcode", i);
          ((SharedPreferences.Editor)localObject2).putString("drawer_cur_code", str2);
          ((SharedPreferences.Editor)localObject2).putString("drawer_cur_desc", str3);
          ((SharedPreferences.Editor)localObject2).putBoolean("drawer_show_flag", true);
        }
      }
      else if (j == 0) {
        ((SharedPreferences.Editor)localObject2).putBoolean("show_flag", false);
      }
      ((SharedPreferences.Editor)localObject2).commit();
    }
    Object localObject1 = this.mWeatherUpdateListener;
    if (localObject1 != null) {
      ((WeatherUpdateListener)localObject1).a(paramInt, paramBoolean, paramBundle);
    }
  }
  
  public void setWeatherUpdateListener(WeatherUpdateListener paramWeatherUpdateListener)
  {
    this.mWeatherUpdateListener = paramWeatherUpdateListener;
  }
  
  public boolean unzipResource(long paramLong, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      FileUtils.delete(WEATHER_RESOURCE_PATH, false);
      FileUtils.uncompressZip(paramString, WEATHER_RESOURCE_PATH, false);
      bool1 = true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("weatherManager", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        bool1 = bool2;
      }
    }
    if (bool1)
    {
      updateResourceVersion(paramLong);
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    return bool1;
  }
  
  public void updateResourceVersion(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateResourceVersion version=");
      localStringBuilder.append(paramLong);
      QLog.d("weatherManager", 2, localStringBuilder.toString());
    }
    this.mGlobalSp.edit().putLong("key_weather_res_version", paramLong).commit();
  }
  
  public void updateWeatherInfo(AppActivity paramAppActivity)
  {
    if ((((ILocalManagerApi)QRoute.api(ILocalManagerApi.class)).isLocaleUpdatedByUser()) && (!this.hasUpdate))
    {
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 2, "updateWeatherInfo  from  LocaleManager.isLocaleUpdatedByUser()");
      }
      this.hasUpdate = true;
      WeatherServlet.a(this.mApp, paramAppActivity);
      return;
    }
    long l = getLastSuccessTime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateWeatherInfo successTime:");
      localStringBuilder.append(l);
      localStringBuilder.append(",currentTime:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("weatherManager", 2, localStringBuilder.toString());
    }
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L) {
      WeatherServlet.a(this.mApp, paramAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.impl.WeatherRuntimeServiceImpl
 * JD-Core Version:    0.7.0.1
 */