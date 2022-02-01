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
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class GameMsgUtil
{
  public static void a(QQAppInterface paramQQAppInterface, Message paramMessage, MsgSummary paramMsgSummary, RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData)
  {
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().r("2747277822", 1008);
    Object localObject1 = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if (!((IGameMsgManagerService)localObject1).isGrayOpen()) {
      return;
    }
    ((IGameMsgManagerService)localObject1).setMsgShowOnList(false);
    ((IGameMsgManagerService)localObject1).setNeedPopMsgView(false);
    ((IGameMsgManagerService)localObject1).setShowReqMsgUnread(false);
    Object localObject2 = paramQQAppInterface.getRecentUserProxy();
    Object localObject3 = ((RecentUserProxy)localObject2).b("2747277822", 1008);
    int i = ((IGameMsgManagerService)localObject1).getUnshowedUnreadCnt();
    paramRecentItemPublicAccountChatMsgData.mUnreadNum += i;
    if (a(paramQQAppInterface, localMessageRecord)) {
      return;
    }
    paramMessage = ((IGameMsgManagerService)localObject1).getLastSessionInfoExceptDelSession();
    i = 1;
    if (paramMessage == null)
    {
      if (!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(localMessageRecord))
      {
        paramMessage = ((RecentUserProxy)localObject2).b("2747277822", 1008);
        if (paramMessage != null)
        {
          ((RecentUserProxy)localObject2).a(paramMessage);
          paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.sendEmptyMessage(1009);
          }
          QLog.i("GameMsgUtil", 1, "del pubacc from recent session.");
        }
      }
      return;
    }
    if (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(localMessageRecord))
    {
      if (localMessageRecord.time > paramMessage.n()) {
        return;
      }
      if ((!((IGameMsgManagerService)localObject1).getHasUnreadMsg()) && (paramMessage.f() == 1))
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
      localStringBuilder.append(paramMessage);
      localStringBuilder.append(",  msg:");
      localStringBuilder.append(localMessageRecord);
      QLog.d("GameMsgUtil", 2, localStringBuilder.toString());
    }
    if ((paramMessage != null) && (paramMessage.n() != 0L))
    {
      if ((paramMessage.o() > 0) || (localMessageRecord == null) || (paramMessage.n() > localMessageRecord.time))
      {
        if (paramMessage.f() == 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(paramMessage.l());
          ((StringBuilder)localObject2).append("位好友请求] 来自");
          ((StringBuilder)localObject2).append(paramMessage.i());
          paramMsgSummary.strContent = new QQText(((StringBuilder)localObject2).toString(), 3, 16, -1);
          long l = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastTopReqMsgTime(paramQQAppInterface);
          paramRecentItemPublicAccountChatMsgData.mDisplayTime = paramMessage.n();
          if ((((IGameMsgManagerService)localObject1).getReqMsgCnt() == 1L) || ((!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isToday(l)) && (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isToday(paramMessage.n() * 1000L))))
          {
            ((RecentUser)localObject3).lastmsgtime = paramMessage.n();
            paramRecentItemPublicAccountChatMsgData.mDisplayTime = paramMessage.n();
            paramRecentItemPublicAccountChatMsgData = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sp_top_last_time");
            ((StringBuilder)localObject2).append(paramQQAppInterface.getCurrentAccountUin());
            localObject2 = ((StringBuilder)localObject2).toString();
            paramRecentItemPublicAccountChatMsgData.edit().putLong((String)localObject2, System.currentTimeMillis()).commit();
          }
        }
        else
        {
          a(paramMessage, (IGameMsgManagerService)localObject1, paramMsgSummary, (RecentUser)localObject3, paramRecentItemPublicAccountChatMsgData);
        }
        ((IGameMsgManagerService)localObject1).setMsgShowOnList(true);
        if (((IGameMsgManagerService)localObject1).getUnshowedUnreadCnt() != 0)
        {
          ((IGameMsgManagerService)localObject1).setNeedPopMsgView(true);
          if (((IGameMsgManagerService)localObject1).getUnreadCnt(false) == 0) {
            ((IGameMsgManagerService)localObject1).setShowReqMsgUnread(true);
          }
          i = 0;
        }
        paramRecentItemPublicAccountChatMsgData = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
        localObject1 = paramMessage.h();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramMessage.f());
        ((StringBuilder)localObject3).append("");
        paramRecentItemPublicAccountChatMsgData.reportForGameMsg((String)localObject1, "1", "145", "920", "92003", "206345", (String)localObject2, ((StringBuilder)localObject3).toString(), "0", "8", "0", "", "");
        QLog.isColorLevel();
        if (!TextUtils.isEmpty(paramMsgSummary.strContent))
        {
          paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_gamebox_public_summary_".concat(paramQQAppInterface.getCurrentUin()), 0);
          paramMessage = new StringBuilder(paramMsgSummary.strContent.length());
          paramMessage.append(paramMsgSummary.strContent);
          paramQQAppInterface.edit().putString("lastPublicContentStr", paramMessage.toString()).putInt("lastPublicPicFlag", paramMsgSummary.mEmojiFlag).putInt("lastPublicState", paramMsgSummary.nState).apply();
        }
      }
      return;
    }
    if (!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(localMessageRecord))
    {
      paramQQAppInterface = ((RecentUserProxy)localObject2).b("2747277822", 1008);
      if (paramQQAppInterface != null) {
        ((RecentUserProxy)localObject2).a(paramQQAppInterface);
      }
    }
  }
  
  public static void a(IGameMsgManagerService paramIGameMsgManagerService, QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary, RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if ((paramMsgSummary != null) && (TextUtils.isEmpty(paramMsgSummary.strContent)))
    {
      paramIGameMsgManagerService.setMsgShowOnList(false);
      paramIGameMsgManagerService.setNeedPopMsgView(false);
      paramIGameMsgManagerService.setShowReqMsgUnread(false);
      Object localObject1 = paramQQAppInterface.getApplication().getSharedPreferences("sp_gamebox_public_summary_".concat(paramQQAppInterface.getCurrentUin()), 0);
      paramMsgSummary.strContent = new QQText(((SharedPreferences)localObject1).getString("lastPublicContentStr", ""), 3, 16, -1);
      paramMsgSummary.mEmojiFlag = ((SharedPreferences)localObject1).getInt("lastPublicPicFlag", 0);
      paramMsgSummary.nState = ((SharedPreferences)localObject1).getInt("lastPublicState", 0);
      Object localObject2 = ((IGameMsgBoxRuntimeService)paramQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getGameRecentUser();
      localObject1 = (IGameMsgBoxManager)paramQQAppInterface.getRuntimeService(IGameMsgBoxManager.class, "");
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((!((IGameMsgBoxManager)localObject1).isGameInGameBox(paramQQAppInterface, localRecentUser.uin)) && (TextUtils.isEmpty(paramMsgSummary.strContent)))
        {
          if (paramGameCenterSessionInfo != null)
          {
            a(paramGameCenterSessionInfo, paramIGameMsgManagerService, paramMsgSummary, localRecentUser, paramRecentItemPublicAccountChatMsgData);
            break;
          }
          paramMsgSummary.strContent = new QQText("您有未读游戏消息", 3, 16, -1);
        }
      }
    }
    paramRecentItemPublicAccountChatMsgData.mUnreadNum = paramIGameMsgManagerService.getUnshowedUnreadCnt();
  }
  
  private static void a(GameCenterSessionInfo paramGameCenterSessionInfo, IGameMsgManagerService paramIGameMsgManagerService, MsgSummary paramMsgSummary, RecentUser paramRecentUser, RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData)
  {
    String str = paramGameCenterSessionInfo.k();
    Object localObject = paramIGameMsgManagerService.getGamePrefix();
    paramIGameMsgManagerService = (IGameMsgManagerService)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        int i = ((String)localObject).indexOf("<");
        int j = ((String)localObject).indexOf(">");
        paramIGameMsgManagerService = (IGameMsgManagerService)localObject;
        if (j >= 0)
        {
          paramIGameMsgManagerService = (IGameMsgManagerService)localObject;
          if (i >= 0)
          {
            paramIGameMsgManagerService = ((String)localObject).substring(i, j + 1);
            j = Integer.parseInt(paramIGameMsgManagerService.substring(1, paramIGameMsgManagerService.length() - 1));
            i = j;
            if (j >= IGameMsgHelperApi.S_EMOJI_LIST.length) {
              i = 0;
            }
            paramIGameMsgManagerService = ((String)localObject).replace(paramIGameMsgManagerService, IGameMsgHelperApi.S_EMOJI_LIST[i]);
          }
        }
      }
      catch (Exception paramIGameMsgManagerService)
      {
        QLog.e("GameMsgUtil", 2, paramIGameMsgManagerService, new Object[0]);
        paramIGameMsgManagerService = "[游戏好友]";
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramIGameMsgManagerService);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(paramGameCenterSessionInfo.m());
    paramMsgSummary.strContent = new QQText(((StringBuilder)localObject).toString(), 3, 16, -1);
    paramRecentUser.lastmsgtime = paramGameCenterSessionInfo.n();
    paramRecentItemPublicAccountChatMsgData.mDisplayTime = paramGameCenterSessionInfo.n();
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    long l = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getGamePubLastReadTime();
    QLog.i("GameMsgUtil", 1, "[isHasUnreadGamePublicMsg]");
    if ((paramQQAppInterface != null) && (paramMessageRecord != null) && (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).checkMesssageIsValid(paramMessageRecord)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pubLastReadTime:");
      localStringBuilder.append(l);
      localStringBuilder.append(",recent Msg time:");
      localStringBuilder.append(paramMessageRecord.time);
      QLog.i("GameMsgUtil", 1, localStringBuilder.toString());
      if ((l > 0L) && (l < paramMessageRecord.time))
      {
        QLog.i("GameMsgUtil", 1, "HAS unread game public msg. case 1");
        return true;
      }
      int i = ((IConversationFacade)paramQQAppInterface.getRuntimeService(IConversationFacade.class)).getUnreadCount("2747277822", 1008);
      if (i > 0)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("HAS unread game public msg. case 2, num:");
        paramQQAppInterface.append(i);
        QLog.i("GameMsgUtil", 1, paramQQAppInterface.toString());
        return true;
      }
      return false;
    }
    QLog.w("GameMsgUtil", 1, "invalid param or invalid public msg");
    return false;
  }
  
  public static boolean a(IGameMsgManagerService paramIGameMsgManagerService, IGameMsgBoxManager paramIGameMsgBoxManager, String paramString, QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary, RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData)
  {
    boolean bool;
    if ((paramIGameMsgManagerService.isShowInMsgBox()) && (paramIGameMsgBoxManager.isGameInGameBox(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      a(paramIGameMsgManagerService, paramQQAppInterface, paramMsgSummary, paramRecentItemPublicAccountChatMsgData, paramIGameMsgManagerService.getLastSessionInfoExceptDelSession());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgUtil
 * JD-Core Version:    0.7.0.1
 */