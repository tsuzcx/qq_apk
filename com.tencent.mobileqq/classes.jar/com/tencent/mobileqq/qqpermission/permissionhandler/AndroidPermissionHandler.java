package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AndroidPermissionHandler
  extends BasePermissionHandler
{
  private int jdField_a_of_type_Int = 1;
  private SparseArray<AndroidPermissionHandler.AndroidPermissionCallback> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  
  public AndroidPermissionHandler(QQPermission paramQQPermission)
  {
    super(paramQQPermission);
  }
  
  @RequiresApi(api=23)
  private int a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentContext.checkSelfPermission(paramString);
  }
  
  @RequiresApi(api=23)
  private void a(@NonNull String[] paramArrayOfString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.requestPermissions(paramArrayOfString, paramInt);
      return;
    }
    if (this.jdField_a_of_type_AndroidxFragmentAppFragment != null) {
      this.jdField_a_of_type_AndroidxFragmentAppFragment.requestPermissions(paramArrayOfString, paramInt);
    }
  }
  
  @RequiresApi(api=23)
  private boolean b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      return this.jdField_a_of_type_AndroidAppActivity.shouldShowRequestPermissionRationale(paramString);
    }
    if (this.jdField_a_of_type_AndroidxFragmentAppFragment != null) {
      return this.jdField_a_of_type_AndroidxFragmentAppFragment.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  @RequiresApi(api=23)
  public void a(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRequestPermissionResult: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", permissions: ");
    ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfString));
    ((StringBuilder)localObject).append(", result: ");
    ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
    QPLog.a("AndroidPermissionHandler", ((StringBuilder)localObject).toString());
    localObject = (AndroidPermissionHandler.AndroidPermissionCallback)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject != null) && (paramArrayOfString.length != 0))
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramInt = 0;
      int i = 1;
      while (paramInt < paramArrayOfString.length)
      {
        localArrayList1.add(paramArrayOfString[paramInt]);
        if (paramArrayOfInt[paramInt] == 0)
        {
          localArrayList2.add(Integer.valueOf(0));
        }
        else
        {
          boolean bool1 = b(paramArrayOfString[paramInt]);
          boolean bool2 = AndroidPermissionHandler.AndroidPermissionCallback.a((AndroidPermissionHandler.AndroidPermissionCallback)localObject, paramArrayOfString[paramInt]);
          if (bool1) {
            localArrayList2.add(Integer.valueOf(1));
          } else if (bool2) {
            localArrayList2.add(Integer.valueOf(2));
          } else {
            localArrayList2.add(Integer.valueOf(3));
          }
          i = 0;
        }
        paramInt += 1;
      }
      if (i != 0)
      {
        ((AndroidPermissionHandler.AndroidPermissionCallback)localObject).a();
        return;
      }
      ((AndroidPermissionHandler.AndroidPermissionCallback)localObject).a(localArrayList1, localArrayList2);
      return;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("onRequestPermissionResult: callback=");
    paramArrayOfString.append(localObject);
    QPLog.b("AndroidPermissionHandler", new Object[] { paramArrayOfString.toString() });
  }
  
  public void a(List<String> paramList, int paramInt, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    if (paramInt == 2)
    {
      a(paramList, new AndroidPermissionHandler.DialogPermissionCallback(this, this.jdField_a_of_type_AndroidContentContext, paramBasePermissionsListener));
      return;
    }
    if (paramInt == 1) {
      a(paramList, new AndroidPermissionHandler.ViewPermissionCallback(this, this.jdField_a_of_type_AndroidContentContext, paramBasePermissionsListener));
    }
  }
  
  public void a(List<String> paramList, AndroidPermissionHandler.AndroidPermissionCallback paramAndroidPermissionCallback)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkPermission: api is ");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QPLog.a("AndroidPermissionHandler", ((StringBuilder)localObject).toString());
      paramAndroidPermissionCallback.a((String)paramList.get(0));
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    String str;
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      if (a(str) == -1) {
        ((List)localObject).add(str);
      }
    }
    if (((List)localObject).size() == 0)
    {
      paramAndroidPermissionCallback.a();
      return;
    }
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      if (b(str))
      {
        paramAndroidPermissionCallback.a((List)localObject, str);
        return;
      }
    }
    b((List)localObject, paramAndroidPermissionCallback);
  }
  
  public boolean a(String paramString)
  {
    return true;
  }
  
  @RequiresApi(api=23)
  public void b(List<String> paramList, AndroidPermissionHandler.AndroidPermissionCallback paramAndroidPermissionCallback)
  {
    AndroidPermissionHandler.AndroidPermissionCallback.a(paramAndroidPermissionCallback);
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      AndroidPermissionHandler.AndroidPermissionCallback.a(paramAndroidPermissionCallback, str, b(str));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doRequestPermission: permission=");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(", shouldShowRequestPermissionRationale=");
    ((StringBuilder)localObject).append(AndroidPermissionHandler.AndroidPermissionCallback.a(paramAndroidPermissionCallback));
    ((StringBuilder)localObject).append(", requestCode=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", size=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidUtilSparseArray.size());
    QPLog.a("AndroidPermissionHandler", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Int, paramAndroidPermissionCallback);
    paramList = (String[])paramList.toArray(new String[0]);
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    a(paramList, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler
 * JD-Core Version:    0.7.0.1
 */