package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.rastercore.d.a.1;

public final class UiSettings
{
  public static final int LOGO_POSITION_CENTER_BOTTOM = 4;
  public static final int LOGO_POSITION_CENTER_TOP = 5;
  public static final int LOGO_POSITION_LEFT_BOTTOM = 0;
  public static final int LOGO_POSITION_LEFT_TOP = 3;
  public static final int LOGO_POSITION_RIGHT_BOTTOM = 1;
  public static final int LOGO_POSITION_RIGHT_TOP = 2;
  public static final int SCALEVIEW_POSITION_CENTER_BOTTOM = 1;
  public static final int SCALEVIEW_POSITION_LEFT_BOTTOM = 0;
  public static final int SCALEVIEW_POSITION_RIGHT_BOTTOM = 2;
  private a.1 uiSettingsDelegate$41cd271b;
  
  public UiSettings(a.1 param1)
  {
    this.uiSettingsDelegate$41cd271b = param1;
  }
  
  protected final int getLogoPosition()
  {
    return this.uiSettingsDelegate$41cd271b.j();
  }
  
  protected final int getScaleViewPosition()
  {
    return this.uiSettingsDelegate$41cd271b.f();
  }
  
  public final boolean isAnimationEnabled()
  {
    return this.uiSettingsDelegate$41cd271b.k();
  }
  
  protected final boolean isScaleControlsEnabled()
  {
    return this.uiSettingsDelegate$41cd271b.g();
  }
  
  protected final boolean isScrollGesturesEnabled()
  {
    return this.uiSettingsDelegate$41cd271b.h();
  }
  
  protected final boolean isZoomGesturesEnabled()
  {
    return this.uiSettingsDelegate$41cd271b.i();
  }
  
  protected final void setAllGesturesEnabled(boolean paramBoolean)
  {
    this.uiSettingsDelegate$41cd271b.d(paramBoolean);
  }
  
  public final void setAnimationEnabled(boolean paramBoolean)
  {
    this.uiSettingsDelegate$41cd271b.e(paramBoolean);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    this.uiSettingsDelegate$41cd271b.b(paramInt);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    this.uiSettingsDelegate$41cd271b.a(paramBoolean);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    this.uiSettingsDelegate$41cd271b.c(paramInt);
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.uiSettingsDelegate$41cd271b.b(paramBoolean);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.uiSettingsDelegate$41cd271b.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.UiSettings
 * JD-Core Version:    0.7.0.1
 */