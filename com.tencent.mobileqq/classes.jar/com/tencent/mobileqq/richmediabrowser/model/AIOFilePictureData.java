package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class AIOFilePictureData
  extends AIOBrowserBaseData
{
  public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new AIOFilePictureData.1();
  public int j;
  public String k = "I:N";
  public String l = "I:N";
  public String m = "I:N";
  public String n = "I:N";
  public boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public boolean r = false;
  public long s = 0L;
  public boolean t = false;
  public int u;
  public String v;
  public String w;
  public int x;
  public int y;
  public int z;
  
  public int getType()
  {
    return 102;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.j = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.u = paramParcel.readInt();
    this.r = Boolean.valueOf(paramParcel.readString()).booleanValue();
    String str = paramParcel.readString();
    if (str == null) {
      str = "0";
    }
    this.s = Long.valueOf(str).longValue();
    this.t = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readInt();
  }
  
  public void updateProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void updateStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.u);
    paramParcel.writeString(String.valueOf(this.r));
    paramParcel.writeString(String.valueOf(this.s));
    paramParcel.writeString(String.valueOf(this.t));
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData
 * JD-Core Version:    0.7.0.1
 */