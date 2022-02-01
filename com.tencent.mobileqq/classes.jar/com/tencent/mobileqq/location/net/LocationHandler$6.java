package com.tencent.mobileqq.location.net;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.qphone.base.util.QLog;

class LocationHandler$6
  implements ReportLocationHandler.OnGetLocationCallback
{
  LocationHandler$6(LocationHandler paramLocationHandler, int paramInt, String paramString) {}
  
  public Pair<Integer, String> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
  
  public LocationItem a()
  {
    if (LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler) == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new LocationItem(LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler).getAccount(), LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler), LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.6
 * JD-Core Version:    0.7.0.1
 */