package com.tencent.mobileqq.kandian.biz.pts.view;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyTextView$2$1
  implements Runnable
{
  ReadInjoyTextView$2$1(ReadInjoyTextView.2 param2, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setDecorationName callback, nick = ", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyUserInfo.decorationName });
    ReadInjoyTextView localReadInjoyTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInjoyTextView$2.a;
    String str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyUserInfo.decorationName)) {
      str = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInjoyTextView$2.b;
    } else {
      str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyUserInfo.decorationName;
    }
    localReadInjoyTextView.setText(RIJStringUtils.a(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.2.1
 * JD-Core Version:    0.7.0.1
 */