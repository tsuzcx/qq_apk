package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;

public class AIOFileVideoData
  extends AIOBrowserBaseData
{
  public String a;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public boolean i;
  public String j;
  public boolean j;
  public String k;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  
  public String a()
  {
    switch (this.status)
    {
    default: 
      return "undefine";
    case 0: 
      return "Nomal";
    case 3: 
      return "Buffering";
    case 1: 
      return "Downloading";
    case 7: 
      return "Error";
    case 4: 
      return "Get URL";
    case 6: 
      return "Pause";
    case 5: 
      return "Playing";
    }
    return "Saving";
  }
  
  public int getType()
  {
    return 103;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.b = paramParcel.readString();
    this.a = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
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
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */