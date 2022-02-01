package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.topicsdk.interfaces.OnPageChangeListenerProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mediaselector/GalleryView$1", "Lcom/tencent/tkd/topicsdk/interfaces/OnPageChangeListenerProxy;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GalleryView$1
  implements OnPageChangeListenerProxy
{
  public void a(int paramInt)
  {
    Object localObject = this.a.a();
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.GalleryView.1
 * JD-Core Version:    0.7.0.1
 */