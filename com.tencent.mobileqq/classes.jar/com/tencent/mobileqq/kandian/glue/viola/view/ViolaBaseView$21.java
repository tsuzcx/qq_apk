package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$21
  implements ViolaBaseView.LoadAsyBack
{
  ViolaBaseView$21(ViolaBaseView paramViolaBaseView, boolean paramBoolean, long paramLong) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (this.a) {
      ViolaBaseView.a(this.c).addReportData(ViolaEnvironment.TIME_BIZ_JS_OFFLINE, Long.toString(System.currentTimeMillis() - this.b));
    }
    if (QLog.isColorLevel()) {
      ThreadManager.post(new ViolaBaseView.21.1(this, paramString), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.21
 * JD-Core Version:    0.7.0.1
 */