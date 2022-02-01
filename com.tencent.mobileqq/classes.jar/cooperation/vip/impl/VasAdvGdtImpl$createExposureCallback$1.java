package cooperation.vip.impl;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import cooperation.vip.VasExposureReference;
import cooperation.vip.VasResultCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "adViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onExposure"}, k=3, mv={1, 1, 16})
final class VasAdvGdtImpl$createExposureCallback$1
  implements AdExposureChecker.ExposureCallback
{
  VasAdvGdtImpl$createExposureCallback$1(VasAdvGdtImpl paramVasAdvGdtImpl) {}
  
  public final void onExposure(WeakReference<View> paramWeakReference)
  {
    if (!(paramWeakReference instanceof VasExposureReference)) {
      paramWeakReference = null;
    }
    for (;;)
    {
      paramWeakReference = (VasExposureReference)paramWeakReference;
      if (paramWeakReference != null)
      {
        this.a.a(paramWeakReference.a());
        Object localObject = paramWeakReference.a();
        if (localObject != null)
        {
          localObject = (VasResultCallback)((WeakReference)localObject).get();
          if (localObject != null) {
            ((VasResultCallback)localObject).a(Boolean.valueOf(true));
          }
        }
        paramWeakReference.a((String)null);
        paramWeakReference = paramWeakReference.a();
        if (paramWeakReference != null) {
          paramWeakReference.clear();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvGdtImpl.createExposureCallback.1
 * JD-Core Version:    0.7.0.1
 */