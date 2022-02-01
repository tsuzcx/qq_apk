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
  public final ArrayList<InterestTagInfo> b = new ArrayList(2);
  
  public InterestTag(int paramInt)
  {
    this.a = paramInt;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tagType", this.a);
      JSONArray localJSONArray = new JSONArray();
      if (this.b.size() > 0)
      {
        Iterator localIterator = this.b.iterator();
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
    if (paramObject.a != this.a) {
      return false;
    }
    if (paramObject.b.size() != this.b.size()) {
      return false;
    }
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      if (!Utils.a(this.b.get(i), paramObject.b.get(i))) {
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append("size = ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(",");
    if (this.b.size() > 0)
    {
      Iterator localIterator = this.b.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTag
 * JD-Core Version:    0.7.0.1
 */