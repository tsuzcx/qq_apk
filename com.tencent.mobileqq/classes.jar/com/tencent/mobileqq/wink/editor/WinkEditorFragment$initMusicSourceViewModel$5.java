package com.tencent.mobileqq.wink.editor;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "imageMusicInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initMusicSourceViewModel$5<T>
  implements Observer<WinkEditorMusicInfo>
{
  WinkEditorFragment$initMusicSourceViewModel$5(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    Object localObject = WinkEditorFragment.r(this.a);
    if (localObject != null) {
      ((MediaPlayer)localObject).stop();
    }
    localObject = WinkEditorFragment.r(this.a);
    if (localObject != null) {
      ((MediaPlayer)localObject).reset();
    }
    boolean bool;
    if (paramWinkEditorMusicInfo != null)
    {
      localObject = WinkEditorMusicHelper.a(paramWinkEditorMusicInfo);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "WinkEditorMusicHelper.ge…MusicPath(imageMusicInfo)");
      bool = WinkEditorMusicHelper.a((String)localObject);
    }
    else
    {
      localObject = "";
      bool = false;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (bool) && (!this.a.isHidden()))
    {
      MediaPlayer localMediaPlayer = WinkEditorFragment.r(this.a);
      if (localMediaPlayer != null)
      {
        localMediaPlayer.setAudioStreamType(3);
        localMediaPlayer.setDataSource((String)localObject);
        localMediaPlayer.setVolume(0.5F, 0.5F);
        localMediaPlayer.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener)WinkEditorFragment.initMusicSourceViewModel.5.1.1.a);
        localMediaPlayer.prepare();
        Intrinsics.checkExpressionValueIsNotNull(paramWinkEditorMusicInfo, "imageMusicInfo");
        localMediaPlayer.seekTo(paramWinkEditorMusicInfo.g());
        localMediaPlayer.setLooping(true);
        localMediaPlayer.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initMusicSourceViewModel.5
 * JD-Core Version:    0.7.0.1
 */