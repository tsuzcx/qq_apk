package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihForwardAvatar$1
  implements View.OnClickListener
{
  QQCustomDialogWtihForwardAvatar$1(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 1, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihForwardAvatar.hideSoftInputFromWindow();
    ForwardPreviewTroopMemberController localForwardPreviewTroopMemberController = new ForwardPreviewTroopMemberController(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihForwardAvatar);
    localForwardPreviewTroopMemberController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihForwardAvatar.addPreviewView(localForwardPreviewTroopMemberController.b());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009AAD", "0X8009AAD", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.1
 * JD-Core Version:    0.7.0.1
 */