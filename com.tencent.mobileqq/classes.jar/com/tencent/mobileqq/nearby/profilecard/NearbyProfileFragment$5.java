package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.GiftConfigManager.TextEntryItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileFragment$5
  implements View.OnClickListener
{
  NearbyProfileFragment$5(NearbyProfileFragment paramNearbyProfileFragment, GiftConfigManager.TextEntryItem paramTextEntryItem) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftGiftConfigManager$TextEntryItem != null) {}
    for (String str = this.jdField_a_of_type_ComTencentBizTroopgiftGiftConfigManager$TextEntryItem.b;; str = "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501")
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.startActivity(localIntent);
      ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.5
 * JD-Core Version:    0.7.0.1
 */