package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.recite.utils.HWReciteUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HWReciteInfo
  extends UploadEditItemInfo
  implements HomeWorkInfoInterface
{
  public int a;
  public long a;
  public TroopHomeworkHelper.UploadFileTask a;
  public String a;
  public List a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  
  public HWReciteInfo(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = Collections.EMPTY_LIST;
    this.jdField_f_of_type_Int = -1;
    a(paramJSONObject);
  }
  
  public static JSONObject a(HWReciteInfo paramHWReciteInfo)
  {
    JSONObject localJSONObject = new JSONObject().put("type", "recite").put("troop_uin", paramHWReciteInfo.jdField_f_of_type_JavaLangString).put("subtype", 1).put("title", paramHWReciteInfo.jdField_b_of_type_JavaLangString).put("desc", paramHWReciteInfo.c).put("kid", paramHWReciteInfo.jdField_a_of_type_JavaLangString).put("error_count", paramHWReciteInfo.jdField_d_of_type_Int).put("remind_count", paramHWReciteInfo.jdField_e_of_type_Int).put("waste_time", paramHWReciteInfo.jdField_a_of_type_Long).put("grade", paramHWReciteInfo.jdField_f_of_type_Int).put("lyric", paramHWReciteInfo.jdField_g_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramHWReciteInfo.jdField_e_of_type_JavaLangString)) {
      localJSONObject.put("file_url", paramHWReciteInfo.jdField_e_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramHWReciteInfo.jdField_d_of_type_JavaLangString)) {
      localJSONObject.put("file_path", paramHWReciteInfo.jdField_d_of_type_JavaLangString);
    }
    if (paramHWReciteInfo.jdField_a_of_type_JavaUtilList != null) {
      localJSONObject.put("pid_list", new JSONArray(paramHWReciteInfo.jdField_a_of_type_JavaUtilList));
    }
    return localJSONObject;
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3, List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("在线背诵").append(paramString2);
    if ((paramList != null) && (!paramList.isEmpty())) {
      localStringBuilder.append(HWReciteUtils.a(paramList));
    }
    paramString1 = new JSONObject().put("type", "recite").put("troop_uin", paramString1).put("subtype", 2).put("title", paramString2).put("desc", localStringBuilder.toString()).put("kid", paramString3);
    if (paramList != null) {
      paramString1.put("pid_list", new JSONArray(paramList));
    }
    return paramString1;
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    try
    {
      a(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Int = paramJSONObject.optInt("subtype");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("kid");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
    this.c = paramJSONObject.optString("desc");
    this.jdField_d_of_type_Int = paramJSONObject.optInt("error_count");
    this.jdField_e_of_type_Int = paramJSONObject.optInt("remind_count");
    this.jdField_a_of_type_Long = paramJSONObject.optLong("waste_time");
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("file_path");
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("file_url");
    this.jdField_f_of_type_Int = paramJSONObject.optInt("grade", -1);
    this.jdField_f_of_type_JavaLangString = paramJSONObject.optString("troop_uin");
    this.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lyric");
    paramJSONObject = paramJSONObject.optJSONArray("pid_list");
    if (paramJSONObject != null)
    {
      int j = paramJSONObject.length();
      if (j != 0)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramJSONObject.getInt(i)));
          i += 1;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilList = Collections.EMPTY_LIST;
    }
    if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HWReciteInfo", 2, "cancel uploadFileTask");
      }
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.c();
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask = null;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_g_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    this.jdField_g_of_type_Int = 3;
  }
  
  public int b()
  {
    return 4;
  }
  
  public void b(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("file_url", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int d()
  {
    if (this.jdField_g_of_type_Int == 3) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo
 * JD-Core Version:    0.7.0.1
 */