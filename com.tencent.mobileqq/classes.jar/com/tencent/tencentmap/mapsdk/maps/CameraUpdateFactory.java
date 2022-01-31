package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Point;
import com.tencent.map.sdk.a.ga;
import com.tencent.map.sdk.a.hg;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import java.util.ArrayList;
import java.util.List;

public final class CameraUpdateFactory
{
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    hg localhg = new hg();
    localhg.o = hg.g;
    localhg.v = paramCameraPosition;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    hg localhg = new hg();
    localhg.o = hg.h;
    localhg.w = paramLatLng;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    hg localhg = new hg();
    localhg.o = hg.j;
    localhg.z = paramLatLngBounds;
    localhg.A = paramInt;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate newLatLngBoundsRect(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    hg localhg = new hg();
    localhg.o = hg.l;
    localhg.B = paramLatLngBounds;
    localhg.F = paramInt1;
    localhg.G = paramInt2;
    localhg.H = paramInt3;
    localhg.I = paramInt4;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds paramLatLngBounds, LatLng paramLatLng, int paramInt)
  {
    if (paramLatLngBounds == null) {
      return null;
    }
    LatLng localLatLng1 = paramLatLngBounds.northeast;
    LatLng localLatLng2 = ga.a(paramLatLng, localLatLng1);
    paramLatLngBounds = paramLatLngBounds.southwest;
    paramLatLng = ga.a(paramLatLng, paramLatLngBounds);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localLatLng1);
    localArrayList.add(localLatLng2);
    localArrayList.add(paramLatLngBounds);
    localArrayList.add(paramLatLng);
    return newLatLngBounds(new LatLngBounds.Builder().include(localArrayList).build(), paramInt);
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    hg localhg = new hg();
    localhg.o = hg.i;
    localhg.x = paramLatLng;
    localhg.y = paramFloat;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate rotateTo(float paramFloat1, float paramFloat2)
  {
    hg localhg = new hg();
    localhg.o = hg.m;
    localhg.J = paramFloat1;
    localhg.K = paramFloat2;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    hg localhg = new hg();
    localhg.o = hg.c;
    localhg.p = paramFloat1;
    localhg.q = paramFloat2;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    hg localhg = new hg();
    localhg.o = hg.e;
    localhg.s = paramFloat;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    hg localhg = new hg();
    localhg.o = hg.f;
    localhg.t = paramFloat;
    localhg.u = paramPoint;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate zoomIn()
  {
    hg localhg = new hg();
    localhg.o = hg.a;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate zoomOut()
  {
    hg localhg = new hg();
    localhg.o = hg.b;
    return new CameraUpdate(localhg);
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    hg localhg = new hg();
    localhg.o = hg.d;
    localhg.r = paramFloat;
    return new CameraUpdate(localhg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory
 * JD-Core Version:    0.7.0.1
 */