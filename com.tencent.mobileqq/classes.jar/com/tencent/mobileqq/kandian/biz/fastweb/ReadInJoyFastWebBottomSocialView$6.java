package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.widget.BubblePopupWindow;

class ReadInJoyFastWebBottomSocialView$6
  implements Runnable
{
  ReadInJoyFastWebBottomSocialView$6(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void run()
  {
    if (ReadInJoyFastWebBottomSocialView.g(this.this$0) != null)
    {
      ReadInJoyFastWebBottomSocialView.g(this.this$0).showAsDropDown(ReadInJoyFastWebBottomSocialView.h(this.this$0));
      BiuBehaviour.c();
      ReadInJoyFastWebBottomSocialView localReadInJoyFastWebBottomSocialView = this.this$0;
      localReadInJoyFastWebBottomSocialView.postDelayed(ReadInJoyFastWebBottomSocialView.i(localReadInJoyFastWebBottomSocialView), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView.6
 * JD-Core Version:    0.7.0.1
 */