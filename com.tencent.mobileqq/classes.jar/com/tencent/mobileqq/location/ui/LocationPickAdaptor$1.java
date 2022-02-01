package com.tencent.mobileqq.location.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import java.util.List;

class LocationPickAdaptor$1
  implements LocationPoiDataFromMapHelper.OnPoiListUpdateListener
{
  LocationPickAdaptor$1(LocationPickAdaptor paramLocationPickAdaptor, String paramString) {}
  
  public void a(List<LocationRoom.Venue> paramList)
  {
    if ((LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor) != null) && (LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor).size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor, paramList);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.notifyDataSetChanged();
      LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor, TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
      if ((LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor).size() > 0) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        if (i == 0) {
          this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a(0);
        }
      }
      while (LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor) == null) {
        return;
      }
      paramList = LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor);
      if (LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor).size() > 0) {}
      for (i = 3;; i = 2)
      {
        paramList.a(i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickAdaptor.1
 * JD-Core Version:    0.7.0.1
 */