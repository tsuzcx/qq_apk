package com.tencent.mobileqq.data;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.NearbyProfileUtil;
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
  public int linesCnt = 0;
  
  public MessageForTofuBaseProfile()
  {
    this.msgtype = -7010;
    this.mNeedTimeStamp = false;
  }
  
  private String line(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("· ");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getResources().getString(paramInt));
    localStringBuilder.append("：");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NotNull
  private String parseLine(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("key_type", 0);
    String str = "";
    if (i != 20002)
    {
      if (i != 20011)
      {
        if (i != 20019)
        {
          if (i != 24002)
          {
            if (i != 24008)
            {
              if (i != 27037)
              {
                if (i != 27264)
                {
                  if (i != 20031)
                  {
                    if (i != 20032) {
                      return "";
                    }
                    return line(2131892791, paramJSONObject.optString("key_profile_location_desc", ""));
                  }
                  i = paramJSONObject.optInt("key_profile_birthday", 0);
                  return line(2131892737, String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & i) >>> 16), Integer.valueOf((0xFF00 & i) >>> 8), Integer.valueOf(i & 0xFF) }));
                }
                return line(2131892739, paramJSONObject.optString("key_profile_education", ""));
              }
              i = paramJSONObject.optInt("key_profile_occupation", -1);
              paramJSONObject = str;
              if (i < NearbyProfileUtil.f.length - 1) {
                if (i <= 0) {
                  paramJSONObject = str;
                } else {
                  paramJSONObject = NearbyProfileUtil.f[i];
                }
              }
              return line(2131892842, paramJSONObject);
            }
            return line(2131892748, paramJSONObject.optString("key_profile_company", ""));
          }
          return line(2131892785, paramJSONObject.optString("key_profile_location_desc", ""));
        }
        return line(2131892809, paramJSONObject.optString("key_profile_introduction", ""));
      }
      return line(2131892778, paramJSONObject.optString("key_profile_email", ""));
    }
    return line(2131892795, paramJSONObject.optString("key_profile_nickname", ""));
  }
  
  protected void doParse()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(this.msg);
      int i = 0;
      while (i < localJSONArray.length())
      {
        if (this.linesCnt >= 3)
        {
          this.linesCnt += 1;
          break;
        }
        String str = parseLine(localJSONArray.optJSONObject(i));
        this.lines[this.linesCnt] = str;
        this.linesCnt += 1;
        i += 1;
      }
      if (!QLog.isDevelopLevel()) {
        break label171;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MessageForTofuBaseProfile", 2, "doParse Exception", localException);
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MessageForTofuBaseProfile", 2, "doParse JSONException", localJSONException);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lineCnt=");
    localStringBuilder.append(this.linesCnt);
    localStringBuilder.append(" doParse:");
    localStringBuilder.append(this.msg);
    QLog.i("MessageForTofuBaseProfile", 4, localStringBuilder.toString());
    label171:
    this.isread = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuBaseProfile
 * JD-Core Version:    0.7.0.1
 */