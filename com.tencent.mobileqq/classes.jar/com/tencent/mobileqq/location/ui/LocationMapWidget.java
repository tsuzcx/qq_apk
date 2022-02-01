package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import awir;
import awkm;
import awkn;
import awmp;
import azey;
import azfb;
import azfd;
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
  awir jdField_a_of_type_Awir;
  private awkn jdField_a_of_type_Awkn;
  private azey jdField_a_of_type_Azey;
  private azfb jdField_a_of_type_Azfb;
  azfd jdField_a_of_type_Azfd;
  protected TencentMap a;
  private CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  protected Map<String, Marker> a;
  awir jdField_b_of_type_Awir;
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
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_b_of_type_Awir.a())) {
      localArrayList.add(this.jdField_b_of_type_Awir.a());
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_Awir.a())) {
      localArrayList.add(this.jdField_a_of_type_Awir.a());
    }
    return localArrayList;
  }
  
  private void a(awir paramawir, Marker paramMarker, boolean paramBoolean)
  {
    paramMarker.setZIndex(paramawir.a());
    paramMarker.setPosition(paramawir.a());
    paramMarker.setClickable(false);
    if (paramBoolean) {
      paramMarker.setRotation((float)paramawir.a());
    }
    paramMarker.refreshInfoWindow();
  }
  
  private boolean a(LatLng paramLatLng)
  {
    LatLng localLatLng = this.jdField_a_of_type_Awir.a();
    if ((localLatLng == null) || (paramLatLng == null)) {}
    while ((Math.abs(paramLatLng.altitude - localLatLng.altitude) > 5.E-006D) || (Math.abs(paramLatLng.latitude - localLatLng.latitude) > 5.E-006D) || (Math.abs(paramLatLng.longitude - localLatLng.longitude) > 5.E-006D)) {
      return false;
    }
    return true;
  }
  
  private void b(awir paramawir)
  {
    Marker localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramawir.a()));
    if (localMarker != null)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramawir.a(), localMarker);
      if (!paramawir.equals(this.jdField_a_of_type_Awir)) {
        break label99;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840619));
    }
    for (;;)
    {
      localMarker.setTag(paramawir.a());
      a(paramawir, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramawir });
      }
      return;
      label99:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840618));
    }
  }
  
  protected void a(awir paramawir)
  {
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(paramawir.a());
    if (localMarker != null) {
      a(paramawir, localMarker, true);
    }
    for (;;)
    {
      localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramawir.a());
      if (localMarker != null) {
        a(paramawir, localMarker, false);
      }
      return;
      b(paramawir);
    }
  }
  
  public void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) {}
    while (paramLatLng == null) {
      return;
    }
    awir localawir = this.jdField_a_of_type_Awir;
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(localawir.a());
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_a_of_type_Azfd.a(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!awmp.a(getContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramLatLng)))
    {
      a(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localawir.a() });
      }
    }
    this.jdField_a_of_type_Awir.a(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localawir);
      label172:
      if ((this.jdField_a_of_type_Awkn == null) || (localMarker == null)) {
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
      this.jdField_a_of_type_Awkn.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      return;
      if (localMarker == null) {
        break label172;
      }
      a(localawir, localMarker, true);
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
    if (this.jdField_a_of_type_Awkn != null) {
      this.jdField_a_of_type_Awkn.a(true, null);
    }
    awir localawir = this.jdField_a_of_type_Awir;
    Float localFloat;
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localawir.a() });
      }
      if (!paramBoolean) {
        break label116;
      }
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localawir.a(), localFloat.floatValue())));
    }
    for (;;)
    {
      a(localawir);
      return;
      label116:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localawir.a(), localFloat.floatValue())));
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    awmp.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap);
    this.jdField_a_of_type_Azey.a();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Azey.b(this.jdField_a_of_type_Azfb);
    this.jdField_a_of_type_Azfd.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Azfb == null) {
      this.jdField_a_of_type_Azfb = new awkm(this);
    }
    this.jdField_a_of_type_Azey.a(this.jdField_a_of_type_Azfb);
    try
    {
      this.jdField_a_of_type_Azey.a(60000L, true, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnlineStatusMapWidget", 1, "onResume: failed. ", localThrowable);
    }
  }
  
  public void setListener(awkn paramawkn)
  {
    this.jdField_a_of_type_Awkn = paramawkn;
    if (this.jdField_a_of_type_Awkn != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_Awkn.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    awmp.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationMapWidget
 * JD-Core Version:    0.7.0.1
 */