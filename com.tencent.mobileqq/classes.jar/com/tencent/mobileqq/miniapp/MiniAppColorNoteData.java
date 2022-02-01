package com.tencent.mobileqq.miniapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class MiniAppColorNoteData
  implements Parcelable
{
  public static final Parcelable.Creator<MiniAppColorNoteData> CREATOR = new MiniAppColorNoteData.1();
  public MiniAppInfo a;
  public String a;
  
  public MiniAppColorNoteData(Parcel paramParcel)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public MiniAppColorNoteData(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 0);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppColorNoteData
 * JD-Core Version:    0.7.0.1
 */