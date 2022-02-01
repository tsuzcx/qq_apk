package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.map.sdk.a.hp;
import java.util.Iterator;
import java.util.List;

public class LatLngBounds
  implements Parcelable
{
  public static final Parcelable.Creator<LatLngBounds> CREATOR = new LatLngBounds.1();
  private final double a;
  private final double b;
  private final double c;
  private final double d;
  public final LatLng northeast;
  public final LatLng southwest;
  
  private LatLngBounds(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a = paramDouble1;
    this.c = paramDouble2;
    this.b = paramDouble3;
    this.d = paramDouble4;
    this.northeast = new LatLng(paramDouble1, paramDouble2);
    this.southwest = new LatLng(paramDouble3, paramDouble4);
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.northeast = paramLatLng1;
    this.southwest = paramLatLng2;
    this.a = paramLatLng1.latitude;
    this.c = paramLatLng1.longitude;
    this.b = paramLatLng2.latitude;
    this.d = paramLatLng2.longitude;
  }
  
  private static double a(int paramInt1, int paramInt2)
  {
    double d1 = 3.141592653589793D - 6.283185307179586D * paramInt2 / Math.pow(2.0D, paramInt1);
    return Math.toDegrees(Math.atan((Math.exp(d1) - Math.exp(-d1)) * 0.5D));
  }
  
  static LatLngBounds a(List<? extends LatLng> paramList)
  {
    double d4 = 90.0D;
    double d2 = 1.7976931348623157E+308D;
    double d3 = -90.0D;
    double d1 = -1.797693134862316E+308D;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LatLng localLatLng = (LatLng)paramList.next();
      double d6 = localLatLng.getLatitude();
      double d5 = localLatLng.getLongitude();
      d4 = Math.min(d4, d6);
      d2 = Math.min(d2, d5);
      d3 = Math.max(d3, d6);
      d1 = Math.max(d1, d5);
    }
    return new LatLngBounds(d3, d1, d4, d2);
  }
  
  private static void a(@FloatRange(from=-90.0D, to=90.0D) double paramDouble1, double paramDouble2, @FloatRange(from=-90.0D, to=90.0D) double paramDouble3, double paramDouble4)
  {
    if ((Double.isNaN(paramDouble1)) || (Double.isNaN(paramDouble3))) {
      throw new IllegalArgumentException("latitude must not be NaN");
    }
    if ((Double.isNaN(paramDouble2)) || (Double.isNaN(paramDouble4))) {
      throw new IllegalArgumentException("longitude must not be NaN");
    }
    if ((Double.isInfinite(paramDouble2)) || (Double.isInfinite(paramDouble4))) {
      throw new IllegalArgumentException("longitude must not be infinite");
    }
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D) || (paramDouble3 > 90.0D) || (paramDouble3 < -90.0D)) {
      throw new IllegalArgumentException("latitude must be between -90 and 90");
    }
    if (paramDouble1 < paramDouble3) {
      throw new IllegalArgumentException("latNorth cannot be less than latSouth");
    }
    if (paramDouble2 < paramDouble4) {
      throw new IllegalArgumentException("lonEast cannot be less than lonWest");
    }
  }
  
  private static double b(int paramInt1, int paramInt2)
  {
    return paramInt2 / Math.pow(2.0D, paramInt1) * 360.0D - 180.0D;
  }
  
  private LatLngBounds b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if (this.a < paramDouble1)
    {
      if (this.c >= paramDouble2) {
        break label60;
      }
      label18:
      if (this.b <= paramDouble3) {
        break label68;
      }
      label28:
      if (this.d <= paramDouble4) {
        break label77;
      }
    }
    for (;;)
    {
      return new LatLngBounds(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      paramDouble1 = this.a;
      break;
      label60:
      paramDouble2 = this.c;
      break label18;
      label68:
      paramDouble3 = this.b;
      break label28;
      label77:
      paramDouble4 = this.d;
    }
  }
  
  public static LatLngBounds.Builder builder()
  {
    return new LatLngBounds.Builder();
  }
  
  private LatLngBounds c(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble4 = Math.max(this.d, paramDouble4);
    paramDouble2 = Math.min(this.c, paramDouble2);
    if (paramDouble2 >= paramDouble4)
    {
      paramDouble3 = Math.max(this.b, paramDouble3);
      paramDouble1 = Math.min(this.a, paramDouble1);
      if (paramDouble1 >= paramDouble3) {
        return new LatLngBounds(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      }
    }
    return null;
  }
  
  public static LatLngBounds from(@FloatRange(from=-90.0D, to=90.0D) double paramDouble1, double paramDouble2, @FloatRange(from=-90.0D, to=90.0D) double paramDouble3, double paramDouble4)
  {
    a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    return new LatLngBounds(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public static LatLngBounds from(int paramInt1, int paramInt2, int paramInt3)
  {
    return new LatLngBounds(a(paramInt1, paramInt3), b(paramInt1, paramInt2 + 1), a(paramInt1, paramInt3 + 1), b(paramInt1, paramInt2));
  }
  
  protected static LatLngBounds readFromParcel(Parcel paramParcel)
  {
    return new LatLngBounds(paramParcel.readDouble(), paramParcel.readDouble(), paramParcel.readDouble(), paramParcel.readDouble());
  }
  
  public static LatLngBounds world()
  {
    return from(90.0D, 180.0D, -90.0D, -180.0D);
  }
  
  public boolean contains(@NonNull LatLng paramLatLng)
  {
    double d1 = paramLatLng.getLatitude();
    if ((d1 <= this.a) && (d1 >= this.b))
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
      d1 = paramLatLng.getLongitude();
      if ((d1 > this.c) || (d1 < this.d)) {
        break label70;
      }
    }
    label70:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label76;
      }
      return true;
      i = 0;
      break;
    }
    label76:
    return false;
  }
  
  public boolean contains(@NonNull LatLngBounds paramLatLngBounds)
  {
    return (contains(paramLatLngBounds.getNorthEast())) && (contains(paramLatLngBounds.getSouthWest()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LatLngBounds)) {
        break;
      }
      paramObject = (LatLngBounds)paramObject;
    } while ((this.a == paramObject.getLatNorth()) && (this.b == paramObject.getLatSouth()) && (this.c == paramObject.getLonEast()) && (this.d == paramObject.getLonWest()));
    return false;
    return false;
  }
  
  @NonNull
  public LatLng getCenter()
  {
    return new LatLng((this.a + this.b) / 2.0D, (this.c + this.d) / 2.0D);
  }
  
  public double getLatNorth()
  {
    return this.a;
  }
  
  public double getLatSouth()
  {
    return this.b;
  }
  
  public double getLatitudeSpan()
  {
    return Math.abs(this.a - this.b);
  }
  
  public double getLonEast()
  {
    return this.c;
  }
  
  public double getLonWest()
  {
    return this.d;
  }
  
  public double getLongitudeSpan()
  {
    return Math.abs(this.c - this.d);
  }
  
  @NonNull
  public LatLng getNorthEast()
  {
    return new LatLng(this.a, this.c);
  }
  
  @NonNull
  public LatLng getNorthWest()
  {
    return new LatLng(this.a, this.d);
  }
  
  @NonNull
  public LatLng getSouthEast()
  {
    return new LatLng(this.b, this.c);
  }
  
  @NonNull
  public LatLng getSouthWest()
  {
    return new LatLng(this.b, this.d);
  }
  
  @NonNull
  public hp getSpan()
  {
    return new hp(getLatitudeSpan(), getLongitudeSpan());
  }
  
  public int hashCode()
  {
    return (int)(this.a + 90.0D + (this.b + 90.0D) * 1000.0D + (this.c + 180.0D) * 1000000.0D + (this.d + 180.0D) * 1000000000.0D);
  }
  
  @NonNull
  public LatLngBounds include(@NonNull LatLng paramLatLng)
  {
    return new LatLngBounds.Builder().include(getNorthEast()).include(getSouthWest()).include(paramLatLng).build();
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    return include(paramLatLng);
  }
  
  @NonNull
  public LatLngBounds intersect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    return c(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  @Nullable
  public LatLngBounds intersect(@NonNull LatLngBounds paramLatLngBounds)
  {
    return c(paramLatLngBounds.getLatNorth(), paramLatLngBounds.getLonEast(), paramLatLngBounds.getLatSouth(), paramLatLngBounds.getLonWest());
  }
  
  public boolean isEmptySpan()
  {
    return (getLongitudeSpan() == 0.0D) || (getLatitudeSpan() == 0.0D);
  }
  
  @NonNull
  public LatLng[] toLatLngs()
  {
    return new LatLng[] { getNorthEast(), getSouthWest() };
  }
  
  @NonNull
  public String toString()
  {
    return "N:" + this.a + "; E:" + this.c + "; S:" + this.b + "; W:" + this.d;
  }
  
  @NonNull
  public LatLngBounds union(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    return b(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  @NonNull
  public LatLngBounds union(@NonNull LatLngBounds paramLatLngBounds)
  {
    return b(paramLatLngBounds.getLatNorth(), paramLatLngBounds.getLonEast(), paramLatLngBounds.getLatSouth(), paramLatLngBounds.getLonWest());
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.c);
    paramParcel.writeDouble(this.b);
    paramParcel.writeDouble(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */