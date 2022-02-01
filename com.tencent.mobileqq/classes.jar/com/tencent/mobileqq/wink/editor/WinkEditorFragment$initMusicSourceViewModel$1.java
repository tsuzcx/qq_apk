package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initMusicSourceViewModel$1<T>
  implements Observer<MusicInfoWrapper>
{
  WinkEditorFragment$initMusicSourceViewModel$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(MusicInfoWrapper paramMusicInfoWrapper)
  {
    if (paramMusicInfoWrapper.b() == null)
    {
      paramMusicInfoWrapper = WinkEditorFragment.d(this.a);
      if (paramMusicInfoWrapper != null) {
        paramMusicInfoWrapper.a(null);
      }
      WinkEditorFragment.q(this.a).b(false);
      return;
    }
    WinkTavCutDelegate localWinkTavCutDelegate = WinkEditorFragment.d(this.a);
    if (localWinkTavCutDelegate != null) {
      localWinkTavCutDelegate.a(paramMusicInfoWrapper.a());
    }
    WinkEditorFragment.q(this.a).b(true);
    paramMusicInfoWrapper = WinkEditorFragment.e(this.a);
    localWinkTavCutDelegate = WinkEditorFragment.d(this.a);
    long l;
    if (localWinkTavCutDelegate != null) {
      l = localWinkTavCutDelegate.e();
    } else {
      l = 0L;
    }
    paramMusicInfoWrapper.a(l / 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initMusicSourceViewModel.1
 * JD-Core Version:    0.7.0.1
 */