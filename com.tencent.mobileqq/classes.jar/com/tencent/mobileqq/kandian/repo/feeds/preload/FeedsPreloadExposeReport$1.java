package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import java.util.List;

final class FeedsPreloadExposeReport$1
  implements Runnable
{
  FeedsPreloadExposeReport$1(ReadInJoyLogicEngine paramReadInJoyLogicEngine, List paramList, String paramString) {}
  
  public void run()
  {
    ReadInJoyLogicEngine localReadInJoyLogicEngine = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine;
    if (localReadInJoyLogicEngine != null) {
      localReadInJoyLogicEngine.a(FeedsPreloadExposeReport.a(this.jdField_a_of_type_JavaUtilList), this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadExposeReport.1
 * JD-Core Version:    0.7.0.1
 */