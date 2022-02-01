package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding
  implements Cloneable
{
  private String a;
  private String b;
  private int c;
  private List<IndoorLevel> d;
  private LatLng e;
  
  public IndoorBuilding(String paramString1, String paramString2, LatLng paramLatLng, List<IndoorLevel> paramList, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramLatLng;
    this.d = paramList;
    this.c = paramInt;
  }
  
  protected final Object clone()
  {
    IndoorBuilding localIndoorBuilding = (IndoorBuilding)super.clone();
    if (this.d != null)
    {
      localIndoorBuilding.d = new ArrayList(this.d.size());
      int i = 0;
      while (i < this.d.size())
      {
        localIndoorBuilding.d.add(new IndoorLevel(((IndoorLevel)this.d.get(i)).getName()));
        i += 1;
      }
    }
    if (this.e != null) {
      localIndoorBuilding.e = new LatLng(this.e.latitude, this.e.longitude);
    }
    return localIndoorBuilding;
  }
  
  public final int getActiveLevelIndex()
  {
    return this.c;
  }
  
  public final String getBuidlingId()
  {
    return this.a;
  }
  
  public final LatLng getBuildingLatLng()
  {
    return this.e;
  }
  
  public final String getBuildingName()
  {
    return this.b;
  }
  
  public final List<IndoorLevel> getLevels()
  {
    return this.d;
  }
  
  public final String toString()
  {
    if ((this.a == null) || (this.d == null) || (this.d.size() <= this.c)) {
      return "";
    }
    return this.a + "_" + ((IndoorLevel)this.d.get(this.c)).getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding
 * JD-Core Version:    0.7.0.1
 */