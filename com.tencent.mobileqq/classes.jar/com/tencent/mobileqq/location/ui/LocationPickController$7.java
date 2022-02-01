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

class LocationPickController$7
  implements MapWidget.EventListener
{
  private long jdField_a_of_type_Long = 0L;
  
  LocationPickController$7(LocationPickController paramLocationPickController, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue) {}
  
  public void a(LatLng paramLatLng)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onMapStable onClick: invoked. center: " + paramLatLng);
    }
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController, paramLatLng);
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).a(LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).getMap(), paramLatLng, "");
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
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).setClickable(false);
      if (QQUIDelegate.b()) {
        LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840756));
      }
    }
    Rect localRect;
    do
    {
      return;
      LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840755));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).setClickable(true);
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840757));
  }
  
  public void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.7
 * JD-Core Version:    0.7.0.1
 */