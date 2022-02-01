package com.tencent.mobileqq.msf.sdk.b;

import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class e$f
  extends e.a
{
  public static final String b = "msf.sdk.event_sendToServiceCost";
  
  private void a(long paramLong)
  {
    a("proxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
    a("cost", String.valueOf(paramLong));
    a("msf.sdk.event_sendToServiceCost", true, paramLong, 0L, true);
  }
  
  public static f b()
  {
    return e.f.a.a();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while (paramInt <= 0);
      l1 = System.currentTimeMillis();
      paramToServiceMsg.addAttribute("to_SendSuccTime", Long.valueOf(l1));
      l2 = ((Long)paramToServiceMsg.getAttribute("to_appSendMsg", Long.valueOf(0L))).longValue();
    } while (l2 <= 0L);
    a(l1 - l2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if ((!paramBoolean) && (!MsfCommand.reportRdm.equals(paramToServiceMsg.getMsfCommand())) && (!"App_reportRDM".equals(paramToServiceMsg.getServiceCmd()))) {
      paramToServiceMsg.addAttribute("to_appSendMsg", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b.e.f
 * JD-Core Version:    0.7.0.1
 */