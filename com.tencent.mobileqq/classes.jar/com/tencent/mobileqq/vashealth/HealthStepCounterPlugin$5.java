package com.tencent.mobileqq.vashealth;

import amtj;
import bgma;
import bgve;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.widget.QQToast;

public class HealthStepCounterPlugin$5
  implements Runnable
{
  public HealthStepCounterPlugin$5(bgma parambgma) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.this$0.mRuntime.a().getContext());
    QQToast.a(this.this$0.mRuntime.a().getContext(), amtj.a(2131704583), 0).b((int)(localQQToast.b() * 2.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.5
 * JD-Core Version:    0.7.0.1
 */