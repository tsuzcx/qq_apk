package com.tencent.mobileqq.data;

import bajp;
import bajq;
import bajr;
import bajs;
import bajt;
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
  public bajp miniCard;
  
  public MessageForTofuAioMiniProfile()
  {
    this.msgtype = -7012;
    this.mNeedTimeStamp = false;
  }
  
  private bajq getBaseProfile(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_baseprofile")) {
      return null;
    }
    bajq localbajq = new bajq();
    localbajq.jdField_a_of_type_Int = paramJSONObject.optInt("age", -1);
    localbajq.jdField_b_of_type_Int = paramJSONObject.optInt("gender", -1);
    localbajq.jdField_a_of_type_JavaLangString = paramJSONObject.optString("place", "");
    localbajq.jdField_b_of_type_JavaLangString = paramJSONObject.optString("addfrd_src", "");
    localbajq.c = paramJSONObject.optInt("commfrd_num", -1);
    return localbajq;
  }
  
  private List<bajr> getNicePics(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; (paramJSONObject == null) || (paramJSONObject.length() == 0); paramJSONObject = paramJSONObject.optJSONArray("field_nicepics")) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      bajr localbajr = new bajr();
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localbajr.jdField_a_of_type_JavaLangString = localJSONObject.optString("ori", "");
      localbajr.jdField_b_of_type_JavaLangString = localJSONObject.optString("medium", "");
      localArrayList.add(localbajr);
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
  
  private bajs getQZoneInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_qzone")) {
      return null;
    }
    bajs localbajs = new bajs();
    localbajs.jdField_a_of_type_JavaLangString = paramJSONObject.optString("space_name", "");
    localbajs.jdField_b_of_type_JavaLangString = paramJSONObject.optString("update_content", "");
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
      localbajs.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    return localbajs;
  }
  
  private bajt getSign(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("sign")) {
      return null;
    }
    bajt localbajt = new bajt();
    localbajt.jdField_a_of_type_Int = paramJSONObject.optInt("actionId", 0);
    localbajt.jdField_a_of_type_JavaLangString = paramJSONObject.optString("actionAndData", "");
    localbajt.jdField_b_of_type_JavaLangString = paramJSONObject.optString("plainText", "");
    return localbajt;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.miniCard = new bajp();
      this.miniCard.jdField_a_of_type_Bajq = getBaseProfile(localJSONObject);
      this.miniCard.jdField_a_of_type_JavaUtilList.addAll(getPersonalLabels(localJSONObject));
      this.miniCard.jdField_a_of_type_Bajs = getQZoneInfo(localJSONObject);
      this.miniCard.b.addAll(getNicePics(localJSONObject));
      this.miniCard.jdField_a_of_type_Bajt = getSign(localJSONObject);
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