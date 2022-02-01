package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import awpi;
import awrd;
import awre;
import awtg;
import azle;
import azlh;
import azlj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationMapWidget
  extends TextureMapView
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  awpi jdField_a_of_type_Awpi;
  private awre jdField_a_of_type_Awre;
  private azle jdField_a_of_type_Azle;
  private azlh jdField_a_of_type_Azlh;
  azlj jdField_a_of_type_Azlj;
  protected TencentMap a;
  private CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  protected Map<String, Marker> a;
  awpi jdField_b_of_type_Awpi;
  private Map<String, Marker> jdField_b_of_type_JavaUtilMap = new HashMap(10);
  
  public LocationMapWidget(Context paramContext)
  {
    this(paramContext, (TencentMapOptions)null);
  }
  
  public LocationMapWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LocationMapWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext.getApplicationContext(), paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilMap = new HashMap(10);
    this.jdField_a_of_type_Int = 0;
  }
  
  public LocationMapWidget(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext.getApplicationContext(), paramTencentMapOptions);
    this.jdField_a_of_type_JavaUtilMap = new HashMap(10);
    this.jdField_a_of_type_Int = 0;
  }
  
  private List<String> a()
  {
    ArrayList localArrayList = new ArrayList(30);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_b_of_type_Awpi.a())) {
      localArrayList.add(this.jdField_b_of_type_Awpi.a());
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_Awpi.a())) {
      localArrayList.add(this.jdField_a_of_type_Awpi.a());
    }
    return localArrayList;
  }
  
  private void a(awpi paramawpi, Marker paramMarker, boolean paramBoolean)
  {
    paramMarker.setZIndex(paramawpi.a());
    paramMarker.setPosition(paramawpi.a());
    paramMarker.setClickable(false);
    if (paramBoolean) {
      paramMarker.setRotation((float)paramawpi.a());
    }
    paramMarker.refreshInfoWindow();
  }
  
  private boolean a(LatLng paramLatLng)
  {
    LatLng localLatLng = this.jdField_a_of_type_Awpi.a();
    if ((localLatLng == null) || (paramLatLng == null)) {}
    while ((Math.abs(paramLatLng.altitude - localLatLng.altitude) > 5.E-006D) || (Math.abs(paramLatLng.latitude - localLatLng.latitude) > 5.E-006D) || (Math.abs(paramLatLng.longitude - localLatLng.longitude) > 5.E-006D)) {
      return false;
    }
    return true;
  }
  
  private void b(awpi paramawpi)
  {
    Marker localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramawpi.a()));
    if (localMarker != null)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramawpi.a(), localMarker);
      if (!paramawpi.equals(this.jdField_a_of_type_Awpi)) {
        break label99;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840545));
    }
    for (;;)
    {
      localMarker.setTag(paramawpi.a());
      a(paramawpi, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramawpi });
      }
      return;
      label99:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840544));
    }
  }
  
  protected void a(awpi paramawpi)
  {
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(paramawpi.a());
    if (localMarker != null) {
      a(paramawpi, localMarker, true);
    }
    for (;;)
    {
      localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramawpi.a());
      if (localMarker != null) {
        a(paramawpi, localMarker, false);
      }
      return;
      b(paramawpi);
    }
  }
  
  public void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) {}
    while (paramLatLng == null) {
      return;
    }
    awpi localawpi = this.jdField_a_of_type_Awpi;
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(localawpi.a());
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_a_of_type_Azlj.a(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!awtg.a(getContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramLatLng)))
    {
      a(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localawpi.a() });
      }
    }
    this.jdField_a_of_type_Awpi.a(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localawpi);
      label172:
      if ((this.jdField_a_of_type_Awre == null) || (localMarker == null)) {
        break label229;
      }
      if (!paramBoolean) {
        break label231;
      }
    }
    label229:
    label231:
    for (paramLatLng = a();; paramLatLng = null)
    {
      this.jdField_a_of_type_Awre.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      return;
      if (localMarker == null) {
        break label172;
      }
      a(localawpi, localMarker, true);
      break label172;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  protected void a(boolean paramBoolean, Float paramFloat)
  {
    if (this.jdField_a_of_type_Awre != null) {
      this.jdField_a_of_type_Awre.a(true, null);
    }
    awpi localawpi = this.jdField_a_of_type_Awpi;
    Float localFloat;
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localawpi.a() });
      }
      if (!paramBoolean) {
        break label116;
      }
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localawpi.a(), localFloat.floatValue())));
    }
    for (;;)
    {
      a(localawpi);
      return;
      label116:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localawpi.a(), localFloat.floatValue())));
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    awtg.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap);
    this.jdField_a_of_type_Azle.a();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Azle.b(this.jdField_a_of_type_Azlh);
    this.jdField_a_of_type_Azlj.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Azlh == null) {
      this.jdField_a_of_type_Azlh = new awrd(this);
    }
    this.jdField_a_of_type_Azle.a(this.jdField_a_of_type_Azlh);
    try
    {
      this.jdField_a_of_type_Azle.a(60000L, true, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnlineStatusMapWidget", 1, "onResume: failed. ", localThrowable);
    }
  }
  
  public void setListener(awre paramawre)
  {
    this.jdField_a_of_type_Awre = paramawre;
    if (this.jdField_a_of_type_Awre != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_Awre.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    awtg.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationMapWidget
 * JD-Core Version:    0.7.0.1
 */