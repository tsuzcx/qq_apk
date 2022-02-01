package com.tencent.mobileqq.mini.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mini.fake.FakeSdkReceiver;
import com.tencent.mobileqq.mini.fake.IFakeReceiver;
import com.tencent.qphone.base.util.QLog;

public class AppBrandTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_BASELIB_UPDATED = "mini_baselib_updated";
  public static final String ACTION_KILL = "mini_process_kill";
  public static final String ACTION_PRELOAD_INTERNAL_APP = "mini_preload_internal_app";
  public static final String ACTION_UPDATE_PERIODIC_CACHE = "mini_periodic_cache_update";
  public static final String INTENT_KEY_RETCODE = "key_retcode";
  protected IFakeReceiver mFakeReceiver;
  
  public IFakeReceiver getFakeBrandUI()
  {
    IFakeReceiver localIFakeReceiver = this.mFakeReceiver;
    if (localIFakeReceiver != null) {
      return localIFakeReceiver;
    }
    this.mFakeReceiver = new FakeSdkReceiver();
    return this.mFakeReceiver;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandTaskPreloadReceiver onReceive action: ");
    localStringBuilder.append(str);
    QLog.i("minisdk-start", 1, localStringBuilder.toString());
    getFakeBrandUI().onReceive(paramContext, paramIntent);
    if (((this instanceof AppBrandTaskPreloadReceiver3)) || ((this instanceof AppBrandTaskPreloadReceiver4)) || ((this instanceof AppBrandTaskPreloadReceiver5))) {
      paramContext.getSharedPreferences("sdk_conf", 4).edit().putInt("usersdk", 0).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */