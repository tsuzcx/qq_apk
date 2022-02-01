package com.tencent.mobileqq.mutualmark.info;

import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MutualMarkConfigIRType$TypeItem
{
  public long a;
  public MutualMarkConfigIRType a;
  public String a;
  public ArrayList<MutualMarkConfigIRType.SubLevelInfo> a;
  public boolean a;
  public long b;
  public String b;
  public String c;
  
  public MutualMarkConfigIRType$TypeItem()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static TypeItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localTypeItem = new TypeItem();
    try
    {
      localTypeItem.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
      localTypeItem.jdField_a_of_type_Long = MutualMarkUtils.b(localTypeItem.jdField_a_of_type_JavaLangString);
      localTypeItem.jdField_b_of_type_Long = MutualMarkUtils.a(localTypeItem.jdField_a_of_type_JavaLangString);
      localTypeItem.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
      localTypeItem.c = paramJSONObject.optString("Android_iconPath");
      localTypeItem.jdField_a_of_type_Boolean = true;
      if (paramJSONObject.has("subLevelInfo"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("subLevelInfo");
        localTypeItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          MutualMarkConfigIRType.SubLevelInfo localSubLevelInfo = MutualMarkConfigIRType.SubLevelInfo.a(paramJSONObject.getJSONObject(i));
          if (localSubLevelInfo != null) {
            localTypeItem.jdField_a_of_type_JavaUtilArrayList.add(localSubLevelInfo);
          }
          i += 1;
        }
      }
      return localTypeItem;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("MutualMarkConfigIRType", 1, "parse error->" + paramJSONObject.toString());
      return null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("type=").append(this.jdField_a_of_type_Long).append("|");
    localStringBuilder.append("level=").append(this.jdField_b_of_type_Long).append("|");
    localStringBuilder.append("name=").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append("iconPath=").append(this.c).append("|");
    localStringBuilder.append("enable=").append(this.jdField_a_of_type_Boolean).append("|");
    localStringBuilder.append("subLevelInfoArrayList=").append(this.jdField_a_of_type_JavaUtilArrayList).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType.TypeItem
 * JD-Core Version:    0.7.0.1
 */