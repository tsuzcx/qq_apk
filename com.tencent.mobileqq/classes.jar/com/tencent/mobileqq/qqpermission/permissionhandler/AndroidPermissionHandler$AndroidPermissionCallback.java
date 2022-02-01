package com.tencent.mobileqq.qqpermission.permissionhandler;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import java.util.List;

public abstract class AndroidPermissionHandler$AndroidPermissionCallback
{
  private ArrayMap<String, Boolean> a;
  protected AndroidPermissionHandler a;
  
  public AndroidPermissionHandler$AndroidPermissionCallback(AndroidPermissionHandler paramAndroidPermissionHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler = paramAndroidPermissionHandler;
    this.jdField_a_of_type_AndroidxCollectionArrayMap = new ArrayMap();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  private boolean a(String paramString)
  {
    return ((Boolean)this.jdField_a_of_type_AndroidxCollectionArrayMap.getOrDefault(paramString, Boolean.valueOf(false))).booleanValue();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidxCollectionArrayMap.clear();
  }
  
  void a()
  {
    QPLog.a("AndroidPermissionCallback", "onGranted");
  }
  
  void a(String paramString)
  {
    QPLog.a("AndroidPermissionCallback", "onUnCertain");
  }
  
  void a(List<String> paramList, String paramString)
  {
    paramList = new StringBuilder();
    paramList.append("onNeedRationale: ");
    paramList.append(paramString);
    QPLog.a("AndroidPermissionCallback", paramList.toString());
  }
  
  void a(List<String> paramList, List<Integer> paramList1)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDenied: ");
    localStringBuilder.append(paramList);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramList1);
    QPLog.a("AndroidPermissionCallback", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
 * JD-Core Version:    0.7.0.1
 */