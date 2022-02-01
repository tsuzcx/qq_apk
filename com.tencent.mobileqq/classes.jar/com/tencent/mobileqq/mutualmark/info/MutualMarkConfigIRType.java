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
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = new MutualMarkConfigIRType();
    for (;;)
    {
      try
      {
        ((MutualMarkConfigIRType)localObject).jdField_a_of_type_Long = paramJSONObject.optLong("type");
        ((MutualMarkConfigIRType)localObject).jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
        bool = paramJSONObject.has("disableLocalResource");
        int i = 0;
        if (bool)
        {
          if (paramJSONObject.optInt("disableLocalResource") == 1)
          {
            bool = true;
            ((MutualMarkConfigIRType)localObject).jdField_b_of_type_Boolean = bool;
          }
        }
        else
        {
          if (paramJSONObject.has("typeItem"))
          {
            paramJSONObject = paramJSONObject.optJSONArray("typeItem");
            ((MutualMarkConfigIRType)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            if (i < paramJSONObject.length())
            {
              MutualMarkConfigIRType.TypeItem localTypeItem = MutualMarkConfigIRType.TypeItem.a(paramJSONObject.getJSONObject(i));
              if (localTypeItem != null)
              {
                ((MutualMarkConfigIRType)localObject).jdField_a_of_type_JavaUtilArrayList.add(localTypeItem);
                localTypeItem.jdField_a_of_type_ComTencentMobileqqMutualmarkInfoMutualMarkConfigIRType = ((MutualMarkConfigIRType)localObject);
              }
              i += 1;
              continue;
            }
          }
          return localObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse error->");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.e("MutualMarkConfigIRType", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      boolean bool = false;
    }
  }
  
  public long a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    long l1 = -1L;
    long l2 = l1;
    if (localObject != null)
    {
      l2 = l1;
      if (!((ArrayList)localObject).isEmpty())
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)((Iterator)localObject).next();
          if ((localTypeItem != null) && (localTypeItem.jdField_a_of_type_Boolean) && (localTypeItem.jdField_b_of_type_Long <= paramLong)) {
            l1 = localTypeItem.jdField_b_of_type_Long;
          }
        }
      }
    }
    return l2;
  }
  
  public MutualMarkConfigIRType.TypeItem a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)((Iterator)localObject).next();
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MutualMarkConfigIRType.TypeItem localTypeItem = (MutualMarkConfigIRType.TypeItem)((Iterator)localObject).next();
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkConfigIRType{type=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", cluster='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sortKeyForNormal=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isInAIOTitleLeft2=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", sortKeyForAIOTitle=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", disableLocalResource=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", typeItems=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType
 * JD-Core Version:    0.7.0.1
 */