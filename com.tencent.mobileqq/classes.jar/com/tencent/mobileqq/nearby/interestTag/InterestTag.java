package com.tencent.mobileqq.nearby.interestTag;

import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
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
  
  public static InterestTag a(appoint_define.InterestTag paramInterestTag)
  {
    InterestTag localInterestTag = null;
    if (paramInterestTag != null)
    {
      localInterestTag = new InterestTag(paramInterestTag.uint32_tag_type.get());
      paramInterestTag = paramInterestTag.rpt_msg_tag_list.get();
      if ((paramInterestTag != null) && (paramInterestTag.size() > 0))
      {
        paramInterestTag = paramInterestTag.iterator();
        while (paramInterestTag.hasNext())
        {
          InterestTagInfo localInterestTagInfo = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramInterestTag.next());
          if (localInterestTagInfo != null) {
            localInterestTag.jdField_a_of_type_JavaUtilArrayList.add(localInterestTagInfo);
          }
        }
      }
    }
    return localInterestTag;
  }
  
  public static InterestTag a(JSONObject paramJSONObject)
  {
    int j = 0;
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      InterestTag localInterestTag;
      try
      {
        if (!paramJSONObject.has("tagType")) {
          break label123;
        }
        i = paramJSONObject.getInt("tagType");
        localInterestTag = new InterestTag(i);
        if (!paramJSONObject.has("tagInfos")) {
          break label118;
        }
        paramJSONObject = paramJSONObject.getJSONArray("tagInfos");
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          break label114;
        }
        QLog.i("Q.nearby_people_card.", 2, paramJSONObject.toString());
      }
      Object localObject = localInterestTag;
      if (i < paramJSONObject.length())
      {
        localObject = paramJSONObject.getJSONObject(i);
        if (localObject != null)
        {
          localObject = InterestTagInfo.convertFrom((JSONObject)localObject);
          if (localObject != null)
          {
            localInterestTag.jdField_a_of_type_JavaUtilArrayList.add(localObject);
            break label140;
            label114:
            localObject = null;
          }
        }
      }
      else
      {
        label118:
        label123:
        do
        {
          return localObject;
          paramJSONObject = null;
          break label128;
          i = 0;
          break;
          localObject = localInterestTag;
        } while (paramJSONObject == null);
        label128:
        i = j;
        continue;
      }
      label140:
      i += 1;
    }
  }
  
  public appoint_define.InterestTag a()
  {
    appoint_define.InterestTag localInterestTag = new appoint_define.InterestTag();
    localInterestTag.uint32_tag_type.set(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)localIterator.next();
        if (localInterestTagInfo != null)
        {
          appoint_define.InterestItem localInterestItem = new appoint_define.InterestItem();
          localInterestItem.uint64_tag_id.set(localInterestTagInfo.tagId);
          if (localInterestTagInfo.tagName != null) {
            localInterestItem.str_tag_name.set(localInterestTagInfo.tagName);
          }
          if (localInterestTagInfo.tagBgColor != null) {
            localInterestItem.str_tag_back_color.set(localInterestTagInfo.tagBgColor);
          }
          if (localInterestTagInfo.tagTextColor != null) {
            localInterestItem.str_tag_font_color.set(localInterestTagInfo.tagTextColor);
          }
          if (localInterestTagInfo.tagJumpUrl != null) {
            localInterestItem.str_tag_href.set(localInterestTagInfo.tagJumpUrl);
          }
          if (localInterestTagInfo.tagIconUrl != null) {
            localInterestItem.str_tag_icon_url.set(localInterestTagInfo.tagIconUrl);
          }
          localInterestTag.rpt_msg_tag_list.add(localInterestItem);
        }
      }
    }
    return localInterestTag;
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
      localException.put("tagInfos", localJSONArray);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, localException.toString());
      }
      return null;
    }
    return localException;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (paramObject.getClass() != getClass());
      paramObject = (InterestTag)paramObject;
    } while ((paramObject.jdField_a_of_type_Int != this.jdField_a_of_type_Int) || (paramObject.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_JavaUtilArrayList.size()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label94;
      }
      if (!Utils.a(this.jdField_a_of_type_JavaUtilArrayList.get(i), paramObject.jdField_a_of_type_JavaUtilArrayList.get(i))) {
        break;
      }
      i += 1;
    }
    label94:
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[").append("tagType = ").append(this.jdField_a_of_type_Int).append(",").append("size = ").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append(",");
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)localIterator.next();
        if (localInterestTagInfo != null) {
          localStringBuilder.append(localInterestTagInfo.toString()).append(",");
        }
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTag
 * JD-Core Version:    0.7.0.1
 */