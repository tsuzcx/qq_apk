package com.tencent.mobileqq.nearby.interestTag;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class InterestTagInfo
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<InterestTagInfo> CREATOR = new InterestTagInfo.1();
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
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("InterestTag", 2, localJSONException.toString());
      }
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    return ((InterestTagInfo)paramObject).tagId == this.tagId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(" tagName: ");
    localStringBuilder.append(this.tagName);
    localStringBuilder.append(" tagIconUrl: ");
    localStringBuilder.append(this.tagIconUrl);
    localStringBuilder.append(" tagId: ");
    localStringBuilder.append(this.tagId);
    localStringBuilder.append(" tagBgColor: ");
    localStringBuilder.append(this.tagBgColor);
    localStringBuilder.append(" tagTextColor: ");
    localStringBuilder.append(this.tagTextColor);
    localStringBuilder.append(" iconJumpUrl: ");
    localStringBuilder.append(this.tagJumpUrl);
    localStringBuilder.append(" bid: ");
    localStringBuilder.append(this.bid);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagInfo
 * JD-Core Version:    0.7.0.1
 */