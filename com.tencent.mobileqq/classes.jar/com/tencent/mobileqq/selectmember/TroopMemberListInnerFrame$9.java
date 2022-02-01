package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopMemberListInnerFrame$9
  implements AbsListView.OnScrollListener
{
  TroopMemberListInnerFrame$9(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.a.f)) && (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isNeedReqGameInfo(this.a.f))) {
      ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).reqGameInfoWhenIdle(this.a.h, this.a.d, this.a.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.9
 * JD-Core Version:    0.7.0.1
 */