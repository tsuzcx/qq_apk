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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("insertVideoPlayer: ");
    ((StringBuilder)localObject1).append(paramJSONObject);
    QMLog.i("VideoPlugin", ((StringBuilder)localObject1).toString());
    if ((paramIMiniAppContext != null) && (paramIMiniAppContext.getAttachedActivity() != null))
    {
      Activity localActivity = paramIMiniAppContext.getAttachedActivity();
      Object localObject2 = (CoverView)this.mCoverViewSparseArray.get(paramInt);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new CoverVideoView(localActivity);
        localObject2 = (CoverVideoView)localObject1;
        ((CoverVideoView)localObject2).setData(paramJSONObject.optString("data"));
        ((CoverVideoView)localObject2).setPageWebView(paramIJsService);
        ((CoverVideoView)localObject2).setVideoPlayerId(paramInt);
        ((CoverVideoView)localObject2).setParentId(paramInt);
        this.mCoverViewSparseArray.put(paramInt, localObject1);
        GameVideoPlayerManager.addPlayerView(paramIMiniAppContext, (ViewGroup)localObject1);
      }
      if ((localObject1 instanceof CoverVideoView))
      {
        paramIJsService = (CoverVideoView)localObject1;
        paramIJsService.setMiniAppContext(paramIMiniAppContext);
        paramIJsService.initVideoPlayerSettings(paramJSONObject);
        if (paramJSONObject.optBoolean("hide")) {
          paramIJsService.setVisibility(8);
        }
      }
      return true;
    }
    return false;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wrong seek pram. ");
      localStringBuilder.append(paramString);
      QMLog.e("VideoPlugin", localStringBuilder.toString(), paramCoverVideoView);
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
        paramString = null;
        if (localJSONArray.length() == 2)
        {
          paramString = localJSONArray.getString(0);
          i = ColorUtils.parseColor(localJSONArray.getString(1));
        }
        else
        {
          if (localJSONArray.length() != 1) {
            break label79;
          }
          paramString = localJSONArray.getString(0);
          break label79;
        }
        paramCoverVideoView.playDanmu(paramString, i);
        return true;
      }
      catch (Exception paramString)
      {
        QMLog.e("VideoPlugin", "sendDanmu error.", paramString);
        return false;
      }
      label79:
      int i = 0;
    }
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView1 != null) && (localCoverView1.getParentId() == paramInt)) {
        if (localCoverView1.getParentId() == 0)
        {
          GameVideoPlayerManager.removeView(this.mMiniAppContext, localCoverView1);
        }
        else
        {
          CoverView localCoverView2 = (CoverView)this.mCoverViewSparseArray.get(localCoverView1.getParentId());
          if (localCoverView2 != null) {
            localCoverView2.removeView(localCoverView1);
          }
        }
      }
      i += 1;
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
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if ((localObject instanceof CoverVideoView))
    {
      localObject = (CoverVideoView)localObject;
      ((CoverVideoView)localObject).updateVideoPlayerSettings(paramJSONObject);
      if (!paramJSONObject.optBoolean("hide")) {
        ((CoverVideoView)localObject).setVisibility(0);
      }
      paramJSONObject = paramJSONObject.optString("src");
      if (!StringUtil.isEmpty(paramJSONObject)) {
        ((CoverVideoView)localObject).setVideoPath(paramJSONObject);
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
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("videoPlayerId");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("containerId", i);
      ThreadManager.getUIHandler().post(new VideoJsPlugin.1(this, paramRequestEvent, i, localJSONObject, (JSONObject)localObject));
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("VideoPlugin", ((StringBuilder)localObject).toString(), localThrowable);
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
      localObject = localJSONObject.optString("type");
      int i = localJSONObject.optInt("videoPlayerId");
      ThreadManager.getUIHandler().post(new VideoJsPlugin.3(this, i, (String)localObject, paramRequestEvent));
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("VideoPlugin", ((StringBuilder)localObject).toString(), localThrowable);
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
      paramString1 = (CoverVideoView)localCoverView;
      if (!paramString1.isFullScreen()) {
        paramString1.fullScreen();
      }
      return true;
    }
    if ("exitFullScreen".equals(paramString1))
    {
      paramString1 = (CoverVideoView)localCoverView;
      if (paramString1.isFullScreen()) {
        paramString1.smallScreen();
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
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("VideoPlugin", localStringBuilder.toString(), localThrowable);
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
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("VideoPlugin", localStringBuilder.toString(), localThrowable);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.VideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */