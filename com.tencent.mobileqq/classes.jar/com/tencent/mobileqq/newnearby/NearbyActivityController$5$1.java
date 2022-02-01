package com.tencent.mobileqq.newnearby;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.nearby.widget.MenuItem;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;

class NearbyActivityController$5$1
  implements NearbyPublishMenu.OnItemClickListener
{
  NearbyActivityController$5$1(NearbyActivityController.5 param5) {}
  
  public void a(Dialog paramDialog, View paramView, MenuItem paramMenuItem)
  {
    NearbyPublishMenuHelper.a(NearbyActivityController.a(this.a.a), paramMenuItem, "home");
    paramDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyActivityController.5.1
 * JD-Core Version:    0.7.0.1
 */