package com.tencent.mobileqq.gamecenter.web;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.hippy.GamePubAccountMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import mqq.app.AppRuntime;

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
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QQGameIPCModule("QQGameIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameIPCModule.IPCModule", 2, "onCall action=" + paramString + ",params=" + paramBundle);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {}
    Bundle localBundle;
    do
    {
      return null;
      if ("findMessage".equals(paramString))
      {
        paramString = ((GamePubAccountMsgManager)localAppRuntime.getManager(QQManagerFactory.GAME_PUB_ACCOUNT_MSG_MANAGER)).a("2747277822", 3);
        paramBundle = new Bundle();
        paramBundle.putSerializable("key_get_msg", paramString);
        callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
        return null;
      }
      if ("getGameMsg".equals(paramString))
      {
        paramString = (GameMsgManager)localAppRuntime.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        Object localObject = paramString.a();
        paramBundle = new ArrayList();
        if (localObject != null) {
          paramBundle.addAll((Collection)localObject);
        }
        if (paramBundle != null) {
          try
          {
            localObject = paramBundle.iterator();
            while (((Iterator)localObject).hasNext())
            {
              GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)((Iterator)localObject).next();
              if (localGameCenterSessionInfo != null) {
                localGameCenterSessionInfo.a((QQAppInterface)localAppRuntime);
              }
            }
            localBundle = new Bundle();
          }
          catch (Exception localException)
          {
            QLog.e("QQGameIPCModule.IPCModule", 1, localException, new Object[0]);
          }
        }
        localBundle.putSerializable("key_get_game_msg", paramBundle);
        localBundle.putInt("key_get_game_view_type", paramString.e());
        localBundle.putBoolean("key_get_game_show_on_list", paramString.c);
        localBundle.putBoolean("key_get_game_show_req_msg_unread", paramString.d);
        localBundle.putBoolean("key_get_game_gray_user", paramString.d());
        callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
        return null;
      }
      if ("doOnResume".equals(paramString))
      {
        ((GameMsgManager)localBundle.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(0);
        ((QQAppInterface)localBundle).getMessageFacade().a("2747277822", 1008, true, true);
        return null;
      }
      if ("doOnDestory".equals(paramString))
      {
        ((GameMsgManager)localBundle.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(0);
        return null;
      }
      if ("getGameMsgUrl".equals(paramString))
      {
        paramString = (GameMsgManager)localBundle.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        paramBundle = new Bundle();
        paramBundle.putString("key_get_msg_list_url", paramString.b());
        callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
        return null;
      }
      if ("saveGalleryDataToMsg".equals(paramString))
      {
        ((GamePubAccountMsgManager)localBundle.getManager(QQManagerFactory.GAME_PUB_ACCOUNT_MSG_MANAGER)).a(paramBundle);
        return null;
      }
      if ("clearUnreadMsg".equals(paramString))
      {
        ((GamePubAccountMsgManager)localBundle.getManager(QQManagerFactory.GAME_PUB_ACCOUNT_MSG_MANAGER)).a("2747277822");
        return null;
      }
      if ("openSessionPage".equals(paramString))
      {
        GameMsgUtil.a(localBundle.getApplication(), null, "other");
        return null;
      }
    } while (!"action_set_clean_req_time".equals(paramString));
    GameMsgUtil.a(localBundle.getAccount(), System.currentTimeMillis());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameIPCModule
 * JD-Core Version:    0.7.0.1
 */