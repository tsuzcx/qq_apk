package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import avwn;
import avyi;
import avyk;
import avyl;
import avym;
import awao;
import aysl;
import ayso;
import aysp;
import aysq;
import bggq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
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
  avwn jdField_a_of_type_Avwn;
  private avym jdField_a_of_type_Avym;
  private aysl jdField_a_of_type_Aysl;
  private ayso jdField_a_of_type_Ayso;
  aysq jdField_a_of_type_Aysq;
  public TencentMap a;
  private CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  protected Map<String, Marker> a;
  avwn jdField_b_of_type_Avwn;
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
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_b_of_type_Avwn.a())) {
      localArrayList.add(this.jdField_b_of_type_Avwn.a());
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_Avwn.a())) {
      localArrayList.add(this.jdField_a_of_type_Avwn.a());
    }
    return localArrayList;
  }
  
  private void a(avwn paramavwn, Marker paramMarker, boolean paramBoolean)
  {
    paramMarker.setZIndex(paramavwn.a());
    paramMarker.setPosition(paramavwn.a());
    paramMarker.setClickable(false);
    if (paramBoolean) {
      paramMarker.setRotation((float)paramavwn.a());
    }
    paramMarker.refreshInfoWindow();
  }
  
  private boolean a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition.target == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " mLastCameraPosition params error " });
      }
      bool = false;
    }
    do
    {
      return bool;
      if ((this.jdField_b_of_type_Avwn == null) || (this.jdField_b_of_type_Avwn.a() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " mFriendItem params error" });
        }
        return false;
      }
      if ((this.jdField_b_of_type_Avwn.a().latitude != this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition.target.latitude) || (this.jdField_b_of_type_Avwn.a().longitude != this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition.target.longitude)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " params same " });
    return true;
    return false;
  }
  
  private boolean a(LatLng paramLatLng)
  {
    LatLng localLatLng = this.jdField_a_of_type_Avwn.a();
    if ((localLatLng == null) || (paramLatLng == null)) {}
    while ((Math.abs(paramLatLng.altitude - localLatLng.altitude) > 5.E-006D) || (Math.abs(paramLatLng.latitude - localLatLng.latitude) > 5.E-006D) || (Math.abs(paramLatLng.longitude - localLatLng.longitude) > 5.E-006D)) {
      return false;
    }
    return true;
  }
  
  private void b(avwn paramavwn)
  {
    Marker localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramavwn.a()));
    if (localMarker != null)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramavwn.a(), localMarker);
      if (!paramavwn.equals(this.jdField_a_of_type_Avwn)) {
        break label99;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840535));
    }
    for (;;)
    {
      localMarker.setTag(paramavwn.a());
      a(paramavwn, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramavwn });
      }
      return;
      label99:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840534));
    }
  }
  
  public LatLng a()
  {
    return this.jdField_a_of_type_Avwn.a();
  }
  
  public void a(Activity paramActivity, avwn paramavwn1, avwn paramavwn2, aysq paramaysq, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Avwn = paramavwn1;
    this.jdField_b_of_type_Avwn = paramavwn2;
    this.jdField_a_of_type_Aysq = paramaysq;
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap = getMap();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setRotateGesturesEnabled(false);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setLogoPositionWithMargin(3, paramInt, 0, bggq.a(BaseApplicationImpl.context, 10.0F), 0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setScaleViewPositionWithMargin(0, 0, bggq.a(BaseApplicationImpl.context, 109.0F), bggq.a(BaseApplicationImpl.context, 62.0F), 0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramaysq.a();
    if ((!a()) || (QLog.isColorLevel())) {}
    try
    {
      QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " camera position cached: ", this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition });
      label141:
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition));
      label356:
      for (;;)
      {
        setTag(-2147483648, Boolean.valueOf(true));
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.setOnMapLoadedCallback(new avyi(this));
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addTencentMapGestureListener(new avyk(this));
        }
        this.jdField_a_of_type_Aysl = new aysl();
        return;
        paramavwn1 = TencentLocationManager.getInstance(getContext()).getLastKnownLocation();
        paramActivity = null;
        if ((this.jdField_b_of_type_Avwn != null) && (aysp.a(this.jdField_b_of_type_Avwn.a().getLatitude(), this.jdField_b_of_type_Avwn.a().getLongitude()))) {
          paramActivity = this.jdField_b_of_type_Avwn.a();
        }
        for (;;)
        {
          if (paramActivity == null) {
            break label356;
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]init: invoked. ", " location last known: ", paramActivity });
          }
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramActivity, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
          break;
          if (paramavwn1 != null) {
            paramActivity = new LatLng(paramavwn1.getLatitude(), paramavwn1.getLongitude());
          }
        }
      }
    }
    catch (Throwable paramActivity)
    {
      break label141;
    }
  }
  
  protected void a(avwn paramavwn)
  {
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(paramavwn.a());
    if (localMarker != null) {
      a(paramavwn, localMarker, true);
    }
    for (;;)
    {
      localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramavwn.a());
      if (localMarker != null) {
        a(paramavwn, localMarker, false);
      }
      return;
      b(paramavwn);
    }
  }
  
  public void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) {}
    while (paramLatLng == null) {
      return;
    }
    avwn localavwn = this.jdField_a_of_type_Avwn;
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(localavwn.a());
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_a_of_type_Aysq.a(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!awao.a(getContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramLatLng)))
    {
      a(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localavwn.a() });
      }
    }
    this.jdField_a_of_type_Avwn.a(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localavwn);
      label176:
      if ((this.jdField_a_of_type_Avym == null) || (localMarker == null)) {
        break label233;
      }
      if (!paramBoolean) {
        break label235;
      }
    }
    label233:
    label235:
    for (paramLatLng = a();; paramLatLng = null)
    {
      this.jdField_a_of_type_Avym.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      return;
      if (localMarker == null) {
        break label176;
      }
      a(localavwn, localMarker, true);
      break label176;
      break;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) || (BaseActivity.sTopActivity != this.jdField_a_of_type_AndroidAppActivity) || (this.jdField_a_of_type_Avwn == null) || (paramBitmap == null)) {}
    avwn localavwn;
    do
    {
      return;
      if (!this.jdField_a_of_type_Avwn.a().equals(paramString)) {
        break;
      }
      localavwn = this.jdField_a_of_type_Avwn;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", "LocationItem = [" + localavwn + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
      }
    } while (localavwn == null);
    View localView = inflate(getContext(), 2131559323, null);
    ((ImageView)localView.findViewById(2131370256)).setImageBitmap(paramBitmap);
    paramBitmap = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramBitmap != null) {
      paramBitmap.setIcon(BitmapDescriptorFactory.fromView(localView));
    }
    for (;;)
    {
      a(localavwn, paramBitmap, false);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramBitmap);
      return;
      localavwn = this.jdField_b_of_type_Avwn;
      break;
      paramBitmap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(localavwn.a()).anchor(0.5F, 1.1F).icon(BitmapDescriptorFactory.fromView(localView)));
      paramBitmap.setTag(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  protected void a(boolean paramBoolean, Float paramFloat)
  {
    if (this.jdField_a_of_type_Avym != null) {
      this.jdField_a_of_type_Avym.a(true, null);
    }
    avwn localavwn = this.jdField_a_of_type_Avwn;
    Float localFloat;
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusMapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localavwn.a() });
      }
      if (!paramBoolean) {
        break label117;
      }
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localavwn.a(), localFloat.floatValue())));
    }
    for (;;)
    {
      a(localavwn);
      return;
      label117:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localavwn.a(), localFloat.floatValue())));
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    awao.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap);
    this.jdField_a_of_type_Aysl.a();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Aysl.b(this.jdField_a_of_type_Ayso);
    this.jdField_a_of_type_Aysq.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ayso == null) {
      this.jdField_a_of_type_Ayso = new avyl(this);
    }
    this.jdField_a_of_type_Aysl.a(this.jdField_a_of_type_Ayso);
    try
    {
      this.jdField_a_of_type_Aysl.a(60000L, true, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnlineStatusMapWidget", 1, "onResume: failed. ", localThrowable);
    }
  }
  
  public void setListener(avym paramavym)
  {
    this.jdField_a_of_type_Avym = paramavym;
    if (this.jdField_a_of_type_Avym != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_Avym.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    awao.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationMapWidget
 * JD-Core Version:    0.7.0.1
 */