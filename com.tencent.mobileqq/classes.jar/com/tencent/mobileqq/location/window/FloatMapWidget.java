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
  private final Map<String, View> f = new HashMap();
  private int g;
  private LocationRoom.Venue h;
  private Marker i;
  private LocationRoom.Venue j;
  private TencentMap.OnMapLoadedCallback k;
  private boolean l = false;
  private LatLng m;
  private Double n;
  
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
    this.e = 1;
  }
  
  private void a(LocationItem paramLocationItem, View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131433421);
    if (paramLocationItem.c().equals(this.a.f().c())) {
      paramView.setBackgroundResource(2130841392);
    } else {
      paramView.setBackgroundResource(2130841393);
    }
    paramView.setRotation((float)(paramLocationItem.b() + 315.0D));
  }
  
  @NotNull
  private View b(String paramString)
  {
    View localView2 = (View)this.f.get(paramString);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = inflate(getContext(), 2131624864, null);
      this.f.put(paramString, localView1);
    }
    return localView1;
  }
  
  private Marker b(LocationItem paramLocationItem, View paramView)
  {
    String str = paramLocationItem.c();
    Marker localMarker = (Marker)this.d.get(str);
    if (localMarker == null)
    {
      localMarker = this.b.addMarker(new MarkerOptions(paramLocationItem.a()).icon(BitmapDescriptorFactory.fromView(paramView)));
      paramView = localMarker;
      if (QLog.isColorLevel())
      {
        QLog.d("FloatMapWidget", 2, new Object[] { "findHeadMarker: invoked. ", " headMarker: ", localMarker, "isDestroyed: ", Boolean.valueOf(this.b.isDestroyed()) });
        paramView = localMarker;
      }
    }
    else
    {
      localMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
      paramView = localMarker;
    }
    paramView.setTag(str);
    this.d.put(str, paramView);
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 4, new Object[] { "dev: findHeadMarker: invoked. ", " item: ", paramLocationItem });
    }
    return paramView;
  }
  
  private void d()
  {
    int i1 = this.a.b();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "drawMapRoute: invoked. ", " routeType: ", Integer.valueOf(i1) });
    }
    c(false);
    if (i1 != -1) {
      a(i1);
    }
  }
  
  private void e()
  {
    View localView = inflate(getContext(), 2131624865, null);
    LocationRoom.Venue localVenue = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "drawMapVenue: invoked. ", " venue: ", localVenue, " mLastDrawVenue: ", this.h });
    }
    this.h = localVenue;
    Marker localMarker = this.i;
    if (localMarker != null) {
      localMarker.remove();
    }
    if (localVenue != null)
    {
      this.i = this.b.addMarker(new MarkerOptions(localVenue.e).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromView(localView)));
      this.i.refreshInfoWindow();
    }
  }
  
  protected void a()
  {
    super.a();
    if (this.l) {
      b();
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if ((this.a != null) && (this.a.a(paramRoomKey)))
    {
      paramRoomKey = this.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "onUpdateUserLocations: invoked. ", " currentVenue: ", paramRoomKey, " mLastDrawVenue: ", this.h });
      }
      if ((this.j != null) && (paramRoomKey == null)) {
        a(paramRoomKey);
      }
      this.j = paramRoomKey;
      this.a.a(true);
      if (this.a.d())
      {
        if (QLog.isColorLevel())
        {
          paramRoomKey = this.b.getCameraPosition();
          if (paramRoomKey != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[map][location]onUpdateUserLocations invoked.  zoom: ");
            localStringBuilder.append(paramRoomKey.zoom);
            QLog.d("FloatMapWidget", 2, localStringBuilder.toString());
          }
        }
        this.a.a(false);
        e();
        if (this.l) {
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
    paramBoolean = this.b.isDestroyed();
    QLog.isColorLevel();
    if (paramBoolean) {
      return;
    }
    if (paramLatLng != null)
    {
      if ((paramLatLng.equals(this.m)) && (paramDouble != null) && (Math.abs(paramDouble.doubleValue() - this.n.doubleValue()) < 5.0D))
      {
        QLog.isColorLevel();
        return;
      }
      this.m = paramLatLng;
      this.n = paramDouble;
      LocationItem localLocationItem = this.a.f();
      this.a.a(paramLatLng, paramDouble);
      paramLatLng = b(localLocationItem.c());
      a(localLocationItem, paramLatLng);
      b(localLocationItem, paramLatLng).refreshInfoWindow();
      QLog.isColorLevel();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.b.isDestroyed();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "updateUserHead: invoked. ", " mapDestroyed: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      return;
    }
    LocationItem localLocationItem = this.a.a(paramString);
    int i1 = this.a.j().size();
    if (this.g != i1)
    {
      this.f.clear();
      this.d.clear();
      this.b.clear();
      d();
      this.g = i1;
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
      localObject = b(paramString);
      ((RoundImageView)((View)localObject).findViewById(2131433422)).setImageBitmap(paramBitmap);
      a(localLocationItem, (View)localObject);
      paramBitmap = b(localLocationItem, (View)localObject);
      if (paramString.equals(this.a.f().c()))
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
          paramBitmap.setZIndex(localLocationItem.e());
          paramBitmap.setPosition(paramString);
        }
      }
      paramBitmap.refreshInfoWindow();
    }
  }
  
  protected void a(boolean paramBoolean, Float paramFloat)
  {
    LocationItem localLocationItem = this.a.f();
    localLocationItem.a(this.a.c());
    if (!this.b.isDestroyed())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "[float][map][init]moveMapToSelfCenter invoked. location: ", localLocationItem.a() });
      }
      if (paramBoolean)
      {
        localFloat = paramFloat;
        if (paramFloat == null) {
          localFloat = Float.valueOf(this.b.getCameraPosition().zoom);
        }
        this.b.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), localFloat.floatValue())));
        return;
      }
      Float localFloat = paramFloat;
      if (paramFloat == null) {
        localFloat = Float.valueOf(15.0F);
      }
      this.b.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(localLocationItem.a(), localFloat.floatValue())));
    }
  }
  
  protected void b()
  {
    int i1 = DisplayUtil.a(getContext(), 16.0F);
    List localList = this.a.h();
    Object localObject1 = localList;
    Object localObject2;
    try
    {
      if (this.a.b() != -1)
      {
        localObject1 = new ArrayList();
        try
        {
          if (this.m != null) {
            ((List)localObject1).add(this.m);
          }
          if (this.a.a() != null) {
            ((List)localObject1).add(this.a.a().e);
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
      QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. ", " mPolyLine: ", this.c });
    }
    if ((this.c != null) && (this.a.b() != -1))
    {
      localObject2 = this.c.getPoints();
      if (localObject2 != null) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    else if ((this.c == null) && (this.a.b() != -1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "zoomMapToShowAll: invoked. need wait route draw. ", " latLngs: ", localObject1 });
      }
      return;
    }
    localObject1 = this.b.calculateZoomToSpanLevel(null, (List)localObject1, i1, i1, i1, i1);
    if (localObject1 != null)
    {
      this.b.animateCamera(CameraUpdateFactory.newCameraPosition((CameraPosition)localObject1));
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
    this.k = null;
    this.f.clear();
    this.c = null;
  }
  
  public void setOnMapLoadedCallback()
  {
    this.k = new FloatMapWidget.1(this);
    this.b.setOnMapLoadedCallback(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapWidget
 * JD-Core Version:    0.7.0.1
 */