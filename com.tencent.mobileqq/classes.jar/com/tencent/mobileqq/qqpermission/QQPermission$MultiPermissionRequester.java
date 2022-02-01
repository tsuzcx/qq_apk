package com.tencent.mobileqq.qqpermission;

import com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QQPermission$MultiPermissionRequester
  extends QQPermission.BasePermissionsListener
{
  private int a;
  private QQPermission b;
  private QQPermission.BasePermissionsListener c;
  private List<BasePermissionHandler> d;
  private List<List<String>> e;
  private int f;
  
  public QQPermission$MultiPermissionRequester(QQPermission paramQQPermission, String[] paramArrayOfString, int paramInt, QQPermission.BasePermissionsListener paramBasePermissionsListener)
  {
    this.b = paramQQPermission;
    this.a = paramInt;
    this.c = paramBasePermissionsListener;
    QQPermission.BasePermissionsListener.a(this.c, (String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
    a(paramArrayOfString);
  }
  
  private void a(String[] paramArrayOfString)
  {
    int i = 0;
    this.f = 0;
    this.d = new ArrayList();
    this.e = new ArrayList();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      Object localObject = QQPermission.a(this.b, str);
      int k = this.d.indexOf(localObject);
      if (k < 0)
      {
        this.d.add(localObject);
        localObject = new ArrayList();
        ((List)localObject).add(str);
        this.e.add(localObject);
      }
      else
      {
        ((List)this.e.get(k)).add(str);
      }
      i += 1;
    }
  }
  
  public void a()
  {
    super.a();
    this.f += 1;
    if (!b()) {
      this.c.a();
    }
  }
  
  public void a(PermissionRequestDialog paramPermissionRequestDialog, List<String> paramList)
  {
    super.a(paramPermissionRequestDialog, paramList);
    this.c.a(paramPermissionRequestDialog, paramList);
  }
  
  public void a(PermissionRequestView paramPermissionRequestView, List<String> paramList)
  {
    super.a(paramPermissionRequestView, paramList);
    this.c.a(paramPermissionRequestView, paramList);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.c.a(paramString);
  }
  
  public void a(List<String> paramList, List<Integer> paramList1)
  {
    super.a(paramList, paramList1);
    this.c.a(paramList, paramList1);
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestNext: ");
    localStringBuilder.append(this.f);
    QPLog.a("QQPermission", localStringBuilder.toString());
    if (this.f < this.d.size())
    {
      ((BasePermissionHandler)this.d.get(this.f)).a((List)this.e.get(this.f), this.a, this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.QQPermission.MultiPermissionRequester
 * JD-Core Version:    0.7.0.1
 */