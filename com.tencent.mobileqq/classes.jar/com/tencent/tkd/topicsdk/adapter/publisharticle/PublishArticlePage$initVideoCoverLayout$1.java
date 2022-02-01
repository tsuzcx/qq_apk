package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import android.content.Context;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.videoprocess.videopreview.VideoPreviewPage;
import com.tencent.tkd.topicsdk.videoprocess.videopreview.VideoPreviewPage.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initVideoCoverLayout$1
  extends Lambda
  implements Function1<DisplayItem, Unit>
{
  PublishArticlePage$initVideoCoverLayout$1(Activity paramActivity)
  {
    super(1);
  }
  
  public final void invoke(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "item");
    VideoPreviewPage.a.a((Context)this.$activity, paramDisplayItem.getRealPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initVideoCoverLayout.1
 * JD-Core Version:    0.7.0.1
 */