package com.tencent.mobileqq.location.window;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class FloatMapWidget
  extends MapWidget
{
  private LocationRoom.Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private TencentMap.OnMapLoadedCallback jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback;
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private Marker jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker;
  private Double jdField_a_of_type_JavaLangDouble;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private LocationRoom.Venue jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private final Map<String, View> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  public FloatMapWidget(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FloatMapWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatMapWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 1;
  }
  
  @NotNull
  private View a(String paramString)
  {
    View localView2 = (View)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = inflate(getContext(), 2131559120, null);
      this.jdField_b_of_type_JavaUtilMap.put(paramString, localView1);
    }
    return localView1;
  }
  
  private Marker a(LocationItem paramLocationItem, View paramView)
  {
    String str = paramLocationItem.a();
    Marker localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localMarker == null)
    {
      localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramLocationItem.a()).icon(BitmapDescriptorFactory.fromView(paramView)));
      paramView = localMarker;
      if (QLog.isColorLevel())
      {
        QLog.d("FloatMapWidget", 2, new Object[] { "findHeadMarker: invoked. ", " headMarker: ", localMarker, "isDestroyed: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) });
        paramView = localMarker;
      }
    }
    else
    {
      localMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
      paramView = localMarker;
    }
    paramView.setTag(str);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramView);
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 4, new Object[] { "dev: findHeadMarker: invoked. ", " item: ", paramLocationItem });
    }
    return paramView;
  }
  
  private void a(LocationItem paramLocationItem, View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131366975);
    if (paramLocationItem.a().equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a())) {
      paramView.setBackgroundResource(2130840619);
    } else {
      paramView.setBackgroundResource(2130840620);
    }
    paramView.setRotation((float)(paramLocationItem.a() + 315.0D));
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "drawMapRoute: invoked. ", " routeType: ", Integer.valueOf(i) });
    }
    c(false);
    if (i != -1) {
      a(i);
    }
  }
  
  private void e()
  {
    View localView = inflate(getContext(), 2131559121, null);
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "drawMapVenue: invoked. ", " venue: ", localVenue, " mLastDrawVenue: ", this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue });
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = localVenue;
    Marker localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker;
    if (localMarker != null) {
      localMarker.remove();
    }
    if (localVenue != null)
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromView(localView)));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker.refreshInfoWindow();
    }
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramRoomKey)))
    {
      paramRoomKey = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "onUpdateUserLocations: invoked. ", " currentVenue: ", paramRoomKey, " mLastDrawVenue: ", this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue });
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramRoomKey == null)) {
        a(paramRoomKey);
      }
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramRoomKey;
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())
      {
        if (QLog.isColorLevel())
        {
          paramRoomKey = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition();
          if (paramRoomKey != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[map][location]onUpdateUserLocations invoked.  zoom: ");
            localStringBuilder.append(paramRoomKey.zoom);
            QLog.d("FloatMapWidget", 2, localStringBuilder.toString());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(false);
        e();
        if (this.jdField_a_of_type_Boolean) {
          b();
        }
      }
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue == null) {
      c(true);
    }
  }
  
  protected void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    paramBoolean = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed();
    QLog.isColorLevel();
    if (paramBoolean) {
      return;
    }
    if (paramLatLng != null)
    {
      if ((paramLatLng.equals(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng)) && (paramDouble != null) && (Math.abs(paramDouble.doubleValue() - this.jdField_a_of_type_JavaLangDouble.doubleValue()) < 5.0D))
      {
        QLog.isColorLevel();
        return;
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
      this.jdField_a_of_type_JavaLangDouble = paramDouble;
      LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramLatLng, paramDouble);
      paramLatLng = a(localLocationItem.a());
      a(localLocationItem, paramLatLng);
      a(localLocationItem, paramLatLng).refreshInfoWindow();
      QLog.isColorLevel();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "updateUserHead: invoked. ", " mapDestroyed: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      return;
    }
    LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
    int i = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.d().size();
    if (this.jdField_b_of_type_Int != i)
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.clear();
      d();
      this.jdField_b_of_type_Int = i;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LocationItem = [");
      ((StringBuilder)localObject).append(localLocationItem);
      ((StringBuilder)localObject).append("], uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], avatar = [");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append("]");
      QLog.d("FloatMapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", ((StringBuilder)localObject).toString() });
    }
    if (localLocationItem != null)
    {
      localObject = a(paramString);
      ((RoundImageView)((View)localObject).findViewById(2131366976)).setImageBitmap(paramBitmap);
      a(localLocationItem, (View)localObject);
      paramBitmap = a(localLocationItem, (View)localObject);
      if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FloatMapWidget", 2, new Object[] { "updateUserHead: invoked. no need refresh self. ", " uin: ", paramString });
        }
      }
      else
      {
        paramString = localLocationItem.a();
        if (paramString != null)
        {
          paramBitmap.setZIndex(localLocationItem.a());
          paramBitmap.setPosition(paramString);
        }
      }
      paramBitmap.refreshInfoWindow();
    }
  }
  
  protected void a(boolean paramBoolean, Float paramFloat)
  {
    LocationItem localLocationItem = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    localLocationItem.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "[float][map][init]moveMapToSelfCenter invoked. location: ", localLocationItem.a() });
      }
      if (paramBoolean)
      {
        localFloat = paramFloat;
        if (paramFloat == null) {
          localFloat = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
        }
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), localFloat.floatValue())));
        return;
      }
      Float localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), localFloat.floatValue())));
    }
  }
  
  protected void b()
  {
    int i = DisplayUtil.a(getContext(), 16.0F);
    List localList = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b();
    Object localObject1 = localList;
    Object localObject2;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != -1)
      {
        localObject1 = new ArrayList();
        try
        {
          if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng != null) {
            ((List)localObject1).add(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != null) {
            ((List)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          }
        }
        catch (Throwable localThrowable1) {}
      }
    }
    catch (Throwable localThrowable2)
    {
      localObject1 = localThrowable1;
      localObject2 = localThrowable2;
      QLog.e("FloatMapWidget", 1, "zoomMapToShowAll: failed. ", (Throwable)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. ", " mPolyLine: ", this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline });
    }
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != -1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.getPoints();
      if (localObject2 != null) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    else if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != -1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. need wait route draw. ", " latLngs: ", localObject1 });
      }
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.calculateZoomToSpanLevel(null, (List)localObject1, i, i, i, i);
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition((CameraPosition)localObject1));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((CameraPosition)localObject1).target);
        ((StringBuilder)localObject2).append(" zoom: ");
        ((StringBuilder)localObject2).append(((CameraPosition)localObject1).zoom);
        QLog.d("FloatMapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. target: ", ((StringBuilder)localObject2).toString() });
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. check padding", " cameraPosition: ", localObject1 });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    setListener(null);
    LocationShareLocationManager.a().a(null);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback = null;
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = null;
  }
  
  public void setOnMapLoadedCallback()
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback = new FloatMapWidget.1(this);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.setOnMapLoadedCallback(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapWidget
 * JD-Core Version:    0.7.0.1
 */