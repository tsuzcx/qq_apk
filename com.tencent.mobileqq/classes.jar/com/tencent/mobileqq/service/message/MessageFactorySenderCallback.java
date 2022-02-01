package com.tencent.mobileqq.service.message;

import MessageSvcPack.SvcRequestSendVideoMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.qqperf.monitor.crash.ReportLog;

public class MessageFactorySenderCallback
  implements MessageFactorySender.Callback
{
  public int a(String paramString)
  {
    return StreamDataManager.b(paramString);
  }
  
  public short a(String paramString)
  {
    return StreamDataManager.a(paramString);
  }
  
  public void a(SvcRequestSendVideoMsg paramSvcRequestSendVideoMsg, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Send video message :selfUin = ");
    localStringBuilder.append(paramSvcRequestSendVideoMsg.lUin);
    localStringBuilder.append(" toUin = ");
    localStringBuilder.append(paramSvcRequestSendVideoMsg.lPeerUin);
    localStringBuilder.append(" buffer[2] = ");
    localStringBuilder.append(paramString);
    ReportLog.a("Video", localStringBuilder.toString());
  }
  
  public boolean a(String paramString)
  {
    return StreamDataManager.a(paramString);
  }
  
  public byte[] a(String paramString)
  {
    return EmotionCodecUtils.a(paramString);
  }
  
  public byte[] a(String paramString, short paramShort)
  {
    return StreamDataManager.a(paramString, paramShort);
  }
  
  public short b(String paramString)
  {
    return StreamDataManager.b(paramString);
  }
  
  public boolean b(String paramString)
  {
    return ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageFactorySenderCallback
 * JD-Core Version:    0.7.0.1
 */