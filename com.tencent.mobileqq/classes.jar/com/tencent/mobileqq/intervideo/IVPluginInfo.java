package com.tencent.mobileqq.intervideo;

import adtg;
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
  public static final Parcelable.Creator CREATOR = new adtg();
  public int a;
  public long a;
  public Bundle a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public IVPluginInfo()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public IVPluginInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
    this.f = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
  }
  
  public static Map a()
  {
    HashMap localHashMap = new HashMap();
    IVPluginInfo localIVPluginInfo1 = new IVPluginInfo();
    localIVPluginInfo1.jdField_a_of_type_Int = 1;
    localIVPluginInfo1.jdField_a_of_type_JavaLangString = "Hy";
    localIVPluginInfo1.jdField_c_of_type_JavaLangString = "com.tencent.huayang";
    localIVPluginInfo1.jdField_b_of_type_JavaLangString = "1600000419";
    IVPluginInfo localIVPluginInfo2 = new IVPluginInfo();
    localIVPluginInfo2.jdField_a_of_type_Int = 2;
    localIVPluginInfo2.jdField_a_of_type_JavaLangString = "Od";
    localIVPluginInfo2.jdField_c_of_type_JavaLangString = "com.tencent.od";
    localIVPluginInfo2.jdField_b_of_type_JavaLangString = "1104763709";
    localIVPluginInfo2.e = "54";
    IVPluginInfo localIVPluginInfo3 = new IVPluginInfo();
    localIVPluginInfo3.jdField_a_of_type_Int = 2;
    localIVPluginInfo3.jdField_a_of_type_JavaLangString = "Od";
    localIVPluginInfo3.jdField_c_of_type_JavaLangString = "com.tencent.gvideo";
    localIVPluginInfo3.jdField_b_of_type_JavaLangString = "1104763709";
    localIVPluginInfo3.e = "1";
    localHashMap.put(localIVPluginInfo1.jdField_c_of_type_JavaLangString, localIVPluginInfo1);
    localHashMap.put(localIVPluginInfo2.jdField_c_of_type_JavaLangString, localIVPluginInfo2);
    localHashMap.put(localIVPluginInfo3.jdField_c_of_type_JavaLangString, localIVPluginInfo3);
    return localHashMap;
  }
  
  public static Map a(String paramString)
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
        localIVPluginInfo.jdField_a_of_type_Int = localJSONObject.optInt("authType");
        localIVPluginInfo.jdField_c_of_type_JavaLangString = localJSONObject.optString("packageName");
        localIVPluginInfo.e = localJSONObject.optString("fromId");
        localIVPluginInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("pluginid");
        localIVPluginInfo.jdField_b_of_type_JavaLangString = localJSONObject.optString("loginAppId");
        localIVPluginInfo.i = localJSONObject.optString("openType");
        localIVPluginInfo.j = localJSONObject.optString("extra");
        localIVPluginInfo.jdField_a_of_type_Long = localJSONObject.optInt("roomId");
        localIVPluginInfo.k = localJSONObject.optString("sign");
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
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVPluginInfo
 * JD-Core Version:    0.7.0.1
 */