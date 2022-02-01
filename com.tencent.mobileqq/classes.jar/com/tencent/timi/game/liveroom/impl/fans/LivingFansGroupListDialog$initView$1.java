package com.tencent.timi.game.liveroom.impl.fans;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/fans/LivingFansGroupListDialog$initView$1", "Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder$ItemClickListener;", "onItemClick", "", "item", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorFansGroupItem;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingFansGroupListDialog$initView$1
  implements LivingFansGroupHolder.ItemClickListener
{
  public void a(@Nullable QQLiveAnchorFansGroupItem paramQQLiveAnchorFansGroupItem)
  {
    if (paramQQLiveAnchorFansGroupItem != null)
    {
      LivingFansGroupListDialog.a(this.a, paramQQLiveAnchorFansGroupItem);
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.fans.LivingFansGroupListDialog.initView.1
 * JD-Core Version:    0.7.0.1
 */