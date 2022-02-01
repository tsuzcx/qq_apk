package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class MiniAppUIJsPlugin
  extends BaseJsPlugin
{
  private static final String CONFIG_SPLIT = ",";
  private static final String EVENT_GET_REGION_DATA = "getRegionData";
  public static final String EVENT_INSERT_HTML_WEBVIEW = "insertHTMLWebView";
  public static final String EVENT_PAGE_SCROLL_TO = "scrollWebviewTo";
  public static final String EVENT_REMOVE_HTML_WEBVIEW = "removeHTMLWebView";
  public static final String EVENT_SET_BACKGROUND_COLOR = "setBackgroundColor";
  public static final String EVENT_SET_BACKGROUND_TEXT_STYLE = "setBackgroundTextStyle";
  public static final String EVENT_UPDATE_HTML_WEBVIEW = "updateHTMLWebView";
  public static final String EVENT_WEBVIEW_INVOKE_APPSERVICE = "onWebInvokeAppService";
  private static final String TAG = "MiniAppUIJsPlugin";
  private static String mCurWhiteListConfig;
  private static String mWhiteHostConfig;
  private static ArrayList<String> needCookieAppIdList;
  private static ArrayList<String> needCookieHostList;
  private InnerWebView innerWebView;
  
  @JsEvent({"getRegionData"})
  public void getRegionData(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", FileUtils.readFileFromAssets(this.mContext, "mini/region"));
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("MiniAppUIJsPlugin", "getRegionData exception: ", localJSONException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"insertHTMLWebView"})
  public void insertHtmlWebview(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 2));
  }
  
  @JsEvent({"scrollWebviewTo"})
  public void pageScrollTo(RequestEvent paramRequestEvent)
  {
    sendNativeViewEvent(paramRequestEvent, 0);
  }
  
  @JsEvent({"removeHTMLWebView"})
  public void removeHtmlWebview(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 2));
  }
  
  @JsEvent({"scrollWebviewTo"})
  public void scrollWebviewTo(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 1));
  }
  
  @JsEvent({"setBackgroundTextStyle", "setBackgroundColor"})
  public void setBackgroundTextStyle(RequestEvent paramRequestEvent)
  {
    sendNativeViewEvent(paramRequestEvent, 3);
  }
  
  @JsEvent({"updateHTMLWebView"})
  public void updateHtmlWebview(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MiniAppUIJsPlugin
 * JD-Core Version:    0.7.0.1
 */