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
    if (paramPanelType == PanelType.EMOJI)
    {
      localObject = this.this$0;
      BottomSelectorLayout.a((BottomSelectorLayout)localObject, ((BottomSelectorLayout)localObject).getTranslationY(), BottomSelectorLayout.a(this.this$0, paramPanelType), false, 4, null);
    }
    else if ((paramPanelType == PanelType.PHOTO) || (paramPanelType == PanelType.VIDEO))
    {
      if (this.this$0.getTranslationY() >= BottomSelectorLayout.b(this.this$0) - this.this$0.getSelectorBarHeight())
      {
        localObject = this.this$0;
        BottomSelectorLayout.a((BottomSelectorLayout)localObject, ((BottomSelectorLayout)localObject).getTranslationY(), BottomSelectorLayout.a(this.this$0, paramPanelType), false, 4, null);
      }
      else
      {
        paramPanelType = this.this$0;
        BottomSelectorLayout.a(paramPanelType, paramPanelType.getTranslationY(), 0.0F, false, 4, null);
      }
    }
    paramPanelType = InputMethodUtils.a;
    Object localObject = this.this$0.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    IBinder localIBinder = this.this$0.getWindowToken();
    Intrinsics.checkExpressionValueIsNotNull(localIBinder, "windowToken");
    paramPanelType.a((Context)localObject, localIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.onAttachedToWindow.2
 * JD-Core Version:    0.7.0.1
 */