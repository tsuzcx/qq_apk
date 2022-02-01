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
    localDynamicAvatar.tinyId = paramOneUinHeadInfo.c;
    localDynamicAvatar.uin = paramOneUinHeadInfo.a;
    localDynamicAvatar.getTimeStamp = paramOneUinHeadInfo.b;
    if ((paramOneUinHeadInfo.d != null) && (!paramOneUinHeadInfo.d.isEmpty()))
    {
      paramOneUinHeadInfo = paramOneUinHeadInfo.d.iterator();
      while (paramOneUinHeadInfo.hasNext())
      {
        Object localObject1 = (DynamicAvatarInfo.UinHeadInfo)paramOneUinHeadInfo.next();
        if (localObject1 != null)
        {
          Object localObject2 = ((DynamicAvatarInfo.UinHeadInfo)localObject1).f;
          if (((DynamicAvatarInfo.UinHeadInfo)localObject1).e == 17)
          {
            localDynamicAvatar.basicSetTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).d;
            localDynamicAvatar.basicOverdueTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).b;
            localDynamicAvatar.basicStaticUrl = ((DynamicAvatarInfo.UinHeadInfo)localObject1).c;
            if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
            {
              localObject1 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (DynamicAvatarInfo.VideoHeadInfo)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  if ((((DynamicAvatarInfo.VideoHeadInfo)localObject2).b != 80) && (((DynamicAvatarInfo.VideoHeadInfo)localObject2).b != 100))
                  {
                    if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).b == 200) {
                      localDynamicAvatar.basicMiddleUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).a;
                    } else if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).b == 640) {
                      localDynamicAvatar.basicBigUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).a;
                    }
                  }
                  else {
                    localDynamicAvatar.basicSmallUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).a;
                  }
                }
              }
            }
          }
          else if (((DynamicAvatarInfo.UinHeadInfo)localObject1).e == 18)
          {
            localDynamicAvatar.nearbySetTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).d;
            localDynamicAvatar.nearbyOverdueTimeStamp = ((DynamicAvatarInfo.UinHeadInfo)localObject1).b;
            localDynamicAvatar.nearbyStaticUrl = ((DynamicAvatarInfo.UinHeadInfo)localObject1).c;
            if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
            {
              localObject1 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (DynamicAvatarInfo.VideoHeadInfo)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  if ((((DynamicAvatarInfo.VideoHeadInfo)localObject2).b != 80) && (((DynamicAvatarInfo.VideoHeadInfo)localObject2).b != 100))
                  {
                    if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).b == 200) {
                      localDynamicAvatar.nearbyMiddleUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).a;
                    } else if (((DynamicAvatarInfo.VideoHeadInfo)localObject2).b == 640) {
                      localDynamicAvatar.nearbyBigUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).a;
                    }
                  }
                  else {
                    localDynamicAvatar.nearbySmallUrl = ((DynamicAvatarInfo.VideoHeadInfo)localObject2).a;
                  }
                }
              }
            }
          }
        }
      }
      return localDynamicAvatar;
    }
    QLog.i("Q.dynamicAvatar", 1, "convertFrom oneUinHeadInfo's headInfos is null.");
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
    localStringBuilder.append("\ntinid: ");
    localStringBuilder.append(this.tinyId);
    localStringBuilder.append("\nuin: ");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("\ngetTimeStamp: ");
    localStringBuilder.append(this.getTimeStamp);
    localStringBuilder.append("\nbasicOverdueTimeStamp: ");
    localStringBuilder.append(this.basicOverdueTimeStamp);
    localStringBuilder.append("\nnearbyOverdueTimeStamp: ");
    localStringBuilder.append(this.nearbyOverdueTimeStamp);
    localStringBuilder.append("\nbasicSetTimeStamp: ");
    localStringBuilder.append(this.basicSetTimeStamp);
    localStringBuilder.append("\nnearbySetTimeStamp: ");
    localStringBuilder.append(this.nearbySetTimeStamp);
    localStringBuilder.append("\nplayTimeStamp: ");
    localStringBuilder.append(this.playTimeStamp);
    localStringBuilder.append("\nbasicSmallUrl: ");
    localStringBuilder.append(this.basicSmallUrl);
    localStringBuilder.append("\nbasicMiddleUrl: ");
    localStringBuilder.append(this.basicMiddleUrl);
    localStringBuilder.append("\nbasicBigUrl: ");
    localStringBuilder.append(this.basicBigUrl);
    localStringBuilder.append("\nnearbySmallUrl: ");
    localStringBuilder.append(this.nearbySmallUrl);
    localStringBuilder.append("\nnearbyMiddleUrl: ");
    localStringBuilder.append(this.nearbyMiddleUrl);
    localStringBuilder.append("\nnearbyBigUrl: ");
    localStringBuilder.append(this.nearbyBigUrl);
    localStringBuilder.append("\nnearbyStaticUrl: ");
    localStringBuilder.append(this.nearbyStaticUrl);
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