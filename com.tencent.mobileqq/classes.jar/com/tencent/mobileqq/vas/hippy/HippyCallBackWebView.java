package com.tencent.mobileqq.vas.hippy;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.vas.hippyhelper.HippyJSBHelper;
import com.tencent.mobileqq.vas.hippyhelper.IHippyJsbInvokeAdapter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;

public class HippyCallBackWebView
  extends CustomWebView
{
  private final HippyJSBHelper b = HippyJSBHelper.b();
  
  public HippyCallBackWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HippyCallBackWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HippyCallBackWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void callJs(String paramString)
  {
    this.b.a().onCallJs(paramString);
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    this.b.a().onCallJs(paramVarArgs);
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String... paramVarArgs)
  {
    this.b.a().onCallJs(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.HippyCallBackWebView
 * JD-Core Version:    0.7.0.1
 */