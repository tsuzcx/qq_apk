package cooperation.wadl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import angj;
import com.tencent.open.wadl.WLog;
import org.json.JSONObject;

public class WadlParams
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new angj();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  
  public WadlParams()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  public WadlParams(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString);
    }
  }
  
  public WadlParams(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_Int = 39;
  }
  
  public String a()
  {
    switch (this.jdField_a_of_type_Int)
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
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void a(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.i = paramParcel.readString();
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.j = paramParcel.readString();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.k = paramParcel.readString();
      return;
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("actionCode");
      this.jdField_a_of_type_JavaLangString = paramString.optString("appId");
      this.jdField_b_of_type_JavaLangString = paramString.optString("apkUrl");
      this.jdField_c_of_type_JavaLangString = paramString.optString("apkSign");
      this.jdField_b_of_type_Int = paramString.optInt("versionCode");
      this.jdField_d_of_type_JavaLangString = paramString.optString("packageName");
      this.e = paramString.optString("appName");
      this.f = paramString.optString("iconUrl");
      if (paramString.optInt("delayDownload") > 0) {}
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.i = paramString.optString("fromWebUrl");
        this.g = paramString.optString("apkChannel", "QQGameCenter");
        this.h = paramString.optString("via");
        this.jdField_a_of_type_Long = paramString.optLong("downloadStartTime");
        this.jdField_b_of_type_Long = paramString.optLong("downloadEndTime");
        this.j = paramString.optString("adtag");
        this.jdField_c_of_type_Int = paramString.optInt("from", 0);
        this.jdField_d_of_type_Int = paramString.optInt("flags", 39);
        this.k = paramString.optString("extraData");
        this.jdField_a_of_type_JavaLangString = paramString.optString("appid", this.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = paramString.optString("url", this.jdField_b_of_type_JavaLangString);
        this.i = paramString.optString("wadlSource", this.i);
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
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString)
    {
      WLog.a("WadlParams", "parse json exception:" + paramString.getMessage());
    }
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_d_of_type_Int & paramInt) == paramInt;
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int |= paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WadlParams{actionCode='" + a() + '\'' + ", appId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", apkUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", versionCode=" + this.jdField_b_of_type_Int + ", packageName='" + this.jdField_d_of_type_JavaLangString + '\'' + ", appName='" + this.e + '\'' + ", delayDownload=" + this.jdField_a_of_type_Boolean + ", extraData='" + this.k + '\'' + ", apkChannel='" + this.g + '\'' + ", via='" + this.h + '\'' + ", flags=" + this.jdField_d_of_type_Int + ", from=" + this.jdField_c_of_type_Int + ", yyStartTime=" + this.jdField_a_of_type_Long + ", yyEndTime=" + this.jdField_b_of_type_Long + ", adtag='" + this.j + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      if (!this.jdField_a_of_type_Boolean) {
        break label155;
      }
    }
    label155:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeString(this.j);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeString(this.k);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlParams
 * JD-Core Version:    0.7.0.1
 */