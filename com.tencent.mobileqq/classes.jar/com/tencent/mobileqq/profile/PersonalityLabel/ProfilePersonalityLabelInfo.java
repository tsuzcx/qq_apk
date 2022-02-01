package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.utils.ParcelableUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0.RspBody;

public class ProfilePersonalityLabelInfo
  implements Parcelable, IProfileBusinessInfo, Serializable
{
  public static final Parcelable.Creator<ProfilePersonalityLabelInfo> CREATOR = new ProfilePersonalityLabelInfo.1();
  public static int CURRENT_VERSION = 2;
  public int isCloseByUser;
  public long lastPraiseUin;
  public int maxPhotoCount;
  public List<PersonalityLabelInfo> personalityLabelInfos;
  public int photoCount;
  public int praiseCount;
  public int remainCount;
  public int unreadCount;
  
  public ProfilePersonalityLabelInfo()
  {
    this.isCloseByUser = 0;
    this.personalityLabelInfos = new ArrayList();
    this.remainCount = 10;
  }
  
  protected ProfilePersonalityLabelInfo(Parcel paramParcel)
  {
    int k = 0;
    this.isCloseByUser = 0;
    int i = paramParcel.readInt();
    this.personalityLabelInfos = paramParcel.createTypedArrayList(PersonalityLabelInfo.CREATOR);
    this.remainCount = paramParcel.readInt();
    this.photoCount = paramParcel.readInt();
    this.praiseCount = paramParcel.readInt();
    this.maxPhotoCount = paramParcel.readInt();
    this.unreadCount = paramParcel.readInt();
    this.lastPraiseUin = paramParcel.readLong();
    if (i >= 2) {
      this.isCloseByUser = paramParcel.readInt();
    }
    paramParcel = this.personalityLabelInfos;
    if ((paramParcel != null) && (paramParcel.size() > 0))
    {
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.personalityLabelInfos.size()) {
          break;
        }
        if (this.personalityLabelInfos.get(i) == null)
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0)
      {
        this.personalityLabelInfos.clear();
        a();
      }
    }
    b();
  }
  
  private void a()
  {
    List localList = this.personalityLabelInfos;
    if (localList != null) {
      localList.clear();
    } else {
      this.personalityLabelInfos = new ArrayList();
    }
    this.remainCount = 0;
    this.photoCount = 0;
    this.praiseCount = 0;
    this.maxPhotoCount = 0;
    this.unreadCount = 0;
    this.lastPraiseUin = 0L;
    this.isCloseByUser = 0;
  }
  
  private void b()
  {
    Object localObject = this.personalityLabelInfos;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("before unmarsh:");
        ((StringBuilder)localObject).append(this.personalityLabelInfos.toString());
        QLog.i("PersonalityLabel", 2, ((StringBuilder)localObject).toString());
      }
      Collections.sort(this.personalityLabelInfos, new ProfilePersonalityLabelInfo.ModTimeComparator(this));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("after unmarsh:");
        ((StringBuilder)localObject).append(this.personalityLabelInfos.toString());
        QLog.i("PersonalityLabel", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static ProfilePersonalityLabelInfo convertFromBytes(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      ProfilePersonalityLabelInfo localProfilePersonalityLabelInfo = (ProfilePersonalityLabelInfo)ParcelableUtil.a(paramArrayOfByte, CREATOR);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("convertFromBytes:");
        paramArrayOfByte.append(localProfilePersonalityLabelInfo);
        if (paramArrayOfByte.toString() == null) {
          paramArrayOfByte = "null";
        } else {
          paramArrayOfByte = localProfilePersonalityLabelInfo.toString();
        }
        QLog.i("PersonalityLabel", 2, paramArrayOfByte);
      }
      return localProfilePersonalityLabelInfo;
    }
    return null;
  }
  
  public static ProfilePersonalityLabelInfo convertFromPb(cmd0x8f0.RspBody paramRspBody)
  {
    ProfilePersonalityLabelInfo localProfilePersonalityLabelInfo = new ProfilePersonalityLabelInfo();
    boolean bool = paramRspBody.uint32_remain_quota.has();
    int j = 0;
    int i;
    if (bool) {
      i = paramRspBody.uint32_remain_quota.get();
    } else {
      i = 0;
    }
    localProfilePersonalityLabelInfo.remainCount = i;
    if (paramRspBody.uint32_total_photo.has()) {
      i = paramRspBody.uint32_total_photo.get();
    } else {
      i = 0;
    }
    localProfilePersonalityLabelInfo.photoCount = i;
    if (paramRspBody.uint32_total_praise.has()) {
      i = paramRspBody.uint32_total_praise.get();
    } else {
      i = 0;
    }
    localProfilePersonalityLabelInfo.praiseCount = i;
    if (paramRspBody.uint32_max_photo_quota.has()) {
      i = paramRspBody.uint32_max_photo_quota.get();
    } else {
      i = 0;
    }
    localProfilePersonalityLabelInfo.maxPhotoCount = i;
    if (paramRspBody.uint32_unread_praise.has()) {
      i = paramRspBody.uint32_unread_praise.get();
    } else {
      i = 0;
    }
    localProfilePersonalityLabelInfo.unreadCount = i;
    long l;
    if (paramRspBody.uint64_last_praise_uin.has()) {
      l = paramRspBody.uint64_last_praise_uin.get();
    } else {
      l = 0L;
    }
    localProfilePersonalityLabelInfo.lastPraiseUin = l;
    if (paramRspBody.uint32_is_close.has()) {
      i = paramRspBody.uint32_is_close.get();
    } else {
      i = 0;
    }
    localProfilePersonalityLabelInfo.isCloseByUser = i;
    if ((paramRspBody.rpt_msg_labels.has()) && (paramRspBody.rpt_msg_labels.size() > 0))
    {
      i = j;
      while (i < paramRspBody.rpt_msg_labels.size())
      {
        PersonalityLabelInfo localPersonalityLabelInfo = PersonalityLabelInfo.convertFromPb((PersonalityTagComm.LabelInfo)paramRspBody.rpt_msg_labels.get(i));
        localProfilePersonalityLabelInfo.personalityLabelInfos.add(localPersonalityLabelInfo);
        i += 1;
      }
      localProfilePersonalityLabelInfo.b();
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("convertFromPb:");
      paramRspBody.append(localProfilePersonalityLabelInfo.toString());
      QLog.i("PersonalityLabel", 2, paramRspBody.toString());
    }
    return localProfilePersonalityLabelInfo;
  }
  
  public static ProfilePersonalityLabelInfo convertFromPbBytes(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabel", 2, "convertFromPbBytes");
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      cmd0x8f0.RspBody localRspBody = new cmd0x8f0.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabel", 2, "convertFromPbBytes failed.", paramArrayOfByte);
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabel", 2, "convertFromPbBytes failed.", paramArrayOfByte);
        }
      }
      return convertFromPb(localRspBody);
    }
    return new ProfilePersonalityLabelInfo();
  }
  
  public static byte[] convertToBytes(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    if (paramProfilePersonalityLabelInfo != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertToBytes:");
        localStringBuilder.append(paramProfilePersonalityLabelInfo.toString());
        QLog.i("PersonalityLabel", 4, localStringBuilder.toString());
      }
      return ParcelableUtil.a(paramProfilePersonalityLabelInfo);
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
    paramObject = (ProfilePersonalityLabelInfo)paramObject;
    if (paramObject.personalityLabelInfos.size() != this.personalityLabelInfos.size()) {
      return false;
    }
    int i = 0;
    while (i < this.personalityLabelInfos.size())
    {
      if (!((PersonalityLabelInfo)paramObject.personalityLabelInfos.get(i)).equals((PersonalityLabelInfo)this.personalityLabelInfos.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public PersonalityLabelInfo getLabelById(long paramLong)
  {
    if (getSize() <= 0) {
      return null;
    }
    int i = 0;
    while (i < this.personalityLabelInfos.size())
    {
      if (((PersonalityLabelInfo)this.personalityLabelInfos.get(i)).id == paramLong) {
        return (PersonalityLabelInfo)this.personalityLabelInfos.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public String getLabelTexts()
  {
    if (this.personalityLabelInfos == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.personalityLabelInfos.size())
    {
      if (i != 0) {
        localStringBuilder.append(65292);
      }
      localStringBuilder.append(((PersonalityLabelInfo)this.personalityLabelInfos.get(i)).text);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int getLatestLabelPhotoSize()
  {
    List localList = this.personalityLabelInfos;
    if ((localList != null) && (localList.size() > 0) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos != null)) {
      return ((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.size();
    }
    return 0;
  }
  
  public String getLatestLabelText()
  {
    List localList = this.personalityLabelInfos;
    if ((localList != null) && (localList.size() > 0)) {
      return ((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).text;
    }
    return "";
  }
  
  public String getLatestThumbLocalUrl()
  {
    List localList = this.personalityLabelInfos;
    if ((localList != null) && (localList.size() > 0) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos != null) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.size() > 0)) {
      return ((PersonalityLabelPhoto)((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.get(0)).localThumbPath;
    }
    return null;
  }
  
  public String getLatestThumbUrl()
  {
    List localList = this.personalityLabelInfos;
    if ((localList != null) && (localList.size() > 0) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos != null) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.size() > 0)) {
      return ((PersonalityLabelPhoto)((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.get(0)).get128SizeUrl();
    }
    return null;
  }
  
  public int getSize()
  {
    List localList = this.personalityLabelInfos;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("currentVersion");
    localStringBuilder.append(":");
    localStringBuilder.append(CURRENT_VERSION);
    localStringBuilder.append("|");
    localStringBuilder.append("isCloseByUser");
    int i = this.isCloseByUser;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("|");
    localStringBuilder.append("remainCount");
    localStringBuilder.append(":");
    localStringBuilder.append(this.remainCount);
    localStringBuilder.append("|");
    localStringBuilder.append("labelInfoSize:");
    localStringBuilder.append(this.personalityLabelInfos.size());
    localStringBuilder.append("|");
    localStringBuilder.append("photoCount:");
    localStringBuilder.append(this.photoCount);
    localStringBuilder.append("|");
    localStringBuilder.append("praiseCount:");
    localStringBuilder.append(this.praiseCount);
    localStringBuilder.append("|");
    localStringBuilder.append("unreadCount:");
    localStringBuilder.append(this.unreadCount);
    localStringBuilder.append("|");
    localStringBuilder.append("lastPraiseUin:");
    localStringBuilder.append(this.lastPraiseUin);
    localStringBuilder.append("|");
    localStringBuilder.append("LabelInfos");
    localStringBuilder.append(":[");
    localStringBuilder.append(this.personalityLabelInfos);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(CURRENT_VERSION);
    paramParcel.writeTypedList(this.personalityLabelInfos);
    paramParcel.writeInt(this.remainCount);
    paramParcel.writeInt(this.photoCount);
    paramParcel.writeInt(this.praiseCount);
    paramParcel.writeInt(this.maxPhotoCount);
    paramParcel.writeInt(this.unreadCount);
    paramParcel.writeLong(this.lastPraiseUin);
    paramParcel.writeInt(this.isCloseByUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo
 * JD-Core Version:    0.7.0.1
 */