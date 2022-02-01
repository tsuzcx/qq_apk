package com.tencent.qapmsdk.impl.e;

import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.json.JsonDispose;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.resource.meta.SingleItem;
import com.tencent.qapmsdk.resource.meta.TagItem;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements Runnable
{
  @Nullable
  private static volatile b a;
  @Nullable
  private String b = null;
  
  @Nullable
  public static b a()
  {
    if (BaseInfo.app != null) {
      return a(AppInfo.obtainProcessName(BaseInfo.app));
    }
    return a("default");
  }
  
  @Nullable
  public static b a(String paramString)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new b();
        }
      }
      finally {}
    }
    if ((a != null) && (a.b == null)) {
      a.b = paramString;
    }
    return a;
  }
  
  private void b()
  {
    if (a.a().b().isEmpty()) {
      return;
    }
    Object localObject2 = (Vector)a.a().b().clone();
    a.a().b().clear();
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localObject1 = JsonDispose.copyJson(BaseInfo.pubJson, (JSONObject)localObject1);
        ((JSONObject)localObject1).put("zone", "default");
        ((JSONObject)localObject1).put("plugin", PluginCombination.startUpPlugin.plugin);
        Object localObject3 = new JSONArray();
        JSONArray localJSONArray = new JSONArray();
        ((JSONObject)localObject1).put("immediates", localObject3);
        localObject2 = ((Vector)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TagItem)((Iterator)localObject2).next();
          if ((Double.isNaN(((TagItem)localObject3).eventTime)) || (((TagItem)localObject3).tagId == 9223372036854775807L)) {
            continue;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("event_time", ((TagItem)localObject3).eventTime);
          localJSONObject.put("tag_id", ((TagItem)localObject3).tagId);
          if (!Double.isNaN(((TagItem)localObject3).duringTime)) {
            localJSONObject.put("during_time", ((TagItem)localObject3).duringTime);
          }
          localJSONObject.put("type", ((TagItem)localObject3).type);
          localJSONObject.put("stage", ((TagItem)localObject3).stage);
          localJSONObject.put("sub_stage", ((TagItem)localObject3).subStage);
          localJSONObject.put("extra_info", ((TagItem)localObject3).extraInfo);
          localJSONObject.put("process_name", this.b);
          if (((TagItem)localObject3).isSlow)
          {
            i = 1;
            localJSONObject.put("is_slow", i);
            localJSONArray.put(localJSONObject);
          }
        }
        else
        {
          ((JSONObject)localObject1).put("manu_tags", localJSONArray);
          localObject1 = new ResultObject(0, "Scenes target", true, 1L, 1L, (JSONObject)localObject1, true, false, BaseInfo.userMeta.uin);
          ReporterMachine.INSTANCE.addResultObj((ResultObject)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_Impl_ReportRunnable", localException);
        return;
      }
      int i = 0;
    }
  }
  
  private void c()
  {
    if ((a.a().c().isEmpty()) && (!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin))) {
      return;
    }
    Object localObject1 = (Vector)a.a().c().clone();
    a.a().c().clear();
    try
    {
      localObject1 = ((Vector)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (SingleItem)((Iterator)localObject1).next();
        if (((SingleItem)localObject2).costTime >= PluginCombination.startUpPlugin.threshold)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("stage", ((SingleItem)localObject2).stage);
          localJSONObject.put("event_time", ((SingleItem)localObject2).eventTime);
          localJSONObject.put("cost_time", ((SingleItem)localObject2).costTime);
          localJSONObject.put("stack", "");
          localJSONObject.put("plugin", PluginCombination.loopStackPlugin.plugin);
          localJSONObject.put("extra_data", ((SingleItem)localObject2).extraData);
          localObject2 = new ResultObject(0, "Scenes single", true, 1L, 1L, localJSONObject, true, false, BaseInfo.userMeta.uin);
          ReporterMachine.INSTANCE.addResultObj((ResultObject)localObject2, null, false);
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_ReportRunnable", localJSONException);
    }
  }
  
  public void run()
  {
    com.tencent.qapmsdk.impl.g.b.e.set(true);
    b();
    c();
    a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.b
 * JD-Core Version:    0.7.0.1
 */