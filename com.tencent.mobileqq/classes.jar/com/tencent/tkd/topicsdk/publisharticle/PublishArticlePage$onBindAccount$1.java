package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$onBindAccount$1
  extends Lambda
  implements Function1<PublishArticleInfo, Unit>
{
  PublishArticlePage$onBindAccount$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    PublishArticlePage.a(this.this$0, paramPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.onBindAccount.1
 * JD-Core Version:    0.7.0.1
 */