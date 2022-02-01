package com.tencent.mobileqq.service.message;

import MessageSvcPack.SvcResponseGetMsgV2;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract interface MessageFactoryReceiver$Callback
{
  public abstract String a(int paramInt);
  
  public abstract void a(FromServiceMsg paramFromServiceMsg, SvcResponseGetMsgV2 paramSvcResponseGetMsgV2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageFactoryReceiver.Callback
 * JD-Core Version:    0.7.0.1
 */