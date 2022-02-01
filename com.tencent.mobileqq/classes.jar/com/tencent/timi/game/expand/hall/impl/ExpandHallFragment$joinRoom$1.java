package com.tencent.timi.game.expand.hall.impl;

import android.app.Activity;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandHallFragment$joinRoom$1
  implements Runnable
{
  ExpandHallFragment$joinRoom$1(ExpandHallFragment paramExpandHallFragment, ExpandHallFragment.joinRoom.joinListener.1 param1) {}
  
  public final void run()
  {
    ExpandHallFragment.a(this.this$0, (Runnable)null);
    if ((ExpandHallFragment.e(this.this$0) != 3L) && (ExpandHallFragment.e(this.this$0) != 4L))
    {
      Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(ExpandHallFragment.b(this.this$0).i);
      if (localObject != null)
      {
        localObject = ((IRoomGetDataService)localObject).b();
        if (localObject != null)
        {
          this.a.a((YoloRoomOuterClass.YoloRoomInfo)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("joinRoom#from room:");
          ((StringBuilder)localObject).append(ExpandHallFragment.b(this.this$0).i);
          ((StringBuilder)localObject).append(" already exits!");
          Logger.a("ExpandHallFragment_", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(false, (Activity)this.this$0.getQBaseActivity(), ExpandHallFragment.b(this.this$0).i, 2, 1, 5, 0, 0, null, false, GuildShequnParams.a(ExpandHallFragment.b(this.this$0)), 0L, (IResultListener)this.a);
      return;
    }
    Logger.c("ExpandHallFragment_", 1, "already destroyed, give up mDelayJoinRoomTask");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.joinRoom.1
 * JD-Core Version:    0.7.0.1
 */