package com.tencent.timi.game.team.impl.team;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class FleetProfileUtil$kickOutPlayer$1
  implements DialogInterface.OnClickListener
{
  FleetProfileUtil$kickOutPlayer$1(long paramLong1, long paramLong2, FleetProfileUtil.KickOutListener paramKickOutListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.a).a(this.b, false, (IResultListener)new FleetProfileUtil.kickOutPlayer.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.FleetProfileUtil.kickOutPlayer.1
 * JD-Core Version:    0.7.0.1
 */