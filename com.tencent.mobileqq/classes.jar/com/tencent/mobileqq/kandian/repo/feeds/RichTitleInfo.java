package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class RichTitleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RichTitleInfo> CREATOR = new RichTitleInfo.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public int e = 0;
  
  public RichTitleInfo() {}
  
  protected RichTitleInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public RichTitleInfo(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("bytes_biu_comments");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("msg_jump_info");
    if (localJSONObject != null)
    {
      this.b = localJSONObject.optString("uint64_id");
      this.c = localJSONObject.optString("bytes_wording");
      this.d = localJSONObject.optString("bytes_jump_url");
    }
    this.e = paramJSONObject.optInt("op_type", 0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RichTitleInfo{normalWords='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicName='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo
 * JD-Core Version:    0.7.0.1
 */