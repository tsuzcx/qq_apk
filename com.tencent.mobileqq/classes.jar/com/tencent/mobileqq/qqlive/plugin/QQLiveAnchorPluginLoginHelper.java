package com.tencent.mobileqq.qqlive.plugin;

import com.tencent.mobileqq.qqlive.biz.sdk.QQLiveSDKHelper;
import com.tencent.qphone.base.util.QLog;

public class QQLiveAnchorPluginLoginHelper
{
  private static final String TAG = "QQLiveAnchor_PluginLogin";
  
  public static void tryLoginMiniSDK()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_PluginLogin", 1, "tryLogin");
    }
    try
    {
      QQLiveSDKHelper.a(QQLiveSDKHelper.a(null), new QQLiveAnchorPluginLoginHelper.1());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLiveAnchor_PluginLogin", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.plugin.QQLiveAnchorPluginLoginHelper
 * JD-Core Version:    0.7.0.1
 */