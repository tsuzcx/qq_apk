package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.OneUinHeadInfo;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.UinHeadInfo;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.VideoHeadInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DynamicAvatar
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<DynamicAvatar> CREATOR = new DynamicAvatar.1();
  public String basicBigUrl = "";
  public String basicMiddleUrl = "";
  public int basicOverdueTimeStamp;
  public int basicSetTimeStamp;
  public String basicSmallUrl = "";
  public String basicStaticUrl = "";
  public int getTimeStamp;
  public String nearbyBigUrl = "";
  public String nearbyMiddleUrl = "";
  public int nearbyOverdueTimeStamp;
  public int nearbySetTimeStamp;
  public String nearbySmallUrl = "";
  public String nearbyStaticUrl = "";
  public long playTimeStamp;
  public long tinyId;
  public long uin;
  
  public DynamicAvatar() {}
  
  protected DynamicAvatar(Parcel paramParcel)
  {
    this.tinyId = paramParcel.readLong();
    this.uin = paramParcel.readLong();
    this.getTimeStamp = paramParcel.readInt();
    this.basicOverdueTimeStamp = paramParcel.readInt();
    this.nearbyOverdueTimeStamp = paramParcel.readInt();
    this.basicSetTimeStamp = paramParcel.readInt();
    this.nearbySetTimeStamp = paramParcel.readInt();
    this.basicSmallUrl = paramParcel.readString();
    this.basicMiddleUrl = paramParcel.readString();
    this.basicBigUrl = paramParcel.readString();
    this.nearbySmallUrl = paramParcel.readString();
    this.nearbyMiddleUrl = paramParcel.readString();
    this.nearbyBigUrl = paramParcel.readString();
    this.playTimeStamp = paramParcel.readLong();
  }
  
  public static DynamicAvatar convertFrom(DynamicAvatarInfo.OneUinHeadInfo paramOneUinHeadInfo)
  {
    if (paramOneUinHeadInfo == null) {
      return null;
    }
    DynamicAvatar localDynamicAvatar = new DynamicAvatar();
    localDynamicAvatar.tinyId = paramOneUinHeadInfo.b;
    localDynamicAvatar.uin = paramOneUinHeadInfo.jdField_a_of_type_Long;
    localDynamicAvatar.getTimeStamp = paramOneUinHeadInfo.jdField_a_of_type_Int;
    if ((paramOneUinHeadInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramOneUinHeadInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      QLog.i("Q.dynamicAvatar", 1, "convertFrom oneUinHeadInfo's headInfos is null.");
      return localDynamicAvatar;
    }
    paramOneUinHeadInfo = paramOneUinHeadInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramOneUinHeadInfo.hasNext())
    {
      Object localObject1 = (DynamicAvatarInfo.UinHeadInfo)paramOneUinHeadInfo.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((DynamicAvatarInfo.UinHeadInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
        if (((DynamicAvatarInfo.UinHeadInfo)localObject1).d == 17)
        {
          localDynamicAvatar.basicSetTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).c;
          localDynamicAvatar.basicOverdueTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).b;
          localDynamicAvatar.basicStaticUrl = ((DynamicAvatarInfo.UinHeadInfo)localObject1).jdField_a_of_type_JavaLangString;
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
          {
            localObject1 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (DynamicAvatarInfo.VideoHeadInfo)((Iterator)localObject1).next();
              if (localObject2 != null) {
                if ((((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 80) || (((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 100)) {
                  localDynamicAvatar.basicSmallUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 200) {
                  localDynamicAvatar.basicMiddleUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 640) {
                  localDynamicAvatar.basicBigUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_JavaLangString;
                }
              }
            }
          }
        }
        else if (((DynamicAvatarInfo.UinHeadInfo)localObject1).d == 18)
        {
          localDynamicAvatar.nearbySetTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).c;
          localDynamicAvatar.nearbyOverdueTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).b;
          localDynamicAvatar.nearbyStaticUrl = ((DynamicAvatarInfo.UinHeadInfo)localObject1).jdField_a_of_type_JavaLangString;
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
          {
            localObject1 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (DynamicAvatarInfo.VideoHeadInfo)((Iterator)localObject1).next();
              if (localObject2 != null) {
                if ((((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 80) || (((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 100)) {
                  localDynamicAvatar.nearbySmallUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 200) {
                  localDynamicAvatar.nearbyMiddleUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_Int == 640) {
                  localDynamicAvatar.nearbyBigUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).jdField_a_of_type_JavaLangString;
                }
              }
            }
          }
        }
      }
    }
    return localDynamicAvatar;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n************************************************");
    localStringBuilder.append("\ntinid: ").append(this.tinyId);
    localStringBuilder.append("\nuin: ").append(this.uin);
    localStringBuilder.append("\ngetTimeStamp: ").append(this.getTimeStamp);
    localStringBuilder.append("\nbasicOverdueTimeStamp: ").append(this.basicOverdueTimeStamp);
    localStringBuilder.append("\nnearbyOverdueTimeStamp: ").append(this.nearbyOverdueTimeStamp);
    localStringBuilder.append("\nbasicSetTimeStamp: ").append(this.basicSetTimeStamp);
    localStringBuilder.append("\nnearbySetTimeStamp: ").append(this.nearbySetTimeStamp);
    localStringBuilder.append("\nplayTimeStamp: ").append(this.playTimeStamp);
    localStringBuilder.append("\nbasicSmallUrl: ").append(this.basicSmallUrl);
    localStringBuilder.append("\nbasicMiddleUrl: ").append(this.basicMiddleUrl);
    localStringBuilder.append("\nbasicBigUrl: ").append(this.basicBigUrl);
    localStringBuilder.append("\nnearbySmallUrl: ").append(this.nearbySmallUrl);
    localStringBuilder.append("\nnearbyMiddleUrl: ").append(this.nearbyMiddleUrl);
    localStringBuilder.append("\nnearbyBigUrl: ").append(this.nearbyBigUrl);
    localStringBuilder.append("\nnearbyStaticUrl: ").append(this.nearbyStaticUrl);
    localStringBuilder.append("\n************************************************");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.tinyId);
    paramParcel.writeLong(this.uin);
    paramParcel.writeInt(this.getTimeStamp);
    paramParcel.writeInt(this.basicOverdueTimeStamp);
    paramParcel.writeInt(this.nearbyOverdueTimeStamp);
    paramParcel.writeInt(this.basicSetTimeStamp);
    paramParcel.writeInt(this.nearbySetTimeStamp);
    paramParcel.writeString(this.basicSmallUrl);
    paramParcel.writeString(this.basicMiddleUrl);
    paramParcel.writeString(this.basicBigUrl);
    paramParcel.writeString(this.nearbySmallUrl);
    paramParcel.writeString(this.nearbyMiddleUrl);
    paramParcel.writeString(this.nearbyBigUrl);
    paramParcel.writeLong(this.playTimeStamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DynamicAvatar
 * JD-Core Version:    0.7.0.1
 */