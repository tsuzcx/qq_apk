package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQSysAndEmojiConfProcessor$AnimEmoCountConfBean
{
  public String a = "";
  public String b = "";
  
  public static AnimEmoCountConfBean a(JSONObject paramJSONObject)
  {
    AnimEmoCountConfBean localAnimEmoCountConfBean = new AnimEmoCountConfBean();
    if (paramJSONObject == null) {
      return localAnimEmoCountConfBean;
    }
    paramJSONObject = paramJSONObject.optJSONObject("anim_emoticon_count");
    if (paramJSONObject == null) {
      return localAnimEmoCountConfBean;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQSysAndEmojiConfProcessor", 2, "parse AnimCountConfBean: ");
    }
    if (paramJSONObject.has("model")) {
      localAnimEmoCountConfBean.a = paramJSONObject.optString("model");
    }
    if (paramJSONObject.has("version")) {
      localAnimEmoCountConfBean.b = paramJSONObject.optString("version");
    }
    return localAnimEmoCountConfBean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{mAnimEmoVersion=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mAnimEmoModel=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.AnimEmoCountConfBean
 * JD-Core Version:    0.7.0.1
 */