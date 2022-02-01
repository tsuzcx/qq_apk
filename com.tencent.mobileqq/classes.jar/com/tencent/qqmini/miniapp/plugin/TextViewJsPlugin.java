package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.action.GetJsRuntimeListener;
import com.tencent.qqmini.miniapp.widget.CoverTextView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
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
public class TextViewJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_TEXTVIEW = "insertTextView";
  private static final String EVENT_REMOVE_TEXTVIEW = "removeTextView";
  private static final String EVENT_UPDATE_TEXTVIEW = "updateTextView";
  private static final String TAG = "TextViewJsPlugin";
  protected float density;
  private boolean needSetPadding = WnsConfig.getConfig("qqminiapp", "miniappcovertextviewpadding", true);
  
  private boolean insertTextView(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("viewId");
    int j = paramJSONObject.optInt("parentId");
    Object localObject2 = paramJSONObject.optString("data");
    boolean bool1 = paramJSONObject.optBoolean("gesture");
    boolean bool2 = paramJSONObject.optBoolean("fixed", false);
    Object localObject1 = CoverViewAction.obtain(this.mMiniAppContext).get(i);
    if (localObject1 == null)
    {
      localObject1 = new CoverTextView(this.mContext);
      ((CoverView)localObject1).setData((String)localObject2, bool1, GetJsRuntimeListener.get(this.mMiniAppContext));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(j);
      ((CoverView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      ((CoverView)localObject1).setParentId(j);
      ((CoverView)localObject1).setFixed(bool2);
      bool1 = CoverViewAction.obtain(this.mMiniAppContext).add(j, i, (CoverView)localObject1, bool2);
    }
    else
    {
      bool1 = true;
    }
    if ((localObject1 instanceof CoverTextView)) {
      updateTextView((CoverTextView)localObject1, paramJSONObject);
    }
    return bool1;
  }
  
  private void setEllipsize(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    if ("ellipsis".equals(paramJSONObject.optString("lineBreak", "clip")))
    {
      paramCoverTextView.setEllipsize(TextUtils.TruncateAt.END);
      return;
    }
    paramCoverTextView.setEllipsize(null);
  }
  
  private void setGravity(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("textAlign");
    if ("left".equals(paramJSONObject))
    {
      paramCoverTextView.setGravity(3);
      return;
    }
    if ("center".equals(paramJSONObject))
    {
      paramCoverTextView.setGravity(17);
      return;
    }
    if ("right".equals(paramJSONObject)) {
      paramCoverTextView.setGravity(5);
    }
  }
  
  private void setPadding(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("lineHeight", 0);
    if (i > 0)
    {
      i = DisplayUtil.dip2px(this.mContext, i) - paramCoverTextView.getTextView().getLineHeight();
      if (i != 0)
      {
        float f = i;
        paramCoverTextView.setLineSpacing(f, 1.0F);
        if ((this.needSetPadding) && (Build.MANUFACTURER.equals("Xiaomi")) && (i < 0)) {
          paramCoverTextView.getTextView().setPadding(0, (int)(f / DisplayUtil.getDensity(this.mContext)), 0, 0);
        }
      }
    }
  }
  
  private void setPosition(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("position");
    if (paramJSONObject != null)
    {
      int i = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
      int j = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
      int k = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      int m = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(i, j);
      paramJSONObject.leftMargin = k;
      paramJSONObject.topMargin = m;
      paramCoverTextView.setLayoutParams(paramJSONObject);
    }
  }
  
  private void setSingleLine(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    if ("nowrap".equals(paramJSONObject.optString("whiteSpace", "nowrap")))
    {
      paramCoverTextView.setSingleLine(true);
      return;
    }
    paramCoverTextView.setSingleLine(false);
  }
  
  private void setStyle(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("style");
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("bgColor"))
      {
        localObject = ColorUtils.getActualColor(paramJSONObject.optString("bgColor"));
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          i = Color.parseColor((String)localObject);
          break label53;
        }
      }
      int i = 0;
      label53:
      if (paramJSONObject.has("borderColor"))
      {
        localObject = ColorUtils.getActualColor(paramJSONObject.optString("borderColor"));
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          j = Color.parseColor((String)localObject);
          break label96;
        }
      }
      int j = 0;
      label96:
      paramCoverTextView.setAlpha((float)paramJSONObject.optDouble("opacity", 0.0D));
      paramCoverTextView.setBackgroundColor(i);
      paramCoverTextView.setScaleX((float)paramJSONObject.optDouble("scaleX", 1.0D));
      paramCoverTextView.setScaleY((float)paramJSONObject.optDouble("scaleY", 1.0D));
      Object localObject = paramJSONObject.optJSONArray("padding");
      if (localObject != null) {
        paramCoverTextView.setPadding(((JSONArray)localObject).optInt(3), ((JSONArray)localObject).optInt(0), ((JSONArray)localObject).optInt(1), ((JSONArray)localObject).optInt(2));
      }
      paramCoverTextView.setBorder(paramJSONObject.optInt("borderWidth", 0), j, (float)paramJSONObject.optDouble("borderRadius", 0.0D), i);
      paramCoverTextView.setAlpha((float)paramJSONObject.optDouble("opacity", 0.0D));
      paramCoverTextView.setBorderRadius((float)paramJSONObject.optDouble("borderRadius", 0.0D) * this.density);
    }
  }
  
  private void setText(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("content");
    if (!StringUtil.isEmpty(paramJSONObject)) {
      paramCoverTextView.setText(paramJSONObject);
    }
  }
  
  private void setTextColor(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    if (!StringUtil.isEmpty(paramJSONObject.optString("color")))
    {
      paramJSONObject = ColorUtils.getActualColor(paramJSONObject.optString("color"));
      if (!TextUtils.isEmpty(paramJSONObject)) {
        paramCoverTextView.setTextColor(Color.parseColor(paramJSONObject));
      }
    }
  }
  
  private void setTextSize(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("fontSize", 0);
    if (i > 0) {
      paramCoverTextView.setTextSize(0, DisplayUtil.dip2px(this.mContext, i));
    }
  }
  
  private void setTypeface(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    if ("bold".equals(paramJSONObject.optString("fontWeight"))) {
      paramCoverTextView.setTypeface(Typeface.defaultFromStyle(1));
    }
  }
  
  private void updateTextView(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    setStyle(paramCoverTextView, paramJSONObject);
    paramCoverTextView.setClickable(paramJSONObject.optBoolean("clickable"));
    paramCoverTextView.setIncludeFontPadding(false);
    setPosition(paramCoverTextView, paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONObject("label");
    if (paramJSONObject != null)
    {
      setTextColor(paramCoverTextView, paramJSONObject);
      setTextSize(paramCoverTextView, paramJSONObject);
      setGravity(paramCoverTextView, paramJSONObject);
      setText(paramCoverTextView, paramJSONObject);
      setTypeface(paramCoverTextView, paramJSONObject);
      setSingleLine(paramCoverTextView, paramJSONObject);
      setEllipsize(paramCoverTextView, paramJSONObject);
      setPadding(paramCoverTextView, paramJSONObject);
    }
  }
  
  private boolean updateTextView(JSONObject paramJSONObject)
  {
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(paramJSONObject.optInt("viewId"));
    if ((localCoverView instanceof CoverTextView))
    {
      updateTextView((CoverTextView)localCoverView, paramJSONObject);
      return true;
    }
    return false;
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.density = DisplayUtil.getDensity(this.mContext);
  }
  
  @JsEvent({"insertTextView"})
  public void setEventInsertTextview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new TextViewJsPlugin.1(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("TextViewJsPlugin", localStringBuilder.toString(), localJSONException);
    }
  }
  
  @JsEvent({"removeTextView"})
  public void setEventRemoveTextview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new TextViewJsPlugin.3(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("TextViewJsPlugin", localStringBuilder.toString(), localJSONException);
    }
  }
  
  @JsEvent({"updateTextView"})
  public void setEventUpdateTextview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new TextViewJsPlugin.2(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("TextViewJsPlugin", localStringBuilder.toString(), localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */