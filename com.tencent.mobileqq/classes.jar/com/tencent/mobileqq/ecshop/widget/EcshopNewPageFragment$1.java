package com.tencent.mobileqq.ecshop.widget;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class EcshopNewPageFragment$1
  implements OnItemSelectListener
{
  EcshopNewPageFragment$1(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if ((paramInt != 5) && (paramInt != 4))
    {
      if (paramInt == 1) {
        this.a.getActivity().finish();
      }
    }
    else
    {
      paramView = new ActivityURIRequest(this.a.getActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", "3046055438");
      paramView.extra().putInt("source", 5);
      QRoute.startUri(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.EcshopNewPageFragment.1
 * JD-Core Version:    0.7.0.1
 */