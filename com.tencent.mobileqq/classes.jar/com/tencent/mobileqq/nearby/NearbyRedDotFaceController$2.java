package com.tencent.mobileqq.nearby;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NearbyRedDotFaceController$2
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("run, mCurIndex=");
        ((StringBuilder)localObject1).append(this.this$0.d);
        QLog.d("NearbyRedDotFaceController", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.this$0.c.size() == 0) {
        return;
      }
      if (this.this$0.d >= this.this$0.c.size()) {
        this.this$0.d = 0;
      }
      this.this$0.a((String)this.this$0.c.get(this.this$0.d));
      Object localObject1 = this.this$0;
      ((NearbyRedDotFaceController)localObject1).d += 1;
      if (this.this$0.c.size() > 1) {
        this.this$0.a.postDelayed(this, 3000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRedDotFaceController.2
 * JD-Core Version:    0.7.0.1
 */