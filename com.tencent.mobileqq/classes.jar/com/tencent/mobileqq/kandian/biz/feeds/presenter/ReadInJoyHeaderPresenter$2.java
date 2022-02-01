package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;

class ReadInJoyHeaderPresenter$2
  implements View.OnClickListener
{
  ReadInJoyHeaderPresenter$2(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.h);
    paramView.append(Base64Util.encodeToString(this.a.getBytes(), 2));
    paramView = paramView.toString();
    ReadInJoyUtils.a(ReadInJoyHeaderPresenter.b(this.c), paramView);
    ReadInJoyHeaderPresenter.a(this.c, RIJFeedsType.k(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyHeaderPresenter.2
 * JD-Core Version:    0.7.0.1
 */