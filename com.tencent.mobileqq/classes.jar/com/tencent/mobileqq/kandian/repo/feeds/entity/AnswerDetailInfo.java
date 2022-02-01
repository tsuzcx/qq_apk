package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;

public class AnswerDetailInfo
{
  public String a = "";
  public String b = "";
  public String c = "";
  public int d;
  public int e;
  
  public static AnswerDetailInfo a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    AnswerDetailInfo localAnswerDetailInfo = new AnswerDetailInfo();
    if (paramAnswerDetail.question_rowkey.has()) {
      localAnswerDetailInfo.a = paramAnswerDetail.question_rowkey.get();
    }
    if (paramAnswerDetail.question_title.has()) {
      localAnswerDetailInfo.b = paramAnswerDetail.question_title.get();
    }
    if (paramAnswerDetail.answer_content.has()) {
      localAnswerDetailInfo.c = paramAnswerDetail.answer_content.get();
    }
    if (paramAnswerDetail.agreed_num.has()) {
      localAnswerDetailInfo.d = paramAnswerDetail.agreed_num.get();
    }
    if (paramAnswerDetail.card_style.has()) {
      localAnswerDetailInfo.e = paramAnswerDetail.card_style.get();
    }
    return localAnswerDetailInfo;
  }
  
  public articlesummary.AnswerDetail a()
  {
    articlesummary.AnswerDetail localAnswerDetail = new articlesummary.AnswerDetail();
    if (!TextUtils.isEmpty(this.a)) {
      localAnswerDetail.question_rowkey.set(this.a);
    }
    if (!TextUtils.isEmpty(this.b)) {
      localAnswerDetail.question_title.set(this.b);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localAnswerDetail.answer_content.set(this.c);
    }
    localAnswerDetail.agreed_num.set(this.d);
    localAnswerDetail.card_style.set(this.e);
    return localAnswerDetail;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.AnswerDetailInfo
 * JD-Core Version:    0.7.0.1
 */