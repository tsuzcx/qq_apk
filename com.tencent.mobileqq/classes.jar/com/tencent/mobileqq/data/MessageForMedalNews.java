package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForMedalNews
  extends ChatMessage
{
  public static final String TAG = "MessageForMedalNews";
  public String desc;
  public String icon;
  public int id;
  public int level;
  public int myLevel;
  public String name;
  public long seq;
  public long ts;
  
  public MessageForMedalNews()
  {
    this.msgtype = -2062;
    this.mNeedTimeStamp = false;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.name = localJSONObject.optString("name");
      this.desc = localJSONObject.optString("desc");
      this.level = localJSONObject.optInt("level");
      this.icon = localJSONObject.optString("icon");
      this.ts = localJSONObject.optLong("ts");
      this.seq = localJSONObject.optLong("seq");
      this.myLevel = localJSONObject.optInt("myLevel");
      this.id = localJSONObject.optInt("id");
      if (QLog.isDevelopLevel()) {
        QLog.i("MessageForMedalNews", 4, "doParse:" + this.msg);
      }
      this.isread = true;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MessageForMedalNews", 2, "doParse", localJSONException);
        }
      }
    }
  }
  
  public boolean msgEquals(MessageForMedalNews paramMessageForMedalNews)
  {
    return paramMessageForMedalNews.uniseq == this.uniseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMedalNews
 * JD-Core Version:    0.7.0.1
 */