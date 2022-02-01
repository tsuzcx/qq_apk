package com.tencent.mobileqq.troop.shortcutbar;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopShortcutBarUtil$RemindGrayTipItem
{
  public long a;
  public String a;
  public long b;
  public String b;
  
  TroopShortcutBarUtil$RemindGrayTipItem()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.jdField_a_of_type_Long);
      localJSONObject.put("appType", this.jdField_b_of_type_Long);
      Object localObject = this.jdField_a_of_type_JavaLangString;
      String str = "";
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = this.jdField_a_of_type_JavaLangString;
      }
      localJSONObject.put("appName", localObject);
      if (this.jdField_b_of_type_JavaLangString == null) {
        localObject = str;
      } else {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      localJSONObject.put("appJumpUrl", localObject);
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    return localJSONObject.toString();
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Long = paramString.optLong("appId");
      this.jdField_b_of_type_Long = paramString.optLong("appType");
      this.jdField_a_of_type_JavaLangString = paramString.optString("appName");
      this.jdField_b_of_type_JavaLangString = paramString.optString("appJumpUrl");
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("appType:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("appName:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("appJumpUrl:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil.RemindGrayTipItem
 * JD-Core Version:    0.7.0.1
 */