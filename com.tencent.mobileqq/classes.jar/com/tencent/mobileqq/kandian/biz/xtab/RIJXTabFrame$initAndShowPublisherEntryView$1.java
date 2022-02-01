package com.tencent.mobileqq.kandian.biz.xtab;

import android.widget.FrameLayout;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.tkd.topicsdk.adapter.entryview.BizEntryViewController;
import com.tencent.tkd.topicsdk.entry.controller.IEntryViewController.DefaultImpls;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "id", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabFrame$initAndShowPublisherEntryView$1
  extends Lambda
  implements Function1<String, Unit>
{
  RIJXTabFrame$initAndShowPublisherEntryView$1(RIJXTabFrame paramRIJXTabFrame, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    String str = RIJXTabFrame.b(this.this$0);
    if (str != null) {
      RIJXTabFrame.c(this.this$0).c(str, null);
    }
    RIJXTabFrame.a(this.this$0, paramString);
    paramString = RIJXTabFrame.b(this.this$0);
    if (paramString != null) {
      if (this.this$0.g() == 0)
      {
        IEntryViewController.DefaultImpls.a(RIJXTabFrame.c(this.this$0), paramString, null, 2, null);
        RIJXTabFrame.d(this.this$0);
        if (RIJXTabFrame.a(this.this$0) == null)
        {
          paramString = new UgcPublishUserGuideController((FrameLayout)RIJXTabFrame.e(this.this$0), this.$tagWidgetHeight + LayoutAttrsKt.getDp(12));
          RIJXTabFrame.a(this.this$0, paramString);
        }
        paramString = RIJXTabFrame.a(this.this$0);
        if (paramString != null) {
          UgcPublishUserGuideController.a(paramString, null, 1, null);
        }
      }
      else
      {
        IEntryViewController.DefaultImpls.b(RIJXTabFrame.c(this.this$0), paramString, null, 2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initAndShowPublisherEntryView.1
 * JD-Core Version:    0.7.0.1
 */