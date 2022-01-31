package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.a;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class i
  extends e
{
  private static String a = null;
  private String m = null;
  private String n = null;
  
  public i(Context paramContext, int paramInt, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.m = a.a(paramContext).b();
    if (a == null) {
      a = l.g(paramContext);
    }
  }
  
  public EventType a()
  {
    return EventType.NETWORK_MONITOR;
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "op", a);
    r.a(paramJSONObject, "cn", this.m);
    paramJSONObject.put("sp", this.n);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.i
 * JD-Core Version:    0.7.0.1
 */