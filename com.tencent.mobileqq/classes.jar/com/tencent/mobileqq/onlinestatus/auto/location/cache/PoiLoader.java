package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

public class PoiLoader
{
  MemoryLoader a;
  DiskLoader b;
  NetworkLoader c;
  private final String d;
  private int e;
  
  public PoiLoader(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramString;
    this.e = paramInt1;
    this.c = new NetworkLoader(paramString);
    this.b = new DiskLoader(paramString, paramInt3);
    this.a = new MemoryLoader(paramString, Math.max(paramInt2 + this.b.a(), 10));
  }
  
  private boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    return this.a.a(paramLatLng, paramInt, paramOnPoiLoadListener);
  }
  
  private boolean b(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    return this.b.a(paramLatLng, paramInt, new PoiLoader.3(this, paramLatLng, paramInt, paramOnPoiLoadListener));
  }
  
  private void c(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    this.c.a(paramLatLng, paramInt, new PoiLoader.4(this, paramLatLng, paramInt, paramOnPoiLoadListener));
  }
  
  public void a(LatLng paramLatLng)
  {
    a(paramLatLng, new PoiLoader.2(this, paramLatLng));
  }
  
  public void a(LatLng paramLatLng, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    ThreadManager.getSubThreadHandler().post(new PoiLoader.1(this, paramLatLng, paramOnPoiLoadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader
 * JD-Core Version:    0.7.0.1
 */