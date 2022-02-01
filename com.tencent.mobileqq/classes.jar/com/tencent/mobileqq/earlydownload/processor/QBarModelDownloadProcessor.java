package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi;
import mqq.app.AppRuntime;

public class QBarModelDownloadProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return ((IQRScanEarlyHandlerApi)QRoute.api(IQRScanEarlyHandlerApi.class)).getHandler(3, paramAppRuntime);
  }
  
  public String a()
  {
    return ((IQRScanEarlyHandlerApi)QRoute.api(IQRScanEarlyHandlerApi.class)).getResName(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.QBarModelDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */