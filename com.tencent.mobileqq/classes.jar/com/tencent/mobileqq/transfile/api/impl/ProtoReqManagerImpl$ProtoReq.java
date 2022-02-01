package com.tencent.mobileqq.transfile.api.impl;

public class ProtoReqManagerImpl$ProtoReq
{
  public Object busiData;
  public ProtoReqManagerImpl.IProtoRespBack callback;
  public int fixScheduleCount = 3;
  public boolean isFastResendEnable = true;
  public boolean isNeedRemindSlowNetwork = true;
  public int noMsfSuggestRetryTime = 450000;
  public byte[] reqBody;
  ProtoReqManagerImpl.ProtoResp resp;
  public String ssoCmd;
  public int timeSpace = 25;
  public int tryCount = 9;
  public int tryTime = 480000;
  
  public void setEasyRetryMode()
  {
    this.tryTime = 30000;
    this.tryCount = 1;
    this.fixScheduleCount = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq
 * JD-Core Version:    0.7.0.1
 */