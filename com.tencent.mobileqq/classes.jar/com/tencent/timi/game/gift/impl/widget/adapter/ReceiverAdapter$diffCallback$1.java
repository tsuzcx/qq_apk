package com.tencent.timi.game.gift.impl.widget.adapter;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter$diffCallback$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "areContentsTheSame", "", "p0", "p1", "areItemsTheSame", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiverAdapter$diffCallback$1
  extends DiffUtil.ItemCallback<ReceiverInfoModel>
{
  public boolean a(@NotNull ReceiverInfoModel paramReceiverInfoModel1, @NotNull ReceiverInfoModel paramReceiverInfoModel2)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel1, "p0");
    Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel2, "p1");
    return true;
  }
  
  public boolean b(@NotNull ReceiverInfoModel paramReceiverInfoModel1, @NotNull ReceiverInfoModel paramReceiverInfoModel2)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel1, "p0");
    Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel2, "p1");
    return (Intrinsics.areEqual(paramReceiverInfoModel1.c(), paramReceiverInfoModel2.c())) && (paramReceiverInfoModel1.b() == paramReceiverInfoModel2.b()) && (paramReceiverInfoModel1.a().uid.get() == paramReceiverInfoModel2.a().uid.get()) && (paramReceiverInfoModel1.f() == paramReceiverInfoModel2.f()) && (paramReceiverInfoModel1.e() == paramReceiverInfoModel2.e()) && (paramReceiverInfoModel1.d() == paramReceiverInfoModel2.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter.diffCallback.1
 * JD-Core Version:    0.7.0.1
 */