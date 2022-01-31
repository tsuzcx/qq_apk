package com.tencent.qqmini.sdk.runtime.plugin;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import bgho;
import bgkd;
import bgkk;
import bglo;
import bglq;
import bhab;
import bhac;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.CoverTextView;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextViewJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_TEXTVIEW = "insertTextView";
  private static final String EVENT_REMOVE_TEXTVIEW = "removeTextView";
  private static final String EVENT_UPDATE_TEXTVIEW = "updateTextView";
  private static final String TAG = "TextViewJsPlugin";
  protected float density;
  private boolean needSetPadding = bglq.a("qqminiapp", "miniappcovertextviewpadding", true);
  
  private void insertTextView(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("viewId");
    int j = paramJSONObject.optInt("parentId");
    String str = paramJSONObject.optString("data");
    boolean bool1 = paramJSONObject.optBoolean("gesture");
    boolean bool2 = paramJSONObject.optBoolean("fixed", false);
    CoverView localCoverView = bhab.a(this.mMiniAppContext).a(i);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverTextView(this.mContext);
      ((CoverView)localObject).setData(str, bool1, bhac.a(this.mMiniAppContext));
      ((CoverView)localObject).setContentDescription(i + "_" + j);
      ((CoverView)localObject).setParentId(j);
      ((CoverView)localObject).setFixed(bool2);
      bhab.a(this.mMiniAppContext).a(j, i, (CoverView)localObject, bool2);
    }
    if ((localObject instanceof CoverTextView)) {
      updateTextView((CoverTextView)localObject, paramJSONObject);
    }
  }
  
  private void updateTextView(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optJSONObject("style");
    Object localObject2;
    if (localObject1 != null)
    {
      if (!((JSONObject)localObject1).has("bgColor")) {
        break label731;
      }
      localObject2 = ColorUtils.getActualColor(((JSONObject)localObject1).optString("bgColor"));
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label731;
      }
    }
    label549:
    label709:
    label717:
    label731:
    for (int i = Color.parseColor((String)localObject2);; i = 0)
    {
      if (((JSONObject)localObject1).has("borderColor"))
      {
        localObject2 = ColorUtils.getActualColor(((JSONObject)localObject1).optString("borderColor"));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
      for (int j = Color.parseColor((String)localObject2);; j = 0)
      {
        paramCoverTextView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
        paramCoverTextView.setBackgroundColor(i);
        paramCoverTextView.setScaleX((float)((JSONObject)localObject1).optDouble("scaleX", 1.0D));
        paramCoverTextView.setScaleY((float)((JSONObject)localObject1).optDouble("scaleY", 1.0D));
        localObject2 = ((JSONObject)localObject1).optJSONArray("padding");
        if (localObject2 != null) {
          paramCoverTextView.setPadding(((JSONArray)localObject2).optInt(3), ((JSONArray)localObject2).optInt(0), ((JSONArray)localObject2).optInt(1), ((JSONArray)localObject2).optInt(2));
        }
        paramCoverTextView.setBorder(((JSONObject)localObject1).optInt("borderWidth", 0), j, (float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D), i);
        paramCoverTextView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
        paramCoverTextView.setBorderRadius((float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D) * this.density);
        paramCoverTextView.setClickable(paramJSONObject.optBoolean("clickable"));
        paramCoverTextView.setIncludeFontPadding(false);
        localObject1 = paramJSONObject.optJSONObject("position");
        if (localObject1 != null)
        {
          i = (int)(this.density * ((JSONObject)localObject1).optInt("width") + 0.5F);
          j = (int)(this.density * ((JSONObject)localObject1).optInt("height") + 0.5F);
          int k = (int)(this.density * ((JSONObject)localObject1).optInt("left") + 0.5F);
          float f = this.density;
          int m = (int)(((JSONObject)localObject1).optInt("top") * f + 0.5F);
          localObject1 = new FrameLayout.LayoutParams(i, j);
          ((FrameLayout.LayoutParams)localObject1).leftMargin = k;
          ((FrameLayout.LayoutParams)localObject1).topMargin = m;
          paramCoverTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        paramJSONObject = paramJSONObject.optJSONObject("label");
        if (paramJSONObject != null)
        {
          if (!bglo.a(paramJSONObject.optString("color")))
          {
            localObject1 = ColorUtils.getActualColor(paramJSONObject.optString("color"));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              paramCoverTextView.setTextColor(Color.parseColor((String)localObject1));
            }
          }
          i = paramJSONObject.optInt("fontSize", 0);
          if (i > 0) {
            paramCoverTextView.setTextSize(0, DisplayUtil.dip2px(this.mContext, i));
          }
          localObject1 = paramJSONObject.optString("textAlign");
          if (!"left".equals(localObject1)) {
            break label670;
          }
          paramCoverTextView.setGravity(3);
          localObject1 = paramJSONObject.optString("content");
          if (!bglo.a((String)localObject1)) {
            paramCoverTextView.setText((String)localObject1);
          }
          if ("bold".equals(paramJSONObject.optString("fontWeight"))) {
            paramCoverTextView.setTypeface(Typeface.defaultFromStyle(1));
          }
          if (!"nowrap".equals(paramJSONObject.optString("whiteSpace", "nowrap"))) {
            break label709;
          }
          paramCoverTextView.setSingleLine(true);
          if (!"ellipsis".equals(paramJSONObject.optString("lineBreak", "clip"))) {
            break label717;
          }
          paramCoverTextView.setEllipsize(TextUtils.TruncateAt.END);
        }
        for (;;)
        {
          i = paramJSONObject.optInt("lineHeight", 0);
          if (i > 0)
          {
            i = DisplayUtil.dip2px(this.mContext, i) - paramCoverTextView.a().getLineHeight();
            if (i != 0)
            {
              paramCoverTextView.setLineSpacing(i, 1.0F);
              if ((this.needSetPadding) && (Build.MANUFACTURER.equals("Xiaomi")) && (i < 0)) {
                paramCoverTextView.a().setPadding(0, (int)(i / DisplayUtil.getDensity(this.mContext)), 0, 0);
              }
            }
          }
          return;
          if ("center".equals(localObject1))
          {
            paramCoverTextView.setGravity(17);
            break;
          }
          if (!"right".equals(localObject1)) {
            break;
          }
          paramCoverTextView.setGravity(5);
          break;
          paramCoverTextView.setSingleLine(false);
          break label549;
          paramCoverTextView.setEllipsize(null);
        }
      }
    }
  }
  
  private void updateTextView(JSONObject paramJSONObject)
  {
    CoverView localCoverView = bhab.a(this.mMiniAppContext).a(paramJSONObject.optInt("viewId"));
    if ((localCoverView instanceof CoverTextView)) {
      updateTextView((CoverTextView)localCoverView, paramJSONObject);
    }
  }
  
  public void onCreate(bgho parambgho)
  {
    super.onCreate(parambgho);
    this.density = DisplayUtil.getDensity(this.mContext);
  }
  
  public void setEventInsertTextview(bgkd parambgkd)
  {
    try
    {
      bgkk.a(new TextViewJsPlugin.1(this, new JSONObject(parambgkd.b)));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TextViewJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
  
  public void setEventRemoveTextview(bgkd parambgkd)
  {
    try
    {
      bgkk.a(new TextViewJsPlugin.3(this, new JSONObject(parambgkd.b)));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TextViewJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
  
  public void setEventUpdateTextview(bgkd parambgkd)
  {
    try
    {
      bgkk.a(new TextViewJsPlugin.2(this, new JSONObject(parambgkd.b)));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TextViewJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.TextViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */