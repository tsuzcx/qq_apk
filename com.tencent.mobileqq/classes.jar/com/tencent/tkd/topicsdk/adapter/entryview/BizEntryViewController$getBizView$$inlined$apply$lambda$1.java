package com.tencent.tkd.topicsdk.adapter.entryview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/tkd/topicsdk/adapter/entryview/BizEntryViewController$getBizView$1$1"}, k=3, mv={1, 1, 16})
final class BizEntryViewController$getBizView$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  BizEntryViewController$getBizView$$inlined$apply$lambda$1(ImageView paramImageView, BizEntryViewController paramBizEntryViewController, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public final void onClick(View paramView)
  {
    paramView = BizEntryViewController.a(this.b);
    Context localContext = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramView.a(localContext, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.entryview.BizEntryViewController.getBizView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */