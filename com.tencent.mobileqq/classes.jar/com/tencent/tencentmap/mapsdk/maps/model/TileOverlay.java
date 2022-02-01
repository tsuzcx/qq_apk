package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.ix;
import com.tencent.map.sdk.a.mu;
import com.tencent.map.sdk.a.ny;
import java.util.Map;

public final class TileOverlay
{
  private final ix a;
  
  public TileOverlay(ix paramix)
  {
    this.a = paramix;
  }
  
  public final void clearTileCache()
  {
    ix localix = this.a;
    if (localix == null) {
      return;
    }
    if (localix.m != null)
    {
      localix.m.a();
      localix.j.clear();
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof TileOverlay)) {
      return false;
    }
    return this.a.equals(((TileOverlay)paramObject).a);
  }
  
  public final String getId()
  {
    ix localix = this.a;
    if (localix == null) {
      return "";
    }
    return localix.L;
  }
  
  public final int hashCode()
  {
    ix localix = this.a;
    if (localix == null) {
      return 0;
    }
    return localix.hashCode();
  }
  
  public final void reload()
  {
    ix localix = this.a;
    if (localix == null) {
      return;
    }
    localix.f();
  }
  
  public final void remove()
  {
    ix localix = this.a;
    if (localix == null) {
      return;
    }
    localix.b();
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    ix localix = this.a;
    if (localix == null) {
      return;
    }
    localix.a(paramString);
  }
  
  public final void setZindex(int paramInt)
  {
    ix localix = this.a;
    if (localix == null) {
      return;
    }
    localix.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
 * JD-Core Version:    0.7.0.1
 */