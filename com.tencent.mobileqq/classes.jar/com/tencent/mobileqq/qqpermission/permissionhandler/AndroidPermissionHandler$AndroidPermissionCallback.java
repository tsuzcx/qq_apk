package com.tencent.mobileqq.qqpermission.permissionhandler;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import java.util.List;

public abstract class AndroidPermissionHandler$AndroidPermissionCallback
{
  protected AndroidPermissionHandler a;
  private ArrayMap<String, Boolean> b;
  
  public AndroidPermissionHandler$AndroidPermissionCallback(AndroidPermissionHandler paramAndroidPermissionHandler)
  {
    this.a = paramAndroidPermissionHandler;
    this.b = new ArrayMap();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.b.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  private void b()
  {
    this.b.clear();
  }
  
  private boolean b(String paramString)
  {
    return ((Boolean)this.b.getOrDefault(paramString, Boolean.valueOf(false))).booleanValue();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
 * JD-Core Version:    0.7.0.1
 */