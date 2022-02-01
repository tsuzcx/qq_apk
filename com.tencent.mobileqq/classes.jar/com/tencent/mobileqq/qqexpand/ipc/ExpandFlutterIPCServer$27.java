package com.tencent.mobileqq.qqexpand.ipc;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ExpandFlutterIPCServer$27
  implements Runnable
{
  ExpandFlutterIPCServer$27(ExpandFlutterIPCServer paramExpandFlutterIPCServer) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (localObject == null)
      {
        QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, "handleClearAllMsgs app is null!");
        return;
      }
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
      ExpandReportUtils.a("click#message_setting_page#delete_all_message", true, -1L, -1L, null, true, true);
      MatchChatMsgUtil.a((QQAppInterface)localObject);
      ExpandChatUtil.c((BaseQQAppInterface)localObject);
      ((ExpandManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).O();
      ((ExtendFriendLimitChatManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a();
      ((IceBreakingMng)((QQAppInterface)localObject).getManager(QQManagerFactory.ICE_BREAKING_MNG)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.27
 * JD-Core Version:    0.7.0.1
 */