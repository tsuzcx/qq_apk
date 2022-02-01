package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.util.EmbeddedHelper;
import com.tencent.qqmini.miniapp.widget.CoverCameraView;
import com.tencent.qqmini.miniapp.widget.camera.CameraCallBack;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class MediaJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_CAMERA = "insertCamera";
  private static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
  public static final String EVENT_OPERATE_CAMERA = "operateCamera";
  private static final String EVENT_OPERATE_VIDEO_PLAYER = "operateVideoPlayer";
  public static final String EVENT_REMOVE_CAMERA = "removeCamera";
  private static final String EVENT_REMOVE_VIDEOPLAYER = "removeVideoPlayer";
  public static final String EVENT_UPDATE_CAMERA = "updateCamera";
  private static final String EVENT_UPDATE_VIDEO_PLAYER = "updateVideoPlayer";
  public static final String TAG = "MediaJsPlugin";
  
  private boolean handleSeek(CoverVideoView paramCoverVideoView, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        bool1 = bool2;
        if (localJSONArray.length() == 1) {
          bool1 = paramCoverVideoView.seekTo((int)(localJSONArray.getDouble(0) * 1000.0D));
        }
      }
      return bool1;
    }
    catch (Exception paramCoverVideoView)
    {
      QMLog.e("MediaJsPlugin", "wrong seek pram. " + paramString);
    }
    return false;
  }
  
  private void handleSendDanmu(CoverVideoView paramCoverVideoView, String paramString1, RequestEvent paramRequestEvent, String paramString2, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString1);
        if (localJSONArray.length() == 2)
        {
          paramString1 = localJSONArray.getString(0);
          i = ColorUtils.parseColor(localJSONArray.getString(1));
          paramCoverVideoView.playDanmu(paramString1, i);
          return;
        }
        if (localJSONArray.length() == 1) {
          paramString1 = localJSONArray.getString(0);
        } else {
          paramString1 = null;
        }
      }
      catch (Exception paramCoverVideoView)
      {
        QMLog.e("MediaJsPlugin", "sendDanmu error." + paramCoverVideoView);
        callbackJsEventFail(paramRequestEvent, paramString2, null, paramInt);
        return;
      }
    }
  }
  
  public void callbackJsEventFail(RequestEvent paramRequestEvent, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = ApiUtil.wrapCallbackFail(paramString, paramJSONObject).toString();
    paramRequestEvent.jsService.evaluateCallbackJs(paramInt, paramString);
  }
  
  public void callbackJsEventOK(RequestEvent paramRequestEvent, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject).toString();
    paramRequestEvent.jsService.evaluateCallbackJs(paramInt, paramString);
  }
  
  @JsEvent({"insertCamera"})
  public void insertCamera(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).optInt("cameraId");
      int j = ((JSONObject)localObject).optInt("parentId");
      JSONObject localJSONObject1 = ((JSONObject)localObject).optJSONObject("position");
      String str1 = ((JSONObject)localObject).optString("flash");
      String str2 = ((JSONObject)localObject).optString("devicePosition");
      if (str1.equals("on")) {
        str1 = "on";
      }
      for (;;)
      {
        boolean bool = ((JSONObject)localObject).optBoolean("fixed", false);
        localObject = ((JSONObject)localObject).optString("mode");
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("containerId", i);
        AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.5(this, paramRequestEvent, i, j, str2, localJSONObject1, localJSONObject2, str1, bool, (String)localObject));
        return;
        if (str1.equals("auto")) {
          str1 = "auto";
        } else {
          str1 = "off";
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  public void insertCamera(RequestEvent paramRequestEvent, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, CameraCallBack paramCameraCallBack, String paramString2, boolean paramBoolean, String paramString3)
  {
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(paramInt1);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverCameraView(this.mMiniAppContext, paramRequestEvent.jsService);
      ((CoverCameraView)localObject).setParentId(paramInt2);
      ((CoverCameraView)localObject).setFixed(paramBoolean);
      ((CoverCameraView)localObject).setCameraId(paramInt1);
      ((CoverCameraView)localObject).setWebviewId(PageAction.obtain(this.mMiniAppContext).getPageId());
      CoverViewAction.obtain(this.mMiniAppContext).add(paramInt2, paramInt1, (CoverView)localObject, paramBoolean);
    }
    float f = DisplayUtil.getDensity(this.mMiniAppContext.getAttachedActivity());
    if ((localObject instanceof CoverCameraView))
    {
      ((CoverCameraView)localObject).setMode(paramString3);
      ((CoverCameraView)localObject).setFlashMode(paramString2);
      ((CoverCameraView)localObject).setCameraSurfaceCallBack(paramCameraCallBack);
      ((CoverCameraView)localObject).openCamera(paramString1);
      paramInt1 = (int)(paramInt5 * f + 0.5F);
      paramInt2 = (int)(paramInt6 * f + 0.5F);
      paramInt3 = (int)(paramInt3 * f + 0.5F);
      paramInt4 = (int)(paramInt4 * f + 0.5F);
      ((CoverCameraView)localObject).setCameraWidth(paramInt1);
      ((CoverCameraView)localObject).setCameraHeight(paramInt2);
      paramRequestEvent = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramRequestEvent.leftMargin = paramInt3;
      paramRequestEvent.topMargin = paramInt4;
      ((CoverCameraView)localObject).setLayoutParams(paramRequestEvent);
    }
  }
  
  @JsEvent({"insertVideoPlayer"})
  public void insertVideoPlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("videoPlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.2(this, i, paramRequestEvent, localJSONObject1, localJSONObject2));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MediaJsPlugin", paramRequestEvent.event + " error.", localException);
    }
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    if ("insertVideoPlayer".equals(paramRequestEvent.event)) {
      EmbeddedHelper.checkEmbeddedWidgetSupport(paramRequestEvent, this.mMiniAppContext.getMiniAppInfo().appId, this.mMiniAppContext.getAttachedActivity());
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"operateCamera"})
  public void operateCamera(RequestEvent paramRequestEvent)
  {
    QMLog.d("MediaJsPlugin", paramRequestEvent.jsonParams);
    CoverView localCoverView;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("cameraId");
      localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(i);
      if (!(localCoverView instanceof CoverCameraView))
      {
        paramRequestEvent.fail();
        return;
      }
      str = localJSONObject.optString("type");
      if ("takePhoto".equals(str))
      {
        ((CoverCameraView)localCoverView).takePhoto(paramRequestEvent, localJSONObject.optString("quality"));
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
      return;
    }
    if ("startRecord".equals(str))
    {
      ((CoverCameraView)localCoverView).startRecord(paramRequestEvent);
      return;
    }
    if ("stopRecord".equals(str)) {
      ((CoverCameraView)localCoverView).stopRecord(paramRequestEvent);
    }
  }
  
  @JsEvent({"operateVideoPlayer"})
  public void operateVideoPlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("type");
      AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.1(this, localJSONObject.optInt("videoPlayerId"), paramRequestEvent, str, localJSONObject.optString("data")));
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"removeCamera"})
  public void removeCamera(RequestEvent paramRequestEvent)
  {
    QMLog.d("MediaJsPlugin", paramRequestEvent.jsonParams);
    try
    {
      int i = new JSONObject(paramRequestEvent.jsonParams).optInt("cameraId");
      CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(i);
      if (!(localCoverView instanceof CoverCameraView))
      {
        paramRequestEvent.fail();
        return;
      }
      ((CoverCameraView)localCoverView).closeCamera();
      AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.6(this, localCoverView, i, paramRequestEvent));
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"removeVideoPlayer"})
  public void removeVideoPlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.4(this, new JSONObject(paramRequestEvent.jsonParams).optInt("videoPlayerId"), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"updateCamera"})
  public void updateCamera(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      CoverView localCoverView;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        int i = localJSONObject.optInt("cameraId");
        localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(i);
        if (!(localCoverView instanceof CoverCameraView))
        {
          paramRequestEvent.fail();
          return;
        }
        str = localJSONObject.optString("devicePosition");
        paramRequestEvent = localJSONObject.optString("flash");
        if (paramRequestEvent.equals("on"))
        {
          paramRequestEvent = "on";
          if (!"front".equalsIgnoreCase(str)) {
            break label117;
          }
          ((CoverCameraView)localCoverView).switchCamera(false, paramRequestEvent);
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return;
      }
      if (paramRequestEvent.equals("auto"))
      {
        paramRequestEvent = "auto";
        continue;
        label117:
        if ("back".equalsIgnoreCase(str)) {
          ((CoverCameraView)localCoverView).switchCamera(true, paramRequestEvent);
        }
      }
      else
      {
        paramRequestEvent = "off";
      }
    }
  }
  
  @JsEvent({"updateVideoPlayer"})
  public void updateVideoPlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.3(this, localJSONObject.optInt("videoPlayerId"), localJSONObject, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MediaJsPlugin", paramRequestEvent.event + " error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin
 * JD-Core Version:    0.7.0.1
 */