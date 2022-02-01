package com.tencent.timi.game.gift.impl.timi.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/live/LiveReceiverAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/gift/impl/timi/live/ReceiverViewHolder;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "diffCallback", "com/tencent/timi/game/gift/impl/timi/live/LiveReceiverAdapter$diffCallback$1", "Lcom/tencent/timi/game/gift/impl/timi/live/LiveReceiverAdapter$diffCallback$1;", "receiverDiff", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/tencent/timi/game/gift/impl/timi/live/LiveReceiverInfoModel;", "kotlin.jvm.PlatformType", "getItemCount", "", "notifyDiff", "", "newReceiverInfoList", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveReceiverAdapter
  extends RecyclerView.Adapter<ReceiverViewHolder>
{
  public static final LiveReceiverAdapter.Companion a = new LiveReceiverAdapter.Companion(null);
  private final AsyncListDiffer<LiveReceiverInfoModel> b;
  private final Context c;
  
  @NotNull
  public ReceiverViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(this.c).inflate(2131629433, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "LayoutInflater.from(ctx)…live_view, parent, false)");
    return new ReceiverViewHolder(paramViewGroup);
  }
  
  public void a(@NotNull ReceiverViewHolder paramReceiverViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverViewHolder, "holder");
    LiveReceiverInfoModel localLiveReceiverInfoModel = (LiveReceiverInfoModel)this.b.getCurrentList().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localLiveReceiverInfoModel, "receiverInfoModel");
    paramReceiverViewHolder.a(localLiveReceiverInfoModel, localLiveReceiverInfoModel.d());
    paramReceiverViewHolder = paramReceiverViewHolder.itemView;
    Intrinsics.checkExpressionValueIsNotNull(paramReceiverViewHolder, "holder.itemView");
    paramReceiverViewHolder.findViewById(2131430774).setOnClickListener((View.OnClickListener)LiveReceiverAdapter.onBindViewHolder.1.a);
  }
  
  public int getItemCount()
  {
    return this.b.getCurrentList().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.live.LiveReceiverAdapter
 * JD-Core Version:    0.7.0.1
 */