package com.tencent.mobileqq.now.message;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatMessageHelper
{
  public static String a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      return "";
    }
    paramChatMessage = (MessageForStructing)paramChatMessage;
    if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
      return "";
    }
    return ((StructMsgForGeneralShare)paramChatMessage.structingMsg).mContentCover;
  }
  
  public static String a(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null))
    {
      if (TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.metaList)) {
        return "";
      }
      try
      {
        paramMessageForArkApp = new JSONObject(paramMessageForArkApp.ark_app_message.metaList);
        if (TextUtils.isEmpty(paramMessageForArkApp.optString("msgInfo"))) {
          return "";
        }
        paramMessageForArkApp = new JSONObject(paramMessageForArkApp.optString("msgInfo")).optString("jump_url");
        return paramMessageForArkApp;
      }
      catch (JSONException paramMessageForArkApp)
      {
        paramMessageForArkApp.printStackTrace();
        QLog.e("ChatMessageHelper", 4, paramMessageForArkApp, new Object[0]);
      }
    }
    return "";
  }
  
  public static String b(ChatMessage paramChatMessage)
  {
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend");
    if (TextUtils.isEmpty(paramChatMessage)) {
      return "";
    }
    try
    {
      paramChatMessage = new JSONObject(paramChatMessage).optString("oac_triggle");
      if (TextUtils.isEmpty(paramChatMessage)) {
        return "";
      }
      int i = paramChatMessage.indexOf("ad_id=");
      int j = paramChatMessage.length();
      int k = i + 12;
      if (j < k) {
        return paramChatMessage.substring(i + 6);
      }
      paramChatMessage = paramChatMessage.substring(i + 6, k);
      return paramChatMessage;
    }
    catch (JSONException paramChatMessage)
    {
      paramChatMessage.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.ChatMessageHelper
 * JD-Core Version:    0.7.0.1
 */