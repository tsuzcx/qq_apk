package com.tencent.mobileqq.troop.troopcard;

import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class CylinderProgressView$1
  implements Runnable
{
  CylinderProgressView$1(CylinderProgressView paramCylinderProgressView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("run()  mCurProgress = ");
    ((StringBuilder)localObject).append(CylinderProgressView.a(this.this$0));
    ((StringBuilder)localObject).append(" mDestProgress =");
    ((StringBuilder)localObject).append(CylinderProgressView.b(this.this$0));
    QLog.d("CylinderProgressView", 2, ((StringBuilder)localObject).toString());
    if (CylinderProgressView.a(this.this$0) < CylinderProgressView.b(this.this$0))
    {
      localObject = this.this$0;
      CylinderProgressView.a((CylinderProgressView)localObject, CylinderProgressView.a((CylinderProgressView)localObject) + 1);
      this.this$0.postInvalidate();
      if (CylinderProgressView.a(this.this$0) != null) {
        CylinderProgressView.a(this.this$0).setText(String.valueOf(CylinderProgressView.a(this.this$0)));
      }
      ThreadManager.getUIHandler().postDelayed(this, 15L);
      return;
    }
    if (CylinderProgressView.a(this.this$0) > CylinderProgressView.b(this.this$0))
    {
      localObject = this.this$0;
      CylinderProgressView.a((CylinderProgressView)localObject, CylinderProgressView.a((CylinderProgressView)localObject) - 1);
      this.this$0.postInvalidate();
      if (CylinderProgressView.a(this.this$0) != null) {
        CylinderProgressView.a(this.this$0).setText(String.valueOf(CylinderProgressView.a(this.this$0)));
      }
      ThreadManager.getUIHandler().postDelayed(this, 15L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.CylinderProgressView.1
 * JD-Core Version:    0.7.0.1
 */