package com.tencent.mobileqq.data;

import bbci;
import bbcj;
import bbck;
import bbcl;
import bbcm;
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
  public bbci miniCard;
  
  public MessageForTofuAioMiniProfile()
  {
    this.msgtype = -7012;
    this.mNeedTimeStamp = false;
  }
  
  private bbcj getBaseProfile(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_baseprofile")) {
      return null;
    }
    bbcj localbbcj = new bbcj();
    localbbcj.jdField_a_of_type_Int = paramJSONObject.optInt("age", -1);
    localbbcj.jdField_b_of_type_Int = paramJSONObject.optInt("gender", -1);
    localbbcj.jdField_a_of_type_JavaLangString = paramJSONObject.optString("place", "");
    localbbcj.jdField_b_of_type_JavaLangString = paramJSONObject.optString("addfrd_src", "");
    localbbcj.c = paramJSONObject.optInt("commfrd_num", -1);
    return localbbcj;
  }
  
  private List<bbck> getNicePics(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; (paramJSONObject == null) || (paramJSONObject.length() == 0); paramJSONObject = paramJSONObject.optJSONArray("field_nicepics")) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      bbck localbbck = new bbck();
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localbbck.jdField_a_of_type_JavaLangString = localJSONObject.optString("ori", "");
      localbbck.jdField_b_of_type_JavaLangString = localJSONObject.optString("medium", "");
      localArrayList.add(localbbck);
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
  
  private bbcl getQZoneInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_qzone")) {
      return null;
    }
    bbcl localbbcl = new bbcl();
    localbbcl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("space_name", "");
    localbbcl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("update_content", "");
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
      localbbcl.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    return localbbcl;
  }
  
  private bbcm getSign(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("sign")) {
      return null;
    }
    bbcm localbbcm = new bbcm();
    localbbcm.jdField_a_of_type_Int = paramJSONObject.optInt("actionId", 0);
    localbbcm.jdField_a_of_type_JavaLangString = paramJSONObject.optString("actionAndData", "");
    localbbcm.jdField_b_of_type_JavaLangString = paramJSONObject.optString("plainText", "");
    return localbbcm;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.miniCard = new bbci();
      this.miniCard.jdField_a_of_type_Bbcj = getBaseProfile(localJSONObject);
      this.miniCard.jdField_a_of_type_JavaUtilList.addAll(getPersonalLabels(localJSONObject));
      this.miniCard.jdField_a_of_type_Bbcl = getQZoneInfo(localJSONObject);
      this.miniCard.b.addAll(getNicePics(localJSONObject));
      this.miniCard.jdField_a_of_type_Bbcm = getSign(localJSONObject);
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