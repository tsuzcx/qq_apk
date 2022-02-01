package com.tencent.mobileqq.qqexpand.chat.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.qqexpand.chat.AioLimitColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.chat.AioLimitColdPalaceHelper.Companion;
import com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.chat.IColdPalaceBanish;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/impl/AioColdPalaceHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IAioColdPalaceHelper;", "()V", "doOnBanishColdPalaceClick", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "uinType", "", "frdUin", "", "iBanish", "Lcom/tencent/mobileqq/qqexpand/chat/IColdPalaceBanish;", "doOnColdPalaceLimitCancel", "doOnColdPalaceLimitConfirm", "activity", "Landroid/app/Activity;", "doOnReqThrowToColdPalace", "suc", "", "uin", "isUsedUp", "newAioHelperInstance", "", "baseChatPie", "onBanishColdPalaceGrayTipClick", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class AioColdPalaceHelperImpl
  implements IAioColdPalaceHelper
{
  public void doOnBanishColdPalaceClick(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    AioLimitColdPalaceHelper.a.b(paramBaseQQAppInterface, paramContext, paramInt, paramString, paramIColdPalaceBanish);
  }
  
  public void doOnColdPalaceLimitCancel(@NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    AioLimitColdPalaceHelper.a.a(paramIColdPalaceBanish);
  }
  
  public void doOnColdPalaceLimitConfirm(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    AioLimitColdPalaceHelper.a.a(paramBaseQQAppInterface, paramActivity, paramInt, paramString, paramIColdPalaceBanish);
  }
  
  public void doOnReqThrowToColdPalace(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramIColdPalaceBanish, "iBanish");
    AioLimitColdPalaceHelper.a.a(paramBaseQQAppInterface, paramContext, paramBoolean1, paramInt, paramString, paramBoolean2, paramIColdPalaceBanish);
  }
  
  @Nullable
  public Object newAioHelperInstance(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "baseChatPie");
    if (!(paramObject instanceof BaseChatPie)) {
      return null;
    }
    return new AioLimitColdPalaceHelper((BaseChatPie)paramObject);
  }
  
  public void onBanishColdPalaceGrayTipClick(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    AioLimitColdPalaceHelper.a.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.impl.AioColdPalaceHelperImpl
 * JD-Core Version:    0.7.0.1
 */