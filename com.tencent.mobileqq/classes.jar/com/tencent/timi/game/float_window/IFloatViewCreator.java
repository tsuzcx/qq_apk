package com.tencent.timi.game.float_window;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/IFloatViewCreator;", "", "createFloatView", "Lcom/tencent/timi/game/float_window/IFloatView;", "roomId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IFloatViewCreator
{
  @Nullable
  public abstract IFloatView a(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.IFloatViewCreator
 * JD-Core Version:    0.7.0.1
 */