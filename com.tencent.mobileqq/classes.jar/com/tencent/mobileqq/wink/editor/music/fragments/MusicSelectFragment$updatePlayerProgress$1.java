package com.tencent.mobileqq.wink.editor.music.fragments;

import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MusicSelectFragment$updatePlayerProgress$1
  implements Runnable
{
  MusicSelectFragment$updatePlayerProgress$1(MusicSelectFragment paramMusicSelectFragment, long paramLong) {}
  
  public final void run()
  {
    WinkEditorMusicControlPanel localWinkEditorMusicControlPanel = (WinkEditorMusicControlPanel)this.this$0.a(2131450175);
    if (localWinkEditorMusicControlPanel != null) {
      localWinkEditorMusicControlPanel.b((int)(this.a / 1000), (int)MusicSelectFragment.a(this.this$0).g());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.updatePlayerProgress.1
 * JD-Core Version:    0.7.0.1
 */