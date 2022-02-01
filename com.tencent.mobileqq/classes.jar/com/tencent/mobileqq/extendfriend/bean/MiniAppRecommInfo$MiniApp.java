package com.tencent.mobileqq.extendfriend.bean;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class MiniAppRecommInfo$MiniApp
  implements Parcelable
{
  public static final Parcelable.Creator<MiniApp> CREATOR = new MiniAppRecommInfo.MiniApp.1();
  public int a;
  public INTERFACE.StApiAppInfo a;
  public String a;
  public byte[] a;
  public String b;
  public String c;
  
  public MiniAppRecommInfo$MiniApp() {}
  
  protected MiniAppRecommInfo$MiniApp(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0) {}
    try
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
      paramParcel.readByteArray(this.jdField_a_of_type_ArrayOfByte);
      paramParcel = new INTERFACE.StApiAppInfo();
      paramParcel.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StApiAppInfo = paramParcel;
      return;
    }
    catch (Throwable paramParcel)
    {
      QLog.e("MiniAppRecommInfo", 1, "", paramParcel);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    if (this.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_ArrayOfByte.length;; paramInt = -1)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp
 * JD-Core Version:    0.7.0.1
 */