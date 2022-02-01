package com.tencent.mobileqq.qqpermission;

import com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QQPermission$MultiPermissionRequester
  extends QQPermission.BasePermissionsListener
{
  private int jdField_a_of_type_Int;
  private QQPermission.BasePermissionsListener jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener;
  private QQPermission jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission;
  private List<BasePermissionHandler> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private List<List<String>> jdField_b_of_type_JavaUtilList;
  
  public QQPermission$MultiPermissionRequester(QQPermission paramQQPermission, String[] paramArrayOfString, int paramInt, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission = paramQQPermission;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener = paramBasePermissionsListener;
    QQPermission.BasePermissionsListener.a(this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener, (String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
    a(paramArrayOfString);
  }
  
  private void a(String[] paramArrayOfString)
  {
    int i = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      Object localObject = QQPermission.a(this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission, str);
      int k = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      if (k < 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        localObject = new ArrayList();
        ((List)localObject).add(str);
        this.jdField_b_of_type_JavaUtilList.add(localObject);
      }
      else
      {
        ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(str);
      }
      i += 1;
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Int += 1;
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a();
    }
  }
  
  public void a(PermissionRequestDialog paramPermissionRequestDialog, List<String> paramList)
  {
    super.a(paramPermissionRequestDialog, paramList);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a(paramPermissionRequestDialog, paramList);
  }
  
  public void a(PermissionRequestView paramPermissionRequestView, List<String> paramList)
  {
    super.a(paramPermissionRequestView, paramList);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a(paramPermissionRequestView, paramList);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a(paramString);
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestNext: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    QPLog.a("QQPermission", localStringBuilder.toString());
    if (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((BasePermissionHandler)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).a((List)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), this.jdField_a_of_type_Int, this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.QQPermission.MultiPermissionRequester
 * JD-Core Version:    0.7.0.1
 */