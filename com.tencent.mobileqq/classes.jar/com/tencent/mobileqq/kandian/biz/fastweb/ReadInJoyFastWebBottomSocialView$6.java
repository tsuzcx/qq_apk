package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.widget.BubblePopupWindow;

class ReadInJoyFastWebBottomSocialView$6
  implements Runnable
{
  ReadInJoyFastWebBottomSocialView$6(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void run()
  {
    if (ReadInJoyFastWebBottomSocialView.a(this.this$0) != null)
    {
      ReadInJoyFastWebBottomSocialView.a(this.this$0).showAsDropDown(ReadInJoyFastWebBottomSocialView.a(this.this$0));
      BiuBehaviour.a();
      ReadInJoyFastWebBottomSocialView localReadInJoyFastWebBottomSocialView = this.this$0;
      localReadInJoyFastWebBottomSocialView.postDelayed(ReadInJoyFastWebBottomSocialView.a(localReadInJoyFastWebBottomSocialView), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView.6
 * JD-Core Version:    0.7.0.1
 */