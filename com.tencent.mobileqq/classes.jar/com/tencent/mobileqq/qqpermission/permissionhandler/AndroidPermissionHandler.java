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
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class AndroidPermissionHandler
  extends BasePermissionHandler
{
  private static AtomicInteger e = new AtomicInteger(1000);
  private SparseArray<AndroidPermissionHandler.AndroidPermissionCallback> f = new SparseArray(4);
  private QQPermissionCallback g;
  
  public AndroidPermissionHandler(QQPermission paramQQPermission)
  {
    super(paramQQPermission);
  }
  
  private AppActivity a()
  {
    if ((this.b instanceof AppActivity)) {
      return (AppActivity)this.b;
    }
    if ((this.c != null) && ((this.c.getActivity() instanceof AppActivity))) {
      return (AppActivity)this.c.getActivity();
    }
    return null;
  }
  
  @RequiresApi(api=23)
  private void a(@NonNull String[] paramArrayOfString, int paramInt)
  {
    AppActivity localAppActivity = a();
    if (localAppActivity != null)
    {
      QPLog.a("AndroidPermissionHandler", "requestSysPermissions: use AppActivity api.");
      localAppActivity.requestPermissions(b(), paramInt, paramArrayOfString);
      return;
    }
    if (this.b != null)
    {
      this.b.requestPermissions(paramArrayOfString, paramInt);
      return;
    }
    if (this.c != null) {
      this.c.requestPermissions(paramArrayOfString, paramInt);
    }
  }
  
  private QQPermissionCallback b()
  {
    if (this.g == null) {
      this.g = new AndroidPermissionHandler.1(this);
    }
    return this.g;
  }
  
  @RequiresApi(api=23)
  private boolean c(String paramString)
  {
    if (this.b != null) {
      return this.b.shouldShowRequestPermissionRationale(paramString);
    }
    if (this.c != null) {
      return this.c.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  @RequiresApi(api=23)
  private int d(String paramString)
  {
    return this.d.checkSelfPermission(paramString);
  }
  
  public int a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      paramString = new StringBuilder();
      paramString.append("checkPermission: api is ");
      paramString.append(Build.VERSION.SDK_INT);
      QPLog.a("AndroidPermissionHandler", paramString.toString());
      return -2;
    }
    if (d(paramString) == 0) {
      return 0;
    }
    return -1;
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
    localObject = (AndroidPermissionHandler.AndroidPermissionCallback)this.f.get(paramInt);
    this.f.delete(paramInt);
    if ((localObject != null) && (paramArrayOfString.length != 0))
    {
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
          boolean bool1 = c(paramArrayOfString[paramInt]);
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
      a(paramList, new AndroidPermissionHandler.DialogPermissionCallback(this, this.d, paramBasePermissionsListener));
      return;
    }
    if (paramInt == 1) {
      a(paramList, new AndroidPermissionHandler.ViewPermissionCallback(this, this.d, paramBasePermissionsListener));
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
      if (d(str) == -1) {
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
      if (c(str))
      {
        paramAndroidPermissionCallback.a((List)localObject, str);
        return;
      }
    }
    b((List)localObject, paramAndroidPermissionCallback);
  }
  
  @RequiresApi(api=23)
  public void b(List<String> paramList, AndroidPermissionHandler.AndroidPermissionCallback paramAndroidPermissionCallback)
  {
    AndroidPermissionHandler.AndroidPermissionCallback.a(paramAndroidPermissionCallback);
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      AndroidPermissionHandler.AndroidPermissionCallback.a(paramAndroidPermissionCallback, str, c(str));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doRequestPermission: permission=");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(", shouldShowRequestPermissionRationale=");
    ((StringBuilder)localObject).append(AndroidPermissionHandler.AndroidPermissionCallback.b(paramAndroidPermissionCallback));
    ((StringBuilder)localObject).append(", requestCode=");
    ((StringBuilder)localObject).append(e);
    ((StringBuilder)localObject).append(", size=");
    ((StringBuilder)localObject).append(this.f.size());
    QPLog.a("AndroidPermissionHandler", ((StringBuilder)localObject).toString());
    int i = e.getAndIncrement();
    this.f.put(i, paramAndroidPermissionCallback);
    a((String[])paramList.toArray(new String[0]), i);
  }
  
  public boolean b(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler
 * JD-Core Version:    0.7.0.1
 */