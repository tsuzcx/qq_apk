package com.tencent.mobileqq.kandian.repo.handler;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toTopicInfo", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "toTweetTopicItem", "context", "Landroid/content/Context;", "toTweetTopicList", "", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class TopicInfoExFunctionKt
{
  @NotNull
  public static final TopicInfo a(@NotNull TweetTopicItem paramTweetTopicItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTweetTopicItem, "$this$toTopicInfo");
    paramTweetTopicItem = TopicInfo.g().a(Long.parseLong(paramTweetTopicItem.a())).c(paramTweetTopicItem.b()).a(paramTweetTopicItem.c()).c(paramTweetTopicItem.d()).b(paramTweetTopicItem.f()).a();
    Intrinsics.checkExpressionValueIsNotNull(paramTweetTopicItem, "TopicInfo.newBuilder()\n …Num)\n            .build()");
    return paramTweetTopicItem;
  }
  
  @NotNull
  public static final TweetTopicItem a(@NotNull TopicInfo paramTopicInfo, @NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "$this$toTweetTopicItem");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    TweetTopicItem localTweetTopicItem = new TweetTopicItem(null, null, null, 0L, null, 0L, null, 127, null);
    localTweetTopicItem.a(String.valueOf(paramTopicInfo.a()));
    String str = paramTopicInfo.b();
    Intrinsics.checkExpressionValueIsNotNull(str, "topicTitle");
    localTweetTopicItem.c(str);
    str = paramTopicInfo.c();
    Intrinsics.checkExpressionValueIsNotNull(str, "topicCoverUrl");
    localTweetTopicItem.b(str);
    localTweetTopicItem.a(paramTopicInfo.e());
    localTweetTopicItem.b(paramTopicInfo.f());
    paramTopicInfo = paramContext.getResources().getString(2131915366);
    Intrinsics.checkExpressionValueIsNotNull(paramTopicInfo, "context.resources.getStr…ng.readinjoy_discuss_str)");
    localTweetTopicItem.d(paramTopicInfo);
    paramTopicInfo = paramContext.getResources().getString(2131915483);
    Intrinsics.checkExpressionValueIsNotNull(paramTopicInfo, "context.resources.getStr…ng.readinjoy_reading_str)");
    localTweetTopicItem.e(paramTopicInfo);
    return localTweetTopicItem;
  }
  
  @NotNull
  public static final List<TweetTopicItem> a(@NotNull List<TopicInfo> paramList, @NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toTweetTopicList");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((TopicInfo)paramList.next(), paramContext));
    }
    return (List)localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.TopicInfoExFunctionKt
 * JD-Core Version:    0.7.0.1
 */