package com.tencent.mobileqq.gamecenter.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avcd;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONObject;

public class PadFaceAd
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<PadFaceAd> CREATOR = new avcd();
  public String appName;
  public String appVersion;
  public String appView;
  public String arkMeta;
  public long endTime;
  @unique
  public int padFaceId;
  public int redPointId;
  public long startTime;
  
  public PadFaceAd() {}
  
  public PadFaceAd(Parcel paramParcel)
  {
    this.padFaceId = paramParcel.readInt();
    this.redPointId = paramParcel.readInt();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.appName = paramParcel.readString();
    this.appView = paramParcel.readString();
    this.appVersion = paramParcel.readString();
    this.arkMeta = paramParcel.readString();
  }
  
  public PadFaceAd(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.padFaceId = paramJSONObject.optInt("id");
      this.startTime = paramJSONObject.optLong("start_time");
      this.endTime = paramJSONObject.optLong("end_time");
      this.appName = paramJSONObject.optString("app_name");
      this.appVersion = paramJSONObject.optString("app_version");
      this.appView = paramJSONObject.optString("app_view");
      this.arkMeta = paramJSONObject.optString("ark_meta");
      this.redPointId = paramJSONObject.optInt("redpoint");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.appName)) && (!TextUtils.isEmpty(this.appView));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PadFaceAd {");
    localStringBuilder.append("padFaceId=").append(this.padFaceId).append(",redPointId=").append(this.redPointId).append(",appName=").append(this.appName).append(",appView=").append(this.appView).append(",appVersion=").append(this.appVersion).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.padFaceId);
    paramParcel.writeInt(this.redPointId);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.appView);
    paramParcel.writeString(this.appVersion);
    paramParcel.writeString(this.arkMeta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.PadFaceAd
 * JD-Core Version:    0.7.0.1
 */