package com.tencent.timi.game.smoba.api;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.router.IService;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.CancelSmobaAuthRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService;", "Lcom/tencent/timi/game/router/IService;", "agreeSmobaAuth", "", "cb", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "cancelSmobaAuth", "Ltrpc/yes/common/GameDataServerOuterClass$CancelSmobaAuthRsp;", "getDefaultSmobaAccountLiveData", "Landroidx/lifecycle/LiveData;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "getGameRoleAbsInfoListLiveData", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "getGameSmobaAuthInfoLiveData", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "initRegisterDatabaseModelClass", "requestDefaultSmobaAccountFromDbOrServer", "callback", "requestDefaultSmobaAccountFromServer", "requestGameRoleAbsInfoListFromDbOrServer", "requestGameRoleAbsInfoListFromServer", "requestSmobaAuthInfoFromDbOrServer", "requestSmobaAuthInfoFromServer", "setDefaultSmobaAccount", "defaultInfo", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "showAccountBindDialog", "context", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "accountList", "showAuthHintDialog", "autoShowAccountSelect", "", "authCallback", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$AuthToGetSmobaInfoCallback;", "bindAccountCallback", "authDesc", "", "", "showSwitchAccountDialog", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$SwitchSmobaAccountCallback;", "AuthToGetSmobaInfoCallback", "BindSmobaAccountCallback", "Callback", "DialogCallback", "SwitchSmobaAccountCallback", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IUserSmobaInfoService
  extends IService
{
  @NotNull
  public abstract LiveData<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> a();
  
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback);
  
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, @Nullable IUserSmobaInfoService.SwitchSmobaAccountCallback paramSwitchSmobaAccountCallback);
  
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull List<String> paramList, boolean paramBoolean, @Nullable IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback);
  
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback);
  
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, boolean paramBoolean, @Nullable IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback);
  
  public abstract void a(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetUserSmobaRoleListRsp> paramCallback);
  
  public abstract void a(@NotNull GameDataServerOuterClass.SmobaGameRoleAbsInfo paramSmobaGameRoleAbsInfo, @Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.SetSmobaDefaultRoleRsp> paramCallback);
  
  @NotNull
  public abstract LiveData<GameDataServerOuterClass.GetUserSmobaRoleListRsp> b();
  
  public abstract void b(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> paramCallback);
  
  @NotNull
  public abstract LiveData<GameDataServerOuterClass.GetSmobaAuthInfoRsp> c();
  
  public abstract void c(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> paramCallback);
  
  public abstract void d(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaAuthInfoRsp> paramCallback);
  
  public abstract void e(@NotNull IUserSmobaInfoService.Callback<GameDataServerOuterClass.CancelSmobaAuthRsp> paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.IUserSmobaInfoService
 * JD-Core Version:    0.7.0.1
 */