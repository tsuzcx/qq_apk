package com.tencent.mobileqq.vas.troopgift;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/CommonGiftController;", "Lcom/tencent/mobileqq/vas/troopgift/AbsTroopGiftController;", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "closeAnimation", "Lkotlin/Function0;", "", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/app/BaseActivity;)V", "COMMON_GIFT_TAG_COMBO", "", "getCOMMON_GIFT_TAG_COMBO", "()Ljava/lang/String;", "COMMON_GIFT_TAG_GIFT", "getCOMMON_GIFT_TAG_GIFT", "TAG", "getTAG", "comboState", "Lcom/tencent/mobileqq/vas/troopgift/PlayState;", "isComboAnimEnd", "", "()Z", "setComboAnimEnd", "(Z)V", "isCommonGiftAnimEnd", "setCommonGiftAnimEnd", "isCommonGiftUsingXA", "mComboView", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftComboView;", "mGiftView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "pagState", "senderAvatarCallback", "com/tencent/mobileqq/vas/troopgift/CommonGiftController$senderAvatarCallback$1", "Lcom/tencent/mobileqq/vas/troopgift/CommonGiftController$senderAvatarCallback$1;", "textAnimationDuration", "", "times", "", "wholeState", "getWholeState$AQQLiteApp_release", "()Lcom/tencent/mobileqq/vas/troopgift/PlayState;", "setWholeState$AQQLiteApp_release", "(Lcom/tencent/mobileqq/vas/troopgift/PlayState;)V", "getDefDuration", "comboTimes", "getSenderDrawable", "Landroid/graphics/drawable/Drawable;", "loadAvatars", "needPag", "playAnimation", "playCommonGiftByOld", "playCommonGiftByXA", "registerPathRule", "comboPath", "giftPath", "setComboAnimationForXA", "fontPath", "shouldCloseCommonGift", "tag", "hasXAJsonFile", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class CommonGiftController
  extends AbsTroopGiftController
{
  @NotNull
  private final String a = "AbsTroopGiftController";
  private final boolean b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  private final TroopGiftComboView e;
  private final VasPagView f;
  private boolean g;
  private boolean h;
  private long i;
  @NotNull
  private PlayState j;
  private PlayState k;
  private PlayState l;
  private int m;
  private final CommonGiftController.senderAvatarCallback.1 n;
  
  public CommonGiftController(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0, @NotNull BaseActivity paramBaseActivity)
  {
    super(paramTroopGiftData, paramFunction0, paramBaseActivity);
    paramTroopGiftData = QVipSDKProcessor.e();
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "QVipSDKProcessor.get()");
    this.b = paramTroopGiftData.g();
    this.c = "1";
    this.d = "2";
    paramTroopGiftData = c().findViewById(2131431018);
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "mLayout.findViewById(R.id.combo_pag)");
    this.e = ((TroopGiftComboView)paramTroopGiftData);
    paramTroopGiftData = c().findViewById(2131434265);
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "mLayout.findViewById(R.id.gift_pag)");
    this.f = ((VasPagView)paramTroopGiftData);
    this.j = PlayState.PLAY_NONE;
    this.k = PlayState.PLAY_NONE;
    this.l = PlayState.PLAY_NONE;
    this.n = new CommonGiftController.senderAvatarCallback.1(this);
  }
  
  private final long a(int paramInt)
  {
    long l1 = 1500L;
    if ((1 <= paramInt) && (9 >= paramInt)) {
      return 1500L;
    }
    if ((10 <= paramInt) && (100 >= paramInt)) {
      return 2500L;
    }
    if ((100 <= paramInt) && (999 >= paramInt)) {
      return 4000L;
    }
    if (paramInt > 999) {
      l1 = 5000L;
    }
    return l1;
  }
  
  private final void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "startComboAnimation");
    }
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "animator");
    localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    localValueAnimator.addListener((Animator.AnimatorListener)new CommonGiftController.setComboAnimationForXA.1(this));
    f().getRuleManager().registerRuleLine("$COMBO_BLOCK", new CommonGiftController.setComboAnimationForXA.2(this, paramString, localValueAnimator, paramInt));
    localValueAnimator.start();
  }
  
  private final boolean b(@NotNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/gift/xa.json");
    return new File(localStringBuilder.toString()).exists();
  }
  
  private final void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "playCommonGiftByXA");
    }
    Object localObject1 = k().giftData.dataForClient.sendCount;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "giftData.giftData.dataForClient.sendCount");
    int i1 = Integer.parseInt((String)localObject1);
    localObject1 = k().giftData.dataForClient.continueAnimationAnd;
    Object localObject2 = k().giftData.dataForClient.giftResourceAnd;
    localObject1 = TroopGiftResManager.a.b(new String[] { localObject1, localObject2 });
    if (!a((File[])localObject1)) {
      return;
    }
    this.g = false;
    this.h = false;
    localObject2 = localObject1[0].getPath();
    localObject1 = localObject1[1].getPath();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("/combo/combo.ttf");
    localObject3 = ((StringBuilder)localObject3).toString();
    f().getRuleManager().registerRuleLine("$SUBSCRIBE", new CommonGiftController.playCommonGiftByXA.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "comboPath");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "giftPath");
    b((String)localObject2, (String)localObject1);
    a(i1, (String)localObject3);
    f().setTag("common_gift");
    if (b((String)localObject1))
    {
      localObject2 = f();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("/gift/");
      ((IXAEngine)localObject2).initRootAsync(((StringBuilder)localObject3).toString(), (Function0)new CommonGiftController.playCommonGiftByXA.2(this));
      return;
    }
    f().initFromUrlAsync("1", (Function0)new CommonGiftController.playCommonGiftByXA.3(this));
  }
  
  @NotNull
  public Drawable a(@NotNull TroopGiftData paramTroopGiftData)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
    if (Intrinsics.areEqual(paramTroopGiftData.giftData.dataForClient.sendUin, "80000000"))
    {
      paramTroopGiftData = paramTroopGiftData.giftData.dataForClient.anonymousPortraitIdx;
      Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "giftData.giftData.dataFo…ient.anonymousPortraitIdx");
      paramTroopGiftData = AnonymousChatHelper.a(Integer.parseInt(paramTroopGiftData));
      localDrawable = m().getResources().getDrawable(2130844765);
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "mActivity.resources.getD…mous_default_header_icon)");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      paramTroopGiftData = URLDrawable.getDrawable(paramTroopGiftData, localURLDrawableOptions);
      Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "URLDrawable.getDrawable(avatarUrl, options)");
      return (Drawable)paramTroopGiftData;
    }
    paramTroopGiftData = FaceDrawable.getFaceDrawable((AppInterface)m().app, 1, paramTroopGiftData.giftData.dataForClient.sendUin, 3, localDrawable, localDrawable, (FaceDrawable.OnLoadingStateChangeListener)new CommonGiftController.getSenderDrawable.1(this, paramTroopGiftData, localDrawable));
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "FaceDrawable.getFaceDraw…          }\n            }");
    return (Drawable)paramTroopGiftData;
  }
  
  public void a()
  {
    if (this.b)
    {
      p();
      return;
    }
    o();
  }
  
  public final void a(@NotNull PlayState paramPlayState)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayState, "<set-?>");
    this.j = paramPlayState;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    if (Intrinsics.areEqual(paramString, this.c))
    {
      this.g = true;
      return this.h;
    }
    if (Intrinsics.areEqual(paramString, this.d))
    {
      this.h = true;
      return this.g;
    }
    return false;
  }
  
  @NotNull
  public String b()
  {
    return this.a;
  }
  
  public final void b(@NotNull TroopGiftData paramTroopGiftData)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "loadAvatars");
    }
    Object localObject1 = ImageUtil.k();
    Object localObject2 = this.e;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "defAvatar");
    ((TroopGiftComboView)localObject2).setAvatars((Bitmap)localObject1, (Bitmap)localObject1);
    localObject2 = FaceDrawable.getDefaultDrawable(1, 3);
    localObject1 = a(paramTroopGiftData);
    this.m = 0;
    if (!(localObject1 instanceof FaceDrawable)) {
      ((Drawable)localObject1).setCallback((Drawable.Callback)this.n);
    } else {
      ((FaceDrawable)localObject1).setCallback((Drawable.Callback)null);
    }
    localObject2 = FaceDrawable.getFaceDrawable((AppInterface)m().app, 1, paramTroopGiftData.giftData.dataForClient.recvUin, 3, (Drawable)localObject2, (Drawable)localObject2, (FaceDrawable.OnLoadingStateChangeListener)new CommonGiftController.loadAvatars.receiverDrawable.1(this, paramTroopGiftData, (Drawable)localObject2));
    paramTroopGiftData = this.e;
    localObject1 = TroopUtils.a((Drawable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "TroopUtils.headDrawableToBitamp(senderDrawable)");
    localObject2 = TroopUtils.a((Drawable)localObject2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "TroopUtils.headDrawableToBitamp(receiverDrawable)");
    paramTroopGiftData.setAvatars((Bitmap)localObject1, (Bitmap)localObject2);
  }
  
  public final void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "comboPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "giftPath");
    Object localObject = f().getRuleManager();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("/gift/gift.pag");
    ((IPublicRuleManager)localObject).registerRuleLine("$GIFT_PAG_FILE_PATH", localStringBuilder.toString());
    paramString2 = f().getRuleManager();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("/combo/combo.pag");
    paramString2.registerRuleLine("$COMBO_PAG_FILE_PATH", ((StringBuilder)localObject).toString());
  }
  
  public final void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public final boolean n()
  {
    return this.b;
  }
  
  public final void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "playCommonGift");
    }
    Object localObject1 = k().giftData.dataForClient.sendCount;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "giftData.giftData.dataForClient.sendCount");
    int i1 = Integer.parseInt((String)localObject1);
    Object localObject2 = new String[2];
    localObject2[0] = k().giftData.dataForClient.continueAnimationAnd;
    localObject2[1] = k().giftData.dataForClient.giftResourceAnd;
    localObject1 = TroopGiftResManager.a.b((String[])localObject2);
    if (localObject1[0].exists())
    {
      String str = localObject1[0].getPath();
      Object localObject3 = this.e;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append("/combo/combo.pag");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/combo/combo.ttf");
      ((TroopGiftComboView)localObject3).setPAGResource((String)localObject4, localStringBuilder.toString());
      this.e.a(i1);
      if (QLog.isColorLevel())
      {
        localObject3 = b();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("\n                        giftID: ");
        ((StringBuilder)localObject4).append(k().giftData.dataForClient.giftId);
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
      this.f.g().a((Function1)new CommonGiftController.playCommonGiftByOld.1((File[])localObject1));
    }
    b(k());
    this.f.g().a((Function1)new CommonGiftController.playCommonGiftByOld.2(this));
    if ((!localObject1[0].exists()) && (!localObject1[1].exists())) {
      l().invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.CommonGiftController
 * JD-Core Version:    0.7.0.1
 */