package com.tencent.mobileqq.msf.core.net.d.a;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class n
  implements b, d
{
  private static final String a = "UdpTimeCostReportFilter";
  private static final String b = "UdpTimeCost";
  private static final String c = "UdpRetryCount";
  private static final String d = "UdpOnlySuccess";
  private static final String e = "UdpFirstSend";
  private final Map f = new TreeMap();
  
  public static n a()
  {
    return n.a.a();
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg)
  {
    boolean bool4 = false;
    if (paramToServiceMsg == null) {
      return false;
    }
    Object localObject = MsfCore.sCore.sender;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((ad)localObject).d.contains(paramToServiceMsg);
    } else {
      bool1 = true;
    }
    localObject = MsfCore.sCore.quicksender;
    boolean bool2;
    if (localObject != null) {
      bool2 = ((com.tencent.mobileqq.msf.core.quicksend.b)localObject).c(paramToServiceMsg);
    } else {
      bool2 = true;
    }
    boolean bool3 = bool4;
    if (bool1)
    {
      bool3 = bool4;
      if (bool2) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public FromServiceMsg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    if (!paramFromServiceMsg.isSuccess()) {
      return paramFromServiceMsg;
    }
    Object localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramToServiceMsg));
    localStringBuilder.append("");
    ((Map)localObject).put("UdpOnlySuccess", localStringBuilder.toString());
    MsfCore.sCore.statReporter.a("MSF_WN_UdpSuccCount", paramFromServiceMsg.isSuccess(), 0L, 0L, this.f, false, false);
    localObject = (Long)paramToServiceMsg.getAttribute("attr_udp_send_time");
    if (localObject != null)
    {
      long l = SystemClock.uptimeMillis() - ((Long)localObject).longValue();
      this.f.put("UdpTimeCost", String.valueOf(l));
      localObject = (Integer)paramToServiceMsg.getAttribute("attr_udp_retry_count");
      this.f.put("UdpRetryCount", String.valueOf(localObject));
      MsfCore.sCore.statReporter.a("MSF_WN_UdpTimeCost", paramFromServiceMsg.isSuccess(), 0L, 0L, this.f, false, false);
      QLog.d("UdpTimeCostReportFilter", 1, new Object[] { "[filter] report udp cost time: ", Long.valueOf(l), a.a(paramFromServiceMsg), ", retryCount: ", localObject, ", wait send:", Boolean.valueOf(b(paramToServiceMsg)) });
    }
    return paramFromServiceMsg;
  }
  
  public ToServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    Object localObject = (Long)paramToServiceMsg.getAttribute("attr_udp_send_time");
    boolean bool;
    if (localObject == null)
    {
      localObject = Long.valueOf(SystemClock.uptimeMillis());
      paramToServiceMsg.addAttribute("attr_udp_send_time", localObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    QLog.d("UdpTimeCostReportFilter", 2, new Object[] { "[filter] sendTime: ", localObject, a.a(paramToServiceMsg), ", firstSend: ", Boolean.valueOf(bool) });
    localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(bool);
    localStringBuilder.append("");
    ((Map)localObject).put("UdpFirstSend", localStringBuilder.toString());
    MsfCore.sCore.statReporter.a("MSF_WN_UdpSendCount", true, 0L, 0L, this.f, false, false);
    return paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.n
 * JD-Core Version:    0.7.0.1
 */