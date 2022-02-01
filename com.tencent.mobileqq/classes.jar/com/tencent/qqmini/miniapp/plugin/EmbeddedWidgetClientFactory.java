package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
  private ConcurrentHashMap<Long, EmbeddedWidgetClientHolder> embeddedWidgetClientHolderMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, Long> mappingTableMap = new ConcurrentHashMap();
  
  private boolean doEventByWidgetId(String paramString, IMiniAppContext paramIMiniAppContext, int paramInt, JSONObject paramJSONObject, long paramLong, IJsService paramIJsService)
  {
    Object localObject = this.embeddedWidgetClientHolderMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
    {
      localObject = (EmbeddedWidgetClientHolder)this.embeddedWidgetClientHolderMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        ((EmbeddedWidgetClientHolder)localObject).handleEmbeddedWidgetEvent(paramString, paramIMiniAppContext, paramJSONObject, paramInt, paramIJsService);
        return true;
      }
      return false;
    }
    QMLog.e("miniapp-embedded", "doEventByWidgetId x5WidgetId is not exist");
    return false;
  }
  
  public IEmbeddedWidgetClient createWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createWidgetClient, tagName:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", attributes:");
      localStringBuilder.append(paramMap.toString());
      QMLog.i("miniapp-embedded", localStringBuilder.toString());
      if (paramString.equalsIgnoreCase("VIDEO"))
      {
        paramString = new EmbeddedWidgetClientHolder(paramString, paramMap, paramIEmbeddedWidget);
        this.embeddedWidgetClientHolderMap.put(Long.valueOf(paramIEmbeddedWidget.getWidgetId()), paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("miniapp-embedded", "createWidgetClient error.", paramString);
    }
    return null;
  }
  
  public Map<Long, EmbeddedWidgetClientHolder> getEmbeddedWidgetClientHolderMap()
  {
    return this.embeddedWidgetClientHolderMap;
  }
  
  public boolean handleEmbeddedWidgetDestory(long paramLong)
  {
    Object localObject = this.embeddedWidgetClientHolderMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("embeddedWidgetClientHolderMap remove ");
      ((StringBuilder)localObject).append(paramLong);
      QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
      localObject = (EmbeddedWidgetClientHolder)this.embeddedWidgetClientHolderMap.get(Long.valueOf(paramLong));
      if (localObject != null) {
        this.mappingTableMap.remove(Integer.valueOf(((EmbeddedWidgetClientHolder)localObject).getViewId()));
      }
      this.embeddedWidgetClientHolderMap.remove(Long.valueOf(paramLong));
    }
    return true;
  }
  
  public boolean handleEmbeddedWidgetEvent(String paramString1, IMiniAppContext paramIMiniAppContext, String paramString2, int paramInt, IJsService paramIJsService)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleEmbeddedWidgetEvent event : ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("; jsonParams : ");
      localStringBuilder.append(paramString2);
      QMLog.e("miniapp-embedded", localStringBuilder.toString());
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("viewId", -1);
      long l = paramString2.optLong("x5WidgetId", -1L);
      if (l != -1L)
      {
        if ((i != -1) && (this.mappingTableMap != null)) {
          this.mappingTableMap.put(Integer.valueOf(i), Long.valueOf(l));
        }
        return doEventByWidgetId(paramString1, paramIMiniAppContext, paramInt, paramString2, l, paramIJsService);
      }
      if ((this.mappingTableMap != null) && (this.mappingTableMap.containsKey(Integer.valueOf(i)))) {
        return doEventByWidgetId(paramString1, paramIMiniAppContext, paramInt, paramString2, ((Long)this.mappingTableMap.get(Integer.valueOf(i))).longValue(), paramIJsService);
      }
      QMLog.e("miniapp-embedded", "handleInsertEmbeddedWidgetEvent view is not exist");
      return false;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("miniapp-embedded", "handleEmbeddedWidgetEvent error.", paramString1);
    }
    return false;
  }
  
  public boolean handleInsertEmbeddedWidgetEvent(String paramString1, IMiniAppContext paramIMiniAppContext, String paramString2, IJsService paramIJsService)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      long l = paramString2.optLong("x5WidgetId", 0L);
      if ((this.embeddedWidgetClientHolderMap != null) && (this.embeddedWidgetClientHolderMap.containsKey(Long.valueOf(l))))
      {
        int i = paramString2.optInt("viewId", -1);
        if ((i != -1) && (this.mappingTableMap != null)) {
          this.mappingTableMap.put(Integer.valueOf(i), Long.valueOf(l));
        }
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)this.embeddedWidgetClientHolderMap.get(Long.valueOf(l));
        if (localEmbeddedWidgetClientHolder != null)
        {
          localEmbeddedWidgetClientHolder.handleInsertEmbeddedWidgetEvent(paramString1, paramIMiniAppContext, paramString2, paramIJsService);
          return true;
        }
      }
      else
      {
        QMLog.e("miniapp-embedded", "handleInsertEmbeddedWidgetEvent x5WidgetId is not exist");
        return false;
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("miniapp-embedded", "handleInsertEmbeddedWidgetEvent error.", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory
 * JD-Core Version:    0.7.0.1
 */