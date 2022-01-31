package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import begy;
import beit;
import beiw;
import beka;
import belh;
import besl;
import bffq;
import bffu;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.core.widget.media.CoverVideoView;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

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
  
  private void insertVideoPlayer(Activity paramActivity, begy parambegy, int paramInt, JSONObject paramJSONObject)
  {
    besl.b("VideoPlugin", "insertVideoPlayer: " + paramJSONObject);
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (localObject == null)
    {
      localObject = new CoverVideoView(paramActivity);
      ((CoverVideoView)localObject).setAtyRef(new WeakReference(paramActivity));
      ((CoverVideoView)localObject).setData(paramJSONObject.optString("data"));
      ((CoverVideoView)localObject).setServiceWebview(parambegy);
      ((CoverVideoView)localObject).setVideoPlayerId(paramInt);
      ((CoverVideoView)localObject).setParentId(paramInt);
      this.mCoverViewSparseArray.put(paramInt, localObject);
      beit.a().a((ViewGroup)localObject);
    }
    for (paramActivity = (Activity)localObject;; paramActivity = (Activity)localObject)
    {
      if ((paramActivity instanceof CoverVideoView))
      {
        ((CoverVideoView)paramActivity).a(paramJSONObject);
        if (paramJSONObject.optBoolean("hide")) {
          ((CoverVideoView)paramActivity).setVisibility(8);
        }
      }
      return;
    }
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int i = 0;
    if (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView1 != null) && (localCoverView1.a() == paramInt))
      {
        if (localCoverView1.a() != 0) {
          break label72;
        }
        beit.a().a(localCoverView1);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        CoverView localCoverView2 = (CoverView)this.mCoverViewSparseArray.get(localCoverView1.a());
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
    beit.a().a(localCoverView);
  }
  
  private void updateVideoPlayer(int paramInt, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if ((localCoverView instanceof CoverVideoView))
    {
      ((CoverVideoView)localCoverView).b(paramJSONObject);
      if (!paramJSONObject.optBoolean("hide")) {
        ((CoverVideoView)localCoverView).setVisibility(0);
      }
      paramJSONObject = paramJSONObject.optString("src");
      if (!belh.a(paramJSONObject)) {
        ((CoverVideoView)localCoverView).setVideoPath(paramJSONObject);
      }
    }
  }
  
  public String insertVideoPlayer(beka parambeka)
  {
    if (this.density <= 0.0F) {
      this.density = bffu.a(this.mContext);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambeka.b);
      int i = localJSONObject1.optInt("videoPlayerId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      beiw.c().post(new VideoJsPlugin.1(this, parambeka, i, localJSONObject1, localJSONObject2));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      besl.d("VideoPlugin", parambeka.a + " error.", localThrowable);
    }
    return "{}";
  }
  
  public String operateVideoPlayer(beka parambeka)
  {
    if (this.density <= 0.0F) {
      this.density = bffu.a(this.mContext);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      String str = localJSONObject.optString("type");
      int i = localJSONObject.optInt("videoPlayerId");
      beiw.c().post(new VideoJsPlugin.3(this, i, str, parambeka));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      besl.d("VideoPlugin", parambeka.a + " error.", localThrowable);
    }
    return "{}";
  }
  
  public boolean operateVideoPlayer(int paramInt, String paramString1, String paramString2)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverVideoView)) {}
    do
    {
      return false;
      if ("play".equals(paramString1))
      {
        ((CoverVideoView)localCoverView).a();
        return true;
      }
      if ("pause".equals(paramString1))
      {
        ((CoverVideoView)localCoverView).b();
        return true;
      }
      if ("stop".equals(paramString1))
      {
        ((CoverVideoView)localCoverView).c();
        return true;
      }
      if (("seek".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        try
        {
          paramInt = (int)(new JSONObject(paramString2).optDouble("time") * 1000.0D);
          bool = ((CoverVideoView)localCoverView).a(paramInt);
          return bool;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            besl.d("VideoPlugin", "wrong seek pram. " + paramString2, paramString1);
            boolean bool = false;
          }
        }
      }
      if (("playbackRate".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        besl.d("VideoPlugin", "playbackRate is not support.");
        return true;
      }
      if ("requestFullScreen".equals(paramString1))
      {
        if (!((CoverVideoView)localCoverView).c()) {
          ((CoverVideoView)localCoverView).a();
        }
        return true;
      }
      if ("exitFullScreen".equals(paramString1))
      {
        if (((CoverVideoView)localCoverView).c()) {
          ((CoverVideoView)localCoverView).b();
        }
        return true;
      }
    } while (!"sendDanmu".equals(paramString1));
    for (;;)
    {
      try
      {
        paramString2 = new JSONArray(paramString2);
        if (paramString2.length() == 2)
        {
          paramString1 = paramString2.getString(0);
          paramInt = bffq.a(paramString2.getString(1));
          ((CoverVideoView)localCoverView).a(paramString1, paramInt);
          return true;
        }
        if (paramString2.length() == 1)
        {
          paramString1 = paramString2.getString(0);
          paramInt = 0;
          continue;
        }
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        besl.d("VideoPlugin", "sendDanmu error.", paramString1);
        return false;
      }
      paramInt = 0;
    }
  }
  
  public String removeVideoPlayer(beka parambeka)
  {
    if (this.density <= 0.0F) {
      this.density = bffu.a(this.mContext);
    }
    try
    {
      int i = new JSONObject(parambeka.b).optInt("videoPlayerId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if ((localCoverView instanceof CoverVideoView))
      {
        ((CoverVideoView)localCoverView).b();
        ((CoverVideoView)localCoverView).c();
        ((CoverVideoView)localCoverView).d();
      }
      beiw.c().post(new VideoJsPlugin.4(this, i, parambeka));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      besl.d("VideoPlugin", parambeka.a + " error.", localThrowable);
    }
    return "{}";
  }
  
  public String updateVideoPlayer(beka parambeka)
  {
    if (this.density <= 0.0F) {
      this.density = bffu.a(this.mContext);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int i = localJSONObject.optInt("videoPlayerId");
      beiw.c().post(new VideoJsPlugin.2(this, i, localJSONObject, parambeka));
      return "{}";
    }
    catch (Throwable localThrowable)
    {
      besl.d("VideoPlugin", parambeka.a + " error.", localThrowable);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */