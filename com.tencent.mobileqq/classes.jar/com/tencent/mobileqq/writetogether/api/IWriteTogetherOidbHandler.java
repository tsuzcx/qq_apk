package com.tencent.mobileqq.writetogether.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.writetogether.data.CreateDocParam;

@QAPI(process={""})
public abstract interface IWriteTogetherOidbHandler
  extends QRouteApi
{
  public abstract void createDoc(CreateDocParam paramCreateDocParam, String paramString);
  
  public abstract void openDoc(String paramString1, String paramString2);
  
  public abstract void pullDoc(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void sendForwardWtMessage(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void sendGrayTip(String paramString1, String paramString2, String paramString3);
  
  public abstract void sendWtMessage(String paramString1, String paramString2, int paramInt, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.IWriteTogetherOidbHandler
 * JD-Core Version:    0.7.0.1
 */