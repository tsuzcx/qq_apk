package com.tencent.mobileqq.vas.hippy.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

@QAPI(process={"all"})
public abstract interface IVasHippyApi
  extends QRouteApi
{
  public abstract HippyAPIProvider createHippyAPIProvider();
  
  public abstract HippyCustomViewCreator createHippyCustomViewCreator();
  
  public abstract boolean isVasModule(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.api.IVasHippyApi
 * JD-Core Version:    0.7.0.1
 */