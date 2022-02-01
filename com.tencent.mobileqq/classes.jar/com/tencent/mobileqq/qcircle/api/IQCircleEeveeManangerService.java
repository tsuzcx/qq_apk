package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQCircleEeveeManangerService
  extends IRuntimeService
{
  public abstract void deleteAllRecomAutoTemplateData();
  
  public abstract void deleteBizUndealMsgBuffer(int paramInt);
  
  public abstract void deleteOneRecomAutoTemplateData(String paramString);
  
  public abstract byte[] getBizUndealMsgBuffer(int paramInt);
  
  public abstract void onSend(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService
 * JD-Core Version:    0.7.0.1
 */