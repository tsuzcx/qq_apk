package com.tencent.mobileqq.profilecard.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Arrays;

public class AllInOne
  implements Parcelable
{
  public static final Parcelable.Creator<AllInOne> CREATOR = new AllInOne.1();
  public int age = -1;
  public String aioDistance;
  public String alias;
  public boolean bindQQ;
  public int chatAbility;
  public byte[] chatCookie;
  public int chatEntrance = 0;
  public String circleName;
  public int colorScreen;
  public byte constellation = 0;
  public ArrayList<ProfileContactInfo> contactArray;
  public String contactName;
  public String discussUin;
  public String distanceTime;
  public String encId = "";
  public byte[] extendFriendVoiceCode;
  public Bundle extras = new Bundle();
  public short faceId = -1;
  public byte gender = -1;
  public int lastActivity = 0;
  public long likeSource = 0L;
  public byte maritalStatus = 0;
  public String nickname;
  public int pa;
  public int preWinType = -1;
  public String preWinUin = "";
  public int professionId = 0;
  public int profileEntryType = 999;
  public String recommendName;
  public String remark;
  public Bundle reportExtra = new Bundle();
  public int sourceID;
  public int subSourceId;
  public String troopCode;
  public String troopNickName;
  public String troopUin;
  public String uid = "";
  public String uin;
  
  private AllInOne() {}
  
  public AllInOne(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.pa = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AllInOne{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pa=");
    localStringBuilder.append(this.pa);
    localStringBuilder.append(", profileEntryType=");
    localStringBuilder.append(this.profileEntryType);
    localStringBuilder.append(", sourceID=");
    localStringBuilder.append(this.sourceID);
    localStringBuilder.append(", subSourceId=");
    localStringBuilder.append(this.subSourceId);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.age);
    localStringBuilder.append(", gender=");
    localStringBuilder.append(this.gender);
    localStringBuilder.append(", faceId=");
    localStringBuilder.append(this.faceId);
    localStringBuilder.append(", maritalStatus=");
    localStringBuilder.append(this.maritalStatus);
    localStringBuilder.append(", professionId=");
    localStringBuilder.append(this.professionId);
    localStringBuilder.append(", constellation=");
    localStringBuilder.append(this.constellation);
    localStringBuilder.append(", distanceTime='");
    localStringBuilder.append(this.distanceTime);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopCode='");
    localStringBuilder.append(this.troopCode);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopUin='");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", discussUin='");
    localStringBuilder.append(this.discussUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contactArray=");
    localStringBuilder.append(this.contactArray);
    localStringBuilder.append(", chatAbility=");
    localStringBuilder.append(this.chatAbility);
    localStringBuilder.append(", preWinUin='");
    localStringBuilder.append(this.preWinUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", preWinType=");
    localStringBuilder.append(this.preWinType);
    localStringBuilder.append(", colorScreen=");
    localStringBuilder.append(this.colorScreen);
    localStringBuilder.append(", nickname='");
    localStringBuilder.append(this.nickname);
    localStringBuilder.append('\'');
    localStringBuilder.append(", remark='");
    localStringBuilder.append(this.remark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", alias='");
    localStringBuilder.append(this.alias);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contactName='");
    localStringBuilder.append(this.contactName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommendName='");
    localStringBuilder.append(this.recommendName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopNickName='");
    localStringBuilder.append(this.troopNickName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", circleName='");
    localStringBuilder.append(this.circleName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastActivity=");
    localStringBuilder.append(this.lastActivity);
    localStringBuilder.append(", chatCookie=");
    localStringBuilder.append(Arrays.toString(this.chatCookie));
    localStringBuilder.append(", chatEntrance=");
    localStringBuilder.append(this.chatEntrance);
    localStringBuilder.append(", encId='");
    localStringBuilder.append(this.encId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.uid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", likeSource=");
    localStringBuilder.append(this.likeSource);
    localStringBuilder.append(", bindQQ=");
    localStringBuilder.append(this.bindQQ);
    localStringBuilder.append(", aioDistance='");
    localStringBuilder.append(this.aioDistance);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extendFriendVoiceCode=");
    localStringBuilder.append(Arrays.toString(this.extendFriendVoiceCode));
    localStringBuilder.append(", reportExtra=");
    localStringBuilder.append(this.reportExtra);
    localStringBuilder.append(", extras=");
    localStringBuilder.append(this.extras);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.pa);
    paramParcel.writeInt(this.age);
    paramParcel.writeByte(this.gender);
    paramParcel.writeInt(this.faceId);
    paramParcel.writeByte(this.maritalStatus);
    paramParcel.writeInt(this.professionId);
    paramParcel.writeByte(this.constellation);
    paramParcel.writeString(this.distanceTime);
    paramParcel.writeString(this.troopCode);
    paramParcel.writeString(this.troopUin);
    paramParcel.writeString(this.discussUin);
    paramParcel.writeTypedList(this.contactArray);
    paramParcel.writeInt(this.chatAbility);
    paramParcel.writeString(this.preWinUin);
    paramParcel.writeInt(this.preWinType);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.remark);
    paramParcel.writeString(this.alias);
    paramParcel.writeString(this.contactName);
    paramParcel.writeString(this.recommendName);
    paramParcel.writeString(this.troopNickName);
    paramParcel.writeString(this.circleName);
    paramParcel.writeInt(this.lastActivity);
    paramParcel.writeInt(this.profileEntryType);
    paramParcel.writeInt(this.sourceID);
    paramParcel.writeByteArray(this.chatCookie);
    paramParcel.writeInt(this.chatEntrance);
    paramParcel.writeString(this.encId);
    paramParcel.writeString(this.uid);
    paramParcel.writeLong(this.likeSource);
    paramParcel.writeInt(this.subSourceId);
    paramParcel.writeString(this.aioDistance);
    paramParcel.writeParcelable(this.extras, paramInt);
    paramParcel.writeInt(this.colorScreen);
    paramParcel.writeParcelable(this.reportExtra, paramInt);
    paramParcel.writeByteArray(this.extendFriendVoiceCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.data.AllInOne
 * JD-Core Version:    0.7.0.1
 */