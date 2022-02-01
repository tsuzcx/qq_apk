package com.tencent.mobileqq.vas.troopgift;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawReq;
import com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawRsp;
import com.tencent.xaction.openapi.XAApi;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IStatusNotify;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController;", "", "mContext", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "COMMON_GIFT_TAG_COMBO", "", "getCOMMON_GIFT_TAG_COMBO", "()Ljava/lang/String;", "COMMON_GIFT_TAG_GIFT", "getCOMMON_GIFT_TAG_GIFT", "STAFF_GIFT_TAG_DRAW_GIFT", "STAFF_GIFT_TAG_FULL_SCREEN", "TAG", "USER_DRAW_IS_ALREADY_DRAW", "USER_DRAW_RESULT_IS_WIN_SP_KEY", "USER_DRAW_RESULT_TEXT_SP_KEY", "isComboAnimEnd", "", "()Z", "setComboAnimEnd", "(Z)V", "isCommonGiftAnimEnd", "setCommonGiftAnimEnd", "isCommonGiftUsingXA", "isFullScreenAnimEnd", "setFullScreenAnimEnd", "isUserClickedDraw", "setUserClickedDraw", "isUserDraw", "isUserDrawAnimEnd", "setUserDrawAnimEnd", "mComboView", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftComboView;", "getMContext", "()Lcom/tencent/mobileqq/app/BaseActivity;", "mGiftView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "mLayout", "Landroid/widget/FrameLayout;", "mStopBtn", "Landroid/widget/ImageView;", "senderAvatarCallback", "com/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$senderAvatarCallback$1", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$senderAvatarCallback$1;", "times", "", "xaController", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftComboXAController;", "xaEngine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getXaEngine", "()Lcom/tencent/xaction/openapi/api/IXAEngine;", "setXaEngine", "(Lcom/tencent/xaction/openapi/api/IXAEngine;)V", "filesAllExist", "files", "", "Ljava/io/File;", "([Ljava/io/File;)Z", "getDrawFeedbackText", "isSuccess", "rsp", "Lcom/tencent/trpcprotocol/qqva/allstaff/staff/StaffGiftDrawBean$DrawRsp;", "getLocalDrawResultName", "kotlin.jvm.PlatformType", "orderId", "getLocalIsUserAlreadyDraw", "getLocalIsUserWin", "getLocalText", "getNickname", "troopUin", "senderUin", "getPAGLayout", "getSenderDrawable", "Landroid/graphics/drawable/Drawable;", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "getXACommonGiftJson", "comboPath", "giftPath", "initXA", "", "loadAvatars", "onDrawPAGButtonClick", "callback", "Lkotlin/Function1;", "playCommonGift", "closeAnimation", "Lkotlin/Function0;", "playCommonGiftByOld", "playCommonGiftByXA", "playStaffGift", "registerAvatarRule", "xa", "senderDrawable", "receiverDrawable", "registerRule", "setLocalDrawResult", "isWin", "text", "setStaffGiftSenderInfo", "shouldCloseCommonGift", "tag", "shouldCloseStaffAnimation", "startDrawNetwork", "req", "Lcom/tencent/trpcprotocol/qqva/allstaff/staff/StaffGiftDrawBean$DrawReq;", "PlayState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftPAGAnimationController
{
  private int jdField_a_of_type_Int;
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final TroopGiftComboView jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView;
  private TroopGiftComboXAController jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboXAController;
  private final TroopGiftPAGAnimationController.senderAvatarCallback.1 jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$senderAvatarCallback$1;
  private final VasPagView jdField_a_of_type_ComTencentMobileqqVasUiVasPagView;
  @NotNull
  public IXAEngine a;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  @NotNull
  private final String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private final String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private final String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private final String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private final String h;
  
  public TroopGiftPAGAnimationController(@NotNull BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaLangString = "TroopGiftPAGAnimationController";
    paramBaseActivity = QVipSDKProcessor.c();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "QVipSDKProcessor.get()");
    this.jdField_a_of_type_Boolean = paramBaseActivity.f();
    this.jdField_b_of_type_JavaLangString = "1";
    this.jdField_c_of_type_JavaLangString = "2";
    this.jdField_d_of_type_JavaLangString = "1";
    this.jdField_e_of_type_JavaLangString = "4";
    this.jdField_f_of_type_JavaLangString = "user_draw_is_already_draw";
    this.jdField_g_of_type_JavaLangString = "user_draw_result_is_win_sp_key";
    this.h = "user_draw_result_text_sp_key";
    paramBaseActivity = LayoutInflater.from((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131560727, null, false);
    if (paramBaseActivity != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramBaseActivity);
      paramBaseActivity = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131364892);
      Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "mLayout.findViewById(R.id.combo_pag)");
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView = ((TroopGiftComboView)paramBaseActivity);
      paramBaseActivity = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367710);
      Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "mLayout.findViewById(R.id.gift_pag)");
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = ((VasPagView)paramBaseActivity);
      paramBaseActivity = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379360);
      Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "mLayout.findViewById(R.i…end_gift_animation_close)");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView.a().a();
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a().a();
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$senderAvatarCallback$1 = new TroopGiftPAGAnimationController.senderAvatarCallback.1(this);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
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
      ((StringBuilder)localObject).append("个潮鹅币");
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
  
  private final void a(IXAEngine paramIXAEngine, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    IPublicRuleManager localIPublicRuleManager = paramIXAEngine.getRuleManager();
    paramDrawable1 = TroopUtils.a(paramDrawable1);
    Intrinsics.checkExpressionValueIsNotNull(paramDrawable1, "TroopUtils.headDrawableToBitamp(senderDrawable)");
    localIPublicRuleManager.registerRuleLine("$GIFT_SEND_AVATAR", paramDrawable1);
    paramIXAEngine = paramIXAEngine.getRuleManager();
    paramDrawable1 = TroopUtils.a(paramDrawable2);
    Intrinsics.checkExpressionValueIsNotNull(paramDrawable1, "TroopUtils.headDrawableToBitamp(receiverDrawable)");
    paramIXAEngine.registerRuleLine("$GIFT_RECEIVE_AVATAR", paramDrawable1);
  }
  
  private final String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user_draw_result_sp_key");
    localStringBuilder.append(paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(paramString, "mContext.app");
    localStringBuilder.append(paramString.getCurrentUin());
    return MD5Utils.toMD5(localStringBuilder.toString());
  }
  
  private final void b(TroopGiftData paramTroopGiftData)
  {
    Object localObject = a(paramTroopGiftData);
    IXAEngine localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localIXAEngine == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    localIXAEngine.getRuleManager().registerRuleLine("$AVATAR", new TroopGiftPAGAnimationController.setStaffGiftSenderInfo.1((Drawable)localObject));
    localObject = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    ((IXAEngine)localObject).getRuleManager().registerRuleLine("$USER_INVOTE", new TroopGiftPAGAnimationController.setStaffGiftSenderInfo.2(this, paramTroopGiftData));
  }
  
  private final void c(TroopGiftData paramTroopGiftData)
  {
    if (((TroopGiftPAGAnimationController)this).jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine != null)
    {
      localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
      if (localIXAEngine == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
      }
      localIXAEngine.destroy();
    }
    IXAEngine localIXAEngine = XAApi.c((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    Intrinsics.checkExpressionValueIsNotNull(localIXAEngine, "XAApi.create(mContext)");
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine = localIXAEngine;
    localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localIXAEngine == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboXAController = new TroopGiftComboXAController(localIXAEngine);
    localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localIXAEngine == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    localIXAEngine.setContentLayout((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout);
    localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localIXAEngine == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    a(localIXAEngine, paramTroopGiftData);
  }
  
  private final boolean d(String paramString)
  {
    if (Intrinsics.areEqual(paramString, this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_f_of_type_Boolean = true;
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_g_of_type_Boolean)) {
        return true;
      }
    }
    else if (Intrinsics.areEqual(paramString, this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public final Drawable a(@NotNull TroopGiftData paramTroopGiftData)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
    if (Intrinsics.areEqual(paramTroopGiftData.giftData.dataForClient.sendUin, "80000000"))
    {
      paramTroopGiftData = paramTroopGiftData.giftData.dataForClient.anonymousPortraitIdx;
      Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "giftData.giftData.dataFo…ient.anonymousPortraitIdx");
      paramTroopGiftData = AnonymousChatHelper.a(Integer.parseInt(paramTroopGiftData));
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130843811);
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "mContext.resources.getDr…mous_default_header_icon)");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      paramTroopGiftData = URLDrawable.getDrawable(paramTroopGiftData, localURLDrawableOptions);
      Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "URLDrawable.getDrawable(avatarUrl, options)");
      return (Drawable)paramTroopGiftData;
    }
    paramTroopGiftData = FaceDrawable.getFaceDrawable((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, paramTroopGiftData.giftData.dataForClient.sendUin, 3, localDrawable, localDrawable, (FaceDrawable.OnLoadingStateChangeListener)new TroopGiftPAGAnimationController.getSenderDrawable.1(this, paramTroopGiftData, localDrawable));
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "FaceDrawable.getFaceDraw…          }\n            }");
    return (Drawable)paramTroopGiftData;
  }
  
  @NotNull
  public final FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  @NotNull
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  @NotNull
  public final IXAEngine a()
  {
    IXAEngine localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localIXAEngine == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    return localIXAEngine;
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mContext.app");
    return localQQAppInterface.getApp().getSharedPreferences(b(paramString), 0).getString(this.h, "");
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "troopUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "senderUin");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getRuntimeService(ITroopMemberNameService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mContext.app.getRuntimeS…va, ProcessConstant.MAIN)");
    localObject = (ITroopMemberNameService)localObject;
    if (localObject != null)
    {
      paramString1 = ((ITroopMemberNameService)localObject).getTroopMemberNameWithoutRemark(paramString1, paramString2);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "nameService.getTroopMemb…mark(troopUin, senderUin)");
      return paramString1;
    }
    return paramString2;
  }
  
  public final void a(@NotNull TroopGiftData paramTroopGiftData)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadAvatars");
    }
    Object localObject1 = ImageUtil.f();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "defAvatar");
    ((TroopGiftComboView)localObject2).setAvatars((Bitmap)localObject1, (Bitmap)localObject1);
    localObject2 = FaceDrawable.getDefaultDrawable(1, 3);
    localObject1 = a(paramTroopGiftData);
    this.jdField_a_of_type_Int = 0;
    if (!(localObject1 instanceof FaceDrawable)) {
      ((Drawable)localObject1).setCallback((Drawable.Callback)this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$senderAvatarCallback$1);
    } else {
      ((FaceDrawable)localObject1).setCallback((Drawable.Callback)null);
    }
    paramTroopGiftData = FaceDrawable.getFaceDrawable((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, paramTroopGiftData.giftData.dataForClient.recvUin, 3, (Drawable)localObject2, (Drawable)localObject2, (FaceDrawable.OnLoadingStateChangeListener)new TroopGiftPAGAnimationController.loadAvatars.receiverDrawable.1(this, paramTroopGiftData, (Drawable)localObject2));
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
      }
      Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "receiverDrawable");
      paramTroopGiftData = (Drawable)paramTroopGiftData;
      a((IXAEngine)localObject2, (Drawable)localObject1, paramTroopGiftData);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboXAController;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xaController");
      }
      ((TroopGiftComboXAController)localObject2).a((Drawable)localObject1, paramTroopGiftData);
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView;
    localObject1 = TroopUtils.a((Drawable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "TroopUtils.headDrawableToBitamp(senderDrawable)");
    paramTroopGiftData = TroopUtils.a((Drawable)paramTroopGiftData);
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "TroopUtils.headDrawableToBitamp(receiverDrawable)");
    ((TroopGiftComboView)localObject2).setAvatars((Bitmap)localObject1, paramTroopGiftData);
  }
  
  public final void a(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "closeAnimation");
    if (this.jdField_a_of_type_Boolean)
    {
      c(paramTroopGiftData, paramFunction0);
      return;
    }
    b(paramTroopGiftData, paramFunction0);
  }
  
  public final void a(@NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "<set-?>");
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine = paramIXAEngine;
  }
  
  public final void a(@NotNull IXAEngine paramIXAEngine, @NotNull TroopGiftData paramTroopGiftData)
  {
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "xa");
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    IPublicRuleManager localIPublicRuleManager = paramIXAEngine.getRuleManager();
    String str = paramTroopGiftData.giftData.dataForClient.troopUin;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.dataForClient.troopUin");
    localIPublicRuleManager.registerRuleLine("$GIFT_SEND_NICK", a(str, String.valueOf(paramTroopGiftData.getSenderUin())));
    paramIXAEngine.getRuleManager().registerRuleLine("$GIFT_SEND_UIN", String.valueOf(paramTroopGiftData.getSenderUin()));
    localIPublicRuleManager = paramIXAEngine.getRuleManager();
    str = paramTroopGiftData.giftData.receiverNick;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.receiverNick");
    localIPublicRuleManager.registerRuleLine("$GIFT_RECEIVE_NICK", str);
    localIPublicRuleManager = paramIXAEngine.getRuleManager();
    str = paramTroopGiftData.giftData.dataForClient.recvUin;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.dataForClient.recvUin");
    localIPublicRuleManager.registerRuleLine("$GIFT_RECEIVE_UIN", str);
    localIPublicRuleManager = paramIXAEngine.getRuleManager();
    str = paramTroopGiftData.giftData.giftName;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.giftName");
    localIPublicRuleManager.registerRuleLine("$GIFT_NAME", str);
    localIPublicRuleManager = paramIXAEngine.getRuleManager();
    str = paramTroopGiftData.giftData.score;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.score");
    localIPublicRuleManager.registerRuleLine("$GIFT_CHARM", str);
    localIPublicRuleManager = paramIXAEngine.getRuleManager();
    str = paramTroopGiftData.giftData.count;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.count");
    localIPublicRuleManager.registerRuleLine("$GIFT_COUNT", str);
    paramIXAEngine = paramIXAEngine.getRuleManager();
    paramTroopGiftData = paramTroopGiftData.giftData.dataForClient.giftType;
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "giftData.giftData.dataForClient.giftType");
    paramIXAEngine.registerRuleLine("$GIFT_TYPE", paramTroopGiftData);
  }
  
  public final void a(@NotNull String paramString, @NotNull StaffGiftDrawBean.DrawReq paramDrawReq, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    Intrinsics.checkParameterIsNotNull(paramDrawReq, "req");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    PbProtocol.a("trpc.qqva.allstaff.staffGift.DrawReward", (MessageMicro)paramDrawReq, StaffGiftDrawBean.DrawRsp.class, (BusinessObserver)new TroopGiftPAGAnimationController.startDrawNetwork.1(this, paramString, paramFunction1));
  }
  
  public final void a(@NotNull String paramString, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (!b(paramString))
    {
      localObject = new StaffGiftDrawBean.DrawReq();
      ((StaffGiftDrawBean.DrawReq)localObject).orderNum.set(paramString);
      a(paramString, (StaffGiftDrawBean.DrawReq)localObject, paramFunction1);
      return;
    }
    boolean bool = c(paramString);
    paramString = a(paramString);
    if (bool)
    {
      this.jdField_c_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
      }
      ((IXAEngine)localObject).getRuleManager().registerRuleLine("$SUCCESS_TEXT", new TroopGiftPAGAnimationController.onDrawPAGButtonClick.1(paramString));
      paramFunction1.invoke("show");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    ((IXAEngine)localObject).getRuleManager().registerRuleLine("$FAIL_TEXT", new TroopGiftPAGAnimationController.onDrawPAGButtonClick.2(paramString));
    paramFunction1.invoke("hide");
  }
  
  public final void a(@NotNull String paramString1, boolean paramBoolean, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "orderId");
    Intrinsics.checkParameterIsNotNull(paramString2, "text");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mContext.app");
    localQQAppInterface.getApp().getSharedPreferences(b(paramString1), 0).edit().putBoolean(this.jdField_f_of_type_JavaLangString, true).putBoolean(this.jdField_g_of_type_JavaLangString, paramBoolean).putString(this.h, paramString2).apply();
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    if (Intrinsics.areEqual(paramString, this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_d_of_type_Boolean = true;
      return this.jdField_e_of_type_Boolean;
    }
    if (Intrinsics.areEqual(paramString, this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_e_of_type_Boolean = true;
      return this.jdField_d_of_type_Boolean;
    }
    return false;
  }
  
  public final boolean a(@NotNull File[] paramArrayOfFile)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFile, "files");
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      if (!paramArrayOfFile[i].exists()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @NotNull
  public final String b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "comboPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "giftPath");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n                {\n                  \"version\": \"1.0\",\n                  \"versionCode\": 1,\n                  \"eles\": [\n                            {\n                              \"id\": 1,\n                              \"type\": \"pagview\",\n                              \"exts\": {\n                                        \"pagfile\": \"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/combo/combo.pag\",\n                                        \"text\": [\n                                                  {\n                                                    \"layer\": 0,\n                                                    \"value\": \"$PAG_TEXT\"\n                                                  }\n                                                ],\n                                        \"image\": [\n                                                   {\n                                                     \"layer\": 0,\n                                                     \"value\": \"$SENDER_AVATAR\"\n                                                   },\n                                                   {\n                                                     \"layer\": 1,\n                                                     \"value\": \"$RECEIVER_AVATAR\"\n                                                   }\n                                                 ],\n                                        \"block\": [\"$COMBO_BLOCK\"]\n                                      },\n                              \"st\": {\n                                     \"bc\": \"#ff0aaa\",\n                                     \"w\": 750,\n                                     \"h\": 1334,\n                                     \"y\": -450\n                                    }\n                            },\n                            {\n                              \"id\": 2,\n                              \"type\": \"pagview\",\n                              \"exts\": {\n                                        \"pagfile\": \"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("/gift/gift.pag\",\n                                        \"block\": [\"$BLOCK2\"]\n                                      },\n                              \"st\": {\n                                     \"bc\": \"#ff0aaa\",\n                                     \"w\": 750,\n                                     \"h\": 1334,\n                                     \"y\": 80\n                                    }\n                            }\n                          ]\n                 }\n                    ");
    return StringsKt.trimIndent(localStringBuilder.toString());
  }
  
  public final void b(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "closeAnimation");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "playCommonGift");
    }
    Object localObject1 = paramTroopGiftData.giftData.dataForClient.sendCount;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "giftData.giftData.dataForClient.sendCount");
    int i = Integer.parseInt((String)localObject1);
    Object localObject2 = new String[2];
    localObject2[0] = paramTroopGiftData.giftData.dataForClient.continueAnimationAnd;
    localObject2[1] = paramTroopGiftData.giftData.dataForClient.giftResourceAnd;
    localObject1 = TroopGiftResManager.a.a((String[])localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new TroopGiftPAGAnimationController.playCommonGiftByOld.1(paramFunction0));
    if (localObject1[0].exists())
    {
      String str = localObject1[0].getPath();
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append("/combo/combo.pag");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/combo/combo.ttf");
      ((TroopGiftComboView)localObject3).setPAGResource((String)localObject4, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView.a(i);
      if (QLog.isColorLevel())
      {
        localObject3 = this.jdField_a_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("\n                        giftID: ");
        ((StringBuilder)localObject4).append(paramTroopGiftData.giftData.dataForClient.giftId);
        ((StringBuilder)localObject4).append("\n                        file url: ");
        ((StringBuilder)localObject4).append(localObject2[0]);
        ((StringBuilder)localObject4).append("\n                        file path: ");
        ((StringBuilder)localObject4).append(str);
        ((StringBuilder)localObject4).append("\n                        file MD5: ");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("/combo/combo.pag");
        ((StringBuilder)localObject4).append(MD5Utils.encodeFileHexStr(((StringBuilder)localObject2).toString()));
        ((StringBuilder)localObject4).append("\n                        ");
        QLog.e((String)localObject3, 2, StringsKt.trimIndent(((StringBuilder)localObject4).toString()));
      }
    }
    if (localObject1[1].exists()) {
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a().a((Function1)new TroopGiftPAGAnimationController.playCommonGiftByOld.2((File[])localObject1));
    }
    a(paramTroopGiftData);
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a().a((Function1)new TroopGiftPAGAnimationController.playCommonGiftByOld.3(this, paramFunction0));
    if ((!localObject1[0].exists()) && (!localObject1[1].exists())) {
      paramFunction0.invoke();
    }
  }
  
  public final boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mContext.app");
    return localQQAppInterface.getApp().getSharedPreferences(b(paramString), 0).getBoolean(this.jdField_f_of_type_JavaLangString, false);
  }
  
  public final void c(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "closeAnimation");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "playCommonGiftByXA");
    }
    Object localObject = paramTroopGiftData.giftData.dataForClient.sendCount;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "giftData.giftData.dataForClient.sendCount");
    int i = Integer.parseInt((String)localObject);
    localObject = paramTroopGiftData.giftData.dataForClient.continueAnimationAnd;
    String str1 = paramTroopGiftData.giftData.dataForClient.giftResourceAnd;
    localObject = TroopGiftResManager.a.a(new String[] { localObject, str1 });
    if (!a((File[])localObject)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new TroopGiftPAGAnimationController.playCommonGiftByXA.1(paramFunction0));
    c(paramTroopGiftData);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    str1 = localObject[0].getPath();
    String str2 = localObject[1].getPath();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append("/combo/combo.ttf");
    localObject = ((StringBuilder)localObject).toString();
    a(paramTroopGiftData);
    paramTroopGiftData = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (paramTroopGiftData == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    paramTroopGiftData.getRuleManager().registerRuleLine("$SUBSCRIBE", new TroopGiftPAGAnimationController.playCommonGiftByXA.2(this, paramFunction0));
    Intrinsics.checkExpressionValueIsNotNull(str1, "comboPath");
    Intrinsics.checkExpressionValueIsNotNull(str2, "giftPath");
    paramTroopGiftData = b(str1, str2);
    paramFunction0 = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (paramFunction0 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    paramFunction0.setTag("common_gift");
    paramFunction0 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboXAController;
    if (paramFunction0 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaController");
    }
    paramFunction0.a(i, (String)localObject);
    paramFunction0 = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (paramFunction0 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    paramFunction0.init(paramTroopGiftData);
    paramTroopGiftData = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (paramTroopGiftData == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    paramTroopGiftData.start();
  }
  
  public final boolean c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "orderId");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "mContext.app");
    return localQQAppInterface.getApp().getSharedPreferences(b(paramString), 0).getBoolean(this.jdField_g_of_type_JavaLangString, false);
  }
  
  public final void d(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "closeAnimation");
    Object localObject1 = QVipSDKProcessor.c();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QVipSDKProcessor.get()");
    if (!((QVipSDKConfig)localObject1).g())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "playStaffGift manage close");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "playStaffGift");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new TroopGiftPAGAnimationController.playStaffGift.1(paramFunction0));
    localObject1 = TroopGiftResManager.a;
    Object localObject2 = paramTroopGiftData.giftData.dataForClient.giftResourceAnd;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "giftData.giftData.dataForClient.giftResourceAnd");
    localObject1 = ((TroopGiftResManager)localObject1).a(new String[] { localObject2 });
    if (!a((File[])localObject1)) {
      return;
    }
    c(paramTroopGiftData);
    b(paramTroopGiftData);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    paramTroopGiftData = paramTroopGiftData.giftData.dataForClient.orderId;
    localObject2 = (IStatusNotify)new TroopGiftPAGAnimationController.playStaffGift.notify.1(this, paramTroopGiftData);
    IXAEngine localIXAEngine = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localIXAEngine == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    localIXAEngine.getRuleManager().registerRuleLine("gift_rush_btn", localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    ((IXAEngine)localObject2).getRuleManager().registerRuleLine("$SUBSCRIBE", new TroopGiftPAGAnimationController.playStaffGift.2(this, paramFunction0));
    paramFunction0 = this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
    if (paramFunction0 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xaEngine");
    }
    paramFunction0 = paramFunction0.setTag("staff_gift");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localObject1[0].getPath());
    ((StringBuilder)localObject2).append('/');
    paramFunction0.initRootAsync(((StringBuilder)localObject2).toString(), (Function0)new TroopGiftPAGAnimationController.playStaffGift.3(this, paramTroopGiftData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController
 * JD-Core Version:    0.7.0.1
 */