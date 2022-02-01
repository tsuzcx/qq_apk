package com.tencent.open.downloadnew;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadInfo> CREATOR = new DownloadInfo.1();
  protected static final String a = "com.tencent.open.downloadnew.DownloadInfo";
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
  protected volatile int e;
  public String e;
  public boolean e;
  public volatile int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  
  public DownloadInfo()
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.l = "";
    this.m = "";
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.n = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.o = null;
    this.jdField_d_of_type_Boolean = false;
    this.p = "";
    this.jdField_d_of_type_Long = 0L;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "6000";
    this.u = "0";
    this.v = "0";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  protected DownloadInfo(Parcel paramParcel)
  {
    this.jdField_g_of_type_JavaLangString = "";
    boolean bool2 = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.l = "";
    this.m = "";
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.n = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.o = null;
    this.jdField_d_of_type_Boolean = false;
    this.p = "";
    this.jdField_d_of_type_Long = 0L;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "6000";
    this.u = "0";
    this.v = "0";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
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
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    this.n = paramParcel.readString();
    this.jdField_i_of_type_Int = paramParcel.readInt();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.o = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_d_of_type_Boolean = bool1;
    this.p = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
    this.t = paramParcel.readString();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_e_of_type_Boolean = bool1;
    this.jdField_k_of_type_Int = paramParcel.readInt();
    this.w = paramParcel.readString();
    this.x = paramParcel.readString();
    this.y = paramParcel.readString();
  }
  
  public DownloadInfo(String paramString1, String paramString2)
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.l = "";
    this.m = "";
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.n = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.o = null;
    this.jdField_d_of_type_Boolean = false;
    this.p = "";
    this.jdField_d_of_type_Long = 0L;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "6000";
    this.u = "0";
    this.v = "0";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, int paramInt1, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10, String paramString11, long paramLong2, boolean paramBoolean1, int paramInt4, String paramString12, int paramInt5, int paramInt6, String paramString13, boolean paramBoolean2, String paramString14, long paramLong3)
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.l = "";
    this.m = "";
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.n = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.o = null;
    this.jdField_d_of_type_Boolean = false;
    this.p = "";
    this.jdField_d_of_type_Long = 0L;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "6000";
    this.u = "0";
    this.v = "0";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
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
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
    this.l = "";
    this.m = "";
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.n = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.o = null;
    this.jdField_d_of_type_Boolean = false;
    this.p = "";
    this.jdField_d_of_type_Long = 0L;
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "6000";
    this.u = "0";
    this.v = "0";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString3;
    this.jdField_f_of_type_JavaLangString = paramString4;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("_");
      paramString2.append(paramString1);
      this.jdField_g_of_type_JavaLangString = paramString2.toString();
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("_");
      paramString1.append(GlobalUtil.calcMD5AsString(paramString2));
      this.jdField_g_of_type_JavaLangString = paramString1.toString();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Int = 1;
    this.jdField_h_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_b_of_type_Long = 0L;
    this.m = paramString6;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return MD5.a(paramString);
  }
  
  private static String c(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(CommonDataAdapter.a().a());
      ((StringBuilder)localObject).append(DeviceInfoUtil.a());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">genUniqueId ori=");
      localStringBuilder.append(paramString);
      LogUtility.b((String)localObject, localStringBuilder.toString());
      paramString = MD5.a(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label93:
      break label93;
    }
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(System.currentTimeMillis());
    return paramString.toString();
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
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if ((!bool) && (!TextUtils.isEmpty(this.y))) {
      localObject1 = null;
    }
    try
    {
      localObject2 = new JSONObject(this.y);
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      label45:
      break label45;
    }
    if (localObject1 != null) {
      str = ((JSONObject)localObject1).optString(paramString);
    }
    Object localObject1 = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">getExtParam ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("=");
    ((StringBuilder)localObject2).append(str);
    LogUtility.b((String)localObject1, ((StringBuilder)localObject2).toString());
    return str;
    str = jdField_a_of_type_JavaLangString;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(">getExtParam empty params:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(this.y);
    LogUtility.b(str, ((StringBuilder)localObject1).toString());
    return "";
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
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkConnect ");
      localStringBuilder.append(localJSONException.getMessage());
      LogUtility.c(str, localStringBuilder.toString(), localJSONException);
    }
    return localJSONObject;
  }
  
  public void a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = b(this.jdField_d_of_type_JavaLangString);
        LogUtility.b(jdField_a_of_type_JavaLangString, "gen ticket by urlStr");
      }
      else if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = b(this.jdField_i_of_type_JavaLangString);
        LogUtility.b(jdField_a_of_type_JavaLangString, "gen ticket by urlPatch");
      }
      else if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_Int);
        LogUtility.b(jdField_a_of_type_JavaLangString, "gen ticket by packageName & versionCode");
      }
      else
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "bad download INFO!!!");
      }
    }
    c();
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (TextUtils.isEmpty(this.y)) {
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject = new JSONObject(this.y);
    }
    catch (JSONException localJSONException)
    {
      label52:
      break label52;
    }
    this.y = "";
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString1, paramString2);
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">setExtParam ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString2);
      LogUtility.b(str, localStringBuilder.toString());
      this.y = localJSONObject.toString();
      return true;
    }
    catch (Exception paramString1)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, ">setExtParam failed:", paramString1);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadInfo [ticket=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", source =");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", uniqueId=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", urlStr=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", urlPatch=");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append(", packageName=");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", fileSize =");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", totalDataLength =");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", isAutoInstallBySDK =");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", isAutoInstall=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", filePath=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", push_title=");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(", sendTime=");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", updateType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", myAppId=");
    localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append(", apkId=");
    localStringBuilder.append(this.jdField_k_of_type_JavaLangString);
    localStringBuilder.append(", lastDownloadSize=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", isApk=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", iconUrl=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", isShowNotification=");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append(", writeCodeState=");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    localStringBuilder.append(", extraInfo =");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", fileMd5 =");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", recommendId =");
    localStringBuilder.append(this.q);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */