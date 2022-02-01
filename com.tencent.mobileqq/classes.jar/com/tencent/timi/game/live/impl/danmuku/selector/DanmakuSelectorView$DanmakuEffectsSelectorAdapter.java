package com.tencent.timi.game.live.impl.danmuku.selector;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.TextShowInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$DanmakuEffectsSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "danmakuChooserView", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView;", "(Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView;)V", "danmakuShowTypeDiff", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$DanmakuSelectDataBean;", "kotlin.jvm.PlatformType", "getItemCount", "", "onBindViewHolder", "", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "submitNewList", "textShowInfoList", "", "Ltrpc/yes/common/GameDataServerOuterClass$TextShowInfo;", "selectShowType", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class DanmakuSelectorView$DanmakuEffectsSelectorAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final AsyncListDiffer<DanmakuSelectorView.DanmakuSelectDataBean> a;
  private final DanmakuSelectorView b;
  
  public DanmakuSelectorView$DanmakuEffectsSelectorAdapter(@NotNull DanmakuSelectorView paramDanmakuSelectorView)
  {
    this.b = paramDanmakuSelectorView;
    this.a = new AsyncListDiffer((RecyclerView.Adapter)this, (DiffUtil.ItemCallback)new DanmakuSelectorView.DanmakuEffectsSelectorAdapter.danmakuShowTypeDiff.1());
  }
  
  public final void a(@NotNull List<GameDataServerOuterClass.TextShowInfo> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "textShowInfoList");
    Object localObject1 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      int j;
      if (((GameDataServerOuterClass.TextShowInfo)((Iterator)localObject1).next()).show_type.get() == paramInt) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        break label72;
      }
      i += 1;
    }
    i = -1;
    label72:
    if (i == -1)
    {
      localObject1 = (GameDataServerOuterClass.TextShowInfo)CollectionsKt.firstOrNull(paramList);
      if (localObject1 != null)
      {
        localObject1 = ((GameDataServerOuterClass.TextShowInfo)localObject1).show_type;
        if (localObject1 != null)
        {
          paramInt = ((PBInt32Field)localObject1).get();
          break label117;
        }
      }
      paramInt = -1;
    }
    label117:
    localObject1 = this.a;
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      GameDataServerOuterClass.TextShowInfo localTextShowInfo = (GameDataServerOuterClass.TextShowInfo)((Iterator)localObject2).next();
      boolean bool;
      if (localTextShowInfo.show_type.get() == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      paramList.add(new DanmakuSelectorView.DanmakuSelectDataBean(bool, localTextShowInfo));
    }
    ((AsyncListDiffer)localObject1).submitList((List)paramList);
  }
  
  public int getItemCount()
  {
    return this.a.getCurrentList().size();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "p0");
    DanmakuSelectorView.DanmakuSelectDataBean localDanmakuSelectDataBean = (DanmakuSelectorView.DanmakuSelectDataBean)this.a.getCurrentList().get(paramInt);
    View localView = paramViewHolder.itemView;
    if (localView != null)
    {
      ((DanmakuSelectorItemView)localView).a(localDanmakuSelectDataBean.a(), localDanmakuSelectDataBean.b().show_type.get());
      paramViewHolder.itemView.setOnClickListener((View.OnClickListener)new DanmakuSelectorView.DanmakuEffectsSelectorAdapter.onBindViewHolder.1(this, paramInt));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorItemView");
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "p0");
    Context localContext = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "p0.context");
    return (RecyclerView.ViewHolder)new DanmakuSelectorView.DanmakuEffectsSelectorAdapter.onCreateViewHolder.1(paramViewGroup, (View)new DanmakuSelectorItemView(localContext, null, 0, 6, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorView.DanmakuEffectsSelectorAdapter
 * JD-Core Version:    0.7.0.1
 */