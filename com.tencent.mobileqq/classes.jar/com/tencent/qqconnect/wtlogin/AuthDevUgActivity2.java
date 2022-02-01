package com.tencent.qqconnect.wtlogin;

import Override;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AuthDevUgActivity2
  extends AuthDevUgActivity
{
  public void a()
  {
    QLog.d("Q.devlock.AuthDevUgActivity2", 1, "opensdk beforeOpenBrowser do nothing");
  }
  
  public void b()
  {
    QLog.d("Q.devlock.AuthDevUgActivity2", 1, "opensdk afterOpenBrowser do finish");
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.AuthDevUgActivity2
 * JD-Core Version:    0.7.0.1
 */