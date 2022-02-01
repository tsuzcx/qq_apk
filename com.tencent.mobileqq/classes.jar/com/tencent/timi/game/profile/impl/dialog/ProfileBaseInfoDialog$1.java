package com.tencent.timi.game.profile.impl.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileBaseInfoDialog$1
  implements View.OnClickListener
{
  public void onClick(@Nullable View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileBaseInfoDialog.1
 * JD-Core Version:    0.7.0.1
 */