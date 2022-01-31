package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatAccount;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class a
  extends e
{
  private StatAccount a = null;
  
  public a(Context paramContext, int paramInt, StatAccount paramStatAccount, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.a = paramStatAccount;
  }
  
  public EventType a()
  {
    return EventType.ADDITION;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "qq", this.a.getAccount());
    paramJSONObject.put("acc", this.a.toJsonString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.a
 * JD-Core Version:    0.7.0.1
 */