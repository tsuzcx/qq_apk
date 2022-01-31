package com.tencent.qqmini.sdk.runtime.plugin;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import bglv;
import bgml;
import bgnt;
import bgok;
import bgor;
import bgpe;
import bgpv;
import bhei;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.CoverImageView;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    return bgml.a(this.mMiniAppContext).a();
  }
  
  private int getWindowHeight()
  {
    return bgml.a(this.mMiniAppContext).b();
  }
  
  private void insertImageView(JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2, boolean paramBoolean1)
  {
    CoverView localCoverView = bhei.a(this.mMiniAppContext).a(paramInt2);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverImageView(this.mContext);
      ((CoverView)localObject).setContentDescription(paramInt2 + "_" + paramInt1);
      ((CoverView)localObject).setParentId(paramInt1);
      ((CoverView)localObject).setFixed(paramBoolean1);
      bhei.a(this.mMiniAppContext).a(paramInt1, paramInt2, (CoverView)localObject, paramBoolean1);
    }
    int i;
    int j;
    if ((localObject instanceof CoverImageView))
    {
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramJSONObject1 != null)
      {
        i = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
        j = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
        paramInt1 = (int)(this.density * paramJSONObject1.optInt("left") + 0.5F);
        paramInt2 = (int)(this.density * paramJSONObject1.optInt("top") + 0.5F);
        paramJSONObject1 = new FrameLayout.LayoutParams(i, j);
        paramJSONObject1.leftMargin = paramInt1;
        paramJSONObject1.topMargin = paramInt2;
        ((CoverView)localObject).setLayoutParams(paramJSONObject1);
        paramInt1 = i;
        paramInt2 = j;
        if (paramJSONObject2 != null)
        {
          int k = paramJSONObject2.optInt("rotate");
          paramInt1 = i;
          paramInt2 = j;
          if (k != 0)
          {
            ((CoverView)localObject).setPivotX(i / 2);
            ((CoverView)localObject).setPivotY(j / 2);
            ((CoverView)localObject).setRotation(k);
            paramInt2 = j;
            paramInt1 = i;
          }
        }
      }
      if (paramJSONObject2 != null)
      {
        j = 0;
        i = j;
        if (paramJSONObject2.has("bgColor"))
        {
          paramJSONObject1 = ColorUtils.getActualColor(paramJSONObject2.optString("bgColor"));
          i = j;
          if (TextUtils.isEmpty(paramJSONObject1)) {}
        }
      }
    }
    try
    {
      i = Color.parseColor(paramJSONObject1);
      ((CoverView)localObject).setBackgroundColor(i);
      ((CoverView)localObject).setAlpha((float)paramJSONObject2.optDouble("opacity", 0.0D));
      paramJSONObject1 = paramJSONObject2.optJSONArray("padding");
      if ((paramJSONObject1 != null) && (paramJSONObject1.length() == 4)) {
        ((CoverView)localObject).setPadding(paramJSONObject1.optInt(3, 0), paramJSONObject1.optInt(0, 0), paramJSONObject1.optInt(1, 0), paramJSONObject1.optInt(2, 0));
      }
      ((CoverView)localObject).setBorderRadius((float)paramJSONObject2.optDouble("borderRadius", 0.0D) * this.density);
      if ((bgpv.a(paramString2)) || ((paramString2.startsWith("http")) || (paramString2.startsWith("https"))))
      {
        try
        {
          paramJSONObject1 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, paramString2, paramInt1, paramInt2, null);
          if (paramJSONObject1 != null) {
            ((CoverImageView)localObject).setImageDrawable(paramJSONObject1);
          }
        }
        catch (Throwable paramJSONObject1)
        {
          for (;;)
          {
            QMLog.e("ImageViewJsPlugin", "URLDrawable error.", paramJSONObject1);
          }
        }
        if (paramBoolean != null) {
          ((CoverImageView)localObject).setClickable(paramBoolean.booleanValue());
        }
        ((CoverImageView)localObject).setOnClickListener(new ImageViewJsPlugin.4(this, paramString1));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("ImageViewJsPlugin", "insertImageView: failed to parse color " + paramJSONObject1, localException);
        i = j;
        continue;
        paramJSONObject1 = bgnt.a().a(paramString2);
        if (!bgpv.a(paramJSONObject1)) {
          try
          {
            paramJSONObject1 = bgpe.a(paramJSONObject1);
            if (paramJSONObject1 != null) {
              ((CoverImageView)localObject).setImageBitmap(paramJSONObject1);
            }
          }
          catch (Throwable paramJSONObject1)
          {
            QMLog.e("ImageViewJsPlugin", "getLocalBitmap error.", paramJSONObject1);
          }
        }
      }
    }
  }
  
  public void insertImageView(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgok.b);
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
        bgor.a(new ImageViewJsPlugin.1(this, localJSONObject2, str2, j, i, str1, localBoolean, localJSONObject3, bool));
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ImageViewJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    this.density = DisplayUtil.getDensity(this.mContext);
  }
  
  public void removeImageView(int paramInt)
  {
    bhei.a(this.mMiniAppContext).a(paramInt);
  }
  
  public void removeImageView(bgok parambgok)
  {
    try
    {
      bgor.a(new ImageViewJsPlugin.3(this, new JSONObject(parambgok.b)));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ImageViewJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
  
  public void updateImageView(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      int i = ((JSONObject)localObject).optInt("viewId");
      String str = ((JSONObject)localObject).optString("iconPath");
      JSONObject localJSONObject1 = ((JSONObject)localObject).optJSONObject("position");
      if (((JSONObject)localObject).has("clickable")) {}
      for (Boolean localBoolean = Boolean.valueOf(((JSONObject)localObject).optBoolean("clickable"));; localBoolean = null)
      {
        JSONObject localJSONObject2 = ((JSONObject)localObject).optJSONObject("style");
        localObject = ((JSONObject)localObject).optString("data");
        new JSONObject().put("viewId", i);
        bgor.a(new ImageViewJsPlugin.2(this, localJSONObject1, (String)localObject, i, str, localBoolean, localJSONObject2));
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("ImageViewJsPlugin", parambgok.a + " error.", localJSONException);
    }
  }
  
  public void updateImageView(JSONObject paramJSONObject1, String paramString1, int paramInt, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2)
  {
    paramString1 = bhei.a(this.mMiniAppContext).a(paramInt);
    int i;
    if ((paramString1 instanceof CoverImageView))
    {
      int n = getWindowHeight();
      Object localObject;
      if (paramJSONObject1 != null)
      {
        int j = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
        int k = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
        int m = (int)(this.density * paramJSONObject1.optInt("left") + 0.5F);
        i = (int)(this.density * paramJSONObject1.optInt("top") + 0.5F);
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
      if (!bgpv.a(paramString2))
      {
        if ((!paramString2.startsWith("http")) && (!paramString2.startsWith("https"))) {
          break label380;
        }
        paramInt = 0;
        i = 0;
        if (paramJSONObject1 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
        i = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
        paramJSONObject1 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, paramString2, paramInt, i, null);
        if (paramJSONObject1 != null) {
          ((CoverImageView)paramString1).setImageDrawable(paramJSONObject1);
        }
      }
      catch (Throwable paramJSONObject1)
      {
        QMLog.e("ImageViewJsPlugin", "URLDrawable error.", paramJSONObject1);
        continue;
      }
      if (paramBoolean != null) {
        ((CoverImageView)paramString1).setClickable(paramBoolean.booleanValue());
      }
      return;
      label380:
      paramJSONObject1 = bgnt.a().a(paramString2);
      if (!bgpv.a(paramJSONObject1)) {
        try
        {
          paramJSONObject1 = bgpe.a(paramJSONObject1);
          if (paramJSONObject1 != null) {
            ((CoverImageView)paramString1).setImageBitmap(paramJSONObject1);
          }
        }
        catch (Throwable paramJSONObject1)
        {
          QMLog.e("ImageViewJsPlugin", "getLocalBitmap error.", paramJSONObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.ImageViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */