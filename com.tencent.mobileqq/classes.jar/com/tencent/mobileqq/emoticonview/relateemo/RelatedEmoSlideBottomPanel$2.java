package com.tencent.mobileqq.emoticonview.relateemo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelatedEmoSlideBottomPanel$2
  implements View.OnClickListener
{
  RelatedEmoSlideBottomPanel$2(RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel) {}
  
  public void onClick(View paramView)
  {
    RelatedEmoSlideBottomPanel.access$002(this.this$0, 2);
    RelatedEmoSlideBottomPanel localRelatedEmoSlideBottomPanel = this.this$0;
    RelatedEmoSlideBottomPanel.access$100(localRelatedEmoSlideBottomPanel, localRelatedEmoSlideBottomPanel.getMeasuredHeight());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel.2
 * JD-Core Version:    0.7.0.1
 */