package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.nearby.widget.MenuItem;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;

class NearbyProfileDisplayPanel$33
  implements NearbyPublishMenu.OnItemClickListener
{
  NearbyProfileDisplayPanel$33(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void a(Dialog paramDialog, View paramView, MenuItem paramMenuItem)
  {
    NearbyPublishMenuHelper.a(this.a.a, paramMenuItem, "data_card");
    paramDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.33
 * JD-Core Version:    0.7.0.1
 */