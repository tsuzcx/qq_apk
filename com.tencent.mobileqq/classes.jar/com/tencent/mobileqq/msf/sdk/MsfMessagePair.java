package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MsfMessagePair
{
  public FromServiceMsg fromServiceMsg;
  public String sendProcess = null;
  public ToServiceMsg toServiceMsg;
  
  public MsfMessagePair(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.sendProcess = null;
    this.toServiceMsg = paramToServiceMsg;
    this.fromServiceMsg = paramFromServiceMsg;
  }
  
  public MsfMessagePair(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.sendProcess = paramString;
    this.toServiceMsg = paramToServiceMsg;
    this.fromServiceMsg = paramFromServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfMessagePair
 * JD-Core Version:    0.7.0.1
 */