package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class j
  extends e
{
  Long a = null;
  String m;
  String n;
  
  public j(Context paramContext, String paramString1, String paramString2, int paramInt, Long paramLong, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.n = paramString1;
    this.m = paramString2;
    this.a = paramLong;
  }
  
  public EventType a()
  {
    return EventType.PAGE_VIEW;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "pi", this.m);
    r.a(paramJSONObject, "rf", this.n);
    if (this.a != null) {
      paramJSONObject.put("du", this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.j
 * JD-Core Version:    0.7.0.1
 */