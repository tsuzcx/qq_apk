package com.tencent.mobileqq.qqpermission;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
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
  BusinessConfig a;
  protected Activity b;
  protected Fragment c;
  protected Context d;
  private ArrayList<BasePermissionHandler> e;
  private AndroidPermissionHandler f;
  
  QQPermission(Activity paramActivity, Fragment paramFragment)
  {
    this.b = paramActivity;
    this.c = paramFragment;
    paramActivity = this.b;
    if (paramActivity != null)
    {
      this.d = paramActivity;
      return;
    }
    paramActivity = this.c;
    if (paramActivity != null) {
      this.d = paramActivity.getContext();
    }
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (b(paramArrayOfString))
    {
      QPLog.b("QQPermission", new Object[] { "check: illegal size" });
      return false;
    }
    return QQPermissionBusinessManager.a(this.a, paramArrayOfString);
  }
  
  private BasePermissionHandler b(String paramString)
  {
    if (this.e == null) {
      e();
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      BasePermissionHandler localBasePermissionHandler = (BasePermissionHandler)localIterator.next();
      if (localBasePermissionHandler.b(paramString)) {
        return localBasePermissionHandler;
      }
    }
    return this.f;
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
  
  private void e()
  {
    this.e = new ArrayList();
    this.e.add(new NotificationPermissionHandler(this));
    this.f = new AndroidPermissionHandler(this);
  }
  
  public int a(String paramString)
  {
    Object localObject = b(paramString);
    int i;
    if (localObject != null) {
      i = ((BasePermissionHandler)localObject).a(paramString);
    } else {
      i = -2;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestPermission: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(i);
    QPLog.a("QQPermission", ((StringBuilder)localObject).toString());
    return i;
  }
  
  public BusinessConfig a()
  {
    return this.a;
  }
  
  void a(BusinessConfig paramBusinessConfig)
  {
    this.a = paramBusinessConfig;
    paramBusinessConfig = new StringBuilder();
    paramBusinessConfig.append("setBusiness: ");
    paramBusinessConfig.append(this.a);
    QPLog.a("QQPermission", new Object[] { paramBusinessConfig.toString() });
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
    new QQPermission.MultiPermissionRequester(this, paramArrayOfString, paramInt, paramBasePermissionsListener).b();
  }
  
  public Activity b()
  {
    return this.b;
  }
  
  public Fragment c()
  {
    return this.c;
  }
  
  public Context d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.QQPermission
 * JD-Core Version:    0.7.0.1
 */