package com.tencent.mobileqq.emosm.web;

import abwp;
import amtj;
import android.os.Bundle;
import android.text.TextUtils;
import arcu;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.text.QQText;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$32
  implements Runnable
{
  public MessengerService$IncomingHandler$32(arcu paramarcu, JSONArray paramJSONArray, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      JSONObject localJSONObject2;
      int j;
      MessageRecord localMessageRecord;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int k = this.jdField_a_of_type_OrgJsonJSONArray.length();
        int i = 0;
        if (i >= k) {
          break label435;
        }
        localJSONObject1 = new JSONObject();
        Object localObject = this.jdField_a_of_type_OrgJsonJSONArray.getString(i);
        localJSONObject1.put("uin", localObject);
        localJSONObject1.put("unreadMsgCount", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a((String)localObject, 1036));
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("text", "");
        localJSONObject2.put("timestamp", 0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages((String)localObject, 1036, null, 5);
        j = ((List)localObject).size() - 1;
        if (j >= 0)
        {
          localMessageRecord = (MessageRecord)((List)localObject).get(j);
          if ((!(localMessageRecord instanceof ChatMessage)) || ((localMessageRecord instanceof MessageForCmGameTips)) || ((localMessageRecord instanceof MessageForGrayTips)) || ((localMessageRecord instanceof MessageForUniteGrayTip))) {
            break label489;
          }
          if (localMessageRecord != null)
          {
            if (TextUtils.isEmpty(localMessageRecord.msg)) {
              ((ChatMessage)localMessageRecord).parse();
            }
            if (!(localMessageRecord instanceof MessageForApollo)) {
              continue;
            }
            localJSONObject2.put("text", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForApollo)localMessageRecord));
            localJSONObject2.put("timestamp", localMessageRecord.time);
          }
        }
        localJSONObject1.put("latestMsg", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
        continue;
        if ((localMessageRecord instanceof MessageForPic))
        {
          localJSONObject2.put("text", amtj.a(2131705798));
          localJSONObject2.put("timestamp", localMessageRecord.time);
          continue;
        }
        if (TextUtils.isEmpty(localMessageRecord.msg)) {
          break label406;
        }
      }
      catch (Exception localException)
      {
        localBundle.putString("result", "");
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      localJSONObject2.put("text", new QQText(localMessageRecord.msg, 3).toPlainText());
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label406:
      localJSONObject2.put("text", amtj.a(2131705802));
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label435:
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("friendMsgList", localException);
      localBundle.putString("result", localJSONObject1.toString());
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      label489:
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.32
 * JD-Core Version:    0.7.0.1
 */