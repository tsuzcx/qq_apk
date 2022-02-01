package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.io.Serializable;

public class LocationInfo
  implements Parcelable, Serializable, Cloneable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR = new LocationInfo.1();
  public String address = "";
  public String city = "";
  boolean isForeign;
  public String lat = "";
  public String lng = "";
  public String name = "";
  
  public LocationInfo()
  {
    this.isForeign = false;
  }
  
  protected LocationInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.isForeign = false;
    this.lng = paramParcel.readString();
    this.lat = paramParcel.readString();
    this.city = paramParcel.readString();
    this.address = paramParcel.readString();
    this.name = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.isForeign = bool;
  }
  
  public LocationInfo(LocationInfo paramLocationInfo)
  {
    this.isForeign = false;
    init(paramLocationInfo.lng, paramLocationInfo.lat, paramLocationInfo.city, paramLocationInfo.name);
    setAddress(paramLocationInfo.address);
    setForeign(paramLocationInfo.isForeign);
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public LocationInfo clone()
  {
    return (LocationInfo)super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(LocationInfo paramLocationInfo)
  {
    boolean bool2 = false;
    if (paramLocationInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (getName().equals(paramLocationInfo.getName()))
    {
      bool1 = bool2;
      if (getCity().equals(paramLocationInfo.getCity())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public String getLat()
  {
    return this.lat;
  }
  
  public String getLng()
  {
    return this.lng;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNameOrCity()
  {
    if (isNameEmpty()) {
      return this.city;
    }
    return this.name;
  }
  
  public void init(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.lng = a(paramString1);
    this.lat = a(paramString2);
    this.city = a(paramString3);
    this.name = a(paramString4);
  }
  
  public boolean isCityEmpty()
  {
    return TextUtils.isEmpty(this.city);
  }
  
  public boolean isForeign()
  {
    return this.isForeign;
  }
  
  public boolean isNameEmpty()
  {
    return getName().equals("");
  }
  
  public boolean isOnlyCity()
  {
    return (!TextUtils.isEmpty(this.city)) && (TextUtils.isEmpty(this.name)) && (TextUtils.isEmpty(this.address));
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public void setForeign(boolean paramBoolean)
  {
    this.isForeign = paramBoolean;
  }
  
  public void setLat(String paramString)
  {
    this.lat = paramString;
  }
  
  public void setLng(String paramString)
  {
    this.lng = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationInfo{lng='");
    localStringBuilder.append(this.lng);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lat='");
    localStringBuilder.append(this.lat);
    localStringBuilder.append('\'');
    localStringBuilder.append(", city='");
    localStringBuilder.append(this.city);
    localStringBuilder.append('\'');
    localStringBuilder.append(", address='");
    localStringBuilder.append(this.address);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isForeign=");
    localStringBuilder.append(this.isForeign);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */