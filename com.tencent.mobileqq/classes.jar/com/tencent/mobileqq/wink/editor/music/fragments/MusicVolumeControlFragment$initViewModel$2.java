package com.tencent.mobileqq.wink.editor.music.fragments;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class MusicVolumeControlFragment$initViewModel$2<T>
  implements Observer<MusicInfoWrapper>
{
  MusicVolumeControlFragment$initViewModel$2(MusicVolumeControlFragment paramMusicVolumeControlFragment) {}
  
  public final void a(MusicInfoWrapper paramMusicInfoWrapper)
  {
    if (MusicVolumeControlFragment.c(this.a) == Scene.CAMERA)
    {
      MusicVolumeControlViewModel localMusicVolumeControlViewModel = MusicVolumeControlFragment.a(this.a);
      WinkEditorMusicInfo localWinkEditorMusicInfo = paramMusicInfoWrapper.b();
      boolean bool2 = true;
      boolean bool1;
      if (localWinkEditorMusicInfo == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localMusicVolumeControlViewModel.d(bool1);
      localMusicVolumeControlViewModel = MusicVolumeControlFragment.a(this.a);
      if (paramMusicInfoWrapper.b() != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localMusicVolumeControlViewModel.b(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment.initViewModel.2
 * JD-Core Version:    0.7.0.1
 */