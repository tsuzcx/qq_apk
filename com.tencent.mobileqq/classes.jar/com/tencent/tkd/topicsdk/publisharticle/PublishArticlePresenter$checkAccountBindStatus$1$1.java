package com.tencent.tkd.topicsdk.publisharticle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePresenter$checkAccountBindStatus$1$1
  extends Lambda
  implements Function0<Unit>
{
  PublishArticlePresenter$checkAccountBindStatus$1$1(PublishArticlePresenter.checkAccountBindStatus.1 param1, boolean paramBoolean1, BindAccountInfo paramBindAccountInfo, String paramString1, boolean paramBoolean2, String paramString2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    PublishArticleContract.IPublishArticleView localIPublishArticleView;
    if (this.$needBind)
    {
      localIPublishArticleView = PublishArticlePresenter.a(this.this$0.this$0);
      if (localIPublishArticleView != null) {
        localIPublishArticleView.a(this.$accountInfo);
      }
    }
    if (((CharSequence)this.$protocolUrl).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localIPublishArticleView = PublishArticlePresenter.a(this.this$0.this$0);
        if (localIPublishArticleView != null) {
          localIPublishArticleView.a(this.$protocolUrl);
        }
      }
      localIPublishArticleView = PublishArticlePresenter.a(this.this$0.this$0);
      if (localIPublishArticleView != null) {
        localIPublishArticleView.a(this.$needRealNameConfirm, this.$realNameConfirmUrl);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter.checkAccountBindStatus.1.1
 * JD-Core Version:    0.7.0.1
 */