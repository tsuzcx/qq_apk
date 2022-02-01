package com.tencent.mobileqq.wink.editor.filter;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "durationUs", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Long;)V"}, k=3, mv={1, 1, 16})
final class WinkEditorFilterViewModel$durationObserver$1<T>
  implements Observer<Long>
{
  WinkEditorFilterViewModel$durationObserver$1(WinkEditorFilterViewModel paramWinkEditorFilterViewModel) {}
  
  public final void a(Long paramLong)
  {
    WinkEditorFilterViewModel localWinkEditorFilterViewModel = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramLong, "durationUs");
    WinkEditorFilterViewModel.a(localWinkEditorFilterViewModel, paramLong.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterViewModel.durationObserver.1
 * JD-Core Version:    0.7.0.1
 */