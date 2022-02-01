package com.tencent.mobileqq.emosm.web.module;

import acmw;
import android.os.Bundle;
import android.text.TextUtils;
import anvx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.text.QQText;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class CmShowModule$15
  implements Runnable
{
  CmShowModule$15(CmShowModule paramCmShowModule, JSONArray paramJSONArray, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
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
        int k = this.val$uinList.length();
        int i = 0;
        if (i >= k) {
          break label435;
        }
        localJSONObject1 = new JSONObject();
        Object localObject = this.val$uinList.getString(i);
        localJSONObject1.put("uin", localObject);
        localJSONObject1.put("unreadMsgCount", this.val$qqApp.getConversationFacade().a((String)localObject, 1036));
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("text", "");
        localJSONObject2.put("timestamp", 0);
        localObject = this.val$qqApp.getMessageFacade().getAllMessages((String)localObject, 1036, null, 5);
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
            localJSONObject2.put("text", ApolloUtil.a(this.val$qqApp, (MessageForApollo)localMessageRecord));
            localJSONObject2.put("timestamp", localMessageRecord.time);
          }
        }
        localJSONObject1.put("latestMsg", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
        continue;
        if ((localMessageRecord instanceof MessageForPic))
        {
          localJSONObject2.put("text", anvx.a(2131706149));
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
        this.val$reqbundle.putBundle("response", localBundle);
        this.val$service.a(this.val$reqbundle);
        return;
      }
      localJSONObject2.put("text", new QQText(localMessageRecord.msg, 3).toPlainText());
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label406:
      localJSONObject2.put("text", anvx.a(2131706153));
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label435:
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("friendMsgList", localException);
      localBundle.putString("result", localJSONObject1.toString());
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.a(this.val$reqbundle);
      return;
      label489:
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.15
 * JD-Core Version:    0.7.0.1
 */