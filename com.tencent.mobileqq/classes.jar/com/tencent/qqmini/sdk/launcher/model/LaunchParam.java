package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import berc;
import java.util.HashMap;
import java.util.Map;

public class LaunchParam
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParam> CREATOR = new berc();
  public int a;
  public long a;
  public EntryModel a;
  public MiniAppInfo a;
  public String a;
  public Map<String, String> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public LaunchParam()
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    paramParcel.readMap(this.jdField_a_of_type_JavaUtilMap, Map.class.getClassLoader());
    this.d = paramParcel.readString();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = ((EntryModel)paramParcel.readParcelable(EntryModel.class.getClassLoader()));
    this.jdField_b_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramLaunchParam.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramLaunchParam.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramLaunchParam.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramLaunchParam.jdField_c_of_type_JavaLangString;
    this.e = paramLaunchParam.e;
    this.f = paramLaunchParam.f;
    this.jdField_b_of_type_Long = paramLaunchParam.jdField_b_of_type_Long;
    this.jdField_c_of_type_Int = paramLaunchParam.jdField_c_of_type_Int;
    this.jdField_a_of_type_Long = paramLaunchParam.jdField_a_of_type_Long;
    this.h = paramLaunchParam.h;
    this.i = paramLaunchParam.i;
    this.jdField_a_of_type_JavaUtilMap = paramLaunchParam.jdField_a_of_type_JavaUtilMap;
    this.d = paramLaunchParam.d;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = paramLaunchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel;
    this.jdField_b_of_type_Int = paramLaunchParam.jdField_b_of_type_Int;
    this.jdField_a_of_type_Boolean = paramLaunchParam.jdField_a_of_type_Boolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("LaunchParam{scene=").append(this.jdField_a_of_type_Int).append(", miniAppId='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", extraKey='").append(this.jdField_b_of_type_JavaLangString).append('\'').append(", entryPath='").append(this.jdField_c_of_type_JavaLangString).append('\'').append(", extendData='").append(this.d).append('\'').append(", navigateExtData='").append(this.e).append('\'').append(", fromMiniAppId='").append(this.f).append('\'').append(", fakeUrl='").append(this.g).append('\'').append(", timestamp=").append(this.jdField_a_of_type_Long).append(", launchClickTimeMillis=").append(this.jdField_b_of_type_Long).append(", tempState=").append(this.jdField_c_of_type_Int).append(", shareTicket=").append(this.h).append(", envVersion=").append(this.i).append(", reportData=");
    if (this.jdField_a_of_type_JavaUtilMap != null) {}
    for (int k = this.jdField_a_of_type_JavaUtilMap.size();; k = 0) {
      return k + ", fromBackToMiniApp=" + this.jdField_b_of_type_Int + '}';
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel, paramInt);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.LaunchParam
 * JD-Core Version:    0.7.0.1
 */