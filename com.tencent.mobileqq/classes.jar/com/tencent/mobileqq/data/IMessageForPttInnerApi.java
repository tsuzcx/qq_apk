package com.tencent.mobileqq.data;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMessageForPttInnerApi
  extends QRouteApi
{
  public abstract String getLocalFilePath(int paramInt, String paramString);
  
  public abstract String getMsgFilePath(int paramInt, String paramString);
  
  public abstract String getSummaryMsg(String paramString, int paramInt);
  
  public abstract String getTmpFilePath(String paramString);
  
  public abstract boolean hasSttTxt(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.IMessageForPttInnerApi
 * JD-Core Version:    0.7.0.1
 */