package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import java.io.Serializable;
import tencent.im.label.comm.PersonalityTagComm.LabelPhoto;

public class PersonalityLabelPhoto
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PersonalityLabelPhoto> CREATOR = new PersonalityLabelPhoto.1();
  public static final long ID_INVALID = -1L;
  public static final String TAG = "PersonalityLabelPhoto";
  long fileId = -1L;
  boolean local = false;
  String localThumbPath = "";
  long praiseCount = 0L;
  long uniseq = 0L;
  public String url = "";
  
  public PersonalityLabelPhoto()
  {
    this.fileId = -1L;
    this.url = "";
    this.praiseCount = 0L;
    this.localThumbPath = "";
    this.uniseq = System.currentTimeMillis();
  }
  
  protected PersonalityLabelPhoto(Parcel paramParcel)
  {
    paramParcel.readInt();
    this.fileId = paramParcel.readLong();
    this.url = paramParcel.readString();
    this.praiseCount = paramParcel.readLong();
    this.localThumbPath = paramParcel.readString();
  }
  
  @NonNull
  public static PersonalityLabelPhoto convertFromPb(PersonalityTagComm.LabelPhoto paramLabelPhoto)
  {
    long l2 = 0L;
    PersonalityLabelPhoto localPersonalityLabelPhoto = new PersonalityLabelPhoto();
    long l1;
    if (paramLabelPhoto.uint64_file_id.has())
    {
      l1 = paramLabelPhoto.uint64_file_id.get();
      localPersonalityLabelPhoto.fileId = l1;
      if (!paramLabelPhoto.uint32_url.has()) {
        break label95;
      }
    }
    label95:
    for (String str = paramLabelPhoto.uint32_url.get();; str = "")
    {
      localPersonalityLabelPhoto.url = str;
      l1 = l2;
      if (paramLabelPhoto.uint64_praise_count.has()) {
        l1 = paramLabelPhoto.uint64_praise_count.get();
      }
      localPersonalityLabelPhoto.praiseCount = l1;
      return localPersonalityLabelPhoto;
      l1 = 0L;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return Utils.a(((PersonalityLabelPhoto)paramObject).url, this.url);
  }
  
  public String get128SizeUrl()
  {
    return this.url + "128";
  }
  
  public String get350SizeUrl()
  {
    return this.url + "350";
  }
  
  public String getOriginUrl()
  {
    if (TextUtils.isEmpty(this.url)) {
      return this.localThumbPath;
    }
    return this.url + "0";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("fileId").append(":").append(this.fileId).append("|").append("praiseCount").append(":").append(this.praiseCount).append("|").append("url").append(":").append(this.url).append("|");
    localStringBuilder.append("localThumbPath").append(":").append(this.localThumbPath).append("|");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ProfilePersonalityLabelInfo.CURRENT_VERSION);
    paramParcel.writeLong(this.fileId);
    paramParcel.writeString(this.url);
    paramParcel.writeLong(this.praiseCount);
    paramParcel.writeString(this.localThumbPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto
 * JD-Core Version:    0.7.0.1
 */