package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class PageGestureProxyImpl$1
  implements OnColorNoteAnimFinishListener
{
  PageGestureProxyImpl$1(PageGestureProxyImpl paramPageGestureProxyImpl, Activity paramActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    if ((PageGestureProxyImpl.a(this.b) != null) && (PageGestureProxyImpl.a(this.b).isInternalApp())) {
      this.a.finish();
    }
    AnimUtil.clearAnim(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */