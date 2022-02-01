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
    Object localObject = new TypeItem();
    try
    {
      ((TypeItem)localObject).jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
      ((TypeItem)localObject).jdField_a_of_type_Long = MutualMarkUtils.b(((TypeItem)localObject).jdField_a_of_type_JavaLangString);
      ((TypeItem)localObject).jdField_b_of_type_Long = MutualMarkUtils.a(((TypeItem)localObject).jdField_a_of_type_JavaLangString);
      ((TypeItem)localObject).jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
      ((TypeItem)localObject).c = paramJSONObject.optString("Android_iconPath");
      ((TypeItem)localObject).jdField_a_of_type_Boolean = true;
      if (paramJSONObject.has("subLevelInfo"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("subLevelInfo");
        ((TypeItem)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          MutualMarkConfigIRType.SubLevelInfo localSubLevelInfo = MutualMarkConfigIRType.SubLevelInfo.a(paramJSONObject.getJSONObject(i));
          if (localSubLevelInfo != null) {
            ((TypeItem)localObject).jdField_a_of_type_JavaUtilArrayList.add(localSubLevelInfo);
          }
          i += 1;
        }
      }
      return localObject;
    }
    catch (Exception paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse error->");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.e("MutualMarkConfigIRType", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("type=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("|");
    localStringBuilder.append("level=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("|");
    localStringBuilder.append("name=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("iconPath=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("enable=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("|");
    localStringBuilder.append("subLevelInfoArrayList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType.TypeItem
 * JD-Core Version:    0.7.0.1
 */