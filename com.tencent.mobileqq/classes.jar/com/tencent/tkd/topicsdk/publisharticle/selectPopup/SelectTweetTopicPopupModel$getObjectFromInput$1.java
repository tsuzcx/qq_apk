package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "topicList", "", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class SelectTweetTopicPopupModel$getObjectFromInput$1
  extends Lambda
  implements Function4<Integer, String, Boolean, List<? extends TweetTopicItem>, Unit>
{
  SelectTweetTopicPopupModel$getObjectFromInput$1(SelectTweetTopicPopupModel paramSelectTweetTopicPopupModel, String paramString, Function1 paramFunction1)
  {
    super(4);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, boolean paramBoolean, @Nullable List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 1>");
    if ((paramInt == 0) && (paramList != null) && ((((Collection)paramList).isEmpty() ^ true)) && (Intrinsics.areEqual(((TweetTopicItem)paramList.get(0)).c(), this.$wording)))
    {
      this.$callback.invoke(Integer.valueOf(1));
      paramString = (Map)SelectTweetTopicPopupModel.a(this.this$0);
      String str = this.$wording;
      paramList = paramList.get(0);
      TweetTopicItem localTweetTopicItem = (TweetTopicItem)paramList;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('#');
      localStringBuilder.append(this.$wording);
      localTweetTopicItem.c(localStringBuilder.toString());
      paramString.put(str, paramList);
      return;
    }
    paramString = new TweetTopicItem(null, null, null, 0L, null, 31, null);
    paramList = new StringBuilder();
    paramList.append('#');
    paramList.append(this.$wording);
    paramString.c(paramList.toString());
    this.$callback.invoke(Integer.valueOf(2));
    ((Map)SelectTweetTopicPopupModel.a(this.this$0)).put(this.$wording, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectTweetTopicPopupModel.getObjectFromInput.1
 * JD-Core Version:    0.7.0.1
 */