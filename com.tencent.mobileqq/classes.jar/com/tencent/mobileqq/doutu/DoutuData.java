package com.tencent.mobileqq.doutu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;

public class DoutuData
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<DoutuData> CREATOR = new DoutuData.1();
  public String picDownUrl;
  public int picHeight;
  public String picMd5;
  public long picSize;
  @notColumn
  public int picType = 1;
  public int picWidth;
  public String suppliersName;
  public String thumbDownUrl;
  public int thumbHeight;
  public String thumbMd5;
  public long thumbSize;
  public int thumbWidth;
  
  public DoutuData() {}
  
  public DoutuData(Parcel paramParcel)
  {
    this.picMd5 = paramParcel.readString();
    this.picSize = paramParcel.readLong();
    this.picHeight = paramParcel.readInt();
    this.picWidth = paramParcel.readInt();
    this.picDownUrl = paramParcel.readString();
    this.thumbMd5 = paramParcel.readString();
    this.thumbSize = paramParcel.readLong();
    this.thumbHeight = paramParcel.readInt();
    this.thumbWidth = paramParcel.readInt();
    this.thumbDownUrl = paramParcel.readString();
    this.suppliersName = paramParcel.readString();
    this.picType = paramParcel.readInt();
  }
  
  public DoutuData(String paramString1, String paramString2)
  {
    this.picMd5 = paramString1;
    this.thumbDownUrl = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.picMd5);
    paramParcel.writeLong(this.picSize);
    paramParcel.writeInt(this.picHeight);
    paramParcel.writeInt(this.picWidth);
    paramParcel.writeString(this.picDownUrl);
    paramParcel.writeString(this.thumbMd5);
    paramParcel.writeLong(this.thumbSize);
    paramParcel.writeInt(this.thumbHeight);
    paramParcel.writeInt(this.thumbWidth);
    paramParcel.writeString(this.thumbDownUrl);
    paramParcel.writeString(this.suppliersName);
    paramParcel.writeInt(this.picType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuData
 * JD-Core Version:    0.7.0.1
 */