package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickPanel", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "invoke"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$onAttachedToWindow$3
  extends Lambda
  implements Function1<PanelType, Unit>
{
  BottomSelectorLayout$onAttachedToWindow$3(BottomSelectorLayout paramBottomSelectorLayout)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "clickPanel");
    if (paramPanelType == PanelType.PHOTO)
    {
      paramPanelType = this.this$0.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "context");
      paramPanelType = paramPanelType.getResources().getString(R.string.v);
      Intrinsics.checkExpressionValueIsNotNull(paramPanelType, "context.resources.getStr…a_photo_item_disable_tip)");
      TopicSDKHelperKt.a(paramPanelType, false, null, 6, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.onAttachedToWindow.3
 * JD-Core Version:    0.7.0.1
 */