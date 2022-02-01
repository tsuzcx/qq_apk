package com.tencent.mobileqq.newfriend.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.qphone.base.util.QLog;

class NewFriendVerificationServiceImpl$1
  extends ProfileCommonObserver
{
  NewFriendVerificationServiceImpl$1(NewFriendVerificationServiceImpl paramNewFriendVerificationServiceImpl) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetSelfAddFriendSetting() addFriendSetting is:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((NewFriendVerificationServiceImpl.access$000(this.a, paramInt)) && (this.a.mApp != null))
    {
      localObject = this.a;
      ((NewFriendVerificationServiceImpl)localObject).getAddFriendBlockedRedPoint(((NewFriendVerificationServiceImpl)localObject).mApp.getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */