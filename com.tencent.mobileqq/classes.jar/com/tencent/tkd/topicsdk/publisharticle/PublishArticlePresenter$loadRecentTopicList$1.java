package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "<anonymous parameter 1>", "", "topicList", "", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePresenter$loadRecentTopicList$1
  extends Lambda
  implements Function3<Integer, String, List<? extends TweetTopicItem>, Unit>
{
  PublishArticlePresenter$loadRecentTopicList$1(PublishArticlePresenter paramPublishArticlePresenter)
  {
    super(3);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 1>");
    if ((paramInt == 0) && (paramList != null)) {
      ThreadManagerKt.a((Function0)new PublishArticlePresenter.loadRecentTopicList.1.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter.loadRecentTopicList.1
 * JD-Core Version:    0.7.0.1
 */