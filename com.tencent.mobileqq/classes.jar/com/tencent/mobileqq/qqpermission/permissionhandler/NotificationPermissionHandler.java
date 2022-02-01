package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.content.Context;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import java.util.List;

public class NotificationPermissionHandler
  extends BasePermissionHandler
{
  public NotificationPermissionHandler(QQPermission paramQQPermission)
  {
    super(paramQQPermission);
  }
  
  private boolean a()
  {
    return QQNotificationManager.getInstance().areNotificationsEnabled(this.d);
  }
  
  public int a(String paramString)
  {
    if (a()) {
      return 0;
    }
    return -1;
  }
  
  public void a(List<String> paramList, int paramInt, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    if (a())
    {
      paramBasePermissionsListener.a();
      return;
    }
    Object localObject;
    if (paramInt == 2)
    {
      localObject = a(this.d.getString(2131897131), this.d.getString(2131897130));
      paramBasePermissionsListener.a((PermissionRequestDialog)localObject, paramList);
      ((PermissionRequestDialog)localObject).show();
      return;
    }
    if (paramInt == 1)
    {
      localObject = new PermissionRequestView(this.d);
      ((PermissionRequestView)localObject).setTitle(2131897131);
      ((PermissionRequestView)localObject).setContent(2131897130);
      ((PermissionRequestView)localObject).setOnSettingClickListener(new NotificationPermissionHandler.1(this, paramBasePermissionsListener));
      paramBasePermissionsListener.a((PermissionRequestView)localObject, paramList);
    }
  }
  
  public boolean b(String paramString)
  {
    return "qq.permission.notification".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.NotificationPermissionHandler
 * JD-Core Version:    0.7.0.1
 */