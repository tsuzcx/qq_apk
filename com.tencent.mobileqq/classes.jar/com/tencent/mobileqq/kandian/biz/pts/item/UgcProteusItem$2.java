package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.GameLiveInfo;
import cooperation.liveroom.LiveRoomProxyActivity;

class UgcProteusItem$2
  implements View.OnClickListener
{
  UgcProteusItem$2(UgcProteusItem paramUgcProteusItem, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void onClick(View paramView)
  {
    if (this.a == 120)
    {
      LiveRoomProxyActivity.open(this.b.a(), this.c.k().mSocialFeedInfo.u.e, "kandian feed click");
      return;
    }
    OnSubRegionClickListener localOnSubRegionClickListener = this.b.y().c();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(paramView, this.c.k(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.UgcProteusItem.2
 * JD-Core Version:    0.7.0.1
 */