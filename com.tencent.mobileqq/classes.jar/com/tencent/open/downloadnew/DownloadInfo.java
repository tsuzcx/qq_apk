package com.tencent.open.downloadnew;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bdcb;
import bexd;
import bfhg;
import bfhh;
import bfjz;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadInfo> CREATOR = new bfjz();
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
  public volatile int e;
  public String e;
  public boolean e;
  public volatile int f;
  public String f;
  public int g;
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
  public String m = "";
  public String n = "";
  public String o;
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "6000";
  public String u = "0";
  public String v = "0";
  public String w;
  public String x;
  public String y;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadInfo.class.getName();
  }
  
  public DownloadInfo()
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
  }
  
  public DownloadInfo(Parcel paramParcel)
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_AndroidContentIntent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.jdField_g_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label516;
      }
      bool1 = true;
      label311:
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.jdField_h_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label521;
      }
      bool1 = true;
      label341:
      this.jdField_c_of_type_Boolean = bool1;
      this.n = paramParcel.readString();
      this.jdField_i_of_type_Int = paramParcel.readInt();
      this.jdField_j_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.o = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label526;
      }
      bool1 = true;
      label395:
      this.jdField_d_of_type_Boolean = bool1;
      this.p = paramParcel.readString();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.q = paramParcel.readString();
      this.r = paramParcel.readString();
      this.s = paramParcel.readString();
      this.t = paramParcel.readString();
      this.u = paramParcel.readString();
      this.v = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label531;
      }
    }
    label516:
    label521:
    label526:
    label531:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_e_of_type_Boolean = bool1;
      this.jdField_k_of_type_Int = paramParcel.readInt();
      this.w = paramParcel.readString();
      this.x = paramParcel.readString();
      this.y = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label311;
      bool1 = false;
      break label341;
      bool1 = false;
      break label395;
    }
  }
  
  public DownloadInfo(String paramString1, String paramString2)
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, int paramInt1, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10, String paramString11, long paramLong2, boolean paramBoolean1, int paramInt4, String paramString12, int paramInt5, int paramInt6, String paramString13, boolean paramBoolean2, String paramString14, long paramLong3)
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString3;
    this.jdField_f_of_type_JavaLangString = paramString4;
    this.jdField_g_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_h_of_type_JavaLangString = paramString6;
    this.jdField_i_of_type_JavaLangString = paramString7;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_j_of_type_JavaLangString = paramString8;
    this.jdField_k_of_type_JavaLangString = paramString9;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.l = paramString10;
    this.m = paramString11;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_h_of_type_Int = paramInt4;
    this.n = paramString12;
    this.jdField_i_of_type_Int = paramInt5;
    this.jdField_j_of_type_Int = paramInt6;
    this.o = paramString13;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.p = paramString14;
    this.jdField_d_of_type_Long = paramLong3;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Intent paramIntent, String paramString6, boolean paramBoolean)
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString3;
    this.jdField_f_of_type_JavaLangString = paramString4;
    if (TextUtils.isEmpty(paramString2)) {}
    for (this.jdField_g_of_type_JavaLangString = ("_" + paramString1);; this.jdField_g_of_type_JavaLangString = ("_" + GlobalUtil.calcMD5AsString(paramString2)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Int = 1;
      this.jdField_h_of_type_JavaLangString = paramString5;
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.jdField_b_of_type_Long = 0L;
      this.m = paramString6;
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString + "_" + paramInt;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return bfhh.a(paramString);
  }
  
  private static String c(String paramString)
  {
    try
    {
      paramString = "" + bexd.a().a() + bdcb.a() + System.currentTimeMillis() + paramString;
      bfhg.b(jdField_a_of_type_JavaLangString, ">genUniqueId ori=" + paramString);
      paramString = bfhh.a(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "" + System.currentTimeMillis();
  }
  
  private void c()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (TextUtils.isEmpty(this.x))) {
      this.x = c(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public int a()
  {
    try
    {
      int i1 = this.jdField_e_of_type_Int;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.y)))
    {
      bfhg.b(jdField_a_of_type_JavaLangString, ">getExtParam empty params:" + paramString + "|" + this.y);
      return "";
    }
    try
    {
      Object localObject = new JSONObject(this.y);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString(paramString);
        bfhg.b(jdField_a_of_type_JavaLangString, ">getExtParam " + paramString + "=" + (String)localObject);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str = null;
        continue;
        str = "";
      }
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("state", this.jdField_e_of_type_Int);
      localJSONObject.put("pro", this.jdField_f_of_type_Int);
      localJSONObject.put("packagename", this.jdField_e_of_type_JavaLangString);
      localJSONObject.put("ismyapp", this.jdField_c_of_type_Int);
      localJSONObject.put("download_from", this.jdField_h_of_type_Int);
      localJSONObject.put("realDownloadType", this.jdField_d_of_type_Int);
      localJSONObject.put("via", this.jdField_h_of_type_JavaLangString);
      localJSONObject.put("writecodestate", this.jdField_j_of_type_Int);
      localJSONObject.put("extraInfo", this.o);
      localJSONObject.put("isAutoInstallBySDK", this.jdField_d_of_type_Boolean);
      localJSONObject.put("fileMd5", this.p);
      localJSONObject.put("fileSize", this.jdField_d_of_type_Long);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      bfhg.c(jdField_a_of_type_JavaLangString, "onNetworkConnect " + localJSONException.getMessage(), localJSONException);
    }
    return localJSONObject;
  }
  
  public void a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label45;
      }
      this.jdField_b_of_type_JavaLangString = b(this.jdField_d_of_type_JavaLangString);
      bfhg.b(jdField_a_of_type_JavaLangString, "gen ticket by urlStr");
    }
    for (;;)
    {
      c();
      return;
      label45:
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = b(this.jdField_i_of_type_JavaLangString);
        bfhg.b(jdField_a_of_type_JavaLangString, "gen ticket by urlPatch");
      }
      else if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_Int);
        bfhg.b(jdField_a_of_type_JavaLangString, "gen ticket by packageName & versionCode");
      }
      else
      {
        bfhg.e(jdField_a_of_type_JavaLangString, "bad download INFO!!!");
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_e_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    JSONObject localJSONObject1;
    if (TextUtils.isEmpty(this.y)) {
      localJSONObject1 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put(paramString1, paramString2);
        bfhg.b(jdField_a_of_type_JavaLangString, ">setExtParam " + paramString1 + "=" + paramString2);
        this.y = localJSONObject1.toString();
        return true;
      }
      catch (Exception paramString1)
      {
        JSONObject localJSONObject2;
        bfhg.c(jdField_a_of_type_JavaLangString, ">setExtParam failed:", paramString1);
      }
      try
      {
        localJSONObject1 = new JSONObject(this.y);
      }
      catch (JSONException localJSONException)
      {
        this.y = "";
        localJSONObject2 = new JSONObject();
      }
    }
    return false;
  }
  
  public void b()
  {
    this.x = "";
    a();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DownloadInfo [ticket=" + this.jdField_b_of_type_JavaLangString + ", uniqueId=" + this.x + ", state=" + this.jdField_e_of_type_Int + ", urlStr=" + this.jdField_d_of_type_JavaLangString + ", urlPatch=" + this.jdField_i_of_type_JavaLangString + ", packageName=" + this.jdField_e_of_type_JavaLangString + ", versionCode=" + this.jdField_b_of_type_Int + ", fileSize =" + this.jdField_d_of_type_Long + ", totalDataLength =" + this.jdField_c_of_type_Long + ", progress=" + this.jdField_f_of_type_Int + ", isAutoInstallBySDK =" + this.jdField_d_of_type_Boolean + ", isAutoInstall=" + this.jdField_a_of_type_Boolean + ", filePath=" + this.l + ", appId=" + this.jdField_c_of_type_JavaLangString + ", push_title=" + this.jdField_f_of_type_JavaLangString + ", sendTime=" + this.jdField_g_of_type_JavaLangString + ", time=" + this.jdField_a_of_type_Long + ", updateType=" + this.jdField_a_of_type_Int + ", myAppId=" + this.jdField_j_of_type_JavaLangString + ", apkId=" + this.jdField_k_of_type_JavaLangString + ", lastDownloadSize=" + this.jdField_b_of_type_Long + ", isApk=" + this.jdField_c_of_type_Boolean + ", iconUrl=" + this.n + ", isShowNotification=" + this.jdField_i_of_type_Int + ", writeCodeState=" + this.jdField_j_of_type_Int + ", extraInfo =" + this.o + ", fileMd5 =" + this.p + ", recommendId =" + this.q + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidContentIntent, paramInt);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.jdField_b_of_type_Boolean) {
        break label401;
      }
      b1 = 1;
      label195:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break label406;
      }
      b1 = 1;
      label225:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.n);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.o);
      if (!this.jdField_d_of_type_Boolean) {
        break label411;
      }
      b1 = 1;
      label279:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.p);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeString(this.q);
      paramParcel.writeString(this.r);
      paramParcel.writeString(this.s);
      paramParcel.writeString(this.t);
      paramParcel.writeString(this.u);
      paramParcel.writeString(this.v);
      if (!this.jdField_e_of_type_Boolean) {
        break label416;
      }
    }
    label401:
    label406:
    label411:
    label416:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeString(this.w);
      paramParcel.writeString(this.x);
      paramParcel.writeString(this.y);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label195;
      b1 = 0;
      break label225;
      b1 = 0;
      break label279;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */