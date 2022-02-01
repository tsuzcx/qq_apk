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
    paramView.append(ReadInJoyConstants.g);
    paramView.append(Base64Util.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 2));
    paramView = paramView.toString();
    ReadInJoyUtils.a(ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsPresenterReadInJoyHeaderPresenter), paramView);
    ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsPresenterReadInJoyHeaderPresenter, RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyHeaderPresenter.2
 * JD-Core Version:    0.7.0.1
 */