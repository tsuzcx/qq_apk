package com.tencent.mobileqq.location.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class LocationShareController$3
  implements MapWidget.EventListener
{
  LocationShareController$3(LocationShareController paramLocationShareController) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      this.a.c();
      return;
    }
    LocationShareController.a(this.a);
  }
  
  public void a(LatLng paramLatLng) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramLatLng = paramList.iterator();
    while (paramLatLng.hasNext())
    {
      paramList = (String)paramLatLng.next();
      Bitmap localBitmap = LocationAvatarHelper.a().a(paramList);
      if (localBitmap != null)
      {
        localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        this.a.a.a(paramList, localBitmap);
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      LocationShareController.a(this.a).b.setValue(Boolean.valueOf(true));
      return;
    }
    if (paramPoint != null)
    {
      Rect localRect = new Rect();
      LocationShareController.a(this.a).getGlobalVisibleRect(localRect);
      if (localRect.contains(paramPoint.x, paramPoint.y)) {
        return;
      }
    }
    LocationShareController.a(this.a).b.setValue(Boolean.valueOf(false));
  }
  
  public void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail)
  {
    LocationShareController.a(this.a, paramBoolean, paramRouteDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.3
 * JD-Core Version:    0.7.0.1
 */