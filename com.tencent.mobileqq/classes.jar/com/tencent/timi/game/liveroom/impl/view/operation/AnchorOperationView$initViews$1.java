package com.tencent.timi.game.liveroom.impl.view.operation;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.liveroom.impl.widget.ChildViewPager;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationView$initViews$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "p0", "", "onPageScrolled", "p1", "", "p2", "onPageSelected", "pos", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOperationView$initViews$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageSelected pos:");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("AnchorOperationView_", ((StringBuilder)localObject).toString());
    localObject = this.a;
    ChildViewPager localChildViewPager = (ChildViewPager)((AnchorOperationView)localObject).a(2131439657);
    Intrinsics.checkExpressionValueIsNotNull(localChildViewPager, "operationViewPager");
    AnchorOperationView.a((AnchorOperationView)localObject, localChildViewPager.getCurrentItem());
    AnchorOperationView.a(this.a, false);
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(AnchorOperationView.b(this.a));
    ThreadManagerV2.getUIHandlerV2().postDelayed(AnchorOperationView.b(this.a), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationView.initViews.1
 * JD-Core Version:    0.7.0.1
 */