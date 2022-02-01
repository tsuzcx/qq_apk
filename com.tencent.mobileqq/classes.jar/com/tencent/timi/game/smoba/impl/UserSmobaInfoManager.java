package com.tencent.timi.game.smoba.impl;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import com.tencent.timi.game.smoba.impl.account.SmobaAccountRepo;
import com.tencent.timi.game.smoba.impl.auth.AuthToGetSmobaInfoRepo;
import com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils;
import com.tencent.timi.game.smoba.impl.util.UserSmobaInfoDbUtils;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.CancelSmobaAuthRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoManager;", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService;", "()V", "defaultSmobaAccount", "Landroidx/lifecycle/MutableLiveData;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "mAccountRepo", "Lcom/tencent/timi/game/smoba/impl/account/SmobaAccountRepo;", "mAuthInfoRepo", "Lcom/tencent/timi/game/smoba/impl/auth/AuthToGetSmobaInfoRepo;", "smobaAccountList", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "smobaAuthInfo", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "agreeSmobaAuth", "", "cb", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "cancelSmobaAuth", "Ltrpc/yes/common/GameDataServerOuterClass$CancelSmobaAuthRsp;", "getDefaultSmobaAccountLiveData", "Landroidx/lifecycle/LiveData;", "getGameRoleAbsInfoListLiveData", "getGameSmobaAuthInfoLiveData", "init", "context", "Landroid/content/Context;", "initRegisterDatabaseModelClass", "loadCacheDataFromDB", "onGetSmobaAuthInfoFromServer", "rsp", "onGetSmobaAuthInfoFromServer$timi_game_impl_release", "onGetSmobaDefaultAccountFromServer", "onGetSmobaDefaultAccountFromServer$timi_game_impl_release", "onGetSmobaRoleInfoListFromServer", "onGetSmobaRoleInfoListFromServer$timi_game_impl_release", "requestDefaultSmobaAccountFromDbOrServer", "callback", "requestDefaultSmobaAccountFromServer", "requestGameRoleAbsInfoListFromDbOrServer", "requestGameRoleAbsInfoListFromServer", "requestSmobaAuthInfoFromDbOrServer", "requestSmobaAuthInfoFromServer", "serviceDestroy", "setDefaultSmobaAccount", "defaultInfo", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "showAccountBindDialog", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "accountList", "showAuthHintDialog", "autoShowAccountSelect", "", "authCallback", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$AuthToGetSmobaInfoCallback;", "bindAccountCallback", "authDesc", "", "", "showSwitchAccountDialog", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$SwitchSmobaAccountCallback;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserSmobaInfoManager
  implements IUserSmobaInfoService
{
  public static final UserSmobaInfoManager.Companion a = new UserSmobaInfoManager.Companion(null);
  @NotNull
  private static final Lazy g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)UserSmobaInfoManager.Companion.INSTANCE.2.INSTANCE);
  private final MutableLiveData<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> b = new MutableLiveData();
  private final MutableLiveData<GameDataServerOuterClass.GetUserSmobaRoleListRsp> c = new MutableLiveData();
  private final MutableLiveData<GameDataServerOuterClass.GetSmobaAuthInfoRsp> d = new MutableLiveData();
  private final SmobaAccountRepo e = new SmobaAccountRepo();
  private final AuthToGetSmobaInfoRepo f = new AuthToGetSmobaInfoRepo();
  
  private final void e()
  {
    GameDataServerOuterClass.GetSmobaAuthInfoRsp localGetSmobaAuthInfoRsp = UserSmobaInfoDbUtils.a.c();
    if (localGetSmobaAuthInfoRsp != null) {
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserSmobaInfoManager.loadCacheDataFromDB..inlined.run.lambda.1(localGetSmobaAuthInfoRsp, this));
    }
    GameDataServerOuterClass.GetSmobaDefaultRoleRsp localGetSmobaDefaultRoleRsp = UserSmobaInfoDbUtils.a.b();
    if (localGetSmobaDefaultRoleRsp != null) {
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserSmobaInfoManager.loadCacheDataFromDB..inlined.run.lambda.2(localGetSmobaDefaultRoleRsp, this));
    }
    GameDataServerOuterClass.GetUserSmobaRoleListRsp localGetUserSmobaRoleListRsp = UserSmobaInfoDbUtils.a.a();
    if (localGetUserSmobaRoleListRsp != null) {
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserSmobaInfoManager.loadCacheDataFromDB..inlined.run.lambda.3(localGetUserSmobaRoleListRsp, this));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadCacheDataFromDB authInfo:");
    localStringBuilder.append(localGetSmobaAuthInfoRsp);
    localStringBuilder.append(", defaultAccount:");
    localStringBuilder.append(localGetSmobaDefaultRoleRsp);
    localStringBuilder.append(", accountList:");
    localStringBuilder.append(localGetUserSmobaRoleListRsp);
    Logger.a("UserSmobaInfoImpl_", localStringBuilder.toString());
  }
  
  @NotNull
  public LiveData<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> a()
  {
    return (LiveData)this.b;
  }
  
  public void a(@Nullable Context paramContext)
  {
    ThreadManagerV2.excute((Runnable)new UserSmobaInfoManager.init.1(this), 32, null, true);
    ThreadManagerV2.excute((Runnable)new UserSmobaInfoManager.init.2(this), 128, null, true);
  }
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    SmobaDialogUtils.a.a(paramQBaseActivity, paramBindSmobaAccountCallback);
  }
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, @Nullable IUserSmobaInfoService.SwitchSmobaAccountCallback paramSwitchSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    SmobaDialogUtils.a.a(paramQBaseActivity, paramSwitchSmobaAccountCallback);
  }
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull List<String> paramList, boolean paramBoolean, @Nullable IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramList, "authDesc");
    SmobaDialogUtils.a.a(paramQBaseActivity, paramList, paramBoolean, paramAuthToGetSmobaInfoCallback, paramBindSmobaAccountCallback);
  }
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramGetUserSmobaRoleListRsp, "accountList");
    SmobaDialogUtils.a.a(paramQBaseActivity, paramGetUserSmobaRoleListRsp, paramBindSmobaAccountCallback);
  }
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, boolean paramBoolean, @Nullable IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    SmobaDialogUtils.a.a(paramQBaseActivity, paramBoolean, paramAuthToGetSmobaInfoCallback, paramBindSmobaAccountCallback);
  }
  
  public void a(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetUserSmobaRoleListRsp> paramCallback)
  {
    this.e.a(paramCallback);
  }
  
  public final void a(@NotNull GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaAuthInfoRsp, "rsp");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSmobaAuthInfoFromServer rsp:");
    localStringBuilder.append(paramGetSmobaAuthInfoRsp);
    Logger.a("UserSmobaInfoImpl_", localStringBuilder.toString());
    this.d.setValue(paramGetSmobaAuthInfoRsp);
    UserSmobaInfoDbUtils.a.a(paramGetSmobaAuthInfoRsp);
  }
  
  public final void a(@Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSmobaDefaultAccountFromServer rsp:");
    localStringBuilder.append(paramGetSmobaDefaultRoleRsp);
    Logger.a("UserSmobaInfoImpl_", localStringBuilder.toString());
    this.b.setValue(paramGetSmobaDefaultRoleRsp);
    UserSmobaInfoDbUtils.a.a(paramGetSmobaDefaultRoleRsp);
  }
  
  public final void a(@Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSmobaRoleInfoListFromServer rsp:");
    localStringBuilder.append(paramGetUserSmobaRoleListRsp);
    Logger.a("UserSmobaInfoImpl_", localStringBuilder.toString());
    this.c.setValue(paramGetUserSmobaRoleListRsp);
    UserSmobaInfoDbUtils.a.a(paramGetUserSmobaRoleListRsp);
  }
  
  public void a(@NotNull GameDataServerOuterClass.SmobaGameRoleAbsInfo paramSmobaGameRoleAbsInfo, @Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.SetSmobaDefaultRoleRsp> paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramSmobaGameRoleAbsInfo, "defaultInfo");
    this.e.a(paramSmobaGameRoleAbsInfo, paramCallback);
  }
  
  @NotNull
  public LiveData<GameDataServerOuterClass.GetUserSmobaRoleListRsp> b()
  {
    return (LiveData)this.c;
  }
  
  public void b(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> paramCallback)
  {
    this.e.b(paramCallback);
  }
  
  @NotNull
  public LiveData<GameDataServerOuterClass.GetSmobaAuthInfoRsp> c()
  {
    return (LiveData)this.d;
  }
  
  public void c(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> paramCallback)
  {
    paramCallback = new UserSmobaInfoManager.requestDefaultSmobaAccountFromDbOrServer.cb.1(this, paramCallback);
    UserSmobaInfoDbUtils.a.a((IUserSmobaInfoService.Callback)paramCallback);
  }
  
  public void d(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaAuthInfoRsp> paramCallback)
  {
    this.f.a(paramCallback);
  }
  
  public void e(@NotNull IUserSmobaInfoService.Callback<GameDataServerOuterClass.CancelSmobaAuthRsp> paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCallback, "cb");
    this.f.b(paramCallback);
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoManager
 * JD-Core Version:    0.7.0.1
 */