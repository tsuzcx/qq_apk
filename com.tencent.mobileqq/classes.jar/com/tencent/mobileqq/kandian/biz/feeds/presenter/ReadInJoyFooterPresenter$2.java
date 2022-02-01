package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;

class ReadInJoyFooterPresenter$2
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$2(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, long paramLong, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.h);
    paramView.append(Base64Util.encodeToString(String.valueOf(this.a).getBytes(), 2));
    paramView = paramView.toString();
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.c), paramView);
    ReadInJoyFooterPresenter.a(1, RIJFeedsType.k(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter.2
 * JD-Core Version:    0.7.0.1
 */