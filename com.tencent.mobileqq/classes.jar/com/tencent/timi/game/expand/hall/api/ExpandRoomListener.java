package com.tencent.timi.game.expand.hall.api;

import com.tencent.timi.game.expand.hall.api.data.GMChangeRoomInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/api/ExpandRoomListener;", "T", "Lcom/tencent/timi/game/utils/IResultListener;", "onGMInfoSuccess", "", "info", "Lcom/tencent/timi/game/expand/hall/api/data/GMChangeRoomInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ExpandRoomListener<T>
  extends IResultListener<T>
{
  public abstract void a(@Nullable GMChangeRoomInfo paramGMChangeRoomInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.api.ExpandRoomListener
 * JD-Core Version:    0.7.0.1
 */