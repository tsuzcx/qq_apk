package com.tencent.mobileqq.leba.business.mainbiz;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class LebaSearchPart$MyFocusChangeListener
  implements View.OnFocusChangeListener
{
  private WeakReference<QQAppInterface> a;
  private WeakReference<QBaseActivity> b;
  
  LebaSearchPart$MyFocusChangeListener(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramQBaseActivity);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    QBaseActivity localQBaseActivity = (QBaseActivity)this.b.get();
    if ((localQQAppInterface == null) || (localQBaseActivity == null)) {
      QLog.i("LebaQCirclePartImpl", 1, "MyFocusChangeListener onFocusChange app == null || activity == null");
    }
    while (!paramBoolean) {
      return;
    }
    paramView.clearFocus();
    UniteSearchReportController.a(null, 0, 21, "0X8009D15", 0, 0, null, null);
    UniteSearchActivity.a(localQBaseActivity, null, 21, 0L, null, 3);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0x8004B21", "0x8004B21", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaSearchPart.MyFocusChangeListener
 * JD-Core Version:    0.7.0.1
 */