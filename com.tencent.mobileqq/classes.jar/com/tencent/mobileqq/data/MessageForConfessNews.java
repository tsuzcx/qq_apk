package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForConfessNews
  extends ChatMessage
{
  public static final String TAG = "MessageForConfessNews";
  public long confessTime;
  public int nBGType;
  public int nBizType;
  public int nConfessNum;
  public int nConfessorSex;
  public int nGetConfessSex;
  public int nRecNickType;
  public int nTopicId;
  public String strConfessorDesc;
  public String strConfessorNick;
  public String strConfessorUin;
  public String strGroupUin;
  public String strRecNick;
  public String strRecUin;
  
  public MessageForConfessNews()
  {
    this.msgtype = -2065;
    this.mNeedTimeStamp = false;
  }
  
  public void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.nTopicId = localJSONObject.optInt("nTopicId");
      this.nBGType = localJSONObject.optInt("nBGType");
      this.nConfessorSex = localJSONObject.optInt("nConfessorSex");
      this.strRecUin = localJSONObject.optString("strRecUin");
      this.strRecNick = localJSONObject.optString("strRecNick");
      this.strConfessorUin = localJSONObject.optString("strConfessorUin");
      this.strConfessorDesc = localJSONObject.optString("strConfessorDesc");
      this.strConfessorNick = localJSONObject.optString("strConfessorNick");
      this.confessTime = localJSONObject.optLong("confessTime");
      this.strGroupUin = localJSONObject.optString("strGroupUin");
      this.nRecNickType = localJSONObject.optInt("nRecNickType");
      if (localJSONObject.has("nConfessNum")) {
        this.nConfessNum = localJSONObject.optInt("nConfessNum");
      }
      if (localJSONObject.has("nBizType")) {
        this.nBizType = localJSONObject.optInt("nBizType");
      }
      if (localJSONObject.has("nGetConfessSex")) {
        this.nGetConfessSex = localJSONObject.optInt("nGetConfessSex");
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MessageForConfessNews", 2, "doParse", localJSONException);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForConfessNews", 4, String.format(Locale.getDefault(), "doParse: %s", new Object[] { this.msg }));
    }
    if ((this.istroop == 1033) || (this.istroop == 0) || (this.istroop == 1)) {
      this.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForConfessNews
 * JD-Core Version:    0.7.0.1
 */