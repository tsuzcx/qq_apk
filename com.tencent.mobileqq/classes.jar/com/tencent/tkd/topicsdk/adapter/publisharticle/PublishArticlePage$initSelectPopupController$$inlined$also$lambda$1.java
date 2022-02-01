package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "startPos", "", "createBySpace", "", "tweetTopicItem", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "invoke", "com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$initSelectPopupController$1$1"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initSelectPopupController$$inlined$also$lambda$1
  extends Lambda
  implements Function3<Integer, Boolean, TweetTopicItem, Unit>
{
  PublishArticlePage$initSelectPopupController$$inlined$also$lambda$1(PublishArticlePage paramPublishArticlePage)
  {
    super(3);
  }
  
  public final void invoke(int paramInt, boolean paramBoolean, @NotNull TweetTopicItem paramTweetTopicItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTweetTopicItem, "tweetTopicItem");
    PublishArticlePage.a(this.this$0, paramInt, paramBoolean, paramTweetTopicItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initSelectPopupController..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */