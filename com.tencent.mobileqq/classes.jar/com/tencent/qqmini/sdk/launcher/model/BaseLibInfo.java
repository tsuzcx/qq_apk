package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM.Column;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.Serializable;
import org.json.JSONObject;

public class BaseLibInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<BaseLibInfo> CREATOR = new BaseLibInfo.1();
  public static final String KEY_1 = "key1";
  public static final String KEY_2 = "key2";
  public static final String KEY_3 = "key3";
  public static final String KEY_4 = "key4";
  public static final String KEY_5 = "key5";
  public static final String LOG_TAG = "BaseLibInfo";
  @JsonORM.Column(key="key4")
  public String baseLibDesc;
  @JsonORM.Column(key="key2")
  public String baseLibKey;
  @JsonORM.Column(key="key5")
  public int baseLibType;
  @JsonORM.Column(key="key1")
  public String baseLibUrl;
  @JsonORM.Column(key="key3")
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
        paramJSONObject = (BaseLibInfo)JsonORM.parseFrom(paramJSONObject, BaseLibInfo.class);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("BaseLibInfo", "BaseLibInfo create from json failed ", paramJSONObject);
      }
    }
    return null;
  }
  
  public static String getKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseLibInfo_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static boolean needUpdateVersion(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needUpdateVersion requireVersion:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",currentVer:");
    localStringBuilder.append(paramString2);
    QMLog.e("BaseLibInfo", localStringBuilder.toString());
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      int m = Math.min(paramString1.length, paramString2.length);
      int j = 0;
      int k;
      for (int i = 0; j < m; i = k)
      {
        k = paramString1[j].length() - paramString2[j].length();
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
      }
      if (i == 0) {
        i = paramString1.length - paramString2.length;
      }
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseLibInfo_");
    localStringBuilder.append(this.baseLibType);
    return localStringBuilder.toString();
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
      QMLog.e("BaseLibInfo", "BaseLibInfo convert to json failed ", localException);
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseLibInfo{baseLibUrl='");
    localStringBuilder.append(this.baseLibUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", baseLibKey='");
    localStringBuilder.append(this.baseLibKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", baseLibVersion='");
    localStringBuilder.append(this.baseLibVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", baseLibDesc='");
    localStringBuilder.append(this.baseLibDesc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", baseLibType='");
    localStringBuilder.append(this.baseLibType);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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