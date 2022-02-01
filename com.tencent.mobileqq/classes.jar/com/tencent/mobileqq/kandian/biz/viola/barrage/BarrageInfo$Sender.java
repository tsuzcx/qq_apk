package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BarrageInfo$Sender
  implements Parcelable
{
  public static final Parcelable.Creator<Sender> CREATOR = new BarrageInfo.Sender.1();
  public String a;
  public String b;
  public String c;
  public boolean d;
  
  public BarrageInfo$Sender() {}
  
  protected BarrageInfo$Sender(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.d = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sender{avatarUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", avatarIconUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAuthor='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageInfo.Sender
 * JD-Core Version:    0.7.0.1
 */