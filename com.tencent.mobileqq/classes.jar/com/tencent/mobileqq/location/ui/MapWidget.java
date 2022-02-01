package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import aqxe;
import arbn;
import awir;
import awit;
import awiz;
import awjf;
import awju;
import awmp;
import awmq;
import awms;
import awmt;
import awmu;
import awmv;
import awmw;
import awmx;
import awmy;
import awmz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.DrivingParam;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.TransitParam;
import com.tencent.lbssearch.object.param.WalkingParam;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.util.DisplayUtil;
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
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapWidget
  extends TextureMapView
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private awjf jdField_a_of_type_Awjf;
  private awmy jdField_a_of_type_Awmy;
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  public LocationRoom a;
  public TencentMap a;
  private CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  private Marker jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker;
  public Polyline a;
  public Map<String, Marker> a;
  private volatile boolean jdField_a_of_type_Boolean;
  private Map<String, Marker> b = new HashMap(10);
  
  public MapWidget(Context paramContext)
  {
    this(paramContext, (TencentMapOptions)null);
  }
  
  public MapWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MapWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext.getApplicationContext(), paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilMap = new HashMap(10);
    this.jdField_a_of_type_Int = 0;
  }
  
  public MapWidget(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext.getApplicationContext(), paramTencentMapOptions);
    this.jdField_a_of_type_JavaUtilMap = new HashMap(10);
    this.jdField_a_of_type_Int = 0;
  }
  
  private List<String> a()
  {
    ArrayList localArrayList = new ArrayList(30);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.c().iterator();
    while (localIterator.hasNext())
    {
      awir localawir = (awir)localIterator.next();
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localawir.a())) {
        localArrayList.add(localawir.a());
      }
    }
    return localArrayList;
  }
  
  private void a(View paramView)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_Int == 0)
    {
      localImageView = (ImageView)paramView.findViewById(2131380439);
      paramView = (arbn)aqxe.a().a(575);
      if (paramView == null) {
        break label64;
      }
    }
    label64:
    for (paramView = paramView.b();; paramView = null)
    {
      if (TextUtils.isEmpty(paramView))
      {
        localImageView.setVisibility(8);
        return;
      }
      localImageView.setVisibility(0);
      awmp.a(localImageView, paramView);
      return;
    }
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
  
  private void a(List<LatLng> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      if ((this.jdField_a_of_type_AndroidViewView instanceof PoiSlideBottomPanel)) {
        i = ((PoiSlideBottomPanel)this.jdField_a_of_type_AndroidViewView).a();
      }
    }
    for (;;)
    {
      int j = DisplayUtil.dip2px(getContext(), 60.0F);
      int k = DisplayUtil.dip2px(getContext(), 102.0F) + LiuHaiUtils.jdField_a_of_type_Int + j + j / 2;
      i += j / 2;
      paramList = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.calculateZoomToSpanLevel(null, paramList, j, j, k, i);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. mBottomContainer: " + this.jdField_a_of_type_AndroidViewView + " paddingTop: " + k + " paddingBottom: " + i + " cameraPosition: ", paramList });
      }
      if (paramList == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(paramList));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. target: ", paramList.target + " zoom: " + paramList.zoom });
      return;
      i = this.jdField_a_of_type_AndroidViewView.getHeight();
      continue;
      i = 0;
    }
  }
  
  private void a(Map<String, Marker> paramMap)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.d();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Marker)((Map.Entry)localObject).getValue();
      if (!localList.contains(str))
      {
        ((Marker)localObject).remove();
        paramMap.remove();
      }
    }
  }
  
  private boolean a(LatLng paramLatLng)
  {
    LatLng localLatLng = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a();
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
      this.b.put(paramawir.a(), localMarker);
      if (!paramawir.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())) {
        break label104;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840619));
    }
    for (;;)
    {
      localMarker.setTag(paramawir.a());
      a(paramawir, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramawir });
      }
      return;
      label104:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840618));
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.c().iterator();
    while (localIterator.hasNext()) {
      a((awir)localIterator.next());
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getHeight() == 0))
    {
      ViewTreeObserver localViewTreeObserver = this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
      localViewTreeObserver.addOnGlobalLayoutListener(new awmv(this, localViewTreeObserver));
      return;
    }
    a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.getPoints());
  }
  
  private void f()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a());
  }
  
  private void g()
  {
    a(this.jdField_a_of_type_JavaUtilMap);
  }
  
  private void h()
  {
    a(this.b);
  }
  
  private void i()
  {
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (localVenue != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, "[map][venue]resetVenue invoked. venue: " + localVenue + " mVenueMarker: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker);
      }
      if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker == null) {
        break label94;
      }
    }
    label94:
    for (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker);; this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_JavaLangRefSoftReference = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(localVenue);
      return;
    }
  }
  
  public LocationRoom.Venue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
  }
  
  public CameraPosition a()
  {
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition();
  }
  
  public LatLng a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a();
  }
  
  public Integer a(int paramInt)
  {
    Object localObject = null;
    c(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error mLocationRoom: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom);
      }
    }
    LatLng localLatLng1;
    LatLng localLatLng2;
    do
    {
      return null;
      localLatLng1 = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a();
      localLatLng2 = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
      if ((localLatLng1 != null) && (localLatLng2 != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error locationSelf: " + localLatLng1 + " locationVenue: " + localLatLng2);
    return null;
    int i = paramInt;
    awmz localawmz;
    if (paramInt == 0)
    {
      if (awmp.a(localLatLng1, localLatLng2) < 2000.0D) {
        i = 3;
      }
    }
    else
    {
      localawmz = new awmz();
      localawmz.a = Integer.valueOf(i);
      switch (i)
      {
      default: 
        label220:
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(i);
        if (localObject != null)
        {
          localObject = ((RoutePlanningParam)localObject).from(localLatLng1).to(localLatLng2);
          new TencentSearch(getContext()).getRoutePlan((RoutePlanningParam)localObject, new awmu(this, i, localawmz));
        }
        break;
      }
    }
    for (;;)
    {
      return Integer.valueOf(i);
      i = 1;
      break;
      localObject = new DrivingParam();
      break label220;
      localObject = new TransitParam();
      break label220;
      localObject = new WalkingParam();
      break label220;
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error RoutePlanningParam: null");
      }
      if (this.jdField_a_of_type_Awmy != null) {
        this.jdField_a_of_type_Awmy.a(false, localawmz);
      }
    }
  }
  
  public void a() {}
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom, CameraPosition paramCameraPosition, int paramInt, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom = paramLocationRoom;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap = getMap();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setRotateGesturesEnabled(false);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setLogoPositionWithMargin(3, paramInt, 0, DisplayUtil.dip2px(BaseApplicationImpl.context, 10.0F), 0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setScaleViewPositionWithMargin(0, 0, DisplayUtil.dip2px(BaseApplicationImpl.context, 17.0F), DisplayUtil.dip2px(BaseApplicationImpl.context, 62.0F), 0);
    paramActivity = paramCameraPosition;
    if (paramCameraPosition == null) {
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    }
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramActivity;
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) || (QLog.isColorLevel())) {}
    try
    {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]init: invoked. ", " camera position cached: ", this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition });
      label151:
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition));
      for (;;)
      {
        setTag(-2147483648, Boolean.valueOf(true));
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.setOnMapLoadedCallback(new awmq(this));
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addTencentMapGestureListener(new awms(this));
        }
        return;
        paramActivity = TencentLocationManager.getInstance(getContext()).getLastKnownLocation();
        if (paramActivity != null)
        {
          paramActivity = new LatLng(paramActivity.getLatitude(), paramActivity.getLongitude());
          if (QLog.isColorLevel()) {
            QLog.d("MapWidget", 2, new Object[] { "[map][init]init: invoked. ", " location last known: ", paramActivity });
          }
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramActivity, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
        }
      }
    }
    catch (Throwable paramActivity)
    {
      break label151;
    }
  }
  
  protected void a(awir paramawir)
  {
    Marker localMarker = (Marker)this.b.get(paramawir.a());
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
  
  public void a(awit paramawit)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (!this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramawit)));
      d();
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())
      {
        if (QLog.isColorLevel())
        {
          paramawit = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition();
          QLog.d("MapWidget", 2, "[map][location]onUpdateUserLocations invoked. target: " + paramawit.target + " zoom: " + paramawit.zoom);
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(false);
        b();
      }
    } while (!this.jdField_a_of_type_Boolean);
    paramawit = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (this.jdField_a_of_type_Awmy != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) || (paramawit == null)) {
        break label181;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1) {
        this.jdField_a_of_type_Awmy.a(paramawit);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramawit;
      return;
      label181:
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramawit == null))
      {
        this.jdField_a_of_type_Awmy.a(null);
        a(true, Float.valueOf(15.0F));
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramawit != null) && (!this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.equals(paramawit)) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1))
      {
        this.jdField_a_of_type_Awmy.a(paramawit);
      }
    }
  }
  
  public void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) {
      break label10;
    }
    label10:
    while (paramLatLng == null) {
      return;
    }
    awir localawir = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    Marker localMarker = (Marker)this.b.get(localawir.a());
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!awmp.a(getContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramLatLng)))
    {
      a(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localawir.a() });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localawir);
      label179:
      if ((this.jdField_a_of_type_Awmy != null) && (localMarker != null)) {
        if (!paramBoolean) {
          break label265;
        }
      }
    }
    label265:
    for (paramLatLng = a();; paramLatLng = null)
    {
      this.jdField_a_of_type_Awmy.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MapWidget", 2, new Object[] { "[map][location]updateSelfLocation invoked. update self LocationItem: ", localawir });
      return;
      if (localMarker == null) {
        break label179;
      }
      a(localawir, localMarker, true);
      break label179;
    }
  }
  
  public void a(LatLng paramLatLng, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][marker]moveMapToLocation invoked. location: ", paramLatLng });
      }
      paramLatLng = CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramLatLng, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom));
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(paramLatLng);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(paramLatLng);
  }
  
  public void a(String paramString)
  {
    awju.a(this.jdField_a_of_type_AndroidAppActivity, paramString, "我的位置", this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().b, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) || (BaseActivity.sTopActivity != this.jdField_a_of_type_AndroidAppActivity) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (paramBitmap == null)) {}
    awir localawir;
    do
    {
      return;
      localawir = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", "LocationItem = [" + localawir + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
      }
    } while (localawir == null);
    View localView = inflate(getContext(), 2131559375, null);
    a(localView);
    ((ImageView)localView.findViewById(2131370506)).setImageBitmap(paramBitmap);
    paramBitmap = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramBitmap != null) {
      paramBitmap.setIcon(BitmapDescriptorFactory.fromView(localView));
    }
    for (;;)
    {
      a(localawir, paramBitmap, false);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramBitmap);
      return;
      paramBitmap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(localawir.a()).anchor(0.5F, 1.1F).icon(BitmapDescriptorFactory.fromView(localView)));
      paramBitmap.setTag(paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    awir localawir = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
    if (localawir == null) {
      return;
    }
    if (this.jdField_a_of_type_Awmy != null) {
      this.jdField_a_of_type_Awmy.a(paramString.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a()), null);
    }
    localawir.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToUserCenter invoked. uin: " + paramString + " location: ", localawir.a() });
      }
      if (!paramBoolean) {
        break label155;
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localawir.a(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
    }
    for (;;)
    {
      a(localawir);
      return;
      label155:
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localawir.a(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public void a(boolean paramBoolean, Float paramFloat)
  {
    if (this.jdField_a_of_type_Awmy != null) {
      this.jdField_a_of_type_Awmy.a(true, null);
    }
    awir localawir = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    localawir.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    Float localFloat;
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localawir.a() });
      }
      if (!paramBoolean) {
        break label132;
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
      label132:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localawir.a(), localFloat.floatValue())));
    }
  }
  
  protected void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b(paramBoolean);
  }
  
  public void c()
  {
    i();
    h();
    g();
    d();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null)
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.remove();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = null;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(-1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidAppActivity = null;
    awmp.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap);
  }
  
  public void onPause()
  {
    super.onPause();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    awiz.a(localQQAppInterface).b(this.jdField_a_of_type_Awjf);
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(localQQAppInterface, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition());
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(-1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Awjf == null) {
      this.jdField_a_of_type_Awjf = new awmw(this);
    }
    awiz.a(localQQAppInterface).a(this.jdField_a_of_type_Awjf);
    try
    {
      awiz.a(localQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom);
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(new awmx(this));
      i();
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != -1) {
        a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MapWidget", 1, "onResume: failed. ", localThrowable);
      }
    }
  }
  
  public void setListener(awmy paramawmy)
  {
    this.jdField_a_of_type_Awmy = paramawmy;
    if (this.jdField_a_of_type_Awmy != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_Awmy.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    awmp.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramInt);
  }
  
  public void setVenue(LocationRoom.Venue paramVenue)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramVenue);
    getViewTreeObserver().addOnGlobalLayoutListener(new awmt(this, paramVenue));
  }
  
  public void setVenueOprating(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget
 * JD-Core Version:    0.7.0.1
 */