package com.tencent.mobileqq.profile.PersonalityLabel;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;
import tencent.im.label.comm.PersonalityTagComm.LabelPhoto;
import tencent.im.label.comm.PersonalityTagComm.PraiseUserInfo;

public class PersonalityLabelInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PersonalityLabelInfo> CREATOR = new PersonalityLabelInfo.1();
  public static final String TAG = "PersonalityLabelInfo";
  int addTime = 0;
  public int bgColor = -16777216;
  String bytesPhotoCookie;
  int category = 0;
  String coverUrl = "";
  public int fgColor = -1;
  public long id = 0L;
  long modTime;
  public List<PersonalityLabelPhoto> personalityLabelPhotos;
  int photoCount = 0;
  long praiseCount = 0L;
  int praiseFlag;
  public String text = "";
  long unreadPraiseCount = 0L;
  ArrayList<PersonalityLabelZan> zanUins;
  
  public PersonalityLabelInfo()
  {
    this.id = 0L;
    this.addTime = 0;
    this.category = 0;
    this.text = "";
    this.fgColor = 0;
    this.bgColor = 0;
    this.coverUrl = "";
    this.photoCount = 0;
    this.praiseCount = 0L;
    this.unreadPraiseCount = 0L;
    this.personalityLabelPhotos = new ArrayList();
    this.bytesPhotoCookie = null;
    this.modTime = 0L;
    this.praiseFlag = 0;
    this.zanUins = new ArrayList();
  }
  
  protected PersonalityLabelInfo(Parcel paramParcel)
  {
    paramParcel.readInt();
    this.id = paramParcel.readLong();
    this.addTime = paramParcel.readInt();
    this.category = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.fgColor = paramParcel.readInt();
    this.bgColor = paramParcel.readInt();
    this.coverUrl = paramParcel.readString();
    this.photoCount = paramParcel.readInt();
    this.praiseCount = paramParcel.readLong();
    this.unreadPraiseCount = paramParcel.readLong();
    this.personalityLabelPhotos = paramParcel.createTypedArrayList(PersonalityLabelPhoto.CREATOR);
    this.bytesPhotoCookie = paramParcel.readString();
    this.modTime = paramParcel.readLong();
    this.praiseFlag = paramParcel.readInt();
    this.zanUins = paramParcel.createTypedArrayList(PersonalityLabelZan.CREATOR);
  }
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getColor exception from");
        localStringBuilder.append(paramString);
        QLog.i("PersonalityLabelInfo", 2, localStringBuilder.toString(), localException);
      }
    }
    return paramInt;
  }
  
  @NonNull
  public static PersonalityLabelInfo convertFromPb(PersonalityTagComm.LabelInfo paramLabelInfo)
  {
    PersonalityLabelInfo localPersonalityLabelInfo = new PersonalityLabelInfo();
    boolean bool = paramLabelInfo.uint64_id.has();
    long l2 = 0L;
    if (bool) {
      l1 = paramLabelInfo.uint64_id.get();
    } else {
      l1 = 0L;
    }
    localPersonalityLabelInfo.id = l1;
    bool = paramLabelInfo.uint32_add_time.has();
    int j = 0;
    if (bool) {
      i = paramLabelInfo.uint32_add_time.get();
    } else {
      i = 0;
    }
    localPersonalityLabelInfo.addTime = i;
    if (paramLabelInfo.uint32_category.has()) {
      i = paramLabelInfo.uint32_category.get();
    } else {
      i = 0;
    }
    localPersonalityLabelInfo.category = i;
    bool = paramLabelInfo.str_text.has();
    String str = "";
    if (bool) {
      localObject = paramLabelInfo.str_text.get();
    } else {
      localObject = "";
    }
    localPersonalityLabelInfo.text = ((String)localObject);
    bool = paramLabelInfo.str_fg_color.has();
    int i = -1;
    if (bool) {
      i = a(paramLabelInfo.str_fg_color.get(), -1);
    }
    localPersonalityLabelInfo.fgColor = i;
    bool = paramLabelInfo.str_bg_color.has();
    i = -16777216;
    if (bool) {
      i = a(paramLabelInfo.str_bg_color.get(), -16777216);
    }
    localPersonalityLabelInfo.bgColor = i;
    Object localObject = str;
    if (paramLabelInfo.str_cover_photo_url.has()) {
      localObject = paramLabelInfo.str_cover_photo_url.get();
    }
    localPersonalityLabelInfo.coverUrl = ((String)localObject);
    if (paramLabelInfo.uint32_praise_count.has()) {
      l1 = paramLabelInfo.uint32_praise_count.get();
    } else {
      l1 = 0L;
    }
    localPersonalityLabelInfo.praiseCount = l1;
    if (paramLabelInfo.uint32_unread_praise.has()) {
      l1 = paramLabelInfo.uint32_unread_praise.get();
    } else {
      l1 = 0L;
    }
    localPersonalityLabelInfo.unreadPraiseCount = l1;
    if (paramLabelInfo.uint32_photo_count.has()) {
      i = paramLabelInfo.uint32_photo_count.get();
    } else {
      i = 0;
    }
    localPersonalityLabelInfo.photoCount = i;
    if (paramLabelInfo.bytes_photo_cookie.has()) {
      localObject = paramLabelInfo.bytes_photo_cookie.get().toStringUtf8();
    } else {
      localObject = null;
    }
    localPersonalityLabelInfo.bytesPhotoCookie = ((String)localObject);
    long l1 = l2;
    if (paramLabelInfo.uint32_mod_time.has()) {
      l1 = paramLabelInfo.uint32_mod_time.get();
    }
    localPersonalityLabelInfo.modTime = l1;
    if (paramLabelInfo.uint32_praise_flag.has()) {
      i = paramLabelInfo.uint32_praise_flag.get();
    } else {
      i = 0;
    }
    localPersonalityLabelInfo.praiseFlag = i;
    if ((paramLabelInfo.rpt_msg_photo.has()) && (paramLabelInfo.rpt_msg_photo.size() > 0))
    {
      i = 0;
      while (i < paramLabelInfo.rpt_msg_photo.size())
      {
        localObject = PersonalityLabelPhoto.convertFromPb((PersonalityTagComm.LabelPhoto)paramLabelInfo.rpt_msg_photo.get(i));
        localPersonalityLabelInfo.personalityLabelPhotos.add(localObject);
        i += 1;
      }
    }
    if ((paramLabelInfo.rpt_last_praise_uins_info.has()) && (paramLabelInfo.rpt_last_praise_uins_info.size() > 0))
    {
      i = j;
      while (i < paramLabelInfo.rpt_last_praise_uins_info.size())
      {
        localObject = (PersonalityTagComm.PraiseUserInfo)paramLabelInfo.rpt_last_praise_uins_info.get(i);
        localPersonalityLabelInfo.zanUins.add(PersonalityLabelZan.convertFromPb((PersonalityTagComm.PraiseUserInfo)localObject));
        i += 1;
      }
    }
    return localPersonalityLabelInfo;
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
    paramObject = (PersonalityLabelInfo)paramObject;
    if ((TextUtils.equals(paramObject.text, this.text)) && (paramObject.fgColor == this.fgColor) && (paramObject.bgColor == this.bgColor)) {
      return paramObject.modTime == this.modTime;
    }
    return false;
  }
  
  public int getSize()
  {
    return this.personalityLabelPhotos.size();
  }
  
  public boolean isComplete()
  {
    List localList = this.personalityLabelPhotos;
    boolean bool = false;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    if (i == this.photoCount) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("id");
    localStringBuilder.append(":");
    localStringBuilder.append(this.id);
    localStringBuilder.append("|");
    localStringBuilder.append("addTime:");
    localStringBuilder.append(this.addTime);
    localStringBuilder.append("|");
    localStringBuilder.append("category:");
    localStringBuilder.append(this.category);
    localStringBuilder.append("|");
    localStringBuilder.append("text:");
    localStringBuilder.append(this.text);
    localStringBuilder.append("|");
    localStringBuilder.append("fgColor:");
    localStringBuilder.append(this.fgColor);
    localStringBuilder.append("|");
    localStringBuilder.append("bgColor:");
    localStringBuilder.append(this.bgColor);
    localStringBuilder.append("|");
    localStringBuilder.append("coverUrl:");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append("|");
    localStringBuilder.append("photoCount:");
    localStringBuilder.append(this.photoCount);
    localStringBuilder.append("|");
    localStringBuilder.append("praiseCount:");
    localStringBuilder.append(this.praiseCount);
    localStringBuilder.append("|");
    localStringBuilder.append("unreadPraiseCount:");
    localStringBuilder.append(this.unreadPraiseCount);
    localStringBuilder.append("|");
    localStringBuilder.append("bytesPhotoCookie:");
    localStringBuilder.append(this.bytesPhotoCookie);
    localStringBuilder.append("|");
    localStringBuilder.append("photoSise:");
    localStringBuilder.append(this.personalityLabelPhotos.size());
    localStringBuilder.append("|");
    localStringBuilder.append("modeTime:");
    localStringBuilder.append(this.modTime);
    localStringBuilder.append("|");
    localStringBuilder.append("praiseFlag:");
    localStringBuilder.append(this.praiseFlag);
    localStringBuilder.append("|");
    localStringBuilder.append("personalityLabelPhotos:[");
    localStringBuilder.append(this.personalityLabelPhotos);
    localStringBuilder.append("]|");
    localStringBuilder.append("recent_prase_uins:[");
    localStringBuilder.append(this.zanUins);
    localStringBuilder.append("]|");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ProfilePersonalityLabelInfo.CURRENT_VERSION);
    paramParcel.writeLong(this.id);
    paramParcel.writeInt(this.addTime);
    paramParcel.writeInt(this.category);
    paramParcel.writeString(this.text);
    paramParcel.writeInt(this.fgColor);
    paramParcel.writeInt(this.bgColor);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeInt(this.photoCount);
    paramParcel.writeLong(this.praiseCount);
    paramParcel.writeLong(this.unreadPraiseCount);
    paramParcel.writeTypedList(this.personalityLabelPhotos);
    paramParcel.writeString(this.bytesPhotoCookie);
    paramParcel.writeLong(this.modTime);
    paramParcel.writeInt(this.praiseFlag);
    paramParcel.writeTypedList(this.zanUins);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo
 * JD-Core Version:    0.7.0.1
 */