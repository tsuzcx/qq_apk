package com.tencent.mobileqq.doutu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import arzu;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;

public class DoutuData
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<DoutuData> CREATOR = new arzu();
  public String pic_down_url;
  public int pic_height;
  public String pic_md5;
  public long pic_size;
  @notColumn
  public int pic_type = 1;
  public int pic_width;
  public String suppliers_name;
  public String thumb_down_url;
  public int thumb_height;
  public String thumb_md5;
  public long thumb_size;
  public int thumb_width;
  
  public DoutuData() {}
  
  public DoutuData(Parcel paramParcel)
  {
    this.pic_md5 = paramParcel.readString();
    this.pic_size = paramParcel.readLong();
    this.pic_height = paramParcel.readInt();
    this.pic_width = paramParcel.readInt();
    this.pic_down_url = paramParcel.readString();
    this.thumb_md5 = paramParcel.readString();
    this.thumb_size = paramParcel.readLong();
    this.thumb_height = paramParcel.readInt();
    this.thumb_width = paramParcel.readInt();
    this.thumb_down_url = paramParcel.readString();
    this.suppliers_name = paramParcel.readString();
    this.pic_type = paramParcel.readInt();
  }
  
  public DoutuData(String paramString1, String paramString2)
  {
    this.pic_md5 = paramString1;
    this.thumb_down_url = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pic_md5);
    paramParcel.writeLong(this.pic_size);
    paramParcel.writeInt(this.pic_height);
    paramParcel.writeInt(this.pic_width);
    paramParcel.writeString(this.pic_down_url);
    paramParcel.writeString(this.thumb_md5);
    paramParcel.writeLong(this.thumb_size);
    paramParcel.writeInt(this.thumb_height);
    paramParcel.writeInt(this.thumb_width);
    paramParcel.writeString(this.thumb_down_url);
    paramParcel.writeString(this.suppliers_name);
    paramParcel.writeInt(this.pic_type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuData
 * JD-Core Version:    0.7.0.1
 */