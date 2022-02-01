package com.tencent.timi.game.expand.hall.impl.gm;

import android.content.Context;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/timi/game/expand/hall/impl/gm/ExpandHallGMManager$itemClickListener$1$onItemClick$1$1"}, k=3, mv={1, 1, 16})
final class ExpandHallGMManager$itemClickListener$1$onItemClick$$inlined$let$lambda$1
  implements Runnable
{
  ExpandHallGMManager$itemClickListener$1$onItemClick$$inlined$let$lambda$1(ExpandHallLaunchParam paramExpandHallLaunchParam, ExpandHallGMManager.itemClickListener.1 param1, long paramLong, Context paramContext) {}
  
  public final void run()
  {
    String str = ExpandHallGMManager.a(this.this$0.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("itemClickListener ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.c);
    Logger.a(str, localStringBuilder.toString());
    ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a(this.c, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.ExpandHallGMManager.itemClickListener.1.onItemClick..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */