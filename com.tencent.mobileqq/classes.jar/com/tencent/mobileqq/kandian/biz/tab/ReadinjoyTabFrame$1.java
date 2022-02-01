package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import mqq.app.AppRuntime;

class ReadinjoyTabFrame$1
  implements View.OnClickListener
{
  ReadinjoyTabFrame$1(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a).setText("");
    ReadinjoyTabFrame.a(this.a).setVisibility(8);
    ReadinjoyReportUtils.a(this.a.a(), true);
    ((KandianMergeManager)this.a.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).d(true);
    RIJMsgBoxUtils.a(this.a.a(), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.1
 * JD-Core Version:    0.7.0.1
 */