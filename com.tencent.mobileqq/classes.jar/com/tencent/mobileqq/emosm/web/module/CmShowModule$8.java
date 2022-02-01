package com.tencent.mobileqq.emosm.web.module;

import android.os.Bundle;
import ankc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowModule$8
  implements Runnable
{
  CmShowModule$8(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    int i;
    if (this.val$qqApp != null)
    {
      localObject = ((ankc)this.val$qqApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).d();
      localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      if (localObject != null) {
        i = 0;
      }
    }
    try
    {
      while (i < ((List)localObject).size())
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("seq", ((ApolloFavActionData)((List)localObject).get(i)).favId);
        localJSONObject2.put("actionId", ((ApolloFavActionData)((List)localObject).get(i)).acitonId);
        localJSONObject2.put("actionText", ((ApolloFavActionData)((List)localObject).get(i)).text);
        localJSONObject2.put("textType", ((ApolloFavActionData)((List)localObject).get(i)).textType);
        localJSONObject2.put("audioId", ((ApolloFavActionData)((List)localObject).get(i)).audioId);
        if (!Float.isNaN(((ApolloFavActionData)((List)localObject).get(i)).audioStartTime)) {
          localJSONObject2.put("audioStartTime", ((ApolloFavActionData)((List)localObject).get(i)).audioStartTime);
        }
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("favActionSet", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CmShowHandler", 2, "getLocalFavAction json error " + localJSONException.toString());
        }
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("getFavResult", localJSONObject1.toString());
    this.val$reqbundle.putBundle("response", (Bundle)localObject);
    this.val$service.a(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.8
 * JD-Core Version:    0.7.0.1
 */