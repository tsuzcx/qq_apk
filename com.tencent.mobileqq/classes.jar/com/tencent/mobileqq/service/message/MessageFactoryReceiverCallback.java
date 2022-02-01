package com.tencent.mobileqq.service.message;

import MessageSvcPack.SvcResponseGetMsgV2;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqperf.monitor.crash.ReportLog;
import java.util.ArrayList;

public class MessageFactoryReceiverCallback
  implements MessageFactoryReceiver.Callback
{
  public String a(int paramInt)
  {
    return StreamDataManager.a(paramInt, 0);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, SvcResponseGetMsgV2 paramSvcResponseGetMsgV2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Receive message packet: seq = ");
    localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
    localStringBuilder.append(" size = ");
    localStringBuilder.append(paramSvcResponseGetMsgV2.vMsgInfos.size());
    ReportLog.a("Video", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageFactoryReceiverCallback
 * JD-Core Version:    0.7.0.1
 */