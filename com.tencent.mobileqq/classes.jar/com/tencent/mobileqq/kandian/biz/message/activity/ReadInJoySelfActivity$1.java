package com.tencent.mobileqq.kandian.biz.message.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;

class ReadInJoySelfActivity$1
  implements Runnable
{
  ReadInJoySelfActivity$1(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment.aA_();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager != null) {
      ReadInJoyWebDataManager.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.i() ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity.1
 * JD-Core Version:    0.7.0.1
 */