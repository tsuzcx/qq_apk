package com.tencent.mobileqq.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class LocationDialogUtil$5$1
  implements DialogInterface.OnClickListener
{
  LocationDialogUtil$5$1(LocationDialogUtil.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "onClick: invoked. showStartShareLocationDialog  ", " which: ", Integer.valueOf(paramInt) });
    }
    LocationShareFragment.a(BaseApplication.getContext(), this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    try
    {
      LocationHandler.a().b(true);
      label67:
      LocationDialogUtil.a(this.a.b, "0X800A769");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.5.1
 * JD-Core Version:    0.7.0.1
 */