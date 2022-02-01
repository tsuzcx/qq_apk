package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatingStranger
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  
  public DatingStranger()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static DatingStranger a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    if ((paramStrangerInfo != null) && (paramStrangerInfo.uint64_tinyid.get() != 0L))
    {
      DatingStranger localDatingStranger = new DatingStranger();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localDatingStranger.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localDatingStranger.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localDatingStranger.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localDatingStranger.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localDatingStranger.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localDatingStranger.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localDatingStranger.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localDatingStranger.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localDatingStranger.e = paramStrangerInfo.uint32_marriage.get();
      }
      if (paramStrangerInfo.str_vipinfo.has()) {
        localDatingStranger.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
      }
      return localDatingStranger;
    }
    return null;
  }
  
  public static DatingStranger a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    DatingStranger localDatingStranger = new DatingStranger();
    try
    {
      localDatingStranger.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
      localDatingStranger.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
      localDatingStranger.jdField_a_of_type_Int = paramJSONObject.getInt("age");
      localDatingStranger.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
      localDatingStranger.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      try
      {
        localDatingStranger.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localDatingStranger.d = paramJSONObject.getInt("profession");
        localDatingStranger.e = paramJSONObject.getInt("emotion");
        localDatingStranger.f = paramJSONObject.getInt("listIdx");
        localDatingStranger.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return localDatingStranger;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static String a(List<DatingStranger> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      paramList = paramList.iterator();
      int j;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        JSONObject localJSONObject = a((DatingStranger)paramList.next());
        j = i;
        if (localJSONObject != null)
        {
          localJSONArray.put(localJSONObject);
          j = i + 1;
        }
        i = j;
      } while (j < 20);
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static JSONObject a(DatingStranger paramDatingStranger)
  {
    if (paramDatingStranger == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramDatingStranger.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramDatingStranger.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramDatingStranger.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramDatingStranger.jdField_b_of_type_Int);
      localJSONObject.put("state", paramDatingStranger.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramDatingStranger.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramDatingStranger.d);
      localJSONObject.put("emotion", paramDatingStranger.e);
      localJSONObject.put("listIdx", paramDatingStranger.f);
      localJSONObject.put("vip", paramDatingStranger.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramDatingStranger)
    {
      paramDatingStranger.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<DatingStranger> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          DatingStranger localDatingStranger = a(paramString.getJSONObject(i));
          if (localDatingStranger != null) {
            paramList.add(localDatingStranger);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    if (((DatingStranger)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingStranger
 * JD-Core Version:    0.7.0.1
 */