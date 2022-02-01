package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqel;
import aqem;
import aqen;
import artq;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DynamicAvatar
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<DynamicAvatar> CREATOR = new artq();
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
  
  public DynamicAvatar(Parcel paramParcel)
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
  
  public static DynamicAvatar convertFrom(aqel paramaqel)
  {
    if (paramaqel == null) {
      return null;
    }
    DynamicAvatar localDynamicAvatar = new DynamicAvatar();
    localDynamicAvatar.tinyId = paramaqel.b;
    localDynamicAvatar.uin = paramaqel.jdField_a_of_type_Long;
    localDynamicAvatar.getTimeStamp = paramaqel.jdField_a_of_type_Int;
    if ((paramaqel.jdField_a_of_type_JavaUtilArrayList == null) || (paramaqel.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      QLog.i("Q.dynamicAvatar", 1, "convertFrom oneUinHeadInfo's headInfos is null.");
      return localDynamicAvatar;
    }
    paramaqel = paramaqel.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramaqel.hasNext())
    {
      Object localObject1 = (aqem)paramaqel.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((aqem)localObject1).jdField_a_of_type_JavaUtilArrayList;
        if (((aqem)localObject1).d == 17)
        {
          localDynamicAvatar.basicSetTimeStamp = ((aqem)localObject1).c;
          localDynamicAvatar.basicOverdueTimeStamp = ((aqem)localObject1).b;
          localDynamicAvatar.basicStaticUrl = ((aqem)localObject1).jdField_a_of_type_JavaLangString;
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
          {
            localObject1 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (aqen)((Iterator)localObject1).next();
              if (localObject2 != null) {
                if ((((aqen)localObject2).jdField_a_of_type_Int == 80) || (((aqen)localObject2).jdField_a_of_type_Int == 100)) {
                  localDynamicAvatar.basicSmallUrl = ((aqen)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((aqen)localObject2).jdField_a_of_type_Int == 200) {
                  localDynamicAvatar.basicMiddleUrl = ((aqen)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((aqen)localObject2).jdField_a_of_type_Int == 640) {
                  localDynamicAvatar.basicBigUrl = ((aqen)localObject2).jdField_a_of_type_JavaLangString;
                }
              }
            }
          }
        }
        else if (((aqem)localObject1).d == 18)
        {
          localDynamicAvatar.nearbySetTimeStamp = ((aqem)localObject1).c;
          localDynamicAvatar.nearbyOverdueTimeStamp = ((aqem)localObject1).b;
          localDynamicAvatar.nearbyStaticUrl = ((aqem)localObject1).jdField_a_of_type_JavaLangString;
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
          {
            localObject1 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (aqen)((Iterator)localObject1).next();
              if (localObject2 != null) {
                if ((((aqen)localObject2).jdField_a_of_type_Int == 80) || (((aqen)localObject2).jdField_a_of_type_Int == 100)) {
                  localDynamicAvatar.nearbySmallUrl = ((aqen)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((aqen)localObject2).jdField_a_of_type_Int == 200) {
                  localDynamicAvatar.nearbyMiddleUrl = ((aqen)localObject2).jdField_a_of_type_JavaLangString;
                } else if (((aqen)localObject2).jdField_a_of_type_Int == 640) {
                  localDynamicAvatar.nearbyBigUrl = ((aqen)localObject2).jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.DynamicAvatar
 * JD-Core Version:    0.7.0.1
 */