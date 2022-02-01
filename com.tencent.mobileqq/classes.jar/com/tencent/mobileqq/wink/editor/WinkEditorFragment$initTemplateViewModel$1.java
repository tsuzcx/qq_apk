package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel.UpdateTemplateMusicAction;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateMusicAction;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initTemplateViewModel$1<T>
  implements Observer<WinkEditorTemplateViewModel.UpdateTemplateMusicAction>
{
  WinkEditorFragment$initTemplateViewModel$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(WinkEditorTemplateViewModel.UpdateTemplateMusicAction paramUpdateTemplateMusicAction)
  {
    if ((WinkEditorFragment.d(this.a) instanceof WinkVideoTavCut))
    {
      WinkEditorTemplateViewModel localWinkEditorTemplateViewModel = WinkEditorFragment.i(this.a);
      Object localObject = WinkEditorFragment.d(this.a);
      if (localObject != null)
      {
        localObject = (WinkVideoTavCut)localObject;
        Intrinsics.checkExpressionValueIsNotNull(paramUpdateTemplateMusicAction, "it");
        localWinkEditorTemplateViewModel.a(((WinkVideoTavCut)localObject).a(paramUpdateTemplateMusicAction));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initTemplateViewModel.1
 * JD-Core Version:    0.7.0.1
 */