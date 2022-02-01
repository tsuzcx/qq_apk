package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Typeface;
import android.os.Parcel;
import com.tencent.map.sdk.a.fz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PolygonOptions
{
  private final List<LatLng> a = new ArrayList();
  private float b = 1.0F;
  private int c = -16777216;
  private int d = fz.m;
  private int e = 0;
  private boolean f = true;
  private boolean g = false;
  private String h = "";
  private int i = -16777216;
  private Typeface j = Typeface.DEFAULT;
  private int k = 2147483647;
  private int l = 1;
  private int m = -1;
  private boolean n;
  private int o = OverlayLevel.OverlayLevelAboveLabels;
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    if (paramLatLng != null) {
      this.a.add(paramLatLng);
    }
    return this;
  }
  
  public PolygonOptions add(List<LatLng> paramList)
  {
    if (paramList != null) {
      this.a.addAll(paramList);
    }
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    if (paramVarArgs != null) {
      this.a.addAll(Arrays.asList(paramVarArgs));
    }
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        LatLng localLatLng = (LatLng)paramIterable.next();
        this.a.add(localLatLng);
      }
    }
    return this;
  }
  
  public PolygonOptions clickable(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public int getFillColor()
  {
    return this.d;
  }
  
  public int getLevel()
  {
    return this.o;
  }
  
  public List<LatLng> getPoints()
  {
    return this.a;
  }
  
  public int getStrokeColor()
  {
    return this.c;
  }
  
  public float getStrokeWidth()
  {
    return this.b;
  }
  
  public String getText()
  {
    return this.h;
  }
  
  public float getZIndex()
  {
    return this.e;
  }
  
  public boolean isClickable()
  {
    return this.n;
  }
  
  public boolean isVisible()
  {
    return this.f;
  }
  
  public PolygonOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.o = paramInt;
    return this;
  }
  
  public void setPoints(Iterable<LatLng> paramIterable)
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.clear();
    } while (paramIterable == null);
    addAll(paramIterable);
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.b = 1.0F;
      return this;
    }
    this.b = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeInt(this.d);
  }
  
  public PolygonOptions zIndex(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */