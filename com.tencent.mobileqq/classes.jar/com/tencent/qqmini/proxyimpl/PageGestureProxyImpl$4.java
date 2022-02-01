package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;

class PageGestureProxyImpl$4
  implements DialogInterface.OnClickListener
{
  PageGestureProxyImpl$4(PageGestureProxyImpl paramPageGestureProxyImpl, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PageGestureProxyImpl.c(this.b).isShowing()) {
      PageGestureProxyImpl.c(this.b).dismiss();
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).showList(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */