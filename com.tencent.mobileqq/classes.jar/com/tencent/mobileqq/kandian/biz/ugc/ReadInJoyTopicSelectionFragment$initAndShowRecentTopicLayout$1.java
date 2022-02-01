package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.repo.handler.TopicInfoExFunctionKt;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class ReadInJoyTopicSelectionFragment$initAndShowRecentTopicLayout$1
  extends Lambda
  implements Function1<TweetTopicItem, Unit>
{
  ReadInJoyTopicSelectionFragment$initAndShowRecentTopicLayout$1(ReadInJoyTopicSelectionFragment paramReadInJoyTopicSelectionFragment)
  {
    super(1);
  }
  
  public final void invoke(@NotNull TweetTopicItem paramTweetTopicItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTweetTopicItem, "it");
    ReadInJoyTopicSelectionFragment.a(this.this$0, TopicInfoExFunctionKt.a(paramTweetTopicItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyTopicSelectionFragment.initAndShowRecentTopicLayout.1
 * JD-Core Version:    0.7.0.1
 */