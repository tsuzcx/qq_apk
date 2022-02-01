package com.tencent.mobileqq.vas.adv.preload;

import com.tencent.mobileqq.vas.adv.base.service.VasGdtService;
import com.tencent.mobileqq.vas.adv.base.service.VasGdtService.GdtCallback;
import com.tencent.mobileqq.vas.adv.base.service.VasGdtService.GdtParams;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/preload/VasPreloadService;", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService;", "businessId", "", "posIdList", "", "(Ljava/lang/String;Ljava/util/List;)V", "createParams", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtParams;", "removeAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasPreloadService
  extends VasGdtService
{
  public static final VasPreloadService.Companion a = new VasPreloadService.Companion(null);
  private static final Map<String, qq_ad_get.QQAdGetRsp> d = (Map)new LinkedHashMap();
  private final String b;
  private final List<String> c;
  
  public VasPreloadService(@NotNull String paramString, @NotNull List<String> paramList)
  {
    this.b = paramString;
    this.c = paramList;
    a((VasGdtService.GdtCallback)new VasPreloadService.1(this));
  }
  
  @NotNull
  protected VasGdtService.GdtParams c()
  {
    return new VasGdtService.GdtParams(VasAdvSupport.a.a().a(), CollectionsKt.toSet((Iterable)this.c), 0, 0, null, null, null, null, null, null, null, 2044, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.preload.VasPreloadService
 * JD-Core Version:    0.7.0.1
 */