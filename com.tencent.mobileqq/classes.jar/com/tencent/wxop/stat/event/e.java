package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.au;
import com.tencent.wxop.stat.common.a;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public abstract class e
{
  protected static String j = null;
  private StatSpecifyReportedInfo a = null;
  protected String b = null;
  protected long c;
  protected int d;
  protected a e = null;
  protected int f;
  protected String g = null;
  protected String h = null;
  protected String i = null;
  protected boolean k = false;
  protected Context l;
  
  e(Context paramContext, int paramInt, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    this.l = paramContext;
    this.c = (System.currentTimeMillis() / 1000L);
    this.d = paramInt;
    this.h = StatConfig.getInstallChannel(paramContext);
    this.i = l.h(paramContext);
    this.b = StatConfig.getAppKey(paramContext);
    if (paramStatSpecifyReportedInfo != null)
    {
      this.a = paramStatSpecifyReportedInfo;
      if (l.c(paramStatSpecifyReportedInfo.getAppKey())) {
        this.b = paramStatSpecifyReportedInfo.getAppKey();
      }
      if (l.c(paramStatSpecifyReportedInfo.getInstallChannel())) {
        this.h = paramStatSpecifyReportedInfo.getInstallChannel();
      }
      if (l.c(paramStatSpecifyReportedInfo.getVersion())) {
        this.i = paramStatSpecifyReportedInfo.getVersion();
      }
      this.k = paramStatSpecifyReportedInfo.isImportant();
    }
    this.g = StatConfig.getCustomUserId(paramContext);
    this.e = au.a(paramContext).b(paramContext);
    if (a() != EventType.NETWORK_DETECTOR) {}
    for (this.f = l.q(paramContext).intValue();; this.f = (-EventType.NETWORK_DETECTOR.a()))
    {
      if (!h.c(j))
      {
        paramContext = StatConfig.getLocalMidOnly(paramContext);
        j = paramContext;
        if (!l.c(paramContext)) {
          j = "0";
        }
      }
      return;
    }
  }
  
  public abstract EventType a();
  
  public abstract boolean a(JSONObject paramJSONObject);
  
  public boolean b(JSONObject paramJSONObject)
  {
    try
    {
      r.a(paramJSONObject, "ky", this.b);
      paramJSONObject.put("et", a().a());
      if (this.e != null)
      {
        paramJSONObject.put("ui", this.e.b());
        r.a(paramJSONObject, "mc", this.e.c());
        int m = this.e.d();
        paramJSONObject.put("ut", m);
        if ((m == 0) && (l.u(this.l) == 1)) {
          paramJSONObject.put("ia", 1);
        }
      }
      r.a(paramJSONObject, "cui", this.g);
      if (a() != EventType.SESSION_ENV)
      {
        r.a(paramJSONObject, "av", this.i);
        r.a(paramJSONObject, "ch", this.h);
      }
      if (this.k) {
        paramJSONObject.put("impt", 1);
      }
      r.a(paramJSONObject, "mid", j);
      paramJSONObject.put("cch", "wxop");
      paramJSONObject.put("idx", this.f);
      paramJSONObject.put("si", this.d);
      paramJSONObject.put("ts", this.c);
      paramJSONObject.put("dts", l.a(this.l, false));
      boolean bool = a(paramJSONObject);
      return bool;
    }
    catch (Throwable paramJSONObject) {}
    return false;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public StatSpecifyReportedInfo d()
  {
    return this.a;
  }
  
  public Context e()
  {
    return this.l;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public String g()
  {
    try
    {
      Object localObject = new JSONObject();
      b((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.e
 * JD-Core Version:    0.7.0.1
 */