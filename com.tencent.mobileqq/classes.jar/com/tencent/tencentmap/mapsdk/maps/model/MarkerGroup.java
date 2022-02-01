package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.kn;
import com.tencent.map.sdk.a.ky;
import java.util.List;

public class MarkerGroup
{
  private String a = "";
  private kn b;
  
  public MarkerGroup(kn paramkn, String paramString)
  {
    this.b = paramkn;
    this.a = paramString;
  }
  
  public void addMarker(Marker paramMarker)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramMarker);
      }
    }
  }
  
  public void addMarkerById(String paramString)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramString);
      }
    }
  }
  
  public void addMarkerList(List<Marker> paramList)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramList);
      }
    }
  }
  
  public void clear()
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str);
      }
    }
  }
  
  public boolean containMarker(Marker paramMarker)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.c(str, paramMarker);
      }
    }
    return false;
  }
  
  public boolean containMarkerById(String paramString)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.d(str, paramString);
      }
    }
    return false;
  }
  
  public Marker findMarkerById(String paramString)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.c(str, paramString);
      }
    }
    return null;
  }
  
  public String getId()
  {
    return this.a;
  }
  
  public List<String> getMarkerIdList()
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.c(str);
      }
    }
    return null;
  }
  
  public List<Marker> getMarkerList()
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.b(str);
      }
    }
    return null;
  }
  
  public boolean removeMarker(Marker paramMarker)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.b(str, paramMarker);
      }
    }
    return false;
  }
  
  public boolean removeMarkerById(String paramString)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.b(str, paramString);
      }
    }
    return false;
  }
  
  public void setMarkerGroupOnTapMapBubblesHidden(boolean paramBoolean)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.d(str);
      }
    }
  }
  
  public void setMarkerGroupOnTapMapInfoWindowHidden(boolean paramBoolean)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramBoolean);
      }
    }
  }
  
  public boolean setMarkerOnTapMapBubblesHidden(Marker paramMarker, boolean paramBoolean)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.d(str, paramMarker);
      }
    }
    return false;
  }
  
  public boolean setOnTapMapBubblesHiddenById(String paramString, boolean paramBoolean)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.e(str, paramString);
      }
    }
    return false;
  }
  
  public boolean updateMarkerOptionById(String paramString, MarkerOptions paramMarkerOptions)
  {
    kn localkn = this.b;
    if (localkn != null)
    {
      String str = this.a;
      if (localkn.a != null) {
        return localkn.a.a(str, paramString, paramMarkerOptions);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MarkerGroup
 * JD-Core Version:    0.7.0.1
 */