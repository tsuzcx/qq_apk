package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmoticonBusinessProxyApi
  extends QRouteApi
{
  public abstract String getCameraEmoHandlerImplClassName();
  
  public abstract String getEmoticonHandlerImplClassName();
  
  public abstract String getFavEmoHandlerImplClassName();
  
  public abstract String getRelatedEmoHandlerImplClassName();
  
  public abstract String getVipComicMqqHandlerImplClassName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
 * JD-Core Version:    0.7.0.1
 */