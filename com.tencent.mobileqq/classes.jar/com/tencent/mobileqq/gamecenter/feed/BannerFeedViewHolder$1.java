package com.tencent.mobileqq.gamecenter.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BannerFeedViewHolder$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl.startsWith("mqqapi://miniapp/")) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqGamecenterFeedBannerFeedViewHolder.itemView.getContext(), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl, 2016, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqGamecenterFeedBannerFeedViewHolder.itemView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterFeedBannerFeedViewHolder.itemView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.feed.BannerFeedViewHolder.1
 * JD-Core Version:    0.7.0.1
 */