package com.tencent.mobileqq.data;

import azzl;
import bbdm;
import bbdn;
import bbdo;
import bbdp;
import bbdq;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageForTofuAioMiniProfile
  extends ChatMessage
{
  public static final String TAG = "MessageForTofuAioMiniProfile";
  public bbdm miniCard;
  
  public MessageForTofuAioMiniProfile()
  {
    this.msgtype = -7012;
    this.mNeedTimeStamp = false;
  }
  
  private azzl getAskAnonymously(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("key_ask_anonymously")) {
      return null;
    }
    azzl localazzl = new azzl();
    localazzl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("key_question_id", "");
    localazzl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("key_question_str", "");
    localazzl.jdField_b_of_type_Long = paramJSONObject.optLong("key_question_time", 0L);
    localazzl.jdField_a_of_type_Long = paramJSONObject.optLong("key_question_uin", 0L);
    localazzl.c = paramJSONObject.optString("key_answer_str", "");
    return localazzl;
  }
  
  private bbdn getBaseProfile(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_baseprofile")) {
      return null;
    }
    bbdn localbbdn = new bbdn();
    localbbdn.jdField_a_of_type_Int = paramJSONObject.optInt("age", -1);
    localbbdn.jdField_b_of_type_Int = paramJSONObject.optInt("gender", -1);
    localbbdn.jdField_a_of_type_JavaLangString = paramJSONObject.optString("place", "");
    localbbdn.jdField_b_of_type_JavaLangString = paramJSONObject.optString("addfrd_src", "");
    localbbdn.c = paramJSONObject.optInt("commfrd_num", -1);
    return localbbdn;
  }
  
  private List<bbdo> getNicePics(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; (paramJSONObject == null) || (paramJSONObject.length() == 0); paramJSONObject = paramJSONObject.optJSONArray("field_nicepics")) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      bbdo localbbdo = new bbdo();
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localbbdo.jdField_a_of_type_JavaLangString = localJSONObject.optString("ori", "");
      localbbdo.jdField_b_of_type_JavaLangString = localJSONObject.optString("medium", "");
      localArrayList.add(localbbdo);
      i += 1;
    }
    return localArrayList;
  }
  
  private List<String> getPersonalLabels(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; (paramJSONObject == null) || (paramJSONObject.length() == 0); paramJSONObject = paramJSONObject.optJSONArray("field_personal_labels")) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localArrayList.add(paramJSONObject.optString(i, ""));
      i += 1;
    }
    return localArrayList;
  }
  
  private bbdp getQZoneInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_qzone")) {
      return null;
    }
    bbdp localbbdp = new bbdp();
    localbbdp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("space_name", "");
    localbbdp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("update_content", "");
    paramJSONObject = paramJSONObject.optJSONArray("img_urls");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      localbbdp.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    return localbbdp;
  }
  
  private bbdq getSign(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("sign")) {
      return null;
    }
    bbdq localbbdq = new bbdq();
    localbbdq.jdField_a_of_type_Int = paramJSONObject.optInt("actionId", 0);
    localbbdq.jdField_a_of_type_JavaLangString = paramJSONObject.optString("actionAndData", "");
    localbbdq.jdField_b_of_type_JavaLangString = paramJSONObject.optString("plainText", "");
    return localbbdq;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.miniCard = new bbdm();
      this.miniCard.jdField_a_of_type_Bbdn = getBaseProfile(localJSONObject);
      this.miniCard.jdField_a_of_type_JavaUtilList.addAll(getPersonalLabels(localJSONObject));
      this.miniCard.jdField_a_of_type_Bbdp = getQZoneInfo(localJSONObject);
      this.miniCard.b.addAll(getNicePics(localJSONObject));
      this.miniCard.jdField_a_of_type_Bbdq = getSign(localJSONObject);
      this.miniCard.jdField_a_of_type_Azzl = getAskAnonymously(localJSONObject);
      if (QLog.isDevelopLevel()) {
        QLog.i("MessageForTofuAioMiniProfile", 4, String.format("doParse %s", new Object[] { this.miniCard }));
      }
      this.isread = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MessageForTofuAioMiniProfile", 1, "doParse", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuAioMiniProfile
 * JD-Core Version:    0.7.0.1
 */