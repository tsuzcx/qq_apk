package com.tencent.tencentmap.mapsdk.maps;

public abstract interface LocationSource
{
  public abstract void activate(LocationSource.OnLocationChangedListener paramOnLocationChangedListener);
  
  public abstract void deactivate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.LocationSource
 * JD-Core Version:    0.7.0.1
 */