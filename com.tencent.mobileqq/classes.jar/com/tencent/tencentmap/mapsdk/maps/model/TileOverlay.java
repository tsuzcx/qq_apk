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
    if (this.a == null) {}
    ix localix;
    do
    {
      return;
      localix = this.a;
    } while (localix.m == null);
    localix.m.a();
    localix.j.clear();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof TileOverlay)) {
      return false;
    }
    return this.a.equals(((TileOverlay)paramObject).a);
  }
  
  public final String getId()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.L;
  }
  
  public final int hashCode()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.hashCode();
  }
  
  public final void reload()
  {
    if (this.a == null) {
      return;
    }
    this.a.f();
  }
  
  public final void remove()
  {
    if (this.a == null) {
      return;
    }
    this.a.b();
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramString);
  }
  
  public final void setZindex(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TileOverlay
 * JD-Core Version:    0.7.0.1
 */