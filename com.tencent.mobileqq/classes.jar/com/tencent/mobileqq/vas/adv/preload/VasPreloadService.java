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
  public static final VasPreloadService.Companion a;
  private static final Map<String, qq_ad_get.QQAdGetRsp> jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  private final String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasAdvPreloadVasPreloadService$Companion = new VasPreloadService.Companion(null);
  }
  
  public VasPreloadService(@NotNull String paramString, @NotNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    a((VasGdtService.GdtCallback)new VasPreloadService.1(this));
  }
  
  @NotNull
  protected VasGdtService.GdtParams a()
  {
    return new VasGdtService.GdtParams(VasAdvSupport.a.a().a(), CollectionsKt.toSet((Iterable)this.jdField_a_of_type_JavaUtilList), 0, 0, null, null, null, null, null, null, null, 2044, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.preload.VasPreloadService
 * JD-Core Version:    0.7.0.1
 */