package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class AutoStatusSelectView$3
{
  AutoStatusSelectView$3(AutoStatusSelectView paramAutoStatusSelectView) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    DialogUtil.a(this.a.g, 2131896425, 2131896426);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.a.a(null);
    this.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusSelectView.3
 * JD-Core Version:    0.7.0.1
 */