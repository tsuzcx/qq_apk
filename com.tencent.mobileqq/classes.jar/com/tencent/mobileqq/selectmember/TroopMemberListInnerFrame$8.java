package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import java.util.List;

class TroopMemberListInnerFrame$8
  extends TroopOnlineMemberObserver
{
  TroopMemberListInnerFrame$8(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if (TextUtils.equals(paramString, this.a.c))
    {
      if ((this.a.f != null) && (this.a.f.isFinishing())) {
        return;
      }
      if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.a.f)) {
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).onOnlineRsp(this.a.h, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.8
 * JD-Core Version:    0.7.0.1
 */