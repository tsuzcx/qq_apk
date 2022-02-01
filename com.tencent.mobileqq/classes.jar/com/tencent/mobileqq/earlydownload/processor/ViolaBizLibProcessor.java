package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBizLibHandlerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

public class ViolaBizLibProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return ((IViolaBizLibHandlerFactory)QRoute.api(IViolaBizLibHandlerFactory.class)).createViolaBizLibHandler(paramAppRuntime);
  }
  
  public String a()
  {
    return "android.qq.readinjoy.viola_biz_810";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.ViolaBizLibProcessor
 * JD-Core Version:    0.7.0.1
 */