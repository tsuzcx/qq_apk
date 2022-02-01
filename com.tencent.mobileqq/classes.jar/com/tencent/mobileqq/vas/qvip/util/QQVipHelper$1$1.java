package com.tencent.mobileqq.vas.qvip.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class QQVipHelper$1$1
  implements Runnable
{
  QQVipHelper$1$1(QQVipHelper.1 param1, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    AccountDetail localAccountDetail = new AccountDetail(this.a);
    EntityManager localEntityManager = this.this$0.a.getEntityManagerFactory(this.this$0.a.getAccount()).createEntityManager();
    if (localEntityManager != null) {
      localEntityManager.persistOrReplace(localAccountDetail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.util.QQVipHelper.1.1
 * JD-Core Version:    0.7.0.1
 */