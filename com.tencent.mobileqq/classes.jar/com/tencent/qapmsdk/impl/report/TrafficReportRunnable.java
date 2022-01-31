package com.tencent.qapmsdk.impl.report;

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
import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrafficReportRunnable
  implements Runnable
{
  private static final String TAG = "QAPM_Impl_TrafficReportRunnable";
  private static final double TIME_UNIT = 1000.0D;
  @Nullable
  private static volatile TrafficReportRunnable instance = null;
  @Nullable
  private String processName = null;
  
  @Nullable
  public static TrafficReportRunnable getInstance()
  {
    if (BaseInfo.app != null) {
      return getInstance(AppInfo.obtainProcessName(BaseInfo.app));
    }
    return getInstance("default");
  }
  
  @Nullable
  public static TrafficReportRunnable getInstance(String paramString)
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TrafficReportRunnable();
      }
      if (instance.processName == null) {
        instance.processName = paramString;
      }
      return instance;
    }
    finally {}
  }
  
  private void reportTraffic()
  {
    if ((!TrafficMonitorReport.getInstance().getHttpQueue().isEmpty()) || (!TrafficMonitorReport.getInstance().getSocketToQueue().isEmpty()))
    {
      if (PluginController.INSTANCE.canCollect(PluginCombination.httpPlugin.plugin)) {
        break label58;
      }
      TrafficMonitorReport.getInstance().getSocketToQueue().clear();
      TrafficMonitorReport.getInstance().getHttpQueue().clear();
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
        while (!TrafficMonitorReport.getInstance().getHttpQueue().isEmpty())
        {
          localObject1 = (SocketInfo)TrafficMonitorReport.getInstance().getHttpQueue().poll();
          if ((!TextUtils.isEmpty(((SocketInfo)localObject1).host)) && (!WhiteUrl.whiteHttpHosts.contains(((SocketInfo)localObject1).host)))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("category", "http");
            ((JSONObject)localObject3).put("url", ((SocketInfo)localObject1).url);
            ((JSONObject)localObject3).put("host_ip", ((SocketInfo)localObject1).ip);
            ((JSONObject)localObject3).put("http_method", ((SocketInfo)localObject1).method);
            ((JSONObject)localObject3).put("content_type", ((SocketInfo)localObject1).contentType);
            ((JSONObject)localObject3).put("bytes_sent", ((SocketInfo)localObject1).sendBytes);
            ((JSONObject)localObject3).put("bytes_received", ((SocketInfo)localObject1).receivedBytes);
            ((JSONObject)localObject3).put("start_time", ((SocketInfo)localObject1).startTimeStamp / 1000.0D);
            ((JSONObject)localObject3).put("duration", ((SocketInfo)localObject1).duringTime);
            ((JSONObject)localObject3).put("ssl", ((SocketInfo)localObject1).sslTime);
            ((JSONObject)localObject3).put("tcp", ((SocketInfo)localObject1).tcpTime);
            ((JSONObject)localObject3).put("apn_type", ((SocketInfo)localObject1).apnType);
            ((JSONObject)localObject3).put("status_code", ((SocketInfo)localObject1).statusCode);
            ((JSONObject)localObject3).put("error_code", ((SocketInfo)localObject1).errorCode);
            ((JSONObject)localObject3).put("dns", ((SocketInfo)localObject1).dnsTime);
            localJSONArray.put(localObject3);
          }
        }
        if (TrafficMonitorReport.getInstance().getSocketToQueue().isEmpty()) {
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
        localObject3 = (SocketInfo)TrafficMonitorReport.getInstance().getSocketToQueue().poll();
      } while ((TextUtils.isEmpty(((SocketInfo)localObject3).host)) || (TextUtils.isEmpty(((SocketInfo)localObject3).protocol)) || (WhiteUrl.whiteHttpHosts.contains(((SocketInfo)localObject3).host)));
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("category", "socket");
      StringBuilder localStringBuilder = new StringBuilder().append(((SocketInfo)localObject3).protocol).append("://").append(((SocketInfo)localObject3).host);
      if (((SocketInfo)localObject3).path == null) {}
      for (localObject2 = "";; localObject2 = ((SocketInfo)localObject3).path)
      {
        localJSONObject2.put("url", (String)localObject2);
        localJSONObject2.put("host_ip", ((SocketInfo)localObject3).ip);
        localJSONObject2.put("tcp", ((SocketInfo)localObject3).tcpTime);
        localJSONObject2.put("apn_type", ((SocketInfo)localObject3).apnType);
        localJSONObject2.put("error_code", ((SocketInfo)localObject3).errorCode);
        localJSONObject2.put("dns", ((SocketInfo)localObject3).dnsTime);
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
    reportTraffic();
    TrafficMonitorReport.hasReport = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.report.TrafficReportRunnable
 * JD-Core Version:    0.7.0.1
 */