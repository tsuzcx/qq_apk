package com.tencent.mobileqq.gamecenter.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.hippy.GamePubAccountMsgManager;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;

final class QQGameHelper$5
  implements Runnable
{
  public void run()
  {
    try
    {
      QQGameHelper.d(null);
      if (!QQGameConfigUtil.f())
      {
        QQGameHelper.d(QQGameHelper.a(-1001, "ERR_CODE_PRELOAD_CLOSE"));
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("feedsPreload_QQGameHelper", 2, "preloadFeedsInfo:feedsSwitch is close ,just return");
        return;
      }
      localObject2 = ((GamePubAccountMsgManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.GAME_PUB_ACCOUNT_MSG_MANAGER)).a("2747277822", 3);
      if (QLog.isColorLevel()) {
        QLog.i("feedsPreload_QQGameHelper", 2, "preloadFeedsInfo,findMessage vCost:" + (System.currentTimeMillis() - QQGameHelper.e()));
      }
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty()))
      {
        QQGameHelper.d(QQGameHelper.a(-1003, "ERR_CODE_REQ_NO_MSG"));
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("feedsPreload_QQGameHelper", 1, localThrowable1, new Object[0]);
      QQGameHelper.d(QQGameHelper.a(-1002, localThrowable1.toString()));
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject1 = new JSONArray();
    JSONArray localJSONArray = new JSONArray();
    Object localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject3;
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
          QLog.e("feedsPreload_QQGameHelper", 1, localThrowable2, new Object[0]);
        }
      }
    }
    localBundle.putString("appList", ((JSONArray)localObject1).toString());
    localBundle.putInt("isLoadAll", QQGameConfigUtil.d());
    localObject2 = new Bundle();
    String str = QQGameHelper.d();
    localObject1 = QQGameConfigUtil.d();
    if (!TextUtils.isEmpty(str))
    {
      localObject3 = ((TicketManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(2)).getSkey(str);
      ((Bundle)localObject2).putString("Cookie", "uin=" + HttpBaseUtil.b(str) + ";skey=" + (String)localObject3 + ";o_cookie=" + str);
      localObject1 = (String)localObject1 + "?g_tk=" + QQGameHelper.a((String)localObject3) + "&x_forward=sg-hippy-android";
    }
    for (;;)
    {
      QQGameHelper.a(localBundle, (Bundle)localObject2, (String)localObject1, localJSONArray);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameHelper.5
 * JD-Core Version:    0.7.0.1
 */