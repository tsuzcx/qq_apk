package com.tencent.mobileqq.filemanageraux.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.DocClickTypeRunnable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class TencentDocConvertABTestUtil$2
  implements View.OnClickListener
{
  TencentDocConvertABTestUtil$2(AppInterface paramAppInterface, String paramString, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable, TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem paramTencentDocEditConvertConfigItem) {}
  
  public void onClick(View paramView)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      ReportController.b(localAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITencentDocConvertABTestUtil$DocClickTypeRunnable.a(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocEditConvertConfigBean$TencentDocEditConvertConfigItem.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.util.TencentDocConvertABTestUtil.2
 * JD-Core Version:    0.7.0.1
 */