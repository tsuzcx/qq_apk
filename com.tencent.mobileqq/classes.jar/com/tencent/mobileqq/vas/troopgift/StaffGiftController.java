package com.tencent.mobileqq.vas.troopgift;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawReq;
import com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawRsp;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IStatusNotify;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/StaffGiftController;", "Lcom/tencent/mobileqq/vas/troopgift/AbsTroopGiftController;", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "closeAnimation", "Lkotlin/Function0;", "", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/app/BaseActivity;)V", "STAFF_GIFT_TAG_DRAW_GIFT", "", "STAFF_GIFT_TAG_FULL_SCREEN", "USER_DRAW_IS_ALREADY_DRAW", "USER_DRAW_RESULT_IS_WIN_SP_KEY", "USER_DRAW_RESULT_TEXT_SP_KEY", "isFullScreenAnimEnd", "", "()Z", "setFullScreenAnimEnd", "(Z)V", "isUserClickedDraw", "setUserClickedDraw", "isUserDraw", "isUserDrawAnimEnd", "setUserDrawAnimEnd", "getDrawFeedbackText", "isSuccess", "rsp", "Lcom/tencent/trpcprotocol/qqva/allstaff/staff/StaffGiftDrawBean$DrawRsp;", "getLocalDrawResultName", "kotlin.jvm.PlatformType", "orderId", "getLocalIsUserAlreadyDraw", "getLocalIsUserWin", "getLocalText", "needPag", "onDrawPAGButtonClick", "callback", "Lkotlin/Function1;", "playAnimation", "setLocalDrawResult", "isWin", "text", "setStaffGiftSenderInfo", "shouldCloseStaffAnimation", "tag", "startDrawNetwork", "req", "Lcom/tencent/trpcprotocol/qqva/allstaff/staff/StaffGiftDrawBean$DrawReq;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class StaffGiftController
  extends AbsTroopGiftController
{
  private final String a = "1";
  private final String b = "4";
  private final String c = "user_draw_is_already_draw";
  private final String d = "user_draw_result_is_win_sp_key";
  private final String e = "user_draw_result_text_sp_key";
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public StaffGiftController(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0, @NotNull BaseActivity paramBaseActivity)
  {
    super(paramTroopGiftData, paramFunction0, paramBaseActivity);
  }
  
  private final String a(boolean paramBoolean, StaffGiftDrawBean.DrawRsp paramDrawRsp)
  {
    if (!paramBoolean) {
      return "网络开小差，请重试";
    }
    paramBoolean = paramDrawRsp.isNotRemained();
    Object localObject = "手慢了，福利已经抢完";
    if (paramBoolean) {
      return "手慢了，福利已经抢完";
    }
    if (paramDrawRsp.isNotValid()) {
      return "来晚啦，奖励已失效";
    }
    if (paramDrawRsp.isPumpCoin())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("恭喜你获得");
      ((StringBuilder)localObject).append(paramDrawRsp.FreeCoins.get());
      ((StringBuilder)localObject).append("个金币");
      return ((StringBuilder)localObject).toString();
    }
    if (paramDrawRsp.isPumpGift())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("恭喜你获得");
      ((StringBuilder)localObject).append(paramDrawRsp.GiftName.get());
      ((StringBuilder)localObject).append("礼物");
      return ((StringBuilder)localObject).toString();
    }
    if (paramDrawRsp.isAlreadyDraw()) {
      localObject = "你已抢过该奖励，注意查收~";
    }
    return localObject;
  }
  
  private final void b(TroopGiftData paramTroopGiftData)
  {
    Drawable localDrawable = a(paramTroopGiftData);
    f().getRuleManager().registerRuleLine("$AVATAR", new StaffGiftController.setStaffGiftSenderInfo.1(localDrawable));
    f().getRuleManager().registerRuleLine("$USER_INVOTE", new StaffGiftController.setStaffGiftSenderInfo.2(this, paramTroopGiftData));
  }
  
  private final String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user_draw_result_sp_key");
    localStringBuilder.append(paramString);
    paramString = m().app;
    Intrinsics.checkExpressionValueIsNotNull(paramString, "mActivity.app");
    localStringBuilder.append(paramString.getCurrentUin());
    return MD5Utils.toMD5(localStringBuilder.toString());
  }
  
  private final boolean e(String paramString)
  {
    if (Intrinsics.areEqual(paramString, this.a))
    {
      this.h = true;
      if ((!this.g) || (this.i)) {
        return true;
      }
    }
    else if (Intrinsics.areEqual(paramString, this.b))
    {
      this.i = true;
      if ((this.g) && (this.h)) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    Object localObject1 = QVipSDKProcessor.e();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QVipSDKProcessor.get()");
    if (!((QVipSDKConfig)localObject1).h())
    {
      QLog.d(b(), 2, "playStaffGift manage close");
      j();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "playAnimation");
    }
    localObject1 = TroopGiftResManager.a;
    String str = k().giftData.dataForClient.giftResourceAnd;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.dataForClient.giftResourceAnd");
    localObject1 = ((TroopGiftResManager)localObject1).b(new String[] { str });
    if (!a((File[])localObject1)) {
      return;
    }
    b(k());
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = false;
    str = k().giftData.dataForClient.orderId;
    Object localObject2 = (IStatusNotify)new StaffGiftController.playAnimation.notify.1(this, str);
    f().getRuleManager().registerRuleLine("gift_rush_btn", localObject2);
    f().getRuleManager().registerRuleLine("$SUBSCRIBE", new StaffGiftController.playAnimation.1(this));
    localObject2 = f().setTag("staff_gift");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject1[0].getPath());
    localStringBuilder.append('/');
    ((IXAEngine)localObject2).initRootAsync(localStringBuilder.toString(), (Function0)new StaffGiftController.playAnimation.2(this, str));
  }
  
  public final void a(@NotNull String paramString, @NotNull StaffGiftDrawBean.DrawReq paramDrawReq, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    Intrinsics.checkParameterIsNotNull(paramDrawReq, "req");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    PbProtocol.a("trpc.qqva.allstaff.staffGift.DrawReward", (MessageMicro)paramDrawReq, StaffGiftDrawBean.DrawRsp.class, (BusinessObserver)new StaffGiftController.startDrawNetwork.1(this, paramString, paramFunction1));
  }
  
  public final void a(@NotNull String paramString, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    if (this.f) {
      return;
    }
    this.f = true;
    if (!a(paramString))
    {
      StaffGiftDrawBean.DrawReq localDrawReq = new StaffGiftDrawBean.DrawReq();
      localDrawReq.orderNum.set(paramString);
      a(paramString, localDrawReq, paramFunction1);
      return;
    }
    boolean bool = b(paramString);
    paramString = c(paramString);
    if (bool)
    {
      this.g = true;
      f().getRuleManager().registerRuleLine("$SUCCESS_TEXT", new StaffGiftController.onDrawPAGButtonClick.1(paramString));
      paramFunction1.invoke("show");
      return;
    }
    f().getRuleManager().registerRuleLine("$FAIL_TEXT", new StaffGiftController.onDrawPAGButtonClick.2(paramString));
    paramFunction1.invoke("hide");
  }
  
  public final void a(@NotNull String paramString1, boolean paramBoolean, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "orderId");
    Intrinsics.checkParameterIsNotNull(paramString2, "text");
    QQAppInterface localQQAppInterface = m().app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mActivity.app");
    localQQAppInterface.getApp().getSharedPreferences(d(paramString1), 0).edit().putBoolean(this.c, true).putBoolean(this.d, paramBoolean).putString(this.e, paramString2).apply();
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    QQAppInterface localQQAppInterface = m().app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mActivity.app");
    return localQQAppInterface.getApp().getSharedPreferences(d(paramString), 0).getBoolean(this.c, false);
  }
  
  public final boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    QQAppInterface localQQAppInterface = m().app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mActivity.app");
    return localQQAppInterface.getApp().getSharedPreferences(d(paramString), 0).getBoolean(this.d, false);
  }
  
  @Nullable
  public final String c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    QQAppInterface localQQAppInterface = m().app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mActivity.app");
    return localQQAppInterface.getApp().getSharedPreferences(d(paramString), 0).getString(this.e, "");
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.StaffGiftController
 * JD-Core Version:    0.7.0.1
 */