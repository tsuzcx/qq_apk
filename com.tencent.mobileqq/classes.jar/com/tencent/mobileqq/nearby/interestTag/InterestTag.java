package com.tencent.mobileqq.nearby.interestTag;

import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class InterestTag
{
  public final int a;
  public final ArrayList<InterestTagInfo> a;
  
  public InterestTag(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tagType", this.jdField_a_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (InterestTagInfo)localIterator.next();
          if (localObject != null)
          {
            localObject = ((InterestTagInfo)localObject).convertTo();
            if (localObject != null) {
              localJSONArray.put(localObject);
            }
          }
        }
      }
      localJSONObject.put("tagInfos", localJSONArray);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, localException.toString());
      }
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (InterestTag)paramObject;
    if (paramObject.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      return false;
    }
    if (paramObject.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return false;
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (!Utils.a(this.jdField_a_of_type_JavaUtilArrayList.get(i), paramObject.jdField_a_of_type_JavaUtilArrayList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[");
    localStringBuilder.append("tagType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append("size = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    localStringBuilder.append(",");
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)localIterator.next();
        if (localInterestTagInfo != null)
        {
          localStringBuilder.append(localInterestTagInfo.toString());
          localStringBuilder.append(",");
        }
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTag
 * JD-Core Version:    0.7.0.1
 */