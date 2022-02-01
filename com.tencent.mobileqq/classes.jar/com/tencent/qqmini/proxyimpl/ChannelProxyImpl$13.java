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
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("miniAppID", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putString("param_proc_name", this.b);
        ((Bundle)localObject).putString("param_proc_modulename", "mini_sdk_client_module");
        Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
        if ((localActivity instanceof AppBrandUI))
        {
          if (QMLog.isColorLevel()) {
            QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
          }
          ((AppBrandUI)this.jdField_a_of_type_AndroidAppActivity).onProcessForeGround((Bundle)localObject);
          if (QMLog.isColorLevel()) {
            QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
          }
          ((AppBrandUI)this.jdField_a_of_type_AndroidAppActivity).onRefreshMiniBadge((Bundle)localObject);
          return;
        }
        if ((localActivity instanceof GameActivity1))
        {
          if (QMLog.isColorLevel()) {
            QMLog.d("ChannelProxyImpl", "onStart--onProcessForeGround");
          }
          ((GameActivity1)this.jdField_a_of_type_AndroidAppActivity).onProcessForeGround((Bundle)localObject);
          if (QMLog.isColorLevel()) {
            QMLog.d("ChannelProxyImpl", "onResume--onRefreshMiniBadge");
          }
          ((GameActivity1)this.jdField_a_of_type_AndroidAppActivity).onRefreshMiniBadge((Bundle)localObject);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ChannelProxyImpl", 2, "syncForceGroundAndRefreshBadge--miniConfig error");
      }
      return;
    }
    QMLog.i("ChannelProxyImpl", "activity is null or finishing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.13
 * JD-Core Version:    0.7.0.1
 */