package com.tencent.mobileqq.kandian.biz.xtab;

import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "popup", "Lcom/tencent/mobileqq/kandian/biz/xtab/IKDXTabHomepageModeGuide;", "invoke", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$initViewPager$2$1$1"}, k=3, mv={1, 1, 16})
final class RIJXTabFrame$initViewPager$2$$special$$inlined$let$lambda$1
  extends Lambda
  implements Function1<IKDXTabHomepageModeGuide, Unit>
{
  RIJXTabFrame$initViewPager$2$$special$$inlined$let$lambda$1(KDXTabHomepageModeGuideViewModel.HomepageGuideData paramHomepageGuideData, RIJXTabFrame.initViewPager.2 param2)
  {
    super(1);
  }
  
  public final void invoke(@NotNull IKDXTabHomepageModeGuide paramIKDXTabHomepageModeGuide)
  {
    Intrinsics.checkParameterIsNotNull(paramIKDXTabHomepageModeGuide, "popup");
    paramIKDXTabHomepageModeGuide.a((FrameLayout)RIJXTabFrame.e(this.this$0.a));
    paramIKDXTabHomepageModeGuide = this.this$0.a.P();
    Intrinsics.checkExpressionValueIsNotNull(paramIKDXTabHomepageModeGuide, "activity");
    RIJJumpUtils.a(paramIKDXTabHomepageModeGuide.getBaseContext(), this.$data.b(), null);
    RIJXTabFrame.a(this.this$0.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initViewPager.2..special..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */