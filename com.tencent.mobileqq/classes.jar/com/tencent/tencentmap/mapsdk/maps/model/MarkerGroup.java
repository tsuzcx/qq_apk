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
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramMarker);
      }
    }
  }
  
  public void addMarkerById(String paramString)
  {
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramString);
      }
    }
  }
  
  public void addMarkerList(List<Marker> paramList)
  {
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramList);
      }
    }
  }
  
  public void clear()
  {
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str);
      }
    }
  }
  
  public boolean containMarker(Marker paramMarker)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      bool1 = bool2;
      if (localkn.a != null) {
        bool1 = localkn.a.c(str, paramMarker);
      }
    }
    return bool1;
  }
  
  public boolean containMarkerById(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      bool1 = bool2;
      if (localkn.a != null) {
        bool1 = localkn.a.d(str, paramString);
      }
    }
    return bool1;
  }
  
  public Marker findMarkerById(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      localObject1 = localObject2;
      if (localkn.a != null) {
        localObject1 = localkn.a.c(str, paramString);
      }
    }
    return localObject1;
  }
  
  public String getId()
  {
    return this.a;
  }
  
  public List<String> getMarkerIdList()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      localObject1 = localObject2;
      if (localkn.a != null) {
        localObject1 = localkn.a.c(str);
      }
    }
    return localObject1;
  }
  
  public List<Marker> getMarkerList()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      localObject1 = localObject2;
      if (localkn.a != null) {
        localObject1 = localkn.a.b(str);
      }
    }
    return localObject1;
  }
  
  public boolean removeMarker(Marker paramMarker)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      bool1 = bool2;
      if (localkn.a != null) {
        bool1 = localkn.a.b(str, paramMarker);
      }
    }
    return bool1;
  }
  
  public boolean removeMarkerById(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      bool1 = bool2;
      if (localkn.a != null) {
        bool1 = localkn.a.b(str, paramString);
      }
    }
    return bool1;
  }
  
  public void setMarkerGroupOnTapMapBubblesHidden(boolean paramBoolean)
  {
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.d(str);
      }
    }
  }
  
  public void setMarkerGroupOnTapMapInfoWindowHidden(boolean paramBoolean)
  {
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      if (localkn.a != null) {
        localkn.a.a(str, paramBoolean);
      }
    }
  }
  
  public boolean setMarkerOnTapMapBubblesHidden(Marker paramMarker, boolean paramBoolean)
  {
    boolean bool = false;
    paramBoolean = bool;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      paramBoolean = bool;
      if (localkn.a != null) {
        paramBoolean = localkn.a.d(str, paramMarker);
      }
    }
    return paramBoolean;
  }
  
  public boolean setOnTapMapBubblesHiddenById(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    paramBoolean = bool;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      paramBoolean = bool;
      if (localkn.a != null) {
        paramBoolean = localkn.a.e(str, paramString);
      }
    }
    return paramBoolean;
  }
  
  public boolean updateMarkerOptionById(String paramString, MarkerOptions paramMarkerOptions)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      kn localkn = this.b;
      String str = this.a;
      bool1 = bool2;
      if (localkn.a != null) {
        bool1 = localkn.a.a(str, paramString, paramMarkerOptions);
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MarkerGroup
 * JD-Core Version:    0.7.0.1
 */