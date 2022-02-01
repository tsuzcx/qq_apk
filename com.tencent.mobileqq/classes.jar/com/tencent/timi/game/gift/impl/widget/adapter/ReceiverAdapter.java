package com.tencent.timi.game.gift.impl.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.gift.impl.theme.IThemeColor;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverViewHolder;", "Lcom/tencent/timi/game/gift/impl/theme/IThemeColor;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "diffCallback", "com/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter$diffCallback$1", "Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter$diffCallback$1;", "onClickListener", "Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter$IOnClickListener;", "receiverDiff", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "kotlin.jvm.PlatformType", "themeColor", "", "chooseReceiver", "", "chosenReceiverInfo", "getItemCount", "notifyDiff", "newReceiverInfoList", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnClickListener", "listener", "setThemeColor", "Companion", "IOnClickListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiverAdapter
  extends RecyclerView.Adapter<ReceiverViewHolder>
  implements IThemeColor
{
  public static final ReceiverAdapter.Companion a = new ReceiverAdapter.Companion(null);
  private ReceiverAdapter.IOnClickListener b;
  private int c;
  private final ReceiverAdapter.diffCallback.1 d;
  private final AsyncListDiffer<ReceiverInfoModel> e;
  private final Context f;
  
  public ReceiverAdapter(@NotNull Context paramContext)
  {
    this.f = paramContext;
    this.c = 2;
    this.d = new ReceiverAdapter.diffCallback.1();
    this.e = new AsyncListDiffer((RecyclerView.Adapter)this, (DiffUtil.ItemCallback)this.d);
  }
  
  private final void a(ReceiverInfoModel paramReceiverInfoModel)
  {
    ReceiverAdapter.IOnClickListener localIOnClickListener = this.b;
    if (localIOnClickListener != null) {
      localIOnClickListener.a(paramReceiverInfoModel);
    }
  }
  
  @NotNull
  public ReceiverViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(this.f).inflate(2131629434, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "LayoutInflater.from(ctx)…iver_view, parent, false)");
    return new ReceiverViewHolder(paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(@NotNull ReceiverAdapter.IOnClickListener paramIOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIOnClickListener, "listener");
    this.b = paramIOnClickListener;
  }
  
  public void a(@NotNull ReceiverViewHolder paramReceiverViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverViewHolder, "holder");
    ReceiverInfoModel localReceiverInfoModel = (ReceiverInfoModel)this.e.getCurrentList().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localReceiverInfoModel, "receiverInfoModel");
    paramReceiverViewHolder.a(localReceiverInfoModel, localReceiverInfoModel.f(), this.c);
    paramReceiverViewHolder = paramReceiverViewHolder.itemView;
    Intrinsics.checkExpressionValueIsNotNull(paramReceiverViewHolder, "holder.itemView");
    paramReceiverViewHolder.findViewById(2131430774).setOnClickListener((View.OnClickListener)new ReceiverAdapter.onBindViewHolder.1(this, localReceiverInfoModel));
  }
  
  public final void a(@NotNull List<ReceiverInfoModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "newReceiverInfoList");
    Logger.b("ReceiverAdapter", CollectionsKt.joinToString$default((Iterable)paramList, null, null, null, 0, null, (Function1)ReceiverAdapter.notifyDiff.1.INSTANCE, 31, null));
    this.e.submitList(paramList);
  }
  
  public int getItemCount()
  {
    return this.e.getCurrentList().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter
 * JD-Core Version:    0.7.0.1
 */