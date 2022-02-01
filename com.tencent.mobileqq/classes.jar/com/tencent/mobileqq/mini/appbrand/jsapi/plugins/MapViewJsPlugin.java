package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class MapViewJsPlugin
  extends BaseJsPlugin
{
  public static final String MAP_TAG = "MiniAppMapTag";
  public static final String TAG = "[mini] MapViewJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public MapViewJsPlugin()
  {
    this.eventMap.add("getMapCenterLocation");
    this.eventMap.add("moveToMapLocation");
    this.eventMap.add("translateMapMarker");
    this.eventMap.add("includeMapPoints");
    this.eventMap.add("getMapScale");
    this.eventMap.add("getMapRegion");
    this.eventMap.add("addMapMarkers");
    this.eventMap.add("removeMapMarkers");
    this.eventMap.add("insertMap");
    this.eventMap.add("updateMap");
    this.eventMap.add("addMapLines");
    this.eventMap.add("addMapPolygons");
    this.eventMap.add("addMapCircles");
    this.eventMap.add("addMapControls");
    this.eventMap.add("getMapRotate");
    this.eventMap.add("getMapSkew");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("insertMap".equals(paramString1))
    {
      AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.1(this, paramJsRuntime, paramString2, paramString1, paramInt));
      return "";
    }
    if ("updateMap".equals(paramString1))
    {
      AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.2(this, paramJsRuntime, paramString2, paramString1, paramInt));
      return "";
    }
    if ("addMapLines".equals(paramString1))
    {
      AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.3(this, paramJsRuntime, paramString2, paramString1, paramInt));
      return "";
    }
    if ("addMapPolygons".equals(paramString1))
    {
      AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.4(this, paramJsRuntime, paramString2, paramString1, paramInt));
      return "";
    }
    if ("addMapCircles".equals(paramString1))
    {
      AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.5(this, paramJsRuntime, paramString2, paramString1, paramInt));
      return "";
    }
    if ("getMapCenterLocation".equals(paramString1)) {
      AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.6(this, paramString2, paramJsRuntime, paramString1, paramInt));
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("moveToMapLocation".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.7(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
      else if ("getMapScale".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.8(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
      else if ("translateMapMarker".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.9(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
      else if ("includeMapPoints".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.10(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
      else if ("getMapRegion".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.11(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
      else
      {
        if ("removeMapMarkers".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.12(this, paramJsRuntime, paramString2, paramString1, paramInt));
          return "";
        }
        if ("addMapMarkers".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.13(this, paramJsRuntime, paramString2, paramString1, paramInt));
          return "";
        }
        if ("addMapControls".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.14(this, paramJsRuntime, paramString2, paramString1, paramInt));
          return "";
        }
        if ("getMapRotate".equals(paramString1)) {
          AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.15(this, paramString2, paramJsRuntime, paramString1, paramInt));
        } else if ("getMapSkew".equals(paramString1)) {
          AppBrandTask.runTaskOnUiThread(new MapViewJsPlugin.16(this, paramString2, paramJsRuntime, paramString1, paramInt));
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */