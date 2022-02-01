package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import java.util.Map;

class MultiCardFragment$1$2
  implements Runnable
{
  MultiCardFragment$1$2(MultiCardFragment.1 param1, List paramList, Map paramMap1, Map paramMap2) {}
  
  public void run()
  {
    if (MultiCardFragment.a(this.d.this$0) != null) {
      MultiCardFragment.a(this.d.this$0).a(this.a, this.b, this.c);
    }
    if (MultiCardFragment.c(this.d.this$0) != null) {
      MultiCardFragment.c(this.d.this$0).b();
    }
    if ((this.b.size() > 0) && (MultiCardFragment.d(this.d.this$0).a))
    {
      MultiCardFragment.d(this.d.this$0).a = false;
      ReportController.b(null, "dc00898", "", "", "0X800A213", "0X800A213", 0, 0, "", "", "", "");
    }
    MultiCardFragment.e(this.d.this$0);
    if (MultiCardFragment.f(this.d.this$0)) {
      MultiCardFragment.a(this.d.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1.2
 * JD-Core Version:    0.7.0.1
 */