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
    LocationPickController.a(this.b, true);
    LocationPickController.b(this.b).b(paramInt);
    if (this.a.h()) {
      ReportController.b(null, "CliOper", "", "", "0X800A960", "0X800A960", 0, 0, "0", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.2
 * JD-Core Version:    0.7.0.1
 */