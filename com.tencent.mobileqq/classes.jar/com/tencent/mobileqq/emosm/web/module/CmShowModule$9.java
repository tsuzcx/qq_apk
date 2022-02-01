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

class CmShowModule$9
  implements Runnable
{
  CmShowModule$9(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    long l;
    if (this.val$qqApp != null)
    {
      localObject1 = (ankc)this.val$qqApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      localObject2 = new ApolloFavActionData();
      ((ApolloFavActionData)localObject2).acitonId = this.val$actionId;
      ((ApolloFavActionData)localObject2).text = this.val$actionText;
      ((ApolloFavActionData)localObject2).textType = this.val$textType;
      ((ApolloFavActionData)localObject2).audioId = this.val$audioId;
      ((ApolloFavActionData)localObject2).playOriginalAudio = this.val$playOriginalAudio;
      ((ApolloFavActionData)localObject2).audioStartTime = this.val$audioStartTime;
      l = System.currentTimeMillis();
      ((ApolloFavActionData)localObject2).favId = l;
      ((ankc)localObject1).a((ApolloFavActionData)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("CmShowHandler", 2, "add fav action success +" + ((ApolloFavActionData)localObject2).toString());
      }
      MqqHandler localMqqHandler = this.val$qqApp.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        localObject2 = new annm(this.val$qqApp.getCurrentUin());
        ((annl)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ankc)localObject1).a(this.val$actionId);
        ((annl)localObject2).b = this.val$actionText;
        ((annl)localObject2).d = this.val$textType;
        ((annl)localObject2).e = this.val$audioId;
        ((annl)localObject2).jdField_a_of_type_Float = this.val$audioStartTime;
        ((annl)localObject2).f = this.val$playOriginalAudio;
        localObject1 = localMqqHandler.obtainMessage(66);
        ((Message)localObject1).obj = localObject2;
        ((Message)localObject1).sendToTarget();
      }
      localObject1 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("seq", l);
      ((JSONObject)localObject1).put("success", true);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("addFavAction", ((JSONObject)localObject1).toString());
      this.val$reqbundle.putBundle("response", (Bundle)localObject2);
      this.val$service.a(this.val$reqbundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CmShowHandler", 2, "addFavAction ipc json error + " + localJSONException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.9
 * JD-Core Version:    0.7.0.1
 */