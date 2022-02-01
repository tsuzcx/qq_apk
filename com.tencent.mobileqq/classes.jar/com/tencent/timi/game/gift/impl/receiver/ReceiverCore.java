package com.tencent.timi.game.gift.impl.receiver;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/receiver/ReceiverCore;", "Lcom/tencent/timi/game/gift/impl/receiver/IReceiverCore;", "()V", "chosenReceiverList", "", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "chosenReceiverLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "myUid", "", "getMyUid", "()J", "receiverList", "receiverUpdateCbList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/gift/impl/receiver/ReceiverUpdateCallback;", "chooseAllReceivers", "", "chosen", "chooseReceiver", "chosenInfo", "getChosenReceiverList", "getChosenReceiverLiveData", "Landroidx/lifecycle/LiveData;", "initWhenEnterRoom", "roomId", "sceneType", "", "rearrangeInsertReceiver", "sortedReceiverList", "registerReceiverChangeListener", "cb", "replaceAllReceiver", "list", "noAnimate", "reset", "resetWhenExitRoom", "resetWhenLogout", "resetWhenPanelShow", "setAllChosenReceivers", "setChooseReceiver", "unregisterReceiverChangeListener", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiverCore
  implements IReceiverCore
{
  public static final ReceiverCore.Companion a = new ReceiverCore.Companion(null);
  private final CopyOnWriteArrayList<WeakReference<ReceiverUpdateCallback>> b = new CopyOnWriteArrayList();
  private final MutableLiveData<Pair<List<ReceiverInfoModel>, Boolean>> c = new MutableLiveData();
  private final List<ReceiverInfoModel> d = (List)new ArrayList();
  private final List<ReceiverInfoModel> e = (List)new ArrayList();
  
  private final void a(List<ReceiverInfoModel> paramList)
  {
    Iterator localIterator1 = ((Iterable)this.d).iterator();
    label182:
    while (localIterator1.hasNext())
    {
      ReceiverInfoModel localReceiverInfoModel1 = (ReceiverInfoModel)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      int i = 0;
      while (localIterator2.hasNext())
      {
        ReceiverInfoModel localReceiverInfoModel2 = (ReceiverInfoModel)localIterator2.next();
        if (Intrinsics.areEqual(localReceiverInfoModel1.a(), localReceiverInfoModel2.a())) {
          break label96;
        }
        i += 1;
      }
      i = -1;
      label96:
      if (i != -1)
      {
        ((ReceiverInfoModel)paramList.get(i)).a(true);
      }
      else
      {
        localIterator2 = paramList.iterator();
        i = 0;
        while (localIterator2.hasNext())
        {
          if (((ReceiverInfoModel)localIterator2.next()).b() >= localReceiverInfoModel1.b()) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            break label182;
          }
          i += 1;
        }
        i = -1;
        int j = i;
        if (i == -1) {
          j = paramList.size();
        }
        paramList.add(Math.max(j, 0), ReceiverInfoModel.a(localReceiverInfoModel1, null, 0, "", true, false, false, 51, null));
      }
    }
  }
  
  private final void b(ReceiverInfoModel paramReceiverInfoModel)
  {
    Object localObject1 = this.d.iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      if (Intrinsics.areEqual(((ReceiverInfoModel)((Iterator)localObject1).next()).a(), paramReceiverInfoModel.a())) {
        break label58;
      }
      i += 1;
    }
    i = -1;
    label58:
    if (i >= 0)
    {
      this.d.remove(i);
    }
    else
    {
      if (c() == paramReceiverInfoModel.a().uid.get()) {
        CustomToastView.a(ResUtils.c(2131889662));
      }
      this.d.add(ReceiverInfoModel.a(paramReceiverInfoModel, null, 0, null, false, false, true, 31, null));
    }
    Object localObject2 = ((Iterable)this.e).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (Intrinsics.areEqual(((ReceiverInfoModel)localObject1).a(), paramReceiverInfoModel.a()))
      {
        paramReceiverInfoModel = (ReceiverInfoModel)localObject1;
        break label184;
      }
    }
    paramReceiverInfoModel = null;
    label184:
    paramReceiverInfoModel = (ReceiverInfoModel)paramReceiverInfoModel;
    boolean bool2 = true;
    boolean bool1;
    if (paramReceiverInfoModel != null)
    {
      if (i < 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramReceiverInfoModel.a(bool1);
    }
    if (this.e.size() == this.d.size()) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.c.postValue(TuplesKt.to(this.d, Boolean.valueOf(bool1)));
    localObject1 = (Iterable)this.e;
    paramReceiverInfoModel = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramReceiverInfoModel.add(ReceiverInfoModel.a((ReceiverInfoModel)((Iterator)localObject1).next(), null, 0, null, false, false, false, 63, null));
    }
    paramReceiverInfoModel = (List)paramReceiverInfoModel;
    localObject1 = ((Iterable)this.b).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ReceiverUpdateCallback)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null) {
        ((ReceiverUpdateCallback)localObject2).a(paramReceiverInfoModel, false);
      }
    }
  }
  
  private final long c()
  {
    IService localIService = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
    return ((ILoginCoreService)localIService).a();
  }
  
  @NotNull
  public List<ReceiverInfoModel> a()
  {
    return this.d;
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
    this.b.add(new WeakReference(paramReceiverUpdateCallback));
  }
  
  public void a(@NotNull List<ReceiverInfoModel> paramList, boolean paramBoolean)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramList, "list");
      Object localObject = ReceiverUtilKt.a(ReceiverUtilKt.b(paramList));
      a((List)localObject);
      this.e.clear();
      this.e.addAll((Collection)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("chosenReceiver: ");
      ((StringBuilder)localObject).append(CollectionsKt.joinToString$default((Iterable)this.d, null, null, null, 0, null, (Function1)ReceiverCore.replaceAllReceiver.1.INSTANCE, 31, null));
      Logger.b("ReceiverCore", ((StringBuilder)localObject).toString());
      Logger.b("ReceiverCore", CollectionsKt.joinToString$default((Iterable)paramList, null, null, null, 0, null, (Function1)ReceiverCore.replaceAllReceiver.2.INSTANCE, 31, null));
      boolean bool3 = this.d.isEmpty();
      boolean bool2 = false;
      boolean bool1 = false;
      if ((bool3) && ((((Collection)this.e).isEmpty() ^ true)))
      {
        this.d.add(this.e.get(0));
        paramList = (ReceiverInfoModel)CollectionsKt.firstOrNull(this.e);
        if (paramList != null) {
          paramList.a(true);
        }
        paramList = this.c;
        localObject = this.d;
        if (this.e.size() == 1) {
          bool1 = true;
        }
        paramList.postValue(TuplesKt.to(localObject, Boolean.valueOf(bool1)));
      }
      else
      {
        bool1 = bool2;
        if (this.e.size() == this.d.size()) {
          bool1 = true;
        }
        this.c.postValue(TuplesKt.to(this.d, Boolean.valueOf(bool1)));
      }
      localObject = (Iterable)this.e;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add(ReceiverInfoModel.a((ReceiverInfoModel)((Iterator)localObject).next(), null, 0, null, false, false, false, 63, null));
      }
      paramList = (List)paramList;
      localObject = ((Iterable)this.b).iterator();
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
      this.d.clear();
      this.c.setValue(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.receiver.ReceiverCore
 * JD-Core Version:    0.7.0.1
 */