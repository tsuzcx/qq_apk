package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.e.a;
import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.f;
import com.tencent.qapmsdk.impl.instrumentation.i;
import com.tencent.qapmsdk.impl.instrumentation.k.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  public final Set<UUID> a = Collections.synchronizedSet(new HashSet());
  public f b;
  protected long c = System.currentTimeMillis();
  protected final ConcurrentHashMap<UUID, i> d = new ConcurrentHashMap();
  private boolean e = false;
  private k.b f;
  private long g = 0L;
  private long h;
  
  public h(f paramf, long paramLong, k.b paramb)
  {
    this.b = paramf;
    this.b.e = System.currentTimeMillis();
    this.b.c = 0;
    this.f = paramb;
    this.g = paramLong;
  }
  
  private JSONObject a(long paramLong, i parami, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    double d1;
    if (paramBoolean)
    {
      d1 = parami.e / 1000.0D;
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
      localJSONObject.put("stage", parami.g);
      localJSONObject.put("sub_stage", parami.h);
      localJSONObject.put("extra_info", "");
      localJSONObject.put("process_name", "");
      localJSONObject.put("is_slow", 0);
      return localJSONObject;
      d1 = parami.f / 1000.0D;
      break;
      paramLong = parami.f - parami.e;
      break label51;
    }
  }
  
  public h a()
  {
    if (this.e) {
      return null;
    }
    this.e = true;
    this.b.f = System.currentTimeMillis();
    this.h = this.b.f;
    return this;
  }
  
  public void a(long paramLong)
  {
    this.b.e = paramLong;
    this.c = paramLong;
  }
  
  public void a(QAPMMonitorThreadLocal paramQAPMMonitorThreadLocal)
  {
    a locala = a.a();
    long l1 = this.b.f - this.b.e;
    if (l1 > 30000L)
    {
      paramQAPMMonitorThreadLocal.d();
      return;
    }
    long l2 = this.b.e;
    long l3 = this.b.e;
    long l4 = this.b.f;
    Object localObject1 = this.b.g;
    Object localObject2 = this.b.h;
    if (l1 > this.g) {}
    i locali;
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
        locali = (i)((Iterator)localObject1).next();
        locala.a(this.b.e, locali.e, locali.f, locali.g, locali.h, false);
      }
    }
    if (l1 > this.g) {
      try
      {
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(a(this.b.e, this.b, true));
        ((JSONArray)localObject1).put(a(this.b.e, this.b, false));
        if (localObject2 != null)
        {
          localObject2 = ((Vector)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            locali = (i)((Iterator)localObject2).next();
            ((JSONArray)localObject1).put(a(this.b.e, locali, true));
            ((JSONArray)localObject1).put(a(this.b.e, locali, false));
            continue;
            locala.d();
          }
        }
      }
      catch (JSONException localJSONException) {}
    }
    for (;;)
    {
      paramQAPMMonitorThreadLocal.d();
      return;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("manu_tags", localJSONException);
      if (b.a.contains(this.b.h)) {
        locala.a(l1, this.b.e, this.b.h, ((JSONObject)localObject2).toString());
      } else {
        locala.a(l1, this.b.e, this.b.g, ((JSONObject)localObject2).toString());
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.b.f = paramLong;
    this.h = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.h
 * JD-Core Version:    0.7.0.1
 */