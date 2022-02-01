package com.tencent.mobileqq.qqlive.prepare;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService;
import com.tencent.mobileqq.qqlive.biz.sdk.QQLiveSDKHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PrepareDataRepository
  extends BaseRepository
{
  SharedPreferences a;
  private final IQQLiveSDK b = QQLiveSDKHelper.a(null);
  
  public PrepareDataRepository()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQLivePrepare");
    ((StringBuilder)localObject).append(localAppRuntime.getCurrentUin());
    localObject = ((StringBuilder)localObject).toString();
    this.a = localAppRuntime.getApplicationContext().getSharedPreferences((String)localObject, 0);
  }
  
  public LocationData a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((SharedPreferences)localObject).getLong("location_interval", 0L) >= 3600000L)
      {
        QLog.d("PrepareDataRepository", 1, "the location is expired");
        return null;
      }
      if (TextUtils.isEmpty(this.a.getString("city", "")))
      {
        QLog.d("PrepareDataRepository", 1, "");
        return null;
      }
      localObject = new LocationData();
      ((LocationData)localObject).a = this.a.getBoolean("isShow", true);
      ((LocationData)localObject).d = this.a.getString("locationAT", "");
      ((LocationData)localObject).b = this.a.getString("city", "");
      ((LocationData)localObject).c = this.a.getString("locationNG", "");
      return localObject;
    }
    QLog.d("PrepareDataRepository", 1, "sp is null");
    return null;
  }
  
  public void a(GameListCallback paramGameListCallback)
  {
    IQQLiveSDK localIQQLiveSDK = this.b;
    if (localIQQLiveSDK != null) {
      localIQQLiveSDK.getGameListService().getGameList(new PrepareDataRepository.1(this, paramGameListCallback));
    }
  }
  
  public void a(LocationData paramLocationData)
  {
    if (paramLocationData != null) {
      this.a.edit().putLong("location_interval", SystemClock.currentThreadTimeMillis()).putString("city", paramLocationData.b).putBoolean("isShow", paramLocationData.a).putString("locationNG", paramLocationData.c).putString("locationAT", paramLocationData.d).apply();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("protocol_check", paramBoolean).apply();
    }
  }
  
  public boolean c()
  {
    SharedPreferences localSharedPreferences = this.a;
    boolean bool = false;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("protocol_check", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.PrepareDataRepository
 * JD-Core Version:    0.7.0.1
 */