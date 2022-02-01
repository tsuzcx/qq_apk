package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqmini.minigame.R.id;
import com.tencent.qqmini.minigame.R.layout;

public class VConsoleView
  extends LinearLayout
{
  private static final String TAG = "VConsoleView";
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
    LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_vconsole_layout, this);
    this.vConsoleGap = ((ImageView)findViewById(R.id.mini_game_vconsole_gap));
    this.vConsoleWebView = ((WebView)findViewById(R.id.mini_game_console_webview));
    this.vConsoleWebView.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.vConsoleWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.vConsoleWebView.removeJavascriptInterface("accessibility");
      this.vConsoleWebView.removeJavascriptInterface("accessibilityTraversal");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.VConsoleView
 * JD-Core Version:    0.7.0.1
 */