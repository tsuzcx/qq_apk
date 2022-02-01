package com.tencent.mobileqq.intervideo.audioroom.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;

public class QQVoiceWebView
  extends TouchWebView
{
  public QQVoiceWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQVoiceWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View getCurrentView()
  {
    return this;
  }
  
  public void releaseEngine()
  {
    setPluginEngine(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.webview.QQVoiceWebView
 * JD-Core Version:    0.7.0.1
 */