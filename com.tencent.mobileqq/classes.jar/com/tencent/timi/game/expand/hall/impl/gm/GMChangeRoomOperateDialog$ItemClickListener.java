package com.tencent.timi.game.expand.hall.impl.gm;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.RecommendProxyOuterClass.KuolieRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/gm/GMChangeRoomOperateDialog$ItemClickListener;", "", "onItemClick", "", "info", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "context", "Landroid/content/Context;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface GMChangeRoomOperateDialog$ItemClickListener
{
  public abstract void a(@NotNull RecommendProxyOuterClass.KuolieRoomInfo paramKuolieRoomInfo, @NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.GMChangeRoomOperateDialog.ItemClickListener
 * JD-Core Version:    0.7.0.1
 */