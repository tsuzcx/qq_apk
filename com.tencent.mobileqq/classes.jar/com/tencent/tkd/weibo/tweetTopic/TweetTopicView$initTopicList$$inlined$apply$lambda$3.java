package com.tencent.tkd.weibo.tweetTopic;

import android.content.Context;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.utils.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "invoke", "com/tencent/tkd/weibo/tweetTopic/TweetTopicView$initTopicList$2$1"}, k=3, mv={1, 1, 16})
final class TweetTopicView$initTopicList$$inlined$apply$lambda$3
  extends Lambda
  implements Function1<TweetTopicItem, Unit>
{
  TweetTopicView$initTopicList$$inlined$apply$lambda$3(TweetTopicView paramTweetTopicView, Context paramContext)
  {
    super(1);
  }
  
  public final void invoke(@NotNull TweetTopicItem paramTweetTopicItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTweetTopicItem, "item");
    this.this$0.a(Utils.a.a(paramTweetTopicItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.initTopicList..inlined.apply.lambda.3
 * JD-Core Version:    0.7.0.1
 */