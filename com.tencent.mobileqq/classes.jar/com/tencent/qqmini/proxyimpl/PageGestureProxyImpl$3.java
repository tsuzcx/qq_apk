package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import mqq.util.WeakReference;

class PageGestureProxyImpl$3
  extends OnColorNoteCurdListener
{
  PageGestureProxyImpl$3(PageGestureProxyImpl paramPageGestureProxyImpl) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (PageGestureProxyImpl.b(this.a) == null) {
      return;
    }
    paramBundle = (Activity)PageGestureProxyImpl.b(this.a).get();
    if (paramBundle != null) {
      paramBundle.moveTaskToBack(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */