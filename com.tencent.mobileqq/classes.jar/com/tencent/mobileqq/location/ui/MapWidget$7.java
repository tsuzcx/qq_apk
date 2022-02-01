package com.tencent.mobileqq.location.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.location.config.LocationEasterEggBean;
import com.tencent.mobileqq.location.data.LocationRoom.OnNewLocationListener;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import java.lang.ref.SoftReference;
import java.util.Map;

class MapWidget$7
  implements LocationRoom.OnNewLocationListener
{
  MapWidget$7(MapWidget paramMapWidget) {}
  
  public void a()
  {
    if (this.a.c != null) {
      this.a.c.remove();
    }
    if (MapWidget.a(this.a) != null) {
      MapWidget.a(this.a).a(null);
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    Object localObject = (LocationEasterEggBean)QConfigManager.b().b(575);
    if (localObject != null) {
      localObject = ((LocationEasterEggBean)localObject).a();
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.a.b.addMarker(new MarkerOptions(paramVenue.e).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromResource(2130841431)));
    }
    else
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      ((URLDrawable)localObject).downloadImediatly();
      localObject = BaseImageUtil.b((Drawable)localObject);
      localObject = this.a.b.addMarker(new MarkerOptions(paramVenue.e).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromBitmap((Bitmap)localObject)));
    }
    if (localObject != null)
    {
      paramVenue.a = new SoftReference(localObject);
      MapWidget.a(this.a, (Marker)localObject);
      ((Marker)localObject).setClickable(false);
      ((Marker)localObject).refreshInfoWindow();
    }
    if (MapWidget.a(this.a) != null) {
      MapWidget.a(this.a).a(paramVenue);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][venue]onNewVenue invoked. Result venue: ", paramVenue });
    }
  }
  
  public void a(String paramString)
  {
    Marker localMarker = (Marker)MapWidget.d(this.a).get(paramString);
    if (localMarker != null)
    {
      localMarker.remove();
      MapWidget.d(this.a).remove(paramString);
    }
    localMarker = (Marker)this.a.d.get(paramString);
    if (localMarker != null)
    {
      localMarker.remove();
      this.a.d.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.7
 * JD-Core Version:    0.7.0.1
 */