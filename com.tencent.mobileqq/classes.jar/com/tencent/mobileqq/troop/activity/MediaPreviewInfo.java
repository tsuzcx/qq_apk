package com.tencent.mobileqq.troop.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import org.json.JSONObject;

public class MediaPreviewInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaPreviewInfo> CREATOR = new MediaPreviewInfo.1();
  public int a = -1;
  public String b = null;
  public String c = null;
  public String d = null;
  
  public MediaPreviewInfo() {}
  
  public MediaPreviewInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optInt("type", -1);
      this.b = paramJSONObject.optString("image");
      this.c = paramJSONObject.optString("video");
      this.d = DynamicAvatarDownloadManager.c(this.c);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("type = ");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", imageUrl = ");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", videoUrl = ");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", videoLocalPath = ");
    localStringBuffer.append(this.d);
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewInfo
 * JD-Core Version:    0.7.0.1
 */