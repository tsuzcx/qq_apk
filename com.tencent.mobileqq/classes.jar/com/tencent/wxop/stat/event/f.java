package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatGameUser;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class f
  extends e
{
  private StatGameUser a = null;
  
  public f(Context paramContext, int paramInt, StatGameUser paramStatGameUser, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt, paramStatSpecifyReportedInfo);
    this.a = paramStatGameUser.clone();
  }
  
  public EventType a()
  {
    return EventType.MTA_GAME_USER;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (this.a == null) {
      return false;
    }
    r.a(paramJSONObject, "wod", this.a.getWorldName());
    r.a(paramJSONObject, "gid", this.a.getAccount());
    r.a(paramJSONObject, "lev", this.a.getLevel());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.f
 * JD-Core Version:    0.7.0.1
 */