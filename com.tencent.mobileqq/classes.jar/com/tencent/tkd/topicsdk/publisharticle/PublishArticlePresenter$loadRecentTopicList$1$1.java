package com.tencent.tkd.topicsdk.publisharticle;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePresenter$loadRecentTopicList$1$1
  extends Lambda
  implements Function0<Unit>
{
  PublishArticlePresenter$loadRecentTopicList$1$1(PublishArticlePresenter.loadRecentTopicList.1 param1, List paramList)
  {
    super(0);
  }
  
  public final void invoke()
  {
    PublishArticleContract.IPublishArticleView localIPublishArticleView = PublishArticlePresenter.a(this.this$0.this$0);
    if (localIPublishArticleView != null) {
      localIPublishArticleView.a(this.$topicList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter.loadRecentTopicList.1.1
 * JD-Core Version:    0.7.0.1
 */