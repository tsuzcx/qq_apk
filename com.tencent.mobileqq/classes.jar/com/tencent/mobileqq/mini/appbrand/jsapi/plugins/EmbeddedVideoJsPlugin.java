package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientFactory;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientHolder;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class EmbeddedVideoJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_VOLUME = "getVolume";
  public static final String EVENT_HIDE_NAVIGATIONBAR = "hideVirtualBottomNavigationBar";
  public static final String EVENT_INSERT_XWEB_VIDEO = "insertXWebVideo";
  public static final String EVENT_OPERATE_XWEB_VIDEO = "operateXWebVideo";
  public static final String EVENT_REMOVE_XWEB_VIDEO = "removeXWebVideo";
  public static final String EVENT_SET_DISPLAY_ORIENTATION = "setDisplayOrientation";
  public static final String EVENT_SET_VOLUME = "setVolume";
  public static final String EVENT_SHOW_NAVIGATIONBAR = "showVirtualBottomNavigationBar";
  public static final String EVENT_UPDATE_XWEB_VIDEO = "updateXWebVideo";
  private static final Set<String> S_EVENT_MAP = new EmbeddedVideoJsPlugin.1();
  public static final String TAG = "EmbeddedVideoJsPlugin";
  public static final String VIDEO_EVENT_END = "onXWebVideoEnded";
  public static final String VIDEO_EVENT_ERR = "onXWebVideoError";
  public static final String VIDEO_EVENT_EXIT_FULLSCREEN = "onXWebVideoExitFullscreen";
  public static final String VIDEO_EVENT_LOADED_METADATA = "onXWebVideoLoadedMetaData";
  public static final String VIDEO_EVENT_PAUSE = "onXWebVideoPause";
  public static final String VIDEO_EVENT_PLAY = "onXWebVideoPlay";
  public static final String VIDEO_EVENT_PROGRESS = "onXWebVideoProgress";
  public static final String VIDEO_EVENT_TIME_UPDATE = "onXWebVideoTimeUpdate";
  public static final String VIDEO_EVENT_WAITING = "onXWebVideoWaiting";
  private int lastNavBarVisibility = 8;
  private int lastTabBarVisibility = 8;
  
  private void enterFullScreenMode()
  {
    int i;
    if ((this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.activity != null) && (!this.jsPluginEngine.appBrandRuntime.activity.isFinishing()))
    {
      i = this.jsPluginEngine.appBrandRuntime.activity.getWindow().getDecorView().getSystemUiVisibility();
      if (Build.VERSION.SDK_INT < 21) {
        break label106;
      }
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label121;
      }
      i |= 0x800;
    }
    for (;;)
    {
      this.jsPluginEngine.appBrandRuntime.activity.getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      label106:
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label121:
      i |= 0x1;
    }
  }
  
  private void enterSmallScreenMode()
  {
    try
    {
      if ((this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.activity != null) && (!this.jsPluginEngine.appBrandRuntime.activity.isFinishing()))
      {
        if (Build.VERSION.SDK_INT >= 16) {
          this.jsPluginEngine.appBrandRuntime.activity.getWindow().getDecorView().setSystemUiVisibility(1024);
        }
        if ((this.jsPluginEngine.appBrandRuntime.getCurPage() != null) && (this.jsPluginEngine.appBrandRuntime.getCurPage().getNavBar() != null))
        {
          int i = this.jsPluginEngine.appBrandRuntime.getCurPage().getNavBar().getStatusNavigationBarTextStyle();
          if (i == -1)
          {
            ImmersiveUtils.a(false, this.jsPluginEngine.appBrandRuntime.activity.getWindow());
            return;
          }
          if (i == -16777216)
          {
            ImmersiveUtils.a(true, this.jsPluginEngine.appBrandRuntime.activity.getWindow());
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("EmbeddedVideoJsPlugin", 1, "smallScreen: ", localException);
    }
  }
  
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
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("EmbeddedVideoJsPlugin", 1, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getContainer() != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()) != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()) != null)) {
      localEmbeddedWidgetClientFactory = ((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()).getEmbeddedWidgetClientFactory();
    }
    for (;;)
    {
      if ("getVolume".equals(paramString1)) {}
      int i;
      int j;
      for (;;)
      {
        try
        {
          paramString2 = (AudioManager)paramJsRuntime.getContextEx().getSystemService("audio");
          if (paramString2 == null) {
            continue;
          }
          i = paramString2.getStreamVolume(3);
          j = paramString2.getStreamMaxVolume(3);
          paramString2 = new JSONObject();
          paramString2.put("currentVolume", i);
          paramString2.put("maxVolume", j);
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, paramString2, paramInt);
        }
        catch (Throwable paramString2)
        {
          QLog.e("EmbeddedVideoJsPlugin", 1, paramString1 + " error.", paramString2);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          continue;
        }
        return "";
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "AudioManager error", paramInt);
        continue;
        if ("setVolume".equals(paramString1))
        {
          try
          {
            i = new JSONObject(paramString2).optInt("value");
            paramString2 = (AudioManager)paramJsRuntime.getContextEx().getSystemService("audio");
            if (paramString2 == null) {
              break label476;
            }
            if ((i > paramString2.getStreamMaxVolume(3)) || (i < 0)) {
              break label458;
            }
            paramString2.setStreamVolume(3, i, 4);
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
          catch (Throwable paramString2)
          {
            QLog.e("EmbeddedVideoJsPlugin", 1, paramString1 + " error.", paramString2);
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          }
          continue;
          label458:
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "value error", paramInt);
          continue;
          label476:
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "AudioManager error", paramInt);
        }
        else if ("insertXWebVideo".equals(paramString1))
        {
          if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertEmbeddedWidgetEvent("insertXWebVideo", paramString2, paramJsRuntime, this.jsPluginEngine.appBrandRuntime)))
          {
            if (this.jsPluginEngine != null) {
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          else if (this.jsPluginEngine != null) {
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          }
        }
        else
        {
          if ((!"updateXWebVideo".equals(paramString1)) && (!"operateXWebVideo".equals(paramString1))) {
            break;
          }
          if (this.jsPluginEngine != null) {
            if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, paramString1, paramString2, paramInt, this.jsPluginEngine.appBrandRuntime))) {
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            } else {
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
        }
      }
      if ("setDisplayOrientation".equals(paramString1)) {}
      for (;;)
      {
        try
        {
          j = new JSONObject(paramString2).optInt("orientation", 0);
          if (j != 90) {
            break label766;
          }
          i = 0;
          if (i != this.jsPluginEngine.appBrandRuntime.activity.getRequestedOrientation())
          {
            Log.i("EmbeddedVideoJsPlugin", "EVENT_SET_DISPLAY_ORIENTATION, setRequestedOrientation: " + j);
            this.jsPluginEngine.appBrandRuntime.activity.setRequestedOrientation(i);
          }
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
        catch (Throwable paramString1) {}
        break;
        label766:
        if (j == -90)
        {
          i = 8;
          continue;
          if ("hideVirtualBottomNavigationBar".equals(paramString1))
          {
            AppBrandTask.runTaskOnUiThread(new EmbeddedVideoJsPlugin.2(this, paramJsRuntime, paramString1, paramInt));
            break;
          }
          if (!"showVirtualBottomNavigationBar".equals(paramString1)) {
            break;
          }
          AppBrandTask.runTaskOnUiThread(new EmbeddedVideoJsPlugin.3(this, paramJsRuntime, paramString1, paramInt));
          break;
        }
        i = 1;
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
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.nativeDestroy();
        }
        ((Iterator)localObject).remove();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.nativePause();
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          localEmbeddedWidgetClientHolder.nativeResume();
        }
      }
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedVideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */