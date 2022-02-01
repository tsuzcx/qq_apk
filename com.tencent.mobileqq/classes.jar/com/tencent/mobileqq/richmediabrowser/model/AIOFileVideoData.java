package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import java.util.ArrayList;

public class AIOFileVideoData
  extends AIOBrowserBaseData
{
  public Bundle a;
  public String a;
  public ArrayList<String> a;
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
  public int g;
  public long g;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public boolean i;
  public boolean j = false;
  
  public AIOFileVideoData()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 0;
    this.jdField_g_of_type_Long = 0L;
  }
  
  public String a()
  {
    switch (this.status)
    {
    case 7: 
    default: 
      return "undefine";
    case 0: 
      return "Nomal";
    case 3: 
      return "Buffering";
    case 1: 
      return "Downloading";
    case 8: 
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
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
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
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */