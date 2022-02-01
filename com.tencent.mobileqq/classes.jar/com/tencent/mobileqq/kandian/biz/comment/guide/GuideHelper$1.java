package com.tencent.mobileqq.kandian.biz.comment.guide;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;

class GuideHelper$1
  implements View.OnClickListener
{
  GuideHelper$1(GuideHelper paramGuideHelper, CommentViewItem paramCommentViewItem, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("getBottomGuideView : ");
    paramView.append(GuideHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper));
    QLog.d("GuideHelper", 1, paramView.toString());
    GuideHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper, "0X8009FEA", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a);
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, GuideHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper.1
 * JD-Core Version:    0.7.0.1
 */