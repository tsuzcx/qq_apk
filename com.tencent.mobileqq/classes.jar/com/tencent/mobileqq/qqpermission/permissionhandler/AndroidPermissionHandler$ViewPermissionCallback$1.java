package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AndroidPermissionHandler$ViewPermissionCallback$1
  implements View.OnClickListener
{
  AndroidPermissionHandler$ViewPermissionCallback$1(AndroidPermissionHandler.ViewPermissionCallback paramViewPermissionCallback, List paramList) {}
  
  @RequiresApi(api=23)
  public void onClick(View paramView)
  {
    AndroidPermissionHandler.ViewPermissionCallback.a(this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler$ViewPermissionCallback, true);
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler$ViewPermissionCallback.a.b(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler$ViewPermissionCallback);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.ViewPermissionCallback.1
 * JD-Core Version:    0.7.0.1
 */