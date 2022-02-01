package com.tencent.mobileqq.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.widget.PopupWindowWithMask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchWordHistoryEntryModel$2$2
  implements View.OnClickListener
{
  SearchWordHistoryEntryModel$2$2(SearchWordHistoryEntryModel.2 param2, PopupWindowWithMask paramPopupWindowWithMask) {}
  
  public void onClick(View paramView)
  {
    ((SearchWordHistoryManager)SearchWordHistoryEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchWordHistoryEntryModel$2.jdField_a_of_type_ComTencentMobileqqSearchSearchWordHistoryEntryModel).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPopupWindowWithMask.dismiss();
    SearchWordHistoryEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchWordHistoryEntryModel$2.jdField_a_of_type_ComTencentMobileqqSearchSearchWordHistoryEntryModel);
    UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchWordHistoryEntryModel$2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_his_del").ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchWordHistoryEntryModel$2.jdField_a_of_type_ComTencentMobileqqSearchSearchWordHistoryEntryModel.b)).ver7("{experiment_id:" + UniteSearchReportController.b + "}"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.2
 * JD-Core Version:    0.7.0.1
 */