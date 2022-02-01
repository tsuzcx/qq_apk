package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;
import mqq.util.WeakReference;

class PageGestureProxyImpl$3
  extends ColorNoteCurd.OnColorNoteCurdListener
{
  PageGestureProxyImpl$3(PageGestureProxyImpl paramPageGestureProxyImpl) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (PageGestureProxyImpl.a(this.a) == null) {}
    do
    {
      return;
      paramBundle = (Activity)PageGestureProxyImpl.a(this.a).get();
    } while (paramBundle == null);
    paramBundle.moveTaskToBack(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */