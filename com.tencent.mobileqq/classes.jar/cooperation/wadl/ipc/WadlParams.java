package cooperation.wadl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bkad;
import bnyl;
import java.util.HashMap;
import org.json.JSONObject;

public class WadlParams
  implements Parcelable
{
  public static final Parcelable.Creator<WadlParams> CREATOR = new bnyl();
  static HashMap<Integer, String> a;
  public int a;
  public long a;
  public String a;
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
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), "doDownloadAction");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "doPauseAction");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), "doCancelAction");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), "doResumeAction");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), "doInstallAction");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "doUpdateAction");
  }
  
  public WadlParams()
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
  }
  
  public WadlParams(String paramString)
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString);
    }
  }
  
  public WadlParams(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_f_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  private String a(int paramInt)
  {
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 4)) {
      return paramString1 + "_" + paramInt1 + "_" + paramInt2;
    }
    return paramString1 + "_" + paramInt1 + "_" + paramInt2 + "_" + paramString2;
  }
  
  private void a(String paramString)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_b_of_type_Int = paramString.optInt("actionCode");
        this.jdField_a_of_type_JavaLangString = paramString.optString("appId");
        this.jdField_b_of_type_JavaLangString = paramString.optString("apkSign");
        this.jdField_e_of_type_Int = paramString.optInt("versionCode");
        this.jdField_f_of_type_JavaLangString = paramString.optString("packageName");
        this.jdField_j_of_type_JavaLangString = paramString.optString("appName");
        this.k = paramString.optString("iconUrl");
        if (paramString.optInt("delayDownload") > 0)
        {
          this.jdField_b_of_type_Boolean = bool;
          this.m = paramString.optString("fromWebUrl");
          this.jdField_c_of_type_JavaLangString = paramString.optString("apkChannel", "10000144");
          this.l = paramString.optString("via");
          this.jdField_a_of_type_Long = paramString.optLong("downloadStartTime");
          this.jdField_b_of_type_Long = paramString.optLong("downloadEndTime");
          this.n = paramString.optString("adtag");
          this.jdField_d_of_type_Int = paramString.optInt("from", 0);
          this.jdField_c_of_type_Int = paramString.optInt("flags", this.jdField_a_of_type_Int);
          if (a(64))
          {
            a(64);
            b(1);
          }
          if (a(128)) {
            a(128);
          }
          this.o = paramString.optString("extraData");
          this.jdField_a_of_type_JavaLangString = paramString.optString("appid", this.jdField_a_of_type_JavaLangString);
          this.m = paramString.optString("wadlSource", this.m);
          this.jdField_b_of_type_JavaLangString = paramString.optString("myAppId", this.jdField_b_of_type_JavaLangString);
          if ((paramString.has("isAutoInstall")) && (paramString.optInt("isAutoInstall") == 0)) {
            a(1);
          }
          if ((paramString.has("showPageNotification")) && (paramString.optInt("showPageNotification") == 0)) {
            a(2);
          }
          if ((paramString.has("showSystemNotification")) && (paramString.optInt("showSystemNotification") == 0)) {
            a(4);
          }
          if ((paramString.has("requireWifi")) && (paramString.optBoolean("requireWifi", false))) {
            b(8);
          }
          if ((paramString.has("showNetworkDiaLog")) && (paramString.optInt("showNetworkDiaLog") > 0)) {
            b(16);
          }
          this.p = paramString.optString("sourceId");
          this.jdField_c_of_type_Long = paramString.optLong("pkgSize");
          this.jdField_a_of_type_Boolean = paramString.optBoolean("isRes");
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_e_of_type_JavaLangString = paramString.optString("resUrl");
            this.jdField_f_of_type_Int = paramString.optInt("resIndex");
            this.jdField_g_of_type_JavaLangString = paramString.optString("resVersionCode");
            this.jdField_h_of_type_JavaLangString = paramString.optString("resName");
            this.jdField_i_of_type_JavaLangString = paramString.optString("resMD5");
            this.jdField_d_of_type_JavaLangString = paramString.optString("resDir");
            return;
          }
          this.jdField_e_of_type_JavaLangString = paramString.optString("apkUrl");
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            continue;
          }
          this.jdField_e_of_type_JavaLangString = paramString.optString("url");
          continue;
        }
        bool = false;
      }
      catch (Exception paramString)
      {
        bkad.a("WadlParams", "parse json exception:" + paramString.getMessage());
        return;
      }
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return a(this.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_Int, this.jdField_e_of_type_Int, this.jdField_h_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool2 = true;
    if (paramParcel != null)
    {
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_j_of_type_JavaLangString = paramParcel.readString();
      this.k = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label267;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      this.m = paramParcel.readString();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.l = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.n = paramParcel.readString();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.o = paramParcel.readString();
      this.p = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label272;
      }
    }
    label267:
    label272:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_g_of_type_JavaLangString = paramParcel.readString();
      this.jdField_h_of_type_JavaLangString = paramParcel.readString();
      this.jdField_i_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_h_of_type_Int = paramParcel.readInt();
      this.jdField_i_of_type_Int = paramParcel.readInt();
      this.jdField_j_of_type_Int = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(WadlParams paramWadlParams)
  {
    this.jdField_c_of_type_Int = paramWadlParams.jdField_c_of_type_Int;
    this.jdField_h_of_type_Int = paramWadlParams.jdField_h_of_type_Int;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_c_of_type_Int & paramInt) == paramInt;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int |= paramInt;
  }
  
  public boolean b(int paramInt)
  {
    return (this.jdField_j_of_type_Int & paramInt) == paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_j_of_type_Int = (this.jdField_c_of_type_Int | paramInt);
  }
  
  public void d(int paramInt)
  {
    this.jdField_j_of_type_Int &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WadlParams{actionCode='" + a(this.jdField_b_of_type_Int) + '\'' + ", appId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", isRes='" + this.jdField_a_of_type_Boolean + '\'' + ", resType=" + this.jdField_g_of_type_Int + ", versionCode=" + this.jdField_e_of_type_Int + ", apkUrl='" + this.jdField_e_of_type_JavaLangString + '\'' + ", packageName='" + this.jdField_f_of_type_JavaLangString + '\'' + ", appName='" + this.jdField_j_of_type_JavaLangString + '\'' + ", delayDownload=" + this.jdField_b_of_type_Boolean + ", extraData='" + this.o + '\'' + ", apkChannel='" + this.jdField_c_of_type_JavaLangString + '\'' + ", via='" + this.l + '\'' + ", flags=" + this.jdField_c_of_type_Int + ", from=" + this.jdField_d_of_type_Int + ", yyStartTime=" + this.jdField_a_of_type_Long + ", yyEndTime=" + this.jdField_b_of_type_Long + ", adtag='" + this.n + '\'' + ", resName='" + this.jdField_h_of_type_JavaLangString + '\'' + ", resIndex='" + this.jdField_f_of_type_Int + '\'' + ", resMD5='" + this.jdField_i_of_type_JavaLangString + '\'' + ", resDir='" + this.jdField_d_of_type_JavaLangString + '\'' + ", pkgSize=" + this.jdField_c_of_type_Long + ", ignoreSpace=" + this.jdField_h_of_type_Int + ", channelNum=" + this.jdField_i_of_type_Int + ", isCancelRequest=" + this.jdField_c_of_type_Boolean + ", extFlags=" + this.jdField_j_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      paramParcel.writeString(this.k);
      if (!this.jdField_b_of_type_Boolean) {
        break label267;
      }
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.m);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeString(this.l);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeString(this.n);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeString(this.o);
      paramParcel.writeString(this.p);
      if (!this.jdField_a_of_type_Boolean) {
        break label272;
      }
    }
    label267:
    label272:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlParams
 * JD-Core Version:    0.7.0.1
 */