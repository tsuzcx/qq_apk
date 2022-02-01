package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$6
  implements ViolaBaseView.LoadAsyBack
{
  ViolaBaseView$6(ViolaBaseView paramViolaBaseView, boolean paramBoolean, long paramLong) {}
  
  public void a()
  {
    ViolaBaseView.a(this.c, 5, this.a);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(ViolaBaseView.g(this.c)))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        ViolaBaseView.a(this.c, paramString);
        if (this.a)
        {
          ViolaBaseView.a(this.c).addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_NET);
          ViolaBaseView.a(this.c).addReportData(ViolaEnvironment.TIME_MAIN_JS_NET, Long.toString(System.currentTimeMillis() - this.b));
          ViolaBaseView.k(this.c).sendEmptyMessageDelayed(3, 0L);
        }
        ThreadManager.post(new ViolaBaseView.6.1(this), 8, null, true);
        return;
      }
      ViolaBaseView.a(this.c, 10, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.6
 * JD-Core Version:    0.7.0.1
 */