package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQRScanEarlyHandlerApi
  extends QRouteApi
{
  public static final int TYPE_MINI_DECODE_SO = 0;
  public static final int TYPE_MINI_DETECT_MODEL = 2;
  public static final int TYPE_MINI_DETECT_SO = 1;
  public static final int TYPE_QBAR_AI_MODEL = 3;
  public static final int TYPE_VOICE_SCAN_CHIRP = 4;
  
  public abstract EarlyHandler getHandler(int paramInt, AppRuntime paramAppRuntime);
  
  public abstract String getResName(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi
 * JD-Core Version:    0.7.0.1
 */