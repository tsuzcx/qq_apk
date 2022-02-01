package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

final class InterestGuide$1
  implements Runnable
{
  public void run()
  {
    if (((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a, "interest_guide_key", Boolean.TRUE)).booleanValue())
    {
      InterestGuide.c = new WeakReference(new InterestGuide(this.a, this.b, this.c));
      InterestGuide.a = Boolean.TRUE;
      return;
    }
    InterestGuide.a = Boolean.FALSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide.1
 * JD-Core Version:    0.7.0.1
 */