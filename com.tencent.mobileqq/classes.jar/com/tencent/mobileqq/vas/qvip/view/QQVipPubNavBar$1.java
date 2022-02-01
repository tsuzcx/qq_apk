package com.tencent.mobileqq.vas.qvip.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class QQVipPubNavBar$1
  implements View.OnClickListener
{
  QQVipPubNavBar$1(QQVipPubNavBar paramQQVipPubNavBar) {}
  
  public void onClick(View paramView)
  {
    if ((QQVipPubNavBar.a(this.a) == 4) && (!TextUtils.isEmpty(QQVipPubNavBar.b(this.a))) && ((QQVipPubNavBar.b(this.a).startsWith("http")) || (QQVipPubNavBar.b(this.a).startsWith("https"))))
    {
      Object localObject = this.a;
      QQVipPubNavBar.a((QQVipPubNavBar)localObject, QQVipPubNavBar.b((QQVipPubNavBar)localObject));
      if (QQVipPubNavBar.b(this.a).equals(QVipPubAccountConfig.c())) {
        localObject = "game_icon";
      } else {
        localObject = "vip_icon";
      }
      MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "4", "", (String)localObject, "", 102, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipPubNavBar.1
 * JD-Core Version:    0.7.0.1
 */