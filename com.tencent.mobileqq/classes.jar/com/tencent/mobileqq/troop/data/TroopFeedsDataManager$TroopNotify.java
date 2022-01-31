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
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public TroopFeedsDataManager$TroopNotify()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static TroopNotify a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {
      return null;
    }
    TroopNotify localTroopNotify = new TroopNotify();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("msg");
    localTroopNotify.jdField_b_of_type_JavaLangString = localJSONObject.optString("text_face");
    if (localTroopNotify.jdField_b_of_type_JavaLangString != null) {
      localTroopNotify.jdField_b_of_type_JavaLangString = localTroopNotify.jdField_b_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    localTroopNotify.jdField_a_of_type_JavaLangString = localJSONObject.optString("title");
    if (localTroopNotify.jdField_a_of_type_JavaLangString != null) {
      localTroopNotify.jdField_a_of_type_JavaLangString = localTroopNotify.jdField_a_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    if ((localTroopNotify.jdField_a_of_type_JavaLangString == null) || (localTroopNotify.jdField_b_of_type_JavaLangString == null)) {
      return null;
    }
    Object localObject = localJSONObject.optJSONArray("pics");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject != null)
      {
        localTroopNotify.c = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
        localTroopNotify.d = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
      }
    }
    localObject = paramJSONObject.optJSONObject("settings");
    if (localObject != null) {
      if (((JSONObject)localObject).optInt("is_show_edit_card", 0) != 1) {
        break label356;
      }
    }
    for (;;)
    {
      localTroopNotify.jdField_a_of_type_Boolean = bool;
      if (localJSONObject.has("v"))
      {
        localJSONObject = localJSONObject.optJSONObject("v");
        localTroopNotify.e = localJSONObject.optString("l");
        localTroopNotify.c = localJSONObject.optString("bi");
      }
      localTroopNotify.f = paramJSONObject.optString("u");
      localTroopNotify.g = ContactUtils.g(paramQQAppInterface, paramString, localTroopNotify.f);
      localTroopNotify.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
      localTroopNotify.jdField_b_of_type_Int = paramJSONObject.optInt("read_num");
      return localTroopNotify;
      label356:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify
 * JD-Core Version:    0.7.0.1
 */