package com.tencent.mobileqq.newnearby;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.util.DisplayUtil;

class NearbyActivityController$5
  implements View.OnClickListener
{
  NearbyActivityController$5(NearbyActivityController paramNearbyActivityController) {}
  
  public void onClick(View paramView)
  {
    paramView = NearbyPublishMenuHelper.a();
    paramView = new NearbyPublishMenu(NearbyActivityController.a(this.a), paramView);
    paramView.a(new NearbyActivityController.5.1(this));
    paramView.a(DisplayUtil.a(NearbyActivityController.a(this.a), 18.0F), DisplayUtil.a(NearbyActivityController.a(this.a), 63.0F) + NearbyActivityController.c(this.a).getHeight(), 0.2F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyActivityController.5
 * JD-Core Version:    0.7.0.1
 */