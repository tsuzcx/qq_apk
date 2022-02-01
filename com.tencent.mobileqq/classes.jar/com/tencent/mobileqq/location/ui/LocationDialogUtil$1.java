package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

final class LocationDialogUtil$1
  implements DialogInterface.OnClickListener
{
  LocationDialogUtil$1(Activity paramActivity, String paramString1, String paramString2, String paramString3, LatLng paramLatLng1, LatLng paramLatLng2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MapUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    ReportController.b(null, "CliOper", "", "", "0X800A970", "0X800A970", 0, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.1
 * JD-Core Version:    0.7.0.1
 */