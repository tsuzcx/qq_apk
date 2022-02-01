package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
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
  public static final String TAG = "EmbeddedVideoJsPlugin";
  public static final String VIDEO_EVENT_END = "onXWebVideoEnded";
  public static final String VIDEO_EVENT_EXIT_FULLSCREEN = "onXWebVideoExitFullscreen";
  public static final String VIDEO_EVENT_LOADED_METADATA = "onXWebVideoLoadedMetaData";
  public static final String VIDEO_EVENT_PAUSE = "onXWebVideoPause";
  public static final String VIDEO_EVENT_PLAY = "onXWebVideoPlay";
  public static final String VIDEO_EVENT_PROGRESS = "onXWebVideoProgress";
  public static final String VIDEO_EVENT_TIME_UPDATE = "onXWebVideoTimeUpdate";
  public static final String VIDEO_EVENT_WAITING = "onXWebVideoWaiting";
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
          this.mMiniAppContext.performAction(new EmbeddedVideoJsPlugin.3(this, localWeakReference));
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("EmbeddedVideoJsPlugin", "smallScreen: ", localException);
      }
    }
  }
  
  private EmbeddedWidgetClientFactory getFactory()
  {
    return (EmbeddedWidgetClientFactory)this.mMiniAppContext.performAction(new EmbeddedVideoJsPlugin.4(this));
  }
  
  @JsEvent({"getVolume"})
  public void getVolume(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = (AudioManager)this.mMiniAppContext.getContext().getSystemService("audio");
      if (localObject != null)
      {
        int i = ((AudioManager)localObject).getStreamVolume(3);
        int j = ((AudioManager)localObject).getStreamMaxVolume(3);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("currentVolume", i);
        ((JSONObject)localObject).put("maxVolume", j);
        paramRequestEvent.ok((JSONObject)localObject);
        return;
      }
      paramRequestEvent.fail("AudioManager error");
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("EmbeddedVideoJsPlugin", localStringBuilder.toString(), localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"hideVirtualBottomNavigationBar"})
  public void hideNavigationBar(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(new EmbeddedVideoJsPlugin.1(this, paramRequestEvent));
  }
  
  @JsEvent({"insertXWebVideo"})
  public void insertXwebVideo(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
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
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    QMLog.i("EmbeddedVideoJsPlugin", paramRequestEvent.event);
    return super.onInterceptJsEvent(paramRequestEvent);
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
  
  @JsEvent({"operateXWebVideo"})
  public void operateXwebVideo(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"removeXWebVideo"})
  public void removeXWebVideo(RequestEvent paramRequestEvent)
  {
    paramRequestEvent.ok();
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
        break label116;
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
        label116:
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
      Log.i("EmbeddedVideoJsPlugin", ((StringBuilder)localObject).toString());
      this.mMiniAppContext.getAttachedActivity().setRequestedOrientation(i);
    }
    paramRequestEvent.ok();
    return;
    paramRequestEvent.fail();
  }
  
  @JsEvent({"setVolume"})
  public void setVolume(RequestEvent paramRequestEvent)
  {
    try
    {
      int i = new JSONObject(paramRequestEvent.jsonParams).optInt("value");
      AudioManager localAudioManager = (AudioManager)this.mMiniAppContext.getContext().getSystemService("audio");
      if (localAudioManager != null)
      {
        if ((i <= localAudioManager.getStreamMaxVolume(3)) && (i >= 0))
        {
          localAudioManager.setStreamVolume(3, i, 4);
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail("value error");
        return;
      }
      paramRequestEvent.fail("AudioManager error");
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("EmbeddedVideoJsPlugin", localStringBuilder.toString(), localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"showVirtualBottomNavigationBar"})
  public void showNavigationBar(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(new EmbeddedVideoJsPlugin.2(this, paramRequestEvent));
  }
  
  @JsEvent({"updateXWebVideo"})
  public void updateXwebVideo(RequestEvent paramRequestEvent)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */