package com.tencent.mobileqq.troop.data;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class TroopEntranceBar$1
  implements Runnable
{
  TroopEntranceBar$1(TroopEntranceBar paramTroopEntranceBar) {}
  
  public void run()
  {
    if (this.this$0.c != null)
    {
      String str = this.this$0.c.b;
      Object localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(this.this$0.a, str);
      if (localObject != null) {
        localObject = ((IPublicAccountDetail)localObject).getUin();
      } else {
        localObject = "";
      }
      ReportController.b(this.this$0.a, "dc00899", "Grp_tribe", "", "interest_data", "exp_tribechat_aio", 0, 0, str, (String)localObject, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.1
 * JD-Core Version:    0.7.0.1
 */