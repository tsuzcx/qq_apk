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

class BiuUgcProteusItem$3
  implements View.OnClickListener
{
  BiuUgcProteusItem$3(BiuUgcProteusItem paramBiuUgcProteusItem, IReadInJoyModel paramIReadInJoyModel, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.k() != null) && (this.a.k().mSocialFeedInfo != null) && (this.a.k().mSocialFeedInfo.u != null))
    {
      LiveRoomProxyActivity.open(this.b.a(), this.a.k().mSocialFeedInfo.u.e, "kandian biu feed click");
      return;
    }
    OnSubRegionClickListener localOnSubRegionClickListener = this.b.y().c();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(paramView, this.a.k(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuUgcProteusItem.3
 * JD-Core Version:    0.7.0.1
 */