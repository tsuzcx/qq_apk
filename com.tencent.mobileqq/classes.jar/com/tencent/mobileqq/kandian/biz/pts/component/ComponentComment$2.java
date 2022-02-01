package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;

class ComponentComment$2
  implements View.OnClickListener
{
  ComponentComment$2(ComponentComment paramComponentComment, long paramLong, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.g);
    paramView.append(Base64Util.encodeToString(String.valueOf(this.jdField_a_of_type_Long).getBytes(), 2));
    paramView = paramView.toString();
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentComment.getContext(), paramView);
    ReadInJoyFooterPresenter.a(1, RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentComment.2
 * JD-Core Version:    0.7.0.1
 */