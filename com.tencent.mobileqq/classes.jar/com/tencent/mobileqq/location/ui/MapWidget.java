package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.DrivingParam;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.TransitParam;
import com.tencent.lbssearch.object.param.WalkingParam;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.location.config.LocationEasterEggBean;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationHandler.LocationChangeListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
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
import com.tencent.util.LiuHaiUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MapWidget
  extends TextureMapView
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  public LocationRoom a;
  private LocationHandler.LocationChangeListener jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener;
  private MapWidget.EventListener jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener;
  protected TencentMap a;
  private CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  private Marker jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker;
  protected Polyline a;
  protected Map<String, Marker> a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Map<String, Marker> jdField_b_of_type_JavaUtilMap = new HashMap(10);
  
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
      LocationItem localLocationItem = (LocationItem)localIterator.next();
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localLocationItem.a())) {
        localArrayList.add(localLocationItem.a());
      }
    }
    return localArrayList;
  }
  
  private void a(View paramView)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_Int == 0)
    {
      localImageView = (ImageView)paramView.findViewById(2131380882);
      paramView = (LocationEasterEggBean)QConfigManager.a().a(575);
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
      MapUtils.a(localImageView, paramView);
      return;
    }
  }
  
  private void a(LocationItem paramLocationItem, Marker paramMarker, boolean paramBoolean)
  {
    paramMarker.setZIndex(paramLocationItem.a());
    paramMarker.setPosition(paramLocationItem.a());
    paramMarker.setClickable(false);
    if (paramBoolean) {
      paramMarker.setRotation((float)paramLocationItem.a());
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
      int j = DisplayUtil.a(getContext(), 60.0F);
      int k = DisplayUtil.a(getContext(), 102.0F) + LiuHaiUtils.jdField_a_of_type_Int + j + j / 2;
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
  
  private void b(LocationItem paramLocationItem)
  {
    Marker localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramLocationItem.a()));
    if (localMarker != null)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramLocationItem.a(), localMarker);
      if (!paramLocationItem.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())) {
        break label104;
      }
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840750));
    }
    for (;;)
    {
      localMarker.setTag(paramLocationItem.a());
      a(paramLocationItem, localMarker, true);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramLocationItem });
      }
      return;
      label104:
      localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840749));
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.c().iterator();
    while (localIterator.hasNext()) {
      a((LocationItem)localIterator.next());
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getHeight() == 0))
    {
      ViewTreeObserver localViewTreeObserver = this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
      localViewTreeObserver.addOnGlobalLayoutListener(new MapWidget.5(this, localViewTreeObserver));
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
    a(this.jdField_b_of_type_JavaUtilMap);
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
  
  LatLng a()
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
    MapWidget.RouteDetail localRouteDetail;
    if (paramInt == 0)
    {
      if (MapUtils.a(localLatLng1, localLatLng2) < 2000.0D) {
        i = 3;
      }
    }
    else
    {
      localRouteDetail = new MapWidget.RouteDetail();
      localRouteDetail.a = Integer.valueOf(i);
      switch (i)
      {
      default: 
        label220:
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(i);
        if (localObject != null)
        {
          localObject = ((RoutePlanningParam)localObject).from(localLatLng1).to(localLatLng2);
          new TencentSearch(getContext()).getRoutePlan((RoutePlanningParam)localObject, new MapWidget.4(this, i, localRouteDetail));
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
      if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(false, localRouteDetail);
      }
    }
  }
  
  protected void a() {}
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom, CameraPosition paramCameraPosition, int paramInt, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom = paramLocationRoom;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap = getMap();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setRotateGesturesEnabled(false);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setLogoPositionWithMargin(3, paramInt, 0, DisplayUtil.a(BaseApplication.getContext(), 10.0F), 0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getUiSettings().setScaleViewPositionWithMargin(0, 0, DisplayUtil.a(BaseApplication.getContext(), 17.0F), DisplayUtil.a(BaseApplication.getContext(), 62.0F), 0);
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
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.setOnMapLoadedCallback(new MapWidget.1(this));
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addTencentMapGestureListener(new MapWidget.2(this));
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
  
  protected void a(LocationItem paramLocationItem)
  {
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(paramLocationItem.a());
    if (localMarker != null) {
      a(paramLocationItem, localMarker, true);
    }
    for (;;)
    {
      localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramLocationItem.a());
      if (localMarker != null) {
        a(paramLocationItem, localMarker, false);
      }
      return;
      b(paramLocationItem);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (!this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramRoomKey)));
      d();
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())
      {
        if (QLog.isColorLevel())
        {
          paramRoomKey = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition();
          QLog.d("MapWidget", 2, "[map][location]onUpdateUserLocations invoked. target: " + paramRoomKey.target + " zoom: " + paramRoomKey.zoom);
        }
        b();
        paramRoomKey = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.d().contains(paramRoomKey)) {
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(false);
        }
      }
    } while (!this.jdField_a_of_type_Boolean);
    paramRoomKey = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) || (paramRoomKey == null)) {
        break label208;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1) {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(paramRoomKey);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramRoomKey;
      return;
      label208:
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramRoomKey == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(null);
        a(true, Float.valueOf(15.0F));
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramRoomKey != null) && (!this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.equals(paramRoomKey)) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(paramRoomKey);
      }
    }
  }
  
  protected void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) {
      break label10;
    }
    label10:
    while (paramLatLng == null) {
      return;
    }
    LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(localLocationItem.a());
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(true);
    }
    if (((Boolean)getTag(-2147483648) != null) && (!MapUtils.a(getContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramLatLng)))
    {
      a(false);
      setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localLocationItem.a() });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramLatLng, paramDouble);
    if (paramBoolean)
    {
      a(localLocationItem);
      label179:
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null) && (localMarker != null)) {
        if (!paramBoolean) {
          break label265;
        }
      }
    }
    label265:
    for (paramLatLng = a();; paramLatLng = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MapWidget", 2, new Object[] { "[map][location]updateSelfLocation invoked. update self LocationItem: ", localLocationItem });
      return;
      if (localMarker == null) {
        break label179;
      }
      a(localLocationItem, localMarker, true);
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
    LocationDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramString, "我的位置", this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().b, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) || (QBaseActivity.sTopActivity != this.jdField_a_of_type_AndroidAppActivity) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom == null) || (paramBitmap == null)) {}
    LocationItem localLocationItem;
    do
    {
      return;
      localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", "LocationItem = [" + localLocationItem + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
      }
    } while (localLocationItem == null);
    View localView = inflate(getContext(), 2131559441, null);
    a(localView);
    ((ImageView)localView.findViewById(2131370790)).setImageBitmap(paramBitmap);
    paramBitmap = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramBitmap != null) {
      paramBitmap.setIcon(BitmapDescriptorFactory.fromView(localView));
    }
    for (;;)
    {
      a(localLocationItem, paramBitmap, false);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramBitmap);
      return;
      paramBitmap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(localLocationItem.a()).anchor(0.5F, 1.1F).icon(BitmapDescriptorFactory.fromView(localView)));
      paramBitmap.setTag(paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
    if (localLocationItem == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(paramString.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a()), null);
    }
    localLocationItem.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToUserCenter invoked. uin: " + paramString + " location: ", localLocationItem.a() });
      }
      if (!paramBoolean) {
        break label155;
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
    }
    for (;;)
    {
      a(localLocationItem);
      return;
      label155:
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  protected void a(boolean paramBoolean, Float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(true, null);
    }
    LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    localLocationItem.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    Float localFloat;
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localLocationItem.a() });
      }
      if (!paramBoolean) {
        break label132;
      }
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), localFloat.floatValue())));
    }
    for (;;)
    {
      a(localLocationItem);
      return;
      label132:
      localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), localFloat.floatValue())));
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
    MapUtils.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap);
  }
  
  public void onPause()
  {
    super.onPause();
    LocationHandler.a().b(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition());
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(-1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener = new MapWidget.6(this);
    }
    LocationHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener);
    try
    {
      LocationHandler.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom);
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(new MapWidget.7(this));
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
  
  public void setListener(MapWidget.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener = paramEventListener;
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    MapUtils.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramInt);
  }
  
  public void setVenue(LocationRoom.Venue paramVenue)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramVenue);
    getViewTreeObserver().addOnGlobalLayoutListener(new MapWidget.3(this, paramVenue));
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