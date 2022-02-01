package com.tencent.mobileqq.kandian.repo.common;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.IReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public abstract class ReadInJoyEngineModule
  implements IReadInJoyEngineModule
{
  public static final String TAG = "ReadInJoyEngineModule";
  private Map<Class<? extends Entity>, IFindRemovedEntity<? extends Entity>> entityFinderMap = new ConcurrentHashMap();
  protected AppInterface mApp;
  protected EntityManager mEntityManager;
  protected ExecutorService mExecutorService;
  protected ReadInJoyMSFService mMSFService;
  protected Handler mMainThreadHandler;
  
  public ReadInJoyEngineModule()
  {
    this.mMSFService = ReadInJoyMSFService.getInstance();
  }
  
  public ReadInJoyEngineModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, Handler paramHandler)
  {
    this.mApp = paramAppInterface;
    this.mExecutorService = paramExecutorService;
    this.mMSFService = ReadInJoyMSFService.getInstance();
    this.mEntityManager = paramEntityManager;
    this.mMainThreadHandler = paramHandler;
  }
  
  public ReadInJoyEngineModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    this.mApp = paramAppInterface;
    this.mExecutorService = paramExecutorService;
    this.mMSFService = paramReadInJoyMSFService;
    this.mEntityManager = paramEntityManager;
    this.mMainThreadHandler = paramHandler;
  }
  
  public abstract void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  public void registerEntityFinder(Class<? extends Entity> paramClass, IFindRemovedEntity<? extends Entity> paramIFindRemovedEntity)
  {
    this.entityFinderMap.put(paramClass, paramIFindRemovedEntity);
  }
  
  public void removeEntityIfExistsInDB(Entity paramEntity)
  {
    IFindRemovedEntity localIFindRemovedEntity;
    if (paramEntity != null) {
      localIFindRemovedEntity = (IFindRemovedEntity)this.entityFinderMap.get(paramEntity.getClass());
    } else {
      localIFindRemovedEntity = null;
    }
    if (localIFindRemovedEntity != null)
    {
      paramEntity = localIFindRemovedEntity.a(this.mEntityManager, paramEntity);
      if (paramEntity != null) {
        this.mEntityManager.remove(paramEntity);
      }
    }
  }
  
  public void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      ReadInJoyMSFService localReadInJoyMSFService = this.mMSFService;
      if (localReadInJoyMSFService != null) {
        localReadInJoyMSFService.sendPbRequest(paramToServiceMsg, this);
      }
    }
  }
  
  public void sendPbReqWithAutoRetry(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.addAttribute("req_enable_msf_retry", Boolean.valueOf(true));
      QLog.d("ReadInJoyEngineModule", 2, "sendPbReqWithAutoRetry ");
    }
    sendPbReq(paramToServiceMsg);
  }
  
  public abstract void unInitialize();
  
  public boolean updateEntity(Entity paramEntity)
  {
    try
    {
      int i = paramEntity.getStatus();
      boolean bool = false;
      if (i == 1000)
      {
        removeEntityIfExistsInDB(paramEntity);
        this.mEntityManager.persistOrReplace(paramEntity);
        i = paramEntity.getStatus();
        if (i == 1001) {
          bool = true;
        }
        return bool;
      }
      if (paramEntity.getStatus() != 1001)
      {
        i = paramEntity.getStatus();
        if (i != 1002) {
          return false;
        }
      }
      bool = this.mEntityManager.update(paramEntity);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule
 * JD-Core Version:    0.7.0.1
 */