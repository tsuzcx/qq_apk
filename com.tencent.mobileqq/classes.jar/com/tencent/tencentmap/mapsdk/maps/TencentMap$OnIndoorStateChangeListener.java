package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;

public abstract interface TencentMap$OnIndoorStateChangeListener
{
  public abstract boolean onIndoorBuildingDeactivated();
  
  public abstract boolean onIndoorBuildingFocused();
  
  public abstract boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
 * JD-Core Version:    0.7.0.1
 */