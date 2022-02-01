package com.tencent.xweb.xwalk;

import android.webkit.WebView.FindListener;
import org.xwalk.core.XWalkFindListener;

public class g$g
  extends XWalkFindListener
{
  WebView.FindListener a;
  
  public g$g(WebView.FindListener paramFindListener)
  {
    this.a = paramFindListener;
  }
  
  public void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    WebView.FindListener localFindListener = this.a;
    if (localFindListener != null) {
      localFindListener.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.g
 * JD-Core Version:    0.7.0.1
 */