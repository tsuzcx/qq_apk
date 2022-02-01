package com.tencent.mobileqq.kandian.biz.tab;

import android.content.res.Resources;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;
import com.tencent.mobileqq.widget.QQToast;

class RIJTabFrameDeliverPopupUtil$1$1
  implements Runnable
{
  RIJTabFrameDeliverPopupUtil$1$1(RIJTabFrameDeliverPopupUtil.1 param1) {}
  
  public void run()
  {
    if (RIJUGCDianDian.b() >= 2)
    {
      QQToast.makeText(this.this$0.a.P(), 0, this.this$0.a.P().getString(2131915357), 0).show(this.this$0.a.P().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    RIJTabFrameDeliverPopupUtil.a(this.this$0.a.P());
    RIJUGCDianDian.a("1", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJTabFrameDeliverPopupUtil.1.1
 * JD-Core Version:    0.7.0.1
 */