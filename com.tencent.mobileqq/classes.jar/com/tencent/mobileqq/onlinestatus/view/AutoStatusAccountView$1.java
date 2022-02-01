package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class AutoStatusAccountView$1
{
  AutoStatusAccountView$1(AutoStatusAccountView paramAutoStatusAccountView, boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    DialogUtil.a(this.c.g, 2131896425, 2131896426);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.c.a(this.a);
    this.c.a(this.b);
    this.c.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusAccountView.1
 * JD-Core Version:    0.7.0.1
 */