package com.tencent.mobileqq.filemanageraux.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.DocClickTypeRunnable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class TencentDocConvertABTestUtil$1
  implements View.OnClickListener
{
  TencentDocConvertABTestUtil$1(AppInterface paramAppInterface, String paramString, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable, TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem paramTencentDocEditConvertConfigItem) {}
  
  public void onClick(View paramView)
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface != null)
    {
      String str = this.b;
      ReportController.b(localAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
    this.c.a(this.d.i());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.util.TencentDocConvertABTestUtil.1
 * JD-Core Version:    0.7.0.1
 */