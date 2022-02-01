package com.tencent.mobileqq.kandian.biz.ugc;

import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeSpan;
import com.tencent.mobileqq.kandian.base.view.widget.text.ISpan;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;

public class TopicSpan
  extends ForegroundColorSpan
  implements DeleteAsAWholeSpan, ISpan
{
  private TopicSpan.DeletedCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcTopicSpan$DeletedCallback;
  private final TopicInfo jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerTopicInfo;
  
  public TopicSpan(TopicInfo paramTopicInfo)
  {
    super(-15504151);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerTopicInfo = paramTopicInfo;
  }
  
  public TopicInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerTopicInfo;
  }
  
  public void a()
  {
    TopicSpan.DeletedCallback localDeletedCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcTopicSpan$DeletedCallback;
    if (localDeletedCallback != null) {
      localDeletedCallback.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.TopicSpan
 * JD-Core Version:    0.7.0.1
 */