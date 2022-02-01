package com.tencent.tkd.weibo.tweetTopic;

import android.content.Context;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.bean.TweetTopicItemKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "invoke", "com/tencent/tkd/weibo/tweetTopic/TweetTopicView$initSearchResultView$2$1"}, k=3, mv={1, 1, 16})
final class TweetTopicView$initSearchResultView$$inlined$apply$lambda$1
  extends Lambda
  implements Function1<TweetTopicItem, Unit>
{
  TweetTopicView$initSearchResultView$$inlined$apply$lambda$1(TweetTopicView paramTweetTopicView, Context paramContext)
  {
    super(1);
  }
  
  public final void invoke(@NotNull TweetTopicItem paramTweetTopicItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTweetTopicItem, "it");
    this.this$0.a(TweetTopicItemKt.a(paramTweetTopicItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.initSearchResultView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */