package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class ChannelProxyImpl$13
  implements Runnable
{
  ChannelProxyImpl$13(ChannelProxyImpl paramChannelProxyImpl, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      QMLog.i("ChannelProxyImpl", "activity is null or finishing");
    }
    Bundle localBundle;
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ChannelProxyImpl", 2, "syncForceGroundAndRefreshBadge--miniConfig error");
      return;
      localBundle = new Bundle();
      localBundle.putString("miniAppID", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("param_proc_name", this.b);
      localBundle.putString("param_proc_modulename", "mini_sdk_client_module");
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppBrandUI))
      {
        if (QMLog.isColorLevel()) {
          QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
        }
        ((AppBrandUI)this.jdField_a_of_type_AndroidAppActivity).onProcessForeGround(localBundle);
        if (QMLog.isColorLevel()) {
          QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
        }
        ((AppBrandUI)this.jdField_a_of_type_AndroidAppActivity).onRefreshMiniBadge(localBundle);
        return;
      }
    } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof GameActivity1));
    if (QMLog.isColorLevel()) {
      QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
    }
    ((GameActivity1)this.jdField_a_of_type_AndroidAppActivity).onProcessForeGround(localBundle);
    if (QMLog.isColorLevel()) {
      QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
    }
    ((GameActivity1)this.jdField_a_of_type_AndroidAppActivity).onRefreshMiniBadge(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.13
 * JD-Core Version:    0.7.0.1
 */