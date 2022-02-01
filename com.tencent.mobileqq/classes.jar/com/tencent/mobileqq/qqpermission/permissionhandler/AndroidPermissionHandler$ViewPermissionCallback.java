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
  private Context b;
  private QQPermission.BasePermissionsListener c;
  private PermissionRequestView d;
  private boolean e;
  
  public AndroidPermissionHandler$ViewPermissionCallback(AndroidPermissionHandler paramAndroidPermissionHandler, Context paramContext, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    super(paramAndroidPermissionHandler);
    this.b = paramContext;
    this.c = paramBasePermissionsListener;
  }
  
  private void a(List<String> paramList)
  {
    if (this.d == null) {
      this.d = new PermissionRequestView(this.b);
    }
    this.d.setOnSettingClickListener(new AndroidPermissionHandler.ViewPermissionCallback.1(this, paramList));
    this.d.setTitle(AndroidPermissionHandler.AndroidPermissionText.a(this.b, paramList));
    this.d.setContent(AndroidPermissionHandler.AndroidPermissionText.b(this.b, paramList));
    this.c.a(this.d, paramList);
  }
  
  void a()
  {
    super.a();
    this.c.a();
  }
  
  void a(String paramString)
  {
    super.a(paramString);
    this.c.a(paramString);
  }
  
  void a(List<String> paramList, String paramString)
  {
    super.a(paramList, paramString);
    a(paramList);
  }
  
  void a(List<String> paramList, List<Integer> paramList1)
  {
    super.a(paramList, paramList1);
    this.c.a(paramList, paramList1);
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
    if ((i == 0) && (this.e))
    {
      this.e = false;
      PermissionUtil.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.ViewPermissionCallback
 * JD-Core Version:    0.7.0.1
 */