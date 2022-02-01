package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.ko;
import com.tencent.map.sdk.a.kz;

public final class MaskLayer
{
  private ko a;
  
  public MaskLayer(MaskLayerOptions paramMaskLayerOptions, ko paramko)
  {
    this.a = paramko;
  }
  
  public final String getId()
  {
    return null;
  }
  
  public final MaskLayerOptions getOptions()
  {
    ko localko = this.a;
    if (localko.a == null) {
      return null;
    }
    return localko.a.a();
  }
  
  public final int getZIndex()
  {
    ko localko = this.a;
    if (localko.a == null) {
      return 0;
    }
    return localko.a.c();
  }
  
  public final boolean isClickable()
  {
    return false;
  }
  
  public final boolean isVisible()
  {
    ko localko = this.a;
    if (localko.a == null) {
      return false;
    }
    return localko.a.d();
  }
  
  public final void remove()
  {
    ko localko = this.a;
    if (localko.a != null) {
      localko.a.b();
    }
  }
  
  public final void remove(long paramLong)
  {
    ko localko = this.a;
    if (localko.a != null) {
      localko.a.a(paramLong);
    }
  }
  
  public final void setOptions(MaskLayerOptions paramMaskLayerOptions)
  {
    ko localko = this.a;
    if (localko.a != null) {
      localko.a.a(paramMaskLayerOptions);
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    ko localko = this.a;
    if (localko.a != null) {
      localko.a.a(paramBoolean);
    }
  }
  
  public final void setZIndex(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MaskLayer
 * JD-Core Version:    0.7.0.1
 */