package com.tencent.qqmini.sdk.runtime.plugin;

import android.widget.FrameLayout.LayoutParams;
import bghn;
import bgho;
import bgie;
import bgkd;
import bgki;
import bgkk;
import bhab;
import bhfx;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.CoverCameraView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

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
  
  public void callbackJsEventFail(bgkd parambgkd, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = bgki.b(paramString, paramJSONObject).toString();
    parambgkd.jdField_a_of_type_Bghn.a(paramInt, paramString);
  }
  
  public void callbackJsEventOK(bgkd parambgkd, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = bgki.a(paramString, paramJSONObject).toString();
    parambgkd.jdField_a_of_type_Bghn.a(paramInt, paramString);
  }
  
  public void insertCamera(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
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
        bgkk.a(new MediaJsPlugin.5(this, parambgkd, i, j, str2, localJSONObject1, localJSONObject2, str1, bool, (String)localObject));
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
      QMLog.e("MediaJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
  
  public void insertCamera(bgkd parambgkd, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, bhfx parambhfx, String paramString2, boolean paramBoolean, String paramString3)
  {
    CoverView localCoverView = bhab.a(this.mMiniAppContext).a(paramInt1);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverCameraView(this.mMiniAppContext.a(), parambgkd.jdField_a_of_type_Bghn);
      ((CoverCameraView)localObject).setParentId(paramInt2);
      ((CoverCameraView)localObject).setFixed(paramBoolean);
      ((CoverCameraView)localObject).setCameraId(paramInt1);
      ((CoverCameraView)localObject).setWebviewId(bgie.a(this.mMiniAppContext).a());
      bhab.a(this.mMiniAppContext).a(paramInt2, paramInt1, (CoverView)localObject, paramBoolean);
    }
    float f = DisplayUtil.getDensity(this.mMiniAppContext.a());
    if ((localObject instanceof CoverCameraView))
    {
      ((CoverCameraView)localObject).setMode(paramString3);
      ((CoverCameraView)localObject).setFlashMode(paramString2);
      ((CoverCameraView)localObject).setCameraSurfaceCallBack(parambhfx);
      ((CoverCameraView)localObject).a(paramString1);
      paramInt1 = (int)(paramInt5 * f + 0.5F);
      paramInt2 = (int)(paramInt6 * f + 0.5F);
      paramInt3 = (int)(paramInt3 * f + 0.5F);
      paramInt4 = (int)(paramInt4 * f + 0.5F);
      ((CoverCameraView)localObject).setCameraWidth(paramInt1);
      ((CoverCameraView)localObject).setCameraHeight(paramInt2);
      parambgkd = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      parambgkd.leftMargin = paramInt3;
      parambgkd.topMargin = paramInt4;
      ((CoverCameraView)localObject).setLayoutParams(parambgkd);
    }
  }
  
  public void insertVideoPlayer(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgkd.b);
      int i = localJSONObject1.optInt("videoPlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      bgkk.a(new MediaJsPlugin.2(this, i, localJSONObject1, parambgkd, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
  
  public void operateCamera(bgkd parambgkd)
  {
    QMLog.d("MediaJsPlugin", parambgkd.b);
    CoverView localCoverView;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int i = localJSONObject.optInt("cameraId");
      localCoverView = bhab.a(this.mMiniAppContext).a(i);
      if (!(localCoverView instanceof CoverCameraView))
      {
        parambgkd.b();
        return;
      }
      str = localJSONObject.optString("type");
      if ("takePhoto".equals(str))
      {
        ((CoverCameraView)localCoverView).a(parambgkd, localJSONObject.optString("quality"));
        return;
      }
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
      return;
    }
    if ("startRecord".equals(str))
    {
      ((CoverCameraView)localCoverView).a(parambgkd);
      return;
    }
    if ("stopRecord".equals(str)) {
      ((CoverCameraView)localCoverView).b(parambgkd);
    }
  }
  
  public void operateVideoPlayer(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      String str = localJSONObject.optString("type");
      bgkk.a(new MediaJsPlugin.1(this, localJSONObject.optInt("videoPlayerId"), parambgkd, str, localJSONObject.optString("data")));
      return;
    }
    catch (JSONException parambgkd)
    {
      parambgkd.printStackTrace();
    }
  }
  
  public void removeCamera(bgkd parambgkd)
  {
    QMLog.d("MediaJsPlugin", parambgkd.b);
    for (;;)
    {
      int j;
      try
      {
        int i = new JSONObject(parambgkd.b).optInt("cameraId");
        CoverView localCoverView = bhab.a(this.mMiniAppContext).a(i);
        if (!(localCoverView instanceof CoverCameraView))
        {
          parambgkd.b();
          return;
        }
        ((CoverCameraView)localCoverView).a();
        j = ((CoverCameraView)localCoverView).a();
        if (j == 0)
        {
          bhab.a(this.mMiniAppContext).a(i);
          parambgkd.a();
          return;
        }
      }
      catch (JSONException parambgkd)
      {
        parambgkd.printStackTrace();
        return;
      }
      bhab.a(this.mMiniAppContext).a(j);
    }
  }
  
  public void removeVideoPlayer(bgkd parambgkd)
  {
    try
    {
      bgkk.a(new MediaJsPlugin.4(this, new JSONObject(parambgkd.b).optInt("videoPlayerId"), parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
  
  public void updateCamera(bgkd parambgkd)
  {
    for (;;)
    {
      CoverView localCoverView;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(parambgkd.b);
        int i = localJSONObject.optInt("cameraId");
        localCoverView = bhab.a(this.mMiniAppContext).a(i);
        if (!(localCoverView instanceof CoverCameraView))
        {
          parambgkd.b();
          return;
        }
        str = localJSONObject.optString("devicePosition");
        parambgkd = localJSONObject.optString("flash");
        if (parambgkd.equals("on"))
        {
          parambgkd = "on";
          if (!"front".equalsIgnoreCase(str)) {
            break label117;
          }
          ((CoverCameraView)localCoverView).a(false, parambgkd);
          return;
        }
      }
      catch (JSONException parambgkd)
      {
        parambgkd.printStackTrace();
        return;
      }
      if (parambgkd.equals("auto"))
      {
        parambgkd = "auto";
        continue;
        label117:
        if ("back".equalsIgnoreCase(str)) {
          ((CoverCameraView)localCoverView).a(true, parambgkd);
        }
      }
      else
      {
        parambgkd = "off";
      }
    }
  }
  
  public void updateVideoPlayer(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      bgkk.a(new MediaJsPlugin.3(this, localJSONObject.optInt("videoPlayerId"), localJSONObject, parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin
 * JD-Core Version:    0.7.0.1
 */