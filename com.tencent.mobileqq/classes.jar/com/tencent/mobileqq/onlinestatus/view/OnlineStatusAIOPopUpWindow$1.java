package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;

class OnlineStatusAIOPopUpWindow$1
  implements IFriendObserver
{
  OnlineStatusAIOPopUpWindow$1(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow, AppInterface paramAppInterface) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 67) || (paramInt == 13))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusAIOPopUpWindow", 2, "friends status update");
      }
      if (OnlineStatusUtils.a(OnlineStatusAIOPopUpWindow.a(this.b).detalStatusFlag, OnlineStatusAIOPopUpWindow.a(this.b).iTermType) != 0)
      {
        this.b.e();
        return;
      }
      ((IOnlineStatusService)this.a.getRuntimeService(IOnlineStatusService.class, "")).dismissAIOStatusPopupDialog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.1
 * JD-Core Version:    0.7.0.1
 */