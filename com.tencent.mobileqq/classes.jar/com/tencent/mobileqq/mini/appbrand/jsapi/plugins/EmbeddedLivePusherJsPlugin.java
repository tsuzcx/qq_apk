package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientFactory;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientHolder;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class EmbeddedLivePusherJsPlugin
  extends BaseJsPlugin
{
  private static final int EMBEDDED_ON_DESTROY_EVENT = 3;
  private static final int EMBEDDED_ON_PAUSE_EVENT = 2;
  private static final int EMBEDDED_ON_RESUME_EVENT = 1;
  public static final String EVENT_INSERT_XWEB_LIVE_PUSHER = "insertXWebLivePusher";
  public static final String EVENT_ON_XWEB_LIVE_PUSHER_BGM_COMPLETE = "onXWebLivePusherBGMComplete";
  public static final String EVENT_ON_XWEB_LIVE_PUSHER_BGM_PROGRESS = "onXWebLivePusherBGMProgress";
  public static final String EVENT_ON_XWEB_LIVE_PUSHER_BGM_START = "onXWebLivePusherBGMStart";
  public static final String EVENT_ON_XWEB_LIVE_PUSHER_ERR = "onXWebLivePusherError";
  public static final String EVENT_ON_XWEB_LIVE_PUSHER_EVENT = "onXWebLivePusherEvent";
  public static final String EVENT_ON_XWEB_LIVE_PUSHER_NET_STATUS = "onXWebLivePusherNetStatus";
  public static final String EVENT_OPERATE_XWEB_LIVE_PUSHER = "operateXWebLivePusher";
  public static final String EVENT_REMOVE_XWEB_LIVE_PUSHER = "removeXWebLivePusher";
  public static final String EVENT_SET_DISPLAY_ORIENTATION = "setDisplayOrientation";
  public static final String EVENT_UPDATE_XWEB_LIVE_PUSHER = "updateXWebLivePusher";
  private static final Set<String> S_EVENT_MAP = new EmbeddedLivePusherJsPlugin.1();
  public static final String TAG = "EmbeddedLivePusherJsPlugin";
  private int lastNavBarVisibility = 8;
  private int lastTabBarVisibility = 8;
  
  private EmbeddedWidgetClientFactory getFactory()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jsPluginEngine != null)
    {
      localObject1 = localObject2;
      if (this.jsPluginEngine.appBrandRuntime != null)
      {
        localObject1 = localObject2;
        if (this.jsPluginEngine.appBrandRuntime.getCurWebviewContainer() != null)
        {
          localObject1 = localObject2;
          if (this.jsPluginEngine.appBrandRuntime.getCurWebviewContainer().getPageWebview() != null) {
            localObject1 = this.jsPluginEngine.appBrandRuntime.getCurWebviewContainer().getPageWebview().getEmbeddedWidgetClientFactory();
          }
        }
      }
    }
    return localObject1;
  }
  
  private void onEmbeddedWidgetLifeCycleEvent(int paramInt)
  {
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          switch (paramInt)
          {
          default: 
            break;
          case 1: 
            localEmbeddedWidgetClientHolder.nativeResume();
            break;
          case 2: 
            localEmbeddedWidgetClientHolder.nativePause();
            break;
          case 3: 
            localEmbeddedWidgetClientHolder.nativeDestroy();
            ((Iterator)localObject).remove();
          }
        }
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("EmbeddedLivePusherJsPlugin", 1, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getContainer() != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()) != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()) != null)) {
      localEmbeddedWidgetClientFactory = ((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()).getEmbeddedWidgetClientFactory();
    }
    for (;;)
    {
      if ("insertXWebLivePusher".equals(paramString1)) {
        if ((this.jsPluginEngine != null) && (localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertEmbeddedWidgetEvent("insertXWebLivePusher", paramString2, paramJsRuntime, this.jsPluginEngine.appBrandRuntime))) {
          if (this.jsPluginEngine != null) {
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
        }
      }
      label498:
      do
      {
        for (;;)
        {
          return "";
          if (this.jsPluginEngine != null)
          {
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            continue;
            if ("updateXWebLivePusher".equals(paramString1))
            {
              if (this.jsPluginEngine != null) {
                if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "updateXWebLivePusher", paramString2, paramInt, this.jsPluginEngine.appBrandRuntime))) {
                  this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
                } else {
                  this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
                }
              }
            }
            else
            {
              if (!"operateXWebLivePusher".equals(paramString1)) {
                break;
              }
              if ((this.jsPluginEngine != null) && ((localEmbeddedWidgetClientFactory == null) || (!localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "operateXWebLivePusher", paramString2, paramInt, this.jsPluginEngine.appBrandRuntime)))) {
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              }
            }
          }
        }
        if ("removeXWebLivePusher".equals(paramString1))
        {
          if (this.jsPluginEngine != null)
          {
            if ((localEmbeddedWidgetClientFactory == null) || (!localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "removeXWebLivePusher", paramString2, paramInt, this.jsPluginEngine.appBrandRuntime))) {
              break label498;
            }
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
          for (;;)
          {
            QLog.e("EmbeddedLivePusherJsPlugin", 1, "handleNativeRequest-removeXWebLivePusher ,jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
            break;
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          }
        }
      } while (!"setDisplayOrientation".equals(paramString1));
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = new JSONObject(paramString2).optInt("orientation", 0);
          if (j != 90) {
            break label635;
          }
          i = 0;
          if (i != this.jsPluginEngine.appBrandRuntime.activity.getRequestedOrientation())
          {
            QLog.d("EmbeddedLivePusherJsPlugin", 1, "EVENT_SET_DISPLAY_ORIENTATION, setRequestedOrientation: " + j);
            this.jsPluginEngine.appBrandRuntime.activity.setRequestedOrientation(i);
          }
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
        catch (Throwable paramString1)
        {
          QLog.e("EmbeddedLivePusherJsPlugin", 1, "setDisplayOrientation get an ");
        }
        break;
        label635:
        if (j == -90) {
          i = 8;
        } else {
          i = 1;
        }
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    onEmbeddedWidgetLifeCycleEvent(3);
  }
  
  public void onPause()
  {
    super.onPause();
    onEmbeddedWidgetLifeCycleEvent(2);
  }
  
  public void onResume()
  {
    super.onResume();
    onEmbeddedWidgetLifeCycleEvent(1);
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedLivePusherJsPlugin
 * JD-Core Version:    0.7.0.1
 */