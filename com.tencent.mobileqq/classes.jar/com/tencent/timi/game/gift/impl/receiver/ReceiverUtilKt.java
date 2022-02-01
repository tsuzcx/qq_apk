package com.tencent.timi.game.gift.impl.receiver;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"deDuplicate", "", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "rawReceiverList", "", "resort", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class ReceiverUtilKt
{
  @NotNull
  public static final List<ReceiverInfoModel> a(@NotNull List<ReceiverInfoModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "rawReceiverList");
    return CollectionsKt.toMutableList((Collection)CollectionsKt.sortedWith((Iterable)paramList, (Comparator)new ReceiverUtilKt.resort..inlined.sortedBy.1()));
  }
  
  @NotNull
  public static final List<ReceiverInfoModel> b(@NotNull List<ReceiverInfoModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "rawReceiverList");
    Object localObject1 = (Iterable)paramList;
    paramList = new HashSet();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (paramList.add(Long.valueOf(((ReceiverInfoModel)localObject2).a().uid.get()))) {
        localArrayList.add(localObject2);
      }
    }
    return CollectionsKt.toMutableList((Collection)localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.receiver.ReceiverUtilKt
 * JD-Core Version:    0.7.0.1
 */