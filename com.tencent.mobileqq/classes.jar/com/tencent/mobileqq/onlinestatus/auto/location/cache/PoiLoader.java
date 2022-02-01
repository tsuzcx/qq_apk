package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

public class PoiLoader
{
  private int jdField_a_of_type_Int;
  private DiskLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheDiskLoader;
  private MemoryLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheMemoryLoader;
  private NetworkLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheNetworkLoader;
  private final String jdField_a_of_type_JavaLangString;
  
  public PoiLoader(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheNetworkLoader = new NetworkLoader(paramString);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheDiskLoader = new DiskLoader(paramString, paramInt3);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheMemoryLoader = new MemoryLoader(paramString, Math.max(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheDiskLoader.a() + paramInt2, 10));
  }
  
  private void a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheNetworkLoader.a(paramLatLng, paramInt, new PoiLoader.4(this, paramLatLng, paramInt, paramOnPoiLoadListener));
  }
  
  private boolean a(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheMemoryLoader.a(paramLatLng, paramInt, paramOnPoiLoadListener);
  }
  
  private boolean b(LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener)
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheDiskLoader.a(paramLatLng, paramInt, new PoiLoader.3(this, paramLatLng, paramInt, paramOnPoiLoadListener));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader
 * JD-Core Version:    0.7.0.1
 */