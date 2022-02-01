package com.tencent.mobileqq.data.troop;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class TroopClipPic
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<TroopClipPic> CREATOR = new TroopClipPic.1();
  public String clipInfo;
  public String id;
  public long ts;
  public int type = 0;
  
  public TroopClipPic() {}
  
  protected TroopClipPic(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.clipInfo = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.ts = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(" type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(" clip=");
    localStringBuilder.append(this.clipInfo);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.clipInfo);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.ts);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopClipPic
 * JD-Core Version:    0.7.0.1
 */