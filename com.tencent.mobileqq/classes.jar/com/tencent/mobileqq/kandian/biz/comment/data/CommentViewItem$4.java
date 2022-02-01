package com.tencent.mobileqq.kandian.biz.comment.data;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.jetbrains.annotations.NotNull;

class CommentViewItem$4
  extends ClickableSpan
{
  CommentViewItem$4(CommentViewItem paramCommentViewItem, BaseCommentData paramBaseCommentData, String paramString1, String paramString2) {}
  
  public void onClick(@NotNull View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.ksHomePage))) {
      ReadInJoyCommentUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.ksHomePage, QBaseActivity.sTopActivity);
    } else {
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_JavaLangString, QBaseActivity.sTopActivity);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a.mAlgorithmID), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a.innerUniqueID, this.b, false);
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#376099"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem.4
 * JD-Core Version:    0.7.0.1
 */