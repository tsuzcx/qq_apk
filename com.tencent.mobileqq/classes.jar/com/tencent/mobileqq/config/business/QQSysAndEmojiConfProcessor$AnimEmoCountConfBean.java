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
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return localAnimEmoCountConfBean;
        paramJSONObject = paramJSONObject.optJSONObject("anim_emoticon_count");
      } while (paramJSONObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "parse AnimCountConfBean: ");
      }
      if (paramJSONObject.has("model")) {
        localAnimEmoCountConfBean.a = paramJSONObject.optString("model");
      }
    } while (!paramJSONObject.has("version"));
    localAnimEmoCountConfBean.b = paramJSONObject.optString("version");
    return localAnimEmoCountConfBean;
  }
  
  public String toString()
  {
    return "{mAnimEmoVersion=" + this.b + ", mAnimEmoModel=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.AnimEmoCountConfBean
 * JD-Core Version:    0.7.0.1
 */