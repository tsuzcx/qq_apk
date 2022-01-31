package com.tencent.mobileqq.emosm.web;

import aiyu;
import ajbx;
import ajcd;
import android.os.Bundle;
import android.os.Message;
import aned;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$26
  implements Runnable
{
  public MessengerService$IncomingHandler$26(aned paramaned, QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localObject2 = new ApolloFavActionData();
      ((ApolloFavActionData)localObject2).acitonId = this.jdField_a_of_type_Int;
      ((ApolloFavActionData)localObject2).text = this.jdField_a_of_type_JavaLangString;
      ((ApolloFavActionData)localObject2).textType = this.b;
      ((ApolloFavActionData)localObject2).audioId = this.c;
      ((ApolloFavActionData)localObject2).playOriginalAudio = this.d;
      ((ApolloFavActionData)localObject2).audioStartTime = this.jdField_a_of_type_Float;
      l = System.currentTimeMillis();
      ((ApolloFavActionData)localObject2).favId = l;
      ((aiyu)localObject1).a((ApolloFavActionData)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "add fav action success +" + ((ApolloFavActionData)localObject2).toString());
      }
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        localObject2 = new ajcd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        ((ajbx)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((aiyu)localObject1).a(this.jdField_a_of_type_Int);
        ((ajbx)localObject2).b = this.jdField_a_of_type_JavaLangString;
        ((ajbx)localObject2).d = this.b;
        ((ajbx)localObject2).e = this.c;
        ((ajbx)localObject2).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
        ((ajbx)localObject2).f = this.d;
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
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.MessengerService", 2, "addFavAction ipc json error + " + localJSONException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.26
 * JD-Core Version:    0.7.0.1
 */