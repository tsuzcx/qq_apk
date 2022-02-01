package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.bean.TweetTopicItemKt;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "tweetTopicItem", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initRecentTopicLayout$1
  extends Lambda
  implements Function1<TweetTopicItem, Unit>
{
  PublishArticlePage$initRecentTopicLayout$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@NotNull TweetTopicItem paramTweetTopicItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTweetTopicItem, "tweetTopicItem");
    RichEditText.a(PublishArticlePage.a(this.this$0), TweetTopicItemKt.a(paramTweetTopicItem), false, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initRecentTopicLayout.1
 * JD-Core Version:    0.7.0.1
 */