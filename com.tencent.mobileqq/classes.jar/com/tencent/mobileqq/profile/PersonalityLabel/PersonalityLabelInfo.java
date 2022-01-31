package com.tencent.mobileqq.profile.PersonalityLabel;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import awpz;
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
  public static final Parcelable.Creator<PersonalityLabelInfo> CREATOR = new awpz();
  public static final String TAG = "PersonalityLabelInfo";
  int addTime = 0;
  public int bgColor = -16777216;
  String bytesPhotoCookie;
  int category = 0;
  String coverUrl = "";
  public int fgColor = -1;
  public long id;
  public long modTime;
  public List<PersonalityLabelPhoto> personalityLabelPhotos;
  public int photoCount = 0;
  public long praiseCount = 0L;
  public int praiseFlag;
  public String text = "";
  long unreadPraiseCount = 0L;
  public ArrayList<PersonalityLabelZan> zanUins;
  
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
  
  public PersonalityLabelInfo(Parcel paramParcel)
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
      i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception localException)
    {
      do
      {
        int i = paramInt;
      } while (!QLog.isColorLevel());
      QLog.i("PersonalityLabelInfo", 2, "getColor exception from" + paramString, localException);
    }
    return paramInt;
  }
  
  @NonNull
  public static PersonalityLabelInfo convertFromPb(PersonalityTagComm.LabelInfo paramLabelInfo)
  {
    long l2 = 0L;
    int j = 0;
    PersonalityLabelInfo localPersonalityLabelInfo = new PersonalityLabelInfo();
    long l1;
    label56:
    label80:
    Object localObject;
    if (paramLabelInfo.uint64_id.has())
    {
      l1 = paramLabelInfo.uint64_id.get();
      localPersonalityLabelInfo.id = l1;
      if (!paramLabelInfo.uint32_add_time.has()) {
        break label424;
      }
      i = paramLabelInfo.uint32_add_time.get();
      localPersonalityLabelInfo.addTime = i;
      if (!paramLabelInfo.uint32_category.has()) {
        break label429;
      }
      i = paramLabelInfo.uint32_category.get();
      localPersonalityLabelInfo.category = i;
      if (!paramLabelInfo.str_text.has()) {
        break label434;
      }
      localObject = paramLabelInfo.str_text.get();
      label105:
      localPersonalityLabelInfo.text = ((String)localObject);
      if (!paramLabelInfo.str_fg_color.has()) {
        break label441;
      }
      i = a(paramLabelInfo.str_fg_color.get(), -1);
      label134:
      localPersonalityLabelInfo.fgColor = i;
      if (!paramLabelInfo.str_bg_color.has()) {
        break label446;
      }
      i = a(paramLabelInfo.str_bg_color.get(), -16777216);
      label163:
      localPersonalityLabelInfo.bgColor = i;
      if (!paramLabelInfo.str_cover_photo_url.has()) {
        break label452;
      }
      localObject = paramLabelInfo.str_cover_photo_url.get();
      label188:
      localPersonalityLabelInfo.coverUrl = ((String)localObject);
      if (!paramLabelInfo.uint32_praise_count.has()) {
        break label459;
      }
      l1 = paramLabelInfo.uint32_praise_count.get();
      label214:
      localPersonalityLabelInfo.praiseCount = l1;
      if (!paramLabelInfo.uint32_unread_praise.has()) {
        break label464;
      }
      l1 = paramLabelInfo.uint32_unread_praise.get();
      label239:
      localPersonalityLabelInfo.unreadPraiseCount = l1;
      if (!paramLabelInfo.uint32_photo_count.has()) {
        break label469;
      }
      i = paramLabelInfo.uint32_photo_count.get();
      label263:
      localPersonalityLabelInfo.photoCount = i;
      if (!paramLabelInfo.bytes_photo_cookie.has()) {
        break label474;
      }
      localObject = paramLabelInfo.bytes_photo_cookie.get().toStringUtf8();
      label291:
      localPersonalityLabelInfo.bytesPhotoCookie = ((String)localObject);
      l1 = l2;
      if (paramLabelInfo.uint32_mod_time.has()) {
        l1 = paramLabelInfo.uint32_mod_time.get();
      }
      localPersonalityLabelInfo.modTime = l1;
      if (!paramLabelInfo.uint32_praise_flag.has()) {
        break label480;
      }
    }
    label424:
    label429:
    label434:
    label441:
    label446:
    label452:
    label459:
    label464:
    label469:
    label474:
    label480:
    for (int i = paramLabelInfo.uint32_praise_flag.get();; i = 0)
    {
      localPersonalityLabelInfo.praiseFlag = i;
      if ((!paramLabelInfo.rpt_msg_photo.has()) || (paramLabelInfo.rpt_msg_photo.size() <= 0)) {
        break label485;
      }
      i = 0;
      while (i < paramLabelInfo.rpt_msg_photo.size())
      {
        localObject = PersonalityLabelPhoto.convertFromPb((PersonalityTagComm.LabelPhoto)paramLabelInfo.rpt_msg_photo.get(i));
        localPersonalityLabelInfo.personalityLabelPhotos.add(localObject);
        i += 1;
      }
      l1 = 0L;
      break;
      i = 0;
      break label56;
      i = 0;
      break label80;
      localObject = "";
      break label105;
      i = -1;
      break label134;
      i = -16777216;
      break label163;
      localObject = "";
      break label188;
      l1 = 0L;
      break label214;
      l1 = 0L;
      break label239;
      i = 0;
      break label263;
      localObject = null;
      break label291;
    }
    label485:
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
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (PersonalityLabelInfo)paramObject;
    } while ((!TextUtils.equals(paramObject.text, this.text)) || (paramObject.fgColor != this.fgColor) || (paramObject.bgColor != this.bgColor) || (paramObject.modTime != this.modTime));
    return true;
  }
  
  public int getSize()
  {
    return this.personalityLabelPhotos.size();
  }
  
  public boolean isComplete()
  {
    boolean bool = false;
    if (this.personalityLabelPhotos == null) {}
    for (int i = 0;; i = this.personalityLabelPhotos.size())
    {
      if (i == this.photoCount) {
        bool = true;
      }
      return bool;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("id").append(":").append(this.id).append("|").append("addTime:").append(this.addTime).append("|").append("category:").append(this.category).append("|").append("text:").append(this.text).append("|").append("fgColor:").append(this.fgColor).append("|").append("bgColor:").append(this.bgColor).append("|").append("coverUrl:").append(this.coverUrl).append("|").append("photoCount:").append(this.photoCount).append("|").append("praiseCount:").append(this.praiseCount).append("|").append("unreadPraiseCount:").append(this.unreadPraiseCount).append("|").append("bytesPhotoCookie:").append(this.bytesPhotoCookie).append("|").append("photoSise:").append(this.personalityLabelPhotos.size()).append("|").append("modeTime:").append(this.modTime).append("|").append("praiseFlag:").append(this.praiseFlag).append("|").append("personalityLabelPhotos:[").append(this.personalityLabelPhotos).append("]|").append("recent_prase_uins:[").append(this.zanUins).append("]|");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(PersonalityLabel.CURRENT_VERSION);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo
 * JD-Core Version:    0.7.0.1
 */