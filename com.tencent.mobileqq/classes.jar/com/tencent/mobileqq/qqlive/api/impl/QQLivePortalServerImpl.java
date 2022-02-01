package com.tencent.mobileqq.qqlive.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqlive.api.IQQLivePortalServer;

public class QQLivePortalServerImpl
  implements IQQLivePortalServer
{
  public static final String PORTAL_URL = "https://h5.qzone.qq.com/v2/vip/live/portal/";
  
  public void goToPortal(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", "https://h5.qzone.qq.com/v2/vip/live/portal/");
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLivePortalServerImpl
 * JD-Core Version:    0.7.0.1
 */