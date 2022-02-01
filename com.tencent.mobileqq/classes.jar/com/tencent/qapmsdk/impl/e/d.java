package com.tencent.qapmsdk.impl.e;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.WhiteUrl;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.json.JsonDispose;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.socket.c.a;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  implements Runnable
{
  @Nullable
  private static volatile d a = null;
  @Nullable
  private String b = null;
  
  @Nullable
  public static d a()
  {
    if (BaseInfo.app != null) {
      return a(AppInfo.obtainProcessName(BaseInfo.app));
    }
    return a("default");
  }
  
  @Nullable
  public static d a(String paramString)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d();
      }
      if (a.b == null) {
        a.b = paramString;
      }
      return a;
    }
    finally {}
  }
  
  private void b()
  {
    if ((!c.a().c().isEmpty()) || (!c.a().b().isEmpty()))
    {
      if (PluginController.INSTANCE.canCollect(PluginCombination.httpPlugin.plugin)) {
        break label58;
      }
      c.a().b().clear();
      c.a().c().clear();
    }
    label58:
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    do
    {
      return;
      Object localObject1 = new JSONObject();
      Object localObject3;
      try
      {
        localJSONObject1 = JsonDispose.copyJson(BaseInfo.pubJson, (JSONObject)localObject1);
        localJSONObject1.put("plugin", PluginCombination.httpPlugin.plugin);
        localJSONArray = new JSONArray();
        while (!c.a().c().isEmpty())
        {
          localObject1 = (a)c.a().c().poll();
          if ((!TextUtils.isEmpty(((a)localObject1).d)) && (!WhiteUrl.whiteHttpHosts.contains(((a)localObject1).d)))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("category", "http");
            ((JSONObject)localObject3).put("url", ((a)localObject1).b);
            ((JSONObject)localObject3).put("host_ip", ((a)localObject1).e);
            ((JSONObject)localObject3).put("http_method", ((a)localObject1).h);
            ((JSONObject)localObject3).put("content_type", ((a)localObject1).n);
            ((JSONObject)localObject3).put("bytes_sent", ((a)localObject1).w);
            ((JSONObject)localObject3).put("bytes_received", ((a)localObject1).x);
            ((JSONObject)localObject3).put("start_time", ((a)localObject1).o / 1000.0D);
            ((JSONObject)localObject3).put("duration", ((a)localObject1).s);
            ((JSONObject)localObject3).put("ssl", ((a)localObject1).p);
            ((JSONObject)localObject3).put("tcp", ((a)localObject1).r);
            ((JSONObject)localObject3).put("apn_type", ((a)localObject1).D);
            ((JSONObject)localObject3).put("status_code", ((a)localObject1).C);
            ((JSONObject)localObject3).put("error_code", ((a)localObject1).B);
            ((JSONObject)localObject3).put("dns", ((a)localObject1).q);
            localJSONArray.put(localObject3);
          }
        }
        if (c.a().b().isEmpty()) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_Impl_TrafficReportRunnable", localException);
        return;
      }
      do
      {
        localObject3 = (a)c.a().b().poll();
      } while ((TextUtils.isEmpty(((a)localObject3).d)) || (TextUtils.isEmpty(((a)localObject3).c)) || (WhiteUrl.whiteHttpHosts.contains(((a)localObject3).d)));
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("category", "socket");
      StringBuilder localStringBuilder = new StringBuilder().append(((a)localObject3).c).append("://").append(((a)localObject3).d);
      if (((a)localObject3).i == null) {}
      for (localObject2 = "";; localObject2 = ((a)localObject3).i)
      {
        localJSONObject2.put("url", (String)localObject2);
        localJSONObject2.put("host_ip", ((a)localObject3).e);
        localJSONObject2.put("tcp", ((a)localObject3).r);
        localJSONObject2.put("apn_type", ((a)localObject3).D);
        localJSONObject2.put("error_code", ((a)localObject3).B);
        localJSONObject2.put("dns", ((a)localObject3).q);
        localJSONArray.put(localJSONObject2);
        break;
      }
    } while (localJSONArray.length() == 0);
    localJSONObject1.put("parts", localJSONArray);
    Object localObject2 = new ResultObject(0, "Http", true, 1L, 1L, localJSONObject1, true, false, BaseInfo.userMeta.uin);
    ReporterMachine.INSTANCE.addResultObj((ResultObject)localObject2);
  }
  
  public void run()
  {
    b();
    c.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.d
 * JD-Core Version:    0.7.0.1
 */