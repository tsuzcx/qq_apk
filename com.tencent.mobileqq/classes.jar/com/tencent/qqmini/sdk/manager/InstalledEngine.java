package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import belh;
import betc;
import betm;
import beur;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class InstalledEngine
  implements Parcelable, Comparable<InstalledEngine>
{
  public static final Parcelable.Creator<InstalledEngine> CREATOR = new beur();
  public int a;
  public EngineVersion a;
  public String a;
  public boolean a;
  public volatile int b;
  public String b;
  public boolean b;
  
  public InstalledEngine()
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public int a(InstalledEngine paramInstalledEngine)
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion.a(paramInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion);
  }
  
  @Deprecated
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      belh.a(this.jdField_b_of_type_JavaLangString, false);
      betm.a().edit().remove(this.jdField_b_of_type_JavaLangString).apply();
    }
    betc.b("InstalledEngine", "[MiniEng] delete engine " + this + ", pName=" + MiniAppEnv.g().getContext().getPackageName());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "InstalledEngine{engineDir=" + this.jdField_b_of_type_JavaLangString + ", engineName=" + this.jdField_a_of_type_JavaLangString + ", engineVersion=" + this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion + ", engineType=" + this.jdField_a_of_type_Int + ", isVerify=" + this.jdField_a_of_type_Boolean + ", isPersist=" + this.jdField_b_of_type_Boolean + ", loadStatus=" + this.jdField_b_of_type_Int + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion, 0);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label79;
      }
    }
    label79:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.InstalledEngine
 * JD-Core Version:    0.7.0.1
 */