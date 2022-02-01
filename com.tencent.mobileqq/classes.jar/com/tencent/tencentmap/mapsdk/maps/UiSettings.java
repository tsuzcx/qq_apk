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
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.b();
    }
    return false;
  }
  
  public boolean isIndoorLevelPickerEnabled()
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.h();
    }
    return false;
  }
  
  public boolean isMyLocationButtonEnabled()
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.c();
    }
    return false;
  }
  
  public boolean isRotateGesturesEnabled()
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.g();
    }
    return false;
  }
  
  public boolean isScaleViewEnabled()
  {
    kr localkr = this.a;
    if (localkr != null) {
      return localkr.a();
    }
    return false;
  }
  
  public boolean isScrollGesturesEnabled()
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.d();
    }
    return false;
  }
  
  public boolean isTiltGesturesEnabled()
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.f();
    }
    return false;
  }
  
  public boolean isZoomControlsEnabled()
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.a();
    }
    return false;
  }
  
  public boolean isZoomGesturesEnabled()
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      return localkr.a.e();
    }
    return false;
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.i(paramBoolean);
    }
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.b(paramBoolean);
    }
  }
  
  public void setCompassExtraPadding(int paramInt)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.c(paramInt);
    }
  }
  
  public void setCompassExtraPadding(int paramInt1, int paramInt2)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.b(paramInt1, paramInt2);
    }
  }
  
  public void setFlingGestureEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.e(paramBoolean);
    }
  }
  
  public void setGestureScaleByMapCenter(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.m(paramBoolean);
    }
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.n(paramBoolean);
    }
  }
  
  public final void setLogoPosition(int paramInt)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.a(paramInt);
    }
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.a(paramInt, paramArrayOfInt);
    }
  }
  
  public final void setLogoPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setLogoScale(float paramFloat)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.a(paramFloat);
    }
  }
  
  public final void setLogoSize(int paramInt)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr != null) && (localkr.a != null)) {
      localkr.a.d(paramInt);
    }
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.c(paramBoolean);
    }
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.h(paramBoolean);
    }
  }
  
  public void setScaleViewEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.j(paramBoolean);
    }
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.b(paramInt);
    }
  }
  
  public void setScaleViewPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.d(paramBoolean);
    }
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.g(paramBoolean);
    }
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.a(paramBoolean);
    }
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.f(paramBoolean);
    }
  }
  
  public final void setZoomPosition(int paramInt)
  {
    kr localkr = this.a;
    if ((localkr != null) && (localkr.a != null)) {
      localkr.a.e(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.UiSettings
 * JD-Core Version:    0.7.0.1
 */