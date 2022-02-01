package com.tencent.xweb.xwalk;

import android.view.View;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class m
  extends XWalkUIClient
{
  public m(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void a()
  {
    super.onHideCustomView();
  }
  
  public final void a(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    super.onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public final void a(XWalkView paramXWalkView, String paramString)
  {
    super.onPageLoadStarted(paramXWalkView, paramString);
  }
  
  public final boolean a(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    return super.onJsPrompt(paramXWalkView, paramString1, paramString2, paramString3, paramXWalkJavascriptResult);
  }
  
  public final boolean a(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    return super.onJsConfirm(paramXWalkView, paramString1, paramString2, paramXWalkJavascriptResult);
  }
  
  public final boolean b(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    return super.onJsAlert(paramXWalkView, paramString1, paramString2, paramXWalkJavascriptResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.m
 * JD-Core Version:    0.7.0.1
 */