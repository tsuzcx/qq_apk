package cooperation.wadl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bdot;
import bicg;
import org.json.JSONObject;

public class WadlParams
  implements Parcelable
{
  public static final Parcelable.Creator<WadlParams> CREATOR = new bicg();
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
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  
  public WadlParams()
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = -1;
  }
  
  public WadlParams(String paramString)
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = -1;
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString);
    }
  }
  
  public WadlParams(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.j = paramString2;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      return "";
    case 2: 
      return "doDownloadAction";
    case 3: 
      return "doPauseAction";
    case 10: 
      return "doCancelAction";
    case 4: 
      return "doResumeAction";
    case 5: 
      return "doInstallAction";
    }
    return "doUpdateAction";
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString + "_" + this.jdField_g_of_type_JavaLangString;
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
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.j = paramParcel.readString();
      this.k = paramParcel.readString();
      this.l = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label243;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.n = paramParcel.readString();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.m = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.o = paramParcel.readString();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.p = paramParcel.readString();
      this.q = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label248;
      }
    }
    label243:
    label248:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_g_of_type_JavaLangString = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(WadlParams paramWadlParams)
  {
    this.jdField_d_of_type_Int = paramWadlParams.jdField_d_of_type_Int;
    this.jdField_c_of_type_Int = paramWadlParams.jdField_c_of_type_Int;
    this.jdField_a_of_type_Long = paramWadlParams.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramWadlParams.jdField_b_of_type_Long;
    this.m = paramWadlParams.m;
    this.n = paramWadlParams.n;
    this.p = paramWadlParams.p;
    this.q = paramWadlParams.q;
    this.jdField_g_of_type_Int = paramWadlParams.jdField_g_of_type_Int;
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_b_of_type_Int = paramString.optInt("actionCode");
      this.jdField_a_of_type_JavaLangString = paramString.optString("appId");
      this.jdField_b_of_type_JavaLangString = paramString.optString("apkUrl");
      this.jdField_c_of_type_JavaLangString = paramString.optString("apkSign");
      this.jdField_f_of_type_Int = paramString.optInt("versionCode");
      this.j = paramString.optString("packageName");
      this.k = paramString.optString("appName");
      this.l = paramString.optString("iconUrl");
      if (paramString.optInt("delayDownload") > 0) {}
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.n = paramString.optString("fromWebUrl");
        this.jdField_d_of_type_JavaLangString = paramString.optString("apkChannel", "10000144");
        this.m = paramString.optString("via");
        this.jdField_a_of_type_Long = paramString.optLong("downloadStartTime");
        this.jdField_b_of_type_Long = paramString.optLong("downloadEndTime");
        this.o = paramString.optString("adtag");
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
        this.p = paramString.optString("extraData");
        this.jdField_a_of_type_JavaLangString = paramString.optString("appid", this.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = paramString.optString("url", this.jdField_b_of_type_JavaLangString);
        this.n = paramString.optString("wadlSource", this.n);
        this.jdField_c_of_type_JavaLangString = paramString.optString("myAppId", this.jdField_c_of_type_JavaLangString);
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
        this.q = paramString.optString("sourceId");
        this.jdField_b_of_type_Boolean = paramString.optBoolean("isRes");
        this.jdField_e_of_type_Int = paramString.optInt("resIndex");
        this.jdField_f_of_type_JavaLangString = paramString.optString("resVersionCode");
        this.jdField_g_of_type_JavaLangString = paramString.optString("resName");
        this.h = paramString.optString("resMD5");
        this.i = paramString.optString("resUrl");
        this.jdField_e_of_type_JavaLangString = paramString.optString("resDir");
        this.jdField_c_of_type_Long = paramString.optLong("pkgSize");
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString)
    {
      bdot.a("WadlParams", "parse json exception:" + paramString.getMessage());
    }
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_c_of_type_Int & paramInt) == paramInt;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int |= paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WadlParams{actionCode='" + a(this.jdField_b_of_type_Int) + '\'' + ", appId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", apkUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", versionCode=" + this.jdField_f_of_type_Int + ", packageName='" + this.j + '\'' + ", appName='" + this.k + '\'' + ", delayDownload=" + this.jdField_a_of_type_Boolean + ", extraData='" + this.p + '\'' + ", apkChannel='" + this.jdField_d_of_type_JavaLangString + '\'' + ", via='" + this.m + '\'' + ", flags=" + this.jdField_c_of_type_Int + ", from=" + this.jdField_d_of_type_Int + ", yyStartTime=" + this.jdField_a_of_type_Long + ", yyEndTime=" + this.jdField_b_of_type_Long + ", adtag='" + this.o + '\'' + ", isRES='" + this.jdField_b_of_type_Boolean + '\'' + ", resName='" + this.jdField_g_of_type_JavaLangString + '\'' + ", resIndex='" + this.jdField_e_of_type_Int + '\'' + ", resverCode='" + this.jdField_f_of_type_JavaLangString + '\'' + ", resMD5='" + this.h + '\'' + ", resUrl='" + this.i + '\'' + ", resDir='" + this.jdField_e_of_type_JavaLangString + '\'' + ", pkgSize=" + this.jdField_c_of_type_Long + ", ignoreSpace=" + this.jdField_g_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.j);
      paramParcel.writeString(this.k);
      paramParcel.writeString(this.l);
      if (!this.jdField_a_of_type_Boolean) {
        break label243;
      }
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.m);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeString(this.o);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeString(this.p);
      paramParcel.writeString(this.q);
      if (!this.jdField_b_of_type_Boolean) {
        break label248;
      }
    }
    label243:
    label248:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlParams
 * JD-Core Version:    0.7.0.1
 */