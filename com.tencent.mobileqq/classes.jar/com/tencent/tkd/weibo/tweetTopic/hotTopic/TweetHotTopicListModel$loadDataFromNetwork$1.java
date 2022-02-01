package com.tencent.tkd.weibo.tweetTopic.hotTopic;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "retCookie", "", "isEnd", "", "topicList", "", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class TweetHotTopicListModel$loadDataFromNetwork$1
  extends Lambda
  implements Function5<Integer, String, byte[], Boolean, List<? extends TweetTopicItem>, Unit>
{
  TweetHotTopicListModel$loadDataFromNetwork$1(TweetHotTopicListModel paramTweetHotTopicListModel, Function7 paramFunction7)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    new Handler(Looper.getMainLooper()).post((Runnable)new TweetHotTopicListModel.loadDataFromNetwork.1.1(this, paramInt, paramList, paramBoolean, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.hotTopic.TweetHotTopicListModel.loadDataFromNetwork.1
 * JD-Core Version:    0.7.0.1
 */