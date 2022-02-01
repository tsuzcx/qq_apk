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
  public int a;
  public String a;
  public String b = null;
  public String c = null;
  
  public MediaPreviewInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public MediaPreviewInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Int = paramJSONObject.optInt("type", -1);
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("image");
      this.b = paramJSONObject.optString("video");
      this.c = DynamicAvatarDownloadManager.b(this.b);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "type = " + this.jdField_a_of_type_Int + ", imageUrl = " + this.jdField_a_of_type_JavaLangString + ", videoUrl = " + this.b + ", videoLocalPath = " + this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewInfo
 * JD-Core Version:    0.7.0.1
 */