package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForTofuNicePics
  extends ChatMessage
{
  public int countInc;
  public long frdUin;
  public long upTime;
  public String url1;
  public String url2;
  
  public MessageForTofuNicePics()
  {
    this.msgtype = -7011;
    this.mNeedTimeStamp = false;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.upTime = localJSONObject.optInt("key_nice_pics_ts");
      this.countInc = localJSONObject.optInt("key_nice_pics_count", 0);
      this.url1 = localJSONObject.optString("key_nice_pics_url_1", "");
      this.url2 = localJSONObject.optString("key_nice_pics_url_2", "");
      this.frdUin = localJSONObject.optLong("key_frd_uin", 0L);
    }
    catch (Exception localException)
    {
      QLog.d("MessageForTofuInimateAnniversary", 1, "doParse", localException);
    }
    catch (JSONException localJSONException)
    {
      QLog.d("MessageForTofuInimateAnniversary", 1, "doParse", localJSONException);
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doParse:");
      localStringBuilder.append(this.msg);
      QLog.i("MessageForTofuInimateAnniversary", 4, localStringBuilder.toString());
    }
    this.isread = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuNicePics
 * JD-Core Version:    0.7.0.1
 */