package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQCircleColdBootService
  extends QRouteApi
{
  public abstract void clear(int paramInt);
  
  public abstract IPreloadTask getTask(int paramInt);
  
  public abstract boolean isAvailable(int paramInt);
  
  public abstract void lock();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void unlock();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleColdBootService
 * JD-Core Version:    0.7.0.1
 */