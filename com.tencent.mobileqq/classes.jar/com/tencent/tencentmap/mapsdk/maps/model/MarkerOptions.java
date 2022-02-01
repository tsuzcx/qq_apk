package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.tencent.map.sdk.a.hf;

public class MarkerOptions
{
  private int A = OverlayLevel.OverlayLevelAboveLabels;
  int a = 0;
  boolean b = false;
  private LatLng c;
  private String d = "";
  private String e;
  private BitmapDescriptor f;
  private float g = 0.5F;
  private float h = 0.5F;
  private boolean i;
  private boolean j = true;
  private float k = 0.0F;
  private float l = 1.0F;
  private float m = 0.0F;
  private Object n;
  private String o;
  private IndoorInfo p;
  private boolean q = true;
  private boolean r = false;
  private boolean s = false;
  private boolean t = true;
  private float u = 0.5F;
  private float v = 1.0F;
  private int w = 0;
  private int x = 0;
  private boolean y = true;
  private boolean z = false;
  
  @Deprecated
  public MarkerOptions() {}
  
  public MarkerOptions(@NonNull LatLng paramLatLng)
  {
    this.c = paramLatLng;
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    this.l = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.g = paramFloat1;
    this.h = paramFloat2;
    return this;
  }
  
  public MarkerOptions clockwise(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  public MarkerOptions contentDescription(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public MarkerOptions fastLoad(boolean paramBoolean)
  {
    this.y = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.l;
  }
  
  public float getAnchorU()
  {
    return this.g;
  }
  
  public float getAnchorV()
  {
    return this.h;
  }
  
  public String getContentDescription()
  {
    return this.o;
  }
  
  public BitmapDescriptor getIcon()
  {
    if (this.f == null) {
      this.f = new BitmapDescriptor(new hf(5));
    }
    return this.f;
  }
  
  public IndoorInfo getIndoorInfo()
  {
    return this.p;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.u;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.v;
  }
  
  public int getInfoWindowOffsetX()
  {
    return this.w;
  }
  
  public int getInfowindowOffsetY()
  {
    return this.x;
  }
  
  public int getLevel()
  {
    return this.A;
  }
  
  public LatLng getPosition()
  {
    return this.c;
  }
  
  public float getRotation()
  {
    return this.k;
  }
  
  public String getSnippet()
  {
    return this.e;
  }
  
  public Object getTag()
  {
    return this.n;
  }
  
  public String getTitle()
  {
    return this.d;
  }
  
  public float getZIndex()
  {
    return this.m;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.f = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions indoorInfo(IndoorInfo paramIndoorInfo)
  {
    this.p = paramIndoorInfo;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.u = paramFloat1;
    this.v = paramFloat2;
    return this;
  }
  
  public MarkerOptions infoWindowEnable(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public MarkerOptions infoWindowOffset(int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.x = paramInt2;
    return this;
  }
  
  public boolean isAvoidAnnocation()
  {
    return this.s;
  }
  
  public boolean isClockwise()
  {
    return this.t;
  }
  
  public boolean isDraggable()
  {
    return this.i;
  }
  
  public boolean isFastLoad()
  {
    return this.y;
  }
  
  public boolean isFlat()
  {
    return this.r;
  }
  
  public boolean isInfoWindowEnable()
  {
    return this.q;
  }
  
  public boolean isViewInfowindow()
  {
    return this.z;
  }
  
  public boolean isVisible()
  {
    return this.j;
  }
  
  public MarkerOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.A = paramInt;
    return this;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.k = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public MarkerOptions tag(Object paramObject)
  {
    this.n = paramObject;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public MarkerOptions viewInfoWindow(boolean paramBoolean)
  {
    this.z = paramBoolean;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {}
    while (this.c == null) {
      return;
    }
    paramParcel.writeString(this.c.toString());
  }
  
  public MarkerOptions zIndex(float paramFloat)
  {
    this.m = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions
 * JD-Core Version:    0.7.0.1
 */