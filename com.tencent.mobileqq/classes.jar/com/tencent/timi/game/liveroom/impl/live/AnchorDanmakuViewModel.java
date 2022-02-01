package com.tencent.timi.game.liveroom.impl.live;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/AnchorDanmakuViewModel;", "", "()V", "danmakuChoosePanelLiveData", "Landroidx/lifecycle/LiveData;", "", "getDanmakuChoosePanelLiveData", "()Landroidx/lifecycle/LiveData;", "danmakuShowType", "", "danmakuTypeChooseLiveData", "Landroidx/lifecycle/MutableLiveData;", "inputBoxOpen", "isGameLiveVisible", "showType", "getShowType", "()I", "isSpecialDanmaku", "onTextSend", "", "setDanmakuShowType", "setGameLiveVisible", "visible", "setInputBoxOpen", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorDanmakuViewModel
{
  public static final AnchorDanmakuViewModel a = new AnchorDanmakuViewModel();
  private static final MutableLiveData<Boolean> b = new MutableLiveData();
  
  @NotNull
  public final LiveData<Boolean> a()
  {
    return (LiveData)b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.AnchorDanmakuViewModel
 * JD-Core Version:    0.7.0.1
 */