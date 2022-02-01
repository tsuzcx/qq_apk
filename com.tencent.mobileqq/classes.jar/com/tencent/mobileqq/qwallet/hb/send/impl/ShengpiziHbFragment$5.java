package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class ShengpiziHbFragment$5
  implements Runnable
{
  ShengpiziHbFragment$5(ShengpiziHbFragment paramShengpiziHbFragment) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ShengpiziHbFragment.f(this.this$0).getLayoutParams();
    int j = this.this$0.b.getTop() - this.this$0.r.getTop() - ScreenUtil.dip2px(16.0F) - ScreenUtil.dip2px(8.0F) - ScreenUtil.dip2px(8.0F);
    int i = j;
    if (j < this.this$0.b()) {
      i = this.this$0.b();
    }
    localLayoutParams.width = -1;
    localLayoutParams.height = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment.5
 * JD-Core Version:    0.7.0.1
 */