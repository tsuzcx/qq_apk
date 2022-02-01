package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.nearby.widget.MenuItem;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;

class NearbyHybridFragment$12
  implements NearbyPublishMenu.OnItemClickListener
{
  NearbyHybridFragment$12(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(Dialog paramDialog, View paramView, MenuItem paramMenuItem)
  {
    NearbyPublishMenuHelper.a(this.a.a, paramMenuItem, "home");
    paramDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.12
 * JD-Core Version:    0.7.0.1
 */