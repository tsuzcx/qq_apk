package com.tencent.timi.game.userinfo.impl.loader;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/loader/BaseAutoLoader;", "CallBacakData", "", "()V", "leftNeedRequestUid", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "maxNumber", "", "getMaxNumber", "()I", "setMaxNumber", "(I)V", "requesting", "", "acquireTAG", "", "getRequestList", "", "uids", "requestData", "", "requestList", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "updateData", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseAutoLoader<CallBacakData>
{
  private HashSet<Long> a = new HashSet();
  private boolean b;
  private int c = 20;
  
  private final List<Long> a(HashSet<Long> paramHashSet)
  {
    List localList = (List)new ArrayList();
    if (paramHashSet != null)
    {
      Object localObject2 = (Iterable)paramHashSet;
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        int i;
        if (((Number)localObject3).longValue() != 0L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = CollectionsKt.withIndex((Iterable)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (IndexedValue)((Iterator)localObject1).next();
          if (((IndexedValue)localObject2).getIndex() < this.c) {
            localList.add(((IndexedValue)localObject2).getValue());
          }
        }
      }
    }
    if (paramHashSet != null) {
      paramHashSet.removeAll((Collection)localList);
    }
    return localList;
  }
  
  @NotNull
  public String a()
  {
    return "BaseAutoLoader";
  }
  
  protected final void a(@Nullable List<Long> paramList)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new BaseAutoLoader.updateData.runnable.1(this, paramList));
  }
  
  public abstract void a(@NotNull List<Long> paramList, @Nullable IResultListener<CallBacakData> paramIResultListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.BaseAutoLoader
 * JD-Core Version:    0.7.0.1
 */