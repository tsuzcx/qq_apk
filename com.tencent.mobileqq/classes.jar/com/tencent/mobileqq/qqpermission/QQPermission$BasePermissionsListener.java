package com.tencent.mobileqq.qqpermission;

import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import java.util.List;

public abstract class QQPermission$BasePermissionsListener
{
  private String[] a;
  
  public void a()
  {
    QPLog.a("QQPermission", "onAllGranted");
  }
  
  public void a(PermissionRequestDialog paramPermissionRequestDialog, List<String> paramList)
  {
    paramPermissionRequestDialog = new StringBuilder();
    paramPermissionRequestDialog.append("onDialogShow: ");
    paramPermissionRequestDialog.append(paramList);
    QPLog.a("QQPermission", paramPermissionRequestDialog.toString());
  }
  
  public void a(PermissionRequestView paramPermissionRequestView, List<String> paramList)
  {
    paramPermissionRequestView = new StringBuilder();
    paramPermissionRequestView.append("onViewShow: ");
    paramPermissionRequestView.append(paramList);
    QPLog.a("QQPermission", paramPermissionRequestView.toString());
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUncertain: ");
    localStringBuilder.append(paramString);
    QPLog.a("QQPermission", localStringBuilder.toString());
  }
  
  public void a(List<String> paramList, List<Integer> paramList1)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDenied: ");
    localStringBuilder.append(paramList);
    localStringBuilder.append(" results:");
    localStringBuilder.append(paramList1);
    QPLog.a("QQPermission", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
 * JD-Core Version:    0.7.0.1
 */