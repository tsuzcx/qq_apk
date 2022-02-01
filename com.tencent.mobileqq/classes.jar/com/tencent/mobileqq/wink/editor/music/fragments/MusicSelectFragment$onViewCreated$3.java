package com.tencent.mobileqq.wink.editor.music.fragments;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class MusicSelectFragment$onViewCreated$3<T>
  implements Observer<MusicInfoWrapper>
{
  MusicSelectFragment$onViewCreated$3(MusicSelectFragment paramMusicSelectFragment) {}
  
  public final void a(MusicInfoWrapper paramMusicInfoWrapper)
  {
    paramMusicInfoWrapper = MusicSelectFragment.b(this.a);
    if (paramMusicInfoWrapper != null) {
      paramMusicInfoWrapper.a(0);
    }
    paramMusicInfoWrapper = MusicSelectFragment.b(this.a);
    if (paramMusicInfoWrapper != null) {
      paramMusicInfoWrapper.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.onViewCreated.3
 * JD-Core Version:    0.7.0.1
 */