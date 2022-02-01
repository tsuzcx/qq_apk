package com.tencent.qqconnect.wtlogin;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

@RoutePage(desc="互联输入短信验证码页面", path="/base/login/authDevVerifyCodeOpenSdk")
public class AuthDevVerifyCodeActivity2
  extends AuthDevVerifyCodeActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected AppRuntime getReportRuntime()
  {
    return null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */