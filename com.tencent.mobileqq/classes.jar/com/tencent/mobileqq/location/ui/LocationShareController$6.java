package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class LocationShareController$6
  implements MapWidget.EventListener
{
  LocationShareController$6(LocationShareController paramLocationShareController, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController);
      return;
    }
    LocationShareController.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController);
  }
  
  public void a(LatLng paramLatLng) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setClickable(false);
      if (QQUIDelegate.b()) {
        LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840756));
      }
    }
    Rect localRect;
    do
    {
      return;
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840755));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setClickable(true);
    LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840757));
  }
  
  public void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail)
  {
    LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController, paramBoolean, paramRouteDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.6
 * JD-Core Version:    0.7.0.1
 */