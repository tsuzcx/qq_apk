package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.map.sdk.a.kr;
import com.tencent.map.sdk.a.ld;

public class UiSettings
{
  private kr a = null;
  
  protected UiSettings() {}
  
  protected UiSettings(kr paramkr)
  {
    this.a = paramkr;
  }
  
  public boolean isCompassEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.b();
      }
    }
    return bool1;
  }
  
  public boolean isIndoorLevelPickerEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.h();
      }
    }
    return bool1;
  }
  
  public boolean isMyLocationButtonEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.c();
      }
    }
    return bool1;
  }
  
  public boolean isRotateGesturesEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.g();
      }
    }
    return bool1;
  }
  
  public boolean isScaleViewEnabled()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return false;
  }
  
  public boolean isScrollGesturesEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.d();
      }
    }
    return bool1;
  }
  
  public boolean isTiltGesturesEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.f();
      }
    }
    return bool1;
  }
  
  public boolean isZoomControlsEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.a();
      }
    }
    return bool1;
  }
  
  public boolean isZoomGesturesEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      kr localkr = this.a;
      bool1 = bool2;
      if (localkr.a != null) {
        bool1 = localkr.a.e();
      }
    }
    return bool1;
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.i(paramBoolean);
      }
    }
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.b(paramBoolean);
      }
    }
  }
  
  public void setCompassExtraPadding(int paramInt)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.c(paramInt);
      }
    }
  }
  
  public void setCompassExtraPadding(int paramInt1, int paramInt2)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.b(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFlingGestureEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.e(paramBoolean);
      }
    }
  }
  
  public void setGestureScaleByMapCenter(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.m(paramBoolean);
      }
    }
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.n(paramBoolean);
      }
    }
  }
  
  public final void setLogoPosition(int paramInt)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.a(paramInt);
      }
    }
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.a(paramInt, paramArrayOfInt);
      }
    }
  }
  
  public final void setLogoPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      }
    }
  }
  
  public void setLogoScale(float paramFloat)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.a(paramFloat);
      }
    }
  }
  
  public final void setLogoSize(int paramInt)
  {
    if ((this.a != null) && (this.a != null))
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.d(paramInt);
      }
    }
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.c(paramBoolean);
      }
    }
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.h(paramBoolean);
      }
    }
  }
  
  public void setScaleViewEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.j(paramBoolean);
      }
    }
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.b(paramInt);
      }
    }
  }
  
  public void setScaleViewPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      }
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.d(paramBoolean);
      }
    }
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.g(paramBoolean);
      }
    }
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.a(paramBoolean);
      }
    }
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.f(paramBoolean);
      }
    }
  }
  
  public final void setZoomPosition(int paramInt)
  {
    if (this.a != null)
    {
      kr localkr = this.a;
      if (localkr.a != null) {
        localkr.a.e(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.UiSettings
 * JD-Core Version:    0.7.0.1
 */