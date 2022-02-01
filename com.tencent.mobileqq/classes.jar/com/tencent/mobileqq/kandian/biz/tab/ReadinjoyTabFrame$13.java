package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;

class ReadinjoyTabFrame$13
  implements Runnable
{
  ReadinjoyTabFrame$13(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void run()
  {
    if (ReadinjoyTabFrame.i(this.this$0) != null)
    {
      ReadinjoyTabFrame.i(this.this$0).setAnimation(AnimationUtils.loadAnimation(this.this$0.P(), 2130772462));
      ReadinjoyTabFrame.i(this.this$0).setVisibility(8);
      SharedPreUtils.bs(this.this$0.P(), this.this$0.t().getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.13
 * JD-Core Version:    0.7.0.1
 */