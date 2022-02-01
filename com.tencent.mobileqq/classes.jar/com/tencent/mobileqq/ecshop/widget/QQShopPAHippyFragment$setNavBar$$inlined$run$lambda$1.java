package com.tencent.mobileqq.ecshop.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/ecshop/widget/QQShopPAHippyFragment$setNavBar$1$1", "Lcom/tencent/mobileqq/widget/navbar/OnItemSelectListener;", "onItemLonClick", "", "v", "Landroid/view/View;", "item", "", "onItemSelect", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPAHippyFragment$setNavBar$$inlined$run$lambda$1
  implements OnItemSelectListener
{
  QQShopPAHippyFragment$setNavBar$$inlined$run$lambda$1(QQShopPAHippyFragment paramQQShopPAHippyFragment) {}
  
  public void onItemSelect(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if ((paramInt != 5) && (paramInt != 4))
    {
      if (paramInt == 1)
      {
        QQShopPAHippyFragment.a(this.a);
        paramView = this.a.getActivity();
        if (paramView != null) {
          paramView.finish();
        }
      }
    }
    else
    {
      paramView = new ActivityURIRequest((Context)this.a.getActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", "3046055438");
      paramView.extra().putInt("source", 5);
      QRoute.startUri((URIRequest)paramView, null);
      QQShopPAHippyFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment.setNavBar..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */