package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$buildPublishArticleInfo$1
  extends Lambda
  implements Function0<Unit>
{
  PublishArticlePage$buildPublishArticleInfo$1(PublishArticleInfo paramPublishArticleInfo, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$publishArticleInfo.updateImageWH(this.$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.buildPublishArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */