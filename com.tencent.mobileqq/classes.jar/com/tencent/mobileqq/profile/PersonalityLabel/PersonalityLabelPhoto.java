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
    PersonalityLabelPhoto localPersonalityLabelPhoto = new PersonalityLabelPhoto();
    boolean bool = paramLabelPhoto.uint64_file_id.has();
    long l2 = 0L;
    if (bool) {
      l1 = paramLabelPhoto.uint64_file_id.get();
    } else {
      l1 = 0L;
    }
    localPersonalityLabelPhoto.fileId = l1;
    String str;
    if (paramLabelPhoto.uint32_url.has()) {
      str = paramLabelPhoto.uint32_url.get();
    } else {
      str = "";
    }
    localPersonalityLabelPhoto.url = str;
    long l1 = l2;
    if (paramLabelPhoto.uint64_praise_count.has()) {
      l1 = paramLabelPhoto.uint64_praise_count.get();
    }
    localPersonalityLabelPhoto.praiseCount = l1;
    return localPersonalityLabelPhoto;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append("128");
    return localStringBuilder.toString();
  }
  
  public String get350SizeUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append("350");
    return localStringBuilder.toString();
  }
  
  public String getOriginUrl()
  {
    if (TextUtils.isEmpty(this.url)) {
      return this.localThumbPath;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append("0");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("fileId");
    localStringBuilder.append(":");
    localStringBuilder.append(this.fileId);
    localStringBuilder.append("|");
    localStringBuilder.append("praiseCount");
    localStringBuilder.append(":");
    localStringBuilder.append(this.praiseCount);
    localStringBuilder.append("|");
    localStringBuilder.append("url");
    localStringBuilder.append(":");
    localStringBuilder.append(this.url);
    localStringBuilder.append("|");
    localStringBuilder.append("localThumbPath");
    localStringBuilder.append(":");
    localStringBuilder.append(this.localThumbPath);
    localStringBuilder.append("|");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto
 * JD-Core Version:    0.7.0.1
 */