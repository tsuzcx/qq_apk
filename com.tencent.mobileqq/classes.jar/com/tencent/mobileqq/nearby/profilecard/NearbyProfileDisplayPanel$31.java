package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.MenuItem;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;

class NearbyProfileDisplayPanel$31
  implements NearbyPublishMenu.OnItemClickListener
{
  NearbyProfileDisplayPanel$31(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void a(Dialog paramDialog, View paramView, NearbyPublishMenu.MenuItem paramMenuItem)
  {
    NearbyPublishMenuHelper.a(this.a.a, paramMenuItem, "data_card");
    paramDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.31
 * JD-Core Version:    0.7.0.1
 */