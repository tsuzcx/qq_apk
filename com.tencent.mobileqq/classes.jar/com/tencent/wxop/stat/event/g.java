package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatAppMonitor;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.a;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class g
  extends e
{
  private static String m = null;
  private static String n = null;
  private StatAppMonitor a = null;
  
  public g(Context paramContext, int paramInt, StatAppMonitor paramStatAppMonitor, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.a = paramStatAppMonitor.clone();
  }
  
  public EventType a()
  {
    return EventType.MONITOR_STAT;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (this.a == null) {
      return false;
    }
    paramJSONObject.put("na", this.a.getInterfaceName());
    paramJSONObject.put("rq", this.a.getReqSize());
    paramJSONObject.put("rp", this.a.getRespSize());
    paramJSONObject.put("rt", this.a.getResultType());
    paramJSONObject.put("tm", this.a.getMillisecondsConsume());
    paramJSONObject.put("rc", this.a.getReturnCode());
    paramJSONObject.put("sp", this.a.getSampling());
    if (n == null) {
      n = l.l(this.l);
    }
    r.a(paramJSONObject, "av", n);
    if (m == null) {
      m = l.g(this.l);
    }
    r.a(paramJSONObject, "op", m);
    paramJSONObject.put("cn", a.a(this.l).b());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.g
 * JD-Core Version:    0.7.0.1
 */