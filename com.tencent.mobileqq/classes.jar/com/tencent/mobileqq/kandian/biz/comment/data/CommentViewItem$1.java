package com.tencent.mobileqq.kandian.biz.comment.data;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class CommentViewItem$1
  extends ClickableSpan
{
  CommentViewItem$1(CommentViewItem paramCommentViewItem, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyCommentUtils.a(this.a.uin, QBaseActivity.sTopActivity);
    paramView = new CommentReportR5Builder(this.b).a().b();
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.b.d), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.b.d.mArticleID), String.valueOf(this.b.d.mAlgorithmID), this.b.d.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    String str;
    if (this.a.isAuthorSelection()) {
      str = "#FF8444";
    } else {
      str = "#737373";
    }
    paramTextPaint.setColor(Color.parseColor(str));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem.1
 * JD-Core Version:    0.7.0.1
 */