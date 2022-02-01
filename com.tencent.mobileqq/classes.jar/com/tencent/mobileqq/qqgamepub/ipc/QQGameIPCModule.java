package com.tencent.mobileqq.qqgamepub.ipc;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGameIPCModule
  extends QIPCModule
{
  private static volatile QQGameIPCModule a;
  
  public QQGameIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QQGameIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QQGameIPCModule("QQGameIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCall action=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",params=");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("QQGamePub_QQGameIPCModule.IPCModule", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localObject1 instanceof BaseQQAppInterface)) {
      return null;
    }
    if ("findMessage".equals(paramString))
    {
      paramString = ((IGamePubAccountMsgService)((AppRuntime)localObject1).getRuntimeService(IGamePubAccountMsgService.class, "")).findMessage("2747277822", 3);
      paramBundle = new Bundle();
      paramBundle.putSerializable("key_get_msg", paramString);
      callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
      return null;
    }
    if ("deleteMessage".equals(paramString))
    {
      paramString = paramBundle.getString("frienduin");
      paramInt = paramBundle.getInt("istroop");
      long l = paramBundle.getLong("uniseq");
      ((IGamePubAccountMsgService)((AppRuntime)localObject1).getRuntimeService(IGamePubAccountMsgService.class, "")).deleteMsg(paramString, paramInt, l);
      return null;
    }
    Bundle localBundle;
    if ("getGameMsg".equals(paramString))
    {
      paramString = (IGameMsgManagerService)((AppRuntime)localObject1).getRuntimeService(IGameMsgManagerService.class, "");
      Object localObject2 = paramString.getSessionInfoList();
      paramBundle = new ArrayList();
      if (localObject2 != null) {
        paramBundle.addAll((Collection)localObject2);
      }
      try
      {
        localObject2 = paramBundle.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)((Iterator)localObject2).next();
          if (localGameCenterSessionInfo != null) {
            localGameCenterSessionInfo.a((BaseQQAppInterface)localObject1);
          }
        }
        if (!"doOnResume".equals(paramString)) {
          break label429;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQGamePub_QQGameIPCModule.IPCModule", 1, localException, new Object[0]);
        localBundle = new Bundle();
        localBundle.putSerializable("key_get_game_msg", paramBundle);
        localBundle.putInt("key_get_game_view_type", paramString.getViewType());
        localBundle.putBoolean("key_get_game_show_on_list", paramString.getNeedPopMsgView());
        localBundle.putBoolean("key_get_game_show_req_msg_unread", paramString.getShowReqMsgUnread());
        localBundle.putBoolean("key_get_game_gray_user", paramString.isGrayOpen());
        callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
        return null;
      }
    }
    else
    {
      ((IGameMsgManagerService)localBundle.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
      ((IMessageFacade)localBundle.getRuntimeService(IMessageFacade.class, "")).setReaded("2747277822", 1008, true, true);
      return null;
    }
    label429:
    if ("doOnDestory".equals(paramString))
    {
      ((IGameMsgManagerService)localBundle.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
      return null;
    }
    if ("getGameMsgUrl".equals(paramString))
    {
      paramString = (IGameMsgManagerService)localBundle.getRuntimeService(IGameMsgManagerService.class, "");
      paramBundle = new Bundle();
      paramBundle.putString("key_get_msg_list_url", paramString.getGameMsgListUrl());
      callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
      return null;
    }
    if ("saveGalleryDataToMsg".equals(paramString))
    {
      ((IGamePubAccountMsgService)localBundle.getRuntimeService(IGamePubAccountMsgService.class, "")).saveGalleryDataToMsg(paramBundle);
      return null;
    }
    if ("clearUnreadMsg".equals(paramString))
    {
      ((IGamePubAccountMsgService)localBundle.getRuntimeService(IGamePubAccountMsgService.class, "")).clearUnreadMsg("2747277822");
      return null;
    }
    if ("openSessionPage".equals(paramString))
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).openGameMsgSessionPage(localBundle.getApplication(), null, "other");
      return null;
    }
    if ("action_set_clean_req_time".equals(paramString))
    {
      paramString = localBundle.getAccount();
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastCleanReqMsgTime(paramString, System.currentTimeMillis());
      return null;
    }
    if ("preDownloadDnflutter".equals(paramString)) {
      ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).updateDnFlutter(GamePubAccountHelper.g());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCModule
 * JD-Core Version:    0.7.0.1
 */