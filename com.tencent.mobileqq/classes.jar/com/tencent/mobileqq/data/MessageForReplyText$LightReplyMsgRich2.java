package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForReplyText$LightReplyMsgRich2
{
  public String emotionId;
  public int msgType;
  public int subMsgId;
  
  public MessageForReplyText$LightReplyMsgRich2(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      this.emotionId = localJSONObject.optString("emoji_id");
      this.msgType = localJSONObject.optInt("msg_type");
      this.subMsgId = localJSONObject.optInt("submsg_index", 0);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("zivonchen", 2, "MessageForReplyText LightReplyMsgRich2 = " + paramString + ", exception:" + localJSONException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForReplyText.LightReplyMsgRich2
 * JD-Core Version:    0.7.0.1
 */