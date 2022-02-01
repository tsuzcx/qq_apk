package com.tencent.mobileqq.emosm.web.module;

import amme;
import android.os.Bundle;
import ankc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class CmShowModule$17
  implements Runnable
{
  CmShowModule$17(CmShowModule paramCmShowModule, String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      Object localObject2 = new JSONObject(this.val$gameListStr);
      ((JSONObject)localObject2).optLong("timestamp");
      Object localObject1 = new ArrayList();
      localObject2 = ((JSONObject)localObject2).optJSONArray("gameList");
      while (i < ((JSONArray)localObject2).length())
      {
        ApolloGameRoamData localApolloGameRoamData = new ApolloGameRoamData();
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        localApolloGameRoamData.gameId = localJSONObject.optInt("gameId");
        localApolloGameRoamData.type = localJSONObject.optInt("tab");
        ((ArrayList)localObject1).add(localApolloGameRoamData);
        i += 1;
      }
      if (this.val$qqApp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmShowHandler", 2, "IPC_APOLLO_UPDATE_GAME_LIST, update game list");
        }
        localObject2 = (ankc)this.val$qqApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
        ((ankc)localObject2).c();
        ((ankc)localObject2).b((ArrayList)localObject1);
        ((amme)this.val$qqApp.getManager(QQManagerFactory.APOLLO_MANAGER)).e();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("result", 0);
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.val$service.a(this.val$reqbundle);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmShowHandler", 1, "IPC_APOLLO_UPDATE_GAME_LIST, exception=", localException);
      Bundle localBundle = new Bundle();
      localBundle.putInt("result", 1);
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.a(this.val$reqbundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.17
 * JD-Core Version:    0.7.0.1
 */