package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdvertisementInfoModule;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.biz.ad.IRIJAdvertisementRequestProxy;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ExecutorService;

public class AdvertisementInfoModuleRequestProxy
  extends ReadInJoyEngineModule
  implements IRIJAdvertisementRequestProxy
{
  private IFindRemovedEntity<AdvertisementInfo> a = new AdvertisementInfoModuleRequestProxy.1(this);
  
  public AdvertisementInfoModuleRequestProxy(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    registerEntityFinder(AdvertisementInfo.class, this.a);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.sendPbReq(paramToServiceMsg);
  }
  
  public boolean a(Entity paramEntity)
  {
    return super.updateEntity(paramEntity);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = (IRIJAdvertisementInfoModule)((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().c();
    if (localIRIJAdvertisementInfoModule != null) {
      localIRIJAdvertisementInfoModule.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.AdvertisementInfoModuleRequestProxy
 * JD-Core Version:    0.7.0.1
 */