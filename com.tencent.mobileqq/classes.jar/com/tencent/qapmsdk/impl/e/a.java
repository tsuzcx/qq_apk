package com.tencent.qapmsdk.impl.e;

import android.os.Handler;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.impl.instrumentation.j;
import com.tencent.qapmsdk.resource.meta.SingleItem;
import com.tencent.qapmsdk.resource.meta.TagItem;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  static volatile boolean a = false;
  private static volatile a b = null;
  private final Vector<TagItem> c = new Vector();
  private final Vector<SingleItem> d = new Vector();
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  private JSONObject a(long paramLong, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("event_time", paramDouble1 / 1000.0D);
    localJSONObject.put("tag_id", paramLong);
    localJSONObject.put("during_time", paramDouble2);
    localJSONObject.put("type", paramInt);
    localJSONObject.put("stage", paramString1);
    localJSONObject.put("sub_stage", paramString2);
    localJSONObject.put("extra_info", "");
    localJSONObject.put("process_name", "");
    localJSONObject.put("is_slow", 0);
    return localJSONObject;
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, long paramLong1, long paramLong2, j paramj)
  {
    for (;;)
    {
      int j;
      try
      {
        if (com.tencent.qapmsdk.impl.g.b.e.get()) {
          return;
        }
        Vector localVector = this.d;
        if (paramj == null) {
          break label401;
        }
        i = 1;
        try
        {
          localObject = this.d.iterator();
          j = -1;
          if (((Iterator)localObject).hasNext())
          {
            SingleItem localSingleItem = (SingleItem)((Iterator)localObject).next();
            int k = j + 1;
            if (!com.tencent.qapmsdk.impl.g.b.a.contains(localSingleItem.stage))
            {
              j = k;
              continue;
            }
            JSONObject localJSONObject = new JSONObject(localSingleItem.extraData);
            JSONArray localJSONArray = localJSONObject.getJSONArray("manu_tags");
            j = 0;
            if (j < localJSONArray.length())
            {
              localObject = localJSONArray.getJSONObject(j);
              if (((JSONObject)localObject).getInt("type") != 1) {
                break label392;
              }
              if (paramDouble1 != 0.0D)
              {
                if (i == 0)
                {
                  ((JSONObject)localObject).put("during_time", (paramLong2 - paramDouble1) * 1.0D);
                  ((JSONObject)localObject).put("event_time", paramLong2 / 1000.0D);
                  localJSONArray.put(j, localObject);
                }
                if (i == 0) {
                  break label372;
                }
                paramDouble1 = paramj.e;
                if (i == 0) {
                  break label378;
                }
                localObject = paramj.h;
                localJSONArray.put(a(paramLong1, paramDouble1, 0.0D, 0, "QAPM_APPLAUNCH", (String)localObject));
                if (i == 0) {
                  break label407;
                }
                paramDouble1 = paramj.f;
                if (i == 0) {
                  break label414;
                }
                paramDouble3 = paramj.f - paramj.e;
                if (i == 0) {
                  break label385;
                }
                paramj = paramj.h;
                localJSONArray.put(a(paramLong1, paramDouble1, paramDouble3, 1, "QAPM_APPLAUNCH", paramj));
              }
            }
            if (paramDouble2 != 0.0D) {
              localSingleItem.costTime = paramDouble2;
            }
            localSingleItem.extraData = localJSONObject.toString();
            this.d.set(k, localSingleItem);
          }
          else
          {
            return;
          }
        }
        finally {}
        paramDouble1 = paramDouble3;
      }
      catch (Exception paramj)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_impl_MonitorReport", "handler signal data may be error" });
        return;
      }
      label372:
      continue;
      label378:
      Object localObject = "LAUNCH_END_BY_USER";
      continue;
      label385:
      paramj = "LAUNCH_END_BY_USER";
      continue;
      label392:
      j += 1;
      continue;
      label401:
      int i = 0;
      continue;
      label407:
      paramDouble1 = paramLong2;
      continue;
      label414:
      paramDouble3 = paramLong2 - paramDouble3;
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramLong3 - paramLong2 < 0L) {
      return;
    }
    synchronized (this.c)
    {
      TagItem localTagItem = new TagItem();
      localTagItem.duringTime = 0.0D;
      localTagItem.stage = paramString1;
      localTagItem.subStage = paramString2;
      localTagItem.extraInfo = "";
      localTagItem.eventTime = (paramLong2 / 1000.0D);
      localTagItem.tagId = paramLong1;
      localTagItem.type = 0;
      localTagItem.isSlow = paramBoolean;
      this.c.add(localTagItem);
      localTagItem = new TagItem();
      localTagItem.duringTime = (paramLong3 - paramLong2);
      localTagItem.stage = paramString1;
      localTagItem.subStage = paramString2;
      localTagItem.extraInfo = "";
      localTagItem.eventTime = (paramLong3 / 1000.0D);
      localTagItem.tagId = paramLong1;
      localTagItem.isSlow = paramBoolean;
      localTagItem.type = 1;
      this.c.add(localTagItem);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    synchronized (this.d)
    {
      SingleItem localSingleItem = new SingleItem();
      localSingleItem.costTime = paramLong1;
      localSingleItem.stage = paramString1;
      localSingleItem.extraData = paramString2;
      localSingleItem.eventTime = paramLong2;
      this.d.add(localSingleItem);
      return;
    }
  }
  
  public void a(long paramLong, j paramj)
  {
    if (com.tencent.qapmsdk.impl.g.b.e.get()) {
      return;
    }
    Vector localVector = this.c;
    long l1 = 0L;
    double d1 = 0.0D;
    double d5 = 0.0D;
    double d6 = 0.0D;
    int i;
    if (paramj != null) {
      i = 1;
    }
    label318:
    label326:
    label332:
    label339:
    label345:
    label352:
    label361:
    label380:
    for (;;)
    {
      int k;
      try
      {
        localObject = this.c.iterator();
        j = -1;
        d2 = d1;
        d4 = d5;
        d3 = d6;
        l2 = l1;
        if (((Iterator)localObject).hasNext())
        {
          TagItem localTagItem = (TagItem)((Iterator)localObject).next();
          k = j + 1;
          j = k;
          if (!com.tencent.qapmsdk.impl.g.b.a.contains(localTagItem.subStage)) {
            continue;
          }
          if (localTagItem.type != 0) {
            break label380;
          }
          d1 = localTagItem.eventTime * 1000.0D;
          l1 = localTagItem.tagId;
          if (localTagItem.type != 1) {
            break label345;
          }
          if (d1 == 0.0D) {
            break label361;
          }
          if (i != 0) {
            break label352;
          }
          d2 = (paramLong - d1) * 1.0D;
          d3 = localTagItem.eventTime * 1000.0D;
          localTagItem.duringTime = d2;
          localTagItem.eventTime = (paramLong / 1000.0D);
          this.c.set(k, localTagItem);
          if (i == 0) {
            break label318;
          }
          l2 = paramj.e;
          if (i == 0) {
            break label326;
          }
          l3 = paramj.f;
          if (i == 0) {
            break label332;
          }
          localObject = paramj.h;
          if (d2 <= PluginCombination.startUpPlugin.threshold) {
            break label339;
          }
          bool = true;
          a(l1, l2, l3, "QAPM_APPLAUNCH", (String)localObject, bool);
          l2 = l1;
          d4 = d2;
          d2 = d1;
        }
        a(d2, d4, d3, l2, paramLong, paramj);
        return;
      }
      finally {}
      i = 0;
      continue;
      long l2 = d3;
      continue;
      long l3 = paramLong;
      continue;
      Object localObject = "LAUNCH_END_BY_USER";
      continue;
      boolean bool = false;
      continue;
      int j = k;
      continue;
      double d3 = 0.0D;
      double d2 = 0.0D;
      continue;
      d2 = d1;
      double d4 = d5;
      d3 = d6;
      l2 = l1;
    }
  }
  
  Vector<TagItem> b()
  {
    return this.c;
  }
  
  Vector<SingleItem> c()
  {
    return this.d;
  }
  
  public void d()
  {
    if (!a)
    {
      new Handler(ThreadManager.getMonitorThreadLooper()).postDelayed(b.a(), 20000L);
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.a
 * JD-Core Version:    0.7.0.1
 */