package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class VConsoleView
  extends LinearLayout
{
  public ImageView vConsoleGap;
  public WebView vConsoleWebView;
  
  public VConsoleView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public VConsoleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public VConsoleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void initUI()
  {
    LayoutInflater.from(getContext()).inflate(2131559325, this);
    this.vConsoleGap = ((ImageView)findViewById(2131370586));
    this.vConsoleWebView = ((WebView)findViewById(2131370581));
    this.vConsoleWebView.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.vConsoleWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.vConsoleWebView.removeJavascriptInterface("accessibility");
      this.vConsoleWebView.removeJavascriptInterface("accessibilityTraversal");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.VConsoleView
 * JD-Core Version:    0.7.0.1
 */