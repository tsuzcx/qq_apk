package com.tencent.mobileqq.matchchat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    if (MatchChatSettingFragment.a(this.this$0) == null) {
      return;
    }
    ReportController.b(MatchChatSettingFragment.a(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    ExpandReportUtils.a("click#message_setting_page#delete_all_message", true, -1L, -1L, null, true, true);
    MatchChatMsgUtil.a(MatchChatSettingFragment.a(this.this$0));
    ExpandFriendChatUtil.b(MatchChatSettingFragment.a(this.this$0));
    ((ExtendFriendManager)MatchChatSettingFragment.a(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e();
    ((ExtendFriendLimitChatManager)MatchChatSettingFragment.a(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a();
    ((IceBreakingMng)MatchChatSettingFragment.a(this.this$0).getManager(QQManagerFactory.ICE_BREAKING_MNG)).a();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */