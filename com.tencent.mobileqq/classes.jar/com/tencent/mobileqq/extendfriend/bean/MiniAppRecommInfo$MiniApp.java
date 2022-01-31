package com.tencent.mobileqq.extendfriend.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqco;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class MiniAppRecommInfo$MiniApp
  implements Parcelable
{
  public static final Parcelable.Creator<MiniApp> CREATOR = new aqco();
  public int a;
  public MiniAppInfo a;
  public String a;
  public String b;
  public String c;
  
  public MiniAppRecommInfo$MiniApp() {}
  
  public MiniAppRecommInfo$MiniApp(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
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
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp
 * JD-Core Version:    0.7.0.1
 */