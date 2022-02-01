package com.tencent.tkd.topicsdk.publisharticle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePresenter$bindAccount$1$1
  extends Lambda
  implements Function0<Unit>
{
  PublishArticlePresenter$bindAccount$1$1(PublishArticlePresenter.bindAccount.1 param1, boolean paramBoolean)
  {
    super(0);
  }
  
  public final void invoke()
  {
    PublishArticleContract.IPublishArticleView localIPublishArticleView = PublishArticlePresenter.a(this.this$0.this$0);
    if (localIPublishArticleView != null) {
      localIPublishArticleView.a(this.$isSuccess);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter.bindAccount.1.1
 * JD-Core Version:    0.7.0.1
 */