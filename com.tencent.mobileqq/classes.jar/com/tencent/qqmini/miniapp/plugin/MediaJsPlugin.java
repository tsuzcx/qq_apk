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
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        break label74;
      }
      JSONArray localJSONArray = new JSONArray(paramString);
      if (localJSONArray.length() != 1) {
        break label74;
      }
      boolean bool = paramCoverVideoView.seekTo((int)(localJSONArray.getDouble(0) * 1000.0D));
      return bool;
    }
    catch (Exception paramCoverVideoView)
    {
      label44:
      label74:
      break label44;
    }
    paramCoverVideoView = new StringBuilder();
    paramCoverVideoView.append("wrong seek pram. ");
    paramCoverVideoView.append(paramString);
    QMLog.e("MediaJsPlugin", paramCoverVideoView.toString());
    return false;
  }
  
  private void handleSendDanmu(CoverVideoView paramCoverVideoView, String paramString1, RequestEvent paramRequestEvent, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString1);
        int j = localJSONArray.length();
        int i = 0;
        if (j == 2)
        {
          paramString1 = localJSONArray.getString(0);
          i = ColorUtils.parseColor(localJSONArray.getString(1));
        }
        else
        {
          if (localJSONArray.length() != 1) {
            break label116;
          }
          paramString1 = localJSONArray.getString(0);
        }
        paramCoverVideoView.playDanmu(paramString1, i);
        return;
      }
      catch (Exception paramCoverVideoView)
      {
        paramString1 = new StringBuilder();
        paramString1.append("sendDanmu error.");
        paramString1.append(paramCoverVideoView);
        QMLog.e("MediaJsPlugin", paramString1.toString());
        callbackJsEventFail(paramRequestEvent, paramString2, null, paramInt);
        return;
      }
      label116:
      paramString1 = null;
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
    String str2;
    for (String str1 = "on";; str2 = "off") {
      try
      {
        Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
        int i = ((JSONObject)localObject2).optInt("cameraId");
        int j = ((JSONObject)localObject2).optInt("parentId");
        localObject1 = ((JSONObject)localObject2).optJSONObject("position");
        Object localObject3 = ((JSONObject)localObject2).optString("flash");
        String str3 = ((JSONObject)localObject2).optString("devicePosition");
        boolean bool = ((String)localObject3).equals("on");
        if (!bool)
        {
          if (!((String)localObject3).equals("auto")) {
            continue;
          }
          str1 = "auto";
        }
        bool = ((JSONObject)localObject2).optBoolean("fixed", false);
        localObject2 = ((JSONObject)localObject2).optString("mode");
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("containerId", i);
        AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.5(this, paramRequestEvent, i, j, str3, (JSONObject)localObject1, (JSONObject)localObject3, str1, bool, (String)localObject2));
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramRequestEvent.event);
        ((StringBuilder)localObject1).append(" error.");
        QMLog.e("MediaJsPlugin", ((StringBuilder)localObject1).toString(), localJSONException);
        return;
      }
    }
  }
  
  public void insertCamera(RequestEvent paramRequestEvent, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, CameraCallBack paramCameraCallBack, String paramString2, boolean paramBoolean, String paramString3)
  {
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(paramInt1);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverCameraView(this.mMiniAppContext, paramRequestEvent.jsService);
      paramRequestEvent = (CoverCameraView)localObject;
      paramRequestEvent.setParentId(paramInt2);
      paramRequestEvent.setFixed(paramBoolean);
      paramRequestEvent.setCameraId(paramInt1);
      paramRequestEvent.setWebviewId(PageAction.obtain(this.mMiniAppContext).getPageId());
      CoverViewAction.obtain(this.mMiniAppContext).add(paramInt2, paramInt1, (CoverView)localObject, paramBoolean);
    }
    float f = DisplayUtil.getDensity(this.mMiniAppContext.getAttachedActivity());
    if ((localObject instanceof CoverCameraView))
    {
      paramRequestEvent = (CoverCameraView)localObject;
      paramRequestEvent.setMode(paramString3);
      paramRequestEvent.setFlashMode(paramString2);
      paramRequestEvent.setCameraSurfaceCallBack(paramCameraCallBack);
      paramRequestEvent.openCamera(paramString1);
      paramInt1 = (int)(paramInt5 * f + 0.5F);
      paramInt2 = (int)(paramInt6 * f + 0.5F);
      paramInt3 = (int)(paramInt3 * f + 0.5F);
      paramInt4 = (int)(f * paramInt4 + 0.5F);
      paramRequestEvent.setCameraWidth(paramInt1);
      paramRequestEvent.setCameraHeight(paramInt2);
      paramString1 = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramString1.leftMargin = paramInt3;
      paramString1.topMargin = paramInt4;
      paramRequestEvent.setLayoutParams(paramString1);
    }
  }
  
  @JsEvent({"insertVideoPlayer"})
  public void insertVideoPlayer(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("videoPlayerId");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new MediaJsPlugin.2(this, i, paramRequestEvent, localJSONObject, (JSONObject)localObject));
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("MediaJsPlugin", ((StringBuilder)localObject).toString(), localException);
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
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject.optInt("cameraId");
      CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(i);
      if (!(localCoverView instanceof CoverCameraView))
      {
        paramRequestEvent.fail();
        return;
      }
      String str = localJSONObject.optString("type");
      if ("takePhoto".equals(str))
      {
        ((CoverCameraView)localCoverView).takePhoto(paramRequestEvent, localJSONObject.optString("quality"));
        return;
      }
      if ("startRecord".equals(str))
      {
        ((CoverCameraView)localCoverView).startRecord(paramRequestEvent);
        return;
      }
      if ("stopRecord".equals(str))
      {
        ((CoverCameraView)localCoverView).stopRecord(paramRequestEvent);
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("MediaJsPlugin", localStringBuilder.toString(), localJSONException);
    }
  }
  
  @JsEvent({"updateCamera"})
  public void updateCamera(RequestEvent paramRequestEvent)
  {
    String str1 = "on";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        int i = localJSONObject.optInt("cameraId");
        CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(i);
        if (!(localCoverView instanceof CoverCameraView))
        {
          paramRequestEvent.fail();
          return;
        }
        String str2 = localJSONObject.optString("devicePosition");
        paramRequestEvent = localJSONObject.optString("flash");
        boolean bool = paramRequestEvent.equals("on");
        if (bool)
        {
          paramRequestEvent = str1;
        }
        else
        {
          if (!paramRequestEvent.equals("auto")) {
            break label151;
          }
          paramRequestEvent = "auto";
        }
        if ("front".equalsIgnoreCase(str2))
        {
          ((CoverCameraView)localCoverView).switchCamera(false, paramRequestEvent);
          return;
        }
        if ("back".equalsIgnoreCase(str2))
        {
          ((CoverCameraView)localCoverView).switchCamera(true, paramRequestEvent);
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
      }
      return;
      label151:
      paramRequestEvent = "off";
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("MediaJsPlugin", localStringBuilder.toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin
 * JD-Core Version:    0.7.0.1
 */