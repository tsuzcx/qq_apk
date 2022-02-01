package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector;
import com.tencent.mobileqq.utils.ProcessUtil;
import java.util.List;
import mqq.app.MobileQQ;

class AutoStatusManager$3
  implements Runnable
{
  AutoStatusManager$3(AutoStatusManager paramAutoStatusManager) {}
  
  public void run()
  {
    if (!ProcessUtil.a(MobileQQ.sMobileQQ))
    {
      this.this$0.d("schedule");
      return;
    }
    this.this$0.b.b();
    if ((Constant.U == null) || (Constant.U.size() == 0)) {
      AutoStatusManager.b(this.this$0);
    }
    if ((Constant.S == null) || (Constant.S.isEmpty())) {
      AutoStatusManager.c(this.this$0);
    }
    if ((Constant.U != null) && (Constant.U.size() > 0) && (Constant.S != null) && (!Constant.S.isEmpty())) {
      AutoStatusManager.d(this.this$0);
    }
    AutoStatusManager.e(this.this$0).postDelayed(this, Constant.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.3
 * JD-Core Version:    0.7.0.1
 */