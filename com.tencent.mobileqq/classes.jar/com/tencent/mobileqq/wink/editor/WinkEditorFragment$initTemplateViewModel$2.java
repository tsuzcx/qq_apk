package com.tencent.mobileqq.wink.editor;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel.UpdateTemplateAction;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateAction;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initTemplateViewModel$2<T>
  implements Observer<WinkEditorTemplateViewModel.UpdateTemplateAction>
{
  WinkEditorFragment$initTemplateViewModel$2(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(WinkEditorTemplateViewModel.UpdateTemplateAction paramUpdateTemplateAction)
  {
    if ((paramUpdateTemplateAction != null) && (!TextUtils.isEmpty((CharSequence)paramUpdateTemplateAction.f())))
    {
      WinkEditorFragment.e(this.a).a(WinkEditorMusicInfo.b, 1, false);
      WinkEditorFragment.e(this.a).d().postValue(Boolean.valueOf(true));
      return;
    }
    WinkEditorFragment.e(this.a).m();
    WinkEditorFragment.e(this.a).d().postValue(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initTemplateViewModel.2
 * JD-Core Version:    0.7.0.1
 */