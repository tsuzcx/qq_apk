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
    if (this.b != null) {
      return this.b.getContentDescription();
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
    if (localBitmapDescriptor == null) {}
    do
    {
      return 0;
      paramContext = localBitmapDescriptor.getFormater().a(paramContext);
    } while (paramContext == null);
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
    if (((km)localObject1).a != null) {}
    for (localObject1 = ((km)localObject1).a.d((String)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b.getPosition();
      }
      return localObject2;
    }
  }
  
  public final float getRotation()
  {
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return 0.0F;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    return localkm.a.i(str);
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
    if (localBitmapDescriptor == null) {}
    do
    {
      return 0;
      paramContext = localBitmapDescriptor.getFormater().a(paramContext);
    } while (paramContext == null);
    return paramContext.getWidth();
  }
  
  public final float getZIndex()
  {
    if (this.b != null) {
      return this.b.getZIndex();
    }
    return 0.0F;
  }
  
  public final int hashCode()
  {
    return this.c.hashCode();
  }
  
  public final void hideInfoWindow()
  {
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    localkm.a.f(str);
  }
  
  public final boolean isClickable()
  {
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return false;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    return localkm.a.k(str);
  }
  
  public final boolean isDraggable()
  {
    return this.b.isDraggable();
  }
  
  public final boolean isFastLoad()
  {
    if (this.b == null) {
      return false;
    }
    return this.b.isFastLoad();
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
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return false;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    return localkm.a.h(str);
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
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    localkm.a.g(str);
  }
  
  public final void remove()
  {
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    localkm.a.a(str);
  }
  
  public final void setAlpha(float paramFloat)
  {
    if (this.e == null) {
      return;
    }
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.b(str, paramFloat);
    }
    this.b.alpha(paramFloat);
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2)
  {
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return;
      this.b.anchor(paramFloat1, paramFloat2);
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    localkm.a.a(str, paramFloat1, paramFloat2);
  }
  
  public final void setAnimation(Animation paramAnimation)
  {
    if ((this.e == null) || (paramAnimation == null)) {}
    km localkm;
    String str;
    do
    {
      return;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    localkm.a.a(str, paramAnimation);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    localkm.a.c(str, paramBoolean);
  }
  
  public final void setContentDescription(String paramString)
  {
    if (this.b != null) {
      this.b.contentDescription(paramString);
    }
  }
  
  public final void setDraggable(boolean paramBoolean)
  {
    boolean bool3 = false;
    if (this.e == null) {
      return;
    }
    this.e.b();
    km localkm1 = this.e;
    String str1 = this.c;
    boolean bool2 = bool3;
    km localkm2;
    String str2;
    if (!paramBoolean)
    {
      localkm2 = this.e;
      str2 = this.c;
      if (localkm2.a == null) {
        break label97;
      }
    }
    label97:
    for (boolean bool1 = localkm2.a.l(str2);; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      localkm1.a(str1, bool2);
      this.b.draggable(paramBoolean);
      return;
    }
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
      if (paramBoolean) {
        break label34;
      }
    }
    label34:
    for (paramBoolean = true;; paramBoolean = false)
    {
      setDraggable(paramBoolean);
      return;
    }
  }
  
  public final void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (this.e == null) {
      return;
    }
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramBitmapDescriptor);
    }
    this.b.icon(paramBitmapDescriptor);
  }
  
  public final void setInMapCenterState(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    km localkm = this.e;
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
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return;
    }
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramInt);
    }
    this.b.level(paramInt);
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
    if ((this.e == null) || (paramLatLng == null)) {
      return;
    }
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramLatLng);
    }
    this.b.position(paramLatLng);
  }
  
  public final void setRotation(float paramFloat)
  {
    if (this.e == null) {
      return;
    }
    km localkm = this.e;
    String str = this.c;
    if (localkm.a != null) {
      localkm.a.a(str, paramFloat);
    }
    this.b.rotation(paramFloat);
  }
  
  public final void setSnippet(String paramString)
  {
    if (this.e == null) {}
    String str;
    do
    {
      return;
      this.b.snippet(paramString);
      paramString = this.e;
      str = this.c;
    } while (paramString.a == null);
    paramString.a.b(str);
  }
  
  public final void setTag(Object paramObject)
  {
    this.i = paramObject;
  }
  
  public final void setTitle(String paramString)
  {
    if (this.e == null) {}
    String str;
    do
    {
      return;
      this.b.title(paramString);
      paramString = this.e;
      str = this.c;
    } while (paramString.a == null);
    paramString.a.c(str);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    km localkm = this.e;
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
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    localkm.a.e(str);
  }
  
  public final boolean startAnimation()
  {
    if (this.e == null) {}
    km localkm;
    String str;
    do
    {
      return false;
      localkm = this.e;
      str = this.c;
    } while (localkm.a == null);
    return localkm.a.j(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Marker
 * JD-Core Version:    0.7.0.1
 */