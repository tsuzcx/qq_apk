package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class ProtoReqManagerImpl$ProtoResp
{
  public int freeRunnalbleIndex;
  boolean processed = false;
  public ProtoReqManagerImpl.ProtoReq req;
  public FromServiceMsg resp;
  public ProtoReqManagerImpl.ProtoReqRunnable[] runs;
  public long startTime;
  public StatictisInfo statisInfo = new StatictisInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
 * JD-Core Version:    0.7.0.1
 */