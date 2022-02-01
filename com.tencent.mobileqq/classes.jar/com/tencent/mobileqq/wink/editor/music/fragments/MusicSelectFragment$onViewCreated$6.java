package com.tencent.mobileqq.wink.editor.music.fragments;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class MusicSelectFragment$onViewCreated$6<T>
  implements Observer<Boolean>
{
  MusicSelectFragment$onViewCreated$6(MusicSelectFragment paramMusicSelectFragment) {}
  
  public final void a(Boolean paramBoolean)
  {
    Object localObject = MusicSelectFragment.d(this.a);
    if (localObject != null) {
      localObject = Boolean.valueOf(((MusicSelectFragment.MenuInfoDelegate)localObject).getHasTemplate());
    } else {
      localObject = paramBoolean;
    }
    if ((!((Boolean)localObject).booleanValue()) && (!paramBoolean.booleanValue()))
    {
      paramBoolean = (WinkEditorMusicControlPanel)this.a.a(2131450175);
      if (paramBoolean != null) {
        paramBoolean.setEnableMusic(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.onViewCreated.6
 * JD-Core Version:    0.7.0.1
 */