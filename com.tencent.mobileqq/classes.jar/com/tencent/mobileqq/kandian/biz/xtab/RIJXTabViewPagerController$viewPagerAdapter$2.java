package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$viewPagerAdapter$2
  extends Lambda
  implements Function0<ReadInJoyChannelViewPager.CustomFragmentPagerAdapter>
{
  RIJXTabViewPagerController$viewPagerAdapter$2(RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    super(0);
  }
  
  @NotNull
  public final ReadInJoyChannelViewPager.CustomFragmentPagerAdapter invoke()
  {
    Object localObject = RIJXTabViewPagerController.f(this.this$0).P();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tabFrame.activity");
    localObject = ((QBaseActivity)localObject).getSupportFragmentManager();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tabFrame.activity.supportFragmentManager");
    return new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter((FragmentManager)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.viewPagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */