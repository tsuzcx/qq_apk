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
    boolean bool2 = true;
    if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {
      return null;
    }
    TroopNotify localTroopNotify = new TroopNotify();
    localTroopNotify.jdField_a_of_type_JavaLangString = paramJSONObject.optString("fid");
    if (paramJSONObject.has("is_read")) {
      if (paramJSONObject.optInt("is_read") == 0) {
        break label79;
      }
    }
    JSONObject localJSONObject;
    label79:
    for (boolean bool1 = true;; bool1 = false)
    {
      localTroopNotify.jdField_d_of_type_Boolean = bool1;
      localJSONObject = paramJSONObject.optJSONObject("msg");
      if (localJSONObject != null) {
        break;
      }
      return null;
    }
    localTroopNotify.jdField_c_of_type_JavaLangString = localJSONObject.optString("text_face");
    if (localTroopNotify.jdField_c_of_type_JavaLangString != null) {
      localTroopNotify.jdField_c_of_type_JavaLangString = localTroopNotify.jdField_c_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    localTroopNotify.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
    if (localTroopNotify.jdField_b_of_type_JavaLangString != null) {
      localTroopNotify.jdField_b_of_type_JavaLangString = localTroopNotify.jdField_b_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    if ((localTroopNotify.jdField_b_of_type_JavaLangString == null) || (localTroopNotify.jdField_c_of_type_JavaLangString == null)) {
      return null;
    }
    localTroopNotify.j = paramJSONObject.optString("fid");
    Object localObject = localJSONObject.optJSONArray("pics");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject != null)
      {
        localTroopNotify.jdField_d_of_type_JavaLangString = ("https://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
        localTroopNotify.e = ("https://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
      }
    }
    localObject = paramJSONObject.optJSONObject("settings");
    if (localObject != null)
    {
      if (((JSONObject)localObject).optInt("is_show_edit_card", 0) != 1) {
        break label459;
      }
      bool1 = true;
      localTroopNotify.jdField_a_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("tip_window_type", 0) != 0) {
        break label464;
      }
      bool1 = true;
      label338:
      localTroopNotify.jdField_b_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("confirm_required", 0) != 1) {
        break label469;
      }
    }
    label459:
    label464:
    label469:
    for (bool1 = bool2;; bool1 = false)
    {
      localTroopNotify.jdField_c_of_type_Boolean = bool1;
      if (localJSONObject.has("v"))
      {
        localJSONObject = localJSONObject.optJSONObject("v");
        localTroopNotify.f = localJSONObject.optString("l");
        localTroopNotify.jdField_d_of_type_JavaLangString = localJSONObject.optString("bi");
      }
      localTroopNotify.g = paramJSONObject.optString("u");
      localTroopNotify.h = ContactUtils.g(paramQQAppInterface, paramString, localTroopNotify.g);
      localTroopNotify.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
      localTroopNotify.jdField_b_of_type_Int = paramJSONObject.optInt("read_num");
      return localTroopNotify;
      bool1 = false;
      break;
      bool1 = false;
      break label338;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify
 * JD-Core Version:    0.7.0.1
 */