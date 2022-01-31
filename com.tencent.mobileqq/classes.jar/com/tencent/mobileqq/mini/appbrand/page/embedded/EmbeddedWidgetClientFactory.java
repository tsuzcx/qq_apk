package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClientFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class EmbeddedWidgetClientFactory
  implements IEmbeddedWidgetClientFactory
{
  private static final String TAG = "miniapp-embedded";
  private ConcurrentHashMap<Integer, Long> mappingTableMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, VideoEmbeddedWidgetClient> videoEmbeddedWidgetClientMap = new ConcurrentHashMap();
  
  public IEmbeddedWidgetClient createWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    try
    {
      QLog.i("miniapp-embedded", 1, "createWidgetClient, tagName:" + paramString + ", attributes:" + paramMap.toString());
      if (paramString.equalsIgnoreCase("video"))
      {
        paramString = new VideoEmbeddedWidgetClient(paramString, paramMap, paramIEmbeddedWidget);
        this.videoEmbeddedWidgetClientMap.put(Long.valueOf(paramIEmbeddedWidget.getWidgetId()), paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-embedded", 1, "createWidgetClient error.", paramString);
    }
    return null;
  }
  
  public Map<Long, VideoEmbeddedWidgetClient> getVideoEmbeddedWidgetClientMap()
  {
    return this.videoEmbeddedWidgetClientMap;
  }
  
  public boolean handleInsertXWebVideo(String paramString, JsRuntime paramJsRuntime, BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    try
    {
      paramString = new JSONObject(paramString);
      long l = paramString.optLong("x5WidgetId", 0L);
      if ((this.videoEmbeddedWidgetClientMap != null) && (this.videoEmbeddedWidgetClientMap.containsKey(Long.valueOf(l))))
      {
        int i = paramString.optInt("viewId", -1);
        if ((i != -1) && (this.mappingTableMap != null)) {
          this.mappingTableMap.put(Integer.valueOf(i), Long.valueOf(l));
        }
        VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)this.videoEmbeddedWidgetClientMap.get(Long.valueOf(l));
        if (localVideoEmbeddedWidgetClient != null)
        {
          localVideoEmbeddedWidgetClient.handleInsertXWebVideo(paramString, paramJsRuntime, paramBaseAppBrandRuntime);
          return true;
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-embedded", 1, "handleInsertXWebVideo error.", paramString);
    }
    return false;
  }
  
  public boolean handleOperateXWebVideo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("viewId", -1);
      if ((this.mappingTableMap != null) && (this.mappingTableMap.containsKey(Integer.valueOf(i))))
      {
        long l = ((Long)this.mappingTableMap.get(Integer.valueOf(i))).longValue();
        if ((this.videoEmbeddedWidgetClientMap != null) && (this.videoEmbeddedWidgetClientMap.containsKey(Long.valueOf(l))))
        {
          VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)this.videoEmbeddedWidgetClientMap.get(Long.valueOf(l));
          if (localVideoEmbeddedWidgetClient != null)
          {
            localVideoEmbeddedWidgetClient.handleOperateXWebVideo(paramString);
            return true;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-embedded", 1, "handleInsertXWebVideo error.", paramString);
    }
    return false;
  }
  
  public boolean handleUpdateXWebVideo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("viewId", -1);
      if ((this.mappingTableMap != null) && (this.mappingTableMap.containsKey(Integer.valueOf(i))))
      {
        long l = ((Long)this.mappingTableMap.get(Integer.valueOf(i))).longValue();
        if ((this.videoEmbeddedWidgetClientMap != null) && (this.videoEmbeddedWidgetClientMap.containsKey(Long.valueOf(l))))
        {
          VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)this.videoEmbeddedWidgetClientMap.get(Long.valueOf(l));
          if (localVideoEmbeddedWidgetClient != null)
          {
            localVideoEmbeddedWidgetClient.handleUpdateXWebVideo(paramString);
            return true;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-embedded", 1, "handleInsertXWebVideo error.", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientFactory
 * JD-Core Version:    0.7.0.1
 */