package com.tencent.mobileqq.matchchat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.manager.IExpandLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    if (MatchChatSettingFragment.b(this.this$0) == null) {
      return;
    }
    ReportController.b(MatchChatSettingFragment.b(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_setting_page#delete_all_message", true, -1L, -1L, null, true, true);
    MatchChatMsgUtil.a(MatchChatSettingFragment.b(this.this$0));
    ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).clearAllMatchChatLocalData(MatchChatSettingFragment.b(this.this$0));
    ((IExpandManager)MatchChatSettingFragment.b(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).O();
    ((IExpandLimitChatManager)MatchChatSettingFragment.b(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a();
    ((IceBreakingMng)MatchChatSettingFragment.b(this.this$0).getManager(QQManagerFactory.ICE_BREAKING_MNG)).a();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */