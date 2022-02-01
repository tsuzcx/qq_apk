package com.tencent.mobileqq.vas.troopgift;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/GiftControllerFactory;", "", "()V", "getGiftController", "Lcom/tencent/mobileqq/vas/troopgift/AbsTroopGiftController;", "giftData", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftData;", "closeAnimation", "Lkotlin/Function0;", "", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GiftControllerFactory
{
  public static final GiftControllerFactory a = new GiftControllerFactory();
  
  @NotNull
  public final AbsTroopGiftController a(@NotNull TroopGiftData paramTroopGiftData, @NotNull Function0<Unit> paramFunction0, @NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopGiftData, "giftData");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "closeAnimation");
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "mActivity");
    if (paramTroopGiftData.isCommonGift()) {
      return (AbsTroopGiftController)new CommonGiftController(paramTroopGiftData, paramFunction0, paramBaseActivity);
    }
    if (paramTroopGiftData.isStaffGift()) {
      return (AbsTroopGiftController)new StaffGiftController(paramTroopGiftData, paramFunction0, paramBaseActivity);
    }
    if (paramTroopGiftData.isGestureGift()) {
      return (AbsTroopGiftController)new GestureGiftController(paramTroopGiftData, paramFunction0, paramBaseActivity);
    }
    if (paramTroopGiftData.isGuildGift())
    {
      paramTroopGiftData = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildGIftController(paramTroopGiftData, paramFunction0, paramBaseActivity);
      if (paramTroopGiftData != null) {
        return (AbsTroopGiftController)paramTroopGiftData;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.troopgift.AbsTroopGiftController");
    }
    return (AbsTroopGiftController)new CommonGiftController(paramTroopGiftData, paramFunction0, paramBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.GiftControllerFactory
 * JD-Core Version:    0.7.0.1
 */