package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Float;)V"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initMusicVolumeViewModel$2<T>
  implements Observer<Float>
{
  WinkEditorFragment$initMusicVolumeViewModel$2(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(Float paramFloat)
  {
    if (WinkEditorFragment.q(this.a).f() == MusicVolumeControlViewModel.VolumeType.TEMPLATE)
    {
      localObject = WinkEditorFragment.i(this.a);
      Intrinsics.checkExpressionValueIsNotNull(paramFloat, "it");
      ((WinkEditorTemplateViewModel)localObject).a(paramFloat.floatValue());
      return;
    }
    Object localObject = WinkEditorFragment.d(this.a);
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramFloat, "it");
      ((WinkTavCutDelegate)localObject).a(paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initMusicVolumeViewModel.2
 * JD-Core Version:    0.7.0.1
 */