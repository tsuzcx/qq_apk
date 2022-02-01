package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qqmini.minigame.manager.GameVideoPlayerManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
public class VideoJsPlugin
  extends BaseJsPlugin
{
  public static final String EMPTY_RESULT = "{}";
  public static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
  public static final String EVENT_OPERATE_VIDEO_PLAYER = "operateVideoPlayer";
  public static final String EVENT_REMOVE_VIDEOPLAYER = "removeVideoPlayer";
  public static final String EVENT_UPDATE_VIDEO_PLAYER = "updateVideoPlayer";
  private static final String TAG = "VideoPlugin";
  private float density;
  private SparseArray<CoverView> mCoverViewSparseArray = new SparseArray();
  
  private boolean insertVideoPlayer(IMiniAppContext paramIMiniAppContext, IJsService paramIJsService, int paramInt, JSONObject paramJSONObject)
  {
    QMLog.i("VideoPlugin", "insertVideoPlayer: " + paramJSONObject);
    if ((paramIMiniAppContext == null) || (paramIMiniAppContext.getAttachedActivity() == null)) {
      return false;
    }
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (localObject == null)
    {
      localObject = new CoverVideoView(localActivity);
      ((CoverVideoView)localObject).setData(paramJSONObject.optString("data"));
      ((CoverVideoView)localObject).setPageWebView(paramIJsService);
      ((CoverVideoView)localObject).setVideoPlayerId(paramInt);
      ((CoverVideoView)localObject).setParentId(paramInt);
      this.mCoverViewSparseArray.put(paramInt, localObject);
      GameVideoPlayerManager.addPlayerView(paramIMiniAppContext, (ViewGroup)localObject);
    }
    for (paramIJsService = (IJsService)localObject;; paramIJsService = (IJsService)localObject)
    {
      if ((paramIJsService instanceof CoverVideoView))
      {
        ((CoverVideoView)paramIJsService).setMiniAppContext(paramIMiniAppContext);
        ((CoverVideoView)paramIJsService).initVideoPlayerSettings(paramJSONObject);
        if (paramJSONObject.optBoolean("hide")) {
          ((CoverVideoView)paramIJsService).setVisibility(8);
        }
      }
      return true;
    }
  }
  
  private boolean operatePlayerSeek(String paramString, CoverVideoView paramCoverVideoView)
  {
    try
    {
      boolean bool = paramCoverVideoView.seekTo((int)(new JSONObject(paramString).optDouble("time") * 1000.0D));
      return bool;
    }
    catch (Exception paramCoverVideoView)
    {
      QMLog.e("VideoPlugin", "wrong seek pram. " + paramString, paramCoverVideoView);
    }
    return false;
  }
  
  private boolean operatePlayerSendDanmu(String paramString, CoverVideoView paramCoverVideoView)
  {
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        if (localJSONArray.length() == 2)
        {
          paramString = localJSONArray.getString(0);
          i = ColorUtils.parseColor(localJSONArray.getString(1));
          paramCoverVideoView.playDanmu(paramString, i);
          return true;
        }
        if (localJSONArray.length() == 1)
        {
          paramString = localJSONArray.getString(0);
          i = 0;
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        QMLog.e("VideoPlugin", "sendDanmu error.", paramString);
        return false;
      }
      int i = 0;
    }
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int i = 0;
    if (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView1 != null) && (localCoverView1.getParentId() == paramInt))
      {
        if (localCoverView1.getParentId() != 0) {
          break label73;
        }
        GameVideoPlayerManager.removeView(this.mMiniAppContext, localCoverView1);
      }
      for (;;)
      {
        i += 1;
        break;
        label73:
        CoverView localCoverView2 = (CoverView)this.mCoverViewSparseArray.get(localCoverView1.getParentId());
        if (localCoverView2 != null) {
          localCoverView2.removeView(localCoverView1);
        }
      }
    }
  }
  
  private void removeVideoPlayer(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverVideoView)) {
      return;
    }
    removeCoverChildView(paramInt);
    GameVideoPlayerManager.removeView(this.mMiniAppContext, localCoverView);
  }
  
  private void updateVideoPlayer(int paramInt, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if ((localCoverView instanceof CoverVideoView))
    {
      ((CoverVideoView)localCoverView).updateVideoPlayerSettings(paramJSONObject);
      if (!paramJSONObject.optBoolean("hide")) {
        ((CoverVideoView)localCoverView).setVisibility(0);
      }
      paramJSONObject = paramJSONObject.optString("src");
      if (!StringUtil.isEmpty(paramJSONObject)) {
        ((CoverVideoView)localCoverView).setVideoPath(paramJSONObject);
      }
    }
  }
  
  @JsEvent({"insertVideoPlayer"})
  public String insertVideoPlayer(RequestEvent paramRequestEvent)
  {
    if (this.density <= 0.0F) {
      this.density = DisplayUtil.getDensity(this.mContext);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("videoPlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      ThreadManager.getUIHandler().post(new VideoJsPlugin.1(this, paramRequestEvent, i, localJSONObject1, localJSONObject2));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("VideoPlugin", paramRequestEvent.event + " error.", localThrowable);
    }
    return "{}";
  }
  
  @JsEvent({"operateVideoPlayer"})
  public String operateVideoPlayer(RequestEvent paramRequestEvent)
  {
    if (this.density <= 0.0F) {
      this.density = DisplayUtil.getDensity(this.mContext);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("type");
      int i = localJSONObject.optInt("videoPlayerId");
      ThreadManager.getUIHandler().post(new VideoJsPlugin.3(this, i, str, paramRequestEvent));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("VideoPlugin", paramRequestEvent.event + " error.", localThrowable);
    }
    return "{}";
  }
  
  public boolean operateVideoPlayer(int paramInt, String paramString1, String paramString2)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverVideoView)) {
      return false;
    }
    if ("play".equals(paramString1))
    {
      ((CoverVideoView)localCoverView).playWithUi();
      return true;
    }
    if ("pause".equals(paramString1))
    {
      ((CoverVideoView)localCoverView).pauseWithUi();
      return true;
    }
    if ("stop".equals(paramString1))
    {
      ((CoverVideoView)localCoverView).stop();
      return true;
    }
    if (("seek".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return operatePlayerSeek(paramString2, (CoverVideoView)localCoverView);
    }
    if (("playbackRate".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      QMLog.e("VideoPlugin", "playbackRate is not support.");
      return true;
    }
    if ("requestFullScreen".equals(paramString1))
    {
      if (!((CoverVideoView)localCoverView).isFullScreen()) {
        ((CoverVideoView)localCoverView).fullScreen();
      }
      return true;
    }
    if ("exitFullScreen".equals(paramString1))
    {
      if (((CoverVideoView)localCoverView).isFullScreen()) {
        ((CoverVideoView)localCoverView).smallScreen();
      }
      return true;
    }
    if ("sendDanmu".equals(paramString1)) {
      return operatePlayerSendDanmu(paramString2, (CoverVideoView)localCoverView);
    }
    return false;
  }
  
  @JsEvent({"removeVideoPlayer"})
  public String removeVideoPlayer(RequestEvent paramRequestEvent)
  {
    if (this.density <= 0.0F) {
      this.density = DisplayUtil.getDensity(this.mContext);
    }
    try
    {
      int i = new JSONObject(paramRequestEvent.jsonParams).optInt("videoPlayerId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if ((localCoverView instanceof CoverVideoView))
      {
        ((CoverVideoView)localCoverView).pauseWithUi();
        ((CoverVideoView)localCoverView).stop();
        ((CoverVideoView)localCoverView).release();
      }
      ThreadManager.getUIHandler().post(new VideoJsPlugin.4(this, i, paramRequestEvent));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("VideoPlugin", paramRequestEvent.event + " error.", localThrowable);
    }
    return "{}";
  }
  
  @JsEvent({"updateVideoPlayer"})
  public String updateVideoPlayer(RequestEvent paramRequestEvent)
  {
    if (this.density <= 0.0F) {
      this.density = DisplayUtil.getDensity(this.mContext);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("videoPlayerId");
      ThreadManager.getUIHandler().post(new VideoJsPlugin.2(this, i, localJSONObject, paramRequestEvent));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("VideoPlugin", paramRequestEvent.event + " error.", localThrowable);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.VideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */