package com.tencent.mobileqq.vas.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGFlushListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class VasPagView$MyViewProxy$sucessedBuilder$1
  extends Lambda
  implements Function0<PAGView>
{
  VasPagView$MyViewProxy$sucessedBuilder$1(VasPagView.MyViewProxy paramMyViewProxy)
  {
    super(0);
  }
  
  @NotNull
  public final PAGView invoke()
  {
    PAGView localPAGView = new PAGView(this.this$0.a().getContext());
    localPAGView.addPAGFlushListener((PAGView.PAGFlushListener)VasPagView.MyViewProxy.sucessedBuilder.1.1.a);
    return localPAGView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView.MyViewProxy.sucessedBuilder.1
 * JD-Core Version:    0.7.0.1
 */