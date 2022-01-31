package com.tencent.tencentmap.mapsdk.maps.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class LatLng
  implements Parcelable
{
  public static final Parcelable.Creator<LatLng> CREATOR = new LatLng.1();
  public double altitude = 0.0D;
  public double latitude;
  public double longitude;
  
  public LatLng()
  {
    this.latitude = 0.0D;
    this.longitude = 0.0D;
  }
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    setLatitude(paramDouble1);
    setLongitude(paramDouble2);
  }
  
  public LatLng(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    setLatitude(paramDouble1);
    setLongitude(paramDouble2);
    setAltitude(paramDouble3);
  }
  
  public LatLng(Location paramLocation)
  {
    this(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude());
  }
  
  public LatLng(Parcel paramParcel)
  {
    setLatitude(paramParcel.readDouble());
    setLongitude(paramParcel.readDouble());
    setAltitude(paramParcel.readDouble());
  }
  
  public LatLng(LatLng paramLatLng)
  {
    this.latitude = paramLatLng.latitude;
    this.longitude = paramLatLng.longitude;
    this.altitude = paramLatLng.altitude;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (LatLng)paramObject;
    } while ((Double.compare(paramObject.altitude, this.altitude) == 0) && (Double.compare(paramObject.latitude, this.latitude) == 0) && (Double.compare(paramObject.longitude, this.longitude) == 0));
    return false;
  }
  
  public double getAltitude()
  {
    return this.altitude;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.latitude);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.longitude);
    int j = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.altitude);
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public void setAltitude(double paramDouble)
  {
    this.altitude = paramDouble;
  }
  
  public void setLatitude(@FloatRange(from=-90.0D, to=90.0D) double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {
      throw new IllegalArgumentException("latitude must not be NaN");
    }
    if (Math.abs(paramDouble) > 90.0D) {
      throw new IllegalArgumentException("latitude must be between -90 and 90");
    }
    this.latitude = paramDouble;
  }
  
  public void setLongitude(@FloatRange(from=-1.797693134862316E+308D, to=1.7976931348623157E+308D) double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {
      throw new IllegalArgumentException("longitude must not be NaN");
    }
    if (Double.isInfinite(paramDouble)) {
      throw new IllegalArgumentException("longitude must not be infinite");
    }
    this.longitude = paramDouble;
  }
  
  @NonNull
  public String toString()
  {
    return "LatLng [latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + "]";
  }
  
  @NonNull
  public LatLng wrap()
  {
    double d1 = 180.0D;
    double d2 = this.latitude;
    double d3 = this.longitude;
    double d4 = ((d3 + 180.0D) % 360.0D + 360.0D) % 360.0D;
    if ((d3 >= 180.0D) && (d4 == 0.0D)) {}
    for (;;)
    {
      return new LatLng(d2, d1);
      d1 = d4 - 180.0D;
    }
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeDouble(this.altitude);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.LatLng
 * JD-Core Version:    0.7.0.1
 */