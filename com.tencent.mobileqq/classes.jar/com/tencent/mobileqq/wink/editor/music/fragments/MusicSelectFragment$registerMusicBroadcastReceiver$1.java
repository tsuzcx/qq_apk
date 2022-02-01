package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.WebCallback;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$registerMusicBroadcastReceiver$1", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$WebCallback;", "onWebCallback", "", "musicInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicSelectFragment$registerMusicBroadcastReceiver$1
  implements MusicSourceViewModel.WebCallback
{
  public void a(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "musicInfo");
    Intent localIntent = new Intent();
    localIntent.setAction("action_dispatch_music_event");
    localIntent.putExtra("event", "KTribeDownloadMusicSuccessWhenMediaPlay");
    localIntent.putExtra("cacheMusicMid", paramWinkEditorMusicInfo.c());
    paramWinkEditorMusicInfo = this.a.getActivity();
    if (paramWinkEditorMusicInfo != null) {
      paramWinkEditorMusicInfo.sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.registerMusicBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */