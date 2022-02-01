package com.tencent.mobileqq.emosm.web.module;

import android.os.Bundle;
import android.os.Message;
import ankc;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowModule$11
  implements Runnable
{
  CmShowModule$11(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = 0;
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    if (this.val$qqApp != null)
    {
      localObject2 = (ankc)this.val$qqApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      JSONObject localJSONObject = new JSONObject();
      localObject1 = new JSONArray();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.val$delString);
        if (i >= localJSONArray.length()) {
          break label180;
        }
        Object localObject3 = localJSONArray.getJSONObject(i);
        long l = ((JSONObject)localObject3).optLong("seq");
        int j = ((JSONObject)localObject3).optInt("actionId");
        localObject3 = ((ankc)localObject2).a(l);
        if ((localObject3 == null) || (j != ((ApolloFavActionData)localObject3).acitonId)) {
          ((JSONArray)localObject1).put(l);
        } else {
          localArrayList.add(localObject3);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CmShowHandler", 2, "delFavAction json error + " + localJSONException.toString());
        }
      }
      return;
      label180:
      if (localArrayList.size() > 0)
      {
        ((ankc)localObject2).f(localArrayList);
        localObject2 = this.val$qqApp.getHandler(ChatActivity.class);
        if (localObject2 != null)
        {
          localObject2 = ((MqqHandler)localObject2).obtainMessage(66);
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (QLog.isColorLevel()) {
            QLog.d("CmShowHandler", 2, "del fav action success +" + localJSONException.toString());
          }
        }
      }
      if (((JSONArray)localObject1).length() > 0) {
        localJSONException.put("delHasError", true);
      }
      for (;;)
      {
        localJSONException.put("errorList", ((JSONArray)localObject1).toString());
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavListAction", localJSONException.toString());
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.val$service.a(this.val$reqbundle);
        return;
        localJSONException.put("delHasError", false);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.11
 * JD-Core Version:    0.7.0.1
 */