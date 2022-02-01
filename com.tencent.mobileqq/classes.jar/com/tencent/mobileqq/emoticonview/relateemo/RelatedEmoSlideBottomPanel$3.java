package com.tencent.mobileqq.emoticonview.relateemo;

class RelatedEmoSlideBottomPanel$3
  implements Runnable
{
  RelatedEmoSlideBottomPanel$3(RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel) {}
  
  public void run()
  {
    this.this$0.setVisibility(0);
    RelatedEmoSlideBottomPanel localRelatedEmoSlideBottomPanel = this.this$0;
    localRelatedEmoSlideBottomPanel.animTranslationY(true, new float[] { localRelatedEmoSlideBottomPanel.getMeasuredHeight(), this.this$0.maxTopY() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel.3
 * JD-Core Version:    0.7.0.1
 */