package com.tencent.mobileqq.wink.editor.music.fragments;

import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog.WinkOperationCallback;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$onViewCreated$5", "Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkLyricPanelDialog$WinkOperationCallback;", "onClickCancelBtn", "", "onClickConfirmBtn", "onIndicatorDragged", "videoClipPosition", "", "onMusicWaveMoveEnd", "isDragging", "", "onMusicWaveMoveStart", "onMusicWaveMoving", "startTimeInMs", "endTimeInMs", "onResetMusicRangeToRecommend", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicSelectFragment$onViewCreated$5
  implements WinkLyricPanelDialog.WinkOperationCallback
{
  public void onClickCancelBtn()
  {
    MusicSelectFragment.a(this.a).v();
    MusicSelectFragment.a(this.a).a(null, null);
  }
  
  public void onClickConfirmBtn()
  {
    MusicSelectFragment.a(this.a).l();
    MusicSelectFragment.a(this.a).s();
    MusicSelectFragment.a(this.a).a(null, null);
  }
  
  public void onIndicatorDragged(int paramInt)
  {
    MusicSelectFragment.PlayerControlCallback localPlayerControlCallback = MusicSelectFragment.b(this.a);
    if (localPlayerControlCallback != null) {
      localPlayerControlCallback.a(paramInt);
    }
  }
  
  public void onMusicWaveMoveEnd(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localPlayerControlCallback = MusicSelectFragment.b(this.a);
      if (localPlayerControlCallback != null) {
        localPlayerControlCallback.b();
      }
      return;
    }
    MusicSelectFragment.a(this.a).w();
    MusicSelectFragment.PlayerControlCallback localPlayerControlCallback = MusicSelectFragment.b(this.a);
    if (localPlayerControlCallback != null) {
      localPlayerControlCallback.b();
    }
  }
  
  public void onMusicWaveMoveStart()
  {
    MusicSelectFragment.PlayerControlCallback localPlayerControlCallback = MusicSelectFragment.b(this.a);
    if (localPlayerControlCallback != null) {
      localPlayerControlCallback.a();
    }
  }
  
  public void onMusicWaveMoving(int paramInt1, int paramInt2)
  {
    ((WinkEditorMusicControlPanel)this.a.a(2131450175)).a(paramInt1, paramInt2);
    MusicSelectFragment.a(this.a).a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void onResetMusicRangeToRecommend(int paramInt)
  {
    MusicSelectFragment.a(this.a).x();
    int i = (int)(paramInt + MusicSelectFragment.a(this.a).g());
    ((WinkEditorMusicControlPanel)this.a.a(2131450175)).b(paramInt);
    ((WinkEditorMusicControlPanel)this.a.a(2131450175)).a(paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.onViewCreated.5
 * JD-Core Version:    0.7.0.1
 */