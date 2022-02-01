package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import java.util.List;

public abstract class BasePermissionHandler
{
  protected QQPermission a;
  protected Activity b;
  protected Fragment c;
  protected Context d;
  
  public BasePermissionHandler(QQPermission paramQQPermission)
  {
    this.a = paramQQPermission;
    this.b = paramQQPermission.b();
    this.c = paramQQPermission.c();
    this.d = paramQQPermission.d();
  }
  
  public abstract int a(String paramString);
  
  protected PermissionRequestDialog a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new BasePermissionHandler.1(this));
  }
  
  protected PermissionRequestDialog a(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    PermissionRequestDialog localPermissionRequestDialog = new PermissionRequestDialog(this.d, 2131952200);
    localPermissionRequestDialog.setCanceledOnTouchOutside(false);
    localPermissionRequestDialog.setCancelable(true);
    String str = QQPermissionBusinessManager.a(this.d, this.a.a().a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString1);
    localPermissionRequestDialog.a(localStringBuilder.toString());
    localPermissionRequestDialog.b(paramString2);
    localPermissionRequestDialog.a(paramOnClickListener);
    return localPermissionRequestDialog;
  }
  
  public abstract void a(List<String> paramList, int paramInt, QQPermission.BasePermissionsListener paramBasePermissionsListener);
  
  public abstract boolean b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
 * JD-Core Version:    0.7.0.1
 */