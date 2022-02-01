package cooperation.vip;

import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "loader", "Lcom/tencent/gdtad/aditem/GdtAdLoader;", "kotlin.jvm.PlatformType", "onResponse"}, k=3, mv={1, 1, 16})
final class VasGdtService$listener$2$1
  implements GdtAdLoader.Listener
{
  VasGdtService$listener$2$1(VasGdtService.listener.2 param2) {}
  
  public final void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    VasGdtService.GdtCallback localGdtCallback = this.a.this$0.a();
    if (localGdtCallback != null)
    {
      if (paramGdtAdLoader == null) {
        break label41;
      }
      paramGdtAdLoader = paramGdtAdLoader.a();
      if (paramGdtAdLoader == null) {
        break label41;
      }
    }
    label41:
    for (paramGdtAdLoader = paramGdtAdLoader.a;; paramGdtAdLoader = null)
    {
      localGdtCallback.a(paramGdtAdLoader);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasGdtService.listener.2.1
 * JD-Core Version:    0.7.0.1
 */