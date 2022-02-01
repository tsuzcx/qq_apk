package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$viewPager$2
  extends Lambda
  implements Function0<ReadInJoyChannelViewPager>
{
  RIJXTabViewPagerController$viewPager$2(RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    super(0);
  }
  
  @NotNull
  public final ReadInJoyChannelViewPager invoke()
  {
    Object localObject = RIJXTabViewPagerController.f(this.this$0).d(2131444266);
    if (localObject != null)
    {
      localObject = (ReadInJoyChannelViewPager)localObject;
      ((ReadInJoyChannelViewPager)localObject).setAdapter((PagerAdapter)RIJXTabViewPagerController.b(this.this$0));
      ((ReadInJoyChannelViewPager)localObject).addOnPageChangeListener((ViewPager.OnPageChangeListener)RIJXTabViewPagerController.e(this.this$0));
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController.viewPager.2
 * JD-Core Version:    0.7.0.1
 */