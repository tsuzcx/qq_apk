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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements Runnable
{
  @Nullable
  private static volatile b a = null;
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
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      if ((a != null) && (a.b == null)) {
        a.b = paramString;
      }
      return a;
    }
    finally {}
  }
  
  private void b()
  {
    if (a.a().b().isEmpty()) {
      return;
    }
    Object localObject1 = (Vector)a.a().b().clone();
    a.a().b().clear();
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        localJSONObject1 = JsonDispose.copyJson(BaseInfo.pubJson, localJSONObject1);
        localJSONObject1.put("zone", "default");
        localJSONObject1.put("plugin", PluginCombination.resourcePlugin.plugin);
        Object localObject2 = new JSONArray();
        localJSONArray = new JSONArray();
        localJSONObject1.put("immediates", localObject2);
        localObject1 = ((Vector)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (TagItem)((Iterator)localObject1).next();
        if ((!Double.isNaN(((TagItem)localObject2).eventTime)) && (((TagItem)localObject2).tagId != 9223372036854775807L))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("event_time", ((TagItem)localObject2).eventTime);
          localJSONObject2.put("tag_id", ((TagItem)localObject2).tagId);
          if (!Double.isNaN(((TagItem)localObject2).duringTime)) {
            localJSONObject2.put("during_time", ((TagItem)localObject2).duringTime);
          }
          localJSONObject2.put("type", ((TagItem)localObject2).type);
          localJSONObject2.put("stage", ((TagItem)localObject2).stage);
          localJSONObject2.put("sub_stage", ((TagItem)localObject2).subStage);
          localJSONObject2.put("extra_info", ((TagItem)localObject2).extraInfo);
          localJSONObject2.put("process_name", this.b);
          int i;
          if (((TagItem)localObject2).isSlow)
          {
            i = 1;
            localJSONObject2.put("is_slow", i);
            localJSONArray.put(localJSONObject2);
          }
          else
          {
            i = 0;
          }
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_Impl_ReportRunnable", localException);
        return;
      }
    }
    localException.put("manu_tags", localJSONArray);
    ResultObject localResultObject = new ResultObject(0, "Scenes target", true, 1L, 1L, localException, true, false, BaseInfo.userMeta.uin);
    ReporterMachine.INSTANCE.addResultObj(localResultObject);
  }
  
  private void c()
  {
    if ((a.a().c().isEmpty()) && (!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin))) {}
    for (;;)
    {
      return;
      Object localObject1 = (Vector)a.a().c().clone();
      a.a().c().clear();
      try
      {
        localObject1 = ((Vector)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (SingleItem)((Iterator)localObject1).next();
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
        return;
      }
      catch (JSONException localJSONException)
      {
        Logger.INSTANCE.exception("QAPM_Impl_ReportRunnable", localJSONException);
      }
    }
  }
  
  public void run()
  {
    b();
    c();
    a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.b
 * JD-Core Version:    0.7.0.1
 */