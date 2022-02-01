package com.tencent.timi.game.smoba.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/api/SmobaAuthAndDefaultAccountChecker;", "", "()V", "TAG", "", "authInfo", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "authInfoLiveData", "Landroidx/lifecycle/LiveData;", "defaultAccountLiveData", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "mListenerPool", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/smoba/api/SmobaAuthAndDefaultAccountChecker$CheckListener;", "Lkotlin/collections/ArrayList;", "observerOfAuthInfo", "Landroidx/lifecycle/Observer;", "observerOfDefaultAccount", "callbackHideHintView", "", "defaultAccount", "callbackShowHintView", "accountList", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "doCheck", "handleDefaultAccount", "handleGetSmobaAuthInfo", "registerListener", "listener", "smobaAuthCheck", "smobaDefaultAccountCheck", "CheckListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaAuthAndDefaultAccountChecker
{
  public static final SmobaAuthAndDefaultAccountChecker a = new SmobaAuthAndDefaultAccountChecker();
  private static final ArrayList<WeakReference<SmobaAuthAndDefaultAccountChecker.CheckListener>> b = new ArrayList();
  private static GameDataServerOuterClass.GetSmobaAuthInfoRsp c;
  private static final LiveData<GameDataServerOuterClass.GetSmobaAuthInfoRsp> d = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).c();
  private static final Observer<GameDataServerOuterClass.GetSmobaAuthInfoRsp> e = (Observer)SmobaAuthAndDefaultAccountChecker.observerOfAuthInfo.1.a;
  private static final LiveData<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> f = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a();
  private static final Observer<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> g = (Observer)SmobaAuthAndDefaultAccountChecker.observerOfDefaultAccount.1.a;
  
  private final void a(GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp, GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
  {
    Iterator localIterator = b.iterator();
    for (;;)
    {
      Object localObject;
      if (localIterator.hasNext()) {
        localObject = (WeakReference)localIterator.next();
      }
      try
      {
        localObject = (SmobaAuthAndDefaultAccountChecker.CheckListener)((WeakReference)localObject).get();
        if (localObject == null) {
          continue;
        }
        ((SmobaAuthAndDefaultAccountChecker.CheckListener)localObject).a(paramGetSmobaAuthInfoRsp, paramGetUserSmobaRoleListRsp);
      }
      catch (Exception localException) {}
      return;
    }
  }
  
  private final void a(GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    if (paramGetSmobaDefaultRoleRsp != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("already bind account:");
      localStringBuilder.append(paramGetSmobaDefaultRoleRsp);
      Logger.a("SmobaAuthAndDefaultAccountChecker_", localStringBuilder.toString());
      b(paramGetSmobaDefaultRoleRsp);
      return;
    }
    Logger.a("SmobaAuthAndDefaultAccountChecker_", "defaultAccount is null");
    a(c, null);
  }
  
  private final void b()
  {
    d.observeForever(e);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
  }
  
  private final void b(GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      try
      {
        localObject = (SmobaAuthAndDefaultAccountChecker.CheckListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((SmobaAuthAndDefaultAccountChecker.CheckListener)localObject).a(paramGetSmobaDefaultRoleRsp);
        }
      }
      catch (Exception localException)
      {
        Logger.a("SmobaAuthAndDefaultAccountChecker_", "callbackHideHintView error", (Throwable)localException);
      }
    }
  }
  
  private final void c()
  {
    f.observeForever(g);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b(null);
  }
  
  private final void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleGetSmobaAuthInfo authInfo = ");
    ((StringBuilder)localObject).append(c);
    Logger.a("SmobaAuthAndDefaultAccountChecker_", ((StringBuilder)localObject).toString());
    localObject = c;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetSmobaAuthInfo is_auth = ");
      localStringBuilder.append(((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject).is_auth.get());
      Logger.a("SmobaAuthAndDefaultAccountChecker_", localStringBuilder.toString());
      if (!((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject).is_auth.get())
      {
        f.observeForever(g);
        a.a((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject, null);
        return;
      }
      a.c();
    }
  }
  
  public final void a()
  {
    b();
  }
  
  public final void a(@NotNull SmobaAuthAndDefaultAccountChecker.CheckListener paramCheckListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCheckListener, "listener");
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      if (Intrinsics.areEqual((SmobaAuthAndDefaultAccountChecker.CheckListener)((WeakReference)localIterator.next()).get(), paramCheckListener)) {
        return;
      }
    }
    b.add(new WeakReference(paramCheckListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.SmobaAuthAndDefaultAccountChecker
 * JD-Core Version:    0.7.0.1
 */