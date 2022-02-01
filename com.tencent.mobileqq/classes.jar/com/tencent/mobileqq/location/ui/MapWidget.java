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
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.LocationShareLocationManager.LocationChangeListener;
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
  protected LocationRoom a;
  private LocationShareLocationManager.LocationChangeListener jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener;
  private MapWidget.EventListener jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener;
  protected TencentMap a;
  private CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  private Marker jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker;
  protected Polyline a;
  protected Map<String, Marker> a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private final Map<String, Marker> jdField_b_of_type_JavaUtilMap = new HashMap(10);
  
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
    if (this.jdField_a_of_type_Int == 0)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131380146);
      LocationEasterEggBean localLocationEasterEggBean = (LocationEasterEggBean)QConfigManager.a().a(575);
      paramView = null;
      if (localLocationEasterEggBean != null) {
        paramView = localLocationEasterEggBean.b();
      }
      if (TextUtils.isEmpty(paramView))
      {
        localImageView.setVisibility(8);
        return;
      }
      localImageView.setVisibility(0);
      MapUtils.a(localImageView, paramView);
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
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      int i;
      if (localObject != null)
      {
        if ((localObject instanceof PoiSlideBottomPanel)) {
          i = ((PoiSlideBottomPanel)localObject).a();
        } else {
          i = ((View)localObject).getHeight();
        }
      }
      else {
        i = 0;
      }
      int j = DisplayUtil.a(getContext(), 60.0F);
      int m = DisplayUtil.a(getContext(), 102.0F);
      int n = LiuHaiUtils.jdField_a_of_type_Int;
      int k = j / 2;
      m = m + n + j + k;
      i += k;
      paramList = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.calculateZoomToSpanLevel(null, paramList, j, j, m, i);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[map][init]zoomMapToShowAll invoked. mBottomContainer: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidViewView);
        ((StringBuilder)localObject).append(" paddingTop: ");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" paddingBottom: ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" cameraPosition: ");
        QLog.d("MapWidget", 2, new Object[] { ((StringBuilder)localObject).toString(), paramList });
      }
      if (paramList != null)
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(paramList));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramList.target);
          ((StringBuilder)localObject).append(" zoom: ");
          ((StringBuilder)localObject).append(paramList.zoom);
          QLog.d("MapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. target: ", ((StringBuilder)localObject).toString() });
        }
      }
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localLatLng != null)
    {
      if (paramLatLng == null) {
        return false;
      }
      bool1 = bool2;
      if (Math.abs(paramLatLng.altitude - localLatLng.altitude) <= 5.E-006D)
      {
        bool1 = bool2;
        if (Math.abs(paramLatLng.latitude - localLatLng.latitude) <= 5.E-006D)
        {
          bool1 = bool2;
          if (Math.abs(paramLatLng.longitude - localLatLng.longitude) <= 5.E-006D) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(LocationItem paramLocationItem)
  {
    Marker localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramLocationItem.a()));
    if (localMarker != null)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramLocationItem.a(), localMarker);
      if (paramLocationItem.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())) {
        localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840625));
      } else {
        localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130840624));
      }
      localMarker.setTag(paramLocationItem.a());
      a(paramLocationItem, localMarker, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramLocationItem });
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
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getHeight() == 0))
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new MapWidget.5(this, (ViewTreeObserver)localObject));
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[map][venue]resetVenue invoked. venue: ");
        localStringBuilder.append(localVenue);
        localStringBuilder.append(" mVenueMarker: ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker);
        QLog.d("MapWidget", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker != null) {
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_JavaLangRefSoftReference = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(localVenue);
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
    c(false);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom;
    Object localObject1 = null;
    if ((localObject2 != null) && (((LocationRoom)localObject2).a() != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != null))
    {
      LatLng localLatLng1 = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a();
      LatLng localLatLng2 = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
      if ((localLatLng1 != null) && (localLatLng2 != null))
      {
        int i = paramInt;
        if (paramInt == 0) {
          if (MapUtils.a(localLatLng1, localLatLng2) < 2000.0D) {
            i = 3;
          } else {
            i = 1;
          }
        }
        localObject2 = new MapWidget.RouteDetail();
        ((MapWidget.RouteDetail)localObject2).a = Integer.valueOf(i);
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              localObject1 = new WalkingParam();
            }
          }
          else {
            localObject1 = new TransitParam();
          }
        }
        else {
          localObject1 = new DrivingParam();
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(i);
        if (localObject1 != null)
        {
          localObject1 = ((RoutePlanningParam)localObject1).from(localLatLng1).to(localLatLng2);
          new TencentSearch(getContext()).getRoutePlan((RoutePlanningParam)localObject1, new MapWidget.4(this, i, (MapWidget.RouteDetail)localObject2));
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error RoutePlanningParam: null");
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener;
          if (localObject1 != null) {
            ((MapWidget.EventListener)localObject1).a(false, (MapWidget.RouteDetail)localObject2);
          }
        }
        return Integer.valueOf(i);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[map][venue][route]showRouteToVenue invoked. error locationSelf: ");
        ((StringBuilder)localObject1).append(localLatLng1);
        ((StringBuilder)localObject1).append(" locationVenue: ");
        ((StringBuilder)localObject1).append(localLatLng2);
        QLog.d("MapWidget", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[map][venue][route]showRouteToVenue invoked. error mLocationRoom: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom);
      QLog.d("MapWidget", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
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
      break label258;
      paramActivity = TencentLocationManager.getInstance(getContext()).getLastKnownLocation();
      if (paramActivity != null)
      {
        paramActivity = new LatLng(paramActivity.getLatitude(), paramActivity.getLongitude());
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][init]init: invoked. ", " location last known: ", paramActivity });
        }
        paramLocationRoom = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap;
        paramLocationRoom.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramActivity, paramLocationRoom.getCameraPosition().zoom)));
      }
      label258:
      setTag(-2147483648, Boolean.valueOf(true));
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.setOnMapLoadedCallback(new MapWidget.1(this));
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addTencentMapGestureListener(new MapWidget.2(this));
      }
      return;
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
    } else {
      b(paramLocationItem);
    }
    localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramLocationItem.a());
    if (localMarker != null) {
      a(paramLocationItem, localMarker, false);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom;
      if ((localObject != null) && (((LocationRoom)localObject).a(paramRoomKey)))
      {
        d();
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())
        {
          if (QLog.isColorLevel())
          {
            paramRoomKey = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[map][location]onUpdateUserLocations invoked. target: ");
            ((StringBuilder)localObject).append(paramRoomKey.target);
            ((StringBuilder)localObject).append(" zoom: ");
            ((StringBuilder)localObject).append(paramRoomKey.zoom);
            QLog.d("MapWidget", 2, ((StringBuilder)localObject).toString());
          }
          b();
          paramRoomKey = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
          if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.d().contains(paramRoomKey)) {
            this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(false);
          }
        }
        if (!this.jdField_a_of_type_Boolean) {
          return;
        }
        paramRoomKey = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
        if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue == null) && (paramRoomKey != null))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1) {
              this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(paramRoomKey);
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramRoomKey == null))
          {
            this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(null);
            a(true, Float.valueOf(15.0F));
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
            if ((localObject != null) && (paramRoomKey != null) && (!((LocationRoom.Venue)localObject).equals(paramRoomKey)) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1)) {
              this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(paramRoomKey);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramRoomKey;
      }
    }
  }
  
  protected void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) {
      return;
    }
    if (paramLatLng != null)
    {
      LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      Marker localMarker = (Marker)this.jdField_b_of_type_JavaUtilMap.get(localLocationItem.a());
      if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition == null) && (localMarker == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(true);
      }
      Boolean localBoolean = (Boolean)getTag(-2147483648);
      Object localObject = null;
      if ((localBoolean != null) && (!MapUtils.a(getContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, paramLatLng)))
      {
        a(false);
        setTag(-2147483648, null);
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localLocationItem.a() });
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramLatLng, paramDouble);
      if (paramBoolean) {
        a(localLocationItem);
      } else if (localMarker != null) {
        a(localLocationItem, localMarker, true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener != null) && (localMarker != null))
      {
        paramLatLng = localObject;
        if (paramBoolean) {
          paramLatLng = a();
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][location]updateSelfLocation invoked. update self LocationItem: ", localLocationItem });
      }
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
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(paramLatLng);
        return;
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(paramLatLng);
    }
  }
  
  public void a(String paramString)
  {
    LocationDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramString, "我的位置", this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().b, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) && (QBaseActivity.sTopActivity == this.jdField_a_of_type_AndroidAppActivity))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom;
      if (localObject1 != null)
      {
        if (paramBitmap == null) {
          return;
        }
        localObject1 = ((LocationRoom)localObject1).a(paramString);
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("LocationItem = [");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append("], uin = [");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("], avatar = [");
          ((StringBuilder)localObject2).append(paramBitmap);
          ((StringBuilder)localObject2).append("]");
          QLog.d("MapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", ((StringBuilder)localObject2).toString() });
        }
        if (localObject1 != null)
        {
          localObject2 = inflate(getContext(), 2131559315, null);
          a((View)localObject2);
          ((ImageView)((View)localObject2).findViewById(2131370423)).setImageBitmap(paramBitmap);
          paramBitmap = (Marker)this.jdField_a_of_type_JavaUtilMap.get(paramString);
          if (paramBitmap != null)
          {
            paramBitmap.setIcon(BitmapDescriptorFactory.fromView((View)localObject2));
          }
          else
          {
            paramBitmap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(((LocationItem)localObject1).a()).anchor(0.5F, 1.1F).icon(BitmapDescriptorFactory.fromView((View)localObject2)));
            paramBitmap.setTag(paramString);
          }
          a((LocationItem)localObject1, paramBitmap, false);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, paramBitmap);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
    if (localLocationItem == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener;
    if (localObject != null) {
      ((MapWidget.EventListener)localObject).a(paramString.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a()), null);
    }
    localLocationItem.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[map][init]moveMapToUserCenter invoked. uin: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" location: ");
        QLog.d("MapWidget", 2, new Object[] { ((StringBuilder)localObject).toString(), localLocationItem.a() });
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
      } else {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom)));
      }
    }
    a(localLocationItem);
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  protected void a(boolean paramBoolean, Float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener;
    if (localObject != null) {
      ((MapWidget.EventListener)localObject).a(true, null);
    }
    LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    localLocationItem.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localLocationItem.a() });
      }
      if (paramBoolean)
      {
        localObject = paramFloat;
        if (paramFloat == null) {
          localObject = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
        }
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), ((Float)localObject).floatValue())));
      }
      else
      {
        localObject = paramFloat;
        if (paramFloat == null) {
          localObject = Float.valueOf(15.0F);
        }
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), ((Float)localObject).floatValue())));
      }
    }
    a(localLocationItem);
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
    Polyline localPolyline = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline;
    if (localPolyline != null)
    {
      localPolyline.remove();
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
    LocationShareLocationManager.a().b(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition());
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(-1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener = new MapWidget.6(this);
    }
    LocationShareLocationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener);
    try
    {
      LocationShareLocationManager.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MapWidget", 1, "onResume: failed. ", localThrowable);
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(new MapWidget.7(this));
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != -1) {
      a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget
 * JD-Core Version:    0.7.0.1
 */