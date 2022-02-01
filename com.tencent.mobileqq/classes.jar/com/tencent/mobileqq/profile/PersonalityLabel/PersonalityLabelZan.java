package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import tencent.im.label.comm.PersonalityTagComm.PraiseUserInfo;

public class PersonalityLabelZan
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PersonalityLabelZan> CREATOR = new PersonalityLabelZan.1();
  public static final String TAG = "PersonalityLabelPhoto";
  String nick;
  long uin;
  
  public PersonalityLabelZan()
  {
    this.uin = 0L;
    this.nick = "";
  }
  
  protected PersonalityLabelZan(Parcel paramParcel)
  {
    paramParcel.readInt();
    this.uin = paramParcel.readLong();
    this.nick = paramParcel.readString();
  }
  
  public static PersonalityLabelZan convertFromPb(PersonalityTagComm.PraiseUserInfo paramPraiseUserInfo)
  {
    PersonalityLabelZan localPersonalityLabelZan = new PersonalityLabelZan();
    if (paramPraiseUserInfo.uint64_praise_uin.has()) {
      localPersonalityLabelZan.uin = paramPraiseUserInfo.uint64_praise_uin.get();
    }
    if (paramPraiseUserInfo.str_nick.has()) {
      localPersonalityLabelZan.nick = paramPraiseUserInfo.str_nick.get();
    }
    return localPersonalityLabelZan;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:").append(this.uin).append("|");
    localStringBuilder.append("nick:").append(this.nick).append("|");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ProfilePersonalityLabelInfo.CURRENT_VERSION);
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.nick);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelZan
 * JD-Core Version:    0.7.0.1
 */