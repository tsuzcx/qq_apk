package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import android.os.Handler;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "<anonymous parameter 4>", "", "<anonymous parameter 5>", "<anonymous parameter 6>", "", "invoke"}, k=3, mv={1, 1, 16})
final class SearchTopicListModel$onEmptyTopicLoaded$1
  extends Lambda
  implements Function7<Boolean, Boolean, Integer, ArrayList<TweetTopicItem>, byte[], Integer, String, Unit>
{
  SearchTopicListModel$onEmptyTopicLoaded$1(SearchTopicListModel paramSearchTopicListModel, ArrayList paramArrayList, Function7 paramFunction7)
  {
    super(7);
  }
  
  public final void invoke(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, @NotNull ArrayList<TweetTopicItem> paramArrayList, @Nullable byte[] paramArrayOfByte, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 6>");
    if (paramBoolean1)
    {
      paramArrayList = (Collection)paramArrayList;
      if ((paramArrayList.isEmpty() ^ true)) {
        this.$result.addAll((Collection)new ArrayList(paramArrayList));
      }
    }
    SearchTopicListModel.a(this.this$0).post((Runnable)new SearchTopicListModel.onEmptyTopicLoaded.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel.onEmptyTopicLoaded.1
 * JD-Core Version:    0.7.0.1
 */