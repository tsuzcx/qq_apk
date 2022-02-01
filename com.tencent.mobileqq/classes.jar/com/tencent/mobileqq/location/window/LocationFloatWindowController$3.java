package com.tencent.mobileqq.location.window;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget.EventListener;
import com.tencent.mobileqq.location.ui.MapWidget.RouteDetail;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class LocationFloatWindowController$3
  implements MapWidget.EventListener
{
  LocationFloatWindowController$3(LocationFloatWindowController paramLocationFloatWindowController) {}
  
  public void a(LocationRoom.Venue paramVenue) {}
  
  public void a(LatLng paramLatLng) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.a.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = BaseImageUtil.c(localBitmap, 16, 16);
          LocationFloatWindowController.a(this.a).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint) {}
  
  public void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.LocationFloatWindowController.3
 * JD-Core Version:    0.7.0.1
 */