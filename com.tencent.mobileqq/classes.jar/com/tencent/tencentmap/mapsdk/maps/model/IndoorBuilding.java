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
    Object localObject = this.d;
    if (localObject != null)
    {
      localIndoorBuilding.d = new ArrayList(((List)localObject).size());
      int i = 0;
      while (i < this.d.size())
      {
        localIndoorBuilding.d.add(new IndoorLevel(((IndoorLevel)this.d.get(i)).getName()));
        i += 1;
      }
    }
    localObject = this.e;
    if (localObject != null) {
      localIndoorBuilding.e = new LatLng(((LatLng)localObject).latitude, this.e.longitude);
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
    if (this.a != null)
    {
      Object localObject = this.d;
      if ((localObject != null) && (((List)localObject).size() > this.c))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(((IndoorLevel)this.d.get(this.c)).getName());
        return ((StringBuilder)localObject).toString();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding
 * JD-Core Version:    0.7.0.1
 */