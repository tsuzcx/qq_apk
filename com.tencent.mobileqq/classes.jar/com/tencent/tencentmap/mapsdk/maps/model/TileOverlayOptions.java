package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.fz;

public final class TileOverlayOptions
{
  private TileProvider a;
  private volatile String b;
  private volatile String c;
  private int d = 1;
  private boolean e = true;
  private int f;
  
  public final TileOverlayOptions betterQuality(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public final TileOverlayOptions diskCacheDir(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public final String getDiskCacheDir()
  {
    return this.b;
  }
  
  public final int getMaxMemoryCacheSize()
  {
    if (this.f == 0) {
      return fz.t * 4;
    }
    return this.f;
  }
  
  public final TileProvider getTileProvider()
  {
    return this.a;
  }
  
  public final String getVersionInfo()
  {
    return this.c;
  }
  
  public final int getZIndex()
  {
    return this.d;
  }
  
  public final boolean isBetterQuality()
  {
    return this.e;
  }
  
  public final TileOverlayOptions maxMemoryCacheSize(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public final TileOverlayOptions tileProvider(TileProvider paramTileProvider)
  {
    this.a = paramTileProvider;
    return this;
  }
  
  public final TileOverlayOptions versionInfo(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public final TileOverlayOptions zIndex(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions
 * JD-Core Version:    0.7.0.1
 */