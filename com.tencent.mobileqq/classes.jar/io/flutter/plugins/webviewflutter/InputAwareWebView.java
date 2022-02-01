package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

final class InputAwareWebView
  extends WebView
{
  private static final String TAG = "InputAwareWebView";
  private View containerView;
  private ThreadedInputConnectionProxyAdapterView proxyAdapterView;
  private View threadedInputConnectionProxyView;
  
  InputAwareWebView(Context paramContext, View paramView)
  {
    super(paramContext);
    this.containerView = paramView;
  }
  
  private void resetInputConnection()
  {
    if (this.proxyAdapterView == null) {
      return;
    }
    if (this.containerView == null)
    {
      Log.e("InputAwareWebView", "Can't reset the input connection to the container view because there is none.");
      return;
    }
    setInputConnectionTarget(this.containerView);
  }
  
  private void setInputConnectionTarget(View paramView)
  {
    if (this.containerView == null)
    {
      Log.e("InputAwareWebView", "Can't set the input connection target because there is no containerView to use as a handler.");
      return;
    }
    paramView.requestFocus();
    this.containerView.post(new InputAwareWebView.1(this, paramView));
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    View localView = this.threadedInputConnectionProxyView;
    this.threadedInputConnectionProxyView = paramView;
    if (localView == paramView) {
      return super.checkInputConnectionProxy(paramView);
    }
    if (this.containerView == null)
    {
      Log.e("InputAwareWebView", "Can't create a proxy view because there's no container view. Text input may not work.");
      return super.checkInputConnectionProxy(paramView);
    }
    this.proxyAdapterView = new ThreadedInputConnectionProxyAdapterView(this.containerView, paramView, paramView.getHandler());
    setInputConnectionTarget(this.proxyAdapterView);
    return super.checkInputConnectionProxy(paramView);
  }
  
  public void clearFocus()
  {
    super.clearFocus();
    resetInputConnection();
  }
  
  void dispose()
  {
    resetInputConnection();
  }
  
  void lockInputConnection()
  {
    if (this.proxyAdapterView == null) {
      return;
    }
    this.proxyAdapterView.setLocked(true);
  }
  
  void setContainerView(View paramView)
  {
    this.containerView = paramView;
    if (this.proxyAdapterView == null) {}
    do
    {
      return;
      Log.w("InputAwareWebView", "The containerView has changed while the proxyAdapterView exists.");
    } while (paramView == null);
    setInputConnectionTarget(this.proxyAdapterView);
  }
  
  void unlockInputConnection()
  {
    if (this.proxyAdapterView == null) {
      return;
    }
    this.proxyAdapterView.setLocked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.InputAwareWebView
 * JD-Core Version:    0.7.0.1
 */