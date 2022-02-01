package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.DraftArticleInfo;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.mediaselector.PanelType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initBottomSelectorLayout$5
  extends Lambda
  implements Function1<PanelType, Unit>
{
  PublishArticlePage$initBottomSelectorLayout$5(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "it");
    Object localObject = PublishArticlePage.b(this.this$0);
    if (localObject != null)
    {
      localObject = ((DraftArticleInfo)localObject).getMediaType();
      if (localObject != null)
      {
        localObject = PublishArticlePage.a(this.this$0, (MediaType)localObject);
        break label41;
      }
    }
    localObject = null;
    label41:
    if (localObject == paramPanelType)
    {
      PublishArticlePage.b(this.this$0, true);
      if (PublishArticlePage.b(this.this$0)) {
        PublishArticlePage.c(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initBottomSelectorLayout.5
 * JD-Core Version:    0.7.0.1
 */