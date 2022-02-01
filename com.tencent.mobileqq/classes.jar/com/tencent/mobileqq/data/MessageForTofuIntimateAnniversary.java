package com.tencent.mobileqq.data;

import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForTofuIntimateAnniversary
  extends ChatMessage
{
  public String bgUrl;
  public long bindTime;
  public long frdUin;
  public int inimateType;
  public int level;
  public int txtColor;
  public int years;
  
  public MessageForTofuIntimateAnniversary()
  {
    this.msgtype = -7009;
    this.mNeedTimeStamp = false;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.inimateType = localJSONObject.optInt("key_type", -1);
      this.frdUin = localJSONObject.optLong("key_frd_uin", 0L);
      this.bindTime = localJSONObject.optLong("key_bind_time", 0L);
      this.years = localJSONObject.optInt("key_anniversary_years", 0);
      this.level = localJSONObject.optInt("key_inimate_level", 0);
      this.bgUrl = localJSONObject.optString("key_bg_url", "");
      this.txtColor = Color.parseColor(localJSONObject.optString("key_txt_clr", "#000"));
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
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary
 * JD-Core Version:    0.7.0.1
 */