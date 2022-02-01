package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ComponentComment$1
  implements View.OnClickListener
{
  ComponentComment$1(ComponentComment paramComponentComment, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyUtils.a(this.c.getContext(), this.a);
    ReadInJoyFooterPresenter.a(1, RIJFeedsType.k(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentComment.1
 * JD-Core Version:    0.7.0.1
 */