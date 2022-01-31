package com.tencent.mobileqq.location.window;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import aruk;
import arum;
import arus;
import arzb;
import baxn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
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
  private boolean jdField_a_of_type_Boolean;
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
      localView1 = inflate(getContext(), 2131559064, null);
      this.jdField_b_of_type_JavaUtilMap.put(paramString, localView1);
    }
    return localView1;
  }
  
  private Marker a(aruk paramaruk, View paramView)
  {
    String str = paramaruk.a();
    Marker localMarker = (Marker)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localMarker == null)
    {
      localMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramaruk.a()).icon(BitmapDescriptorFactory.fromView(paramView)));
      paramView = localMarker;
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "findHeadMarker: invoked. ", " headMarker: ", localMarker, "isDestroyed: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed()) });
      }
    }
    for (paramView = localMarker;; paramView = localMarker)
    {
      paramView.setTag(str);
      this.jdField_a_of_type_JavaUtilMap.put(str, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 4, new Object[] { "dev: findHeadMarker: invoked. ", " item: ", paramaruk });
      }
      return paramView;
      localMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
  }
  
  private void a(aruk paramaruk, View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131366379);
    if (paramaruk.a().equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a())) {
      paramView.setBackgroundResource(2130840239);
    }
    for (;;)
    {
      paramView.setRotation((float)(paramaruk.a() + 315.0D));
      return;
      paramView.setBackgroundResource(2130840240);
    }
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
    View localView = inflate(getContext(), 2131559065, null);
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "drawMapVenue: invoked. ", " venue: ", localVenue, " mLastDrawVenue: ", this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue });
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = localVenue;
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker != null) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker.remove();
    }
    if (localVenue != null)
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromView(localView)));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker.refreshInfoWindow();
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void a(arum paramarum)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramarum)))
    {
      paramarum = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "onUpdateUserLocations: invoked. ", " currentVenue: ", paramarum, " mLastDrawVenue: ", this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue });
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (paramarum == null)) {
        a(paramarum);
      }
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramarum;
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a())
      {
        if (QLog.isColorLevel())
        {
          paramarum = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition();
          if (paramarum != null) {
            QLog.d("FloatMapWidget", 2, "[map][location]onUpdateUserLocations invoked.  zoom: " + paramarum.zoom);
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
  
  public void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean)
  {
    paramBoolean = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed();
    if ((!QLog.isColorLevel()) || (paramBoolean)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramLatLng == null);
        if ((!paramLatLng.equals(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng)) || (paramDouble == null) || (Math.abs(paramDouble.doubleValue() - this.jdField_a_of_type_JavaLangDouble.doubleValue()) >= 5.0D)) {
          break;
        }
      } while (!QLog.isColorLevel());
      return;
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
      this.jdField_a_of_type_JavaLangDouble = paramDouble;
      aruk localaruk = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramLatLng, paramDouble);
      paramLatLng = a(localaruk.a());
      a(localaruk, paramLatLng);
      a(localaruk, paramLatLng).refreshInfoWindow();
    } while (!QLog.isColorLevel());
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "updateUserHead: invoked. ", " mapDestroyed: ", Boolean.valueOf(bool) });
    }
    if (bool) {}
    aruk localaruk;
    do
    {
      return;
      localaruk = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a(paramString);
      int i = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.d().size();
      if (this.jdField_b_of_type_Int != i)
      {
        this.jdField_b_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.clear();
        d();
        this.jdField_b_of_type_Int = i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "[map][head]updateUserHead invoked. ", "LocationItem = [" + localaruk + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
      }
    } while (localaruk == null);
    View localView = a(paramString);
    ((RoundImageView)localView.findViewById(2131366380)).setImageBitmap(paramBitmap);
    a(localaruk, localView);
    paramBitmap = a(localaruk, localView);
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().a())) {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "updateUserHead: invoked. no need refresh self. ", " uin: ", paramString });
      }
    }
    for (;;)
    {
      paramBitmap.refreshInfoWindow();
      return;
      paramString = localaruk.a();
      if (paramString != null)
      {
        paramBitmap.setZIndex(localaruk.a());
        paramBitmap.setPosition(paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean, Float paramFloat)
  {
    aruk localaruk = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    localaruk.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b());
    if (!this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "[float][map][init]moveMapToSelfCenter invoked. location: ", localaruk.a() });
      }
      if (paramBoolean)
      {
        localFloat = paramFloat;
        if (paramFloat == null) {
          localFloat = Float.valueOf(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().zoom);
        }
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaruk.a(), localFloat.floatValue())));
      }
    }
    else
    {
      return;
    }
    Float localFloat = paramFloat;
    if (paramFloat == null) {
      localFloat = Float.valueOf(15.0F);
    }
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localaruk.a(), localFloat.floatValue())));
  }
  
  public void b()
  {
    int i = baxn.a(getContext(), 16.0F);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.b();
    label310:
    label353:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1) {
          break label353;
        }
        Object localObject2 = new ArrayList();
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng != null) {
            ((List)localObject2).add(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
          }
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() != null)
          {
            ((List)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a().jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
            localObject1 = localObject2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. ", " mPolyLine: ", this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline });
          }
          if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1)) {
            continue;
          }
          localObject2 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.getPoints();
          if (localObject2 != null) {
            ((List)localObject1).addAll((Collection)localObject2);
          }
          localObject1 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.calculateZoomToSpanLevel(null, (List)localObject1, i, i, i, i);
          if (localObject1 == null) {
            break label310;
          }
          this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newCameraPosition((CameraPosition)localObject1));
          if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, new Object[] { "[map][init]zoomMapToShowAll invoked. target: ", ((CameraPosition)localObject1).target + " zoom: " + ((CameraPosition)localObject1).zoom });
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localThrowable1;
          Object localObject3 = localThrowable2;
          continue;
        }
        localThrowable1 = localThrowable1;
        QLog.e("FloatMapWidget", 1, "zoomMapToShowAll: failed. ", localThrowable1);
        continue;
        if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a() == -1)) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. need wait route draw. ", " latLngs: ", localObject1 });
        return;
      }
      QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. check padding", " cameraPosition: ", localObject1 });
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    setListener(null);
    arus.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(null);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback = null;
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = null;
  }
  
  public void setOnMapLoadedCallback()
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback = new arzb(this);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.setOnMapLoadedCallback(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnMapLoadedCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapWidget
 * JD-Core Version:    0.7.0.1
 */