package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import org.json.JSONObject;

class ConfessManager$GroupChatExtra
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  
  ConfessManager$GroupChatExtra()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static GroupChatExtra a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GroupChatExtra localGroupChatExtra = new GroupChatExtra();
    try
    {
      paramString = new JSONObject(paramString);
      localGroupChatExtra.jdField_a_of_type_JavaLangString = paramString.optString("strGroupUin");
      localGroupChatExtra.jdField_b_of_type_JavaLangString = paramString.optString("strSendUin");
      localGroupChatExtra.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localGroupChatExtra.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localGroupChatExtra.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localGroupChatExtra.jdField_c_of_type_JavaLangString = paramString.optString("strRecNick");
      localGroupChatExtra.jdField_d_of_type_Int = paramString.optInt("nRecNickType");
      localGroupChatExtra.jdField_d_of_type_JavaLangString = paramString.optString("strRecUin");
      localGroupChatExtra.jdField_e_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localGroupChatExtra.f = paramString.optString("strConfessorDesc");
      localGroupChatExtra.g = paramString.optString("strConfessorNick");
      localGroupChatExtra.jdField_e_of_type_Int = paramString.optInt("flag");
      localGroupChatExtra.jdField_a_of_type_Long = paramString.optInt("confessTime");
      localGroupChatExtra.jdField_a_of_type_Boolean = paramString.optBoolean("isRandomShmsgseq");
      return localGroupChatExtra;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("strGroupUin", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("strSendUin", this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("nTopicId", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("nBGType", this.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("nConfessorSex", this.jdField_c_of_type_Int);
      ((JSONObject)localObject).put("strRecNick", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject).put("nRecNickType", this.jdField_d_of_type_Int);
      ((JSONObject)localObject).put("strRecUin", this.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorUin", this.jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorDesc", this.f);
      ((JSONObject)localObject).put("strConfessorNick", this.g);
      ((JSONObject)localObject).put("flag", this.jdField_e_of_type_Int);
      ((JSONObject)localObject).put("confessTime", this.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("isRandomShmsgseq", this.jdField_a_of_type_Boolean);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.GroupChatExtra
 * JD-Core Version:    0.7.0.1
 */