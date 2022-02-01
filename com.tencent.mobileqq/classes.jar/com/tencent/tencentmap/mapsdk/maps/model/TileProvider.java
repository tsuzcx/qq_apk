package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.fy;

public abstract interface TileProvider
{
  public static final Tile NO_TILE = new Tile(-1, -1, fy.a());
  
  public abstract Tile getTile(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TileProvider
 * JD-Core Version:    0.7.0.1
 */