package com.tencent.open.wadl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bckm;

public class WadlJsBridgeDownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WadlJsBridgeDownloadInfo> CREATOR = new bckm();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public volatile int e;
  public String e;
  public volatile int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public String j = "";
  public String k = "";
  public String l = "";
  public String m;
  
  public WadlJsBridgeDownloadInfo()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 2;
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_g_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DownloadInfo [appId=" + this.jdField_a_of_type_JavaLangString + ", urlStr=" + this.jdField_b_of_type_JavaLangString + ", packageName=" + this.jdField_c_of_type_JavaLangString + ", push_title=" + this.jdField_d_of_type_JavaLangString + ", sendTime=" + this.jdField_e_of_type_JavaLangString + ", progress=" + this.jdField_f_of_type_Int + ", time=" + this.jdField_a_of_type_Long + ", filePath=" + this.j + ", state=" + this.jdField_e_of_type_Int + ", urlPatch=" + this.jdField_g_of_type_JavaLangString + ", updateType=" + this.jdField_a_of_type_Int + ", myAppId=" + this.jdField_h_of_type_JavaLangString + ", apkId=" + this.jdField_a_of_type_Int + ", versionCode=" + this.jdField_b_of_type_Int + ", lastDownloadSize=" + this.jdField_b_of_type_Long + ", isApk=" + this.jdField_b_of_type_Boolean + ", iconUrl=" + this.l + ", isShowNotification=" + this.jdField_h_of_type_Int + ", writeCodeState=" + this.i + ", extraInfo =" + this.m + ", isAutoInstallBySDK =" + this.jdField_c_of_type_Boolean + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int n = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    if (this.jdField_b_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.l);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeInt(this.i);
      paramParcel.writeString(this.m);
      if (!this.jdField_c_of_type_Boolean) {
        break label174;
      }
    }
    label174:
    for (paramInt = n;; paramInt = 0)
    {
      paramParcel.writeInt((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeDownloadInfo
 * JD-Core Version:    0.7.0.1
 */