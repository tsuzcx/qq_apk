package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IArticleViewModelUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ArticleViewModel
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  public int a;
  public long a;
  private final AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private Observable<CharSequence> jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable = new Observable("");
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  public String a;
  private Observable<CharSequence> b = new Observable("");
  private Observable<CharSequence> c = new Observable("");
  
  private ArticleViewModel(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = ((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).convertBiuTime(paramAbsBaseArticleInfo);
    this.c.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(paramAbsBaseArticleInfo, this));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeNonBiuComment(paramAbsBaseArticleInfo, this));
    this.b.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeSummaryText(paramAbsBaseArticleInfo, this));
  }
  
  public static ArticleViewModel a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return new ArticleViewModel(paramAbsBaseArticleInfo);
  }
  
  public AbsBaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  public Observable<CharSequence> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable;
  }
  
  public void a()
  {
    this.c.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeNonBiuComment(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this));
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCustomLinkTextColorSummary | linkedTextColor ");
    localStringBuilder.append(paramInt);
    QLog.d("ArticleViewModel", 1, localStringBuilder.toString());
    this.c.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this));
    this.b.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeSummaryText(paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this));
  }
  
  public Observable<CharSequence> b()
  {
    return this.b;
  }
  
  public Observable<CharSequence> c()
  {
    return this.c;
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onLoadUserInfoFailed] uin=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString2);
    QLog.e("ArticleViewModel", 1, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadUserInfoSucceed] uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" userInfo: ");
      localStringBuilder.append(paramReadInJoyUserInfo);
      QLog.d("ArticleViewModel", 2, localStringBuilder.toString());
    }
    this.c.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeNonBiuComment(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null));
    this.b.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeSummaryText(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel
 * JD-Core Version:    0.7.0.1
 */