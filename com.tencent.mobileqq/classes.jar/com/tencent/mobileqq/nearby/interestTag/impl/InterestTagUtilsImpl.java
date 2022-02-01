package com.tencent.mobileqq.nearby.interestTag.impl;

import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.InterestTagUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class InterestTagUtilsImpl
  implements IInterestTagUtils
{
  public static final String TAG = "InterestTagUtilsImpl";
  private final InterestTagUtils mInterestTagUtils = new InterestTagUtils();
  
  public InterestTag convertFrom(Object paramObject)
  {
    return this.mInterestTagUtils.a((appoint_define.InterestTag)paramObject);
  }
  
  public InterestTag convertFromJSONObject(JSONObject paramJSONObject)
  {
    return this.mInterestTagUtils.a(paramJSONObject);
  }
  
  public Object convertTo(InterestTag paramInterestTag)
  {
    appoint_define.InterestTag localInterestTag = new appoint_define.InterestTag();
    localInterestTag.uint32_tag_type.set(paramInterestTag.jdField_a_of_type_Int);
    if (paramInterestTag.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      paramInterestTag = paramInterestTag.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramInterestTag.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramInterestTag.next();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.impl.InterestTagUtilsImpl
 * JD-Core Version:    0.7.0.1
 */