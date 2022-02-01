package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import java.util.List;

public abstract class BasePermissionHandler
{
  protected Activity a;
  protected Context a;
  protected Fragment a;
  protected QQPermission a;
  
  public BasePermissionHandler(QQPermission paramQQPermission)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission = paramQQPermission;
    this.jdField_a_of_type_AndroidAppActivity = paramQQPermission.a();
    this.jdField_a_of_type_AndroidxFragmentAppFragment = paramQQPermission.a();
    this.jdField_a_of_type_AndroidContentContext = paramQQPermission.a();
  }
  
  protected PermissionRequestDialog a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new BasePermissionHandler.1(this));
  }
  
  protected PermissionRequestDialog a(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    PermissionRequestDialog localPermissionRequestDialog = new PermissionRequestDialog(this.jdField_a_of_type_AndroidContentContext, 2131755427);
    localPermissionRequestDialog.setCanceledOnTouchOutside(false);
    localPermissionRequestDialog.setCancelable(true);
    String str = QQPermissionBusinessManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission.a().id());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString1);
    localPermissionRequestDialog.a(localStringBuilder.toString());
    localPermissionRequestDialog.b(paramString2);
    localPermissionRequestDialog.a(paramOnClickListener);
    return localPermissionRequestDialog;
  }
  
  public abstract void a(List<String> paramList, int paramInt, QQPermission.BasePermissionsListener paramBasePermissionsListener);
  
  public abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
 * JD-Core Version:    0.7.0.1
 */