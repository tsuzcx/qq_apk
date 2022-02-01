package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.os.IBinder;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "invoke"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$onAttachedToWindow$2
  extends Lambda
  implements Function1<PanelType, Unit>
{
  BottomSelectorLayout$onAttachedToWindow$2(BottomSelectorLayout paramBottomSelectorLayout)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    if (paramPanelType == PanelType.EMOJI) {
      BottomSelectorLayout.a(this.this$0, this.this$0.getTranslationY(), BottomSelectorLayout.a(this.this$0, paramPanelType), false, 4, null);
    }
    for (;;)
    {
      paramPanelType = InputMethodUtils.a;
      Context localContext = this.this$0.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      IBinder localIBinder = this.this$0.getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localIBinder, "windowToken");
      paramPanelType.a(localContext, localIBinder);
      return;
      if ((paramPanelType == PanelType.PHOTO) || (paramPanelType == PanelType.VIDEO)) {
        if (this.this$0.getTranslationY() >= BottomSelectorLayout.a(this.this$0) - this.this$0.a()) {
          BottomSelectorLayout.a(this.this$0, this.this$0.getTranslationY(), BottomSelectorLayout.a(this.this$0, paramPanelType), false, 4, null);
        } else {
          BottomSelectorLayout.a(this.this$0, this.this$0.getTranslationY(), 0.0F, false, 4, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.onAttachedToWindow.2
 * JD-Core Version:    0.7.0.1
 */