package com.tencent.mobileqq.transfile;

import anza;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class ProtoReqManager$ProtoResp
{
  public int freeRunnalbleIndex;
  boolean processed = false;
  public ProtoReqManager.ProtoReq req;
  public FromServiceMsg resp;
  public ProtoReqManager.ProtoReqRunnable[] runs;
  public long startTime;
  public anza statisInfo = new anza();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp
 * JD-Core Version:    0.7.0.1
 */