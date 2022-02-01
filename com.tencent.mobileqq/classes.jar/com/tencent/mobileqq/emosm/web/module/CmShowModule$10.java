package com.tencent.mobileqq.emosm.web.module;

import android.os.Bundle;
import android.os.Message;
import ankc;
import annl;
import annm;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowModule$10
  implements Runnable
{
  CmShowModule$10(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject2;
    ApolloFavActionData localApolloFavActionData;
    if (this.val$qqApp != null)
    {
      localObject2 = (ankc)this.val$qqApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      localApolloFavActionData = ((ankc)localObject2).a(this.val$seq);
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("seq", this.val$seq);
          if (localApolloFavActionData != null) {
            continue;
          }
          localJSONObject.put("ret", 1);
          if (QLog.isColorLevel()) {
            QLog.d("CmShowHandler", 2, "del fav but local has not the action");
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("CmShowHandler", 2, "delFavAction json error + " + localJSONException.toString());
          return;
          ((ankc)localObject2).b(localApolloFavActionData);
          localJSONException.put("ret", 0);
          MqqHandler localMqqHandler = this.val$qqApp.getHandler(ChatActivity.class);
          if (localMqqHandler == null) {
            continue;
          }
          Object localObject1 = new annm(this.val$qqApp.getCurrentUin());
          ((annl)localObject1).a = ((ankc)localObject2).a(this.val$actionId);
          ((annl)localObject1).b = localApolloFavActionData.text;
          ((annl)localObject1).d = localApolloFavActionData.textType;
          localObject2 = localMqqHandler.obtainMessage(66);
          ((Message)localObject2).obj = localObject1;
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CmShowHandler", 2, "del fav action success +" + localJSONException.toString());
          continue;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavAction", localJSONObject.toString());
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.val$service.a(this.val$reqbundle);
        return;
        if (this.val$actionId == localApolloFavActionData.acitonId) {
          continue;
        }
        localJSONObject.put("ret", 2);
        if (QLog.isColorLevel()) {
          QLog.d("CmShowHandler", 2, "del fav action fail +" + localJSONObject.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.10
 * JD-Core Version:    0.7.0.1
 */