package com.tencent.mobileqq.vas.adv.preload.api.impl;

import com.tencent.mobileqq.vas.adv.preload.VasPreloadService;
import com.tencent.mobileqq.vas.adv.preload.VasPreloadService.Companion;
import com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/preload/api/impl/VasAdvPreloadApiImpl;", "Lcom/tencent/mobileqq/vas/adv/preload/api/IVasAdvPreloadApi;", "()V", "preloadServiceMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/vas/adv/preload/VasPreloadService;", "Lkotlin/collections/HashMap;", "getPreloadServiceMap", "()Ljava/util/HashMap;", "preloadServiceMap$delegate", "Lkotlin/Lazy;", "addPreloadAd", "", "businessId", "posIdList", "", "getAdAsJson", "loadAd", "removeAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvPreloadApiImpl
  implements IVasAdvPreloadApi
{
  private final Lazy preloadServiceMap$delegate = LazyKt.lazy((Function0)VasAdvPreloadApiImpl.preloadServiceMap.2.INSTANCE);
  
  private final HashMap<String, VasPreloadService> getPreloadServiceMap()
  {
    return (HashMap)this.preloadServiceMap$delegate.getValue();
  }
  
  public void addPreloadAd(@NotNull String paramString, @NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    Intrinsics.checkParameterIsNotNull(paramList, "posIdList");
    getPreloadServiceMap().put(paramString, new VasPreloadService(paramString, paramList));
  }
  
  @Nullable
  public String getAdAsJson(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    return VasPreloadService.a.c(paramString);
  }
  
  public void loadAd(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    paramString = (VasPreloadService)getPreloadServiceMap().get(paramString);
    if (paramString != null) {
      paramString.b();
    }
  }
  
  @Nullable
  public qq_ad_get.QQAdGetRsp removeAd(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    getPreloadServiceMap().remove(paramString);
    return VasPreloadService.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.preload.api.impl.VasAdvPreloadApiImpl
 * JD-Core Version:    0.7.0.1
 */