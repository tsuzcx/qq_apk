package com.tencent.timi.game.liveroom.impl.fans;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem;
import com.tencent.widget.pull2refresh.BaseAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupListAdapter;", "Lcom/tencent/widget/pull2refresh/BaseAdapter;", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorFansGroupItem;", "Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder;", "context", "Landroid/content/Context;", "list", "", "listener", "Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder$ItemClickListener;", "anchorUid", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder$ItemClickListener;J)V", "getAnchorUid", "()J", "getListener", "()Lcom/tencent/timi/game/liveroom/impl/fans/LivingFansGroupHolder$ItemClickListener;", "getCustomItemViewType", "", "position", "onBindCustomViewHolder", "", "holder", "onCreateCustomViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingFansGroupListAdapter
  extends BaseAdapter<QQLiveAnchorFansGroupItem, LivingFansGroupHolder>
{
  @NotNull
  private final LivingFansGroupHolder.ItemClickListener a;
  private final long b;
  
  public LivingFansGroupListAdapter(@NotNull Context paramContext, @NotNull List<? extends QQLiveAnchorFansGroupItem> paramList, @NotNull LivingFansGroupHolder.ItemClickListener paramItemClickListener, long paramLong)
  {
    super(paramContext, paramList);
    this.a = paramItemClickListener;
    this.b = paramLong;
  }
  
  @NotNull
  public LivingFansGroupHolder a(@Nullable ViewGroup paramViewGroup, int paramInt)
  {
    return new LivingFansGroupHolder(paramViewGroup, 2131629443, this.a, this.b);
  }
  
  public void a(@Nullable LivingFansGroupHolder paramLivingFansGroupHolder, int paramInt)
  {
    if (paramLivingFansGroupHolder != null)
    {
      Object localObject = getItem(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getItem(position)");
      paramLivingFansGroupHolder.a((QQLiveAnchorFansGroupItem)localObject);
    }
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.fans.LivingFansGroupListAdapter
 * JD-Core Version:    0.7.0.1
 */