package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class OnTopicRecommendHeaderFollowClickListener$2
  implements ActionSheet.OnButtonClickListener
{
  OnTopicRecommendHeaderFollowClickListener$2(OnTopicRecommendHeaderFollowClickListener paramOnTopicRecommendHeaderFollowClickListener) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      OnTopicRecommendHeaderFollowClickListener.a(this.a, false);
    }
    OnTopicRecommendHeaderFollowClickListener.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicRecommendHeaderFollowClickListener.2
 * JD-Core Version:    0.7.0.1
 */