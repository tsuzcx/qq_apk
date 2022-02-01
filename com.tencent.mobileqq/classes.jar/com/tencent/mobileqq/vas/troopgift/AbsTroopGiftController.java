package com.tencent.mobileqq.vas.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.Loader;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.LoaderCallback;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.mobileqq.vas.ui.PagViewProxy.Companion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.XAApi;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.openapi.api.IXAGlobal;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/AbsTroopGiftController;", "", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "closeAnimation", "Lkotlin/Function0;", "", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/app/BaseActivity;)V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "getCloseAnimation", "()Lkotlin/jvm/functions/Function0;", "getGiftData", "()Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "getMActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "mLayout", "Landroid/widget/FrameLayout;", "getMLayout", "()Landroid/widget/FrameLayout;", "mStopBtn", "Landroid/widget/ImageView;", "mStopBtnTag", "mWindowManager", "Landroid/view/WindowManager;", "senderAvatarCallback", "com/tencent/mobileqq/vas/troopgift/AbsTroopGiftController$senderAvatarCallback$1", "Lcom/tencent/mobileqq/vas/troopgift/AbsTroopGiftController$senderAvatarCallback$1;", "times", "", "xaEngine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getXaEngine", "()Lcom/tencent/xaction/openapi/api/IXAEngine;", "setXaEngine", "(Lcom/tencent/xaction/openapi/api/IXAEngine;)V", "addAnimationView", "filesAllExist", "", "files", "", "Ljava/io/File;", "([Ljava/io/File;)Z", "getAnimationLayout", "getNickname", "troopUin", "senderUin", "getSenderDrawable", "Landroid/graphics/drawable/Drawable;", "getStopBtn", "getXAEngine", "initXA", "isPagInit", "needPag", "onAnimationEnd", "playAnimation", "registerAvatars", "registerRule", "startAnimation", "tryLoadAnimation", "hasStopBtn", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class AbsTroopGiftController
{
  private final String a;
  private final String b;
  @Nullable
  private IXAEngine c;
  @NotNull
  private final FrameLayout d;
  private final ImageView e;
  private final WindowManager f;
  private int g;
  private final AbsTroopGiftController.senderAvatarCallback.1 h;
  @NotNull
  private final TroopGiftData i;
  @NotNull
  private final Function0<Unit> j;
  @NotNull
  private final BaseActivity k;
  
  public AbsTroopGiftController(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0, @NotNull BaseActivity paramBaseActivity)
  {
    this.i = paramTroopGiftData;
    this.j = paramFunction0;
    this.k = paramBaseActivity;
    this.a = getClass().getSimpleName();
    this.b = "mStopBtnTag";
    paramTroopGiftData = LayoutInflater.from((Context)this.k).inflate(2131626985, null, false);
    if (paramTroopGiftData != null)
    {
      this.d = ((FrameLayout)paramTroopGiftData);
      paramTroopGiftData = this.d.findViewById(2131448097);
      Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "mLayout.findViewById(R.i…end_gift_animation_close)");
      this.e = ((ImageView)paramTroopGiftData);
      this.e.setTag(this.b);
      this.e.setOnClickListener((View.OnClickListener)new AbsTroopGiftController.1(this));
      paramTroopGiftData = this.k.getSystemService("window");
      if (paramTroopGiftData != null)
      {
        this.f = ((WindowManager)paramTroopGiftData);
        this.h = new AbsTroopGiftController.senderAvatarCallback.1(this);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  private final void a(boolean paramBoolean)
  {
    XAApi.e().registerGlobalRule("$IS_PAG_INIT", Boolean.valueOf(paramBoolean));
    IXAEngine localIXAEngine = this.c;
    if (localIXAEngine != null) {
      localIXAEngine.destroy();
    }
    this.c = XAApi.c((Context)this.k);
    f().setContentLayout((ViewGroup)this.d);
    g();
    h();
  }
  
  private final boolean a(@NotNull FrameLayout paramFrameLayout)
  {
    int n = paramFrameLayout.getChildCount();
    int m = 0;
    while (m < n)
    {
      View localView = paramFrameLayout.getChildAt(m);
      Intrinsics.checkExpressionValueIsNotNull(localView, "this.getChildAt(i)");
      if (Intrinsics.areEqual(localView.getTag(), this.b)) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  private final void n()
  {
    this.k.runOnUiThread((Runnable)new AbsTroopGiftController.startAnimation.1(this));
  }
  
  private final void o()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.format = -2;
    if (Build.VERSION.SDK_INT >= 21) {
      localLayoutParams.flags = -2147482624;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      localLayoutParams.layoutInDisplayCutoutMode = 1;
    }
    try
    {
      this.f.addView((View)this.d, (ViewGroup.LayoutParams)localLayoutParams);
    }
    catch (Exception localException)
    {
      QLog.e(b(), 1, (Throwable)localException, new Object[0]);
    }
    if (a(this.d)) {
      this.d.removeView((View)this.e);
    }
    this.d.addView((View)this.e);
    if (Build.VERSION.SDK_INT >= 19) {
      this.d.setSystemUiVisibility(1792);
    }
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
      localDrawable = this.k.getResources().getDrawable(2130844765);
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "mActivity.resources.getD…mous_default_header_icon)");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      paramTroopGiftData = URLDrawable.getDrawable(paramTroopGiftData, localURLDrawableOptions);
      Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "URLDrawable.getDrawable(avatarUrl, options)");
      return (Drawable)paramTroopGiftData;
    }
    paramTroopGiftData = FaceDrawable.getFaceDrawable((AppInterface)this.k.app, 1, paramTroopGiftData.giftData.dataForClient.sendUin, 3, localDrawable, localDrawable, (FaceDrawable.OnLoadingStateChangeListener)new AbsTroopGiftController.getSenderDrawable.1(this, paramTroopGiftData, localDrawable));
    Intrinsics.checkExpressionValueIsNotNull(paramTroopGiftData, "FaceDrawable.getFaceDraw…          }\n            }");
    return (Drawable)paramTroopGiftData;
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "troopUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "senderUin");
    Object localObject = this.k.app.getRuntimeService(ITroopMemberNameService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mActivity.app.getRuntime…va, ProcessConstant.MAIN)");
    localObject = (ITroopMemberNameService)localObject;
    if (localObject != null)
    {
      paramString1 = ((ITroopMemberNameService)localObject).getTroopMemberNameWithoutRemark(paramString1, paramString2);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "nameService.getTroopMemb…mark(troopUin, senderUin)");
      return paramString1;
    }
    return paramString2;
  }
  
  public abstract void a();
  
  public final boolean a(@NotNull File[] paramArrayOfFile)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFile, "files");
    int n = paramArrayOfFile.length;
    int m = 0;
    while (m < n)
    {
      if (!paramArrayOfFile[m].exists()) {
        return false;
      }
      m += 1;
    }
    return true;
  }
  
  public String b()
  {
    return this.a;
  }
  
  @NotNull
  protected final FrameLayout c()
  {
    return this.d;
  }
  
  public final void d()
  {
    if (!e())
    {
      n();
      return;
    }
    if (!PagViewProxy.d.b().a())
    {
      PagViewProxy.d.b().a((AbsAsyncLoadProxy.LoaderCallback)new AbsTroopGiftController.tryLoadAnimation.1(this));
      return;
    }
    n();
  }
  
  public abstract boolean e();
  
  @NotNull
  public final IXAEngine f()
  {
    if (this.c == null) {
      this.c = XAApi.c((Context)this.k);
    }
    IXAEngine localIXAEngine = this.c;
    if (localIXAEngine == null) {
      Intrinsics.throwNpe();
    }
    return localIXAEngine;
  }
  
  public final void g()
  {
    IPublicRuleManager localIPublicRuleManager = f().getRuleManager();
    String str = this.i.giftData.dataForClient.troopUin;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.dataForClient.troopUin");
    localIPublicRuleManager.registerRuleLine("$GIFT_SEND_NICK", a(str, String.valueOf(this.i.getSenderUin())));
    localIPublicRuleManager.registerRuleLine("$GIFT_SEND_UIN", String.valueOf(this.i.getSenderUin()));
    str = this.i.giftData.receiverNick;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.receiverNick");
    localIPublicRuleManager.registerRuleLine("$GIFT_RECEIVE_NICK", str);
    str = this.i.giftData.dataForClient.recvUin;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.dataForClient.recvUin");
    localIPublicRuleManager.registerRuleLine("$GIFT_RECEIVE_UIN", str);
    str = this.i.giftData.giftName;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.giftName");
    localIPublicRuleManager.registerRuleLine("$GIFT_NAME", str);
    str = this.i.giftData.score;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.score");
    localIPublicRuleManager.registerRuleLine("$GIFT_CHARM", str);
    str = this.i.giftData.count;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.count");
    localIPublicRuleManager.registerRuleLine("$GIFT_COUNT", str);
    str = this.i.giftData.dataForClient.giftType;
    Intrinsics.checkExpressionValueIsNotNull(str, "giftData.giftData.dataForClient.giftType");
    localIPublicRuleManager.registerRuleLine("$GIFT_TYPE", str);
  }
  
  public final void h()
  {
    Object localObject1 = ImageUtil.k();
    Object localObject2 = f().getRuleManager();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "defAvatar");
    ((IPublicRuleManager)localObject2).registerRuleLine("$GIFT_SEND_AVATAR", localObject1);
    f().getRuleManager().registerRuleLine("$GIFT_RECEIVE_AVATAR", localObject1);
    localObject1 = FaceDrawable.getDefaultDrawable(1, 3);
    localObject2 = a(this.i);
    this.g = 0;
    if (!(localObject2 instanceof FaceDrawable)) {
      ((Drawable)localObject2).setCallback((Drawable.Callback)this.h);
    } else {
      ((FaceDrawable)localObject2).setCallback((Drawable.Callback)null);
    }
    localObject1 = FaceDrawable.getFaceDrawable((AppInterface)this.k.app, 1, this.i.giftData.dataForClient.recvUin, 3, (Drawable)localObject1, (Drawable)localObject1, (FaceDrawable.OnLoadingStateChangeListener)new AbsTroopGiftController.registerAvatars.receiverDrawable.1(this, (Drawable)localObject1));
    IPublicRuleManager localIPublicRuleManager = f().getRuleManager();
    localObject2 = TroopUtils.a((Drawable)localObject2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "TroopUtils.headDrawableToBitamp(senderDrawable)");
    localIPublicRuleManager.registerRuleLine("$GIFT_SEND_AVATAR", localObject2);
    localObject2 = f().getRuleManager();
    localObject1 = TroopUtils.a((Drawable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "TroopUtils.headDrawableToBitamp(receiverDrawable)");
    ((IPublicRuleManager)localObject2).registerRuleLine("$GIFT_RECEIVE_AVATAR", localObject1);
  }
  
  @NotNull
  public final FrameLayout i()
  {
    return this.d;
  }
  
  public final void j()
  {
    try
    {
      this.f.removeViewImmediate((View)this.d);
    }
    catch (Exception localException)
    {
      QLog.e(b(), 1, localException.getMessage());
    }
    this.j.invoke();
  }
  
  @NotNull
  public final TroopGiftData k()
  {
    return this.i;
  }
  
  @NotNull
  public final Function0<Unit> l()
  {
    return this.j;
  }
  
  @NotNull
  public final BaseActivity m()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.AbsTroopGiftController
 * JD-Core Version:    0.7.0.1
 */