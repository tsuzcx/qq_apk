package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import android.widget.FrameLayout.LayoutParams;
import bgho;
import bgid;
import bgkd;
import bgkk;
import bgkv;
import bgzz;
import bhaa;
import bhae;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.smtt.sdk.CookieManager;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppUIJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_GET_REGION_DATA = "getRegionData";
  private static final String EVENT_HIDE_HOME_BUTTON = "hideHomeButton";
  public static final String EVENT_HIDE_LOADING = "hideLoading";
  public static final String EVENT_HIDE_TOAST = "hideToast";
  public static final String EVENT_INSERT_HTML_WEBVIEW = "insertHTMLWebView";
  public static final String EVENT_PAGE_SCROLL_TO = "scrollWebviewTo";
  public static final String EVENT_REMOVE_HTML_WEBVIEW = "removeHTMLWebView";
  public static final String EVENT_SET_BACKGROUND_COLOR = "setBackgroundColor";
  public static final String EVENT_SET_BACKGROUND_TEXT_STYLE = "setBackgroundTextStyle";
  public static final String EVENT_SHOW_LOADING = "showLoading";
  public static final String EVENT_SHOW_TOAST = "showToast";
  public static final String EVENT_UPDATE_HTML_WEBVIEW = "updateHTMLWebView";
  public static final String EVENT_WEBVIEW_INVOKE_APPSERVICE = "onWebInvokeAppService";
  private static final String TAG = "MiniAppUIJsPlugin";
  private InnerWebView innerWebView;
  private String mLastPage;
  
  private boolean doInsertHTMLWebView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppUIJsPlugin", "insertHTMLWebView htmlId=" + paramInt1 + ",innerWebView=" + this.innerWebView);
    }
    if (this.innerWebView != null) {
      return false;
    }
    float f = ViewUtils.getDensity(this.mMiniAppContext.a());
    int i = (int)(paramInt4 * f + 0.5F);
    paramInt4 = (int)(paramInt5 * f + 0.5F);
    paramInt5 = (int)(paramInt2 * f + 0.5F);
    paramInt3 = (int)(f * paramInt3 + 0.5F);
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppUIJsPlugin", "insertHTMLWebView htmlId=" + paramInt1 + ",left=" + paramInt5 + ",top=" + paramInt3 + ",w=" + i + ",h=" + paramInt4);
    }
    paramInt2 = paramInt4;
    if ("custom".equals(bgzz.a(this.mMiniAppContext).a()))
    {
      paramInt2 = paramInt4 - (ViewUtils.dpToPx(44.0F) + DisplayUtil.getStatusBarHeight(this.mMiniAppContext.a()));
      bhaa.a(this.mMiniAppContext).a("default");
    }
    this.innerWebView = new InnerWebView(this.mMiniAppContext.a());
    this.innerWebView.a = paramInt1;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, paramInt2);
    localLayoutParams.leftMargin = paramInt5;
    localLayoutParams.topMargin = paramInt3;
    this.innerWebView.setVisibility(8);
    return bhae.a(this.mMiniAppContext).a(this.innerWebView, localLayoutParams);
  }
  
  private boolean doRemoveHTMLWebView(int paramInt)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppUIJsPlugin", "removeHTMLWebView htmlId=" + paramInt);
    }
    if ((this.innerWebView == null) || (this.innerWebView.a != paramInt)) {
      return false;
    }
    this.innerWebView.loadUrl("about:blank");
    this.innerWebView.clearView();
    this.innerWebView.destroy();
    boolean bool = bhae.a(this.mMiniAppContext).a(this.innerWebView);
    this.innerWebView = null;
    return bool;
  }
  
  public boolean doUpdateHTMLWebView(int paramInt, String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppUIJsPlugin", "updateHTMLWebView htmlId=" + paramInt + ",innerWebView=" + this.innerWebView + ",src=" + paramString);
    }
    if ((this.innerWebView == null) || (this.innerWebView.a != paramInt) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    this.innerWebView.a(this.mMiniAppContext);
    this.innerWebView.setVisibility(0);
    if (QMLog.isColorLevel())
    {
      String str = CookieManager.getInstance().getCookie(paramString);
      QMLog.e("MiniAppUIJsPlugin", "cookie : " + str);
    }
    this.innerWebView.loadUrl(paramString);
    try
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("MiniAppUIJsPlugin", "innerWebView.hasFocus() : " + this.innerWebView.hasFocus());
      }
      if (!this.innerWebView.hasFocus()) {
        this.innerWebView.requestFocus();
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QMLog.e("MiniAppUIJsPlugin", "innerWebView requestFocuserror,", paramString);
      }
    }
    return true;
  }
  
  public boolean doUpdateHTMLWebView(int paramInt, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppUIJsPlugin", "updateHTMLWebView htmlId=" + paramInt + ",innerWebView=" + this.innerWebView + ",position=" + paramJSONObject);
    }
    if ((this.innerWebView == null) || (this.innerWebView.a != paramInt) || (paramJSONObject == null)) {
      return false;
    }
    float f = ViewUtils.getDensity(this.mMiniAppContext.a());
    paramInt = (int)(paramJSONObject.optInt("width") * f + 0.5F);
    int i = (int)(paramJSONObject.optInt("height") * f + 0.5F);
    int j = (int)(paramJSONObject.optInt("left") * f + 0.5F);
    int k = (int)(f * paramJSONObject.optInt("top") + 0.5F);
    paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
    paramJSONObject.leftMargin = j;
    paramJSONObject.topMargin = k;
    this.innerWebView.setLayoutParams(paramJSONObject);
    return true;
  }
  
  public void getRegionData(bgkd parambgkd)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", bgkv.a(this.mContext, "mini/region"));
      parambgkd.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MiniAppUIJsPlugin", "getRegionData exception: ", localJSONException);
      parambgkd.b();
    }
  }
  
  public void hideHomeButton(bgkd parambgkd)
  {
    bgkk.a(new MiniAppUIJsPlugin.5(this, parambgkd));
  }
  
  public void hideToast(bgkd parambgkd)
  {
    bgkk.a(new MiniAppUIJsPlugin.4(this, parambgkd));
  }
  
  public void insertHtmlWebview(bgkd parambgkd)
  {
    bgkk.a(new MiniAppUIJsPlugin.6(this, parambgkd));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.innerWebView != null)
    {
      bhae.a(this.mMiniAppContext).a(this.innerWebView);
      this.innerWebView.loadUrl("about:blank");
      this.innerWebView.clearView();
      this.innerWebView.destroy();
      this.innerWebView = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.innerWebView != null)
    {
      QMLog.d("MiniAppUIJsPlugin", "innerWebView pause");
      this.innerWebView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.innerWebView != null)
    {
      QMLog.d("MiniAppUIJsPlugin", "innerWebView resume & requestFocus");
      this.innerWebView.onResume();
      bgkk.a(new MiniAppUIJsPlugin.1(this));
    }
  }
  
  public void pageScrollTo(bgkd parambgkd)
  {
    sendNativeViewEvent(parambgkd, 0);
  }
  
  public void removeHtmlWebview(bgkd parambgkd)
  {
    bgkk.a(new MiniAppUIJsPlugin.8(this, parambgkd));
  }
  
  public void scrollWebviewTo(bgkd parambgkd)
  {
    this.mMiniAppContext.a(bgid.a(parambgkd, 1));
  }
  
  public void setBackgroundTextStyle(bgkd parambgkd)
  {
    sendNativeViewEvent(parambgkd, 3);
  }
  
  public void showLoading(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      bgkk.a(new MiniAppUIJsPlugin.3(this, parambgkd, localJSONObject.optString("title", ""), localJSONObject.optBoolean("mask", false)));
      return;
    }
    catch (JSONException parambgkd)
    {
      while (!QMLog.isColorLevel()) {}
      QMLog.e("MiniAppUIJsPlugin", parambgkd.getMessage(), parambgkd);
    }
  }
  
  public void showToast(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      String str1 = localJSONObject.optString("title", "");
      int i = localJSONObject.optInt("duration", 1500);
      boolean bool = localJSONObject.optBoolean("mask", false);
      String str2 = localJSONObject.optString("icon", "success");
      bgkk.a(new MiniAppUIJsPlugin.2(this, parambgkd, str1, i, bool, localJSONObject.optString("image", ""), str2));
      return;
    }
    catch (Exception parambgkd)
    {
      QMLog.e("MiniAppUIJsPlugin", parambgkd.getMessage(), parambgkd);
    }
  }
  
  public void updateHtmlWebview(bgkd parambgkd)
  {
    bgkk.a(new MiniAppUIJsPlugin.7(this, parambgkd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin
 * JD-Core Version:    0.7.0.1
 */