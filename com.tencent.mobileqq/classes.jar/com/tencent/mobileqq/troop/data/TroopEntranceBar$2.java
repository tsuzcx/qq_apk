package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class TroopEntranceBar$2
  implements Runnable
{
  TroopEntranceBar$2(TroopEntranceBar paramTroopEntranceBar) {}
  
  public void run()
  {
    Object localObject2 = "";
    Object localObject1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((AccountDetail)localObject1).uin;
      String str = ((AccountDetail)localObject1).name;
      localObject1 = str;
      localObject2 = localObject3;
      if (str != null)
      {
        localObject1 = str;
        localObject2 = localObject3;
        if (str.endsWith(HardCodeUtil.a(2131715162)))
        {
          localObject1 = str.substring(0, str.length() - 3);
          localObject2 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject1 = String.format("https://buluo.qq.com/mobile/relativegroup.html?from=%s&scode=%s&keyword=%s&channel=1&_wv=1027&_bid=128", new Object[] { "qun_aio", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localObject1 });
      localObject3 = new Intent(this.this$0.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject3).putExtra("url", (String)localObject1);
      this.this$0.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "clk_tribechat_aio", "exp_tribechat_aio", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject2, "", "");
      return;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.2
 * JD-Core Version:    0.7.0.1
 */