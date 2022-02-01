package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImgHeaderView$1
  implements View.OnClickListener
{
  ImgHeaderView$1(ImgHeaderView paramImgHeaderView, Activity paramActivity, QQVipMsgInfo paramQQVipMsgInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewImgHeaderView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo.mPaMsgid, this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo.mGameAppId, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.ImgHeaderView.1
 * JD-Core Version:    0.7.0.1
 */