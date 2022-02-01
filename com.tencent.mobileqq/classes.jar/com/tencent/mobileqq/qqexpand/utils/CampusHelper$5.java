package com.tencent.mobileqq.qqexpand.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.statistics.ReportController;

final class CampusHelper$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    IExpandHandler localIExpandHandler = this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler;
    if (localIExpandHandler != null) {
      localIExpandHandler.a(this.jdField_a_of_type_ComTencentPbProfilecardEditExtendFriendInfo$SchoolInfo);
    }
    ReportController.b(null, "dc00898", "", "", "0X800ADA8", "0X800ADA8", 1, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.CampusHelper.5
 * JD-Core Version:    0.7.0.1
 */