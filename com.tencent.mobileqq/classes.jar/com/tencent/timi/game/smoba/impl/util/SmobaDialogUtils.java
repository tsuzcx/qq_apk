package com.tencent.timi.game.smoba.impl.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.Companion;
import com.tencent.timi.game.smoba.impl.widget.SmobaAccountSelectView;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/util/SmobaDialogUtils;", "", "()V", "TAG", "", "doBindAccountTask", "", "contentView", "Lcom/tencent/timi/game/smoba/impl/widget/SmobaAccountSelectView;", "cb", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "context", "Lcom/tencent/mobileqq/app/QBaseActivity;", "dialog", "Landroid/content/DialogInterface;", "gotoAccountSelectLogic", "bindAccountCallback", "handleAuthDialogTaskOnAlreadyAuth", "authInfo", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$AuthToGetSmobaInfoCallback;", "autoShowAccountSelect", "", "onBindAccountResult", "result", "rsp", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "errorMsg", "errorCode", "", "showAccountBindDialog", "callback", "accountList", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "showAuthHintDialog", "desc", "", "showCreateSmobaAccountDialog", "showSwitchAccountDialog", "switchSmobaAccountCallback", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$SwitchSmobaAccountCallback;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaDialogUtils
{
  public static final SmobaDialogUtils a = new SmobaDialogUtils();
  
  private final void a(QBaseActivity paramQBaseActivity, DialogInterface paramDialogInterface, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    LoadingUtils.a.a(paramDialogInterface);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((IUserSmobaInfoService.Callback)new SmobaDialogUtils.gotoAccountSelectLogic.1(paramDialogInterface, paramQBaseActivity, paramBindSmobaAccountCallback));
  }
  
  private final void a(SmobaAccountSelectView paramSmobaAccountSelectView, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback, QBaseActivity paramQBaseActivity, DialogInterface paramDialogInterface)
  {
    LoadingUtils.a.a(paramDialogInterface);
    paramSmobaAccountSelectView = paramSmobaAccountSelectView.getCurrentSelectedAccount();
    paramBindSmobaAccountCallback = new SmobaDialogUtils.doBindAccountTask.setDefaultAccountCb.1(paramDialogInterface, paramBindSmobaAccountCallback, paramQBaseActivity);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(paramSmobaAccountSelectView, (IUserSmobaInfoService.Callback)paramBindSmobaAccountCallback);
  }
  
  private final void a(GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp, IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, boolean paramBoolean, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback, QBaseActivity paramQBaseActivity)
  {
    GameDataServerOuterClass.AgreeSmobaAuthRsp localAgreeSmobaAuthRsp = new GameDataServerOuterClass.AgreeSmobaAuthRsp();
    localAgreeSmobaAuthRsp.auth_desc.set(paramGetSmobaAuthInfoRsp.auth_desc.get());
    localAgreeSmobaAuthRsp.is_auth.set(paramGetSmobaAuthInfoRsp.is_auth.get());
    if (paramAuthToGetSmobaInfoCallback != null) {
      paramAuthToGetSmobaInfoCallback.a(localAgreeSmobaAuthRsp);
    }
    if (!paramBoolean) {
      return;
    }
    paramGetSmobaAuthInfoRsp = new SmobaDialogUtils.handleAuthDialogTaskOnAlreadyAuth.defaultAccountCallback.1(paramBindSmobaAccountCallback, paramQBaseActivity);
    UserSmobaInfoManager.a.a().b((IUserSmobaInfoService.Callback)paramGetSmobaAuthInfoRsp);
  }
  
  private final void a(boolean paramBoolean, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback, QBaseActivity paramQBaseActivity, GameDataServerOuterClass.SetSmobaDefaultRoleRsp paramSetSmobaDefaultRoleRsp, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramSetSmobaDefaultRoleRsp != null))
    {
      QQToast.makeText((Context)paramQBaseActivity, (CharSequence)paramQBaseActivity.getResources().getString(2131916701), 0).show();
      paramQBaseActivity = new GameDataServerOuterClass.GetSmobaDefaultRoleRsp();
      paramQBaseActivity.role_info.set(paramSetSmobaDefaultRoleRsp.role_info.get());
      if (paramBindSmobaAccountCallback != null) {
        paramBindSmobaAccountCallback.a(paramQBaseActivity);
      }
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(null);
      return;
    }
    QQToast.makeText((Context)paramQBaseActivity, (CharSequence)paramString, 0).show();
    if (paramBindSmobaAccountCallback != null) {
      paramBindSmobaAccountCallback.a(paramInt, paramString);
    }
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    CommonDialog localCommonDialog = new CommonDialog.Builder((Context)paramQBaseActivity).a("需要绑定你的默认王者帐号").c("你的QQ帐号暂无王者角色信息，去王者创建后开黑扩列更便捷").d("去创建").a((DialogInterface.OnClickListener)SmobaDialogUtils.showCreateSmobaAccountDialog.commonDialog.1.a).e("知道了").b((DialogInterface.OnClickListener)SmobaDialogUtils.showCreateSmobaAccountDialog.commonDialog.2.a).b(true).a();
    paramQBaseActivity = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (paramQBaseActivity != null) {
      paramQBaseActivity = paramQBaseActivity.e();
    } else {
      paramQBaseActivity = null;
    }
    if (paramQBaseActivity != null) {
      paramQBaseActivity.a(localCommonDialog);
    }
    if (paramQBaseActivity != null) {
      paramQBaseActivity.a((View)localCommonDialog.b(), paramQBaseActivity.k());
    }
    if (paramQBaseActivity != null) {
      paramQBaseActivity.a((View)localCommonDialog.a(), paramQBaseActivity.l());
    }
    localCommonDialog.show();
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    LoadingUtils.a.a((Context)paramQBaseActivity);
    paramQBaseActivity = new SmobaDialogUtils.showAccountBindDialog.cb.1(paramQBaseActivity, paramBindSmobaAccountCallback);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((IUserSmobaInfoService.Callback)paramQBaseActivity);
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @Nullable IUserSmobaInfoService.SwitchSmobaAccountCallback paramSwitchSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    IService localIService = ServiceCenter.a(ITeamService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService(ITeamService::class.java)");
    if (((ITeamService)localIService).a())
    {
      QQToast.makeText((Context)paramQBaseActivity, 2131886637, 0).show();
      return;
    }
    LoadingUtils.a.a((Context)paramQBaseActivity);
    paramQBaseActivity = new SmobaDialogUtils.showSwitchAccountDialog.getRoleList.1(paramQBaseActivity, paramSwitchSmobaAccountCallback);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((IUserSmobaInfoService.Callback)paramQBaseActivity);
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull List<String> paramList, boolean paramBoolean, @Nullable IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramList, "desc");
    Object localObject2 = (Context)paramQBaseActivity;
    CommonDialog.Builder localBuilder = new CommonDialog.Builder((Context)localObject2);
    localBuilder.a("QQ请求以下权限");
    Object localObject1 = null;
    localObject2 = View.inflate((Context)localObject2, 2131629511, null);
    TextView localTextView;
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "contentView");
      localTextView = (TextView)((View)localObject2).findViewById(2131431734);
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "contentView.desc1Txv");
      localTextView.setText((CharSequence)paramList.get(0));
    }
    if (paramList.size() > 1)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "contentView");
      localTextView = (TextView)((View)localObject2).findViewById(2131431735);
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "contentView.desc2Txv");
      localTextView.setText((CharSequence)paramList.get(1));
    }
    CommonDialog.Builder.a(localBuilder, (View)localObject2, 0, CommonExKt.a(24), 0, CommonExKt.a(25), 10, null);
    localBuilder.e("暂不");
    localBuilder.d("允许");
    localBuilder.b((DialogInterface.OnClickListener)new SmobaDialogUtils.showAuthHintDialog.1(paramAuthToGetSmobaInfoCallback));
    localBuilder.a((DialogInterface.OnClickListener)new SmobaDialogUtils.showAuthHintDialog.2(paramQBaseActivity, paramAuthToGetSmobaInfoCallback, paramBoolean, paramBindSmobaAccountCallback));
    localBuilder.c(false);
    localBuilder.b(true);
    try
    {
      paramList = localBuilder.a();
      paramBindSmobaAccountCallback = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
      paramQBaseActivity = localObject1;
      if (paramBindSmobaAccountCallback != null) {
        paramQBaseActivity = paramBindSmobaAccountCallback.e();
      }
      if (paramQBaseActivity != null) {
        paramQBaseActivity.a(paramList);
      }
      if (paramQBaseActivity != null) {
        paramQBaseActivity.a((View)paramList.b(), paramQBaseActivity.f());
      }
      if (paramQBaseActivity != null) {
        paramQBaseActivity.a((View)paramList.a(), paramQBaseActivity.g());
      }
      paramList.show();
    }
    catch (Exception paramQBaseActivity)
    {
      Logger.a("SmobaDialogUtils_", "show failed", (Throwable)paramQBaseActivity);
    }
    if (paramAuthToGetSmobaInfoCallback != null) {
      paramAuthToGetSmobaInfoCallback.b();
    }
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramGetUserSmobaRoleListRsp, "accountList");
    paramGetUserSmobaRoleListRsp = paramGetUserSmobaRoleListRsp.role_list.get();
    if (paramGetUserSmobaRoleListRsp.size() == 0)
    {
      Logger.c("SmobaDialogUtils_", "showAccountBindDialog data.size == 0");
      a(paramQBaseActivity);
      if (paramBindSmobaAccountCallback != null) {
        paramBindSmobaAccountCallback.a(-1, "account list is 0");
      }
      return;
    }
    Object localObject = (Context)paramQBaseActivity;
    CommonDialog.Builder localBuilder = new CommonDialog.Builder((Context)localObject);
    localBuilder.a("需要绑定你的默认王者帐号");
    localBuilder.b("用于展示战绩及王者组队游戏");
    localObject = new SmobaAccountSelectView((Context)localObject, null, 0, 6, null);
    Intrinsics.checkExpressionValueIsNotNull(paramGetUserSmobaRoleListRsp, "data");
    ((SmobaAccountSelectView)localObject).setData(paramGetUserSmobaRoleListRsp);
    localBuilder.a((View)localObject, CommonExKt.a(28), CommonExKt.a(14), CommonExKt.a(28), CommonExKt.a(25));
    localBuilder.e("暂不");
    localBuilder.d("确定");
    localBuilder.b((DialogInterface.OnClickListener)new SmobaDialogUtils.showAccountBindDialog.1(paramBindSmobaAccountCallback));
    localBuilder.a((DialogInterface.OnClickListener)new SmobaDialogUtils.showAccountBindDialog.2((SmobaAccountSelectView)localObject, paramBindSmobaAccountCallback, paramQBaseActivity));
    localBuilder.b(true);
    localBuilder.c(false);
    for (;;)
    {
      try
      {
        paramGetUserSmobaRoleListRsp = localBuilder.a();
        paramQBaseActivity = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
        if (paramQBaseActivity == null) {
          break label336;
        }
        paramQBaseActivity = paramQBaseActivity.e();
        if (paramQBaseActivity != null) {
          paramQBaseActivity.a(paramGetUserSmobaRoleListRsp);
        }
        if (paramQBaseActivity != null) {
          paramQBaseActivity.a((View)paramGetUserSmobaRoleListRsp.b(), paramQBaseActivity.k());
        }
        if (paramQBaseActivity != null) {
          paramQBaseActivity.a((View)paramGetUserSmobaRoleListRsp.a(), paramQBaseActivity.j());
        }
        paramGetUserSmobaRoleListRsp.show();
      }
      catch (Exception paramQBaseActivity)
      {
        Logger.a("SmobaDialogUtils_", "show failed", (Throwable)paramQBaseActivity);
      }
      if (paramBindSmobaAccountCallback != null) {
        paramBindSmobaAccountCallback.b();
      }
      return;
      label336:
      paramQBaseActivity = null;
    }
  }
  
  public final void a(@NotNull QBaseActivity paramQBaseActivity, boolean paramBoolean, @Nullable IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, @Nullable IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    Object localObject = (GameDataServerOuterClass.GetSmobaAuthInfoRsp)UserSmobaInfoManager.a.a().c().getValue();
    if (localObject != null)
    {
      if (((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject).is_auth.get())
      {
        a((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject, paramAuthToGetSmobaInfoCallback, paramBoolean, paramBindSmobaAccountCallback, paramQBaseActivity);
        return;
      }
      localObject = ((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject).auth_desc.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "authInfo.auth_desc.get()");
      a(paramQBaseActivity, (List)localObject, paramBoolean, paramAuthToGetSmobaInfoCallback, paramBindSmobaAccountCallback);
      return;
    }
    LoadingUtils.a.a((Context)paramQBaseActivity);
    paramQBaseActivity = new SmobaDialogUtils.showAuthHintDialog.getAuthInfoCb.1(paramQBaseActivity, paramBoolean, paramAuthToGetSmobaInfoCallback, paramBindSmobaAccountCallback);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d((IUserSmobaInfoService.Callback)paramQBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils
 * JD-Core Version:    0.7.0.1
 */