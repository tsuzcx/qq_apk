package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$initTabs$1$1$view$1$1", "com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$initTabs$1$1$addTabBar$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileDisplayPanel$initTabs$$inlined$apply$lambda$1$1
  implements View.OnClickListener
{
  NewNearbyProfileDisplayPanel$initTabs$$inlined$apply$lambda$1$1(Pair paramPair, NewNearbyProfileDisplayPanel.initTabs..inlined.apply.lambda.1 param1, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    int i = NewNearbyProfileDisplayPanel.e(this.b.this$0).indexOf(this.a);
    if (i == this.b.this$0.ab)
    {
      paramView = this.b.this$0.e;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "mActivity");
      NearbyProfileReportKt.b(paramView);
    }
    else if (i == this.b.this$0.ac)
    {
      paramView = this.b.this$0.e;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "mActivity");
      NearbyProfileReportKt.c(paramView);
    }
    NewNearbyProfileDisplayPanel.a(this.b.this$0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.initTabs..inlined.apply.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */