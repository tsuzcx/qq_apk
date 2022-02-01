package com.tencent.mobileqq.vas.hippy;

import com.tencent.mobileqq.vas.hippyhelper.HippyJSBHelper;
import com.tencent.mobileqq.vas.hippyhelper.IHippyJsbInvokeAdapter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public class HippyJsBridgeListener
  extends JsBridgeListener
{
  private final HippyJSBHelper d = HippyJSBHelper.b();
  
  public HippyJsBridgeListener(WebView paramWebView, long paramLong, boolean paramBoolean)
  {
    super(paramWebView, paramLong, paramBoolean);
  }
  
  public void a()
  {
    this.d.a().onCallError("PermissionDenied");
  }
  
  public void a(Object paramObject)
  {
    this.d.a().onCallJs(paramObject);
  }
  
  public void a(String paramString)
  {
    this.d.a().onCallError(paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.d.a().onCallJs(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.HippyJsBridgeListener
 * JD-Core Version:    0.7.0.1
 */