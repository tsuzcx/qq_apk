package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.DisplayItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initVideoCoverLayout$2
  extends Lambda
  implements Function1<DisplayItem, Unit>
{
  PublishArticlePage$initVideoCoverLayout$2(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "item");
    this.this$0.a(paramDisplayItem, (Function1)new PublishArticlePage.initVideoCoverLayout.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initVideoCoverLayout.2
 * JD-Core Version:    0.7.0.1
 */