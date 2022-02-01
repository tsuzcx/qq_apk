package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotificationPermissionHandler$1
  implements View.OnClickListener
{
  NotificationPermissionHandler$1(NotificationPermissionHandler paramNotificationPermissionHandler, QQPermission.BasePermissionsListener paramBasePermissionsListener) {}
  
  public void onClick(View paramView)
  {
    if (NotificationPermissionHandler.a(this.b)) {
      this.a.a();
    } else {
      PermissionUtil.a(this.b.d);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.NotificationPermissionHandler.1
 * JD-Core Version:    0.7.0.1
 */