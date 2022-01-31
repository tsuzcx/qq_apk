package com.tencent.qqmini.sdk.minigame.ui;

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
  public WebView a;
  public ImageView a;
  
  public VConsoleView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VConsoleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VConsoleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131559311, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370270));
    this.jdField_a_of_type_AndroidWebkitWebView = ((WebView)findViewById(2131370265));
    this.jdField_a_of_type_AndroidWebkitWebView.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidWebkitWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.jdField_a_of_type_AndroidWebkitWebView.removeJavascriptInterface("accessibility");
      this.jdField_a_of_type_AndroidWebkitWebView.removeJavascriptInterface("accessibilityTraversal");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.VConsoleView
 * JD-Core Version:    0.7.0.1
 */