package com.tencent.mobileqq.gamecenter.message;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TinyInfo
  implements Serializable
{
  public static final String EXT_KEY_GAME_MSG_INFO = "ext_key_game_msg_info";
  public static final String KEY_FROM_FOLE_ID = "key_from_role_id";
  public static final String KEY_FROM_OPEN_ID = "key_from_open_id";
  public static final String KEY_FROM_TINY_ID = "key_from_tiny_id";
  public static final String KEY_GAME_APP_ID = "key_game_app_id";
  public static final String KEY_REDPOINT_INFO = "key_redpoint_info";
  public static final String KEY_TO_FOLE_ID = "key_to_role_id";
  public static final String KEY_TO_OPEN_ID = "key_to_open_id";
  public static final String KEY_TO_TINY_ID = "key_to_tiny_id";
  public String fromOpenId;
  public String fromRoleId;
  public long fromTinyId;
  public long gameAppId;
  public String nickName;
  public int redpointSwitch;
  public String toOpenId;
  public String toRoleId;
  public long toTinyId;
  public long windowFlag;
  
  public TinyInfo() {}
  
  public TinyInfo(String paramString)
  {
    parseFromJson(paramString);
  }
  
  public TinyInfo(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString5)
  {
    this.fromOpenId = paramString2;
    this.fromRoleId = paramString1;
    this.toOpenId = paramString4;
    this.toRoleId = paramString3;
    this.gameAppId = paramLong1;
    this.fromTinyId = paramLong2;
    this.toTinyId = paramLong3;
    this.windowFlag = paramInt;
    this.nickName = paramString5;
  }
  
  public TinyInfo(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (paramBoolean) {
        paramString = localJSONObject.optString("key_to_role_id");
      } else {
        paramString = localJSONObject.optString("key_from_role_id");
      }
      this.fromRoleId = paramString;
      if (paramBoolean) {
        paramString = localJSONObject.optString("key_to_open_id");
      } else {
        paramString = localJSONObject.optString("key_from_open_id");
      }
      this.fromOpenId = paramString;
      if (paramBoolean) {
        paramString = localJSONObject.optString("key_from_role_id");
      } else {
        paramString = localJSONObject.optString("key_to_role_id");
      }
      this.toRoleId = paramString;
      if (paramBoolean) {
        paramString = localJSONObject.optString("key_from_open_id");
      } else {
        paramString = localJSONObject.optString("key_to_open_id");
      }
      this.toOpenId = paramString;
      this.gameAppId = localJSONObject.optLong("key_game_app_id");
      long l;
      if (paramBoolean) {
        l = localJSONObject.optLong("key_to_tiny_id");
      } else {
        l = localJSONObject.optLong("key_from_tiny_id");
      }
      this.fromTinyId = l;
      if (paramBoolean) {
        l = localJSONObject.optLong("key_from_tiny_id");
      } else {
        l = localJSONObject.optLong("key_to_tiny_id");
      }
      this.toTinyId = l;
      this.windowFlag = localJSONObject.optInt("key_window_flag");
      this.nickName = localJSONObject.optString("key_nick_name");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("parseFromJson 2 info: ");
        paramString.append(toString());
        QLog.d("Q.tiny_msg.TinyInfo", 2, paramString.toString());
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String toJsonStr(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString5, int paramInt2)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      localJSONObject.put("key_from_role_id", paramString1);
      str1 = str2;
      localJSONObject.put("key_from_open_id", paramString2);
      str1 = str2;
      localJSONObject.put("key_to_role_id", paramString3);
      str1 = str2;
      localJSONObject.put("key_to_open_id", paramString4);
      str1 = str2;
      localJSONObject.put("key_game_app_id", paramLong1);
      str1 = str2;
      localJSONObject.put("key_from_tiny_id", paramLong2);
      str1 = str2;
      localJSONObject.put("key_to_tiny_id", paramLong3);
      str1 = str2;
      localJSONObject.put("key_window_flag", paramInt1);
      str1 = str2;
      localJSONObject.put("key_nick_name", paramString5);
      str1 = str2;
      localJSONObject.put("key_redpoint_info", paramInt2);
      str1 = str2;
      paramString1 = localJSONObject.toString();
      str1 = paramString1;
      paramString2 = paramString1;
      if (QLog.isColorLevel())
      {
        str1 = paramString1;
        paramString2 = new StringBuilder();
        str1 = paramString1;
        paramString2.append("toJsonStr json: ");
        str1 = paramString1;
        paramString2.append(paramString1);
        str1 = paramString1;
        QLog.d("Q.tiny_msg.TinyInfo", 2, paramString2.toString());
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString2 = str1;
    }
    return paramString2;
  }
  
  public void parseFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.fromRoleId = paramString.optString("key_from_role_id");
      this.fromOpenId = paramString.optString("key_from_open_id");
      this.toRoleId = paramString.optString("key_to_role_id");
      this.toOpenId = paramString.optString("key_to_open_id");
      this.gameAppId = paramString.optInt("key_game_app_id");
      this.fromTinyId = paramString.optLong("key_from_tiny_id");
      this.toTinyId = paramString.optLong("key_to_tiny_id");
      this.windowFlag = paramString.optInt("key_window_flag");
      this.nickName = paramString.optString("key_nick_name");
      this.redpointSwitch = paramString.optInt("key_redpoint_info");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("parseFromJson info: ");
        paramString.append(toString());
        QLog.d("Q.tiny_msg.TinyInfo", 2, paramString.toString());
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void parseFromMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("Q.tiny_msg.TinyInfo", 1, "[parseFromMessageRecord], gameMsg is null.");
      return;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
    if (!TextUtils.isEmpty(paramMessageRecord)) {
      parseFromJson(paramMessageRecord);
    }
  }
  
  public String toJsonStr()
  {
    String str2 = "";
    String str1 = str2;
    Object localObject;
    try
    {
      localObject = new JSONObject();
      str1 = str2;
      ((JSONObject)localObject).put("key_from_role_id", this.fromRoleId);
      str1 = str2;
      ((JSONObject)localObject).put("key_from_open_id", this.fromOpenId);
      str1 = str2;
      ((JSONObject)localObject).put("key_to_role_id", this.toRoleId);
      str1 = str2;
      ((JSONObject)localObject).put("key_to_open_id", this.toOpenId);
      str1 = str2;
      ((JSONObject)localObject).put("key_game_app_id", this.gameAppId);
      str1 = str2;
      ((JSONObject)localObject).put("key_from_tiny_id", this.fromTinyId);
      str1 = str2;
      ((JSONObject)localObject).put("key_to_tiny_id", this.toTinyId);
      str1 = str2;
      ((JSONObject)localObject).put("key_window_flag", this.windowFlag);
      str1 = str2;
      ((JSONObject)localObject).put("key_nick_name", this.nickName);
      str1 = str2;
      ((JSONObject)localObject).put("key_redpoint_info", this.redpointSwitch);
      str1 = str2;
      str2 = ((JSONObject)localObject).toString();
      str1 = str2;
      localObject = str2;
      if (QLog.isColorLevel())
      {
        str1 = str2;
        localObject = new StringBuilder();
        str1 = str2;
        ((StringBuilder)localObject).append("toJsonStr 2 json: ");
        str1 = str2;
        ((StringBuilder)localObject).append(str2);
        str1 = str2;
        QLog.d("Q.tiny_msg.TinyInfo", 2, ((StringBuilder)localObject).toString());
        return str2;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = str1;
    }
    return localObject;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("fromRoleId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.fromRoleId);
    localStringBuilder.append(" ");
    localStringBuilder.append("fromOpenId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.fromOpenId);
    localStringBuilder.append(" ");
    localStringBuilder.append("toRoleId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.toRoleId);
    localStringBuilder.append(" ");
    localStringBuilder.append("toOpenId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.toOpenId);
    localStringBuilder.append(" ");
    localStringBuilder.append("gameAppId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.gameAppId);
    localStringBuilder.append(" ");
    localStringBuilder.append("fromTinyId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.fromTinyId);
    localStringBuilder.append(" ");
    localStringBuilder.append("toTinyId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.toTinyId);
    localStringBuilder.append(" ");
    localStringBuilder.append("nickName");
    localStringBuilder.append("=");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append(" ");
    localStringBuilder.append("windowFlag");
    localStringBuilder.append("=");
    localStringBuilder.append(this.windowFlag);
    localStringBuilder.append(" ");
    localStringBuilder.append("redpointR");
    localStringBuilder.append("=");
    localStringBuilder.append(this.redpointSwitch);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.TinyInfo
 * JD-Core Version:    0.7.0.1
 */