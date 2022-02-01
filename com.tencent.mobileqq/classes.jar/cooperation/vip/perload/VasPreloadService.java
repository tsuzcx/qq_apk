package cooperation.vip.perload;

import cooperation.vip.VasAdvSupport;
import cooperation.vip.VasAdvSupport.Companion;
import cooperation.vip.VasGdtService;
import cooperation.vip.VasGdtService.GdtCallback;
import cooperation.vip.VasGdtService.GdtParams;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/perload/VasPreloadService;", "Lcooperation/vip/VasGdtService;", "businessId", "", "posIdList", "", "(Ljava/lang/String;Ljava/util/List;)V", "createParams", "Lcooperation/vip/VasGdtService$GdtParams;", "removeAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasPreloadService
  extends VasGdtService
{
  public static final VasPreloadService.Companion a;
  private static final Map<String, qq_ad_get.QQAdGetRsp> jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  private final String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_CooperationVipPerloadVasPreloadService$Companion = new VasPreloadService.Companion(null);
  }
  
  public VasPreloadService(@NotNull String paramString, @NotNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    a((VasGdtService.GdtCallback)new VasPreloadService.1(this));
  }
  
  @NotNull
  public VasGdtService.GdtParams a()
  {
    return new VasGdtService.GdtParams(VasAdvSupport.a.a().a(), CollectionsKt.toSet((Iterable)this.jdField_a_of_type_JavaUtilList), 0, 0, null, null, null, null, null, null, null, 2044, null);
  }
  
  @Nullable
  public final qq_ad_get.QQAdGetRsp a()
  {
    return jdField_a_of_type_CooperationVipPerloadVasPreloadService$Companion.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.perload.VasPreloadService
 * JD-Core Version:    0.7.0.1
 */