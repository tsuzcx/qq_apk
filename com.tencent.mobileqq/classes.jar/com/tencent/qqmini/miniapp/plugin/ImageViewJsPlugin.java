package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.CoverImageView;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class ImageViewJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_IMAGEVIEW = "insertImageView";
  private static final String EVENT_REMOVE_IMAGEVIEW = "removeImageView";
  private static final String EVENT_UPDATE_IMAGEVIEW = "updateImageView";
  private static final String TAG = "ImageViewJsPlugin";
  protected float density;
  
  private int getPageWebViewId()
  {
    return PageAction.obtain(this.mMiniAppContext).getPageId();
  }
  
  private int getWindowHeight()
  {
    return PageAction.obtain(this.mMiniAppContext).getWindowHeight();
  }
  
  private boolean insertImageView(RequestEvent paramRequestEvent, JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2, boolean paramBoolean1)
  {
    Object localObject = CoverViewAction.obtain(this.mMiniAppContext).get(paramInt2);
    if (localObject == null)
    {
      localObject = new CoverImageView(this.mContext);
      ((CoverView)localObject).setContentDescription(paramInt2 + "_" + paramInt1);
      ((CoverView)localObject).setParentId(paramInt1);
      ((CoverView)localObject).setFixed(paramBoolean1);
    }
    for (paramBoolean1 = CoverViewAction.obtain(this.mMiniAppContext).add(paramInt1, paramInt2, (CoverView)localObject, paramBoolean1);; paramBoolean1 = true)
    {
      if ((localObject instanceof CoverImageView))
      {
        paramInt1 = 0;
        paramInt2 = 0;
        if (paramJSONObject1 != null)
        {
          paramInt1 = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
          paramInt2 = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
          setPosition(paramJSONObject1, paramJSONObject2, (CoverView)localObject, paramInt1, paramInt2);
        }
        setStyle(paramJSONObject2, (CoverView)localObject);
        setImageDrawable(paramString2, (CoverImageView)localObject, paramInt1, paramInt2);
        setOnClickListener(paramRequestEvent, paramString1, paramBoolean, (CoverView)localObject);
      }
      return paramBoolean1;
    }
  }
  
  private void setIconPath(JSONObject paramJSONObject, String paramString, CoverImageView paramCoverImageView)
  {
    int j = 0;
    if ((paramString.startsWith("http")) || (paramString.startsWith("https"))) {
      if (paramJSONObject == null) {
        break label154;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        i = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
        j = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
        paramJSONObject = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, paramString, i, j, null);
        if (paramJSONObject != null) {
          paramCoverImageView.setImageDrawable(paramJSONObject);
        }
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("ImageViewJsPlugin", "URLDrawable error.", paramJSONObject);
        return;
      }
      paramJSONObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      if (!StringUtil.isEmpty(paramJSONObject))
      {
        try
        {
          paramJSONObject = ImageUtil.getLocalBitmap(paramJSONObject);
          if (paramJSONObject == null) {
            continue;
          }
          paramCoverImageView.setImageBitmap(paramJSONObject);
          return;
        }
        catch (Throwable paramJSONObject)
        {
          QMLog.e("ImageViewJsPlugin", "getLocalBitmap error.", paramJSONObject);
          return;
        }
        label154:
        i = 0;
      }
    }
  }
  
  private void setImageDrawable(String paramString, CoverImageView paramCoverImageView, int paramInt1, int paramInt2)
  {
    if ((StringUtil.isEmpty(paramString)) || ((paramString.startsWith("http")) || (paramString.startsWith("https")))) {}
    for (;;)
    {
      try
      {
        paramString = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, paramString, paramInt1, paramInt2, null);
        if (paramString != null) {
          paramCoverImageView.setImageDrawable(paramString);
        }
        return;
      }
      catch (Throwable paramString)
      {
        QMLog.e("ImageViewJsPlugin", "URLDrawable error.", paramString);
        return;
      }
      paramString = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      if (!StringUtil.isEmpty(paramString)) {
        try
        {
          paramString = ImageUtil.getLocalBitmap(paramString);
          if (paramString != null)
          {
            paramCoverImageView.setImageBitmap(paramString);
            return;
          }
        }
        catch (Throwable paramString)
        {
          QMLog.e("ImageViewJsPlugin", "getLocalBitmap error.", paramString);
        }
      }
    }
  }
  
  private void setOnClickListener(RequestEvent paramRequestEvent, String paramString, Boolean paramBoolean, CoverView paramCoverView)
  {
    if (paramBoolean != null) {
      paramCoverView.setClickable(paramBoolean.booleanValue());
    }
    paramCoverView.setOnClickListener(new ImageViewJsPlugin.4(this, paramString, paramRequestEvent));
  }
  
  private void setPosition(JSONObject paramJSONObject1, JSONObject paramJSONObject2, CoverView paramCoverView, int paramInt1, int paramInt2)
  {
    int i = (int)(this.density * paramJSONObject1.optInt("left") + 0.5F);
    int j = (int)(this.density * paramJSONObject1.optInt("top") + 0.5F);
    paramJSONObject1 = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    paramJSONObject1.leftMargin = i;
    paramJSONObject1.topMargin = j;
    paramCoverView.setLayoutParams(paramJSONObject1);
    if (paramJSONObject2 != null)
    {
      i = paramJSONObject2.optInt("rotate");
      if (i != 0)
      {
        paramCoverView.setPivotX(paramInt1 / 2);
        paramCoverView.setPivotY(paramInt2 / 2);
        paramCoverView.setRotation(i);
      }
    }
  }
  
  private void setStyle(JSONObject paramJSONObject, CoverView paramCoverView)
  {
    Object localObject;
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.has("bgColor")) {
        break label161;
      }
      localObject = ColorUtils.getActualColor(paramJSONObject.optString("bgColor"));
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label161;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor((String)localObject);
        paramCoverView.setBackgroundColor(i);
        paramCoverView.setAlpha((float)paramJSONObject.optDouble("opacity", 0.0D));
        localObject = paramJSONObject.optJSONArray("padding");
        if ((localObject != null) && (((JSONArray)localObject).length() == 4)) {
          paramCoverView.setPadding(((JSONArray)localObject).optInt(3, 0), ((JSONArray)localObject).optInt(0, 0), ((JSONArray)localObject).optInt(1, 0), ((JSONArray)localObject).optInt(2, 0));
        }
        paramCoverView.setBorderRadius((float)paramJSONObject.optDouble("borderRadius", 0.0D) * this.density);
        return;
      }
      catch (Exception localException)
      {
        Log.w("ImageViewJsPlugin", "insertImageView: failed to parse color " + (String)localObject, localException);
      }
      label161:
      int i = 0;
    }
  }
  
  @JsEvent({"insertImageView"})
  public void insertImageView(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("viewId");
      int j = localJSONObject1.optInt("parentId");
      String str1 = localJSONObject1.optString("iconPath");
      String str2 = localJSONObject1.optString("data");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("position");
      if (localJSONObject1.has("clickable")) {}
      for (Boolean localBoolean = Boolean.valueOf(localJSONObject1.optBoolean("clickable"));; localBoolean = null)
      {
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("style");
        boolean bool = localJSONObject1.optBoolean("fixed", false);
        new JSONObject().put("viewId", i);
        AppBrandTask.runTaskOnUiThread(new ImageViewJsPlugin.1(this, paramRequestEvent, localJSONObject2, str2, j, i, str1, localBoolean, localJSONObject3, bool));
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ImageViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.density = DisplayUtil.getDensity(this.mContext);
  }
  
  @JsEvent({"removeImageView"})
  public void removeImageView(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new ImageViewJsPlugin.3(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ImageViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"updateImageView"})
  public void updateImageView(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).optInt("viewId");
      String str = ((JSONObject)localObject).optString("iconPath");
      JSONObject localJSONObject1 = ((JSONObject)localObject).optJSONObject("position");
      if (((JSONObject)localObject).has("clickable")) {}
      for (Boolean localBoolean = Boolean.valueOf(((JSONObject)localObject).optBoolean("clickable"));; localBoolean = null)
      {
        JSONObject localJSONObject2 = ((JSONObject)localObject).optJSONObject("style");
        localObject = ((JSONObject)localObject).optString("data");
        new JSONObject().put("viewId", i);
        AppBrandTask.runTaskOnUiThread(new ImageViewJsPlugin.2(this, localJSONObject1, (String)localObject, i, str, localBoolean, localJSONObject2, paramRequestEvent));
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ImageViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  public boolean updateImageView(JSONObject paramJSONObject1, String paramString1, int paramInt, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2)
  {
    paramString1 = CoverViewAction.obtain(this.mMiniAppContext).get(paramInt);
    if ((paramString1 instanceof CoverImageView))
    {
      int n = getWindowHeight();
      Object localObject;
      if (paramJSONObject1 != null)
      {
        int j = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
        int k = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
        int m = (int)(this.density * paramJSONObject1.optInt("left") + 0.5F);
        int i = (int)(this.density * paramJSONObject1.optInt("top") + 0.5F);
        paramInt = i;
        if (k + i > n) {
          paramInt = n - k;
        }
        localObject = new FrameLayout.LayoutParams(j, k);
        ((FrameLayout.LayoutParams)localObject).leftMargin = m;
        ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
        paramString1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (paramJSONObject2 != null)
      {
        paramString1.setAlpha((float)paramJSONObject2.optDouble("opacity", 0.0D));
        localObject = paramJSONObject2.optJSONArray("padding");
        if ((localObject != null) && (((JSONArray)localObject).length() == 4)) {
          paramString1.setPadding(((JSONArray)localObject).optInt(3, 0), ((JSONArray)localObject).optInt(0, 0), ((JSONArray)localObject).optInt(1, 0), ((JSONArray)localObject).optInt(2, 0));
        }
        paramString1.setBorderRadius((float)paramJSONObject2.optDouble("borderRadius", 0.0D) * this.density);
      }
      if (!StringUtil.isEmpty(paramString2)) {
        setIconPath(paramJSONObject1, paramString2, (CoverImageView)paramString1);
      }
      if (paramBoolean != null) {
        paramString1.setClickable(paramBoolean.booleanValue());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */