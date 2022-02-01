package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class GameMsgUtil
{
  public static void a(QQAppInterface paramQQAppInterface, Message paramMessage, MsgSummary paramMsgSummary, RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData)
  {
    System.currentTimeMillis();
    Object localObject = paramQQAppInterface.getMessageFacade().b("2747277822", 1008);
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if (!localIGameMsgManagerService.isGrayOpen()) {
      return;
    }
    localIGameMsgManagerService.setMsgShowOnList(false);
    localIGameMsgManagerService.setNeedPopMsgView(false);
    localIGameMsgManagerService.setShowReqMsgUnread(false);
    paramMessage = paramQQAppInterface.getRecentUserProxy();
    RecentUser localRecentUser = paramMessage.a("2747277822", 1008);
    int i = localIGameMsgManagerService.getUnshowedUnreadCnt();
    paramRecentItemPublicAccountChatMsgData.mUnreadNum += i;
    if ((((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid((MessageRecord)localObject)) && (!((MessageRecord)localObject).isread))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgUtil", 2, "[buildMessageBody] has unread public account message.return.");
      }
      return;
    }
    GameCenterSessionInfo localGameCenterSessionInfo = localIGameMsgManagerService.getLastSessionInfoExceptDelSession();
    int j = 1;
    if (localGameCenterSessionInfo == null)
    {
      if (!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid((MessageRecord)localObject))
      {
        paramMsgSummary = paramMessage.a("2747277822", 1008);
        if (paramMsgSummary != null)
        {
          paramMessage.a(paramMsgSummary);
          paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.sendEmptyMessage(1009);
          }
          QLog.i("GameMsgUtil", 1, "del pubacc from recent session.");
        }
      }
      return;
    }
    if (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid((MessageRecord)localObject))
    {
      if (((MessageRecord)localObject).time > localGameCenterSessionInfo.a()) {
        return;
      }
      if ((!localIGameMsgManagerService.getHasUnreadMsg()) && (localGameCenterSessionInfo.a() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameMsgUtil", 2, "[buildMessageBody] show operating msg.return.");
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[buildMessageBody] last info:");
      localStringBuilder.append(localGameCenterSessionInfo);
      localStringBuilder.append(",  msg:");
      localStringBuilder.append(localObject);
      QLog.d("GameMsgUtil", 2, localStringBuilder.toString());
    }
    if ((localGameCenterSessionInfo != null) && (localGameCenterSessionInfo.a() != 0L))
    {
      if ((localGameCenterSessionInfo.c() <= 0) && (localObject != null)) {
        if (localGameCenterSessionInfo.a() <= ((MessageRecord)localObject).time) {
          break label1012;
        }
      }
      if (localGameCenterSessionInfo.a() == 0)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("[");
        paramMessage.append(localGameCenterSessionInfo.b());
        paramMessage.append("位好友请求] 来自");
        paramMessage.append(localGameCenterSessionInfo.f());
        paramMsgSummary.strContent = new QQText(paramMessage.toString(), 3, 16, -1);
        long l = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastTopReqMsgTime(paramQQAppInterface);
        paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.a();
        if ((localIGameMsgManagerService.getReqMsgCnt() == 1L) || ((!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isToday(l)) && (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isToday(localGameCenterSessionInfo.a() * 1000L))))
        {
          localRecentUser.lastmsgtime = localGameCenterSessionInfo.a();
          paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.a();
          paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
          paramMsgSummary = new StringBuilder();
          paramMsgSummary.append("sp_top_last_time");
          paramMsgSummary.append(paramQQAppInterface.getCurrentAccountUin());
          paramQQAppInterface = paramMsgSummary.toString();
          paramMessage.edit().putLong(paramQQAppInterface, System.currentTimeMillis()).commit();
        }
      }
      else
      {
        localObject = localGameCenterSessionInfo.h();
        paramMessage = localIGameMsgManagerService.getGamePrefix();
        paramQQAppInterface = paramMessage;
        if (!TextUtils.isEmpty(paramMessage)) {
          try
          {
            i = paramMessage.indexOf("<");
            int k = paramMessage.indexOf(">");
            paramQQAppInterface = paramMessage;
            if (k >= 0)
            {
              paramQQAppInterface = paramMessage;
              if (i >= 0)
              {
                paramQQAppInterface = paramMessage.substring(i, k + 1);
                k = Integer.parseInt(paramQQAppInterface.substring(1, paramQQAppInterface.length() - 1));
                i = k;
                if (k >= IGameMsgHelperApi.sEmojiList.length) {
                  i = 0;
                }
                paramQQAppInterface = paramMessage.replace(paramQQAppInterface, IGameMsgHelperApi.sEmojiList[i]);
              }
            }
          }
          catch (Exception paramQQAppInterface)
          {
            QLog.e("GameMsgUtil", 2, paramQQAppInterface, new Object[0]);
            paramQQAppInterface = "[游戏好友]";
          }
        }
        paramMessage = new StringBuilder();
        paramMessage.append(paramQQAppInterface);
        paramMessage.append(" ");
        paramMessage.append((String)localObject);
        paramMessage.append(": ");
        paramMessage.append(localGameCenterSessionInfo.i());
        paramMsgSummary.strContent = new QQText(paramMessage.toString(), 3, 16, -1);
        localRecentUser.lastmsgtime = localGameCenterSessionInfo.a();
        paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.a();
      }
      localIGameMsgManagerService.setMsgShowOnList(true);
      i = j;
      if (localIGameMsgManagerService.getUnshowedUnreadCnt() != 0)
      {
        localIGameMsgManagerService.setNeedPopMsgView(true);
        if (localIGameMsgManagerService.getUnreadCnt(false) == 0) {
          localIGameMsgManagerService.setShowReqMsgUnread(true);
        }
        i = 0;
      }
      paramQQAppInterface = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      paramMessage = localGameCenterSessionInfo.e();
      paramMsgSummary = new StringBuilder();
      paramMsgSummary.append(i);
      paramMsgSummary.append("");
      paramMsgSummary = paramMsgSummary.toString();
      paramRecentItemPublicAccountChatMsgData = new StringBuilder();
      paramRecentItemPublicAccountChatMsgData.append(localGameCenterSessionInfo.a());
      paramRecentItemPublicAccountChatMsgData.append("");
      paramQQAppInterface.reportForGameMsg(paramMessage, "1", "145", "920", "92003", "206345", paramMsgSummary, paramRecentItemPublicAccountChatMsgData.toString(), "0", "8", "0", "", "");
      QLog.isColorLevel();
      label1012:
      return;
    }
    if (!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid((MessageRecord)localObject))
    {
      paramQQAppInterface = paramMessage.a("2747277822", 1008);
      if (paramQQAppInterface != null) {
        paramMessage.a(paramQQAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgUtil
 * JD-Core Version:    0.7.0.1
 */