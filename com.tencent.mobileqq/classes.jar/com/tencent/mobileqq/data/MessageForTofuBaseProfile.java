package com.tencent.mobileqq.data;

import android.content.res.Resources;
import bhhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForTofuBaseProfile
  extends ChatMessage
{
  public String[] lines = new String[3];
  public int linesCnt;
  
  public MessageForTofuBaseProfile()
  {
    this.msgtype = -7010;
    this.mNeedTimeStamp = false;
  }
  
  private String line(int paramInt, String paramString)
  {
    return "· " + BaseApplicationImpl.getApplication().getResources().getString(paramInt) + "：" + paramString;
  }
  
  @NotNull
  private String parseLine(JSONObject paramJSONObject)
  {
    int i;
    switch (paramJSONObject.optInt("key_type", 0))
    {
    default: 
      return "";
    case 20002: 
      return line(2131694523, paramJSONObject.optString("key_profile_nickname", ""));
    case 20031: 
      i = paramJSONObject.optInt("key_profile_birthday", 0);
      return line(2131694466, String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & i) >>> 16), Integer.valueOf((0xFF00 & i) >>> 8), Integer.valueOf(i & 0xFF) }));
    case 27264: 
      return line(2131694468, paramJSONObject.optString("key_profile_education", ""));
    case 20032: 
      return line(2131694519, paramJSONObject.optString("key_profile_location_desc", ""));
    case 24002: 
      return line(2131694513, paramJSONObject.optString("key_profile_location_desc", ""));
    case 24008: 
      return line(2131694477, paramJSONObject.optString("key_profile_company", ""));
    case 27037: 
      i = paramJSONObject.optInt("key_profile_occupation", -1);
      String str = "";
      paramJSONObject = str;
      if (i < bhhu.e.length - 1) {
        if (i > 0) {
          break label267;
        }
      }
      for (paramJSONObject = str;; paramJSONObject = bhhu.e[i]) {
        return line(2131694567, paramJSONObject);
      }
    case 20011: 
      label267:
      return line(2131694507, paramJSONObject.optString("key_profile_email", ""));
    }
    return line(2131694537, paramJSONObject.optString("key_profile_introduction", ""));
  }
  
  protected void doParse()
  {
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray(this.msg);
        i = 0;
        if (i < localJSONArray.length())
        {
          if (this.linesCnt < 3) {
            continue;
          }
          this.linesCnt += 1;
        }
      }
      catch (JSONException localJSONException)
      {
        JSONArray localJSONArray;
        int i;
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MessageForTofuBaseProfile", 2, "doParse JSONException", localJSONException);
        continue;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MessageForTofuBaseProfile", 2, "doParse Exception", localException);
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MessageForTofuBaseProfile", 4, "lineCnt=" + this.linesCnt + " doParse:" + this.msg);
      }
      this.isread = true;
      return;
      str = parseLine(localJSONArray.optJSONObject(i));
      this.lines[this.linesCnt] = str;
      this.linesCnt += 1;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuBaseProfile
 * JD-Core Version:    0.7.0.1
 */