package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.sdk.a.gg;
import com.tencent.map.sdk.a.hf;
import com.tencent.map.sdk.a.km;
import com.tencent.map.sdk.a.kx;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import java.util.List;

public final class Marker
  implements IOverlay
{
  private boolean a = false;
  private MarkerOptions b = null;
  private String c = "";
  private boolean d = false;
  private km e = null;
  private int f = 0;
  private boolean g = false;
  private TencentMap.OnMarkerDragListener h;
  private Object i;
  
  public Marker(MarkerOptions paramMarkerOptions, km paramkm, String paramString)
  {
    this.c = paramString;
    this.b = paramMarkerOptions;
    this.e = paramkm;
    this.g = paramMarkerOptions.b;
    this.f = paramMarkerOptions.a;
    this.i = this.b.getTag();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Marker)) {
      return false;
    }
    paramObject = (Marker)paramObject;
    return this.c.equals(paramObject.c);
  }
  
  public final float getAlpha()
  {
    return this.b.getAlpha();
  }
  
  public final float getAnchorU()
  {
    return this.b.getAnchorU();
  }
  
  public final float getAnchorV()
  {
    return this.b.getAnchorV();
  }
  
  public final String getContentDescription()
  {
    MarkerOptions localMarkerOptions = this.b;
    if (localMarkerOptions != null) {
      return localMarkerOptions.getContentDescription();
    }
    return null;
  }
  
  public final int getDisplayLevel()
  {
    return this.f;
  }
  
  public final int getHeight(Context paramContext)
  {
    BitmapDescriptor localBitmapDescriptor = this.b.getIcon();
    if (localBitmapDescriptor == null) {
      return 0;
    }
    paramContext = localBitmapDescriptor.getFormater().a(paramContext);
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getHeight();
  }
  
  public final String getId()
  {
    return this.c;
  }
  
  public final int getLevel()
  {
    return this.b.getLevel();
  }
  
  public final List<gg> getMapElements()
  {
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      return localkm.a.m(str);
    }
    return null;
  }
  
  public final TencentMap.OnMarkerDragListener getOnDragListener()
  {
    return this.h;
  }
  
  public final MarkerOptions getOptions()
  {
    return this.b;
  }
  
  public final LatLng getPosition()
  {
    Object localObject1 = this.e;
    Object localObject2 = this.c;
    if (((km)localObject1).a != null) {
      localObject1 = ((km)localObject1).a.d((String)localObject2);
    } else {
      localObject1 = null;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.b.getPosition();
    }
    return localObject2;
  }
  
  public final float getRotation()
  {
    km localkm = this.e;
    if (localkm == null) {
      return 0.0F;
    }
    String str = this.c;
    if (localkm.a != null) {
      return localkm.a.i(str);
    }
    return 0.0F;
  }
  
  public final String getSnippet()
  {
    return this.b.getSnippet();
  }
  
  public final Object getTag()
  {
    return this.i;
  }
  
  public final String getTitle()
  {
    return this.b.getTitle();
  }
  
  public final int getWidth(Context paramContext)
  {
    BitmapDescriptor localBitmapDescriptor = this.b.getIcon();
    if (localBitmapDescriptor == null) {
      return 0;
    }
    paramContext = localBitmapDescriptor.getFormater().a(paramContext);
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getWidth();
  }
  
  public final float getZIndex()
  {
    MarkerOptions localMarkerOptions = this.b;
    if (localMarkerOptions != null) {
      return localMarkerOptions.getZIndex();
    }
    return 0.0F;
  }
  
  public final int hashCode()
  {
    return this.c.hashCode();
  }
  
  public final void hideInfoWindow()
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.f(str);
    }
  }
  
  public final boolean isClickable()
  {
    km localkm = this.e;
    if (localkm == null) {
      return false;
    }
    String str = this.c;
    if (localkm.a != null) {
      return localkm.a.k(str);
    }
    return false;
  }
  
  public final boolean isDraggable()
  {
    return this.b.isDraggable();
  }
  
  public final boolean isFastLoad()
  {
    MarkerOptions localMarkerOptions = this.b;
    if (localMarkerOptions == null) {
      return false;
    }
    return localMarkerOptions.isFastLoad();
  }
  
  public final boolean isInMapCenterState()
  {
    return this.d;
  }
  
  public final boolean isInfoWindowAutoOverturn()
  {
    return this.g;
  }
  
  public final boolean isInfoWindowEnable()
  {
    return this.b.isInfoWindowEnable();
  }
  
  public final boolean isInfoWindowShown()
  {
    km localkm = this.e;
    if (localkm == null) {
      return false;
    }
    String str = this.c;
    if (localkm.a != null) {
      return localkm.a.h(str);
    }
    return false;
  }
  
  public final boolean isVisible()
  {
    if (this.e == null) {
      return false;
    }
    return this.b.isVisible();
  }
  
  public final boolean onTapMapViewBubbleHidden()
  {
    return this.a;
  }
  
  public final void refreshInfoWindow()
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.g(str);
    }
  }
  
  public final void remove()
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str);
    }
  }
  
  public final void setAlpha(float paramFloat)
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.b(str, paramFloat);
    }
    this.b.alpha(paramFloat);
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2)
  {
    if (this.e == null) {
      return;
    }
    this.b.anchor(paramFloat1, paramFloat2);
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramFloat1, paramFloat2);
    }
  }
  
  public final void setAnimation(Animation paramAnimation)
  {
    km localkm = this.e;
    if (localkm != null)
    {
      if (paramAnimation == null) {
        return;
      }
      String str = this.c;
      if (localkm.a != null) {
        localkm.a.a(str, paramAnimation);
      }
    }
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.c(str, paramBoolean);
    }
  }
  
  public final void setContentDescription(String paramString)
  {
    MarkerOptions localMarkerOptions = this.b;
    if (localMarkerOptions != null) {
      localMarkerOptions.contentDescription(paramString);
    }
  }
  
  public final void setDraggable(boolean paramBoolean)
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    localkm.b();
    localkm = this.e;
    String str = this.c;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (!paramBoolean)
    {
      boolean bool1;
      if (localkm.a != null) {
        bool1 = localkm.a.l(str);
      } else {
        bool1 = false;
      }
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    localkm.a(str, bool2);
    this.b.draggable(paramBoolean);
  }
  
  public final void setFastLoad(boolean paramBoolean)
  {
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.n(str);
    }
    this.b.fastLoad(paramBoolean);
  }
  
  public final void setFixingPoint(int paramInt1, int paramInt2)
  {
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramInt1, paramInt2);
    }
    this.e.b();
    this.b.draggable(false);
  }
  
  public final void setFixingPointEnable(boolean paramBoolean)
  {
    this.e.a(this.c, paramBoolean);
    if (this.b.isDraggable()) {
      setDraggable(paramBoolean ^ true);
    }
  }
  
  public final void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramBitmapDescriptor);
    }
    this.b.icon(paramBitmapDescriptor);
  }
  
  public final void setInMapCenterState(boolean paramBoolean)
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.b(str, paramBoolean);
    }
    this.d = paramBoolean;
  }
  
  public final void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    if (this.e == null) {
      return;
    }
    this.b.infoWindowAnchor(paramFloat1, paramFloat2);
    refreshInfoWindow();
  }
  
  public final void setInfoWindowEnable(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    this.b.infoWindowEnable(paramBoolean);
  }
  
  public final void setInfoWindowOffset(int paramInt1, int paramInt2)
  {
    if (this.e == null) {
      return;
    }
    this.b.infoWindowOffset(paramInt1, paramInt2);
    refreshInfoWindow();
  }
  
  public final void setLevel(int paramInt)
  {
    if (paramInt >= OverlayLevel.OverlayLevelAboveRoads)
    {
      if (paramInt > OverlayLevel.OverlayLevelAboveLabels) {
        return;
      }
      km localkm = this.e;
      String str = this.c;
      if (localkm.a != null) {
        localkm.a.a(str, paramInt);
      }
      this.b.level(paramInt);
    }
  }
  
  public final void setMarkerOptions(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions == null) {
      return;
    }
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramMarkerOptions);
    }
    this.b.position(paramMarkerOptions.getPosition()).anchor(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV()).title(paramMarkerOptions.getTitle()).snippet(paramMarkerOptions.getSnippet()).draggable(paramMarkerOptions.isDraggable()).visible(paramMarkerOptions.isVisible()).rotation(paramMarkerOptions.getRotation()).icon(paramMarkerOptions.getIcon()).alpha(paramMarkerOptions.getAlpha()).zIndex(paramMarkerOptions.getZIndex());
  }
  
  public final void setOnTapMapViewBubbleHidden(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    this.a = paramBoolean;
  }
  
  public final void setPosition(LatLng paramLatLng)
  {
    km localkm = this.e;
    if (localkm != null)
    {
      if (paramLatLng == null) {
        return;
      }
      String str = this.c;
      if (localkm.a != null) {
        localkm.a.a(str, paramLatLng);
      }
      this.b.position(paramLatLng);
    }
  }
  
  public final void setRotation(float paramFloat)
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramFloat);
    }
    this.b.rotation(paramFloat);
  }
  
  public final void setSnippet(String paramString)
  {
    if (this.e == null) {
      return;
    }
    this.b.snippet(paramString);
    paramString = this.e;
    String str = this.c;
    if (paramString.a != null) {
      paramString.a.b(str);
    }
  }
  
  public final void setTag(Object paramObject)
  {
    this.i = paramObject;
  }
  
  public final void setTitle(String paramString)
  {
    if (this.e == null) {
      return;
    }
    this.b.title(paramString);
    paramString = this.e;
    String str = this.c;
    if (paramString.a != null) {
      paramString.a.c(str);
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramBoolean);
    }
    this.b.visible(paramBoolean);
  }
  
  public final void setZIndex(float paramFloat)
  {
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.c(str, paramFloat);
    }
    this.b.zIndex(paramFloat);
  }
  
  public final void showInfoWindow()
  {
    km localkm = this.e;
    if (localkm == null) {
      return;
    }
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.e(str);
    }
  }
  
  public final boolean startAnimation()
  {
    km localkm = this.e;
    if (localkm == null) {
      return false;
    }
    String str = this.c;
    if (localkm.a != null) {
      return localkm.a.j(str);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Marker
 * JD-Core Version:    0.7.0.1
 */