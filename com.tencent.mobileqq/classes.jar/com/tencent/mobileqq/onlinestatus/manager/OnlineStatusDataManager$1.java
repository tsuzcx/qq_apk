package com.tencent.mobileqq.onlinestatus.manager;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class OnlineStatusDataManager$1
  extends ProfileCardObserver
{
  OnlineStatusDataManager$1(OnlineStatusDataManager paramOnlineStatusDataManager) {}
  
  protected void onGetProfileDetail(boolean paramBoolean, String paramString, Card paramCard)
  {
    boolean bool;
    if ((paramString != null) && (paramString.equals(OnlineStatusDataManager.a(this.a).getCurrentAccountUin()))) {
      bool = true;
    } else {
      bool = false;
    }
    int i;
    if ((paramCard != null) && (paramCard.lBirthday != OnlineStatusDataManager.b(this.a))) {
      i = 1;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "onGetDetailInfo: invoked. [constellation] ", " isSuccess: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " mSelfCurrentBirthday: ", Long.valueOf(OnlineStatusDataManager.b(this.a)), " isSelfUin: ", Boolean.valueOf(bool) });
    }
    paramString = (IOnlineStatusService)OnlineStatusDataManager.a(this.a).getRuntimeService(IOnlineStatusService.class, "");
    if ((i != 0) && (paramString.getExtOnlineStatus() == 1040L) && (bool))
    {
      paramString = OnlineStatusDataManager.a(this.a).getCurrentAccountUin();
      String str1 = ConstellationUtilKt.b(OnlineStatusDataManager.a(this.a), paramString);
      paramBoolean = TextUtils.isEmpty(str1);
      if (paramBoolean)
      {
        String str2 = ConstellationUtilKt.d(OnlineStatusDataManager.a(this.a), paramString);
        OnlineStatusExtInfoServlet.a(OnlineStatusDataManager.a(this.a), str2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (拉取资料回调中，如果运势为空，才执行运势拉取) ", " emptyTrend: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " trend: ", str1 });
      }
      OnlineStatusDataManager.a(this.a, paramCard.lBirthday);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "onGetDetailInfo: invoked.[constellation]  no need fetch", " mApp.getExtOnlineStatus(): ", Long.valueOf(paramString.getExtOnlineStatus()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager.1
 * JD-Core Version:    0.7.0.1
 */