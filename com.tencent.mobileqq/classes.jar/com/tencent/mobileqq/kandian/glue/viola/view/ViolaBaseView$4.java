package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$4
  implements LoadLibCallback
{
  ViolaBaseView$4(ViolaBaseView paramViolaBaseView, int paramInt) {}
  
  public void onError(int paramInt)
  {
    if ((this.a == ViolaBaseView.k()) && (ViolaSoLoaderManager.a.a().e()))
    {
      ViolaBaseView.a(this.b, System.currentTimeMillis());
      ViolaBaseView.e(this.b);
    }
    else
    {
      ViolaBaseView.a(this.b, 100);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSoIfNeed error,code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",isActivityDestroy:");
    localStringBuilder.append(ViolaBaseView.f(this.b));
    QLog.e("ViolaBaseView", 2, localStringBuilder.toString());
  }
  
  public void onFinish(int paramInt)
  {
    if (paramInt == ReadInJoyWebRenderEngine.h)
    {
      ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_EXIT);
    }
    else if (this.a == ViolaBaseView.k())
    {
      ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_NET);
      ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.b(this.b)));
    }
    else
    {
      ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_OFFLINE);
      ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.b(this.b)));
    }
    ViolaBaseView.c(this.b);
    ViolaBaseView.d(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.4
 * JD-Core Version:    0.7.0.1
 */