package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyTextView$1$1
  implements Runnable
{
  ReadInjoyTextView$1$1(ReadInjoyTextView.1 param1, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setContentWithNickName callback, nick = ", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyUserInfo.nick });
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInjoyTextView$1.a.setText(ReadInjoyTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInjoyTextView$1.a, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInjoyTextView$1.b, RIJStringUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyUserInfo.nick)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.1.1
 * JD-Core Version:    0.7.0.1
 */