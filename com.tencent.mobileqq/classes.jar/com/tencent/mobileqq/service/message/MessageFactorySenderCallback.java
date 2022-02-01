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
    return StreamDataManager.d(paramString);
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
  
  public byte[] a(String paramString, short paramShort)
  {
    return StreamDataManager.b(paramString, paramShort);
  }
  
  public short b(String paramString)
  {
    return StreamDataManager.e(paramString);
  }
  
  public short c(String paramString)
  {
    return StreamDataManager.g(paramString);
  }
  
  public boolean d(String paramString)
  {
    return StreamDataManager.i(paramString);
  }
  
  public boolean e(String paramString)
  {
    return ((IStreamDataManager)QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(paramString);
  }
  
  public byte[] f(String paramString)
  {
    return EmotionCodecUtils.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageFactorySenderCallback
 * JD-Core Version:    0.7.0.1
 */