package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/api/IQQGameFlutterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isAppInstalled", "", "isEngineInstalled", "preloadFlutter", "", "qqgamepubaccount-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IQQGameFlutterApi
  extends QRouteApi
{
  public abstract boolean isAppInstalled();
  
  public abstract boolean isEngineInstalled();
  
  public abstract void preloadFlutter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi
 * JD-Core Version:    0.7.0.1
 */