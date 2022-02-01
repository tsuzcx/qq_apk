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
  public boolean A;
  public String B;
  public int C;
  public int D;
  public long E;
  public String F;
  public boolean G;
  public String H;
  public long I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
  public boolean P;
  public int Q;
  public String R;
  public String S;
  public String T;
  public boolean U;
  public boolean V;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = "";
  public String h;
  public long i;
  public int j;
  public String k;
  public String l;
  public String m;
  public int n;
  public int o;
  public int p;
  public String q;
  public String r;
  protected volatile int s;
  public volatile int t;
  public Intent u;
  public int v;
  public boolean w;
  public boolean x;
  public long y;
  public int z;
  
  public DownloadInfo()
  {
    this.j = 0;
    this.n = 0;
    this.o = 0;
    this.p = 1;
    this.q = "";
    this.r = "";
    this.s = 1;
    this.t = 0;
    this.w = true;
    this.x = false;
    this.y = 0L;
    this.z = 0;
    this.A = true;
    this.B = "";
    this.C = 0;
    this.D = -1;
    this.E = 0L;
    this.F = null;
    this.G = false;
    this.H = "";
    this.I = 0L;
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = "6000";
    this.N = "0";
    this.O = "0";
    this.P = false;
    this.U = false;
  }
  
  protected DownloadInfo(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.j = 0;
    this.n = 0;
    this.o = 0;
    this.p = 1;
    this.q = "";
    this.r = "";
    this.s = 1;
    this.t = 0;
    this.w = true;
    this.x = false;
    this.y = 0L;
    this.z = 0;
    this.A = true;
    this.B = "";
    this.C = 0;
    this.D = -1;
    this.E = 0L;
    this.F = null;
    this.G = false;
    this.H = "";
    this.I = 0L;
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = "6000";
    this.N = "0";
    this.O = "0";
    this.P = false;
    this.U = false;
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.v = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.w = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.x = bool1;
    this.y = paramParcel.readLong();
    this.z = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.A = bool1;
    this.B = paramParcel.readString();
    this.C = paramParcel.readInt();
    this.D = paramParcel.readInt();
    this.E = paramParcel.readLong();
    this.F = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.G = bool1;
    this.H = paramParcel.readString();
    this.I = paramParcel.readLong();
    this.J = paramParcel.readString();
    this.K = paramParcel.readString();
    this.L = paramParcel.readString();
    this.M = paramParcel.readString();
    this.N = paramParcel.readString();
    this.O = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.P = bool1;
    this.Q = paramParcel.readInt();
    this.R = paramParcel.readString();
    this.S = paramParcel.readString();
    this.T = paramParcel.readString();
  }
  
  public DownloadInfo(String paramString1, String paramString2)
  {
    this.j = 0;
    this.n = 0;
    this.o = 0;
    this.p = 1;
    this.q = "";
    this.r = "";
    this.s = 1;
    this.t = 0;
    this.w = true;
    this.x = false;
    this.y = 0L;
    this.z = 0;
    this.A = true;
    this.B = "";
    this.C = 0;
    this.D = -1;
    this.E = 0L;
    this.F = null;
    this.G = false;
    this.H = "";
    this.I = 0L;
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = "6000";
    this.N = "0";
    this.O = "0";
    this.P = false;
    this.U = false;
    this.c = paramString1;
    this.e = paramString2;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, int paramInt1, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10, String paramString11, long paramLong2, boolean paramBoolean1, int paramInt4, String paramString12, int paramInt5, int paramInt6, String paramString13, boolean paramBoolean2, String paramString14, long paramLong3)
  {
    this.j = 0;
    this.n = 0;
    this.o = 0;
    this.p = 1;
    this.q = "";
    this.r = "";
    this.s = 1;
    this.t = 0;
    this.w = true;
    this.x = false;
    this.y = 0L;
    this.z = 0;
    this.A = true;
    this.B = "";
    this.C = 0;
    this.D = -1;
    this.E = 0L;
    this.F = null;
    this.G = false;
    this.H = "";
    this.I = 0L;
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = "6000";
    this.N = "0";
    this.O = "0";
    this.P = false;
    this.U = false;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.i = paramLong1;
    this.h = paramString6;
    this.k = paramString7;
    this.j = paramInt1;
    this.l = paramString8;
    this.m = paramString9;
    this.n = paramInt2;
    this.o = paramInt3;
    this.q = paramString10;
    this.r = paramString11;
    this.y = paramLong2;
    this.A = paramBoolean1;
    this.z = paramInt4;
    this.B = paramString12;
    this.C = paramInt5;
    this.D = paramInt6;
    this.F = paramString13;
    this.G = paramBoolean2;
    this.H = paramString14;
    this.I = paramLong3;
  }
  
  public DownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Intent paramIntent, String paramString6, boolean paramBoolean)
  {
    this.j = 0;
    this.n = 0;
    this.o = 0;
    this.p = 1;
    this.q = "";
    this.r = "";
    this.s = 1;
    this.t = 0;
    this.w = true;
    this.x = false;
    this.y = 0L;
    this.z = 0;
    this.A = true;
    this.B = "";
    this.C = 0;
    this.D = -1;
    this.E = 0L;
    this.F = null;
    this.G = false;
    this.H = "";
    this.I = 0L;
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = "6000";
    this.N = "0";
    this.O = "0";
    this.P = false;
    this.U = false;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("_");
      paramString2.append(paramString1);
      this.g = paramString2.toString();
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("_");
      paramString1.append(GlobalUtil.calcMD5AsString(paramString2));
      this.g = paramString1.toString();
    }
    this.i = System.currentTimeMillis();
    this.s = 1;
    this.h = paramString5;
    this.u = paramIntent;
    this.y = 0L;
    this.r = paramString6;
    this.A = paramBoolean;
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
    return MD5.b(paramString);
  }
  
  private static String c(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(CommonDataAdapter.a().c());
      ((StringBuilder)localObject).append(DeviceInfoUtil.b());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">genUniqueId ori=");
      localStringBuilder.append(paramString);
      LogUtility.b((String)localObject, localStringBuilder.toString());
      paramString = MD5.b(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label94:
      break label94;
    }
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(System.currentTimeMillis());
    return paramString.toString();
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.b)) && (TextUtils.isEmpty(this.S))) {
      this.S = c(this.b);
    }
  }
  
  public int a()
  {
    try
    {
      int i1 = this.s;
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
    if ((!bool) && (!TextUtils.isEmpty(this.T))) {
      localObject1 = null;
    }
    try
    {
      localObject2 = new JSONObject(this.T);
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
    Object localObject1 = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">getExtParam ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("=");
    ((StringBuilder)localObject2).append(str);
    LogUtility.b((String)localObject1, ((StringBuilder)localObject2).toString());
    return str;
    str = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(">getExtParam empty params:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(this.T);
    LogUtility.b(str, ((StringBuilder)localObject1).toString());
    return "";
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.s = paramInt;
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
      if (TextUtils.isEmpty(this.T)) {
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject = new JSONObject(this.T);
    }
    catch (JSONException localJSONException)
    {
      label52:
      break label52;
    }
    this.T = "";
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString1, paramString2);
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">setExtParam ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString2);
      LogUtility.b(str, localStringBuilder.toString());
      this.T = localJSONObject.toString();
      return true;
    }
    catch (Exception paramString1)
    {
      LogUtility.c(a, ">setExtParam failed:", paramString1);
    }
    return false;
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.b)) {
      if (!TextUtils.isEmpty(this.d))
      {
        this.b = b(this.d);
        LogUtility.b(a, "gen ticket by urlStr");
      }
      else if (!TextUtils.isEmpty(this.k))
      {
        this.b = b(this.k);
        LogUtility.b(a, "gen ticket by urlPatch");
      }
      else if (!TextUtils.isEmpty(this.e))
      {
        this.b = a(this.e, this.n);
        LogUtility.b(a, "gen ticket by packageName & versionCode");
      }
      else
      {
        LogUtility.e(a, "bad download INFO!!!");
      }
    }
    e();
  }
  
  public void c()
  {
    this.S = "";
    b();
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.c);
      localJSONObject.put("state", this.s);
      localJSONObject.put("pro", this.t);
      localJSONObject.put("packagename", this.e);
      localJSONObject.put("ismyapp", this.o);
      localJSONObject.put("download_from", this.z);
      localJSONObject.put("realDownloadType", this.p);
      localJSONObject.put("via", this.h);
      localJSONObject.put("writecodestate", this.D);
      localJSONObject.put("extraInfo", this.F);
      localJSONObject.put("isAutoInstallBySDK", this.G);
      localJSONObject.put("fileMd5", this.H);
      localJSONObject.put("fileSize", this.I);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkConnect ");
      localStringBuilder.append(localJSONException.getMessage());
      LogUtility.c(str, localStringBuilder.toString(), localJSONException);
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadInfo [ticket=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", source =");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", uniqueId=");
    localStringBuilder.append(this.S);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", urlStr=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", urlPatch=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", packageName=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", fileSize =");
    localStringBuilder.append(this.I);
    localStringBuilder.append(", totalDataLength =");
    localStringBuilder.append(this.E);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", isAutoInstallBySDK =");
    localStringBuilder.append(this.G);
    localStringBuilder.append(", isAutoInstall=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", filePath=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", push_title=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", sendTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", updateType=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", myAppId=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", apkId=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", lastDownloadSize=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", isApk=");
    localStringBuilder.append(this.A);
    localStringBuilder.append(", iconUrl=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", isShowNotification=");
    localStringBuilder.append(this.C);
    localStringBuilder.append(", writeCodeState=");
    localStringBuilder.append(this.D);
    localStringBuilder.append(", extraInfo =");
    localStringBuilder.append(this.F);
    localStringBuilder.append(", fileMd5 =");
    localStringBuilder.append(this.H);
    localStringBuilder.append(", recommendId =");
    localStringBuilder.append(this.J);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */