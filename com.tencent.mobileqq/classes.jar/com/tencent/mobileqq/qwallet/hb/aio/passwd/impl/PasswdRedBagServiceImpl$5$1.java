package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import Wallet.IdiomRedPackMatchRsp;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PasswdRedBagServiceImpl$5$1
  implements BusinessObserver
{
  PasswdRedBagServiceImpl$5$1(PasswdRedBagServiceImpl.5 param5) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 26)
    {
      paramBundle = (IdiomRedPackMatchRsp)paramBundle.getSerializable("rsp");
      Object localObject;
      if ((QLog.isColorLevel()) && (paramBundle != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openSolitaireRedBagByIdiom reportObserver: ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append("|status: ");
        ((StringBuilder)localObject).append(paramBundle.status);
        ((StringBuilder)localObject).append(" |hbIdiom： ");
        ((StringBuilder)localObject).append(paramBundle.hbIdiom);
        ((StringBuilder)localObject).append(" |hbIdiomLastPY: ");
        ((StringBuilder)localObject).append(paramBundle.hbIdiomLastPY);
        ((StringBuilder)localObject).append(" |idiomSeq: ");
        ((StringBuilder)localObject).append(paramBundle.idiomSeq);
        ((StringBuilder)localObject).append(" |subchannel: ");
        ((StringBuilder)localObject).append(paramBundle.subchannel);
        QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramBoolean) && (paramBundle != null))
      {
        if (paramBundle.status == 0)
        {
          this.a.f.setPasswdRedBagLastedWord(this.a.a.a, paramBundle.hbIdiom, paramBundle.hbIdiomLastPY, paramBundle.idiomSeq, paramBundle.hbPoemRule);
          return;
        }
        if (paramBundle.status == 1)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("sessionInfo.curType: ");
            ((StringBuilder)localObject).append(this.a.c.a);
            QLog.i("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
          }
          if (this.a.c.a == 0) {
            this.a.f.setPasswdRedBagOpen(this.a.a.a, this.a.c.b, this.a.c.a);
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("answer", this.a.b);
          ((Bundle)localObject).putInt("subchannel", paramBundle.subchannel);
          this.a.f.openPasswdBagByTenpay(this.a.c, this.a.a, this.a.d, this.a.e, (Bundle)localObject);
          return;
        }
        if (paramBundle.status == 2)
        {
          long l = NetConnInfoCenter.getServerTime();
          ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putLong(PasswdRedBagServiceImpl.access$200(this.a.f).getCurrentAccountUin(), "idiom_match_in_phone", l + paramBundle.timeInterval);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.5.1
 * JD-Core Version:    0.7.0.1
 */