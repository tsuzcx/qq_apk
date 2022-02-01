package com.tencent.timi.game.profile.api.listener;

import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/api/listener/CommunityClickListener;", "", "onAtClick", "", "profileDialog", "Lcom/tencent/timi/game/profile/api/ui/ProfileDialog;", "onGiveGiftClick", "onKaiHeiClick", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface CommunityClickListener
{
  public abstract void a();
  
  public abstract void a(@NotNull ProfileDialog paramProfileDialog);
  
  public abstract void b(@NotNull ProfileDialog paramProfileDialog);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.api.listener.CommunityClickListener
 * JD-Core Version:    0.7.0.1
 */