package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class TroopEntranceBar$2
  implements Runnable
{
  TroopEntranceBar$2(TroopEntranceBar paramTroopEntranceBar) {}
  
  public void run()
  {
    Object localObject1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(this.this$0.a, this.this$0.c.b);
    if (localObject1 != null)
    {
      str = ((IPublicAccountDetail)localObject1).getUin();
      localObject2 = ((IPublicAccountDetail)localObject1).getName();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).endsWith(HardCodeUtil.a(2131912573))) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 3);
        }
      }
      localObject2 = localObject1;
      localObject1 = str;
    }
    else
    {
      str = "";
      localObject1 = str;
      localObject2 = str;
    }
    String str = String.format("https://buluo.qq.com/mobile/relativegroup.html?from=%s&scode=%s&keyword=%s&channel=1&_wv=1027&_bid=128", new Object[] { "qun_aio", this.this$0.c.b, localObject2 });
    Object localObject2 = new Intent(this.this$0.b, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", str);
    this.this$0.b.startActivity((Intent)localObject2);
    ReportController.b(this.this$0.a, "dc00899", "Grp_tribe", "", "clk_tribechat_aio", "exp_tribechat_aio", 0, 0, this.this$0.c.b, (String)localObject1, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.2
 * JD-Core Version:    0.7.0.1
 */