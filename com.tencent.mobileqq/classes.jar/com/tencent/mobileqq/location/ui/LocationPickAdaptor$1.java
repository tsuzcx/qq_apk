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
    int i;
    if ((LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor) != null) && (LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor).size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor, paramList);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.notifyDataSetChanged();
    LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor, TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    if ((LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor).size() > 0) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a(0);
      }
    }
    else if (LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor) != null)
    {
      paramList = LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor);
      if (LocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor).size() > 0) {
        i = 3;
      } else {
        i = 2;
      }
      paramList.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickAdaptor.1
 * JD-Core Version:    0.7.0.1
 */