package com.tencent.mobileqq.location.ui;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class LocationPickController$2
  implements AdapterView.OnItemClickListener
{
  LocationPickController$2(LocationPickController paramLocationPickController, PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController, true);
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.b()) {
      ReportController.b(null, "CliOper", "", "", "0X800A960", "0X800A960", 0, 0, "0", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.2
 * JD-Core Version:    0.7.0.1
 */