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
  private static volatile d a;
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
    if (a == null) {
      try
      {
        if (a == null) {
          a = new d();
        }
      }
      finally {}
    }
    if (a.b == null) {
      a.b = paramString;
    }
    return a;
  }
  
  private void b()
  {
    if ((!c.a().c().isEmpty()) || (!c.a().b().isEmpty()))
    {
      if (!PluginController.INSTANCE.canCollect(PluginCombination.httpPlugin.plugin))
      {
        c.a().b().clear();
        c.a().c().clear();
        return;
      }
      Object localObject1 = new JSONObject();
      try
      {
        JSONObject localJSONObject1 = JsonDispose.copyJson(BaseInfo.pubJson, (JSONObject)localObject1);
        localJSONObject1.put("plugin", PluginCombination.httpPlugin.plugin);
        JSONArray localJSONArray = new JSONArray();
        Object localObject2;
        for (;;)
        {
          boolean bool = c.a().c().isEmpty();
          if (bool) {
            break;
          }
          localObject1 = (a)c.a().c().poll();
          if ((!TextUtils.isEmpty(((a)localObject1).d)) && (!WhiteUrl.whiteHttpHosts.contains(((a)localObject1).d)))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("category", "http");
            ((JSONObject)localObject2).put("url", ((a)localObject1).b);
            ((JSONObject)localObject2).put("host_ip", ((a)localObject1).e);
            ((JSONObject)localObject2).put("http_method", ((a)localObject1).h);
            ((JSONObject)localObject2).put("content_type", ((a)localObject1).n);
            ((JSONObject)localObject2).put("bytes_sent", ((a)localObject1).w);
            ((JSONObject)localObject2).put("bytes_received", ((a)localObject1).x);
            long l = ((a)localObject1).o;
            double d = l;
            Double.isNaN(d);
            d /= 1000.0D;
            ((JSONObject)localObject2).put("start_time", d);
            ((JSONObject)localObject2).put("duration", ((a)localObject1).s);
            ((JSONObject)localObject2).put("ssl", ((a)localObject1).p);
            ((JSONObject)localObject2).put("tcp", ((a)localObject1).r);
            ((JSONObject)localObject2).put("apn_type", ((a)localObject1).D);
            ((JSONObject)localObject2).put("status_code", ((a)localObject1).C);
            ((JSONObject)localObject2).put("error_code", ((a)localObject1).B);
            ((JSONObject)localObject2).put("dns", ((a)localObject1).q);
            localJSONArray.put(localObject2);
          }
        }
        while (!c.a().b().isEmpty())
        {
          localObject2 = (a)c.a().b().poll();
          if ((!TextUtils.isEmpty(((a)localObject2).d)) && (!TextUtils.isEmpty(((a)localObject2).c)) && (!WhiteUrl.whiteHttpHosts.contains(((a)localObject2).d)))
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("category", "socket");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((a)localObject2).c);
            localStringBuilder.append("://");
            localStringBuilder.append(((a)localObject2).d);
            if (((a)localObject2).i == null) {
              localObject1 = "";
            } else {
              localObject1 = ((a)localObject2).i;
            }
            localStringBuilder.append((String)localObject1);
            localJSONObject2.put("url", localStringBuilder.toString());
            localJSONObject2.put("host_ip", ((a)localObject2).e);
            localJSONObject2.put("tcp", ((a)localObject2).r);
            localJSONObject2.put("apn_type", ((a)localObject2).D);
            localJSONObject2.put("error_code", ((a)localObject2).B);
            localJSONObject2.put("dns", ((a)localObject2).q);
            localJSONArray.put(localJSONObject2);
          }
        }
        if (localJSONArray.length() == 0) {
          return;
        }
        localJSONObject1.put("parts", localJSONArray);
        localObject1 = new ResultObject(0, "Http", true, 1L, 1L, localJSONObject1, true, false, BaseInfo.userMeta.uin);
        ReporterMachine.INSTANCE.addResultObj((ResultObject)localObject1);
        return;
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_Impl_TrafficReportRunnable", localException);
      }
    }
  }
  
  public void run()
  {
    b();
    c.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.d
 * JD-Core Version:    0.7.0.1
 */