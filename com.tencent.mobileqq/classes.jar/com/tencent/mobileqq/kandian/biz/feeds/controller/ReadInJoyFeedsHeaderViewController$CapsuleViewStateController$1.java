package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyFeedsHeaderViewController$CapsuleViewStateController$1
  implements View.OnClickListener
{
  ReadInJoyFeedsHeaderViewController$CapsuleViewStateController$1(ReadInJoyFeedsHeaderViewController.CapsuleViewStateController paramCapsuleViewStateController, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick: ");
    ((StringBuilder)localObject).append(ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController).mChannelCoverName);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    ReadInJoyHelper.a(ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController).mChannelCoverId, true);
    ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.1
 * JD-Core Version:    0.7.0.1
 */