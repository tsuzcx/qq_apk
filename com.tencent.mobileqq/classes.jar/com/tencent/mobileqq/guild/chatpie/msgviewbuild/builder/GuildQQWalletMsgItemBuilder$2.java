package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.statistics.ReportController;

class GuildQQWalletMsgItemBuilder$2
  implements View.OnClickListener
{
  GuildQQWalletMsgItemBuilder$2(GuildQQWalletMsgItemBuilder paramGuildQQWalletMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView))
    {
      ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.a.b, paramView);
      if ((this.a.A > 0) && ((this.a.B == 2) || (this.a.B == 3)))
      {
        if (this.a.x.aE().a == 10014) {
          paramView = "2";
        } else {
          paramView = "1";
        }
        QQAppInterface localQQAppInterface = this.a.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a.A);
        ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aiotail.click", 0, 0, localStringBuilder.toString(), paramView, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildQQWalletMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */