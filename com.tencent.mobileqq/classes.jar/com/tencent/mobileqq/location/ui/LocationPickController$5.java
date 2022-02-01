package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class LocationPickController$5
  implements MapWidget.EventListener
{
  private long c = 0L;
  
  LocationPickController$5(LocationPickController paramLocationPickController, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue) {}
  
  public void a(LatLng paramLatLng)
  {
    if (System.currentTimeMillis() - this.c < 1000L) {
      return;
    }
    this.c = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMapStable onClick: invoked. center: ");
      localStringBuilder.append(paramLatLng);
      QLog.d("LocationShareController", 2, localStringBuilder.toString());
    }
    LocationPickController.a(this.b, paramLatLng);
    LocationPickController.b(this.b).a(LocationPickController.c(this.b).getMap(), paramLatLng, "");
    ReportController.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = LocationAvatarHelper.a().a(paramList);
        if (localBitmap != null)
        {
          localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          LocationPickController.c(this.b).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      LocationPickController.e(this.b).setClickable(false);
      if (QQUIDelegate.c())
      {
        LocationPickController.e(this.b).setImageDrawable(this.a.getResources().getDrawable(2130841404));
        return;
      }
      LocationPickController.e(this.b).setImageDrawable(this.a.getResources().getDrawable(2130841403));
      return;
    }
    if (paramPoint != null)
    {
      Rect localRect = new Rect();
      LocationPickController.e(this.b).getGlobalVisibleRect(localRect);
      if (localRect.contains(paramPoint.x, paramPoint.y)) {
        return;
      }
    }
    LocationPickController.e(this.b).setClickable(true);
    LocationPickController.e(this.b).setImageDrawable(this.a.getResources().getDrawable(2130841405));
  }
  
  public void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.5
 * JD-Core Version:    0.7.0.1
 */