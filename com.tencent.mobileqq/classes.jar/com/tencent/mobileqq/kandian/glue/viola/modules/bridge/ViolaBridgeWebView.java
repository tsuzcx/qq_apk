package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.content.Context;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import java.util.HashMap;

public class ViolaBridgeWebView
  extends CustomWebView
{
  private HashMap<String, ViolaBridgeApiHelper.InvokeListener> b = new HashMap();
  
  public ViolaBridgeWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void callJs(String paramString) {}
  
  public void callJs(String paramString, String... paramVarArgs) {}
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String... paramVarArgs) {}
  
  public String getUrl()
  {
    return "https://kandian.qq.com/";
  }
  
  public void loadUrl(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.ViolaBridgeWebView
 * JD-Core Version:    0.7.0.1
 */