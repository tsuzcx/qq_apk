package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Float;)V"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initMusicVolumeViewModel$1<T>
  implements Observer<Float>
{
  WinkEditorFragment$initMusicVolumeViewModel$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(Float paramFloat)
  {
    WinkTavCutDelegate localWinkTavCutDelegate = WinkEditorFragment.d(this.a);
    if (localWinkTavCutDelegate != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramFloat, "it");
      localWinkTavCutDelegate.b(paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initMusicVolumeViewModel.1
 * JD-Core Version:    0.7.0.1
 */