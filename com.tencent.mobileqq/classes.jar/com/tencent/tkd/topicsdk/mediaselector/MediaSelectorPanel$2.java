package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MediaSelectorPanel$2
  extends Lambda
  implements Function4<AdapterView<?>, View, Integer, Long, Unit>
{
  MediaSelectorPanel$2(MediaSelectorPanel paramMediaSelectorPanel)
  {
    super(4);
  }
  
  public final void invoke(@NotNull AdapterView<?> paramAdapterView, @NotNull View paramView, int paramInt, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramAdapterView, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramView, "<anonymous parameter 1>");
    paramAdapterView = this.this$0.getOnItemClickListener();
    if (paramAdapterView != null) {
      paramAdapterView = (Unit)paramAdapterView.invoke(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.2
 * JD-Core Version:    0.7.0.1
 */