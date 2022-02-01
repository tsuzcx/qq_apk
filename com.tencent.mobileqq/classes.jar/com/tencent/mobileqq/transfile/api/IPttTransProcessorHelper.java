package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IPttTransProcessorHelper
  extends QRouteApi
{
  public abstract boolean checkIsJsPttClass(IHttpCommunicatorListener paramIHttpCommunicatorListener);
  
  public abstract BaseTransProcessor createPttTransProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest);
  
  public abstract Class getC2CPttDownloadProcessorClass();
  
  public abstract Class getC2CPttUpProcessorClass();
  
  public abstract Class getGroupPttDownloadProcessorClass();
  
  public abstract Class getGroupPttUpProcessorClass();
  
  public abstract Class getJSPttDownloadProcessorClass();
  
  public abstract Class getJSPttUpProcessorClass();
  
  public abstract Class getPAAudioDownloadProcessorClass();
  
  public abstract String getPAAudioPttPath(AppRuntime paramAppRuntime, String paramString);
  
  public abstract Class getSlicePttUpProcessorClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
 * JD-Core Version:    0.7.0.1
 */