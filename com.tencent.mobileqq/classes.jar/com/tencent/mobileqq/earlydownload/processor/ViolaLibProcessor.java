package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaLibHandlerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

public class ViolaLibProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return ((IViolaLibHandlerFactory)QRoute.api(IViolaLibHandlerFactory.class)).createViolaLibHandler(paramAppRuntime);
  }
  
  public String a()
  {
    return "android.qq.readinjoy.viola_795";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.ViolaLibProcessor
 * JD-Core Version:    0.7.0.1
 */