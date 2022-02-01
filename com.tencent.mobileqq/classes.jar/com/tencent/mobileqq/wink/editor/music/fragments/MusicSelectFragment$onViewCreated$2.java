package com.tencent.mobileqq.wink.editor.music.fragments;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "t", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k=3, mv={1, 1, 16})
final class MusicSelectFragment$onViewCreated$2<T>
  implements Observer<Integer>
{
  MusicSelectFragment$onViewCreated$2(MusicSelectFragment paramMusicSelectFragment) {}
  
  public final void a(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      int i = ((Number)paramInteger).intValue();
      ((WinkEditorMusicControlPanel)this.a.a(2131450175)).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.onViewCreated.2
 * JD-Core Version:    0.7.0.1
 */