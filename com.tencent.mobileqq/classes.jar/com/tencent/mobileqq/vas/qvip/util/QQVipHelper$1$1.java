package com.tencent.mobileqq.vas.qvip.util;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;

class QQVipHelper$1$1
  implements Runnable
{
  QQVipHelper$1$1(QQVipHelper.1 param1, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    IPublicAccountDetail localIPublicAccountDetail = (IPublicAccountDetail)QRoute.api(IPublicAccountDetail.class);
    localIPublicAccountDetail.init(this.a);
    Object localObject = this.b;
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    if (localObject != null) {
      ((EntityManager)localObject).persistOrReplace(localIPublicAccountDetail.getEntity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.util.QQVipHelper.1.1
 * JD-Core Version:    0.7.0.1
 */