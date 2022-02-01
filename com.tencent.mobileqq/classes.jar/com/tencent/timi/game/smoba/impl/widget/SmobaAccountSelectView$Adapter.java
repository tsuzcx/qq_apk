package com.tencent.timi.game.smoba.impl.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/widget/SmobaAccountSelectView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/smoba/impl/widget/SmobaAccountSelectView$VH;", "(Lcom/tencent/timi/game/smoba/impl/widget/SmobaAccountSelectView;)V", "mSelectFlags", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mSelectedPos", "", "getItemCount", "getSelectedPos", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateFlags", "selectedPos", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class SmobaAccountSelectView$Adapter
  extends RecyclerView.Adapter<SmobaAccountSelectView.VH>
{
  private final ArrayList<Boolean> b = new ArrayList();
  private int c;
  
  public final int a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSelectedPos=");
    localStringBuilder.append(this.c);
    Logger.a("SmobaAccountSelectView_", localStringBuilder.toString());
    return this.c;
  }
  
  @NotNull
  public SmobaAccountSelectView.VH a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = View.inflate(this.a.getContext(), 2131629524, null);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "view");
    return new SmobaAccountSelectView.VH(paramViewGroup);
  }
  
  public final void a(int paramInt)
  {
    int j = getItemCount();
    this.b.clear();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = this.b;
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localArrayList.add(Boolean.valueOf(bool));
      i += 1;
    }
    this.c = paramInt;
  }
  
  public void a(@NotNull SmobaAccountSelectView.VH paramVH, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVH, "holder");
    Object localObject1 = SmobaAccountSelectView.a(this.a).get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSombaAccountList[position]");
    localObject1 = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject1;
    Object localObject2 = this.b.get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mSelectFlags[position]");
    int i;
    if (((Boolean)localObject2).booleanValue()) {
      i = 2130853198;
    } else {
      i = 2130853199;
    }
    localObject2 = paramVH.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "holder.itemView");
    ((ImageView)((View)localObject2).findViewById(2131430667)).setImageResource(i);
    localObject2 = paramVH.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "holder.itemView");
    localObject2 = (TextView)((View)localObject2).findViewById(2131445112);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "holder.itemView.roleNameTxv");
    ((TextView)localObject2).setText((CharSequence)((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject1).role_name.get());
    localObject2 = paramVH.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "holder.itemView");
    localObject2 = (TextView)((View)localObject2).findViewById(2131445102);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "holder.itemView.roleDescTxv");
    ((TextView)localObject2).setText((CharSequence)((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject1).role_desc.get());
    paramVH.itemView.setOnClickListener((View.OnClickListener)new SmobaAccountSelectView.Adapter.onBindViewHolder.1(this, paramInt));
  }
  
  public int getItemCount()
  {
    return SmobaAccountSelectView.a(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.widget.SmobaAccountSelectView.Adapter
 * JD-Core Version:    0.7.0.1
 */