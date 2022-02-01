package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.content.Context;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import java.util.ArrayList;
import java.util.List;

class AndroidPermissionHandler$ViewPermissionCallback
  extends AndroidPermissionHandler.AndroidPermissionCallback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQPermission.BasePermissionsListener jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener;
  private PermissionRequestView jdField_a_of_type_ComTencentMobileqqQqpermissionViewPermissionRequestView;
  private boolean jdField_a_of_type_Boolean;
  
  public AndroidPermissionHandler$ViewPermissionCallback(AndroidPermissionHandler paramAndroidPermissionHandler, Context paramContext, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    super(paramAndroidPermissionHandler);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener = paramBasePermissionsListener;
  }
  
  private void a(List<String> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqpermissionViewPermissionRequestView == null) {
      this.jdField_a_of_type_ComTencentMobileqqQqpermissionViewPermissionRequestView = new PermissionRequestView(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionViewPermissionRequestView.setOnSettingClickListener(new AndroidPermissionHandler.ViewPermissionCallback.1(this, paramList));
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionViewPermissionRequestView.setTitle(AndroidPermissionHandler.AndroidPermissionText.a(this.jdField_a_of_type_AndroidContentContext, paramList));
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionViewPermissionRequestView.setContent(AndroidPermissionHandler.AndroidPermissionText.b(this.jdField_a_of_type_AndroidContentContext, paramList));
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a(this.jdField_a_of_type_ComTencentMobileqqQqpermissionViewPermissionRequestView, paramList);
  }
  
  void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a();
  }
  
  void a(String paramString)
  {
    super.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a(paramString);
  }
  
  void a(List<String> paramList, String paramString)
  {
    super.a(paramList, paramString);
    a(paramList);
  }
  
  void a(List<String> paramList, List<Integer> paramList1)
  {
    super.a(paramList, paramList1);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a(paramList, paramList1);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (j < paramList.size())
    {
      String str = (String)paramList.get(j);
      int k = ((Integer)paramList1.get(j)).intValue();
      if ((k == 0) || (k == 1) || (k == 2))
      {
        if (k == 0) {
          i = 1;
        } else {
          i = 1;
        }
      }
      else {
        localArrayList.add(str);
      }
      j += 1;
    }
    a(localArrayList);
    if ((i == 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      PermissionUtil.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.ViewPermissionCallback
 * JD-Core Version:    0.7.0.1
 */