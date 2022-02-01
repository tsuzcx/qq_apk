package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ComponentHeaderTopicRecommend$3
  implements ActionSheet.OnButtonClickListener
{
  ComponentHeaderTopicRecommend$3(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      ComponentHeaderTopicRecommend.a(this.a, false);
    }
    ComponentHeaderTopicRecommend.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend.3
 * JD-Core Version:    0.7.0.1
 */