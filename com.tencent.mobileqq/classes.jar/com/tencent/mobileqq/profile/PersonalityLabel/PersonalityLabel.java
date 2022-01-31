package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aute;
import autf;
import bbfe;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0.RspBody;

public class PersonalityLabel
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PersonalityLabel> CREATOR = new aute();
  public static int CURRENT_VERSION = 2;
  public static final String TAG = "PersonalityLabel";
  public int isCloseByUser;
  public long lastPraiseUin;
  public int maxPhotoCount;
  public List<PersonalityLabelInfo> personalityLabelInfos;
  public int photoCount;
  public int praiseCount;
  public int remainCount;
  public int unreadCount;
  
  public PersonalityLabel()
  {
    this.personalityLabelInfos = new ArrayList();
    this.remainCount = 10;
  }
  
  public PersonalityLabel(Parcel paramParcel)
  {
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
    if ((this.personalityLabelInfos != null) && (this.personalityLabelInfos.size() > 0)) {
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (i < this.personalityLabelInfos.size())
      {
        if (this.personalityLabelInfos.get(i) == null) {
          j = 1;
        }
      }
      else
      {
        if (j != 0)
        {
          this.personalityLabelInfos.clear();
          a();
        }
        b();
        return;
      }
      i += 1;
    }
  }
  
  private void a()
  {
    if (this.personalityLabelInfos != null) {
      this.personalityLabelInfos.clear();
    }
    for (;;)
    {
      this.remainCount = 0;
      this.photoCount = 0;
      this.praiseCount = 0;
      this.maxPhotoCount = 0;
      this.unreadCount = 0;
      this.lastPraiseUin = 0L;
      this.isCloseByUser = 0;
      return;
      this.personalityLabelInfos = new ArrayList();
    }
  }
  
  private void b()
  {
    if ((this.personalityLabelInfos != null) && (this.personalityLabelInfos.size() > 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PersonalityLabel", 2, "before unmarsh:" + this.personalityLabelInfos.toString());
      }
      Collections.sort(this.personalityLabelInfos, new autf(this));
      if (QLog.isDevelopLevel()) {
        QLog.i("PersonalityLabel", 2, "after unmarsh:" + this.personalityLabelInfos.toString());
      }
    }
  }
  
  public static PersonalityLabel convertFromBytes(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      paramArrayOfByte = null;
    }
    PersonalityLabel localPersonalityLabel;
    do
    {
      return paramArrayOfByte;
      localPersonalityLabel = (PersonalityLabel)bbfe.a(paramArrayOfByte, CREATOR);
      paramArrayOfByte = localPersonalityLabel;
    } while (!QLog.isColorLevel());
    if ("convertFromBytes:" + localPersonalityLabel == null) {}
    for (paramArrayOfByte = "null";; paramArrayOfByte = localPersonalityLabel.toString())
    {
      QLog.i("PersonalityLabel", 2, paramArrayOfByte);
      return localPersonalityLabel;
    }
  }
  
  public static PersonalityLabel convertFromPb(cmd0x8f0.RspBody paramRspBody)
  {
    int j = 0;
    PersonalityLabel localPersonalityLabel = new PersonalityLabel();
    label53:
    label77:
    label101:
    label125:
    long l;
    if (paramRspBody.uint32_remain_quota.has())
    {
      i = paramRspBody.uint32_remain_quota.get();
      localPersonalityLabel.remainCount = i;
      if (!paramRspBody.uint32_total_photo.has()) {
        break label253;
      }
      i = paramRspBody.uint32_total_photo.get();
      localPersonalityLabel.photoCount = i;
      if (!paramRspBody.uint32_total_praise.has()) {
        break label258;
      }
      i = paramRspBody.uint32_total_praise.get();
      localPersonalityLabel.praiseCount = i;
      if (!paramRspBody.uint32_max_photo_quota.has()) {
        break label263;
      }
      i = paramRspBody.uint32_max_photo_quota.get();
      localPersonalityLabel.maxPhotoCount = i;
      if (!paramRspBody.uint32_unread_praise.has()) {
        break label268;
      }
      i = paramRspBody.uint32_unread_praise.get();
      localPersonalityLabel.unreadCount = i;
      if (!paramRspBody.uint64_last_praise_uin.has()) {
        break label273;
      }
      l = paramRspBody.uint64_last_praise_uin.get();
      label149:
      localPersonalityLabel.lastPraiseUin = l;
      if (!paramRspBody.uint32_is_close.has()) {
        break label278;
      }
    }
    label258:
    label263:
    label268:
    label273:
    label278:
    for (int i = paramRspBody.uint32_is_close.get();; i = 0)
    {
      localPersonalityLabel.isCloseByUser = i;
      if ((!paramRspBody.rpt_msg_labels.has()) || (paramRspBody.rpt_msg_labels.size() <= 0)) {
        break label288;
      }
      i = j;
      while (i < paramRspBody.rpt_msg_labels.size())
      {
        PersonalityLabelInfo localPersonalityLabelInfo = PersonalityLabelInfo.convertFromPb((PersonalityTagComm.LabelInfo)paramRspBody.rpt_msg_labels.get(i));
        localPersonalityLabel.personalityLabelInfos.add(localPersonalityLabelInfo);
        i += 1;
      }
      i = 0;
      break;
      label253:
      i = 0;
      break label53;
      i = 0;
      break label77;
      i = 0;
      break label101;
      i = 0;
      break label125;
      l = 0L;
      break label149;
    }
    localPersonalityLabel.b();
    label288:
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabel", 2, "convertFromPb:" + localPersonalityLabel.toString());
    }
    return localPersonalityLabel;
  }
  
  public static PersonalityLabel convertFromPbBytes(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabel", 2, "convertFromPbBytes");
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return new PersonalityLabel();
    }
    cmd0x8f0.RspBody localRspBody = new cmd0x8f0.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      return convertFromPb(localRspBody);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabel", 2, "convertFromPbBytes failed.", paramArrayOfByte);
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabel", 2, "convertFromPbBytes failed.", paramArrayOfByte);
        }
      }
    }
  }
  
  public static byte[] convertToBytes(PersonalityLabel paramPersonalityLabel)
  {
    if (paramPersonalityLabel != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PersonalityLabel", 4, "convertToBytes:" + paramPersonalityLabel.toString());
      }
      return bbfe.a(paramPersonalityLabel);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    PersonalityLabel localPersonalityLabel;
    do
    {
      return false;
      localPersonalityLabel = (PersonalityLabel)paramObject;
    } while (((PersonalityLabel)paramObject).personalityLabelInfos.size() != this.personalityLabelInfos.size());
    int i = 0;
    for (;;)
    {
      if (i >= this.personalityLabelInfos.size()) {
        break label89;
      }
      if (!((PersonalityLabelInfo)localPersonalityLabel.personalityLabelInfos.get(i)).equals((PersonalityLabelInfo)this.personalityLabelInfos.get(i))) {
        break;
      }
      i += 1;
    }
    label89:
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
    if ((this.personalityLabelInfos != null) && (this.personalityLabelInfos.size() > 0) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos != null)) {
      return ((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.size();
    }
    return 0;
  }
  
  public String getLatestLabelText()
  {
    if ((this.personalityLabelInfos != null) && (this.personalityLabelInfos.size() > 0)) {
      return ((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).text;
    }
    return "";
  }
  
  public String getLatestThumbLocalUrl()
  {
    if ((this.personalityLabelInfos != null) && (this.personalityLabelInfos.size() > 0) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos != null) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.size() > 0)) {
      return ((PersonalityLabelPhoto)((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.get(0)).localThumbPath;
    }
    return null;
  }
  
  public String getLatestThumbUrl()
  {
    if ((this.personalityLabelInfos != null) && (this.personalityLabelInfos.size() > 0) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos != null) && (((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.size() > 0)) {
      return ((PersonalityLabelPhoto)((PersonalityLabelInfo)this.personalityLabelInfos.get(0)).personalityLabelPhotos.get(0)).get128SizeUrl();
    }
    return null;
  }
  
  public int getSize()
  {
    if (this.personalityLabelInfos == null) {
      return 0;
    }
    return this.personalityLabelInfos.size();
  }
  
  public String toString()
  {
    boolean bool = true;
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("currentVersion").append(":").append(CURRENT_VERSION).append("|");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("isCloseByUser");
    if (this.isCloseByUser == 1) {}
    for (;;)
    {
      localStringBuilder2.append(bool).append("|");
      localStringBuilder1.append("remainCount").append(":").append(this.remainCount).append("|").append("labelInfoSize:").append(this.personalityLabelInfos.size()).append("|").append("photoCount:").append(this.photoCount).append("|").append("praiseCount:").append(this.praiseCount).append("|").append("unreadCount:").append(this.unreadCount).append("|").append("lastPraiseUin:").append(this.lastPraiseUin).append("|").append("LabelInfos").append(":[").append(this.personalityLabelInfos).append("]");
      return localStringBuilder1.toString();
      bool = false;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel
 * JD-Core Version:    0.7.0.1
 */