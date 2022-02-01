package com.tencent.mobileqq.guild.audio.frame;

import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

class FloatWindowPermissionHandler$1$1
  implements Runnable
{
  FloatWindowPermissionHandler$1$1(FloatWindowPermissionHandler.1 param1) {}
  
  public void run()
  {
    FloatWindowPermissionHandler.a(this.a.a);
    if (FloatWindowPermissionHandler.b(this.a.a) == null) {
      return;
    }
    boolean bool = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
    FloatWindowPermissionHandler.b(this.a.a).a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.frame.FloatWindowPermissionHandler.1.1
 * JD-Core Version:    0.7.0.1
 */