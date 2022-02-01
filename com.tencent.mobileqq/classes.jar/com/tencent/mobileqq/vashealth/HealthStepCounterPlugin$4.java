package com.tencent.mobileqq.vashealth;

import amtj;
import bgma;
import bgve;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.widget.QQToast;

public class HealthStepCounterPlugin$4
  implements Runnable
{
  public HealthStepCounterPlugin$4(bgma parambgma) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.this$0.mRuntime.a().getContext());
    QQToast.a(this.this$0.mRuntime.a().getContext(), amtj.a(2131704586), 0).b((int)(localQQToast.b() * 2.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.4
 * JD-Core Version:    0.7.0.1
 */