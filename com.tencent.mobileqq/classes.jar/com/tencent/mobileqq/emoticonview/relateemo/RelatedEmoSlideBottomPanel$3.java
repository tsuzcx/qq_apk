package com.tencent.mobileqq.emoticonview.relateemo;

class RelatedEmoSlideBottomPanel$3
  implements Runnable
{
  RelatedEmoSlideBottomPanel$3(RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel) {}
  
  public void run()
  {
    this.this$0.setVisibility(0);
    this.this$0.animTranslationY(true, new float[] { this.this$0.getMeasuredHeight(), this.this$0.maxTopY() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel.3
 * JD-Core Version:    0.7.0.1
 */