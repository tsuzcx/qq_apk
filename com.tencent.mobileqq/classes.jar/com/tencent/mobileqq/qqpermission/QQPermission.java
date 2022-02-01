package com.tencent.mobileqq.qqpermission;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager;
import com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler;
import com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler;
import com.tencent.mobileqq.qqpermission.permissionhandler.NotificationPermissionHandler;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QQPermission
{
  protected Activity a;
  protected Context a;
  protected Fragment a;
  QQPermissionConfig jdField_a_of_type_ComTencentMobileqqQqpermissionAnnotationQQPermissionConfig;
  private AndroidPermissionHandler jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler;
  private ArrayList<BasePermissionHandler> jdField_a_of_type_JavaUtilArrayList;
  
  QQPermission(Activity paramActivity, Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidxFragmentAppFragment = paramFragment;
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (paramActivity != null)
    {
      this.jdField_a_of_type_AndroidContentContext = paramActivity;
      return;
    }
    paramActivity = this.jdField_a_of_type_AndroidxFragmentAppFragment;
    if (paramActivity != null) {
      this.jdField_a_of_type_AndroidContentContext = paramActivity.getContext();
    }
  }
  
  QQPermission(Fragment paramFragment)
  {
    this(null, paramFragment);
  }
  
  private BasePermissionHandler a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      a();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      BasePermissionHandler localBasePermissionHandler = (BasePermissionHandler)localIterator.next();
      if (localBasePermissionHandler.a(paramString)) {
        return localBasePermissionHandler;
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(new NotificationPermissionHandler(this));
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler = new AndroidPermissionHandler(this);
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (b(paramArrayOfString))
    {
      QPLog.b("QQPermission", new Object[] { "check: illegal size" });
      return false;
    }
    return QQPermissionBusinessManager.a(this.jdField_a_of_type_ComTencentMobileqqQqpermissionAnnotationQQPermissionConfig, paramArrayOfString);
  }
  
  private boolean b(String[] paramArrayOfString)
  {
    int i2 = paramArrayOfString.length;
    int i3 = paramArrayOfString.length;
    boolean bool = false;
    int n = 0;
    int i1 = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    while (n < i3)
    {
      String str = paramArrayOfString[n];
      switch (str.hashCode())
      {
      default: 
        break;
      case 1365911975: 
        if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
          i = 1;
        }
        break;
      case -63024214: 
        if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
          i = 2;
        }
        break;
      case -406040016: 
        if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
          i = 0;
        }
        break;
      case -1888586689: 
        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
          i = 3;
        }
        break;
      }
      i = -1;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              j = 1;
            }
          }
          else {
            k = 1;
          }
        }
        else {
          m = 1;
        }
      }
      else {
        i1 = 1;
      }
      n += 1;
    }
    int i = i2;
    if (i1 != 0)
    {
      i = i2;
      if (m != 0) {
        i = i2 - 1;
      }
    }
    m = i;
    if (k != 0)
    {
      m = i;
      if (j != 0) {
        m = i - 1;
      }
    }
    if ((m <= 0) || (m > 2)) {
      bool = true;
    }
    return bool;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public Fragment a()
  {
    return this.jdField_a_of_type_AndroidxFragmentAppFragment;
  }
  
  public QQPermissionConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqpermissionAnnotationQQPermissionConfig;
  }
  
  public void a(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler != null) && (Build.VERSION.SDK_INT >= 23)) {
      this.jdField_a_of_type_ComTencentMobileqqQqpermissionPermissionhandlerAndroidPermissionHandler.a(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  void a(QQPermissionConfig paramQQPermissionConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqpermissionAnnotationQQPermissionConfig = paramQQPermissionConfig;
    paramQQPermissionConfig = new StringBuilder();
    paramQQPermissionConfig.append("setBusiness: ");
    paramQQPermissionConfig.append(this.jdField_a_of_type_ComTencentMobileqqQqpermissionAnnotationQQPermissionConfig);
    QPLog.a("QQPermission", new Object[] { paramQQPermissionConfig.toString() });
  }
  
  public void a(String[] paramArrayOfString, int paramInt, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPermissions: ");
    localStringBuilder.append(Arrays.toString(paramArrayOfString));
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt);
    QPLog.a("QQPermission", localStringBuilder.toString());
    if (!a(paramArrayOfString))
    {
      QPLog.b("QQPermission", new Object[] { "requestPermissions: illegal request!" });
      return;
    }
    new QQPermission.MultiPermissionRequester(this, paramArrayOfString, paramInt, paramBasePermissionsListener).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.QQPermission
 * JD-Core Version:    0.7.0.1
 */