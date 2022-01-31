package com.tencent.mobileqq.gallery.model.video;

import android.os.Parcel;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;

public class AIOFileVideoData
  extends GalleryBaseData
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
  public long f;
  public String f;
  public boolean f;
  public long g;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  
  public int a()
  {
    return 4;
  }
  
  public String a()
  {
    switch (this.jdField_e_of_type_Int)
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
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readString();
    this.a = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.model.video.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */