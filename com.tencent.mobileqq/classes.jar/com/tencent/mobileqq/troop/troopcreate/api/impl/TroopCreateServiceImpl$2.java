package com.tencent.mobileqq.troop.troopcreate.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.qphone.base.util.QLog;

class TroopCreateServiceImpl$2
  extends TroopMngObserver
{
  TroopCreateServiceImpl$2(TroopCreateServiceImpl paramTroopCreateServiceImpl) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTroopManagerFailed, result = ");
    localStringBuilder.append(paramInt2);
    QLog.e("TroopCreateServiceImpl", 1, localStringBuilder.toString());
    TroopCreateServiceImpl.access$100(this.a).removeObserver(this.a.mTroopObserver);
    if (TroopCreateServiceImpl.access$200(this.a) != null)
    {
      if (paramInt1 == 8) {
        TroopCreateServiceImpl.access$200(this.a).onInviteComplete(paramInt2, "");
      }
      TroopCreateServiceImpl.access$202(this.a, null);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    TroopCreateServiceImpl.access$100(this.a).removeObserver(this.a.mTroopObserver);
    ITroopMemberListHandler localITroopMemberListHandler;
    if (paramInt1 == 8)
    {
      if (TroopCreateServiceImpl.access$200(this.a) != null) {
        TroopCreateServiceImpl.access$200(this.a).onInviteComplete(0, paramString);
      }
      ((ITroopCreateGrayMsg)TroopCreateServiceImpl.access$100(this.a).getRuntimeService(ITroopCreateGrayMsg.class, "")).addCreateNewTroopGrayTips(paramString, true, "");
      localITroopMemberListHandler = (ITroopMemberListHandler)TroopCreateServiceImpl.access$100(this.a).getBusinessHandler(TroopMemberListHandler.class.getName());
    }
    try
    {
      localITroopMemberListHandler.a(Long.parseLong(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label105:
      break label105;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreateServiceImpl", 1, new Object[] { "onTroopManagerSuccess: error, troopUin = ", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */