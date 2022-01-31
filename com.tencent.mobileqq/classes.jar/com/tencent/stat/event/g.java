package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.a;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends d
{
  private a a;
  private JSONObject p = null;
  
  public g(Context paramContext, int paramInt, JSONObject paramJSONObject, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.a = new a(paramContext, paramStatSpecifyReportedInfo);
    this.p = paramJSONObject;
  }
  
  public EventType a()
  {
    return EventType.SESSION_ENV;
  }
  
  public boolean a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (this.e != null) {
      paramJSONObject.put("ut", this.e.getUserType());
    }
    if (this.p != null) {
      paramJSONObject.put("cfg", this.p);
    }
    if (StatCommonHelper.needCheckTime(this.n)) {
      paramJSONObject.put("ncts", 1);
    }
    this.a.a(paramJSONObject, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.event.g
 * JD-Core Version:    0.7.0.1
 */