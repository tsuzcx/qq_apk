package com.tencent.qapmsdk.impl.appstate;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.e.a;
import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.l.b;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private g a;
  private long b = System.currentTimeMillis();
  private boolean c = false;
  private l.b d;
  private long e = 0L;
  private long f;
  
  j(g paramg, long paramLong, l.b paramb)
  {
    this.a = paramg;
    this.a.e = System.currentTimeMillis();
    this.a.c = 0;
    this.d = paramb;
    this.e = paramLong;
  }
  
  private JSONObject a(long paramLong, com.tencent.qapmsdk.impl.instrumentation.j paramj, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    double d1;
    if (paramBoolean)
    {
      d1 = paramj.e / 1000.0D;
      localJSONObject.put("event_time", d1);
      localJSONObject.put("tag_id", paramLong);
      if (!paramBoolean) {
        break label148;
      }
      paramLong = 0L;
      label51:
      localJSONObject.put("during_time", paramLong);
      if (!paramBoolean) {
        break label161;
      }
    }
    label148:
    label161:
    for (int i = 0;; i = 1)
    {
      localJSONObject.put("type", i);
      localJSONObject.put("stage", paramj.g);
      localJSONObject.put("sub_stage", paramj.h);
      localJSONObject.put("extra_info", "");
      localJSONObject.put("process_name", "");
      localJSONObject.put("is_slow", 0);
      return localJSONObject;
      d1 = paramj.f / 1000.0D;
      break;
      paramLong = paramj.f - paramj.e;
      break label51;
    }
  }
  
  j a()
  {
    if (this.c) {
      return null;
    }
    this.c = true;
    this.a.f = System.currentTimeMillis();
    this.f = this.a.f;
    return this;
  }
  
  void a(long paramLong)
  {
    this.a.e = paramLong;
    this.b = paramLong;
  }
  
  void a(QAPMMonitorThreadLocal paramQAPMMonitorThreadLocal)
  {
    a locala = a.a();
    long l1 = this.a.f - this.a.e;
    if (l1 > 30000L)
    {
      paramQAPMMonitorThreadLocal.d();
      return;
    }
    long l2 = this.a.e;
    long l3 = this.a.e;
    long l4 = this.a.f;
    Object localObject1 = this.a.g;
    Object localObject2 = this.a.h;
    if (l1 > this.e) {}
    com.tencent.qapmsdk.impl.instrumentation.j localj;
    for (boolean bool = true;; bool = false)
    {
      locala.a(l2, l3, l4, (String)localObject1, (String)localObject2, bool);
      localObject2 = (Vector)paramQAPMMonitorThreadLocal.f().get();
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localj = (com.tencent.qapmsdk.impl.instrumentation.j)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(localj.h)) {
          locala.a(this.a.e, localj.e, localj.f, localj.g, localj.h, false);
        }
      }
    }
    try
    {
      localObject1 = new JSONArray();
      ((JSONArray)localObject1).put(a(this.a.e, this.a, true));
      ((JSONArray)localObject1).put(a(this.a.e, this.a, false));
      if (localObject2 != null)
      {
        localObject2 = ((Vector)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localj = (com.tencent.qapmsdk.impl.instrumentation.j)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(localj.h))
          {
            ((JSONArray)localObject1).put(a(this.a.e, localj, true));
            ((JSONArray)localObject1).put(a(this.a.e, localj, false));
            continue;
            locala.d();
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_impl_SectionHarve", "handler start single may be error", localJSONException.getMessage() });
    }
    for (;;)
    {
      paramQAPMMonitorThreadLocal.d();
      return;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("manu_tags", localJSONException);
      if (b.a.contains(this.a.h)) {
        locala.a(l1, this.a.e, this.a.h, ((JSONObject)localObject2).toString());
      } else {
        locala.a(l1, this.a.e, this.a.g, ((JSONObject)localObject2).toString());
      }
    }
  }
  
  void b(long paramLong)
  {
    this.a.f = paramLong;
    this.f = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.j
 * JD-Core Version:    0.7.0.1
 */