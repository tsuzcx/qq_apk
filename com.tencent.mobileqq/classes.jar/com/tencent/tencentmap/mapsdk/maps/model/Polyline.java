package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;
import com.tencent.map.sdk.a.gg;
import com.tencent.map.sdk.a.kq;
import com.tencent.map.sdk.a.lb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Polyline
  implements IOverlay
{
  @Deprecated
  public static final int DARK_BLUE = 6;
  @Deprecated
  public static final int DASHED = 33;
  @Deprecated
  public static final int DIDI_PSG_BLUE = 20;
  @Deprecated
  public static final int DIDI_PSG_SLIGHTBLUE = 0;
  @Deprecated
  public static final int GREEN = 4;
  @Deprecated
  public static final int GREY = 0;
  @Deprecated
  public static final int LIGHT_BLUE = 1;
  @Deprecated
  public static final int RED = 2;
  @Deprecated
  public static final int WHITE_BLUE = 19;
  @Deprecated
  public static final int YELLOW = 3;
  private PolylineOptions a = null;
  private String b = "";
  private kq c = null;
  private Object d;
  
  public Polyline(PolylineOptions paramPolylineOptions)
  {
    this(paramPolylineOptions, null, null);
  }
  
  public Polyline(PolylineOptions paramPolylineOptions, kq paramkq, String paramString)
  {
    this.b = paramString;
    this.a = paramPolylineOptions;
    this.c = paramkq;
  }
  
  public final void addTurnArrow(int paramInt1, int paramInt2)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.a(str, paramInt1, paramInt2);
    }
  }
  
  public final void cleanTurnArrow()
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.c(str);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Polyline)) {
      return false;
    }
    paramObject = (Polyline)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.a(str, paramInt, paramLatLng);
    }
  }
  
  public final int getColor()
  {
    return this.a.getColor();
  }
  
  public final int[][] getColors()
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a == null) {
      return null;
    }
    return localkq.a.b(str);
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
    if (this.c == null) {}
    kq localkq;
    String str;
    do
    {
      return null;
      localkq = this.c;
      str = this.b;
    } while (localkq.a == null);
    return localkq.a.e(str);
  }
  
  public final List<Integer> getPattern()
  {
    return this.a.getPattern();
  }
  
  public final List<LatLng> getPoints()
  {
    return this.a.getPoints();
  }
  
  public final PolylineOptions getPolylineOptions()
  {
    return this.a;
  }
  
  public final Object getTag()
  {
    return this.d;
  }
  
  public final PolylineOptions.Text getText()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.getText();
  }
  
  public final Rect getVisibleRect()
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a == null) {
      return new Rect();
    }
    return localkq.a.d(str);
  }
  
  public final float getWidth()
  {
    return this.a.getWidth();
  }
  
  public final int getZIndex()
  {
    return this.a.getZIndex();
  }
  
  public final int hashCode()
  {
    return this.b.hashCode();
  }
  
  public final boolean isAboveMaskLayer()
  {
    return this.a.b;
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
  
  public final void pattern(List<Integer> paramList)
  {
    this.a.pattern(paramList);
    setPolylineOptions(this.a);
  }
  
  public final void remove()
  {
    if (this.c == null) {}
    kq localkq;
    String str;
    do
    {
      return;
      localkq = this.c;
      str = this.b;
    } while (localkq.a == null);
    localkq.a.a(str);
  }
  
  public final void setAboveMaskLayer(boolean paramBoolean)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.c(str, paramBoolean);
    }
    this.a.b = paramBoolean;
  }
  
  public final void setArrow(boolean paramBoolean)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.b(str, paramBoolean);
    }
    this.a.arrow(paramBoolean);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.a.clickable(paramBoolean);
  }
  
  public final void setColor(int paramInt)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.a(str, paramInt);
    }
    this.a.color(paramInt);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.c.a(this.b, paramBitmapDescriptor);
  }
  
  @Deprecated
  public final void setColorTexture(String paramString)
  {
    this.c.a(this.b, BitmapDescriptorFactory.fromAsset(paramString));
  }
  
  public final void setColors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.a(str, paramArrayOfInt1, paramArrayOfInt2);
    }
    this.a.colors(paramArrayOfInt1, paramArrayOfInt2);
    this.a.c = true;
  }
  
  public final void setEraseable(boolean paramBoolean)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.d(str, paramBoolean);
    }
  }
  
  public final void setLevel(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return;
    }
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.b(str, paramInt);
    }
    this.a.level(paramInt);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.a(str, paramList);
    }
    this.a.setLatLngs(paramList);
  }
  
  public final void setPolylineOptions(PolylineOptions paramPolylineOptions)
  {
    if (paramPolylineOptions == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      this.a.arrow(paramPolylineOptions.isArrow());
      this.a.zIndex(paramPolylineOptions.getZIndex());
      this.a.width(paramPolylineOptions.getWidth());
      this.a.color(paramPolylineOptions.getColor());
      this.a.b = paramPolylineOptions.b;
      this.a.alpha(paramPolylineOptions.getAlpha());
      this.a.animation(paramPolylineOptions.getAnimation());
      this.a.visible(paramPolylineOptions.isVisible());
      localObject1 = this.a;
      Object localObject3 = paramPolylineOptions.getPoints();
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).add((LatLng)((Iterator)localObject3).next());
        }
      }
      ((PolylineOptions)localObject1).a.clear();
      ((PolylineOptions)localObject1).addAll((Iterable)localObject2);
      this.a.pattern(paramPolylineOptions.getPattern());
      localObject1 = this.c;
      localObject2 = this.b;
    } while (((kq)localObject1).a == null);
    ((kq)localObject1).a.a((String)localObject2, paramPolylineOptions);
  }
  
  public final void setTag(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public final void setText(PolylineOptions.Text paramText)
  {
    if ((this.c == null) || (this.a == null)) {
      return;
    }
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.a(str, paramText);
    }
    this.a.text(paramText);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    kq localkq = this.c;
    String str = this.b;
    if (localkq.a != null) {
      localkq.a.a(str, paramBoolean);
    }
    this.a.visible(paramBoolean);
  }
  
  public final void setWidth(float paramFloat)
  {
    float f = 128.0F;
    if (paramFloat < 0.0F) {
      paramFloat = 1.0F;
    }
    for (;;)
    {
      if (paramFloat > 128.0F) {
        paramFloat = f;
      }
      for (;;)
      {
        kq localkq = this.c;
        String str = this.b;
        if (localkq.a != null) {
          localkq.a.a(str, paramFloat);
        }
        this.a.width(paramFloat);
        return;
      }
    }
  }
  
  public final void setZIndex(int paramInt)
  {
    kq localkq = this.c;
    String str = this.b;
    float f = Math.max(0, paramInt);
    if (localkq.a != null) {
      localkq.a.b(str, f);
    }
    this.a.zIndex(Math.max(0, paramInt));
  }
  
  public final void startAnimation(Animation paramAnimation)
  {
    if (((paramAnimation instanceof AlphaAnimation)) || ((paramAnimation instanceof EmergeAnimation)))
    {
      if (this.c != null)
      {
        kq localkq = this.c;
        String str = this.b;
        if (localkq.a != null) {
          localkq.a.a(str, paramAnimation.glAnimation);
        }
      }
      return;
    }
    throw new IllegalArgumentException("Unsupported animation, only AlphaAnimation and EmergeAnimation allowed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Polyline
 * JD-Core Version:    0.7.0.1
 */