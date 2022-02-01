package com.tencent.mobileqq.nearby.interestTag;

import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InterestTagUtils
{
  public InterestTag a(appoint_define.InterestTag paramInterestTag)
  {
    if (paramInterestTag != null)
    {
      InterestTag localInterestTag = new InterestTag(paramInterestTag.uint32_tag_type.get());
      Object localObject = paramInterestTag.rpt_msg_tag_list.get();
      paramInterestTag = localInterestTag;
      if (localObject != null)
      {
        paramInterestTag = localInterestTag;
        if (((List)localObject).size() > 0)
        {
          localObject = ((List)localObject).iterator();
          for (;;)
          {
            paramInterestTag = localInterestTag;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramInterestTag = (appoint_define.InterestItem)((Iterator)localObject).next();
            paramInterestTag = (InterestTagInfo)((IInterestTagInfoUtils)QRoute.api(IInterestTagInfoUtils.class)).convertFrom(paramInterestTag);
            if (paramInterestTag != null) {
              localInterestTag.b.add(paramInterestTag);
            }
          }
        }
      }
    }
    else
    {
      paramInterestTag = null;
    }
    return paramInterestTag;
  }
  
  public InterestTag a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        boolean bool = paramJSONObject.has("tagType");
        j = 0;
        if (!bool) {
          break label146;
        }
        i = paramJSONObject.getInt("tagType");
        localInterestTag = new InterestTag(i);
        if (!paramJSONObject.has("tagInfos")) {
          break label151;
        }
        paramJSONObject = paramJSONObject.getJSONArray("tagInfos");
      }
      catch (JSONException paramJSONObject)
      {
        InterestTag localInterestTag;
        Object localObject;
        if (!QLog.isColorLevel()) {
          break label144;
        }
        QLog.i("Q.nearby_people_card.", 2, paramJSONObject.toString());
      }
      if (i < paramJSONObject.length())
      {
        localObject = paramJSONObject.getJSONObject(i);
        if (localObject != null)
        {
          localObject = (InterestTagInfo)((IInterestTagInfoUtils)QRoute.api(IInterestTagInfoUtils.class)).convertFrom((JSONObject)localObject);
          if (localObject != null) {
            localInterestTag.b.add(localObject);
          }
        }
        i += 1;
      }
      else
      {
        return localInterestTag;
        label144:
        return null;
        label146:
        i = 0;
        continue;
        label151:
        paramJSONObject = null;
        if (paramJSONObject != null) {
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagUtils
 * JD-Core Version:    0.7.0.1
 */