package com.tencent.mobileqq.ptt.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVoiceChangeTempApi
  extends QRouteApi
{
  public abstract String getContentPicHost();
  
  public abstract boolean isLaterVersion(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.IVoiceChangeTempApi
 * JD-Core Version:    0.7.0.1
 */