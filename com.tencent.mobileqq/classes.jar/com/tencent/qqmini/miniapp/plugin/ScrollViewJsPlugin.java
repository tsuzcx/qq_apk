package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.action.GetJsRuntimeListener;
import com.tencent.qqmini.miniapp.widget.CoverScrollView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class ScrollViewJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_SCROLLVIEW = "insertScrollView";
  private static final String EVENT_REMOVE_SCROLLVIEW = "removeScrollView";
  private static final String EVENT_UPDATE_SCROLLVIEW = "updateScrollView";
  private static final String TAG = "ScrollViewJsPlugin";
  protected float density;
  
  private boolean insertScrollView(JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    int i = paramJSONObject.optInt("viewId");
    int j = paramJSONObject.optInt("parentId");
    String str = paramJSONObject.optString("data");
    boolean bool2 = paramJSONObject.optBoolean("gesture");
    boolean bool3 = paramJSONObject.optBoolean("fixed", false);
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(i);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverScrollView(this.mContext);
      ((CoverView)localObject).setData(str, bool2, GetJsRuntimeListener.get(this.mMiniAppContext));
      ((CoverView)localObject).setContentDescription(i + "_" + j);
      ((CoverView)localObject).setParentId(j);
      ((CoverView)localObject).setFixed(bool3);
      bool1 = CoverViewAction.obtain(this.mMiniAppContext).add(j, i, (CoverView)localObject, bool3);
    }
    if ((localObject instanceof CoverScrollView)) {
      updateScrollView(paramJSONObject, (CoverScrollView)localObject);
    }
    return bool1;
  }
  
  private void updateScrollView(JSONObject paramJSONObject, CoverScrollView paramCoverScrollView)
  {
    Object localObject1 = paramJSONObject.optJSONObject("style");
    int j;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      j = 0;
      i = j;
      if (((JSONObject)localObject1).has("bgColor"))
      {
        localObject2 = ColorUtils.getActualColor(((JSONObject)localObject1).optString("bgColor"));
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
    try
    {
      i = Color.parseColor((String)localObject2);
      int k = 0;
      j = k;
      if (((JSONObject)localObject1).has("borderColor"))
      {
        localObject2 = ColorUtils.getActualColor(((JSONObject)localObject1).optString("borderColor"));
        j = k;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          j = Color.parseColor((String)localObject2);
        }
      }
      paramCoverScrollView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
      paramCoverScrollView.setBackgroundColor(i);
      paramCoverScrollView.setScaleX((float)((JSONObject)localObject1).optDouble("scaleX", 1.0D));
      paramCoverScrollView.setScaleY((float)((JSONObject)localObject1).optDouble("scaleY", 1.0D));
      localObject2 = ((JSONObject)localObject1).optJSONArray("padding");
      if (localObject2 != null) {
        paramCoverScrollView.setPadding(((JSONArray)localObject2).optInt(3), ((JSONArray)localObject2).optInt(2), ((JSONArray)localObject2).optInt(1), ((JSONArray)localObject2).optInt(0));
      }
      paramCoverScrollView.setBorder(((JSONObject)localObject1).optInt("borderWidth", 0), j, (float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D), i);
      paramCoverScrollView.setBorderRadius((float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D) * this.density);
      paramCoverScrollView.setClickable(paramJSONObject.optBoolean("clickable", false));
      paramCoverScrollView.setHorizontalScrollBarEnabled(paramJSONObject.optBoolean("scrollX", false));
      paramCoverScrollView.setVerticalScrollBarEnabled(paramJSONObject.optBoolean("scrollY", false));
      localObject1 = paramJSONObject.optJSONObject("position");
      float f;
      if (localObject1 != null)
      {
        i = (int)(this.density * ((JSONObject)localObject1).optInt("width") + 0.5F);
        j = (int)(this.density * ((JSONObject)localObject1).optInt("height") + 0.5F);
        k = (int)(this.density * ((JSONObject)localObject1).optInt("left") + 0.5F);
        f = this.density;
        int m = (int)(((JSONObject)localObject1).optInt("top") * f + 0.5F);
        localObject1 = new FrameLayout.LayoutParams(i, j);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = k;
        ((FrameLayout.LayoutParams)localObject1).topMargin = m;
        paramCoverScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (paramJSONObject.has("contentSize"))
      {
        localObject1 = paramJSONObject.optJSONObject("contentSize");
        if (localObject1 != null)
        {
          i = (int)(this.density * ((JSONObject)localObject1).optInt("width") + 0.5F);
          f = this.density;
          paramCoverScrollView.setContainerSize(i, (int)(((JSONObject)localObject1).optInt("height") * f + 0.5F));
        }
      }
      if (paramJSONObject.has("scrollTop")) {
        paramCoverScrollView.setScrollTop((int)(this.density * paramJSONObject.optInt("scrollTop", 0) + 0.5F));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("ScrollViewJsPlugin", "insertTextView: failed to parse color " + (String)localObject2, localException);
        i = j;
      }
    }
  }
  
  private boolean updateScrollView(JSONObject paramJSONObject)
  {
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(paramJSONObject.optInt("viewId"));
    if ((localCoverView instanceof CoverScrollView))
    {
      updateScrollView(paramJSONObject, (CoverScrollView)localCoverView);
      return true;
    }
    return false;
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.density = DisplayUtil.getDensity(this.mContext);
  }
  
  @JsEvent({"insertScrollView"})
  public void setEventInsertScrollview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new ScrollViewJsPlugin.1(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ScrollViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"removeScrollView"})
  public void setEventRemoveScrollview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new ScrollViewJsPlugin.3(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ScrollViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"updateScrollView"})
  public void setEventUpdateScrollview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new ScrollViewJsPlugin.2(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ScrollViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ScrollViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */