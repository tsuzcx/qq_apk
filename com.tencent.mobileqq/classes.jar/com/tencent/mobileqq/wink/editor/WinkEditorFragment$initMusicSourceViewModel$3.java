package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initMusicSourceViewModel$3<T>
  implements Observer<Boolean>
{
  WinkEditorFragment$initMusicSourceViewModel$3(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(Boolean paramBoolean)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "it");
    if (paramBoolean.booleanValue())
    {
      WinkEditorFragment.i(this.a).h();
      return;
    }
    WinkEditorFragment.i(this.a).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initMusicSourceViewModel.3
 * JD-Core Version:    0.7.0.1
 */