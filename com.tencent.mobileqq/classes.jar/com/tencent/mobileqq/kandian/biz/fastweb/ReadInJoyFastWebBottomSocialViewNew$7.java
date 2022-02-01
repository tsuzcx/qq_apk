package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;

class ReadInJoyFastWebBottomSocialViewNew$7
  implements ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob
{
  ReadInJoyFastWebBottomSocialViewNew$7(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew, boolean paramBoolean, String paramString) {}
  
  public void a(ReadInJoyObserver paramReadInJoyObserver)
  {
    int j = ReadInJoyFastWebBottomSocialViewNew.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew);
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 0;
    } else {
      i = -1;
    }
    paramReadInJoyObserver.a(j, i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew.7
 * JD-Core Version:    0.7.0.1
 */