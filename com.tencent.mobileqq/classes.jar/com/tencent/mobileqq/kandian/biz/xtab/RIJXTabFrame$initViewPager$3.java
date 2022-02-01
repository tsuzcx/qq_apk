package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class RIJXTabFrame$initViewPager$3<T>
  implements Observer<Boolean>
{
  RIJXTabFrame$initViewPager$3(RIJXTabFrame paramRIJXTabFrame) {}
  
  public final void a(Boolean paramBoolean)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "it");
    if (paramBoolean.booleanValue())
    {
      RIJXTabFrame.h(this.a).a();
      return;
    }
    RIJXTabFrame.h(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initViewPager.3
 * JD-Core Version:    0.7.0.1
 */