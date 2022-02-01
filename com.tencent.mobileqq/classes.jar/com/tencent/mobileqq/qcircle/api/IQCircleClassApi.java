package com.tencent.mobileqq.qcircle.api;

import com.qflutter.vistaimage.IVistaImage;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQCircleClassApi
  extends QRouteApi
{
  public abstract boolean checkIsQCirclePluginLoadingActivity(QBaseActivity paramQBaseActivity);
  
  public abstract Class<? extends IApplicationDelegate> getQCircleApplicationDelegateClass();
  
  public abstract Class getQCircleHandlerClass();
  
  public abstract Class getQCircleHostTransFragmentClass();
  
  public abstract Class getQCircleHostTransLoginOutFragmentClass();
  
  public abstract IVistaImage getQCircleVistaImageInstance();
  
  public abstract BaseRequest getQQCircleGetGroupCountRequest(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleClassApi
 * JD-Core Version:    0.7.0.1
 */