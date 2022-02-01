package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class OnlineStatusAIOPopUpWindow$5
{
  OnlineStatusAIOPopUpWindow$5(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    DialogUtil.a(OnlineStatusAIOPopUpWindow.f(this.a), 2131896425, 2131896426);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.a.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.5
 * JD-Core Version:    0.7.0.1
 */