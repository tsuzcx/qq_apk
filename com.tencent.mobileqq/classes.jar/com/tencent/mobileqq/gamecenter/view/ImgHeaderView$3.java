package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImgHeaderView$3
  implements View.OnClickListener
{
  ImgHeaderView$3(ImgHeaderView paramImgHeaderView, Context paramContext, QQGameMsgInfo paramQQGameMsgInfo, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewImgHeaderView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ImgHeaderView.3
 * JD-Core Version:    0.7.0.1
 */