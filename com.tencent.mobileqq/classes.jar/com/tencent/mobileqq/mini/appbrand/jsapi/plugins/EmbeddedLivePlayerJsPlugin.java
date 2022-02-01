package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
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

public class EmbeddedLivePlayerJsPlugin
  extends BaseJsPlugin
{
  private static final int EMBEDDED_ON_DESTROY_EVENT = 3;
  private static final int EMBEDDED_ON_PAUSE_EVENT = 2;
  private static final int EMBEDDED_ON_RESUME_EVENT = 1;
  public static final String EVENT_EXIT_FULL_SCREEN = "xWebLivePlayerExitFullScreen";
  public static final String EVENT_HIDE_NAVIGATIONBAR = "hideVirtualBottomNavigationBar";
  public static final String EVENT_INSERT_POSITION_CONTAINER = "insertPositioningContainer";
  public static final String EVENT_INSERT_XWEB_LIVE_PLAYER = "insertXWebLivePlayer";
  public static final String EVENT_ON_XWEB_LIVE_AUDIO_VOLUME = "onXWebLivePlayerAudioVolume";
  public static final String EVENT_ON_XWEB_LIVE_METADATA = "onXWebLivePlayerMetadata";
  public static final String EVENT_OPERATE_XWEB_LIVE_PLAYER = "operateXWebLivePlayer";
  public static final String EVENT_ORIENTATION_CHANGE = "onXWebLivePlayerOrientationChanged";
  public static final String EVENT_REMOVE_XWEB_LIVE_PLAYER = "removeXWebLivePlayer";
  public static final String EVENT_REQUEST_FULL_SCREEN = "xWebLivePlayerRequestFullScreen";
  public static final String EVENT_SHOW_NAVIGATIONBAR = "showVirtualBottomNavigationBar";
  public static final String EVENT_TYPE_NET_STATUS = "onXWebLivePlayerNetStatus";
  public static final String EVENT_TYPE_PLAYER_EVENT = "onXWebLivePlayerEvent";
  public static final String EVENT_UPDATE_XWEB_LIVE_PLAYER = "updateXWebLivePlayer";
  private static final Set<String> S_EVENT_MAP = new EmbeddedLivePlayerJsPlugin.1();
  public static final String TAG = "EmbeddedLivePlayerJsPlugin";
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
      QLog.e("EmbeddedLivePlayerJsPlugin", 1, "smallScreen: ", localException);
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
    QLog.d("EmbeddedLivePlayerJsPlugin", 1, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getContainer() != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()) != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()) != null)) {
      localEmbeddedWidgetClientFactory = ((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()).getEmbeddedWidgetClientFactory();
    }
    for (;;)
    {
      if ("insertXWebLivePlayer".equals(paramString1)) {
        if ((this.jsPluginEngine != null) && (localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertEmbeddedWidgetEvent("insertXWebLivePlayer", paramString2, paramJsRuntime, this.jsPluginEngine.appBrandRuntime))) {
          if (this.jsPluginEngine != null) {
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
        }
      }
      for (;;)
      {
        return "";
        if (this.jsPluginEngine != null)
        {
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          continue;
          if ("updateXWebLivePlayer".equals(paramString1))
          {
            if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "updateXWebLivePlayer", paramString2, paramInt)))
            {
              if (this.jsPluginEngine != null) {
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
              }
            }
            else if (this.jsPluginEngine != null) {
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          else if ("operateXWebLivePlayer".equals(paramString1))
          {
            if (((localEmbeddedWidgetClientFactory == null) || (!localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "operateXWebLivePlayer", paramString2, paramInt))) && (this.jsPluginEngine != null)) {
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          else
          {
            if ("removeXWebLivePlayer".equals(paramString1))
            {
              if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "removeXWebLivePlayer", paramString2, paramInt))) {
                if (this.jsPluginEngine != null) {
                  this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
                }
              }
              for (;;)
              {
                QLog.e("EmbeddedLivePlayerJsPlugin", 1, "handleNativeRequest-removeXWebLivePlayer ,jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
                break;
                if (this.jsPluginEngine != null) {
                  this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
                }
              }
            }
            if ("showVirtualBottomNavigationBar".equals(paramString1)) {
              AppBrandTask.runTaskOnUiThread(new EmbeddedLivePlayerJsPlugin.2(this, paramJsRuntime, paramString1, paramInt));
            } else if ("hideVirtualBottomNavigationBar".equals(paramString1)) {
              AppBrandTask.runTaskOnUiThread(new EmbeddedLivePlayerJsPlugin.3(this, paramJsRuntime, paramString1, paramInt));
            } else if (("insertPositioningContainer".equals(paramString1)) && (this.jsPluginEngine != null)) {
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            }
          }
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
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedLivePlayerJsPlugin
 * JD-Core Version:    0.7.0.1
 */