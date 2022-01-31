package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bere;
import bern;
import betc;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import java.io.Serializable;
import org.json.JSONObject;

public class BaseLibInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<BaseLibInfo> CREATOR = new bern();
  public static final String KEY_1 = "key1";
  public static final String KEY_2 = "key2";
  public static final String KEY_3 = "key3";
  public static final String KEY_4 = "key4";
  public static final String KEY_5 = "key5";
  public static final String LOG_TAG = "BaseLibInfo";
  @bere(a="key4")
  public String baseLibDesc;
  @bere(a="key2")
  public String baseLibKey;
  @bere(a="key5")
  public int baseLibType;
  @bere(a="key1")
  public String baseLibUrl;
  @bere(a="key3")
  public String baseLibVersion;
  
  public BaseLibInfo() {}
  
  public BaseLibInfo(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2, null, -1);
  }
  
  public BaseLibInfo(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null, -1);
  }
  
  public BaseLibInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.baseLibUrl = paramString1;
    this.baseLibKey = paramString2;
    this.baseLibVersion = paramString3;
    this.baseLibDesc = paramString4;
    this.baseLibType = paramInt;
  }
  
  public static BaseLibInfo fromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        paramJSONObject = (BaseLibInfo)JsonORM.a(paramJSONObject, BaseLibInfo.class);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        betc.d("BaseLibInfo", "BaseLibInfo create from json failed ", paramJSONObject);
        return null;
      }
    }
    return null;
  }
  
  public static String getKey(int paramInt)
  {
    return "BaseLibInfo_" + paramInt;
  }
  
  public static boolean needUpdateVersion(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      int m = Math.min(paramString1.length, paramString2.length);
      int i = 0;
      int j = 0;
      while (j < m)
      {
        int k = paramString1[j].length() - paramString2[j].length();
        i = k;
        if (k != 0) {
          break;
        }
        k = paramString1[j].compareTo(paramString2[j]);
        i = k;
        if (k != 0) {
          break;
        }
        j += 1;
        i = k;
      }
      if (i != 0) {}
      while (i > 0)
      {
        return true;
        i = paramString1.length - paramString2.length;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getKey()
  {
    return "BaseLibInfo_" + this.baseLibType;
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key1", this.baseLibUrl);
      localJSONObject.put("key2", this.baseLibKey);
      localJSONObject.put("key3", this.baseLibVersion);
      localJSONObject.put("key4", this.baseLibDesc);
      localJSONObject.put("key5", this.baseLibType);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      betc.d("BaseLibInfo", "BaseLibInfo convert to json failed ", localException);
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return "BaseLibInfo{baseLibUrl='" + this.baseLibUrl + '\'' + ", baseLibKey='" + this.baseLibKey + '\'' + ", baseLibVersion='" + this.baseLibVersion + '\'' + ", baseLibDesc='" + this.baseLibDesc + '\'' + ", baseLibType='" + this.baseLibType + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.baseLibUrl);
    paramParcel.writeString(this.baseLibKey);
    paramParcel.writeString(this.baseLibVersion);
    paramParcel.writeString(this.baseLibDesc);
    paramParcel.writeInt(this.baseLibType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.BaseLibInfo
 * JD-Core Version:    0.7.0.1
 */