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
  protected LocationRoom a;
  protected TencentMap b;
  protected Polyline c;
  protected Map<String, Marker> d = new HashMap(10);
  protected int e = 0;
  private Activity f;
  private View g;
  private LocationRoom.Venue h;
  private MapWidget.EventListener i;
  private CameraPosition j;
  private Marker k;
  private final Map<String, Marker> l = new HashMap(10);
  private volatile boolean m = false;
  private LocationShareLocationManager.LocationChangeListener n;
  private int o = 0;
  
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
  }
  
  public MapWidget(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext.getApplicationContext(), paramTencentMapOptions);
  }
  
  private void a(View paramView)
  {
    if (this.e == 0)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131449060);
      LocationEasterEggBean localLocationEasterEggBean = (LocationEasterEggBean)QConfigManager.b().b(575);
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
    paramMarker.setZIndex(paramLocationItem.e());
    paramMarker.setPosition(paramLocationItem.a());
    paramMarker.setClickable(false);
    if (paramBoolean) {
      paramMarker.setRotation((float)paramLocationItem.b());
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
      Object localObject = this.g;
      int i1;
      if (localObject != null)
      {
        if ((localObject instanceof PoiSlideBottomPanel)) {
          i1 = ((PoiSlideBottomPanel)localObject).getBottomHeight();
        } else {
          i1 = ((View)localObject).getHeight();
        }
      }
      else {
        i1 = 0;
      }
      int i2 = DisplayUtil.a(getContext(), 60.0F);
      int i4 = DisplayUtil.a(getContext(), 102.0F);
      int i5 = LiuHaiUtils.d;
      int i3 = i2 / 2;
      i4 = i4 + i5 + i2 + i3;
      i1 += i3;
      paramList = this.b.calculateZoomToSpanLevel(null, paramList, i2, i2, i4, i1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[map][init]zoomMapToShowAll invoked. mBottomContainer: ");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(" paddingTop: ");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append(" paddingBottom: ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" cameraPosition: ");
        QLog.d("MapWidget", 2, new Object[] { ((StringBuilder)localObject).toString(), paramList });
      }
      if (paramList != null)
      {
        this.b.animateCamera(CameraUpdateFactory.newCameraPosition(paramList));
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
    List localList = this.a.j();
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
    LatLng localLatLng = this.a.f().a();
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
    Marker localMarker = this.b.addMarker(new MarkerOptions(paramLocationItem.a()));
    if (localMarker != null)
    {
      this.l.put(paramLocationItem.c(), localMarker);
      if (paramLocationItem.equals(this.a.f())) {
        localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130841398));
      } else {
        localMarker.setIcon(BitmapDescriptorFactory.fromResource(2130841397));
      }
      localMarker.setTag(paramLocationItem.c());
      a(paramLocationItem, localMarker, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][new]onNewLabelMarker invoked. Result LocationItem: ", paramLocationItem });
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.a.i().iterator();
    while (localIterator.hasNext()) {
      a((LocationItem)localIterator.next());
    }
  }
  
  private void e()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((View)localObject).getHeight() == 0))
    {
      localObject = this.g.getViewTreeObserver();
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new MapWidget.5(this, (ViewTreeObserver)localObject));
      return;
    }
    a(this.c.getPoints());
  }
  
  private void f()
  {
    a(this.a.g());
  }
  
  private void g()
  {
    a(this.d);
  }
  
  private List<String> getLoadAvatarList()
  {
    ArrayList localArrayList = new ArrayList(30);
    Iterator localIterator = this.a.i().iterator();
    while (localIterator.hasNext())
    {
      LocationItem localLocationItem = (LocationItem)localIterator.next();
      if (!this.d.containsKey(localLocationItem.c())) {
        localArrayList.add(localLocationItem.c());
      }
    }
    return localArrayList;
  }
  
  private void h()
  {
    a(this.l);
  }
  
  private void i()
  {
    LocationRoom.Venue localVenue = this.a.a();
    if (localVenue != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[map][venue]resetVenue invoked. venue: ");
        localStringBuilder.append(localVenue);
        localStringBuilder.append(" mVenueMarker: ");
        localStringBuilder.append(this.k);
        QLog.d("MapWidget", 2, localStringBuilder.toString());
      }
      if (this.k != null) {
        this.a.a().a = new SoftReference(this.k);
      } else {
        this.a.a().a = null;
      }
      this.a.a(localVenue);
    }
  }
  
  public Integer a(int paramInt)
  {
    c(false);
    Object localObject2 = this.a;
    Object localObject1 = null;
    if ((localObject2 != null) && (((LocationRoom)localObject2).f() != null) && (this.a.a() != null))
    {
      LatLng localLatLng1 = this.a.f().a();
      LatLng localLatLng2 = this.a.a().e;
      if ((localLatLng1 != null) && (localLatLng2 != null))
      {
        int i1 = paramInt;
        if (paramInt == 0) {
          if (MapUtils.a(localLatLng1, localLatLng2) < 2000.0D) {
            i1 = 3;
          } else {
            i1 = 1;
          }
        }
        localObject2 = new MapWidget.RouteDetail();
        ((MapWidget.RouteDetail)localObject2).a = Integer.valueOf(i1);
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3) {
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
        this.a.a(i1);
        if (localObject1 != null)
        {
          localObject1 = ((RoutePlanningParam)localObject1).from(localLatLng1).to(localLatLng2);
          new TencentSearch(getContext()).getRoutePlan((RoutePlanningParam)localObject1, new MapWidget.4(this, i1, (MapWidget.RouteDetail)localObject2));
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error RoutePlanningParam: null");
          }
          localObject1 = this.i;
          if (localObject1 != null) {
            ((MapWidget.EventListener)localObject1).a(false, (MapWidget.RouteDetail)localObject2);
          }
        }
        return Integer.valueOf(i1);
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
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("MapWidget", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  protected void a() {}
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom, CameraPosition paramCameraPosition, int paramInt, View paramView)
  {
    this.a = paramLocationRoom;
    this.f = paramActivity;
    this.g = paramView;
    this.b = getMap();
    this.b.getUiSettings().setRotateGesturesEnabled(false);
    this.b.getUiSettings().setLogoPositionWithMargin(3, paramInt, 0, DisplayUtil.a(BaseApplication.getContext(), 10.0F), 0);
    this.b.getUiSettings().setScaleViewPositionWithMargin(0, 0, DisplayUtil.a(BaseApplication.getContext(), 17.0F), DisplayUtil.a(BaseApplication.getContext(), 62.0F), 0);
    paramActivity = paramCameraPosition;
    if (paramCameraPosition == null) {
      paramActivity = this.a.k();
    }
    this.j = paramActivity;
    if ((this.j == null) || (QLog.isColorLevel())) {}
    try
    {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]init: invoked. ", " camera position cached: ", this.j });
      label151:
      this.b.moveCamera(CameraUpdateFactory.newCameraPosition(this.j));
      break label258;
      paramActivity = TencentLocationManager.getInstance(getContext()).getLastKnownLocation();
      if (paramActivity != null)
      {
        paramActivity = new LatLng(paramActivity.getLatitude(), paramActivity.getLongitude());
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][init]init: invoked. ", " location last known: ", paramActivity });
        }
        paramLocationRoom = this.b;
        paramLocationRoom.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramActivity, paramLocationRoom.getCameraPosition().zoom)));
      }
      label258:
      setTag(-2147483648, Boolean.valueOf(true));
      if (this.e == 0)
      {
        this.b.setOnMapLoadedCallback(new MapWidget.1(this));
        this.b.addTencentMapGestureListener(new MapWidget.2(this));
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
    Marker localMarker = (Marker)this.l.get(paramLocationItem.c());
    if (localMarker != null) {
      a(paramLocationItem, localMarker, true);
    } else {
      b(paramLocationItem);
    }
    localMarker = (Marker)this.d.get(paramLocationItem.c());
    if (localMarker != null) {
      a(paramLocationItem, localMarker, false);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if (!this.b.isDestroyed())
    {
      if (this.f.isFinishing()) {
        return;
      }
      Object localObject = this.a;
      if ((localObject != null) && (((LocationRoom)localObject).a(paramRoomKey)))
      {
        d();
        if (this.a.d())
        {
          if (QLog.isColorLevel())
          {
            paramRoomKey = this.b.getCameraPosition();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[map][location]onUpdateUserLocations invoked. target: ");
            ((StringBuilder)localObject).append(paramRoomKey.target);
            ((StringBuilder)localObject).append(" zoom: ");
            ((StringBuilder)localObject).append(paramRoomKey.zoom);
            QLog.d("MapWidget", 2, ((StringBuilder)localObject).toString());
          }
          b();
          paramRoomKey = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
          if (this.a.j().contains(paramRoomKey)) {
            this.a.a(false);
          }
        }
        if (!this.m) {
          return;
        }
        paramRoomKey = this.a.a();
        if (this.i != null) {
          if ((this.h == null) && (paramRoomKey != null))
          {
            if (this.a.b() == -1) {
              this.i.a(paramRoomKey);
            }
          }
          else if ((this.h != null) && (paramRoomKey == null))
          {
            this.i.a(null);
            a(true, Float.valueOf(15.0F));
          }
          else
          {
            localObject = this.h;
            if ((localObject != null) && (paramRoomKey != null) && (!((LocationRoom.Venue)localObject).equals(paramRoomKey)) && (this.a.b() == -1)) {
              this.i.a(paramRoomKey);
            }
          }
        }
        this.h = paramRoomKey;
      }
    }
  }
  
  protected void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    if (this.b.isDestroyed()) {
      return;
    }
    if (paramLatLng != null)
    {
      LocationItem localLocationItem = this.a.f();
      Marker localMarker = (Marker)this.l.get(localLocationItem.c());
      if ((this.j == null) && (localMarker == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", paramLatLng });
        }
        this.a.a(true);
      }
      Boolean localBoolean = (Boolean)getTag(-2147483648);
      Object localObject = null;
      if ((localBoolean != null) && (!MapUtils.a(getContext(), this.b, paramLatLng)))
      {
        a(false);
        setTag(-2147483648, null);
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", localLocationItem.a() });
        }
      }
      this.a.a(paramLatLng, paramDouble);
      if (paramBoolean) {
        a(localLocationItem);
      } else if (localMarker != null) {
        a(localLocationItem, localMarker, true);
      }
      if ((this.i != null) && (localMarker != null))
      {
        paramLatLng = localObject;
        if (paramBoolean) {
          paramLatLng = getLoadAvatarList();
        }
        this.i.a(localMarker.getPosition(), localMarker.getRotation(), paramLatLng);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][location]updateSelfLocation invoked. update self LocationItem: ", localLocationItem });
      }
    }
  }
  
  public void a(LatLng paramLatLng, boolean paramBoolean)
  {
    if (!this.b.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][marker]moveMapToLocation invoked. location: ", paramLatLng });
      }
      paramLatLng = CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(paramLatLng, this.b.getCameraPosition().zoom));
      if (paramBoolean)
      {
        this.b.animateCamera(paramLatLng);
        return;
      }
      this.b.moveCamera(paramLatLng);
    }
  }
  
  public void a(String paramString)
  {
    LocationDialogUtil.a(this.f, paramString, "我的位置", this.a.a().c, this.a.f().a(), this.a.a().e);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((!this.b.isDestroyed()) && (QBaseActivity.sTopActivity == this.f))
    {
      Object localObject1 = this.a;
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
          localObject2 = inflate(getContext(), 2131625264, null);
          a((View)localObject2);
          ((ImageView)((View)localObject2).findViewById(2131437691)).setImageBitmap(paramBitmap);
          paramBitmap = (Marker)this.d.get(paramString);
          if (paramBitmap != null)
          {
            paramBitmap.setIcon(BitmapDescriptorFactory.fromView((View)localObject2));
          }
          else
          {
            paramBitmap = this.b.addMarker(new MarkerOptions(((LocationItem)localObject1).a()).anchor(0.5F, 1.1F).icon(BitmapDescriptorFactory.fromView((View)localObject2)));
            paramBitmap.setTag(paramString);
          }
          a((LocationItem)localObject1, paramBitmap, false);
          this.d.put(paramString, paramBitmap);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    LocationItem localLocationItem = this.a.a(paramString);
    if (localLocationItem == null) {
      return;
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((MapWidget.EventListener)localObject).a(paramString.equals(this.a.f().c()), null);
    }
    localLocationItem.a(this.a.c());
    if (!this.b.isDestroyed())
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
        this.b.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), this.b.getCameraPosition().zoom)));
      } else {
        this.b.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), this.b.getCameraPosition().zoom)));
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
    Object localObject = this.i;
    if (localObject != null) {
      ((MapWidget.EventListener)localObject).a(true, null);
    }
    LocationItem localLocationItem = this.a.f();
    localLocationItem.a(this.a.c());
    if (!this.b.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]moveMapToSelfCenter invoked. location: ", localLocationItem.a() });
      }
      if (paramBoolean)
      {
        localObject = paramFloat;
        if (paramFloat == null) {
          localObject = Float.valueOf(this.b.getCameraPosition().zoom);
        }
        this.b.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), ((Float)localObject).floatValue())));
      }
      else
      {
        localObject = paramFloat;
        if (paramFloat == null) {
          localObject = Float.valueOf(15.0F);
        }
        this.b.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), ((Float)localObject).floatValue())));
      }
    }
    a(localLocationItem);
  }
  
  protected void b()
  {
    a(this.a.h());
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
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
    Polyline localPolyline = this.c;
    if (localPolyline != null)
    {
      localPolyline.remove();
      this.c = null;
    }
    if (paramBoolean) {
      this.a.a(-1);
    }
  }
  
  public CameraPosition getLastCameraPosition()
  {
    return this.b.getCameraPosition();
  }
  
  LatLng getSelfLatlng()
  {
    return this.a.f().a();
  }
  
  public LocationRoom.Venue getVenue()
  {
    return this.a.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.f = null;
    MapUtils.a(this.b);
  }
  
  public void onPause()
  {
    super.onPause();
    LocationShareLocationManager.a().b(this.n);
    this.a.a(this.b.getCameraPosition());
    if (this.c == null) {
      this.a.a(-1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.n == null) {
      this.n = new MapWidget.6(this);
    }
    LocationShareLocationManager.a().a(this.n);
    try
    {
      LocationShareLocationManager.a().a(this.f, this.a);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MapWidget", 1, "onResume: failed. ", localThrowable);
    }
    this.a.a(new MapWidget.7(this));
    i();
    if (this.a.b() != -1) {
      a(this.a.b());
    }
  }
  
  public void setListener(MapWidget.EventListener paramEventListener)
  {
    this.i = paramEventListener;
    if (this.i != null)
    {
      boolean bool = a(this.b.getCameraPosition().target);
      this.i.a(bool, null);
    }
  }
  
  public void setMapLogoVisibility(int paramInt)
  {
    MapUtils.a(this.b, paramInt);
  }
  
  public void setVenue(LocationRoom.Venue paramVenue)
  {
    this.a.a(paramVenue);
    getViewTreeObserver().addOnGlobalLayoutListener(new MapWidget.3(this, paramVenue));
  }
  
  public void setVenueOprating(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget
 * JD-Core Version:    0.7.0.1
 */