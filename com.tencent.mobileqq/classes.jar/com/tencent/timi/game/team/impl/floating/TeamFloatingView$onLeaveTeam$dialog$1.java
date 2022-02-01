package com.tencent.timi.game.team.impl.floating;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class TeamFloatingView$onLeaveTeam$dialog$1
  implements DialogInterface.OnClickListener
{
  TeamFloatingView$onLeaveTeam$dialog$1(TeamFloatingView paramTeamFloatingView, Ref.ObjectRef paramObjectRef) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setVisibility(4);
    TeamUtil.a(this.a.getRoomId(), (Activity)this.b.element, (IResultListener)new TeamFloatingView.onLeaveTeam.dialog.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingView.onLeaveTeam.dialog.1
 * JD-Core Version:    0.7.0.1
 */