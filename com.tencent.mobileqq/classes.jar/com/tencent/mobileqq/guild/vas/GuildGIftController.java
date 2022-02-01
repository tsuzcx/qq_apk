package com.tencent.mobileqq.guild.vas;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vas.troopgift.CommonGiftController;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData.GiftDataBean;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData.GiftDataBean.DataForClientBean;
import com.tencent.mobileqq.vas.troopgift.TroopGiftResManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/vas/GuildGIftController;", "Lcom/tencent/mobileqq/vas/troopgift/CommonGiftController;", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "closeAnimation", "Lkotlin/Function0;", "", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/app/BaseActivity;)V", "initCloseBtn", "playAnimation", "playGiftAnim", "qqguild_df_impl_release"}, k=1, mv={1, 1, 16})
public final class GuildGIftController
  extends CommonGiftController
{
  public GuildGIftController(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0, @NotNull BaseActivity paramBaseActivity)
  {
    super(paramTroopGiftData, paramFunction0, paramBaseActivity);
  }
  
  private final void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "playGuildGIftByXA");
    }
    Object localObject1 = k().giftData.dataForClient.sendCount;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "giftData.giftData.dataForClient.sendCount");
    Integer.parseInt((String)localObject1);
    localObject1 = k().giftData.dataForClient.giftResourceAnd;
    Object localObject2 = TroopGiftResManager.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "url");
    localObject2 = ((TroopGiftResManager)localObject2).a((String)localObject1);
    if (!((File)localObject2).exists()) {
      return;
    }
    q();
    a(false);
    b(false);
    f().getRuleManager().registerRuleLine("$SUBSCRIBE", new GuildGIftController.playGiftAnim.1(this));
    f().setTag("guild_gift");
    localObject1 = f();
    localObject2 = ((File)localObject2).getAbsolutePath();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "file.absolutePath");
    ((IXAEngine)localObject1).initZipAsync((String)localObject2, (Function0)new GuildGIftController.playGiftAnim.2(this));
  }
  
  private final void q()
  {
    View localView = i().findViewById(2131448097);
    if (localView != null)
    {
      localView.setVisibility(4);
      i().setOnClickListener((View.OnClickListener)new GuildGIftController.initCloseBtn.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public void a()
  {
    if (n()) {
      p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.GuildGIftController
 * JD-Core Version:    0.7.0.1
 */