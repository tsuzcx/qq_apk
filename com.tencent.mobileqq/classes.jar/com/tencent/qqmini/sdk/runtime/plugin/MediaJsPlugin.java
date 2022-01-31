package com.tencent.qqmini.sdk.runtime.plugin;

import android.widget.FrameLayout.LayoutParams;
import bglu;
import bglv;
import bgml;
import bgok;
import bgop;
import bgor;
import bhei;
import bhke;
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
  
  public void callbackJsEventFail(bgok parambgok, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = bgop.b(paramString, paramJSONObject).toString();
    parambgok.jdField_a_of_type_Bglu.a(paramInt, paramString);
  }
  
  public void callbackJsEventOK(bgok parambgok, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = bgop.a(paramString, paramJSONObject).toString();
    parambgok.jdField_a_of_type_Bglu.a(paramInt, paramString);
  }
  
  public void insertCamera(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
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
        bgor.a(new MediaJsPlugin.5(this, parambgok, i, j, str2, localJSONObject1, localJSONObject2, str1, bool, (String)localObject));
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
      QMLog.e("MediaJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
  
  public void insertCamera(bgok parambgok, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, bhke parambhke, String paramString2, boolean paramBoolean, String paramString3)
  {
    CoverView localCoverView = bhei.a(this.mMiniAppContext).a(paramInt1);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverCameraView(this.mMiniAppContext.a(), parambgok.jdField_a_of_type_Bglu);
      ((CoverCameraView)localObject).setParentId(paramInt2);
      ((CoverCameraView)localObject).setFixed(paramBoolean);
      ((CoverCameraView)localObject).setCameraId(paramInt1);
      ((CoverCameraView)localObject).setWebviewId(bgml.a(this.mMiniAppContext).a());
      bhei.a(this.mMiniAppContext).a(paramInt2, paramInt1, (CoverView)localObject, paramBoolean);
    }
    float f = DisplayUtil.getDensity(this.mMiniAppContext.a());
    if ((localObject instanceof CoverCameraView))
    {
      ((CoverCameraView)localObject).setMode(paramString3);
      ((CoverCameraView)localObject).setFlashMode(paramString2);
      ((CoverCameraView)localObject).setCameraSurfaceCallBack(parambhke);
      ((CoverCameraView)localObject).a(paramString1);
      paramInt1 = (int)(paramInt5 * f + 0.5F);
      paramInt2 = (int)(paramInt6 * f + 0.5F);
      paramInt3 = (int)(paramInt3 * f + 0.5F);
      paramInt4 = (int)(paramInt4 * f + 0.5F);
      ((CoverCameraView)localObject).setCameraWidth(paramInt1);
      ((CoverCameraView)localObject).setCameraHeight(paramInt2);
      parambgok = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      parambgok.leftMargin = paramInt3;
      parambgok.topMargin = paramInt4;
      ((CoverCameraView)localObject).setLayoutParams(parambgok);
    }
  }
  
  public void insertVideoPlayer(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgok.b);
      int i = localJSONObject1.optInt("videoPlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      bgor.a(new MediaJsPlugin.2(this, i, localJSONObject1, parambgok, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
  
  public void operateCamera(bgok parambgok)
  {
    QMLog.d("MediaJsPlugin", parambgok.b);
    CoverView localCoverView;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.optInt("cameraId");
      localCoverView = bhei.a(this.mMiniAppContext).a(i);
      if (!(localCoverView instanceof CoverCameraView))
      {
        parambgok.b();
        return;
      }
      str = localJSONObject.optString("type");
      if ("takePhoto".equals(str))
      {
        ((CoverCameraView)localCoverView).a(parambgok, localJSONObject.optString("quality"));
        return;
      }
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
      return;
    }
    if ("startRecord".equals(str))
    {
      ((CoverCameraView)localCoverView).a(parambgok);
      return;
    }
    if ("stopRecord".equals(str)) {
      ((CoverCameraView)localCoverView).b(parambgok);
    }
  }
  
  public void operateVideoPlayer(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      String str = localJSONObject.optString("type");
      bgor.a(new MediaJsPlugin.1(this, localJSONObject.optInt("videoPlayerId"), parambgok, str, localJSONObject.optString("data")));
      return;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
  
  public void removeCamera(bgok parambgok)
  {
    QMLog.d("MediaJsPlugin", parambgok.b);
    for (;;)
    {
      int j;
      try
      {
        int i = new JSONObject(parambgok.b).optInt("cameraId");
        CoverView localCoverView = bhei.a(this.mMiniAppContext).a(i);
        if (!(localCoverView instanceof CoverCameraView))
        {
          parambgok.b();
          return;
        }
        ((CoverCameraView)localCoverView).a();
        j = ((CoverCameraView)localCoverView).a();
        if (j == 0)
        {
          bhei.a(this.mMiniAppContext).a(i);
          parambgok.a();
          return;
        }
      }
      catch (JSONException parambgok)
      {
        parambgok.printStackTrace();
        return;
      }
      bhei.a(this.mMiniAppContext).a(j);
    }
  }
  
  public void removeVideoPlayer(bgok parambgok)
  {
    try
    {
      bgor.a(new MediaJsPlugin.4(this, new JSONObject(parambgok.b).optInt("videoPlayerId"), parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
  
  public void updateCamera(bgok parambgok)
  {
    for (;;)
    {
      CoverView localCoverView;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(parambgok.b);
        int i = localJSONObject.optInt("cameraId");
        localCoverView = bhei.a(this.mMiniAppContext).a(i);
        if (!(localCoverView instanceof CoverCameraView))
        {
          parambgok.b();
          return;
        }
        str = localJSONObject.optString("devicePosition");
        parambgok = localJSONObject.optString("flash");
        if (parambgok.equals("on"))
        {
          parambgok = "on";
          if (!"front".equalsIgnoreCase(str)) {
            break label117;
          }
          ((CoverCameraView)localCoverView).a(false, parambgok);
          return;
        }
      }
      catch (JSONException parambgok)
      {
        parambgok.printStackTrace();
        return;
      }
      if (parambgok.equals("auto"))
      {
        parambgok = "auto";
        continue;
        label117:
        if ("back".equalsIgnoreCase(str)) {
          ((CoverCameraView)localCoverView).a(true, parambgok);
        }
      }
      else
      {
        parambgok = "off";
      }
    }
  }
  
  public void updateVideoPlayer(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      bgor.a(new MediaJsPlugin.3(this, localJSONObject.optInt("videoPlayerId"), localJSONObject, parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MediaJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin
 * JD-Core Version:    0.7.0.1
 */