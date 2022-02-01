package com.tencent.mobileqq.intervideo.now.lifecycle;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.IForeground;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class NowForegroundImpl
  implements IForeground
{
  protected AppRuntime a;
  WeakReference<Activity> b;
  private int c = 0;
  
  public NowForegroundImpl()
  {
    a();
  }
  
  public void a()
  {
    this.a = BaseApplicationImpl.getApplication().waitAppRuntime(null);
  }
  
  public void onCreate(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate context = ");
    localStringBuilder.append(paramContext);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
    Foreground.updateRuntimeState(this.a);
    if ((paramContext instanceof Activity)) {
      this.b = new WeakReference((Activity)paramContext);
    }
  }
  
  public void onDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy mRuntime = ");
    localStringBuilder.append(this.a);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStart mActivity = ");
    localStringBuilder.append(this.b);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
  }
  
  public void onStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop mRuntime = ");
    localStringBuilder.append(this.a);
    QLog.d("NowForegroundImpl", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.lifecycle.NowForegroundImpl
 * JD-Core Version:    0.7.0.1
 */