package com.tencent.mobileqq.vas.adv.preload;

import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.pb.PBField;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/preload/VasPreloadService$Companion;", "", "()V", "preloadedAd", "", "", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "getAd", "businessId", "getAdAsJson", "removeAd", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasPreloadService$Companion
{
  @JvmStatic
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    Object localObject2 = ((Companion)this).b(paramString);
    Object localObject1 = null;
    paramString = localObject1;
    if (localObject2 != null)
    {
      localObject2 = GdtJsonPbUtil.a((PBField)localObject2);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = localObject2.toString();
      }
    }
    return paramString;
  }
  
  @JvmStatic
  @Nullable
  public final qq_ad_get.QQAdGetRsp a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    return (qq_ad_get.QQAdGetRsp)VasPreloadService.a().remove(paramString);
  }
  
  @JvmStatic
  @Nullable
  public final qq_ad_get.QQAdGetRsp b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    return (qq_ad_get.QQAdGetRsp)VasPreloadService.a().get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.preload.VasPreloadService.Companion
 * JD-Core Version:    0.7.0.1
 */