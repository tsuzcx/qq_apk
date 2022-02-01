package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/IAioColdPalaceHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doOnBanishColdPalaceClick", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "uinType", "", "frdUin", "", "iBanish", "Lcom/tencent/mobileqq/qqexpand/chat/IColdPalaceBanish;", "doOnColdPalaceLimitCancel", "doOnColdPalaceLimitConfirm", "activity", "Landroid/app/Activity;", "doOnReqThrowToColdPalace", "suc", "", "uin", "isUsedUp", "newAioHelperInstance", "", "baseChatPie", "onBanishColdPalaceGrayTipClick", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IAioColdPalaceHelper
  extends QRouteApi
{
  public abstract void doOnBanishColdPalaceClick(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish);
  
  public abstract void doOnColdPalaceLimitCancel(@NotNull IColdPalaceBanish paramIColdPalaceBanish);
  
  public abstract void doOnColdPalaceLimitConfirm(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish);
  
  public abstract void doOnReqThrowToColdPalace(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull IColdPalaceBanish paramIColdPalaceBanish);
  
  @Nullable
  public abstract Object newAioHelperInstance(@NotNull Object paramObject);
  
  public abstract void onBanishColdPalaceGrayTipClick(@NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper
 * JD-Core Version:    0.7.0.1
 */