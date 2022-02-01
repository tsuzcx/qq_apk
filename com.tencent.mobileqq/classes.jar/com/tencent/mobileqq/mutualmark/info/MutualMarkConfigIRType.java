package com.tencent.mobileqq.mutualmark.info;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MutualMarkConfigIRType
{
  public int a;
  public long a;
  public String a;
  public ArrayList<MutualMarkConfigIRType.TypeItem> a;
  public boolean a;
  public int b;
  public boolean b;
  
  public MutualMarkConfigIRType()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static MutualMarkConfigIRType a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localMutualMarkConfigIRType = new MutualMarkConfigIRType();
    try
    {
      localMutualMarkConfigIRType.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localMutualMarkConfigIRType.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label135;
        }
      }
      label135:
      for (boolean bool = true;; bool = false)
      {
        localMutualMarkConfigIRType.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localMutualMarkConfigIRType.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          MutualMarkConfigIRType.TypeItem localTypeItem = MutualMarkConfigIRType.TypeItem.a(paramJSONObject.getJSONObject(i));
          if (localTypeItem != null)
          {
            localMutualMarkConfigIRType.jdField_a_of_type_JavaUtilArrayList.add(localTypeItem);
            localTypeItem.jdField_a_of_type_ComTencentMobileqqMutualmarkInfoMutualMarkConfigIRType = localMutualMarkConfigIRType;
          }
          i += 1;
        }
      }
      return localMutualMarkConfigIRType;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("MutualMarkConfigIRType", 1, "parse error->" + paramJSONObject.toString());
      return null;
    }
  }
  
  public long a(long paramLong)
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      l1 = l2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        l1 = -1L;
        if (localIterator.hasNext())
        {
          MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)localIterator.next();
          if ((localTypeItem == null) || (!localTypeItem.jdField_a_of_type_Boolean) || (localTypeItem.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localTypeItem.jdField_b_of_type_Long;
        }
      }
    }
    label97:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public MutualMarkConfigIRType.TypeItem a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)localIterator.next();
        if ((localTypeItem != null) && (localTypeItem.jdField_b_of_type_Long == paramLong)) {
          return localTypeItem;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    MutualMarkConfigIRType.TypeItem localTypeItem = a(paramLong);
    if (localTypeItem != null) {
      return localTypeItem.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)localIterator.next();
        if ((localTypeItem != null) && (localTypeItem.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    MutualMarkConfigIRType.TypeItem localTypeItem = a(paramLong);
    if (localTypeItem != null) {
      return localTypeItem.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType
 * JD-Core Version:    0.7.0.1
 */