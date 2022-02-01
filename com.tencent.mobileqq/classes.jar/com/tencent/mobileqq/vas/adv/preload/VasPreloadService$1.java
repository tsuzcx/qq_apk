package com.tencent.mobileqq.vas.adv.preload;

import com.tencent.mobileqq.vas.adv.base.service.VasGdtService.GdtCallback;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/preload/VasPreloadService$1", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtCallback;", "onAdGetRsp", "", "rsp", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasPreloadService$1
  implements VasGdtService.GdtCallback
{
  public void a(@Nullable qq_ad_get.QQAdGetRsp paramQQAdGetRsp)
  {
    VasPreloadService.d().put(VasPreloadService.a(this.a), paramQQAdGetRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.preload.VasPreloadService.1
 * JD-Core Version:    0.7.0.1
 */