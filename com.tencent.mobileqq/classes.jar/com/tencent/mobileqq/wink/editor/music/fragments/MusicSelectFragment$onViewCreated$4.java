package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.OperationCallback;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$onViewCreated$4", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicPanel$OperationCallback;", "onClickMusicCutBtn", "", "enableMusicCut", "", "onClickSearchBox", "onEnableBgm", "isEnabled", "onMusicSelected", "selectedMusicInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "position", "", "onOriginSoundSwitch", "isOn", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicSelectFragment$onViewCreated$4
  implements WinkEditorMusicPanel.OperationCallback
{
  public void a()
  {
    Object localObject = MusicSelectFragment.c(this.a);
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      WinkEditorMusicHelper.a((Context)localFragmentActivity, "", (Intent)localObject);
    }
    localObject = MusicSelectFragment.b(this.a);
    if (localObject != null) {
      ((MusicSelectFragment.PlayerControlCallback)localObject).a();
    }
  }
  
  public void a(@Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt)
  {
    if (paramWinkEditorMusicInfo != null)
    {
      if (paramWinkEditorMusicInfo.a()) {
        return;
      }
      MusicSelectFragment.a(this.a).a(paramWinkEditorMusicInfo, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      MusicSelectFragment.a(this.a).t();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    WinkEditorMusicInfo localWinkEditorMusicInfo = MusicSelectFragment.a(this.a).h();
    if (localWinkEditorMusicInfo != null)
    {
      WinkEditorMusicControlPanel localWinkEditorMusicControlPanel = (WinkEditorMusicControlPanel)this.a.a(2131450175);
      MusicSourceViewModel localMusicSourceViewModel = MusicSelectFragment.a(this.a);
      String str = localWinkEditorMusicInfo.c();
      Intrinsics.checkExpressionValueIsNotNull(str, "it.getSongMid()");
      localWinkEditorMusicControlPanel.a(localWinkEditorMusicInfo, localMusicSourceViewModel.a(str), MusicSelectFragment.a(this.a).g(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.onViewCreated.4
 * JD-Core Version:    0.7.0.1
 */