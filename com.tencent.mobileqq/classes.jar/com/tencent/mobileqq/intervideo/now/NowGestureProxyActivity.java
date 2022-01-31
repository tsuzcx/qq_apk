package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.os.Process;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.sixgod.pluginsdk.log.SGLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.SixgodLog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class NowGestureProxyActivity
  extends ContainerActivity
{
  private AppRuntime a;
  
  public void a()
  {
    this.a = BaseApplicationImpl.getApplication().waitAppRuntime(null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    QLog.i("NowGestureProxyActivity", 1, "NowGestureProxyActivity onCreate ");
    if (paramBundle != null)
    {
      QLog.i("NowGestureProxyActivity", 1, "重启的场景，直接finish ");
      finish();
      Process.killProcess(Process.myPid());
      return;
    }
    super.onCreate(paramBundle);
    a();
    Foreground.updateRuntimeState(this.a);
    SGLog.init(new SixgodLog());
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowGestureProxyActivity", 2, "NowGestureProxyActivity onDestroy");
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    Foreground.onPause(this.a);
    super.onPause();
  }
  
  protected void onResume()
  {
    Foreground.onResume(this.a);
    super.onResume();
  }
  
  protected void onStart()
  {
    Foreground.onStart(this.a, this);
    super.onStart();
  }
  
  protected void onStop()
  {
    Foreground.onStop(this.a);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowGestureProxyActivity
 * JD-Core Version:    0.7.0.1
 */