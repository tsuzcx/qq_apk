package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.SDKInitCallback;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$5$1
  implements ViolaAccessHelper.SDKInitCallback
{
  ViolaBaseView$5$1(ViolaBaseView.5 param5, long paramLong) {}
  
  public void a()
  {
    if (ViolaBaseView.h(this.b.this$0) != null) {
      ViolaBaseView.h(this.b.this$0).b();
    }
    ViolaBaseView.a(this.b.this$0, 1);
    QLog.e("ViolaBaseView", 2, "ThreadManager 执行 onViolaSDKError");
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaBaseView", 2, "ThreadManager 执行 onViolaSDKSucc");
    }
    if (ViolaBaseView.h(this.b.this$0) != null) {
      ViolaBaseView.h(this.b.this$0).a();
    }
    if (paramLong != 0L)
    {
      ViolaBaseView.a(this.b.this$0).addReportData(ViolaEnvironment.TIME_SDK_MAIN, Long.toString(paramLong));
      ViolaBaseView.a(this.b.this$0).addReportData(ViolaEnvironment.TIME_SDK_INIT, Long.toString(System.currentTimeMillis() - this.a));
    }
    ViolaBaseView.a(this.b.this$0, true);
    if (ViolaBaseView.i(this.b.this$0) == null) {
      ViolaBaseView.a(this.b.this$0, null);
    }
    ViolaBaseView.j(this.b.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.5.1
 * JD-Core Version:    0.7.0.1
 */