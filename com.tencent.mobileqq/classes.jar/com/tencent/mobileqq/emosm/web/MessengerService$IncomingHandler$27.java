package com.tencent.mobileqq.emosm.web;

import aleh;
import alhk;
import alhq;
import android.os.Bundle;
import android.os.Message;
import aply;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$27
  implements Runnable
{
  public MessengerService$IncomingHandler$27(aply paramaply, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject2;
    ApolloFavActionData localApolloFavActionData;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = (aleh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localApolloFavActionData = ((aleh)localObject2).a(this.jdField_a_of_type_Long);
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("seq", this.jdField_a_of_type_Long);
          if (localApolloFavActionData != null) {
            continue;
          }
          localJSONObject.put("ret", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "del fav but local has not the action");
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("Q.emoji.web.MessengerService", 2, "delFavAction json error + " + localJSONException.toString());
          return;
          ((aleh)localObject2).b(localApolloFavActionData);
          localJSONException.put("ret", 0);
          MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
          if (localMqqHandler == null) {
            continue;
          }
          Object localObject1 = new alhq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ((alhk)localObject1).a = ((aleh)localObject2).a(this.jdField_a_of_type_Int);
          ((alhk)localObject1).b = localApolloFavActionData.text;
          ((alhk)localObject1).d = localApolloFavActionData.textType;
          localObject2 = localMqqHandler.obtainMessage(66);
          ((Message)localObject2).obj = localObject1;
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.emoji.web.MessengerService", 2, "del fav action success +" + localJSONException.toString());
          continue;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavAction", localJSONObject.toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
        if (this.jdField_a_of_type_Int == localApolloFavActionData.acitonId) {
          continue;
        }
        localJSONObject.put("ret", 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.web.MessengerService", 2, "del fav action fail +" + localJSONObject.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.27
 * JD-Core Version:    0.7.0.1
 */