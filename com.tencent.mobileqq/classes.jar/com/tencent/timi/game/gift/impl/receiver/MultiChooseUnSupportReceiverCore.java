package com.tencent.timi.game.gift.impl.receiver;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/receiver/MultiChooseUnSupportReceiverCore;", "Lcom/tencent/timi/game/gift/impl/receiver/IReceiverCore;", "()V", "chosenReceiverList", "", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "chosenReceiverLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "fakeChosenPair", "receiverList", "receiverUpdateCbList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/gift/impl/receiver/ReceiverUpdateCallback;", "chooseAllReceivers", "", "chosen", "chooseReceiver", "chosenInfo", "getChosenReceiverList", "getChosenReceiverLiveData", "initWhenEnterRoom", "roomId", "", "sceneType", "", "rearrangeInsertReceiver", "sortedReceiverList", "registerReceiverChangeListener", "cb", "replaceAllReceiver", "list", "noAnimate", "reset", "resetWhenExitRoom", "resetWhenLogout", "resetWhenPanelShow", "setChosenReceiver", "info", "unregisterReceiverChangeListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MultiChooseUnSupportReceiverCore
  implements IReceiverCore
{
  private final CopyOnWriteArrayList<WeakReference<ReceiverUpdateCallback>> a = new CopyOnWriteArrayList();
  private final List<ReceiverInfoModel> b = (List)new ArrayList();
  private final MutableLiveData<Pair<List<ReceiverInfoModel>, Boolean>> c = new MutableLiveData();
  private final Pair<List<ReceiverInfoModel>, Boolean> d = new Pair(this.b, Boolean.valueOf(false));
  private final List<ReceiverInfoModel> e = (List)new ArrayList();
  
  private final void a(List<ReceiverInfoModel> paramList)
  {
    try
    {
      if (this.b.isEmpty())
      {
        this.e.clear();
        this.e.addAll((Collection)paramList);
        b((ReceiverInfoModel)CollectionsKt.getOrNull(paramList, 0));
        break label293;
      }
      localReceiverInfoModel1 = (ReceiverInfoModel)this.b.get(0);
      localIterator = paramList.iterator();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        ReceiverInfoModel localReceiverInfoModel1;
        Iterator localIterator;
        int i;
        ReceiverInfoModel localReceiverInfoModel2;
        PBUInt64Field localPBUInt64Field;
        for (;;)
        {
          label293:
          throw paramList;
        }
        int j = 0;
        label309:
        if (j == 0)
        {
          i += 1;
          continue;
          i = -1;
          continue;
          label328:
          j = 0;
          label330:
          if (j == 0)
          {
            i += 1;
            continue;
            label344:
            i = -1;
          }
        }
      }
    }
    if (localIterator.hasNext())
    {
      localReceiverInfoModel2 = (ReceiverInfoModel)localIterator.next();
      localPBUInt64Field = localReceiverInfoModel1.a().uid;
      if ((localPBUInt64Field != null) && (localPBUInt64Field.get() == localReceiverInfoModel2.a().uid.get()))
      {
        j = 1;
        break label309;
        if (i != -1)
        {
          ((ReceiverInfoModel)paramList.get(i)).a(true);
          this.e.clear();
          this.e.addAll((Collection)paramList);
          return;
        }
        localIterator = paramList.iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label344;
        }
        if (((ReceiverInfoModel)localIterator.next()).b() < localReceiverInfoModel1.b()) {
          break label328;
        }
        j = 1;
        break label330;
        j = i;
        if (i == -1) {
          j = paramList.size();
        }
        paramList.add(Math.max(j, 0), ReceiverInfoModel.a(localReceiverInfoModel1, null, 0, "", true, false, true, 19, null));
        this.e.clear();
        this.e.addAll((Collection)paramList);
      }
    }
  }
  
  private final void b(ReceiverInfoModel paramReceiverInfoModel)
  {
    this.b.clear();
    if (paramReceiverInfoModel != null) {
      this.b.add(paramReceiverInfoModel);
    }
    Iterator localIterator = ((Iterable)this.e).iterator();
    ReceiverUpdateCallback localReceiverUpdateCallback;
    do
    {
      boolean bool = localIterator.hasNext();
      localReceiverUpdateCallback = null;
      if (!bool) {
        break;
      }
      localObject1 = localIterator.next();
    } while (!((ReceiverInfoModel)localObject1).f());
    break label79;
    Object localObject1 = null;
    label79:
    localObject1 = (ReceiverInfoModel)localObject1;
    if (localObject1 != null) {
      ((ReceiverInfoModel)localObject1).a(false);
    }
    localIterator = ((Iterable)this.e).iterator();
    int i;
    do
    {
      localObject1 = localReceiverUpdateCallback;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = localIterator.next();
      long l = ((ReceiverInfoModel)localObject1).a().uid.get();
      if (paramReceiverInfoModel != null)
      {
        Object localObject2 = paramReceiverInfoModel.a();
        if (localObject2 != null)
        {
          localObject2 = ((CommonOuterClass.QQUserId)localObject2).uid;
          if ((localObject2 != null) && (l == ((PBUInt64Field)localObject2).get()))
          {
            i = 1;
            continue;
          }
        }
      }
      i = 0;
    } while (i == 0);
    paramReceiverInfoModel = (ReceiverInfoModel)localObject1;
    if (paramReceiverInfoModel != null) {
      paramReceiverInfoModel.a(true);
    }
    this.c.postValue(this.d);
    localObject1 = (Iterable)this.e;
    paramReceiverInfoModel = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramReceiverInfoModel.add(ReceiverInfoModel.a((ReceiverInfoModel)((Iterator)localObject1).next(), null, 0, null, false, false, false, 63, null));
    }
    paramReceiverInfoModel = (List)paramReceiverInfoModel;
    localObject1 = ((Iterable)this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localReceiverUpdateCallback = (ReceiverUpdateCallback)((WeakReference)((Iterator)localObject1).next()).get();
      if (localReceiverUpdateCallback != null) {
        localReceiverUpdateCallback.a(paramReceiverInfoModel, false);
      }
    }
  }
  
  @NotNull
  public List<ReceiverInfoModel> a()
  {
    return this.b;
  }
  
  public void a(@NotNull ReceiverInfoModel paramReceiverInfoModel)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel, "chosenInfo");
      b(paramReceiverInfoModel);
      return;
    }
    finally
    {
      paramReceiverInfoModel = finally;
      throw paramReceiverInfoModel;
    }
  }
  
  public void a(@NotNull ReceiverUpdateCallback paramReceiverUpdateCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverUpdateCallback, "cb");
    this.a.add(new WeakReference(paramReceiverUpdateCallback));
  }
  
  public void a(@NotNull List<ReceiverInfoModel> paramList, boolean paramBoolean)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramList, "list");
      paramList = ReceiverUtilKt.a(ReceiverUtilKt.b(paramList));
      a(paramList);
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add(ReceiverInfoModel.a((ReceiverInfoModel)((Iterator)localObject).next(), null, 0, null, false, false, false, 63, null));
      }
      paramList = (List)paramList;
      localObject = ((Iterable)this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReceiverUpdateCallback localReceiverUpdateCallback = (ReceiverUpdateCallback)((WeakReference)((Iterator)localObject).next()).get();
        if (localReceiverUpdateCallback != null) {
          localReceiverUpdateCallback.a(paramList, paramBoolean);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    try
    {
      this.e.clear();
      this.b.clear();
      this.c.setValue(null);
      Iterator localIterator = ((Iterable)this.a).iterator();
      while (localIterator.hasNext())
      {
        ReceiverUpdateCallback localReceiverUpdateCallback = (ReceiverUpdateCallback)((WeakReference)localIterator.next()).get();
        if (localReceiverUpdateCallback != null) {
          localReceiverUpdateCallback.a(CollectionsKt.emptyList(), false);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.receiver.MultiChooseUnSupportReceiverCore
 * JD-Core Version:    0.7.0.1
 */