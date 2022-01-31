package com.tencent.qqmini.sdk.minigame.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.ProcessUtil;

public class VConsoleView
  extends LinearLayout
{
  public WebView a;
  public ImageView a;
  private volatile boolean a;
  
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
  
  private String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return ProcessUtil.getCurrentProcessName(paramContext);
  }
  
  private void a()
  {
    a(getContext());
    LayoutInflater.from(getContext()).inflate(2131559362, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370567));
    this.jdField_a_of_type_AndroidWebkitWebView = ((WebView)findViewById(2131370562));
    this.jdField_a_of_type_AndroidWebkitWebView.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidWebkitWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.jdField_a_of_type_AndroidWebkitWebView.removeJavascriptInterface("accessibility");
      this.jdField_a_of_type_AndroidWebkitWebView.removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public void a(Context paramContext)
  {
    if ((paramContext == null) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        String str = a(paramContext);
        if (!paramContext.getPackageName().equals(str)) {
          WebView.setDataDirectorySuffix(str);
        }
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (IllegalStateException paramContext)
    {
      QMLog.e("VConsoleView", "Failed to initWebviewEvn", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.VConsoleView
 * JD-Core Version:    0.7.0.1
 */