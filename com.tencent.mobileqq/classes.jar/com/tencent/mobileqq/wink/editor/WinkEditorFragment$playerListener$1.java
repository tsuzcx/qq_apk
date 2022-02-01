package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.editor.music.TimeUtils;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricProgressCalculator;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.tavcut.render.player.IPlayer.PlayerStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/WinkEditorFragment$playerListener$1", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerListener;", "onPlayerSourceReady", "", "iPlayer", "Lcom/tencent/tavcut/render/player/IPlayer;", "onPositionChanged", "l", "", "l1", "onStatusChanged", "playerStatus", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorFragment$playerListener$1
  implements IPlayer.PlayerListener
{
  public void a(long paramLong1, long paramLong2)
  {
    long l1 = 1000;
    long l2 = TimeUtils.b(paramLong1 / l1);
    if (WinkEditorFragment.e(this.a).h() != null) {
      WinkLyricProgressCalculator.a().a(l2, paramLong2 / l1);
    }
    WinkEditorFragment.c(this.a).i().postValue(Long.valueOf(paramLong1));
  }
  
  public void a(@Nullable IPlayer.PlayerStatus paramPlayerStatus, @NotNull IPlayer paramIPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "iPlayer");
  }
  
  public void a(@NotNull IPlayer paramIPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "iPlayer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.playerListener.1
 * JD-Core Version:    0.7.0.1
 */