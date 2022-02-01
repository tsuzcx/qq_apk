package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import avco;
import avej;
import avek;
import avgm;
import axym;
import axyp;
import axyr;
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
  avco jdField_a_of_type_Avco;
  private avek jdField_a_of_type_Avek;
  private axym jdField_a_of_type_Axym;
  private axyp jdField_a_of_type_Axyp;
  axyr jdField_a_of_type_Axyr;
  protected TencentMap a;
  private CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  protected Map<String, Marker> a;
  avco jdField_b_of_type_Avco;
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
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_b_of_type_Avco.a())) {
      localArrayList.add(this.jdField_b_of_type_Avco.a());
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_Avco.a())) {
      localArrayList.add(this.jdField_a_of_type_Avco.a());
    }
    return localArrayList;
  }
  
  private void a(avco paramavco, Marker paramMarker, boolean paramBoolean)
  {
    paramMarker.setZIndex(paramavco.a());
    paramMarker.setPosition(paramavco.a());
    paramMarker.setClickable(false);
    if (paramBoolean) {
      paramMarker.setRotation((float)paramavco.a());
    }
    paramMarker.refreshInfoWindow();
  }
  
  private boolean a(LatLng paramLatLng)
  {
    LatLng localLatLng = this.jdField_a_of_type_Avco.a();
    if ((localLatLng == null) || (paramLatLng == null)) {}
    while ((Math.abs(paramLatLng.altitude - localLatLng.altitude) > 5.E-006D) || (Math.abs(paramLatLng.latitude - localLatLng.latitude) > 5.E-006D) || (Math.abs(paramLatLng.longitude - localLatLng.longitude) > 5.E-006D)) {
      return false;
    }
    return true;
  }
  
  private void b(avco paramavco)
  {
    Marker localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramavco.a()));
    if (localMarker != null)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramavco.a(), localMarker);
      if (!paramavco.equals(this.jdField_a_of_type_Avco)) {
        break label99;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840580));
    }
    for (;;)
    {
      localMarker.setTag(paramavco.a());
      a(paramavco, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramavco });
      }
      return;
      label99:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840579));
    }
  }
  
  protected void a(avco paramavco)
  {
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(paramavco.a());
    if (localMarker != null) {
      a(paramavco, localMarker, true);
    }
    for (;;)
    {
      localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramavco.a());
      if (localMarker != null) {
        a(paramavco, localMarker, false);
      }
      return;
      b(paramavco);
    }
  }
  
  public void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) {}
    while (paramLatLng == null) {
      return;
    }
    avco localavco = this.jdField_a_of_type_Avco;
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(localavco.a());
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_a_of_type_Axyr.a(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!avgm.a(getContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramLatLng)))
    {
      a(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localavco.a() });
      }
    }
    this.jdField_a_of_type_Avco.a(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localavco);
      label172:
      if ((this.jdField_a_of_type_Avek == null) || (localMarker == null)) {
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
      this.jdField_a_of_type_Avek.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      return;
      if (localMarker == null) {
        break label172;
      }
      a(localavco, localMarker, true);
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
    if (this.jdField_a_of_type_Avek != null) {
      this.jdField_a_of_type_Avek.a(true, null);
    }
    avco localavco = this.jdField_a_of_type_Avco;
    Float localFloat;
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localavco.a() });
      }
      if (!paramBoolean) {
        break label116;
      }
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localavco.a(), localFloat.floatValue())));
    }
    for (;;)
    {
      a(localavco);
      return;
      label116:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localavco.a(), localFloat.floatValue())));
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    avgm.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap);
    this.jdField_a_of_type_Axym.a();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Axym.b(this.jdField_a_of_type_Axyp);
    this.jdField_a_of_type_Axyr.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Axyp == null) {
      this.jdField_a_of_type_Axyp = new avej(this);
    }
    this.jdField_a_of_type_Axym.a(this.jdField_a_of_type_Axyp);
    try
    {
      this.jdField_a_of_type_Axym.a(60000L, true, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnlineStatusMapWidget", 1, "onResume: failed. ", localThrowable);
    }
  }
  
  public void setListener(avek paramavek)
  {
    this.jdField_a_of_type_Avek = paramavek;
    if (this.jdField_a_of_type_Avek != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_Avek.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    avgm.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationMapWidget
 * JD-Core Version:    0.7.0.1
 */