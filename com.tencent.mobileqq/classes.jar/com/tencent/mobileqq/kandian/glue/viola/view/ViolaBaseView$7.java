package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$7
  implements ViolaBaseView.LoadAsyBack
{
  ViolaBaseView$7(ViolaBaseView paramViolaBaseView, boolean paramBoolean, long paramLong) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (this.a) {
      ViolaBaseView.a(this.c).addReportData(ViolaEnvironment.TIME_MAIN_JS_OFFLINE, Long.toString(System.currentTimeMillis() - this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.7
 * JD-Core Version:    0.7.0.1
 */