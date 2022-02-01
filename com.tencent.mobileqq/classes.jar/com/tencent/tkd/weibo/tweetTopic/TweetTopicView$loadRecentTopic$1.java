package com.tencent.tkd.weibo.tweetTopic;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "topicList", "", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class TweetTopicView$loadRecentTopic$1
  extends Lambda
  implements Function5<Integer, String, byte[], Boolean, List<? extends TweetTopicItem>, Unit>
{
  TweetTopicView$loadRecentTopic$1(TweetTopicView paramTweetTopicView)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 1>");
    new Handler(Looper.getMainLooper()).post((Runnable)new TweetTopicView.loadRecentTopic.1.1(this, paramInt, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.loadRecentTopic.1
 * JD-Core Version:    0.7.0.1
 */