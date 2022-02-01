package com.tencent.mobileqq.qqgamepub.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;

final class GamePAPreloadHelper$1
  implements Runnable
{
  public void run()
  {
    try
    {
      GamePAPreloadHelper.a(null);
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadFeedsSwitch())
      {
        GamePAPreloadHelper.a(GamePAPreloadHelper.a(-1001, "ERR_CODE_PRELOAD_CLOSE"));
        if (QLog.isColorLevel()) {
          QLog.i("feedsPreload_QQGamePub_GamePAPreloadHelper", 2, "preloadFeedsInfo:feedsSwitch is close ,just return");
        }
      }
      else
      {
        Object localObject2 = ((IGamePubAccountMsgService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGamePubAccountMsgService.class, "")).findMessage("2747277822", 3);
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("preloadFeedsInfo,findMessage vCost:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - GamePAPreloadHelper.d());
          QLog.i("feedsPreload_QQGamePub_GamePAPreloadHelper", 2, ((StringBuilder)localObject1).toString());
        }
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
        {
          Bundle localBundle1 = new Bundle();
          localObject1 = new JSONArray();
          JSONArray localJSONArray = new JSONArray();
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject2).next();
            if (localQQGameMsgInfo != null) {
              try
              {
                localJSONArray.put(localQQGameMsgInfo.paMsgid);
                localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("msgID", localQQGameMsgInfo.paMsgid);
                ((JSONObject)localObject3).put("appID", localQQGameMsgInfo.gameAppId);
                ((JSONObject)localObject3).put("msgTime", localQQGameMsgInfo.msgTime);
                ((JSONObject)localObject3).put("extJson", localQQGameMsgInfo.extJson);
                ((JSONObject)localObject3).put("sortedConfigs", localQQGameMsgInfo.sortedConfigs);
                ((JSONArray)localObject1).put(localObject3);
              }
              catch (Throwable localThrowable2)
              {
                QLog.e("feedsPreload_QQGamePub_GamePAPreloadHelper", 1, localThrowable2, new Object[0]);
              }
            }
          }
          localBundle1.putString("appList", ((JSONArray)localObject1).toString());
          localBundle1.putInt("isLoadAll", ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadFeedsLoadAll());
          Bundle localBundle2 = new Bundle();
          Object localObject3 = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getAccount();
          localObject2 = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadFeedsUrl();
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = ((TicketManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(2)).getSkey((String)localObject3);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("uin=");
            localStringBuilder.append(HttpBaseUtil.b((String)localObject3));
            localStringBuilder.append(";skey=");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(";o_cookie=");
            localStringBuilder.append((String)localObject3);
            localBundle2.putString("Cookie", localStringBuilder.toString());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("?g_tk=");
            ((StringBuilder)localObject3).append(GamePAPreloadHelper.a((String)localObject1));
            ((StringBuilder)localObject3).append("&x_forward=sg-hippy-android");
            localObject1 = ((StringBuilder)localObject3).toString();
          }
          GamePAPreloadHelper.a(localBundle1, localBundle2, (String)localObject1, localJSONArray);
          return;
        }
        GamePAPreloadHelper.a(GamePAPreloadHelper.a(-1003, "ERR_CODE_REQ_NO_MSG"));
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("feedsPreload_QQGamePub_GamePAPreloadHelper", 1, localThrowable1, new Object[0]);
      GamePAPreloadHelper.a(GamePAPreloadHelper.a(-1002, localThrowable1.toString()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper.1
 * JD-Core Version:    0.7.0.1
 */