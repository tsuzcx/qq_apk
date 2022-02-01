package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.DraftArticleInfo;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$restoredDraftArticleInfo$2
  extends Lambda
  implements Function0<DraftArticleInfo>
{
  PublishArticlePage$restoredDraftArticleInfo$2(PublishArticlePage paramPublishArticlePage)
  {
    super(0);
  }
  
  @Nullable
  public final DraftArticleInfo invoke()
  {
    return DraftManager.a.a().a(PublishArticlePage.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.restoredDraftArticleInfo.2
 * JD-Core Version:    0.7.0.1
 */