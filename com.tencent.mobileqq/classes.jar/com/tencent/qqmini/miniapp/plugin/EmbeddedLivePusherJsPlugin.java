package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@JsPlugin
public class EmbeddedLivePusherJsPlugin
  extends BaseJsPlugin
{
  private static final int EMBEDDED_ON_DESTROY_EVENT = 3;
  private static final int EMBEDDED_ON_PAUSE_EVENT = 2;
  private static final int EMBEDDED_ON_RESUME_EVENT = 1;
  public static final String EVENT_HIDE_NAVIGATIONBAR = "hideVirtualBottomNavigationBar";
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
  public static final String EVENT_SHOW_NAVIGATIONBAR = "showVirtualBottomNavigationBar";
  public static final String EVENT_UPDATE_XWEB_LIVE_PUSHER = "updateXWebLivePusher";
  public static final String TAG = "EmbeddedLivePusherJsPlugin";
  private int lastNavBarVisibility = 8;
  private int lastTabBarVisibility = 8;
  
  private void enterFullScreenMode(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
      if (Build.VERSION.SDK_INT >= 21) {
        i = 5894;
      } else if (Build.VERSION.SDK_INT >= 16) {
        i = 1798;
      }
      if (Build.VERSION.SDK_INT >= 19) {
        i |= 0x800;
      } else {
        i |= 0x1;
      }
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    }
  }
  
  private void enterSmallScreenMode()
  {
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    WeakReference localWeakReference = new WeakReference(localActivity);
    if (localActivity != null) {
      try
      {
        if (!localActivity.isFinishing())
        {
          if (Build.VERSION.SDK_INT >= 16) {
            localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
          }
          this.mMiniAppContext.performAction(new EmbeddedLivePusherJsPlugin.4(this, localWeakReference));
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("EmbeddedLivePusherJsPlugin", "smallScreen: ", localException);
      }
    }
  }
  
  private EmbeddedWidgetClientFactory getFactory()
  {
    return (EmbeddedWidgetClientFactory)this.mMiniAppContext.performAction(new EmbeddedLivePusherJsPlugin.5(this));
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
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt == 3)
              {
                localEmbeddedWidgetClientHolder.nativeDestroy();
                ((Iterator)localObject).remove();
              }
            }
            else {
              localEmbeddedWidgetClientHolder.nativePause();
            }
          }
          else {
            localEmbeddedWidgetClientHolder.nativeResume();
          }
        }
      }
    }
  }
  
  @JsEvent({"hideVirtualBottomNavigationBar"})
  public void hideNavigationBar(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(new EmbeddedLivePusherJsPlugin.3(this, paramRequestEvent));
  }
  
  @JsEvent({"insertXWebLivePusher"})
  public void insertXWebLivePusher(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    IJsService localIJsService = (IJsService)this.mMiniAppContext.performAction(new EmbeddedLivePusherJsPlugin.1(this));
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
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
  
  @JsEvent({"operateXWebLivePusher"})
  public void operateXWebLivePusher(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"removeXWebLivePusher"})
  public void removeXWebLivePusher(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"setDisplayOrientation"})
  public void setDisplayOrientation(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      i = 0;
      j = ((JSONObject)localObject).optInt("orientation", 0);
      if (j != 90) {
        break label115;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        int i;
        int j;
        continue;
        label115:
        if (j == -90) {
          i = 8;
        } else {
          i = 1;
        }
      }
    }
    if (i != this.mMiniAppContext.getAttachedActivity().getRequestedOrientation())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EVENT_SET_DISPLAY_ORIENTATION, setRequestedOrientation: ");
      ((StringBuilder)localObject).append(j);
      QMLog.i("EmbeddedLivePusherJsPlugin", ((StringBuilder)localObject).toString());
      this.mMiniAppContext.getAttachedActivity().setRequestedOrientation(i);
    }
    paramRequestEvent.ok();
    return;
    paramRequestEvent.fail();
  }
  
  @JsEvent({"showVirtualBottomNavigationBar"})
  public void showNavigationBar(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(new EmbeddedLivePusherJsPlugin.2(this, paramRequestEvent));
  }
  
  @JsEvent({"updateXWebLivePusher"})
  public void updateXWebLivePusher(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin
 * JD-Core Version:    0.7.0.1
 */