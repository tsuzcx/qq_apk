package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.map.sdk.a.fy;

public class BubbleOptions
{
  private Marker a;
  private String b;
  private LatLng c;
  private int d = 0;
  private int e = 0;
  private float f = 0.5F;
  private float g = 0.5F;
  private int h = 0;
  private View i;
  private Drawable[] j = null;
  private boolean k = false;
  
  public BubbleOptions background(Bitmap[] paramArrayOfBitmap)
  {
    if (paramArrayOfBitmap != null)
    {
      this.j = new Drawable[4];
      int m = 0;
      int n = paramArrayOfBitmap.length;
      while (m < n)
      {
        this.j[m] = fy.a(paramArrayOfBitmap[m]);
        m += 1;
      }
    }
    return this;
  }
  
  public BubbleOptions background(Drawable[] paramArrayOfDrawable)
  {
    this.j = paramArrayOfDrawable;
    return this;
  }
  
  public BubbleOptions content(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public BubbleOptions contentView(View paramView)
  {
    this.i = paramView;
    return this;
  }
  
  public BubbleOptions displayLevel(int paramInt)
  {
    int m = paramInt;
    if (paramInt < 0) {
      m = 0;
    }
    this.h = m;
    return this;
  }
  
  public Drawable[] getBackground()
  {
    return this.j;
  }
  
  public String getContent()
  {
    return this.b;
  }
  
  public View getContentView()
  {
    return this.i;
  }
  
  public int getDisplayLevel()
  {
    return this.h;
  }
  
  public Marker getMarker()
  {
    return this.a;
  }
  
  public float getMarkerAnchorU()
  {
    return this.f;
  }
  
  public float getMarkerAnchorV()
  {
    return this.g;
  }
  
  public int getMarkerHeight()
  {
    return this.e;
  }
  
  public int getMarkerWidth()
  {
    return this.d;
  }
  
  public boolean getOnTapHidden()
  {
    return this.k;
  }
  
  public LatLng getPosition()
  {
    return this.c;
  }
  
  public BubbleOptions marker(Marker paramMarker)
  {
    this.a = paramMarker;
    position(paramMarker.getPosition());
    markerAnchor(paramMarker.getAnchorU(), paramMarker.getAnchorV());
    return this;
  }
  
  public BubbleOptions markerAnchor(float paramFloat1, float paramFloat2)
  {
    this.f = paramFloat1;
    this.g = paramFloat2;
    return this;
  }
  
  public BubbleOptions markerSize(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    return this;
  }
  
  public BubbleOptions position(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public BubbleOptions setOnTapHidden(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BubbleOptions
 * JD-Core Version:    0.7.0.1
 */