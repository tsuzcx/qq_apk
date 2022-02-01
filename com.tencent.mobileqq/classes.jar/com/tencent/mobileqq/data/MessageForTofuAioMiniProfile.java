package com.tencent.mobileqq.data;

import azxd;
import azxe;
import azxf;
import azxg;
import azxh;
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
  public azxd miniCard;
  
  public MessageForTofuAioMiniProfile()
  {
    this.msgtype = -7012;
    this.mNeedTimeStamp = false;
  }
  
  private azxe getBaseProfile(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_baseprofile")) {
      return null;
    }
    azxe localazxe = new azxe();
    localazxe.jdField_a_of_type_Int = paramJSONObject.optInt("age", -1);
    localazxe.jdField_b_of_type_Int = paramJSONObject.optInt("gender", -1);
    localazxe.jdField_a_of_type_JavaLangString = paramJSONObject.optString("place", "");
    localazxe.jdField_b_of_type_JavaLangString = paramJSONObject.optString("addfrd_src", "");
    localazxe.c = paramJSONObject.optInt("commfrd_num", -1);
    return localazxe;
  }
  
  private List<azxf> getNicePics(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; (paramJSONObject == null) || (paramJSONObject.length() == 0); paramJSONObject = paramJSONObject.optJSONArray("field_nicepics")) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      azxf localazxf = new azxf();
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localazxf.jdField_a_of_type_JavaLangString = localJSONObject.optString("ori", "");
      localazxf.jdField_b_of_type_JavaLangString = localJSONObject.optString("medium", "");
      localArrayList.add(localazxf);
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
  
  private azxg getQZoneInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("field_qzone")) {
      return null;
    }
    azxg localazxg = new azxg();
    localazxg.jdField_a_of_type_JavaLangString = paramJSONObject.optString("space_name", "");
    localazxg.jdField_b_of_type_JavaLangString = paramJSONObject.optString("update_content", "");
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
      localazxg.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    return localazxg;
  }
  
  private azxh getSign(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = null; paramJSONObject == null; paramJSONObject = paramJSONObject.optJSONObject("sign")) {
      return null;
    }
    azxh localazxh = new azxh();
    localazxh.jdField_a_of_type_Int = paramJSONObject.optInt("actionId", 0);
    localazxh.jdField_a_of_type_JavaLangString = paramJSONObject.optString("actionAndData", "");
    localazxh.jdField_b_of_type_JavaLangString = paramJSONObject.optString("plainText", "");
    return localazxh;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.miniCard = new azxd();
      this.miniCard.jdField_a_of_type_Azxe = getBaseProfile(localJSONObject);
      this.miniCard.jdField_a_of_type_JavaUtilList.addAll(getPersonalLabels(localJSONObject));
      this.miniCard.jdField_a_of_type_Azxg = getQZoneInfo(localJSONObject);
      this.miniCard.b.addAll(getNicePics(localJSONObject));
      this.miniCard.jdField_a_of_type_Azxh = getSign(localJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuAioMiniProfile
 * JD-Core Version:    0.7.0.1
 */