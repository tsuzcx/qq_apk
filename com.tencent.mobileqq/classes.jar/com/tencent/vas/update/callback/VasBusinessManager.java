package com.tencent.vas.update.callback;

import com.tencent.vas.update.VasUpdateSystem;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.module.NotificationModule;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

public abstract class VasBusinessManager
{
  protected NotificationModule mNotificationModule = new NotificationModule();
  protected BaseUpdateBusiness[] mRegisterBusiness;
  
  public VasBusinessManager()
  {
    VasUpdateWrapper.setVasUpdateWrapper(createVasUpdateFactory());
    regiserObservers();
    VasUpdateSystem.getInstance().setNotification(this.mNotificationModule);
  }
  
  private void addObserver(BaseUpdateBusiness[] paramArrayOfBaseUpdateBusiness)
  {
    int j = paramArrayOfBaseUpdateBusiness.length;
    int i = 0;
    if (i < j)
    {
      BaseUpdateBusiness localBaseUpdateBusiness = paramArrayOfBaseUpdateBusiness[i];
      if ((localBaseUpdateBusiness == null) || (localBaseUpdateBusiness.getBid() <= 0L)) {}
      for (;;)
      {
        i += 1;
        break;
        this.mNotificationModule.addObserver(Long.valueOf(localBaseUpdateBusiness.getBid()), localBaseUpdateBusiness);
      }
    }
  }
  
  protected abstract IVasUpdateFactory createVasUpdateFactory();
  
  public void destoryBusinessCallbacks()
  {
    this.mNotificationModule.clearObservers();
    this.mRegisterBusiness = null;
  }
  
  public BaseUpdateBusiness getBusinessCallback(long paramLong)
  {
    if (this.mNotificationModule.getObserver(Long.valueOf(paramLong)) == null) {
      throw new NullPointerException("bid doesn't resiter or has been register , you need to reuse the same bid callback ， bid = " + paramLong);
    }
    return (BaseUpdateBusiness)this.mNotificationModule.getObserver(Long.valueOf(paramLong));
  }
  
  public <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass)
  {
    if (this.mNotificationModule.getObserver(paramClass) == null) {
      throw new NullPointerException("bid has been register , you need to reuse the same bid callback，class = " + paramClass);
    }
    return this.mNotificationModule.getObserver(paramClass);
  }
  
  public void onDestory()
  {
    destoryBusinessCallbacks();
  }
  
  public void regiserObservers()
  {
    this.mRegisterBusiness = registerBusinessCallback();
    addObserver(this.mRegisterBusiness);
    BaseUpdateBusiness localBaseUpdateBusiness = registerCommonBusinessCallback();
    if (localBaseUpdateBusiness != null) {
      this.mNotificationModule.setDefaultCallback(localBaseUpdateBusiness);
    }
  }
  
  public abstract BaseUpdateBusiness[] registerBusinessCallback();
  
  protected BaseUpdateBusiness registerCommonBusinessCallback()
  {
    return null;
  }
  
  public void updateAllItem()
  {
    VasUpdateSystem.getInstance().updateAllItem();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.callback.VasBusinessManager
 * JD-Core Version:    0.7.0.1
 */