package com.tencent.mobileqq.vas.adv.base.support.gdt;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "adViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onExposure"}, k=3, mv={1, 1, 16})
final class VasAdvGdtImpl$createExposureCallback$1
  implements AdExposureChecker.ExposureCallback
{
  VasAdvGdtImpl$createExposureCallback$1(VasAdvGdtImpl paramVasAdvGdtImpl) {}
  
  public final void onExposure(WeakReference<View> paramWeakReference)
  {
    Object localObject = paramWeakReference;
    if (!(paramWeakReference instanceof VasExposureReference)) {
      localObject = null;
    }
    paramWeakReference = (VasExposureReference)localObject;
    if (paramWeakReference != null)
    {
      this.a.a(paramWeakReference.b());
      localObject = paramWeakReference.a();
      if (localObject != null)
      {
        localObject = (VasResultCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((VasResultCallback)localObject).onResult(Boolean.valueOf(true));
        }
      }
      paramWeakReference.a((String)null);
      paramWeakReference = paramWeakReference.a();
      if (paramWeakReference != null) {
        paramWeakReference.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl.createExposureCallback.1
 * JD-Core Version:    0.7.0.1
 */