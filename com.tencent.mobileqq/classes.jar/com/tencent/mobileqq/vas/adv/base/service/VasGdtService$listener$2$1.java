package com.tencent.mobileqq.vas.adv.base.service;

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
      if (paramGdtAdLoader != null)
      {
        paramGdtAdLoader = paramGdtAdLoader.a();
        if (paramGdtAdLoader != null)
        {
          paramGdtAdLoader = paramGdtAdLoader.b;
          break label38;
        }
      }
      paramGdtAdLoader = null;
      label38:
      localGdtCallback.a(paramGdtAdLoader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasGdtService.listener.2.1
 * JD-Core Version:    0.7.0.1
 */