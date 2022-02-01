package com.tencent.mobileqq.litelivesdk.api.business;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.ilive.LiveConfig.SDKType;
import java.util.HashMap;

public class BusinessConfig
  implements Parcelable
{
  public static final Parcelable.Creator<BusinessConfig> CREATOR = new BusinessConfig.1();
  public int a;
  public String a;
  public HashMap<String, String> a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  
  public BusinessConfig()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  protected BusinessConfig(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      return;
      bool = false;
    }
  }
  
  public LiveConfig.SDKType a()
  {
    if (this.jdField_e_of_type_Int == 0) {
      return LiveConfig.SDKType.AUDIENCE;
    }
    if (this.jdField_e_of_type_Int == 1) {
      return LiveConfig.SDKType.ANCHOR;
    }
    return LiveConfig.SDKType.FULL;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig
 * JD-Core Version:    0.7.0.1
 */