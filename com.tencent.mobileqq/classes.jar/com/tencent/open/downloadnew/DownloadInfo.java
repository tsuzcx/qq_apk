package com.tencent.open.downloadnew;

import algo;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.open.base.LogUtility;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new algo();
  protected static final String a;
  public int a;
  public long a;
  public Intent a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public volatile int f;
  public String f;
  public volatile int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public String l = "";
  public String m;
  public String n = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadInfo.class.getName();
  }
  
  public DownloadInfo()
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_i_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_k_of_type_Int = -1;
  }
  
  public DownloadInfo(String paramString1, String paramString2)
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_i_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_k_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, int paramInt1, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10, int paramInt4, long paramLong2, boolean paramBoolean1, int paramInt5, String paramString11, int paramInt6, int paramInt7, String paramString12, boolean paramBoolean2, String paramString13, long paramLong3)
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_i_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_k_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.jdField_f_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_g_of_type_JavaLangString = paramString6;
    this.h = paramString7;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_i_of_type_JavaLangString = paramString8;
    this.jdField_j_of_type_JavaLangString = paramString9;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_k_of_type_JavaLangString = paramString10;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_i_of_type_Int = paramInt5;
    this.l = paramString11;
    this.jdField_j_of_type_Int = paramInt6;
    this.jdField_k_of_type_Int = paramInt7;
    this.m = paramString12;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.n = paramString13;
    this.jdField_d_of_type_Long = paramLong3;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_i_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_k_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.jdField_f_of_type_JavaLangString = ("_" + paramString1);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    try
    {
      int i1 = this.jdField_f_of_type_Int;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("state", this.jdField_f_of_type_Int);
      localJSONObject.put("pro", this.jdField_g_of_type_Int);
      localJSONObject.put("packagename", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("ismyapp", this.jdField_c_of_type_Int);
      localJSONObject.put("download_from", this.jdField_i_of_type_Int);
      localJSONObject.put("realDownloadType", this.jdField_d_of_type_Int);
      localJSONObject.put("via", this.jdField_g_of_type_JavaLangString);
      localJSONObject.put("writecodestate", this.jdField_k_of_type_Int);
      localJSONObject.put("extraInfo", this.m);
      localJSONObject.put("isAutoInstallBySDK", this.jdField_d_of_type_Boolean);
      localJSONObject.put("fileMd5", this.n);
      localJSONObject.put("fileSize", this.jdField_d_of_type_Long);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "onNetworkConnect " + localJSONException.getMessage(), localJSONException);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_f_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DownloadInfo [appId=" + this.jdField_b_of_type_JavaLangString + ", urlStr=" + this.jdField_c_of_type_JavaLangString + ", packageName=" + this.jdField_d_of_type_JavaLangString + ", push_title=" + this.jdField_e_of_type_JavaLangString + ", sendTime=" + this.jdField_f_of_type_JavaLangString + ", progress=" + this.jdField_g_of_type_Int + ", time=" + this.jdField_a_of_type_Long + ", filePath=" + this.jdField_k_of_type_JavaLangString + ", state=" + this.jdField_f_of_type_Int + ", urlPatch=" + this.h + ", updateType=" + this.jdField_a_of_type_Int + ", myAppId=" + this.jdField_i_of_type_JavaLangString + ", apkId=" + this.jdField_a_of_type_Int + ", versionCode=" + this.jdField_b_of_type_Int + ", lastDownloadSize=" + this.jdField_b_of_type_Long + ", isApk=" + this.jdField_c_of_type_Boolean + ", iconUrl=" + this.l + ", isShowNotification=" + this.jdField_j_of_type_Int + ", writeCodeState=" + this.jdField_k_of_type_Int + ", extraInfo =" + this.m + ", isAutoInstallBySDK =" + this.jdField_d_of_type_Boolean + ", fileMd5 =" + this.n + ", fileSize =" + this.jdField_d_of_type_Long + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    if (this.jdField_c_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.l);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeString(this.m);
      if (!this.jdField_d_of_type_Boolean) {
        break label190;
      }
    }
    label190:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt((byte)paramInt);
      paramParcel.writeString(this.n);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */