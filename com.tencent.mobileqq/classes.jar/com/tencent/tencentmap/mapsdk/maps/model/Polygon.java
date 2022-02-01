package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.gg;
import com.tencent.map.sdk.a.kp;
import com.tencent.map.sdk.a.la;
import java.util.List;

public final class Polygon
  implements IOverlay
{
  private PolygonOptions a = null;
  private String b = "";
  private kp c = null;
  private Object d;
  
  public Polygon(PolygonOptions paramPolygonOptions, kp paramkp, String paramString)
  {
    this.b = paramString;
    this.a = paramPolygonOptions;
    this.c = paramkp;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    List localList = getPoints();
    if ((localList != null) && (localList.size() >= 3))
    {
      if (paramLatLng == null) {
        return false;
      }
      int j = localList.size();
      int i = 0;
      while (i < localList.size())
      {
        if (((LatLng)localList.get(i)).equals(paramLatLng)) {
          return true;
        }
        i += 1;
      }
      j -= 1;
      i = 0;
      int m;
      for (int k = 0; i < localList.size(); k = m)
      {
        if ((((LatLng)localList.get(i)).latitude >= paramLatLng.latitude) || (((LatLng)localList.get(j)).latitude < paramLatLng.latitude))
        {
          m = k;
          if (((LatLng)localList.get(j)).latitude < paramLatLng.latitude)
          {
            m = k;
            if (((LatLng)localList.get(i)).latitude < paramLatLng.latitude) {}
          }
        }
        else if (((LatLng)localList.get(i)).longitude > paramLatLng.longitude)
        {
          m = k;
          if (((LatLng)localList.get(j)).longitude > paramLatLng.longitude) {}
        }
        else
        {
          if (((LatLng)localList.get(i)).longitude + (paramLatLng.latitude - ((LatLng)localList.get(i)).latitude) / (((LatLng)localList.get(j)).latitude - ((LatLng)localList.get(i)).latitude) * (((LatLng)localList.get(j)).longitude - ((LatLng)localList.get(i)).longitude) <= paramLatLng.longitude) {
            j = 1;
          } else {
            j = 0;
          }
          m = k ^ j;
        }
        j = i;
        i += 1;
      }
      return k;
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Polygon)) {
      return false;
    }
    paramObject = (Polygon)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public final int getFillColor()
  {
    return this.a.getFillColor();
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
    kp localkp = this.c;
    if (localkp != null)
    {
      String str = this.b;
      if (localkp.a == null) {
        return null;
      }
      return localkp.a.b(str);
    }
    return null;
  }
  
  public final List<LatLng> getPoints()
  {
    return this.a.getPoints();
  }
  
  public final int getStrokeColor()
  {
    return this.a.getStrokeColor();
  }
  
  public final float getStrokeWidth()
  {
    return this.a.getStrokeWidth();
  }
  
  public final Object getTag()
  {
    return this.d;
  }
  
  public final float getZIndex()
  {
    return this.a.getZIndex();
  }
  
  public final int hashCode()
  {
    return this.b.hashCode();
  }
  
  public final boolean isClickable()
  {
    PolygonOptions localPolygonOptions = this.a;
    if (localPolygonOptions != null) {
      return localPolygonOptions.isClickable();
    }
    return false;
  }
  
  public final boolean isVisible()
  {
    return this.a.isVisible();
  }
  
  public final void remove()
  {
    kp localkp = this.c;
    if (localkp == null) {
      return;
    }
    String str = this.b;
    if (localkp.a != null) {
      localkp.a.a(str);
    }
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.a.clickable(paramBoolean);
  }
  
  public final void setFillColor(int paramInt)
  {
    kp localkp = this.c;
    String str = this.b;
    if (localkp.a != null) {
      localkp.a.a(str, paramInt);
    }
    this.a.fillColor(paramInt);
  }
  
  public final void setLevel(int paramInt)
  {
    if (paramInt >= OverlayLevel.OverlayLevelAboveRoads)
    {
      if (paramInt > OverlayLevel.OverlayLevelAboveLabels) {
        return;
      }
      kp localkp = this.c;
      String str = this.b;
      if (localkp.a != null) {
        localkp.a.c(str, paramInt);
      }
      this.a.level(paramInt);
    }
  }
  
  public final void setOptions(PolygonOptions paramPolygonOptions)
  {
    kp localkp = this.c;
    String str = this.b;
    if (localkp.a != null) {
      localkp.a.a(str, paramPolygonOptions);
    }
    this.a = paramPolygonOptions;
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    kp localkp = this.c;
    if (localkp == null) {
      return;
    }
    String str = this.b;
    if (localkp.a != null) {
      localkp.a.a(str, paramList);
    }
    this.a.setPoints(paramList);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    kp localkp = this.c;
    String str = this.b;
    if (localkp.a != null) {
      localkp.a.b(str, paramInt);
    }
    this.a.strokeColor(paramInt);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    kp localkp = this.c;
    String str = this.b;
    if (localkp.a != null) {
      localkp.a.a(str, paramFloat);
    }
    this.a.strokeWidth(paramFloat);
  }
  
  public final void setTag(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    kp localkp = this.c;
    String str = this.b;
    if (localkp.a != null) {
      localkp.a.a(str, paramBoolean);
    }
    this.a.visible(paramBoolean);
  }
  
  public final void setZIndex(int paramInt)
  {
    kp localkp = this.c;
    String str = this.b;
    float f = paramInt;
    if (localkp.a != null) {
      localkp.a.b(str, f);
    }
    this.a.zIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Polygon
 * JD-Core Version:    0.7.0.1
 */