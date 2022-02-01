package com.tencent.mobileqq.friends.intimate;

import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IntimatePlayTogetherMiniGameCardView$1
  implements View.OnClickListener
{
  IntimatePlayTogetherMiniGameCardView$1(IntimatePlayTogetherMiniGameCardView paramIntimatePlayTogetherMiniGameCardView, MISC.StGetFriendPlayListV2Rsp paramStGetFriendPlayListV2Rsp) {}
  
  public void onClick(View paramView)
  {
    if (this.a.total.get() <= 1) {
      QLog.d("IntimatePlayTogetherMin", 1, new Object[] { "onClick", "will not jump because total count less than 2" });
    } else if (TextUtils.isEmpty(this.a.moreJumpLink.get())) {
      QLog.e("IntimatePlayTogetherMin", 1, new Object[] { "onClick", "Could not launch with empty jump url" });
    } else {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.b.getContext(), this.a.moreJumpLink.get(), 2064, new IntimatePlayTogetherMiniGameCardView.1.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.1
 * JD-Core Version:    0.7.0.1
 */