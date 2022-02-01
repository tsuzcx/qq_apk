package com.tencent.tkd.topicsdk.uiImpl;

import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.data.IDataTransfer.TopicCallback;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "isEnd", "", "topicList", "", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class UIDataTransferImpl$getTweetHotList$1
  extends Lambda
  implements Function4<Integer, String, Boolean, List<? extends TweetTopicItem>, Unit>
{
  UIDataTransferImpl$getTweetHotList$1(int paramInt, IDataTransfer.TopicCallback paramTopicCallback)
  {
    super(4);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, boolean paramBoolean, @Nullable List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramList != null)
    {
      localObject2 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((TweetTopicItem)((Iterator)localObject2).next());
      }
    }
    if (paramBoolean) {
      localObject1 = null;
    }
    for (;;)
    {
      this.$callback.a(paramInt, paramString, (byte[])localObject1, paramBoolean, paramList);
      return;
      localObject1 = String.valueOf(this.$pageNum + 1);
      localObject2 = Charsets.UTF_8;
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.uiImpl.UIDataTransferImpl.getTweetHotList.1
 * JD-Core Version:    0.7.0.1
 */