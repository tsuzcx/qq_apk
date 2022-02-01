package com.tencent.mobileqq.kandian.biz.comment.data;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.jetbrains.annotations.NotNull;

class CommentViewItem$4
  extends ClickableSpan
{
  CommentViewItem$4(CommentViewItem paramCommentViewItem, BaseCommentData paramBaseCommentData, String paramString1, String paramString2) {}
  
  public void onClick(@NotNull View paramView)
  {
    if ((this.a.isAuthorReply()) && (!TextUtils.isEmpty(this.a.ksHomePage))) {
      ReadInJoyCommentUtils.b(this.a.ksHomePage, QBaseActivity.sTopActivity);
    } else {
      ReadInJoyCommentUtils.a(this.b, QBaseActivity.sTopActivity);
    }
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.d.d), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.d.d.mArticleID), String.valueOf(this.d.d.mAlgorithmID), this.d.d.innerUniqueID, this.c, false);
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#376099"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem.4
 * JD-Core Version:    0.7.0.1
 */