package com.tencent.mobileqq.qqconnectface;

import com.tencent.mobileqq.identification.IResourceObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IResourceObserverApi
  extends QRouteApi
{
  public abstract void requestFaceManage(AppRuntime paramAppRuntime, IResourceObserver paramIResourceObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.IResourceObserverApi
 * JD-Core Version:    0.7.0.1
 */