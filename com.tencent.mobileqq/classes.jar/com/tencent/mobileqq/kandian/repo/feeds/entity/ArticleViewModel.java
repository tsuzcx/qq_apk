package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IArticleViewModelUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ArticleViewModel
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  public int a;
  public long b;
  public String c;
  private final AbsBaseArticleInfo d;
  private Observable<CharSequence> e = new Observable("");
  private Observable<CharSequence> f = new Observable("");
  private Observable<CharSequence> g = new Observable("");
  private CharSequence h = "";
  
  private ArticleViewModel(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.d = paramAbsBaseArticleInfo;
    this.h = ((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).convertBiuTime(paramAbsBaseArticleInfo);
    this.g.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(paramAbsBaseArticleInfo, this));
    this.e.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeNonBiuComment(paramAbsBaseArticleInfo, this));
    this.f.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeSummaryText(paramAbsBaseArticleInfo, this));
  }
  
  public static ArticleViewModel a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return new ArticleViewModel(paramAbsBaseArticleInfo);
  }
  
  public void a()
  {
    this.g.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(this.d, this));
    this.e.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeNonBiuComment(this.d, this));
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCustomLinkTextColorSummary | linkedTextColor ");
    localStringBuilder.append(paramInt);
    QLog.d("ArticleViewModel", 1, localStringBuilder.toString());
    this.g.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(paramInt, this.d, this));
    this.f.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeSummaryText(paramInt, this.d, this));
  }
  
  public AbsBaseArticleInfo b()
  {
    return this.d;
  }
  
  public Observable<CharSequence> c()
  {
    return this.e;
  }
  
  public Observable<CharSequence> d()
  {
    return this.f;
  }
  
  public Observable<CharSequence> e()
  {
    return this.g;
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
    this.g.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeBiuComment(this.d, null));
    this.e.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeNonBiuComment(this.d, null));
    this.f.a(((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).makeSummaryText(this.d, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel
 * JD-Core Version:    0.7.0.1
 */