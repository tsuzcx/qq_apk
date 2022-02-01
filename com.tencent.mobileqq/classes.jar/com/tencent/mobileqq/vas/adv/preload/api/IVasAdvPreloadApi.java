package com.tencent.mobileqq.vas.adv.preload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/preload/api/IVasAdvPreloadApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addPreloadAd", "", "businessId", "", "posIdList", "", "getAdAsJson", "loadAd", "removeAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasAdvPreloadApi
  extends QRouteApi
{
  public abstract void addPreloadAd(@NotNull String paramString, @NotNull List<String> paramList);
  
  @Nullable
  public abstract String getAdAsJson(@NotNull String paramString);
  
  public abstract void loadAd(@NotNull String paramString);
  
  @Nullable
  public abstract qq_ad_get.QQAdGetRsp removeAd(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi
 * JD-Core Version:    0.7.0.1
 */