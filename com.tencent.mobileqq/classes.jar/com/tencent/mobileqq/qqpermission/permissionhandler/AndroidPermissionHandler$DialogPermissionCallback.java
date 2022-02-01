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
  QQPermission.BasePermissionsListener b;
  private Context c;
  
  public AndroidPermissionHandler$DialogPermissionCallback(AndroidPermissionHandler paramAndroidPermissionHandler, Context paramContext, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    super(paramAndroidPermissionHandler);
    this.c = paramContext;
    this.b = paramBasePermissionsListener;
  }
  
  private void a(List<String> paramList)
  {
    Object localObject = AndroidPermissionHandler.AndroidPermissionText.a(this.c, paramList);
    String str = AndroidPermissionHandler.AndroidPermissionText.b(this.c, paramList);
    localObject = this.a.a((String)localObject, str);
    this.b.a((PermissionRequestDialog)localObject, paramList);
    ((PermissionRequestDialog)localObject).show();
  }
  
  void a()
  {
    super.a();
    this.b.a();
  }
  
  void a(String paramString)
  {
    super.a(paramString);
    this.b.a(paramString);
  }
  
  @RequiresApi(api=23)
  void a(List<String> paramList, String paramString)
  {
    super.a(paramList, paramString);
    this.a.b(paramList, this);
  }
  
  void a(List<String> paramList, List<Integer> paramList1)
  {
    super.a(paramList, paramList1);
    this.b.a(paramList, paramList1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.DialogPermissionCallback
 * JD-Core Version:    0.7.0.1
 */