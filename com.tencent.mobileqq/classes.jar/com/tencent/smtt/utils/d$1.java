package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.WebView;

class d$1
  implements d.a
{
  d$1(d paramd, WebView paramWebView, Context paramContext, RelativeLayout paramRelativeLayout, String paramString, TextView paramTextView) {}
  
  public void a()
  {
    this.a.post(new d.1.1(this));
  }
  
  public void a(int paramInt)
  {
    this.a.post(new d.1.2(this, paramInt));
  }
  
  public void a(Throwable paramThrowable)
  {
    this.a.post(new d.1.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.d.1
 * JD-Core Version:    0.7.0.1
 */