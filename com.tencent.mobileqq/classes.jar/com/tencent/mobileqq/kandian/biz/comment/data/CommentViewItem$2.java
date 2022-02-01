package com.tencent.mobileqq.kandian.biz.comment.data;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class CommentViewItem$2
  extends ClickableSpan
{
  CommentViewItem$2(CommentViewItem paramCommentViewItem, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySubCommentData.repliedUserUin, QBaseActivity.sTopActivity);
    paramView = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem).a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySubCommentData.repliedUserUin).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a.mAlgorithmID), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#737373"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem.2
 * JD-Core Version:    0.7.0.1
 */