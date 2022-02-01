package com.tencent.timi.game.expand.hall.impl.gm;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.RecommendProxyOuterClass.KuolieRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/gm/ExpandHallGMManager$itemClickListener$1", "Lcom/tencent/timi/game/expand/hall/impl/gm/GMChangeRoomOperateDialog$ItemClickListener;", "onItemClick", "", "info", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "context", "Landroid/content/Context;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallGMManager$itemClickListener$1
  implements GMChangeRoomOperateDialog.ItemClickListener
{
  public void a(@NotNull RecommendProxyOuterClass.KuolieRoomInfo paramKuolieRoomInfo, @NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramKuolieRoomInfo, "info");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    long l = paramKuolieRoomInfo.room_id.get();
    paramKuolieRoomInfo = ExpandHallGMManager.b(this.a);
    if (paramKuolieRoomInfo != null) {
      paramKuolieRoomInfo.i = l;
    }
    paramKuolieRoomInfo = ExpandHallGMManager.b(this.a);
    if (paramKuolieRoomInfo != null) {
      paramKuolieRoomInfo.j = true;
    }
    paramKuolieRoomInfo = ExpandHallGMManager.b(this.a);
    if (paramKuolieRoomInfo != null)
    {
      String str = ExpandHallGMManager.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("itemClickListener ");
      localStringBuilder.append(l);
      localStringBuilder.append(' ');
      Logger.a(str, localStringBuilder.toString());
      ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).b();
      ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new ExpandHallGMManager.itemClickListener.1.onItemClick..inlined.let.lambda.1(paramKuolieRoomInfo, this, l, paramContext), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.ExpandHallGMManager.itemClickListener.1
 * JD-Core Version:    0.7.0.1
 */