package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQRScanIpcApi
  extends QRouteApi
{
  public static final String MODULUE_MAIN = "QRScanMainQIPCModule";
  public static final String MODULUE_SUB = "QRScanSubQIPCModule";
  
  public abstract QIPCModule getModule(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRScanIpcApi
 * JD-Core Version:    0.7.0.1
 */