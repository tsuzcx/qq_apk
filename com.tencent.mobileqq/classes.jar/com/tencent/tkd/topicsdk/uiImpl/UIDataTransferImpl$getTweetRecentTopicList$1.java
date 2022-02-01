package com.tencent.tkd.topicsdk.uiImpl;

import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.data.IDataTransfer.TopicCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "topicList", "", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class UIDataTransferImpl$getTweetRecentTopicList$1
  extends Lambda
  implements Function3<Integer, String, List<? extends TweetTopicItem>, Unit>
{
  UIDataTransferImpl$getTweetRecentTopicList$1(IDataTransfer.TopicCallback paramTopicCallback)
  {
    super(3);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    this.$callback.a(paramInt, paramString, null, true, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.uiImpl.UIDataTransferImpl.getTweetRecentTopicList.1
 * JD-Core Version:    0.7.0.1
 */