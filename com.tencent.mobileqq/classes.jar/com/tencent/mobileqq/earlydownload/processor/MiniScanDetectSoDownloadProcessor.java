package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi;
import mqq.app.AppRuntime;

public class MiniScanDetectSoDownloadProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return ((IQRScanEarlyHandlerApi)QRoute.api(IQRScanEarlyHandlerApi.class)).getHandler(1, paramAppRuntime);
  }
  
  public String a()
  {
    return ((IQRScanEarlyHandlerApi)QRoute.api(IQRScanEarlyHandlerApi.class)).getResName(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.MiniScanDetectSoDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */