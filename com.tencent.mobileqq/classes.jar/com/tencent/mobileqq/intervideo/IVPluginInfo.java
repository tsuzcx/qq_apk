package com.tencent.mobileqq.intervideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IVPluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<IVPluginInfo> CREATOR = new IVPluginInfo.1();
  public String a;
  public String b;
  public String c;
  public long d;
  public String e;
  public String f = "";
  public int g = 1;
  public Bundle h = null;
  public String i;
  public int j = 0;
  public String k;
  public String l;
  public int m;
  public String n;
  public String o;
  public String p;
  
  public IVPluginInfo() {}
  
  protected IVPluginInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readBundle(getClass().getClassLoader());
    this.i = paramParcel.readString();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
  }
  
  public static Map<String, IVPluginInfo> a()
  {
    HashMap localHashMap = new HashMap();
    IVPluginInfo localIVPluginInfo1 = new IVPluginInfo();
    localIVPluginInfo1.g = 1;
    localIVPluginInfo1.a = "Hy";
    localIVPluginInfo1.c = "com.tencent.huayang";
    localIVPluginInfo1.b = "1600000419";
    IVPluginInfo localIVPluginInfo2 = new IVPluginInfo();
    localIVPluginInfo2.g = 2;
    localIVPluginInfo2.a = "Od";
    localIVPluginInfo2.c = "com.tencent.od";
    localIVPluginInfo2.b = "1104763709";
    localIVPluginInfo2.f = "54";
    IVPluginInfo localIVPluginInfo3 = new IVPluginInfo();
    localIVPluginInfo3.g = 2;
    localIVPluginInfo3.a = "Od";
    localIVPluginInfo3.c = "com.tencent.gvideo";
    localIVPluginInfo3.b = "1104763709";
    localIVPluginInfo3.f = "1";
    IVPluginInfo localIVPluginInfo4 = new IVPluginInfo();
    localIVPluginInfo3.g = 2;
    localIVPluginInfo3.a = "Od";
    localIVPluginInfo3.c = "com.tencent.huiyin";
    localIVPluginInfo3.b = "1104763709";
    localIVPluginInfo3.f = "100";
    localHashMap.put(localIVPluginInfo1.c, localIVPluginInfo1);
    localHashMap.put(localIVPluginInfo2.c, localIVPluginInfo2);
    localHashMap.put(localIVPluginInfo3.c, localIVPluginInfo3);
    localHashMap.put(localIVPluginInfo4.c, localIVPluginInfo4);
    return localHashMap;
  }
  
  public static Map<String, IVPluginInfo> a(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramString.getJSONObject(str);
        IVPluginInfo localIVPluginInfo = new IVPluginInfo();
        localIVPluginInfo.g = localJSONObject.optInt("authType");
        localIVPluginInfo.c = localJSONObject.optString("packageName");
        localIVPluginInfo.f = localJSONObject.optString("fromId");
        localIVPluginInfo.a = localJSONObject.optString("pluginid");
        localIVPluginInfo.b = localJSONObject.optString("loginAppId");
        localIVPluginInfo.n = localJSONObject.optString("openType");
        localIVPluginInfo.o = localJSONObject.optString("extra");
        localIVPluginInfo.d = localJSONObject.optInt("roomId");
        localIVPluginInfo.p = localJSONObject.optString("sign");
        localHashMap.put(str, localIVPluginInfo);
      }
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeBundle(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVPluginInfo
 * JD-Core Version:    0.7.0.1
 */