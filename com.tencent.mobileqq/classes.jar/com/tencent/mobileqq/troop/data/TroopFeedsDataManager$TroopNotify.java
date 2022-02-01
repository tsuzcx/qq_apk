package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopFeedsDataManager$TroopNotify
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e = null;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i = null;
  public String j = null;
  
  public TroopFeedsDataManager$TroopNotify()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static TroopNotify a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.has("msg")) {
        return null;
      }
      TroopNotify localTroopNotify = new TroopNotify();
      localTroopNotify.jdField_a_of_type_JavaLangString = paramJSONObject.optString("fid");
      boolean bool1 = paramJSONObject.has("is_read");
      boolean bool2 = true;
      if (bool1)
      {
        if (paramJSONObject.optInt("is_read") != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localTroopNotify.jdField_d_of_type_Boolean = bool1;
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject("msg");
      if (localJSONObject == null) {
        return null;
      }
      localTroopNotify.jdField_c_of_type_JavaLangString = localJSONObject.optString("text_face");
      Object localObject = localTroopNotify.jdField_c_of_type_JavaLangString;
      if (localObject != null) {
        localTroopNotify.jdField_c_of_type_JavaLangString = ((String)localObject).replace("&#10;", "<br/>");
      }
      localTroopNotify.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
      localObject = localTroopNotify.jdField_b_of_type_JavaLangString;
      if (localObject != null) {
        localTroopNotify.jdField_b_of_type_JavaLangString = ((String)localObject).replace("&#10;", "<br/>");
      }
      if (localTroopNotify.jdField_b_of_type_JavaLangString != null)
      {
        if (localTroopNotify.jdField_c_of_type_JavaLangString == null) {
          return null;
        }
        localTroopNotify.j = paramJSONObject.optString("fid");
        localObject = localJSONObject.optJSONArray("pics");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          localObject = ((JSONArray)localObject).optJSONObject(0);
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("https://gdynamic.qpic.cn/gdynamic/");
            localStringBuilder.append(((JSONObject)localObject).optString("id"));
            localStringBuilder.append("/628");
            localTroopNotify.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("https://gdynamic.qpic.cn/gdynamic/");
            localStringBuilder.append(((JSONObject)localObject).optString("id"));
            localStringBuilder.append("/");
            localTroopNotify.e = localStringBuilder.toString();
          }
        }
        localObject = paramJSONObject.optJSONObject("settings");
        if (localObject != null)
        {
          if (((JSONObject)localObject).optInt("is_show_edit_card", 0) == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localTroopNotify.jdField_a_of_type_Boolean = bool1;
          if (((JSONObject)localObject).optInt("tip_window_type", 0) == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localTroopNotify.jdField_b_of_type_Boolean = bool1;
          if (((JSONObject)localObject).optInt("confirm_required", 0) == 1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          localTroopNotify.jdField_c_of_type_Boolean = bool1;
        }
        if (localJSONObject.has("v"))
        {
          localJSONObject = localJSONObject.optJSONObject("v");
          localTroopNotify.f = localJSONObject.optString("l");
          localTroopNotify.jdField_d_of_type_JavaLangString = localJSONObject.optString("bi");
        }
        localTroopNotify.g = paramJSONObject.optString("u");
        localTroopNotify.h = ContactUtils.b(paramQQAppInterface, paramString, localTroopNotify.g);
        localTroopNotify.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
        localTroopNotify.jdField_b_of_type_Int = paramJSONObject.optInt("read_num");
        return localTroopNotify;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify
 * JD-Core Version:    0.7.0.1
 */