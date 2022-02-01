package com.tencent.mobileqq.wink.editor.music.fragments;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "t", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "onChanged"}, k=3, mv={1, 1, 16})
final class MusicSelectFragment$onViewCreated$1<T>
  implements Observer<List<? extends WinkEditorMusicInfo>>
{
  MusicSelectFragment$onViewCreated$1(MusicSelectFragment paramMusicSelectFragment) {}
  
  public final void a(@Nullable List<? extends WinkEditorMusicInfo> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        WinkEditorMusicInfo localWinkEditorMusicInfo = (WinkEditorMusicInfo)localObject;
        int i;
        if ((localWinkEditorMusicInfo.c) && (localWinkEditorMusicInfo.f != 3) && (MusicSelectFragment.a(this.a).e() != WinkEditorViewModel.EditMode.Image)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label88;
        }
      }
      Object localObject = null;
      label88:
      if ((WinkEditorMusicInfo)localObject != null) {
        ((WinkEditorMusicControlPanel)this.a.a(2131450175)).setClipEntranceVisible(true);
      } else {
        ((WinkEditorMusicControlPanel)this.a.a(2131450175)).setClipEntranceVisible(false);
      }
      if (MusicSelectFragment.a(this.a).e() != WinkEditorViewModel.EditMode.Image) {
        ((WinkEditorMusicControlPanel)this.a.a(2131450175)).setMusicDisableEnable(true);
      } else {
        ((WinkEditorMusicControlPanel)this.a.a(2131450175)).setMusicDisableEnable(false);
      }
      ((WinkEditorMusicControlPanel)this.a.a(2131450175)).a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.onViewCreated.1
 * JD-Core Version:    0.7.0.1
 */