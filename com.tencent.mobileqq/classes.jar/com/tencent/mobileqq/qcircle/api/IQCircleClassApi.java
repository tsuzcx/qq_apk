package com.tencent.mobileqq.qcircle.api;

import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQCircleClassApi
  extends QRouteApi
{
  public abstract Class<? extends IApplicationDelegate> getQCircleApplicationDelegateClass();
  
  public abstract Class getQCircleHostTransFragmentClass();
  
  public abstract BaseRequest getQQCircleGetGroupCountRequest(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleClassApi
 * JD-Core Version:    0.7.0.1
 */