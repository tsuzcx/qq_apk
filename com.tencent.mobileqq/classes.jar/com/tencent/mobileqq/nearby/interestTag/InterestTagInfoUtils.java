package com.tencent.mobileqq.nearby.interestTag;

import appoint.define.appoint_define.InterestItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class InterestTagInfoUtils
{
  public Object a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    paramObject = (appoint_define.InterestItem)paramObject;
    InterestTagInfo localInterestTagInfo = new InterestTagInfo();
    if (paramObject.str_tag_back_color.has()) {
      localInterestTagInfo.tagBgColor = paramObject.str_tag_back_color.get();
    }
    if (paramObject.str_tag_font_color.has()) {
      localInterestTagInfo.tagTextColor = paramObject.str_tag_font_color.get();
    }
    if (paramObject.str_tag_icon_url.has()) {
      localInterestTagInfo.tagIconUrl = paramObject.str_tag_icon_url.get();
    }
    if (paramObject.str_tag_name.has()) {
      localInterestTagInfo.tagName = paramObject.str_tag_name.get();
    }
    if (paramObject.str_tag_href.has()) {
      localInterestTagInfo.tagJumpUrl = paramObject.str_tag_href.get();
    }
    if (paramObject.uint64_tag_id.has()) {
      localInterestTagInfo.tagId = paramObject.uint64_tag_id.get();
    }
    if (paramObject.uint32_bid.has()) {
      localInterestTagInfo.bid = paramObject.uint32_bid.get();
    }
    return localInterestTagInfo;
  }
  
  public Object a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      InterestTagInfo localInterestTagInfo = new InterestTagInfo();
      try
      {
        if (paramJSONObject.has("tagId")) {
          localInterestTagInfo.tagId = paramJSONObject.getLong("tagId");
        }
        if (paramJSONObject.has("tagName")) {
          localInterestTagInfo.tagName = paramJSONObject.getString("tagName");
        }
        if (paramJSONObject.has("tagIconUrl")) {
          localInterestTagInfo.tagIconUrl = paramJSONObject.getString("tagIconUrl");
        }
        if (paramJSONObject.has("tagJumpUrl")) {
          localInterestTagInfo.tagJumpUrl = paramJSONObject.getString("tagJumpUrl");
        }
        if (paramJSONObject.has("tagTextColor")) {
          localInterestTagInfo.tagTextColor = paramJSONObject.getString("tagTextColor");
        }
        if (paramJSONObject.has("tagBgColor")) {
          localInterestTagInfo.tagBgColor = paramJSONObject.getString("tagBgColor");
        }
        if (paramJSONObject.has("bid")) {
          localInterestTagInfo.bid = paramJSONObject.getLong("bid");
        }
        return localInterestTagInfo;
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("InterestTag", 2, paramJSONObject.toString());
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagInfoUtils
 * JD-Core Version:    0.7.0.1
 */