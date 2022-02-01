package com.tencent.mobileqq.emosm.web.module;

import amme;
import amsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import anvx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowModule$12
  implements Runnable
{
  CmShowModule$12(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    label281:
    int i;
    if (this.val$qqApp != null)
    {
      do
      {
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject(this.val$writeDataJson);
            JSONObject localJSONObject = new JSONObject();
            localObject2 = ((JSONObject)localObject1).optString("optType");
            if (!"flower".equals(localObject2)) {
              break label281;
            }
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("toUin");
              localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
              Calendar localCalendar = Calendar.getInstance();
              ((SharedPreferences)localObject2).edit().putBoolean(this.val$qqApp.getCurrentAccountUin() + "apollo_today_has_vote" + (String)localObject1 + localCalendar.get(1) + localCalendar.get(2) + localCalendar.get(5), true).commit();
              localJSONObject.put("result", 0);
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("writeRet", localJSONObject.toString());
              this.val$reqbundle.putBundle("response", (Bundle)localObject1);
              this.val$service.a(this.val$reqbundle);
              return;
            }
            localJSONObject.put("result", 1);
            localJSONObject.put("msg", anvx.a(2131706139));
            continue;
            QLog.e("CmShowHandler", 2, "delFavAction json error + " + localJSONException.toString());
          }
          catch (JSONException localJSONException)
          {
            if (!QLog.isColorLevel()) {
              break label793;
            }
          }
          return;
          if ("gameIntro".equals(localObject2))
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if (localObject1 != null)
            {
              i = ((JSONObject)localObject1).optInt("gameId");
              BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putBoolean("apollo_game_first_clk_" + i, false).commit();
              localJSONException.put("result", 0);
              if (QLog.isColorLevel()) {
                QLog.d("CmShowHandler", 2, "gameIntro from web write, gameId:" + i);
              }
            }
          }
          else if ("lifeChange".equals(localObject2))
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("data");
            if ((localObject1 != null) && (this.val$qqApp != null))
            {
              i = ((JSONObject)localObject1).optInt("gameId");
              int j = ((JSONObject)localObject1).optInt("life");
              if (QLog.isColorLevel()) {
                QLog.d("CmShowHandler", 2, new Object[] { "lifeChange, gameId", Integer.valueOf(i), ", game coin count=" + j });
              }
              ApolloGameUtil.a(this.val$qqApp, j);
              localObject1 = this.val$qqApp.getHandler(ChatActivity.class);
              if (localObject1 != null) {
                ((MqqHandler)localObject1).obtainMessage(76).sendToTarget();
              }
              localJSONException.put("result", 0);
            }
            else
            {
              localJSONException.put("result", 1);
              localJSONException.put("msg", anvx.a(2131706159));
            }
          }
          else
          {
            if (!"danUpgrade".equals(localObject2)) {
              break;
            }
            ((VasExtensionHandler)this.val$qqApp.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(this.val$qqApp.getCurrentUin(), 128, "refreshAction");
            if (QLog.isColorLevel()) {
              QLog.d("CmShowHandler", 2, "ipc call danUpgrade,maybe have new slave action");
            }
            localJSONException.put("result", 0);
          }
        }
        if (!"drawerAudio".equals(localObject2)) {
          break;
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
      } while (localObject1 == null);
      if (((JSONObject)localObject1).has("audio"))
      {
        i = ((JSONObject)localObject1).optInt("audio");
        break label794;
      }
    }
    for (;;)
    {
      amsg.a(bool);
      break;
      QLog.e("ApolloJsApi", 1, "drawerVoice has no val");
      i = 0;
      break label794;
      if (!"lastShopScheme".equals(localObject2)) {
        break;
      }
      localObject1 = ((JSONObject)localObject1).optJSONObject("data");
      if (QLog.isColorLevel()) {
        QLog.d("CmShowHandler", 2, new Object[] { "lastShopScheme, data=", localObject1 });
      }
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((JSONObject)localObject1).optString("lastShopScheme");
      ((amme)this.val$qqApp.getManager(QQManagerFactory.APOLLO_MANAGER)).c((String)localObject1);
      break;
      label793:
      label794:
      do
      {
        bool = true;
        break;
        return;
        if (i == 0) {
          break;
        }
      } while (i != 1);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.12
 * JD-Core Version:    0.7.0.1
 */