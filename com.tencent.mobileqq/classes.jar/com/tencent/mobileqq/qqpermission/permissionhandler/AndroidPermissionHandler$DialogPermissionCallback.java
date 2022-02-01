package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import java.util.ArrayList;
import java.util.List;

class AndroidPermissionHandler$DialogPermissionCallback
  extends AndroidPermissionHandler.AndroidPermissionCallback
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQPermission.BasePermissionsListener jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener;
  
  public AndroidPermissionHandler$DialogPermissionCallback(AndroidPermissionHandler paramAndroidPermissionHandler, Context paramContext, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    super(paramAndroidPermissionHandler);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener = paramBasePermissionsListener;
  }
  
  private void a(List<String> paramList)
  {
    Object localObject = AndroidPermissionHandler.AndroidPermissionText.a(this.jdField_a_of_type_AndroidContentContext, paramList);
    String str = AndroidPermissionHandler.AndroidPermissionText.b(this.jdField_a_of_type_AndroidContentContext, paramList);
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler.a((String)localObject, str);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a((PermissionRequestDialog)localObject, paramList);
    ((PermissionRequestDialog)localObject).show();
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
  
  @RequiresApi(api=23)
  void a(List<String> paramList, String paramString)
  {
    super.a(paramList, paramString);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler.b(paramList, this);
  }
  
  void a(List<String> paramList, List<Integer> paramList1)
  {
    super.a(paramList, paramList1);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionQQPermission$BasePermissionsListener.a(paramList, paramList1);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size()) {
      if (((Integer)paramList1.get(i)).intValue() != 1)
      {
        if (((Integer)paramList1.get(i)).intValue() == 2) {
          return;
        }
        if (((Integer)paramList1.get(i)).intValue() == 3) {
          localArrayList.add(paramList.get(i));
        }
        i += 1;
      }
      else
      {
        return;
      }
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.DialogPermissionCallback
 * JD-Core Version:    0.7.0.1
 */