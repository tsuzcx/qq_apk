package com.tencent.qqmini.sdk.runtime.plugin;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.Window;
import bglu;
import bglv;
import bgok;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;
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
    int i;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
      if (Build.VERSION.SDK_INT < 21) {
        break label60;
      }
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label75;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      label60:
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label75:
      i |= 0x1;
    }
  }
  
  private void enterSmallScreenMode()
  {
    Activity localActivity = this.mMiniAppContext.a();
    WeakReference localWeakReference = new WeakReference(localActivity);
    if (localActivity != null) {}
    try
    {
      if (!localActivity.isFinishing())
      {
        if (Build.VERSION.SDK_INT >= 16) {
          localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
        }
        this.mMiniAppContext.a(new EmbeddedVideoJsPlugin.4(this, localWeakReference));
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("EmbeddedVideoJsPlugin", "smallScreen: ", localException);
    }
  }
  
  private EmbeddedWidgetClientFactory getFactory()
  {
    return (EmbeddedWidgetClientFactory)this.mMiniAppContext.a(new EmbeddedVideoJsPlugin.5(this));
  }
  
  public void getVolume(bgok parambgok)
  {
    try
    {
      Object localObject = (AudioManager)this.mMiniAppContext.a().getSystemService("audio");
      if (localObject != null)
      {
        int i = ((AudioManager)localObject).getStreamVolume(3);
        int j = ((AudioManager)localObject).getStreamMaxVolume(3);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("currentVolume", i);
        ((JSONObject)localObject).put("maxVolume", j);
        parambgok.a((JSONObject)localObject);
        return;
      }
      parambgok.a("AudioManager error");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("EmbeddedVideoJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " error.", localThrowable);
      parambgok.b();
    }
  }
  
  public void hideNavigationBar(bgok parambgok)
  {
    this.mMiniAppContext.a(new EmbeddedVideoJsPlugin.2(this, parambgok));
  }
  
  public void insertXwebVideo(bgok parambgok)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    bglu localbglu = (bglu)this.mMiniAppContext.a(new EmbeddedVideoJsPlugin.1(this));
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertXWebVideo(parambgok.b, parambgok.jdField_a_of_type_Bglu, localbglu)))
    {
      parambgok.a();
      return;
    }
    parambgok.b();
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getVideoEmbeddedWidgetClientMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getVideoEmbeddedWidgetClientMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localVideoEmbeddedWidgetClient != null) {
          localVideoEmbeddedWidgetClient.nativeDestroy();
        }
        ((Iterator)localObject).remove();
      }
    }
  }
  
  public boolean onInterceptJsEvent(bgok parambgok)
  {
    QMLog.i("EmbeddedVideoJsPlugin", parambgok.jdField_a_of_type_JavaLangString);
    return super.onInterceptJsEvent(parambgok);
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getVideoEmbeddedWidgetClientMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getVideoEmbeddedWidgetClientMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localVideoEmbeddedWidgetClient != null) {
          localVideoEmbeddedWidgetClient.nativePause();
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getVideoEmbeddedWidgetClientMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getVideoEmbeddedWidgetClientMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoEmbeddedWidgetClient localVideoEmbeddedWidgetClient = (VideoEmbeddedWidgetClient)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localVideoEmbeddedWidgetClient != null) {
          localVideoEmbeddedWidgetClient.nativeResume();
        }
      }
    }
  }
  
  public void operateXwebVideo(bgok parambgok)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleOperateXWebVideo(parambgok.b)))
    {
      parambgok.a();
      return;
    }
    parambgok.b();
  }
  
  public void setDisplayOrientation(bgok parambgok)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        int j = new JSONObject(parambgok.b).optInt("orientation", 0);
        if (j == 90)
        {
          if (i != this.mMiniAppContext.a().getRequestedOrientation())
          {
            Log.i("EmbeddedVideoJsPlugin", "EVENT_SET_DISPLAY_ORIENTATION, setRequestedOrientation: " + j);
            this.mMiniAppContext.a().setRequestedOrientation(i);
          }
          parambgok.a();
          return;
        }
        if (j == -90) {
          i = 8;
        } else {
          i = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        parambgok.b();
        return;
      }
    }
  }
  
  public void setVolume(bgok parambgok)
  {
    try
    {
      int i = new JSONObject(parambgok.b).optInt("value");
      AudioManager localAudioManager = (AudioManager)this.mMiniAppContext.a().getSystemService("audio");
      if (localAudioManager != null)
      {
        if ((i <= localAudioManager.getStreamMaxVolume(3)) && (i >= 0))
        {
          localAudioManager.setStreamVolume(3, i, 4);
          parambgok.a();
          return;
        }
        parambgok.a("value error");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("EmbeddedVideoJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " error.", localThrowable);
      parambgok.b();
      return;
    }
    parambgok.a("AudioManager error");
  }
  
  public void showNavigationBar(bgok parambgok)
  {
    this.mMiniAppContext.a(new EmbeddedVideoJsPlugin.3(this, parambgok));
  }
  
  public void updateXwebVideo(bgok parambgok)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleUpdateXWebVideo(parambgok.b)))
    {
      parambgok.a();
      return;
    }
    parambgok.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.EmbeddedVideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */