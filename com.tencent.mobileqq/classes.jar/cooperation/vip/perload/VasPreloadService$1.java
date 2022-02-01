package cooperation.vip.perload;

import cooperation.vip.VasGdtService.GdtCallback;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/perload/VasPreloadService$1", "Lcooperation/vip/VasGdtService$GdtCallback;", "onAdGetRsp", "", "rsp", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasPreloadService$1
  implements VasGdtService.GdtCallback
{
  public void a(@Nullable qq_ad_get.QQAdGetRsp paramQQAdGetRsp)
  {
    VasPreloadService.a().put(VasPreloadService.a(this.a), paramQQAdGetRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.perload.VasPreloadService.1
 * JD-Core Version:    0.7.0.1
 */