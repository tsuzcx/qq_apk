package com.tencent.mobileqq.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;

class LocationDialogUtil$9$1
  implements DialogInterface.OnClickListener
{
  LocationDialogUtil$9$1(LocationDialogUtil.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = LocationHandler.a();
    paramDialogInterface.d(new LocationRoom.RoomKey(this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString));
    paramDialogInterface.b(true);
    paramDialogInterface.a(this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString);
    LocationShareFragment.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.9.1
 * JD-Core Version:    0.7.0.1
 */