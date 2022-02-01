package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class OnlineStatusManager$1
  extends ProfileCardObserver
{
  OnlineStatusManager$1(OnlineStatusManager paramOnlineStatusManager) {}
  
  public void onGetProfileDetail(boolean paramBoolean, String paramString, Card paramCard)
  {
    boolean bool;
    int i;
    if ((paramString != null) && (paramString.equals(OnlineStatusManager.a(this.a).getCurrentAccountUin())))
    {
      bool = true;
      if ((paramCard == null) || (paramCard.lBirthday == OnlineStatusManager.a(this.a))) {
        break label283;
      }
      i = 1;
      label46:
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "onGetDetailInfo: invoked. [constellation] ", " isSuccess: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " mSelfCurrentBirthday: ", Long.valueOf(OnlineStatusManager.a(this.a)), " isSelfUin: ", Boolean.valueOf(bool) });
      }
      if ((i == 0) || (OnlineStatusManager.a(this.a).getExtOnlineStatus() != 1040L) || (!bool)) {
        break label289;
      }
      paramString = OnlineStatusManager.a(this.a).getCurrentAccountUin();
      str1 = ConstellationUtilKt.a(OnlineStatusManager.a(this.a), paramString);
      paramBoolean = TextUtils.isEmpty(str1);
      if (paramBoolean)
      {
        str2 = ConstellationUtilKt.b(OnlineStatusManager.a(this.a), paramString);
        OnlineStatusExtInfoServlet.a(OnlineStatusManager.a(this.a), str2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (拉取资料回调中，如果运势为空，才执行运势拉取) ", " emptyTrend: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " trend: ", str1 });
      }
      OnlineStatusManager.a(this.a, paramCard.lBirthday);
    }
    label283:
    label289:
    while (!QLog.isColorLevel())
    {
      String str1;
      String str2;
      return;
      bool = false;
      break;
      i = 0;
      break label46;
    }
    QLog.d("OnlineStatusManager", 2, new Object[] { "onGetDetailInfo: invoked.[constellation]  no need fetch", " mApp.getExtOnlineStatus(): ", Long.valueOf(OnlineStatusManager.a(this.a).getExtOnlineStatus()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.1
 * JD-Core Version:    0.7.0.1
 */