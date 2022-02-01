package com.tencent.mobileqq.hotpic;

import android.os.Handler;
import android.os.Message;

class HotPicPageView$3
  extends Handler
{
  HotPicPageView$3(HotPicPageView paramHotPicPageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (HotPicPageView.z) {
        return;
      }
      this.a.i();
      return;
    }
    if (HotPicPageView.z) {
      return;
    }
    if ((this.a.g.getVisibility() == 0) && (this.a.h != null))
    {
      if (this.a.h.getItemCount() == 0) {
        return;
      }
      i = this.a.g.d();
      if (i < 0) {
        return;
      }
      paramMessage = this.a.g.findViewHolderForPosition(i);
      if ((paramMessage != null) && ((paramMessage instanceof HotPicPageView.MyVideoViewHolder)))
      {
        paramMessage = (HotPicPageView.MyVideoViewHolder)paramMessage;
        if (paramMessage.n == 0)
        {
          this.a.b(paramMessage, i);
          return;
        }
        paramMessage.m = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.3
 * JD-Core Version:    0.7.0.1
 */