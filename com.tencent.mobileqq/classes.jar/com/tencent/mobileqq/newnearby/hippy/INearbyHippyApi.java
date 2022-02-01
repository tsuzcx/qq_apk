package com.tencent.mobileqq.newnearby.hippy;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

@QAPI(process={"all"})
public abstract interface INearbyHippyApi
  extends QRouteApi
{
  public abstract HippyAPIProvider getNearbyHippyAPIProvider();
  
  public abstract boolean hasNewMessage();
  
  public abstract boolean isCanPreload();
  
  public abstract boolean isNearbyModule(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.INearbyHippyApi
 * JD-Core Version:    0.7.0.1
 */