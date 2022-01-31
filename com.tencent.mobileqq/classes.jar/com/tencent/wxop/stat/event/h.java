package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class h
  extends e
{
  public static final StatSpecifyReportedInfo a;
  
  static
  {
    StatSpecifyReportedInfo localStatSpecifyReportedInfo = new StatSpecifyReportedInfo();
    a = localStatSpecifyReportedInfo;
    localStatSpecifyReportedInfo.setAppKey("A9VH9B8L4GX4");
  }
  
  public h(Context paramContext)
  {
    super(paramContext, 0, a);
  }
  
  public EventType a()
  {
    return EventType.NETWORK_DETECTOR;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "actky", StatConfig.getAppKey(this.l));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.h
 * JD-Core Version:    0.7.0.1
 */