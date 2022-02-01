package com.tencent.mobileqq.nearby.interestTag;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestItem;
import awog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class InterestTagInfo
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<InterestTagInfo> CREATOR = new awog();
  public long bid;
  public String tagBgColor;
  public String tagIconUrl;
  public long tagId;
  public String tagJumpUrl;
  public String tagName;
  public String tagTextColor;
  public int tagType = -1;
  
  public InterestTagInfo() {}
  
  public InterestTagInfo(Parcel paramParcel)
  {
    this.tagId = paramParcel.readLong();
    this.tagName = paramParcel.readString();
    this.tagIconUrl = paramParcel.readString();
    this.tagJumpUrl = paramParcel.readString();
    this.tagTextColor = paramParcel.readString();
    this.tagBgColor = paramParcel.readString();
    this.bid = paramParcel.readLong();
  }
  
  public static InterestTagInfo convertFrom(appoint_define.InterestItem paramInterestItem)
  {
    Object localObject;
    if (paramInterestItem == null) {
      localObject = null;
    }
    InterestTagInfo localInterestTagInfo;
    do
    {
      return localObject;
      localInterestTagInfo = new InterestTagInfo();
      if (paramInterestItem.str_tag_back_color.has()) {
        localInterestTagInfo.tagBgColor = paramInterestItem.str_tag_back_color.get();
      }
      if (paramInterestItem.str_tag_font_color.has()) {
        localInterestTagInfo.tagTextColor = paramInterestItem.str_tag_font_color.get();
      }
      if (paramInterestItem.str_tag_icon_url.has()) {
        localInterestTagInfo.tagIconUrl = paramInterestItem.str_tag_icon_url.get();
      }
      if (paramInterestItem.str_tag_name.has()) {
        localInterestTagInfo.tagName = paramInterestItem.str_tag_name.get();
      }
      if (paramInterestItem.str_tag_href.has()) {
        localInterestTagInfo.tagJumpUrl = paramInterestItem.str_tag_href.get();
      }
      if (paramInterestItem.uint64_tag_id.has()) {
        localInterestTagInfo.tagId = paramInterestItem.uint64_tag_id.get();
      }
      localObject = localInterestTagInfo;
    } while (!paramInterestItem.uint32_bid.has());
    localInterestTagInfo.bid = paramInterestItem.uint32_bid.get();
    return localInterestTagInfo;
  }
  
  public static InterestTagInfo convertFrom(JSONObject paramJSONObject)
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
  
  public JSONObject convertTo()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tagId", this.tagId);
      if (!TextUtils.isEmpty(this.tagName)) {
        localJSONObject.put("tagName", this.tagName);
      }
      if (!TextUtils.isEmpty(this.tagIconUrl)) {
        localJSONObject.put("tagIconUrl", this.tagIconUrl);
      }
      if (!TextUtils.isEmpty(this.tagJumpUrl)) {
        localJSONObject.put("tagJumpUrl", this.tagJumpUrl);
      }
      if (!TextUtils.isEmpty(this.tagTextColor)) {
        localJSONObject.put("tagTextColor", this.tagTextColor);
      }
      if (!TextUtils.isEmpty(this.tagBgColor)) {
        localJSONObject.put("tagBgColor", this.tagBgColor);
      }
      localJSONObject.put("bid", this.bid);
    }
    catch (JSONException localJSONException)
    {
      do
      {
        localJSONObject = null;
      } while (!QLog.isColorLevel());
      QLog.i("InterestTag", 2, localJSONException.toString());
    }
    return localJSONObject;
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((paramObject.getClass() != getClass()) || (((InterestTagInfo)paramObject).tagId != this.tagId)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(" tagName: ").append(this.tagName);
    localStringBuilder.append(" tagIconUrl: ").append(this.tagIconUrl);
    localStringBuilder.append(" tagId: ").append(this.tagId);
    localStringBuilder.append(" tagBgColor: ").append(this.tagBgColor);
    localStringBuilder.append(" tagTextColor: ").append(this.tagTextColor);
    localStringBuilder.append(" iconJumpUrl: ").append(this.tagJumpUrl);
    localStringBuilder.append(" bid: ").append(this.bid);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.tagId);
    paramParcel.writeString(this.tagName);
    paramParcel.writeString(this.tagIconUrl);
    paramParcel.writeString(this.tagJumpUrl);
    paramParcel.writeString(this.tagTextColor);
    paramParcel.writeString(this.tagBgColor);
    paramParcel.writeLong(this.bid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagInfo
 * JD-Core Version:    0.7.0.1
 */