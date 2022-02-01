package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TempApiImpl
  implements ITempApi
{
  public static final String TAG = "TempApiImpl";
  
  private static Intent getClickNotifyHippyIntent(AppInterface paramAppInterface, Context paramContext)
  {
    if (paramAppInterface != null)
    {
      if (paramContext == null) {
        return null;
      }
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySwitch())
      {
        QLog.e("TempApiImpl", 1, "[getClickNotifyHippyIntent] hippy switch is off, ail to open by hippy");
        return null;
      }
      QLog.i("TempApiImpl", 1, "getClickNotifyHippyIntent success.");
      paramAppInterface = new Intent(paramContext, JumpActivity.class);
      paramAppInterface.setData(Uri.parse("mqqapi://hippy/open?bundleName%3DQQGameCenter%26url%3Dhttps%253A%252F%252Fstatic.gamecenter.qq.com%252Fxgame-hippy%252Fdist%252Fhome%252Fandroid%252Fmain.js%253Fpage%253Dmsg%2526isPredrawWhenClosed%253Dtrue%2526isAnimated%253Dtrue%2526isTrasparent%253Dfalse%2526isStatusBarDarkFont%253Dtrue%2526version%253D1%2526src_type%253Dweb%2526adtag%253DlockScreen"));
      return paramAppInterface;
    }
    return null;
  }
  
  public void addTinySessionKey(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QQAppInterface localQQAppInterface = getQQAppinterface();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.getMsgCache().c(paramString1, paramString2, paramArrayOfByte);
      return;
    }
    throw new RuntimeException("fail to get QQAppInterface.");
  }
  
  public Intent getIntentFromMsg(Context paramContext, Message paramMessage, AppInterface paramAppInterface)
  {
    if (((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab())
    {
      localObject1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getTinyConvInfo(paramMessage.frienduin, 10007);
      if (localObject1 != null)
      {
        paramContext = new Intent(paramContext, ChatActivity.class);
        paramContext.putExtra("uin", paramMessage.frienduin);
        paramContext.putExtra("uintype", 10007);
        paramMessage = ((ConversationInfo)localObject1).tinyInfo.fromRoleId;
        paramAppInterface = ((ConversationInfo)localObject1).tinyInfo.toRoleId;
        paramContext.putExtra("game_msg_friend_role_id", paramMessage);
        paramContext.putExtra("game_msg_my_role_id", paramAppInterface);
        return paramContext;
      }
    }
    Object localObject1 = getClickNotifyHippyIntent(paramAppInterface, paramContext);
    if (localObject1 != null)
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).report(paramAppInterface, paramMessage.frienduin, 10006, 2);
      return localObject1;
    }
    Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
    Object localObject2 = paramMessage.frienduin;
    localIntent.putExtra("uin", (String)localObject2);
    localIntent.putExtra("uintype", 10007);
    if (paramAppInterface != null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TempApiImpl", 2, "getIntentFromMsg is called!.");
        }
        localObject1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getTinyConvInfo((String)localObject2, 10007);
        if (localObject1 != null)
        {
          paramContext = ((ConversationInfo)localObject1).tinyInfo.fromRoleId;
          localObject1 = ((ConversationInfo)localObject1).tinyInfo.toRoleId;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[getIntentFromMsg], uin:");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(",fRoleId:");
          ((StringBuilder)localObject3).append(paramContext);
          ((StringBuilder)localObject3).append(",mRoleId:");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.i("TempApiImpl", 1, ((StringBuilder)localObject3).toString());
          localObject3 = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
          paramContext = ((IGameMsgManagerService)localObject3).getSingleGameDetail((String)localObject1);
          if (paramContext == null) {
            break label589;
          }
          paramContext = ((IGameMsgManagerService)localObject3).findGameSwitchConfig(paramContext.c);
          if ((paramContext == null) || (paramContext.mSyncSwitch == 1)) {
            break label589;
          }
          i = 0;
          localObject1 = ((IGameMsgManagerService)localObject3).getGameMsgListUrl();
          paramContext = (Context)localObject1;
          if (i == 0)
          {
            localObject2 = ((IGameMsgManagerService)localObject3).getSessionInfoByUin((String)localObject2);
            paramContext = (Context)localObject1;
            if (localObject2 != null)
            {
              paramContext = new StringBuilder();
              paramContext.append((String)localObject1);
              paramContext.append("&&gameId=");
              paramContext.append(((GameCenterSessionInfo)localObject2).h());
              paramContext.append("&gameName=");
              paramContext.append(((GameCenterSessionInfo)localObject2).i());
              paramContext.append("&sessionId=");
              paramContext.append(((GameCenterSessionInfo)localObject2).g());
              paramContext.append("&requestCount=");
              paramContext.append(((GameCenterSessionInfo)localObject2).l());
              paramContext = paramContext.toString();
            }
          }
          localIntent.putExtra("url", paramContext);
          localIntent.addFlags(268435456);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
          localIntent.putExtra("game_msg_enter_from", 1);
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("TempApiImpl", 1, "getIntentFromMsg is called!. error", paramContext);
      }
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).report(paramAppInterface, paramMessage.frienduin, 10006, 2);
      return localIntent;
      label589:
      int i = 1;
    }
  }
  
  public QQAppInterface getQQAppinterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void refreshAppBadge(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (paramAppInterface.isLogin())) {
      ((IAppBadgeService)((QQAppInterface)paramAppInterface).getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  public void updateRecentList(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getHandler(Conversation.class);
    paramAppInterface.sendMessage(paramAppInterface.obtainMessage(1009));
    if (QLog.isColorLevel()) {
      QLog.d("TempApiImpl", 2, "[updateRecentList] send update list msg.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.TempApiImpl
 * JD-Core Version:    0.7.0.1
 */