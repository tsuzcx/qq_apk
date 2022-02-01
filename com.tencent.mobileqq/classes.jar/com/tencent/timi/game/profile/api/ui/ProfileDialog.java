package com.tencent.timi.game.profile.api.ui;

import android.content.Context;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/api/ui/ProfileDialog;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "acquireName", "", "setItemClickListener", "", "listener", "", "setReceiveVoiceState", "needShow", "", "isReceiveVoice", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class ProfileDialog
  extends BaseSlideUpDialog
{
  public ProfileDialog(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  @Nullable
  public abstract String a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.api.ui.ProfileDialog
 * JD-Core Version:    0.7.0.1
 */