package com.tencent.mobileqq.qqlive.data.gift;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mqq.util.LogUtil;

public class GiftMessage
  implements Parcelable
{
  public static final Parcelable.Creator<GiftMessage> CREATOR = new GiftMessage.1();
  public int allComboCnt = 0;
  public boolean comboOver = false;
  public long comboSeq = 0L;
  public int effectLevel;
  public int giftID;
  public String giftName = "";
  public int giftNum;
  public int giftType;
  public int materialID;
  public long receiver = 0L;
  public String receiverHead = "";
  public String receiverNick = "";
  public long sender;
  public String senderHead;
  public String senderNick = "";
  
  public GiftMessage() {}
  
  protected GiftMessage(Parcel paramParcel)
  {
    this.giftType = paramParcel.readInt();
    this.giftID = paramParcel.readInt();
    this.giftNum = paramParcel.readInt();
    this.sender = paramParcel.readLong();
    this.senderNick = paramParcel.readString();
    this.materialID = paramParcel.readInt();
    this.effectLevel = paramParcel.readInt();
    this.giftName = paramParcel.readString();
    this.senderHead = paramParcel.readString();
    this.receiverNick = paramParcel.readString();
    this.receiverHead = paramParcel.readString();
    this.comboSeq = paramParcel.readLong();
    this.allComboCnt = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("GiftMessage{giftType=");
    localStringBuilder1.append(this.giftType);
    localStringBuilder1.append(", giftID=");
    localStringBuilder1.append(this.giftID);
    localStringBuilder1.append(", giftNum=");
    localStringBuilder1.append(this.giftNum);
    localStringBuilder1.append(", sender=");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.sender);
    localStringBuilder2.append("");
    localStringBuilder1.append(LogUtil.getSafePrintUin(localStringBuilder2.toString()));
    localStringBuilder1.append(", senderNick='");
    localStringBuilder1.append(this.senderNick);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", materialID=");
    localStringBuilder1.append(this.materialID);
    localStringBuilder1.append(", effectLevel=");
    localStringBuilder1.append(this.effectLevel);
    localStringBuilder1.append(", giftName='");
    localStringBuilder1.append(this.giftName);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", senderHead='");
    localStringBuilder1.append(this.senderHead);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", receiverNick='");
    localStringBuilder1.append(this.receiverNick);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", receiverHead='");
    localStringBuilder1.append(this.receiverHead);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", comboSeq=");
    localStringBuilder1.append(this.comboSeq);
    localStringBuilder1.append(", allComboCnt=");
    localStringBuilder1.append(this.allComboCnt);
    localStringBuilder1.append(", receiver=");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.receiver);
    localStringBuilder2.append("");
    localStringBuilder1.append(LogUtil.getSafePrintUin(localStringBuilder2.toString()));
    localStringBuilder1.append(", comboOver=");
    localStringBuilder1.append(this.comboOver);
    localStringBuilder1.append('}');
    return localStringBuilder1.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.giftType);
    paramParcel.writeInt(this.giftID);
    paramParcel.writeInt(this.giftNum);
    paramParcel.writeLong(this.sender);
    paramParcel.writeString(this.senderNick);
    paramParcel.writeInt(this.materialID);
    paramParcel.writeInt(this.effectLevel);
    paramParcel.writeString(this.giftName);
    paramParcel.writeString(this.senderHead);
    paramParcel.writeString(this.receiverNick);
    paramParcel.writeString(this.receiverHead);
    paramParcel.writeLong(this.comboSeq);
    paramParcel.writeInt(this.allComboCnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.gift.GiftMessage
 * JD-Core Version:    0.7.0.1
 */