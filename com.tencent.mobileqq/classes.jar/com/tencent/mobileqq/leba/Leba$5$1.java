package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.leba.controller.LebaController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class Leba$5$1
  implements Runnable
{
  Leba$5$1(Leba.5 param5, List paramList) {}
  
  public void run()
  {
    if (this.b.this$0.c != null)
    {
      this.b.this$0.c.clear();
      this.b.this$0.c.addAll(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshLebaConfig. lebaData size=");
      localStringBuilder.append(this.b.this$0.c.size());
      QLog.i("LebaFrame", 1, localStringBuilder.toString());
    }
    if (this.b.this$0.e != null)
    {
      this.b.this$0.e.c();
      if (QLog.isColorLevel()) {
        QLog.i("LebaFrame", 2, "refreshLebaConfig. notifyData.");
      }
      Leba.a(this.b.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.5.1
 * JD-Core Version:    0.7.0.1
 */