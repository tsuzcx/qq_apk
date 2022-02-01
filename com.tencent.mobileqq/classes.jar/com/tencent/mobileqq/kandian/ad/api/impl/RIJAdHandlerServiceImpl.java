package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdHandlerService;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;

public class RIJAdHandlerServiceImpl
  implements IRIJAdHandlerService
{
  public IBaseHandler createAdHandler()
  {
    return new AdHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */