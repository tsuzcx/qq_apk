package com.tencent.mobileqq.kandian.biz.ugc;

import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeSpan;
import com.tencent.mobileqq.kandian.base.view.widget.text.ISpan;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;

public class TopicSpan
  extends ForegroundColorSpan
  implements DeleteAsAWholeSpan, ISpan
{
  private final TopicInfo a;
  private TopicSpan.DeletedCallback b;
  
  public TopicSpan(TopicInfo paramTopicInfo)
  {
    super(-15504151);
    this.a = paramTopicInfo;
  }
  
  public TopicInfo b()
  {
    return this.a;
  }
  
  public void cO_()
  {
    TopicSpan.DeletedCallback localDeletedCallback = this.b;
    if (localDeletedCallback != null) {
      localDeletedCallback.a(b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.TopicSpan
 * JD-Core Version:    0.7.0.1
 */