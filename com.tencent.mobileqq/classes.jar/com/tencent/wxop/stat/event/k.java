package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.a;
import com.tencent.wxop.stat.common.b;
import com.tencent.wxop.stat.common.l;
import org.json.JSONObject;

public class k
  extends e
{
  private b a;
  private JSONObject m = null;
  
  public k(Context paramContext, int paramInt, JSONObject paramJSONObject, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.a = new b(paramContext);
    this.m = paramJSONObject;
  }
  
  public EventType a()
  {
    return EventType.SESSION_ENV;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (this.e != null) {
      paramJSONObject.put("ut", this.e.d());
    }
    if (this.m != null) {
      paramJSONObject.put("cfg", this.m);
    }
    if (l.w(this.l)) {
      paramJSONObject.put("ncts", 1);
    }
    this.a.a(paramJSONObject, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.k
 * JD-Core Version:    0.7.0.1
 */