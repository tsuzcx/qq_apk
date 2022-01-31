package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.gg;
import com.tencent.map.sdk.a.kh;
import com.tencent.map.sdk.a.ku;
import java.util.List;

public final class Circle
  implements IOverlay
{
  private CircleOptions a = null;
  private String b = "";
  private kh c = null;
  private Object d;
  
  public Circle(CircleOptions paramCircleOptions, kh paramkh, String paramString)
  {
    this.b = paramString;
    this.a = paramCircleOptions;
    this.c = paramkh;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    Object localObject = getCenter();
    double d4 = ((LatLng)localObject).longitude;
    double d3 = ((LatLng)localObject).latitude;
    double d2 = paramLatLng.longitude;
    double d1 = paramLatLng.latitude;
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramLatLng = new double[3];
    localObject = new double[3];
    paramLatLng[0] = (d5 * d6);
    paramLatLng[1] = (d6 * d1);
    paramLatLng[2] = d2;
    localObject[0] = (d4 * d3);
    localObject[1] = (d4 * d7);
    localObject[2] = d8;
    return Math.asin(Math.sqrt((paramLatLng[0] - localObject[0]) * (paramLatLng[0] - localObject[0]) + (paramLatLng[1] - localObject[1]) * (paramLatLng[1] - localObject[1]) + (paramLatLng[2] - localObject[2]) * (paramLatLng[2] - localObject[2])) / 2.0D) * 12742001.579854401D < getRadius();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Circle)) {
      return false;
    }
    paramObject = (Circle)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public final LatLng getCenter()
  {
    return new LatLng(this.a.getCenter().latitude, this.a.getCenter().longitude);
  }
  
  public final int getFillColor()
  {
    return this.a.getFillColor();
  }
  
  public final String getId()
  {
    return this.b;
  }
  
  public final int getLevel()
  {
    return this.a.getLevel();
  }
  
  public final List<gg> getMapElements()
  {
    kh localkh;
    String str;
    if (this.c != null)
    {
      localkh = this.c;
      str = this.b;
      if (localkh.a != null) {}
    }
    else
    {
      return null;
    }
    return localkh.a.b(str);
  }
  
  public final double getRadius()
  {
    return this.a.getRadius();
  }
  
  public final int getStrokeColor()
  {
    return this.a.getStrokeColor();
  }
  
  public final float getStrokeWidth()
  {
    return this.a.getStrokeWidth();
  }
  
  public final Object getTag()
  {
    return this.d;
  }
  
  public final float getZIndex()
  {
    return this.a.getZIndex();
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final boolean isClickable()
  {
    if (this.a != null) {
      return this.a.isClickable();
    }
    return false;
  }
  
  public final boolean isVisible()
  {
    return this.a.isVisible();
  }
  
  public final void remove()
  {
    if (this.c == null) {}
    kh localkh;
    String str;
    do
    {
      return;
      localkh = this.c;
      str = this.b;
    } while (localkh.a == null);
    localkh.a.a(str);
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    if (this.c == null) {
      return;
    }
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.a(str, paramLatLng);
    }
    this.a.center(paramLatLng);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.a.clickable(paramBoolean);
  }
  
  public final void setFillColor(int paramInt)
  {
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.a(str, paramInt);
    }
    this.a.fillColor(paramInt);
  }
  
  public final void setLevel(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return;
    }
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.c(str, paramInt);
    }
    this.a.level(paramInt);
  }
  
  public final void setOptions(CircleOptions paramCircleOptions)
  {
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.a(str, paramCircleOptions);
    }
    this.a = paramCircleOptions;
  }
  
  public final void setRadius(double paramDouble)
  {
    if (paramDouble < 0.0D) {}
    while (this.c == null) {
      return;
    }
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.a(str, paramDouble);
    }
    this.a.radius(paramDouble);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.b(str, paramInt);
    }
    this.a.strokeColor(paramInt);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.a(str, paramFloat);
    }
    this.a.strokeWidth(paramFloat);
  }
  
  public final void setTag(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    kh localkh = this.c;
    String str = this.b;
    if (localkh.a != null) {
      localkh.a.a(str, paramBoolean);
    }
    this.a.visible(paramBoolean);
  }
  
  public final void setZIndex(int paramInt)
  {
    kh localkh = this.c;
    String str = this.b;
    float f = paramInt;
    if (localkh.a != null) {
      localkh.a.b(str, f);
    }
    this.a.zIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Circle
 * JD-Core Version:    0.7.0.1
 */