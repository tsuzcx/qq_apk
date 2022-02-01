package com.tencent.mobileqq.filemanageraux.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class TencentDocConvertABTestUtil$1
  implements View.OnClickListener
{
  TencentDocConvertABTestUtil$1(QQAppInterface paramQQAppInterface, String paramString, TencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable, TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem paramTencentDocEditConvertConfigItem) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxUtilTencentDocConvertABTestUtil$DocClickTypeRunnable.a(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocEditConvertConfigBean$TencentDocEditConvertConfigItem.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.util.TencentDocConvertABTestUtil.1
 * JD-Core Version:    0.7.0.1
 */