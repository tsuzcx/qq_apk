package com.tencent.mobileqq.minigame.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.qphone.base.util.QLog;

public class EngineVersion
  implements Parcelable, Comparable<EngineVersion>
{
  public static final Parcelable.Creator<EngineVersion> CREATOR = new EngineVersion.1();
  public static final String LOG_TAG = "EngineVersion";
  public static final String SEP = "_";
  public String mMajor;
  public String mMinor;
  
  public EngineVersion() {}
  
  public EngineVersion(String paramString)
  {
    this.mMajor = "8.8.17.5770";
    this.mMinor = paramString;
  }
  
  public EngineVersion(String paramString1, String paramString2)
  {
    this.mMajor = paramString1;
    this.mMinor = paramString2;
  }
  
  public static int compareVersion(String paramString1, String paramString2)
  {
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
    if (i != 0) {
      return i;
    }
    return paramString1.length - paramString2.length;
  }
  
  public static EngineVersion fromFolderName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("_");
      if (paramString.length > 1) {
        return new EngineVersion(paramString[0], paramString[1]);
      }
    }
    return null;
  }
  
  public static String toFolderName(EngineVersion paramEngineVersion)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEngineVersion.mMajor);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEngineVersion.mMinor);
    return localStringBuilder.toString();
  }
  
  public int compareTo(@NonNull EngineVersion paramEngineVersion)
  {
    try
    {
      int j = compareVersion(this.mMajor, paramEngineVersion.mMajor);
      int i = j;
      if (j == 0) {
        i = compareVersion(this.mMinor, paramEngineVersion.mMinor);
      }
      return i;
    }
    catch (Exception paramEngineVersion)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] compare error ");
      localStringBuilder.append(DebugUtil.getPrintableStackTrace(paramEngineVersion));
      QLog.e("EngineVersion", 1, localStringBuilder.toString());
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (EngineVersion)paramObject;
      if (!this.mMajor.equals(paramObject.mMajor)) {
        return false;
      }
      return this.mMinor.equals(paramObject.mMinor);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mMajor.hashCode() * 31 + this.mMinor.hashCode();
  }
  
  public String toFolderName()
  {
    return toFolderName(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EngineVersion{mMajor=");
    localStringBuilder.append(this.mMajor);
    localStringBuilder.append(",mMinor=");
    localStringBuilder.append(this.mMinor);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMajor);
    paramParcel.writeString(this.mMinor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineVersion
 * JD-Core Version:    0.7.0.1
 */