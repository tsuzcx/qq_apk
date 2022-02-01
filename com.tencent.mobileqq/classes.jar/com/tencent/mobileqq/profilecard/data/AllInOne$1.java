package com.tencent.mobileqq.profilecard.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

final class AllInOne$1
  implements Parcelable.Creator<AllInOne>
{
  public AllInOne createFromParcel(Parcel paramParcel)
  {
    AllInOne localAllInOne = new AllInOne(null);
    localAllInOne.uin = paramParcel.readString();
    localAllInOne.pa = paramParcel.readInt();
    localAllInOne.age = paramParcel.readInt();
    localAllInOne.gender = paramParcel.readByte();
    localAllInOne.faceId = ((short)paramParcel.readInt());
    localAllInOne.maritalStatus = paramParcel.readByte();
    localAllInOne.professionId = paramParcel.readInt();
    localAllInOne.constellation = paramParcel.readByte();
    localAllInOne.distanceTime = paramParcel.readString();
    localAllInOne.troopCode = paramParcel.readString();
    localAllInOne.troopUin = paramParcel.readString();
    localAllInOne.discussUin = paramParcel.readString();
    localAllInOne.contactArray = new ArrayList();
    paramParcel.readTypedList(localAllInOne.contactArray, ProfileContactInfo.CREATOR);
    localAllInOne.chatAbility = paramParcel.readInt();
    localAllInOne.preWinUin = paramParcel.readString();
    localAllInOne.preWinType = paramParcel.readInt();
    localAllInOne.nickname = paramParcel.readString();
    localAllInOne.remark = paramParcel.readString();
    localAllInOne.alias = paramParcel.readString();
    localAllInOne.contactName = paramParcel.readString();
    localAllInOne.recommendName = paramParcel.readString();
    localAllInOne.troopNickName = paramParcel.readString();
    localAllInOne.circleName = paramParcel.readString();
    localAllInOne.lastActivity = paramParcel.readInt();
    localAllInOne.profileEntryType = paramParcel.readInt();
    localAllInOne.sourceID = paramParcel.readInt();
    localAllInOne.chatCookie = paramParcel.createByteArray();
    localAllInOne.chatEntrance = paramParcel.readInt();
    localAllInOne.encId = paramParcel.readString();
    localAllInOne.uid = paramParcel.readString();
    localAllInOne.likeSource = paramParcel.readLong();
    localAllInOne.subSourceId = paramParcel.readInt();
    localAllInOne.aioDistance = paramParcel.readString();
    localAllInOne.extras = ((Bundle)paramParcel.readParcelable(Bundle.class.getClassLoader()));
    localAllInOne.colorScreen = paramParcel.readInt();
    localAllInOne.reportExtra = ((Bundle)paramParcel.readParcelable(Bundle.class.getClassLoader()));
    localAllInOne.extendFriendVoiceCode = paramParcel.createByteArray();
    return localAllInOne;
  }
  
  public AllInOne[] newArray(int paramInt)
  {
    return new AllInOne[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.data.AllInOne.1
 * JD-Core Version:    0.7.0.1
 */