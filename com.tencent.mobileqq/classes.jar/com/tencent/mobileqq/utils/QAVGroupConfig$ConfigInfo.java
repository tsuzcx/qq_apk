package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QAVGroupConfig$ConfigInfo
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  int b = 20;
  int c = 20;
  int d = 20;
  
  static ConfigInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        ConfigInfo localConfigInfo = new ConfigInfo();
        localConfigInfo.jdField_a_of_type_Int = paramString.optInt("pretask_id");
        if (paramString.has("direct_call_num")) {
          localConfigInfo.b = paramString.optInt("direct_call_num");
        }
        if (paramString.has("max_select_num")) {
          localConfigInfo.c = paramString.optInt("max_select_num");
        }
        if (paramString.has("show_invite_box")) {
          localConfigInfo.d = paramString.optInt("show_invite_box");
        }
        return localConfigInfo;
      }
      catch (Exception paramString)
      {
        QLog.d("QAVGroupConfig", 1, "parseJson, Exception", paramString);
      }
    }
    return null;
  }
  
  public String toString()
  {
    return "pretask_id[" + this.jdField_a_of_type_Int + "], show_call[" + this.jdField_a_of_type_Boolean + "], direct_call_num[" + this.b + "], max_select_num[" + this.c + "], show_invite_box[" + this.d + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */