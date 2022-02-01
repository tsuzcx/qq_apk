package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardBaseOption$7
  implements View.OnClickListener
{
  ForwardBaseOption$7(ForwardBaseOption paramForwardBaseOption, String paramString, ForwardBaseOption.IPicDownloadCallback paramIPicDownloadCallback) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    Parcelable localParcelable = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    if ((localParcelable instanceof MessageForPic)) {
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, (MessageForPic)localParcelable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption$IPicDownloadCallback);
    } else if ((localParcelable instanceof AIOImageData)) {
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, (AIOImageData)localParcelable, this.jdField_a_of_type_JavaLangString);
    } else {
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.7
 * JD-Core Version:    0.7.0.1
 */