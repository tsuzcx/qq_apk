package com.tencent.qqmini.sdk.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import besl;
import betf;
import bffr;
import bfgt;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class EngineVersion
  implements Parcelable, Comparable<EngineVersion>
{
  public static final Parcelable.Creator<EngineVersion> CREATOR = new betf();
  public String a;
  public String b;
  
  public EngineVersion() {}
  
  public EngineVersion(String paramString)
  {
    if (bfgt.a()) {}
    for (String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();; str = "1.1.0")
    {
      this.a = str;
      this.b = paramString;
      return;
    }
  }
  
  public EngineVersion(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.min(paramString1.length, paramString2.length);
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
    if (i != 0) {
      return i;
    }
    return paramString1.length - paramString2.length;
  }
  
  public static EngineVersion a(String paramString)
  {
    paramString = paramString.split("_");
    if (paramString.length > 1) {
      return new EngineVersion(paramString[0], paramString[1]);
    }
    return null;
  }
  
  public static String a(EngineVersion paramEngineVersion)
  {
    return paramEngineVersion.a + "_" + paramEngineVersion.b;
  }
  
  public int a(EngineVersion paramEngineVersion)
  {
    try
    {
      int j = a(this.a, paramEngineVersion.a);
      int i = j;
      if (j == 0) {
        i = a(this.b, paramEngineVersion.b);
      }
      return i;
    }
    catch (Exception paramEngineVersion)
    {
      besl.d("EngineVersion", "[MiniEng] compare error " + bffr.a(paramEngineVersion));
    }
    return 0;
  }
  
  public String a()
  {
    return a(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (EngineVersion)paramObject;
      bool1 = bool2;
    } while (!this.a.equals(paramObject.a));
    return this.b.equals(paramObject.b);
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return "EngineVersion{mMajor=" + this.a + ",mMinor=" + this.b + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineVersion
 * JD-Core Version:    0.7.0.1
 */