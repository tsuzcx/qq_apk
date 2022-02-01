package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.api.IPGCShortContentUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAvatarWallPreviewActivity$12
  implements View.OnClickListener
{
  TroopAvatarWallPreviewActivity$12(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.isPGCShortContent())) {
      ((IPGCShortContentUtils)QRoute.api(IPGCShortContentUtils.class)).redirectToOtherPage(this.c.getActivity(), this.a);
    } else if ((!TextUtils.isEmpty(this.b)) && (this.c.getActivity() != null) && ((this.c.getActivity() instanceof TroopAvatarWallPreviewActivity))) {
      if ((this.a != null) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isSupportNative(this.a.mArticleContentUrl, this.a.mChannelID, this.a)))
      {
        TroopAvatarWallPreviewActivity.access$900(this.c, this.a, this.b);
      }
      else
      {
        ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).jumpTo(this.c.getActivity(), this.b);
        if (this.c.isGridImageReport) {
          TroopAvatarWallPreviewActivity.access$1000(this.c);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */