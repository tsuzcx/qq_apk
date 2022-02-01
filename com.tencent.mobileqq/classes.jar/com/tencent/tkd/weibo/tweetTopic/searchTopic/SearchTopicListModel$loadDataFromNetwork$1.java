package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.Collection;
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
final class SearchTopicListModel$loadDataFromNetwork$1
  extends Lambda
  implements Function5<Integer, String, byte[], Boolean, List<? extends TweetTopicItem>, Unit>
{
  SearchTopicListModel$loadDataFromNetwork$1(SearchTopicListModel paramSearchTopicListModel, Function7 paramFunction7)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    if (paramInt == 0)
    {
      paramString = (Collection)paramList;
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        SearchTopicListModel.a(this.this$0, paramList, this.$callback, paramBoolean, paramArrayOfByte);
        return;
      }
      SearchTopicListModel.a(this.this$0, this.$callback);
      return;
    }
    SearchTopicListModel.a(this.this$0, this.$callback, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel.loadDataFromNetwork.1
 * JD-Core Version:    0.7.0.1
 */