package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;

public class CircleOptions
{
  private LatLng a = new LatLng(39.984253000000002D, 116.307439D);
  private double b = 1.0D;
  private float c = 1.0F;
  private int d = -16777216;
  private int e = 0;
  private int f = 0;
  private boolean g = true;
  private boolean h;
  private int i = OverlayLevel.OverlayLevelAboveLabels;
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public CircleOptions clickable(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.a;
  }
  
  public int getFillColor()
  {
    return this.e;
  }
  
  public int getLevel()
  {
    return this.i;
  }
  
  public double getRadius()
  {
    return this.b;
  }
  
  public int getStrokeColor()
  {
    return this.d;
  }
  
  public float getStrokeWidth()
  {
    return this.c;
  }
  
  public int getZIndex()
  {
    return this.f;
  }
  
  public boolean isClickable()
  {
    return this.h;
  }
  
  public boolean isVisible()
  {
    return this.g;
  }
  
  public CircleOptions level(int paramInt)
  {
    if (paramInt >= OverlayLevel.OverlayLevelAboveRoads)
    {
      if (paramInt > OverlayLevel.OverlayLevelAboveLabels) {
        return this;
      }
      this.i = paramInt;
    }
    return this;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.b = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.c = 1.0F;
      return this;
    }
    this.c = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeDouble(this.b);
  }
  
  public CircleOptions zIndex(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CircleOptions
 * JD-Core Version:    0.7.0.1
 */