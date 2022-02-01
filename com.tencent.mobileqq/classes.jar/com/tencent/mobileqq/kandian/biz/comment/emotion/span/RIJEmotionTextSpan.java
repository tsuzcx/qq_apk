package com.tencent.mobileqq.kandian.biz.comment.emotion.span;

import com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeSpan;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo;

public class RIJEmotionTextSpan
  implements DeleteAsAWholeSpan, IEmotionSpan, IShrinkLength
{
  private final RIJBaseEmotionInfo a;
  
  public RIJEmotionTextSpan(RIJBaseEmotionInfo paramRIJBaseEmotionInfo)
  {
    this.a = paramRIJBaseEmotionInfo;
  }
  
  public int a()
  {
    RIJBaseEmotionInfo localRIJBaseEmotionInfo = this.a;
    if ((localRIJBaseEmotionInfo instanceof IShrinkLength)) {
      return ((IShrinkLength)localRIJBaseEmotionInfo).a();
    }
    return 0;
  }
  
  public RIJBaseEmotionInfo b()
  {
    return this.a;
  }
  
  public void cO_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.span.RIJEmotionTextSpan
 * JD-Core Version:    0.7.0.1
 */