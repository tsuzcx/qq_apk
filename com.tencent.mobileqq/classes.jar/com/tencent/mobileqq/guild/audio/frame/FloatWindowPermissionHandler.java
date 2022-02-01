package com.tencent.mobileqq.guild.audio.frame;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

public class FloatWindowPermissionHandler
{
  Application.ActivityLifecycleCallbacks a = new FloatWindowPermissionHandler.1(this);
  private Activity b;
  private FloatWindowPermissionHandler.OnRequestPermissionListener c;
  
  public FloatWindowPermissionHandler(Activity paramActivity) {}
  
  private void a(Activity paramActivity)
  {
    d();
    IQQFloatingPermission localIQQFloatingPermission = (IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class);
    Object localObject = paramActivity;
    if (paramActivity == null) {
      localObject = QBaseActivity.sTopActivity;
    }
    localIQQFloatingPermission.enterPermissionRequestDialogCustom((Context)localObject, 2131890250, 2131890249);
  }
  
  private void d()
  {
    BaseApplication.getContext().registerActivityLifecycleCallbacks(this.a);
  }
  
  private void e()
  {
    BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this.a);
  }
  
  public void a(FloatWindowPermissionHandler.OnRequestPermissionListener paramOnRequestPermissionListener)
  {
    this.c = paramOnRequestPermissionListener;
  }
  
  public boolean a()
  {
    return ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
  }
  
  public boolean b()
  {
    boolean bool = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
    if (!bool) {
      a(this.b);
    }
    return bool;
  }
  
  public void c()
  {
    e();
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.frame.FloatWindowPermissionHandler
 * JD-Core Version:    0.7.0.1
 */