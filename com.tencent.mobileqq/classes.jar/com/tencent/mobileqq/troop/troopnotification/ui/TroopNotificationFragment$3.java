package com.tencent.mobileqq.troop.troopnotification.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class TroopNotificationFragment$3
  implements View.OnClickListener
{
  TroopNotificationFragment$3(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i = GroupSystemMsgController.a().b(TroopNotificationFragment.f(this.a));
      this.a.w.sendEmptyMessage(1014);
      Object localObject = (IConversationFacade)TroopNotificationFragment.f(this.a).getRuntimeService(IConversationFacade.class, "");
      if (localObject != null) {
        ((IConversationFacade)localObject).increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, -i);
      }
      int j = 0;
      localObject = ((IRecentUserProxyService)TroopNotificationFragment.f(this.a).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      i = j;
      if (localObject != null)
      {
        i = j;
        if (TroopNotificationFragment.f(this.a).getAccount() != null)
        {
          RecentUser localRecentUser = ((RecentUserProxy)localObject).c(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
          i = j;
          if (localRecentUser != null)
          {
            i = 1;
            ((RecentUserProxy)localObject).a(localRecentUser);
          }
        }
      }
      if (i != 0)
      {
        localObject = (ITroopSysMsgDependApiService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject != null) {
          ((ITroopSysMsgDependApiService)localObject).refreshConversationList();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.3
 * JD-Core Version:    0.7.0.1
 */