package com.tencent.timi.game.ui;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/ViewStateChangeListener;", "", "onHide", "", "view", "Landroid/view/View;", "onShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ViewStateChangeListener
{
  public abstract void a(@NotNull View paramView);
  
  public abstract void b(@NotNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.ViewStateChangeListener
 * JD-Core Version:    0.7.0.1
 */