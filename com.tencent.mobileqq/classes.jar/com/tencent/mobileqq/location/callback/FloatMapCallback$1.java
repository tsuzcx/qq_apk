package com.tencent.mobileqq.location.callback;

import android.app.Dialog;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class FloatMapCallback$1
  implements IWindowClickListener
{
  Dialog jdField_a_of_type_AndroidAppDialog;
  boolean jdField_a_of_type_Boolean = false;
  
  FloatMapCallback$1(FloatMapCallback paramFloatMapCallback, QQAppInterface paramQQAppInterface, LocationRoom.RoomKey paramRoomKey) {}
  
  public boolean a()
  {
    IFloatMapService localIFloatMapService = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {
      localIFloatMapService.showFloatTypeDialog(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidAppDialog = localIFloatMapService.createFloatExitConfirmDialog(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_AndroidAppDialog != null) {
          this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new FloatMapCallback.1.1(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapCallback", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity != null) {
      LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).launchShareUi(localQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), 4);
    }
    FloatMapCallback.d();
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.callback.FloatMapCallback.1
 * JD-Core Version:    0.7.0.1
 */