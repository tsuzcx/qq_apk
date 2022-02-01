package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyAuthVideoPlayerFragment$4
  implements ActionSheet.OnButtonClickListener
{
  NearbyAuthVideoPlayerFragment$4(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = (INearbyCardHandler)this.b.getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
        if (paramView != null) {
          paramView.a("", 0, false);
        }
      }
    }
    else {
      ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).showPtvPanel(this.b.getActivity(), this.b.getBaseActivity().app, 4);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.4
 * JD-Core Version:    0.7.0.1
 */