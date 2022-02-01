package com.tencent.mobileqq.troop.widget;

import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class CylinderProgressView$1
  implements Runnable
{
  CylinderProgressView$1(CylinderProgressView paramCylinderProgressView) {}
  
  public void run()
  {
    QLog.d("CylinderProgressView", 0, "run()  mCurProgress = " + CylinderProgressView.a(this.this$0) + " mDestProgress =" + CylinderProgressView.b(this.this$0));
    if (CylinderProgressView.a(this.this$0) < CylinderProgressView.b(this.this$0))
    {
      CylinderProgressView.a(this.this$0, CylinderProgressView.a(this.this$0) + 1);
      this.this$0.postInvalidate();
      if (CylinderProgressView.a(this.this$0) != null) {
        CylinderProgressView.a(this.this$0).setText(String.valueOf(CylinderProgressView.a(this.this$0)));
      }
      ThreadManager.getUIHandler().postDelayed(this, 15L);
    }
    while (CylinderProgressView.a(this.this$0) <= CylinderProgressView.b(this.this$0)) {
      return;
    }
    CylinderProgressView.a(this.this$0, CylinderProgressView.a(this.this$0) - 1);
    this.this$0.postInvalidate();
    if (CylinderProgressView.a(this.this$0) != null) {
      CylinderProgressView.a(this.this$0).setText(String.valueOf(CylinderProgressView.a(this.this$0)));
    }
    ThreadManager.getUIHandler().postDelayed(this, 15L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.CylinderProgressView.1
 * JD-Core Version:    0.7.0.1
 */