package com.tencent.mobileqq.qqlive.api.impl.pendant;

import com.tencent.mobileqq.qqlive.utils.ThreadCenter;

class QQLiveModulePendant$4
  implements Runnable
{
  QQLiveModulePendant$4(QQLiveModulePendant paramQQLiveModulePendant) {}
  
  public void run()
  {
    if (QQLiveModulePendant.access$200(this.this$0) == 0L) {
      QQLiveModulePendant.access$202(this.this$0, 60L);
    }
    QQLiveModulePendant.access$600(this.this$0);
    QQLiveModulePendant localQQLiveModulePendant = this.this$0;
    ThreadCenter.a(localQQLiveModulePendant, this, QQLiveModulePendant.access$200(localQQLiveModulePendant) * 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.pendant.QQLiveModulePendant.4
 * JD-Core Version:    0.7.0.1
 */