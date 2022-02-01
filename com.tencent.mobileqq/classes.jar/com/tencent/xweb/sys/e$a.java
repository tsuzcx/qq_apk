package com.tencent.xweb.sys;

import android.content.Context;
import android.view.KeyEvent;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import com.tencent.xweb.x;

class e$a
  extends DtWebView
{
  public x a;
  
  public e$a(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return computeVerticalScrollRange();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (this.b.hasEnteredFullscreen()))
    {
      this.b.leaveFullscreen();
      return true;
    }
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b.a != null) {
      this.b.a.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    x localx = this.a;
    if (localx != null) {
      localx.a(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.e.a
 * JD-Core Version:    0.7.0.1
 */