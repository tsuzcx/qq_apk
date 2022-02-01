package com.tencent.mobileqq.richmediabrowser.api;

import android.text.SpannableString;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDanmuDataIPCServer
  extends QRouteApi
{
  public static final String NAME = "DanmuDataIPCServer";
  
  public abstract QIPCModule getDanmuIPCServer();
  
  public abstract void notifyDanmuSendResult(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, SpannableString paramSpannableString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer
 * JD-Core Version:    0.7.0.1
 */