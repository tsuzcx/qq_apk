package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import java.util.Iterator;
import java.util.List;

class PasswdRedBagServiceImpl$9
  implements Runnable
{
  PasswdRedBagServiceImpl$9(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl) {}
  
  public void run()
  {
    Iterator localIterator = PasswdRedBagServiceImpl.access$400(this.this$0).b().iterator();
    while (localIterator.hasNext())
    {
      PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)localIterator.next();
      PasswdRedBagServiceImpl.access$500(this.this$0, localPasswdRedBagInfo);
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).PasswdRedBagFoldManager$updateRedBagMapCache(PasswdRedBagServiceImpl.access$200(this.this$0), false, localPasswdRedBagInfo.a, localPasswdRedBagInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */