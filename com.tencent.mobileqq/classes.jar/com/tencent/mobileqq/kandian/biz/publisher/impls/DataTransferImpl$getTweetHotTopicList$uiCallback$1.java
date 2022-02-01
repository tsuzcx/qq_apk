package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.data.IDataTransfer.TopicCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "", "isEnd", "", "resultList", "", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "", "onLoadTopicListResult"}, k=3, mv={1, 1, 16})
final class DataTransferImpl$getTweetHotTopicList$uiCallback$1
  implements IDataTransfer.TopicCallback
{
  public final void a(int paramInt, String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<TweetTopicItem> paramList)
  {
    paramArrayOfByte = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramString, "errorMsg");
    paramArrayOfByte.invoke(Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean), paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl.getTweetHotTopicList.uiCallback.1
 * JD-Core Version:    0.7.0.1
 */