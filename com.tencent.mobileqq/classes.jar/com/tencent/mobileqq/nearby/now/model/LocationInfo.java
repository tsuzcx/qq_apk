package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import atho;
import java.io.Serializable;

public class LocationInfo
  implements Parcelable, Serializable, Cloneable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR = new atho();
  public String address = "";
  public String city = "";
  boolean isForeign = false;
  public String lat = "";
  public String lng = "";
  public String name = "";
  
  public LocationInfo() {}
  
  public LocationInfo(Parcel paramParcel)
  {
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
    if (paramLocationInfo == null) {}
    while ((!getName().equals(paramLocationInfo.getName())) || (!getCity().equals(paramLocationInfo.getCity()))) {
      return false;
    }
    return true;
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
    return "LocationInfo{lng='" + this.lng + '\'' + ", lat='" + this.lat + '\'' + ", city='" + this.city + '\'' + ", address='" + this.address + '\'' + ", name='" + this.name + '\'' + ", isForeign=" + this.isForeign + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.lng);
    paramParcel.writeString(this.lat);
    paramParcel.writeString(this.city);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.name);
    if (this.isForeign) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */