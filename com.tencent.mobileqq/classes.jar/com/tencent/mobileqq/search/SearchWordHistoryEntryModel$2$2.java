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
    ((SearchWordHistoryManager)SearchWordHistoryEntryModel.a(this.b.c).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).d();
    this.a.dismiss();
    SearchWordHistoryEntryModel.b(this.b.c);
    QQAppInterface localQQAppInterface = this.b.b;
    ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_his_del").ver2(UniteSearchReportController.a(this.b.c.i));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{experiment_id:");
    localStringBuilder.append(UniteSearchReportController.b);
    localStringBuilder.append("}");
    UniteSearchReportController.a(localQQAppInterface, localReportModelDC02528.ver7(localStringBuilder.toString()));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.2
 * JD-Core Version:    0.7.0.1
 */