package com.tencent.xweb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import com.tencent.xweb.internal.IWebView;
import org.xwalk.core.Log;

class WebView$e
  extends MutableContextWrapper
{
  IWebView a;
  
  public WebView$e(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(IWebView paramIWebView)
  {
    this.a = paramIWebView;
  }
  
  public void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (!v.a().h()) {
      ad.a("BASE_CONTEXT_CHANGED", this.a);
    }
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    try
    {
      super.unbindService(paramServiceConnection);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      Log.e("xweb.WebView", "ContextWrapper unbindService IllegalArgumentException", paramServiceConnection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.WebView.e
 * JD-Core Version:    0.7.0.1
 */