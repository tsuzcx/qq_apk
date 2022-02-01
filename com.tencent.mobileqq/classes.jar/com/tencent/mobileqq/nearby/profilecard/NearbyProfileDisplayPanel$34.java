package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.nearby.widget.MenuItem;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;

class NearbyProfileDisplayPanel$34
  implements NearbyPublishMenu.OnItemClickListener
{
  NearbyProfileDisplayPanel$34(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void a(Dialog paramDialog, View paramView, MenuItem paramMenuItem)
  {
    NearbyPublishMenuHelper.a(this.a.e, paramMenuItem, "data_card");
    paramDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.34
 * JD-Core Version:    0.7.0.1
 */